package com.cn.control.systemframe.sanpingxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;


import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
/*
 * �޸���Ʒ��ť������
 */
public class AtlerShangPingAction implements ActionListener {
	
	private ShangPingGuangLiFrame dialog;
	public AtlerShangPingAction(ShangPingGuangLiFrame dialog) {
	     this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		if(dialog.getSptable().getSelectedColumnCount()!=1){
			JOptionPane.showMessageDialog(dialog,"����ѡ��һ������");
			return;
		}
		int row = dialog.getSptable().getSelectedRow();
		String obj = dialog.getTableModel().getValueAt(row, 0).toString();
	   new AtlerShangPingDialog(this.dialog,"�޸���Ʒ",true,obj);
	}

}
