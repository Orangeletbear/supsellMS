package com.cn.util;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 打印表数据
 * @author finey
 *
 */
public class PrintTableData {

    public static void printTableData(String fileName,JTable table,String[] columns){
    	 
    	JFileChooser fileWindow = new JFileChooser("D:\\SuperSellMS\\res\\excel\\");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXL 文件 ","xls");
        
        fileWindow.setFileFilter(filter);

    	int rval = fileWindow.showSaveDialog((JFrame)null);
		 if(rval == JFileChooser.APPROVE_OPTION){
			 try{   
				File file2 = new File(fileWindow.getCurrentDirectory(),
						fileWindow.getSelectedFile().getName()); 
				
				ReaderXls.reader(file2.getAbsolutePath(), table, columns);
				
	         } 
	         catch(Exception e1){
		         e1.printStackTrace();
	         }	  	  
		 }
		 if(rval == JFileChooser.CANCEL_OPTION){
			 
		 }
		 
    }
    
}
    	

