package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCLaoShangPinTianJia;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
/**
 * 一打开addSanPingDialog就应该初始化了左边表内数据
 * @author Administrator
 *
 */
public class LaoShangPinTianJiaListener implements WindowListener{
	
	AddShangPingDialog dialog;

	public LaoShangPinTianJiaListener(AddShangPingDialog dialog){
		this.dialog = dialog;
	}
	/////////写这个方法
	public void windowOpened(WindowEvent e) {
		dialog.setLeftData(JDBCLaoShangPinTianJia.getTB_SPINFO());
		dialog.getATM().setDataVector(dialog.getLeftData(), ColumnNames.splbtable_colunm);
	}

	public void windowIconified(WindowEvent e) {
		
	}
	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		
	}

	public void windowDeactivated(WindowEvent e) {
		
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

}
