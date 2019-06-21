package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * ɾ���������е�������
 * 
 */
public class DeleteDiaoBoShangPinAction implements ActionListener {
	private KucunDiaobo dialog;
	
	public DeleteDiaoBoShangPinAction(KucunDiaobo dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		int row = dialog.getTableKCDB1().getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���� " + (1 + row) + " ���ݣ�",
						"ɾ������",JOptionPane.YES_NO_OPTION,1);
		if( choice == JOptionPane.YES_OPTION){
			dialog.getTableModel1().removeRow(row);
			dialog.getTableKCDB1().setRowSelectionInterval(0, 0);
		}
	}
}
