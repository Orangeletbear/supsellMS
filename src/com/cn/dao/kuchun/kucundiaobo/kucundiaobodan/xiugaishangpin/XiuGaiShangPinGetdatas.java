package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.xiugaishangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.JDBCTool;

public class XiuGaiShangPinGetdatas {
	
	public static Vector getDatas(String name,String num){
		Connection conn = JDBCTool.getConnection();
		String sql = "select sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_color," +
				"sp.sp_dj,sp.sp_zdkc from tb_spinfo sp where sp.sp_name = '" + name + "'";
		Vector vo = new Vector();
		Statement st= null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int column1 = rs.getMetaData().getColumnCount();
				while(rs.next()){
					for(int i = 0; i < column1; i ++){
					  vo.add(rs.getObject(i));
				   }
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return vo;
	}
}
