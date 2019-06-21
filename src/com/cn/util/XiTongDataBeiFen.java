package com.cn.util;
import java.io.File;
import java.io.IOException;


public class XiTongDataBeiFen {
	 public static void dataBackup(String databasename, String databasepw,
			   String netname, String filepath, String filename)
			   throws IOException {
			  Runtime rt = Runtime.getRuntime();
			  Process processexp = null;
			  checkCreatDir(filepath);
			  String exp = "exp " + databasename + "/" + databasepw + "@" + netname
			    + " file=" + filepath + "/" + filename ;
			  int success = 0;
			  try {
			   processexp = rt.exec(exp);
			  } catch (IOException e) {
			   success = -1;
			  
			   e.printStackTrace();
			  }

			 }
	 public static void dataResume(String databasename,String databasepw,String netname,String fromuser,String filename)
	   throws IOException {
	  Runtime rt = Runtime.getRuntime();
	  Process processimp = null;
	  // if(checkDir("f:/"+filename)){
	  String imp = "imp " + databasename + "/" + databasepw + "@" + netname
	    +" fromuser="+fromuser
	    +" touser="+fromuser
	    +" file="
	       + filename + ".dmp";
	  int success = 0;
	  try {
	   processimp = rt.exec(imp);
	  } catch (IOException e) {
	   success = -1;
	   e.printStackTrace();
	  }
	  // }
	 }
	 // 创建文件夹

	 public static void checkCreatDir(String dirPath) { // 目录是否存在
	  File file = new File(dirPath);
	  if (!file.exists()) {
	   file.mkdirs();
	  }
	 }
public static void main(String args[]){
	try {
		XiTongDataBeiFen.dataResume("SSMSUSER", "123456", "ORACLE", "SSMSUSER", "D:\\2008-11-06");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
