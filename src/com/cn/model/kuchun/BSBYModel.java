package com.cn.model.kuchun;

public class BSBYModel {
	
	public static String []itemsDJLX = {"商品报损","商品报溢"};
	public static String []itemsCKMC = {"主仓库","烟酒仓库","饮料仓库"};
	public static String []itemsJBR = {"小李","小张","小王"};
	
	// 高级查询
	public static String []itemsCKMC1 = {"所有仓库","主仓库","烟酒仓 库","饮料仓库"};
	public static String []itemsJBR1 = {"所有经办人","小李","小张","小王"};
	
	public static Object [][]dataBSBY1 = {};
	public static String []colunmsBSBY1 = new String[]{"商品名称","单位","规格型号","颜色","单价","数量"};
	
	/*
	 * 报损查询
	 */
	public static Object [][]dataBSBY2 = {};
	public static String []colunmsBSBY2 = new String[]
	                         {"报损单号","报损日期","仓库名称","经办人","操作员","备注"};
	/*
	 * 报溢查询
	 */
	public static Object [][]dataBSBY4 = {};
	public static String []colunmsBSBY4 = new String[]
	                         {"报溢单号","报溢日期","仓库名称","经办人","操作员","备注"};
	
	public static Object [][]dataBSBY3 = {};
	public static String []colunmsBSBY3 = new String[]
	                         {"商品编号","商品名称","商品类别","单价","数量","总金额","单位","规格","颜色","备注"};

}
