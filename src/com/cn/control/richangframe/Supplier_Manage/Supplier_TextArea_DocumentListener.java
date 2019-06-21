package com.cn.control.richangframe.Supplier_Manage;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class Supplier_TextArea_DocumentListener implements DocumentListener{
	private Supplier_Manage sm;
	public Supplier_TextArea_DocumentListener(Supplier_Manage sm) {
		this.sm = sm;
	}

	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void insertUpdate(DocumentEvent e) {
		try {
			sm.getTextArea().setText(e.getDocument().getText(0, e.getLength()));
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
