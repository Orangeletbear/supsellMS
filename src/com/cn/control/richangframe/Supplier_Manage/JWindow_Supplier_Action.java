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
	
	//Supplier_Manage中查询按钮的监听器，实现查询所有供货商的功能
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			frame.getJTextField().setText(null);
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	/**
	 * Supplier_Manage输入供货商名称或编号的JTextField的Document监听器,
	 * 达到输入查询同步的功能
	 */
	
	//直接修改JTextField的反应
	public void changedUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 1){    
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	//在JTextField插入数值时的反应
	public void insertUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 1){    
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

	//在JTextField删除数值时的反应
	public void removeUpdate(DocumentEvent e) {
		if(frame.getText_North().length() >= 0){
			JWindow_Supplier_Manage.getjsmWindow(frame);
			frame.getJTextField().requestFocus();
		}
	}

}
