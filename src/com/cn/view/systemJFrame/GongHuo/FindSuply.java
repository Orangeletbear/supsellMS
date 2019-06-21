 
	package com.cn.view.systemJFrame.GongHuo;

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
import com.cn.model.AllTableModel;
import com.cn.model.system.SuplyCulomns;
import com.cn.view.systemJFrame.GongHuoShang;
/*
 * 查找供应商对话框
 */
	public class FindSuply extends JDialog {

		private JTextField tex2;
		private JTextField tex1;
		private JTextField tex3;
		private JTextField tex4;
		private JButton jbx1;

		public FindSuply(GongHuoShang set, String title, boolean be) {
			super((JFrame)null,title,true);
			this.setSize(240,280);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			init();
			this.setVisible(true);
		}

		private void init() {
			JPanel thisp = new JPanel();
			 tex1 = new JTextField(21);
			 tex2 = new JTextField(21);
			 tex3 = new JTextField(21);tex3.setEditable(false);
			 tex4 = new JTextField(21);tex4.setEditable(false);
			 JLabel lab  = new JLabel("供货商名称:");
			 JLabel lab1 = new JLabel("联 系 人 : ");
			 JLabel lab2 = new JLabel("联系电话 ： ");
			 JLabel lab3 = new JLabel("仓库地址 ： ");
			  jbx1= new JButton("确认(F5)") ;
			  jbx1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					String Name;
					String lxr;
					Name = tex1.getText();
					lxr = tex2.getText();
					
					Vector data = SupllyDB.findSuplly(Name, lxr);
					((GongHuoShang)FindSuply.this.getOwner()).getSupplyModel().
					
					   setDataVector(data,AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
					FindSuply.this.dispose();
				}
				  
				  
			  });
			  
			  
			 JButton bt2 = new JButton("退出(F4)");
			  
			bt2.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					 FindSuply.this.dispose();
					
				}});
			 Box boxLabel = Box.createVerticalBox();
			 //boxLabel.add(Box.createVerticalStrut(1));
			 boxLabel.add(lab);
			 boxLabel.add(Box.createVerticalStrut(23));
			 boxLabel.add(lab1);
			 boxLabel.add(Box.createVerticalStrut(25));
			 boxLabel.add(lab2);
			 boxLabel.add(Box.createVerticalStrut(26));
			 boxLabel.add(lab3);
			// boxLabel.add(Box.createVerticalStrut(21));
			 Box boxText = Box.createVerticalBox();
			 boxText.add(Box.createVerticalStrut(21));
			 boxText.add(tex1); 
			 boxText.add(Box.createVerticalStrut(21));
			 boxText.add(tex2);
			 boxText.add(Box.createVerticalStrut(21));
			 boxText.add(tex3); 
			 boxText.add(Box.createVerticalStrut(21));
			 boxText.add(tex4);
			 boxText.add(Box.createVerticalStrut(21));
			 thisp.add(boxLabel);thisp.add(boxText);
			 
			 thisp.add(jbx1);thisp.add(bt2);
			 this.add(thisp);
			 
			
		}

		public JTextField getTe2() {
			return tex2;
		}

		public JTextField getTe1() {
			return tex1;
		}

		public JTextField getTe3() {
			return tex3;
		}

		public JTextField getTe4() {
			return tex4;
		}

		public JButton getJb1() {
			return jbx1;
		}

	}



