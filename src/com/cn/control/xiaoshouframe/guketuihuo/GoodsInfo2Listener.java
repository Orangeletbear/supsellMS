package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;


import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfo2Dialog;
/**
 * �ü�������������ʹ
 * ��Ʒ��Ϣ�Ի���һ��
 * ����ʾ�������
 * @author Administrator
 *
 */
public class GoodsInfo2Listener extends WindowAdapter {

	private GoodsInfo2Dialog dialog;
	//������
	private AddTuiHuoGoodsDialog mainDialog ;
	
	public GoodsInfo2Listener(GoodsInfo2Dialog dialog){
		this.dialog = dialog;
		mainDialog = dialog.getDialog();
	}
	
	public void windowOpened(WindowEvent e) {
		int row1 = mainDialog.getSpqdtable().getSelectedRow();//���ѡ������һ��
		//�������ݵĵ�һ������  ��Ʒ���
		String spId = mainDialog.getSpqd_tableModel().getValueAt(row1, 0).toString();
		String spName = mainDialog.getSpqd_tableModel().getValueAt(row1, 1).toString();
		String xingHao = mainDialog.getSpqd_tableModel().getValueAt(row1, 3).toString();
		String color = mainDialog.getSpqd_tableModel().getValueAt(row1, 4).toString();
		String danWei = mainDialog.getSpqd_tableModel().getValueAt(row1, 2).toString();
		String kuCun = mainDialog.getSpqd_tableModel().getValueAt(row1, 6).toString();
		
		
		int row2 = mainDialog.getSxsptable().getSelectedRow();//�ұ߱��ѡ��������
		String shuLiang = mainDialog.getSxsp_tableModel().getValueAt(row2, 3).toString();
		String danJia = mainDialog.getSxsp_tableModel().getValueAt(row2, 2).toString();
		
		
		//��ʼ������
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
