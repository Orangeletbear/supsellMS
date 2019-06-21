package com.cn.control.kuchunframe.kucunpandian.xinzengshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.view.kuchunJFrame.KucunPandian;
import com.cn.view.kuchunJFrame.kucunpandian.PanDianShangPinXiuGaiWindow;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;
/**
 * 盘点商品信息选择和修改窗口上的确定按钮，将已选的商品传到已盘列表
 * @author Administrator
 *
 */
public class PanDianXinxiXiugaiOKAction implements ActionListener {
	
	private PanDianShangPinXiuGaiWindow win;
	public PanDianXinxiXiugaiOKAction(PanDianShangPinXiuGaiWindow win) {
		this.win = win;
	}
	public void actionPerformed(ActionEvent e) {
		Vector vo = new Vector();
		Vector tmp = new Vector();
		tmp.add(win.getLabelBH().getText().trim());
		tmp.add(win.getLabelMC().getText().trim());
		tmp.add(win.getLabelDW().getText().trim());
		tmp.add(win.getLabelXH().getText().trim());
		tmp.add(win.getLabelKC().getText().trim());
		tmp.add(win.getTextSL().getText().trim());
//		vo.add(tmp);
		
		if(win.getKDialog() instanceof KucunPandian){
			int column = win.getKDialog().getTablemodelPD2().getColumnCount();
			int row = win.getKDialog().getTablePD2().getSelectedRow();
			if(row >= 0){
				win.getKDialog().getTablemodelPD2().setValueAt(tmp.get(5),row, 7);
			}
		}
		
		if(win.getDialog() instanceof XinZengPanDianDanJDialog){
			if(win.getFlag() == 1){
				int column = win.getDialog().getTableYPSP().getColumnCount();
				int row = win.getDialog().getTableYPSP().getSelectedRow();
				if(row >= 0){
					for(int i = 0; i < column; i ++){
						win.getDialog().getTableModelYPSP().setValueAt(tmp.get(i),row, i);
					}
				}
			}else if(win.getFlag() == 0){
				win.getDialog().getVoYPSP().add(tmp);
				win.getDialog().getTableModelYPSP().setDataVector(win.getDialog().getVoYPSP(), win.getDialog().getVeYPSP());
				win.getDialog().getTableYPSP().setRowSelectionInterval(0, 0);
			}
		}
		win.dispose();
	}
}
