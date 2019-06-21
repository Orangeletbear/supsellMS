package com.cn.dao.richang.Guote_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Guote_Manage {
	public static Vector get_sp_select(String TEXT){
		Vector data = new Vector();
		String sql = "select sp_Id,sp_Name,sp_jj,sp_sj,sp_dw,sp_ggxh,sp_color "+
					 "from tb_spinfo " +
	    			 " WHERE ( sp_Id LIKE '%" + TEXT +"%' OR "+
    				  " sp_Name LIKE '%" + TEXT +"%' OR "+
    				  " sp_jj LIKE '%" + TEXT +"%' OR "+
    				  " sp_sj LIKE '%" + TEXT +"%' OR "+
    				  " sp_dw LIKE '%" + TEXT +"%' OR "+
    				  " sp_ggxh LIKE '%" + TEXT +"%' OR "+
    				  " sp_color LIKE '%" + TEXT +"%' )";
		    				 
		
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
	
	public static Vector get_sp_select_kind(String TEXT,String kind){
		Vector data = new Vector();
		String sql = "select sp.sp_Id,sp.sp_Name,sp.sp_jj,sp.sp_sj,sp.sp_dw,sp.sp_ggxh,sp.sp_color "+
					 "from (select * "+
					 "from tb_spinfo sp,tb_sblb lb " +  
	    			 "WHERE lb.sblb_Name LIKE '" + kind + "' and " +  
	    			 		" sp.sp_lb = lb.sblb_Id) sp"  +
					 
	    			 " WHERE ( sp_Id LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_Name LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_jj LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_sj LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_dw LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_ggxh LIKE '%" + TEXT +"%' OR "+
    				  " sp.sp_color LIKE '%" + TEXT +"%')";
//		"(select * "+
//		"from tb_spinfo " +
//		"where sp_lb ='" + kind + "')"
		    				 
		
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
