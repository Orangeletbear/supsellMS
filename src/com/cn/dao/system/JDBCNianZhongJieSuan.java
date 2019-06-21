package com.cn.dao.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 查询年终结算所需的信息
 * @author Administrator
 *
 */
public class JDBCNianZhongJieSuan {

	/**
	 * 查询采购信息(包括采购单数、采购退货单数、总计采购数量、总计采购金额)
	 * @return
	 */
	public static ArrayList getCaiGouData(String year){
		ArrayList data = new ArrayList();
		String sql = null;
		sql = "select zcg_id ,zth_id,zcgd_num,zcgd_szje "+
                " from (select count(cg_Id)zcg_id from tb_cg_main "+
                        " where Extract(Year From cg_date )= '"+year+"')" +
                     " ,(select count(th_Id) zth_id from tb_th_main " +
                         " where Extract(Year From th_date )= '"+year+"')"+     
                     " ,(select sum(cgd_num) zcgd_num,sum(cgd_spzje) zcgd_szje "+
                         "  from (select cgd_num ,cgd_spzje "+
                                    " from tb_cg_detail "+
                                  "   where cgd_spdh in ( select cg_id "+
                                             "from tb_cg_main "+
                                            "   where Extract(Year From cg_date )= '"+year+"')) ) ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取列数
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i <= columns ;i++){
					data.add( rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库操作失败");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	/**
	 * 查询某年的销售信息(包括销售单数、销售退货单数、总计销售数量、总计销售金额)
	 * @return
	 */
	public static ArrayList getXiaoShouData(String year){
	ArrayList data = new ArrayList();
		String sql = null;
		sql = "select zxs_id ,zth_id,zxsd_num,zxsd_szje" +
				  " from (select count(xs_Id)zxs_id from tb_sell_main" +
				           " where Extract(Year From xs_xsdate )= '"+year+"'),(select " +
				                   " count(kh_th_Id)zth_id from tb_khth_main " +
				                   " where Extract(Year From kh_th_date )= '"+year+"'),(select " +
				                     "sum(xsd_num) zxsd_num,sum(xsd_szje) zxsd_szje" +
				                       " from (select xsd_num ,xsd_szje from tb_sell_detail" +
				                       " where xsd_dh in (select xs_id" +
				                         " from tb_sell_main" +
				                         "  where Extract(Year From xs_xsdate )= '"+year+"')) )   ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取列数
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i <= columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库操作失败");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	/**
	 * 查询某年的调拨信息（包括调拨单数和调拨数量）
	 * @return
	 */
	public static ArrayList getDiaoBoData(String year){
	ArrayList data = new ArrayList();
		
		String sql = null;
		sql = "select zkctb_id,kctbd_num" +
				" from (select count(kctb_Id) zkctb_id " +
				   " from tb_kctb_main where  Extract(Year From kctb_tbdate )= '"+year+"'),  " +
				   " (select sum(kctbd_num) kctbd_num " +
				   "  from (select kctbd_num from tb_kctb_detail " +
				        "  where kctbd_tbdh in(select kctb_id " +
				              " from tb_kctb_main where " +
				              " Extract(Year From kctb_tbdate )= '"+year+"'))) ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取列数
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i <= columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库操作失败");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
	
	/**
	 * 查询报损信息(包括报损单数、报损数量、报损金额)
	 * @return
	 */
	public static ArrayList getBaoSunData(String year){
	ArrayList data = new ArrayList();
		String sql = null;
		sql = "select zbs_id ,zbsd_num,zbsd_szje" +
			" from (select count(bs_Id)zbs_id  " +
			          " from tb_bs_main " +
			          " where Extract(Year From bs_date )= '"+year+"') bs,"+
                    "(select sum(bsd_num) zbsd_num,sum(bsd_zje) zbsd_szje "+
                      "  from (select bsd_num ,bsd_zje "+
                              " from tb_bs_detail"+
                              " where bsd_xbid in (select bs_id "+
                                   " from tb_bs_main "+
                                    "  where Extract(Year From bs_date )= '"+year+"')) )  ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取列数
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i <= columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库操作失败");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
	
	
	/**
	 * 查询某年的报溢信息(包括报溢单数、报溢数量、报溢金额)
	 * @return
	 */
	public static ArrayList getBaoYiData(String year){
	ArrayList data = new ArrayList();
		
		String sql = null;
		sql = "select zby_id ,zbyd_num,zbyd_szje" +
				" from (select count(by_Id) zby_id from tb_by_main " +
				" where Extract(Year From by_date )= '"+year+"') bs," +
				" (select sum(byd_num) zbyd_num,sum(byd_zje) zbyd_szje " +
				" from (select byd_num ,byd_zje " +
				"  from tb_by_detail" +
				"  where byd_cdId in (select by_id" +
				" from tb_by_main " +
				" where Extract(Year From by_date )= '"+year+"')) )   ";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取列数
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i = 1;i <= columns ;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库操作失败");
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	
}
