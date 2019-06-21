package com.cn.dao.jinhuo.caigoutuihuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class Insert_tb_th_detailJDBC {
	/*
	 * ��Ʒ��ţ����ţ��������ܽ��
	 */
	 public static boolean insert(String bianhao,String danhao,String shuliang,String zongjine){
			
			
		 String sql = "insert into tb_th_detail values(" +
		    "?,?,?,?)";
    
	 	Connection conn = JDBCTool.getConnection();
	 	PreparedStatement ps = null;
	     try {
	    	ps = conn.prepareStatement(sql);
	 			
	 		ps.setString(1, bianhao);
	 		ps.setString(2, danhao);
	 		ps.setString(3, shuliang);
	 		ps.setString(4, zongjine);
	 		
	 		ps.executeUpdate();  
	     		
	 	} catch (SQLException e) {
	 		e.printStackTrace();
	 		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	 		return false;
	 	}finally{
	 		JDBCTool.freeResouse(ps, conn);
	 	}
	 		
	 	return true;
  }
}
