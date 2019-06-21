package com.cn.view.systemJFrame.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.system.CustomerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.view.systemJFrame.CustomerSet;
/*
 * 查找顾客对话框
 */
public class FindCustomer extends JDialog {
    
	
	private JTextField te2;
	private JTextField te1;
	private JTextField te3;
	private JTextField te4;
	private JButton jb1;

	public FindCustomer(CustomerSet set, String title, boolean be) {
		super(set,title,true);
		this.setSize(230,260);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}

	public FindCustomer() {
		// TODO Auto-generated constructor stub
	}

	private void init() {
		JPanel thisp = new JPanel();
		 te1 = new JTextField(21);
		 te2 = new JTextField(21);
		 te3 = new JTextField(21);
		 te3.setEditable(false);
		// te3.setEditable(false);
		// te4.setEditable(false);
		 te4 = new JTextField(21);
		 te4.setEditable(false);
		 JLabel la  = new JLabel("客户名称:");
		 JLabel la1 = new JLabel("联系人  :");
		 JLabel la2 = new JLabel("联系电话:");
		 
		 JLabel la3 = new JLabel("联系地址:");
		  jb1= new JButton("确认(F5)") ;
		  
		  /*
		   * 查询语句监听
		   */
		  jb1.addActionListener(new ActionListener(){
   
	 
			public void actionPerformed(ActionEvent e) {
				String khName;
				String khLSR;
				 
				  khName = te1.getText(); 
				 
				 
				  khLSR = te2.getText(); 
			 
				//String khTell = te3.getText().toString();
				//String khAddress = te4.getText().toString();
				
				Vector data = CustomerDB.findCustomer(
						khName, khLSR );
				 
				CustomerSet.getCustomerModel().setDataVector(data,
				AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
				FindCustomer.this.dispose();
			}
			  
		  });
		  
		  
		  
		 JButton bt2 = new JButton("退出(F4)");
		  bt2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
                  FindCustomer.this.dispose();				
			}});
		
		 Box boxLabel = Box.createVerticalBox();
		 //boxLabel.add(Box.createVerticalStrut(16));
		 boxLabel.add(la);
		 boxLabel.add(Box.createVerticalStrut(24));
		 boxLabel.add(la1);
		 boxLabel.add(Box.createVerticalStrut(26));
		 boxLabel.add(la2);
		 boxLabel.add(Box.createVerticalStrut(28));
		 boxLabel.add(la3);
		// boxLabel.add(Box.createVerticalStrut(21));
		 Box boxText = Box.createVerticalBox();
		 boxText.add(Box.createVerticalStrut(16));
		 boxText.add(te1); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(te2);
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(te3); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(te4);
		 boxText.add(Box.createVerticalStrut(21));
		 thisp.add(boxLabel);
		 thisp.add(boxText);
		 
		 thisp.add(jb1);
		 thisp.add(bt2);
		 this.add(thisp);
		 
		
	}

	public JTextField getTe2() {
		return te2;
	}

	public JTextField getTe1() {
		return te1;
	}

	public JTextField getTe3() {
		return te3;
	}

	public JTextField getTe4() {
		return te4;
	}

	public JButton getJb1() {
		return jb1;
	}

}
