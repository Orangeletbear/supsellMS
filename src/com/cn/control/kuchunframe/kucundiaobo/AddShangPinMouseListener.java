package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * 
 * 通过监听信息表双击来获得数据信息窗口！
 * @author Administrator
 *
 */
public class AddShangPinMouseListener extends MouseAdapter implements ActionListener{
	private AddSanPingDialog dialog;
	
	public AddShangPinMouseListener(AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			actions();
		}
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(dialog.getAddBtn() == btn){
			actions();
		}
//		if(dialog.getAterBtn() == btn){
//			
//		}
//		if(dialog.getAterBtn() == btn){
//			
//		}
		
	}
	private void actions(){
		int row = dialog.getSpqdtable().getSelectedRow();
		
		if(dialog.getVo3().size() > 0){
			for(int j = 0; j < dialog.getTableModel3().getRowCount(); j ++){
				if(dialog.getSpqdtable().getValueAt(row, 1).equals(dialog.getSxsptable().getValueAt(j, 0))){
					JOptionPane.showMessageDialog(null, "该商品已在选择列表中，如需修改请单击右下方的修改按钮！");
					break;
				} 
				if(j == dialog.getTableModel3().getRowCount()-1){
					son();
					break;
				}
			}
		}else{
			son();
		}
	}
	private void son(){
		int row = dialog.getSpqdtable().getSelectedRow();
		if(row >= 0){
			int column = dialog.getSpqdtable().getColumnCount();
			///////////////如果该商品没有添加，则 进行如下操作//////////////有时间要提取公共部分
			AllTableModel model = dialog.getTableModel1();
			Object [] str  = new Object[column];
			for(int i = 0; i < column; i ++){
				str [i] = model.getValueAt(row, i);
			}
			
			AddShangPinXinXiDialog xxDialog = null;
			if(dialog.getCDialog() instanceof ChaifenKunbang){
				if(dialog.getFlag().equals("0")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"商品信息(拆分商品)",true,0);
				}
				if(dialog.getFlag().equals("1")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"商品信息(捆绑商品)",true,0);
				}
			}
			if(dialog.getKDialog() instanceof KucunDiaobo){
				xxDialog = new AddShangPinXinXiDialog(dialog,"商品信息(库存调拨)",true,0);
			}
			if(dialog.getBDialog() instanceof BaosunBaoyi){
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("商品报损")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"商品信息(商品报损)",true,0);
				}
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("商品报溢")){
					xxDialog = new AddShangPinXinXiDialog(dialog,"商品信息(商品报溢)",true,0);
				}
			}

			//将数据设置到信息窗口栏上
			xxDialog.getLabelSPBH().setText(str[0].toString());
			xxDialog.getLabelGGXH().setText(str[3].toString());
			xxDialog.getLabelDW().setText(str[2].toString());
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
