package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

public class ColumnNames {
	/*
	 *  采购进货中供货商后面那个放大镜按钮所触发的window所包含的表
	 */
	private static String[] gonghuoshang = {"编号","供货商名称","联系人",
			"联系电话","联系地址"};
	public static Vector gonghuoshang_columnNames = 
		AllTableModel.getVectorFromObj(gonghuoshang);
	
	
	/*
	 *  商品信息（采购进货）JDialog，从属于 增加商品（采购进货）--普通供货商供货记录
	 */
	private static String[] gonghuojilu = {"供货日期","单据号","单位",
			"采购单价","数量","总金额",};
	public static Vector gonghuojilu_columnNames = 
		AllTableModel.getVectorFromObj(gonghuojilu);
	/*
	 *  采购进货中，腌菜写的那个面板上的table-----老商品添加
	 */
	private static String[] splbtable = {"商品编号","商品名称","单位",
		"规格型号","参考进价","库存数","参考售价"};
	public static Vector splbtable_colunm = 
		AllTableModel.getVectorFromObj(splbtable);
	/*
	 *  采购进货中，腌菜写的那个面板上右边的table
	 */
	private static String[] splbtable1 = {"商品编号","商品名称","单位","进价",
		"数量","总金额"};
	public static Vector splbtable1_colunm = 
		AllTableModel.getVectorFromObj(splbtable1);
	
	/*
	 * 采购进货主界面的表列名
	 */
	public static String[] caiGouJinHuo = {"商品编号","商品名称","单位","规格型号",
		"颜色","单价","数量","总金额"};
	public static Vector caiGouJinHuo_columns = 
		AllTableModel.getVectorFromObj(caiGouJinHuo);
	
	/*
	 * 树形面板界面
	 */
	private static String[] gun = {"商品编号","商品名称","单位",
		"参考进价","规格","颜色","参考进价","库存"};
	public static Vector spqdtable_columnName = 
		AllTableModel.getVectorFromObj(gun);
	
	
}
