package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

public class CaiGouDanJuColumnNames {

	
	/*
	 *  �ɹ����ݲ�ѯ
	 */
	private static String[] caigou = {"���ݺ�","��������","����������","�ֿ�����","Ӧ�����","ʵ�����",
		"Ƿ����","�Żݽ��","��������","ԭʼ����","������","����Ա","��ע"};
	public static Vector table1_columnNames = 
		AllTableModel.getVectorFromObj(caigou);
	
	
	private static String[] xiangxi = {"��Ʒ���","��Ʒ����","��λ",
		"����","����","�ܽ��","����ͺ�","��ɫ"};
	public static Vector table2_columnNames = 
		AllTableModel.getVectorFromObj(xiangxi);
}