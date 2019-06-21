package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info_change;

public class Action_sp_info_change implements ActionListener {
	private Quote_sp_info_change qsic;
	public Action_sp_info_change(Quote_sp_info_change qsic) {
		this.qsic = qsic;
	}

	public void actionPerformed(ActionEvent e) {
		String[][] spbj = new String[][] {{
			qsic.getId().getText().trim(), 
			qsic.getname().getText().trim(),
			qsic.getGhsbj().getText().trim(),
			qsic.getWfbj().getText().trim()
	}};
		int row = qsic.getAqgs().getTable_right_tab().getSelectedRow();
		Vector v = qsic.getAqgs().getTabelModel_table_right().getDataVector();
//		v.set(row, AllTableModel.getVectorDataFromObj(spbj));
//		v.removeAll((Vector) v.get(row));
		qsic.getAqgs().getTabelModel_table_right().removeRow(row);
	//添加数据到原来的data
		qsic.getAqgs().getTabelModel_table_right().getDataVector().addAll(AllTableModel.getVectorDataFromObj(spbj));
	//将数据放入表中
		qsic.getAqgs().getTabelModel_table_right().setDataVector(v, 
			AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		qsic.dispose();

	}

}
