package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cn.model.AllTableModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;

/**
 * �ڶ�����Ʒ��Ϣ�Ի���
 * ��ʱ��Ӧ�ļ�����
 * @author Administrator
 *
 */
public class XiaoShuoGoods2InfoAction extends WindowAdapter {

	private XiaoShouGoodsInfo2 dialog;
	//������
	private AddXiaoShouGoodsDialog mainDialog;
	
	public XiaoShuoGoods2InfoAction(XiaoShouGoodsInfo2 dialog){
		this.dialog = dialog;
		
	}
	//���ڴ�ʱ�������ݣ�������Դ��������Ʒ����Ʒ���ۣ��Ի����еı�
	public void windowOpened(WindowEvent e){
		
		mainDialog = dialog.getDialog();
		AllTableModel model = mainDialog.getSpqd_tableModel();
         //	��������߱�ѡ�����
		int row1 = mainDialog.getSpqdtable().getSelectedRow();
		
		String spId = model.getValueAt(row1, 0).toString();
		String spName = model.getValueAt(row1, 1).toString();
		String xingHao = model.getValueAt(row1, 3).toString();
		String danWei = model.getValueAt(row1, 2).toString();
		String color= model.getValueAt(row1, 4).toString();
		String kuCun = model.getValueAt(row1, 6).toString();
		
		//�����ұ߱�ѡ�����
		int row2 = mainDialog.getSxsptable().getSelectedRow();
		AllTableModel model2 = mainDialog.getSxsp_tableModel();
		
		String canKaoShouJia = model2.getValueAt(row2, 2).toString();
		String daZhe = model2.getValueAt(row2, 3).toString();
		String shuLiang = model2.getValueAt(row2, 5).toString();
		String danJia = model2.getValueAt(row2, 4).toString();
		String zje = model2.getValueAt(row2, 6).toString();
		
		//��������ʾ��������
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
