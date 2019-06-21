package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
import com.cn.view.systemJFrame.OperatorSet;
/**
 * 操作员与数据库交互问题
 * @author finey
 *
 */
public class OperatorDB {
	

	/**
	 * 查出所有操作员信息
	 * @return
	 */
	public static Vector  getData(){
		   
	  	 Vector data = new Vector();
	  	  String sql = "select user_id,user_name," +
	         "user_srzw,user_ispos "+
	         "from tb_usernofo order by user_id" ;
	 	
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
	 * 查出所有操作员信息
	 * @return
	 */
	public static Vector  getData(String user){
		   
	  	 Vector data = new Vector();
	  	  String sql = "select *"+
	         " from tb_usernofo  us where us.user_id = '"+user+"'" ;
	 	  String sqlp = "select * from tb_czy_qx qx where qx.czy_id = '"+user+"'";
	 	   
	 	  Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				    st = conn.createStatement();
					rs = st.executeQuery(sql);
					//获取表中的列数
					int columnCount = rs.getMetaData().getColumnCount();
					rs.next();
				    for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
					}
				    
				    st = conn.createStatement();
					rs = st.executeQuery(sqlp);
					//获取表中的列数
					columnCount = rs.getMetaData().getColumnCount();
					rs.next();
//					
				    for(int column = 1;column<=columnCount;column++){
						data.add(rs.getObject(column));
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
	 * 删除操作员
	 * @param id  操作员ID
	 * @return
	 */
	
	public static boolean deleteOperator(String id){
		String sql = "delete tb_usernofo where user_id='"+id+"'"; 
	         Connection conn = JDBCTool.getConnection();
	         Statement st = null;
	     String sqlp = "delete tb_czy_qx where czy_id ='"+id+"'"; 
	         try {
	        	 
				st=conn.createStatement();
				st.executeQuery(sqlp);
				st=conn.createStatement();
				st.executeQuery(sql);
			} catch (SQLException e) {
				
				return false;
			}
	          finally{
	        	 JDBCTool.freeResouse(st, conn);
	        	  
	          }
	          return true;
	         }
    /**
     * 增加操作员
     * @param obj
     * priData 权限包
     * @return
     */
	public static boolean addOperator(Vector obj,String[] priData){
		
		String sql = "insert into tb_usernofo values(?,?,?,?,?)";
		//权限插入语句
		String psql = "insert into tb_czy_qx values(?,?,?,?,?,?,?)";
		
		
		Connection conn= JDBCTool.getConnection();
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement(sql);
			// ps.setString(1,count);
			 ps.setString(1,obj.get(0).toString());
			 ps.setString(2,obj.get(1).toString());
			 ps.setString(3,obj.get(3).toString());
			 ps.setString(4,obj.get(2).toString());
			 ps.setString(5,obj.get(4).toString());
			 ps.executeUpdate();
			 
			 //权限的修改
			 ps = conn.prepareStatement(psql);
			ps.setString(1,obj.get(0).toString());
			ps.setString(2,priData[0]);
			ps.setString(3,priData[1]);
			ps.setString(4,priData[2]);
			ps.setString(5,priData[3]);
			ps.setString(6,priData[4]);
			ps.setString(7,priData[5]);
			
			ps.executeUpdate();
			 
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null,"数据库发生错误！");
			 e.printStackTrace();
			 return false;
		}
		  finally{
			  JDBCTool.freeResouse(ps, conn);
		  }
		
		return true;
	}
	/**
     * 修改操作员
     * @param obj
     * priData 权限包
     * @return
     */
	public static boolean alterOperator(Vector obj,String[] priData){
		String sql = "update  tb_usernofo tb "+
						" set tb.user_name = ?,tb.user_psw = ?,"+
						    "tb.user_srzw = ?,tb.user_ispos = ? "+ 
						" where tb.user_id = ?";
		
		//操作员权限修改语句
		String psql = " update tb_czy_qx qx set qx.is_cg = ?,qx.is_xs = ?,"+
							"qx.is_kc = ? ,qx.is_bt = ? ,qx.is_rg = ? ,"+
							"qx.is_sz = ? where qx.czy_id = ?";
		
		Connection conn= JDBCTool.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			 ps = conn.prepareStatement(sql);
			// ps.setString(1,count);
			 ps.setString(1,obj.get(1).toString());
			 ps.setString(2,obj.get(3).toString());
			 ps.setString(3,obj.get(2).toString());
			 ps.setString(4,obj.get(4).toString());
			 ps.setString(5,obj.get(0).toString());
			 ps.executeUpdate();

			 //			权限的修改
			 ps = conn.prepareStatement(psql);
			 ps.setString(1,priData[0]);
			 ps.setString(2,priData[1]);
			 ps.setString(3,priData[2]);
			 ps.setString(4,priData[3]);
			 ps.setString(5,priData[4]);
			 ps.setString(6,priData[5]);
			 ps.setString(7,obj.get(0).toString());
			
			 ps.executeUpdate();
			 
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null,"数据库发生错误！");
			 e.printStackTrace();
			 return false;
		}
		  finally{
			  JDBCTool.freeResouse(ps, conn);
		  }
		
		return true;
	}
}
