package com.cn.control.kuchunframe.kucunpandian.panyingpankui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.kucunpandian.PanYingPanKuiJDialog;
import com.cn.view.kuchunJFrame.kucunpandian.WeiPanShangPinDialog;

public class PanYingPanKuiActionListener implements ActionListener {
	private PanYingPanKuiJDialog dialog;
	
	public PanYingPanKuiActionListener(PanYingPanKuiJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		///查询
		if(dialog.getBtnCX() == btn ){
			Vector vo = KunCunPanDianChaXunGetDatas.panYingPanKuiChaXun(dialog.getComboCK().getSelectedItem().toString(),
					dialog.getComboCZY().getSelectedItem().toString());
			dialog.getTablemodel1().setDataVector(vo, dialog.getVe1());
			dialog.getLabelPDDS().setText("" + vo.size());
			
		}
		///未盘商品
		if(dialog.getBtnWP() == btn){
			WeiPanShangPinDialog wDialog = new WeiPanShangPinDialog(dialog,"未盘商品",true);
			Vector vo = KunCunPanDianChaXunGetDatas.allNotShangPinChaXun();//数据库有待改善
			wDialog.getTablemodel2().setDataVector(vo, wDialog.getVe2());
			wDialog.setVo2(vo);
			
			wDialog.getLabelSPSL().setText("共选择了" + vo.size() + "盘点单");
			wDialog.setVisible(true);
		}
	}
}
