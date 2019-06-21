package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 给个商品编号或商品名称，查这个商品（没查到，可以用来判断是新商品）
 * 返回查到的商品信息
 * @author Administrator
 *
 */
public class Tb_spinfoJDBC {

	/**
	 * 
	 * @param spID
	 * @return
	 */
	public static Vector find(String spID){
		
		Vector data = new Vector();
		String sql = "select * "+
	       " from tb_spinfo tb "+
	       " where tb.sp_id ='"+spID+"'";

		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			int lieshu = rs.getMetaData().getColumnCount();//统计列数
			
			while(rs.next()){
				for(int i = 1; i <= lieshu ; i ++){
					data.add( rs.getObject(i));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
}
