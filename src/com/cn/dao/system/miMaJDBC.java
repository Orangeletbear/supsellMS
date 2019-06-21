package com.cn.dao.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/**
 * 操作员与数据库交互问题
 * @author finey
 *
 */
public class miMaJDBC {
	

	/**
	 * 查出所有操作员信息
	 * @return
	 */
	public static String  getData(String name){
		   String miMa=null;
	  	  String sql = "select user_PSW from tb_usernofo where  user_Name='"+name+"'";
	 	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				st = conn.createStatement();
					rs = st.executeQuery(sql);
					//获取表中的列数
				rs.next();
				miMa=rs.getString(1);
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
	 	return miMa;
	   }
	
}