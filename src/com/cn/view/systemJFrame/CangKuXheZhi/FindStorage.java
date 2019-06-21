package com.cn.view.systemJFrame.CangKuXheZhi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.StorageCulomns;
import com.cn.view.systemJFrame.CangKuSheZhi;
/*
 * 查找仓库对话框
 */
public class FindStorage extends JDialog {
	 
	 JTextField jf1 ;
	 JTextField jf2 ;
	 JTextField jf3;
	 JTextField jf4 ;
	 JButton bt1;
	 
	
	
	public FindStorage(CangKuSheZhi ca ,String str ,boolean bo){
		super(ca,str,true);
		this.setSize(230,260);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		init();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	

	private void init() {
		JPanel thisp = new JPanel();
		 jf1 = new JTextField(21);
		 jf2 = new JTextField(21);
		 jf3 = new JTextField(21);jf3.setEditable(false);
		 jf4 = new JTextField(21);jf4.setEditable(false);
		 JLabel la  = new JLabel("仓库名称：");
		 JLabel la1 = new JLabel("负责人  ：");
		 JLabel la2 = new JLabel("联系电话：");
		 JLabel la3 = new JLabel("仓库地址：");
		  bt1= new JButton("确认(F5)") ;
		  bt1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String Name;
				String FZR;
				Name = jf1.getText();
				FZR =  jf2.getText();
				Vector data = StorageDB.findStorage(Name, FZR);
				
				CangKuSheZhi.getTablemodel().setDataVector(data,
						AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));
				FindStorage.this.dispose();
			}
		  });
		  
		 JButton bt2 = new JButton("退出(F4)");
		  bt2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				FindStorage.this.dispose();
				
			}});
		
		 Box boxLabel = Box.createVerticalBox();
		// boxLabel.add(Box.createVerticalStrut(16));
		 boxLabel.add(la);
		 boxLabel.add(Box.createVerticalStrut(22));
		 boxLabel.add(la1);
		 boxLabel.add(Box.createVerticalStrut(26));
		 boxLabel.add(la2);
		 boxLabel.add(Box.createVerticalStrut(28));
		 boxLabel.add(la3);
		 //boxLabel.add(Box.createVerticalStrut(21));
		 Box boxText = Box.createVerticalBox();
		 boxText.add(Box.createVerticalStrut(16));
		 boxText.add(jf1); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(jf2);
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(jf3); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(jf4);
		 boxText.add(Box.createVerticalStrut(21));
		 thisp.add(boxLabel);thisp.add(boxText);
		 
		 thisp.add(bt1);thisp.add(bt2);
		 this.add(thisp);
		 
	}
	
	public JTextField getJf1() {
		return jf1;
	}

	public JTextField getJf2() {
		return jf2;
	}

	public JTextField getJf3() {
		return jf3;
	}

	public JTextField getJf4() {
		return jf4;
	}

	public JButton getBt1() {
		return bt1;
	}

	 
	

}
