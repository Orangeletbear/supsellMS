package com.cn.control.kuchunframe.kucunpandian.xinzengshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.cn.view.kuchunJFrame.kucunpandian.PanDianShangPinXiuGaiWindow;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;
/**
 * 将选择的商品信息显示在弹出窗口上
 * @author Administrator
 *
 */
public class PanDianXinxiXiugaiMouseAction extends MouseAdapter implements ActionListener {
	private XinZengPanDianDanJDialog dialog;
//	private XiuGaiPanDianDanJDialog xgDdialog;
	
	public PanDianXinxiXiugaiMouseAction(XinZengPanDianDanJDialog dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		panDuan();
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			panDuan();
		}
	}
	
	/*
	 * 判断是否已经添加该商品
	 */
	private void panDuan(){
		int row = dialog.getTableSPQD().getSelectedRow();
		
		if(dialog.getVoYPSP().size() > 0){
			for(int j = 0; j < dialog.getTableModelYPSP().getRowCount(); j ++){
				if(dialog.getTableModelSPQD().getValueAt(row,0).toString().equals(
						dialog.getTableModelYPSP().getValueAt(j, 0).toString())){
					JOptionPane.showMessageDialog(null, "该商品已在选择列表中，如需修改请单击右下方的修改按钮！");
					break;
				} 
				
				if(j == dialog.getTableModelYPSP().getRowCount()-1){
					actions();
					break;
				}
			}
		}else{
			actions();
		}
	}
	private void actions(){
		int row = dialog.getTableSPQD().getSelectedRow();
		if(row >= 0){
			PanDianShangPinXiuGaiWindow win = new PanDianShangPinXiuGaiWindow(dialog,0);
			
			win.getLabelBH().setText(dialog.getTableSPQD().getValueAt(row, 0).toString());
			win.getLabelMC().setText(dialog.getTableSPQD().getValueAt(row, 1).toString());
			win.getLabelKC().setText(dialog.getTableSPQD().getValueAt(row, 4).toString());
			win.getLabelXH().setText(dialog.getTableSPQD().getValueAt(row, 3).toString());
			win.getLabelDW().setText(dialog.getTableSPQD().getValueAt(row, 2).toString());
			
			win.setVisible(true);
		}
	}
}
