package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.richang.Guote_Manage.JDBC_Select_sp;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;

public class Action_Guote_Tree implements MouseListener {
	private Add_Quote_Goods aqgs;
	public Action_Guote_Tree(Add_Quote_Goods aqgs) {
		this.aqgs = aqgs;
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1){
     	  String TEXT = aqgs.getTree_tab_1().getLastSelectedPathComponent().toString().trim();
     	  Vector v = JDBC_Select_sp.get_select_sp_kind(TEXT);
     	 aqgs.getData_left_tab_2().addAll(v);
     	  aqgs.getTabelModel_table_tab_2().setDataVector(v, AllTableModel.getVectorFromObj(Guote_Manage_Model.left_table_tab_2));
     	  
     	  aqgs.getText_name_id().getDocument().addDocumentListener(new Action_sp_tab_2(aqgs,TEXT));
     	  aqgs.getAdd_selected_goods().addActionListener(new Action_Select_sp_kind(aqgs));
     	  aqgs.getTable_tab_2().addMouseListener(new Action_Select_sp_kind(aqgs));
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
