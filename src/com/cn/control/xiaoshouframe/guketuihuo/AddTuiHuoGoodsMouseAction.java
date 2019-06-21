package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfo2Dialog;

/**
 * 双击商品增加（销售退货）
 * 对话框右边表格所对应的监听器
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
			new GoodsInfo2Dialog(dialog,"商品信息");
		}
	}
}
