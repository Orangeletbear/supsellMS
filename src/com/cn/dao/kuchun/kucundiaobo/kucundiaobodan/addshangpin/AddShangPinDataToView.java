package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin;

import java.util.Vector;

//import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;


public class AddShangPinDataToView {

	public static Object[][] dataToView(String name){
		Object[][] datas = AddShangPinGetDatas.createSQL(name);
		
		return datas;
	}
}
