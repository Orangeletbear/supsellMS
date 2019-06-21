package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ֻ��Ϊ�˽��ֿ�������id
 * @author Administrator
 *
 */
public class Tb_ckinfoJDBC {

	public static String find(String spName){
		String id =null;
		
		String sql = " select ck.ck_id "+
		" from tb_ckinfo ck "+
		" where ck.ck_name = '"+spName+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			
			while(rs.next()){
					id = rs.getObject(1).toString();
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
