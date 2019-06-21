package com.cn.control.richangframe.Salesman_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Salesman_Manage.JDBC_Log_salesman;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Log_Add;

public class Action_Log_Add implements ActionListener {
	private Salesman_Log_Add sla;
	public Action_Log_Add(Salesman_Log_Add sla) {
		this.sla = sla;
	}

	public void actionPerformed(ActionEvent e) {
		if(sla.getTextArea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(sla, "日志内容不能为空！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//联系日期
			String date = sla.getDate().getSelectedItem().toString();
			//联系内容
			String textarea = sla.getTextArea().getText();
			//业务员id
			String name = sla.getSm().getLabel_box_1()[0].getText();
			String id = JDBC_Log_salesman.get_id_yg(name).get(0).toString();
			//将数据插入到数据库
			JDBC_Log_salesman.Insert_yg_LOG(id, date, textarea);
			
			//从数据库中查询插入后的数据
			Vector connect_yg = JDBC_Log_salesman.get_connect_yg(id);
			//将数据插入到表格中
			sla.getSm().getTabelModel_tab_2().setDataVector(connect_yg, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
			
			sla.dispose();
		}
	}
}
