package com.cn.control.jinhuoframe;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCLaoShangPinTianJia;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
/**
 * һ��addSanPingDialog��Ӧ�ó�ʼ������߱�������
 * @author Administrator
 *
 */
public class LaoShangPinTianJiaListener implements WindowListener{
	
	AddShangPingDialog dialog;

	public LaoShangPinTianJiaListener(AddShangPingDialog dialog){
		this.dialog = dialog;
	}
	/////////д�������
	public void windowOpened(WindowEvent e) {
		dialog.getATM().setDataVector(JDBCLaoShangPinTianJia.getTB_SPINFO(), ColumnNames.splbtable_colunm);
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
