package com.cn.control.systemframe.sanpingtiaojia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;

/**
 * 商品调价下的，查询按钮监听器
 * @author Administrator
 *
 */
public class SPTJDocumentAcion implements DocumentListener {
	
	private SanpinTiaoJiaJFrame frame;
	
	public SPTJDocumentAcion(SanpinTiaoJiaJFrame frame) {
		this.frame = frame;
	}

	public void changedUpdate(DocumentEvent arg0) {
		
	}

	public void insertUpdate(DocumentEvent arg0) {
		SPTiaoJiaGetDataPublic.getDataAndSetData(frame);
	}

	public void removeUpdate(DocumentEvent arg0) {
		SPTiaoJiaGetDataPublic.getDataAndSetData(frame);
	}

}
