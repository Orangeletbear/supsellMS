package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * POS端的客显设置
 * @author finey
 *
 */
public class KeXianSetDialog extends JDialog {

	//单价
	JTextField spDanJia = new JTextField(10);
	//总价
	JTextField countAll = new JTextField(10);
	//收款
	JTextField getPrice = new JTextField(10);
	//找零
	JTextField returnPrice = new JTextField(10);
    //端口
	JComboBox duanBox = new JComboBox(new String[]{"COM1","COM2","COM3","COM4"});
	
	public KeXianSetDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(350,330));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//中心数据输入块
	    JPanel centerPane = initPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				KeXianSetDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	private JPanel initPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel upPane = initUpPane();
		JPanel centerPane = initCenterPane();
		
		pane.add(upPane,BorderLayout.NORTH);
		pane.add(centerPane,BorderLayout.CENTER);
		
		return pane;
	}
	//上面面板
	private JPanel initUpPane(){
		JPanel pane = new JPanel();
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("选择客显使用的端口 : ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(duanBox);
	    pane.add(tmpPane);

	    pane.setBorder(new TitledBorder("选择端口"));
		return pane;
	}
	//中间面板
	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    JLabel tmpLab = new JLabel("单价: ");
	    JButton text = new JButton("测试");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDanJia);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("总计: ");
	    text = new JButton("测试");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(countAll);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("收款: ");
	    text = new JButton("测试");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(getPrice);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("找零: ");
	    text = new JButton("测试");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(returnPrice);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    
		pane.setBorder(new TitledBorder("客显测试"));
		return pane;
	}
	

}
