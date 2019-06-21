package com.cn.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;
/**
 * һ�����ڴ������ļ��м������ݿ�Ĺ�����
 * @author finey
 *
 */
public class JDBCTool {
	
   private static Properties pro=new Properties();
   static{
	   try {
		InputStream in = new BufferedInputStream(
				      new FileInputStream("src/com/cn/util/db.properties"));  
		pro.load(in);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"�������ļ�����");
	} catch (IOException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"�������ļ�����");
	}
   }
   static {
	   try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,"��������ʧ��");
		e.printStackTrace();
	}
   }
   
   public static Connection getConnection(){
	   Connection conn = null;
	   String url = pro.getProperty("url");
	   String user = pro.getProperty("user");
	   String password = pro.getProperty("password");
	   
	   try {
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"ϵͳ���ݿ��ʹ��ʧ��");
	}finally{
		
	}
	return conn;
   }
   /*
    * ���ݿ���ͷ�
    */
   public static void freeResouse(ResultSet rs){
	   if(rs!=null){
		   try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
   }
   public static void freeResouse(Statement st){
	   if(st != null){
		   try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
   }
   public static void freeResouse(Connection conn){
	   if(conn != null){
		   try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
   }
   public static void freeResouse(ResultSet rs,Statement st){
	   freeResouse(rs);
	   freeResouse(st);
   }
   public static void freeResouse(Statement st,Connection conn ){
	   freeResouse(st);
	   freeResouse(conn);
   }
   public static void freeResorse(ResultSet rs,Statement st,Connection conn){
	   freeResouse(rs);
	   freeResouse(st);
	   freeResouse(conn);
   }
  
}
