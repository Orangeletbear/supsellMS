package com.cn.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 用于记录一个程序从开始到结束的事件日志
 * 信息只写在一个文件中
 * @author finey
 *
 */
public class WriteLogMessage {
	
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
	   try {
		   WriteLogMessage.writeCalendar();
		   for(String name: message){
			   cout.write(name+" ");
		    }
		   cout.newLine();
		
	   } catch (IOException e) {
		   WriteLogMessage.closeStream();
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
            WriteLogMessage.writeCalendar();
            cout.write("写入一对象,数据如下:\n");
			cout.write(obj.toString());
			cout.newLine();
			
		   } catch (IOException e) {
			   WriteLogMessage.closeStream();
			  e.printStackTrace();
			  return false;
		   }
		      return true;
   }
   private static void writeCalendar() throws IOException{
	   GregorianCalendar c = new GregorianCalendar();
	   
	   //当前日期的文件
	   String logName =  "["+c.get(Calendar.YEAR)+"-"+ (c.get(Calendar.MONTH)+1) + "-"+
	                     c.get(Calendar.DAY_OF_MONTH)+"] [" + c.get(Calendar.HOUR) +":"+
	                     c.get(Calendar.MINUTE) +":"+ c.get(Calendar.SECOND)+"] ";
	   cout.write(logName);
   }
   /**
    * 写异常信息
    * @param ex  异常对象
    * @return  
 * @throws IOException 
    */
    public static void debugLog(Exception ex) throws IOException{
    	   WriteLogMessage.writeCalendar();
    	   PrintWriter pw = new PrintWriter(cout);
    	   ex.printStackTrace(pw);
   }
    /**
     * 关闭流对象
     */
    public static void closeStream() {
    	
    	WriteLogMessage.traceLog("Program is exit!");
    	if(cout != null){
    		try {
				cout.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
  
}
