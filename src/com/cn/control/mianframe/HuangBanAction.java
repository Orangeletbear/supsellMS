package com.cn.control.mianframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.login.LoginDialog;
import com.cn.view.mainJFrame.MainFrame;
/*
 * �������ϵĻ�����������
 */
public class HuangBanAction implements ActionListener {
	private MainFrame frame;
	public HuangBanAction(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
          new LoginDialog(frame,"����",true);
	}

}
