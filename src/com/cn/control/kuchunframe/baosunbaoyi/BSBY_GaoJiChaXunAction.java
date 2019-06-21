package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun.BaosunBaoyiChaXunGetDatas;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.BSBYModel;
import com.cn.view.kuchunJFrame.baosunbaoyi.BSBY_GaoJiChaXunDialog;

public class BSBY_GaoJiChaXunAction implements ActionListener {
	private  BSBY_GaoJiChaXunDialog dialog;
	
	public BSBY_GaoJiChaXunAction(BSBY_GaoJiChaXunDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		Vector vo = BaosunBaoyiChaXunGetDatas.createSQL(dialog.getComboCK().getSelectedItem().toString(),
				dialog.getComboJBR().getSelectedItem().toString(),
				dialog.getDialog().getComboDJLX2().getSelectedItem().toString());
		if(dialog.getDialog().getComboDJLX2().getSelectedItem().toString().equals("商品报损")){
			dialog.getDialog().getTableModel2().setDataVector(vo, 
					AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY2));
		}
		if(dialog.getDialog().getComboDJLX2().getSelectedItem().toString().equals("商品报溢")){
			dialog.getDialog().getTableModel2().setDataVector(vo, 
					AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY4));
		}
		
//		dialog.getDialog().getTableBSBY2().setRowSelectionInterval(0, 0);//默认选中行数
		dialog.getDialog().getLabelDJHJ().setText("" + vo.size());
		dialog.dispose();
	}
}
