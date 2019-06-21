package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin;

import java.util.Vector;

import javax.swing.JDialog;

import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * 将选择好的数据从数据库中查询出来
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
