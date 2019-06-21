package com.cn.dao.kuchun.chaifenkunbang.chaifenshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

/**
 * ��Ʒ��ֽ����е����ݿ⽻��
 * @author Administrator
 */

public class ChaiFenShangPinGetDatas {
	
	/*
	 * ������Ʒ���Ż�ȡ��Ʒ�ĳɱ��ۼ�����
	 */
	public static String getChengben(String str){
		String dj = null;
		Connection conn = JDBCTool.getConnection();
		String sql = null;
		if(str.matches("\\d+")){
			sql = "select sp.sp_dj from tb_spinfo sp" +
			" where sp.sp_id = '" + str + "'";
		}else{
			sql = "select sp.sp_dj from tb_spinfo sp" +
			" where sp.sp_name = '" + str + "'";
		}
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					dj = rs.getString("sp_dj");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return dj;
	} 
	
	/*
	 * ͨ����Ʒ���ƻ�ȡ��Ʒ���,��棬��ע���������������������Ʒ��Ϣ��
	 */
	public static Vector getSPInof(String name){
		Connection conn = JDBCTool.getConnection();
		Vector vo = new Vector();
		String sql = "select sp.sp_id,sp.sp_zdkc,sp.sp_bz from tb_spinfo sp" +
		" where sp.sp_name = '" + name + "'";;
		String id = null;
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					int column = rs.getMetaData().getColumnCount();
					for(int i = 1; i <= column; i ++ ){
						vo.add(rs.getString(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return vo;
	}
}
