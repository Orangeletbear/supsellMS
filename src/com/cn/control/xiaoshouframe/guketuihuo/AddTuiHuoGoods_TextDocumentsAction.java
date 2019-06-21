package com.cn.control.xiaoshouframe.guketuihuo;

import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.jinhuo.AddSanPingCulomns;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;

public class AddTuiHuoGoods_TextDocumentsAction implements DocumentListener {

	private GuKeTuiHuoDialog mainDialog ;
	private AddTuiHuoGoodsDialog dialog;

	public AddTuiHuoGoods_TextDocumentsAction(AddTuiHuoGoodsDialog dialog){
		this.dialog = dialog;
	}
	public void changedUpdate(DocumentEvent e) {
		
	}

	
	public void insertUpdate(DocumentEvent e) {
		  Vector data  = null;
	  	mainDialog = dialog.getMaindialog();
		  String khName = mainDialog.getKeHuText1().getText();
		  String spId = dialog.getSpbhfield().getText();
		  data = JDBCDanJuFind.getGoodsData2(khName,spId);
		  System.out.println(data);
		System.out.println("222");
		  if(data.size() > 0){
			  dialog.getSpqd_tableModel().setDataVector(data,
						AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1));
			  dialog.getSpqdtable().requestFocus();
			  dialog.getSpqdtable().setRowSelectionInterval(0, 0);
		  }else{
			  dialog.getSpqd_tableModel().setDataVector(data,
						AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1));
		  }
	}


	public void removeUpdate(DocumentEvent e) {
		
	}

}
