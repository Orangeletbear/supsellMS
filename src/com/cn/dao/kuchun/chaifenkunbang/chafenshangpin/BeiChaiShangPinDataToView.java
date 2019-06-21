package com.cn.dao.kuchun.chaifenkunbang.chafenshangpin;

import com.cn.view.kuchunJFrame.ChaifenKunbang;

/**
 * 
 * 只根据输入框中的商品编号进行交互
 * @author Administrator
 *
 */
public class BeiChaiShangPinDataToView {
	private ChaifenKunbang dialog;
	
	public BeiChaiShangPinDataToView(ChaifenKunbang dialog){
		this.dialog = dialog;
	}
	

	public static Object[][] dataToView(String num){
		Object [][] datas = BeiChaiShangPinGetDatas.createSQL(num);
		return datas;
	}

	
/*	public static Object[][] dataToView(ChaifenKunbang dialog){
		Object [][] datas = BeiChaiShangPinGetDatas.createSQL(dialog.getTextBCSPBH().getText().trim());
		return datas;
	}
	*/
}
