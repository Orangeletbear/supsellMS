package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;

/**
 * ˫��  ������Ʒ  ����߱�������ݣ������ֵ�����¼�
 * @author Administrator
 */
public class AddShangPinMouseAdapt extends MouseAdapter{

	private AddShangPingDialog addShang;
	
	
	public AddShangPinMouseAdapt (AddShangPingDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  ShangPinXinXi(addShang,"��Ʒ��Ϣ���ɹ�������",true);
			}
		} 

}
