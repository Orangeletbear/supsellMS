package com.cn.dao.loginandmainframe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import com.cn.util.JDBCTool;
import com.cn.view.login.LoginDialog;

public class JDBCLoginInformation {
    /*
     * �����ݿ��������¼
     */
	public static LoginDialogVO compareUser(String user) {
		//����Ϊ�û����Ƿ���� 
		String sql= "select *from tb_usernofo tbu  where tbu.user_Name='"+
		user+"'";
		
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		LoginDialogVO voObj = new LoginDialogVO();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
				
			while(rs.next()){
				voObj.ID = rs.getString(1).trim();
				voObj.userName = rs.getString(2);
				voObj.password = rs.getString(3);
				voObj.position = rs.getString(4);
				voObj.isPos = rs.getString(5).trim().charAt(0);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
	    return voObj;
	}
	
	/*
	 * POS ��½����ʱ��֤
	 */
	public static boolean compareUser(String user,char[] password){
		//����Ϊ�û����Ƿ���� 
		
		String pasw  = new String (password);
		
		String sql= "select * from tb_usernofo tbu  where tbu.user_Name='"+
		user+"' and tbu.user_PSW='"+pasw+"'";
		Connection conn = JDBCTool.getConnection();
		Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				return true;
			}	
			
				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		return false;
	}

}
