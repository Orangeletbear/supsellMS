package com.cn.control.kuchunframe.kucundiaobo.chaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun.GaoJiChaXunDataToView;
import com.cn.view.kuchunJFrame.kucunDiaobo.GaojiChaxunDialog;

/*
 * 高级查询确定按钮监听器，进行条件查询提交
 */
public class GaoJiChaXunOKAction implements ActionListener {
	private GaojiChaxunDialog dialog;
	
	public GaoJiChaXunOKAction(GaojiChaxunDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		Vector vo = GaoJiChaXunDataToView.dataToView(dialog);
		dialog.getDialog().getTableModel2().setDataVector(vo, dialog.getDialog().getVe2());
//		dialog.getDialog().getTableKCDB2().setRowSelectionInterval(0, 0);
		dialog.getDialog().getLabelDJS().setText("" + vo.size());
		dialog.dispose();
	}
}
