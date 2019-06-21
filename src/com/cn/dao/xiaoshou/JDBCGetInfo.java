package com.cn.dao.xiaoshou;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ��������ݿ��л�ȡһЩ������Ϣ
 * @author Administrator
 *
 */
public class JDBCGetInfo {

	/**
	 * ������ȡ���вֿ������
	 * @return 
	 */
	public static Vector getCangKuData(){
		Vector data = new Vector();
		
		String sql = null;
		sql = "select ck_Name from tb_ckinfo";
		
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   st = conn.createStatement();
    		   rs = st.executeQuery(sql);
    			//��ȡ���е�����
    			int columnCount = rs.getMetaData().getColumnCount();
    			while(rs.next()){
    				
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
	 * ��ȡ����Ա��������
	 * @return
	 */
	public static Vector getJingBanRenData(){
		Vector data = new Vector();
		
		String sql = null;
		sql = "select yg_Name from tb_yginfo";
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   st = conn.createStatement();
    		   rs = st.executeQuery(sql);
    			//��ȡ���е�����
    			int columnCount = rs.getMetaData().getColumnCount();
    			while(rs.next()){
    				
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
	 * ���ݿͻ����ƻ�ȡ�ͻ���Id
	 * @param keHuName
	 * @return
	 */
	
	public static Object getKeHuId(String keHuName){
		Object keHuId = null;
		
		String sql = null;
		sql = "select kh_Id from tb_khinfo where kh_Name = '"+keHuName+"'";
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   st = conn.createStatement();
    		   rs = st.executeQuery(sql);
    		   if(rs.next()){
    			   keHuId =  rs.getObject(1);
    		   }
    		
    			
    	} catch (SQLException e) {
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
    		
    	} finally{
    		JDBCTool.freeResorse(rs, st, conn);
    	}
    	return keHuId;
	}
	
	/**
	 * ���ݲֿ����ƻ�ȡ�ֿ��Id
	 * @param keHuName
	 * @return
	 */
	
	public static Object getcangKuId(String cangKuName){
		Object cangKuId = null;
		
		String sql = null;
		sql = "select ck_Id from tb_ckinfo where ck_Name = '"+cangKuName+"'";
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   st = conn.createStatement();
    		   rs = st.executeQuery(sql);
    		   if(rs.next()){
    			   cangKuId =  rs.getObject(1);
    		   }
    		 
    			
    	} catch (SQLException e) {
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
    		
    	} finally{
    		JDBCTool.freeResorse(rs, st, conn);
    	}
    	return cangKuId;
	}
	/**
	 * ͨ����Ʒ��ID����ȡ����
	 */
	public static Object getKuCun(String spId){
        Object kuCun = null;
		
		String sql = null;
		sql = "select sp_zdkc from tb_spinfo where sp_Id = '"+spId+"'";
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   st = conn.createStatement();
    		   rs = st.executeQuery(sql);
    		   if(rs.next()){
    			   kuCun =  rs.getObject(1);
    		   }
    		 
    			
    	} catch (SQLException e) {
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
    		
    	} finally{
    		JDBCTool.freeResorse(rs, st, conn);
    	}
    	return kuCun;
	}
}
