package com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinGetDatas;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class KunBangShuLiangSheZhiDocumentListener  implements DocumentListener{
	private ChaifenKunbang dialog;
	
	public KunBangShuLiangSheZhiDocumentListener(ChaifenKunbang dialog) {	
		this.dialog = dialog;
	}

	public void changedUpdate(DocumentEvent e) {
		String djNum = ChaiFenShangPinGetDatas.getChengben(
				dialog.getLabelKBSP().getText().toString());
		String kbsl = null;
		if(dialog.getTextKBSL().getText().trim().length() == 0 ){
			kbsl = "0";
		}else{
			kbsl = dialog.getTextKBSL().getText().trim();
		}
		
		float kbze = new Float(djNum).floatValue() * new Float(kbsl).floatValue();
		
		dialog.getLabelKBZE().setText(" " + kbze);
	}

	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}
}
