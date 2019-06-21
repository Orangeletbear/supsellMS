package com.cn.control.systemframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
/*
 * 修改商品按钮监听器
 */
public class AtlerShangPingAction implements ActionListener {
	
	private ShangPingGuangLiFrame dialog;
	public AtlerShangPingAction(ShangPingGuangLiFrame dialog) {
	     this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		
		int row = dialog.getSptable().getSelectedRow();
		String obj = dialog.getTableModel().getValueAt(row, 0).toString();
		new AtlerShangPingDialog(this.dialog,"修改商品",true,obj);
	}

}
