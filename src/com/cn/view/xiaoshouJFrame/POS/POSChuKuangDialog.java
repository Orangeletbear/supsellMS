package com.cn.view.xiaoshouJFrame.POS;

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

import com.cn.dao.xiaoshou.XPOSJDBCControl;
/*
 * POS出款对话框
 */
public class POSChuKuangDialog extends JDialog {
	//收银员Box
	private JComboBox userName = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	//出款金额
	JTextField luKuangJinE = new JTextField(15);
	
	public POSChuKuangDialog(JDialog frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(300,200));
		this.setLayout(new GridLayout(3,1,20,5));
		
		JPanel pane  =new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab =new JLabel("收 银 员 :");
		pane.add(lab);
		pane.add(userName);
		this.add(pane);
		
		
		pane  =new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab =new JLabel("出款金额 :");
		pane.add(lab);
		luKuangJinE.setText("1000.00");
		pane.add(luKuangJinE);
		this.add(pane);

		
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				POSChuKuangDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		this.add(southPane,BorderLayout.SOUTH);
		
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}

}
