package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;
/**
 * ��Ʒ��Ϣ��������Ʒ���Ի���2�е�
 * �����ı�������Ӧ�ļ�����
 * @author Administrator
 *
 */
  public class XiaoShouGoodsInfo2_DocumentListener implements DocumentListener {
	  
	private XiaoShouGoodsInfo2 dialog;
	
	 public XiaoShouGoodsInfo2_DocumentListener( XiaoShouGoodsInfo2 dialog) {
			
			this.dialog = dialog;
		}

		public void changedUpdate(DocumentEvent e) {
		
		}

		
		public void insertUpdate(DocumentEvent e) {
			
			float daZhe = 0;
			float canKaoShouJia = 0;
			float shuLiang = 0;
			if (!dialog.getDaZhe().getText().equals("")){
				daZhe = Float.parseFloat(dialog.getDaZhe().getText().toString());
			}
			if (!dialog.getCanKaoShouJia().getText().equals("")){
				canKaoShouJia = Float.parseFloat(dialog.getCanKaoShouJia().getText().toString());
			}
			if (!dialog.getShuLiang().getText().equals("")){
				shuLiang = Float.parseFloat(dialog.getShuLiang().getText().toString());
			}
			
			
			if(e.getDocument().equals(dialog.getDaZhe().getDocument())){
				dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
				dialog.getDanJia().setText(""+daZhe*canKaoShouJia);
			
			}else if(e.getDocument().equals(dialog.getShuLiang().getDocument())){
				dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
			}else {
				dialog.getZje().setText(""+daZhe*shuLiang*canKaoShouJia);
				dialog.getDanJia().setText(""+daZhe*canKaoShouJia);
				
			}

		}

		
		public void removeUpdate(DocumentEvent e) {
			
		}
	
}
