package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;
/**
 * ���ҶԻ����ϵ�
 * ���ҿͻ���ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class ChaZhaoKeHuButtonAction implements ActionListener {

	//private  ChaZhaoDialog dialog;
	private static ChaZhaoDialog dialog;
	
	
	public ChaZhaoKeHuButtonAction(ChaZhaoDialog dialog){
		this.dialog = dialog;
	}
	
	public static ChaZhaoDialog getDialog() {
		return dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		new AllKeHuDialog(dialog,"Fcxkh",true,true);
	}

}
