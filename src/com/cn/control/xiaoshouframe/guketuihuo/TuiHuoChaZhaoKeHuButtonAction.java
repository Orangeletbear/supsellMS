package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.TuiHuoAllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;

/**
 *  �˿��˻��Ի����еĹ˿��˻���ѯѡ���
 *  ����ϸ���Ұ�ť��������
 *  ���ҶԻ����ϵĲ��ҿͻ���ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class TuiHuoChaZhaoKeHuButtonAction implements ActionListener {

		public static void setDialog(GaoJiChaXun dialog) {
		TuiHuoChaZhaoKeHuButtonAction.dialog = dialog;
	}
		private static GaoJiChaXun dialog;
			
		
		
		
		public TuiHuoChaZhaoKeHuButtonAction(GaoJiChaXun dialog){
			this.dialog = dialog;
		}
		
		public static GaoJiChaXun getDialog() {
			return dialog;
		}
		public void actionPerformed(ActionEvent e) {
			
			new TuiHuoAllKeHuDialog(dialog,"Fcxkh",true,true);
		}

}
