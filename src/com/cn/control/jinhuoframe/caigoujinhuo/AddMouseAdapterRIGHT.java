package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

/**
 * ˫��  ������Ʒ  ���ұ߱�������ݣ������ֵ�����¼�
 * @author Administrator
 */
public class AddMouseAdapterRIGHT extends MouseAdapter{

	private AddShangPingDialog addShang;
	
	
	public AddMouseAdapterRIGHT (AddShangPingDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  ShangPinXinXi2(addShang,"��Ʒ��Ϣ���ɹ�������",true);
			}
		} 

}
