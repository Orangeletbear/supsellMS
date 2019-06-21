package com.cn.view.kuchunJFrame.kuchunchaxun;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
/**
 * 当前库存中的高级查询按钮
 * @author finey
 *
 */
public class AdvanceFind extends JDialog {
	//供应商
	private JTextField gongHuoSan = new JTextField(16) ; 
	
	private JComboBox comBox = new JComboBox(new String[]{"=",">=","<=","<>"});
	//库存
	private JTextField kuCunNum = new JTextField(8);
	//仓库集合
	private JComboBox canKu = new JComboBox(JDBCCuCunFind.getCanKuData());
	
	public AdvanceFind(KuCunChaXunFrame frame,String title){
		super(frame,title,true);
		init();
	}
	
	private void init(){
		this.setSize(270,270);
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
        this.setVisible(true);
        
	}
	/*
	 * 建立面板
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(5,1));
		
		JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lab = new JLabel("查询此供货商所供商品的库存情况:");
        tempPane.add(lab);
        mainPane.add(tempPane);
		
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("供 货 商:");
        tempPane.add(lab);
        tempPane.add(gongHuoSan);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("库 存 量:");
        tempPane.add(lab);
        tempPane.add(comBox);
        tempPane.add(kuCunNum);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("所在仓库:");
        tempPane.add(lab);
        tempPane.add(canKu);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,5));
        JButton okBtn = new JButton("确  定");
        JButton exitBtn = new JButton("退  出");
        exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AdvanceFind.this.dispose();
			}
        	
        });
        tempPane.add(okBtn);
        tempPane.add(exitBtn);
        mainPane.add(tempPane);
        
        
        
        
		return mainPane;
	}
	public static void main(String[] args) {
		new AdvanceFind(null,"ff");
	}

}
