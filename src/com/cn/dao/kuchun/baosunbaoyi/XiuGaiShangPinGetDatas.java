package com.cn.dao.kuchun.baosunbaoyi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 商品选择之后的修改 ,通过获取商品名称进行数据交互
 * @author Administrator
 *
 */
public class XiuGaiShangPinGetDatas {
	
	/*
	 * 报损商品的修改
	 */
	public static Vector baoSunXiugai(String name,String num){
		Vector vo = new Vector();
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		String sql = "select sp.sp_name,sp.sp_dw,sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,sp.sp_bz " +
				"from tb_spinfo sp  where sp.sp_name ='" + name + "'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			int column1 = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				Vector tmp = new Vector();
				for(int i = 1; i <= column1; i ++  ){
					if(i == 5){
						tmp.add(compareNum(name,num));
					}else {
						tmp.add(rs.getObject(i));
					}
				}
				vo.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return vo;
	}
	
	/*
	 * 此方法用来判断传输进来的调拨数量与库存之间的大小关系
	 * 
	 */
	public static int compareNum(String name,String num){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		String sql = "select sp.sp_zdkc from tb_spinfo sp where sp.sp_name = '" +
		name + "'";
		int count = Integer.valueOf(num);
		int i = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				i = rs.getInt("sp_zdkc");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		if(count > i){
			JOptionPane.showMessageDialog(null, "你输入的调拨数量太大,请重新输入！");
		}
		//更新数据库
//		updata(id,num);
		
		return count > i ? i :count;
	}
}
