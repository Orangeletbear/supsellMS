package com.cn.control.mianframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.dao.loginandmainframe.JDBCLoginInformation;
import com.cn.dao.loginandmainframe.LoginDialogVO;
import com.cn.util.Log;
import com.cn.view.login.LoginConfirmation;
import com.cn.view.login.LoginDialog;
import com.cn.view.mainJFrame.MainFrame;
/*
 * µÇÂ½´°¿ÚÈ·¶¨¼àÌýÆ÷
 */
public class LoginCompareAction implements ActionListener {
	
	LoginDialog dialog;
	
	public LoginCompareAction(LoginDialog dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		LoginConfirmation.loginConfirm(dialog);
  }	//action and 			
	
}
