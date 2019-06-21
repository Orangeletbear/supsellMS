package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
/*
 * Ñ¡ÔñÊ÷µÄÊó±ê¼àÌýÆ÷
 */
public class TreeMouseAction extends MouseAdapter {
	
	private KuCunChaXunFrame frame;
	public TreeMouseAction(KuCunChaXunFrame frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent e) {
           if(e.getButton() == 1){
        	   
        	   String ckName = frame.getTree().getLastSelectedPathComponent().toString().trim();
        	   String spName = frame.getSpbhmcfield32().getText().toString().trim();
        	   
        	   CunChunPublicFindData.setSPDataFromDatabase(frame,ckName,spName);
           }
	}

	

}
