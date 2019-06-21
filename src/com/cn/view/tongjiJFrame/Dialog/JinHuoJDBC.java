package com.cn.view.tongjiJFrame.Dialog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JinHuoJDBC {
       public static Vector getTiaoJianJDBC(String date1,String date2,String leiBie,String shuLiang,String shuLiang1){
    	   Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql=null;
				if("所有类别".equals(leiBie)){
				 sql="select distinct sp_id, sp_name,sblb_name,sp_dw,sp_ggxh,sp_color,nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num)" +
				 		", coalesce(pdd_num,0) from tb_pd_main,tb_sblb, tb_spinfo,tb_sell_detail,tb_pd_detail,tb_posxfb_detail where sp_id=xsd_id " +
				 		" and sblb_id=sp_lb and sp_id=pdd_spid and pd_id=pdd_sbid and posxfbd_spId=sp_id and nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num) >'"+shuLiang+"' " +
				 				"and coalesce(pdd_num,0) <'"+shuLiang1+"' " +
				 				" and  to_date('"+date1+"','YYYY-MM-DD')-" +
						"pd_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"pd_date>0 ";
				}
				else{
					 sql="select distinct sp_id, sp_name,sblb_name,sp_dw,sp_ggxh,sp_color,nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num)" +
				 		", coalesce(pdd_num,0) from tb_pd_main,tb_sblb, tb_spinfo,tb_sell_detail,tb_pd_detail,tb_posxfb_detail where sp_id=xsd_id " +
				 		" and sblb_id=sp_lb and sp_id=pdd_spid and pd_id=pdd_sbid and posxfbd_spId=sp_id and nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num) >'"+shuLiang+"' " +
				 				"and coalesce(pdd_num,0) <'"+shuLiang1+"' " +
				 				" and  to_date('"+date1+"','YYYY-MM-DD')-" +
						"pd_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"pd_date>0  and sblb_name='"+leiBie+"'";
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
       public static Vector getShangPinJDBC(String name){
    	   Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql=null;
				
			
					 sql="select distinct sp_id, sp_name,sblb_name,sp_dw,sp_ggxh,sp_color,nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num)" +
				 		", coalesce(pdd_num,0) from tb_pd_main,tb_sblb, tb_spinfo,tb_sell_detail,tb_pd_detail,tb_posxfb_detail where sp_id=xsd_id " +
				 		" and sblb_id=sp_lb and sp_id=pdd_spid and pd_id=pdd_sbid and posxfbd_spId=sp_id and " +
				 		"(sp_name like '%"+name+"%' or sp_id like '%"+name+"%')";
		
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
       public static Vector getGongHuoShangJDBC(String name){
    	   Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql=null;
				
			
					 sql="select distinct sp_id, sp_name,sblb_name,sp_dw,sp_ggxh,sp_color,nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num)" +
				 		", coalesce(pdd_num,0) from tb_pd_main,tb_sblb, tb_spinfo,tb_sell_detail,tb_pd_detail,tb_posxfb_detail where sp_id=xsd_id " +
				 		" and sblb_id=sp_lb and sp_id=pdd_spid and pd_id=pdd_sbid and posxfbd_spId=sp_id and " +
				 		" sp_sccs like '%"+name+"%'";
		
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
       public static Vector getXuanZeJDBC(){
    	   Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql=null;
				
			
					 sql="select distinct sp_id, sp_name,sblb_name,sp_dw,sp_ggxh,sp_color,nvl2((xsd_num+ posxfbd_num),xsd_num,posxfbd_num)" +
				 		", coalesce(pdd_num,0) from tb_pd_main,tb_sblb, tb_spinfo,tb_sell_detail,tb_pd_detail,tb_posxfb_detail where sp_id=xsd_id " +
				 		" and sblb_id=sp_lb and sp_id=pdd_spid and pd_id=pdd_sbid and posxfbd_spId=sp_id  " +
				 		" and coalesce(pdd_num,0)<'8'";
		
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
