package com.cn.control.richangframe.Supplier_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.richangJFrame.Supplier_Manage.JWindow_Supplier_Manage;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class JWindow_Supplier_Action implements ActionListener ,DocumentListener{
	
	private Supplier_Manage frame;

	public JWindow_Supplier_Action(Supplier_Manage frame){
		this.frame = frame;
	}
	
	//Supplier_Manage�в�ѯ��ť�ļ�������ʵ�ֲ�ѯ���й����̵Ĺ���
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			frame.getJTextField().setText(null);
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	/**
	 * Supplier_Manage���빩�������ƻ��ŵ�JTextField��Document������,
	 * �ﵽ�����ѯͬ���Ĺ���
	 */
	
	//ֱ���޸�JTextField�ķ�Ӧ
	public void changedUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 1){    
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	//��JTextField������ֵʱ�ķ�Ӧ
	public void insertUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 1){    
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	//��JTextFieldɾ����ֵʱ�ķ�Ӧ
	public void removeUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 0){
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

}
