package com.cn.model.kuchun;

public class CFKBModel {
	
	public static final String [] CFKBChaifenShangpin = {"主仓库","烟酒仓库","饮料仓库"};
	public static final String []itemsJBR = {"小李","小张","小王"};
	public static final String []itemsDJLX = {"商品拆分","商品捆绑"};
	
	/*
	 * 高级查询所用
	 */
	public static final String []itemsJBR1 = {"所有经办人","小李","小张","小王"};
	public static final String [] itemsCK1 = {"所有仓库","主仓库","烟酒仓库","饮料仓库"};
	
	public static final Object [][]dataCFKB1 = {};
	public static final String []colunmsCFKB1 =
	     {"拆分成的商品名称","单位","规格型号","颜色","单价","数量","总金额"};
	
	public static final Object [][]dataCFKB2 = {};
	public static final String []colunmsCFKB2 =
	     {"捆绑成的商品","单位","规格型号","颜色","成本价价","数量","总金额"};
	
	public static final Object [][]dataCFKB3 = {};
	public static final String []colunmsCFKB3 =
	     {"商品编号(大)","商品名称(大)","单位(大)","仓库(大)",
					"折分比率","商品编号(小)","商品名称(小)","单位(小)","仓库(小)","操作员"};
/*
 * 拆分商品总表查询
 */
	public static final Object [][]dataCFKB4 = {};
	public static final String []colunmsCFKB4 =
	     {"拆分单号","拆分日期","仓库名称","商品编号","商品名称","成本价",
		"数量","总金额","经办人","操作员","备注"};
	
/*
 * 捆绑总表查询
 */
	public static final Object [][]dataCFKB6 = {};
	public static final String []colunmsCFKB6 =
	     {"捆绑单号","捆绑日期","仓库名称","商品编号","商品名称","成本价",
		"数量","总金额","经办人","操作员","备注"};
	
	public static final Object [][]dataCFKB5 = {};
	public static final String []colunmsCFKB5 =
	     {"商品编号","商品名称","单价","数量","总金额","单位","规格","颜色"};
	
}
