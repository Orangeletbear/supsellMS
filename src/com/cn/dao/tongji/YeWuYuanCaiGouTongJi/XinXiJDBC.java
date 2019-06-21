package com.cn.dao.tongji.YeWuYuanCaiGouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class XinXiJDBC {
	 public static Vector getMingXiData(String message) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {String sql = null;
				if(message.toLowerCase().startsWith("cj", 0)){
				  sql="select cgd_spId,sp_Name,sp_dw,sp_dj,cgd_num,(sp_dj*cgd_num),sp_ggxh,sp_color from tb_cg_main,tb_cg_detail,tb_spinfo where cg_Id=cgd_spdh and " +
				  		"sp_Id=cgd_spId and cg_Id='"+message+"'";}
				else{
					sql="select thd_spId,sp_Name,sp_dw,sp_dj,thd_num,(sp_dj*thd_num),sp_ggxh,sp_color from tb_th_main,tb_th_detail,tb_spinfo where th_Id=thd_spdh and " +
			  		"sp_Id=thd_spId and th_Id='"+message+"'";
				}
		 	    	
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
		 	    //	}	
		 	    	
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
			
	    	return data;
	    }
}
