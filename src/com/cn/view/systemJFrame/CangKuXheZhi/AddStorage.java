package com.cn.view.systemJFrame.CangKuXheZhi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.systemframe.storage.AddStorageAction;
import com.cn.view.systemJFrame.CangKuSheZhi;
/*
 * 增加仓库对话框
 */
public class AddStorage extends JDialog {
	public JTextField getT1() {
		return t1;
	}
	public JTextField getT2() {
		return t2;
	}
	public JTextField getT3() {
		return t3;
	}
	public JTextField getT4() {
		return t4;
	}
	public JTextField getT5() {
		return t5;
	}
	public JButton getJb1() {
		return jb1;
	}
	public String getTitle() {
		return title;
	}
	//
	JTextField t1  ;//仓库名称
	JTextField t2  ;//负责人
	JTextField t3  ;//联系电话
	JTextField t4  ;//联系地址
	JTextField t5  ;//备注
	JButton jb1;//确定
	JCheckBox c1;//默认仓库
	JCheckBox c2;//	POS仓库
	protected String title;
	CangKuSheZhi owner;
	
	public AddStorage(CangKuSheZhi frame,String title,boolean be){
	super(frame,title,true);
	this.setSize(230,250);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	JPanel pa = new JPanel();
	//JPanel pa1 = new JPanel();
	//JPanel pa2 = new JPanel();
	//JPanel pa3 = new JPanel();
	pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
	JLabel b1 = new JLabel("仓库名称");
	JLabel b2 = new JLabel("负 责 人");
	JLabel b3 = new JLabel("联系电话");
	JLabel b4 = new JLabel("联系地址");
	JLabel b5 = new JLabel(" 备  注 ");
      t1 = new JTextField(21);
      t2 = new JTextField(21);
	  t3 = new JTextField(21);
	  t4 = new JTextField(21);
	  t5 = new JTextField(21);
	pa.add(b1);pa.add(t1);
	pa.add(b2);pa.add(t2);
	pa.add(b3);pa.add(t3);
	pa.add(b4);pa.add(t4);
	pa.add(b5);pa.add(t5);
    

	 c1 = new JCheckBox("默认仓库");
	
	  c2 = new JCheckBox("POS仓库");
	  jb1 = new JButton("确认(F5)");
	
	  /**
	   * 给确定键增加监听器
	   */
	  jb1.addActionListener(new AddStorageAction(AddStorage.this));
	  
	
	  JButton jb2 = new JButton("退出(F4)");
	
	  jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			 AddStorage.this.dispose();
			
		}});
	 
	
	  pa.add(c1);
	
	  pa.add(c2);
	
	  pa.add(jb1);
	
	  pa.add(jb2);
	
	
	  pa.setLayout(new FlowLayout(FlowLayout.CENTER));
    //退出键监听器
	  jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			AddStorage.this.dispose();
		}});
	
	  this.add(pa);
	
	  this.setVisible(true);
	
	}
 
	  public JCheckBox getC1() {
		 return c1;
	}
	  public JCheckBox getC2() {
		 return c2;
	}
}


