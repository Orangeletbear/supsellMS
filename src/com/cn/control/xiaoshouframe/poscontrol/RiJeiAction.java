package com.cn.control.xiaoshouframe.poscontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.xiaoshouJFrame.POS.RiJieGuanLiDialog;

/**
 *  �սᰴť,���ڽ�����գ�����һ���POSǰ̨���۵�ͳ�ƣ������������սڵ�
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
        		frame, "�Ƿ��ڸ�ʱ����ս�","�ս�",
        		 JOptionPane.YES_NO_OPTION, 1);
          //��ȷ��ɾ������
	     if(choice == JOptionPane.YES_OPTION){
	    	 
	     }else{
	    	 return;
	     }
	}

}
