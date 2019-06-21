package com.cn.dao.tongji.ShangPinXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class KeHuXiJDBC {
	 public static Vector getKeHuXiData(String message) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {String sql = null;
			sql="select xs_id,xs_xsdate,sp_id,sp_name,sp_dj,xsd_num,(sp_dj*xsd_num), " +
			"((sp_sj-sp_jj)*xsd_num),round(((sp_sj-sp_jj)*xsd_num)/(sp_dj*xsd_num),3) "+
            ",sp_dw,sp_ggxh,sp_color,ck_name,xs_jbr,sp_sccs "+
            "from tb_sell_main,tb_sell_detail,tb_spinfo,tb_ckinfo,tb_khinfo where "+
            "xs_id=xsd_dh and xsd_id=sp_id and kh_id=xs_khid and xs_chName=ck_id and kh_name='"+message+"'";
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

