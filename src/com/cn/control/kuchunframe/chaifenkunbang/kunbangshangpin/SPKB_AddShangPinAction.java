package com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

public class SPKB_AddShangPinAction implements ActionListener {
	private ChaifenKunbang dialog;
	
	public SPKB_AddShangPinAction(ChaifenKunbang dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog.getTextKBSP().getText().trim().length() > 0){
			AddSanPingDialog spDialog = new AddSanPingDialog(dialog,"������Ʒ(������Ʒ)","",true,"1");
			spDialog.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "δѡ��������Ʒ��");
		}
	}
}
