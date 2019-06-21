package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 将所选的商品确定后传输到调主界面上
 * 
 */
public class Send_ShangPinAction implements ActionListener {
	private AddSanPingDialog dialog;
	private static 	boolean flag = true;
	
	public Send_ShangPinAction (AddSanPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog.getVo3().size() > 0){
//			库存调拨窗口
			if(dialog.getKDialog() instanceof KucunDiaobo){
				for(int i = 0; i < dialog.getVo3().size(); i ++){
					dialog.getKDialog().getVector1().add(dialog.getVo3().get(i));
				}
				dialog.getKDialog().getTableModel1().setDataVector(dialog.getKDialog().getVector1(), 
						dialog.getKDialog().getVe1());
//				dialog.getKDialog().getTableKCDB1().setRowSelectionInterval(0, 0);
			}
			
			//报损报溢窗口
			if(dialog.getBDialog() instanceof BaosunBaoyi){
				Vector vo1 = new Vector();//存放已选表格中的数据
				Vector vo2 = new Vector();//存放将要放到调拨单里的数据
				vo1 = dialog.getVo3();
				for(int i = 0; i < vo1.size(); i ++){
					Vector tmp = new Vector();
						tmp.add(((Vector)vo1.get(i)).get(0));
						tmp.add(((Vector)vo1.get(i)).get(1));
						tmp.add(((Vector)vo1.get(i)).get(2));
						tmp.add(((Vector)vo1.get(i)).get(3));
						tmp.add(((Vector)vo1.get(i)).get(4));
						tmp.add(((Vector)vo1.get(i)).get(5));
						vo2.add(tmp);
				}	
				//报损
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("商品报损")){
					for(int i = 0; i < dialog.getVo3().size(); i ++){
						dialog.getBDialog().getVector1().add(vo2.get(i));
					}
					dialog.getBDialog().getTableModel1().setDataVector(dialog.getBDialog().getVector1(),dialog.getBDialog().getVe1());
				}
				//报溢
				if(dialog.getBDialog().getComboDJLX1().getSelectedItem().toString().equals("商品报溢")){
					for(int i = 0; i < dialog.getVo3().size(); i ++){
						dialog.getBDialog().getVector2().add(vo2.get(i));
					}
					dialog.getBDialog().getTableModel1().setDataVector(dialog.getBDialog().getVector2(),dialog.getBDialog().getVe1());
				}				
//				dialog.getBDialog().getTableBSBY1().setRowSelectionInterval(0, 0);
			}
			
			///商品拆分捆绑
			if(dialog.getCDialog() instanceof ChaifenKunbang){
				
				ChaifenKunbang cd = dialog.getCDialog(); 
				
				if(dialog.getFlag().equals("0")){
					for(int i = 0; i < actions().size(); i ++){
						dialog.getCDialog().getVector1().add(actions().get(i));
					}
					cd.getTableModelCF().setDataVector(dialog.getCDialog().getVector1(), cd.getVe1());
				}
				
				if(dialog.getFlag().equals("1")){
					for(int i = 0; i < actions().size(); i ++){
						dialog.getCDialog().getVector2().add(actions().get(i));
					}
					cd.getTableModelKB().setDataVector(dialog.getCDialog().getVector2(), cd.getVe2());
				}
			}
			dialog.dispose();
		}
	}
	
	/*
	 * 拆分捆绑的公用方法
	 */
	private Vector actions(){
		Vector vo1 = new Vector();//存放已选表格中的数据
		Vector vo2 = new Vector();//存放将要放到拆分单里的数据
		vo1 = dialog.getVo3();
		for(int i = 0; i < vo1.size(); i ++){
			
//			for(int j = 0; j < vo1.size(); j ++){
				Vector tmp = new Vector();
				tmp.add(((Vector)vo1.get(i)).get(0));
				tmp.add(((Vector)vo1.get(i)).get(1));
				tmp.add(((Vector)vo1.get(i)).get(2));
				tmp.add(((Vector)vo1.get(i)).get(3));
				tmp.add(((Vector)vo1.get(i)).get(4));
				tmp.add(((Vector)vo1.get(i)).get(5));
				tmp.add(((Vector)vo1.get(i)).get(6));
				vo2.add(tmp);
		} 
		return vo2;
	}
}
