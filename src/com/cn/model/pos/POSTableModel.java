package com.cn.model.pos;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
/*
 * 自定义表模式
 */
public class POSTableModel extends DefaultTableModel {

	public POSTableModel() {
	}

	public POSTableModel(int arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Vector arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Object[] arg0, int arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Vector arg0, Vector arg1) {
		super(arg0, arg1);
	}

	public POSTableModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
	}
    //不可通过双击改变单元格数据
	public boolean isCellEditable(int row, int column) {
	    return false;
	 }
	public static final String[] culomn  ={"序号","商品编号","商品名称",
		  "单位","单价","折扣","折后单价","数量","金额"};
	public static final Object[][] data  ={};
	//退货单的列字段
	public static final String[] SPCulomns  ={"序号","商品编号","商品名称",
		  "单位","单价","打折率","可退数量","退货数量","金额"};
	public static final String[] MultiSPCulomns  ={"商品编号","商品名称",
		  "商品条码","单位","规格型号","颜色","是否特价"};
	//会员信息表的列字段
	public static final String[] hyculomn = {"会员编号","会员名称","会员级别"};
	
}
