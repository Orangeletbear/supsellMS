package com.cn.util;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
/*
 * ʱ���߳�,��һ��������ʾ��Label,������JLabel�ϸ���ϵͳ��ǰʱ��
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
	 * ʱ���߳�����
	 */
	public static void printTime(JLabel labe){
		Thread thread = new Thread(new TimeThread(labe));
		thread.setDaemon(true);
		thread.start();
	}

}
