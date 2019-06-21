package com.cn.control.kuchunframe.kucunpandian.xinzengshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.kucunpandian.PanDianShangPinXiuGaiWindow;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;
/**
 * ���̵���Ʒ�б���޸ģ�ɾ���Լ�����˫���޸� ����
 * 
 * 
 * @author Administrator
 *
 */
public class YiPanShangPinMouseActionListener extends MouseAdapter implements ActionListener {

	private XinZengPanDianDanJDialog dialog;
	public YiPanShangPinMouseActionListener(XinZengPanDianDanJDialog dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		/*
		 * �޸���Ʒ
		 */
		if(btn == dialog.getBtnXG()){
			actions();
		}
		/*
		 * ɾ����Ʒ
		 */
		if(btn == dialog.getBtnSC()){
			int row = dialog.getTableYPSP().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���� "+ (row + 1) + "  ������",
						"ɾ������", JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					dialog.getTableModelYPSP().removeRow(row);
				}
			}
		}
	}
	//˫�������б��޸���Ʒ
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			actions();
		}
	}
	
	private void actions(){
		int row = dialog.getTableYPSP().getSelectedRow();
		if(row >= 0){
			PanDianShangPinXiuGaiWindow win = new PanDianShangPinXiuGaiWindow(dialog,1);
			
			win.getLabelBH().setText(dialog.getTableYPSP().getValueAt(row,0).toString());
			win.getLabelMC().setText(dialog.getTableYPSP().getValueAt(row,1).toString());
			win.getLabelKC().setText(dialog.getTableYPSP().getValueAt(row,4).toString());
			win.getLabelXH().setText(dialog.getTableYPSP().getValueAt(row,3).toString());
			win.getLabelDW().setText(dialog.getTableYPSP().getValueAt(row,2).toString());
			win.getTextSL().setText(dialog.getTableYPSP().getValueAt(row,5).toString());
			
			win.setVisible(true);
		}
	}
}
