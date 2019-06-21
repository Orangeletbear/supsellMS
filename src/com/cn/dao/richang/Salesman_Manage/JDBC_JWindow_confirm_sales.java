package com.cn.dao.richang.Salesman_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_JWindow_confirm_sales {
	/**
	 * ��ȡ���ݺţ��ͻ����ֿ����ƣ�Ӧ����ʵ������������
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm_kh(String TEXT){
    	Vector data = new Vector();
    	String sql = "select xs.xs_id,kh.kh_name,ck.ck_name,xs.xs_ysje,xs.xs_ssje,'���۵�' "+
    				 "from tb_khinfo kh, tb_sell_main xs , tb_ckinfo ck "+
    				 "where kh.kh_id = xs.xs_khID and xs.xs_chName = ck.ck_id "+
    				 "and kh.kh_id = '" + TEXT + "'";
		    				 
    	
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
	 * ��ȡ���ݺţ������̣��ֿ����ƣ�Ӧ����ʵ������������
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm_ghs(String TEXT){
    	Vector data = new Vector();
    	String sql = "select cg.cg_id,ghs.ghs_name,ck.ck_name,cg.cg_yfje,cg.cg_sfje,'�ɹ���' "+
		 				"from tb_ghsinfo ghs, tb_cg_main cg , tb_ckinfo ck "+
		 				"where ghs.ghs_id = cg.cg_ghs and cg.cg_lkid = ck.ck_id "+
		 				"and ghs.ghs_id = "+TEXT;
		    				 
    	
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
	 * ��ȡ��Ӧ����ʵ�����
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm_kh_sum(String TEXT){
    	Vector data = new Vector();
    	String sql = "select sum(xs.xs_ysje),sum(xs.xs_ssje) "+
    				 "from tb_khinfo kh, tb_sell_main xs , tb_ckinfo ck "+
    				 "where kh.kh_id = xs.xs_khID and xs.xs_chName = ck.ck_id "+
    				 "and kh.kh_id = '" + TEXT + "'";
		    				 
    	
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
	 * ��ȡ��Ӧ����ʵ�����
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm_ghs_sum(String TEXT){
    	Vector data = new Vector();
    	String sql = "select sum(cg.cg_yfje),sum(cg.cg_sfje) "+
		 				"from tb_ghsinfo ghs, tb_cg_main cg , tb_ckinfo ck "+
		 				"where ghs.ghs_id = cg.cg_ghs and cg.cg_lkid = ck.ck_id "+
		 				"and ghs.ghs_id = "+TEXT;
		    				 
    	
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
     * ��ȡԱ����ע
     * @param TEXT
     * @return
     */
    public static Vector get_Confirm_data_bz(String TEXT){
    	Vector data = new Vector();
    	String sql = "select yg.yg_bz "+
    				 "from tb_yginfo yg "+
    				 "where yg.yg_id = '" + TEXT + "'";
		    				 
    	
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
}
