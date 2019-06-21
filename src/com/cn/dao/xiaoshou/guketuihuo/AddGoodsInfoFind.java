package com.cn.dao.xiaoshou.guketuihuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class AddGoodsInfoFind {

	/**
	 * 查询某客户消费某商品的记录
	 * @param khName 用户名
	 * @param spName 商品名
	 * @return
	 */
	public static  Vector  getData(String khName,String spName){
		
		Vector data = null;
		String sql = null;
		
		sql = "select xs_xsdate,xs_Id,sp_dw,sp_sj,xsd_num,xsd_szje" +
				" from tb_sell_detail td ,tb_sell_main tm,tb_spinfo ts" +
				" where td.xsd_dh = tm.xs_id and ts.sp_id = " +
				"td.xsd_id and " +
				" td.xsd_id = (select sp_Id from tb_spinfo where sp_Name = '"+spName+"')" +
				" and tm.xs_khid = (select kh_Id from tb_khinfo where kh_Name = '"+khName+"')";
		
		Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet  rs = null;

    	try {
    		   data = new Vector();
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
	 * 根据商品名称查询商品的有关信息
	 * @param spName 商品名称
	 * @return
	 *//*
	public Vector getData(String spName){
		Vector data = null;
		return data;
	}*/
}
