package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin;

import java.util.Vector;

import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

public class JRSX_ShangPinDataToView {
	private AddSanPingDialog dialog;
	
	public JRSX_ShangPinDataToView(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public static Vector dataToView(AddSanPingDialog dialog){
		
		Vector datas = JRSX_ShangPinGetDatas.createSQL(dialog.getSpbhfield().getText().trim());
		
		return datas;
		
	}
}
