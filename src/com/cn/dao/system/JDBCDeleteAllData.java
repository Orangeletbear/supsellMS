package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * @author Administrator
 *
 */
public class JDBCDeleteAllData {

	
	public static void delete_cgd_Data(String year){
		String sql[] = new String[14];
		//删除某年的采购详表中的数据
		sql[0] = "delete from tb_cg_detail" +
				" where cgd_spdh in  ( select cg_id" +
				   "  from tb_cg_main" +
				   " where Extract(Year From cg_date )= '"+year+"') ";
		
		//删除某年的采购主表中的数据
		sql[1] = "delete from tb_cg_main" +
				" where Extract(Year From cg_date )= '"+year+"' ";
		
		//删除某年的采购退货详表中的数据
		sql[2] = "delete from tb_th_detail" +
				" where thd_spdh in  ( select th_id" +
				" from tb_th_main" +
				  " where Extract(Year From th_date )= '"+year+"') ";
		
         //删除某年的采购退货总表中的数据
		
		sql[3] = " delete from tb_th_main" +
				" where Extract(Year From th_date )= '"+year+"'   ";
		
		//删除某年的销售详表中的数据
		sql[4] = "delete from tb_sell_detail" +
		              " where xsd_dh in (select xs_id from " +
                      " tb_sell_main " +
                       " where Extract(Year from xs_xsdate) ='"+year+"')  ";
		
		//删除某年的销售主表中的数据
		sql[5] =  " delete from tb_sell_main" +
		            " where Extract(Year from xs_xsdate)='"+year+"'";
		
		//删除某年的客户退货详表中的数据
		sql[6] = "delete from tb_khth_detail" +
				" where khthd_dh in (select kh_th_Id " +
				"  from tb_khth_main where Extract(Year from kh_th_date )='"+year+"')";
         //	删除某年的客户退货总表中的数据
		
		sql[7] = "delete from tb_khth_main" +
				" where Extract(Year from kh_th_date)='"+year+"' ";
		//删除某年的库存调拨详表中的数据
		
		sql[8] = "delete from tb_kctb_detail" +
				" where kctbd_tbdh in(select kctb_Id from " +
				" tb_kctb_main where Extract(Year From kctb_tbdate)= '"+year+"') ";
		
		//删除某年的库存调拨总表中的数据
		sql[9] = "delete from tb_kctb_main" +
				"  where Extract(Year From kctb_tbdate) = '"+year+"'  ";
		
		//删除某年的报损详表中的信息
		sql[10] = " delete from tb_bs_detail" +
				"  where bsd_xbId in(select bs_id " +
				   " from tb_bs_main where Extract(Year from bs_date) = '"+year+"')";
		//删除某年的报损总表中的数据
		sql[11] = " delete from tb_bs_main" +
				" where  Extract(Year from bs_date) = '"+year+"'";
		
		//删除某年的报溢详表中的数据
		sql[12] = "delete from tb_by_detail  " +
				" where byd_cdId in (select by_id " +
				" from tb_by_main where Extract(Year from by_date) = '"+year+"')";
		// --删除某年的报溢总表中的数据
		sql[13] = " delete from tb_by_main" +
				"  where Extract(Year from by_date) = '"+year+"'";
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps =  null;
		
			try {
	     
			for(int i = 0;i < sql.length;i++){
				ps = conn.prepareStatement(sql[i]);		
				ps.execute();
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
	}
	
	//向数据库中插入年终结算信息
	public static void insertData(Vector data){	
		
		String sql = null;
		
		sql = "insert into tb_nzjs  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.get(0).toString());
			
			Timestamp time = DateConventer.strToTimestamp(
					         data.get(1).toString(),"yyyy-MM-dd");
			ps.setTimestamp(2, time);
			
			ps.setString(3, data.get(2).toString());
			ps.setString(4, data.get(3).toString());
			ps.setString(5, data.get(4).toString());
			ps.setString(6, data.get(5).toString());
			ps.setString(7, data.get(6).toString());
			ps.setString(8, data.get(7).toString());
			ps.setString(9, data.get(8).toString());
			ps.setString(10, data.get(9).toString());
			ps.setString(11, data.get(10).toString());
			ps.setString(12, data.get(11).toString());
			ps.setString(13, data.get(12).toString());
			ps.setString(14, data.get(13).toString());
			ps.setString(15, data.get(14).toString());
			ps.setString(16, data.get(15).toString());
			ps.setString(17, data.get(16).toString());
			ps.setString(18, data.get(17).toString());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResouse(ps, conn);
		}
		
	}
     //	从数据库中获取所有的年终结算信息
	public static Vector  getData(){	
		
		Vector data = new Vector();
		String sql = null;
		
		sql = "select * from tb_nzjs";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				Vector temp = new Vector();
				for(int i = 1;i <= columns ;i++){
					temp.add(rs.getObject(i));
				}
				data.add(temp);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败");
			e.printStackTrace();
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
	   //	从数据库中获取某年的年终结算信息
	 public static Vector  getData(String year){	
		
		Vector data = new Vector();
		String sql = null;
		
		sql = "select * from tb_nzjs where  nz_year = '"+year+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				int column = rs.getMetaData().getColumnCount();
				for(int i = 1;i<= column;i++){
					data.add(rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库操作失败");
			return data;
		}finally {
			JDBCTool.freeResorse(rs, st, conn);
		}
		return data;
	}
}
