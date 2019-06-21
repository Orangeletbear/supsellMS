package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chaxunshangpin;

import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * 通过商品编号和商品名称模糊查询来查询符合要求的商品信息
 * @author Administrator
 *
 */
public class ChaXunShangPinDataToView {
	
	private AddSanPingDialog dialog;
	
	public ChaXunShangPinDataToView(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public static Object[][] dataToView(AddSanPingDialog dialog){
		
		Object [][]datas = ChaXunShangPinGetDatas.createSQL(dialog.getSpbhfield().getText().trim());
		
		return datas;
		
	}
	
}
