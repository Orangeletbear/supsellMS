package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import com.cn.dao.richang.Guote_Manage.JDBC_Query_sp;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Quote_Manage;

public class Action_query_kind implements ActionListener {
	private Quote_Manage qm;
	public Action_query_kind(Quote_Manage qm) {
		this.qm = qm;
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() instanceof JButton){
			qm.getText_goods().setText("全部商品");
			String TEXT = qm.getText_goods().getText().trim();
			String str_date = qm.getDatepicker_1().getSelectedItem().toString().trim();
			String to_date = qm.getDatepicker_2().getSelectedItem().toString().trim();
			Vector v = JDBC_Query_sp.Query_sp_bj_kind(TEXT, str_date, to_date);
			qm.getTabelModel().setDataVector(v, 
					AllTableModel.getVectorFromObj(Guote_Manage_Model.table));
		}else{
			String TEXT = qm.getText_goods().getText().trim();
			String str_date = qm.getDatepicker_1().getSelectedItem().toString().trim();
			String to_date = qm.getDatepicker_2().getSelectedItem().toString().trim();
			Vector v = JDBC_Query_sp.Query_sp_bj_kind(TEXT, str_date, to_date);
			qm.getTabelModel().setDataVector(v, 
					AllTableModel.getVectorFromObj(Guote_Manage_Model.table));
		}
		
	}

}
