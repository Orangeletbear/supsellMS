package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.xiugaishangpin.XiuGaiShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.kucunDiaobo.XiuGaiShangPinDialog;

public class XiuGaiShangPinOKAction implements ActionListener {
	private XiuGaiShangPinDialog dialog;
	
	public XiuGaiShangPinOKAction(XiuGaiShangPinDialog dialog) {
		this.dialog  = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		String name = dialog.getLabelMC().getText();
		String num = dialog.getTextSL().getText();
		
		Vector vo = XiuGaiShangPinDataToView.dataToview(name,num);
		
		KucunDiaobo kDialog = (KucunDiaobo)dialog.getOwner();
		kDialog.getTableModel1().setDataVector(vo, 
				AllTableModel.getVectorFromObj(KCDBModel.colunmsKCDB1));
		kDialog.getTableKCDB1().setRowSelectionInterval(0, 0);
		
	}
}
