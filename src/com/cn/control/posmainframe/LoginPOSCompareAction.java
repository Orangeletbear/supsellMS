package com.cn.control.posmainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.dao.loginandmainframe.JDBCLoginInformation;
import com.cn.dao.loginandmainframe.LoginDialogVO;
import com.cn.view.login.LoginConfirmation;
import com.cn.view.login.LoginDialog;
import com.cn.view.login.LoginPosFrame;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.posmainJFrame.POSFrame;

public class LoginPOSCompareAction implements ActionListener {

	LoginPosFrame dialog;
	
	public LoginPOSCompareAction(LoginPosFrame dialog) {
		this.dialog = dialog;
	}
	

	public void actionPerformed(ActionEvent e) {
		LoginConfirmation.posLoginConfirm(dialog);
	
   }	//action and 			

}
