package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;
/**
 * ˫����������У�������Ʒ��Ϣdialog����JDBC������ȡ���ݳ�ʼ��dialog����
 * @author Administrator
 *
 */
public class ShangPinXinXiListener implements WindowListener {

	ShangPinXinXi dialog;
	String spid;
	
	public ShangPinXinXiListener(ShangPinXinXi dialog,String spid){
		this.dialog = dialog;
		this.spid =spid;
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

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {
		//��ʼ������
		Vector v = JDBCShangPinXinXi.getData(spid);
		//����toString����null���ð죬������ɽկ��
		dialog.getShangpinbianhao().setText(""+v.remove(0));
		
		dialog.getShangpinmingcheng().setText(""+v.remove(0));
		dialog.getShangpinmingcheng().setForeground(Color.RED);//��Ʒ������Ϊ��ɫ����
		
		dialog.getGuigexinghao().setText(""+v.remove(0));
		//tmp������һ������ͬʱ����  ������λ  ��  ѡ��λ
 		String tmp = ""+v.remove(0);
		dialog.getJibendanwei().setText(tmp);
		////////////����comboBox�Ĺ����൥λ��ʱûд����������������
		dialog.getXuanzedanwei().addItem(tmp);
		dialog.getShengchanchangshang().setText(""+v.remove(0));
		dialog.getYanse().setText(""+v.remove(0));
		
		dialog.getDangqiankucun().setText(""+v.remove(0));
		dialog.getDangqiankucun().setForeground(Color.RED);//��ǰ�����Ϊ��ɫ����
		
		dialog.getBeizhu().setText(""+v.remove(0));
		dialog.getCankaojinjia().setText(""+v.remove(0));
		
		//��ʼ����
		dialog.getATM().setDataVector(JDBCShangPinXinXi.getRowData(spid), 
				ColumnNames.gonghuojilu_columnNames);
		
		
		
	}

}
