package com.cn.control.posmainframe;
/**
 * POS退货对话框上对应的键盘监听器
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.pos.JDBCInsertData;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.util.DateConventer;
import com.cn.view.posmainJFrame.ChangeNumber;
import com.cn.view.posmainJFrame.POSTuiHuoDialog;

public class POSTuiHuoKeyListener implements KeyListener {

	private POSTuiHuoDialog dialog;
	
	public POSTuiHuoKeyListener(POSTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource().equals(dialog.getXsIS()) &&e.getKeyCode() == 10){
			String danHao = dialog.getXsIS().getText();
			
			ArrayList<String > dh = JDBC_POS_GetInfo.get_pos_xs_id();
			int i = 0;
			for( ;i<dh.size();i++){
				if(danHao.equals(dh.get(i))){
					Vector data = JDBC_POS_GetInfo.getxs_Info(danHao);
					dialog.getXsDate().setText(data.get(0).toString());
					dialog.getHyID().setText(data.get(1).toString());
					dialog.getSptm().requestFocus();
					break;
				}
			}
			if(i == dh.size()){
				JOptionPane.showMessageDialog(dialog, "该销售单不存在，请核查后重录",
						"系统提示", JOptionPane.WARNING_MESSAGE,null);
			}
		}else if(e.getSource().equals(dialog.getSptm()) &&e.getKeyCode() == 10){
			String danHao = dialog.getXsIS().getText();
			System.out.println(danHao);
			
			String spId = dialog.getSptm().getText();
			//System.out.println(spId);
			ArrayList<String > spIds = JDBC_POS_GetInfo.get_pos_sp_id(danHao);
			int i = 0;
			//System.out.println(spIds.size());
			
			for( ;i<spIds.size();i++){
				if(spId.equals(spIds.get(i))){
					
					Vector data = dialog.getData();
					data.add(JDBC_POS_GetInfo.get_pos_sp_info(dialog.getCount(), spId));
					//System.out.println(data);
					dialog.getDefaultModel().setDataVector(data,
							AllTableModel.getVectorFromObj(POSTableModel.SPCulomns));
					dialog.setCount(dialog.getCount()+1);
					
					dialog.getSpTable().setRowSelectionInterval(
							dialog.getData().size()-1, dialog.getData().size()-1);
					break;
				}
			}
			if(i == spIds.size()){
				JOptionPane.showMessageDialog(dialog, "当前销售单中没有该商品的销售记录，不能退货!",
						"系统提示", JOptionPane.WARNING_MESSAGE,null);
			}
			int row = dialog.getSpTable().getRowCount();
			int column = dialog.getDefaultModel().getColumnCount();
			
			float money = 0f;
			float number = 0f;
			for(int t = 0;t< row;t++){
				//System.out.println(dialog.getDefaultModel().getValueAt(t, 8).toString());
				money = money+ new Float(dialog.getDefaultModel().getValueAt(t, 8).toString());
				//System.out.println(dialog.getDefaultModel().getValueAt(t, 7).toString());
				
				number = number +new Float(dialog.getDefaultModel().getValueAt(t, 7).toString());
			}
		
			dialog.getSum().setText(String.valueOf(money));
			dialog.getNumber().setText(String.valueOf(number));
			
		}else if(e.getKeyCode() == KeyEvent.VK_F3){
			
			int row = dialog.getSpTable().getSelectedRow();
			if(row ==-1){
				return;
			}
			float m = new Float(dialog.getDefaultModel().getValueAt(row, 8).toString());
			float s = new Float(dialog.getDefaultModel().getValueAt(row, 7).toString());
			dialog.getDefaultModel().removeRow(row);
			dialog.getSum().setText(String.valueOf(new Float(dialog.getSum().getText()) - m));
			dialog.getNumber().setText(String.valueOf(new Float(dialog.getNumber().getText())-s));
			dialog.setCount(dialog.getCount() -1);
			
			dialog.getSpTable().setRowSelectionInterval(
					dialog.getData().size()-1, dialog.getData().size()-1);
		}else if(e.getKeyCode() == KeyEvent.VK_F4){
			new ChangeNumber(dialog,"修改数量");
		}else if(e.getKeyCode() == KeyEvent.VK_F5){
			
			//存放插入数据库POS退货主表中的数据
			Vector  zbData = new Vector();
			//获取退货单号
			zbData.add(dialog.getTuiHuoID().getText());
			//获取销售单号
			zbData.add(dialog.getXsIS().getText()); 
			//获取退货日期
			zbData.add( DateConventer.dateToStr(Calendar.getInstance().getTime()));
		
			ArrayList data = JDBC_POS_GetInfo.get_pos_xs_info(dialog.getXsIS().getText());
			//获取导购员
			zbData.add(data.get(0));
			//获取仓库
			zbData.add(data.get(1));
			
			//获取应退金额
			zbData.add(dialog.getSum().getText());
			//获取实退金额
			zbData.add(dialog.getSum().getText());
			//获取操作员
			String user =dialog.getFrame().getUser();
			zbData.add(JDBC_POS_GetInfo.getId(user)) ;
			//获取经办人
			zbData.add(data.get(2));
			//获取备注
			zbData.add(data.get(3));
			
			
			//向数据库pos退货总表中插入数据
			JDBCInsertData.insert_th_main_Data(zbData);
			
			//存放向退货详表中插入的数据
			
			//存放向数据库中的销售单详表插入的信息
			int row = dialog.getDefaultModel().getRowCount();
			int column = dialog.getDefaultModel().getColumnCount();
			
			for(int i = 0;i< row; i++){
				Object[] th_data = new Object[column];
				//商品号
				th_data[0] =dialog.getDefaultModel().getValueAt(i, 1);
				//单号
				th_data[1] =  zbData.get(0);
				//数量
				th_data[2] = dialog.getDefaultModel().getValueAt(i, 7).toString();
				//总金额
				th_data[3] = dialog.getDefaultModel().getValueAt(i, 8).toString();
				
				//向数据库中插入数据
				JDBCInsertData.insert_th_detail_Data(th_data);
				
			}
			
			//提示信息
			JOptionPane.showMessageDialog(dialog, "没有设置打印机,不能打印小票",
					"系统提示", JOptionPane.DEFAULT_OPTION, null);
		    dialog.getData().removeAllElements();
		   /* dialog.getDefaultModel().setDataVector(dialog.getData(),
		    		AllTableModel.getVectorFromObj(POSTableModel.SPCulomns));*/
		    dialog.repaint();
			dialog.getSptm().setText("");
			dialog.getSum().setText("0.0");
			dialog.getNumber().setText("0");
			dialog.getXsIS().setText("");
			dialog.getXsDate().setText("");
			dialog.getHyID().setText("");
			
			//改变单号
			String str = null;
			int xd = Integer.parseInt(dialog.getTuiHuoID().getText().substring(11, 14))+1;
			if(xd < 10){
				str = "000"+xd;
			}else if(xd <100){
				str = "00"+xd;
			}else if(xd<1000){
				str = "0"+xd;
			}else{
				str = ""+xd;
			}
		
			dialog.getTuiHuoID().setText(dialog.getTuiHuoID().getText().substring(0,10)+str);
			
			dialog.getXsIS().requestFocus();
			
		}else if(e.getKeyCode() == KeyEvent.VK_F7){
			if(dialog.getSpTable().getRowCount() == 0){
				dialog.dispose();
			}else{
				int n = JOptionPane.showOptionDialog(dialog, "列表中有退货商品,是否退出本窗口", "系统提示", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.DEFAULT_OPTION, null, null, null);
				if(n == JOptionPane.YES_OPTION){
					dialog.dispose();
				}else{
					
				}
			}
			
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			int selectRow = dialog.getSpTable().getSelectedRow();
			if(selectRow == dialog.getData().size()){
				return;
			}
			if(selectRow ==-1){
				return;
			}
			dialog.getSpTable().setRowSelectionInterval(
					selectRow+1, selectRow+1);
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			int selectRow = dialog.getSpTable().getSelectedRow();
			if(selectRow == dialog.getData().size()){
				return;
			}
			if(selectRow ==-1){
				return;
			}
			dialog.getSpTable().setRowSelectionInterval(
					selectRow-1, selectRow-1);
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
