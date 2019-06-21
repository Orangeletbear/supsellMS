package com.cn.dao.xiaoshou.xiaoshoudanjuchaxun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 查询所有客户信息
 * @author Administrator
 *
 */
public class JDBCFindKeHuInfo {

	public static Vector getData(){
		Vector data = new Vector();
		
		String sql = null;
		
		sql = "select kh_Id,kh_Name,kh_lxr,kh_tell,kh_address" +
			    " from tb_khinfo";
		

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
	
	

	/**
	 * 按客户编号查询客户信息，支持模糊查询
	 * @author Administrator
	 *
	 */

		public static Vector getkeHuData(String khId){
			Vector data = new Vector();
			
			String sql = null;
			
			sql = "select kh_Id,kh_Name,kh_lxr,kh_tell,kh_address" +
				    " from tb_khinfo" +
				    " where kh_Id like'%"+khId+"%'";
			

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
