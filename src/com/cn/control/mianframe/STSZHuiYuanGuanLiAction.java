package com.cn.control.mianframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/*
 * ��Ա����Ť
 */
public class STSZHuiYuanGuanLiAction implements ActionListener {
	
	MainFrame frame;
	public STSZHuiYuanGuanLiAction(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new HuiYanGuangLiFrame(frame,"��Ա����");
	}

}
