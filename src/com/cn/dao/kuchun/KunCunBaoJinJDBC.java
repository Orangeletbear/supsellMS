package com.cn.dao.kuchun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 库存报警中的数据交互
 * @author Administrator
 *
 */
public class KunCunBaoJinJDBC {
     public static Vector getBaoJingSPXSMassege(String spID){
    	 
    	 Vector data = new Vector();
    	 String sql[] ={ "select xsm.xs_xsdate,xsm.xs_id,'销售',kh.kh_name,"+
    			 			" 0,inb.num,ck.ck_name,xsm.xs_jbr,xsm.xs_czy  "+
    			 " from tb_sell_main xsm, tb_ckinfo ck,tb_khinfo kh , "+
    			 " (select xsd.xsd_num num,xsd.xsd_dh dh  "+
    			 " from tb_sell_detail xsd"+
    			 " where xsd.xsd_id = '"+spID+"') inb"+
    			 " where inb.dh = xsm.xs_id "+
    			 " and ck.ck_id = xsm.xs_chname "+
    			 " and kh.kh_id = xsm.xs_khid",
    		  "select cgm.cg_date,cgm.cg_id,'进货',gh.ghs_name,"+
    			 " inb.num,0,ck.ck_name,cgm.cg_jbr,cgm.cg_czy  "+
    			 " from tb_cg_main cgm, tb_ckinfo ck,tb_ghsinfo gh,  "+
    			 " (select cgd.cgd_num num,cgd.cgd_spdh dh  "+
    			 "  from tb_cg_detail cgd"+
    			 " where cgd.cgd_spid = '"+spID+"') inb"+
    			 " where inb.dh = cgm.cg_id "+
    			 " and ck.ck_id = cgm.cg_lkid "+
    			 " and gh.ghs_id = cgm.cg_ghs "
    			 };

    			 					
    			 					
    	 Connection conn = JDBCTool.getConnection();
    	 Statement st = null;
    	 ResultSet  rs = null;

    	 try {
    		 st = conn.createStatement();
    		 for(int i = 0;i<sql.length;i++){
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
              return data;
    	 } finally{
    		 JDBCTool.freeResorse(rs, st, conn);
    	 }

    	 return data;
     }
	}
