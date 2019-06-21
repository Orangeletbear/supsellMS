package com.cn.control.kuchunframe.kucunpandian;

import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.kuchun.kucunpandian.KCPD_MoHuChaXunGetDatas;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;

public class KCPD_MoHuChaXunDocumentLisrener implements DocumentListener {

	private XinZengPanDianDanJDialog dialog;
	
	public KCPD_MoHuChaXunDocumentLisrener(XinZengPanDianDanJDialog dialog) {
		this.dialog = dialog;
	}

	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void changedUpdate(DocumentEvent e) {
		Vector vo = KCPD_MoHuChaXunGetDatas.moHuCheck(dialog.getTextSPBH().getText().trim());
		
		dialog.getTableModelSPQD().setDataVector(vo, dialog.getVeKCSP());
		dialog.getTableSPQD().setRowSelectionInterval(0, 0);
	}

}
