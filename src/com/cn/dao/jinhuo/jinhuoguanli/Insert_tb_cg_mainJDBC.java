package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.util.JDBCTool;

/**
 * 向采购主表中添加采购单
 */
public class Insert_tb_cg_mainJDBC {
	/*
	 * 单号，开单日期，供货商，入库名称，
	 * 应付金额，实付金额，优惠金额，
	 * 经办人，操作员，备注
	 */
  public static boolean insert(Vector<String> argVector){
		
		
		 String sql = "insert into tb_cg_main values(" +
		    "?,to_date(?,'YYYY-MM-DD')," +
		    "?,?,?,?,?,?,?,?)";
    
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
	 		ps.setString(10,argVector.remove(0));
	 		
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
