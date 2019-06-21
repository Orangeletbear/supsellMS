package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * 
 * ͨ��������Ϣ��˫�������������Ϣ���ڣ�
 * @author Administrator
 *
 */
public class AddShangPinMouseListener extends MouseAdapter implements ActionListener{
	private AddSanPingDialog dialog;
	
	public AddShangPinMouseListener(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			actions();
		}
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(dialog.getAddBtn() == btn){
			actions();
		}
//		if(dialog.getAterBtn() == btn){
//			
//		}
//		if(dialog.getAterBtn() == btn){
//			
//		}
		
	}
	private void actions(){
		int row = dialog.getSpqdtable().getSelectedRow();
		
		if(dialog.getVo3().size() > 0){
			for(int j = 0; j < dialog.getTableModel3().getRowCount(); j ++){
				if(dialog.getSpqdtable().getValueAt(row, 1).equals(dialog.getSxsptable().getValueAt(j, 0))){
					JOptionPane.showMessageDialog(null, "����Ʒ����ѡ���б��У������޸��뵥�����·����޸İ�ť��");
					break;
				} 
				if(j == dialog.getTableModel3().getRowCount()-1){
					son();
					break;
				}
			}
		}else{
			son();
		}
	}
	private void son(){
		int row = dialog.getSpqdtable().getSelectedRow();
		if(row >= 0){
			int column = dialog.getSpqdtable().getColumnCount();
			///////////////�������Ʒû����ӣ��� �������²���//////////////��ʱ��Ҫ��ȡ��������
			AllTableModel model = dialog.getTableModel1();
			Object [] str  = new Object[column];
			for(int i = 0; i < column; i ++){
				str [i] = model.getValueAt(row, i);
			}
			
			AddShangPinXinXiDialog xxDialog = null;
			if(dialog.getCDialog() instanceof ChaifenKunbang){
				if(dialog.getFlag().equals("0")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(�����Ʒ)",true,0);
				}
				if(dialog.getFlag().equals("1")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(������Ʒ)",true,0);
				}
			}
			if(dialog.getKDialog() instanceof KucunDiaobo){
				xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(������)",true,0);
			}
			if(dialog.getBDialog() instanceof BaosunBaoyi){
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(��Ʒ����)",true,0);
				}
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(��Ʒ����)",true,0);
				}
			}

			//���������õ���Ϣ��������
			xxDialog.getLabelSPBH().setText(str[0].toString());
			xxDialog.getLabelGGXH().setText(str[3].toString());
			xxDialog.getLabelDW().setText(str[2].toString());
			xxDialog.getLabelSCCS().setText(null);
			xxDialog.getLabelDQKC().setText(str[6].toString());
			xxDialog.getLabelSPMC().setText(str[1].toString());
			xxDialog.getLabelYS().setText(str[4].toString());
			xxDialog.getLabelBZ().setText(null);
			xxDialog.getLabelCBDJ().setText(str[5].toString());
			
			xxDialog.setVisible(true);
		}
	}
}
