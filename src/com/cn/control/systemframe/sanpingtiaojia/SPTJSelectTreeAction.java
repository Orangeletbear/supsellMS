package com.cn.control.systemframe.sanpingtiaojia;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;
/**
 * 商品调价下的树鼠标监听器
 * @author finey
 *
 */
public class SPTJSelectTreeAction extends MouseAdapter {

	private SanpinTiaoJiaJFrame frame;
	
	public SPTJSelectTreeAction(SanpinTiaoJiaJFrame frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent e) {
           if(e.getButton() == 1){
        	   SPTiaoJiaGetDataPublic.getDataAndSetData(frame);
           }
	}

}
