package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

/**
 * 商品报损报溢标题的改变
 */
public class TitleChangeAction implements ActionListener {
	private BaosunBaoyi dialog;
	
	public TitleChangeAction(BaosunBaoyi dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if("商品报损".equals(dialog.getComboDJLX1().getSelectedItem().toString())){
			dialog.getLabelTitle().setText("商品报损");
			dialog.getLabelBSRQ().setText("报损日期：");
			dialog.getLabelDH();
			/*
			 * 设置报损单据号
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
		
		if("商品报溢".equals(dialog.getComboDJLX1().getSelectedItem().toString())){
			dialog.getLabelTitle().setText("商品报溢");
			dialog.getLabelBSRQ().setText("报溢日期：");
			/*
			 * 设置报溢单据号
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
		if((dialog.getComboDJLX().getSelectedItem().toString().trim()).equals("商 品 报 损")){
			dialog.getLabelTitle().setText("商品报损");
			System.out.println("商品报损");
		}
		else if((dialog.getComboDJLX().getSelectedItem().toString().trim()).equals("商 品 报 溢")){
			dialog.getLabelTitle().setText("商品报溢");
			System.out.println("商品报溢");
		}		
	}*/

}
