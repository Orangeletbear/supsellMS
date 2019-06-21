package com.cn.model.xiaoshou.guketuihuo;

public interface TuiHuoTabelCulomnModel{
	
	//顾客退货对话框中的顾客退货选项卡上的表名
	public static String[] BackColumNames = {"商品编号","商品名称","单位",
		"单价","数量","总金额","规格型号","颜色"};
	
	//顾客退货对话框中的退货查询选项卡上的表名
	public static String[] QueryColumnNames = {"单据号","开单日期",
		"客户名称","仓库名称","应收金额","实收金额","欠款金额","单据类型"
		,"经办人","操作人","备注"};
	
	//顾客退货对话框中的退货查询选项卡上的单据详细信息表的表名
	public static String[] DanJuColumnNames = {"商品编号","商品名称","单位",
		"单价","数量","总金额","规格型号","颜色"};
	
	public static final Object[][] obj={};
}
