package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/**
 * 公用的一段JDBC
 * @author Administrator
 */

public class NomalJDBC {

	
	public static Vector gongJu(String sql){
		Vector data = new Vector();
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			int lieshu = rs.getMetaData().getColumnCount();//统计列数
			
			while(rs.next()){
				Vector argVector = new Vector();
				for(int i = 1; i <= lieshu ; i ++){
					argVector.add( rs.getObject(i));
				}
				data.add(argVector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
}
