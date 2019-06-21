package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 拆分商品中的商品添加
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
			AddSanPingDialog spDialog = new AddSanPingDialog(dialog,"增加商品(拆分商品)","",true,"0");
			spDialog.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "未选择拆分商品！");
		}
	}
}
