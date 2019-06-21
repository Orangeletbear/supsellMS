package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info_kind;

public class Action_Select_sp_kind implements ActionListener, MouseListener {
	private Add_Quote_Goods aqgs;
	public Action_Select_sp_kind(Add_Quote_Goods aqgs) {
		this.aqgs = aqgs;
	}

	public void actionPerformed(ActionEvent e) {
		if(aqgs.getTable_tab_2().getSelectedRow() != -1){
			new Quote_sp_info_kind(aqgs,"报价商品信息",true);
			aqgs.getTable_tab_2().getSelectionModel().clearSelection();
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			new Quote_sp_info_kind(aqgs,"报价商品信息",true);
			aqgs.getTable_tab_2().getSelectionModel().clearSelection();
		}

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
