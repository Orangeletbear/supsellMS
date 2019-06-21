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

/**
 * 商品管理JDBC交互
 * @author finey
 *
 */
public class SanPingGuanLiJDBC{
	
	
	/**
	 * 查出给定商品编号的商品基本信息
	 * @param spID 商品编号
	 * @return 
	 */
     public static Vector getASPMassege(String spID){
    	 Vector data = new Vector();
      	
      	 String sql = "select *"+
      		 			" from tb_spinfo sp,tb_sblb lb"+
      		 			" where sp.sp_lb = lb.sblb_id"+
      		 			" and sp.sp_id = '"+spID+"'";
      	 			
         
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
  		
  			
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
      	
      	return data;
     }
     
	/**
	 * 商品基本信息查询
	 * @param lbName 商品类别
	 * @param spName  商品名称
	 * @return
	 */
     public static Vector getSPBaseMassege(String lbName,String spName){
    	 Vector data = new Vector();
      	
      	 String sql = "select sp.sp_id,sp.sp_name,lb.sblb_name,sp.sp_tm,"+
      	 			"sp.sp_dw,sp.sp_dwgx,sp.sp_ggxh,sp.sp_color,"+
      	 			"(sp.sp_tjdateto - sp.sp_tjdatefrom) 保质期,"+
      	 			"sp.sp_isuse,sp.sp_sftj,sp.sp_zdkc,sp.sp_jj,"+
      	 			"sp.sp_sj,sp.sp_zk,sp.sp_sccs,sp.sp_bz"+
      	 			" from tb_spinfo sp,tb_sblb lb"+
      	 			" where sp.sp_lb = lb.sblb_id"+
      	 			" and (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')";
      	 			
      	
         if("所有类别".equals(lbName)==false){
         	sql = sql+" and lb.sblb_name = '"+lbName+"'";
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
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
      	
      	return data;
     }
     
     
     /**
      * 加入一条数据到商品表中
      * @param data
      * @return
      */
     public static boolean addADataToDataDB(Vector<String> data){
   	  
   	    String sql = "insert into tb_spinfo values(" +
   			    "?,?,?,?,?,?,?,?,?,?,?,?," +
   			    "?,?,?,?,to_date(?,'YYYY-MM-DD')," +
   			    "to_date(?,'YYYY-MM-DD'),?,?,?,?,?)";
   	    
    	String spLbId = null;
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet st = null;
     	try {
     		///取出类别ID
 			ps = conn.prepareStatement("select lb.sblb_Id from " +
 								"tb_sblb lb where lb.sblb_name = ?");
 			ps.setString(1, data.get(0));
 			st = ps.executeQuery();
 			st.next();
 			spLbId = st.getString(1);
 			
 			ps = conn.prepareStatement(sql);
 			
 			ps.setString(1, data.get(1));
 			ps.setString(2, data.get(2));
 			ps.setString(3, data.get(9));
 			ps.setString(4, spLbId);
 			
 			ps.setString(5, data.get(3));
 			ps.setString(6, data.get(5));
 			ps.setString(7, "");
 			ps.setString(8, data.get(8));
 			ps.setString(9, data.get(9));
 			
 			ps.setString(10, data.get(4));
 			ps.setString(11, data.get(17));
 			ps.setString(12, data.get(14));
 			ps.setString(13, data.get(15));
 			ps.setString(14, data.get(14));
 			
 			ps.setString(15, data.get(19));
 			ps.setString(16, data.get(18));
 			ps.setString(17, data.get(20));
 			ps.setString(18, data.get(21));
 			ps.setString(19, data.get(16));
 			ps.setString(20, data.get(14));
 			ps.setString(21, data.get(12));
 			ps.setString(22, data.get(13));
 			ps.setString(23, "001");

 			ps.executeUpdate();  
     		
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return false;
 		}finally{
 			JDBCTool.freeResouse(ps, conn);
 		}
 		
 		return true;
     }
     /**
      * 修改商品信息
      * @param data
      * @return 是否修改成功
      */
     public static boolean atlerSPDataDB(Vector<String> data){
   	  
   	    String sql = "update tb_spinfo sp "+
   	    				" set sp.sp_lb = ?,sp.sp_tm = ?,sp.sp_dw = ?,"+
   	    					"sp.sp_jj = ?,sp.sp_sj = ?,sp.sp_ggxh = ?,"+
   	    					"sp.sp_color = ?,sp.sp_zdkc = ?,sp.sp_sftj = ?,"+
   	    					"sp.sp_zk = ?,sp.sp_hyj = ?,sp.sp_tj = ?,"+
   	    					"sp.sp_tjdatefrom = ?,sp.sp_tjdateto = ?,sp.sp_isuse = ?,"+
   	    					"sp.sp_sccs = ?,sp.sp_bz = ?"+
                        "where sp.sp_id = ?";
   	    
    	String spLbId = null;
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet st = null;
     	try {
     		///取出类别ID
 			ps = conn.prepareStatement("select lb.sblb_Id from " +
 								"tb_sblb lb where lb.sblb_name = ?");
 			ps.setString(1, data.get(0));
 			st = ps.executeQuery();
 			st.next();
 			spLbId = st.getString(1);
 			
 			ps = conn.prepareStatement(sql);
 			
 			ps.setString(1, spLbId);
 			ps.setString(2, data.get(3).toString());
 			ps.setString(3, data.get(5).toString());
 			ps.setFloat(4, new Float(data.get(8).toString()).floatValue());
 			
 			ps.setFloat(5, new Float(data.get(8).toString()).floatValue());
 			ps.setString(6, data.get(4).toString());
 			ps.setString(7, data.get(7).toString());
 			ps.setInt(8, new Integer(data.get(6).toString()).intValue());
 			ps.setString(9, data.get(17).toString());
 			
 			ps.setFloat(10, new Float(data.get(14).toString()).floatValue());
 			
 			ps.setFloat(11, new Float(data.get(19).toString()).floatValue());
 			ps.setFloat(12, new Float(data.get(18).toString()).floatValue());
 			
 			
 			
 			ps.setTimestamp(13, 
 				DateConventer.strToTimestamp(data.get(20).toString(),"yyyy-MM-dd"));
 			ps.setTimestamp(14, 
 				DateConventer.strToTimestamp(data.get(21).toString(),"yyyy-MM-dd"));
 			
 			//System.out.println(data.get(16).toString());
 			//System.out.println(data.get(12).toString());
 			//System.out.println(data.get(13).toString());
 			
 			ps.setString(15, data.get(16).toString());
 			ps.setString(16, data.get(12).toString());
 			ps.setString(17, data.get(13).toString());
 			ps.setString(18, data.get(1).toString());
 			
 			ps.executeUpdate();  
     		
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return false;
 		}finally{
 			JDBCTool.freeResouse(ps, conn);
 		}
 		
 		return true;
     }
     
   /*
 	 * 删除一条给定条件的数据
 	 * num 为给的学号
 	 */
 	public static boolean deleteData(String spID){
 		
 		String sql = "delete tb_spinfo where sp_id ='"+spID+"'";
 		
 		Connection conn = JDBCTool.getConnection();
     	Statement st = null;
     	try {
 			st = conn.createStatement();
 			
 			st.executeUpdate(sql);
     		
 		} catch (SQLException e) {
 			return false;
 		}finally{
 			JDBCTool.freeResouse(st, conn);
 		}
 		
 		return true;
 	}
 	
 	/*
 	 * 获取单位
 	 */
 	
 	public static  String[] getSPDanWei(){
 		
 		String [] data = null;
 		
 		Vector tmpData = new Vector();
      	
     	String sql = "select * from tb_danwei";
     	
     	Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 		try {
 			    st = conn.createStatement();
 				rs = st.executeQuery(sql);
 				while(rs.next()){
 					tmpData.add(rs.getString(1));
 				}
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return data;
 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
 		data = new String[tmpData.size()];
     	for(int i =0;i<tmpData.size();i++){
     		data[i] = tmpData.get(i).toString();
     	}
 		
 		return data;
 	}
 	/*
 	 * 获取商品颜色
 	 */
 	public static  String[] getSPColor(){
 		
 		String [] data = null;
 		
 		Vector tmpData = new Vector();
      	
     	String sql = "select * from tb_color";
     	
     	Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 		try {
 			    st = conn.createStatement();
 				rs = st.executeQuery(sql);
 				while(rs.next()){
 					tmpData.add(rs.getString(1));
 				}
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return data;
 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
 		data = new String[tmpData.size()];
     	for(int i =0;i<tmpData.size();i++){
     		data[i] = tmpData.get(i).toString();
     	}
 		
 		return data;
 	}
 	
 	
 	/**
     * 修改商品折扣
     * @param spID 所要修改的商品ID
     * @return 是否修改成功
     */
    public static boolean atlerSPZheKou(String spZK,String spID){
  	  
  	    String sql = "update tb_spinfo sp "+
  	    				" set sp.sp_zk = "+spZK+""+
                       "where sp.sp_id = "+spID+"";
  	    
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
    	try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();  
    		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
		
		return true;
    }
    
    /**
     * 禁用商品
     * spID 商品ID
     * @return 是否修改成功
     */
    public static boolean jinYongSP(String spID){
  	  
  	    String sql = "update tb_spinfo sp "+
  	    				" set sp.sp_isuse = 0 "+
                       "where sp.sp_id = "+spID+"";
  	    
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
    	try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();  
    		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
		
		return true;
    }
    
    /**
     * 取得给定类别名的类别ID 
     * @param lbName
     * @return  以整型表示的类别ID
     */
    public static int getSPLBNum(String lbName){
    
 
      	
     	String sql = "select sblb_Id from tb_sblb lb" +
     			" where lb.sblb_Name = '"+lbName+"'";
     	
     	Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 		String lbID = null;
 		try {
 			    st = conn.createStatement();
 				rs = st.executeQuery(sql);
 				rs.next();
 				lbID = rs.getString(1);	
 				
 		} catch (SQLException e) {
 			e.printStackTrace();

 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
 		int lb = new Integer(lbID);
 		return lb;
    }
    
    
    /**
     * 取得给定类别名ID的商品总数加一个 
     * @param lbName
     * @return  以整型表示的类别ID
     */
    public static int getSPAtLBNum(String lbName){
    	String sql = null;
    
    		sql = "select * from tb_spinfo sp" +
 			" where sp.sp_Id like '"+lbName+"%'";
    	
    
    	
     	 
     	
     	Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 		String lbID = null;
 		int spNum = 1;
 		try {
 			    st = conn.createStatement();
 				rs = st.executeQuery(sql);
 				while(rs.next()){
 					spNum++;
 				}
 				
 				
 		} catch (SQLException e) {
 			e.printStackTrace();

 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
 		
 		return spNum;
    }
    
    
}
