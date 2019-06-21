package com.cn.control.kuchunframe.kucundiaobo.chaxun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun.DiaoBoDanChaXunGetDatas;
import com.cn.view.kuchunJFrame.KucunDiaobo;

public class ChaXunDiaoBoMouseListener extends MouseAdapter {
	private KucunDiaobo dialog;
	
	public ChaXunDiaoBoMouseListener(KucunDiaobo dialog) {
		this.dialog = dialog;
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 1){
			int row = dialog.getTableKCDB2().getSelectedRow();
			Vector vo = DiaoBoDanChaXunGetDatas.shangPinChaXun(dialog.getTableKCDB2().getValueAt(row, 0).toString());
			dialog.getTableModel3().setDataVector(vo, dialog.getVe3());
			dialog.getLabelDJXQ().setText(dialog.getTableKCDB2().getValueAt(row, 0).toString());
			dialog.getLabelJLS().setText("" + vo.size());
//			dialog.getTableKCDB3().setRowSelectionInterval(0,0);
		}
	}
}
