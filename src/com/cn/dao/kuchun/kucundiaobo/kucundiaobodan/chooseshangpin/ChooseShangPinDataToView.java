package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin;

import java.util.Vector;

import javax.swing.JDialog;

import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * ��ѡ��õ����ݴ����ݿ��в�ѯ����
 * @author Administrator
 *
 */
public class ChooseShangPinDataToView {
	
	private AddShangPinXinXiDialog dialog;
//	private JDialog dialog;
	
	public ChooseShangPinDataToView(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}

	public static Vector dataToView(AddShangPinXinXiDialog dialog){
		String id = dialog.getLabelSPBH().getText().trim();
		String num = dialog.getTextDBSL().getText().toString().trim();
		
		Vector datas = ChooseShangPinGetDatas.getDatas(id,num);
		return datas;
	}
}
