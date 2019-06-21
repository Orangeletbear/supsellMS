package com.cn.util;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
/*
 * 时间线程,传一个你所显示的Label,不断在JLabel上更新系统当前时间
 */
public class TimeThread implements Runnable {
	
	private static JLabel labe;
	
	public TimeThread(JLabel labe) {
		this.labe = labe;
	}

	public void run() {
         while(true){
        	 Date date = new Date();
        	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	 String time = formatter.format(date);
        	 
        	 labe.setText(time);
        	 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	labe.setFont(new Font("ff",Font.PLAIN,15));

         }
	}
	
	/*
	 * 时间线程启动
	 */
	public static void printTime(JLabel labe){
		Thread thread = new Thread(new TimeThread(labe));
		thread.setDaemon(true);
		thread.start();
	}

}
