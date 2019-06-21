package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * ɾ������
 * @author Administrator
 *
 */
public class DeleteShangPinAction implements ActionListener {
	
	private AddSanPingDialog dialog;
	
	public DeleteShangPinAction(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		JTable table = dialog.getSxsptable();
		int row = table.getSelectedRow();
		if(row >= 0){
			int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ�����еĵ� " + (1+row) + " ������" ,
					"ɾ������", JOptionPane.YES_NO_OPTION,1);
			
			if( i == JOptionPane.YES_OPTION){
				dialog.getTableModel3().removeRow(row);
//				dialog.getSxsptable().setRowSelectionInterval(0, 0);
			}
		}
	}
}
