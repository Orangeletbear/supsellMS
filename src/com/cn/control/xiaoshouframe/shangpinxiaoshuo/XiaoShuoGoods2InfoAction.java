package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cn.model.AllTableModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;

/**
 * 第二个商品信息对话框
 * 打开时对应的监听器
 * @author Administrator
 *
 */
public class XiaoShuoGoods2InfoAction extends WindowAdapter {

	private XiaoShouGoodsInfo2 dialog;
	//父窗口
	private AddXiaoShouGoodsDialog mainDialog;
	
	public XiaoShuoGoods2InfoAction(XiaoShouGoodsInfo2 dialog){
		this.dialog = dialog;
		
	}
	//窗口打开时就有数据，数据来源于增加商品（商品销售）对话框中的表
	public void windowOpened(WindowEvent e){
		
		mainDialog = dialog.getDialog();
		AllTableModel model = mainDialog.getSpqd_tableModel();
         //	父窗口左边表被选择的行
		int row1 = mainDialog.getSpqdtable().getSelectedRow();
		
		String spId = model.getValueAt(row1, 0).toString();
		String spName = model.getValueAt(row1, 1).toString();
		String xingHao = model.getValueAt(row1, 3).toString();
		String danWei = model.getValueAt(row1, 2).toString();
		String color= model.getValueAt(row1, 4).toString();
		String kuCun = model.getValueAt(row1, 6).toString();
		
		//父窗右边表被选择的行
		int row2 = mainDialog.getSxsptable().getSelectedRow();
		AllTableModel model2 = mainDialog.getSxsp_tableModel();
		
		String canKaoShouJia = model2.getValueAt(row2, 2).toString();
		String daZhe = model2.getValueAt(row2, 3).toString();
		String shuLiang = model2.getValueAt(row2, 5).toString();
		String danJia = model2.getValueAt(row2, 4).toString();
		String zje = model2.getValueAt(row2, 6).toString();
		
		//将数据显示到界面上
		dialog.getGoodId().setText(spId);
		dialog.getGoodId().setForeground(Color.BLUE);
		
		dialog.getGoodName().setText(spName);
		dialog.getGoodName().setForeground(Color.RED);
		
		dialog.getXingHao().setText(xingHao);
		dialog.getXingHao().setForeground(Color.BLUE);
		
		dialog.getDanWei().setText(danWei);
		dialog.getDanWei().setForeground(Color.BLUE);
		
		dialog.getDanJia() .setText(danJia);
		dialog.getDanJia().setForeground(Color.BLUE);
		
		dialog.getCanKaoShouJia().setText(canKaoShouJia);
		dialog.getCanKaoShouJia().setForeground( Color.RED);
		
		dialog.getDaZhe().setText(daZhe);
		dialog.getDaZhe().setForeground(Color.BLUE);
		
		dialog.getZje().setText(zje);
		dialog.getZje().setForeground(Color.BLUE);
		
		dialog.getKuCun().setText(kuCun);
		dialog.getKuCun().setForeground(Color.BLUE);
		
		dialog.getColor().setText(color);
		dialog.getColor().setForeground(Color.RED);
		
		dialog.getShuLiang().setText(shuLiang);
		dialog.getShuLiang().setForeground(Color.RED);
	}
}
