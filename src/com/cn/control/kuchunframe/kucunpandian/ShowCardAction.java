package com.cn.control.kuchunframe.kucunpandian;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.cn.dao.kuchun.kucunpandian.KucunPandianPutinDatabase;
import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.kucunpandian.PanYingPanKuiJDialog;

public class ShowCardAction implements ActionListener {
	private PanYingPanKuiJDialog dialog;
	private static int i = 0;
	public ShowCardAction(PanYingPanKuiJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		CardLayout layout = dialog.getCardlayout();
		JPanel cardPane = dialog.getCenJpanel();
		JButton btn = (JButton)e.getSource();
		//大于等于2时下一步按钮无效
		if(i < 2){
			if(btn == dialog.getBtnNext()){
				i ++;
				if(i > 2){
					i = 0;
				}
				layout.next(cardPane);
			}
		}
		////小于0时上一步按钮无效
		if(i > 0){
			if(btn == dialog.getBtnLast()){
				i --;
				if(i < 0){
					i = 2;
				}
				layout.previous(cardPane);
			}
		}
		
		//初始化第一个界面
		if( i == 0){
			
//			System.out.println(i + "界面一被初始化");
			
		}
		
		//第二个界面数据交互
		if(i == 1){
			/*
			 * 将第一步中的表格置空
			 */
//			dialog.getTablemodel1().setDataVector(null, dialog.getVe1());
			
			Vector vo = KunCunPanDianChaXunGetDatas.allShangPinChaXun();
			dialog.getTablemodel2().setDataVector(vo, dialog.getVe2());
			dialog.getLabelJLS1().setText("共选择了" + vo.size() + "盘点单");
			
//			System.out.println(i + "界面二被初始化");
		}
		
		//第三个界面
		if(i == 2){
			
			int row = dialog.getTable2().getRowCount();
			String []str = new String[row];
			for(int i = 0; i < row; i ++){
				str[i] = dialog.getTable2().getValueAt(i, 0).toString();
			}
			
			Vector vo = KunCunPanDianChaXunGetDatas.compareShangPinChaXun(str);
			dialog.getTablemodel3().setDataVector(vo, dialog.getVe3());
			dialog.getLabelJLS2().setText("" + vo.size());
			/*
			 * 将第二步中的表格清空
			 */
//			dialog.getTablemodel2().setDataVector(null, dialog.getVe2());
//			System.out.println(i + "界面三被初始化");
		}
		
		//修正库存
		if(btn == dialog.getBtnXZ()){
			////////////获取表中的数据
			if(i == 2){
				JTable table = dialog.getTable3();
				int row = table.getRowCount();
				int column = table.getColumnCount();
				Vector vo = new Vector();
				for(int i = 0; i < row; i ++){
						Vector tmp = new Vector();
						tmp.add(table.getValueAt(i, 0));
						tmp.add(table.getValueAt(i, 4));
						vo.add(tmp);
				}
				//////////////更新库存
				int choice = JOptionPane.showConfirmDialog(null,"修正后数据不能恢复，请先备份数据库！确定要修改盘点中的商品的库存吗？",
							"修正商品库存",JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					KucunPandianPutinDatabase.updateKucun(vo);
					/*
					 * 更新盘点单信息
					 * 更新盘点商品信息
					 */
					KunCunPanDianChaXunGetDatas.clearPanDianShangPin();
					/*
					 * 盘点单不能直接清除,因为有个历史查询
					 * 但是缺乏 已盘点与未盘点的标志,盘点时无法区分
					 * 
					 * 但是已盘点单上的商品已经盘点置空了
					 */
					
//					KunCunPanDianChaXunGetDatas.clearPanDianDan();
					KunCunPanDianChaXunGetDatas.clearPanDianBiaoZhi();
					
					dialog.getTablemodel3().setDataVector(null, dialog.getVe3());
				}
			}
		}
	}
}
