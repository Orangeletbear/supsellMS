package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.kuchunJFrame.kuchunchaxun.ChaKanMingXiDialog;
/**
 * ��������˫��������
 * @author Administrator
 *
 */
public class TableMouseAction extends MouseAdapter {

	
	private KuCunChaXunFrame frame;
	private int flag = 0;
	public TableMouseAction(KuCunChaXunFrame frame,int flag) {
		this.frame = frame;
		this.flag = flag;
	}

	public void mouseClicked(MouseEvent e) {
           if(e.getClickCount() == 2){
        	   new ChaKanMingXiDialog(frame,"�鿴��Ʒ��ϸ",flag);
           }
	}


}
