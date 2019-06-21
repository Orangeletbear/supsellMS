package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import com.cn.model.AllTableModel;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * 修改商品表中的鼠标双击监听器
 * @author Administrator
 *
 */
public class XiuGaiShangPinMouseListener extends MouseAdapter {
	private AddSanPingDialog dialog;
	public XiuGaiShangPinMouseListener(AddSanPingDialog dialog) {
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			JTable table1 = dialog.getSpqdtable();	
			JTable table2 = dialog.getSxsptable();
			
			int row1 = table1.getRowCount();
			int row3 = table2.getSelectedRow();
			
			for(int i = 0; i < row1; i ++){
				String name3 = table2.getValueAt(row3, 0).toString();
				String name1 = table1.getValueAt(i, 1).toString();
				
				if(name3.equals(name1)){
					int colunm = dialog.getSpqdtable().getColumnCount();
					
					AllTableModel model = dialog.getTableModel1();
					Object [] str  = new Object[colunm];
					for(int j = 0; j < colunm; j ++){
						str [j] = model.getValueAt(i, j);
					}
						
					AddShangPinXinXiDialog xxDialog = 
						new AddShangPinXinXiDialog(dialog,"商品信息(库存调拨)",true,1);
					
					//将数据设置到信息窗口栏上
					xxDialog.getLabelSPBH().setText(str[0].toString());
					xxDialog.getLabelGGXH().setText(str[3].toString());
					xxDialog.getLabelSCCS().setText(null);
					xxDialog.getLabelDQKC().setText(str[6].toString());
					xxDialog.getLabelSPMC().setText(str[1].toString());
					xxDialog.getLabelYS().setText(str[4].toString());
					xxDialog.getLabelBZ().setText(null);
					xxDialog.getLabelCBDJ().setText(str[5].toString());
					
					xxDialog.setVisible(true);
				}
			}	
		}
	}
}
