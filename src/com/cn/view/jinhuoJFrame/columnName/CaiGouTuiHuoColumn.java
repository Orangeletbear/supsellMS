package com.cn.view.jinhuoJFrame.columnName;

import java.util.Vector;

import com.cn.model.AllTableModel;

/**
 * 采购退货中表格列名
 * @author Administrator
 *
 */
public class CaiGouTuiHuoColumn {

	/*
	 * 退货查询中间表格 center_data
	 */
	private static String[] danju = {"单据号","开单日期","供货商名称","仓库名称","应付金额","实付金额",
		"欠款金额","优惠金额","单据类型","原始单号","经办人","操作员","备注"};
	public static Vector center_ColumnNames = 
	AllTableModel.getVectorFromObj(danju);
	
	/*
	 * south_data
	 */
	private static String[] danjuxiangxi = {"商品编号","商品名称","单位",
		"单价","数量","总金额","规格型号","颜色"};
	public static Vector south_ColumnNames = 
	AllTableModel.getVectorFromObj(danjuxiangxi);
}
