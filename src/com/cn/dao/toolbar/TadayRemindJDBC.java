package com.cn.dao.toolbar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/*
 * 工具栏上的今日提醒窗口中的数据控制层
 */
public class TadayRemindJDBC {
  /*
   * 获取存报警数据
   * spName 用于查看该商品是否报警
   * 查出的结果为库存小于一定数量的数据信息
   */
	public static Vector getCuCunBJData(String spName){
		//二维数据
    	Vector data = new Vector();
    	
    	String sql ="select  tb.sp_id,tb.sp_name,tb.sp_ggxh,tb.sp_dw,"+
    						"tb.sp_color,tb.sp_zdkc"+
    					" from tb_spinfo tb "+
    					" where tb.sp_zdkc <= 0"+
    					" and (tb.sp_id like '%"+spName+"%' or tb.sp_name like '%"+spName+"%')";
    	
    	//是否查 出库存为零的商品
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			   st = conn.createStatement();
			   rs = st.executeQuery(sql);
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
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	return data;
		
    }
    
    
	/**
	 * 应收款提醒数据查询
	 * @param khName 客户名
	 * @return  满足要求的数据
	 * conD 查询条件
	 * dayNum 天数
	 */
	public static Vector getYingShouKTXData(String khName,
			                  String conD,String dayNum){  
		//二维数据
    	Vector data = new Vector();
    	
    	String sql =" select * from ("+
    			"select kh.kh_name na,tb.xs_id id,tb.xs_xsdate,tb.xs_ysje,"+
    			"tb.xs_ssje,(tb.xs_ysje-tb.xs_ssje) mon,"+
    			"(tb.xs_xsdate+100) 止日,ceil(sysdate-tb.xs_xsdate) daNum,"+
    			" tb.xs_jbr from  tb_sell_main tb ,tb_khinfo kh "+
    			" where kh.kh_id = tb.xs_khid ) intb"+
    			" where(intb.id like '%"+khName+"%' or intb.na like '%"+khName+"%')";
    	
    	if(">=".equals(conD)){
    		 sql = sql+" and intb.daNum >= "+dayNum+" and intb.mon > 0";
    	}
    	if("<=".equals(conD)){
    		sql = sql+ " and intb.daNum <= "+dayNum+" and intb.mon > 0";
    	}
        if("=".equals(conD)){
        	sql = sql+" and intb.daNum = "+dayNum+" and intb.mon > 0";
    	}
    	
    	
    	//是否查 出库存为零的商品
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			   st = conn.createStatement();
			   rs = st.executeQuery(sql);
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
			JDBCTool.freeResorse(rs, st, conn);
		}
    	return data;
	}
	/*
	 * 商品过期提醒
	 * spName 商品名或编号
	 * conD 查询条件
	 * dayNum 天数
	 */
    public static Vector getPassData(String spName,String conD,String dayNum){
    	//二维数据
    	Vector data = new Vector();
    	String sql =null;
    	if(">=".equals(conD)){
    		sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum >= "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
    	if("<=".equals(conD)){
    		sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum < "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
        if("=".equals(conD)){
        	sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum = "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
    	
    	//是否查 出库存为零的商品
    	Connection conn = JDBCTool.getConnection();
    	PreparedStatement ps = null;
		ResultSet  rs = null;
		
		try {
			   ps = conn.prepareStatement(sql);
			   //ps.setInt(1, 10);
			   //System.out.println(new Integer(dayNum).intValue());
			   rs = ps.executeQuery(sql);
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
			
		} finally{
			JDBCTool.freeResorse(rs, ps, conn);
		}
    	return data;
    }
	
}
