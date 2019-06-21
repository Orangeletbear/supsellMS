package com.cn.control.kuchunframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.mainJFrame.MainFrame;
/**
 * 库存变动监听器
 * @author finey
 *
 */
public class KuCunBDAction implements ActionListener {
	private MainFrame frame;
	public KuCunBDAction(MainFrame frame) {
	    this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		new KuCunChaXunFrame(frame,"当前库存查询");
	}

}
