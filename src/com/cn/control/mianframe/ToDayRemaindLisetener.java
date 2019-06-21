package com.cn.control.mianframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.toolbar.RemaindDialog;

public class ToDayRemaindLisetener implements ActionListener {
    private MainFrame frame;
	public ToDayRemaindLisetener(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new RemaindDialog(frame,"ΩÒ»’Ã·–—",true).setVisible(true);
	}

}
