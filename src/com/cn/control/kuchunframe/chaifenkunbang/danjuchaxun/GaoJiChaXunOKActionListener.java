package com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.CFKB_ChaXunGetDatas;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.CFKBModel;
import com.cn.view.kuchunJFrame.chaifenkunbang.CFGaojiChaxunJDialog;

/**
 * 高级查询确定按钮
 * 
 */
public class GaoJiChaXunOKActionListener implements ActionListener {
	private CFGaojiChaxunJDialog dialog;
	public GaoJiChaXunOKActionListener(CFGaojiChaxunJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		Vector vo = new Vector();
		vo = CFKB_ChaXunGetDatas.gaojiChaXun(dialog.getComboCFCK().getSelectedItem().toString(), 
				dialog.getComboJBR().getSelectedItem().toString(), 
				dialog.getDialog().getComboDJLX().getSelectedItem().toString());
		
		if(dialog.getDialog().getComboDJLX().getSelectedItem().toString().equals("商品拆分")){
			dialog.getDialog().getTableModel4().setDataVector(vo, 
					AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB4));
		}
		if(dialog.getDialog().getComboDJLX().getSelectedItem().toString().equals("商品捆绑")){
			dialog.getDialog().getTableModel4().setDataVector(vo, 
					AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB6));
		}
		
		dialog.getDialog().getLabelDJHJ().setText("" +  vo.size());
		dialog.dispose();
	}
}
