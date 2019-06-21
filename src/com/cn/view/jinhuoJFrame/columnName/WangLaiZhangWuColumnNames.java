package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

public class WangLaiZhangWuColumnNames {

/*
 * 第一个表
 */
	private static String[] danJu = {"供货商名称","日期","单号",
		"类型","应付金额","实付金额","欠款金额","优惠金额","经办人","操作员","备注"};
	public static Vector wanglaizhangwu_danJu = 
		AllTableModel.getVectorFromObj(danJu);
	
/*
 * 第二个表	
 */
	private static String[] xiangDan = {"商品编号","商品名称","单位",
		"单价","数量","总金额","规格型号","颜色"};
	public static Vector wanglaizhangwu_xiangDan = 
		AllTableModel.getVectorFromObj(xiangDan);
	
/*
 * 第三个表
 */
	private static String[] fuKuan = {"供货商名称","日期","单号",
		"类型","付款金额","经办人","操作员","备注"};
	public static Vector wanglaizhangwu_fuKuan = 
		AllTableModel.getVectorFromObj(fuKuan);

/**
 * 第二个面板
 */
	private static String[] huizong = {"商品编号","商品名称","单位",
		"数量","总金额","规格型号","颜色","生产厂商","备注"};
	public static Vector wanglaizhangwu_huizong = 
		AllTableModel.getVectorFromObj(huizong);
	
/**
 * 
 */
	private static String[] panel3 = {"商品编号","商品名称","单位",
		"销售数量","销售总金额","利润","毛利率%","规格型号","颜色","生产厂商","备注"};
	public static Vector wanglaizhangwu_panel3 = 
		AllTableModel.getVectorFromObj(panel3);
	
/**
 * 
 */
	private static String[] panel4 = {"供货商名称",
		"商品销售额","商品退货额","合计金额","商品进货额","我方应付金额","我方实付金额","未付金额"};
	public static Vector wanglaizhangwu_panel4 = 
		AllTableModel.getVectorFromObj(panel4);

/**
 * 
 */
	private static String[] panel5 = {"单据编号","单据日期","付款方式/类型",
		"付款金额","供货商名称","经办人","操作员","备注"};
	public static Vector wanglaizhangwu_panel5 = 
		AllTableModel.getVectorFromObj(panel5);
}
