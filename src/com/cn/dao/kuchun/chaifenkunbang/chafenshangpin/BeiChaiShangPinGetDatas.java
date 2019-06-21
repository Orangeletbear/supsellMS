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
 * ���ݻ����Ʒ��ţ�����ѯ��Ҫ����ֵ���Ʒ��ϸ��Ϣ
 * @author Administrator
 *
 */

public class BeiChaiShangPinGetDatas {
	/*
	 * ��ȡSQL���
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
	 * �����ݿ���в�ѯ����,��ʼ���������������
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
		}
		
		if(list.size() == 0){
			return new Object[][]{};
		}
		
		//��list�е����ݴ���Object
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
