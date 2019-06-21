package com.cn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * �������ݿ�
 * @author Administrator
 *
 */
public class BackOracle {
	/**
	* ����oracle���ݿ�
	* 
	* @author �ƿ���
	* @param userName
	*            ���ݿ��¼��
	* @param passWord
	*            ���ݿ��¼����
	* @param dataBaseName
	*            ��Ҫ���ݵ����ݿ�����
	* @param address
	*            �����ַ;��D:/doc/
	* @param name
	*            ���ݿⱣ������
	* @return ���ݵ����ݿ�����
	*/
	private void backUpDataBaseOracle(
			String userName,String passWord,String dataBaseName,String address){
	// ƴװDOS����������ݿⱸ��
	
	StringBuffer exp=new StringBuffer("exp ");
	
	exp.append(userName);
	exp.append("/");
	exp.append(passWord);
	exp.append("@");
	exp.append(dataBaseName);
	exp.append(" file=");
	/*
	* �õ��洢��ַ�����һ���ַ� �����\��ֱ��ƴװ��ַ ���û��\�ͼ���/Ȼ��ƴװ���ݿ�����
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
	
	System.out.println("��ʼ����........");
	try {
		System.out.println(exp.toString());
		
		Process p=Runtime.getRuntime().exec(exp.toString());
		
		InputStreamReader isr = new InputStreamReader(p.getErrorStream()); 
		
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;   
		
		while ((line = br.readLine()) != null){   
			
			if(line.indexOf("����")!=-1){    
				
				break;   
			}   
		}
		
		p.destroy();
		
		p.waitFor();
		
		System.out.println("���ݳɹ�......");
		
	} catch (IOException e) {
		
		System.out.println(e.getMessage());
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
	}
	
	
	
	
	/**
	* �ָ�oracle���ݿ�
	* 
	* @author �ƿ���
	* @param userName
	*            ���ݿ��¼��
	* @param passWord
	*            ���ݿ��¼����
	* @param dataBaseName
	*            ��Ҫ���ݵ����ݿ�����
	* @param address
	*            �����ַ;��D:/doc/
	* @param name
	*            ���ݿⱣ������
	* @return ���ݵ����ݿ�����
	*/
	private void resumeDataBaseOracle(String userName, String passWord,
	    String dataBaseName, String address) {
		
	   // ƴװDOS����������ݿⱸ��
	   StringBuffer exp = new StringBuffer("imp ");
	   
	   exp.append(userName);
	   exp.append("/");
	   exp.append(passWord);
	   exp.append("@");
	   exp.append(dataBaseName);
	   exp.append(" file=");
	   
	   /*
	   * �õ��洢��ַ�����һ���ַ� �����\��ֱ��ƴװ��ַ ���û��\�ͼ���/Ȼ��ƴװ���ݿ�����
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
	   
	   //�ж��ļ��Ƿ���ڣ����ڲŽ��лָ������ھͲ��ָ�
	   
	   if (file.exists()) {
		   System.out.println("file is hesre");
		   System.out.println("��ʼ�ָ�........");
	    try {
	    	System.out.println(exp.toString());
	    	Process p=Runtime.getRuntime().exec(exp.toString());
	    	
	    	InputStreamReader isr = new InputStreamReader(p.getErrorStream());
	    	
	    	BufferedReader br = new BufferedReader(isr);
	    	String line = null;
	    	
	     while ((line = br.readLine()) != null) {
	    	 if (line.indexOf("����") != -1) {
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
		//����
		//new BackOracle().backUpDataBaseOracle("fuser", "123456", "finey", "d:\\");
		
		//��ԭ
		new BackOracle().resumeDataBaseOracle(
				"fuser", "123456", "finey", "d:\\");
		
	} 
	

}

 

