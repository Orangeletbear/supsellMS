package com.cn.dao.kuchun.kucunpandian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

/**
 * 盘点商品添加模糊查询
 * @author Administrator
 *
 */
public class KCPD_MoHuChaXunGetDatas {
	
	public static Vector moHuCheck(String str){
		Vector vo = new Vector();
		String sql = null;
		if(str.length() > 0){
			if(str.matches("\\d+")){
				sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc from tb_spinfo sp" +
						" where sp.sp_id like '%" + str +"%'";
			}else{
				sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc from tb_spinfo sp" +
				" where sp.sp_name like '%" + str +"%'";
			}
		}else{
			sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc from tb_spinfo sp";
		}
		
		Connection conn = JDBCTool.getConnection();
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				int column = rs.getMetaData().getColumnCount();
				 while(rs.next()){
					 Vector tmp = new Vector();
						 for(int i = 1;i <= column;i++){
							 tmp.add(rs.getObject(i));  
					 }
					 vo.add(tmp);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return vo;
	}
	
}
