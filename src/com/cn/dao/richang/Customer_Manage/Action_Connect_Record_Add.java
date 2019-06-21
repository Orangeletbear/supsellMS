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
			JOptionPane.showMessageDialog(ccra, "�����˲���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else if(ccra.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(ccra, "��ϵ���ݲ���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			
			//�ͻ�����kh_name
			String kh_name = ccra.getcm().getLabel_box_1()[0].getText().trim();
			//�ͻ�kh_id
			String kh_id = JDBC_Connect_Record.get_kh_ID(kh_name).get(0).toString();
			//��ϵ����
			String date = ccra.getComboBox_date().getSelectedItem().toString();
			//��ϵ����
			String textarea = ccra.getTextarea().getText();
			//������
			String jbr = ccra.getComboBox_jbr().getSelectedItem().toString();
			
			//�����ݲ��뵽���ݿ�
			JDBC_Connect_Record.Insert_kh_CONNECT(kh_id, date, textarea, jbr);
			//�����ݿ��в�ѯ����������
			Vector connect_kh = JDBC_Connect_Record.get_connect_kh(kh_id);
			//�����ݲ��뵽�����
			ccra.getcm().getTabelModel_split_2_tab_2().setDataVector(connect_kh, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
			
			ccra.dispose();
		}

	}

}
