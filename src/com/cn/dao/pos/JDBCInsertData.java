package com.cn.dao.pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * 
 * @author Administrator
 *
 */
public class JDBCInsertData {

	/**
	 * 
	 * @param data
	 */
	public static void insertXiaoShouData(Object[] data){
		   String sql = null;
	       sql = "insert into tb_posxfb_main values(?,?,?,?,?,?,?,?,?,'0001',?)";
		   PreparedStatement ps = null;
		    
		   Connection conn = JDBCTool.getConnection();
		   try {
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,data[0].toString());
			
			 
			 Timestamp time = DateConventer.strToTimestamp(data[1].toString(),"yyyy-MM-dd");
			 ps.setTimestamp(2, time);
			 
			 ps.setString(3, data[2].toString());
			
			 ps.setString(4, data[3].toString());
			 
			 ps.setString(5, data[4].toString());	
		
			 
			 ps.setString(6, data[5].toString());
			 ps.setString(7, data[6].toString());
			 
			 ps.setString(8, data[7].toString());
			 
			 ps.setString(9, data[8].toString());
	 
			 ps.setString(10, data[10].toString());
			 
			 ps.executeUpdate();  
			 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
	/**
	 * 
	 * 向数据库中POS销售单详表插入一行数据
	 *
	 */
	public static void insertXiangBiaoData(Object[] data){
		String sql = null;
		
		sql = "insert into tb_posxfb_detail values(?,?,?,?)";
		
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		try {
		    ps = conn.prepareStatement(sql);
		    
			ps.setString(1, data[0].toString());
			
			ps.setString(2, data[1].toString());
			
			ps.setString(3, data[2].toString());
			
			ps.setString(4, data[3].toString());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	/**
	 * 插入POS销售退货主表中的数据
	 * @param data
	 */
	public static void insert_th_main_Data(Vector data){
		   String sql = null;
	       sql = "insert into tb_posth_main values(?,?,?,?,?,?,?,?,?,null)";
		   PreparedStatement ps = null;
		    
		   Connection conn = JDBCTool.getConnection();
		   try {
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,data.get(0).toString());
			
			
			 
			 ps.setString(2, data.get(1).toString());
			 
			 Timestamp time = DateConventer.strToTimestamp(data.get(2).toString(),"yyyy-MM-dd");
			 ps.setTimestamp(3, time);
			 
			 ps.setString(4, data.get(3).toString());
			 
			 ps.setString(5, data.get(4).toString());	
		
			 
			 ps.setString(6, data.get(5).toString());
			 ps.setString(7, data.get(6).toString());
			 
			 ps.setString(8, data.get(7).toString());
			 
			 ps.setString(9, data.get(8).toString());
			 //ps.setString(10, data.get(9).toString());
			 
			 ps.executeUpdate();  
			 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
	/**
	 * 
	 * 向数据库中POS销售退货详表插入一行数据
	 *
	 */
	public static void insert_th_detail_Data(Object[] data){
		String sql = null;
		
		sql = "insert into tb_posxth_detail values(?,?,?,?)";
		
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		try {
		    ps = conn.prepareStatement(sql);
		    
			ps.setString(1, data[0].toString());
			
			ps.setString(2, data[1].toString());
			
			ps.setString(3, data[2].toString());
			
			ps.setString(4, data[3].toString());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	/**
	 *向会员消费表中插入数据
	 * @param data
	 */
	public static void insert_hyxf_Data(Vector data){
		   String sql = null;
	       sql = "insert into tb_hyxfb values(?,?,?,?)";
		   PreparedStatement ps = null;
		    
		   Connection conn = JDBCTool.getConnection();
		   try {
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,data.get(0).toString());
			
			
			 
			 ps.setString(2, data.get(1).toString());
			 
			 
			 ps.setString(3, data.get(2).toString());
			 
			 ps.setString(4, data.get(3).toString());
	 
			 
			 ps.executeUpdate();  
			 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
}
