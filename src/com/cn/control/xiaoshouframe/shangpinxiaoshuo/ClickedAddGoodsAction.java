package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;
/**
 * 双击增加商品（商品销售）
 * 对话框左边表格对应的监听器
 * @author Administrator
 *
 */
public class ClickedAddGoodsAction extends MouseAdapter {

	private AddXiaoShouGoodsDialog addGoods;

	
	public ClickedAddGoodsAction (AddXiaoShouGoodsDialog addGoods){
		this.addGoods = addGoods;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  XiaoShouGoodsInfo(addGoods,"商品信息(商品销售)");
				
			}
		} 

}
