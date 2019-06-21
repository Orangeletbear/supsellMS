package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;


import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfo2Dialog;
/**
 * 该监听器的作用是使
 * 商品信息对话框一打开
 * 就显示相关数据
 * @author Administrator
 *
 */
public class GoodsInfo2Listener extends WindowAdapter {

	private GoodsInfo2Dialog dialog;
	//父窗口
	private AddTuiHuoGoodsDialog mainDialog ;
	
	public GoodsInfo2Listener(GoodsInfo2Dialog dialog){
		this.dialog = dialog;
		mainDialog = dialog.getDialog();
	}
	
	public void windowOpened(WindowEvent e) {
		int row1 = mainDialog.getSpqdtable().getSelectedRow();//左边选中是哪一行
		//该行数据的第一个就是  商品编号
		String spId = mainDialog.getSpqd_tableModel().getValueAt(row1, 0).toString();
		String spName = mainDialog.getSpqd_tableModel().getValueAt(row1, 1).toString();
		String xingHao = mainDialog.getSpqd_tableModel().getValueAt(row1, 3).toString();
		String color = mainDialog.getSpqd_tableModel().getValueAt(row1, 4).toString();
		String danWei = mainDialog.getSpqd_tableModel().getValueAt(row1, 2).toString();
		String kuCun = mainDialog.getSpqd_tableModel().getValueAt(row1, 6).toString();
		
		
		int row2 = mainDialog.getSxsptable().getSelectedRow();//右边表格选中是哪行
		String shuLiang = mainDialog.getSxsp_tableModel().getValueAt(row2, 3).toString();
		String danJia = mainDialog.getSxsp_tableModel().getValueAt(row2, 2).toString();
		
		
		//初始化数据
		dialog.getSpId().setText(spId);
		dialog.getSpName().setText(spName);
		dialog.getSpName().setForeground(Color.RED);
		dialog.getXingHao().setText(xingHao);
		dialog.getKuCun().setText(kuCun);
		dialog.getKuCun().setForeground(Color.RED);
		dialog.getColor().setText(color);
		dialog.getDanWei().setText(danWei);
		dialog.getDanJia().setText(danJia);
		dialog.getDanJia().setForeground(Color.RED);
		dialog.getShuLiang().setText(shuLiang);
	    dialog.getShuLiang().setForeground(Color.RED);
		
		
	
	}

	
}
