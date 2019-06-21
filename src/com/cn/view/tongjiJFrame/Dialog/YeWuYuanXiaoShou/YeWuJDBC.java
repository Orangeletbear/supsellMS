package com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class YeWuJDBC {
	 public static Vector getMingXiData(String date1,String date2,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql[]=new String[2];
		 	      
		 	    
		 	    		sql[0]="select xs_id,xs_xsdate,xs_jbr,ck_name,'销售付款',xs_ysje,xs_ssje,round((sp_sj-sp_jj)*xsd_num,3)," +
	 	    			" round(((sp_sj-sp_jj)*xsd_num)/xsd_szje,3),xs_czy,kh_name,xs_bz"+ 
	                     " FROM tb_sell_detail,tb_sell_main,tb_khinfo,tb_ckinfo,tb_spinfo "+
	                     " where xs_id=xsd_dh and xs_khid=kh_id and xs_chName=ck_id and sp_id=xsd_id and xs_jbr='"+mingCheng+"' and " +
	                         "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
							 "xs_xsdate>0";
	 	    	         sql[1]="  select posxfbd_id,posxfb_date,yg_name,ck_name,'现金',posxfb_yfje,posxfb_sfje,round((sp_sj-sp_jj)*posxfbd_num,3)," +
	 	    	    		" round(((sp_sj-sp_jj)*posxfbd_num)/posxfbd_zje,3),yg_name,  posxfb_gkjb,posxfb_bz "+
	                        "  FROM tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo "+
	                        "  where posxfb_id=posxfbd_id  and posxfb_ckid=ck_id and posxfbd_spid=sp_id and " +
	                         "to_date('"+date1+"','YYYY-MM-DD')-posxfb_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
							 "posxfb_date>0 and posxfb_dgyId=yg_Id and yg_name='"+mingCheng+"'";
		 	    	
		 	    	for(int i=0;i<sql.length;i++){
				  st = conn.createStatement();
					rs = st.executeQuery(sql[i]);
					//获取表中的列数
					int columnCount = rs.getMetaData().getColumnCount();
					while(rs.next()){
						Vector tmp = new Vector();
						for(int column = 1;column<=columnCount;column++){
							tmp.add(rs.getObject(column));
						}
				    data.add(tmp);
				}
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
