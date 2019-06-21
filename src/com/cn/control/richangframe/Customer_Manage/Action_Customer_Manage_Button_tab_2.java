package com.cn.control.richangframe.Customer_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Customer_Manage.JDBC_Connect_Record;
import com.cn.dao.richang.Customer_Manage.JDBC_Customer_JButton_tab_2;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Connect_Record_Add;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Connect_Record_Change;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Manage;

public class Action_Customer_Manage_Button_tab_2 implements ActionListener {
	private Customer_Manage cm;
	private AllTableModel TableModel;
	public Action_Customer_Manage_Button_tab_2(Customer_Manage cm) {
		this.cm = cm;
	}

	public void actionPerformed(ActionEvent e) {
		//获取客户名称
		String kh_name = cm.getLabel_box_1()[0].getText().trim();
		if(kh_name.length() == 0){
			JOptionPane.showMessageDialog(cm, "请先输入客户！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//保存操作
			if(e.getSource() == cm.getSave()){
				if(cm.getTextArea().getText().length() == 0){
					JDBC_Customer_JButton_tab_2.setBeiZhu(cm.getTextArea().getText().toString());
				}else{
					JDBC_Customer_JButton_tab_2.setBeiZhu(cm.getTextArea().getText().toString());
				}
				JOptionPane.showMessageDialog(cm, "保存成功！", "系统信息", 
						JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
			}
			//添加操作
			if(e.getSource() == cm.getAdd()){
				new Customer_Connect_Record_Add(cm,"供货商联系记录",true);
			}
			//修改操作
			if(e.getSource() == cm.getChange()){
				//获取表格中的数据，只有在有数据的时候才new
				TableModel = cm.getTabelModel_split_2_tab_2();
				if(TableModel.getRowCount() != 0){
					new Customer_Connect_Record_Change(cm,"供货商联系记录",true);
				}
			}
			//删除操作
			if(e.getSource() == cm.getDelete()){
				//获取供货商ghs_id
				String kh_id = JDBC_Connect_Record.get_kh_ID(kh_name).get(0).toString();
				//获取(供货商联系信息)
				Vector connect_kh = JDBC_Connect_Record.get_connect_kh(kh_id);
				TableModel = cm.getTabelModel_split_2_tab_2();
				if(TableModel.getRowCount() != 0 && cm.getTable_split_2_tab_2().getSelectedRow() != -1){
					int i = JOptionPane.showConfirmDialog(cm, "是否要删除该联系记录信息！", "系统信息", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
					if(i == JOptionPane.YES_OPTION){
						Vector v = (Vector)connect_kh.get(cm.getTable_split_2_tab_2().getSelectedRow());
						String date = v.get(0).toString();
						String textarea = "";
						if(v.get(1) != null){
							textarea = v.get(1).toString();
						}
						String jbr = v.get(2).toString();
						JDBC_Connect_Record.Del_kh_CONNECT(date, textarea,jbr);
						//获取(供货商联系信息)删除之后
						Vector connect_kh_del = JDBC_Connect_Record.get_connect_kh(kh_id);
						cm.getTabelModel_split_2_tab_2().setDataVector(connect_kh_del, AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
					}
				}else{
					JOptionPane.showMessageDialog(cm, "请选择指定列！", "系统信息", 
							JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
				}
			}
		}
	}

}
