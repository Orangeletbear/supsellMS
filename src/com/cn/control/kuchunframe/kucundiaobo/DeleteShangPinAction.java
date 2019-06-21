package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * 删除已选择好的表中的商品数据行
 * 
 */
public class DeleteShangPinAction implements ActionListener {
	private KucunDiaobo kDialog;
	private BaosunBaoyi bDialog;
	
	public DeleteShangPinAction(KucunDiaobo dialog) {
		this.kDialog = dialog;
	}
	
	public DeleteShangPinAction(BaosunBaoyi dialog) {
		this.bDialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		//删除库存调拨中的商品数据行
		if(kDialog instanceof KucunDiaobo){
			int row = kDialog.getTableKCDB1().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "确定要删除第 " + (1 + row) + " 数据！",
						"删除数据",JOptionPane.YES_NO_OPTION,1);
				if( choice == JOptionPane.YES_OPTION){
					kDialog.getTableModel1().removeRow(row);
//					kDialog.getTableKCDB1().setRowSelectionInterval(0, 0);
				}
			}
		}
		//删除报损报溢中的商品数据行
		if(bDialog instanceof BaosunBaoyi){
			int row = bDialog.getTableBSBY1().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "确定要删除第 " + (1 + row) + " 数据！",
								"删除数据",JOptionPane.YES_NO_OPTION,1);
				if( choice == JOptionPane.YES_OPTION){
					bDialog.getTableModel1().removeRow(row);
//					bDialog.getTableBSBY1().setRowSelectionInterval(0, 0);
				}
			}
		}
	}
}
