package com.cn.control.kuchunframe.chaifenkunbang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;
/**
 * �ձ�������Ʒѡ���ѯ��ť�����Ĵ���
 * 
 * ������Ʒ����У���������ѯ������Ʒʱ��������Ʒ��Ϣ����
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
		 * ��֡������еĴ���
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
		 * ��װ�����еĴ���
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
