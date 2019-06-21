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
		//����������ghs_name
		String ghs_name = scrc.getSm().getLabel_box_1()[0].getText().trim();
		//������ghs_id
		String ghs_id = JDBC_Connect_Record.get_GHS_ID(ghs_name).get(0).toString();
		
		Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(ghs_id);
		Vector select_row = (Vector)connect_ghs.get(scrc.getSm().getTable_right_tab_2().getSelectedRow());
		String str_text = select_row.get(1).toString();
		String str_jbr = select_row.get(2).toString();
		if(scrc.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(scrc, "��ϵ���ݲ���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//��ϵ����
			String to_date = scrc.getComboBox_date().getSelectedItem().toString();
			//��ϰ����
			String to_text = scrc.getTextarea().getText();
			//������
			String to_jbr = scrc.getComboBox_jbr().getSelectedItem().toString();
			//�޸�����
			JDBC_Connect_Record.change_GHS_Connect(str_text, str_jbr, to_date, to_text, to_jbr);
			
			//�����ݿ��в�ѯ�޸ĺ������
			Vector connect_ghs_change = JDBC_Connect_Record.get_connect_ghs(ghs_id);
			//�����ݲ��뵽�����
			scrc.getSm().getTabelModel_right_tab_2().setDataVector(connect_ghs_change, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
			
			scrc.dispose();
		}
	}

}
