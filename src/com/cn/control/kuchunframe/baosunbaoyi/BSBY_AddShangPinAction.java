package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

public class BSBY_AddShangPinAction implements ActionListener {

	private BaosunBaoyi dialog;
	
	public BSBY_AddShangPinAction(BaosunBaoyi dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
//		if(dialog.getComboDJLX1().getSelectedItem().toString().equals("商品报损")){
			AddSanPingDialog spDialog = new AddSanPingDialog(dialog,"增加商品(商品报损)","","0");
////			====================================== 
//			System.out.println("2222222222222222222");
			spDialog.setVisible(true);
//		}
//		if(dialog.getComboDJLX1().getSelectedItem().toString().equals("商品报溢")){
//			AddSanPingDialog spDialog = new AddSanPingDialog(dialog,"增加商品(商品报溢)","","0");
//			====================================== 
//			System.out.println("3333333333333");
			
//			spDialog.setVisible(true);
//		}
	}
}
