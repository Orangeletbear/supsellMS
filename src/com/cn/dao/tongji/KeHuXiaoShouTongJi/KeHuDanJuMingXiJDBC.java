package com.cn.dao.tongji.KeHuXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class KeHuDanJuMingXiJDBC {
	/*
	 * 查出各类单据信息
	 */
    public static Vector getShangPinMingXiData(String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	   if(mingCheng.toLowerCase().startsWith("xs")){
			sql=" select sp_id,sp_name,sp_dw,sp_dj,xsd_num,xsd_szje,sp_ggxh,sp_color " +
					" from tb_sell_detail,tb_spinfo"+
                  " where  xsd_id=sp_id and xsd_dh='"+mingCheng+"'";
	 	   }
	 	   if(mingCheng.toLowerCase().startsWith("xt")){
	 		   sql="select sp_id,sp_name,sp_dw,sp_dj,khthd_num,khthd_zje,sp_ggxh,sp_color " +
	 		   		" from tb_khth_detail,tb_spinfo"+
                    " where sp_id=khthd_thxdid and khthd_dh ='"+mingCheng+"'";
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
    public static Vector getFuKuanMingXiData(String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	   if(mingCheng.toLowerCase().startsWith("xs")){
			sql=" select kh_name,xs_xsdate,xs_id,'销售开单收款',xs_ssje,xs_jbr,xs_czy,xs_bz " +
				" from tb_sell_main,tb_khinfo"+
                " where   xs_khid=kh_id"+
                " and xs_id='"+mingCheng+"'";
	 	   }
	 	   if(mingCheng.toLowerCase().startsWith("xt")){
	 		   sql="select kh_name,kh_th_date,kh_th_id,'退货开单退款',kh_th_stje,kh_th_jbr,kh_th_czy,kh_th_bz " +
	 		   		" from tb_khth_main,tb_khinfo"+
                    " where   kh_th_name=kh_id and kh_th_id ='"+mingCheng+"'";
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
