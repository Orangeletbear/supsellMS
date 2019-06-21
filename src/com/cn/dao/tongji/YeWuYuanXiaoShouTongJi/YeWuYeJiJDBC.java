package com.cn.dao.tongji.YeWuYuanXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class YeWuYeJiJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getYeJiData(String date1,String date2,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql[]=new String[2];
	 	      
	 	    	if("所有业务员".equals(mingCheng)){
	 	    		sql[0]=" select xs_jbr,sum(xsd_szje),sum(khthd_zje),sum(xsd_szje)+sum(khthd_zje),sum(xs_ssje),"+
                           "  sum(xsd_szje)-sum(xs_ssje) "+
                            " from tb_sell_main,tb_sell_detail,tb_khth_main,tb_khth_detail,tb_spinfo"+
                            " where xsd_dh=xs_id and khthd_dh=kh_th_id and xsd_id=sp_id and sp_id=xsd_id and " +
                            "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						    "xs_xsdate>0 and khthd_thxdid=sp_id"+
                            " group by xs_jbr";
	 	  
	 	    		sql[1]=" select xs_jbr,sum(xsd_szje),'0',sum(xsd_szje),sum(xs_ssje),'0' "+
                            " from tb_sell_main,tb_sell_detail"+
                            " where xsd_dh=xs_id and " +
                            "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						    "xs_xsdate>0 and xs_jbr not in( select xs_jbr"+
                            " from tb_sell_main,tb_sell_detail,tb_khth_main,tb_khth_detail,tb_spinfo"+
                            " where xsd_dh=xs_id and khthd_dh=kh_th_id and xsd_id=sp_id and sp_id=xsd_id  and khthd_thxdid=sp_id"+
                            " group by xs_jbr)"+
                            " group by xs_jbr";
	 	    	}
	 	    	else{
	 	    		sql[0]=" select xs_jbr,sum(xsd_szje),sum(khthd_zje),sum(xsd_szje)+sum(khthd_zje),sum(xs_ssje),"+
                    "  sum(xsd_szje)-sum(xs_ssje)"+
                     " from tb_sell_main,tb_sell_detail,tb_khth_main,tb_khth_detail,tb_spinfo"+
                     " where xsd_dh=xs_id and khthd_dh=kh_th_id and xsd_id=sp_id and khthd_thxdid=sp_id and sp_id=xsd_id and " +
                         "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						 "xs_xsdate>0 and xs_jbr='"+mingCheng+"'"+
                     " group by xs_jbr";
	  
	    		   sql[1]=" select xs_jbr,sum(xsd_szje),'0',sum(xsd_szje),sum(xs_ssje),'0' "+
                     " from tb_sell_main,tb_sell_detail"+
                     " where xsd_dh=xs_id  and " +
                         "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						 "xs_xsdate>0 and xs_jbr not in( select xs_jbr"+
                     " from tb_sell_main,tb_sell_detail,tb_khth_main,tb_khth_detail,tb_spinfo"+
                     " where xsd_dh=xs_id and khthd_dh=kh_th_id and  xsd_id=sp_id and khthd_thxdid=sp_id"+
                     " group by xs_jbr) and xs_jbr='"+mingCheng+"' "+
                     " group by xs_jbr";
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
