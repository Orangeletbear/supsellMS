package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;
/**
 * ˫��������Ʒ����Ʒ���ۣ�
 * �Ի�����߱���Ӧ�ļ�����
 * @author Administrator
 *
 */
public class ClickedAddGoodsAction extends MouseAdapter {

	private AddXiaoShouGoodsDialog addGoods;

	
	public ClickedAddGoodsAction (AddXiaoShouGoodsDialog addGoods){
		this.addGoods = addGoods;
	}
	
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  XiaoShouGoodsInfo(addGoods,"��Ʒ��Ϣ(��Ʒ����)");
				
			}
		} 

}
