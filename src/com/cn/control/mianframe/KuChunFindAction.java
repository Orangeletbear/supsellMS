package com.cn.control.mianframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.toolbar.KuChunFind;
/*
 * �������ϵĿ���ѯ������
 */
public class KuChunFindAction implements ActionListener {
    
	
	private MainFrame frame;
	public KuChunFindAction(MainFrame frame) {
	   this.frame = frame;
	 
	}

	public void actionPerformed(ActionEvent e) {
		new KuChunFind(frame,"����ѯ",true);
	}

}
