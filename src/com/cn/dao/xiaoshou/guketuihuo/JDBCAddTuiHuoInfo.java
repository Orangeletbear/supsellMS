package com.cn.dao.xiaoshou.guketuihuo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;


/**
 * 用于向数据库中插入数据
 * @author Administrator
 *
 */
public class JDBCAddTuiHuoInfo {

	/**
	 * 
	 *向数据库中客户退货单总表插入一条数据
	 */
	public  static void set_th_zb_Data(Object[] data){
		
	   String sql = "insert into tb_khth_main values(?,?,?,?,?,?,?,?,?)";
	   PreparedStatement ps = null;
	    
	   Connection conn = JDBCTool.getConnection();
	   try {
		 ps = conn.prepareStatement(sql);
		 ps.setString(1,data[0].toString());
		 ps.setString(2, data[1].toString());
		 Timestamp time = DateConventer.strToTimestamp(data[2].toString(),"yyyy-MM-dd");
		 ps.setTimestamp(3, time);
		 ps.setString(4, data[3].toString());
		 ps.setString(5, data[4].toString());
		 ps.setString(6, data[5].toString());
		 ps.setString(7, data[6].toString());
		 ps.setString(8, data[7].toString());
		 ps.setString(9, data[8].toString());
		 
		 ps.executeUpdate();  
		
		 
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * 
	 * 向数据库中客户退货单详表插入一行数据
	 *
	 */
	public static void set_th_xb_Data(Object[] data){
		String sql = null;
		
		sql = "insert into tb_khth_detail values(?,?,?,?)";
		
		
		Connection conn = JDBCTool.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data[0].toString());
			ps.setString(2, data[1].toString());
			ps.setString(3, data[2].toString());
			ps.setString(4, data[3].toString());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
