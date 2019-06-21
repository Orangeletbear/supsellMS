package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AlterXiaoShouGoodsDialog;
/**
 * 
 * 商品销售对话框中的单击修改商品按钮
 * 和双击其上的表格时出现的对话框
 * 打开时发生的事件
 * @author Administrator
 *
 */
public class AlterXiaoShouGoodsAction extends WindowAdapter {

	private AlterXiaoShouGoodsDialog dialog;
	private ShangPinXiaoShouDialog mainDialog;
	
	public AlterXiaoShouGoodsAction(AlterXiaoShouGoodsDialog dialog){
		this.dialog = dialog;
		mainDialog = dialog.getDialog();
	}

	
	//界面一打开就添加数据
	public void windowOpened(WindowEvent e){
		
       int row	= mainDialog.getTable().getSelectedRow();
       String spId = mainDialog.getTableModel().getValueAt(row, 0).toString();
       String spName = mainDialog.getTableModel().getValueAt(row, 1).toString();
       String danWei = mainDialog.getTableModel().getValueAt(row, 2).toString();
       String danJia = mainDialog.getTableModel().getValueAt(row, 7).toString();
       String shuLiang = mainDialog.getTableModel().getValueAt(row, 8).toString();
       String xingHao = mainDialog.getTableModel().getValueAt(row, 3).toString();
       String color = mainDialog.getTableModel().getValueAt(row, 4).toString();
       String daZhe  = mainDialog.getTableModel().getValueAt(row, 6).toString();
       String canKaoShouJia = mainDialog.getTableModel().getValueAt(row, 5).toString();
       String zje = String.valueOf(Float.parseFloat(danJia)*Float.parseFloat(shuLiang));
       String kuCun = JDBCGetInfo.getKuCun(spId).toString();
       
       dialog.getGoodId().setText(spId);
       dialog.getGoodId().setForeground(Color.BLUE);
       
       dialog.getGoodName().setText(spName);
       dialog.getGoodName().setForeground(Color.BLUE);
       
       dialog.getDanWei().setText(danWei);
       dialog.getDanJia().setText(danJia);
       
       dialog.getShuLiang().setText(shuLiang);
       dialog.getShuLiang().setForeground(Color.RED);
       
       dialog.getXingHao().setText(xingHao);
       dialog.getXingHao().setForeground(Color.BLUE);
       dialog.getColor().setText(color);
       dialog.getColor().setForeground(Color.RED);
       
       dialog.getDaZhe().setText(daZhe);
       dialog.getDaZhe().setForeground(Color.BLUE);
       
       dialog.getCanKaoShouJia().setText(canKaoShouJia);
       dialog.getCanKaoShouJia().setForeground(Color.RED);
       
       dialog.getZje().setText(zje);
       dialog.getZje().setForeground(Color.RED);
       
       dialog.getKuCun().setText(kuCun);
       dialog.getKuCun().setForeground(Color.RED);
    
	}

}
