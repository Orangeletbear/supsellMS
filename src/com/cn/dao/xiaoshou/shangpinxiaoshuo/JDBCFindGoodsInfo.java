package com.cn.dao.xiaoshou.shangpinxiaoshuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCFindGoodsInfo {

	/**
	 * ��ȡ������Ʒ����Ϣ��
	 * @return
	 */
	public static Vector getData(){
		Vector data = new Vector();
		
		String sql = null;
		sql = "select sp_id,sp_name,sp_dw,sp_ggxh,sp_color,sp_sj,sp_zdkc from tb_spinfo ";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Vector temp = new Vector();
				int column = rs.getMetaData().getColumnCount();
				for(int i = 1 ;i <= column;i++){
					temp.add(rs.getObject(i));
				}
				data.add(temp);
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	
	/**
	 * ������Ʒ������ơ���ȡ������������Ʒ��Ϣ
	 * @return
	 */
	public static Vector getlbData(String splb){
		Vector data = new Vector();
		
		String sql = null;
		sql = " select sp_id,sp_name,sp_dw,sp_ggxh,sp_color," +
				" sp_sj,sp_zdkc " +
				" from tb_spinfo " +
				" where sp_lb = (select sblb_Id from tb_sblb " +
				               " where sblb_Name = '"+splb+"')";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Vector temp = new Vector();
				int column = rs.getMetaData().getColumnCount();
				for(int i = 1 ;i <= column;i++){
					temp.add(rs.getObject(i));
				}
				data.add(temp);
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	/**
	 * ��ȡ����������һ����������۵��ݵĵ��ݺ�
	 * @param date
	 * @return
	 */
	public static ArrayList danJu(String date){
		ArrayList data = new ArrayList();
		String sql = null;
		
		sql = "select xs_Id from tb_sell_main where xs_xsdate = to_date('"+date+"','YYYY-MM-DD') ";
		
		Connection conn =JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()){
				int column = rs.getMetaData().getColumnCount();
				for(int i = 1;i<=column;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
}
