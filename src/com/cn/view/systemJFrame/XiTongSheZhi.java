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
    
    JButton btn1 = new JButton("ȷ��");
    JButton btn2 = new JButton("ȡ��");
    
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
	     
	     tab.add("��˾��Ϣ",bt1); 
	     tab.add("ϵͳ����",bt2);
	     tab.add("POS��������",bt3); 
	     tab.add("Զ�̷��ʿ���",bt4); 
	     tab.add("���ӳ���������",bt5);
	     this.add(tab,BorderLayout.CENTER);
	    
	}

	private void addCenter() {
	 
		
	}

	 
	 
	 

	public static void main(String[] args) {
	 
		new XiTongSheZhi("��������");
		

	}

}
