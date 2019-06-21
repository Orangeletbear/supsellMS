package com.cn.control.richangframe.Salesman_Manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;

import com.cn.dao.richang.Salesman_Manage.JDBC_JWindow_confirm_sales;
import com.cn.dao.richang.Salesman_Manage.JDBC_Log_salesman;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.richangJFrame.Salesman_Manage.JWindow_Salesman_Manage;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Manage;

public class Action_Salesman_Confirm_Row implements ActionListener {
	private JWindow_Salesman_Manage jsm;
	private Salesman_Manage sm;
	private Vector data;
	private JLabel[] box_1;
	private JLabel[] box_2;
	private JLabel[] box_3;
	private Float sum_fact_gain;
	private Float sum_fact_pay;
	private Float sum_should_gain;
	private Float sum_should_pay;
	private float between_money;
	public Action_Salesman_Confirm_Row(JWindow_Salesman_Manage jsm) {
		this.jsm = jsm;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.data = jsm.getData();
		this.sm = jsm.getDialog();
		
		box_1 = sm.getLabel_box_1();
		box_2 = sm.getLabel_box_2();
		box_3 = sm.getLabel_box_3();
		//��ȡJWindow_Customer_Manage��JTableѡ���е�����
		Vector v = (Vector)data.get(jsm.getTable().getSelectedRow());
		//��ȡ�ͻ���id
		String TEXT = v.get(0).toString();
		//ͨ���ͻ���id��ѯ��Ӧ�ĵ��ݺţ��ֿ����ƣ�Ӧ����������
		Vector table_detail_kh = JDBC_JWindow_confirm_sales.get_Confirm_kh(TEXT);
		Vector table_detail_ghs = JDBC_JWindow_confirm_sales.get_Confirm_ghs(TEXT);
		Vector table_detail = new Vector();
		table_detail.addAll(table_detail_kh);
		table_detail.addAll(table_detail_ghs);
		/**
		 * ���ͨ���ͻ�id��ѯ�������ݣ����˳�������ܵõ���������ݵĲ���
		 */
		if(table_detail.size() != 0){
			/**
			 * �������ݣ���Ӧ������һ����box_1
			 */
			for(int i = 1; i < v.size(); i++){
				Dimension d = box_1[i-1].getPreferredSize();
				box_1[i-1].setText(v.get(i).toString());
				box_1[i-1].setPreferredSize(d);
			}
			/**
			 * ����ѯ��ѡ���е�������ݣ����ݺţ��ֿ����ƣ�Ӧ�ս�ʵ�ս������ˣ��������ͣ�
			 * ���뵽Customer_Manage��һ��tab����߱��ɹ�/�˻�/�����¼��
			 */
			sm.setData_left(table_detail);
			sm.getTabelModel_split_1().setDataVector(table_detail,
					AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_1));
			//���Table_left_tab_1����ѡ�������
			sm.getTable_split_1().addMouseListener(new Action_Table_split_1(sm));
			/**
			 * �����е����ݽ�����ȡ�������뵽��Ӧ��JLabel��
			 * ���ݰ��������м�¼����Ӧ�ս��������ʵ�ս������)
			 */
			Vector table_detail_sum_ghs = JDBC_JWindow_confirm_sales.get_Confirm_ghs_sum(TEXT);
			Vector table_detail_sum_kh = JDBC_JWindow_confirm_sales.get_Confirm_kh_sum(TEXT);
			Vector table_detail_sum = new Vector();
			if((table_detail_sum_ghs.get(0) != null && table_detail_sum_kh.get(0) != null) || 
					(table_detail_sum_ghs.get(0) == null && table_detail_sum_kh.get(0) == null)){
				//�ҷ�Ӧ��
				sum_should_pay = Float.valueOf(table_detail_sum_ghs.get(0).toString());
				//�ҷ�Ӧ��
				sum_should_gain = Float.valueOf(table_detail_sum_kh.get(0).toString());
				//�ҷ�ʵ��
				sum_fact_pay = Float.valueOf(table_detail_sum_ghs.get(1).toString());
				//�ҷ�ʵ��
				sum_fact_gain = Float.valueOf(table_detail_sum_kh.get(1).toString());
				
				//�ҷ�Ӧ��
				sum_should_pay -= sum_should_gain;
				//�ҷ�ʵ��
				sum_fact_pay -= sum_fact_gain;
				//����� = ʵ����� - Ӧ�����
				between_money = sum_fact_pay - sum_should_pay;
			}else if(table_detail_sum_ghs.get(0) != null && table_detail_sum_kh.get(0) == null){
				//�ҷ�Ӧ��
				sum_should_pay = Float.valueOf(table_detail_sum_ghs.get(0).toString());
				//�ҷ�ʵ��
				sum_fact_pay = Float.valueOf(table_detail_sum_ghs.get(1).toString());
				//����� = ʵ����� - Ӧ�����
				between_money = sum_fact_pay - sum_should_pay;
			}else{
				//�ҷ�Ӧ��
				sum_should_gain = Float.valueOf(table_detail_sum_kh.get(0).toString());
				//�ҷ�ʵ��
				sum_fact_gain = Float.valueOf(table_detail_sum_kh.get(1).toString());
				//����� = �ҷ�ʵ�� - �ҷ�Ӧ��
				between_money = sum_fact_gain - sum_should_gain;
			}
			//�ҷ�ʵ�����ҷ�Ӧ��
			for(int i = 1; i < 3; i++){
				Dimension d_box_2 = box_2[i-1].getPreferredSize();
				box_2[i-1].setText("" + sum_should_pay);
				box_2[i-1].setForeground(Color.RED);
				box_2[i-1].setPreferredSize(d_box_2);
				
				Dimension d_box_3 = box_3[i-1].getPreferredSize();
				box_3[i].setText("" + sum_fact_pay);
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
			box_3[0].setText("" + sm.getTabelModel_split_1().getRowCount());
			box_3[0].setPreferredSize(d_record);
			
			//tab_2�еı�ע,��Ϊ��������뱸ע����
//			System.out.println(JDBC_JWindow_confirm.get_Confirm_data_bz(TEXT).size());
				if(JDBC_JWindow_confirm_sales.get_Confirm_data_bz(TEXT).get(0) != null){
					sm.getTextArea().setText(JDBC_JWindow_confirm_sales.get_Confirm_data_bz(TEXT).get(0).toString());
				}
			
			//��table_right_tab_2��������
				Vector connect_yg = JDBC_Log_salesman.get_connect_yg(TEXT);
				sm.getTabelModel_tab_2().setDataVector(connect_yg, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
			
			
			jsm.dispose();
		}else {
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
			jsm.dispose();
		}

	}


}
