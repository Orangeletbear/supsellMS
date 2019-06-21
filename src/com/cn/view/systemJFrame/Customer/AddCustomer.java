package com.cn.view.systemJFrame.Customer;

 

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import com.cn.control.systemframe.customer.AddCustomerActive;
import com.cn.view.systemJFrame.CustomerSet;

 
/*
 * 增加顾客对话框
 */
public class AddCustomer extends JDialog{
	
	JTextField t1; 
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextArea t5;
	
	JTextField fe;
	
	public JCheckBox c1;
	public JCheckBox c2;
	JButton jb1 ;
	
	public JTextField getT1() {
		return t1;
	}
	public void setT1(JTextField t1) {
		this.t1 = t1;
	}
	public JTextField getT2() {
		return t2;
	}
	public void setT2(JTextField t2) {
		this.t2 = t2;
	}
	public JTextField getT3() {
		return t3;
	}
	public void setT3(JTextField t3) {
		this.t3 = t3;
	}
	public JTextField getT4() {
		return t4;
	}
	public void setT4(JTextField t4) {
		this.t4 = t4;
	}
	public JTextArea getT5() {
		return t5;
	}
	public void setT5(JTextArea t5) {
		this.t5 = t5;
	}
	public JTextField getFe() {
		return fe;
	}
	public void setFe(JTextField fe) {
		this.fe = fe;
	}
	public JCheckBox getC1() {
		return c1;
	}
	public void setC1(JCheckBox c1) {
		this.c1 = c1;
	}
	public JCheckBox getC2() {
		return c2;
	}
	public void setC2(JCheckBox c2) {
		this.c2 = c2;
	}
	public AddCustomer(CustomerSet dialog,String title){
		super(dialog,title ,true);
		init();
		
	}
	private void init(){
		this.setSize(250,310);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel pa = new JPanel();
		//JPanel pa1 = new JPanel();
		//JPanel pa2 = new JPanel();
		//JPanel pa3 = new JPanel();
		pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
		JLabel b1 = new JLabel("客户名称");
		JLabel b2 = new JLabel("负 责 人");
		JLabel b3 = new JLabel("联系电话");
		JLabel b4 = new JLabel("联系地址");
		JLabel b5 = new JLabel(" 备  注 ");
		t1 = new JTextField(24);
		t2 = new JTextField(24);
		t3 = new JTextField(24);
		t4 = new JTextField(24);
		
		
		t5 = new JTextArea(3,24);
		t5.setText("ff");
		//t5.setPreferredSize(new Dimension(13,17));
		pa.add(b1);pa.add(t1);
		pa.add(b2);pa.add(t2);
		pa.add(b3);pa.add(t3);
		pa.add(b4);pa.add(t4);
		pa.add(b5);pa.add(new JScrollPane(t5));
				//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				//JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    JLabel la = new JLabel("初期应收:");
	    
	    fe = new JTextField("0.00");
	    
	    JLabel warn = new JLabel("(初期应收：新 增 此 客 户 时，  ");
	    JLabel warn2 = new JLabel("此客户目前欠我方的货款余额.)   ");
		warn.setFont(new Font("DIALOG",Font.PLAIN,12));
		warn.setForeground(Color.RED);
		warn2.setFont(new Font("DIALOG",Font.PLAIN,12));
		warn2.setForeground(Color.RED);
		pa.add(la);
		pa.add(fe);
		
		c1 = new JCheckBox("默认客户");
		c2 = new JCheckBox("禁 用");
		jb1= new JButton("确认(F5)");
		
		jb1.addActionListener(new AddCustomerActive(AddCustomer.this));
		
		
		//jb1.addActionListener(new OKActionListener(this));
		JButton jb2 = new JButton("退出(F4)");
		jb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AddCustomer.this.dispose();
			}
			
		});
		
		pa.add(c1);
		pa.add(c2);
		pa.add(warn);
		pa.add(warn2);
		pa.add(jb1);
		pa.add(jb2);
		pa.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(pa);
		this.setVisible(true);
	}
	public JTextComponent getJf() {
		return null;
	}
}