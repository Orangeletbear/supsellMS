package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfo2Dialog;

/**
 * ˫����Ʒ���ӣ������˻���
 * �Ի����ұ߱������Ӧ�ļ�����
 * @author Administrator
 *
 */
public class AddTuiHuoGoodsMouseAction extends MouseAdapter {

	private AddTuiHuoGoodsDialog dialog;
	
	public AddTuiHuoGoodsMouseAction(AddTuiHuoGoodsDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			new GoodsInfo2Dialog(dialog,"��Ʒ��Ϣ");
		}
	}
}
