package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info_change;

public class Action_Select_change_del implements ActionListener ,MouseListener{
	private Add_Quote_Goods adgs;
	public static int row;
	public Action_Select_change_del(Add_Quote_Goods adgs) {
		this.adgs = adgs;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adgs.getChange()){
			if(adgs.getTable_right_tab().getSelectedRow() != -1){
				row = adgs.getTable_right_tab().getSelectedRow();
				new Quote_sp_info_change(adgs,"报价商品信息",true);
			}
		}
		if(e.getSource() == adgs.getDelete()){
			if(adgs.getTable_right_tab().getSelectedRow() != -1){
				int i = JOptionPane.showConfirmDialog(adgs, "是否要删除该商品信息！", "系统信息", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
				if(i == JOptionPane.YES_OPTION){
					adgs.getTabelModel_table_right().removeRow(adgs.getTable_right_tab().getSelectedRow());
				}
			}
		}
		
		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			row = adgs.getTable_right_tab().getSelectedRow();
			new Quote_sp_info_change(adgs,"报价商品信息",true);
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
