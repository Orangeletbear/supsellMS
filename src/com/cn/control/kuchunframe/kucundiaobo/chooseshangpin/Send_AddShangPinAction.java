package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin.ChooseShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/*
 * ��ѡ�õ���Ʒ���������������
 * ȷ����ť
 */
public class Send_AddShangPinAction implements ActionListener {
	private AddSanPingDialog dialog;
	
	public Send_AddShangPinAction(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
//		dialog.getVo3().add(ChooseShangPinDataToView.dataToView(dialog));
		dialog.getTableModel3().setDataVector(dialog.getVo3(),
				AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3));
		((AddSanPingDialog)dialog.getOwner()).getSxsptable().setRowSelectionInterval(0, 0);
		
		//ȷ��֮�����ʧ�Ի���
		dialog.dispose();
	}
}
