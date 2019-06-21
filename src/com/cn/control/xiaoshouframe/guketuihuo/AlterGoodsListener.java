package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AlterGoodsDialog;
/**
 * 
 * 顾客退货对话框中顾客退货选项卡
 * 上的单击修改商品按钮
 * 和双击其上的表格时出现的对话框
 * 打开时发生的事件
 * @author Administrator
 *
 */

public class AlterGoodsListener extends WindowAdapter {

	private AlterGoodsDialog dialog;
	private GuKeTuiHuoDialog mainDialog;
	
	public AlterGoodsListener(AlterGoodsDialog dialog){
		this.dialog = dialog;
		this.mainDialog = dialog.getDialog();
	}
	
	//界面一打开就添加数据
	public void windowOpened(WindowEvent e){
		
       int row	= mainDialog.getTable().getSelectedRow();
       String spId = mainDialog.getTableModel().getValueAt(row, 0).toString();
       String spName = mainDialog.getTableModel().getValueAt(row, 1).toString();
       String danWei = mainDialog.getTableModel().getValueAt(row, 2).toString();
       String danJia = mainDialog.getTableModel().getValueAt(row, 3).toString();
       String shuLiang = mainDialog.getTableModel().getValueAt(row, 4).toString();
       String xingHao = mainDialog.getTableModel().getValueAt(row, 5).toString();
       String color = mainDialog.getTableModel().getValueAt(row, 6).toString();
       
       dialog.getSpId().setText(spId);
       dialog.getSpId().setForeground(Color.BLUE);
       dialog.getSpName().setText(spName);
       dialog.getSpName().setForeground(Color.BLUE);
       dialog.getDanWei().setText(danWei);
       dialog.getDanJia().setText(danJia);
       dialog.getShuLiang().setText(shuLiang);
       dialog.getShuLiang().setForeground(Color.RED);
       dialog.getXingHao().setText(xingHao);
       dialog.getColor().setText(color);
       dialog.getColor().setForeground(Color.RED);
       
       
    
	}
}
