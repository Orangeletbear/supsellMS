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
		//获取JWindow_Customer_Manage中JTable选中行的数据
		Vector v = (Vector)data.get(jsm.getTable().getSelectedRow());
		//获取客户商id
		String TEXT = v.get(0).toString();
		//通过客户商id查询相应的单据号，仓库名称，应付金额等数据
		Vector table_detail_kh = JDBC_JWindow_confirm_sales.get_Confirm_kh(TEXT);
		Vector table_detail_ghs = JDBC_JWindow_confirm_sales.get_Confirm_ghs(TEXT);
		Vector table_detail = new Vector();
		table_detail.addAll(table_detail_kh);
		table_detail.addAll(table_detail_ghs);
		/**
		 * 如果通过客户id查询不到数据，则退出，如果能得到则进行数据的插入
		 */
		if(table_detail.size() != 0){
			/**
			 * 插入数据（供应商名称一栏）box_1
			 */
			for(int i = 1; i < v.size(); i++){
				Dimension d = box_1[i-1].getPreferredSize();
				box_1[i-1].setText(v.get(i).toString());
				box_1[i-1].setPreferredSize(d);
			}
			/**
			 * 将查询到选中行的相关数据（单据号，仓库名称，应收金额，实收金额，经办人，单据类型）
			 * 放入到Customer_Manage第一个tab的左边表（采购/退货/付款记录）
			 */
			sm.setData_left(table_detail);
			sm.getTabelModel_split_1().setDataVector(table_detail,
					AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_1));
			//添加Table_left_tab_1单击选择监听器
			sm.getTable_split_1().addMouseListener(new Action_Table_split_1(sm));
			/**
			 * 将表中的数据进行提取，并放入到相应的JLabel中
			 * 数据包括（表中记录数，应收金额总数，实收金额总数)
			 */
			Vector table_detail_sum_ghs = JDBC_JWindow_confirm_sales.get_Confirm_ghs_sum(TEXT);
			Vector table_detail_sum_kh = JDBC_JWindow_confirm_sales.get_Confirm_kh_sum(TEXT);
			Vector table_detail_sum = new Vector();
			if((table_detail_sum_ghs.get(0) != null && table_detail_sum_kh.get(0) != null) || 
					(table_detail_sum_ghs.get(0) == null && table_detail_sum_kh.get(0) == null)){
				//我方应付
				sum_should_pay = Float.valueOf(table_detail_sum_ghs.get(0).toString());
				//我方应得
				sum_should_gain = Float.valueOf(table_detail_sum_kh.get(0).toString());
				//我方实付
				sum_fact_pay = Float.valueOf(table_detail_sum_ghs.get(1).toString());
				//我方实得
				sum_fact_gain = Float.valueOf(table_detail_sum_kh.get(1).toString());
				
				//我方应付
				sum_should_pay -= sum_should_gain;
				//我方实付
				sum_fact_pay -= sum_fact_gain;
				//相差金额 = 实付金额 - 应付金额
				between_money = sum_fact_pay - sum_should_pay;
			}else if(table_detail_sum_ghs.get(0) != null && table_detail_sum_kh.get(0) == null){
				//我方应付
				sum_should_pay = Float.valueOf(table_detail_sum_ghs.get(0).toString());
				//我方实付
				sum_fact_pay = Float.valueOf(table_detail_sum_ghs.get(1).toString());
				//相差金额 = 实付金额 - 应付金额
				between_money = sum_fact_pay - sum_should_pay;
			}else{
				//我方应得
				sum_should_gain = Float.valueOf(table_detail_sum_kh.get(0).toString());
				//我方实得
				sum_fact_gain = Float.valueOf(table_detail_sum_kh.get(1).toString());
				//相差金额 = 我方实得 - 我方应得
				between_money = sum_fact_gain - sum_should_gain;
			}
			//我方实付，我方应付
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
			//相差金额
			Dimension d_bettween = box_2[2].getPreferredSize();
			box_2[2].setText("" + between_money);
			box_2[2].setForeground(Color.RED);
			box_2[2].setPreferredSize(d_bettween);
			//记录数
			Dimension d_record = box_3[0].getPreferredSize();
			box_3[0].setText("" + sm.getTabelModel_split_1().getRowCount());
			box_3[0].setPreferredSize(d_record);
			
			//tab_2中的备注,不为空是则加入备注数据
//			System.out.println(JDBC_JWindow_confirm.get_Confirm_data_bz(TEXT).size());
				if(JDBC_JWindow_confirm_sales.get_Confirm_data_bz(TEXT).get(0) != null){
					sm.getTextArea().setText(JDBC_JWindow_confirm_sales.get_Confirm_data_bz(TEXT).get(0).toString());
				}
			
			//往table_right_tab_2插入数据
				Vector connect_yg = JDBC_Log_salesman.get_connect_yg(TEXT);
				sm.getTabelModel_tab_2().setDataVector(connect_yg, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
			
			
			jsm.dispose();
		}else {
			//box_2_中我方实付，我方应付
			for(int i = 1; i < 3; i++){
				Dimension d_box_2 = box_2[i-1].getPreferredSize();
				box_2[i-1].setText("" + 0.0);
				box_2[i-1].setForeground(Color.RED);
				box_2[i-1].setPreferredSize(d_box_2);
			}
			//相差金额
			Dimension d_bettween = box_2[2].getPreferredSize();
			box_2[2].setText("" + 0.0);
			box_2[2].setForeground(Color.RED);
			box_2[2].setPreferredSize(d_bettween);
			jsm.dispose();
		}

	}


}
