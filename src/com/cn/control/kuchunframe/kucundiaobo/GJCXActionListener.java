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
		//��������Ӧ�İ�ťΪ�߼���ѯʱ���򵯳��˶Ի���
		JButton btn = (JButton) e.getSource();
		if(btn == dialog.getBtnGJCX()){
			new GaojiChaxunDialog(dialog,"�� �� �� ѯ",true).setVisible(true);
		}
	}
}
