package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.KuChunFind;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * �������ϵĿ���ѯ������
 */
public class CuCunFindAction implements ActionListener {
	
	KuChunFind frame;
	public CuCunFindAction(KuChunFind frame) {
	    this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		   //�ֿ���
           String canKuName = frame.getChanKu().getSelectedItem().toString();
           //��Ʒ������Ʒ��
           String spName = frame.getSpField().getText().toString();
           //��Ʒ���
           String splb = frame.getLbField().getSelectedItem().toString();
           //�Ƿ��������Ʒ
           boolean isGetO = frame.getBox().isSelected();
           
           Vector data = JDBCCuCunFind.getData(canKuName, spName,splb,isGetO);
			frame.getTableMo().setDataVector(data,
					AllTableModel.getVectorFromObj(TableCulomnModel.KuChunCaXunColumnName));
           
	}

}
