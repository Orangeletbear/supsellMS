package com.cn.control.kuchunframe.kucundiaobo.chaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun.TimeChaXunDataToView;
import com.cn.view.kuchunJFrame.KucunDiaobo;

public class TimeChaXunAction implements ActionListener {
	private KucunDiaobo dialog;
	
	public TimeChaXunAction(KucunDiaobo dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		
		Vector data = TimeChaXunDataToView.dataToView(dialog);
		dialog.getTableModel2().setDataVector(data, dialog.getVe2());
		
		dialog.getLabelDJS().setText("" + data.size());
		
//		dialog.getTableKCDB2().setRowSelectionInterval(0, 0);
	}
}
