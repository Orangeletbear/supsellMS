package com.cn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 备份数据库
 * @author Administrator
 *
 */
public class BackOracle {
	/**
	* 备份oracle数据库
	* 
	* @author 唐俊锋
	* @param userName
	*            数据库登录名
	* @param passWord
	*            数据库登录密码
	* @param dataBaseName
	*            需要备份的数据库名称
	* @param address
	*            保存地址;如D:/doc/
	* @param name
	*            数据库保存名称
	* @return 备份的数据库名称
	*/
	private void backUpDataBaseOracle(
			String userName,String passWord,String dataBaseName,String address){
	// 拼装DOS命令进行数据库备份
	
	StringBuffer exp=new StringBuffer("exp ");
	
	exp.append(userName);
	exp.append("/");
	exp.append(passWord);
	exp.append("@");
	exp.append(dataBaseName);
	exp.append(" file=");
	/*
	* 得到存储地址的最后一个字符 如果有\就直接拼装地址 如果没有\就加上/然后拼装数据库名称
	*/
	String maxIndex=address.substring(address.length()-1);
	
	if("/".equals(maxIndex)||"\\".equals(maxIndex)){
		exp.append(address);
	}else{
		address=address+"\\";
		exp.append(address);
	}
	
	File file = new File(address);
	
	if (!file.exists()) {
		file.mkdir();
	}
	
	exp.append(dataBaseName);
	
	exp.append(".dmp");
	
	System.out.println("开始备份........");
	try {
		System.out.println(exp.toString());
		
		Process p=Runtime.getRuntime().exec(exp.toString());
		
		InputStreamReader isr = new InputStreamReader(p.getErrorStream()); 
		
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;   
		
		while ((line = br.readLine()) != null){   
			
			if(line.indexOf("错误")!=-1){    
				
				break;   
			}   
		}
		
		p.destroy();
		
		p.waitFor();
		
		System.out.println("备份成功......");
		
	} catch (IOException e) {
		
		System.out.println(e.getMessage());
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
	}
	
	
	
	
	/**
	* 恢复oracle数据库
	* 
	* @author 唐俊锋
	* @param userName
	*            数据库登录名
	* @param passWord
	*            数据库登录密码
	* @param dataBaseName
	*            需要备份的数据库名称
	* @param address
	*            保存地址;如D:/doc/
	* @param name
	*            数据库保存名称
	* @return 备份的数据库名称
	*/
	private void resumeDataBaseOracle(String userName, String passWord,
	    String dataBaseName, String address) {
		
	   // 拼装DOS命令进行数据库备份
	   StringBuffer exp = new StringBuffer("imp ");
	   
	   exp.append(userName);
	   exp.append("/");
	   exp.append(passWord);
	   exp.append("@");
	   exp.append(dataBaseName);
	   exp.append(" file=");
	   
	   /*
	   * 得到存储地址的最后一个字符 如果有\就直接拼装地址 如果没有\就加上/然后拼装数据库名称
	   */
	   String maxIndex = address.substring(address.length() - 1);
	   
	   if ("/".equals(maxIndex) || "\\".equals(maxIndex)) {
		   exp.append(address);
	   } else {
		   address=address+"\\";
		   exp.append(address);
	   }
	   
	   exp.append("sql");
	   exp.append(".dmp");
	   
	   File file = new File(address+"sql"+".dmp");
	   System.out.println(file.getAbsolutePath());
	   
	   //判断文件是否存在，存在才进行恢复不存在就不恢复
	   
	   if (file.exists()) {
		   System.out.println("file is hesre");
		   System.out.println("开始恢复........");
	    try {
	    	System.out.println(exp.toString());
	    	Process p=Runtime.getRuntime().exec(exp.toString());
	    	
	    	InputStreamReader isr = new InputStreamReader(p.getErrorStream());
	    	
	    	BufferedReader br = new BufferedReader(isr);
	    	String line = null;
	    	
	     while ((line = br.readLine()) != null) {
	    	 if (line.indexOf("错误") != -1) {
	    		 	break;
	    	 }
	     }
	     
	     p.destroy();
	     p.waitFor();
	     
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    } catch (InterruptedException e) {
	    	System.out.println(e.getMessage());
	    }
	   }
	   
	} 
	
	
	public static void main(String[] args){
		//备份
		//new BackOracle().backUpDataBaseOracle("fuser", "123456", "finey", "d:\\");
		
		//还原
		new BackOracle().resumeDataBaseOracle(
				"fuser", "123456", "finey", "d:\\");
		
	} 
	

}

 

