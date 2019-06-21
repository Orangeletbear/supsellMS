package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.kuchunframe.kucundiaobo.TanChuXinXiOKAction;
import com.cn.util.GBC;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * 单击商品信息行所弹出的商品信息窗口
 * 
 * @author Administrator
 *
 */
public class AddShangPinXinXiDialog extends JDialog {
	private AddSanPingDialog dialog;//父窗口
	private int flag;//标志父窗口
	
	
	private JLabel labelSPBH;//商品编号
	private JLabel labelGGXH;//规格型号
	private JLabel labelSCCS;//生产厂商
	private JLabel labelDQKC;//当前库存
	private JLabel labelSPMC;//商品名称
	private JLabel labelYS;//颜色
	private JLabel labelBZ;//备注
	private JLabel labelCBDJ;//成本单价
	private JTextField textDBSL;//调拨数量
	private JLabel labelDW;
//	private JComboBox comboDW;//单位
	
	private JButton btnYes;//确定
	private JButton btnNo;//取消
	public AddSanPingDialog getDialog() {
		return dialog;
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

	public JLabel getLabelCBDJ() {
		return labelCBDJ;
	}

	public JTextField getTextDBSL() {
		return textDBSL;
	}

	public JLabel getLabelDW() {
		return labelDW;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}
	
	//获取label上的信息进行设置
	
	public int getFlag() {
		return flag;
	}

//	public AddShangPinXinXiDialog(AddSanPingDialog dialog,String title,boolean b){
//		super(dialog,title,b);
//		this.dialog = dialog;
//		init();
//	}
	
	/*
	 * 新增与修改
	 * 1为修改，0为新增
	 */
	public AddShangPinXinXiDialog(AddSanPingDialog dialog,String title,boolean b,int flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
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
		label4.setForeground(Color.RED);
		layout.setConstraints(label4, new GBC(0,3));
		cenJpanel.add(label4);
		
		JLabel label5= new JLabel("商品数量:  ");//调拨数量
		label5.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label5, new GBC(0,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label5);
		
		JLabel label6= new JLabel("商品名称:  ");//商品名称
		label6.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label6, new GBC(2,0));
		cenJpanel.add(label6);
		
		JLabel label7= new JLabel("单位:  ");//单位
		label7.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label7, new GBC(2,1));
		cenJpanel.add(label7);
		
		JLabel label8= new JLabel("颜色:  ");//颜色
		label8.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label8, new GBC(2,2));
		cenJpanel.add(label8);
		
		JLabel label9= new JLabel("备注:  ");//备注
		label9.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label9, new GBC(2,3));
		cenJpanel.add(label9);
		
		JLabel label10= new JLabel("成本单价:  ");//成本单价
		label10.setPreferredSize(new Dimension(80,30));
		label10.setForeground(Color.RED);
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
		labelDQKC.setForeground(Color.RED);
		layout.setConstraints(labelDQKC, new GBC(1,3));
		cenJpanel.add(labelDQKC);
		
		textDBSL = new JTextField(5);
		textDBSL.setPreferredSize(new Dimension(60,20));
		textDBSL.setText("10");
		layout.setConstraints(textDBSL, new GBC(1,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textDBSL);
		
		labelSPMC = new JLabel();
		labelSPMC.setPreferredSize(new Dimension(60,20));
		labelSPMC.setEnabled(false);
		layout.setConstraints(labelSPMC, new GBC(3,0));
		cenJpanel.add(labelSPMC);
		
//		comboDW = new JComboBox(items);//暂时采用label表示
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
		
		labelCBDJ = new JLabel();
		labelCBDJ.setPreferredSize(new Dimension(60,20));
		labelCBDJ.setForeground(Color.RED);
		layout.setConstraints(labelCBDJ, new GBC(3,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(labelCBDJ);
		
		return cenJpanel;
	}

	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		
		btnYes = new JButton("确  定(F5)");
		btnNo = new JButton("取  消(F4)");
		{	
			//确定后将商品信息窗口的信息全部加到所选列表中去
			btnYes.addActionListener(new TanChuXinXiOKAction(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AddShangPinXinXiDialog.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnYes);
			souJpanel.add(btnNo);
		}
		return souJpanel;
	}
	
	//===========================测试
		public static void main(String [] args){
			new AddShangPinXinXiDialog(null,"测试",true,1).setVisible(true);
		}
}
