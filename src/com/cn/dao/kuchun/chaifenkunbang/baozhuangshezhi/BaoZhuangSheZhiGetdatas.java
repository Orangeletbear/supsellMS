package com.cn.dao.kuchun.chaifenkunbang.baozhuangshezhi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

/**
 * ��ȡ��Ʒ��ϸ��Ϣ����ɫ
 * @author Administrator
 *
 */
public class BaoZhuangSheZhiGetdatas {

	public static String chaXunXinxi(String id) {
		String color = null;
		Connection conn = JDBCTool.getConnection();
		String sql = "select sp.sp_color from tb_spinfo sp" +
			" where sp.sp_id = '" + id + "'";
		
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					color = rs.getString("sp_color");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return color;
	}

}
