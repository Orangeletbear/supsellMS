package com.cn.util;

import java.sql.Timestamp;
//import java.text.ParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/********************************************************************
 * ���ں��ַ���֮����໥ת��
 * 
 * @author makai
 * @version 1.0 2009/02/07
 */
public class DateConventer {
  
  /****************************************************************
   * ���ַ���ת��Ϊjava.util.Date
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
      System.out.println("�Ƿ����ַ���������");      
      e.printStackTrace();
    }
    return d;
  }
  
  /****************************************************************
   * ���ַ���ת��Ϊjava.util.Date
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
      System.out.println("�Ƿ����ַ���������");      
      e.printStackTrace();
    }
    return d;
  }
  
  /****************************************************************
   * ��java.util.Dateת��Ϊ�ַ���
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
   * ���ַ���ת��Ϊjava.sql.Timestamp
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
   * ��Timestampת��Ϊ�ַ���
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
		