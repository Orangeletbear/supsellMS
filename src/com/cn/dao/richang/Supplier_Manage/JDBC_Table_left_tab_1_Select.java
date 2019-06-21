package com.cn.dao.richang.Supplier_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_Table_left_tab_1_Select {
	/**
	 * ��ȡ�ɹ���Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ��
	 * @param TEXT
	 * @return
	 */
    public static Vector getTable_left_tab_1_Select(String TEXT){
    	Vector data = new Vector();
    	String sql = "select xd.cgd_spid,sp.sp_name,sp.sp_dw,sp.sp_dj,xd.cgd_num,xd.cgd_spzje "+
    				 "from tb_cg_main cg,tb_cg_detail xd,tb_spinfo sp "+
    				 "where cg.cg_id = xd.cgd_spdh and xd.cgd_spid = sp.sp_id "+
    				 "and cg.cg_id = '" + TEXT +"'";
		    				 
    	
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
    /**
	 * ��ȡ�ɹ��ܣ��������ܽ�
	 * @param TEXT
	 * @return
	 */
    public static Vector getTable_left_tab_1_Select_sum(String TEXT){
    	Vector data = new Vector();
    	String sql = "select sum(xd.cgd_num),sum(xd.cgd_spzje) "+
    				 "from tb_cg_main cg,tb_cg_detail xd,tb_spinfo sp "+
    				 "where cg.cg_id = xd.cgd_spdh and xd.cgd_spid = sp.sp_id "+
    				 "and cg.cg_id = '" + TEXT +"'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
			    
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
