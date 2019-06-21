package com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinPutinDatabase;
import com.cn.dao.kuchun.chaifenkunbang.kunbangshangpin.KunBangShangPinPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

/**
 * 捆绑商品数据录入，更新商品库存
 * @author Administrator
 *
 */
public class KunBangShuJuLuRuActions implements ActionListener{
	
	private ChaifenKunbang dialog;
	
	public KunBangShuJuLuRuActions(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		//捆绑单录入
		//( 捆绑单号 , 捆绑库, 日期,捆绑成商品, 绑成数量, 经办人, 操作员, 备注 )
		Vector vo1 = new Vector();
		vo1.add(dialog.getLabelKBDH().getText());
		vo1.add(dialog.getComboKBCK().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate2().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getLabelKBSP().getText());
		vo1.add(dialog.getTextKBSL().getText());
		vo1.add(dialog.getComboJBR2().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser());//操作员
		vo1.add(dialog.getTextBZ2().getText());
		
		
		//拆分商品录入
		//( 商品号, 单号(FK), 数量, 总金额 )
		Vector vo2 = new Vector();
		int row = dialog.getTableKB().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableKB().getValueAt(i, 0));
			ve.add(dialog.getLabelKBDH().getText().toString());
			ve.add(dialog.getTableKB().getValueAt(i, 5));//数量
			ve.add(dialog.getTableKB().getValueAt(i, 6));//金额
			vo2.add(ve);
		}
		
		//报损报溢数据更新
		//被拆商品减少
		String bcmc = dialog.getLabelKBSP().getText();
		String bcsl = dialog.getTextKBSL().getText().trim();
		
		//被拆成的商品数量增加
		String []nameVo = new String [row];
		String []numVo = new String [row];
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableKB().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableKB().getValueAt(i, 5).toString();
		}
		
		
		KunBangShangPinPutinDatabase.putinKunbangZongdan(vo1);//捆绑总单录入
		KunBangShangPinPutinDatabase.putinKunbangXiangbiao(vo2);//捆绑商品录入
		KunBangShangPinPutinDatabase.updatas1(bcmc, bcsl);//被捆绑成的商品更新
		KunBangShangPinPutinDatabase.updatas2(nameVo, numVo);//被捆绑的商品更新
		
		//表格数据置空
		dialog.getTableModelKB().setDataVector(null, dialog.getVe2());
		//存储数据的vector置空
		dialog.getVector2().removeAllElements();
	}
	
	
}
