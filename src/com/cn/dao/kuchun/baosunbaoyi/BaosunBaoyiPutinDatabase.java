package com.cn.dao.kuchun.baosunbaoyi;

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
 * ���������е���Ʒ��Ϣ�洢�����ݿ�
 * 
 */
public class BaosunBaoyiPutinDatabase {
	
	/*
	 * ¼�������
	 */
	public static void insertZongDan (Vector vo,String lx){
		String sql = null;
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		if("��Ʒ����".equals(lx.trim())){
			sql = "insert into tb_bs_main values(?,?,?,?,?,?)";
		}
		if("��Ʒ����".equals(lx.trim())){
			sql = "insert into tb_by_main values(?,?,?,?,?,?)";
		}
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.get(0).toString());
			
			ps.setString(2, getCKId(vo.get(1).toString()));
			
			ps.setTimestamp(3,DateConventer.strToTimestamp(vo.get(2).toString(),"yyyy-mm-dd"));
			
			ps.setString(4, vo.get(3).toString());
			
			ps.setString(5, vo.get(4).toString());
			
			ps.setString(6, vo.get(5).toString());
			
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "����¼��ɹ���");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	
	
	
	/*
	 * ¼�뱨������Ʒ
	 */
	public static void insertShangPin(Vector vo,String lx ){
		String sql = null;
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		if("��Ʒ����".equals(lx.trim())){
			sql = "insert into tb_bs_detail values(?,?,?,?)";
		}
		if("��Ʒ����".equals(lx.trim())){
			sql = "insert into tb_by_detail values(?,?,?,?)";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < vo.size(); i ++){
				for(int j = 0; j < ((Vector)vo.get(0)).size();){
					
					ps.setString(1, getSPId(((Vector)vo.get(i)).get(j++).toString()));
					ps.setString(2, ((Vector)vo.get(i)).get(j++).toString());
					float f = new Float(((Vector)vo.get(i)).get(j++).toString()).floatValue();
					int c = new Integer(((Vector)vo.get(i)).get(j++).toString()).intValue();
					ps.setInt(3, c);
					ps.setFloat(4,c*f);
					
					ps.executeUpdate();
				}
			}
			JOptionPane.showMessageDialog(null, "������¼��ɹ�");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	
	/*
	 * �����������ݿ����ݽ��и���
	 */
	public static void updatas(String[]nameVo,String[] numVo,String lx){
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		String sql = null;
		if("��Ʒ����".equals(lx.trim())){
			sql = "update tb_spinfo set sp_zdkc = sp_zdkc - ? where sp_id = ?";
		}
		if("��Ʒ����".equals(lx.trim())){
			sql = "update tb_spinfo set sp_zdkc = sp_zdkc + ? where sp_id = ?";
		}
		
			
			try {
				for(int i = 0; i < nameVo.length; i ++){
					String name =  nameVo[i];
					String num =numVo[i];
					
					int count = Integer.valueOf(num);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, count);
					ps.setString(2, getSPId(name));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "���³ɹ�");
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
	private static String getCKId(String name){
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
