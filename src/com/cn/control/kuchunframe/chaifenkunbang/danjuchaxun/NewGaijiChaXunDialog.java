package com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.CFGaojiChaxunJDialog;

public class NewGaijiChaXunDialog implements ActionListener {
	private ChaifenKunbang dialog;
	public NewGaijiChaXunDialog(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		new CFGaojiChaxunJDialog(dialog,"∏ﬂº∂≤È—Ø",true);
	}
}
