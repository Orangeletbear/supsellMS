package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chaxunshangpin;

import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * ͨ����Ʒ��ź���Ʒ����ģ����ѯ����ѯ����Ҫ�����Ʒ��Ϣ
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
