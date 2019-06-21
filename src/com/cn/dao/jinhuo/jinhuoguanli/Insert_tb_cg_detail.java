package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 采购进货写入采购祥表,一条一条的加进去
 * @author Administrator
 *
 */
public class Insert_tb_cg_detail {

	/*
	 * 商品编号，单号，数量，总金额
	 */
	 public static boolean insert(String bianhao,String danhao,String shuliang,String zongjine){
			
			
		 String sql = "insert into tb_cg_detail values(" +
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
	 		JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
	 		return false;
	 	}finally{
	 		JDBCTool.freeResouse(ps, conn);
	 	}
	 		
	 	return true;
  }
}
