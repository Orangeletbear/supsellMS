package com.cn.control.kuchunframe.kucundiaobo;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin.AddShangPinDataToView;
import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chaxunshangpin.ChaXunShangPinDataToView;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;


public class ShangPinMohuChaXunDocumentListener implements DocumentListener {
	private AddSanPingDialog dialog;
	
	public ShangPinMohuChaXunDocumentListener(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void changedUpdate(DocumentEvent e) {
		Object [][]datas = ChaXunShangPinDataToView.dataToView(dialog);
		dialog.getTableModel1().setDataVector(datas, AddSanPingCulomns.ColumnName1);
		dialog.getSpqdtable().setRowSelectionInterval(0, 0);
	}

}
