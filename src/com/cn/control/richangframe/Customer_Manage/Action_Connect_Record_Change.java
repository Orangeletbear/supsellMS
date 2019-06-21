package com.cn.control.richangframe.Customer_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Customer_Manage.JDBC_Connect_Record;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Connect_Record_Change;

public class Action_Connect_Record_Change implements ActionListener {
	private Customer_Connect_Record_Change ccrc;
	public Action_Connect_Record_Change(Customer_Connect_Record_Change ccrc) {
		this.ccrc = ccrc;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(ccrc.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(ccrc, "��ϵ���ݲ���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//�ͻ�����ghs_name
			String kh_name = ccrc.getcm().getLabel_box_1()[0].getText().trim();
			//�ͻ�kh_id
			String kh_id = JDBC_Connect_Record.get_kh_ID(kh_name).get(0).toString();
			
			Vector connect_kh = JDBC_Connect_Record.get_connect_kh(kh_id);
			Vector select_row = (Vector)connect_kh.get(ccrc.getcm().getTable_split_2_tab_2().getSelectedRow());
			String str_text = select_row.get(1).toString();
			String str_jbr = select_row.get(2).toString();
			//��ϵ����
			String to_date = ccrc.getComboBox_date().getSelectedItem().toString();
			//��ϰ����
			String to_text = ccrc.getTextarea().getText();
			//������
			String to_jbr = ccrc.getComboBox_jbr().getSelectedItem().toString();
			//�޸�����
			JDBC_Connect_Record.change_kh_Connect(str_text, str_jbr, to_date, to_text, to_jbr);
			
			//�����ݿ��в�ѯ�޸ĺ������
			Vector connect_kh_change = JDBC_Connect_Record.get_connect_kh(kh_id);
			//�����ݲ��뵽�����
			ccrc.getcm().getTabelModel_split_2_tab_2().setDataVector(connect_kh_change, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
			
			ccrc.dispose();
		}

	}

}
