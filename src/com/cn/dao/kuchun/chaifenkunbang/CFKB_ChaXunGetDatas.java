package com.cn.dao.kuchun.chaifenkunbang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

public class CFKB_ChaXunGetDatas {
	
	/*
	 * �ܵ���ѯ
	 */
	public static Vector chaxunZongDan(String spid,String dateFrom,String dateTo,String lx){
		Vector vo = new Vector();
		String sql = null;
		
		String sql1 = "and cfm.cf_bcfspid like '%"+ spid+ "%'";
		String sql2 = "and kbm.kb_cspid like '%"+ spid+ "%'";
		
		if(lx.equals("��Ʒ���")){
			sql = "select cfm.cf_id,cfm.cf_date,ckN.ckname,cfm.cf_bcfspid,sp.sp_name," +
					" sp.sp_dj,cfm.cf_cfnum,(cfm.cf_cfnum*sp.sp_dj) cfzje,cfm.cf_jbr,cfm.cf_czy,cfm.cf_bz" +
					" from tb_spinfo sp,tb_cf_main cfm,(select ck.ck_id ckid,ck.ck_name ckname from tb_ckinfo ck) ckN" +
					" where cfm.cf_bcfspid = sp.sp_id  and ckN.Ckid = cfm.cf_lk" +
					" and cfm.cf_date between ? and ? ";
			if(spid.length() > 0){
				sql = sql + sql1;
			}
		}
		
		if(lx.equals("��Ʒ����")){
			sql = "select kbm.kb_id,kbm.kb_date,ckN.Ckname,kbm.kb_cspid,sp.sp_name," +
					"sp.sp_dj,kbm.kb_num,(kbm.kb_num*sp.sp_dj) zje,kbm.kb_jbr,kbm.kb_czy,kbm.kb_bz" +
					" from tb_spinfo sp,tb_kb_main kbm,(select ck.ck_id ckid,ck.ck_name ckname from tb_ckinfo ck) ckN " +
					"where kbm.kb_cspid = sp.sp_id and kbm.kb_ck = ckN.Ckid " +
					"and kbm.kb_date between ? and ? ";
			if(spid.length() > 0){
				sql = sql + sql2;
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
				 
				 for(int i = 1; i<= column; i ++){
					 //�������ַ���ת��Ϊ���ڸ�ʽ
					 if(i == 2){
						 tmp.add(DateConventer.strToTimestamp(rs.getString(i),"yyyy-MM-dd"));
					 }else{
						 tmp.add(rs.getObject(i)); 
					 }
				 }
				 vo.add(tmp);
			 }
//			 JOptionPane.showMessageDialog(null, "�ܵ���ѯ�ɹ�!!!!!!!");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}
	
	/*
	 * ��ϸ��Ʒ��ѯ
	 * 
	 */
	public static Vector shangPinChaXun(String id,String lx){
		Vector vo = new Vector();
		String sql = null;
		if(lx.equals("��Ʒ���")){
			sql = "select cfd.cfd_spid,sp.sp_name,sp.sp_dj,cfd.cfd_num,cfd.cfd_zje,sp.sp_dw,sp.sp_ggxh,sp.sp_color" +
					" from tb_spinfo sp,tb_cf_detail cfd,tb_cf_main cfm where cfd.cfd_spid = sp.sp_id and" +
					" cfm.cf_id = cfd.cfd_xbid and cfd.cfd_xbid = '"+ id +"'";
		}
		if(lx.equals("��Ʒ����")){
			sql = "select kbd.kbd_spid,sp.sp_name,sp.sp_dj,kbd.kbd_num,kbd.kbd_zje,sp.sp_dw,sp.sp_ggxh,sp.sp_color" +
					" from  tb_spinfo sp,tb_kb_detail kbd,tb_kb_main kbm where kbd.kbd_spid = sp.sp_id and" +
					" kbd.kbd_cdid = kbm.kb_id and kbd.kbd_cdid = '"+ id +"'";
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
					 tmp.add(rs.getObject(i));
				 }
				 vo.add(tmp);
			 }
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "��Ʒ��ѯ�ɹ�!!!!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}
	
	/*
	 *  �߼���ѯ
	 *  where kbm.kb_cspid = sp.sp_id and kbm.kb_ck = ckN.Ckid 
       and kbm.kb_ck = '001' and kbm.kb_jbr = 'С��'
	 */
	public static Vector gaojiChaXun(String ckName,String jbr,String lx){
		Vector vo = new Vector();
		String sql = null;
		
		String sql1 =  " and cfm.cf_lk = '" + getCKId(ckName) + "'" ;
		String sql2 = " and cfm.cf_jbr = '" + jbr + "'";
		
		
		String sql4 =" and kbm.kb_ck = '" + getCKId(ckName) + "'";
		String sql5 = " and kbm.kb_jbr = '" + jbr + "'";
		
		if(lx.equals("��Ʒ���")){
			sql =  "select cfm.cf_id,cfm.cf_date,ckN.ckname,cfm.cf_bcfspid,sp.sp_name," +
				" sp.sp_dj,cfm.cf_cfnum,(cfm.cf_cfnum*sp.sp_dj) cfzje,cfm.cf_jbr,cfm.cf_czy,cfm.cf_bz" +
				" from tb_spinfo sp,tb_cf_main cfm,(select ck.ck_id ckid,ck.ck_name ckname from tb_ckinfo ck) ckN" +
		        " where cfm.cf_bcfspid = sp.sp_id  and ckN.Ckid = cfm.cf_lk";
		}
		
		if(lx.equals("��Ʒ����")){
			sql =  "select kbm.kb_id,kbm.kb_date,ckN.Ckname,kbm.kb_cspid,sp.sp_name," +
			"sp.sp_dj,kbm.kb_num,(kbm.kb_num*sp.sp_dj) zje,kbm.kb_jbr,kbm.kb_czy,kbm.kb_bz" +
			" from tb_spinfo sp,tb_kb_main kbm,(select ck.ck_id ckid,ck.ck_name ckname from tb_ckinfo ck) ckN " +
			"where kbm.kb_cspid = sp.sp_id and kbm.kb_ck = ckN.Ckid ";
		}
		
		if(lx.equals("��Ʒ���")){
			if(ckName.equals("���вֿ�")){
				if(jbr.equals("���о�����")){
					sql = sql + "";
				} else {
					sql = sql + sql2;
				}
			}else {
				if(jbr.equals("���о�����")){
					sql = sql + sql1;
				}else {
					sql = sql + sql1 + sql2;
				}
			}
		}
		
		if(lx.equals("��Ʒ����")){
			if(ckName.equals("���вֿ�")){
				if(jbr.equals("���о�����")){
					sql = sql + "";
				} else {
					sql = sql + sql5;
				}
			}else {
				if(jbr.equals("���о�����")){
					sql = sql + sql4;
				}else {
					sql = sql + sql4 + sql5;
				}
			}
		}
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//====================
		System.out.println(sql);
		
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
//			JOptionPane.showMessageDialog(null, "��Ʒ��ѯ�ɹ�!!!!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResouse(ps,conn);
		}
		return vo;
	}  
	
	/*
	 * ��ȡ�ֿ�id
	 */
	private static String getCKId(String name){
		String id= null;
		String sql = "select ck.ck_id from tb_ckinfo ck where ck.ck_name = '" + name + "'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getString("ck_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return id;
	}
	
}
