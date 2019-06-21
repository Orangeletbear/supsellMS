package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan;

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
 * �������������ݴ������ݿ�
 * @author Administrator
 *
 */
public class PutinDiaoBoDan {
	/*
	 * ��ȡ�ֿ�id
	 */
	private static String getCKId(String name){
		String id= null;
		String sql = "select ck.ck_id from tb_ckinfo ck where ck.ck_name = '" +name + "'";
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
	 * ¼�������
	 */
	public static void insertDiaoboDan (Vector vo){
		String sql = "insert into tb_kctb_main values(?,?,?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.get(0).toString());
			ps.setString(2, getCKId(vo.get(1).toString()));
			ps.setString(3, getCKId(vo.get(2).toString()));
			ps.setTimestamp(4,DateConventer.strToTimestamp(vo.get(3).toString(),"yyyy-mm-dd"));
			ps.setString(5, vo.get(4).toString());
			ps.setString(6, vo.get(5).toString());
			
			ps.executeUpdate();
			
//			JOptionPane.showMessageDialog(null, "������¼��ɹ�");
			
		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
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
		System.out.println(SPid);
		return SPid;
	}
	
	
	/*
	 * ¼�������Ʒ
	 */
	public static void insertDiaoBoShangPin(Vector vo ){
		String sql = "insert into tb_kctb_detail values(?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		System.out.println(vo.size());
		System.out.println(((Vector)vo.get(0)).size());
		
		for(int i = 0; i < vo.size(); i ++){
			for(int j = 0; j < ((Vector)vo.get(0)).size(); j ++){
				System.out.println(((Vector)vo.get(i)).get(j));
			}
		}
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
			JOptionPane.showMessageDialog(null, "����¼��ɹ�");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
}
