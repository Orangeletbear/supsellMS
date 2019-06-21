package com.cn.control.richangframe.Salesman_Manage;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.richang.Customer_Manage.JDBC_Table_split_1_Select;
import com.cn.dao.richang.Supplier_Manage.JDBC_Table_left_tab_1_Select;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Manage;

public class Action_Table_split_1 implements MouseListener {

	private Vector data;
	private Salesman_Manage sm;
	public Action_Table_split_1(Salesman_Manage sm) {
		this.sm = sm;
	}

	public void mouseClicked(MouseEvent e) {
		
		data = sm.getData_left();
		if(e.getClickCount() == 1){
			//��ȡCustomer_Manage��Table_split_1ѡ���е�����
			Vector xs = (Vector)data.get(sm.getTable_split_1().getSelectedRow());
			//��ȡ���ݺţ�ID��
			String TEXT = xs.get(0).toString();
			if(TEXT.startsWith("XS")){
				//ͨ�����۵��ţ�ID����ѯ��Ӧ��������Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ��
				Vector xs_xd = JDBC_Table_split_1_Select.getTable_split_1_Select(TEXT);
				sm.getTabelModel_split_2().setDataVector(xs_xd, 
						AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_2));
				
				
				Vector all = JDBC_Table_split_1_Select.getTable_split_1_Select_sum(TEXT);
				if(all.get(0) == null && all.get(1) == null){
					Dimension num = sm.getNumber_split_2().getPreferredSize();
					sm.getNumber_split_2().setText("0");
					sm.getNumber_split_2().setPreferredSize(num);
					
					Dimension money = sm.getMoney_split_2().getPreferredSize();
					sm.getMoney_split_2().setText("0");
					sm.getMoney_split_2().setPreferredSize(num);
				}else{
					Dimension num = sm.getNumber_split_2().getPreferredSize();
					sm.getNumber_split_2().setText("" + Float.valueOf(all.get(0).toString()));
					sm.getNumber_split_2().setPreferredSize(num);
					
					Dimension money = sm.getMoney_split_2().getPreferredSize();
					sm.getMoney_split_2().setText("" + Float.valueOf(all.get(1).toString()));
					sm.getMoney_split_2().setPreferredSize(num);
				}
			}
			if(TEXT.startsWith("CJ")){
				//��ȡSupplier_Manage��Table_left_tab_1ѡ���е�����
				Vector cg = (Vector)data.get(sm.getTable_split_1().getSelectedRow());
				//��ȡ�ɹ����ţ�ID��
				String text = cg.get(0).toString();
				//ͨ���ɹ����ţ�ID����ѯ��Ӧ�Ĳɹ���Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ��
				Vector cg_xd = JDBC_Table_left_tab_1_Select.getTable_left_tab_1_Select(text);
				sm.getTabelModel_split_2().setDataVector(cg_xd, 
						AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_2));
				
				
				Vector all = JDBC_Table_left_tab_1_Select.getTable_left_tab_1_Select_sum(TEXT);
				if(all.get(0) == null && all.get(1) == null){
					Dimension num = sm.getNumber_split_2().getPreferredSize();
					sm.getNumber_split_2().setText("0");
					sm.getNumber_split_2().setPreferredSize(num);
					
					Dimension money = sm.getMoney_split_2().getPreferredSize();
					sm.getMoney_split_2().setText("0");
					sm.getMoney_split_2().setPreferredSize(num);
				}else{
					Dimension num = sm.getNumber_split_2().getPreferredSize();
					sm.getNumber_split_2().setText("" + Float.valueOf(all.get(0).toString()));
					sm.getNumber_split_2().setPreferredSize(num);
					
					Dimension money = sm.getMoney_split_2().getPreferredSize();
					sm.getMoney_split_2().setText("" + Float.valueOf(all.get(1).toString()));
					sm.getMoney_split_2().setPreferredSize(num);
				}
			}
			
		}
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
