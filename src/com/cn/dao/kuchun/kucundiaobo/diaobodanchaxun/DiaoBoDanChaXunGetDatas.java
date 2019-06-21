package com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
/**
 * 初始化调拨单界面
 * @author Administrator
 *
 */
public class DiaoBoDanChaXunGetDatas {
	
	/*
	 * 时间查询调拨单
	 * 
	 */
	
	public static Vector timeChaxun(String dateFrom,String dateTo){
		Vector vo = new Vector();
		String sql = "select dbm.kctb_id,dbm.kctb_ckid,dbm.kctb_lkid,zje, dbm.kctb_tbdate,dbm.kctb_jbr," +
				"dbm.kctb_czy,dbm.kctb_bz from tb_kctb_main dbm,(select dbd.kctbd_tbdh dh, sum(dbd.kctbd_tbzje) zje " +
				"from tb_kctb_detail dbd,tb_kctb_main indbm where indbm.kctb_id = dbd.kctbd_tbdh group by dbd.kctbd_tbdh) tbzje" +
				" where dbm.kctb_id = dh and dbm.kctb_tbdate between ? and ? ";
		
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
					 //设置调入仓库名称
					 if(i == 2){
						 tmp.add(create(rs.getString(i).toString()));
						 
					 }
					 else if(i == 3){
							tmp.add(create(rs.getString(i).toString()));
					 }
					 //将日期字符串转换为日期格式
					 else if(i == 5){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
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
	 * 通过单据号查询
	 * 
	 */
	public static Vector danJuChaXun(){
		Vector vo = new Vector();
		String sql = "select dbm.kctb_id,dbm.kctb_ckid,dbm.kctb_lkid,tbzje.zje, dbm.kctb_tbdate,dbm.kctb_jbr,dbm.kctb_czy,dbm.kctb_bz" +
				" from tb_kctb_main dbm,(select dbd.kctbd_tbdh dh, sum(dbd.kctbd_tbzje) zje from tb_kctb_detail dbd,tb_kctb_main indbm " +
				" where indbm.kctb_id = dbd.kctbd_tbdh group by dbd.kctbd_tbdh) tbzje where dbm.kctb_id = tbzje.dh " ;
		
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
					 //设置调入仓库名称
					 if(i == 2){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					 else if(i == 3){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					 //将日期字符串转换为日期格式
					 else if(i == 5){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
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
	 * 商品调拨详细表
	 */
	public static Vector shangPinChaXun(String id){
		Vector vo = new Vector();
		String sql = "select dbd.kctbd_spid,sp.sp_name,sp.sp_dj,dbd.kctbd_num,dbd.kctbd_tbzje,sp.sp_dw," +
				"sp.sp_ggxh,sp.sp_color from tb_kctb_main dbm,tb_kctb_detail dbd,tb_spinfo sp" +
				" where dbm.kctb_id = dbd.kctbd_tbdh and dbd.kctbd_spid = sp.sp_id and dbd.kctbd_tbdh = '" + id + "'" ;
		
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
					 
						 tmp.add(rs.getObject(i)); 
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
	 *  and dbm.kctb_ckid = '' and dbm.kctb_lkid = '' and dbm.kctb_jbr = '';
	 */
	public static Vector createSQL(String ckname,String lkname,String jbr){
		Vector vo = new Vector();
		String sql = "select dbm.kctb_id,dbm.kctb_ckid,dbm.kctb_lkid,zje, dbm.kctb_tbdate,dbm.kctb_jbr," +
		"dbm.kctb_czy,dbm.kctb_bz from tb_kctb_main dbm,(select dbd.kctbd_tbdh dh, sum(dbd.kctbd_tbzje) " +
		"zje from tb_kctb_detail dbd,tb_kctb_main indbm where indbm.kctb_id = dbd.kctbd_tbdh " +
			"group by dbd.kctbd_tbdh) tbzje where dbm.kctb_id = dh" ;
		String sql1 = "dbm.kctb_ckid = '" + createid(ckname) + "'";
		String sql2 = "dbm.kctb_lkid = '" + createid(lkname) + "'";
		String sql3 = "dbm.kctb_jbr = '" + jbr + "'";
		
		if(ckname.equals("所有仓库")){
			if(lkname.equals("所有仓库")){
				if(jbr.equals("所有经办人")){
					sql = sql + "";
				}else{
					sql = sql + " and " + sql3;
				}
			}else{
				if(jbr.equals("所有经办人")){
					sql = sql + " and " + sql2;
				}else{
					sql = sql + " and " + sql2  + " and " + sql3;
				}
			}
		}else{
			if(lkname.equals("所有仓库")){
				if(jbr.equals("所有经办人")){
					sql = sql + " and " + sql1;
				}else{
					sql = sql + " and " + sql1 + " and " + sql3;
				}
			}else{
				if(jbr.equals("所有经办人")){
					sql = sql + " and " + sql1 + " and " + sql2;
				}else{
					sql = sql + " and " + sql1 + " and " + sql2  + " and " + sql3;
				}
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
				 
				 for(int i = 1;i<=column;i++){
					 //设置调入仓库名称
					 if(i == 2){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					 else if(i == 3){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					 //将日期字符串转换为日期格式
					 else if(i == 5){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
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
		String sql = "select ck.ck_id from tb_ckinfo ck" +
				" where ck.ck_name = '" + CKname + "'";
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
	
}
