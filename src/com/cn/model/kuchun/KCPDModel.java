package com.cn.model.kuchun;

public class KCPDModel {
	
	public static final Object [][]dataKCPD1 = {};
	public static final String []colunmsKCPD1 
					={"盘点单号","仓库名称","日期","操作员","商品条数","商品数量","备注"};
	
	public static final Object [][]dataKCPD2 = {};
	public static final String []colunmsKCPD2 
					={"商品编号","商品名称","商品类别",
						"单位","规格型号","生产厂商","库存数量","盘点数量"};
	public static final Object [][]dataKCPD3 = {};
	public static final String []colunmsKCPD3 
					={"盘点单号","盘点日期","商品编号","商品名称","商品类别",
						"单位","规格型号","库存数量","盘点数量","仓库名称"};
	
	public static final String [] itemsCKMC ={"所有仓库","主仓库","酒库","饮料库"};
	
	public static final String [] itemsCZY ={"所有操作员","admin","pos","peng_shao"};
	
	public static final String [] itemsCKMC1 ={"主仓库","酒库","饮料库"};
	
	public static final String [] itemsCZY1 ={"admin","pos","peng_shao"};
	/////盘点单，录入盘点商品库存商品
	public static final Object [][]dataKCSP = {};
	public static final String []colunmsKCSP
					= {"商品编号","商品名称",
						"单位","规格型号","库存数量"};
/////盘点单，录入盘点商品已盘商品
	public static final Object [][]dataYPSP = {};
	public static final String []colunmsYPSP 
					= {"商品编号","商品名称",
						"单位","规格型号","库存数量","盘点数量"};
	
	/////////////盘盈盘亏
	public static final Object [][]dataPYPK1 = {};
	public static final String []colunmsPYPK1 
					={"盘点单号","仓库名称","日期","操作员","商品条数","商品数量","备注"};
	
	public static final Object [][]dataPYPK2 = {};
	public static final String []colunmsPYPK2 
					={"商品编号","商品名称",
							"单位","规格型号","盘点数量","所在仓库"};
	
	public static final Object [][]dataPYPK3 = {};
	public static final String []colunmsPYPK3
					={"商品编号","商品名称",
							"单位","规格型号","盘点数量","库存数量","差异数量","所在仓库"};
	
	public static final Object [][]dataPYPK4 = {};
	public static final String []colunmsPYPK4 
					={"商品编号","商品名称",
							"单位","规格型号","库存数量","所在仓库"};
}
