package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

public class JRSX_ShangPinGetDatas {
	
	public static Vector createSQL(String str){
		String sql = null;
		if(str.length() > 0 ){
			if(str.matches("\\d+")){
				sql = "select sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_color,sp.sp_dj," +
				"sp.sp_zdkc,sp.sp_dj*sp.sp_zdkc sp_zje" +
				" from tb_spinfo sp" + " where sp.sp_id = " + str;
			}else{
				sql = "select sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_color,sp.sp_dj," +
				"sp.sp_zdkc,sp.sp_dj*sp.sp_zdkc sp_zje" +
				" from tb_spinfo sp" + " where sp.sp_name = " + str;
			}
		}else{
			sql = null;
		}
		
		return getDatas(sql);
		
	} 
	 
/*	public static Vector createSQL(String name){
		String CKID = null;
		String sql = null;
		if(name.length() > 0){
			if(name.trim().equals("主仓库")){
				CKID = "001";
			}else if(name.trim().equals("烟酒仓库")){
				CKID = "002";
			}else if(name.trim().equals("饮料仓库")){
				CKID = "003";
			}
				sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ,SP.SP_ZDKC" +
						" FROM TB_SPINFO SP WHERE SP.SP_SYCK = '" +CKID + "'";
		}else{
			sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ,SP.SP_ZDKC" 
							+ " FROM TB_SPINFO SP";
		}
		return getDatas(sql);
	}*/
	
	
	/*
	 * 与数据库进行查询交互
	 */
	public static Vector getDatas(String sql){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		Vector datas = new Vector();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			int column1 = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i <= column1; i ++ ){
					datas.add(rs.getObject(i));
				}
			}
			System.out.println(datas.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
		
	}
}
