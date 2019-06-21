package com.cn.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * 用于记录一个程序从开始到结束的事件日志
 * 信息只写在一个文件中
 * @author finey
 *
 */
public class Log {
	
   private static BufferedWriter cout = createLogFileStream();
  
   /**
    * 建立一个流对象
    * @return
    */
   private static BufferedWriter createLogFileStream(){
	   
	   GregorianCalendar c = new GregorianCalendar();
	   
	   //当前日期的文件
	   String logName = "Log_" + c.get(Calendar.YEAR)+ (c.get(Calendar.MONTH)+1) +
	                     c.get(Calendar.DAY_OF_MONTH)+ c.get(Calendar.HOUR) + 
	                     c.get(Calendar.MINUTE) + c.get(Calendar.SECOND)+".txt";
	  
	   File file = new File("log",logName);
	   
	   file.getParentFile().mkdirs();
	   try {
		   
		  file.createNewFile();
		  
	   } catch (IOException e1) {
		   
		   e1.printStackTrace();
	   }
	   
	   BufferedWriter cout  = null;
	   try {
		   
		cout = new BufferedWriter(
				   new OutputStreamWriter(
				new FileOutputStream(file)));
		
		
	   } catch (FileNotFoundException e) {
		   
		e.printStackTrace();
	   } 
	   
       return cout;
	   
   }
   /**
    * 方法的信息写入目志
    * @return
    * @throws IOException 
    */
   public static boolean traceLog(String... message) {
	   Vector data = new Vector();
	   try {
		   String time = Log.writeCalendar();
		   //写入数据库中
		   data.add(time);
		   data.add(message[1]);
		   data.add(message[2]);
		   logMessageToDataDB(data);
		   for(String name: message){
			   cout.write(name+" ");
		    }
		   cout.newLine();
		   cout.flush();
	   } catch (IOException e) {
		   Log.closeStream();
		  e.printStackTrace();
		  return false;
	   }
	      return true;
       }
   /**
    * 写类中的对象到到日志文件中
    * @param className
    * @return
 * @throws IOException 
    */
   public static boolean debugLog(Object obj) {
	  
	   try {
            Log.writeCalendar();
            cout.write("写入一对象,数据如下:\n");
			cout.write(obj.toString());
			cout.newLine();
			cout.flush();
		   } catch (IOException e) {
			   Log.closeStream();
			  e.printStackTrace();
			  return false;
		   }
		      return true;
   }
   private static String writeCalendar() throws IOException{
	   
	   Date date = new Date();
  	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	   String time = formatter.format(date);

	   //当前日期的文件
	   String currentTime =  "["+time+"] ";
	   cout.write(currentTime);
	   return time;
   }
   /**
    * 写异常信息
    * @param ex  异常对象
    * @return  
 * @throws IOException 
    */
    public static void debugLog(Exception ex) throws IOException{
    	   Log.writeCalendar();
    	   PrintWriter pw = new PrintWriter(cout);
    	   
    	   ex.printStackTrace(pw);
    	   cout.flush();
   }
    /**
     * 关闭流对象
     */
    public static void closeStream() {
    	
    	if(cout != null){
    		try {
				cout.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    /**
     * 日志信息写入数据库
     * @param data
     */
  public static void logMessageToDataDB(Vector data){

 	    String sql = "insert into tb_logmessage values(?,?,?)";
 	    
  	    String spLbId = null;
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
   	    try {
   		    ///取出操作员ID
   	    	String userID = null;
   	    	ps = conn.prepareStatement(" select tb.user_id from tb_usernofo tb  " +
   	    			" where tb.user_name='"+data.get(1).toString().trim()+"'");
   	    	st = ps.executeQuery();
   	    	st.next();
   	    	userID = st.getString(1);
   	    	
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, DateConventer.strToTimestamp(
					data.get(0).toString(), "yyyy-MM-dd HH:mm:ss"));
            ps.setString(2,userID);
            ps.setString(3, data.get(2).toString());
            
			ps.executeUpdate();  
   		
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
		
	
  }
}
