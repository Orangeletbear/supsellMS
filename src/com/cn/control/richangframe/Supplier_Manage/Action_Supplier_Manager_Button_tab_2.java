package com.cn.control.richangframe.Supplier_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.cn.dao.richang.Supplier_Manage.JDBC_Connect_Record;
import com.cn.dao.richang.Supplier_Manage.JDBC_Supplier_JButton_tab_2;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Connect_Record_Add;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Connect_Record_Change;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;

public class Action_Supplier_Manager_Button_tab_2 implements ActionListener{
	private Supplier_Manage sm;
	private String TEXT = "";
	private AllTableModel TableModel;
	private JTable table_right_tab_2;
	public Action_Supplier_Manager_Button_tab_2(Supplier_Manage sm) {
		this.sm = sm;
	}

	public void actionPerformed(ActionEvent e) {
		//获取供货商名称
		String ghs_name = sm.getLabel_box_1()[0].getText().trim();
		if(ghs_name.length() == 0){
			JOptionPane.showMessageDialog(sm, "请先输入供货商！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			//保存操作
			if(e.getSource() == sm.getSave()){
				if(sm.getTextArea().getText().length() == 0){
					JDBC_Supplier_JButton_tab_2.setBeiZhu(sm.getTextArea().getText().toString());
				}else{
					JDBC_Supplier_JButton_tab_2.setBeiZhu(sm.getTextArea().getText().toString());
				}
				JOptionPane.showMessageDialog(sm, "保存成功！", "系统信息", 
						JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
			}
			//添加操作
			if(e.getSource() == sm.getAdd()){
				new Supplier_Connect_Record_Add(sm,"供货商联系记录",true);
			}
			//修改操作
			if(e.getSource() == sm.getChange()){
				//获取表格中的数据，只有在有数据的时候才new
				TableModel = sm.getTabelModel_right_tab_2();
				if(TableModel.getRowCount() != 0){
					new Supplier_Connect_Record_Change(sm,"供货商联系记录",true);
				}
			}
			//删除操作
			if(e.getSource() == sm.getDelete()){
				//获取供货商ghs_id
				String ghs_id = JDBC_Connect_Record.get_GHS_ID(ghs_name).get(0).toString();
				//获取(供货商联系信息)
				Vector connect_ghs = JDBC_Connect_Record.get_connect_ghs(ghs_id);
				TableModel = sm.getTabelModel_right_tab_2();
				if(TableModel.getRowCount() != 0 && sm.getTable_right_tab_2().getSelectedRow() != -1){
					int i = JOptionPane.showConfirmDialog(sm, "是否要删除该联系记录信息！", "系统信息", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
					if(i == JOptionPane.YES_OPTION){
						Vector v = (Vector)connect_ghs.get(sm.getTable_right_tab_2().getSelectedRow());
						String date = v.get(0).toString();
						String textarea = "";
						if(v.get(1) != null){
							textarea = v.get(1).toString();
						}
						String jbr = v.get(2).toString();
						JDBC_Connect_Record.Del_GHS_CONNECT(date, textarea,jbr);
						//获取(供货商联系信息)删除之后
						Vector connect_ghs_del = JDBC_Connect_Record.get_connect_ghs(ghs_id);
						sm.getTabelModel_right_tab_2().setDataVector(connect_ghs_del, AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
					}
				}else{
					JOptionPane.showMessageDialog(sm, "请选择指定列！", "系统信息", 
							JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
				}
			}
		}
		
	}

}
