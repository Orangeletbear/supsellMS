package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * �����������ĳɹ�����id
 * @author Administrator
 *
 */
public class Tb_gongHuoShangJDBC {
	public static String change(String gonghuoshang){
		String id = null;
		
		String sql = " select gh.ghs_id "+
 		" from tb_ghsinfo gh "+
		" where gh.ghs_name = '"+gonghuoshang+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			while(rs.next()){
				id = rs.getString(1); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

		
		return id;
	}

}
