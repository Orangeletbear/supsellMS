package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * ����ѡ����Ʒȷ�����䵽����������
 * 
 */
public class Send_ShangPinAction implements ActionListener {
	private AddSanPingDialog dialog;
	private static 	boolean flag = true;
	
	public Send_ShangPinAction (AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog.getVo3().size() > 0){
//			����������
			if(dialog.getKDialog() instanceof KucunDiaobo){
				for(int i = 0; i < dialog.getVo3().size(); i ++){
					dialog.getKDialog().getVector1().add(dialog.getVo3().get(i));
				}
				dialog.getKDialog().getTableModel1().setDataVector(dialog.getKDialog().getVector1(), 
						dialog.getKDialog().getVe1());
//				dialog.getKDialog().getTableKCDB1().setRowSelectionInterval(0, 0);
			}
			
			//�����細��
			if(dialog.getBDialog() instanceof BaosunBaoyi){
				Vector vo1 = new Vector();//�����ѡ����е�����
				Vector vo2 = new Vector();//��Ž�Ҫ�ŵ��������������
				vo1 = dialog.getVo3();
				for(int i = 0; i < vo1.size(); i ++){
					Vector tmp = new Vector();
						tmp.add(((Vector)vo1.get(i)).get(0));
						tmp.add(((Vector)vo1.get(i)).get(1));
						tmp.add(((Vector)vo1.get(i)).get(2));
						tmp.add(((Vector)vo1.get(i)).get(3));
						tmp.add(((Vector)vo1.get(i)).get(4));
						tmp.add(((Vector)vo1.get(i)).get(5));
						vo2.add(tmp);
				}	
				//����
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
					for(int i = 0; i < dialog.getVo3().size(); i ++){
						dialog.getBDialog().getVector1().add(vo2.get(i));
					}
					dialog.getBDialog().getTableModel1().setDataVector(dialog.getBDialog().getVector1(),dialog.getBDialog().getVe1());
				}
				//����
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
					for(int i = 0; i < dialog.getVo3().size(); i ++){
						dialog.getBDialog().getVector2().add(vo2.get(i));
					}
					dialog.getBDialog().getTableModel1().setDataVector(dialog.getBDialog().getVector2(),dialog.getBDialog().getVe1());
				}				
//				dialog.getBDialog().getTableBSBY1().setRowSelectionInterval(0, 0);
			}
			
			///��Ʒ�������
			if(dialog.getCDialog() instanceof ChaifenKunbang){
				
				ChaifenKunbang cd = dialog.getCDialog(); 
				
				if(dialog.getFlag().equals("0")){
					for(int i = 0; i < actions().size(); i ++){
						dialog.getCDialog().getVector1().add(actions().get(i));
					}
					cd.getTableModelCF().setDataVector(dialog.getCDialog().getVector1(), cd.getVe1());
				}
				
				if(dialog.getFlag().equals("1")){
					for(int i = 0; i < actions().size(); i ++){
						dialog.getCDialog().getVector2().add(actions().get(i));
					}
					cd.getTableModelKB().setDataVector(dialog.getCDialog().getVector2(), cd.getVe2());
				}
			}
			dialog.dispose();
		}
	}
	
	/*
	 * �������Ĺ��÷���
	 */
	private Vector actions(){
		Vector vo1 = new Vector();//�����ѡ����е�����
		Vector vo2 = new Vector();//��Ž�Ҫ�ŵ���ֵ��������
		vo1 = dialog.getVo3();
		for(int i = 0; i < vo1.size(); i ++){
			
//			for(int j = 0; j < vo1.size(); j ++){
				Vector tmp = new Vector();
				tmp.add(((Vector)vo1.get(i)).get(0));
				tmp.add(((Vector)vo1.get(i)).get(1));
				tmp.add(((Vector)vo1.get(i)).get(2));
				tmp.add(((Vector)vo1.get(i)).get(3));
				tmp.add(((Vector)vo1.get(i)).get(4));
				tmp.add(((Vector)vo1.get(i)).get(5));
				tmp.add(((Vector)vo1.get(i)).get(6));
				vo2.add(tmp);
		} 
		return vo2;
	}
}
