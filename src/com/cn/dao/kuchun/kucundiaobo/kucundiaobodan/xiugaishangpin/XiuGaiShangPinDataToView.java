package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.xiugaishangpin;

import java.util.Vector;

import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * 商品修改对话框数据交互
 * 
 * 根据输入的商品名称进行查询，带完善
 * @author Administrator
 *
 */
public class XiuGaiShangPinDataToView {
	private KucunDiaobo dialog;
	
	public XiuGaiShangPinDataToView(KucunDiaobo dialog) {
		this.dialog = dialog;
	}
	
	public static Vector dataToview(String name,String num){
		Vector vo = XiuGaiShangPinGetdatas.getDatas(name,num);
		
		return vo;
	}
}
