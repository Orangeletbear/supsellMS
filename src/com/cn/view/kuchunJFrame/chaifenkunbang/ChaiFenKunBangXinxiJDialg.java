package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.ChaiFenKunBangXinXiOKBtnAction;
import com.cn.util.GBC;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class ChaiFenKunBangXinxiJDialg extends JDialog {
	
	private ChaifenKunbang dialog;
	private String flag;//区分拆分捆绑的标志
	
//	private static String []items = {"瓶","件","箱"}; 
	private JLabel labelSPBH;//商品编号
	private JLabel labelGGXH;//规格型号
	private JLabel labelSCCS;//生产厂商
	private JLabel labelDQKC;//当前库存
	private JLabel labelSPMC;//商品名称
	private JLabel labelYS;//颜色
	private JLabel labelBZ;//备注
	private JTextField textCFSL;//拆分数量
	private JTextField textCFDJ;//拆分单价
//	private JComboBox comboDW;//单位
	private JLabel labelDW;
	
	private JButton btnYes;//确定
	private JButton btnNo;//取消
	
	//获取label上的信息进行设置
	
	public ChaiFenKunBangXinxiJDialg(ChaifenKunbang dialog,String title,boolean b,String flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
	}
	
	public String getFlag() {
		return flag;
	}
	public JLabel getLabelSPBH() {
		return labelSPBH;
	}

	public JLabel getLabelGGXH() {
		return labelGGXH;
	}

	public JLabel getLabelSCCS() {
		return labelSCCS;
	}

	public JLabel getLabelDQKC() {
		return labelDQKC;
	}

	public JLabel getLabelSPMC() {
		return labelSPMC;
	}

	public JLabel getLabelYS() {
		return labelYS;
	}

	public JLabel getLabelBZ() {
		return labelBZ;
	}

	public JTextField getTextCFSL() {
		return textCFSL;
	}

	public JTextField getTextCFDJ() {
		return textCFDJ;
	}

//	public JComboBox getComboDW() {
//		return comboDW;
//	}
	
	public JButton getBtnYes() {
		return btnYes;
	}

	public JLabel getLabelDW() {
		return labelDW;
	}

	public JButton getBtnNo() {
		return btnNo;
	}
	
	public ChaifenKunbang getDialog() {
		return dialog;
	}

	private void init(){
		this.setSize(350, 260);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
//		jpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),""));
		return jpanel;
	}
	
	/**
	 * 中间部分的主面板
	 */
	private JPanel addCen(){
		JPanel cenJpanel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		cenJpanel.setLayout(layout);
		
		JLabel label1 = new JLabel("商品编号:  ");//商品编号
		label1.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label1, new GBC(0,0));
		cenJpanel.add(label1);
		
		JLabel label2= new JLabel("规格型号:  ");//规格型号
		label2.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label2, new GBC(0,1));
		cenJpanel.add(label2);
		
		JLabel label3= new JLabel("生产厂商:  ");//生产厂商
		label3.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label3, new GBC(0,2));
		cenJpanel.add(label3);
		
		JLabel label4= new JLabel("当前库存:  ");//当前库存
		label4.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label4, new GBC(0,3));
		cenJpanel.add(label4);
		
		JLabel label5= new JLabel("拆分单价:  ");//拆分单价
		label5.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label5, new GBC(0,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label5);
		
		JLabel label6= new JLabel("商品名称:  ");//商品名称
		label6.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label6, new GBC(2,0));
		cenJpanel.add(label6);
		
		JLabel label7= new JLabel("单        位:  ");//单位
		label7.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label7, new GBC(2,1));
		cenJpanel.add(label7);
		
		JLabel label8= new JLabel("颜       色:  ");//颜色
		label8.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label8, new GBC(2,2));
		cenJpanel.add(label8);
		
		JLabel label9= new JLabel("备        注:  ");//备注
		label9.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label9, new GBC(2,3));
		cenJpanel.add(label9);
		
		JLabel label10= new JLabel("拆分数量:  ");//成本单价
		label10.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label10, new GBC(2,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label10);
		
		
		labelSPBH = new JLabel();
		labelSPBH.setPreferredSize(new Dimension(60,20));
		labelSPBH.setEnabled(false);
		layout.setConstraints(labelSPBH, new GBC(1,0));
		cenJpanel.add(labelSPBH);
		
		labelGGXH = new JLabel();
		labelGGXH.setPreferredSize(new Dimension(60,20));
		labelGGXH.setEnabled(false);
		layout.setConstraints(labelGGXH, new GBC(1,1));
		cenJpanel.add(labelGGXH);
		
		labelSCCS = new JLabel();
		labelSCCS.setPreferredSize(new Dimension(60,20));
		labelSCCS.setEnabled(false);
		layout.setConstraints(labelSCCS, new GBC(1,2));
		cenJpanel.add(labelSCCS);
		
		labelDQKC = new JLabel();
		labelDQKC.setPreferredSize(new Dimension(60,20));
		labelDQKC.setEnabled(false);
		labelDQKC.setForeground(Color.RED);
		layout.setConstraints(labelDQKC, new GBC(1,3));
		cenJpanel.add(labelDQKC);
		
		textCFDJ = new JTextField(5);
		textCFDJ.setPreferredSize(new Dimension(60,20));
		textCFDJ.setText("1.0");
		layout.setConstraints(textCFDJ, new GBC(1,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textCFDJ);
		
		labelSPMC = new JLabel();
		labelSPMC.setPreferredSize(new Dimension(60,20));
		labelSPMC.setEnabled(false);
		layout.setConstraints(labelSPMC, new GBC(3,0));
		cenJpanel.add(labelSPMC);
		
//		comboDW = new JComboBox(items);
		labelDW = new JLabel();
		labelDW.setPreferredSize(new Dimension(60,20));
		layout.setConstraints(labelDW, new GBC(3,1));
		cenJpanel.add(labelDW);
		
		labelYS = new JLabel();
		labelYS.setPreferredSize(new Dimension(60,20));
		labelYS.setEnabled(false);
		layout.setConstraints(labelYS, new GBC(3,2));
		cenJpanel.add(labelYS);
		
		labelBZ = new JLabel();
		labelBZ.setPreferredSize(new Dimension(60,20));
		labelBZ.setEnabled(false);
		layout.setConstraints(labelBZ, new GBC(3,3));
		cenJpanel.add(labelBZ);
		
		textCFSL = new JTextField(5);
		textCFSL.setText("5");
		textCFSL.setPreferredSize(new Dimension(60,20));
		textCFSL.setForeground(Color.RED);
		layout.setConstraints(textCFSL, new GBC(3,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textCFSL);
		
		cenJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return cenJpanel;
	}

	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		
		btnYes = new JButton("确  定(F5)");
		btnNo = new JButton("取  消(F4)");
		{	
			//确定后将商品信息窗口的信息全部加到所选列表中去
			btnYes.addActionListener(new ChaiFenKunBangXinXiOKBtnAction(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					ChaiFenKunBangXinxiJDialg.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnYes);
			souJpanel.add(btnNo);
		}
		return souJpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChaiFenKunBangXinxiJDialg(null,"拆分商品信息",true,"").setVisible(true);
	}
}
