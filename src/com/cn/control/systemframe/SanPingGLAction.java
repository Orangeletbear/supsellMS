package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * ��Ʒ���������
 * @author Administrator
 *
 */
public class SanPingGLAction implements ActionListener {
	private MainFrame frame;
	public SanPingGLAction(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new ShangPingGuangLiFrame(frame,"��Ʒ��Ϣ");
	}

}
