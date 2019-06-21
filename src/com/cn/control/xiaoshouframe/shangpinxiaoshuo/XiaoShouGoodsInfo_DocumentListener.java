package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;

/**
 * 商品信息（销售商品）对话框中的
 * 几个文本框所对应的监听器
 * @author Administrator
 *
 */
public class XiaoShouGoodsInfo_DocumentListener implements DocumentListener {

	private XiaoShouGoodsInfo dialog;
	
	
	public XiaoShouGoodsInfo_DocumentListener(XiaoShouGoodsInfo dialog) {
		
		this.dialog = dialog;
	}

	public void changedUpdate(DocumentEvent e) {
	
	}

	
	public void insertUpdate(DocumentEvent e) {
		
		float daZhe = 0;
		float canKaoShouJia = 0;
		float shuLiang = 0;
		if (!dialog.getDaZhe().getText().equals("")){
			daZhe = Float.parseFloat(dialog.getDaZhe().getText().toString());
		}
		if (!dialog.getCanKaoShouJia().getText().equals("")){
			canKaoShouJia = Float.parseFloat(dialog.getCanKaoShouJia().getText().toString());
		}
		if (!dialog.getShuLiang().getText().equals("")){
			shuLiang = Float.parseFloat(dialog.getShuLiang().getText().toString());
		}
		
		
		if(e.getDocument().equals(dialog.getDaZhe().getDocument())){
			dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
			dialog.getDanJia().setText(""+daZhe*canKaoShouJia);
		
		}else if(e.getDocument().equals(dialog.getShuLiang().getDocument())){
			dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
		}else {
			dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
			dialog.getDanJia().setText(""+daZhe*canKaoShouJia);
			
		}

	}

	
	public void removeUpdate(DocumentEvent e) {
		
	}

}
