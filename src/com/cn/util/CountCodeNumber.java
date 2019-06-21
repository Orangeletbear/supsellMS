package com.cn.util;

import java.io.*;
import java.util.regex.*;

/**
 * 计算一个文件夹下所有.java文件的有效代码.
 * 注:注释和空行为非有效
 * @author finey
 *"((\\t+)|([ ]*)|((([ ]*)|(\\t+))[//].*)|((([ ]*)|(\\t+[ ]*))\\*.*))";
 */
public class CountCodeNumber {
	
	/** num 代码的行数   regexRightCode 为正确代码的正则*/
    private int num = 0;
    private int noNum = 0;
    private boolean flag = false;
    private static String regexRightCode = 
    "((\\s*)(()|(\\/\\*.*)|(//.*)|(\\*.*)))";
	
	public int getNum() {
		return num;
	}
	public int getNoNum() {
		return noNum;
	}
	/**
	 * 计算文件或文件夹中的代码数
	 * @param file
	 * @throws FileNotFoundException 
	 */
    public void countCodeNumber(File file,String regex) throws FileNotFoundException{
    	if(file == null)
    		return ;
    	
    	//为java文则返回条数
    	if(file.isFile()){
    		//取得文件后缀
    		
    		if(file.toString().matches(regex)){
				num = countFile(new FileInputStream(file));	
    	        return;
    	    }
    		System.out.println("文件非java文件!");
    		return;
        }
    	else{
    		if(!file.isDirectory()){
    			System.err.println("该文件不存在于系统中!!!");
    			return;
    		}
    	}
    	
    	//累加当前文件下的满足给定条件的代码
    	File [] f = file.listFiles(new InnerFileNameFilter(regex));
    	
    	//==================以下有两种方法=======================
    	/**   1. 用SequenceInputStream 整合多个文件一起读  */
   
    	/*List<InputStream> list = new ArrayList<InputStream>();
		try{
		   for(int i = 0;i<f.length;i++)
			  list.add(new FileInputStream(f[i]));
		
		   
		}catch(FileNotFoundException e){
			System.out.println("文件没有找到!!!");
			for(int i = 0;i < list.size();i++){
				CloseFile.free(list.get(i));
			}
			e.printStackTrace();
		}catch(IOException e){
			
			e.printStackTrace();
		}
		InputStream cin = new BufferedInputStream(
                new SequenceInputStream(
           Collections.enumeration(list)));
    	
		num += countFile(cin);   //当前目录下的所有java文件计算
*/    	
    	/**2.   ==========单个文件计算===========  */
    	for(int i = 0;i<f.length;i++){
    		num+=countFile(new FileInputStream(f[i]));
    	}
    	
    }
    /**
     * 计算一个源文件中满足条件的代码行数
     * @return int 代码数
     */
   private int countFile(InputStream cin){
	   BufferedReader bin = null;
	   int tem = 0;
	   try {
		    bin = new BufferedReader(new InputStreamReader(cin));
		    String str = null;
		    while((str = bin.readLine())!= null){
		    	if(isRightCode(str)){
		    		tem++;
		    	}
		    	else{
		    	   this.noNum++;
		    	}
		    }
		    
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		    try {
		    	if(bin != null)
				   bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	   return tem;
   }
   /**
    * 计算是否为有效代码
    * @param str
    * @return
    */
   private boolean isRightCode(String str){
	   if(str == null)
		   
	       return false;
	   Pattern p = Pattern.compile(CountCodeNumber.regexRightCode);
	   Matcher m = p.matcher(str);
	   if(flag){
		   if(str.trim().matches(".*\\*/$")){
			   flag = false;
		   }
		   return false;   
	   }
	   if(str.trim().matches("/\\*.*")){
		   if(!str.trim().matches("/\\*.*\\*/$")){
		     flag = true;
		     return false;
	       }
	   }
	   return !m.matches();
   }
    /**
     * 用于对当前对象中所指目录下的文件的过滤的实现类
     * 
     */
    public class InnerFileNameFilter implements FilenameFilter {
        private Pattern p;
        private String regex;
        
        InnerFileNameFilter(String regex){
        	this.regex = regex;
        	p = Pattern.compile(regex);
        }
    	public boolean accept(File dir, String name) {
    		if(new File(dir,name).isDirectory()){
    			try {
					countCodeNumber(new File(dir,name) ,regex);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
    		}
    		File f = new File(dir,name);
    		if(f.isDirectory()){
    			return false;
    		}
    
    		
    		Matcher m = p.matcher(name);
    		return m.matches();
    		
    	}

    }

	public static void main(String[] args) {
		CountCodeNumber c = new CountCodeNumber();
		
		File f = new File("D:/SuperSellMS/src/com/cn/");
		
		try {
			c.countCodeNumber(f , ".+[.]java");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("该文件下有java有效代码: "+c.getNum());
		System.out.println("该文件下无效代码  : "+c.getNoNum());
	}
}
