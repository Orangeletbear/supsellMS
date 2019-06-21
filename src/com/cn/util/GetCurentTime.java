package com.cn.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 获得当前的时间的年月日时分组合
 * @author finey
 *
 */
public class GetCurentTime {
        public static String getCurentTime(){
        	
        	 GregorianCalendar c = new GregorianCalendar();
      	   
      	   //当前日期的文件
      	   String time = "" + c.get(Calendar.YEAR)+ (c.get(Calendar.MONTH)+1) +
      	   					c.get(Calendar.DAY_OF_MONTH)+ c.get(Calendar.HOUR) + 
      	   					c.get(Calendar.MINUTE)+"";
           time = time.substring(2,time.length());
           return time;
        }
}
