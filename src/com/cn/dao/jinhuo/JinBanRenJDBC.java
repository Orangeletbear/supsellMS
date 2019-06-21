package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * �����о���������Ū����
 * ����String����
 * @author Administrator
 *
 */
public class JinBanRenJDBC {

	public static Vector find(){
		Vector name = new Vector();  
		
		String sql = " select yg.yg_name from tb_yginfo yg ";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			
			while(rs.next()){
					name.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

	
		return name;

	}
}
