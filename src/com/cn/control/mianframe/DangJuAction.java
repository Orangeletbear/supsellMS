package com.cn.control.mianframe;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.toolbar.DanJuFindDialog;
/*
 * 主界面上的单据查寻监听器
 */
public class DangJuAction implements ActionListener {
	MainFrame frame;
	public DangJuAction(MainFrame frame) {
	   this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new DanJuFindDialog(frame,"  单据查寻",true);
	}

}
