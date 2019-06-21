package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info_kind;

public class Action_Select_sp implements ActionListener ,MouseListener{
	private Add_Quote_Goods adgs;
	public Action_Select_sp(Add_Quote_Goods adgs) {
		this.adgs = adgs;
	}

	public void actionPerformed(ActionEvent e) {
		if(adgs.getTable_tab_1().getSelectedRow() != -1){
			new Quote_sp_info(adgs,"报价商品信息",true);
			adgs.getTable_tab_1().getSelectionModel().clearSelection();
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			new Quote_sp_info(adgs,"报价商品信息",true);
			adgs.getTable_tab_1().getSelectionModel().clearSelection();
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
