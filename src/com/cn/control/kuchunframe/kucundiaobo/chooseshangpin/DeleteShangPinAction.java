package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 删除数据
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
			int i = JOptionPane.showConfirmDialog(null,"确定要删除表中的第 " + (1+row) + " 数据吗？" ,
					"删除数据", JOptionPane.YES_NO_OPTION,1);
			
			if( i == JOptionPane.YES_OPTION){
				dialog.getTableModel3().removeRow(row);
//				dialog.getSxsptable().setRowSelectionInterval(0, 0);
			}
		}
	}
}
