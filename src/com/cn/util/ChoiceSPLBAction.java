package com.cn.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JWindow;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.util.InitTreePane;
import com.cn.view.systemJFrame.shangpingxinxidialog.AddShangPingDialog;
/*
 * 单击打开一个树选择窗口
 * 选择商品类别
 */
public class ChoiceSPLBAction extends MouseAdapter {
	
	private JDialog dialog;
	private JWindow window;
	private JTextField output;
	private JTree tree;
	private boolean isAdd;
	private JTextField spName;
	/**
	 * 
	 * @param dialog  所有者
	 * @param output  所要输送你文本域
	 * @param isAd  修改还是增加
	 */
	public ChoiceSPLBAction(JDialog dialog,
			JTextField output,boolean isAdd,JTextField spName){
		this.isAdd = isAdd;
		this.dialog = dialog;
		this.output = output;
		this.spName = spName;
		
	}
	
	/**
	 * 自动获取商品ID
	 * @param lbName  商品类别名
	 * @return spID
	 */
	private String getSPName(String lbName){
		String spID = "5";
		int lbNum = SanPingGuanLiJDBC.getSPLBNum(lbName);
		if(lbNum < 10){
			spID = spID+"0"+lbNum;
		}
		if(lbNum >=10){
			spID = spID+lbNum;
		}
		
		System.out.println(lbNum);
		
		int lbSPNum = SanPingGuanLiJDBC.getSPAtLBNum(spID);
		
			if(lbSPNum / 100 >= 1 ){
				spID = spID + "0"+lbSPNum;
			}else if(lbSPNum / 10 >= 1){
				spID = spID + "00"+lbSPNum;
			}else if(lbSPNum / 1 < 10) {
				spID = spID + "000"+lbSPNum;
			}
		
		
		
		return spID;
	}
	
	public void mouseClicked(MouseEvent arg0){
		
		window = new JWindow(dialog);
		window.setSize(200,200);
		window.setLayout(new BorderLayout());
		JButton btn = (JButton)arg0.getSource();
		Point point = btn.getLocationOnScreen();
 		window.setLocation(point);
		
		InitTreePane treePane = new InitTreePane(tree);

		JPanel pane = treePane.getPane();
		
		this.tree = treePane.getTree();
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		
		cancerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
			}
		});
		
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String name = tree.getLastSelectedPathComponent().toString();
				if(name == null){
					window.dispose();
					
				}else{
					output.setText(name);
					if(isAdd ==true){
						spName.setText(getSPName(name));
					}
					
					window.dispose();
				}
				
			}
		});
		
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		southPane.setBackground(Color.gray);
		
		window.add(new JScrollPane(pane));
		window.add(southPane,BorderLayout.SOUTH);
		window.setVisible(true);
	}
	


}
