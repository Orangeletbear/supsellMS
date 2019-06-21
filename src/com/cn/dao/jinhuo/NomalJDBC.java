package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/**
 * ���õ�һ��JDBC
 * @author Administrator
 */

public class NomalJDBC {

	
	public static Vector gongJu(String sql){
		Vector data = new Vector();
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			int lieshu = rs.getMetaData().getColumnCount();//ͳ������
			
			while(rs.next()){
				Vector argVector = new Vector();
				for(int i = 1; i <= lieshu ; i ++){
					argVector.add( rs.getObject(i));
				}
				data.add(argVector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
}
