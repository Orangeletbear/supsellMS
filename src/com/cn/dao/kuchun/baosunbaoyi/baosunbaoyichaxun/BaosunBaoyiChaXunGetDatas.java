package com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * 报损报溢界面初始化程序及条件查询报损报溢信息
 * @author Administrator
 */
public class BaosunBaoyiChaXunGetDatas {
	
	/*
	 * 时间查询调拨单
	 */
	public static Vector timeChaxun(String dateFrom,String dateTo,String lx){
		Vector vo = new Vector();
		String sql = null;
		
		if("商品报损".equals(lx)){
			sql =  "select bsm.bs_id,bsm.bs_date,bsm.bs_ck,bsm.bs_jbr,bsm.bs_czy,bsm.bs_bz " +
			" from tb_bs_main bsm where bsm.bs_date between ? and ? ";
		}
		
		if("商品报溢".equals(lx)){
			sql = "select bym.by_id,bym.by_date,bym.by_ck,bym.by_jbr,bym.by_czy,bym.by_bz" +
					" from tb_by_main bym where bym.by_date between ? and ? ";
		}
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, DateConventer.strToTimestamp(dateFrom,"yyyy-MM-dd"));
			ps.setTimestamp(2, DateConventer.strToTimestamp(dateTo,"yyyy-MM-dd"));
			
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			 
			 while(rs.next()){
				 Vector tmp = new Vector();
				 
				 for(int i = 1; i<= column; i ++){
					 //将日期字符串转换为日期格式
					 if(i == 2){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
					 }
					//设置调入仓库名称
					 else if(i == 3){
						 tmp.add(create(rs.getString(i).toString()));//空指针异常
					 } else{
						 tmp.add(rs.getObject(i)); 
					 }
				 }
				 vo.add(tmp);
			 }
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		
		return vo;
	}
	/*
	 * 通过单据号查询
	 * 
	 */
	public static Vector danJuChaXun(String id,String lx){
		Vector vo = new Vector();
		String sql = null;
		
		if("商品报损".equals(lx)){
			sql =  "select bsm.bs_id,bsm.bs_date,bsm.bs_ck,bsm.bs_jbr,bsm.bs_czy,bsm.bs_bz " +
				" from tb_bs_main bsm where bsm.bs_id = '"+ id + "'";
		}
		
		if("商品报溢".equals(lx)){
			sql = "select bym.by_id,bym.by_date,bym.by_ck,bym.by_jbr,bym.by_czy,bym.by_bz" +
					" from tb_by_main bym where bym.by_id = '" + id + "'";
		}
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			
			 while(rs.next()){
				 Vector tmp = new Vector();
				//将日期字符串转换为日期格式
				 for(int i = 1;i<=column;i++){
					 if(i == 2){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
					 }
					 //设置调入仓库名称
					 else if(i == 3){
						 tmp.add(create(rs.getString(i).toString()));
					 }else{
						 tmp.add(rs.getObject(i)); 
					 }
				 }
				 vo.add(tmp);
			 }
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}
	
	/*
	 * 商品调拨详细表,通过获得单据id来查询
	 */
	public static Vector shangPinChaXun(String id,String lx){
		Vector vo = new Vector();
		String sql = null;
		
		if("商品报损".equals(lx.trim())){
			sql =  "select bsd.bsd_xspid,sp.sp_name,sp.sp_lb,bsd.bsd_num,sp.sp_dj,bsd.bsd_zje,sp.sp_dw,sp.sp_ggxh," +
					" sp.sp_color,bsm.bs_bz from tb_bs_detail bsd,tb_bs_main bsm ,tb_spinfo sp" +
					" where bsm.bs_id = bsd.bsd_xbid and bsd.bsd_xspid = sp.sp_id and bsm.bs_id = '"+ id +"'";
		}
		
		if("商品报溢".equals(lx.trim())){
			sql = "select byd.byd_spid,sp.sp_name,sp.sp_name,sp.sp_lb,byd.byd_num,sp.sp_dj,byd.byd_zje,sp.sp_dw,sp.sp_ggxh," +
					" sp.sp_color,bym.by_bz from tb_by_main bym ,tb_by_detail byd, tb_spinfo sp" +
					" where bym.by_id = byd.byd_cdid and byd.byd_spid = sp.sp_id and bym.by_id =  '" + id + "'";
		}
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			
			 while(rs.next()){
				 Vector tmp = new Vector();
				 
				 for(int i = 1;i<=column;i++){
					 	if(i == 3){
					 		tmp.add(createLB(rs.getString(i)));
					 	}else {
					 		tmp.add(rs.getObject(i));
					 	}	
				 }
				 vo.add(tmp);
			 }
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}
	
	/*
	 * 高级查询，通过调出仓库，调入仓库，经办人来查询调拨单详情
	 */
	public static Vector createSQL(String ckName,String jbr,String lx){
//		Vector vo = new Vector();
		String sql  = null;
		String sql1 = null;
		String sql2 = null;
		//select bsm.bs_id,bsm.bs_date,bsm.bs_ck,bsm.bs_jbr,bsm.bs_czy,bsm.bs_bz from tb_bs_main bsm 
		//where bsm.bs_ck = '001' and bsm.bs_jbr = '小李';
		//select bym.by_id,bym.by_date,bym.by_ck,bym.by_jbr,bym.by_czy,bym.by_bz from tb_by_main bym 
		//where bym.by_ck = '001' and bym.by_jbr = '小周';  
		
		if("商品报损".equals(lx.trim())){
			sql =  "select bsm.bs_id,bsm.bs_date,bsm.bs_ck,bsm.bs_jbr,bsm.bs_czy,bsm.bs_bz from tb_bs_main bsm";
			sql1 = "bsm.bs_ck = '" + createid(ckName) + "'";
			sql2 = "bsm.bs_jbr = '" + jbr + "'"; 
		}
		
		if("商品报溢".equals(lx.trim())){
			sql = "select bym.by_id,bym.by_date,bym.by_ck,bym.by_jbr,bym.by_czy,bym.by_bz from tb_by_main bym ";
			sql1 ="bym.by_ck = '" + createid(ckName) + "'";
			sql2 = "bym.by_jbr = '" + jbr + "'";
		}	
		
		if("所有仓库".equals(ckName.trim())){
			if("所有经办人".equals(jbr.trim())){
				sql = sql + "";
			}else {
				sql = sql + " where " + sql2;
			}
		}else{
			if("所有经办人".equals(jbr.trim())){
				sql = sql + " where " + sql1;
			}else {
				sql = sql + " where " + sql1 + " and " + sql2;
			}
		}
		
		return gaoJiChaXun(sql);
	}
	public static Vector gaoJiChaXun(String sql){
		Vector vo = new Vector();
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			
			 while(rs.next()){
				 Vector tmp = new Vector();
				//将日期字符串转换为日期格式
				 for(int i = 1;i<=column;i++){
					 if(i == 2){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
					 }
					 //设置调入仓库名称
					 else if(i == 3){
						 tmp.add(create(rs.getString(i).toString()));
					 }else{
						 tmp.add(rs.getObject(i)); 
					 }
				 }
				 vo.add(tmp);
			 }
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}
	
	
	/*
	 * 查询仓库名称
	 */
	private static String create(String CKid){
		Connection conn = JDBCTool.getConnection();
		String sql = "select ck.ck_name from tb_ckinfo ck" +
				" where ck.ck_id = '" + CKid + "'";
		
		String name = null;
		Statement st= null;
		ResultSet rs = null;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					name = rs.getString("ck_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return name;
	}
	
	/*
	 * 查询仓库id
	 */
	private static String createid(String CKname){
		Connection conn = JDBCTool.getConnection();
		String sql = null;
		
		if("所有仓库".equals(CKname)){
			return null;
		}else {
			sql = "select ck.ck_id from tb_ckinfo ck" +
			" where ck.ck_name = '" + CKname + "'";
		}
		String id = null;
		Statement st= null;
		ResultSet rs = null;
		
		try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					id = rs.getString("ck_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return id;
	}
	
	/*
	 * 查询商品类别名称
	 */
	private static String createLB(String LBid){
		Connection conn = JDBCTool.getConnection();
		String sql = "select sb.sblb_name from tb_sblb sb where sb.sblb_id ='" + LBid + "'";
		String name = null;
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()){
					name = rs.getString("sblb_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return name;
	}
	
	
	
}
