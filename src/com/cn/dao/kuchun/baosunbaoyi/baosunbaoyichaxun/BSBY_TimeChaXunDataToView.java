package com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun;

import java.text.ParseException;
import java.util.Vector;

import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

public class BSBY_TimeChaXunDataToView {

	private BaosunBaoyi dialog;
	
	public BSBY_TimeChaXunDataToView(BaosunBaoyi dialog) {
		this.dialog = dialog;
	}
	
	public static Vector dataToView(BaosunBaoyi dialog){
		Vector vo = new Vector();
		try {
			vo = BaosunBaoyiChaXunGetDatas.timeChaxun(DateConventer.dateToStr(
					dialog.getDateFrom().getSelectedDate(), "yyyy-MM-dd"),
					  DateConventer.dateToStr(dialog.getDateTo().getSelectedDate(), "yyyy-MM-dd"),
					    dialog.getComboDJLX2().getSelectedItem().toString());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
