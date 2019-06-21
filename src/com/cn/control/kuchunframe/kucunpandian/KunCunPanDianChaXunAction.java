package com.cn.control.kuchunframe.kucunpandian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.KucunPandian;
import com.cn.view.kuchunJFrame.kucunpandian.KCPD_GaoJiChaXunDialog;

public class KunCunPanDianChaXunAction implements ActionListener {
	
	private KCPD_GaoJiChaXunDialog dialog;//高级查询 
	
	private KucunPandian skDialog;//库存盘点
	//库存盘点添加商品界面
	public KunCunPanDianChaXunAction(KCPD_GaoJiChaXunDialog dialog) {
		this.dialog = dialog;
	}
	//盘点单查询界面
	public KunCunPanDianChaXunAction(KucunPandian dialog) {
		this.skDialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog instanceof KCPD_GaoJiChaXunDialog){
			KucunPandian kDialog = dialog.getDialog();
			Vector vo = new Vector();
			try {
				 vo = KunCunPanDianChaXunGetDatas.gaoJiChaXun(DateConventer.dateToStr(dialog.getDateFrom().getSelectedDate(),"yyyy-MM-dd"),
						 DateConventer.dateToStr(dialog.getDateTo().getSelectedDate(),"yyyy-MM-dd"),
						   dialog.getComboCK().getSelectedItem().toString(),
						     dialog.getComboCZY().getSelectedItem().toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			kDialog.getTablemodelPD3().setDataVector(vo, kDialog.getVe1());
			kDialog.getLabelHJ1().setText("" + vo.size());
			
//			kDialog.getTablePD1().setRowSelectionInterval(0, 0);
			dialog.dispose();
		}
		
		if(skDialog instanceof KucunPandian){
			Vector vo = new Vector();
			try {
				 vo = KunCunPanDianChaXunGetDatas.danJuChaXun(DateConventer.dateToStr(skDialog.getDateFrom().getSelectedDate(),"yyyy-MM-dd"),
						 DateConventer.dateToStr(skDialog.getDateTo().getSelectedDate(),"yyyy-MM-dd"),
						 skDialog.getComboCKMC().getSelectedItem().toString(),
						   skDialog.getComboCZR().getSelectedItem().toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			skDialog.getTablemodelPD3().setDataVector(vo, skDialog.getVe3());
			
			skDialog.getLabelHJ3().setText("" + vo.size());
			
		}
	}
}
