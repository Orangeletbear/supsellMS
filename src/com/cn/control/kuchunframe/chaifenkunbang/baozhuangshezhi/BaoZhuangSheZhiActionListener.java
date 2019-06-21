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
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���� " + (row+1) +" �����ݣ�","ɾ����װ��Ʒ",JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					dialog.getTableModelBZ().removeRow(row);	
				}
			}else{
				JOptionPane.showMessageDialog(null, "�ް�װ��Ʒ��Ϣ��");
			}
		}
	}
}
