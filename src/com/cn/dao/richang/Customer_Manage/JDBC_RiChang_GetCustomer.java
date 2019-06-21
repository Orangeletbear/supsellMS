package com.cn.dao.richang.Customer_Manage;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
/*
 * �������ϵĵ��ݲ�ѯJDBC����
 */
public class JDBC_RiChang_GetCustomer {
 



	/**
	 * �ͻ��ۺϹ���(Customer_Manage)���ͱ��۹���(Guote_Manage)��new JWindow_Customer_Manage
	 * �����м�����������������ѯ��Ĭ��Ϊ���пͻ�
	 * 
	 */
	public static Vector getCustomer(String TEXT){
    	Vector data = new Vector();
    	String sql = "SELECT kh_ID,kh_NAME,kh_LXR,kh_TELL,kh_ADDRESS " +
		    			"FROM tb_khinfo kh " +
		    			"WHERE ( kh.kh_Id LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_NAME LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_LXR LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_TELL LIKE '%" + TEXT +"%' OR "+
		    				  " kh.kh_ADDRESS LIKE '%" + TEXT +"%' )";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}

}
	
	