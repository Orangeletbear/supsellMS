package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinGetDatas;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
/**
 * 拆分数量文本框监听器
 * 
 */
public class ChaiFenShuLiangSheZhiDocumentListener implements DocumentListener{
	private ChaifenKunbang dialog;
	public ChaiFenShuLiangSheZhiDocumentListener(ChaifenKunbang dialog) {	
		this.dialog = dialog;
	}

	public void changedUpdate(DocumentEvent e) {
		String djNum = ChaiFenShangPinGetDatas.getChengben(
				dialog.getLabelBCSPMC1().getText().toString());
		String cfsl = null;
		if(dialog.getTextCFSL().getText().trim().length() == 0 ){
			cfsl = "0";
		}else{
			cfsl = dialog.getTextCFSL().getText().trim();
		}
		
		float cfze = new Float(djNum).floatValue() * new Float(cfsl).floatValue();
		
		dialog.getLabelCFZE().setText(" " + cfze);
	}

	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}
}
