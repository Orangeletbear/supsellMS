package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

/**
 * �ɹ��˻��б������
 * @author Administrator
 *
 */
public class CaiGouTuiHuoColumn {

	/*
	 * �˻���ѯ�м��� center_data
	 */
	private static String[] danju = {"���ݺ�","��������","����������","�ֿ�����","Ӧ�����","ʵ�����",
		"Ƿ����","�Żݽ��","��������","ԭʼ����","������","����Ա","��ע"};
	public static Vector center_ColumnNames = 
	AllTableModel.getVectorFromObj(danju);
	
	/*
	 * south_data
	 */
	private static String[] danjuxiangxi = {"��Ʒ���","��Ʒ����","��λ",
		"����","����","�ܽ��","����ͺ�","��ɫ"};
	public static Vector south_ColumnNames = 
	AllTableModel.getVectorFromObj(danjuxiangxi);
}
