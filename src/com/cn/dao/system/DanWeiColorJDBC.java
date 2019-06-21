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
	 * ȡ�����е�λ��Ϣ
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
				//��ȡ���е�����
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
  	
  	 return data;
	}
		/**
	    * ����һ����λ
	    * @param data  ��Ա��Ϣ��
	    * @return  �Ƿ����
	    */
	   public static void addADanWei(String newDanWei){
		   
		   String sql = "insert into tb_danwei values('"+newDanWei+"')";
		   Connection conn = JDBCTool.getConnection();
		   PreparedStatement ps = null;
		   ResultSet st = null;
		   
		   try {
			   ///ȡ�����ID
			   ps = conn.prepareStatement(sql);
			   ps.executeUpdate();  
		
		   } catch (SQLException e) {
			 
			   JOptionPane.showMessageDialog(null,"�õ�λ����");
		
		   }finally{
			   JDBCTool.freeResouse(ps, conn);
		   }

		

	   }
	   
	   
	   /**
	     * ɾ��һ����λ
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
	   	
	   		   JOptionPane.showMessageDialog(null,"�õ�λ��ҵ�񣬲���ɾ��");
	   		
	   	   }finally{
	   		   JDBCTool.freeResouse(ps, conn);
	   	   }
	      	return true;
	      }
	    //================================================
	     /**
	 	 * ȡ�����е�λ��Ϣ
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
	 				//��ȡ���е�����
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
	 			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	 			return data;
	 		} finally{
	 			JDBCTool.freeResorse(rs, st, conn);
	 		}
	   	
	   	 return data;
	 	}
	 		/**
	 	    * ����һ����λ
	 	    * @param data  ��Ա��Ϣ��
	 	    * @return  �Ƿ����
	 	    */
	 	   public static void addAColor(String newDanWei){
	 		   
	 		   String sql = "insert into tb_color values('"+newDanWei+"')";
	 		   Connection conn = JDBCTool.getConnection();
	 		   PreparedStatement ps = null;
	 		   ResultSet st = null;
	 		   
	 		   try {
	 			   ///ȡ�����ID
	 			   ps = conn.prepareStatement(sql);
	 			   ps.executeUpdate();  
	 		
	 		   } catch (SQLException e) {
	 			   
	 			   JOptionPane.showMessageDialog(null,"����ɫ����");
	 		
	 		   }finally{
	 			   JDBCTool.freeResouse(ps, conn);
	 		   }

	 		

	 	   }
	 	   
	 	   
	 	   /**
	 	     * ɾ��һ����λ
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
	 	   		   JOptionPane.showMessageDialog(null,"����ɫ��ҵ�񣬲���ɾ��");
	 	   		   return false;
	 	   	   }finally{
	 	   		   JDBCTool.freeResouse(ps, conn);
	 	   	   }
	 	      	return true;
	 	      }
}
