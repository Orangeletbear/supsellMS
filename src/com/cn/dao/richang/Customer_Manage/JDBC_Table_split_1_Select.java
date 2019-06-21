package com.cn.dao.richang.Customer_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Table_split_1_Select {
	/**
	 * 获取销售商品编号，商品名称，单位，单价，数量，总金额
	 * @param TEXT
	 * @return
	 */
	public static Vector getTable_split_1_Select(String TEXT) {
		Vector data = new Vector();
    	String sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_dj,xs_d.xsd_num,xs_d.xsd_szje "+
    				 "from tb_sell_main xs,tb_sell_detail xs_d,tb_spinfo sp "+
    				 "where xs_d.xsd_id = sp.sp_id and xs_d.xsd_dh = xs.xs_id "+
    				 "and xs.xs_id = '" + TEXT +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
	/**
	 * 获取销售总（数量，总金额）
	 * @param TEXT
	 * @return
	 */
	public static Vector getTable_split_1_Select_sum(String TEXT) {
		Vector data = new Vector();
    	String sql = "select sum(xs_d.xsd_num),sum(xs_d.xsd_szje) "+
    				 "from tb_sell_main xs,tb_sell_detail xs_d,tb_spinfo sp "+
    				 "where xs_d.xsd_id = sp.sp_id and xs_d.xsd_dh = xs.xs_id "+
    				 "and xs.xs_id = '" + TEXT +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
			    
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
}
