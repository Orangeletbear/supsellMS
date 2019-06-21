package com.cn.dao.xiaoshou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

public class XPOSJDBCControl {
	
	
	/**
	 * 查出会员的续费信息
	 * @param dateFrom   开始日期
	 * @param dateTo   结束日期
	 * @param hyId   会员号，或名称,或单号
	 * @return
	 */
   public static Vector getHuiYuanXiaoFei(String dateFrom ,String dateTo,String hyId){
		
		Vector data = new Vector();
   	
		String sql = "select pxf.posxfb_id,pxf.posxfb_date,hy.hy_id,hy.hy_name,"+
				 			"pxf.posxfb_yfje,fs.kh_xffs_name,pxf.posxfb_czy,pxf.posxfb_bz"+
				 	    " from tb_posxfb_main pxf ,tb_hyinfo hy,tb_kh_xffs fs"+
				 	    " where fs.kh_xffs_id = pxf.posxfb_fkfs "+
				 	    	" and hy.hy_id = pxf.posxfb_gkjb"+
				 	    	" and (hy.hy_id like '%"+hyId+"%' or hy.hy_name like '%"+hyId+"%' "+
				 	    			"or pxf.posxfb_id like '%"+hyId+"%')"+
         					"and pxf.posxfb_date between to_date(?,'yyyy-mm-dd')  and " +
         					"to_date(?,'yyyy-mm-dd')";
  	 		
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

 //===========================================================================
   /**
	 * 查出会员销售明细
	 * @param xsID  单号
	 * @return
	 */
  public static Vector getHuiYuanXiaoFeiMingXi(String xsId){
		
		Vector data = new Vector();
  	
		String sql = "select sp.sp_id,sp.sp_name,sp.sp_dj,sp.sp_zk,"+
						"pxd.posxfbd_num,(sp.sp_dj*pxd.posxfbd_num) 总金额,"+
						"sp.sp_dw,sp.sp_ggxh,sp.sp_color"+
						" from  tb_posxfb_detail pxd,tb_spinfo sp"+
						" where pxd.posxfbd_spid = sp.sp_id"+
						" and pxd.posxfbd_id = '"+xsId+"'";
 	 		
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
//===========================================================================
  /**
	 * POS 商品销售排行
	 * @param xsID  单号
	 * @return
	 */
  	public static Vector getPOSSPXiaoShouPaiHang(
  			String dateFrom ,String dateTo,String spId){
		
		Vector data = new Vector();
	
		String sql = "select sp.sp_id,sp.sp_name,inb.num,(sp.sp_dj*inb.num) 总金额 "+ 
						" from tb_spinfo sp, "+ 
						"( select pxfd.posxfbd_spid spid, sum(pxfd.posxfbd_num) num "+ 
							" from tb_posxfb_detail pxfd,tb_posxfb_main pxfm "+ 
							" where pxfm.posxfb_id = pxfd.posxfbd_id  "+ 
							" and pxfm.posxfb_date between ? and ? "+ 
							" group by pxfd.posxfbd_spid ) inb "+ 
						" where sp.sp_id = inb.spid "+ 
						" and (sp.sp_id like '%"+spId+"%' or sp.sp_name like '%"+spId+"%')"+ 
						" order by inb.num desc";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  	
  //===========================================================================
  	/**
	 * POS 商品销售排行
	 * @param xsID  单号
	 * @return
	 */
  	public static Vector getPOSSPXiaoShouPaiHangForNum(
  			String dateFrom ,String dateTo,String spId){
		
		Vector data = new Vector();
	
		String sql = "select sp.sp_id,sp.sp_name,inb.num,(sp.sp_dj*inb.num) 总金额,"+
						" ((sp.sp_dj*inb.num)-(sp.sp_jj*inb.num)) ,"+
			           "  Trunc(((((sp.sp_dj*inb.num)-(sp.sp_jj*inb.num))/(sp.sp_dj*inb.num))*100),2)"+
			            " from tb_spinfo sp, "+
			            "( select pxfd.posxfbd_spid spid, sum(pxfd.posxfbd_num) num  "+
						" from tb_posxfb_detail pxfd,tb_posxfb_main pxfm  "+
						" where pxfm.posxfb_id = pxfd.posxfbd_id "+
						" and pxfm.posxfb_date between ? and ? "+
						" group by pxfd.posxfbd_spid ) inb  "+
						" where sp.sp_id = inb.spid  "+
						" and (sp.sp_id like '%"+spId+"%' or sp.sp_name like '%"+spId+"%') "+
						" order by inb.num desc ";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  //===========================================================================
  	/**
	 * POS 业务员销售排行
	 * @param ywId  业务员ID或姓名
	 * @return
	 */
  	public static Vector getPOSYeWuYuanXiaoShouPaiHang(
  			String dateFrom ,String dateTo,String ywId){
		
		Vector data = new Vector();
	
		String sql = "select  usert.user_id,usert.user_name,inb.num,inb.zje,"+
			            " inb.liren, Trunc(inb.liren/inb.zje,2) 毛利率"+
			             " from tb_usernofo usert,"+
						" (select pxfm.posxfb_czy czy,sum(pxfm.posxfb_sfje) zje,"+
						" sum(inb.num) num,sum(inb.liren) liren"+
						" from tb_posxfb_main pxfm,"+
						"(select inb.id id,sum(inb.num) num,sum(inb.liren) liren"+
						  " from"+
						  "( select pxfd.posxfbd_id id ,pxfd.posxfbd_num num,"+
						"((sp.sp_dj*pxfd.posxfbd_num)-(sp.sp_jj*pxfd.posxfbd_num)) liren"+
						" from tb_posxfb_detail pxfd ,tb_spinfo sp"+
						" where pxfd.posxfbd_spid = sp.sp_id) inb"+
						" group by inb.id) inb   "+
						" where pxfm.posxfb_id = inb.id"+
						" and pxfm.posxfb_date between ? and ? "+
						" group by pxfm.posxfb_czy) inb"+
						" where usert.user_id = inb.czy"+
						" and (usert.user_name like '%"+ywId+"%' or usert.user_id like '%"+ywId+"%')"+
						" order by inb.zje";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
	 * POS 商品类别销售排行
	 * @param lbId  商品类别
	 * @return
	 */
  	public static Vector getPOSSPLeiBieXiaoShouPaiHang(
  			String dateFrom ,String dateTo,String lbId){
		
		Vector data = new Vector();
	
		String sql = "select lb.sblb_id,lb.sblb_name,inb.num,inb.zje,"+
						"inb.liren,Trunc(inb.liren/inb.zje,2)"+
						" from tb_sblb lb,"+
						"(select inb.lb,sum(inb.num) num,sum(inb.zje) zje,sum(inb.liren) liren"+
						" from "+
						"( select sp.sp_lb lb,inb.num num,(sp.sp_dj*inb.num) zje,"+
						"((sp.sp_dj*inb.num)-(sp.sp_jj*inb.num)) liren "+
						" from tb_spinfo sp, "+
						"( select pxfd.posxfbd_spid spid, sum(pxfd.posxfbd_num) num  "+
						" from tb_posxfb_detail pxfd,tb_posxfb_main pxfm "+ 
						" where pxfm.posxfb_id = pxfd.posxfbd_id "+
						" and pxfm.posxfb_date between ? and ? "+
						" group by pxfd.posxfbd_spid ) inb  "+
						" where sp.sp_id = inb.spid ) inb"+
						" group by inb.lb ) inb"+
						" where lb.sblb_id = inb.lb "+
						" and (lb.sblb_id like '%"+lbId+"%' or lb.sblb_name like '%"+lbId+"%')";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  //===========================================================================
  	/*
     *获取商品所有类别 
     *返回字符串数组，存所有类别
     */
	public static String []  getAllPOSChaoZhuoYuanData() {
		Vector tmp = new Vector();
    	String [] data= null;
    	String sql = "select tb.user_Name from tb_usernofo tb" +
    			" where tb.user_isPos = '1'";
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
                 tmp.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，数据初始化失败!");
			return new String[]{};
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	data = new String[tmp.size()];
		for(int i = 0;i<tmp.size();i++){
			data[i] = tmp.get(i).toString();
		}
    	return data;
	}
   //=========================================================================== 
	/**
	 * POS 销售流水账 主表查询
	 * @param   syID业务员ID或姓名
	 * @param   jbID
	 * @return
	 */
  	public static Vector getPOSSPDanJuLiuShui(
  			String dateFrom ,String dateTo,String syId,String jbID){
		
		Vector data = new Vector();
	
		String sql = "select xs.posxfb_date,xs.posxfb_id,xs.posxfb_yfje,fs.kh_xffs_name,"+
						"(xs.posxfb_yfje-xs.posxfb_sfje),sy.user_name,jb.yg_name"+
						" from  tb_posxfb_main xs,tb_usernofo sy,tb_yginfo jb,tb_kh_xffs fs"+
						" where sy.user_id = xs.posxfb_czy "+
						" and jb.yg_id = xs.posxfb_jbr and xs.posxfb_fkfs = fs.kh_xffs_id"+
						" and ( sy.user_name like '%"+syId+"%' or jb.yg_name like '%"+jbID+"%')"+
						" and  xs.posxfb_date between ? and ?";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
	 * POS 销售流水账 主表查询
	 * @param   syID单据号或会员
	 * @return
	 */
  	public static Vector getPOSSPMingXiLiuShui(
  			String dateFrom ,String dateTo,String syId){
		
		Vector data = new Vector();
	
		String sql = "select xs.posxfb_date,xs.posxfb_id,hy.hy_id,hy.hy_name,"+
					"sp.sp_id,sp.sp_name,sp.sp_dj,sp.sp_zk,xsm.posxfbd_num,"+
					"(sp.sp_dj*xsm.posxfbd_num),sp.sp_dw,sp.sp_ggxh,sp.sp_color,"+
					"sp.sp_bz"+
					" from  tb_posxfb_main xs,tb_spinfo sp,tb_hyinfo hy,tb_posxfb_detail xsm"+
					" where xs.posxfb_id = xsm.posxfbd_id"+
					" and xsm.posxfbd_spid = sp.sp_id"+
					" and xs.posxfb_gkjb = hy.hy_id"+
					" and (hy.hy_id like '%"+syId+"%' or hy.hy_name like '%"+syId+"%'" +
							" or xs.posxfb_id like '%"+syId+"%')" +
					" and  xs.posxfb_date between ? and ? ";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  //===========================================================================
  	
  	/**
	 * POS 收银员收费查询
	 * @param   syID  收银员名
	 * @return
	 */
  	public static Vector getPOSShouYingYuanShouFei(
  			String dateFrom ,String dateTo,String syId){
		
		Vector data = new Vector();
	
		String sql = "select sy.user_id,sy.user_name,inb.yssum,inb.sssum"+
						" from tb_usernofo sy,"+
						"(select xs.posxfb_czy czy,sum(xs.posxfb_yfje) yssum, "+
						" sum(xs.posxfb_sfje) sssum"+
						" from tb_posxfb_main xs"+
						" where  xs.posxfb_date between ? and ?"+
								" group by xs.posxfb_czy) inb"+
								" where sy.user_id = inb.czy"+
								" and sy.user_name like '%"+syId+"%' ";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
	 * POS 收银员收费明细查询
	 * @param   syID  收银员ID
	 * @return
	 */
  	public static Vector getPOSShouYingYuanShouFeiMingXi(String syId){
		
		Vector data = new Vector();
	
		String sql = " select xs.posxfb_id,xs.posxfb_date,"+
						"xs.posxfb_yfje,xs.posxfb_sfje"+
						" from tb_posxfb_main xs"+
						" where xs.posxfb_czy ='"+syId+"'";
	 		
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
  	
  	//=====================================================
  	/**
	 * POS 日结管理
	 * @param   syID  收银员名或日结单号
	 * @return
	 */
  	public static Vector getPOSRiJieGuangLi(
  			String dateFrom ,String dateTo,String syId){
		
		Vector data = new Vector();
	
		String sql = "select rj.dayc_id,rj.dayc_date,rj.dayc_num,"+
							"rj.dayc_zje,sy.user_name"+
						" from tb_dayCount rj,tb_usernofo sy"+
						" where  rj.dayc_czy = sy.user_id"+
						" and (rj.dayc_id like '%"+syId+"%' or sy.user_name like '%"+syId+"%')"+  
						" and rj.dayc_date between ? and ? ";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  	
  	//===============================================
  	/**
	 * POS 出入款查询
	 * @param  syName  收银员名或日结单号
	 * @return
	 */
  	public static Vector getPOSOutAndInPay(
  			String dateFrom ,String dateTo,String syName){
		
		Vector data = new Vector();
	
		String sql = "";
	 		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs = null;
		try {
				ps = conn.prepareStatement(sql);
				
				ps.setTimestamp(1, 
				    DateConventer.strToTimestamp(dateFrom, "yyyy-MM-dd"));
				ps.setTimestamp(2, 
					DateConventer.strToTimestamp(dateTo, "yyyy-MM-dd"));
				
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
  	
}
  	

