package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.BeiChaiShangPinChaXunDataToView;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;

/**
 * 被拆商品查询按钮监听器，根据编号查询
 * @author Administrator
 *
 */
public class BeiChaiShangPinChaXunAction implements DocumentListener {
	private BeiChaiShangPinFindJWindow dialog;
	
	public BeiChaiShangPinChaXunAction(BeiChaiShangPinFindJWindow dialog){
		this.dialog = dialog;
	}
		
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}
	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}
	public void changedUpdate(DocumentEvent e) {
		Object [][]datas = BeiChaiShangPinChaXunDataToView.dataToView(dialog);
		dialog.getTableModelBCF().setDataVector(datas, AddSanPingCulomns.ColumnName1);
		dialog.getTableBCF().setRowSelectionInterval(0, 0);
	}
}
