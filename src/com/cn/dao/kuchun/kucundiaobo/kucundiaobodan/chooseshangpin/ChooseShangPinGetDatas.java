package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;


/**
 * ��������Ʒ��Ϣ����������Ϣ��ӵ�ѡ�������
 * @author Administrator
 *
 */
public class ChooseShangPinGetDatas {

	
	/**
	 * 
	 * ����ģ����ѯ������
	 * @param sql
	 * @return
	 */
	public static Vector getDatas(String id,String num){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		String sql = null;
		Vector data = new Vector();
		
		if(id.length() > 0 ){
			sql = "select sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_color,sp.sp_dj," +
					"sp.sp_zdkc,sp.sp_dj*sp.sp_zdkc sp_zje from tb_spinfo sp" +
					" where sp.sp_id = '" + id + "'";
		} else {
			sql = null;
		}
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			int column1 = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				
				for(int i = 1; i <= column1; i ++  ){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		//���Ϊ��ʱ���ܵ���
		/*if(compareNum(id,num) <= 0){
			return  new Vector();
		}*/
		//��Ϊ��ʱ�򽫽�����뵽data��
		data.set(5,compareNum(id,num));
		
		return data;
	}

	/*
	 * �˷��������жϴ�������ĵ�����������֮��Ĵ�С��ϵ
	 * 
	 */
	public static int compareNum(String id,String num){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		String sql = "select sp.sp_zdkc from tb_spinfo sp where sp.sp_id = '" +
		id + "'";
		int count = Integer.valueOf(num);
		int i = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				i = rs.getInt("sp_zdkc");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		
		if(count > i){
			JOptionPane.showMessageDialog(null, "������ĵ�������̫��,���������룡");
		}
		//�������ݿ�
//		updata(id,num);
		
		return count > i ? i :count;
	}
	
	/*
	 * ���ݿ����
	 */
	public static void updata(String id,String num){
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		String sql = "update tb_spinfo set sp_zdkc = sp_zdkc - ? where sp_id = ?";
		int count = Integer.valueOf(num);
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
	}
}
