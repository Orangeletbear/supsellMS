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
 * 会员管理的一些数据交互
 * @author finey
 *
 */
public class HuiYuanXinGLJDBC {
		
    /**
     * 查出会员基本信息
     * @param hyId  会员号或会员名
     * @return
     */
	public static Vector getHuiYuanBaseM(String hyId){
		
		Vector data = new Vector();
   	
		String sql = "select hy.hy_id,hy.hy_name,hyj.hyjb_name,hy.hy_jf,"+
						"hyx.hyxf_xhye,hyx.hyxf_zxf,hyx.hyxf_xfcs,hy.hy_zt,hy.hy_isjfsj,"+
						"hy.hy_syqx,hy.hy_tell,hy.hy_sr,hy.hy_jldate,"+
						"hy.hy_jzdate,hy.hy_bz"+
						" from tb_hyinfo hy,tb_hyjb hyj,tb_hyxfb hyx"+
						" where (hy.hy_id like '%"+hyId+"%' or hy.hy_name like '%"+hyId+"%')"+
						" and hyj.hyjb_id = hy.hy_level "+
						" and hy.hy_id = hyx.hyxf_id(+)";
  	 		
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
	 * 查出会员的续费信息
	 * @param dateFrom   开始日期
	 * @param dateTo   结束日期
	 * @param hyId   会员号，或名称
	 * @return
	 */
   public static Vector getHuiYuanXuFei(String dateFrom ,String dateTo,String hyId){
		
		Vector data = new Vector();
   	
		String sql = "select xf.hyxf_jfdate,xf.hyxf_id,hy.hy_name,"+
						"xf.hyxf_sfje,xf.hyxf_sjzf,xf.hyxf_czy,xf.hyxf_bz"+
						" from  tb_hyxf xf,tb_hyinfo hy"+
						" where hy.hy_id = xf.hyxf_id and (hy.hy_id like '%"+hyId+"%' " +
								"or hy.hy_name like '%"+hyId+"%')"+
						" and (xf.hyxf_jfdate - to_date(?,'yyyy-mm-dd')) >= 0 "+
						" and (to_date(?,'yyyy-mm-dd') - xf.hyxf_jfdate) >= 0";
  	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		
		try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,dateFrom );
				ps.setString(2,dateTo );
				
				rs = ps.executeQuery();
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
			JDBCTool.freeResorse(rs, ps, conn);
		}
  	
  	 return data;
	}
   /**
    * 查出会员级别基本信息
    * @param hyId  级别编号或名称
    * @return
    */
	public static Vector getHuiJiBieBaseM(String hyId){
		
		Vector data = new Vector();
  	
		String sql = "select jb.hyjb_id,jb.hyjb_name,jb.hyjb_jbzk,jb.hyjb_jfxx,jb.hyjb_jfsx "+
						" from  tb_hyjb jb "+
						" where jb.hyjb_id like '%"+hyId+"%' or jb.hyjb_name like '%"+hyId+"%'";
 	 		
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
    * 取得所有会员级别名
    * @return
    */
   public static String[] getHuiYuanJiBie(){
	   String[] jieBieName = null;
	   
	   String sql = "select jb.hyjb_name from tb_hyjb jb";
	   
	   Vector data = new Vector();
	   
	   Connection conn = JDBCTool.getConnection();
	   Statement st = null;
	   ResultSet  rs = null;
		
		try {
			    st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
			       data.add(rs.getString(1));
				
			    }
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			return jieBieName;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
	   jieBieName= new String[data.size()];
	   for(int i =0;i<data.size();i++){
		   jieBieName[i] = data.get(i).toString();
	   }
	   return jieBieName;
   }
   /**
    * 增加一条会员信息记录
    * @param data  会员信息包
    * @return  是否加入
    */
   public static boolean addAHuiYuanData(Vector<String> data){
	   
	   String sql = "insert into tb_hyinfo values" +
	   		"(?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
	   String jbID = null;
	   Connection conn = JDBCTool.getConnection();
	   PreparedStatement ps = null;
	   ResultSet st = null;
	   
	   try {
		   ///取出类别ID
		   ps = conn.prepareStatement("select jb.hyjb_id from " +
						"tb_hyjb jb where jb.hyjb_name = ?");
		   ps.setString(1, data.get(1));
		   st = ps.executeQuery();
		   st.next();
		   jbID = st.getString(1);
	
		   ps = conn.prepareStatement(sql);
	
		   ps.setString(1, data.get(0));
		   ps.setString(2, data.get(2));
		   ps.setString(3, jbID);
		   ps.setString(4, data.get(6));
	
		   ps.setString(5, data.get(11));
		   ps.setString(6, data.get(10));
		   ps.setTimestamp(7, 
				DateConventer.strToTimestamp(data.get(4), "yyyy-MM-dd"));
		   
		   ps.setString(8, data.get(7));
		   ps.setTimestamp(9, 
			    DateConventer.strToTimestamp(data.get(8), "yyyy-MM-dd"));
	
		   ps.setTimestamp(10, 
				    DateConventer.strToTimestamp(data.get(9), "yyyy-MM-dd"));
		   ps.setString(11, data.get(12));
		   ps.setString(12, data.get(13));
		   ps.setString(13, data.get(3));
	       
		   ps.executeUpdate();  
	
	   } catch (SQLException e) {
		   e.printStackTrace();
		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
		   return false;
	   }finally{
		   JDBCTool.freeResouse(ps, conn);
	   }

	   return true;

   }
   
   /**
    * 修改一条会员信息记录
    * @param data  会员信息包
    * @return  是否成功修改
    */
   public static boolean atlerHuiYuanMassege(Vector<String> data){
	   
	   String sql = "update tb_hyinfo hy "+
		   			  "set hy.hy_name = ? ,hy.hy_level = ?,hy.hy_jf = ?,"+
		   			   " hy.hy_zt = ?,hy.hy_syqx = ?,hy.hy_sr = ?,"+
		   			    " hy.hy_tell = ?,hy.hy_jldate = ?,hy.hy_jzdate = ?,"+
		   			   " hy.hy_isjfsj = ?,hy.hy_bz = ?,hy.hy_secret= ?"+
		   			  " where hy.hy_id = ?";
  
	   String jbID = null;
	   Connection conn = JDBCTool.getConnection();
	   PreparedStatement ps = null;
	   ResultSet st = null;
	   
	   try {
		   ///取出类别ID
		   ps = conn.prepareStatement("select jb.hyjb_id from " +
						"tb_hyjb jb where jb.hyjb_name = ?");
		   ps.setString(1, data.get(1));
		   st = ps.executeQuery();
		   st.next();
		   jbID = st.getString(1);
	
		   ps = conn.prepareStatement(sql);
	
		   ps.setString(1, data.get(2));
		   ps.setString(2, jbID);
		   ps.setString(3, data.get(6));
		   ps.setString(4, data.get(11));
		   
	       if(data.get(10).equals("1")){
	    	   ps.setString(5, "一年");
	       }else{
	    	   ps.setString(5, "无期");
	       }
		  
		   ps.setTimestamp(6, 
				DateConventer.strToTimestamp(data.get(4), "yyyy-MM-dd"));
		   
		   ps.setString(7, data.get(7));
		   ps.setTimestamp(8, 
			    DateConventer.strToTimestamp(data.get(8), "yyyy-MM-dd"));
	
		   ps.setTimestamp(9, 
				    DateConventer.strToTimestamp(data.get(9), "yyyy-MM-dd"));
		   ps.setString(10, data.get(12));
		   ps.setString(11, data.get(13));
		   ps.setString(12, data.get(3));
		   ps.setString(13, data.get(0));
		   
		   ps.executeUpdate();  
	
	   } catch (SQLException e) {
		   e.printStackTrace();
		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
		   return false;
	   }finally{
		   JDBCTool.freeResouse(ps, conn);
	   }

	   return true;

   }
   
   /**
	 * 查出给定会员编号的基本信息
	 * @param hyID 会员编号
	 * @return 
	 */
    public static Vector getAHYMassege(String hyID){
   	 Vector data = new Vector();
     	
     	 String sql = " select *"+
     		 			 " from tb_hyinfo hy,tb_hyjb jb"+
     		 			  " where jb.hyjb_id = hy.hy_level"+
     		 				" and hy.hy_id  =  '"+hyID+"'";
     	 			
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
 			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 			return data;
 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
     	
     	return data;
    }
   //===================================================================
    /**
	 * 查出给定会员级别编号的基本信息
	 * @param jbID 会员编号
	 * @return 
	 */
    public static Vector getAJiBieXinXi(String jbID){
   	   
    	Vector data = new Vector();
     	
     	String sql = " select *"+
     		 			 " from tb_hyjb jb"+
     		 			  " where jb.hyjb_id  =  '"+jbID+"'";
     	 			
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
 			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 			return data;
 		} finally{
 			JDBCTool.freeResorse(rs, st, conn);
 		}
     	
     	return data;
    }
    
    /**
     * 删除一条级别信息
     * @param hyID 会员号
     * @return
     */
     public static boolean deleHuiYuan(String hyID){
         
     	
        String sql = "delete b_hyinfo hy  where hy.hy_id = "+hyID;
         
   	   Connection conn = JDBCTool.getConnection();
   	   PreparedStatement ps = null;
   	   ResultSet st = null;
   	   
   	   try {
   		   
   	
   		   ps = conn.prepareStatement(sql);
   		   ps.executeUpdate();  
   	
   	   } catch (SQLException e) {
   		   e.printStackTrace();
   		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
   		   return false;
   	   }finally{
   		   JDBCTool.freeResouse(ps, conn);
   	   }
      	return true;
      }
    
    
    /**
     * 增加一条级别记录
     * @param data 级别数据包
     * @return
     */
    public static boolean addAJiBieXinXi(Vector data){
    	
       String sql = "insert into tb_hyjb values(?,?,?,?,?)";
       
 	   Connection conn = JDBCTool.getConnection();
 	   PreparedStatement ps = null;
 	   ResultSet st = null;
 	   
 	   try {
 		   
 	
 		   ps = conn.prepareStatement(sql);
 	
 		   ps.setString(1, data.get(0).toString());
 		   ps.setString(2, data.get(1).toString());
 		   ps.setFloat(3, new Float(data.get(2).toString()));
 		   ps.setInt(4, new Integer(data.get(3).toString()));
 		   ps.setInt(5,new Integer(data.get(4).toString()));
		   
 	       
 		   
 		   ps.executeUpdate();  
 	
 	   } catch (SQLException e) {
 		   e.printStackTrace();
 		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 		   return false;
 	   }finally{
 		   JDBCTool.freeResouse(ps, conn);
 	   }

    	
    	
    	return true;
    }
    
    /**
     * 修改一条级别记录
     * @param data 级别数据包
     * @return
     */
    public static boolean atlerAJiBieXinXi(Vector data){
       
    	
       String sql = "update tb_hyjb jb " +
       					"set jb.hyjb_name = ?,jb.hyjb_jbzk = ?," +
       					"jb.hyjb_jfxx = ?,jb.hyjb_jfsx = ?" +
       					" where jb.hyjb_id = ?";
       
       
       
 	   Connection conn = JDBCTool.getConnection();
 	   PreparedStatement ps = null;
 	   ResultSet st = null;
 	   
 	   try {
 		   
 	
 		   ps = conn.prepareStatement(sql);
		   ps.setString(1, data.get(1).toString());
		   ps.setFloat(2, new Float(data.get(2).toString()));
		   ps.setInt(3, new Integer(data.get(3).toString()));
		   ps.setInt(4,new Integer(data.get(4).toString()));
		   ps.setString(5, data.get(0).toString());
 	      
 		   ps.executeUpdate();  
 	
 	   } catch (SQLException e) {
 		   e.printStackTrace();
 		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 		   return false;
 	   }finally{
 		   JDBCTool.freeResouse(ps, conn);
 	   }

    	
    	return true;
    }
    
   /**
    * 删除一条级别信息
    * @param jbID
    * @return
    */
    public static boolean deleJiBie(String jbID){
        
    	
       String sql = "delete tb_hyjb jb  where jb.hyjb_id = "+jbID;
        
  	   Connection conn = JDBCTool.getConnection();
  	   PreparedStatement ps = null;
  	   ResultSet st = null;
  	   
  	   try {
  		   
  	
  		   ps = conn.prepareStatement(sql);
  		   ps.executeUpdate();  
  	
  	   } catch (SQLException e) {
  		   e.printStackTrace();
  		   JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
  		   return false;
  	   }finally{
  		   JDBCTool.freeResouse(ps, conn);
  	   }
     	return true;
     }
    
  //===================================================================
      
    /**
     * 查出会员消费信息
     * dateFrom 开始时间
     * dateTo 截止时间
     * hyID 会员ID或名字
     */
 	public static Vector getHuiYuanXiaoFeiXinXi(
 			String dateFrom ,String dateTo,String hyId){
 		
 		Vector data = new Vector();
   	
 		String sql = "select hy.hy_id,hy.hy_name,pxf.posxfb_id,pxf.posxfb_date,"+
 						" pxf.posxfb_yfje,fs.kh_xffs_name,Floor(pxf.posxfb_yfje/20),"+
 			" Trunc(mod(pxf.posxfb_yfje,20),2),pxf.posxfb_bz"+
 			" from tb_posxfb_main pxf ,tb_hyinfo hy,tb_kh_xffs fs"+
 			" where fs.kh_xffs_id = pxf.posxfb_fkfs and hy.hy_id = pxf.posxfb_gkjb"+
 			" and (hy.hy_id like '%"+hyId+"%' or hy.hy_name like '%"+hyId+"%')"+
 			" and pxf.posxfb_date between ?  and ? ";
  	 		
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet  rs = null;
 		
 		try {
 			    ps = conn.prepareStatement(sql);
 			    ps.setTimestamp(1, DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
 			    ps.setTimestamp(2,DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
 				rs = ps.executeQuery();
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
 			JDBCTool.freeResorse(rs, ps, conn);
 		}
  	
  	 return data;
 	}
 	
 	/**
     * 查出会员消费详细信息
     * xfDanHao  消费单号
     */
 	public static Vector getHuiYuanXiaoFeiMingxi(String xfDanHao){
 		
 		Vector data = new Vector();
   	
 		String sql = "select sp.sp_id,sp.sp_name,sp.sp_dj,xfm.posxfbd_num,"+
 						     " sp.sp_dw,xfm.posxfbd_zje,sp.sp_ggxh,sp.sp_sccs"+
 							" from tb_posxfb_detail xfm,tb_spinfo sp"+
 							" where  sp.sp_id = xfm.posxfbd_spid "+
 							" and xfm.posxfbd_id = '"+xfDanHao+"' "	;
  	 		
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet  rs = null;
 		
 		try {
 			    ps = conn.prepareStatement(sql);
 			    
 				rs = ps.executeQuery();
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
 			JDBCTool.freeResorse(rs, ps, conn);
 		}
  	
  	 return data;
 	}
 
 	/**
     * 查出会员消费信息
     * dateFrom 开始时间
     * dateTo 截止时间
     * hyID 会员ID或名字
     */
 	public static Vector getHuiYuanXiaoFeiMassege(
 			String dateFrom ,String dateTo,String hyId){
 		
 		Vector data = new Vector();
   	
 		String sql = "select pxf.posxfb_id,pxf.posxfb_date,"+
 						" pxf.posxfb_yfje,fs.kh_xffs_name,Floor(pxf.posxfb_yfje/20),"+
 			" Trunc(mod(pxf.posxfb_yfje,20),2),pxf.posxfb_bz"+
 			" from tb_posxfb_main pxf ,tb_hyinfo hy,tb_kh_xffs fs"+
 			" where fs.kh_xffs_id = pxf.posxfb_fkfs and hy.hy_id = pxf.posxfb_gkjb"+
 			" and (hy.hy_id like '%"+hyId+"%' or hy.hy_name like '%"+hyId+"%')"+
 			" and pxf.posxfb_date between ?  and ? ";
  	 		
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet  rs = null;
 		
 		try {
 			    ps = conn.prepareStatement(sql);
 			    ps.setTimestamp(1, DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
 			    ps.setTimestamp(2,DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
 				rs = ps.executeQuery();
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
 			JDBCTool.freeResorse(rs, ps, conn);
 		}
  	
  	 return data;
 	}
 	/**
 	 * 将给定的会员号的积分清零
 	 * @param hyID
 	 */
 	public static void huiYuanJiFenSetO(String hyID){
 		
 		String sql = "update tb_hyinfo hy " +
			"set hy.hy_jf = 0  where hy.hy_id = '"+hyID+"'";

 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet st = null;
 		try {
 			ps = conn.prepareStatement(sql);

 			ps.executeUpdate();  

 			} catch (SQLException e) {
 				e.printStackTrace();
 				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 			}finally{
 				JDBCTool.freeResouse(ps, conn);
 			}

 	}
 	
 	/**
 	 * 将给定的会员号充值
 	 * sje  实充金额，
 	 * dje 到账金额
 	 * user 操作员
 	 * @param hyID
 	 */
 	public static boolean huiYuanAddMoney(
 			String sje,String dje,String hyID,String user){
 		
 		String sql = "insert into tb_hyxf values(sysdate,'"+hyID+"'," +
 				"'"+sje+"','"+dje+"','"+user+"',null)";
        String sql1 = "select * from tb_hyxfb where hyxf_Id = '"+hyID+"'";
        
 		Connection conn = JDBCTool.getConnection();
 		PreparedStatement ps = null;
 		ResultSet rs = null;
 		ResultSet st = null;
 		try {
 			
 			ps = conn.prepareStatement(sql1);
 			rs = ps.executeQuery();
 			
 			boolean isHere = rs.next();
 			float number = new Float(dje).floatValue();
 			//插入金额
 			if(isHere){
 				ps = conn.prepareStatement("update tb_hyxfb set " +
 						"hyxf_xhye = CoalEsce((hyxf_xhye + ?),hyxf_xhye,?) where hyxf_Id = '"+hyID+"'");
 	 			ps.setFloat(1, number);
 	 			ps.setFloat(2, number);
 	 			
 				ps.executeUpdate(); 
 			}else{
 				ps = conn.prepareStatement("insert into tb_hyxfb values(" +
 						"'"+hyID+"','"+dje+"',0.0,0)");
 	 			ps.executeUpdate(); 
 			}
 			
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
}
