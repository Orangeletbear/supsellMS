package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info_kind;

public class Action_sp_info_kind_Confirm implements ActionListener
		{
	private Quote_sp_info_kind qsik;

	public Action_sp_info_kind_Confirm(Quote_sp_info_kind qsik) {
		this.qsik = qsik;
	}

	public void actionPerformed(ActionEvent e) {
		String[][] spbj = new String[][] {{
				qsik.getId().getText().trim(), 
				qsik.getname().getText().trim(),
				qsik.getWfbj().getText().trim(),
				qsik.getWfbj().getText().trim()
		}};
		//添加数据到原来的data
		qsik.getAqgs().getTabelModel_table_right().getDataVector().addAll(AllTableModel.getVectorDataFromObj(spbj));
		//将数据放入表中
		qsik.getAqgs().getTabelModel_table_right().setDataVector(qsik.getAqgs().getTabelModel_table_right().getDataVector(), 
				AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		qsik.dispose();
	}
}
