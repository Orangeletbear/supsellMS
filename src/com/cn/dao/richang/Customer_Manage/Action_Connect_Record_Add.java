package com.cn.dao.richang.Customer_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Connect_Record_Add;

public class Action_Connect_Record_Add implements ActionListener {
	private Customer_Connect_Record_Add ccra;
	public Action_Connect_Record_Add(Customer_Connect_Record_Add ccra) {
		this.ccra = ccra;
	}

	public void actionPerformed(ActionEvent e) {
		Object select_people = ccra.getComboBox_jbr().getSelectedItem();
		if( select_people == null){
			JOptionPane.showMessageDialog(ccra, "经办人不能为空！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else if(ccra.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(ccra, "联系内容不能为空！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			
			//客户名称kh_name
			String kh_name = ccra.getcm().getLabel_box_1()[0].getText().trim();
			//客户kh_id
			String kh_id = JDBC_Connect_Record.get_kh_ID(kh_name).get(0).toString();
			//联系日期
			String date = ccra.getComboBox_date().getSelectedItem().toString();
			//联系内容
			String textarea = ccra.getTextarea().getText();
			//经办人
			String jbr = ccra.getComboBox_jbr().getSelectedItem().toString();
			
			//将数据插入到数据库
			JDBC_Connect_Record.Insert_kh_CONNECT(kh_id, date, textarea, jbr);
			//从数据库中查询插入后的数据
			Vector connect_kh = JDBC_Connect_Record.get_connect_kh(kh_id);
			//将数据插入到表格中
			ccra.getcm().getTabelModel_split_2_tab_2().setDataVector(connect_kh, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
			
			ccra.dispose();
		}

	}

}
