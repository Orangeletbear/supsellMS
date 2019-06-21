package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin.ChooseShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/*
 * ��Ʒ��Ϣ���ϵ�ȷ����ť
 * 
 */
public class AddShangPinOKAction implements ActionListener {
	private AddShangPinXinXiDialog dialog;
	
	public AddShangPinOKAction(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		//������ݲ�ѯ ֮�������
		dialog.getDialog().getVo3().add(ChooseShangPinDataToView.dataToView(dialog));
		
		//�������õ���������ʾ������
		dialog.getDialog().getTableModel3().setDataVector(dialog.getDialog().getVo3(),
				AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3));
		
		((AddSanPingDialog)dialog.getOwner()).getSxsptable().setRowSelectionInterval(0, 0);
		
		//ȷ��֮�����ʧ�Ի���
		dialog.dispose();
	}
	
}