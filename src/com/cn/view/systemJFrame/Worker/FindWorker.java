package com.cn.view.systemJFrame.Worker;

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

import com.cn.dao.system.SupllyDB;
import com.cn.dao.system.WorkerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.WorkerCulomns;
import com.cn.view.systemJFrame.WorkSet;
/*
 * 查找员工对话框
 */
public class FindWorker extends JDialog {
	 
	 JTextField tf1 ;
	 JTextField tf2 ;
	 JTextField tf3;
	 JTextField tf4 ;
	 JButton btn1;
	 
	
	
	public FindWorker(WorkSet ca ,String str ,boolean bo){
		super(ca,str,true);
		this.setSize(230,260);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}

	private void init() {
		JPanel thisp = new JPanel();
		 tf1 = new JTextField(21);
		 tf2 = new JTextField(21);
		 tf3 = new JTextField(21);tf3.setEditable(false);
		 tf4 = new JTextField(21);tf4.setEditable(false);
		 JLabel la  = new JLabel("员工姓名：");
		 JLabel la1 = new JLabel("所任职务：");
		 JLabel la2 = new JLabel("联系电话：");
		 JLabel la3 = new JLabel("仓库地址：");
		  btn1= new JButton("确认(F5)") ;
		 JButton bt2 = new JButton("退出(F4)");
		 btn1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String  Name;
				String srzw;
				Name = tf1.getText();
				srzw = tf2.getText();
				Vector data = WorkerDB.findCustomer(Name, srzw);
				
				WorkSet.getWorkerModel().setDataVector(data,
						AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
				FindWorker.this.dispose();
			}
			 
		 });
		 
		  bt2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				FindWorker.this.dispose();
				
			}});
		
		 Box boxLabel = Box.createVerticalBox();
		// boxLabel.add(Box.createVerticalStrut(16));
		 boxLabel.add(la);
		 boxLabel.add(Box.createVerticalStrut(24));
		 boxLabel.add(la1);
		 boxLabel.add(Box.createVerticalStrut(26));
		 boxLabel.add(la2);
		 boxLabel.add(Box.createVerticalStrut(28));
		 boxLabel.add(la3);
		 //boxLabel.add(Box.createVerticalStrut(21));
		 Box boxText = Box.createVerticalBox();
		 boxText.add(Box.createVerticalStrut(16));
		 boxText.add(tf1); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(tf2);
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(tf3); 
		 boxText.add(Box.createVerticalStrut(21));
		 boxText.add(tf4);
		 boxText.add(Box.createVerticalStrut(21));
		 thisp.add(boxLabel);thisp.add(boxText);
		 
		 thisp.add(btn1);thisp.add(bt2);
		 this.add(thisp);
		 
        }

	public JTextField getTf1() {
		return tf1;
	}

	public JTextField getTf2() {
		return tf2;
	}

	public JTextField getTf3() {
		return tf3;
	}

	public JTextField getTf4() {
		return tf4;
	}

	public JButton getBtn1() {
		return btn1;
	}
	}
