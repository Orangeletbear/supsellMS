package com.cn.dao.loginandmainframe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

/*
 * 取得表中POS的操作名
 */
public class JDBCPOSGetUserName {
	JDBCPOSGetUserName(){
		
	}
	/*
	 * 返回用户名
	 */
	public static String[] getUserName(){
		String [] name = null;
		Vector data = new Vector();
		String sql = "select user_Name from tb_usernofo where user_isPos = '1'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				data.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		name = new String [data.size()];
		for(int i =0;i<data.size();i++){
			name[i] = data.get(i).toString();
		}
		return name;
	}
	
	
}
