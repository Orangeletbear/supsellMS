package com.cn.control.jinhuoframe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;

/**
 * ������Ʒ���ɹ������������������������mouse�¼�
 * 
 * @author Administrator
 *
 */
public class ShangPinXinXiMouseAdapt extends MouseAdapter {
	AddShangPingDialog dialog;
	
	public ShangPinXinXiMouseAdapt(AddShangPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			int tmp = dialog.getSplbtable().getSelectedRow();
			String spID = (String)dialog.getATM().getValueAt(tmp, 0);
			new  ShangPinXinXi(dialog,"��Ʒ��Ϣ���ɹ�������",true);
		}
	} 

}
