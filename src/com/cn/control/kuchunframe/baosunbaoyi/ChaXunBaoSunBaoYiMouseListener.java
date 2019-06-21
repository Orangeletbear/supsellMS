package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun.BaosunBaoyiChaXunGetDatas;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

public class ChaXunBaoSunBaoYiMouseListener extends MouseAdapter {

	private BaosunBaoyi dialog;
	
	public ChaXunBaoSunBaoYiMouseListener(BaosunBaoyi dialog) {
		this.dialog = dialog;
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 1){
			int row = dialog.getTableBSBY2().getSelectedRow();
			Vector vo = BaosunBaoyiChaXunGetDatas.shangPinChaXun(dialog.getTableBSBY2().getValueAt(row, 0).toString(),
					dialog.getComboDJLX2().getSelectedItem().toString());
			
			dialog.getTableModel3().setDataVector(vo, dialog.getVe3());
			dialog.getLabelDJXX().setText("" + dialog.getTableBSBY2().getValueAt(row, 0));
			dialog.getLabelSPHJ().setText("" + vo.size());
//			dialog.getTableBSBY3().setRowSelectionInterval(0,0);
		}
	}

}
