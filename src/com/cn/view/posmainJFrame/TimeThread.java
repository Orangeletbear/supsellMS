package com.cn.view.posmainJFrame;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 时间线程
 */
public class TimeThread implements Runnable {
	
	private POSFrame frame;
	
	public TimeThread(POSFrame frame) {
		this.frame = frame;
	}

	public void run() {
         while(true){
        	 Date date = new Date();
        	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	 String time = formatter.format(date);
        	 
        	 frame.getTimeLabel().setText(time);
        	 frame.getTimeLabel().setFont(new Font("ff",Font.BOLD,15));
        	 if(frame == null){
        		 break;
        	 }
 
        	 //frame.repaint();
         }
	}

}
