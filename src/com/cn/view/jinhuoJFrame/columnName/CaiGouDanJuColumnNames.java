package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

public class CaiGouDanJuColumnNames {

	
	/*
	 *  采购单据查询
	 */
	private static String[] caigou = {"单据号","开单日期","供货商名称","仓库名称","应付金额","实付金额",
		"欠款金额","优惠金额","单据类型","原始单号","经办人","操作员","备注"};
	public static Vector table1_columnNames = 
		AllTableModel.getVectorFromObj(caigou);
	
	
	private static String[] xiangxi = {"商品编号","商品名称","单位",
		"单价","数量","总金额","规格型号","颜色"};
	public static Vector table2_columnNames = 
		AllTableModel.getVectorFromObj(xiangxi);
}