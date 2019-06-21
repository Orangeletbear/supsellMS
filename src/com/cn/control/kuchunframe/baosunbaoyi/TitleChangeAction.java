package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

/**
 * ��Ʒ���������ĸı�
 */
public class TitleChangeAction implements ActionListener {
	private BaosunBaoyi dialog;
	
	public TitleChangeAction(BaosunBaoyi dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if("��Ʒ����".equals(dialog.getComboDJLX1().getSelectedItem().toString())){
			dialog.getLabelTitle().setText("��Ʒ����");
			dialog.getLabelBSRQ().setText("�������ڣ�");
			dialog.getLabelDH();
			/*
			 * ���ñ��𵥾ݺ�
			 */
			{
				String num = DanJuHaoShuLiangGetDatas.baoSunNum();
//				System.out.println(num);
				try {
					dialog.getLabelDH().setText("BS" + DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyyMMdd") 
							+ num);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if("��Ʒ����".equals(dialog.getComboDJLX1().getSelectedItem().toString())){
			dialog.getLabelTitle().setText("��Ʒ����");
			dialog.getLabelBSRQ().setText("�������ڣ�");
			/*
			 * ���ñ��絥�ݺ�
			 */
			{
				String num = DanJuHaoShuLiangGetDatas.baoYiNum();
//				System.out.println(num);
				try {
					dialog.getLabelDH().setText("BY" + DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyyMMdd") 
							+ num);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

/*	public void itemStateChanged(ItemEvent e) {
		if((dialog.getComboDJLX().getSelectedItem().toString().trim()).equals("�� Ʒ �� ��")){
			dialog.getLabelTitle().setText("��Ʒ����");
			System.out.println("��Ʒ����");
		}
		else if((dialog.getComboDJLX().getSelectedItem().toString().trim()).equals("�� Ʒ �� ��")){
			dialog.getLabelTitle().setText("��Ʒ����");
			System.out.println("��Ʒ����");
		}		
	}*/

}
