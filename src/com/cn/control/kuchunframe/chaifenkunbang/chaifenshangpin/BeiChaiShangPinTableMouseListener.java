package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinGetDatas;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;
import com.cn.view.kuchunJFrame.chaifenkunbang.BeiChaiShangPinFindJWindow;

/**
 * 通过监听表格和弹出窗口的确定按钮，将选择的商品的详细信息，显示在主界面信息栏
 * @author Administrator
 *
 */
public class BeiChaiShangPinTableMouseListener extends MouseAdapter implements ActionListener {
	private BeiChaiShangPinFindJWindow window;
	
	public BeiChaiShangPinTableMouseListener(BeiChaiShangPinFindJWindow window){
		this.window = window;
	}
	/*
	 * 双击表格确定数据
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			if(window.getDialog() instanceof ChaifenKunbang){
				if(window.getFlag().equals("0")){
					actions1();
				}
				if(window.getFlag().equals("1")){
					actions2();
				}
			}
			if(window.getBDialog() instanceof BaozhuangShezhiJDialog){
				if(window.getFlag1().equals("0")){
					actions3();
				}
				if(window.getFlag1().equals("1")){
					actions4();
				}
			}
			window.dispose();
		}
	}
	/*
	 * 确认按钮提交数据
	 */
	public void actionPerformed(ActionEvent e) {
//		if(window.getDialog().getTitle() == "增加商品(拆分商品)"){
//			actions1();
//		}
		if(window.getDialog() instanceof ChaifenKunbang){
			if(window.getFlag().equals("0")){
				actions1();
			}
			if(window.getFlag().equals("1")){
				actions2();
			}
		}
		if(window.getBDialog() instanceof BaozhuangShezhiJDialog){
			if(window.getFlag1().equals("0")){
				actions3();
			}
			if(window.getFlag1().equals("1")){
				actions4();
			}
		}
		
		window.dispose();
	}
	/*
	 * 传输到拆分界面
	 */
	private void actions1(){
		
			int row = window.getTableBCF().getSelectedRow();
			int column = window.getTableBCF().getColumnCount();
			
			//用来存储数据库查询出来的数据
			String []data = new String[column];
			for(int i = 0; i < column; i ++){
				data[i] = window.getTableModelBCF().getValueAt(row, i).toString();
			}
			
			String djNum = ChaiFenShangPinGetDatas.getChengben(data[0]);
			
			/*
			 * 将数组中的数据显示到属性栏中
			 */
			ChaifenKunbang dialog = (ChaifenKunbang)window.getOwner();
			
			String cfsl = null;
			if(dialog.getTextCFSL().getText().trim().length() == 0 ){
				cfsl = "0";
			}else{
				cfsl = dialog.getTextCFSL().getText().trim();
			}
			
			float cfze = new Float(djNum).floatValue() * new Float(cfsl).floatValue();
			
			dialog.getTextBCSPBH().setText(data[0].toString());
			dialog.getLabelBCSPMC1().setText(data[1].toString());
			dialog.getLabelGGXH1().setText(data[2].toString());
			dialog.getLabelDW1().setText(data[3].toString());
			dialog.getLabelYS1().setText(data[4].toString());
			dialog.getLabelDQKC1().setText(data[5].toString());
			dialog.getLabelCBJ1().setText(djNum);
			dialog.getLabelCFZE().setText("" + cfze);
	}
	/*
	 * 传输到捆绑界面
	 */
	private void actions2(){
		
		int row = window.getTableBCF().getSelectedRow();
		int column = window.getTableBCF().getColumnCount();
		
		//用来存储数据库查询出来的数据
		String []data = new String[column];
		for(int i = 0; i < column; i ++){
			data[i] = window.getTableModelBCF().getValueAt(row, i).toString();
		}
//		System.out.println(data[0]);
		
		String djNum = ChaiFenShangPinGetDatas.getChengben(data[0]);
		
//		System.out.println(djNum);
		/*
		 * 将数组中的数据显示到属性栏中
		 */
		ChaifenKunbang dialog = (ChaifenKunbang)window.getOwner();
		
		String kbsl = null;
		if(dialog.getTextCFSL().getText().trim().length() == 0 ){
			kbsl = "0";
		}else{
			kbsl = dialog.getTextCFSL().getText().trim();
		}
		
		float kbze = new Float(djNum).floatValue() * new Float(kbsl).floatValue();
		
		dialog.getTextKBSP().setText(data[0].toString());
		dialog.getLabelKBSP().setText(data[1].toString());
		dialog.getLabelGGXH2().setText(data[2].toString());
		dialog.getLabelDW2().setText(data[3].toString());
		dialog.getLabelYS2().setText(data[4].toString());
		dialog.getLabelDQKC2().setText(data[5].toString());
		dialog.getLabelCBJ2().setText(djNum);
		dialog.getLabelKBZE().setText("" + kbze);
	}
	
	/*
	 * 传输到包装大商品界面
	 */
	private void actions3(){
		int row = window.getTableBCF().getSelectedRow();
		int column = window.getTableBCF().getColumnCount();
		
		//用来存储数据库查询出来的数据
		String []data = new String[column - 1];
		for(int i = 0; i < column - 1; i ++){
			data[i] = window.getTableModelBCF().getValueAt(row, i).toString();
		}
		
		BaozhuangShezhiJDialog dialog = window.getBDialog();
		dialog.getTextSPBH1().setText(data[0].toString());
		dialog.getLabelSPName1().setText(data[1].toString());
		dialog.getLabelGGXH1().setText(data[2].toString());
		dialog.getLabelDW1().setText(data[3].toString());
		dialog.getLabelYS1().setText(data[4].toString());
	}
	
	/*
	 * 传输到包装大商品界面
	 */
	private void actions4(){
		int row = window.getTableBCF().getSelectedRow();
		int column = window.getTableBCF().getColumnCount();
		
		//用来存储数据库查询出来的数据
		String []data = new String[column - 1];
		///------------------------------
		for(int i = 0; i < column - 1; i ++){
			data[i] = window.getTableModelBCF().getValueAt(row, i).toString();
		}
		BaozhuangShezhiJDialog dialog = window.getBDialog();
		dialog.getTextSPBH2().setText(data[0].toString());
		dialog.getLabelSPName2().setText(data[1].toString());
		dialog.getLabelGGXH2().setText(data[2].toString());
		dialog.getLabelDW2().setText(data[3].toString());
		dialog.getLabelYS2().setText(data[4].toString());
	}
	
}
