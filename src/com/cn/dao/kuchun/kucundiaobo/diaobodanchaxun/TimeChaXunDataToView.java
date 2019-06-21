package com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun;

import java.text.ParseException;
import java.util.Vector;

import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * ͨ��ʱ��β�ѯ������Ʒ������Ϣ
 * @author Administrator
 *
 */
public class TimeChaXunDataToView {
	private KucunDiaobo dialog;
	
	public TimeChaXunDataToView(KucunDiaobo dialog) {
		this.dialog = dialog;
	}
	
	public static Vector dataToView(KucunDiaobo dialog){
		Vector vo = new Vector();
		try {
			vo = DiaoBoDanChaXunGetDatas.timeChaxun(DateConventer.dateToStr(
					dialog.getDateFrom().getSelectedDate(), "yyyy-MM-dd"),
					DateConventer.dateToStr(
							dialog.getDateTo().getSelectedDate(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
