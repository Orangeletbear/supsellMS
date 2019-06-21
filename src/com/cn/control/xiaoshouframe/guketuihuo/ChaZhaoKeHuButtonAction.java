package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.KeHuWind;


/**
 * 顾客退货对话框上顾客退货选项卡 
 * 上的查找客户按钮所对应的监听器
 * @author Administrator
 *
 */
public class ChaZhaoKeHuButtonAction implements MouseListener {

	private static GuKeTuiHuoDialog dialog;
	 
	public ChaZhaoKeHuButtonAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
	    int y = arg0.getYOnScreen();
	    
	    if(dialog.getTableModel().getRowCount()== 0){
			new KeHuWindow(dialog,true).setLocation(x-190,y-20);
			
		
		}else{
			JOptionPane.showMessageDialog(dialog,
					"退货状态时不能更改客户名称", "系统提示", JOptionPane.DEFAULT_OPTION, null);
		}
	    
		
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(dialog.getTableModel().getRowCount()== 0){
			new KeHuWindow(dialog,true).setLocation(140,130);
			
		
		}else{
			JOptionPane.showMessageDialog(dialog,
					"退货状态时不能更改客户名称", "系统提示", JOptionPane.DEFAULT_OPTION, null);
		}
	}
	public static GuKeTuiHuoDialog getDialog() {
		return dialog;
	}

}
