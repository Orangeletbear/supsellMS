package com.cn.dao.jinhuo.wanglaizhangwu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class ZhangWuJDBC {
  public static Vector getZhangWu(String mingCheng){
	  Vector data = new Vector();
  	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql[]=new String[2];
			if(mingCheng.equals("")){
	 	    	sql[0]=" select ghs_name,sum(xsd_szje),sum(khthd_zje),(sum(xsd_szje)+sum(khthd_zje)),sum(cgd_spzje),sum(kh_th_ytje)-sum(xs_ysje),"+
                     " sum(kh_th_ytje)-sum(xs_ssje),sum(kh_th_ytje)-sum(xs_ysje)-sum(kh_th_ytje)+sum(xs_ssje)"+
                     " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail,tb_cg_detail,tb_cg_main,tb_ghsinfo "+
                     " where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id " +
                     " group by ghs_name ";
	 	    	
			   sql[1]="select ghs_name,sum(xsd_szje),'0',sum(cgd_spzje),sum(xsd_szje),sum(xs_ysje),sum(xs_ssje),sum(xs_ysje-xs_ssje)"+  
                     "  from tb_sell_main,tb_sell_detail,tb_khinfo,tb_cg_detail,tb_cg_main,tb_ghsinfo  "+
                     "  where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and ghs_name not in(  select ghs_name" +
                     " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail,tb_cg_detail,tb_cg_main,tb_ghsinfo "+
                     " where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id " +
                     " group by ghs_name) "+
                     " group by ghs_name";
				
	 	    	}
			else{
				sql[0]=" select ghs_name,sum(xsd_szje),sum(khthd_zje),(sum(xsd_szje)+sum(khthd_zje)),sum(cgd_spzje),sum(kh_th_ytje)-sum(xs_ysje),"+
                " sum(kh_th_ytje)-sum(xs_ssje),sum(kh_th_ytje)-sum(xs_ysje)-sum(kh_th_ytje)+sum(xs_ssje)"+
                " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail,tb_cg_detail,tb_cg_main,tb_ghsinfo "+
                " where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id and ghs_name='"+mingCheng+"'" +
                " group by ghs_name ";
	    	
		    sql[1]="select ghs_name,sum(xsd_szje),'0',sum(cgd_spzje),sum(xsd_szje),sum(xs_ysje),sum(xs_ssje),sum(xs_ysje-xs_ssje)"+  
                "  from tb_sell_main,tb_sell_detail,tb_khinfo,tb_cg_detail,tb_cg_main,tb_ghsinfo  "+
                "  where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and ghs_name not in(  select ghs_name" +
                " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail,tb_cg_detail,tb_cg_main,tb_ghsinfo "+
                " where cg_id=cgd_spdh and cg_ghs=ghs_id and xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id " +
                " group by ghs_name) and ghs_name='"+mingCheng+"' "+
                " group by ghs_name";
		}
			
			
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
