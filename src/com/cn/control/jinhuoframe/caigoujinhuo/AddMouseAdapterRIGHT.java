package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

/**
 * 双击  增加商品  中右边表格内数据，所出现的鼠标事件
 * @author Administrator
 */
public class AddMouseAdapterRIGHT extends MouseAdapter{

	private AddShangPingDialog addShang;
	
	
	public AddMouseAdapterRIGHT (AddShangPingDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  ShangPinXinXi2(addShang,"商品信息（采购进货）",true);
			}
		} 

}
