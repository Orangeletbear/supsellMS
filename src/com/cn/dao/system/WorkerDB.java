package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.system.StorageCulomns;
import com.cn.util.JDBCTool;
import com.cn.view.systemJFrame.CangKuSheZhi;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.WorkSet;

public class WorkerDB {
	
	
	 //查出数据库数据返回
	   public static Vector  getData(){
		   
	  	 Vector data = new Vector();
	  	 String sql = "select yg.yg_name," +
	  	 		"yg.yg_zw,yg.yg_tell,yg.yg_address,"+"yg.yg_bz " +
	  	 				"from tb_yginfo yg,tb_ygqx qx where yg.yg_id=qx.yg_id ";
	 	
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
	   
	   
	   public static Vector getData2(Object o){
		   String sql = "select qx.yg_zgq,qx.yg_kcglq,qx.yg_xsq from tb_ygqx qx" +
		   		" where qx.yg_id=(select yg.yg_id from tb_yginfo yg" +
					" where yg.yg_name='"+o.toString().trim()+"')";
		   Connection conn= JDBCTool.getConnection();
		   Statement st = null;
		   ResultSet rs =null;
		    Vector obj= new Vector();
              try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				int count;
				//Vector //= new Vector ();
				while(rs.next()){
				count = rs.getMetaData().getColumnCount();
				 System.out.println(count);
				for(int i=1;i<=count;i++){
					obj.add(rs.getObject(i));
				}
				} 
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
              finally{
            	  JDBCTool.freeResouse(st, conn);
              }
		   
		   
		   
		   
		   return obj;
	   }
	   
	   
	   public static boolean deleteWorker(Object obj ){
			String sql = "delete tb_yginfo yg where yg.yg_name='"+obj.toString().trim()+"'"; 
			String sql2="delete tb_ygqx qx where qx.yg_id=(select yg.yg_id from tb_yginfo yg" +
					" where yg.yg_name='"+obj.toString().trim()+"')";
			
		         Connection conn = JDBCTool.getConnection();
		         Statement st = null;
		         Statement st2= null;
		        // ResultSet rs = null;
		         try {
		        	 st2=conn.createStatement();
		        	 st2.executeQuery(sql2);
		        	 
					 st=conn.createStatement();
					 st.executeQuery(sql);
				} catch (SQLException e) {
					
					e.printStackTrace();
					return false;
				}
		          finally{
		        	 JDBCTool.freeResouse( st, conn);
		        	  
		          }return true;
		         }
	   
	   
	   public static boolean addWorker(String [] obj){
		  	 String sql = "insert into tb_yginfo values(?,?,?,?,?,?)";
		  	 String sql2 = "insert into tb_ygqx values(?,?,?,?)";
		  	 Connection conn = JDBCTool.getConnection();
				 PreparedStatement ps = null;PreparedStatement ps2 = null;
				 int count = WorkSet.getWorkerModel().getRowCount();
				 String str = ""+count;
				 
		   	 try {
		   		 
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, str);//ID
					
					ps.setString(2, obj[0].toString().trim());
					ps.setString(3, obj[1].toString().trim());
					ps.setString(4, obj[2].toString().trim());
					ps.setString(5, obj[3].toString().trim());
					ps.setString(6, obj[4].toString().trim()); 
					ps.executeUpdate();  
					
					
					
					ps2 = conn.prepareStatement(sql2);
					ps2.setString(1,str);
					ps2.setString(2, obj[5].toString().trim());
					ps2.setString(3, obj[6].toString().trim());
					ps2.setString(4, obj[7].toString().trim());
					ps2.executeUpdate(); 
					
		   		
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}finally{
					JDBCTool.freeResouse( ps,conn);
				}
		  	 return true;
		   }
	   public static Vector findCustomer(String  Name,String srzw){
			  
			  Vector data = new Vector();
		  	  String sql = " select yg.yg_name,yg.yg_zw,"+
		         "yg.yg_tell, yg.yg_address,"+
		         " yg.yg_bz "+
		         " from tb_yginfo yg where (yg.yg_name like '%"+Name+"%' and yg.yg_zw like '%"+srzw+"%')";
		 	
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
	   
	   
	   
	   public static boolean changeWorker(Vector data){
		 	 /* 
		  	 String sql = "select kh.kh_name,kh.kh_lxr,"+
		  	  yg_Id varchar2(5) REFERENCES tb_yginfo(yg_Id),
               yg_zgq varchar2(2),
               yg_kcglq varchar2(2),
               yg_xsq varchar2(2)
                  );
		         "kh.kh_tell,kh.kh_ysjy,kh.kh_address,"+
		         "kh.kh_mrkh,kh.kh_jyf,kh.kh_bz"+
		         "from tb_khinfo kh ";*/
		      
		         String sql ="update tb_yginfo yg  set yg.yg_name=?,yg.yg_zw = ?,"+
		                     "yg.yg_tell =?,yg.yg_address =?,"+
		       	 	         "yg.yg_bz =? "+
		       	 	         "where yg.yg_name='"+data.get(0).toString()+"'";
		         
		         String sql2 = "update tb_ygqx qx set qx.yg_zgq=?,qx.yg_kcglq=?,qx.yg_xsq=? where" +
		         	" qx.yg_id=(select yg.yg_id from tb_yginfo yg where yg.yg_name=" +
		         	"'"+data.get(0).toString()+"')";
		         
		       				
		  	 
		  	 Connection conn = JDBCTool.getConnection();
		   	 PreparedStatement ps = null;
		     PreparedStatement ps2 = null;
				try {
					ps2 = conn.prepareStatement(sql2);
					ps2.setString(1, data.get(5).toString().trim());
					ps2.setString(2, data.get(6).toString().trim());
					ps2.setString(3, data.get(7).toString().trim());
					
					ps2.executeUpdate();
					
					ps = conn.prepareStatement(sql);
					
					ps.setString(1,data.get(0).toString().trim());
					
					ps.setString(2,data.get(1).toString().trim());
					
					ps.setString(3,data.get(2).toString().trim());
					
					ps.setString(4,data.get(3).toString().trim());
				    
					ps.setString(5,data.get(4).toString().trim());
				 
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
