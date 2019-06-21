package com.cn.dao.pos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/**
 * 获取一些基本信息
 * @author Administrator
 *
 */
public class JDBC_POS_GetInfo {

	/**
	 * 根据收银员/操作员名称获取收银员/操作员编号
	 * @param syyName
	 * @return
	 */
	public static Object getId(String syyName){
		Object syyId = null;
		String sql = null;
		sql = "select user_id from tb_usernofo where user_Name = '"+syyName+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				syyId = rs.getObject(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return syyId;
	}
	/**
	 * 获取会员名字
	 * @param hyId
	 * @return
	 */
	public static Object getName(String hyId){
		Object syyId = null;
		String sql = null;
		sql = "select hy_Name from tb_hyinfo where hy_id = '"+hyId+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				syyId = rs.getObject(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return syyId;
	}
	/**
	 * 获取某日的所有POS销售单据Id
	 * @param date
	 * @return
	 */
	public static ArrayList get_pos_xs_id(String date){
		ArrayList data = new ArrayList();
		String sql = null;
		sql = "select posxfb_Id from tb_posxfb_main " +
				" where posxfb_date = to_date('"+date+"','yyyy-mm-dd')";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	/**
	 * 获取所有POS销售单据Id
	 * @param date
	 * @return
	 */
	public static ArrayList get_pos_xs_id(){
		ArrayList<String> data = new ArrayList<String>();
		String sql = null;
		sql = "select posxfb_Id from tb_posxfb_main " ;
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i).toString());
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 获取某日的所有POS销售退货单据Id
	 * @param date
	 * @return
	 */
	public static ArrayList get_pos_xsth_id(String date){
		ArrayList data = new ArrayList();
		String sql = null;
		sql = "select posth_Id from tb_posth_main " +
				" where posth_date = to_date('"+date+"','yyyy-mm-dd')";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 根据导购员名称获取导购员编号
	 * @param syyName
	 * @return
	 */
	public static Object getdgId(String dgName){
		Object dgId = null;
		String sql = null;
		sql = "select yg_id from tb_yginfo where yg_Name = '"+dgName+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				dgId = rs.getObject(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return dgId;
	}
	
	/**
	 * 根据消费方式名称获取消费方式Id
	 * @param syyName
	 * @return
	 */
	public static Object getfsId(String fsName){
		Object fsId = null;
		String sql = null;
		sql = "select kh_xffs_Id from tb_kh_xffs where kh_xffs_Name = '"+fsName+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				fsId = rs.getObject(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return fsId;
	}
	/**
	 * 根据会员员名称获取会员编号
	 * @param hyName
	 * @return
	 */
	public static Object getczyId(String hyName){
		Object dgId = null;
		String sql = null;
		sql = "select hy_Id from tb_hyinfo where hy_Name = '"+hyName+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				dgId = rs.getObject(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return dgId;
	}
	/**
	 * 获取会员编号、姓名、级别信息
	 * @param hyName
	 * @return
	 */
	public static Vector gethyInfo(){
		Vector data = new Vector();
		String sql = null;
		sql = "select hy_Id ,hy_Name, hy_Level from tb_hyinfo ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				Vector temp = new Vector();
				for(int i = 1; i<= columns;i++){
					temp.add(rs.getObject(i));
				}
				data.add(temp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 获取给定POS销售单号的销售日期和会员编号
	 * @param hyName
	 * @return
	 */
	public static Vector getxs_Info(String danHao){
		Vector data = new Vector();
		String sql = null;
		sql = "select posxfb_date ,posxfb_gkjb" +
				"  from tb_posxfb_main where posxfb_Id ='"+danHao+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()) {
			
				for(int i = 1; i<= columns;i++){
				data.add(rs.getObject(i));
				}
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	/**
	 * 获取给定POS销售单号从POS销售详表
	 * 中查询出该单号所销售的商品编号
	 * @param hyName
	 * @return
	 */
	public static ArrayList get_pos_sp_id(String danHao){
		ArrayList<String> data = new ArrayList<String>();
		String sql = null;
		sql = "select posxfbd_spId from tb_posxfb_detail " +
				"where posxfbd_Id ='"+danHao+"'" ;
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i).toString());
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 获取给定商品编号的一些信息
	 * @param hyName
	 * @return
	 */
	public static Vector get_pos_sp_info(int i,String spid){
		Vector data = new Vector();
		data.add(i);
		data.add(spid);
		String sql1 = null;
		String sql2 = null;
		sql1 = "select sp_Name,sp_dw,sp_dj,sp_dzl from tb_spinfo " +
				" where sp_Id ='"+spid+"'" ;
		sql2 = "select  posxfbd_num,posxfbd_num,posxfbd_zje " +
				"  from tb_posxfb_detail" +
				" where posxfbd_spId ='"+spid+"'";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql1);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int j = 1;j<=columns;j++){
					data.add(rs.getObject(j).toString());
				}
			}
			rs = st.executeQuery(sql2);
			 columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int j = 1;j<=3;j++){
					data.add(rs.getObject(j).toString());
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	

	/**
	 * 获取某pos销售单据的一些信息
	 * @param date
	 * @return
	 */
	public static ArrayList get_pos_xs_info(String danHao){
		ArrayList data = new ArrayList();
		String sql = null;
		sql = "select  posxfb_dgyId, posxfb_ckId, posxfb_jbr,posxfb_bz from tb_posxfb_main " +
				" where posxfb_Id = '"+danHao+"'";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
     /**
      * 根据会员编号查询该会员的一些消费信息
      * @param hyId
      * @return
      */
	public static Vector get_hy_xfInfo(String hyId){
		Vector data = new Vector();
		
		String sql = null;
		sql = "select hyxf_xhye, hyxf_zxf,hyxf_xfcs " +
				" from tb_hyxfb where hyxf_Id ='"+hyId+"'";
	
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i<=columns;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败！");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
}
