package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;
/**
 * 查找所有客户信息上的
 * 确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class AllKeHuSureAction implements ActionListener {

	private AllKeHuDialog dialog;
	private  ChaZhaoDialog mainDialog = ChaZhaoKeHuButtonAction.getDialog();
	
	public AllKeHuSureAction(AllKeHuDialog dialog){
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
