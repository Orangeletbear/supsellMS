package com.cn.dao.xiaoshou.shangpinxiaoshuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 *��������Ϣ�������ݿ⣬�������й�����
 * @author Administrator
 *
 */
public class JDBCAddXiaoShouInfo {

	/**
	 * 
	 *�����ݿ������۵��ܱ����һ������
	 */
	public  static void set_xs_zb_Data(Object[] data){
		
	   String sql = "insert into tb_sell_main values(?,?,?,?,?,?,?,?,?)";
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
	 * �����ݿ������۵�������һ������
	 *
	 */
	public static void set_xs_xb_Data(Object[] data){
		String sql = null;
		
		sql = "insert into tb_sell_detail values(?,?,?,?)";
		
		
		Connection conn = JDBCTool.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data[0].toString());
			ps.setString(2, data[1].toString());
			ps.setString(3, data[2].toString());
			ps.setString(4, data[3].toString());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * �������ݿ���ĳ��Ʒ��Ϣ��Ŀ��
	 * @param spName
	 * @param shuLiang
	 */
	
	public static void updateKuCun(String spId,int shuLiang){
		String sql = null;
    
		sql = "update  tb_spinfo set sp_zdkc = "+shuLiang+" where sp_Id ='"+spId+"'";
		Connection conn = JDBCTool.getConnection();
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(st, conn);
		}
		
	}
}
