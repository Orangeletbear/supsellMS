package com.cn.dao.richang.Customer_Manage;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
/*
 * 工具栏上的单据查询JDBC交互
 */
public class JDBC_RiChang_GetCustomer {
 



	/**
	 * 客户综合管理(Customer_Manage)，和报价管理(Guote_Manage)在new JWindow_Customer_Manage
	 * 窗口中即不输入条件单击查询，默认为所有客户
	 * 
	 */
	public static Vector getCustomer(String TEXT){
    	Vector data = new Vector();
    	String sql = "SELECT kh_ID,kh_NAME,kh_LXR,kh_TELL,kh_ADDRESS " +
		    			"FROM tb_khinfo kh " +
		    			"WHERE ( kh.kh_Id LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_NAME LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_LXR LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_TELL LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_ADDRESS LIKE '%" + TEXT +"%' )";
		    				 
    	
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

}
	
	