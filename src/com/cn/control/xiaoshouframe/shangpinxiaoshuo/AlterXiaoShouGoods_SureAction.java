package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AlterXiaoShouGoodsDialog;
/**
 * ˫����Ʒ���۶Ի����������ֵ�
 * �޸���Ʒ�Ի����ϵ�ȷ����ť����Ӧ�ļ�����
 */
public class AlterXiaoShouGoods_SureAction implements ActionListener {

	private ShangPinXiaoShouDialog mainDialog;
	private AlterXiaoShouGoodsDialog dialog;
	
	public AlterXiaoShouGoods_SureAction( AlterXiaoShouGoodsDialog dialog){
		this.dialog = dialog;
		this.mainDialog = dialog.getDialog();
	}
	public void actionPerformed(ActionEvent e) {
		//��ȡ�����ڱ��б�ѡ�е���
		int row = mainDialog.getTable().getSelectedRow();
		AllTableModel model = mainDialog.getTableModel();
	
		String daZhe = dialog.getDaZhe().getText();
		String canKaoShouJia = dialog.getCanKaoShouJia().getText();
		String shuLiang = dialog.getShuLiang().getText();
		String danJia = dialog.getDanJia().getText();
		String zje = dialog.getZje().getText();
        String kuCun = dialog.getKuCun().getText();
    	float oldZje = Float.parseFloat(mainDialog.getTableModel().getValueAt(row,9).toString());
        float money = 0;
		money = Float.parseFloat(zje) +Float.parseFloat(mainDialog.getYingShouText().getText())-oldZje;
		money = money +0.000001f;
		if(money <100){
			mainDialog.getYingShouText().setText(String.valueOf(money).substring(0,4));
			mainDialog.getShiShouText().setText(String.valueOf(money).substring(0,4));
		}else if(money < 1000){
			mainDialog.getYingShouText().setText(String.valueOf(money).substring(0,5));
			mainDialog.getShiShouText().setText(String.valueOf(money).substring(0,5));
		}else if(money <10000){
			mainDialog.getYingShouText().setText(String.valueOf(money).substring(0,6));
			mainDialog.getShiShouText().setText(String.valueOf(money).substring(0,6));
		}
		if(Float.parseFloat(dialog.getDaZhe().getText())<= 1.0 
				&& Float.parseFloat(shuLiang) < Float.parseFloat(kuCun)){
			
			model.setValueAt(canKaoShouJia, row, 5);
			model.setValueAt(daZhe, row, 6);
		    model.setValueAt(danJia, row, 7);
			model.setValueAt(shuLiang, row, 8);
			model.setValueAt(zje, row, 9);
			
			dialog.dispose();
			
		}else if (Float.parseFloat(dialog.getDaZhe().getText()) >1.0 ) {
			       JOptionPane.showMessageDialog(dialog, "�����������д�,����������!","ϵͳ��ʾ", 
					       JOptionPane.DEFAULT_OPTION, null);
		}else if ( Float.parseFloat(shuLiang) > Float.parseFloat(kuCun)){
			
			  int n = JOptionPane.showOptionDialog(dialog, "�������С����������������������", "ϵͳ��ʾ", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
		       if(n == JOptionPane.YES_OPTION){
		    		
		   		model.setValueAt(canKaoShouJia, row, 5);
		   		model.setValueAt(daZhe, row, 6);
		   	    model.setValueAt(danJia, row, 7);
		   		model.setValueAt(shuLiang, row, 8);
		   		model.setValueAt(zje, row, 9);
		   		
		   		dialog.dispose();
		  
		    }
	
		}
	}

}
