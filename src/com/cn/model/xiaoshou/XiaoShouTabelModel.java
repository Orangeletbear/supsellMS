package com.cn.model.xiaoshou;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class XiaoShouTabelModel extends DefaultTableModel {

	public XiaoShouTabelModel() {
	}

	public XiaoShouTabelModel(int arg0, int arg1) {
		super(arg0, arg1);
	}

	public XiaoShouTabelModel(Vector arg0, int arg1) {
		super(arg0, arg1);
	}

	public XiaoShouTabelModel(Object[] arg0, int arg1) {
		super(arg0, arg1);
	}

	public XiaoShouTabelModel(Vector arg0, Vector arg1) {
		super(arg0, arg1);
	}

	public XiaoShouTabelModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
	}
    //����ͨ��˫���ı䵥Ԫ������
	public boolean isCellEditable(int row, int column) {
	    return false;
	 }
	

}
