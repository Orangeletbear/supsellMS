package com.cn.dao.richang.Guote_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Query_sp {
	
	public static Vector Query_sp_bj(String TEXT){
		Vector data = new Vector();
		String sql = "select sp_Id,sp_Name,sp_tjdateFrom,sp_jj,sp_sj,sp_dw,sp_ggxh,sp_color,sp_bz "+
					 "from tb_spinfo " +
	    			 " WHERE sp_id = '" + TEXT +"'";
		    				 
		
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
	public static Vector Query_sp_bj_kind(String TEXT,String str_date,String to_date){
		Vector data = new Vector();
		String sql;
		if(TEXT.equals("全部商品")){
			sql = "select sp_Id,sp_Name,sp_tjdateFrom,sp_jj,sp_sj,sp_dw,sp_ggxh,sp_color,sp_bz "+
			 "from tb_spinfo  " +  
			 		"where (sp_tjdateFrom between " +
			 				"TO_DATE('"+ str_date +"','YYYY-MM-DD') and " +
			 						"TO_DATE('"+ to_date +"','YYYY-MM-DD'))";
		}else{
			sql = "select sp_Id,sp_Name,sp_tjdateFrom,sp_jj,sp_sj,sp_dw,sp_ggxh,sp_color,sp_bz "+
			 "from (select * "+
			 "from tb_spinfo sp,tb_sblb lb " +  
			 "WHERE lb.sblb_Name LIKE '" + TEXT + "' and " +  
			 		" sp.sp_lb = lb.sblb_Id) " +
			 		"where (sp_tjdateFrom between " +
			 				"TO_DATE('"+ str_date +"','YYYY-MM-DD') and " +
			 						"TO_DATE('"+ to_date +"','YYYY-MM-DD'))";
		}
		
					
		    				 
		
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
