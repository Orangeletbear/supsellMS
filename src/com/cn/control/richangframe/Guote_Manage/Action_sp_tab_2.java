package com.cn.control.richangframe.Guote_Manage;

import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.richang.Guote_Manage.JDBC_Guote_Manage;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;

public class Action_sp_tab_2 implements DocumentListener {
	private Add_Quote_Goods aqgs;
	private String kind;
	public Action_sp_tab_2(Add_Quote_Goods aqgs,String kind) {
		this.aqgs = aqgs;
		this.kind = kind;
	}

	//直接修改JTextField的反应
	public void changedUpdate(DocumentEvent e) {
		if(aqgs.getText_name_id().getText().length() >=1){
			Vector v = JDBC_Guote_Manage.get_sp_select_kind(aqgs.getText_name_id().getText().trim(),kind);
			aqgs.getTabelModel_table_tab_2().setDataVector(v, 
					AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		}
	}
	//在JTextField插入数值时的反应
	public void insertUpdate(DocumentEvent arg0) {
		if(aqgs.getText_name_id().getText().length() >=1){
//			JDBC_Guote_Manage.get_sp_select(aqgs.getText_name_id().getText().trim());
			Vector v = JDBC_Guote_Manage.get_sp_select_kind(aqgs.getText_name_id().getText().trim(),kind);
			aqgs.getTabelModel_table_tab_2().setDataVector(v, 
					AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		}
		
	}
	//在JTextField删除数值时的反应
	public void removeUpdate(DocumentEvent arg0) {
		if(aqgs.getText_name_id().getText().length() >=1){
//			JDBC_Guote_Manage.get_sp_select(aqgs.getText_name_id().getText().trim());
			Vector v = JDBC_Guote_Manage.get_sp_select_kind(aqgs.getText_name_id().getText().trim(),kind);
			aqgs.getTabelModel_table_tab_2().setDataVector(v, 
					AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		}
		
	}
}
