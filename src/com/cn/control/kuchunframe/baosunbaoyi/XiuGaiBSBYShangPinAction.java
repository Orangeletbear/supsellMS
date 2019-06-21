package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.kucunDiaobo.XiuGaiShangPinDialog;
/*
 * 弹出修改商品信息的窗口
 */
public class XiuGaiBSBYShangPinAction extends MouseAdapter implements ActionListener {

	private BaosunBaoyi dialog;
	
	public XiuGaiBSBYShangPinAction(BaosunBaoyi dialog) {
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
		int row = dialog.getTableBSBY1().getSelectedRow();
		
		if(row >= 0){
			int column = dialog.getTableBSBY1().getColumnCount();
			
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
