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
	
	//Salesman_Manage中查询按钮的监听器，实现查询所有供货商的功能
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			frame.getSelect_name().setText(null);
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
	}

	/**
	 * Customer_Manage输入供货商名称或编号的JTextField的Document监听器,
	 * 达到输入查询同步的功能
	 */
	//直接修改JTextField的反应
	public void changedUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 1){    
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
		
	}

	//在JTextField插入数值时的反应
	public void insertUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 0){
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
	}

	//在JTextField删除数值时的反应
	public void removeUpdate(DocumentEvent arg0) {
		if(frame.getSelect_name().getText().length() >= 0){
			JWindow_Salesman_Manage.getjsmWindow(frame);
			frame.getSelect_name().requestFocus();
		}
		
	}

}
