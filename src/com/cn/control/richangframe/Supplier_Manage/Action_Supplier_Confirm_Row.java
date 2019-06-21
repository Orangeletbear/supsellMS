package com.cn.control.richangframe.Supplier_Manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;

import com.cn.dao.richang.Supplier_Manage.JDBC_Connect_Record;
import com.cn.dao.richang.Supplier_Manage.JDBC_JWindow_confirm_supplier;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Supplier_Manage.JWindow_Supplier_Manage;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class Action_Supplier_Confirm_Row implements ActionListener ,MouseListener{
	private JWindow_Supplier_Manage jsm;
	private Supplier_Manage sm;
	private Vector data;
	private JLabel [] box_1;
	private JLabel [] box_2;
	private JLabel [] box_3;
	public Action_Supplier_Confirm_Row(JWindow_Supplier_Manage jsm) {
		this.jsm = jsm;
		
	}
	public void actionPerformed(ActionEvent e) {
		this.data = jsm.getData();
		this.sm = jsm.getDialog();
		box_1 = sm.getLabel_box_1();
		box_2 = sm.getLabel_box_2();
		box_3 = sm.getLabel_box_3();
		//��ȡJWindow_Supplier_Manage��JTableѡ���е�����
		Vector v = (Vector)data.get(jsm.getTable().getSelectedRow());
		//��ȡ������id
		String TEXT = v.get(0).toString();
		//ͨ��������id��ѯ��Ӧ�ĵ��ݺţ��ֿ����ƣ�Ӧ����������
		Vector table_detail = JDBC_JWindow_confirm_supplier.get_Confirm(TEXT);
		/**
		 * �������ݣ���Ӧ������һ����box_1
		 */
		for(int i = 1; i < v.size(); i++){
			Dimension d = box_1[i-1].getPreferredSize();
			box_1[i-1].setText(v.get(i).toString());
			box_1[i-1].setPreferredSize(d);
		}
		/**
		 * ���ͨ��������id��ѯ�������ݣ����˳�������ܵõ���������ݵĲ���
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
			 * ����ѯ��ѡ���е�������ݣ����ݺţ��ֿ����ƣ�Ӧ����ʵ���������ˣ��������ͣ�
			 * ���뵽Supplier_Manage��һ��tab����߱��ɹ�/�˻�/�����¼��
			 */
			sm.setData(table_detail);
			sm.getTabelModel_left_tab_1().setDataVector(table_detail,
					AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
			//���Table_left_tab_1˫��ѡ�������
			sm.getTable_left_tab_1().addMouseListener(new Action_table_left_tab_1(sm));
			/**
			 * �����е����ݽ�����ȡ�������뵽��Ӧ��JLabel��
			 * ���ݰ��������м�¼�����ҷ�Ӧ���������ҷ�ʵ������)
			 */
			Vector table_detaile_sum = JDBC_JWindow_confirm_supplier.get_Confirm_data(TEXT);
			//�ҷ�Ӧ��
			Float sum_should_pay = Float.valueOf(table_detaile_sum.get(0).toString());
			//�ҷ�ʵ��
			Float sum_fact_pay = Float.valueOf(table_detaile_sum.get(1).toString());
			//����� = ʵ����� - Ӧ�����
			Float between_money = sum_fact_pay - sum_should_pay;
			
			//�ҷ�ʵ�����ҷ�Ӧ��
			for(int i = 1; i < 3; i++){
				Dimension d_box_2 = box_2[i-1].getPreferredSize();
				box_2[i-1].setText("" + Float.valueOf(table_detaile_sum.get(i-1).toString()));
				box_2[i-1].setForeground(Color.RED);
				box_2[i-1].setPreferredSize(d_box_2);
				
				Dimension d_box_3 = box_3[i-1].getPreferredSize();
				box_3[i].setText("" + Float.valueOf(table_detaile_sum.get(i-1).toString()));
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
			box_3[0].setText("" + sm.getTabelModel_left_tab_1().getRowCount());
			box_3[0].setPreferredSize(d_record);
			//��ѯ�������
			sm.getChakanzhuangwu().setVisible(true);
			
			//tab_2�еı�ע,��Ϊ��������뱸ע����
			if(JDBC_JWindow_confirm_supplier.get_Confirm_data_bz(TEXT).get(0) != null){
				sm.getTextArea().setText(JDBC_JWindow_confirm_supplier.get_Confirm_data_bz(TEXT).get(0).toString());
			}
			//��table_right_tab_2��������
				Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(v.get(0).toString());
				sm.getTabelModel_right_tab_2().setDataVector(connect_ghs, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
			
			
			jsm.dispose();
		}else {
			Vector v1 = new Vector();
			sm.getTabelModel_left_tab_1().setDataVector(v1,
					AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
			sm.getTextArea().setText("");
			sm.getTabelModel_right_tab_1().setDataVector(v1, 
					AllTableModel.getVectorFromObj(Supplier_Manage_Model.detail_info));
			sm.getTabelModel_right_tab_2().setDataVector(v1, 
					AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
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
			sm.getChakanzhuangwu().setVisible(true);
			jsm.dispose();
		}
		
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			this.data = jsm.getData();
			this.sm = jsm.getDialog();
			box_1 = sm.getLabel_box_1();
			box_2 = sm.getLabel_box_2();
			box_3 = sm.getLabel_box_3();
			//��ȡJWindow_Supplier_Manage��JTableѡ���е�����
			Vector v = (Vector)data.get(jsm.getTable().getSelectedRow());
			//��ȡ������id
			String TEXT = v.get(0).toString();
			//ͨ��������id��ѯ��Ӧ�ĵ��ݺţ��ֿ����ƣ�Ӧ����������
			Vector table_detail = JDBC_JWindow_confirm_supplier.get_Confirm(TEXT);
			/**
			 * �������ݣ���Ӧ������һ����box_1
			 */
			for(int i = 1; i < v.size(); i++){
				Dimension d = box_1[i-1].getPreferredSize();
				box_1[i-1].setText(v.get(i).toString());
				box_1[i-1].setPreferredSize(d);
			}
			/**
			 * ���ͨ��������id��ѯ�������ݣ����˳�������ܵõ���������ݵĲ���
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
				 * ����ѯ��ѡ���е�������ݣ����ݺţ��ֿ����ƣ�Ӧ����ʵ���������ˣ��������ͣ�
				 * ���뵽Supplier_Manage��һ��tab����߱��ɹ�/�˻�/�����¼��
				 */
				sm.setData(table_detail);
				sm.getTabelModel_left_tab_1().setDataVector(table_detail,
						AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
				//���Table_left_tab_1˫��ѡ�������
				sm.getTable_left_tab_1().addMouseListener(new Action_table_left_tab_1(sm));
				/**
				 * �����е����ݽ�����ȡ�������뵽��Ӧ��JLabel��
				 * ���ݰ��������м�¼�����ҷ�Ӧ���������ҷ�ʵ������)
				 */
				Vector table_detaile_sum = JDBC_JWindow_confirm_supplier.get_Confirm_data(TEXT);
				//�ҷ�Ӧ��
				Float sum_should_pay = Float.valueOf(table_detaile_sum.get(0).toString());
				//�ҷ�ʵ��
				Float sum_fact_pay = Float.valueOf(table_detaile_sum.get(1).toString());
				//����� = ʵ����� - Ӧ�����
				Float between_money = sum_fact_pay - sum_should_pay;
				
				//�ҷ�ʵ�����ҷ�Ӧ��
				for(int i = 1; i < 3; i++){
					Dimension d_box_2 = box_2[i-1].getPreferredSize();
					box_2[i-1].setText("" + Float.valueOf(table_detaile_sum.get(i-1).toString()));
					box_2[i-1].setForeground(Color.RED);
					box_2[i-1].setPreferredSize(d_box_2);
					
					Dimension d_box_3 = box_3[i-1].getPreferredSize();
					box_3[i].setText("" + Float.valueOf(table_detaile_sum.get(i-1).toString()));
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
				box_3[0].setText("" + sm.getTabelModel_left_tab_1().getRowCount());
				box_3[0].setPreferredSize(d_record);
				//��ѯ�������
				sm.getChakanzhuangwu().setVisible(true);
				
				//tab_2�еı�ע,��Ϊ��������뱸ע����
				if(JDBC_JWindow_confirm_supplier.get_Confirm_data_bz(TEXT).get(0) != null){
					sm.getTextArea().setText(JDBC_JWindow_confirm_supplier.get_Confirm_data_bz(TEXT).get(0).toString());
				}
				//��table_right_tab_2��������
					Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(v.get(0).toString());
					sm.getTabelModel_right_tab_2().setDataVector(connect_ghs, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
				
				
				jsm.dispose();
			}else {
				Vector v1 = new Vector();
				sm.getTabelModel_left_tab_1().setDataVector(v1,
						AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
				sm.getTextArea().setText("");
				sm.getTabelModel_right_tab_1().setDataVector(v1, 
						AllTableModel.getVectorFromObj(Supplier_Manage_Model.detail_info));
				sm.getTabelModel_right_tab_2().setDataVector(v1, 
						AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
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
				sm.getChakanzhuangwu().setVisible(true);
				jsm.dispose();
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
