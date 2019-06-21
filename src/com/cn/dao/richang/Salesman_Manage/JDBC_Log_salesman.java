package com.cn.dao.richang.Salesman_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Log_salesman {
	/**
     * ����ҵ��Ա��־
     * @param kh_id,date,textarea,jbr
     */
	public static void Insert_yg_LOG(String yg_id, String date,
			String textarea) {
		Vector data = new Vector();
    	String sql = "insert into tb_ygconnect values ('" + yg_id + "', " +
    			"to_date('" + date + "','YYYY-MM-DD'), " +
    			"'" + textarea + "') ";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
	}
	/**
     * ��ȡ��Ա��������־
     * @param 
     * @return Vector
     */
	public static Vector get_connect_yg(String yg_id) {
		Vector data = new Vector();
    	String sql = "select ygc.ygc_date,ygc.ygc_log "+
    				 "from tb_ygconnect ygc "+
    				 "where ygc.ygc_Id ='" + yg_id +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//��ȡ���е�����
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
	/**
     * ��ȡԱ��id
     * @param 
     * @return Vector
     */
	public static Vector get_id_yg(String yg_name) {
		Vector data = new Vector();
    	String sql = "select yg.yg_id "+
    				 "from tb_yginfo yg "+
    				 "where yg.yg_name ='" + yg_name +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
			    
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}

	/**
     * ɾ��Ա����־
     * @param 
     */
	public static void Del_yg_LOG(String date, String textarea) {
		Vector data = new Vector();
    	String sql = "delete from tb_ygconnect " +
    			"where ygc_log =  '" + textarea + "' ";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
				st.executeUpdate(sql);
//				rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
	}
	/**
     * �޸�Ա����־
     * @return Vector
     */
	public static void change_yg_Connect(String str_date,String str_text,
			String to_date, String to_text) {
    	String sql = "update tb_ygconnect ygc  "+
    				 "set ygc.ygc_date = to_date('" + to_date + "','YYYY-MM-DD'), "  +
    				     "ygc.ygc_log = '" + to_text +"' "+
    				     "where ygc.ygc_log = '" + str_text +"' "; 
	    			 
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
		
	}
}
