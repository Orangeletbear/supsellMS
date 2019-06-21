package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.TuiHuoAllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.AllKeHuDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;

/**
 *  顾客退货对话框中的顾客退货查询选项卡上
 *  的详细查找按钮所弹出的
 *  查找对话框上的查找客户按钮所对应的监听器
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
