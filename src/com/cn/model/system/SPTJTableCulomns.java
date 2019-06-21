package com.cn.model.system;
/**
 * 商品调价对话框上的表字段
 * @author finey
 *
 */
public class SPTJTableCulomns {
	//商品调价第一个表的列名字段
	public static final String[] ColumnName11 = {"商品编号", "商品名称", "单价",
        "预设进价", "预设售价","规格型号","颜色","最低库存", "是否特价商品","会员价",
        "特价","特价期限","开始日期","结束日期","暂停使用否"," 打折率","生产厂商","备注"};

	//商品调价第二个表的列名字段
	public static final String[] ColumnName12= {"顾客类别","商品名称","零售单价",
		"商品折扣","顾客折扣", "单项折扣","最终折扣", "特价否","顾客特价","最终单价"};
	//商品调价第三个表的列名字段
	public static final String[] ColumnName2 = {"调价时间", "高品编号", "高品名称",
        "商品内容"};
	public static final Object[][] data = {};
	
	public static final String[] SPTLColumnName = {"商品编号", "商品名称", "类别",
		"商品条码","单位","单位关系","规格型号","颜色","保质期(天)","状态(1可用)","是否特价商品",
		"最低库存","预设进价", "预设售价","商品折扣","生产厂商","备注"};
      

}
