package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import com.cn.view.kuchunJFrame.kucunDiaobo.JingbanrenJWindow;

public class JingBanRenAction implements ActionListener {
	
	private JDialog dialog;
	
	public JingBanRenAction(JDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		new JingbanrenJWindow(dialog,"ѡ�񾭰���",true).setVisible(true);
	}
}
