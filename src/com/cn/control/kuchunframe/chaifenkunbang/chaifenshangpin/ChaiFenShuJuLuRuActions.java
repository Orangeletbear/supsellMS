package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class ChaiFenShuJuLuRuActions implements ActionListener{
	private ChaifenKunbang dialog;
	public ChaiFenShuJuLuRuActions(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		//拆分单录入
		//( 拆分单号 , 拆分库, 日期, 被拆商品编号, 拆分数量, 经办人, 操作员,备注 )
		Vector vo1 = new Vector();
		vo1.add(dialog.getLabelCFDH().getText());
		vo1.add(dialog.getComboCFCK().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getLabelBCSPMC1().getText());
		vo1.add(dialog.getTextCFSL().getText());
		vo1.add(dialog.getComboJBR1().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser());//操作员
		vo1.add(dialog.getTextBZ1().getText());
		
		
		//拆分商品录入
		//( 商品号, 单号(FK), 数量, 总金额 )
		Vector vo2 = new Vector();
		int row = dialog.getTableCF().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableCF().getValueAt(i, 0));
			ve.add(dialog.getLabelCFDH().getText().toString());
			ve.add(dialog.getTableCF().getValueAt(i, 5));//数量
			ve.add(dialog.getTableCF().getValueAt(i, 6));//金额
			vo2.add(ve);
		}
		
		//报损报溢数据更新
		//被拆商品减少
		String bcmc = dialog.getLabelBCSPMC1().getText();
		String bcsl = dialog.getTextCFSL().getText().trim();
		
		//被拆成的商品数量增加
		String []nameVo = new String [row];
		String []numVo = new String [row];
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableCF().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableCF().getValueAt(i, 5).toString();
		}
		
		
		ChaiFenShangPinPutinDatabase.putinChaifenZongdan(vo1);//拆分总单录入
		ChaiFenShangPinPutinDatabase.putinChaifenXiangbiao(vo2);//拆分商品录入
		ChaiFenShangPinPutinDatabase.updatas1(bcmc, bcsl);//拆分的商品更新
		ChaiFenShangPinPutinDatabase.updatas2(nameVo, numVo);//被拆成的商品更新
		
		//表格中数据置空
		dialog.getTableModelCF().setDataVector(null, dialog.getVe1());
		//存储数据的vector置空
		dialog.getVector1().removeAllElements();
		}
}
