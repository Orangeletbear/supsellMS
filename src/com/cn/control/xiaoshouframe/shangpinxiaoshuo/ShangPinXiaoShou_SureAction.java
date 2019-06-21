package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCAddXiaoShouInfo;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.mainJFrame.MainFrame;
/**
 * 商品销售对话框上的确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class ShangPinXiaoShou_SureAction implements ActionListener {

	private ShangPinXiaoShouDialog dialog;
	
	public ShangPinXiaoShou_SureAction(ShangPinXiaoShouDialog dialog){
		this.dialog = dialog;
	}
	
	/**
	 * 获取界面上的数据，并把它插入数据库
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(dialog.getTableModel().getRowCount() == 0){
			JOptionPane.showMessageDialog(dialog,"单据中没有业务发生不能保存");
		}else{
			String message = "单据保存后不能再修改,是否确认保存！";
			int n = JOptionPane.showOptionDialog(dialog, message, "系统信息", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			  if(n == JOptionPane.YES_OPTION){
				//存放要插入数据库销售总表中的数据
					 Object[] zongBiaoData = new Object[9];
					
			        //单号
					zongBiaoData[0] = dialog.getDanHaoLabel().getText();
					 
				    //获取客户名称
					String khName = dialog.getKeHuText().getText();
					//获取客户Id
					 zongBiaoData[1] = JDBCGetInfo.getKeHuId(khName);
					//获取仓库名称
					String cangKu = dialog.getCangKuBox().getSelectedItem().toString();
					//获取仓库Id
					zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
					//获取销售日期
					try {
						zongBiaoData[2] = DateConventer.dateToStr(dialog.getDataPicker().getSelectedDate());
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					//获取实收金额
					zongBiaoData[5] = dialog.getShiShouText().getText();
					//获取应收金额
					zongBiaoData[4] = dialog.getYingShouText().getText();
					//获取经办人
					zongBiaoData[6] = dialog.getJingBanBox().getSelectedItem();
					
					String user =((MainFrame)dialog.getOwner()).getUser();
					
					//操作员
					zongBiaoData[7] = user;
					//获取备注
					zongBiaoData[8] = dialog.getBeiZhuText().getText();
					
					 //	向数据库中插入数据
					JDBCAddXiaoShouInfo.set_xs_zb_Data(zongBiaoData);
						
				  /**
				   * 获取待插入销售单详表中的数据
				   * 
				   */
					//存放向数据库中的销售单详表插入的信息
					int row = dialog.getTableModel().getRowCount();
					int column = dialog.getTableModel().getColumnCount();
					
					for(int i = 0;i< row; i++){
						Object[] data = new Object[column];
						//商品号
						data[0] =dialog.getTableModel().getValueAt(i, 0);
						//单号
						data[1] =  zongBiaoData[0];
						//数量
						data[2] = dialog.getTableModel().getValueAt(i, 8).toString();
						//总金额
						data[3] = dialog.getTableModel().getValueAt(i, 9).toString();
						
						//向数据库中插入数据
						JDBCAddXiaoShouInfo.set_xs_xb_Data(data);
					}
					
					//更新数据库中的商品库存信息					
					for(int i = 0 ; i < row;i++){
						String spId = dialog.getTableModel().getValueAt(i, 0).toString();
						int shuLiang = Integer.parseInt(dialog.getTableModel().getValueAt(i, 8).toString());
						//先获取该商品原先的库存
						int old = Integer.parseInt(JDBCGetInfo.getKuCun(spId).toString());
						//更新数据库中的商品库存信息
						JDBCAddXiaoShouInfo.updateKuCun(spId, old -shuLiang);
					}
					
					//最后清空表中的数据
					dialog.getTableModel().setDataVector(XiaoShouCulomnModel.obj,
							XiaoShouCulomnModel.columnNames);
					dialog.getShiShouText().setText("0.0");
					dialog.getYingShouText().setText("0.0");
					//改变单号
					String str = null;
					int xd = Integer.parseInt(dialog.getDanHaoLabel().getText().substring(11, 14))+1;
					if(xd < 10){
						str = "000"+xd;
					}else if(xd <100){
						str = "00"+xd;
					}else if(xd<1000){
						str = "0"+xd;
					}else{
						str = ""+xd;
					}
				
					dialog.getDanHaoLabel().setText(dialog.getDanHaoLabel().getText().substring(0,10)+str);
					
					//提示信息
					 JOptionPane.showMessageDialog(dialog, "数据保存成功");
					//使删除按钮和修改商品按钮显示可见
					dialog.getDeleteButton().setVisible(false);
					dialog.getAlterButton().setVisible(false);
					//写日志信息
					 Log.traceLog( "  操作员  ",user," 给 "+khName+" 开了一张销售单据："+zongBiaoData[0]);
			    	
					 dialog.getData().clear();
				}

			}
			
		}
			  
}


