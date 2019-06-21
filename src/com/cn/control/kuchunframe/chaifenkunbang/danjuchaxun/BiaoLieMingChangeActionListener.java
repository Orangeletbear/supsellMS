package com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.model.AllTableModel;
import com.cn.model.kuchun.CFKBModel;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

/**
 * 改变拆分捆绑查询的列表名称
 * 
 */
public class BiaoLieMingChangeActionListener implements ActionListener {
	private ChaifenKunbang dialog;
	public BiaoLieMingChangeActionListener(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		if(dialog.getComboDJLX().getSelectedItem().toString().equals("商品拆分")){
			Vector vo = dialog.setVe4();
			vo = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB4);
			dialog.getTableModel4().setColumnIdentifiers(vo);
		}
		if(dialog.getComboDJLX().getSelectedItem().toString().equals("商品捆绑")){
			Vector vo = dialog.setVe4();
			vo = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB6);
			dialog.getTableModel4().setColumnIdentifiers(vo);
		}
	}
}
