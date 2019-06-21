package com.cn.dao.richang.Guote_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Add_Guote_sp {
	/**
     * 修改商品报价
     * @return Vector
     */
    public static void change_bj(String id,String ghsbj,
    										String wfbj,String beizhu){
    	String sql = "update tb_spinfo sp "+
    				 "set sp.sp_jj = '"  + ghsbj +"'," +  
    				     "sp.sp_bz = '"  + beizhu +"'," +
    				     "sp.sp_sj = '" + wfbj + "'"+
    				 "where sp.sp_Id ='" + id + "' "; 
		    				 
    	
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
