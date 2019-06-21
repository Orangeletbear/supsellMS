package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCAddTuiHuoInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
/**
 * 顾客退货对话框中
 * 的顾客退货选项卡上的确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class GuKeTuiHuoSureAction implements ActionListener {

	
	private GuKeTuiHuoDialog dialog ;
	
	public GuKeTuiHuoSureAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(dialog.getTableModel().getRowCount() == 0){
			JOptionPane.showMessageDialog(dialog,"单据中没有业务发生不能保存");
		}else{
			String message = "单据保存后不能再修改,是否确认保存！";
			int n = JOptionPane.showOptionDialog(dialog, message, "系统信息", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if(n == JOptionPane.YES_OPTION){
				/**
				 * 获取待插入客户退货单总表中的数据
				 */
				 Object[] zongBiaoData = new Object[9];
			      //单据号
				 zongBiaoData[0] = dialog.getDanHaoLabel().getText();
				//获取客户名称
				String khName = dialog.getKeHuText1().getText();
				//获取客户Id
				 zongBiaoData[1] = JDBCGetInfo.getKeHuId(khName);
				//获取收货仓库
				String cangKu = dialog.getCangKuBox().getSelectedItem().toString();
				//获取仓库Id
				zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
				//获取销售日期
				try {
					zongBiaoData[2] = DateConventer.dateToStr(dialog.getDataPicker().getSelectedDate());
					//zongBiaoData[2] = dialog.getDataPicker().getSelectedDate();
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
		       //获取应退金额
				zongBiaoData[4] = dialog.getYingTuiText().getText();
			  //获取实退金额
				zongBiaoData[5] = dialog.getShiTuiText().getText();
			  //获取经办人
				zongBiaoData[6] = dialog.getJingBanBox().getSelectedItem().toString();
				//操作员
				String user = dialog.getMainFrame().getUser();
				zongBiaoData[7] = user;
			  //获取备注信息
				zongBiaoData[8] = dialog.getBeiZhuText().getText();
				
			 //	向数据库中插入数据
				JDBCAddTuiHuoInfo.set_th_zb_Data(zongBiaoData);
				
			  /**
			   * 获取待插入客户退货单详表中的数据
			   * 
			   */	
				//存放向数据库中的顾客退货详表插入的信息
				int row = dialog.getTableModel().getRowCount();
				int column = dialog.getTableModel().getColumnCount();
			
				for(int i = 0;i< row; i++){
					Object[] data = new Object[column];
					data[0] =dialog.getTableModel().getValueAt(i, 0);
					data[1] =  zongBiaoData[0];
					data[2] = dialog.getTableModel().getValueAt(i, 4).toString();
					data[3] = dialog.getTableModel().getValueAt(i, 5).toString();
					
					//向数据库中插入数据
					JDBCAddTuiHuoInfo.set_th_xb_Data(data);
			
				}
				
				//清空表中的数据
				dialog.getTableModel().setDataVector(TuiHuoTabelCulomnModel.obj,
			       TuiHuoTabelCulomnModel.BackColumNames);
				//
				dialog.getShiTuiText().setText("0.0");
				dialog.getYingTuiText().setText("0.0");

				//提示信息
				 JOptionPane.showMessageDialog(dialog, "数据保存成功");
				
				 //	写日志信息
				 Log.traceLog( "  操作员  ",user,"给 "+khName+" 开了一张退货单据："+zongBiaoData[0]);
	
				dialog.getDeleteButton().setVisible(false);
				dialog.getAlterButton().setVisible(false);
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
                dialog.getData().clear();
			}

		}
		
	}

}
