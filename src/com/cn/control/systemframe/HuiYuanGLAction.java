package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * ��Ա����ť
 * @author finey
 *
 */
public class HuiYuanGLAction implements ActionListener {
	MainFrame frame;
	public HuiYuanGLAction(MainFrame frame) {
	     this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new HuiYanGuangLiFrame(frame,"��Ա����");
	}

}
