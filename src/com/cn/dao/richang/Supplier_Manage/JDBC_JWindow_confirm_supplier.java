package com.cn.dao.richang.Supplier_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_JWindow_confirm_supplier {
	/**
	 * 获取采购单据号，仓库名称，应付金额，实付金额，经办人，单据类型
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm(String TEXT){
    	Vector data = new Vector();
    	String sql = "select cg.cg_id,ck.ck_name,cg.cg_yfje,cg.cg_sfje,cg.cg_jbr,'采购单' "+
    				 "from tb_ghsinfo ghs, tb_cg_main cg , tb_ckinfo ck "+
    				 "where ghs.ghs_id = cg.cg_ghs and cg.cg_lkid = ck.ck_id "+
    				 "and ghs.ghs_id = "+TEXT;
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
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
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
    /**
     * 获取应付金额，实付金额
     * @param TEXT
     * @return
     */
    public static Vector get_Confirm_data(String TEXT){
    	Vector data = new Vector();
    	String sql = "select sum(cg.cg_yfje),sum(cg.cg_sfje) "+
    				 "from tb_ghsinfo ghs, tb_cg_main cg , tb_ckinfo ck "+
    				 "where ghs.ghs_id = cg.cg_ghs and cg.cg_lkid = ck.ck_id "+
    				 "and ghs.ghs_id = "+TEXT;
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
    /**
     * 获取供货商备注
     * @param TEXT
     * @return
     */
    public static Vector get_Confirm_data_bz(String TEXT){
    	Vector data = new Vector();
    	String sql = "select ghs.ghs_bz "+
    				 "from tb_ghsinfo ghs "+
    				 "where ghs.ghs_id = '" + TEXT + "'";
		    				 
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			
				rs = st.executeQuery(sql);
				//获取表中的列数
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
	}
}
