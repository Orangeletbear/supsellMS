package com.cn.model.xiaoshou.postongji;

public interface POSXiaoShouCulomnModel {
	
	//POS销售统计对话框中的销售流水账对话框上单据流水表上的表名
	public static String[] danJuColumNames = {"销售日期","销售单号","总金额",
		"付款方式","优惠金额","收银员","经办人"};
	
	//POS销售统计对话框中的销售流水账对话框上商品明细表上的表名
	public static String[] mingXiColumNames = {"销售时间","单据号","会员编号",
		"会员名称","商品编号","商品名称","单价","打折率","数量","总金额","单位","规格型号","颜色","销售备注"};
	

	//POS销售统计对话框中的收银员收银统计对话框上收银员收银的表名
	public static String[] shouYinColumNames = {
		"收银员编号","收银员名称","应收金额","实收金额"};
	

	//POS销售统计对话框中的收银员收银统计对话框上收银员收银明细表上的表名
	public static String[] shouYinMingXiColumNames = {
		"销售单号","销售日期","应收金额","实收金额"};
	
   //POS销售统计对话框中的日结管理对话框表上的表名
	public static String[] riJieColumNames = {
		"单号","日结日期","数量","金额","操作员"};
	
	//POS销售统计对话框中销售排行对话框商品销售排行选项卡的表名
    public static String[] goodSalesRankingColumNames = {
    	"商品编号","商品名称","销售数量","总销售额","利润","毛利率(%)"};
	
	
	//POS销售统计对话框中销售排行对话框收银员销售排行选项卡的表名
     public static String[] salesRankingColumNames = {
    	 "收银员编号","收银员名称","销售数量","总销售额","利润","毛利率(%)"};
	
	
	//POS销售统计对话框中销售排行对话框表上商品类别销售排行选项卡的表名
	public static String[] categoryColumNames = {
		"类别编号","类别名称","销售数量","总销售额","利润","毛利率(%)"};
	  
	
	//POS销售统计 ————会员消费统计---销售单据信息表的表名
	public static String[] VIPConsumeColumNames = {
		                  "销售单号","销售日期","会员编号","会员姓名",
		                  "消费金额","销费方式","操作员","备注"};
	
	//POS销售统计 ————会员消费统计---销售单据详细信息表的表名
    public static String[] detailedInfoColumNames = {
    	                   "商品编号","商品名称","单价",
    	                   "打折率","数量","总金额","单位","规格型号","颜色"};
	
  //POS销售统计 ————会员消费统计---销售单据详细信息表的表名
    public static String[] goodsInfoColumNames = {
    	                   "商品编号","商品名称","数量","金额"};
	
    //POS销售统计———————POS出入款管理
    public static String[] chuRuKuanColumNames = {"单号","开单日期","入款金额"
	               ,"出款金额","单据类型","收银员","操作员"};
    
	//POS销售统计———————
	public static final Object[][] obj={};
}
