/**
 * 
 */
package com.cn.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * 所有表
 * @author Administrator
 *
 */
public class AllTableModel extends DefaultTableModel {

	public AllTableModel() {
	}

	
	public AllTableModel(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AllTableModel(Vector arg0, int arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AllTableModel(Object[] arg0, int arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AllTableModel(Vector arg0, Vector arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AllTableModel(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
	}
	
	public boolean isCellEditable(int row, int column) {
	    return false;
	 }
	
	/*
	 * 将OBJ数组列转化为Vector列
	 */
	public static  Vector getVectorFromObj(Object [] obj){
		return AllTableModel.convertToVector(obj);
	}
	/*
	 * 将OBJ二维数组转化为Vector二维数据
	 */
	public static  Vector getVectorDataFromObj(Object [][] obj){
		return AllTableModel.convertToVector(obj);
	}
}
