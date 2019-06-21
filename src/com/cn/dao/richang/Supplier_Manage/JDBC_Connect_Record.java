package com.cn.dao.richang.Supplier_Manage;

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
     * 获取供货商GHS_ID
     * @param ghs_name
     * @return Vector
     */
    public static Vector get_GHS_ID(String ghs_name){
    	Vector data = new Vector();
    	String sql = "select ghs.ghs_id "+
    				 "from tb_ghsinfo ghs "+
    				 "where ghs.ghs_name = '" + ghs_name +"'";
		    				 
    	
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
     * 插入供货商联系
     * @param ghs_id,date,textarea,jbr
     */
    public static void Insert_GHS_CONNECT(String ghs_id,String date,String textarea,String jbr){
    	Vector data = new Vector();
//    	java.sql.Date d = DateStringTool.strToDate_sql(date);
    	String sql = "insert into tb_ghsconnect values('" + ghs_id + "', " +
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
     * 获取所有供应商联系表信息
     * @param 
     * @return Vector
     */
    public static Vector get_connect_ghs(String ghs_id){
    	Vector data = new Vector();
    	String sql = "select ghsc.ghsc_date,ghsc.ghsc_detail,ghsc.ghsc_jbr "+
    				 "from tb_ghsconnect ghsc "+
    				 "where ghsc.ghsc_ghs = '" + ghs_id +"'";
		    				 
    	
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
     * 删除供货商联系
     * @param ghs_id,date,textarea,jbr
     */
    public static void Del_GHS_CONNECT(String date,String textarea,String jbr){
    	Vector data = new Vector();
//    	java.sql.Date d = new java.sql.Date(DateStringTool.strToDate(date).getTime());
    	String sql = "delete from tb_ghsconnect " +
//    			"where ghsc_date = '" + d + "' and " +
    			"where ghsc_detail =  '" + textarea + "' and "+ 
    			"ghsc_jbr = '" + jbr + "'";
		    				 
    	
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
     * 修改供货商联系
     * @return Vector
     */
    public static void change_GHS_Connect(String str_text,String str_jbr,
    										String to_date,String to_text,String to_jbr){
    	String sql = "update tb_ghsconnect ghsc "+
    				 "set ghsc.ghsc_date = " + "to_date('" + to_date + "','YYYY-MM-DD'), "  +
    				     "ghsc.ghsc_detail = '" + to_text + "', "+
    				     "ghsc.ghsc_jbr = '" + to_jbr + "' "+
	    			 "where ghsc_detail =  '" + str_text + "' and "+ 
	    			 "ghsc_jbr = '" + str_jbr + "'";
		    				 
    	
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
