package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;
/**
 * ���۵��ݲ�ѯ�ϵ���ϸ���Ұ�ť�ļ�����
 * @author Administrator
 *
 */
public class XiangXiChaZhaoAction implements ActionListener {

	private static DanJuChaXunDialog dialog;
	
	public XiangXiChaZhaoAction(DanJuChaXunDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		new ChaZhaoDialog(dialog,"����",true);

	}
	public static DanJuChaXunDialog getDialog() {
		return dialog;
	}

}
