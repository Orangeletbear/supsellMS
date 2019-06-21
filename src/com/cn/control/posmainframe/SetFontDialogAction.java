package com.cn.control.posmainframe;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.posmainJFrame.FontDialog;
import com.cn.view.posmainJFrame.POSFrame;
/**
 * ������Ի���ļ�����
 * @author finey
 *
 */
public class SetFontDialogAction implements ActionListener {
	POSFrame frame;
	public SetFontDialogAction(POSFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new FontDialog(frame, "����Ի���", true);
		
	}

}
