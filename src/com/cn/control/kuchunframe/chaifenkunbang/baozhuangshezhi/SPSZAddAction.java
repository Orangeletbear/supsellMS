package com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.cn.dao.kuchun.chaifenkunbang.baozhuangshezhi.BaoZhuangSheZhiGetdatas;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;

/**
 * 
 * 商品包装设置中的添加按钮
 * @author Administrator
 *
 */
public class SPSZAddAction implements ActionListener {
	private ChaifenKunbang dialog;
	
	public SPSZAddAction(ChaifenKunbang dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == dialog.getBtnZJ()){
			new BaozhuangShezhiJDialog(dialog,"商品包装设置",true,"0").setVisible(true);
		}
		if(btn == dialog.getBtnXG()){
			int row = dialog.getTableBZ().getSelectedRow();
			if(row >= 0){
				BaozhuangShezhiJDialog bz = new BaozhuangShezhiJDialog(dialog,"商品包装设置",true,"1");
				
				String color1 = BaoZhuangSheZhiGetdatas.chaXunXinxi(dialog.getTableBZ().getValueAt(row, 0).toString());
				
				bz.getComboSZCK1().setEnabled(false);
				bz.getTextSPBH1().setText(dialog.getTableBZ().getValueAt(row, 0).toString());
				bz.getTextSPBH1().setEnabled(false);
				bz.getLabelSPName1().setText(dialog.getTableBZ().getValueAt(row, 1).toString());
				bz.getLabelGGXH1().setText(dialog.getTableBZ().getValueAt(row, 2).toString());
				bz.getLabelDW1().setText(dialog.getTableBZ().getValueAt(row, 3).toString());
				bz.getLabelYS1().setText(color1);
				
				String color2 = BaoZhuangSheZhiGetdatas.chaXunXinxi(dialog.getTableBZ().getValueAt(row, 5).toString());
				bz.getComboSZCK2().setEnabled(false);
				bz.getTextSPBH2().setText(dialog.getTableBZ().getValueAt(row, 5).toString());
				bz.getTextSPBH2().setEnabled(false);
				bz.getLabelSPName2().setText(dialog.getTableBZ().getValueAt(row, 6).toString());
				bz.getLabelGGXH2().setText(dialog.getTableBZ().getValueAt(row, 7).toString());
				bz.getLabelDW2().setText(dialog.getTableBZ().getValueAt(row, 8).toString());
				bz.getLabelYS2().setText(color2);
				
				bz.getTextZFBL().setText(dialog.getTableBZ().getValueAt(row, 4).toString());
				
				bz.setVisible(true);
			}
		}
	}
	
	
	
}
