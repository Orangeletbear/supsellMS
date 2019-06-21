package com.cn.control.kuchunframe.kucunpandian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.KucunPandian;
import com.cn.view.kuchunJFrame.kucunpandian.XinZengPanDianDanJDialog;

public class XZorXGPanDianDanAction implements ActionListener {
	private KucunPandian dialog;
	
	public XZorXGPanDianDanAction(KucunPandian dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if(btn == dialog.getBtnXZPDD()){
			new XinZengPanDianDanJDialog(dialog,"录入盘点商品",true);
		}
		if(btn == dialog.getBtnXGPDD()){
			int row = dialog.getTablePD1().getSelectedRow();
			if(row >= 0){
				XinZengPanDianDanJDialog xzDialog = new XinZengPanDianDanJDialog(dialog,"修改盘点商品",true);
				
				Vector vo = KunCunPanDianChaXunGetDatas.xiugaiShangPinChaXun(dialog.getTablePD1().getValueAt(row, 0).toString());
				xzDialog.getTableModelYPSP().setDataVector(vo, xzDialog.getVeYPSP());
			}
			
		}
	}
}
