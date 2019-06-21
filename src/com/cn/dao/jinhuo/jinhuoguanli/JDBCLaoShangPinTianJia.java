package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCLaoShangPinTianJia {
	
	public static Vector<Vector<Object>> getTB_SPINFO(){
		Vector<Vector<Object>> data= new Vector<Vector<Object>>();
		
		String sql = "select tb.sp_id,tb.sp_name,tb.sp_dw,tb.sp_ggxh,tb.sp_jj,tb.sp_zdkc,tb.sp_sj from tb_spinfo tb";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			int lieshu = rs.getMetaData().getColumnCount();//统计列数
			
			while(rs.next()){
				Vector<Object> tmp = new Vector<Object>();//存储每行数据 
				
				for(int i = 1; i <= lieshu ; i ++){
					tmp.add( rs.getObject(i));
				}
				data.add(tmp);/////每行数据作为data的一个元素
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
}
