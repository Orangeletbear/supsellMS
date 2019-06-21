package com.cn.dao.richang.Guote_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Select_sp {
	public static Vector get_select_sp_kind(String TEXT){
		Vector data = new Vector();
		String sql;
		if(TEXT.equals("所有类别")){
			sql = "select sp.sp_Id,sp.sp_Name,sp.sp_jj,sp.sp_sj,sp.sp_dw,sp.sp_ggxh "+
			 "from tb_spinfo sp";
		}else{
			sql = "select sp.sp_Id,sp.sp_Name,sp.sp_jj,sp.sp_sj,sp.sp_dw,sp.sp_ggxh "+
			 "from tb_spinfo sp,tb_sblb lb " +
			 " WHERE lb.sblb_Name LIKE '%" + TEXT +"%' and " +
			 		"sp.sp_lb = lb.sblb_Id" ;
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
