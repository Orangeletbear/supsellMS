package com.cn.dao.tongji.YeWuYuanXiaoShouTongJi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class YeWuYeJiMouseJDBC {
	/*
	 * ������൥����Ϣ
	 * djID ���ݺ�
	 * isGetBZ �Ƿ�����ע
	 */
    public static Vector getYeJiMingXiData(String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	  
			sql="  select kh_name,sum(xsd_szje),sum(xs_ssje),sum(xsd_szje)-sum(xs_ssje)  " +
			    " from tb_sell_main,tb_sell_detail,tb_khinfo"+
                "  where xs_id=xsd_dh  and xs_khid=kh_id and xs_jbr='"+mingCheng+"' "+
                "  group by kh_name";
	 	  
			  st = conn.createStatement();
				rs = st.executeQuery(sql);
				//��ȡ���е�����
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
    

}
