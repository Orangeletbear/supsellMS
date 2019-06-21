package com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin;

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
 * ������Ʒѡ� �ļ�����
 */
public class KunBangShangPinActionListener  extends MouseAdapter implements ActionListener {

	private ChaifenKunbang dialog;
	
	public KunBangShangPinActionListener(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		/*
		 * ɾ����Ʒ
		 */
		if(dialog.getBtnSCSP2() == btn){
			int row = dialog.getTableKB().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ����" + (row + 1) + " �����ݣ�", 
						"ɾ�������Ʒ", JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					dialog.getTableModelKB().removeRow(row);
//					dialog.getTableKB().setRowSelectionInterval(0, 0);
				}
			}
		}
		if(dialog.getBtnXGSP2() == btn){
			actions();
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			actions();
		}
	}
	
	private void actions(){
		ChaiFenKunBangXinxiJDialg cDialog = new ChaiFenKunBangXinxiJDialg(dialog,"������Ʒ��Ϣ",true,"1");
		
		/*
		 * ��ȡѡ���е���Ʒ��Ϣ
		 */
		
		int row = dialog.getTableKB().getSelectedRow();
		int column = dialog.getTableKB().getColumnCount();
		if(row >= 0){
			String []str = new String[column];
			Vector vo = ChaiFenShangPinGetDatas.getSPInof(dialog.getTableKB().getValueAt(row, 0).toString());
			for(int i = 0; i < column; i ++){
				str[i] = dialog.getTableKB().getValueAt(row, i).toString();
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
