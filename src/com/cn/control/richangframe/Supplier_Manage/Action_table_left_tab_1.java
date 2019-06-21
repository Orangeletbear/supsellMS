package com.cn.control.richangframe.Supplier_Manage;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.richang.Supplier_Manage.JDBC_Table_left_tab_1_Select;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class Action_table_left_tab_1 implements MouseListener {
	private Supplier_Manage sm;
	private Vector data;
	public Action_table_left_tab_1(Supplier_Manage sm) {
		this.sm = sm;
		
	}

	public void mouseClicked(MouseEvent e) {
		data = sm.getTable_left_tab_1_Data();
		if(e.getClickCount() == 1){
			//��ȡSupplier_Manage��Table_left_tab_1ѡ���е�����
			Vector cg = (Vector)data.get(sm.getTable_left_tab_1().getSelectedRow());
			//��ȡ�ɹ����ţ�ID��
			String TEXT = cg.get(0).toString();
			//ͨ���ɹ����ţ�ID����ѯ��Ӧ�Ĳɹ���Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ��
			Vector cg_xd = JDBC_Table_left_tab_1_Select.getTable_left_tab_1_Select(TEXT);
			sm.getTabelModel_right_tab_1().setDataVector(cg_xd, 
					AllTableModel.getVectorFromObj(Supplier_Manage_Model.detail_info));
			
			
			Vector all = JDBC_Table_left_tab_1_Select.getTable_left_tab_1_Select_sum(TEXT);
			if(all.get(0) == null && all.get(1) == null){
				Dimension num = sm.getAll_num().getPreferredSize();
				sm.getAll_num().setText("0");
				sm.getAll_num().setPreferredSize(num);
				
				Dimension money = sm.getAll_num().getPreferredSize();
				sm.getAll_money().setText("0");
				sm.getAll_money().setPreferredSize(num);
			}else{
				Dimension num = sm.getAll_num().getPreferredSize();
				sm.getAll_num().setText("" + Float.valueOf(all.get(0).toString()));
				sm.getAll_num().setPreferredSize(num);
				
				Dimension money = sm.getAll_num().getPreferredSize();
				sm.getAll_money().setText("" + Float.valueOf(all.get(1).toString()));
				sm.getAll_money().setPreferredSize(num);
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
