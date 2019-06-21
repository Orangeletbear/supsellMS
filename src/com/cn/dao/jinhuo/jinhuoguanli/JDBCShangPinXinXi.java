package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 双击表格数据行，弹出商品信息dialog，与JDBC交互获取数据初始化dialog界面
 * @author Administrator
 *
 */
public class JDBCShangPinXinXi {
	
	
	
	
	/**
	 * 获取某一行数据的spID，更新JLabel中数据
	 */
	public static Vector getData(String spID){
		Vector<Object> data = new Vector<Object>();
		
		//查询 该spID，要获取的数据有：商品编号，商品名称，规格型号，基本单位，生产厂商，颜色，当前库存，备注
		//                           参考进价
		
		String sql = "select tb.sp_id,tb.sp_name,tb.sp_ggxh,tb.sp_dw,tb.sp_sccs,tb.sp_color,tb.sp_zdkc,tb.sp_bz,"+
	       " tb.sp_jj"+
	       " from tb_spinfo tb"+
	       " where tb.sp_id ='"+spID+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			int lieshu = rs.getMetaData().getColumnCount();//统计列数
			
			while(rs.next()){
				for(int i = 1; i <= lieshu ; i ++){
					data.add( rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
	

	
	/**
	 * 获取某一行数据的spID，更新商品信息dialog中table中数据
	 */
	public static Vector getRowData(String spID){
		Vector data = new Vector();
		
		//		供货日期，单据号，单位，采购单价，数量，总金额
		
		String sql = "select tm.cg_date,tm.cg_id,tb.sp_dw,tb.sp_jj,td.cgd_num,td.cgd_spzje "+
		  " from tb_cg_detail td,tb_cg_main tm,tb_spinfo tb "+
		  " where td.cgd_spid ='"+spID+"'"+
		  " and td.cgd_spdh = tm.cg_id"+
		  " and tb.sp_id = td.cgd_spid";
		
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//建立连接
		
		try {
			st = conn.createStatement();//创建statement对象
			rs= st.executeQuery(sql);//调用executeUpdate/Query方法发送SQL语句
			
			int lieshu = rs.getMetaData().getColumnCount();//统计列数
			
			while(rs.next()){
				Vector<Object> tmp = new Vector<Object>();//存储每行数据 
				
				for(int i = 1; i <= lieshu ; i ++){
					tmp.add( rs.getObject(i));
				}
				data.add(tmp);/////每行数据作为data的一个元素
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}

}
