package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfo2Dialog;

public class GoodsInfo2SureAction implements ActionListener {

	public AddTuiHuoGoodsDialog mainDialog;
	
	public GoodsInfo2Dialog dialog;
	
	public GoodsInfo2SureAction(AddTuiHuoGoodsDialog mainDialog,GoodsInfo2Dialog dialog){
		this.mainDialog = mainDialog;
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		int row = mainDialog.getSxsptable().getSelectedRow();
		String shuLiang = dialog.getShuLiang().getText();
		String danJia = dialog.getDanJia().getText();
		
		String zje = String.valueOf(Float.parseFloat(shuLiang)*Float.parseFloat(danJia));
		mainDialog.getSxsp_tableModel().setValueAt(danJia, row, 2);
		mainDialog.getSxsp_tableModel().setValueAt(shuLiang, row, 3);
        
		dialog.dispose();
		    
	
	     
	}

}
