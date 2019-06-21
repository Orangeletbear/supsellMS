package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;
/**
 * 商品调价
 * @author finey
 *
 */
public class ShangPingTJAction implements ActionListener {
	
	MainFrame frame;
	
	public ShangPingTJAction(MainFrame frame) {
	     this.frame = frame;
	}


	public void actionPerformed(ActionEvent e) {
		new SanpinTiaoJiaJFrame(frame,"商品调价");
	}

}
