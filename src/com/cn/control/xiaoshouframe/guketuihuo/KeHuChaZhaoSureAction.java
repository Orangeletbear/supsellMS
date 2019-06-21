package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ChaZhaoKeHuButtonAction;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;

public class KeHuChaZhaoSureAction implements ActionListener {


	private AllKeHuDialog dialog;
	private static ChaZhaoDialog mainDialog = ChaZhaoKeHuButtonAction.getDialog();
	
	public KeHuChaZhaoSureAction(AllKeHuDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
   
         JTable table = dialog.getKeHuTable();
         int row = table.getSelectedRow();
         String keHuName = (String) table.getValueAt(row, 1);
         mainDialog.getKeHuName().setText(keHuName);
         dialog.dispose();
	}


}
