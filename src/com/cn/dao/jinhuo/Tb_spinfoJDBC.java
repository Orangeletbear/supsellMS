package com.cn.dao.jinhuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ������Ʒ��Ż���Ʒ���ƣ��������Ʒ��û�鵽�����������ж�������Ʒ��
 * ���ز鵽����Ʒ��Ϣ
 * @author Administrator
 *
 */
public class Tb_spinfoJDBC {

	/**
	 * 
	 * @param spID
	 * @return
	 */
	public static Vector find(String spID){
		
		Vector data = new Vector();
		String sql = "select * "+
	       " from tb_spinfo tb "+
	       " where tb.sp_id ='"+spID+"'";

		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			int lieshu = rs.getMetaData().getColumnCount();//ͳ������
			
			while(rs.next()){
				for(int i = 1; i <= lieshu ; i ++){
					data.add( rs.getObject(i));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
}
