package com.cn.dao.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;

/**
 * 商品管理JDBC交互
 * @author finey
 *
 */
public class RiZhiJDBC{
	
	
	/**
	 * 查出给定商品编号的商品基本信息
	 * @param spID 商品编号
	 * @return 
	 */
     public static Vector getData(String date1,String date2,String neiRong){
    	 Vector data = new Vector();
      	 String sql = "select m_date,user_name,m_log from tb_logmessage,tb_usernofo" +
      	 		" where m_user_id=user_id and to_date('"+date1+"','YYYY-MM-DD')-" +
							"m_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
							"m_date>0 and (user_name like '%"+neiRong+"%' OR m_log like '%"+neiRong+"%')" +
									" order by m_date";
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
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
      	
      	return data;
     }
}