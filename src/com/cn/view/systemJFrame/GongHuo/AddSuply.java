package com.cn.view.systemJFrame.GongHuo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cn.control.systemframe.suplly.AddSupllyAction;
import com.cn.view.systemJFrame.GongHuoShang;
/*
 * 增加供应商对话框
 */
public class AddSuply extends JDialog {
	private JTextField text1;
	private JTextField text3;
	private JTextField text4;
	private JTextField text2;
	private JTextArea text5;//备注
	private JTextField jfe;//期初应付
	private JCheckBox cb1;//默认供货商
	private JCheckBox cb2;//禁用
	
	public AddSuply(GongHuoShang dialog,String title){
		super(dialog,title,true);
		init();
		
	}
	private void init(){
		this.setSize(264,320);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel pa = new JPanel();
		//JPanel pa1 = new JPanel();
		//JPanel pa2 = new JPanel();
		//JPanel pa3 = new JPanel();
		pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
		JLabel b1 = new JLabel("供货商名称 ");
		JLabel b2 = new JLabel("联  系  人 ");
		JLabel b3 = new JLabel("联 系 电 话");
		JLabel b4 = new JLabel("联 系 地 址");
		JLabel b5 = new JLabel("  备     注   ");
		text1 = new JTextField(21);
		text2 = new JTextField(21);
		text3 = new JTextField(21);
		text4 = new JTextField(21);
		
		
		text5 = new JTextArea(4,21);
		text5.setText("ff");
		//t5.setPreferredSize(new Dimension(13,17));
		pa.add(b1);pa.add(text1);
		pa.add(b2);pa.add(text2);
		pa.add(b3);pa.add(text3);
		pa.add(b4);pa.add(text4);
		pa.add(b5);pa.add(new JScrollPane(text5,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    JLabel la = new JLabel("初期应收:");
	    
	    jfe = new JTextField("0.00");
	    
	    JLabel warn = new JLabel("初期应付:新增供应商时,目前欠此供应商的货款额.");
		warn.setFont(new Font("DIALOG",Font.PLAIN,11));
		warn.setForeground(Color.RED);
		pa.add(la);
		pa.add(jfe);
		
		cb1 = new JCheckBox("默认客户",true);
		
		cb2 = new JCheckBox("禁 用");
		JButton jb1 = new JButton("确认(F5)");
		
		jb1.addActionListener(new AddSupllyAction(AddSuply.this));
		//jb1.addActionListener(new OKActionListener(this));
		JButton jb2 = new JButton("退出(F4)");
		jb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AddSuply.this.dispose();
			}
			
		});
		
		pa.add(cb1);
		pa.add(cb2);
		pa.add(warn);
		 
		pa.add(jb1);
		pa.add(jb2);
		pa.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(pa);
		this.setVisible(true);
	}
	public JCheckBox getCb1() {
		return cb1;
	}
	public JCheckBox getCb2() {
		return cb2;
	}
	public JTextField getJfe() {
		return jfe;
	}
	public JTextField getText1() {
		return text1;
	}
	public JTextField getText2() {
		return text2;
	}
	public JTextField getText3() {
		return text3;
	}
	public JTextField getText4() {
		return text4;
	}
	public JTextArea getText5() {
		return text5;
	}
}
 
