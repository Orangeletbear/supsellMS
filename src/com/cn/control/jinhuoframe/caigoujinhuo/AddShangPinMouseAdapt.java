package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;

/**
 * 双击  增加商品  中左边表格内数据，所出现的鼠标事件
 * @author Administrator
 */
public class AddShangPinMouseAdapt extends MouseAdapter{

	private AddShangPingDialog addShang;
	
	
	public AddShangPinMouseAdapt (AddShangPingDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  ShangPinXinXi(addShang,"商品信息（采购进货）",true);
			}
		} 

}
