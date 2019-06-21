package com.cn.control.richangframe.Salesman_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.richangJFrame.Salesman_Manage.JWindow_Salesman_Manage;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Manage;

public class JWindow_Salesman_Action implements ActionListener ,DocumentListener{
	
	private Salesman_Manage frame;
	
	public JWindow_Salesman_Action(Salesman_Manage frame){
		this.frame = frame;
	}
	
	//Salesman_Manage�в�ѯ��ť�ļ�������ʵ�ֲ�ѯ���й����̵Ĺ���
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			frame.getSelect_name().setText(null);
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
	}

	/**
	 * Customer_Manage���빩�������ƻ��ŵ�JTextField��Document������,
	 * �ﵽ�����ѯͬ���Ĺ���
	 */
	//ֱ���޸�JTextField�ķ�Ӧ
	public void changedUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 1){    
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
		
	}

	//��JTextField������ֵʱ�ķ�Ӧ
	public void insertUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 0){
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
	}

	//��JTextFieldɾ����ֵʱ�ķ�Ӧ
	public void removeUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 0){
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
		
	}

}
