package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * 商品管理监听器
 * @author Administrator
 *
 */
public class SanPingGLAction implements ActionListener {
	private MainFrame frame;
	public SanPingGLAction(MainFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new ShangPingGuangLiFrame(frame,"商品信息");
	}

}
