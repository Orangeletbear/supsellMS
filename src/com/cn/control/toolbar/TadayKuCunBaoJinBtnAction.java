package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * �������еĿ�汨�������ϵĲ�ѯѰ��ť������
 * �����С��һ������ʱ����( Ĭ��Ϊ0 )
 */
public class TadayKuCunBaoJinBtnAction implements ActionListener {
	
	private RemaindDialog frame;
	
	public TadayKuCunBaoJinBtnAction(RemaindDialog frame) {
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent arg0) {
	
		Vector data = TadayRemindJDBC.getCuCunBJData(
				    frame.getSpNamefield().getText().toString());
		frame.getKuCunBJtableMO().setDataVector(data,
		AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName1));
		
	}

}
