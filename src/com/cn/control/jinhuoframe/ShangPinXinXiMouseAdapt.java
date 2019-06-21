package com.cn.control.jinhuoframe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;

/**
 * 增加商品（采购进货）中两个表格所触发的mouse事件
 * 
 * @author Administrator
 *
 */
public class ShangPinXinXiMouseAdapt extends MouseAdapter {
	AddShangPingDialog dialog;
	
	public ShangPinXinXiMouseAdapt(AddShangPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			int tmp = dialog.getSplbtable().getSelectedRow();
			String spID = (String)dialog.getATM().getValueAt(tmp, 0);
			new  ShangPinXinXi(dialog,"商品信息（采购进货）",true);
		}
	} 

}
