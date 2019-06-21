package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;
/**
 * 增加商品（商品销售）对话框左边表的
 * 双击时对应的鼠标事件
 * @author Administrator
 *
 */
public class AddXiaoShuoGoodsMouseAction extends MouseAdapter {
 
	private AddXiaoShouGoodsDialog addGoods;

	public AddXiaoShuoGoodsMouseAction (AddXiaoShouGoodsDialog addGoods){
		this.addGoods = addGoods;
	}
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  XiaoShouGoodsInfo2(addGoods,"商品信息(商品销售)");
				
			}
		} 
}
