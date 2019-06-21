package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

public class MouseListe extends MouseAdapter {
	
    private DanJuChaXunDialog dialog;

	public MouseListe(DanJuChaXunDialog dialog,int row) {
		this.dialog = dialog;
	}
	
	
	public void mouseClicked(MouseEvent e) {
		Vector data = null;
		
		
		//左键
		if(e.getButton() == 1) {
			int i = dialog.getHuiZongTable().getSelectedRow();
			String danHao = (String) dialog.getTabelModel().getValueAt(i,0);
			JLabel label = dialog.getShangPinMingXiLabel();
			label.setText(danHao+"         "+(String) dialog.getTabelModel().getValueAt(i,2));
			label.setForeground(Color.RED);
			data = JDBCDanJuFind.getDate(danHao);	

			dialog.getTabelModel2().setDataVector(data,
					AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
	        
		}
	    //右键
		if(e.getButton() == 3) {
			JPopupMenu menu = new JPopupMenu();
			JMenuItem item = new JMenuItem("整单退货(Z)");
			menu.add(item);
			int x = e.getX();
			int y = e.getY();
			menu.show(dialog,x,y+180);
			item.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					GuKeTuiHuoDialog guKeDialog = new GuKeTuiHuoDialog(dialog,"顾客退货",true,true);
					int row = dialog.getHuiZongTable().getSelectedRow();
					String keHuName = (String) dialog.getTabelModel().getValueAt(row,2);
					guKeDialog.getKeHuText1().setText(keHuName);
					
					guKeDialog.getYingTuiText().setText(
							 dialog.getTabelModel().getValueAt(row,4).toString());
					guKeDialog.getShiTuiText().setText(
							 dialog.getTabelModel().getValueAt(row,4).toString());
					guKeDialog.getJingBanBox().setSelectedItem(
							 dialog.getTabelModel().getValueAt(row,10));
					guKeDialog.setVisible(true);
					
				}
				
			});
			
			
		}
		
	} 
}
