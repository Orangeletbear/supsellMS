package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun.BSBY_TimeChaXunDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.BSBYModel;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

public class BSBY_TimeChaXunAction implements ActionListener {
	private BaosunBaoyi dialog;
	
	public BSBY_TimeChaXunAction(BaosunBaoyi dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		Vector vo = BSBY_TimeChaXunDataToView.dataToView(dialog);
		
		if(dialog.getComboDJLX2().getSelectedItem().toString().equals("商品报损")){
			dialog.getTableModel2().setDataVector(vo, 
					AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY2));
		}
		if(dialog.getComboDJLX2().getSelectedItem().toString().equals("商品报溢")){
			dialog.getTableModel2().setDataVector(vo, 
					AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY4));
		}
		dialog.getLabelDJHJ().setText("" + vo.size());
//		dialog.getTableBSBY2().setRowSelectionInterval(0, 0);
	}
}
