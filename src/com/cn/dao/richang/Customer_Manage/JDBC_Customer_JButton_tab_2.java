package com.cn.dao.richang.Customer_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Customer_JButton_tab_2 {
	/**
	 * 设置客户备注
	 * @param TEXT
	 * @return 
	 * @return
	 */
    public static void setBeiZhu(String TEXT){
    	String sql = "update tb_khinfo  set kh_bz = '" + TEXT + "' ";
		    				 
    	
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
}
