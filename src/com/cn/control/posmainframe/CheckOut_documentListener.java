package com.cn.control.posmainframe;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.posmainJFrame.CheckOut;
import com.cn.view.posmainJFrame.POSFrame;

public class CheckOut_documentListener implements DocumentListener {

	private CheckOut dialog;
	//private POSFrame frame;
	
	public CheckOut_documentListener(CheckOut dialog) {
		this.dialog = dialog;
		//this.frame = dialog.getFrame();
	}


	public void changedUpdate(DocumentEvent e) {
		

	}

	
	public void insertUpdate(DocumentEvent e) {
	
			float returnMoney = Float.parseFloat(dialog.getGivePay().getText().toString()) 
			     - Float.parseFloat(dialog.getShouldPay().getText().toString());
			dialog.getReturnPay().setText(String.valueOf(returnMoney));
		
	}

	
	public void removeUpdate(DocumentEvent e) {
		

	}

}
