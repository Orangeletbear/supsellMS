package com.cn.dao.jinhuo.caigoutuihuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ��ɹ��˻���������Ӳɹ���
 */
public class Insert_tb_th_mainJDBC {
	/*
	 * ���ţ��������ڣ������̣�������ƣ�
	 * Ӧ����ʵ�����Żݽ�
	 * �����ˣ�����Ա����ע
	 */
  public static boolean insert(Vector<String> argVector){
		
		
		 String sql = "insert into tb_th_main values(" +
		    "?,to_date(?,'YYYY-MM-DD')," +
		    "?,?,?,?,?,?,?)";
    
	 	Connection conn = JDBCTool.getConnection();
	 	PreparedStatement ps = null;
	     try {
	    	ps = conn.prepareStatement(sql);
	 			
	 		ps.setString(1, argVector.remove(0));
	 		ps.setString(2, argVector.remove(0));
	 		ps.setString(3, argVector.remove(0));
	 		ps.setString(4, argVector.remove(0));
	 		ps.setString(5, argVector.remove(0));
	 		ps.setString(6, argVector.remove(0));
	 		ps.setString(7, argVector.remove(0));
	 		ps.setString(8, argVector.remove(0));
	 		ps.setString(9, argVector.remove(0));
	 		
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