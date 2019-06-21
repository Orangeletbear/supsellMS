package com.cn.util;
import java.io.IOException;


public class TextOracleBack{

		public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime();
		Process processexp = null;
		String exp = "imp fuser/123456@finey file=d:\\sql.dmp";
		try {
		    processexp = rt.exec(exp);
		    if   (processexp.waitFor()!=0)   {   
		                 System.err.println("exit   value   =   "   +   
		                   processexp.exitValue());   
		    }   
		    System.out.println(processexp);
		   } catch (IOException e) {
			   
		    e.printStackTrace();
		   } catch (InterruptedException e) {
			   
		    e.printStackTrace();
		   }

		}

		}

