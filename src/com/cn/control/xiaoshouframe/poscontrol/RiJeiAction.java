package com.cn.control.xiaoshouframe.poscontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.xiaoshouJFrame.POS.RiJieGuanLiDialog;

/**
 *  日结按钮,用于结算今日，或几日一起的POS前台销售的统计，产生独立的日节单
 * @author finey
 *
 */
public class RiJeiAction implements ActionListener {
	private RiJieGuanLiDialog frame;
	public RiJeiAction(RiJieGuanLiDialog frame) {
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent e) {
		int choice =  JOptionPane.showConfirmDialog(
        		frame, "是否在该时间点日结","日结",
        		 JOptionPane.YES_NO_OPTION, 1);
          //点确定删除数据
	     if(choice == JOptionPane.YES_OPTION){
	    	 
	     }else{
	    	 return;
	     }
	}

}
