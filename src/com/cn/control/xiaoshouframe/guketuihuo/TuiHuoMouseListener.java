package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;

/**
 *  �˿��˻��Ի����еĹ˿��˻���ѯѡ�
 *  �ϵ��˻��ܱ��ϵı������Ӧ������¼�
 * @author Administrator
 *
 */
public class TuiHuoMouseListener extends MouseAdapter {

	 private GuKeTuiHuoDialog dialog;

		public TuiHuoMouseListener(GuKeTuiHuoDialog dialog,int row) {
			this.dialog = dialog;
		}
		
		
		public void mouseClicked(MouseEvent e) {
			Vector data = null;
			
			
			//���
			if(e.getButton() == 1) {
				int i = dialog.getDanJuTable().getSelectedRow();
				String danHao = (String) dialog.getDanJuModel().getValueAt(i,0);
				JLabel label = dialog.getInformation();
				label.setText(danHao+"         "+(String) dialog.getDanJuModel().getValueAt(i,2));
				label.setForeground(Color.RED);
				data = JDBCTuiHuoDanJuFind.getDate(danHao);	

			}
		   
			dialog.getXiangXiModel().setDataVector(data,
					AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.DanJuColumnNames));
	        
		} 
		
}
