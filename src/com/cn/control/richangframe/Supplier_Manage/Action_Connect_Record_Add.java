package com.cn.control.richangframe.Supplier_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Supplier_Manage.JDBC_Connect_Record;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Connect_Record_Add;

public class Action_Connect_Record_Add implements ActionListener {
	private Supplier_Connect_Record_Add scr;
	public Action_Connect_Record_Add(Supplier_Connect_Record_Add scr) {
		this.scr = scr;
	}

	public void actionPerformed(ActionEvent e) {
		Object select_people = scr.getComboBox_jbr().getSelectedItem();
		if( select_people == null){
			JOptionPane.showMessageDialog(scr, "�����˲���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else if(scr.getTextarea().getText().trim().length() == 0){
			JOptionPane.showMessageDialog(scr, "��ϵ���ݲ���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			
			//����������ghs_name
			String ghs_name = scr.getSm().getLabel_box_1()[0].getText().trim();
			//������ghs_id
			String ghs_id = JDBC_Connect_Record.get_GHS_ID(ghs_name).get(0).toString();
			//��ϵ����
			String date = scr.getComboBox_date().getSelectedItem().toString();
			//��ϰ����
			String textarea = scr.getTextarea().getText();
			//������
			String jbr = scr.getComboBox_jbr().getSelectedItem().toString();
			
//			//�����ݲ��뵽���ݿ�
			JDBC_Connect_Record.Insert_GHS_CONNECT(ghs_id, date, textarea, jbr);
			//�����ݿ��в�ѯ����������
			Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(ghs_id);
			//�����ݲ��뵽�����
			scr.getSm().getTabelModel_right_tab_2().setDataVector(connect_ghs, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
			
			scr.dispose();
		}
	}

}
