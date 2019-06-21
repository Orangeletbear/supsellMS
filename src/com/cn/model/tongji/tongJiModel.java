package com.cn.model.tongji;

public class tongJiModel {
	/*
	 * CaiGouTongJiMainFrame
	 */
	public static String danJuNames[]={"开单日期","业务员","业务类型","单号","应付金额","实付金额","仓库","供货商","操作员","注备"};
	public static String danJuColumn[][];
	public static String mingXiNames[]={"单号","日期","供货商","商品编号","商品名称","仓库","单位","单价","数量","总金额","规格","颜色","经办人"};
	public static String mingXiColumn[][];
	public static String huiZongNames[]={"商品编号","商品名称","单位","规格","颜色","数量","总金额","供货商名称"};
	public static String huiZongColumn[][];
	public static String xinXiNames[]={"商品编号","商品名称","单位","单价","数量","总金额","规格","颜色"};
	public static String xinXiColumn[][];
	/*
	 * GoodsXiaoShouTongJi
	 */
	public static String dtm1Names[]={"单据号","开单日期","商品编号","商品名称","供货商名称",
			"单位","销售单价","销售数量","总金额","利润","毛利率（%）","经办人",
			"仓库名称","客户名称","规格型号","颜色","生产厂商"};
	public static String dtm1Column[][];
	public static String dtm2Names[]={"商品编号","商品名称","供货商名称","销售数量","总销售额","利润","毛利率（%）","生产厂商"};
	public static String dtm2Column[][];
	public static String dtm3Names[]={"类别名称","销售数量","总销售额","利润","毛利率（5）"};
	public static String dtm3Column[][];
	public static String dtm4Names[]={"供货商名称","进货数量","进货金额","销售数量","销售金额","销售完成比率（%）","销售利润","毛利润"};
	public static String dtm4Column[][];
	public static String dtm5Names[]={"单据号","销售日期","商品编号","商品名称","单价","数量","总金额","利润","利润率（%）","单位","规格型号","颜色","仓库","经办人","客户名称"};
	public static String dtm5Column[][];
	public static String dtm6Names[]={"客户名称","销售数量","销售金额","销售利润","毛利润（%）"};
	public static String dtm6Column[][];
	public static String dtm7Names[]={"单据号","销售日期","商品编号","商品名称","单价","数量","总金额","利润","利润率（%）","单位","规格型号","颜色","仓库","经办人","客户名称"};
	public static String dtm7Column[][];
	/*
	 * KeHuXiaoShouTongJi
	 */
	public static String boxNames1[]={"今天","昨天","前天","最近七天","最近一个月","本月","上月","所有时间"};
	public static String zhangWuNames[]={"客户名称","日期","单号","类型","应收金额","实收金额","欠款金额","优惠金额","经办人","操作员","注备"};
	public static String zhangWuColumn[][];
	public static String shangPinNames[]={"商品编号","商品名称","单位","单价","数量","总金额","规格型号","颜色"};
	public static String shangPinColumn[][];
	public static String fuKuanNames[]={"客户名称","日期","单号","类型","收款金额","经办人","操作员","注备"};
	public static String fuKuanColumn[][];
	public static String huiZongNames1[]={"商品编号","商品名称","单位","销售数量","销售总金额","规格型号","颜色","生产厂商","注备"};
	public static String huiZongColumn1[][];
	public static String mingXiNames1[]={"客户名称","单据号","开单日期","单位","单价","数量","总金额","规格型号","颜色"};
	public static String mingXiColumn1[][];
	public static String keHuName[]={"客户名称","商品销售额","商品退货额","合计金额","我方应收金额","我方实收金额","未受金额"};
	public static String keHuColumn[][];
	public static String danJuNames1[]={"单据编号","单据日期","收款方式/类型","收款金额","客户名称","经办人","操作员","注备"};
	public static String danJuColumn1[][];
	/*
	 * KuCunMainFrame
	 */
	public static String kuCunNames[]={"结算时间","仓库名称","库存数量","库存总成本","进货数量","进货总金额","销售数量","销售总金额","销售利润"};
	public static String kuCunColumn[][];
	/*
	 * ShangPingCaiGouMainFrame
	 */
	public static String boxNames2[]={"今天","昨天","前天","最近七天","最近一个月","本月","上月","所有时间"};
	public static String tableNames[]={"单号","日期","供应商","商品名称","仓库","单位","单价","数量","总金额","规格型号","颜色","经办人"};
	public static String column[][];
	public static String huiZongName[]={"商品编号","商品名称","单位","数量","总金额","规格型号","颜色"};
	public static String column2[][];
	public static String tongJiName[]={"类别名称","采购数量","采购金额"};
	public static String column3[][];
	/*
	 * XiaoShouMainFrame
	 */
	public static String biaoGeNames[]={"商品编号","商品名称","销售数量","总销售额","利润","毛利率（%）","生产厂商"};
	public static String biaoGecolumn[][];
	/*
	 * YeWuYuanMainFrame
	 */
	public static String xiaoShouNames[]={"单据号","开单日期","业务员","仓库名称","单据说明","应收金额","实收金额","利润","毛利率（%）","操作员","客户名称","注备"};
	public static String xiaoShouColumn[][];
	public static String mingXiNames2[]={"商品编号","商品名称","单位","单价","数量","总金额","规格型号","颜色"};
	public static String mingXiColumn2[][];
	public static String yeJiNames[]={"业务员名称","销售金额","退货金额","合计金额","已回收金额","未回收金额"};
	public static String yeJiColumn[][];
	public static String yeJiXiNames[]={"客户名称","销售合计金额","已回收金额","未回收金额"};
	public static String yeJiXiColumn[][];
	public static String leiBieNames[]={"商品编号","商品名称","供货商名称","销售数量","总销售额","利润","毛利率（%）","业务员","生产厂商"};
	public static String leiBieColumn[][];
}
