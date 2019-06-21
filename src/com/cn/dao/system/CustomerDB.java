package com.cn.dao.system;
//package mypackage.gui.textmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

 
import com.cn.util.*;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.Customer.FindCustomer;
//import mypackage.tool.commmon.FilePro;

public class CustomerDB{

	
	 //查出数据库数据返回
   public static Vector  getData(){
	   
  	 Vector data = new Vector();
  	  String sql = " select kh.kh_name,kh.kh_lxr,"+
         "kh.kh_tell,kh.kh_ysjy,kh.kh_address,"+
         "kh.kh_mrkh,kh.kh_jyf,kh.kh_bz "+
         " from tb_khinfo kh ";
 	
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
    * 加一条数据到数据库中
    */
   public static boolean addCustomer(Object [] obj){
  	 String sql = "insert into tb_khinfo values(?,?,?,?,?,?,?,?,?)";
  	 
  	 Connection conn = JDBCTool.getConnection();
		 PreparedStatement ps = null;
		 
		 // cu = new CustomerSet(null, null);
		 int count = CustomerSet.getCustomerModel().getRowCount();
		 String str = ""+count;
		 
   	 try {
   		 
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, str);//ID
			
			ps.setString(2, obj[0].toString());
			ps.setString(3, obj[1].toString());
			ps.setString(4, obj[2].toString());
			ps.setString(6, obj[3].toString());
			ps.setFloat(5, new Float(obj[5].toString()).floatValue());//应收金额
			ps.setString(9, obj[4].toString());
			ps.setString(7, obj[6].toString());
            ps.setString(8, obj[7].toString());
			
			ps.executeUpdate();  
   		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			JDBCTool.freeResouse( ps,conn);
		}
  	 return true;
   }

   /**
    * 将改好的客户信息写入数据库
    * @param data  改变的数据包
    * @return 是否写入
    */
   public static boolean changeCustomer(Vector data){
 	 /* 
  	 String sql = "select kh.kh_name,kh.kh_lxr,"+
         "kh.kh_tell,kh.kh_ysjy,kh.kh_address,"+
         "kh.kh_mrkh,kh.kh_jyf,kh.kh_bz"+
         "from tb_khinfo kh ";*/
      
         String sql ="update tb_khinfo kh set kh.kh_name=?,kh.kh_lxr = ?,"+
                     "kh.kh_tell =?,kh.kh_address =?,"+
       	 	         "kh.kh_bz =?,kh.kh_ysjy=?,kh.kh_mrkh=?,kh.kh_jyf=? where " +
       	 	         "kh.kh_name='"+data.get(0)+"'";
       				
  	 
  	 Connection conn = JDBCTool.getConnection();
   	 PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,data.get(0).toString().trim());
			
			ps.setString(2,data.get(1).toString().trim());
			
			ps.setString(3,data.get(2).toString().trim());
			
			ps.setFloat(6,new Float(data.get(5).toString()).floatValue());
			ps.setString(4,data.get(3).toString().trim());
			ps.setString(7,data.get(6).toString().trim());
			ps.setString(5,data.get(4).toString().trim());
			ps.setString(8,data.get(7).toString().trim());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// JOptionPane.showMessageDialog(null,"数据库发生错误，修改操作失败!");
			return false;
		} finally{
			JDBCTool.freeResouse(ps, conn);
		}

 	  
 	  return true;
   }
  


  
  public static boolean deleteCustomer(Object obj ){
	String sql = "delete tb_khinfo kh where kh.kh_name='"+obj.toString().trim()+"'"; 
         Connection conn = JDBCTool.getConnection();
         Statement st = null;
         
         try {
        	 
			st=conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
          finally{
        	  JDBCTool.freeResouse( st, conn);
        	  
          }
          return true;
         }
  
  /**
   * 给定客户信息，查出结果
   *knName  客户名
   *khssSr  联系人
   */
  public static Vector findCustomer(String khName,String lxr){
	  
	  Vector data = new Vector();
  	  String sql = " select kh.kh_name,kh.kh_lxr,"+
         "kh.kh_tell,kh.kh_ysjy,kh.kh_address,"+
         "kh.kh_mrkh,kh.kh_jyf,kh.kh_bz "+
         " from tb_khinfo kh  where (kh.kh_name like '%"+khName+"%' and kh.kh_lxr like '%"+lxr+"%')";
          
 	
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
  
}