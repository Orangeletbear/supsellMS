package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
/**
 * �˿��˻��Ի����еĹ˿��˻���ѯѡ�
 * �ϵĸ߼���ѯ��ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class GaoJiChaXunAction implements ActionListener {

	public static GuKeTuiHuoDialog dialog;
	
	public GaoJiChaXunAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		 new GaoJiChaXun(dialog,"����",true);

	}

	public static GuKeTuiHuoDialog getDialog(){
		return dialog;
	}
}
