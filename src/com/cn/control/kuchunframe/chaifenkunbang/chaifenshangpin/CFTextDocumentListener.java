package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;

/**
 * �ı���ʼ�仯ʱ��������
 * �δ����е������д����ƣ�Ӧ����һ��popupmenu
 */
public class CFTextDocumentListener implements DocumentListener {
	private ChaifenKunbang dialog;
	public CFTextDocumentListener(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	public void changedUpdate(DocumentEvent e) {
		new BeiChaiShangPinFindJWindow(dialog).setVisible(true);
	}
}
