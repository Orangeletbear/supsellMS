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
	 * 在这个监听器中为客户综合管理(Guote_Manage)中查询
	 * 所有客户
	 */
	private Customer_Manage frame;
	
	public JWindow_Customer_Action(Customer_Manage frame) {
		this.frame = frame;
	}
	//Customer_Manage中查询按钮的监听器，实现查询所有供货商的功能
	public void actionPerformed(ActionEvent e){
		if(e.getSource() instanceof JButton){
			frame.getText_North().setText(null);
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
	}
	/**
	 * Customer_Manage输入供货商名称或编号的JTextField的Document监听器,
	 * 达到输入查询同步的功能
	 */
	//直接修改JTextField的反应
	public void changedUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 1){    
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
		
	}

	//在JTextField插入数值时的反应
	public void insertUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 0){
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
	}

	//在JTextField删除数值时的反应
	public void removeUpdate(DocumentEvent arg0) {
		if(frame.getText_North().getText().length() >= 0){
			JWindow_Customer_Manage.getjcmWindow(frame);
			frame.getText_North().requestFocus();
		}
		
	}

}
