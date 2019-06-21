package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 将所有经办人名字弄出来
 * 返回String数组
 * @author Administrator
 *
 */
public class JinBanRenJDBC {

	public static Vector find(){
		Vector name = new Vector();  
		
		String sql = " select yg.yg_name from tb_yginfo yg ";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			
			while(rs.next()){
					name.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

	
		return name;

	}
}
