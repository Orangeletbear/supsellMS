package com.cn.control.richangframe.Customer_Manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;

import com.cn.dao.richang.Customer_Manage.JDBC_Connect_Record;
import com.cn.dao.richang.Customer_Manage.JDBC_JWindow_confirm_customer;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Manage;
import com.cn.view.richangJFrame.Customer_Manage.JWindow_Customer_Manage;

public class Action_Customer_Confirm_Row implements ActionListener ,MouseListener{
	private JWindow_Customer_Manage jcm;
	private Customer_Manage cm;
	private Vector data;
	private JLabel [] box_1;
	private JLabel [] box_2;
	private JLabel [] box_3;
	public Action_Customer_Confirm_Row(JWindow_Customer_Manage jcm) {
			this.jcm = jcm;
			
	}


	public void actionPerformed(ActionEvent arg0) {
		this.data = jcm.getData();
		this.cm = jcm.getDialog();
		
		box_1 = cm.getLabel_box_1();
		box_2 = cm.getLabel_box_2();
		box_3 = cm.getLabel_box_3();
		//��ȡJWindow_Customer_Manage��JTableѡ���е�����
		Vector v = (Vector)data.get(jcm.getTable().getSelectedRow());
		//��ȡ�ͻ���id
		String TEXT = v.get(0).toString();
		//ͨ���ͻ���id��ѯ��Ӧ�ĵ��ݺţ��ֿ����ƣ�Ӧ����������
		Vector table_detail = JDBC_JWindow_confirm_customer.get_Confirm(TEXT);
		/**
		 * �������ݣ���Ӧ������һ����box_1
		 */
		for(int i = 1; i < v.size(); i++){
			Dimension d = box_1[i-1].getPreferredSize();
			if(v.get(i)==null){
				box_1[i-1].setText("");
			}else{
				box_1[i-1].setText(v.get(i).toString());
			}
			box_1[i-1].setPreferredSize(d);
		}
		/**
		 * ���ͨ���ͻ�id��ѯ�������ݣ����˳�������ܵõ���������ݵĲ���
		 */
		if(table_detail.size() != 0){
//			/**
//			 * �������ݣ���Ӧ������һ����box_1
//			 */
//			for(int i = 1; i < v.size(); i++){
//				Dimension d = box_1[i-1].getPreferredSize();
//				box_1[i-1].setText(v.get(i).toString());
//				box_1[i-1].setPreferredSize(d);
//			}
			/**
			 * ����ѯ��ѡ���е�������ݣ����ݺţ��ֿ����ƣ�Ӧ�ս�ʵ�ս������ˣ��������ͣ�
			 * ���뵽Customer_Manage��һ��tab����߱��ɹ�/�˻�/�����¼��
			 */
			cm.setData_split_1(table_detail);
			cm.getTabelModel_split_1().setDataVector(table_detail,
					AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_1));
			//���Table_left_tab_1������ѡ�������
			cm.getTable_split_1().addMouseListener(new Action_Table_split_1(cm));
			/**
			 * �����е����ݽ�����ȡ�������뵽��Ӧ��JLabel��
			 * ���ݰ��������м�¼����Ӧ�ս��������ʵ�ս������)
			 */
			Vector table_detail_sum = JDBC_JWindow_confirm_customer.get_Confirm_data(TEXT);
			//�ҷ�Ӧ��
			Float sum_should_pay = Float.valueOf(table_detail_sum.get(0).toString());
			//�ҷ�ʵ��
			Float sum_fact_pay = Float.valueOf(table_detail_sum.get(1).toString());
			//����� = ʵ����� - Ӧ�����
			Float between_money = sum_fact_pay - sum_should_pay;
			
			//�ҷ�ʵ�����ҷ�Ӧ��
			for(int i = 1; i < 3; i++){
				Dimension d_box_2 = box_2[i-1].getPreferredSize();
				box_2[i-1].setText("" + Float.valueOf(table_detail_sum.get(i-1).toString()));
				box_2[i-1].setForeground(Color.RED);
				box_2[i-1].setPreferredSize(d_box_2);
				
				Dimension d_box_3 = box_3[i-1].getPreferredSize();
				box_3[i].setText("" + Float.valueOf(table_detail_sum.get(i-1).toString()));
				box_3[i].setForeground(Color.RED);
				box_3[i].setPreferredSize(d_box_3);
			}
			//�����
			Dimension d_bettween = box_2[2].getPreferredSize();
			box_2[2].setText("" + between_money);
			box_2[2].setForeground(Color.RED);
			box_2[2].setPreferredSize(d_bettween);
			//��¼��
			Dimension d_record = box_3[0].getPreferredSize();
			box_3[0].setText("" + cm.getTabelModel_split_1().getRowCount());
			box_3[0].setPreferredSize(d_record);
			//��ѯ�������
			cm.getChakanzhuangwu().setVisible(true);
			
			//tab_2�еı�ע,��Ϊ��������뱸ע����
			if(JDBC_JWindow_confirm_customer.get_Confirm_data_bz(TEXT).get(0) != null){
				cm.getTextArea().setText(JDBC_JWindow_confirm_customer.get_Confirm_data_bz(TEXT).get(0).toString());
			}
			//��table_right_tab_2��������
				Vector connect_kh = JDBC_Connect_Record.get_connect_kh(v.get(0).toString());
				cm.getTabelModel_split_2_tab_2().setDataVector(connect_kh, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
			
			
			jcm.dispose();
		}else {
			Vector v1 = new Vector();;
			cm.getTabelModel_split_1().setDataVector(v1,
					AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_1));
			cm.getTabelModel_split_2().setDataVector(v1,
					AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_2));
			cm.getTextArea().setText("");
			cm.getTabelModel_split_2_tab_2().setDataVector(v1, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
			//box_2_���ҷ�ʵ�����ҷ�Ӧ��
			for(int i = 1; i < 3; i++){
				Dimension d_box_2 = box_2[i-1].getPreferredSize();
				box_2[i-1].setText("" + 0.0);
				box_2[i-1].setForeground(Color.RED);
				box_2[i-1].setPreferredSize(d_box_2);
			}
			//�����
			Dimension d_bettween = box_2[2].getPreferredSize();
			box_2[2].setText("" + 0.0);
			box_2[2].setForeground(Color.RED);
			box_2[2].setPreferredSize(d_bettween);
			//��ѯ�������
			cm.getChakanzhuangwu().setVisible(true);
			jcm.dispose();
		}
		
		
	}


	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			this.data = jcm.getData();
			this.cm = jcm.getDialog();
			
			box_1 = cm.getLabel_box_1();
			box_2 = cm.getLabel_box_2();
			box_3 = cm.getLabel_box_3();
			//��ȡJWindow_Customer_Manage��JTableѡ���е�����
			Vector v = (Vector)data.get(jcm.getTable().getSelectedRow());
			//��ȡ�ͻ���id
			String TEXT = v.get(0).toString();
			//ͨ���ͻ���id��ѯ��Ӧ�ĵ��ݺţ��ֿ����ƣ�Ӧ����������
			Vector table_detail = JDBC_JWindow_confirm_customer.get_Confirm(TEXT);
			/**
			 * �������ݣ���Ӧ������һ����box_1
			 */
			for(int i = 1; i < v.size(); i++){
				Dimension d = box_1[i-1].getPreferredSize();
				box_1[i-1].setText(v.get(i).toString());
				box_1[i-1].setPreferredSize(d);
			}
			/**
			 * ���ͨ���ͻ�id��ѯ�������ݣ����˳�������ܵõ���������ݵĲ���
			 */
			if(table_detail.size() != 0){
//				/**
//				 * �������ݣ���Ӧ������һ����box_1
//				 */
//				for(int i = 1; i < v.size(); i++){
//					Dimension d = box_1[i-1].getPreferredSize();
//					box_1[i-1].setText(v.get(i).toString());
//					box_1[i-1].setPreferredSize(d);
//				}
				/**
				 * ����ѯ��ѡ���е�������ݣ����ݺţ��ֿ����ƣ�Ӧ�ս�ʵ�ս������ˣ��������ͣ�
				 * ���뵽Customer_Manage��һ��tab����߱��ɹ�/�˻�/�����¼��
				 */
				cm.setData_split_1(table_detail);
				cm.getTabelModel_split_1().setDataVector(table_detail,
						AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_1));
				//���Table_left_tab_1������ѡ�������
				cm.getTable_split_1().addMouseListener(new Action_Table_split_1(cm));
				/**
				 * �����е����ݽ�����ȡ�������뵽��Ӧ��JLabel��
				 * ���ݰ��������м�¼����Ӧ�ս��������ʵ�ս������)
				 */
				Vector table_detail_sum = JDBC_JWindow_confirm_customer.get_Confirm_data(TEXT);
				//�ҷ�Ӧ��
				Float sum_should_pay = Float.valueOf(table_detail_sum.get(0).toString());
				//�ҷ�ʵ��
				Float sum_fact_pay = Float.valueOf(table_detail_sum.get(1).toString());
				//����� = ʵ����� - Ӧ�����
				Float between_money = sum_fact_pay - sum_should_pay;
				
				//�ҷ�ʵ�����ҷ�Ӧ��
				for(int i = 1; i < 3; i++){
					Dimension d_box_2 = box_2[i-1].getPreferredSize();
					box_2[i-1].setText("" + Float.valueOf(table_detail_sum.get(i-1).toString()));
					box_2[i-1].setForeground(Color.RED);
					box_2[i-1].setPreferredSize(d_box_2);
					
					Dimension d_box_3 = box_3[i-1].getPreferredSize();
					box_3[i].setText("" + Float.valueOf(table_detail_sum.get(i-1).toString()));
					box_3[i].setForeground(Color.RED);
					box_3[i].setPreferredSize(d_box_3);
				}
				//�����
				Dimension d_bettween = box_2[2].getPreferredSize();
				box_2[2].setText("" + between_money);
				box_2[2].setForeground(Color.RED);
				box_2[2].setPreferredSize(d_bettween);
				//��¼��
				Dimension d_record = box_3[0].getPreferredSize();
				box_3[0].setText("" + cm.getTabelModel_split_1().getRowCount());
				box_3[0].setPreferredSize(d_record);
				//��ѯ�������
				cm.getChakanzhuangwu().setVisible(true);
				
				//tab_2�еı�ע,��Ϊ��������뱸ע����
				if(JDBC_JWindow_confirm_customer.get_Confirm_data_bz(TEXT).get(0) != null){
					cm.getTextArea().setText(JDBC_JWindow_confirm_customer.get_Confirm_data_bz(TEXT).get(0).toString());
				}
				//��table_right_tab_2��������
					Vector connect_kh = JDBC_Connect_Record.get_connect_kh(v.get(0).toString());
					cm.getTabelModel_split_2_tab_2().setDataVector(connect_kh, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
				
				
				jcm.dispose();
			}else {
				Vector v1 = new Vector();;
				cm.getTabelModel_split_1().setDataVector(v1,
						AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_1));
				cm.getTabelModel_split_2().setDataVector(v1,
						AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_2));
				cm.getTextArea().setText("");
				cm.getTabelModel_split_2_tab_2().setDataVector(v1, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
				//box_2_���ҷ�ʵ�����ҷ�Ӧ��
				for(int i = 1; i < 3; i++){
					Dimension d_box_2 = box_2[i-1].getPreferredSize();
					box_2[i-1].setText("" + 0.0);
					box_2[i-1].setForeground(Color.RED);
					box_2[i-1].setPreferredSize(d_box_2);
				}
				//�����
				Dimension d_bettween = box_2[2].getPreferredSize();
				box_2[2].setText("" + 0.0);
				box_2[2].setForeground(Color.RED);
				box_2[2].setPreferredSize(d_bettween);
				//��ѯ�������
				cm.getChakanzhuangwu().setVisible(true);
				jcm.dispose();
			}
		}
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
