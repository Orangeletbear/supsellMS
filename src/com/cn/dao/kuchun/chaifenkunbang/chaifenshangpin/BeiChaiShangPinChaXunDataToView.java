package com.cn.dao.kuchun.chaifenkunbang.chaifenshangpin;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chaxunshangpin.ChaXunShangPinGetDatas;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;

public class BeiChaiShangPinChaXunDataToView {
	
	private BeiChaiShangPinFindJWindow dialog;
	
	public BeiChaiShangPinChaXunDataToView(BeiChaiShangPinFindJWindow dialog){
		this.dialog = dialog;
	}
	
	public static Object[][] dataToView(BeiChaiShangPinFindJWindow dialog){
		
		Object [][]datas = ChaXunShangPinGetDatas.createSQL(dialog.getTextSPCX().getText().trim());
		
		return datas;
		
	}
	
	
}
