package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.GongHuoShang;

public class SupllyDB {
	
	
	 //查出数据库数据返回
	   public static Vector getData(){
		   
	  	 Vector data = new Vector();
	  	  String sql = "select ghs.ghs_name,ghs.ghs_lxr," +
	  	  		"ghs.ghs_tell,ghs.ghs_yfjy," +
	  	  		"ghs.ghs_address,ghs.ghs_ismr," +
      "ghs.ghs_jyf,ghs.ghs_bz "+
      "from tb_ghsinfo ghs";
	 	
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
	   public static boolean deleteSupply(String obj ){
			String sql = "delete tb_ghsinfo ghs where ghs.ghs_name='"+obj+"'"; 
		         Connection conn = JDBCTool.getConnection();
		         Statement st = null;
		         
		         try {
					st=conn.createStatement();
					st.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
		          finally{
		        	  try {
						st.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return false;
					}
		        	  
		          }return true;
		         }
	   public static boolean addSuplly(Object [] obj){
		  	 String sql = "insert into tb_ghsinfo values(?,?,?,?,?,?,?,?,?)";
		  	 
		  	 Connection conn = JDBCTool.getConnection();
				 PreparedStatement ps = null;
				 
				// GongHuoShang cu = new GongHuoShang(null, sql);
				 int count = GongHuoShang.getSupplyModel().getRowCount();
				 String str = ""+count;
				 
		   	 try {
		   		 
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, str);//ID
					
					ps.setString(2, obj[0].toString());
					ps.setString(3, obj[1].toString());
					ps.setString(4, obj[2].toString());
					ps.setString(5, obj[3].toString());
					ps.setFloat(6, new Float(obj[5].toString()).floatValue());//应收金额
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
	   
	   public static Vector findSuplly(String Name,String lxr){
			  
			  Vector data = new Vector();
		  	  String sql = " select ghs.ghs_name,ghs.ghs_lxr,"+
		         "ghs.ghs_tell, ghs.ghs_address,ghs.ghs_yfjy,"+
		         "ghs.ghs_ismr,ghs.ghs_jyf,ghs.ghs_bz "+
		         "from tb_ghsinfo ghs where (ghs.ghs_name like '%"+Name+"%' and ghs.ghs_lxr like '%"+lxr+"%')";
		 	
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
	   public static boolean changeSuplly(Vector data){
		 	 /* 
		  	 String sql = "select kh.kh_name,kh.kh_lxr,"+
		         "kh.kh_tell,kh.kh_ysjy,kh.kh_address,"+
		         "kh.kh_mrkh,kh.kh_jyf,kh.kh_bz"+
		         "from tb_khinfo kh ";*/
		      
		         String sql ="update tb_ghsinfo gh set gh.ghs_name=?,gh.ghs_lxr = ?,"+
		                     "gh.ghs_tell =?,gh.ghs_address =?,gh.ghs_yfjy=?,"+
		       	 	         "gh.ghs_ismr=?,gh.ghs_jyf=?,gh.ghs_bz =? where " +
		       	 	         "gh.ghs_name='"+data.get(0)+"'";
		       				
		  	 
		  	 Connection conn = JDBCTool.getConnection();
		   	 PreparedStatement ps = null;
				
				try {
					
					ps = conn.prepareStatement(sql);
					ps.setString(1,data.get(0).toString().trim());
					
					ps.setString(2,data.get(1).toString().trim());
					ps.setString(3,data.get(2).toString().trim());
					ps.setString(4,data.get(3).toString().trim());
					ps.setFloat(5,new Float(data.get(4).toString()).floatValue());
					ps.setString(6,data.get(5).toString().trim());
					ps.setString(7,data.get(6).toString().trim());
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
		    
		  
}
