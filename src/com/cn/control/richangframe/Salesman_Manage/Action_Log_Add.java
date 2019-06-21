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
			JOptionPane.showMessageDialog(sla, "��־���ݲ���Ϊ�գ�", "ϵͳ��Ϣ", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//��ϵ����
			String date = sla.getDate().getSelectedItem().toString();
			//��ϵ����
			String textarea = sla.getTextArea().getText();
			//ҵ��Աid
			String name = sla.getSm().getLabel_box_1()[0].getText();
			String id = JDBC_Log_salesman.get_id_yg(name).get(0).toString();
			//�����ݲ��뵽���ݿ�
			JDBC_Log_salesman.Insert_yg_LOG(id, date, textarea);
			
			//�����ݿ��в�ѯ����������
			Vector connect_yg = JDBC_Log_salesman.get_connect_yg(id);
			//�����ݲ��뵽�����
			sla.getSm().getTabelModel_tab_2().setDataVector(connect_yg, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
			
			sla.dispose();
		}
	}
}
