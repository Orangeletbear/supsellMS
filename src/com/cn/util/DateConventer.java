package com.cn.util;

import java.sql.Timestamp;
//import java.text.ParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/********************************************************************
 * 日期和字符串之间的相互转换
 * 
 * @author makai
 * @version 1.0 2009/02/07
 */
public class DateConventer {
  
  /****************************************************************
   * 将字符串转换为java.util.Date
   * 
   * @param str
   * @return java.util.Date
   ****************************************************************/
  public static Date strToDate(String str, String pattern) {
    Date d = null;
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    try {
      d = formatter.parse(str);
    } catch (ParseException e) {
      System.out.println("非法的字符串。。。");      
      e.printStackTrace();
    }
    return d;
  }
  
  /****************************************************************
   * 将字符串转换为java.util.Date
   * 
   * @param str
   * @return java.util.Date
   ****************************************************************/
  public static Date strToDate(String str) {
    Date d = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      d = formatter.parse(str);
    } catch (ParseException e) {
      System.out.println("非法的字符串。。。");      
      e.printStackTrace();
    }
    return d;
  }
  
  /****************************************************************
   * 将java.util.Date转换为字符串
   * 
   * @param str
   * @param pattern
   * @return String
   ****************************************************************/
  public static String dateToStr(Date date, String pattern) {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(date);    
  }
  
  public static String dateToStr(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    return formatter.format(date);    
  }
  
  /****************************************************************
   * 将字符串转换为java.sql.Timestamp
   * 
   * @param str
   * @return java.sql.Timestamp
   ****************************************************************/
  public static Timestamp strToTimestamp(String str, String pattern) {
    //return Timestamp.valueOf(str);
    return new Timestamp(strToDate(str, pattern).getTime());
  }
  
  public static Timestamp strToTimestamp(String str) {
    //return Timestamp.valueOf(str);
    return new Timestamp(strToDate(str).getTime());
  }
  
  /****************************************************************
   * 将Timestamp转换为字符串
   * 
   * @param str
   * @return java.sql.Timestamp
   ****************************************************************/
  public static String timestampToStr(Timestamp stamp, String pattern) {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(stamp);
  }
  
  public static String timestampToStr(Timestamp stamp) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(stamp);
  }
  
  
}
		