package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 只是为了将仓库名换成id
 * @author Administrator
 *
 */
public class Tb_ckinfoJDBC {

	public static String find(String spName){
		String id =null;
		
		String sql = " select ck.ck_id "+
		" from tb_ckinfo ck "+
		" where ck.ck_name = '"+spName+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			
			while(rs.next()){
					id = rs.getObject(1).toString();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

		
		return id;
	}
}
