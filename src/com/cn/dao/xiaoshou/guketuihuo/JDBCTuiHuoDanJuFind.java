package com.cn.dao.xiaoshou.guketuihuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCTuiHuoDanJuFind {
	/**
	 * 查找两个时间内的销售退货单据总表
	 * 支持单号的模糊查询
	 * @param djID 给订单号
	 * @param date1 
	 * @param date2
	 * @return 满足要求的单据信息
	 */
	
	  public static Vector getData(String djID,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	    	
	    	if("".equals(djID)){
	    		sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
	    				"'销售退货',kh_th_jbr,kh_th_czy,kh_th_bz" +
	    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
	    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
	    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
	    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0";
	    	}else{
	    		sql = "select deg.kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje," +
	    				"kh_th_stje,kh_th_ytje-kh_th_stje,'销售退货',kh_th_jbr,kh_th_czy,kh_th_bz" +
	    				" from tb_khth_main,(select kh_Name,ck_Name,kh_th_Id" +
	    				        " from tb_khth_main,tb_khinfo,tb_ckinfo" +
	    				        " where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
	    				        "and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
	    				        "and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0) deg" +
	    			" where tb_khth_main.kh_th_Id = deg.kh_th_Id and (kh_Name = '"+djID+"'or deg.kh_th_Id like '%"+djID+"%')";
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
	 * 来查询两个日期之间的退货单据信息
	 */
	  public static Vector getData(String khName,String chName,
			                String czyName,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	   
	    	 if(khName.equals("")){
		    		if("所有仓库".equals(chName)){
		    			if("所有操作员".equals(czyName)){
		    				sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
		    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
		    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
		    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
		    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0";
		    			 }else{
		    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0" +
							    " and kh_th_czy = '"+czyName+"'" ;
		    			     } 
		    		 }else{
	 
		    			 if("所有操作员".equals(czyName)){
		    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"
			    				+"and ck_Name = '"+chName+"'";
			    			 }else{
			    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
				    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
				    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
				    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
				    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
				    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"
				    				+"and ck_Name = '"+chName+"'"+
								    " and kh_th_czy = '"+czyName+"'" ;
			    			     } 
		    		 }
		    	}else{
		    		if("所有仓库".equals(chName)){
		    			if("所有操作员".equals(czyName)){
		    				sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
		    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
		    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
		    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
		    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
		    			   " and kh_Name = '"+khName+"'";
		    			 }else{
		    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
			    			   " and kh_Name = '"+khName+"'"+
							    "and kh_th_czy = '"+czyName+"'" ;
		    			     } 
		    		 }else{
	 
		    			 if("所有操作员".equals(czyName)){
		    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
			    			   " and kh_Name = '"+khName+"'" +
							    "and ck_Name = '"+chName+"'" ;
			    			 }else{
			    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
				    				"'商品销售',kh_th_jbr,kh_th_czy,kh_th_bz" +
				    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
				    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
				    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
				    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
				    			   " and kh_Name = '"+khName+"'" +
								    "and ck_Name = '"+chName+"'"+
								    "and kh_th_czy = '"+czyName+"'" ;
								    
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
	   * 查询销售退货单据详表上的信息
	   * 根据销售退货总表上被选定的行上的单据号
	   * 查询出该单据上的商品信息
	   * 
	   * @param id 销售总表上的单据号
	   * @return 该单据上的商品信息
	   */
	 
	  public static Vector getDate(String id){
		  Vector data  = new Vector();
		  String sql = null;
		
		  sql = "select khthd_thxdId,sp_Name,sp_dw,sp_dj, khthd_num,khthd_zje," +
		  		"sp_ggxh,sp_color  " +
		  		" from tb_khth_detail,tb_spinfo,tb_khth_main" +
		  		" where khthd_thxdId = sp_Id and kh_th_Id = khthd_dh and kh_th_Id='"+id+"'";
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
		 * 获取给定日期那一天的所有退货单据的单据号
		 * @param date
		 * @return
		 */
		public static ArrayList danJuId(String date){
			ArrayList data = new ArrayList();
			String sql = null;
			
			sql = "select kh_th_Id from tb_khth_main where kh_th_date = to_date('"+date+"','YYYY-MM-DD') ";
			
			Connection conn =JDBCTool.getConnection();
			Statement st = null;
			ResultSet rs = null;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()){
					int column = rs.getMetaData().getColumnCount();
					for(int i = 1;i<=column;i++){
						data.add(rs.getObject(i));
					}
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			}finally {
				JDBCTool.freeResorse(rs, st, conn);
			}
			
			return data;
		}
		
		


}
