package com.cn.control.richangframe.Salesman_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Salesman_Manage.JDBC_Log_salesman;
import com.cn.dao.richang.Salesman_Manage.JDBC_Salesman_JButton_tab_2;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Log_Add;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Log_Change;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Manage;

public class Action_Salesman_Manage_Button_tab_2 implements ActionListener {
	private Salesman_Manage sm;
	private AllTableModel TableModel;
	private Vector data;
	public Action_Salesman_Manage_Button_tab_2(Salesman_Manage sm) {
		this.sm = sm;
	}

	public void actionPerformed(ActionEvent e) {
		//获取员工名称
		String yg_name = sm.getLabel_box_1()[0].getText().trim();
		if(yg_name.length() == 0){
			JOptionPane.showMessageDialog(sm, "请先输入员工！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}else{
			
			//保存操作
			if(e.getSource() == sm.getSave()){
				if(sm.getTextArea().getText().length() == 0){
						JDBC_Salesman_JButton_tab_2.setBeiZhu(sm.getTextArea().getText().toString());
				}else{
					JDBC_Salesman_JButton_tab_2.setBeiZhu(sm.getTextArea().getText().toString());
				}
				JOptionPane.showMessageDialog(sm, "保存成功！", "系统信息", 
						JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
			}
			//添加操作
			if(e.getSource() == sm.getAdd()){
				new Salesman_Log_Add(sm,"业务员日志",true);
			}
			//修改操作
			if(e.getSource() == sm.getChange()){
				//获取表格中的数据，只有在有数据的时候才new
				TableModel = sm.getTabelModel_tab_2();
				if(TableModel.getRowCount() != 0){
					new Salesman_Log_Change(sm,"业务员日志",true);
				}
			}
			//删除操作
			if(e.getSource() == sm.getDelete()){
				//获取员工yg_id
				String yg_id = JDBC_Log_salesman.get_id_yg(yg_name).get(0).toString();
				//获取员工日志log
				Vector connect_yg = JDBC_Log_salesman.get_connect_yg(yg_id);
				TableModel = sm.getTabelModel_tab_2();
				if(TableModel.getRowCount() != 0 && sm.getTable_tab_2().getSelectedRow() != -1){
					int i = JOptionPane.showConfirmDialog(sm, "是否要删除该日志信息！", "系统信息", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
					if(i == JOptionPane.YES_OPTION){
						Vector v = (Vector)connect_yg.get(sm.getTable_tab_2().getSelectedRow());
						String date = v.get(0).toString();
						String textarea = "";
						if(v.get(1) != null){
							textarea = v.get(1).toString();
						}
						JDBC_Log_salesman.Del_yg_LOG(date, textarea);
						//获取删除之后
						Vector connect_log_del = JDBC_Log_salesman.get_connect_yg(yg_id);
						sm.getTabelModel_tab_2().setDataVector(connect_log_del, AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
					}
				}else{
					JOptionPane.showMessageDialog(sm, "请选择指定列！", "系统信息", 
							JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
				}
			}
		}
	}

	}

