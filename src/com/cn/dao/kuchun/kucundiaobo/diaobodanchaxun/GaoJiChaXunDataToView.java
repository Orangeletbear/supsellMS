package com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun;

import java.util.Vector;

import com.cn.view.kuchunJFrame.kucunDiaobo.GaojiChaxunDialog;

/*
 * 高级查询中获取界面信息和获得数据库交互的结果
 */
public class GaoJiChaXunDataToView {
	private GaojiChaxunDialog dialog;
	
	public GaoJiChaXunDataToView(GaojiChaxunDialog dialog) {
		this.dialog = dialog;
	}
	
	public static Vector dataToView(GaojiChaxunDialog dialog){
		Vector vo = DiaoBoDanChaXunGetDatas.createSQL(dialog.getComboDCCK().getSelectedItem().toString(),
				dialog.getComboDRCK().getSelectedItem().toString(), dialog.getComboJBR().getSelectedItem().toString()); 
		
		return vo;	
	}
}
