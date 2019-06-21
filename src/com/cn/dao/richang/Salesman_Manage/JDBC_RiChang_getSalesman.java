package com.cn.dao.richang.Salesman_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/*
 * 工具栏上的单据查询JDBC交互
 */
public class JDBC_RiChang_getSalesman {
 



	/**
	 * 业务员管理(Salesman_Manage)，和报价管理(Guote_Manage)在new JWindow_Salesman_Manage
	 * 窗口中即不输入条件单击查询，默认为所有客户
	 * 
	 */
    public static Vector getSalesman(String TEXT){
    	Vector data = new Vector();
    	
    	String sql = "select yg.yg_Id,yg.yg_Name,yg.yg_zw,yg.yg_tell,yg.yg_address " +
						"from tb_yginfo yg " +
						"WHERE (  yg.yg_Id LIKE '%" + TEXT +"%' OR "+
								" yg.yg_Name LIKE '%" + TEXT +"%' OR "+
								" yg.yg_zw LIKE '%" + TEXT +"%' OR "+
								" yg.yg_tell LIKE '%" + TEXT +"%' OR "+
								" yg.yg_address LIKE '%" + TEXT +"%' )";
    	
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
	
	