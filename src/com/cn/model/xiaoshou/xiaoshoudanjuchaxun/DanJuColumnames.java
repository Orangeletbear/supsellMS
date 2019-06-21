package com.cn.model.xiaoshou.xiaoshoudanjuchaxun;

/**
 * 销售单据查询对话框中
 * 的所有表的表列名
 * @author Administrator
 *
 */
public interface DanJuColumnames {

	//详细单据表的表列名
	public static String[] mingXiBiaoColumnames= {"商品编号", "商品名称", "单位",
	"单价","数量","总金额","规格型号","颜色"};
	
	//单据总表的表列名
	public static String[] zongBiaoColumnames= {"单号", "开单日期", "客户名称",
		                  "仓库名称","应收金额","实收金额","欠款金额",
		                  "优惠金额","单据类型","原始单号","经办人","操作员","备注"};
	
	//详细查找按钮中的客户查找按钮所弹出的对话框中的表列名
	public static String[] keHuInfo = {"编号","客户名称","联系人","联系电话","联系地址"};
	public static final Object[][] obj={};
}
