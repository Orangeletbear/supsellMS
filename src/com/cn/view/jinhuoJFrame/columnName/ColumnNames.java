package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

public class ColumnNames {
	/*
	 *  �ɹ������й����̺����Ǹ��Ŵ󾵰�ť��������window�������ı�
	 */
	private static String[] gonghuoshang = {"���","����������","��ϵ��",
			"��ϵ�绰","��ϵ��ַ"};
	public static Vector gonghuoshang_columnNames = 
		AllTableModel.getVectorFromObj(gonghuoshang);
	
	
	/*
	 *  ��Ʒ��Ϣ���ɹ�������JDialog�������� ������Ʒ���ɹ�������--��ͨ�����̹�����¼
	 */
	private static String[] gonghuojilu = {"��������","���ݺ�","��λ",
			"�ɹ�����","����","�ܽ��",};
	public static Vector gonghuojilu_columnNames = 
		AllTableModel.getVectorFromObj(gonghuojilu);
	/*
	 *  �ɹ������У����д���Ǹ�����ϵ�table-----����Ʒ���
	 */
	private static String[] splbtable = {"��Ʒ���","��Ʒ����","��λ",
		"����ͺ�","�ο�����","�����","�ο��ۼ�"};
	public static Vector splbtable_colunm = 
		AllTableModel.getVectorFromObj(splbtable);
	/*
	 *  �ɹ������У����д���Ǹ�������ұߵ�table
	 */
	private static String[] splbtable1 = {"��Ʒ���","��Ʒ����","��λ","����",
		"����","�ܽ��"};
	public static Vector splbtable1_colunm = 
		AllTableModel.getVectorFromObj(splbtable1);
	
	/*
	 * �ɹ�����������ı�����
	 */
	public static String[] caiGouJinHuo = {"��Ʒ���","��Ʒ����","��λ","����ͺ�",
		"��ɫ","����","����","�ܽ��"};
	public static Vector caiGouJinHuo_columns = 
		AllTableModel.getVectorFromObj(caiGouJinHuo);
	
	/*
	 * ����������
	 */
	private static String[] gun = {"��Ʒ���","��Ʒ����","��λ",
		"�ο�����","���","��ɫ","�ο�����","���"};
	public static Vector spqdtable_columnName = 
		AllTableModel.getVectorFromObj(gun);
	
	
}
