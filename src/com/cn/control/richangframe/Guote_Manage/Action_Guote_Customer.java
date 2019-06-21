package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.richangJFrame.Guote_Manage.JWindow_Quote_Customer;
import com.cn.view.richangJFrame.Guote_Manage.Quote_Manage;

public class Action_Guote_Customer implements ActionListener{
	/**
	 * 在这个监听器中为报价管理(Guote_Manage)中查询
	 * 所有客户
	 */
	private Quote_Manage dialog;
	
	public Action_Guote_Customer(Quote_Manage dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e){
		new JWindow_Quote_Customer(dialog);
	}

}
