package com.cn.control.richangframe.Salesman_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Salesman_Manage.JDBC_Log_salesman;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Log_Change;

public class Action_Log_Change implements ActionListener {
	private Salesman_Log_Change slc;
	public Action_Log_Change(Salesman_Log_Change slc) {
		this.slc = slc;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(slc.getTextArea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(slc, "日志内容不能为空！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//获取员工名称
			String yg_name = slc.getSm().getLabel_box_1()[0].getText().trim();
			//获取员工yg_id
			String yg_id = JDBC_Log_salesman.get_id_yg(yg_name).get(0).toString();
			//获取员工日志log
			Vector connect_yg = JDBC_Log_salesman.get_connect_yg(yg_id);
			int row = slc.getSm().getTable_tab_2().getSelectedRow();
			Vector v = (Vector)connect_yg.get(row);
			String str_date = v.get(0).toString();
			String str_text = v.get(1).toString();
			
			String to_date = slc.getDate().getSelectedItem().toString();
			String to_text = slc.getTextArea().getText();
			//修改数据
			JDBC_Log_salesman.change_yg_Connect(str_date,str_text, to_date, to_text);
			
			//获取修改之后的数据
			Vector connect_log_change = JDBC_Log_salesman.get_connect_yg(yg_id);
			slc.getSm().getTabelModel_tab_2().setDataVector(connect_log_change, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
			slc.dispose();
			
		}
		
		
	}

}
