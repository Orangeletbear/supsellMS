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
 * ���ڼ�¼һ������ӿ�ʼ���������¼���־
 * ��Ϣֻд��һ���ļ���
 * @author finey
 *
 */
public class WriteLogMessage {
	
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
    * д���еĶ��󵽵���־�ļ���
    * @param className
    * @return
 * @throws IOException 
    */
   public static boolean debugLog(Object obj) {
	  
	   try {
            WriteLogMessage.writeCalendar();
            cout.write("д��һ����,��������:\n");
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
	   
	   //��ǰ���ڵ��ļ�
	   String logName =  "["+c.get(Calendar.YEAR)+"-"+ (c.get(Calendar.MONTH)+1) + "-"+
	                     c.get(Calendar.DAY_OF_MONTH)+"] [" + c.get(Calendar.HOUR) +":"+
	                     c.get(Calendar.MINUTE) +":"+ c.get(Calendar.SECOND)+"] ";
	   cout.write(logName);
   }
   /**
    * д�쳣��Ϣ
    * @param ex  �쳣����
    * @return  
 * @throws IOException 
    */
    public static void debugLog(Exception ex) throws IOException{
    	   WriteLogMessage.writeCalendar();
    	   PrintWriter pw = new PrintWriter(cout);
    	   ex.printStackTrace(pw);
   }
    /**
     * �ر�������
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
