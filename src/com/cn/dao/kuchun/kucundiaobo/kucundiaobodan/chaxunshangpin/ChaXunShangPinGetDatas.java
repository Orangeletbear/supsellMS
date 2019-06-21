package com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chaxunshangpin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.util.JDBCTool;

/**
 * ���ı����е���Ϣ���д����Ǳ�Ż�������
 * 
 * @author Administrator
 *
 */


public class ChaXunShangPinGetDatas {
	
	
	public static Object[][] createSQL(String str){
		String sql = null;
		
		if(str.length() > 0 ){
			if(str.matches("\\d+")){
				sql = "select SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ," +
						"SP.SP_ZDKC from tb_spinfo sp" +
						  " where sp.sp_id like '%" + str + "%'";
			}else{
				sql = "select SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ," +
						"SP.SP_ZDKC from tb_spinfo sp" +
						  " where sp.sp_name like '%" + str + "%'";
			}
		}else{
			sql = "select SP.SP_ID,SP.SP_NAME,SP.SP_DW,SP.SP_GGXH,SP.SP_COLOR,SP.SP_DJ," +
					"SP.SP_ZDKC from tb_spinfo sp";
		}
		
		return getDatas(sql);
	}
	
	
	/**
	 * 
	 * ����ģ����ѯ������
	 * @param sql
	 * @return
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
				List<Object> li = new ArrayList<Object>();
				for(int i = 1; i <= column1; i ++  ){
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
		
		//��list�е����ݴ���Object
		Object [][]datas = new Object[list.size()][list.get(0).size()];
		
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(0).size(); j++){
				datas[i][j] = list.get(i).get(j);
			}
		}
		
		return datas;
	}
}
