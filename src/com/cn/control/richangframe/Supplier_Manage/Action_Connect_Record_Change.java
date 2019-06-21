package com.cn.control.richangframe.Supplier_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Supplier_Manage.JDBC_Connect_Record;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Connect_Record_Change;

public class Action_Connect_Record_Change implements ActionListener {
	private Supplier_Connect_Record_Change scrc;
	public Action_Connect_Record_Change(
			Supplier_Connect_Record_Change scrc) {
		this.scrc = scrc;
	}

	public void actionPerformed(ActionEvent e) {
		//供货商名称ghs_name
		String ghs_name = scrc.getSm().getLabel_box_1()[0].getText().trim();
		//供货商ghs_id
		String ghs_id = JDBC_Connect_Record.get_GHS_ID(ghs_name).get(0).toString();
		
		Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(ghs_id);
		Vector select_row = (Vector)connect_ghs.get(scrc.getSm().getTable_right_tab_2().getSelectedRow());
		String str_text = select_row.get(1).toString();
		String str_jbr = select_row.get(2).toString();
		if(scrc.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(scrc, "联系内容不能为空！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//联系日期
			String to_date = scrc.getComboBox_date().getSelectedItem().toString();
			//练习内容
			String to_text = scrc.getTextarea().getText();
			//经办人
			String to_jbr = scrc.getComboBox_jbr().getSelectedItem().toString();
			//修改数据
			JDBC_Connect_Record.change_GHS_Connect(str_text, str_jbr, to_date, to_text, to_jbr);
			
			//从数据库中查询修改后的数据
			Vector connect_ghs_change = JDBC_Connect_Record.get_connect_ghs(ghs_id);
			//将数据插入到表格中
			scrc.getSm().getTabelModel_right_tab_2().setDataVector(connect_ghs_change, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
			
			scrc.dispose();
		}
	}

}
