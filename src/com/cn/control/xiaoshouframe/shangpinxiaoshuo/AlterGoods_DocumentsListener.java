package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AlterXiaoShouGoodsDialog;
/**
 * 商品销售中的修改商品按钮所弹出的
 * 修改商品对话框上的文本框
 * 所对应的文本监听器
 * @author Administrator
 *
 */
public class AlterGoods_DocumentsListener implements DocumentListener {

	private AlterXiaoShouGoodsDialog dialog;
	
	public AlterGoods_DocumentsListener(AlterXiaoShouGoodsDialog dialog){
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
		
		if(e.getDocument().equals(dialog.getCanKaoShouJia().getDocument())){
			dialog.getDanJia().setText(String.valueOf(canKaoShouJia*daZhe));
			dialog.getZje().setText(String.valueOf(canKaoShouJia*daZhe*shuLiang));
		}else if(e.getDocument().equals(dialog.getShuLiang().getDocument())){
			dialog.getDanJia().setText(String.valueOf(canKaoShouJia*daZhe));
			dialog.getZje().setText(String.valueOf(canKaoShouJia*daZhe*shuLiang));
		}else if(e.getDocument().equals(dialog.getDaZhe().getDocument())){
			dialog.getDanJia().setText(String.valueOf(canKaoShouJia*daZhe));
			dialog.getZje().setText(String.valueOf(canKaoShouJia*daZhe*shuLiang));
		}

	}

	public void removeUpdate(DocumentEvent e) {
		

	}

}
