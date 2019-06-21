package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.kuchunJFrame.kuchunchaxun.ChaKanMingXiDialog;
/**
 * 库存中鼠标双击监听器
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
        	   new ChaKanMingXiDialog(frame,"查看商品明细",flag);
           }
	}


}
