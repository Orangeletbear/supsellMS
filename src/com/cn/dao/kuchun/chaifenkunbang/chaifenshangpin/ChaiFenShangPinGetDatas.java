package com.cn.dao.kuchun.chaifenkunbang.chaifenshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

/**
 * 商品拆分界面中的数据库交互
 * @author Administrator
 */

public class ChaiFenShangPinGetDatas {
	
	/*
	 * 根据商品单号获取商品的成本价即单价
	 */
	public static String getChengben(String str){
		String dj = null;
		Connection conn = JDBCTool.getConnection();
		String sql = null;
		if(str.matches("\\d+")){
			sql = "select sp.sp_dj from tb_spinfo sp" +
			" where sp.sp_id = '" + str + "'";
		}else{
			sql = "select sp.sp_dj from tb_spinfo sp" +
			" where sp.sp_name = '" + str + "'";
		}
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					dj = rs.getString("sp_dj");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return dj;
	} 
	
	/*
	 * 通过商品名称获取商品编号,库存，备注并将结果交互到弹出的商品信息中
	 */
	public static Vector getSPInof(String name){
		Connection conn = JDBCTool.getConnection();
		Vector vo = new Vector();
		String sql = "select sp.sp_id,sp.sp_zdkc,sp.sp_bz from tb_spinfo sp" +
		" where sp.sp_name = '" + name + "'";;
		String id = null;
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					int column = rs.getMetaData().getColumnCount();
					for(int i = 1; i <= column; i ++ ){
						vo.add(rs.getString(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return vo;
	}
}
