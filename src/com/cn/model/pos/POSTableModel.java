package com.cn.model.pos;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
/*
 * �Զ����ģʽ
 */
public class POSTableModel extends DefaultTableModel {

	public POSTableModel() {
	}

	public POSTableModel(int arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Vector arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Object[] arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Vector arg0, Vector arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
	}
    //����ͨ��˫���ı䵥Ԫ������
	public boolean isCellEditable(int row, int column) {
	    return false;
	 }
	public static final String[] culomn  ={"���","��Ʒ���","��Ʒ����",
		  "��λ","����","�ۿ�","�ۺ󵥼�","����","���"};
	public static final Object[][] data  ={};
	//�˻��������ֶ�
	public static final String[] SPCulomns  ={"���","��Ʒ���","��Ʒ����",
		  "��λ","����","������","��������","�˻�����","���"};
	public static final String[] MultiSPCulomns  ={"��Ʒ���","��Ʒ����",
		  "��Ʒ����","��λ","����ͺ�","��ɫ","�Ƿ��ؼ�"};
	//��Ա��Ϣ������ֶ�
	public static final String[] hyculomn = {"��Ա���","��Ա����","��Ա����"};
	
}
