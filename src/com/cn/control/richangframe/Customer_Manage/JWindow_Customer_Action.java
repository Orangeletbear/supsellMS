package com.cn.control.richangframe.Customer_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.richangJFrame.Customer_Manage.Customer_Manage;
import com.cn.view.richangJFrame.Customer_Manage.JWindow_Customer_Manage;

public class JWindow_Customer_Action implements ActionListener,DocumentListener{
	/**
	 * �������������Ϊ�ͻ��ۺϹ���(Guote_Manage)�в�ѯ
	 * ���пͻ�
	 */
	private Customer_Manage frame;
	
	public JWindow_Customer_Action(Customer_Manage frame) {
		this.frame = frame;
	}
	//Customer_Manage�в�ѯ��ť�ļ�������ʵ�ֲ�ѯ���й����̵Ĺ���
	public void actionPerformed(ActionEvent e){
		if(e.getSource() instanceof JButton){
			frame.getText_North().setText(null);
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
	}
	/**
	 * Customer_Manage���빩�������ƻ��ŵ�JTextField��Document������,
	 * �ﵽ�����ѯͬ���Ĺ���
	 */
	//ֱ���޸�JTextField�ķ�Ӧ
	public void changedUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 1){    
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
		
	}

	//��JTextField������ֵʱ�ķ�Ӧ
	public void insertUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 0){
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
	}

	//��JTextFieldɾ����ֵʱ�ķ�Ӧ
	public void removeUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 0){
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
		
	}

}
