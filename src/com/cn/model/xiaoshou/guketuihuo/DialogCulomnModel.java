package com.cn.model.xiaoshou.guketuihuo;

public interface DialogCulomnModel {
	
	//商品信息（销售退货）对话框上的表的列名
	public static Object[] columNames = {"消费日期","单据号","单位",
		"销售单价","数量","总金额"};
	
	//增加商品(销售退货)对话框上的左边面板上的表的列名
	public static final Object[] leftColumnName= {"商品编号", "商品名称", "单位",
       "规格","颜色","参考进价","库存"};
	
	//增加商品(销售退货)对话框上的右边面板上的表的列名
	public static final Object[] rightColumnName2 = {"商品名称", "单位","单价",
		"数量", "总金额"};
	public static final Object[][] obj={};
}
