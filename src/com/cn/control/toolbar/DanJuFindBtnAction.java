package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.DanJuFindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * �������ϵĵ��ݲ�ѯ�ϵĲ�ѯ��ť������
 */
public class DanJuFindBtnAction implements ActionListener {
	
	private DanJuFindDialog frame;
	
	public DanJuFindBtnAction(DanJuFindDialog frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e){
		boolean flag = false;
		if(frame.getBox().isSelected()){
			flag= true;
		}
		
		Vector data = JDBCDanJuFindGetData.getData(frame.getLbField().getText(),flag);
		//���ݼ����ģʽ��
		frame.getTabelModel().setDataVector(data,
		AllTableModel.getVectorFromObj(TableCulomnModel.DangJuFindColumnName));
		
	}

}
