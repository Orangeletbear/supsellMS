package com.cn.dao.kuchun.danjuhao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cn.util.JDBCTool;

/**
 * �������õ��ݺŵ������λ��
 * @author Administrator
 *
 */
public class DanJuHaoShuLiangGetDatas {
	/*
	 * ��ֵ�������
	 */
	public static String chaiFenNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(cfm.cf_id) + 1,'0000')) num from tb_cf_main cfm";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
	/*
	 * ���󵥾�����
	 */
	public static String kunBangNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(kbm.kb_id) + 1,'0000')) num from tb_kb_main kbm";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
	/*
	 * ������������
	 */
	public static String diaoBoNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(dbm.kctb_Id) + 1,'0000')) num from tb_kctb_main dbm";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
	/*
	 * �̵㵥�ݺ�����
	 */
	public static String panDianNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(pdm.pd_Id) + 1,'0000')) num from tb_pd_main pdm";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
	/*
	 * ����
	 */
	public static String baoSunNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(bsm.bs_Id) + 1,'0000')) num from tb_bs_main bsm";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
	/*
	 * ����
	 */
	public static String baoYiNum() {
		String count = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select LTrim(to_char(count(bym.by_Id) + 1,'0000')) num from tb_by_main bym";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					count = rs.getString("num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return count;
	}
	
}
