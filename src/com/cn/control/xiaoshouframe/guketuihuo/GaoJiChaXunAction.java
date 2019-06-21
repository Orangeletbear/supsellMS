package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;
/**
 * 顾客退货对话框中的顾客退货查询选项卡
 * 上的高级查询按钮所对应的监听器
 * @author Administrator
 *
 */
public class GaoJiChaXunAction implements ActionListener {

	public static GuKeTuiHuoDialog dialog;
	
	public GaoJiChaXunAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		 new GaoJiChaXun(dialog,"查找",true);

	}

	public static GuKeTuiHuoDialog getDialog(){
		return dialog;
	}
}
