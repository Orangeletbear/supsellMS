package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.kucunDiaobo.GaojiChaxunDialog;

public class GJCXActionListener implements ActionListener {
	
	private KucunDiaobo dialog;
	
	public GJCXActionListener(KucunDiaobo dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		//当发生响应的按钮为高级查询时，则弹出此对话框
		JButton btn = (JButton) e.getSource();
		if(btn == dialog.getBtnGJCX()){
			new GaojiChaxunDialog(dialog,"高 级 查 询",true).setVisible(true);
		}
	}
}
