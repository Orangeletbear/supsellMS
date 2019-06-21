package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import com.cn.model.AllTableModel;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * ����ѡ�����ѡ�������������Ʒ�嵥����ϵ�������ٽ���Ʒ�嵥�е�������ʾ����Ϣ������
 */

//��Ʒѡ��֮�󣬽�����Ʒ��Ϣ�޸�
public class JRSX_XiuGaiShangPinAction  extends MouseAdapter implements ActionListener {
	private AddSanPingDialog dialog;
	
	public JRSX_XiuGaiShangPinAction(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		actions();
	}
	

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			actions();
		}
	}
	
	private void actions(){
		JTable table1 = dialog.getSpqdtable();	
		JTable table2 = dialog.getSxsptable();
		
		int row1 = table1.getRowCount();
		int row3 = table2.getSelectedRow();
		if(row1>=0 && row3 >=0){
			for(int i = 0; i < row1; i ++){
				String name3 = table2.getValueAt(row3, 0).toString();
				String name1 = table1.getValueAt(i, 1).toString();
				
				if(name3.equals(name1)){
					int colunm = dialog.getSpqdtable().getColumnCount();
					
					AllTableModel model = dialog.getTableModel1();
					Object [] str  = new Object[colunm];
					for(int j = 0; j < colunm; j ++){
						str [j] = model.getValueAt(i, j);
						
					}
					
					AddShangPinXinXiDialog xxDialog = null;
			
					//�������
					if(dialog.getCDialog() instanceof ChaifenKunbang){
						if(dialog.getFlag().equals("0")){
							xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(�����Ʒ)",true,1);
						}
						if(dialog.getFlag().equals("1")){
							xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(������Ʒ)",true,1);
						}
					}
					
					//������
					if(dialog.getKDialog() instanceof KucunDiaobo){
						xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(������)",true,1);
					}
					
					//������
					if(dialog.getBDialog() instanceof BaosunBaoyi){
						if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
							xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(��Ʒ����)",true,1);
						}
						if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("��Ʒ����")){
							xxDialog = new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(��Ʒ����)",true,1);
						}
					}
					
					//���������õ���Ϣ��������
					xxDialog.getLabelSPBH().setText(str[0].toString());
					xxDialog.getLabelGGXH().setText(str[3].toString());
					xxDialog.getLabelSCCS().setText(null);
					xxDialog.getLabelDQKC().setText(str[6].toString());
					xxDialog.getLabelSPMC().setText(str[1].toString());
					xxDialog.getLabelDW().setText(str[2].toString());
					xxDialog.getLabelYS().setText(str[4].toString());
					xxDialog.getLabelBZ().setText(null);
					xxDialog.getLabelCBDJ().setText(str[5].toString());
					
					xxDialog.setVisible(true);
				}
			}
		}
	}
	
}
