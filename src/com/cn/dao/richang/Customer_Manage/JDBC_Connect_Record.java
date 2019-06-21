package com.cn.dao.richang.Customer_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Connect_Record {
	/**
     * 获取所有经办人
     * @param 
     * @return Vector
     */
    public static Vector get_jbr(){
    	Vector data = new Vector();
    	String sql = "select yg_Name "+
    				 "from tb_yginfo ";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
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
    /**
     * 获取客户KH_ID
     * @param kh_name
     * @return Vector
     */
	public static Vector get_kh_ID(String kh_name) {
		Vector data = new Vector();
    	String sql = "select kh.kh_id "+
    				 "from  tb_khinfo kh "+
    				 "where kh.kh_name = '" + kh_name +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
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
	/**
     * 插入客户联系
     * @param kh_id,date,textarea,jbr
     */
	public static void Insert_kh_CONNECT(String kh_id, String date,
			String textarea, String jbr) {
		Vector data = new Vector();
//    	java.sql.Date d = DateStringTool.strToDate_sql(date);
    	String sql = "insert into tb_khconnect values ('" + kh_id + "', " +
    			"to_date('" + date + "','YYYY-MM-DD'), " +
//    			"'" + d + "'" +
    			"'" + textarea + "', " + 
    			"'" + jbr + "')";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
	}
	/**
     * 获取所有客户联系表信息
     * @param 
     * @return Vector
     */
	public static Vector get_connect_kh(String kh_id) {
		Vector data = new Vector();
    	String sql = "select khc.khc_date,khc.khc_detail,khc.khc_jbr "+
    				 "from tb_khconnect khc "+
    				 "where khc.khc_Id ='" + kh_id +"'";
		    				 
    	
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
     * 删除客户联系
     * @param kh_id,date,textarea,jbr
     */
	public static void Del_kh_CONNECT(String date, String textarea, String jbr) {
		Vector data = new Vector();
//    	java.sql.Date d = new java.sql.Date(DateStringTool.strToDate(date).getTime());
    	String sql = "delete from tb_khconnect " +
//    			"where ghsc_date = '" + d + "' and " +
    			"where khc_detail =  '" + textarea + "' and "+ 
    			"khc_jbr = '" + jbr + "'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
				st.executeUpdate(sql);
//				rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
	}
	/**
     * 修改客户联系
     * @return Vector
     */
	public static void change_kh_Connect(String str_text, String str_jbr,
			String to_date, String to_text, String to_jbr) {
    	String sql = "update tb_khconnect khc "+
    				 "set khc.khc_date = " + "to_date('" + to_date + "','YYYY-MM-DD'), "  +
    				     "khc.khc_detail = '" + to_text + "', "+
    				     "khc.khc_jbr = '" + to_jbr + "' "+
	    			 "where khc_detail =  '" + str_text + "' and "+ 
	    			 "khc_jbr = '" + str_jbr + "'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
		
	}
}
