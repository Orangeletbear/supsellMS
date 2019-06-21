package com.cn.control.richangframe.Customer_Manage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.richang.Customer_Manage.JDBC_Table_split_1_Select;
import com.cn.dao.richang.Supplier_Manage.JDBC_Table_left_tab_1_Select;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Manage;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class Action_Table_split_1 implements MouseListener {
	private Customer_Manage cm;
	private Vector data;
	public Action_Table_split_1(Customer_Manage cm) {
		this.cm = cm;
	}

	public void mouseClicked(MouseEvent e) {
		data = cm.getData_split_1();
		if(e.getClickCount() == 1){
			//获取Customer_Manage中Table_split_1选中行的数据
			Vector xs = (Vector)data.get(cm.getTable_split_1().getSelectedRow());
			//获取销售单号（ID）
			String TEXT = xs.get(0).toString();
			//通过销售单号（ID）查询相应的销售商品编号，商品名称，单位，单价，数量，总金额
			Vector xs_xd = JDBC_Table_split_1_Select.getTable_split_1_Select(TEXT);
			cm.getTabelModel_split_2().setDataVector(xs_xd, 
					AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_2));
			
			
			Vector all = JDBC_Table_split_1_Select.getTable_split_1_Select_sum(TEXT);
			if(all.get(0) == null && all.get(1) == null){
				Dimension num = cm.getNumber_split_2().getPreferredSize();
				cm.getNumber_split_2().setText("0");
				cm.getNumber_split_2().setPreferredSize(num);
				
				Dimension money = cm.getMoney_split_2().getPreferredSize();
				cm.getMoney_split_2().setText("0");
				cm.getMoney_split_2().setPreferredSize(num);
			}else{
				Dimension num = cm.getNumber_split_2().getPreferredSize();
				cm.getNumber_split_2().setText("" + Float.valueOf(all.get(0).toString()));
				cm.getNumber_split_2().setPreferredSize(num);
				
				Dimension money = cm.getMoney_split_2().getPreferredSize();
				cm.getMoney_split_2().setText("" + Float.valueOf(all.get(1).toString()));
				cm.getMoney_split_2().setPreferredSize(num);
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
