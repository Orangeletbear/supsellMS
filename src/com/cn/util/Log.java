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
 * ���ڼ�¼һ������ӿ�ʼ���������¼���־
 * ��Ϣֻд��һ���ļ���
 * @author finey
 *
 */
public class Log {
	
   private static BufferedWriter cout = createLogFileStream();
  
   /**
    * ����һ��������
    * @return
    */
   private static BufferedWriter createLogFileStream(){
	   
	   GregorianCalendar c = new GregorianCalendar();
	   
	   //��ǰ���ڵ��ļ�
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
    * ��������Ϣд��Ŀ־
    * @return
    * @throws IOException 
    */
   public static boolean traceLog(String... message) {
	   Vector data = new Vector();
	   try {
		   String time = Log.writeCalendar();
		   //д�����ݿ���
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
    * д���еĶ��󵽵���־�ļ���
    * @param className
    * @return
 * @throws IOException 
    */
   public static boolean debugLog(Object obj) {
	  
	   try {
            Log.writeCalendar();
            cout.write("д��һ����,��������:\n");
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

	   //��ǰ���ڵ��ļ�
	   String currentTime =  "["+time+"] ";
	   cout.write(currentTime);
	   return time;
   }
   /**
    * д�쳣��Ϣ
    * @param ex  �쳣����
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
     * �ر�������
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
     * ��־��Ϣд�����ݿ�
     * @param data
     */
  public static void logMessageToDataDB(Vector data){

 	    String sql = "insert into tb_logmessage values(?,?,?)";
 	    
  	    String spLbId = null;
		Connection conn = JDBCTool.getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
   	    try {
   		    ///ȡ������ԱID
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		}finally{
			JDBCTool.freeResouse(ps, conn);
		}
		
	
  }
}
