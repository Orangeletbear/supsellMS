package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 将供货商名改成供货商id
 * @author Administrator
 *
 */
public class Tb_gongHuoShangJDBC {
	public static String change(String gonghuoshang){
		String id = null;
		
		String sql = " select gh.ghs_id "+
 		" from tb_ghsinfo gh "+
		" where gh.ghs_name = '"+gonghuoshang+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			while(rs.next()){
				id = rs.getString(1); 
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
