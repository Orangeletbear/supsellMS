package com.cn.dao.richang.Supplier_Manage;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
/*
 * 工具栏上的单据查询JDBC交互
 */
public class JDBC_RiChang_GetSupplier {
 



	/**
	 * 供应商管理(Supplier_Manage)，和报价管理(Guote_Manage)在new JWindow_Supplier_Manage
	 * 窗口中即不输入条件单击查询，默认为所有供应商
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

}
	
	