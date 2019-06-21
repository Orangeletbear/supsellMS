package com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;

public class BaoZhuangSheZhiActionListener implements ActionListener {
	private ChaifenKunbang dialog;
	public BaoZhuangSheZhiActionListener(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(dialog.getBtnSC() == btn){
			int row = dialog.getTableBZ().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "确定要删除第 " + (row+1) +" 行数据？","删除包装商品",JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					dialog.getTableModelBZ().removeRow(row);	
				}
			}else{
				JOptionPane.showMessageDialog(null, "无包装商品信息！");
			}
		}
	}
}
