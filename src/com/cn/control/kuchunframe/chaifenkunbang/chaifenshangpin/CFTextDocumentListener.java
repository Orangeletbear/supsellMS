package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;

/**
 * 文本开始变化时弹出窗口
 * 次窗口中的内容有待改善，应创建一个popupmenu
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
