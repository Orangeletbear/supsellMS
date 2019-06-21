package com.cn.control.kuchunframe.kucunpandian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.KucunPandian;
import com.cn.view.kuchunJFrame.kucunpandian.PanDianShangPinXiuGaiWindow;
import com.cn.view.kuchunJFrame.kucunpandian.PanYingPanKuiJDialog;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;

public class PanDianZhuJieMianAction extends MouseAdapter implements ActionListener {
	private KucunPandian dialog;
	public PanDianZhuJieMianAction(KucunPandian dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		//ɾ���̵㵥
		if(dialog.getBtnSCPDD() == btn){
			int row = dialog.getTablePD1().getSelectedRow();
			if(row >= 0){
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���� " + (row+1) + "���ݣ�", 
						"ɾ���̵㵥", JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
//					dialog.getTablePD1().remove(row);
					KunCunPanDianChaXunGetDatas.deletePanDianDan(dialog.getTablePD1().getValueAt(row, 0).toString());
					
					/*
					 * ����ɾ��֮����̵㵥�б�
					 */
					Vector vo = KunCunPanDianChaXunGetDatas.panDianDanjuChaXun(dialog.getLabelPDDH().getText().trim());
					dialog.getTablemodelPD1().setDataVector(vo, dialog.getVe1());
					dialog.getLabelHJ1().setText("" + vo.size());
				}	
			}
		}
		
		//ɾ���̵���Ʒ
		if(dialog.getBtnSCSP() == btn){
			int row1 = dialog.getTablePD1().getSelectedRow();
			int row2 = dialog.getTablePD2().getSelectedRow();
			if(row1 >= 0 && row2 >= 0  ){
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���� " + (row2+1) + "���ݣ�", 
						"ɾ���̵���Ʒ", JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					KunCunPanDianChaXunGetDatas.deleteShangPin(dialog.getTablePD2().getValueAt(row2, 0).toString(),
							dialog.getTablePD1().getValueAt(row1, 0).toString());
					
					/*
					 * ����ɾ����Ʒ֮��ı��
					 */
					int row = dialog.getTablePD1().getSelectedRow();
					Vector vo = KunCunPanDianChaXunGetDatas.shangPinChaXun(
							dialog.getTablePD1().getValueAt(row, 0).toString());
					dialog.getTablemodelPD2().setDataVector(vo, dialog.getVe2());
					dialog.getLabelPDDH().setText(dialog.getTablePD1().getValueAt(row, 0).toString());
					dialog.getLabelHJ2().setText("" );
					
				}
			}
		}
		
		//�����̵���Ʒ
		if(dialog.getBtnXZSP() == btn){
			int row = dialog.getTablePD1().getSelectedRow();
			if(row >= 0){
				XinZengPanDianDanJDialog xzDialog = new XinZengPanDianDanJDialog(dialog,"�޸��̵���Ʒ",true);
				Vector vo = KunCunPanDianChaXunGetDatas.xiugaiShangPinChaXun(dialog.getTablePD1().getValueAt(row, 0).toString());
				xzDialog.getTableModelYPSP().setDataVector(vo, xzDialog.getVeYPSP());
//				xzDialog.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "δѡ���̵㵥��");
			}
		}
		//�޸��̵���Ʒ��Ϣ
		if(dialog.getBtnXGSP() == btn){
			actions();
		}
		
		//��ʼ�̵�
		if(dialog.getBtnKSPD() == btn){
			int row = dialog.getTablePD1().getRowCount();
			
			if(row > 0){
				PanYingPanKuiJDialog pDialog = new PanYingPanKuiJDialog(dialog,"��ӯ�̿�",true);
				////��ʼ����һ������
				
				Vector pdvo = new Vector();
				
				int culomns = dialog.getTablePD1().getColumnCount();
				for(int i = 0;i<row;i++){
				    Vector tmpvo = new Vector();
					for(int j = 0;j<culomns;j++){
						tmpvo.add(dialog.getTablemodelPD1().getValueAt(i, j));
						
					}
					pdvo.add(tmpvo);
				}
				pDialog.getTablemodel1().setDataVector(pdvo, pDialog.getVe1());
				pDialog.getLabelPDDS().setText("��ѡ����" + pdvo.size() + "�̵㵥");
				
				pDialog.setVisible(true);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			actions();
		}
	}

	/*
	 * �޸��̵���Ʒ���ô��뷽��
	 */
	private void actions(){
		int row = dialog.getTablePD2().getSelectedRow();
		if(row >= 0){
			PanDianShangPinXiuGaiWindow win = new PanDianShangPinXiuGaiWindow(dialog);
			
			win.getLabelBH().setText(dialog.getTablePD2().getValueAt(row,0).toString());
			win.getLabelMC().setText(dialog.getTablePD2().getValueAt(row,1).toString());
			win.getLabelKC().setText(dialog.getTablePD2().getValueAt(row,6).toString());
			win.getLabelXH().setText(dialog.getTablePD2().getValueAt(row,4).toString());
			win.getLabelDW().setText(dialog.getTablePD2().getValueAt(row,3).toString());
			win.getTextSL().setText(dialog.getTablePD2().getValueAt(row,7).toString());
			
			win.setVisible(true);
		}
	}
}
