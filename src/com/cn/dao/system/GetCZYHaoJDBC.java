package com.cn.dao.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class GetCZYHaoJDBC {
      public static String getCZYHao(String name){
    	  String Id=null;
	  	  String sql = "select user_Id from tb_usernofo where  user_Name='"+name+"'";
	 	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				st = conn.createStatement();
					rs = st.executeQuery(sql);
					//获取表中的列数
				rs.next();
				Id=rs.getString(1);
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
    	  return Id;
      }
}
