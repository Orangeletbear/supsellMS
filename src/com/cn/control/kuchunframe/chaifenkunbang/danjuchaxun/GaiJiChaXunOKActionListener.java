package com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.CFKB_ChaXunGetDatas;
import com.cn.view.kuchunJFrame.chaifenkunbang.CFGaojiChaxunJDialog;

/**
 * 高级查询确定按钮
 * 
 */
public class GaiJiChaXunOKActionListener implements ActionListener {
	private CFGaojiChaxunJDialog dialog;
	public GaiJiChaXunOKActionListener(CFGaojiChaxunJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		Vector vo = new Vector();
		vo = CFKB_ChaXunGetDatas.gaojiChaXun(dialog.getComboCFCK().getSelectedItem().toString(), 
				dialog.getComboJBR().getSelectedItem().toString(), 
				dialog.getDialog().getComboDJLX().getSelectedItem().toString());
		dialog.getDialog().getTableModel4().setDataVector(vo, dialog.getDialog().getVe4());
		dialog.dispose();
	}
}
