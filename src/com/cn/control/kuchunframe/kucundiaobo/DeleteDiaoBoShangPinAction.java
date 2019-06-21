package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * 删除调拨表中的数据行
 * 
 */
public class DeleteDiaoBoShangPinAction implements ActionListener {
	private KucunDiaobo dialog;
	
	public DeleteDiaoBoShangPinAction(KucunDiaobo dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		int row = dialog.getTableKCDB1().getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(null, "确定要删除第 " + (1 + row) + " 数据！",
						"删除数据",JOptionPane.YES_NO_OPTION,1);
		if( choice == JOptionPane.YES_OPTION){
			dialog.getTableModel1().removeRow(row);
			dialog.getTableKCDB1().setRowSelectionInterval(0, 0);
		}
	}
}
