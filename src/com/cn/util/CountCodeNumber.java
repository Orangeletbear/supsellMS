package com.cn.util;

import java.io.*;
import java.util.regex.*;

/**
 * ����һ���ļ���������.java�ļ�����Ч����.
 * ע:ע�ͺͿ���Ϊ����Ч
 * @author finey
 *"((\\t+)|([ ]*)|((([ ]*)|(\\t+))[//].*)|((([ ]*)|(\\t+[ ]*))\\*.*))";
 */
public class CountCodeNumber {
	
	/** num ���������   regexRightCode Ϊ��ȷ���������*/
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
	 * �����ļ����ļ����еĴ�����
	 * @param file
	 * @throws FileNotFoundException 
	 */
    public void countCodeNumber(File file,String regex) throws FileNotFoundException{
    	if(file == null)
    		return ;
    	
    	//Ϊjava���򷵻�����
    	if(file.isFile()){
    		//ȡ���ļ���׺
    		
    		if(file.toString().matches(regex)){
				num = countFile(new FileInputStream(file));	
    	        return;
    	    }
    		System.out.println("�ļ���java�ļ�!");
    		return;
        }
    	else{
    		if(!file.isDirectory()){
    			System.err.println("���ļ���������ϵͳ��!!!");
    			return;
    		}
    	}
    	
    	//�ۼӵ�ǰ�ļ��µ�������������Ĵ���
    	File [] f = file.listFiles(new InnerFileNameFilter(regex));
    	
    	//==================���������ַ���=======================
    	/**   1. ��SequenceInputStream ���϶���ļ�һ���  */
   
    	/*List<InputStream> list = new ArrayList<InputStream>();
		try{
		   for(int i = 0;i<f.length;i++)
			  list.add(new FileInputStream(f[i]));
		
		   
		}catch(FileNotFoundException e){
			System.out.println("�ļ�û���ҵ�!!!");
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
    	
		num += countFile(cin);   //��ǰĿ¼�µ�����java�ļ�����
*/    	
    	/**2.   ==========�����ļ�����===========  */
    	for(int i = 0;i<f.length;i++){
    		num+=countFile(new FileInputStream(f[i]));
    	}
    	
    }
    /**
     * ����һ��Դ�ļ������������Ĵ�������
     * @return int ������
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
    * �����Ƿ�Ϊ��Ч����
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
     * ���ڶԵ�ǰ��������ָĿ¼�µ��ļ��Ĺ��˵�ʵ����
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
		
		System.out.println("���ļ�����java��Ч����: "+c.getNum());
		System.out.println("���ļ�����Ч����  : "+c.getNoNum());
	}
}
