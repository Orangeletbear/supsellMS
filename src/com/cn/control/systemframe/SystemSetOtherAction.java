package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.OtherSetFrame;
/*
 * 系统其它设置对话框
 */
public class SystemSetOtherAction implements ActionListener {
	private MainFrame frame;
	public SystemSetOtherAction(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		new OtherSetFrame(frame,"系统设置",true);
	}

}
