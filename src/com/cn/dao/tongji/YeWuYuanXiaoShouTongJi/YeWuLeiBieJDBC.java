package com.cn.dao.tongji.YeWuYuanXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class YeWuLeiBieJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getLeiBieData(String date1,String date2,String leiBie,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql=null;
	 	      
	 	    	if("所有业务员".equals(mingCheng)&&"所有类别".equals(leiBie)){
	 	    		sql="select xsd_id,sp_name,sp_sccs,xsd_num,xsd_szje,xsd_num*(sp_sj-sp_jj)," +
	 	    			" round(xsd_num*(sp_sj-sp_jj)/xsd_szje,3),xs_jbr,sp_sccs"+
                        " from tb_sell_detail,tb_sell_main,tb_spinfo,tb_sblb "+
                        " where xs_id=xsd_dh and xsd_id=sp_id and sblb_id=sp_lb and " +
                         "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						 "xs_xsdate>0";
	 	    	}
	 	    	else if("所有业务员".equals(mingCheng)&&!"所有类别".equals(leiBie)){
	 	    		sql="select xsd_id,sp_name,sp_sccs,xsd_num,xsd_szje,xsd_num*(sp_sj-sp_jj)," +
 	    			" round(xsd_num*(sp_sj-sp_jj)/xsd_szje,3),xs_jbr,sp_sccs"+
                    " from tb_sell_detail,tb_sell_main,tb_spinfo,tb_sblb "+
                    " where xs_id=xsd_dh and xsd_id=sp_id and sblb_id=sp_lb and " +
                     "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					 "xs_xsdate>0 and sblb_name='"+leiBie+"'";
	 	    	}
	 	    	else if(!"所有业务员".equals(mingCheng)&&"所有类别".equals(leiBie)){
	 	    		sql="select xsd_id,sp_name,sp_sccs,xsd_num,xsd_szje,xsd_num*(sp_sj-sp_jj)," +
 	    			" round(xsd_num*(sp_sj-sp_jj)/xsd_szje,3),xs_jbr,sp_sccs"+
                    " from tb_sell_detail,tb_sell_main,tb_spinfo,tb_sblb "+
                    " where xs_id=xsd_dh and xsd_id=sp_id and sblb_id=sp_lb and " +
                     "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					 "xs_xsdate>0 and xs_jbr='"+mingCheng+"'";
	 	    	}
	 	    	else{
	 	    		sql="select xsd_id,sp_name,sp_sccs,xsd_num,xsd_szje,xsd_num*(sp_sj-sp_jj)," +
 	    			" round(xsd_num*(sp_sj-sp_jj)/xsd_szje,3),xs_jbr,sp_sccs"+
                    " from tb_sell_detail,tb_sell_main,tb_spinfo,tb_sblb "+
                    " where xs_id=xsd_dh and xsd_id=sp_id and sblb_id=sp_lb and " +
                     "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					 "xs_xsdate>0 and sblb_name='"+leiBie+"' and xs_jbr='"+mingCheng+"'";
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
	 	    	
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
    

}
