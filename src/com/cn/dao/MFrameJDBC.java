package com.cn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ������һЩ���ݵĶ�ȡ
 * @author Administrator
 *
 */
public class MFrameJDBC {
    
	/**
	 * �Ƿ��Զ��򿪽��������Ի���
	 * 1  Ϊ�ǣ�0 Ϊ��
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
	 * �ı��������״̬
	 * 1  Ϊ�ǣ�0 Ϊ��
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
	 * �Ƿ��Զ��򿪽��������Ի���
	 * ��ȡ�����û���Ȩ����
	 * user �û���
	 * @return  Ȩ�޼�, �ǻ��
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
	 * ��ȡ�����û���Ȩ����
	 * user �û���
	 * @return  Ȩ�޼�, �ǻ��
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
	 * ȡ���Ƿ��Զ����ݱ�־
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
	 * ȡ���Զ����ݱ�־ʱ��
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
	 * �����Զ����ݵı�־
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
			JOptionPane.showMessageDialog(null,"ϵͳ����");
		
		} finally{
			JDBCTool.freeResouse(st, conn);
		}

    }
	
	
	/**
	 * �����Զ����ݵ�ʱ��
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
			JOptionPane.showMessageDialog(null,"ϵͳ����");
		
		} finally{
			JDBCTool.freeResouse(st, conn);
		}
    }
	
}
