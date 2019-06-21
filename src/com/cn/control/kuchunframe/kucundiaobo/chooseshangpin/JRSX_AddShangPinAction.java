package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin.JRSX_ShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;
		/*
		 * ������ѡ��Ʒ��ť������
		 * ��ѡ��Ʒ�ı��
		 */
public class JRSX_AddShangPinAction implements ActionListener {
	private AddSanPingDialog dialog;
	public JRSX_AddShangPinAction(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	//��ô���ڱ���׷������
	public void actionPerformed(ActionEvent e) {
		
		/*if(){
			dialog.getVo3().add(JRSX_ShangPinDataToView.dataToView(dialog));
			dialog.getTableModel3().setDataVector(dialog.getVo3(),
					AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3));
		}*/
		
		
		int row = dialog.getSpqdtable().getSelectedRow();
		int column = dialog.getSpqdtable().getColumnCount();
		
		AllTableModel model = dialog.getTableModel1();
		Object [] str  = new Object[column];
		for(int i = 0; i < column; i ++){
			str [i] = model.getValueAt(row, i);
		}
		AddShangPinXinXiDialog xxDialog = 
			new AddShangPinXinXiDialog(dialog,"��Ʒ��Ϣ(������)",true,0);
		//���������õ���Ϣ��������
		xxDialog.getLabelSPBH().setText(str[0].toString());
		xxDialog.getLabelGGXH().setText(str[3].toString());
		xxDialog.getLabelSCCS().setText(null);
		xxDialog.getLabelDQKC().setText(str[6].toString());
		xxDialog.getLabelSPMC().setText(str[1].toString());
		xxDialog.getLabelYS().setText(str[4].toString());
		xxDialog.getLabelBZ().setText(null);
		xxDialog.getLabelCBDJ().setText(str[5].toString());
		
		xxDialog.setVisible(true);
		
		/*
		 * ���ñ���Ĭ��ѡ���� 
		 * ListSelectionModel listSelectionModel = new DefaultListSelectionModel();   
			listSelectionModel .setSelectionInterval(0, 2);   
			table.setSelectionModel(listSelectionModel);   
			listSelectionModel .removeSelectionInterval(1, 1); 
		 */
		
		ListSelectionModel listSelectionModel = new DefaultListSelectionModel(); 
		listSelectionModel .setSelectionInterval(0, 0); 
		dialog.getSxsptable().setSelectionModel(listSelectionModel); 
		
	}
}
