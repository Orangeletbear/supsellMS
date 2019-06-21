package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AlterGoodsDialog;

/**
 * �˿��˻�ѡ��е���Ӱ�ť��������
 * ��Ʒ��Ϣ�Ի����ϵ�ȷ����ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class AlterGoodsSureAction implements ActionListener {

    private AlterGoodsDialog dialog;
    private GuKeTuiHuoDialog mainDialog;
    
    public AlterGoodsSureAction(GuKeTuiHuoDialog mainDialog, AlterGoodsDialog dialog){
    	this.dialog =dialog;
    	this.mainDialog = mainDialog;
    }
	public void actionPerformed(ActionEvent e) {
		
		Object shuLiang = dialog.getShuLiang().getText();
		Object danJia= dialog.getDanJia().getText();

		int row = mainDialog.getTable().getSelectedRow();
		float oldZje = Float.parseFloat(mainDialog.getTableModel().getValueAt(row, 5).toString());
		//�ܽ��
		float zje = Float.parseFloat(shuLiang.toString())*
		               Float.parseFloat(danJia.toString());
		String zj = null;
		if(zje < 10){
			 zj = String.valueOf(zje).substring(0, 3);
		}
		else if(zje < 100){
			 zj = String.valueOf(zje).substring(0, 4);
		}else if(zje<1000){
			zj = String.valueOf(zje).substring(0,5);
		}else if(zje<10000){
			zj = String.valueOf(zje).substring(0,6);
		}
		mainDialog.getTableModel().setValueAt(shuLiang, row, 4);
		mainDialog.getTableModel().setValueAt(danJia, row, 3);
		mainDialog.getTableModel().setValueAt(zj, row, 5);
		float money = 0;
		money = zje +Float.parseFloat(mainDialog.getYingTuiText().getText())-
		    oldZje;
		money = money +0.000001f;
		if(money <100){
			mainDialog.getYingTuiText().setText(String.valueOf(money).substring(0,4));
			mainDialog.getShiTuiText().setText(String.valueOf(money).substring(0,4));
		}else if(money < 1000){
			mainDialog.getYingTuiText().setText(String.valueOf(money).substring(0,5));
			mainDialog.getShiTuiText().setText(String.valueOf(money).substring(0,5));
		}else if(money <10000){
			mainDialog.getYingTuiText().setText(String.valueOf(money).substring(0,6));
			mainDialog.getShiTuiText().setText(String.valueOf(money).substring(0,6));
		}
	
		//�������ڴ������ݺ�ô��ڽ����ͷ�
		dialog.dispose();
	}

}
