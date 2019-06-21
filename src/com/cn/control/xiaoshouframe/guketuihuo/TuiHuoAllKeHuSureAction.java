package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.TuiHuoAllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;
/**
 * 顾客退货对话框中的顾客退货选项卡上的
 * 高级查询按钮所弹出的查找对话框上的
 * 查找客户按钮所弹出的对话框上的
 * 确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class TuiHuoAllKeHuSureAction implements ActionListener {

	private TuiHuoAllKeHuDialog dialog;
	private static GaoJiChaXun mainDialog = TuiHuoChaZhaoKeHuButtonAction.getDialog();
	
	public TuiHuoAllKeHuSureAction(TuiHuoAllKeHuDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
   
         JTable table = dialog.getKeHuTable();
         int row = table.getSelectedRow();
         String keHuName = (String) table.getValueAt(row, 1);
         mainDialog.getKeHuText().setText(keHuName);
         dialog.dispose();
	}

}
