package com.cn.control.kuchunframe.kucunchaxun;

import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
/**
 * 库存查询中的，第三个面板中的，商品名或编号输入域文档监听
 * 即输一个监听一次返回一次数据
 * @author Administrator
 *
 */
public class SanPinXinDocumentAction implements DocumentListener {
	
	private KuCunChaXunFrame frame;
	
	public SanPinXinDocumentAction( KuCunChaXunFrame frame) {
		
	    this.frame = frame;
	}

	public void changedUpdate(DocumentEvent arg0) {
	}

	public void insertUpdate(DocumentEvent arg0) {
		String ckName = frame.getTree().getLastSelectedPathComponent().toString().trim();
    	String spName = frame.getSpbhmcfield32().getText().toString().trim();
    	 System.out.println("insert  mouse client1    "+ ckName+"   "+spName);
    	CunChunPublicFindData.setSPDataFromDatabase(frame,ckName,spName);
	}

	public void removeUpdate(DocumentEvent arg0) {
		String ckName = frame.getTree().getLastSelectedPathComponent().toString().trim();
    	String spName = frame.getSpbhmcfield32().getText().toString().trim();
    	 System.out.println("remove mouse client1    "+ ckName+"   "+spName);
    	CunChunPublicFindData.setSPDataFromDatabase(frame,ckName,spName);
	}

}
