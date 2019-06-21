package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.PutinDiaoBoDan;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * 
 * ��ѡ�õĵ�����Ʒ���е��������õ������ţ��ٽ��������Ŵ洢�����ݿ���
 * @author Administrator
 */
public class InsertDiaoBoDanAction implements ActionListener {
	
	private KucunDiaobo dialog;
	
	public InsertDiaoBoDanAction (KucunDiaobo dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		//������¼��
		Vector vo = new Vector();
		vo.add(dialog.getLabelDBDH().getText().toString());
		vo.add(dialog.getComboDCCK().getSelectedItem().toString());
		vo.add(dialog.getComboDRCK().getSelectedItem().toString());
		
		try {
			vo.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	
		vo.add(dialog.getComboJBR().getSelectedItem().toString());
		vo.add(dialog.getTextBZ().getText());
		
		//������Ʒ¼��
		Vector voe = new Vector();
		
		int row = dialog.getTableKCDB1().getRowCount();
		int column = dialog.getTableKCDB1().getColumnCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableKCDB1().getValueAt(i, 0));
			ve.add(dialog.getLabelDBDH().getText().toString());
			ve.add(dialog.getTableKCDB1().getValueAt(i, 5));
			ve.add(dialog.getTableKCDB1().getValueAt(i, 6));
			System.out.println(ve.size());
			voe.add(ve);
			System.out.println(voe.size());
		}
		
		PutinDiaoBoDan.insertDiaoboDan(vo);
		PutinDiaoBoDan.insertDiaoBoShangPin(voe);
	}

}
