package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;

/**
 * 顾客退货选项卡中的添加退货商品
 * 对话框上的表所对应的鼠标事件按钮
 * @author Administrator
 *
 */
public class AddTuiHuoGoodsMouseAdapt extends MouseAdapter{

	private AddTuiHuoGoodsDialog addShang;

	
	public AddTuiHuoGoodsMouseAdapt (AddTuiHuoGoodsDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  GoodsInfoDialog(addShang,"商品信息(销售退货)");
				
			}
		} 



}
