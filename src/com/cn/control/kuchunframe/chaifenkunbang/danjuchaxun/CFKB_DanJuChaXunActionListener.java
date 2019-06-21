package com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.CFKB_ChaXunGetDatas;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.CFKBModel;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class CFKB_DanJuChaXunActionListener extends MouseAdapter implements ActionListener {
	private ChaifenKunbang dialog;	
	public CFKB_DanJuChaXunActionListener(ChaifenKunbang dialog) {
		this.dialog  = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		/*
		 * �ܵ���ѯ
		 */
		Vector vo1 = new Vector();
		try {
			vo1 = CFKB_ChaXunGetDatas.chaxunZongDan(dialog.getTextSPBH().getText().trim(),
					DateConventer.dateToStr(dialog.getDateFrom().getSelectedDate(),"yyyy-MM-dd"),
					DateConventer.dateToStr(dialog.getDateTo().getSelectedDate(),"yyyy-MM-dd"),
					dialog.getComboDJLX().getSelectedItem().toString());
			dialog.getLabelDJHJ().setText("" + vo1.size());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * ��ͬ���͵Ĳ���
		 */
		if(dialog.getComboDJLX().getSelectedItem().toString().equals("��Ʒ���")){
			dialog.getTableModel4().setDataVector(vo1, 
					AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB4));
			
		}
		
		if(dialog.getComboDJLX().getSelectedItem().toString().equals("��Ʒ����")){
			dialog.getTableModel4().setDataVector(vo1, 
					AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB6));
		}
		
	}
	public void mouseClicked(MouseEvent e){
		Vector vo1 = new Vector();
		int row = dialog.getTableCFKB4().getSelectedRow();
		if(row >= 0){
			String id = dialog.getTableCFKB4().getValueAt(row, 0).toString();
			String lx = dialog.getComboDJLX().getSelectedItem().toString();
			//���õ��ݺ�
			dialog.getLabelDJXX().setText(dialog.getTableCFKB4().getValueAt(row, 0).toString());
			vo1 = CFKB_ChaXunGetDatas.shangPinChaXun(id,lx);
			dialog.getTableModel5().setDataVector(vo1, dialog.getVe5());
			//������Ʒ����
			dialog.getLabelSPHJ().setText("" + vo1.size());
		}
	}
}
