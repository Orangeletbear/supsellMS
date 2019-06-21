package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

public class DanWeiColorJDBC {
	
	/**
	 * 取出所有单位信息
	 * @return
	 */
	public static Vector getAllDanWeiM(){
		
		Vector data = new Vector();
   	
		String sql = "select * from tb_danwei";
  	 		
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
		/**
	    * 增加一个单位
	    * @param data  会员信息包
	    * @return  是否加入
	    */
	   public static void addADanWei(String newDanWei){
		   
		   String sql = "insert into tb_danwei values('"+newDanWei+"')";
		   Connection conn = JDBCTool.getConnection();
		   PreparedStatement ps = null;
		   ResultSet st = null;
		   
		   try {
			   ///取出类别ID
			   ps = conn.prepareStatement(sql);
			   ps.executeUpdate();  
		
		   } catch (SQLException e) {
			 
			   JOptionPane.showMessageDialog(null,"该单位存在");
		
		   }finally{
			   JDBCTool.freeResouse(ps, conn);
		   }

		

	   }
	   
	   
	   /**
	     * 删除一个单位
	     * @return
	     */
	     public static boolean deleDanWei(String danWeiName){
	         
	     	
	        String sql = "delete tb_danwei  where danwei_name = '"+danWeiName+"'";
	         
	   	   Connection conn = JDBCTool.getConnection();
	   	   PreparedStatement ps = null;
	   	   try {
	   		   ps = conn.prepareStatement(sql);
	   		   ps.executeUpdate();  
	   	
	   	   } catch (SQLException e) {
	   	
	   		   JOptionPane.showMessageDialog(null,"该单位有业务，不可删除");
	   		
	   	   }finally{
	   		   JDBCTool.freeResouse(ps, conn);
	   	   }
	      	return true;
	      }
	    //================================================
	     /**
	 	 * 取出所有单位信息
	 	 * @return
	 	 */
	 	public static Vector getAllColorM(){
	 		
	 		Vector data = new Vector();
	    	
	 		String sql = "select * from tb_color";
	   	 		
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
	 		/**
	 	    * 增加一个单位
	 	    * @param data  会员信息包
	 	    * @return  是否加入
	 	    */
	 	   public static void addAColor(String newDanWei){
	 		   
	 		   String sql = "insert into tb_color values('"+newDanWei+"')";
	 		   Connection conn = JDBCTool.getConnection();
	 		   PreparedStatement ps = null;
	 		   ResultSet st = null;
	 		   
	 		   try {
	 			   ///取出类别ID
	 			   ps = conn.prepareStatement(sql);
	 			   ps.executeUpdate();  
	 		
	 		   } catch (SQLException e) {
	 			   
	 			   JOptionPane.showMessageDialog(null,"该颜色存在");
	 		
	 		   }finally{
	 			   JDBCTool.freeResouse(ps, conn);
	 		   }

	 		

	 	   }
	 	   
	 	   
	 	   /**
	 	     * 删除一个单位
	 	     * @return
	 	     */
	 	     public static boolean deleColor(String danWeiName){
	 	         
	 	     	
	 	        String sql = "delete tb_color  where color_name = '"+danWeiName+"'";
	 	         
	 	   	   Connection conn = JDBCTool.getConnection();
	 	   	   PreparedStatement ps = null;
	 	   	   try {
	 	   		   ps = conn.prepareStatement(sql);
	 	   		   ps.executeUpdate();  
	 	   	
	 	   	   } catch (SQLException e) {
	 	   		   e.printStackTrace();
	 	   		   JOptionPane.showMessageDialog(null,"该颜色有业务，不可删除");
	 	   		   return false;
	 	   	   }finally{
	 	   		   JDBCTool.freeResouse(ps, conn);
	 	   	   }
	 	      	return true;
	 	      }
}
