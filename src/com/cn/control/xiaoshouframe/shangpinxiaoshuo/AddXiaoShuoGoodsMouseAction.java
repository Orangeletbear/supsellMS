package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;
/**
 * ������Ʒ����Ʒ���ۣ��Ի�����߱��
 * ˫��ʱ��Ӧ������¼�
 * @author Administrator
 *
 */
public class AddXiaoShuoGoodsMouseAction extends MouseAdapter {
 
	private AddXiaoShouGoodsDialog addGoods;

	public AddXiaoShuoGoodsMouseAction (AddXiaoShouGoodsDialog addGoods){
		this.addGoods = addGoods;
	}
	 
	 public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				new  XiaoShouGoodsInfo2(addGoods,"��Ʒ��Ϣ(��Ʒ����)");
				
			}
		} 
}
