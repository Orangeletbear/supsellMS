package com.cn.control.mianframe;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.toolbar.DanJuFindDialog;
/*
 * �������ϵĵ��ݲ�Ѱ������
 */
public class DangJuAction implements ActionListener {
	MainFrame frame;
	public DangJuAction(MainFrame frame) {
	   this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new DanJuFindDialog(frame,"  ���ݲ�Ѱ",true);
	}

}
