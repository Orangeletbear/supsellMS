package com.cn.control.kuchunframe.kucunpandian;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.KucunPandian;

/**
 * ���̵�����1��ӵ���Ʒ���ѡ���ѯ����
 * @author Administrator
 *
 */
public class KCPD_ChaXunShangPinMouseListener extends MouseAdapter {
	private KucunPandian dialog;
	
	public KCPD_ChaXunShangPinMouseListener( KucunPandian dialog) {
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 1){
			int row = dialog.getTablePD1().getSelectedRow();
			
			Vector vo = KunCunPanDianChaXunGetDatas.shangPinChaXun(
					dialog.getTablePD1().getValueAt(row, 0).toString());
			
			dialog.getTablemodelPD2().setDataVector(vo, dialog.getVe2());
			dialog.getLabelPDDH().setText(dialog.getTablePD1().getValueAt(row, 0).toString());
			
			dialog.getLabelHJ2().setText("" + vo.size());
//			dialog.getTablePD2().setRowSelectionInterval(0, 0);
		}
	}
}
