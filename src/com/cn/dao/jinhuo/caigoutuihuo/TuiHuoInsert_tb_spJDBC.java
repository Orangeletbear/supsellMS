package com.cn.dao.jinhuo.caigoutuihuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.util.JDBCTool;

public class TuiHuoInsert_tb_spJDBC {
	/*
	 * ��Ʒ��ţ���������棩���ֿ�(ҪID)
	 */
	public static boolean insert(String spID,
			String shuliang,String cangku){
		//����ǰ�����
		Vector chakucun = Tb_spinfoJDBC.find(spID);
		int kucun = Integer.parseInt(""+chakucun.get(11));
		kucun = kucun - Integer.parseInt(shuliang);
		
		 String sql = " update tb_spinfo sp "+
		 	" set sp.sp_zdkc ='"+kucun+"', "+
		 	" sp.sp_syck ='"+cangku+"' "+
			" where sp.sp_id ='"+ spID+"'";

		 Connection conn = JDBCTool.getConnection();
		 PreparedStatement ps = null;
		 try {
			 ps = conn.prepareStatement(sql);
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
