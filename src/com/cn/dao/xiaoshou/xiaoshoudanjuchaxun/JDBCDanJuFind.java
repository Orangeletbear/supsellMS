package com.cn.dao.xiaoshou.xiaoshoudanjuchaxun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCDanJuFind {
	/**
	 * 查找两个时间内的销售单据总表
	 * 支持单号的模糊查询
	 * @param djID 给订单号或客户名称
	 * @param date1 
	 * @param date2
	 * @return 满足要求的单据信息
	 */
	
	  public static Vector getData(String djID,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	    
	    	if("".equals(djID)){
	    		sql ="select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
	    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
	    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
	    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
	    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
	    				" and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0";
	    	}else{
	    		sql = "select deg.xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje," +
	    				"xs_ssje,xs_ysje-xs_ssje ,0,'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
	    				" from tb_sell_main,(select kh_Name,ck_Name,xs_id" +
	    				        " from tb_sell_main,tb_khinfo,tb_ckinfo" +
	    				        " where xs_khId = kh_Id and xs_chName = ck_Id " +
	    				        "and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
	    				        "and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0) deg" +
	    			" where tb_sell_main.xs_id = deg.xs_id and (kh_Name = '"+djID+"'or deg.xs_id like '%"+djID+"%')";
	    	}
	
	    	Connection conn = JDBCTool.getConnection();
	    	Statement st = null;
	    	ResultSet  rs = null;

	    	try {
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
	
	
	/**
	 * 按客户名称，仓库名称，操作员名称
	 * 来查询两个日期之间的单据信息
	 */
	  public static Vector getData(String khName,String chName,
			                String czyName,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	   
	         if(khName.equals("")){
	    		if("所有仓库".equals(chName)){
	    			if("所有操作员".equals(czyName)){
	    				sql ="select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
	    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
	    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
	    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
	    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
	    				" and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0";
	    			 }else{
	    				 sql ="select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
		    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
		    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
		    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
		    				" and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0" +
						    " and xs_czy = '"+czyName+"'" ;
	    			     } 
	    		 }else{
 
	    			 if("所有操作员".equals(czyName)){
	    				 sql ="select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
		    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
		    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
		    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
		    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"
		    				+"and ck_Name = '"+chName+"'";
		    			 }else{
		    				 sql ="select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
			    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
			    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
			    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"
			    				+"and ck_Name = '"+chName+"'"+
							    " and xs_czy = '"+czyName+"'" ;
		    			     } 
	    		 }
	    	}else{
	    		if("所有仓库".equals(chName)){
	    			if("所有操作员".equals(czyName)){
	    				sql = "select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
	    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
	    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
	    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
	    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
	    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"+
	    			   " and kh_Name = '"+khName+"'";
	    			 }else{
	    				 sql = "select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
		    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
		    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
		    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
		    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"+
		    			   " and kh_Name = '"+khName+"'"+
						    "and xs_czy = '"+czyName+"'" ;
	    			     } 
	    		 }else{
 
	    			 if("所有操作员".equals(czyName)){
	    				 sql = "select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
		    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
		    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
		    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
		    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"+
		    			   " and kh_Name = '"+khName+"'" +
						    "and ck_Name = '"+chName+"'" ;
		    			 }else{
		    				 sql = "select xs_id,xs_xsdate,kh_Name,ck_Name,xs_ysje,xs_ssje,xs_ysje-xs_ssje ,0," +
			    				"'商品销售',' ',xs_jbr,xs_czy,xs_bz" +
			    				" from tb_sell_main,tb_khinfo,tb_ckinfo" +
			    				" where xs_khId = kh_Id and xs_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-xs_xsdate >=0"+
			    			   " and kh_Name = '"+khName+"'" +
							    "and ck_Name = '"+chName+"'"+
							    "and xs_czy = '"+czyName+"'" ;
							    
		    			     } 
	    		 }
	    		
	    	}
            Connection conn = JDBCTool.getConnection();
	    	Statement st = null;
	    	ResultSet  rs = null;

	    	try {
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
	
	  /**
	   * 按给定的客户名称查询其所消费的应付总金额
	   * 和实付总金额
	   * @param keHuName 客户名称
	   * @return
	   */
	  public static Vector getData(String keHuName){
		  Vector data = new Vector();
		  String sql = null;
		  sql = "select sum(xs_ysje),sum(xs_ssje),sum(xs_ysje) -sum(xs_ssje)" +
		  		" from  tb_sell_main , tb_khinfo" +
		  		" where kh_id =  xs_khID and kh_Name = '"+keHuName+"'";
		  
			Connection conn = JDBCTool.getConnection();
	    	Statement st = null;
	    	ResultSet  rs = null;

	    	try {
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
	  
	  /**
	   * 查询销售单据详表上的信息
	   * 根据销售总表上被选定的行上的单据号
	   * 查询出该单据上的商品信息
	   * 
	   * @param id 销售总表上的单据号
	   * @return 该单据上的商品信息
	   */
	 
	  public static Vector getDate(String id){
		  Vector data  = new Vector();
		  
		  String sql = null;
		
		  sql = "select xsd_Id,sp_Name,sp_dw,sp_dj,xsd_num,xsd_szje," +
		  		"sp_ggxh,sp_color  " +
		  		"from tb_sell_detail,tb_spinfo,tb_sell_main" +
		  		"  where xsd_Id = sp_Id and xsd_dh = xs_id and xs_id='"+id+"'";
		  Connection conn = JDBCTool.getConnection();
	      Statement st = null;
	      ResultSet  rs = null;

	    	try {
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
	 
	/**
	 * 按客户名称查询其曾经消费过的商品信息
	 * @return
	 */
	  public static Vector getGoodsData(String khName){
		  Vector data = new Vector ();
		  String sql = null;
		  sql = "select distinct sp_Id,sp_Name,sp_dw,sp_ggxh," +
		  		"sp_color,sp_sj,sp_zdkc" +
		  		" from tb_spinfo,tb_sell_detail detail,(select xs_id" +
		  		           " from tb_sell_main ,tb_khinfo " +
		  		           " where xs_khid = kh_id and kh_name = '"+khName+"')" +
		  		"where detail.xsd_dh = xs_id and tb_spinfo.sp_id = detail.xsd_id";
		  
		  Connection conn = JDBCTool.getConnection();
		  Statement st = null;
		  ResultSet rs = null;
		  
		  try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()){
				Vector tmp = new Vector();
				for(int column = 1;column<=columns;column++){
					tmp.add(rs.getObject(column));
				}
		       data.add(tmp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		  return data;
			  
	  }
	  
		/**
		 * 按客户名称和商品类别查询其曾经消费过的商品信息
		 * @return
		 */
		  public static Vector getGoodsData(String khName,String splb){
			  Vector data = new Vector ();
			  String sql = null;
			  sql = "select distinct sp_Id,sp_Name,sp_dw,sp_ggxh," +
			  		"sp_color,sp_sj,sp_zdkc" +
			  		" from tb_spinfo,tb_sell_detail detail,(select xs_id" +
			  		           " from tb_sell_main ,tb_khinfo " +
			  		           " where xs_khid = kh_id and kh_name = '"+khName+"')" +
			  		"where detail.xsd_dh = xs_id and tb_spinfo.sp_id = detail.xsd_id" +
			  		" and sp_lb = (select sblb_Id from tb_sblb where sblb_Name = '"+splb+"')";
			  
			  Connection conn = JDBCTool.getConnection();
			  Statement st = null;
			  ResultSet rs = null;
			  
			  try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				int columns = rs.getMetaData().getColumnCount();
				while (rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columns;column++){
						tmp.add(rs.getObject(column));
					}
			       data.add(tmp);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				JDBCTool.freeResorse(rs, st, conn);
			}
			  return data;
				  
		  }
	  /**
		 * 按客户名称和商品id查询其曾经消费过的商品信息
		 * @return
		 */
		  public static Vector getGoodsData2(String khName,String spId){
			  Vector data = new Vector ();
			  String sql = null;
			  sql = "select distinct sp_Id,sp_Name,sp_dw,sp_ggxh," +
			  		"sp_color,sp_sj,sp_zdkc" +
			  		" from tb_spinfo,tb_sell_detail detail,(select xs_id" +
			  		           " from tb_sell_main ,tb_khinfo " +
			  		           " where xs_khid = kh_id and kh_name = '"+khName+"')" +
			  		"where detail.xsd_dh = xs_id and tb_spinfo.sp_id = detail.xsd_id" +
			  		" and sp_Id like'"+spId+"%'"  ;
			  
			  Connection conn = JDBCTool.getConnection();
			  Statement st = null;
			  ResultSet rs = null;
			  
			  try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				int columns = rs.getMetaData().getColumnCount();
				while (rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columns;column++){
						tmp.add(rs.getObject(column));
					}
			       data.add(tmp);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				JDBCTool.freeResorse(rs, st, conn);
			}
			  return data;
				  
		  }
	  /**
	   * 查询所有销售单据信息
	   */
	  
	  public static Vector getAllData(){
		  String sql = null;
		  Connection conn = JDBCTool.getConnection();
		  Statement st = null;
		  ResultSet rs = null;
		  Vector data = new Vector();
		  
		  sql = "select tm.xs_Id ,tm.xs_xsdate, tk.kh_name,tc.ck_name," +
		  		"tm.xs_ysje,tm.xs_ssje,tm.xs_ysje- tm.xs_ssje,'0','商品销售',''," +
		  		"tm.xs_jbr,tm.xs_czy,tm.xs_bz  " +
		  		" from tb_sell_main tm ,tb_khinfo tk,tb_ckinfo tc" +
		  		" where tm.xs_khid = tk.kh_id and tm.xs_chname = tc.ck_id";
		  try {
			st = conn.createStatement();
			rs =  st.executeQuery(sql);
			int column = rs.getMetaData().getColumnCount();
			while(rs.next()){
				Vector temp = new Vector();
				for(int i = 1; i  <=column;i++){
					
					temp.add(rs.getObject(i));
				}
				data.add(temp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	  }
}
