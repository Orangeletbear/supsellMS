package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.kuchun.chaifenkunbang.kunbangshangpin.KunBangShangPinPutinDatabase;
import com.cn.util.JDBCTool;

/**
 * 
 * 根据调拨窗口所选择的调出仓库来筛选商品
 * @author Administrator
 *
 */
public class AddShangPinGetDatas {
	

	/*
	 * 获取SQL语句
	 */
	public static Object[][] createSQL(String name){
		String CKID = KunBangShangPinPutinDatabase.getCKId(name);
		String sql = null;
		if(name.length() > 0){
				sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ,SP.SP_ZDKC" +
						" FROM TB_SPINFO SP WHERE SP.SP_SYCK = '" +CKID + "'";
		}else{
			sql = "SELECT SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ,SP.SP_ZDKC" 
							+ " FROM TB_SPINFO SP";
		}
		return getDatas(sql);
	}
	
	
	/*
	 * 与数据库进行查询交互
	 */
	public static Object[][] getDatas(String sql){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		List<List> list = new ArrayList<List>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			int column1 = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				List li = new ArrayList();
				for(int i = 1; i <= column1; i ++ ){
					li.add(rs.getObject(i));
				}
				list.add(li);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list.size() == 0){
			return new Object[][]{};
		}
		
		Object[][] datas = new Object[list.size()][list.get(0).size()];
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(0).size(); j++){
				datas[i][j] = list.get(i).get(j);
			}
		}
		
		return datas;
	}
}
