package com.cn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 主界面一些数据的读取
 * @author Administrator
 *
 */
public class MFrameJDBC {
    
	/**
	 * 是否自动打开今日提醍对话框
	 * 1  为是，0 为否
	 * @return
	 */
	public static String getIsTodayRemind(){
		
 
    	String sql = "select ot.tb_isreal from tb_other ot " +
    			  " where ot.tb_name = 'Taday_Remind'";
    	
    	String data = null;
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			rs.next();
			data = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
	
	/**
	 * 改变今日提醍状态
	 * 1  为是，0 为否
	 * @return
	 */
	public static void changeTodayRemind(String change){
		
 
    	String sql = "update tb_other ot set ot.tb_isreal = " +
    			"'"+change+"'  where ot.tb_name = 'Taday_Remind'";
    	
    	String data = null;
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		try {
			st = conn.createStatement();
			st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally{
			JDBCTool.freeResouse(st, conn);
		}
 
    }
	
	/**
	 * 是否自动打开今日提醍对话框
	 * 获取给定用户的权根集
	 * user 用户名
	 * @return  权限集, 是或否
	 */
	public static String[] getPrivateForUser(String user){
		
        String[] data = new String [6];
        
    	String sql = "select * from tb_czy_qx qx where qx.czy_id = "+
    					" ( select us.user_id from tb_usernofo us  "+
    					" where us.user_name = '"+user+"')";
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			rs.next();
			for(int i = 0;i<6;i++){
				data[i] = rs.getString(i+2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
	
	/**
	 * 
	 * 获取给定用户的权根集
	 * user 用户名
	 * @return  权限集, 是或否
	 */
	public static String[] getUser(){
		
        String[] data =null;
        
    	String sql = " select us.user_name from tb_usernofo us " +
    			" where user_isPos = '0' ";
    					
    	Vector Data1 = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			
			while(rs.next()){
				Data1.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
		
		data = new String[Data1.size()];
		for(int i = 0;i< Data1.size();i++){
			data[i] =  Data1.get(i).toString();
		}
		
    	return data;
    }
	
	/**
	 * 取出是否自动备份标志
	 * @return  
	 */
	public static String getIsAutoBakeData(){
		
        String data = null;
    	String sql = " select ot.tb_isreal from tb_other ot " +
    			  " where ot.tb_name = 'AutoBakeData'";
    					
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			
			rs.next();
			data = rs.getString(1);	
		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
		
		
    	return data;
    }
	
	/**
	 * 取出自动备份标志时间
	 * @return  
	 */
	public static String getIsAutoBakeDataTime(){
		
        String data = null;
    	String sql = " select ot.tb_isreal from tb_other ot " +
    			  " where ot.tb_name = 'BakeTime'";
    					
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			
			rs.next();
			data = rs.getString(1);	
		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

    	return data;
    }
	
	/**
	 * 更新自动备份的标志
	 * @return  
	 */
	public static void updateAutoBakeData(String data){
		
    	String sql = " update tb_other ot set ot.tb_isreal = '"+data+"'" +
    			" where ot.tb_name = 'AutoBakeData'";
    					
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		try {
			st = conn.createStatement();
            st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"系统错误");
		
		} finally{
			JDBCTool.freeResouse(st, conn);
		}

    }
	
	
	/**
	 * 更新自动备份的时间
	 * @return  
	 */
	public static void updateAutoBakeDataTime(String data){
		
    	String sql = " update tb_other ot set ot.tb_isreal = '"+data+"'" +
    			" where ot.tb_name = 'BakeTime'";
    					
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		try {
			st = conn.createStatement();
            st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"系统错误");
		
		} finally{
			JDBCTool.freeResouse(st, conn);
		}
    }
	
}
