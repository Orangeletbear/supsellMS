package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * �����Ʒ�е���Ʒ���
 * 
 * @author Administrator
 *
 */

public class SPCF_AddShangPinAction implements ActionListener {
	
	private ChaifenKunbang dialog;
	
	public SPCF_AddShangPinAction(ChaifenKunbang dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog.getTextBCSPBH().getText().trim().length() > 0){
			AddSanPingDialog spDialog = new AddSanPingDialog(dialog,"������Ʒ(�����Ʒ)","",true,"0");
			spDialog.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "δѡ������Ʒ��");
		}
	}
}
