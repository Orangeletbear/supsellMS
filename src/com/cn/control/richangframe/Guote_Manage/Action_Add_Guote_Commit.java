package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.dao.richang.Guote_Manage.JDBC_Add_Guote_sp;
import com.cn.dao.richang.Guote_Manage.JDBC_Query_sp;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.view.richangJFrame.Guote_Manage.Add_Quote_Goods;

public class Action_Add_Guote_Commit implements ActionListener {
	private Add_Quote_Goods aqgs;
	public Action_Add_Guote_Commit(Add_Quote_Goods aqgs) {
		this.aqgs = aqgs;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aqgs.getConfirm()){
			//��ע
			String beizhu = aqgs.getBeizhu().getText().toString().trim();
			Vector v = aqgs.getTabelModel_table_right().getDataVector();
			int row = aqgs.getTable_right_tab().getRowCount();
			for(int i =0; i < row; i++){
				Vector c = (Vector)v.get(i);
				//��Ʒid
				String id = c.get(0).toString();
				//�����̱���
				String ghsbj = c.get(2).toString();
				//�ҷ�����
				String wfbj = c.get(3).toString();
				JDBC_Add_Guote_sp.change_bj(id, ghsbj, wfbj,beizhu);
				Vector vs = JDBC_Query_sp.Query_sp_bj(id);
				aqgs.getDialog().getTabelModel().getDataVector().addAll(vs);
				aqgs.getDialog().getTabelModel().setDataVector(aqgs.getDialog().getTabelModel().getDataVector(), 
						AllTableModel.getVectorFromObj(Guote_Manage_Model.table));
				aqgs.dispose();
			}
		}
		if(e.getSource() == aqgs.getCancel()){
			int row = aqgs.getTable_right_tab().getRowCount();
			if(row != -1){
				int i = JOptionPane.showConfirmDialog(aqgs, "�Ƿ񱣴��ϱ��б�����Ʒ��", "ϵͳ��Ϣ", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
				if(i == JOptionPane.NO_OPTION){
					aqgs.dispose();
				}else if(i == JOptionPane.YES_OPTION){
					//��ע
					String beizhu = aqgs.getBeizhu().getText().toString().trim();
					Vector v = aqgs.getTabelModel_table_right().getDataVector();
					for(int j =0; j < row; j++){
						Vector c = (Vector)v.get(i);
						//��Ʒid
						String id = c.get(0).toString();
						//�����̱���
						String ghsbj = c.get(2).toString();
						//�ҷ�����
						String wfbj = c.get(3).toString();
						JDBC_Add_Guote_sp.change_bj(id, ghsbj, wfbj,beizhu);
						Vector vs = JDBC_Query_sp.Query_sp_bj(id);
						aqgs.getDialog().getTabelModel().getDataVector().addAll(vs);
						aqgs.getDialog().getTabelModel().setDataVector(aqgs.getDialog().getTabelModel().getDataVector(), 
								AllTableModel.getVectorFromObj(Guote_Manage_Model.table));
						aqgs.dispose();
				}
			}
		}
	}
	}
}
