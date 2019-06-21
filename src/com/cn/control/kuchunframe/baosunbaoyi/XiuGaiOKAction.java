package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cn.dao.kuchun.baosunbaoyi.XiuGaiShangPinGetDatas;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.kucunDiaobo.XiuGaiShangPinDialog;

/*
 * 对商品在选好的主窗口中进行修改 
 * 
 */
public class XiuGaiOKAction implements ActionListener {
	private XiuGaiShangPinDialog dialog;
	
	public XiuGaiOKAction(XiuGaiShangPinDialog dialog){
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		//库存调拨
		if(dialog.getkDialog() instanceof KucunDiaobo){
			int row = dialog.getkDialog().getTableKCDB1().getSelectedRow();
			
			int count = XiuGaiShangPinGetDatas.compareNum(dialog.getLabelMC().getText(),
					dialog.getTextSL().getText().toString());
			String djNum = dialog.getLabelDJ().getText().toString();
			float dj = Float.valueOf(djNum);
			float zje = dj * count;
			dialog.getkDialog().getTableKCDB1().setValueAt("" + count, row, 5);
			dialog.getkDialog().getTableKCDB1().setValueAt("" + zje, row, 6);
			
			dialog.dispose();
		}
		
		//报损报溢
		if(dialog.getbDialog() instanceof BaosunBaoyi){
			int row = dialog.getbDialog().getTableBSBY1().getSelectedRow();
			
			int count = XiuGaiShangPinGetDatas.compareNum(dialog.getLabelMC().getText(),
					dialog.getTextSL().getText().toString());
//			String djNum = dialog.getLabelDJ().getText().toString();
//			int dj = Integer.valueOf(djNum);
			
			dialog.getbDialog().getTableBSBY1().setValueAt("" + count, row, 5);
			
			
			dialog.dispose();
		}
	
		
		
	}
}
