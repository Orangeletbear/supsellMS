package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.xiugaishangpin;

import java.util.Vector;

import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * ��Ʒ�޸ĶԻ������ݽ���
 * 
 * �����������Ʒ���ƽ��в�ѯ��������
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
