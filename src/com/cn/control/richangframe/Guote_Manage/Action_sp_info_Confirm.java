package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;
import com.cn.view.richangJFrame.Guote_Manage.Quote_sp_info;

public class Action_sp_info_Confirm implements ActionListener
		{
	private Add_Quote_Goods aqgs;
	private Quote_sp_info qsi;
	public Action_sp_info_Confirm(Quote_sp_info qsi) {
		this.qsi = qsi;
	}

	public void actionPerformed(ActionEvent e) {
		String[][] spbj = new String[][] {{
				qsi.getId().getText().trim(), 
				qsi.getname().getText().trim(),
				qsi.getGhsbj().getText().trim(),
				qsi.getWfbj().getText().trim()
		}};
		//添加数据到原来的data
		qsi.getAqgs().getTabelModel_table_right().getDataVector().addAll(AllTableModel.getVectorDataFromObj(spbj));
		//将数据放入表中
		qsi.getAqgs().getTabelModel_table_right().setDataVector(qsi.getAqgs().getTabelModel_table_right().getDataVector(), 
				AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
		qsi.dispose();
	}
}
