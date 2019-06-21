package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.baosunbaoyi.BaosunBaoyiPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.mainJFrame.MainFrame;

/**
 * 将报损报溢中的信息录入
 * @author Administrator
 *
 */
public class BaoSunBaoYiShuJuLuRuAction implements ActionListener {
	private BaosunBaoyi dialog;
	public BaoSunBaoYiShuJuLuRuAction(BaosunBaoyi dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		//报损报溢单录入
		Vector vo1 = new Vector();
		//(单号 , 仓库名, 日期,经办人, 操作员,备注 )
		String djlx = dialog.getComboDJLX1().getSelectedItem().toString();//单据类型
		vo1.add(dialog.getLabelDH().getText().toString());
		vo1.add(dialog.getComboCKMC().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getComboJBR().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser().toString());
		vo1.add(dialog.getTextBZ().getText());
		
		
		//报损报溢商品录入
		//( 商品号, 单号(FK), 数量, 总金额 )
		Vector vo2 = new Vector();
		
		int row = dialog.getTableBSBY1().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableBSBY1().getValueAt(i, 0));
			ve.add(dialog.getLabelDH().getText().toString());
			ve.add(dialog.getTableBSBY1().getValueAt(i, 4));//单价
			ve.add(dialog.getTableBSBY1().getValueAt(i, 5));//数量
			vo2.add(ve);
		}
		
		//报损报溢数据更新
		String []nameVo = new String [row];
		String []numVo = new String [row];
		
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableBSBY1().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableBSBY1().getValueAt(i, 5).toString();
		}
		
		BaosunBaoyiPutinDatabase.insertZongDan(vo1, djlx);//录入报损报溢总单
		BaosunBaoyiPutinDatabase.insertShangPin(vo2, djlx);//录入报损报溢商品
		BaosunBaoyiPutinDatabase.updatas(nameVo, numVo, djlx);//更新数据库
		
		dialog.getTableModel1().setDataVector(null, dialog.getVe1());
		dialog.getVector1().removeAllElements();
		dialog.getVector2().removeAllElements();
	}
}
