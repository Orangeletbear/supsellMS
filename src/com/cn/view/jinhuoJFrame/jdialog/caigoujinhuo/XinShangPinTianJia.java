package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.util.GBC;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;

/**
 * @author Administrator
 *
 */
public class XinShangPinTianJia extends JDialog{

	/*
	 * 父窗口
	 */
	CaiGouJinHuo dialog;

	//panel1
	private JTextField suoshuleibie = new JTextField(10);
	private JTextField shangpinbianhao = new JTextField(10);
	private JTextField shangpinmingcheng = new JTextField(10);
	private JTextField shangpintiaoma = new JTextField(10);
	private JTextField guigexinghao = new JTextField(10);
	private JTextField danwei = new JTextField(10);
	private JTextField kucunxiaxian = new JTextField(10);
	private JTextField yanse = new JTextField(10);
	private JTextField yushejinjia = new JTextField(10);
	private JTextField yusheshoujia = new JTextField(10);
	private JTextField shengchanchangshang = new JTextField(10);
	private JTextField beizhu = new JTextField(28);
	private JCheckBox shiyongbaozhiqi;
	private JTextField tian = new JTextField(6);
	private JButton fangdajing;
	//panel2
	//第一部分
	
	//第二部分
	private JCheckBox lianxuzengjia;
	private JButton queren;
	private JButton tuichu;
	public XinShangPinTianJia(JDialog jDialog,String title,boolean model){
		super(jDialog,title,model);
		this.dialog = (CaiGouJinHuo)jDialog;
		init();
	}
	
	private void init(){
		this.setSize(500, 450);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setLayout(new GridLayout(2,0));
		this.add(panel1());
		this.add(panel2());
		
		this.setVisible(true);
	}
	//panel1
	private JTabbedPane panel1(){
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.RED,1));//边框
		
		//
		GridBagLayout layout = new GridBagLayout();
		panel1.setLayout(new GridBagLayout());
		panel1.setLayout(layout);
		//layout.setConstraints(btn1, new GBC(0, 0).setInsets(2, 2, 2, 2));
	 
		JLabel label1 = new JLabel("所属类别:");
		JLabel label2 = new JLabel("商品编号:");
		JLabel label3 = new JLabel("商品名称:");
		JLabel label4 = new JLabel("商品条码:");
		JLabel label5 = new JLabel("规格型号:");
		JLabel label6 = new JLabel("单位:");
		JLabel label7 = new JLabel("库存下限:");
		JLabel label8 = new JLabel("颜色:");
		JLabel label9 = new JLabel("预设进价:");
		JLabel label10 = new JLabel("预设售价:");
		JLabel label11 = new JLabel("天");
		JLabel label12 = new JLabel("生产厂商:");
		JLabel label13 = new JLabel("备注:");
		
		layout.setConstraints(label1,new GBC(0,0,1,1));//所属类别
		panel1.add(label1);
		layout.setConstraints(suoshuleibie,new GBC(1,0,2,1));
		panel1.add(suoshuleibie);
		
		fangdajing = new JButton(new ImageIcon("res/AcionIcon/cha.jpg"));//放大镜
		fangdajing.setMargin(new Insets(0,0,0,0));
		layout.setConstraints(fangdajing,new GBC(3,0,1,1));
		panel1.add(fangdajing);
		
		layout.setConstraints(label2,new GBC(4,0,1,1));//商品编号
		panel1.add(label2);
		layout.setConstraints(shangpinbianhao,new GBC(5,0,2,1));
		panel1.add(shangpinbianhao);
		
		layout.setConstraints(label3,new GBC(0,1,1,1));//商品名称
		panel1.add(label3);
		layout.setConstraints(shangpinmingcheng,new GBC(1,1,2,1));
		panel1.add(shangpinmingcheng);
		
		layout.setConstraints(label4,new GBC(4,1,1,1));//商品条码
		panel1.add(label4);
		layout.setConstraints(shangpintiaoma,new GBC(5,1,2,1));
		panel1.add(shangpintiaoma);
		
		layout.setConstraints(label5,new GBC(0,2,1,1));//规格型号
		panel1.add(label5);
		layout.setConstraints(guigexinghao,new GBC(1,2,2,1));
		panel1.add(guigexinghao);
		
		layout.setConstraints(label6,new GBC(4,2,1,1));//单位
		panel1.add(label6);
		layout.setConstraints(danwei,new GBC(5,2,1,1));
		panel1.add(danwei);
		
		layout.setConstraints(label7,new GBC(0,3,1,1));//库存下限
		panel1.add(label7);
		layout.setConstraints(kucunxiaxian,new GBC(1,3,2,1));
		panel1.add(kucunxiaxian);
		
		layout.setConstraints(label8,new GBC(4,3,1,1));//颜色
		panel1.add(label8);
		layout.setConstraints(yanse,new GBC(5,3,2,1));
		panel1.add(yanse);
		
		layout.setConstraints(label9,new GBC(0,4,1,1));//预设进价
		panel1.add(label9);
		layout.setConstraints(yushejinjia,new GBC(1,4,2,1));
		panel1.add(yushejinjia);
		
		layout.setConstraints(label10,new GBC(4,4,1,1));//预设售价
		panel1.add(label10);
		layout.setConstraints(yusheshoujia,new GBC(5,4,2,1));
		panel1.add(yusheshoujia);
		
		shiyongbaozhiqi = new JCheckBox("使用保质期");
		layout.setConstraints(shiyongbaozhiqi,new GBC(0,5,2,1));//使用保质期
		panel1.add(shiyongbaozhiqi);
		
		layout.setConstraints(tian,new GBC(2,5,1,1));//天
		panel1.add(tian);
		layout.setConstraints(label11,new GBC(3,5,1,1));
		panel1.add(label11);
		
		layout.setConstraints(label12,new GBC(4,5,1,1));//生产厂商
		panel1.add(label12);
		layout.setConstraints(shengchanchangshang,new GBC(5,5,2,1));
		panel1.add(shengchanchangshang);
		
		layout.setConstraints(label13,new GBC(0,6,1,1));//备注
		panel1.add(label13);
		layout.setConstraints(beizhu,new GBC(1,6,4,1));
		panel1.add(beizhu);
		
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.add("商品信息", panel1);
		return tabPane;
	}
	//panel2
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		//第一部分，JTabbedPane包含的三个选项卡
		JTabbedPane tabPane = new JTabbedPane();
		
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		
		tabPane.add("多单位",pane1);
		tabPane.add("其他信息",pane2);
		tabPane.add("特价信息",pane3);
		
		
		
		//第二部分，包含   连续增加商品，确定，退出 按钮
		JPanel pane_south = new JPanel();
		
		lianxuzengjia = new JCheckBox("连续增加");
		queren = new JButton("确认");
		queren.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(shangpinmingcheng.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"商品名称不能为空");
					return;
				}
				if(shangpinbianhao.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"商品编号不能为空");
					return;
				}
				if(danwei.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"请选择商品单位");
					return;
				}
				//一切合法，向xinshangpinData 传数据
				/*
				 * 商品编号，商品名称，单价，类别，条码，单位，单位关系
				 * 预设进价，预设售价，规格型号，颜色，库存
				 * 是否特价商品，商品折扣，会员价，特价，
				 * 开始日期，结束日期，状态，打折率，生产厂商，仓库
				 */
				
			}
			
		});
		tuichu = new JButton("退出");
		tuichu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				XinShangPinTianJia.this.dispose();
			}
			
		});
		
		pane_south.setLayout(new FlowLayout(FlowLayout.LEFT,50,2));
		pane_south.add(lianxuzengjia);
		pane_south.add(queren);
		pane_south.add(tuichu);
		

		
		//
		panel2.setLayout(new BorderLayout());
		panel2.add(tabPane,BorderLayout.CENTER);
		panel2.add(pane_south,BorderLayout.SOUTH);
		
		return panel2;
	}
	
	public static void main(String[] args){
		new XinShangPinTianJia((JDialog)null,"增加商品",true);
	}

	public JTextField getSuoshuleibie() {
		return suoshuleibie;
	}

	public JTextField getShangpinbianhao() {
		return shangpinbianhao;
	}

	public JTextField getShangpinmingcheng() {
		return shangpinmingcheng;
	}

	public JTextField getShangpintiaoma() {
		return shangpintiaoma;
	}

	public JTextField getGuigexinghao() {
		return guigexinghao;
	}

	public JTextField getDanwei() {
		return danwei;
	}

	public JTextField getKucunxiaxian() {
		return kucunxiaxian;
	}

	public JTextField getYanse() {
		return yanse;
	}

	public JTextField getYushejinjia() {
		return yushejinjia;
	}

	public JTextField getYusheshoujia() {
		return yusheshoujia;
	}

	public JTextField getShengchanchangshang() {
		return shengchanchangshang;
	}

	public JTextField getBeizhu() {
		return beizhu;
	}

	public JCheckBox getShiyongbaozhiqi() {
		return shiyongbaozhiqi;
	}

	public JTextField getTian() {
		return tian;
	}

	public JButton getFangdajing() {
		return fangdajing;
	}

	public JCheckBox getLianxuzengjia() {
		return lianxuzengjia;
	}

	public JButton getQueren() {
		return queren;
	}

	public JButton getTuichu() {
		return tuichu;
	}
	
}
