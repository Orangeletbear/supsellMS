package com.cn.control.kuchunframe.kucunpandian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.kucunpandian.KucunPandianPutinDatabase;
import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;

public class ShangPinPanDianShuJuLuRuAction implements ActionListener{
	private XinZengPanDianDanJDialog dialog;
	
	public ShangPinPanDianShuJuLuRuAction(XinZengPanDianDanJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		//盘点单录入
		Vector vo = new Vector();
		vo.add(dialog.getLabelPDDH().getText());
		vo.add(dialog.getComboPDCK().getSelectedItem().toString());
		try {
			vo.add(DateConventer.dateToStr(dialog.getDatePDRQ().getSelectedDate(),"yyyy-MM-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo.add("");
		vo.add(dialog.getLabelCZY().getText());
		//获取表格中的信息
		int rows = dialog.getTableYPSP().getRowCount(); //商品记录行数
		vo.add(rows);
		int count = 0;
		for(int i = 0 ; i < rows; i ++){
			count = 0 + new Integer(dialog.getTableYPSP().getValueAt(i, 5).toString());
		}
		vo.add(count);
		vo.add(dialog.getLabelBZ().getText());
		
		
		////盘点商品录入
		Vector vo2 = new Vector();
		for(int i = 0; i < rows; i ++){
			Vector vo1 = new Vector();
			vo1.add(dialog.getTableYPSP().getValueAt(i, 0));
			vo1.add(dialog.getLabelPDDH().getText());
			vo1.add(dialog.getTableYPSP().getValueAt(i, 5));
			vo1.add(dialog.getTableYPSP().getValueAt(i, 5));
			
			vo2.add(vo1);
		}
		
		/*
		 * 如果盘点单或盘点商品为空则不能录入
		 */
		if(vo.size()!= 0 && vo2.size() != 0){
			KucunPandianPutinDatabase.insertZongDan(vo);//盘点单插入
			KucunPandianPutinDatabase.insertShangPin(vo2);//商品信息插入
			
			Vector vo0 = KunCunPanDianChaXunGetDatas.panDianDanjuChaXun(dialog.getLabelPDDH().getText().trim());
			dialog.getDialog().getTablemodelPD1().setDataVector(vo0, dialog.getDialog().getVe1());
			
			dialog.getDialog().getLabelHJ1().setText("" + 1);
			dialog.dispose();
		}
	}
	
}
