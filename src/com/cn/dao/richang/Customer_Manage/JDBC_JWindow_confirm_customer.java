package com.cn.dao.richang.Customer_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBC_JWindow_confirm_customer {
	/**
	 * 获取采购单据号，仓库名称，应收金额，实收金额，经办人，单据类型
	 * @param TEXT
	 * @return
	 */
    public static Vector get_Confirm(String TEXT){
    	Vector data = new Vector();
    	String sql = "select xs.xs_id,ck.ck_name,xs.xs_ysje,xs.xs_ssje,xs.xs_jbr,'销售单' "+
    				 "from tb_khinfo kh, tb_sell_main xs , tb_ckinfo ck "+
    				 "where kh.kh_id = xs.xs_khID and xs.xs_chName = ck.ck_id "+
    				 "and kh.kh_id = '" + TEXT + "'";
		    				 
    	
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
     * 获取应收金额，实收金额
     * @param TEXT
     * @return
     */
    public static Vector get_Confirm_data(String TEXT){
    	Vector data = new Vector();
    	String sql = "select sum(xs.xs_ysje),sum(xs.xs_ssje) "+
					 "from tb_khinfo kh, tb_sell_main xs , tb_ckinfo ck "+
					 "where kh.kh_id = xs.xs_khID and xs.xs_chName = ck.ck_id "+
					 "and kh.kh_id = '" + TEXT + "'";
		    				 
    	
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
     * 获取客户备注
     * @param TEXT
     * @return
     */
    public static Vector get_Confirm_data_bz(String TEXT){
    	Vector data = new Vector();
    	String sql = "select kh.kh_bz "+
    				 "from tb_khinfo kh "+
    				 "where kh.kh_id = '" + TEXT + "'";
		    				 
    	
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
