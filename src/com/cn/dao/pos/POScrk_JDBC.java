package com.cn.dao.pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
/**
 * 关于收银员的出入款信息
 * @author Administrator
 *
 */
public class POScrk_JDBC {

	/**
	 * 获取某天的所有收银员入款单单据号
	 * @param date
	 * @return
	 */
	public static ArrayList getRuKuanInfo(String date){
		ArrayList data = new ArrayList();
		
		String sql = null;
		sql = "select in_id from tb_inPay where in_date = to_date('"+date+"','yyyy-mm-dd')";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				for(int i = 1;i<=columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 获取某天的所有收银员出款单单据号
	 * @param date
	 * @return
	 */
	public static ArrayList getChuKuanInfo(String date){
		ArrayList data = new ArrayList();
		
		String sql = null;
		sql = "select out_id from tb_outPay where out_date = to_date('"+date+"','yyyy-mm-dd')";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				for(int i = 0;i<columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 向数据库中插入收银员入款信息
	 * @param data
	 */
	public static void insertRuKuanData(Vector data){
		
		String sql = null;
		sql = "insert into tb_inPay values(?,?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.get(0).toString());
		    Timestamp time = DateConventer.strToTimestamp(data.get(1).toString(),"yyyy-MM-dd");
		    ps.setTimestamp(2, time);
		    ps.setString(3, data.get(2).toString());
		    ps.setString(4, data.get(3).toString());
		    ps.setString(5, data.get(4).toString());
			
		    ps.executeUpdate();  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
	/**
	 * 向数据库中插入收银员出款信息
	 * @param data
	 */
	public static void insertChuKuanData(Vector data){
		
		String sql = null;
		sql = "insert into tb_outPay values(?,?,?,?,?)";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.get(0).toString());
		    Timestamp time = DateConventer.strToTimestamp(data.get(1).toString(),"yyyy-MM-dd");
		    ps.setTimestamp(2, time);
		    ps.setString(3, data.get(2).toString());
		    ps.setString(4, data.get(3).toString());
		    ps.setString(5, data.get(4).toString());
			
		    ps.executeUpdate();  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
}
