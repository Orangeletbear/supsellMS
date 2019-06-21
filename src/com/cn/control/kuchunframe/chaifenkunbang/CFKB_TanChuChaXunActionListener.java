package com.cn.control.kuchunframe.chaifenkunbang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;
/**
 * 普遍用于商品选择查询按钮弹出的窗体
 * 
 * 如在商品拆分中，当单击查询被拆商品时，弹出商品信息窗口
 * @author Administrator
 *
 */
public class CFKB_TanChuChaXunActionListener implements ActionListener {
	
	private ChaifenKunbang dialog;
	private BaozhuangShezhiJDialog bDialog;
	
	public CFKB_TanChuChaXunActionListener(ChaifenKunbang dialog){
		this.dialog = dialog;
	}
	public CFKB_TanChuChaXunActionListener(BaozhuangShezhiJDialog bDialog){
		this.bDialog = bDialog;
	}
	
//	public BCSPCXAction(BeiChaiShangPinFindJWindow win){
//		this.win = win;
//	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		/*
		 * 拆分、捆绑中的窗口
		 */
		if(dialog instanceof ChaifenKunbang){
			if(dialog.getBtnCX1() == btn){
				BeiChaiShangPinFindJWindow bc = new BeiChaiShangPinFindJWindow(dialog,"0",dialog.getTextBCSPBH().getText().trim()) ;
				bc.setBounds(400, 220,400,280);
			}
			
			if(dialog.getBtnCX2() == btn){
				BeiChaiShangPinFindJWindow bc = new BeiChaiShangPinFindJWindow(dialog,"1",dialog.getTextKBSP().getText().trim()) ;
				bc.setBounds(400, 220,400,280);
			}
		}
		
		
		/*
		 * 包装设置中的窗口
		 */
		if(bDialog instanceof BaozhuangShezhiJDialog){
			if(bDialog.getBtnCX1() == btn){
				BeiChaiShangPinFindJWindow bc = new BeiChaiShangPinFindJWindow(
						bDialog,"0",bDialog.getTextSPBH1().getText().trim()) ;
				bc.setBounds(400, 190,400,280);
			}
			
			if(bDialog.getBtnCX2() == btn){
				BeiChaiShangPinFindJWindow bc = new BeiChaiShangPinFindJWindow(bDialog,"1",bDialog.getTextSPBH2().getText().trim()) ;
				bc.setBounds(400, 350,400,280);
			}
		}	
	}
}
