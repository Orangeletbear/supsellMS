package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.DialogColumnNamesModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;

/**
 * ��Ʒ��Ϣ��������Ʒ���Ի����ϵ�
 * ȷ����ť����Ӧ�ļ�����
 * 
 */
   public class XiaoShouGoodsInfo_SureAction implements ActionListener {
	 //������  
	 private AddXiaoShouGoodsDialog mainDialog;
	private  XiaoShouGoodsInfo dialog;
	
	public XiaoShouGoodsInfo_SureAction(XiaoShouGoodsInfo dialog){
		this.dialog = dialog;
		mainDialog  = dialog.getDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		//���Ҫ�򸸴�����߱�񷵻ص�����
		Vector<String> data  = new Vector<String>();
		
	
		String spName = dialog.getGoodName().getText();
		String danWei = dialog.getDanWei().getText();
		String danJia = dialog.getCanKaoShouJia().getText();
		String daZhe = dialog.getDaZhe().getText();
		String zheHouJia = dialog.getDanJia().getText();
		String shuLiang = dialog.getShuLiang().getText();
		String zje = dialog.getZje().getText();
		String kuCun = dialog.getKuCun().getText();
		
		String canKaoShouJia = dialog.getCanKaoShouJia().getText();
	
		
		if(Float.parseFloat(dialog.getDaZhe().getText())<= 1.0 
				&& Float.parseFloat(shuLiang) < Float.parseFloat(kuCun)){
			data.add(spName);
			data.add(danWei);
			data.add(danJia);
			data.add(daZhe);
			data.add(zheHouJia);
			data.add(shuLiang);
			data.add(zje);
			
		    Vector	data1 =dialog.getDialog().getData();
			data1.add(data);
			
			dialog.getDialog().getSxsp_tableModel().setDataVector(data1, 
					AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
			
			dialog.dispose();
			
		}else if ("".equals(dialog.getDaZhe().getText())||Float.parseFloat(dialog.getDaZhe().getText()) >1.0 
				   ||Float.parseFloat(dialog.getDaZhe().getText()) <=0.0) {
			       JOptionPane.showMessageDialog(dialog, "�����������д�,����������!","ϵͳ��ʾ", 
					       JOptionPane.DEFAULT_OPTION, null);
		}else if ( Float.parseFloat(shuLiang) > Float.parseFloat(kuCun)){
			
			  int n = JOptionPane.showOptionDialog(dialog, "�������С����������������������", "ϵͳ��ʾ", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
		       if(n == JOptionPane.YES_OPTION){
		    	   data.add(spName);
		   		data.add(danWei);
		   		data.add(danJia);
		   		data.add(daZhe);
		   		data.add(zheHouJia);
		   		data.add(shuLiang);
		   		data.add(zje);
		   		
		   	    Vector	data1 =dialog.getDialog().getData();
		   		data1.add(data);
		    	
		    	dialog.getDialog().getSxsp_tableModel().setDataVector(data1, 
						AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
				
				dialog.dispose();
	 
		    }
	
		}
	    //���Ҫ����Ʒ���۶Ի�����з��ص�����
		
		Vector<Object> vector = new Vector<Object>();
		//�����Ʒ���
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				 mainDialog.getSpqdtable().getSelectedRow(), 0));
		//�����Ʒ����
		vector.add(dialog.getGoodName().getText());
		//��ӵ�λ
		vector.add(dialog.getDanWei().getText());
		//��ӹ���ͺ�
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				mainDialog.getSpqdtable().getSelectedRow(), 3));
		//�����ɫ
		vector.add(dialog.getColor().getText());
		
		//��ӵ���
		vector.add(canKaoShouJia);
		//��Ӵ�����
		vector.add(daZhe);
		//����ۺ��
		vector.add(danJia);
		//�������
		vector.add(shuLiang);
		//����ܽ��
		vector.add(zje);

		mainDialog.getMainData().add(vector);
		
		}

}


