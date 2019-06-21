package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.view.kuchunJFrame.chaifenkunbang.ChaiFenKunBangXinxiJDialg;

/*
 * 确认后将修改后的信息设置到表中
 */
public class ChaiFenKunBangXinXiOKBtnAction implements ActionListener {
	private ChaiFenKunBangXinxiJDialg dialog;
	
	public ChaiFenKunBangXinXiOKBtnAction(ChaiFenKunBangXinxiJDialg dialog){
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * 往表中设置信息
		 */
		if(dialog.getFlag().equals("0")){
			int column = dialog.getDialog().getTableCF().getColumnCount();
			int row = dialog.getDialog().getTableCF().getSelectedRow();
			
			if(row >= 0){
				for(int i = 0; i < column; i ++){
					dialog.getDialog().getTableCF().setValueAt(actions().get(i),row, i);
				}
			}
		}
		if(dialog.getFlag().equals("1")){
			int column = dialog.getDialog().getTableKB().getColumnCount();
			int row = dialog.getDialog().getTableKB().getSelectedRow();
			
			if(row >= 0){
				for(int i = 0; i < column; i ++){
					dialog.getDialog().getTableKB().setValueAt(actions().get(i),row, i);
				}
			}
		}
		dialog.dispose();
	}
	
	private Vector actions(){
		/*
		 * 获取信息
		 */
		Vector vo = new Vector();
		vo.add(dialog.getLabelSPMC().getText().toString());
		vo.add(dialog.getLabelDW().getText().toString());
		vo.add(dialog.getLabelGGXH().getText().toString());
		vo.add(dialog.getLabelYS().getText());
		
		String djNum = dialog.getTextCFDJ().getText();
		String slNum = dialog.getTextCFSL().getText();
		float dj = new Float(djNum).floatValue();
		int sl = new Integer(slNum).intValue();
		vo.add(dj);
		vo.add(sl);
		vo.add(dj * sl);
		
		return vo;
	}
	
}
