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
 *  顾客退货对话框中的顾客退货查询选项卡
 *  上的退货总表上的表格所对应的鼠标事件
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
			
			
			//左键
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
