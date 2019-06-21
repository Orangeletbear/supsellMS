package com.cn.model.kuchun;
/**
 * 当前库存中的列名
 * @author finey
 *
 */
public class KuCunKunCBDCulomns {

	
	//库存变动情况
	public static final String[] KuCunColumnName1 = {"商品编号", "商品名称", "单位",
		"库存量", "销售总数","上次进价(元)","成本均价(元)","预设售价(元)","库存总值(元)","规格型号","颜色","生产厂商","备注"};
	//商品变动情况
	public static final String[] KuCunColumnName2 = {"商品编号", "商品名称", "库存量",
            "进货数量", "退货数量(进货)","合计数量","销售数量", "退货数量(销售)","合计数量"};
	//商品信息查询
	public static final String[] KuCunColumnName3 = {"商品编号", "商品名称", "进货价",
        "销售价","单位", "规格型号","颜色","生产厂商","备注"};
	
	//库存查询明细查询
	public static final String[] KuCunDeTailFind = {"日期", "单据号", "说明(单据类型)",
        "供货商/客户","入库数", "出库数","单价(元)","总金额(元)","仓库","经办人","操作员"};
	public static final Object [][] data = {};
}
