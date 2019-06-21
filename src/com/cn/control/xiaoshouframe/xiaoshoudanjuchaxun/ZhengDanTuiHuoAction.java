package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.cn.model.AllTableModel;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;
/**
 * ���۵��ݶԻ����ϵ�
 * �����˻���ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class ZhengDanTuiHuoAction implements ActionListener {

	private static  DanJuChaXunDialog dialog;
	
	
	public ZhengDanTuiHuoAction(DanJuChaXunDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		
	    Vector data = null;
		JTable table = dialog.getHuiZongTable();
		
		int row = table.getSelectedRow();
		if(row >=0){
			GuKeTuiHuoDialog guKeDialog = new GuKeTuiHuoDialog(dialog,"�˿��˻�",true,true);
		
			String keHuName = (String) dialog.getTabelModel().getValueAt(row,2);
			guKeDialog.getKeHuText1().setText(keHuName);
			
			guKeDialog.getYingTuiText().setText(
					 dialog.getTabelModel().getValueAt(row,4).toString());
			guKeDialog.getShiTuiText().setText(
					 dialog.getTabelModel().getValueAt(row,4).toString());
			guKeDialog.getJingBanBox().setSelectedItem(
					 dialog.getTabelModel().getValueAt(row,10));
			guKeDialog.setVisible(true);
		
		
		}

	}
	public static DanJuChaXunDialog getDialog() {
		return dialog;
	}

}
