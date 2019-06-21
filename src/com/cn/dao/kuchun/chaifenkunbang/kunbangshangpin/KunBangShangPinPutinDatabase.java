package com.cn.dao.kuchun.chaifenkunbang.kunbangshangpin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * ���������Ʒ�ܵ�����Ʒ��Ϣ���µ����ݿ���ȥ
 * 
 */
public class KunBangShangPinPutinDatabase {
	
	//( ���󵥺� , �����, ����,�������Ʒ, �������, ������, ����Ա, ��ע )
	public static void putinKunbangZongdan(Vector vo){
		String sql = "insert into tb_kb_main values(?,?,?,?,?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.get(0).toString());//��ֵ���
			ps.setString(2, getCKId(vo.get(1).toString()));
			ps.setTimestamp(3,DateConventer.strToTimestamp(vo.get(2).toString(),"yyyy-mm-dd"));
			ps.setString(4, getSPId(vo.get(3).toString()));//��Ʒid
			ps.setString(5, vo.get(4).toString());
			ps.setString(6, vo.get(5).toString());
			ps.setString(7, vo.get(6).toString());
			ps.setString(8, vo.get(7).toString());
			
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "�ܵ�����¼��ɹ���");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	/*
	 * ������ ��Ʒ��Ϣ¼��
	 */
	public static void putinKunbangXiangbiao(Vector vo){
		String sql = "insert into tb_kb_detail values(?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		// ( ��Ʒ��, ����(FK), ����, �ܽ�� )
		try {
			ps = conn.prepareStatement(sql);
			
			for(int i = 0; i < vo.size(); i ++){
				for(int j = 0; j < ((Vector)vo.get(0)).size();){
					ps.setString(1, getSPId(((Vector)vo.get(i)).get(j++).toString()));
					ps.setString(2, ((Vector)vo.get(i)).get(j++).toString());
					ps.setInt(3, new Integer(((Vector)vo.get(i)).get(j++).toString()).intValue());
					ps.setFloat(4, new Float(((Vector)vo.get(i)).get(j++).toString()).floatValue());
					
					ps.executeUpdate();
			}
		}
			JOptionPane.showMessageDialog(null, "����¼��ɹ���");
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	
	/*
	 * ���±��������Ʒ�Ŀ����Ϣ
	 */
	public static void updatas1(String name,String num){
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		String sql = "update tb_spinfo set sp_zdkc = sp_zdkc + ? where sp_id = ?";
		int count = Integer.valueOf(num);
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, getSPId(name));
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "���Ӹ��³ɹ�!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
	/*
	 * ���±��������Ʒ��Ϣ
	 */
	public static void updatas2(String[]nameVo,String[] numVo){
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		String sql = "update tb_spinfo set sp_zdkc = sp_zdkc - ? where sp_id = ?";
		
			try {
				for(int i = 0; i < nameVo.length; i ++){
					
					String name =  nameVo[i];
					String num = numVo[i];
					
					int count = Integer.valueOf(num);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, count);
					ps.setString(2, getSPId(name));
					ps.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCTool.freeResouse(ps, conn);
			}
	}
	
	/*
	 * ��ȡ�ֿ�id
	 */
	public static String getCKId(String name){
		String id= null;
		String sql = "select ck.ck_id from tb_ckinfo ck where ck.ck_name = '" + name + "'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getString("ck_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return id;
	}
	
	/*
	 * ��ȡ��Ʒid
	 */
	private static String getSPId(String name){
		String SPid = null;
		String sql = "select sp.sp_id from tb_spinfo sp where sp.sp_name = '" +name + "'";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				SPid = rs.getString("sp_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return SPid;
	}
}
