package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.*;
import com.cn.view.systemJFrame.CangKuSheZhi;

public class StorageDB {
	
	
	 //查出数据库数据返回
	public static Vector  getData(){
		   
	  	 Vector data = new Vector();
	  	  String sql = "select ck.ck_name," +
	  	  		"ck.ck_fzr," +
	  	  		"ck.ck_tell,ck.ck_address," +
	  	  		"ck.ck_mrf,ck.ck_ispos," +
	  	  		"ck.ck_bz "+
                "from tb_ckinfo ck";
	 	
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
				return data;
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
	 	
	 	return data;
	   }
     /*
      * 增加仓库
      */
     public static boolean addStorageData(String[] obj){
    	 String sql = "insert into tb_ckinfo values(?,?,?,?,?,?,?,?)";
    	 
    	 Connection conn = JDBCTool.getConnection();
 		 PreparedStatement ps = null;
 		  String str = ""+CangKuSheZhi.getTable().getRowCount();
     	 System.out.print(str);
 		  try {
     		 
 			ps = conn.prepareStatement(sql);
 			ps.setString(1,str);
 			ps.setString(2, obj[0].toString().trim());
 			
 			ps.setString(3, obj[1].toString().trim());
 			ps.setString(4, obj[2].toString().trim());
 			ps.setString(5, obj[3].toString().trim());
 			//ps.setFloat(5, new Float(obj[4].toString()).floatValue());
 			ps.setString(6, obj[5].toString().trim());
 			ps.setString(7, obj[6].toString().trim());
 			ps.setString(8, obj[4].toString().trim());
 			ps.executeUpdate();  
     		
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return false;
 		}finally{
 			JDBCTool.freeResouse( ps,conn);
 		}
    	 
    	 return true;
     }



    public static boolean ChangeStorageData(Vector obj){
	        String sql =  "update tb_ckinfo ck set ck.ck_name = ?," +
	           "ck.ck_fzr=?,ck.ck_tell=?," +
	        		"ck.ck_address=?," +
	        				"ck.ck_mrf=?," +
	        						"ck.ck_isPos=?," +
	        								"ck.ck_bz=? " +
	        										"where ck.ck_name='"+obj.get(0).toString()+"'";
		 
          Connection conn = JDBCTool.getConnection();
          PreparedStatement ps = null; 
		 try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, obj.get(0).toString().trim());
			ps.setString(2, obj.get(1).toString().trim());
			ps.setString(3, obj.get(2).toString().trim());
			ps.setString(4, obj.get(3).toString().trim());
			ps.setString(5, obj.get(4).toString().trim());
			ps.setString(6, obj.get(5).toString().trim());
			ps.setString(7, obj.get(6).toString().trim());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"数据库错误,修改仓库失败!");
			e.printStackTrace();
             return false;			
			
		}
		finally{
			JDBCTool.freeResouse(ps, conn);
		}
        
        return  true;
      }

    public static boolean DeleteStorageData(Object obj){
    	String sql = "delete tb_ckinfo ck where ck.ck_name = '"+obj.toString().trim()+"'";
    	Connection conn = JDBCTool.getConnection();
    	Statement st = null;
    	ResultSet rs = null;
    	try {
			  st = conn.createStatement();
			  rs = st.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
    	finally{
    		JDBCTool.freeResorse(rs, st, conn);
    	}
    	return true;
    }
    
    public static Vector findStorage(String Name,String FZR){
  	  
  	  Vector data = new Vector();
    	  String sql = " select ck.ck_name,ck.ck_fzr,"+
           "ck.ck_tell, ck.ck_address,"+
           "ck.ck_mrf,ck.ck_isPos,ck.ck_bz "+
           " from tb_ckinfo ck where (ck.ck_name like '%"+Name+"%' and ck.ck_fzr like '%"+FZR+"%')";
   	
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
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
   	
   	return data;
    }
    
    
    
    public static Vector All(){
    	
    	String sql = "select *from tb_ckinfo";
		return getData();
    }
    
}

