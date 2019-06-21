package com.cn.dao.kuchun.kucunpandian;

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
 * ���̵㵥���̵���Ʒ¼�����ݿ�
 * @author Administrator
 *
 */
public class KucunPandianPutinDatabase {
	/*
	 * ¼���̵㵥
	 */
	public static void insertZongDan (Vector vo){
		String sql = "insert into tb_pd_main values(?,?,?,?,?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.get(0).toString());
			ps.setString(2, getCKId(vo.get(1).toString()));
			///------------------------------------
//			System.out.println(vo.get(0).toString());
//			System.out.println(getCKId(vo.get(1).toString()));
			
			ps.setTimestamp(3,DateConventer.strToTimestamp(vo.get(2).toString(),"yyyy-MM-dd"));
			ps.setString(4, vo.get(3).toString());
			ps.setString(5, vo.get(4).toString());
			ps.setInt(6, new Integer(vo.get(5).toString()).intValue());
			ps.setInt(7, new Integer(vo.get(6).toString()).intValue());
			ps.setString(8, vo.get(7).toString());
			
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "����¼��ɹ���");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
			e.printStackTrace();
			return;
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	/*
	 * ¼���̵���Ʒ
	 */
	public static void insertShangPin(Vector vo){
		String sql = "insert into tb_pd_detail values(?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < vo.size(); i ++){
				for(int j = 0; j < ((Vector)vo.get(0)).size();){
					//��Ʒ����
					float dj = getSPdj(((Vector)vo.get(i)).get(j).toString());
					updatePD(((Vector)vo.get(i)).get(j).toString());
					ps.setString(1,((Vector)vo.get(i)).get(j++).toString());
					ps.setString(2, ((Vector)vo.get(i)).get(j++).toString());
					ps.setInt(3, new Integer(((Vector)vo.get(i)).get(j++).toString()).intValue());
					ps.setFloat(4, new Float(((Vector)vo.get(i)).get(j++).toString()).floatValue() * dj);
					
					ps.executeUpdate();
				}
			}
			JOptionPane.showMessageDialog(null, "�̵�¼��ɹ�");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	/*
	 * ����̵���Ʒ
	 * String sql = "insert into tb_pdsp_spinfo values (?,1)";
	 */
	private static void updatePD(String id){
		String sql = "insert into tb_pdsp_spinfo values (?,1)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			if(e.getMessage().trim().matches("ORA-00001: Υ��ΨһԼ������")){
				JOptionPane.showMessageDialog(null, "����Ʒ�Ѿ��̵㣡");
			}
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	
	/*
	 * �����̵�������������Ʒ���
	 * update tb_spinfo set sp_zdkc = 111 where sp_id = '5100001'; 
	 */
	public static void updateKucun(Vector vo){
		String sql = "update tb_spinfo set sp_zdkc = ? where sp_id = ?";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < vo.size(); i ++){
				int count = new Integer(((Vector)vo.get(i)).get(1).toString()).intValue();
				ps.setInt(1, count);	
				ps.setString(2,((Vector)vo.get(i)).get(0).toString());
	
				ps.executeUpdate();
			}
			JOptionPane.showMessageDialog(null, "�����³ɹ�");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			e.printStackTrace();
			return;
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
	}
	
	/*
	 * ��ȡ��Ʒ����
	 */
	private static float getSPdj(String id){
		float dj = 0;
		String djNum = null;
		String sql = "select sp.sp_dj from tb_spinfo sp where sp.sp_id = '" +id + "'";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				djNum = rs.getString("sp_dj");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		dj = new Float(djNum).floatValue();
		
		return dj;
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
	
}
