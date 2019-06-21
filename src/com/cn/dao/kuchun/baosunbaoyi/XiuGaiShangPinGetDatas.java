package com.cn.dao.kuchun.baosunbaoyi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ��Ʒѡ��֮����޸� ,ͨ����ȡ��Ʒ���ƽ������ݽ���
 * @author Administrator
 *
 */
public class XiuGaiShangPinGetDatas {
	
	/*
	 * ������Ʒ���޸�
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
	 * �˷��������жϴ�������ĵ�����������֮��Ĵ�С��ϵ
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
			JOptionPane.showMessageDialog(null, "������ĵ�������̫��,���������룡");
		}
		//�������ݿ�
//		updata(id,num);
		
		return count > i ? i :count;
	}
}
