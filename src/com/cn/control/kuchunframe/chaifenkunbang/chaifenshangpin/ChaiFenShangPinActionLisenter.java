package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinGetDatas;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.ChaiFenKunBangXinxiJDialg;
/*
 * 拆分商品选项卡监听器
 */
public class ChaiFenShangPinActionLisenter extends MouseAdapter implements ActionListener {
	private ChaifenKunbang dialog;
	
	public ChaiFenShangPinActionLisenter(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		/*
		 *	删除商品
		 */
		if(dialog.getBtnSCSP1() == btn){
			int row = dialog.getTableCF().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "你确定要删除第" + (row+1) + " 行数据？", 
						"删除拆分商品", JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					dialog.getTableModelCF().removeRow(row);
					dialog.getTableCF().setRowSelectionInterval(0, 0);
				}
			}
		}
		if(dialog.getBtnXGSP1() == btn){
			actions();
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			actions();
		}
	}
	
	private void actions(){
		ChaiFenKunBangXinxiJDialg cDialog = new ChaiFenKunBangXinxiJDialg(dialog,"拆分商品信息",true,"0");
		
		/*
		 * 获取选中行的商品信息
		 */
		
		int row = dialog.getTableCF().getSelectedRow();
		int column = dialog.getTableCF().getColumnCount();
		if(row >= 0){
			String []str = new String[column];
			Vector vo = ChaiFenShangPinGetDatas.getSPInof(dialog.getTableCF().getValueAt(row, 0).toString());
			for(int i = 0; i < column; i ++){
				str[i] = dialog.getTableCF().getValueAt(row, i).toString();
			}
//			String cfsl = dialog.getTextCFSL().getText().trim();
			
			cDialog.getLabelSPBH().setText(vo.get(0).toString());
			cDialog.getLabelSPMC().setText(str[0]);
			cDialog.getLabelGGXH().setText(str[2]);
			cDialog.getLabelDW().setText(str[1]);
			cDialog.getLabelSCCS().setText(null);
			cDialog.getLabelYS().setText(str[3]);
			cDialog.getLabelDQKC().setText(vo.get(1).toString());
			
			if(vo.get(2) != null){
				cDialog.getLabelBZ().setText(vo.get(2).toString());
			}else{
				cDialog.getLabelBZ().setText(null);
			}
			cDialog.getTextCFDJ().setText(str[4]);
			cDialog.getTextCFSL().setText(str[5]);
			cDialog.setVisible(true);
		}
	}
}
