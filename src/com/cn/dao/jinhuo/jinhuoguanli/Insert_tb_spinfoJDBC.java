package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * 老商品添加数据写入数据库
 * 
*/
public class Insert_tb_spinfoJDBC {
	/*
	 * 商品编号，单价，数量（库存），仓库(要ID)
	 */
	public static boolean insert(String spID,String danjia,
			String shuliang,String cangku){
		//查以前库存量
		Vector chakucun = Tb_spinfoJDBC.find(spID);
		int kucun = Integer.parseInt(""+chakucun.get(11));
		kucun = kucun +Integer.parseInt(shuliang);
		
		 String sql = " update tb_spinfo sp "+
		 	" set sp.sp_dj ='"+danjia+"', "+
		 	" sp.sp_zdkc ='"+kucun+"', "+
		 	" sp.sp_syck ='"+cangku+"' "+
			" where sp.sp_id ='"+ spID+"'";

		 Connection conn = JDBCTool.getConnection();
		 PreparedStatement ps = null;
		 try {
			 ps = conn.prepareStatement(sql);
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
