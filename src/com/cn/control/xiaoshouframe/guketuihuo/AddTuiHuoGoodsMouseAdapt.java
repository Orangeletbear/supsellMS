package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;

/**
 * �˿��˻�ѡ��е�����˻���Ʒ
 * �Ի����ϵı�����Ӧ������¼���ť
 * @author Administrator
 *
 */
public class AddTuiHuoGoodsMouseAdapt extends MouseAdapter{

	private AddTuiHuoGoodsDialog addShang;

	
	public AddTuiHuoGoodsMouseAdapt (AddTuiHuoGoodsDialog addShang){
		this.addShang = addShang;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  GoodsInfoDialog(addShang,"��Ʒ��Ϣ(�����˻�)");
				
			}
		} 



}
