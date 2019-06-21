package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.DiaoBoDanPutinDataBase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.mainJFrame.MainFrame;

/**
 * 
 * 将选好的调拨商品进行调拨，设置调拨单号，再将调拨单号存储在数据库中
 * 录入需要存储在数据库中的数据
 * @author Administrator
 */
public class DiaoBoShuJuLuRuAction implements ActionListener {
	
	private KucunDiaobo dialog;
	
	public DiaoBoShuJuLuRuAction (KucunDiaobo dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		//调拨单录入
		/*
		 * --( 商品号,单号(FK), 数量, 总金额 )
--( ID,  调出库  , 调入库,  日期,  经办人, 操作员,备注 )
		 */
		Vector vo = new Vector();
		vo.add(dialog.getLabelDBDH().getText().toString());
		vo.add(dialog.getComboDCCK().getSelectedItem().toString());
		vo.add(dialog.getComboDRCK().getSelectedItem().toString());
		//============================
		System.out.println(dialog.getComboDCCK().getSelectedItem().toString() + "===========");
		System.out.println(dialog.getComboDRCK().getSelectedItem().toString());
		
		try {
			vo.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo.add(dialog.getComboJBR().getSelectedItem().toString());
		vo.add(dialog.getFrame().getUser().toString());
		vo.add(dialog.getTextBZ().getText());
		
		//调拨商品录入
		Vector voe = new Vector();
		
		int row = dialog.getTableKCDB1().getRowCount();
//		int column = dialog.getTableKCDB1().getColumnCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableKCDB1().getValueAt(i, 0));
			ve.add(dialog.getLabelDBDH().getText().toString());
			ve.add(dialog.getTableKCDB1().getValueAt(i, 5));
			ve.add(dialog.getTableKCDB1().getValueAt(i, 6));
			voe.add(ve);
		}
		//商品数据库更新
		String []nameVo = new String [row];
		String []numVo = new String [row];
		
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableKCDB1().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableKCDB1().getValueAt(i, 5).toString();
		}
		
		
		DiaoBoDanPutinDataBase.insertDiaoboDan(vo);
		DiaoBoDanPutinDataBase.insertDiaoBoShangPin(voe);
		DiaoBoDanPutinDataBase.updatas(nameVo, numVo);
		
		dialog.getTableModel1().setDataVector(null, dialog.getVe1());//数据提交后，窗口置空
		dialog.getVector1().removeAllElements();
	}

}
