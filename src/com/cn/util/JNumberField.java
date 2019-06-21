package com.cn.util;

import javax.swing.*;

import javax.swing.text.*;
import java.awt.*;

/**
 * 只能输入数字的JTextField
 * 
 */
public class JNumberField extends JTextField {
	public JNumberField() {
		super();
		setDocument(new numDoc());
	}

	public JNumberField(int decLen) {
		super(decLen);
		setDocument(new numDoc(decLen));
	}

	public JNumberField(int decLen, int maxLen) {
		super();
		setDocument(new numDoc(decLen, maxLen));
	}
}

class numDoc extends PlainDocument {
	int maxLength = 16;
	int decLength = 0;

	public numDoc(int decLen, int maxLen) {
		maxLength = maxLen;
		decLength = decLen;
	}

	public numDoc(int decLen) {
		decLength = decLen;
	}

	public numDoc() {
	}

	public void insertString(int offset, String s, AttributeSet a)
			throws BadLocationException {
		int len = getLength();
		String str = getText(0, len);
		int decPos = str.indexOf(".");
		if (s.equals("F")
				|| s.equals("f")
				|| s.equals("D")
				|| s.equals("d")
				|| (str + s).length() > maxLength
				|| (decPos > -1 && offset > decPos && ((str.substring(decPos +1)) + s)
						.length() > decLength)
				|| (str.trim().equals("0") && !s.substring(0, 1).equals(".") && offset != 0)
				|| (s.equals(".") && decLength == 0)
			|| (s.indexOf(".") > -1 && s.substring(s.indexOf(".") + 1).length() > decLength)) {
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		try {
			Float.parseFloat(str + s);
		} catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		super.insertString(offset, s, a);
	}
	
}

