package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 会员管理下的参数设置对话框
 * @author finey
 *
 */
public class HuiYuanCanShuSheZhi extends JDialog {
    //每积一分的消费金额
	private JTextField jiFenXiaoFeiE = new JTextField(10);
    
	//积分后的消费余额累计到下次消费
	private JCheckBox yuEBox = new JCheckBox("积分后的消费余额累计到下次消费");
	
	 //充值折兑比例
	private JTextField biLi = new JTextField(10);
	
	public HuiYuanCanShuSheZhi( HuiYanGuangLiFrame frame,String title){
		super(frame,title);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(350,350));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	
   private JPanel createPane(){
	    JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab = new JLabel("每积一分的消费金额:");
		tmpPane.add(lab);
		tmpPane.add(jiFenXiaoFeiE);
		jiFenXiaoFeiE.setText("20");
		JLabel lab1 = new JLabel("不能为零(默认20)");
		lab1.setForeground(Color.red);
		tmpPane.add(lab1);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(yuEBox);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("充值兑比例:");
		tmpPane.add(lab);
		tmpPane.add(biLi);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    lab = new JLabel("折兑比例=到账金额/支付金额");
	    lab.setForeground(Color.red);
		tmpPane.add(lab);
		centerPane.add(tmpPane);
		
		centerPane.setBorder(new TitledBorder("基本设置"));
		
		mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYuanCanShuSheZhi.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
   }
	
	
}
