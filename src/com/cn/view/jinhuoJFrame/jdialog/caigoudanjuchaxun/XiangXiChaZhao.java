package com.cn.view.jinhuoJFrame.jdialog.caigoudanjuchaxun;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.CaiGouDanJuChaXun;

public class XiangXiChaZhao extends JDialog{
	//第一部分
	
	private JTextField gonghuoshang = new JTextField(10);
	private JButton fangdajing = new JButton(new ImageIcon("res/AcionIcon/cha.jpg"));
	private JDatePicker kaidanriqi = new JDatePicker();
	private JDatePicker zhi = new JDatePicker();
	private JComboBox cangkumingcheng = new JComboBox();
	private JComboBox caozuoyuan = new JComboBox();
	//第二部分
	private JButton queding = new JButton("确定");
	
	public XiangXiChaZhao(CaiGouDanJuChaXun dialog,String title,boolean model){
		super(dialog,title,model);
		init();
	}
	private void init(){
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		this.add(pane(),BorderLayout.CENTER);
		this.add(panel2(),BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	
	//第一部分
	private JPanel pane(){
		JPanel pane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		//
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT,17,4));
		panel1.add(new JLabel("供货商："));
		panel1.add(gonghuoshang);
		fangdajing.setMargin(new Insets(0,0,0,0));
		panel1.add(fangdajing);
		//
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel2.add(new JLabel("开单日期："));
		panel2.add(kaidanriqi);
		//
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT,29,4));
		panel3.add(new JLabel("至："));
		panel3.add(zhi);
		//
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel4.add(new JLabel("仓库名称："));
		cangkumingcheng.setPreferredSize(new Dimension(120,20));
		panel4.add(cangkumingcheng);
		//
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT,15,4));
		panel5.add(new JLabel("操作员："));
		caozuoyuan.setPreferredSize(new Dimension(120,20));
		panel5.add(caozuoyuan);
		//
		
		pane.setLayout(new GridLayout(5,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		
		return pane;
	}
	//第二部分
	
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		panel2.add(queding);
		
		JButton tuichu = new JButton("退出");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				XiangXiChaZhao.this.dispose();
			}
		});
		panel2.add(tuichu);
		
		return panel2;
	}
	

	
	
	
	
	public static void main(String[] args){
		new XiangXiChaZhao((CaiGouDanJuChaXun)null,"查找",true);
		
	}
}
