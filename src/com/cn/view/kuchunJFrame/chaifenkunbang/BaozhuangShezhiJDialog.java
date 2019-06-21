package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.chaifenkunbang.CFKB_TanChuChaXunActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi.BaoZhuangSheZhiOKActionListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.CFKBModel;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

	/**
	 * 商品包装设置窗体
	 * 用来设置大小包装商品之间的选择和设置
	 * @author Administrator
	 *
	 */

public class BaozhuangShezhiJDialog extends JDialog{
	private ChaifenKunbang dialog;
	private String flag;//标志不同窗口事件
	
	// 第一行组件
	private JComboBox comboSZCK1;//所在仓库
	private JTextField textSPBH1;//商品编号
	private JButton btnCX1;
	private JLabel labelSPName1;//商品名称
	private JLabel labelGGXH1;//规格型号
	private JLabel labelDW1;//DW
	private JLabel labelYS1;//颜色

	// 第二行组件
	private JComboBox comboSZCK2;//所在仓库
	private JTextField textSPBH2;//商品编号
	private JButton btnCX2;
	private JLabel labelSPName2;//商品名称
	private JLabel labelGGXH2;//规格型号
	private JLabel labelDW2;//DW
	private JLabel labelYS2;//颜色
	
	//第三行组件
	private JTextField textZFBL;//折分比率
	private JButton btnYes;//确定
	private JButton btnNo;//取消
	
	//////////////////////////////-------------------------
	public ChaifenKunbang getDialog() {
		return dialog;
	}

	public String getFlag() {
		return flag;
	}

	public JComboBox getComboSZCK1() {
		return comboSZCK1;
	}

	public JTextField getTextSPBH1() {
		return textSPBH1;
	}

	public JButton getBtnCX1() {
		return btnCX1;
	}

	public JLabel getLabelSPName1() {
		return labelSPName1;
	}

	public JLabel getLabelGGXH1() {
		return labelGGXH1;
	}

	public JLabel getLabelDW1() {
		return labelDW1;
	}

	public JLabel getLabelYS1() {
		return labelYS1;
	}

	public JComboBox getComboSZCK2() {
		return comboSZCK2;
	}

	public JTextField getTextSPBH2() {
		return textSPBH2;
	}

	public JButton getBtnCX2() {
		return btnCX2;
	}

	public JLabel getLabelSPName2() {
		return labelSPName2;
	}

	public JLabel getLabelGGXH2() {
		return labelGGXH2;
	}

	public JLabel getLabelDW2() {
		return labelDW2;
	}

	public JLabel getLabelYS2() {
		return labelYS2;
	}

	public JTextField getTextZFBL() {
		return textZFBL;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public BaozhuangShezhiJDialog(ChaifenKunbang dialog,String title,boolean b,String flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
	}
	
	private void init(){
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	//将主面板划为3行
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(3,1));

		{
			jpanel.add(addFrist());
			jpanel.add(addSecond());
			jpanel.add(addThree());
//			jpanel.add(addFour());
		}
		
		return jpanel;
	}
	
	//第一行面板
	private JPanel addFrist(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new GridLayout(2,1));
		
		JPanel jpanel11 = new JPanel();
		JPanel jpanel12 = new JPanel();
		jpanel11.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		jpanel12.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		
		JLabel label1 = new JLabel("所在仓库：");
		JLabel label2 = new JLabel("商品编号：");
		JLabel label3 = new JLabel("商品名称：");
		JLabel label4 = new JLabel("规格型号：");
		JLabel label5 = new JLabel("单位：");
		JLabel label6 = new JLabel("颜色：");
		
		comboSZCK1 = new JComboBox(JDBCCuCunFind.getCanKuData());
		textSPBH1 = new JTextField(10);;
		labelSPName1 = new JLabel("          ");
		labelSPName1.setPreferredSize(new Dimension(80,20));
		labelGGXH1 = new JLabel("          ");
		labelDW1 = new JLabel("          ");
		labelYS1 = new JLabel("          ");
		btnCX1 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX1.setSize(new Dimension(30,30));
		btnCX1.setMargin(new Insets(0,0,0,0));
		//添加监听器
		{
			btnCX1.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		{
			jpanel11.add(label1);
			jpanel11.add(comboSZCK1);
			jpanel11.add(label2);
			jpanel11.add(textSPBH1);
			jpanel11.add(btnCX1);
		}
		
		{
			jpanel12.add(label3);
			jpanel12.add(labelSPName1);
			jpanel12.add(label4);
			jpanel12.add(labelGGXH1);
			jpanel12.add(label5);
			jpanel12.add(labelDW1);
			jpanel12.add(label6);
			jpanel12.add(labelYS1);
		}
		
		{
			jpanel1.add(jpanel11);
			jpanel1.add(jpanel12);
		}
		
		jpanel1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"大商品包装"));
		return jpanel1; 
	}
	
	//第二行面板
	private JPanel addSecond(){
		JPanel jpanel2 = new JPanel();
		
		jpanel2.setLayout(new GridLayout(2,1));
		
		JPanel jpanel21 = new JPanel();
		JPanel jpanel22 = new JPanel();
		jpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		jpanel22.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		
		JLabel label1 = new JLabel("所在仓库：");
		JLabel label2 = new JLabel("商品编号：");
		JLabel label3 = new JLabel("商品名称：");
		JLabel label4 = new JLabel("规格型号：");
		JLabel label5 = new JLabel("单位：");
		JLabel label6 = new JLabel("颜色：");
		
		comboSZCK2 = new JComboBox(JDBCCuCunFind.getCanKuData());
		textSPBH2 = new JTextField(10);
		labelSPName2 = new JLabel("          ");
		labelSPName2.setPreferredSize(new Dimension(80,20));
		labelGGXH2 = new JLabel("          ");
		labelDW2 = new JLabel("          ");
		labelYS2 = new JLabel("          ");
		btnCX2 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX2.setSize(new Dimension(30,30));
		btnCX2.setMargin(new Insets(0,0,0,0));
		//添加监听器
		{
			btnCX2.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		
		{
			jpanel21.add(label1);
			jpanel21.add(comboSZCK2);
			jpanel21.add(label2);
			jpanel21.add(textSPBH2);
			jpanel21.add(btnCX2);
		}
		
		{
			jpanel22.add(label3);
			jpanel22.add(labelSPName2);
			jpanel22.add(label4);
			jpanel22.add(labelGGXH2);
			jpanel22.add(label5);
			jpanel22.add(labelDW2);
			jpanel22.add(label6);
			jpanel22.add(labelYS2);
		}
		
		{
			jpanel2.add(jpanel21);
			jpanel2.add(jpanel22);
		}
		
		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"小商品包装"));
		return jpanel2; 
	}
	
	//第三行面板
	private JPanel addThree(){
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new GridLayout(3,1));
		
		JPanel jpanel31 = new JPanel();
		JPanel jpanel32 = new JPanel();
		JPanel jpanel33 = new JPanel();
		jpanel31.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
		jpanel33.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		
		JLabel label1 = new JLabel("折 分 比 率：");
		JLabel label2 = new JLabel("说明：拆分比率是指一件大包装商品与一件小包装商品的折分比例。" );
		JLabel label3 = new JLabel("如折分比率为10，则1件大包装商品可以拆分成10件小包装商品。");
		label2.setForeground(Color.RED);
		label3.setForeground(Color.RED);
		
		textZFBL = new JTextField(20);
		btnYes = new JButton("确定",new ImageIcon("res/AcionIcon/green.jpg"));
		btnYes.setMargin(new Insets(0,0,0,0));
		btnNo = new JButton("退出",new ImageIcon("res/AcionIcon/red.jpg"));
		btnNo.setMargin(new Insets(0,0,0,0));
		{
			btnYes.addActionListener(new BaoZhuangSheZhiOKActionListener(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BaozhuangShezhiJDialog.this.dispose();
				}
			});
		}
		
		{
		jpanel31.add(label1);	
		jpanel31.add(textZFBL);
		
		jpanel32.add(label2);
		jpanel32.add(label3);
		
		jpanel33.add(btnYes);
		jpanel33.add(btnNo);
		}
		{
			jpanel3.add(jpanel31);
			jpanel3.add(jpanel32);
			jpanel3.add(jpanel33);
		}
		
		return jpanel3; 
	}
	
	public static void main(String []args){
		new BaozhuangShezhiJDialog(null,"商品包装设置",true,"").setVisible(true);
	}
	
}
