package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AlterGoodsDialog;

/**
 * 顾客退货选项卡中的添加按钮所弹出的
 * 商品信息对话框上的确定按钮所对应的监听器
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
		//总金额
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
	
		//向主窗口传完数据后该窗口将被释放
		dialog.dispose();
	}

}
