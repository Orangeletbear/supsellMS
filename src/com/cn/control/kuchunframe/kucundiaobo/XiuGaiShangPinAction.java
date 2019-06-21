package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.xiugaishangpin.XiuGaiShangPinDataToView;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.kucunDiaobo.XiuGaiShangPinDialog;

/**
 * 将调拨表中的要修改的数据显示到信息对话框中
 * 
 * @author Administrator
 *
 */
public class XiuGaiShangPinAction extends MouseAdapter implements ActionListener {
	private KucunDiaobo dialog;
	
	public XiuGaiShangPinAction(KucunDiaobo dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
			actions();
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			actions();
		}
	}
	private void actions(){
		
		Vector vo = new Vector();
		int row = dialog.getTableKCDB1().getSelectedRow();
		int column = dialog.getTableKCDB1().getColumnCount();
		if(row >= 0){
			for(int i = 0; i < column; i ++){
				vo.add(dialog.getTableModel1().getValueAt(row, i));
			}
			
			XiuGaiShangPinDialog xDialog = new XiuGaiShangPinDialog(dialog,"修改商品",true);
			
			xDialog.getLabelMC().setText(vo.get(0).toString());
			xDialog.getLabelDW().setText(vo.get(1).toString());
			xDialog.getLabelGGXH().setText(vo.get(2).toString());
			xDialog.getLabelYS().setText(vo.get(3).toString());
			xDialog.getLabelDJ().setText(vo.get(4).toString());
			xDialog.getTextSL().setText(vo.get(5).toString());
			
			xDialog.setVisible(true);
		}
	}
}
