package com.cn.dao.richang.Supplier_Manage;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
/*
 * �������ϵĵ��ݲ�ѯJDBC����
 */
public class JDBC_RiChang_GetSupplier {
 



	/**
	 * ��Ӧ�̹���(Supplier_Manage)���ͱ��۹���(Guote_Manage)��new JWindow_Supplier_Manage
	 * �����м�����������������ѯ��Ĭ��Ϊ���й�Ӧ��
	 * 
	 */
    public static Vector getSupplier(String TEXT){
    	Vector data = new Vector();
    	String sql = "SELECT GHS_ID,GHS_NAME,GHS_LXR,GHS_TELL,GHS_ADDRESS " +
		    			"FROM TB_GHSINFO GHS " +
		    			"WHERE ( GHS.GHS_ID LIKE '%" + TEXT +"%' OR "+
		    				  " GHS.GHS_NAME LIKE '%" + TEXT +"%' OR "+
		    				  " GHS.GHS_LXR LIKE '%" + TEXT +"%' OR "+
		    				  " GHS.GHS_TELL LIKE '%" + TEXT +"%' OR "+
		    				  " GHS.GHS_ADDRESS LIKE '%" + TEXT +"%' )";
		    				 
    	
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
	
	