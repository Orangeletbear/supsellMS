package com.cn.dao.kuchun.chaifenkunbang.chafenshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * 
 * 根据获得商品编号，来查询需要被拆分的商品详细信息
 * @author Administrator
 *
 */

public class BeiChaiShangPinGetDatas {
	/*
	 * 获取SQL语句
	 */
	public static Object[][] createSQL(String num){
		
		String sql = null;
		
		if(num.length() > 0){
				
				sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_GGXH,SP.SP_DW,SP.SP_COLOR,SP.SP_ZDKC,SP.SP_DJ FROM TB_SPINFO SP" +
						" WHERE SP.SP_ID like '%" +num + "%'";
		}else if(num.length() == 0){
			sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_GGXH,SP.SP_DW,SP.SP_COLOR,SP.SP_ZDKC,SP.SP_DJ FROM TB_SPINFO SP";
			
		}
		return getDatas(sql);
	}
	
	
	/*
	 * 与数据库进行查询交互,初始化弹出窗体的数据
	 */
	public static Object [][] getDatas(String sql){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		List<List> list = new ArrayList<List>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			int column1 = rs.getMetaData().getColumnCount();
			while(rs.next()){
				List<Object> li = new ArrayList<Object>();
				for(int i = 1; i <= column1; i ++  ){
					li.add(rs.getObject(i));
				}
				list.add(li);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
		}
		
		if(list.size() == 0){
			return new Object[][]{};
		}
		
		//将list中的数据存在Object
		Object [][]datas = new Object[list.size()][list.get(0).size()];
//		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(0).size(); j++){
				datas[i][j] = list.get(i).get(j);
			}
		}
		return datas;
	}
}
