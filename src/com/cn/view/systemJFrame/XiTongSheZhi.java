package com.cn.view.systemJFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class XiTongSheZhi extends JDialog {
	
	JPanel bt1 =  new JPanel();
    JPanel bt2 =  new JPanel();
    JPanel bt3 =  new JPanel();
    JPanel bt4 =  new JPanel();
    JPanel bt5 =  new JPanel();
    
    JButton btn1 = new JButton("确定");
    JButton btn2 = new JButton("取消");
    
	public XiTongSheZhi(String str){
	    super((JFrame)null,str);
		init();
	}
	
	private void init() {
		this.setSize(480,360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    addNorthPanel();
	    addCenter();
	    addSouth();
	    
	 //this.setLayout(new BorderLayout());
		this.setVisible(true);
	}
    
	 private void addSouth() {
		 JPanel paSouth =new JPanel();
		 paSouth.setLayout(new FlowLayout(FlowLayout.RIGHT,50,2));
	// paSouth.setLayout(new GridLayout(1,2));
		 paSouth.add(btn1);
		 paSouth.add(btn2);
		 this.add(paSouth,BorderLayout.SOUTH);
		
	}

	private void addNorthPanel() {
	      
	     JTabbedPane  tab  = new JTabbedPane
	     (JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	     
	     tab.add("公司信息",bt1); 
	     tab.add("系统参数",bt2);
	     tab.add("POS参数设置",bt3); 
	     tab.add("远程访问控制",bt4); 
	     tab.add("电子称条码设置",bt5);
	     this.add(tab,BorderLayout.CENTER);
	    
	}

	private void addCenter() {
	 
		
	}

	 
	 
	 

	public static void main(String[] args) {
	 
		new XiTongSheZhi("其它设置");
		

	}

}
