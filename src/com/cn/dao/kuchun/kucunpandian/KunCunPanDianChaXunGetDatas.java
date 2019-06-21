package com.cn.dao.kuchun.kucunpandian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

public class KunCunPanDianChaXunGetDatas {

	/*
	 * 高级查询弹出界面 :高级查询，通过时间始末，仓库及操作员来获取盘点商品的详细信息
	 */
	public static Vector gaoJiChaXun(String dateFrom,String dateTo,String ckName,String czy){
		Vector vo = new Vector();
		
		String sql =  "select pdm.pd_id,pdm.pd_ck,pdm.pd_date,pdm.pd_czy,pdm.pd_ypts,pdm.pd_ypzs,pdm.pd_bz " +
				" from tb_pd_main pdm where pdm.pd_date between ? and ?  and pdm.pd_ck = '" 
						+ createid(ckName) + "' and pdm.pd_czy = '" + czy + "'";
		
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
				//将日期字符串转换为日期格式
				 for(int i = 1;i<=column;i++){
					 if(i == 2){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					 //设置调入仓库名称
					 else if(i == 3){
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
	 *盘点单据高级查询，通过时间始末，仓库及操作员来获取盘点商品的详细信息
	 */
	public static Vector danJuChaXun(String dateFrom,String dateTo,String ckName,String czy){
		Vector vo = new Vector();
		
		String sql =  "select pdm.pd_id,pdm.pd_date,sp.sp_id,sp.sp_name,splb.sblb_name," +
				" sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc,pdd.pdd_num,pdm.pd_ck" +
				"  from tb_spinfo sp,tb_pd_main pdm,tb_pd_detail pdd ,tb_sblb splb where pdm.pd_id =" +
				" pdd.pdd_sbid and sp.sp_lb = splb.sblb_id and pdd.pdd_spid = sp.sp_id and pdm.pd_date between  ? and ? " ;
		String sql1 = " pdm.pd_ck = '" + createid(ckName) + "' ";
		String sql2 = " pdm.pd_czy = '" + czy + "'";
		
		if(ckName.equals("所有仓库")){
			if(czy.equals("所有操作员")){
				sql = sql + "";
			}else{
				sql = sql + " and " + sql2;
			}
		}else{
			if(czy.equals("所有操作员")){
				sql = sql +  " and " + sql1;
			}else{
				sql = sql + " and " + sql1 + " and " + sql2;
			}
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
					//将日期字符串转换为日期格式
					 for(int i = 1;i<=column;i++){
						 if(i == 2){
							 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
						 }
						 //设置调入仓库名称
						 else if(i == 10){
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
	 * 将新增的盘点单加入到盘点主界面
	 * "select ck.ck_name from tb_ckinfo ck" +
				" where ck.ck_id = '" + CKid + "'";
	 */
	public static Vector panDianDanjuChaXun(String id){
		Vector vo = new Vector();
		String sql =  "select pdm.pd_id,ck.ck_name,pdm.pd_date,pdm.pd_czy,pdm.pd_ypts,pdm.pd_ypzs,pdm.pd_bz " +
		" from tb_pd_main pdm ,tb_ckinfo ck where ck.ck_id = pdm.pd_ck and pdm.pd_id = '" + id + "'";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			
			 while(rs.next()){
				 Vector tmp = new Vector();
					 for(int i = 1;i <= column;i++){
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
	 * 通过盘点单号来查询盘点商品信息
	 */
	public static Vector shangPinChaXun(String id){
		Vector vo = new Vector();
		String sql = "select pdd.pdd_spid,sp.sp_name,splb.sblb_name,sp.sp_dw,sp.sp_ggxh,sp.sp_sccs,sp.sp_zdkc,pdd.pdd_num" +
				" from tb_pd_main pdm,tb_pd_detail pdd,tb_spinfo sp,tb_sblb splb where sp.sp_lb = splb.sblb_id and" +
				" pdm.pd_id = pdd.pdd_sbid and pdd.pdd_spid = sp.sp_id and pdm.pd_id = '" + id + "'";
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
	 * 盘盈盘亏界面盘点单查询:通过仓库和操作员来查询
	 * 
	 */
	public static Vector panYingPanKuiChaXun(String ckName,String czy){
		Vector vo = new Vector();
		
		String sql =  "select pdm.pd_id,pdm.pd_ck,pdm.pd_date,pdm.pd_czy,pdm.pd_ypts,pdm.pd_ypzs,pdm.pd_bz " +
				" from tb_pd_main pdm where pdm.pd_ck = '"  + createid(ckName) + "' and pdm.pd_czy = '" + czy + "'";
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int column = rs.getMetaData().getColumnCount();
			
			 while(rs.next()){
				 Vector tmp = new Vector();
				
				//设置调入仓库名称
				 for(int i = 1;i<=column;i++){
					 if(i == 2){
						 tmp.add(create(rs.getString(i).toString()));
					 }
					//将日期字符串转换为日期格式
					 else if(i == 3){
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
	 * 通过盘点单号来查询修改商品窗口的商品信息
	 */
	public static Vector xiugaiShangPinChaXun(String id){
		Vector vo = new Vector();
		String sql = "select pdd.pdd_spid,sp.sp_id,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc,pdd.pdd_num" +
				" from tb_spinfo sp,tb_pd_detail pdd where sp.sp_id = pdd.pdd_spid and pdd.pdd_sbid = '" + id + "'";
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
	 * 
	 * 通过商品号来删除该盘点单上的盘点商品
	 */
	public static void deletePanDianDan(String PDid){
		deletePanDianShangPin(PDid);
		Connection conn = JDBCTool.getConnection();
//		Vector vo = new Vector();
		String sql = "delete tb_pd_main where pd_id ='"
			+ PDid + "'";
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	/*
	 * 通过盘点单号，删除盘点商品中的此项记录，包含该盘点单号的商品
	 */
	public static void deletePanDianShangPin(String PDid){
		Connection conn = JDBCTool.getConnection();
//		Vector vo = new Vector();
		String sql = "delete tb_pd_detail where pdd_sbid = '" + PDid  + "'";
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/*
	 * 
	 * 通过商品号来删除盘点单上的盘点商品
	 */
	public static void deleteShangPin(String SPid,String PDid){
		Connection conn = JDBCTool.getConnection();
//		Vector vo = new Vector();
		String sql = "delete tb_pd_detail where pdd_spid = '" + SPid +  "' and pdd_sbid ='"
			+ PDid + "'";
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				/*int column = rs.getMetaData().getColumnCount();
				 while(rs.next()){
					 Vector tmp = new Vector();
						 for(int i = 1;i <= column;i++){
							 tmp.add(rs.getObject(i));  
					 }
					 vo.add(tmp);
				 }*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	/*
	 * 盘点商品添加窗口初始化
	 */
	public static Vector initDatas(String name){
		Connection conn = JDBCTool.getConnection();
		Vector vo = new Vector();
		String sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc from tb_spinfo sp " +
				"where sp.sp_id not in(select pdsp_spid from tb_pdsp_spinfo) and sp.sp_syck ='"
			+ createid(name) + "'";
		Statement st= null;
		ResultSet rs = null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				int column = rs.getMetaData().getColumnCount();
				 while(rs.next()){
					 Vector tmp = new Vector();
						 for(int i = 1;i <= column;i++){
							 tmp.add(rs.getObject(i));  
					 }
					 vo.add(tmp);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return vo;
	}
	/*
	 * 列出盘点单上的所有商品
	 * select pdd.pdd_spid,sp.sp_name,sp.sp_dw,sp.sp_ggxh,pdd.pdd_num,pdm.pd_ck
 from tb_spinfo sp,tb_pd_detail pdd,tb_pd_main pdm,tb_pdsp_spinfo pdsp
 where pdm.pd_id = pdd.pdd_sbid and pdd.pdd_spid = sp.sp_id and pdsp.pdsp_spid = sp.sp_id and pdsp.pdsp_per = '1';
 	 *ck.ck_name tb_ckinfo ck  ck.ck_id  = sp.sp_syck
	 */
	///////////////有待改进，要把不同单号上的统一商品相加起来
	public static Vector allShangPinChaXun(){
		Vector vo = new Vector();
		String sql = "select distinct pdd.pdd_spid,sp.sp_name,sp.sp_dw,sp.sp_ggxh,pdd.pdd_num,ck.ck_name" +
				" from tb_spinfo sp,tb_pd_detail pdd,tb_pd_main pdm,tb_pdsp_spinfo pdsp, tb_ckinfo ck" +
				" where pdm.pd_id = pdd.pdd_sbid and pdd.pdd_spid = sp.sp_id and ck.ck_id  = pdm.pd_ck and" +
				" pdsp.pdsp_spid = sp.sp_id and pdsp.pdsp_per = '1'";
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
	 * 未盘点的商品
	 * select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc,sp.sp_syck
 from tb_spinfo sp,tb_pd_detail pdd,tb_pd_main pdm
 where sp.sp_id not in(select distinct pdsp.pdsp_spid from tb_pdsp_spinfo pdsp where pdsp.pdsp_per = '1');
	 */
	public static Vector allNotShangPinChaXun(){
		Vector vo = new Vector();
		String sql = "select distinct sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_zdkc,sp.sp_syck" +
				" from tb_spinfo sp where sp.sp_id not in(select distinct pdsp.pdsp_spid" +
				" from tb_pdsp_spinfo pdsp where pdsp.pdsp_per = '1')";
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
	 * 查询盘点数量跟库存数量的比较
	 * select distinct sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,pd.innum,sp.sp_zdkc,
       (pd.innum - sp.sp_zdkc) 差异库存,sp.sp_syck from tb_spinfo sp,tb_pd_detail pdd,tb_pd_main pdm,
       (select inpdd.pdd_spid inid,sum(pdd_num) innum from tb_pd_detail inpdd group by inpdd.pdd_spid) pd 
       where pdm.pd_id = pdd.pdd_sbid and pdd.pdd_spid = sp.sp_id and pd.inid = sp.sp_id
       and sp.sp_id = '5100006';
	 *
	 *ck.ck_name tb_ckinfo ck  ck.ck_id  = sp.sp_syck
	 */
	public static Vector compareShangPinChaXun(String [] obj){
		Vector vo = new Vector();
		String sql = "select distinct sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,pd.innum,sp.sp_zdkc," +
				" (pd.innum - sp.sp_zdkc) 差异库存,ck.ck_name from tb_spinfo sp,tb_pd_detail pdd,tb_pd_main pdm,tb_ckinfo ck, " +
				" (select inpdd.pdd_spid inid,sum(pdd_num) innum from tb_pd_detail inpdd group by inpdd.pdd_spid) pd" +
				" where pdm.pd_id = pdd.pdd_sbid and pdd.pdd_spid = sp.sp_id and pd.inid = sp.sp_id and ck.ck_id  = sp.sp_syck and sp.sp_id = ?";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < obj.length; i ++){
				ps.setString(1, obj[i]);
				rs = ps.executeQuery();
				int column = rs.getMetaData().getColumnCount();
				 while(rs.next()){
					 Vector tmp = new Vector();
						 for(int j = 1;j<=column;j++){
								 tmp.add(rs.getObject(j)); 
						 }
						 vo.add(tmp);
					 }
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
	 * 清零盘点商品
	 * 	public static void clearPanDianShangPin(String[] id){
	 * String sql ="delete tb_pd_detail where pdd_sbid = ? ";
	 */
	public static void clearPanDianShangPin(){
		
//		Vector vo = new Vector();
		String sql ="delete tb_pd_detail ";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
//		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
//			for(int i = 0; i < id.length; i ++){
//				ps.setString(1, id[i]);
//				}
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "清除盘点商品");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		
	}
	
	/*
	 * 清零盘点号
	 * 	public static void clearPanDianDan(String[] id){
	 * String sql = "delete tb_pd_main where pd_id = ?";
	 */
	public static void clearPanDianDan(){
		
//		Vector vo = new Vector();
		String sql = "delete tb_pd_main";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
//		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
//			for(int i = 0; i < id.length; i ++){
//				ps.setString(1, id[i]);
//				rs = ps.executeQuery();
//			}
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "清除盘点单");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		
	}
	
	
	/*
	 * 清零盘点商品标志
	 * 清除所有的盘点商品标志
	 * public static void clearPanDianBiaoZhi(String[] id){
	 * String sql = "delete tb_pdsp_spinfo where pdsp_spid in (select pdd.pdd_spid from tb_pd_detail pdd)";
	 */
	public static void clearPanDianBiaoZhi( ){
		
		Vector vo = new Vector();
		String sql = "delete tb_pdsp_spinfo";
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
//			for(int i = 0; i < id.length; i ++){
//				ps.setString(1, id[i]);
//				rs = ps.executeQuery();
				ps.executeUpdate();
//			}
//				JOptionPane.showMessageDialog(null, "清除盘点商品标志");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		
	}
	
	
	
	/////////////////////辅助查询
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
}
