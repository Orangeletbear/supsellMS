package com.cn.control.posmainframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.cn.dao.pos.JDBCInsertData;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCAddXiaoShouInfo;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.posmainJFrame.CheckOut;
import com.cn.view.posmainJFrame.POSFrame;
/**
 * 结账对话框的确定快捷键
 * @author Administrator
 *
 */
public class CheckOut_SureKeyList implements KeyListener {

	 private CheckOut dialog;
	 private POSFrame frame;
	    
	 public CheckOut_SureKeyList(CheckOut dialog){
		 this.dialog = dialog;
		 this.frame = dialog.getFrame();
	 }
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_F5){
			//存放要插入数据库销售总表中的数据
			 Object[] zongBiaoData = new Object[11];
			
	       //单号
			zongBiaoData[0] = frame.getIdField().getText();
			
		    //获取销售日期
			zongBiaoData[1] = DateConventer.dateToStr(Calendar.getInstance().getTime());
			
			//获取导购员名称
			String dgName = frame.getDgBox().getSelectedItem().toString();
			zongBiaoData[2] = JDBC_POS_GetInfo.getdgId(dgName);
			
			//获取仓库名称
			String cangKu = frame.getChangKuBox().getSelectedItem().toString();
			//获取仓库Id
			zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
			
			  //获取会员名称
		     String hyName = "普通用户";
			//获取会员Id
		     if(" ".equals(frame.getHyName().getText())){
		    	 zongBiaoData[4] = JDBC_POS_GetInfo.getczyId(hyName);
		     }else{
		    	 zongBiaoData[4] = frame.getHyName().getText();
		     }
			
			
			//获取应付金额
			zongBiaoData[5] = dialog.getShouldPay().getText();
			
			//获取实付金额
			zongBiaoData[6] =Float.parseFloat(dialog.getGivePay().getText())- 
			                      Float.parseFloat(dialog.getReturnPay().getText());
			 System.out.println(zongBiaoData[6]);
			//获取付款名称
			String fkfs = dialog.getZfWay().getText();
			zongBiaoData[7] = JDBC_POS_GetInfo.getfsId(fkfs);
			 
			//操作员
			String user =frame.getUser();
			zongBiaoData[8] = JDBC_POS_GetInfo.getId(user);

			zongBiaoData[9] = zongBiaoData[8];
	    	//获取备注
			zongBiaoData[10] = dialog.getHyID().getText();
		
			//向销售总表中插入数据
			JDBCInsertData.insertXiaoShouData(zongBiaoData);
			
			
			  /**
			   * 获取待插入销售单详表中的数据
			   * 
			   */
				//存放向数据库中的销售单详表插入的信息
				int row = frame.getMode().getRowCount();
				int column = frame.getMode().getColumnCount();
				
				for(int i = 0;i< row; i++){
					Object[] data = new Object[column];
					//商品号
					data[0] =frame.getMode().getValueAt(i, 1);
					//单号
					data[1] =  zongBiaoData[0];
					//数量
					data[2] = frame.getMode().getValueAt(i, 7).toString();
					//总金额
					data[3] = frame.getMode().getValueAt(i, 8).toString();
					
					//向数据库中插入数据
					JDBCInsertData.insertXiangBiaoData(data);
				}
				
				//更新数据库中的商品库存信息					
				for(int i = 0 ; i < row;i++){
					String spId = frame.getMode().getValueAt(i, 1).toString();
					int shuLiang = Integer.parseInt(frame.getMode().getValueAt(i, 7).toString());
					//先获取该商品原先的库存
					int old = Integer.parseInt(JDBCGetInfo.getKuCun(spId).toString());
					//更新数据库中的商品库存信息
					JDBCAddXiaoShouInfo.updateKuCun(spId, old -shuLiang);
				}
				
				//最后清空表中的数据
		
				frame.getData().removeAllElements();
				frame.getAll().setText("");
				frame.getHyName().setText("h007");
				frame.repaint();
				//改变单号
				String str = null;
				int xd = Integer.parseInt(frame.getIdField().getText().substring(11, 14))+1;
				if(xd < 10){
					str = "000"+xd;
				}else if(xd <100){
					str = "00"+xd;
				}else if(xd<1000){
					str = "0"+xd;
				}else{
					str = ""+xd;
				}
			
				frame.getIdField().setText(frame.getIdField().getText().substring(0,10)+str);
				frame.getAll().setText("0.0");
				frame.setNum(1);
				//提示信息
				 JOptionPane.showMessageDialog(dialog, "成  功   结   账");
				//使删除按钮和修改商品按钮显示可见
			
				//写日志信息
				 Log.traceLog( "  操作员  ",user," 给 "+hyName+" 开了一张pos销售单据："+zongBiaoData[0]);
				 dialog.dispose();
				
		}else if(e.getKeyCode() == KeyEvent.VK_F4){
			dialog.dispose();
		}
	
		}

	
	public void keyReleased(KeyEvent e) {
		

	}

	public void keyTyped(KeyEvent e) {
		

	}

}
