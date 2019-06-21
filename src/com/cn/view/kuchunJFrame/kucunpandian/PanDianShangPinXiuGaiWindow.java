package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import com.cn.control.kuchunframe.kucunpandian.xinzengshangpin.PanDianXinxiXiugaiOKAction;
import com.cn.view.kuchunJFrame.KucunPandian;

/**
 * 商品选择信息显示窗口
 * @author Administrator
 *
 */
public class PanDianShangPinXiuGaiWindow extends JWindow {
	private XinZengPanDianDanJDialog dialog;
	private KucunPandian kDialog;//库存盘点
	/*
	 * 标志不同的窗口
	 * 0:新增，1：为增加界面修改，2：为盘点界面新增
	 */
	private int flag;
	
	private JLabel labelBH;//商品编号
	private JLabel labelMC;//商品名称
	private JLabel labelKC;//商品库存
	private JLabel labelXH;//商品型号
	private JLabel labelDW;//商品单位
	private JTextField textSL;//盘点数量
	private JButton btnYes;//确定
	private JButton btnNo;//取消
	
	//添加盘点商品窗口，弹出商品信息修改
	public PanDianShangPinXiuGaiWindow(XinZengPanDianDanJDialog dialog,int flag){
		super(dialog);
		this.dialog = dialog;
		this.flag = flag;
		init();
	}
	//盘点主界面窗口，弹出商品信息修改
	public PanDianShangPinXiuGaiWindow(KucunPandian kDialog){
		super(kDialog);
		this.kDialog = kDialog;
		init();
	}
	
	public KucunPandian getKDialog() {
		return kDialog;
	}
	public int getFlag() {
		return flag;
	}
	public XinZengPanDianDanJDialog getDialog() {
		return dialog;
	}
	public JLabel getLabelBH() {
		return labelBH;
	}
	public JLabel getLabelMC() {
		return labelMC;
	}
	public JLabel getLabelKC() {
		return labelKC;
	}
	public JLabel getLabelXH() {
		return labelXH;
	}
	public JLabel getLabelDW() {
		return labelDW;
	}
	public JTextField getTextSL() {
		return textSL;
	}
	public JButton getBtnYes() {
		return btnYes;
	}
	public JButton getBtnNo() {
		return btnNo;
	}
	
	private void init(){
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(add());
	}
	private JPanel add(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4,1));
		
		JPanel jpanel1 = new JPanel();
		JLabel label1 = new JLabel("商品编号：");
		labelBH = new JLabel();
		labelBH.setPreferredSize(new Dimension(60,20));
		JLabel label2 = new JLabel("商品名称：");
		labelMC = new JLabel();
		labelMC.setPreferredSize(new Dimension(80,20));
		jpanel1.add(label1);
		jpanel1.add(labelBH);
		jpanel1.add(label2);
		jpanel1.add(labelMC);
		
		JPanel jpanel2 = new JPanel();
		JLabel label3 = new JLabel("商品库存：");
		labelKC = new JLabel( );
		labelKC.setPreferredSize(new Dimension(60,20));
		labelKC.setForeground(Color.RED);
		JLabel label4 = new JLabel("商品型号：");
		labelXH = new JLabel( );
		labelXH.setPreferredSize(new Dimension(80,20));
		jpanel2.add(label3);
		jpanel2.add(labelKC);
		jpanel2.add(label4);
		jpanel2.add(labelXH);
		
		JPanel jpanel3 = new JPanel();
		JLabel label5 = new JLabel("商品单位：");
		labelDW = new JLabel( );
		labelDW.setPreferredSize(new Dimension(60,20));
		JLabel label6 = new JLabel("商品数量：");
		textSL = new JTextField(7);
		textSL.setText("5"); 
		textSL.setEditable(true);
		jpanel3.add(label5);
		jpanel3.add(labelDW);
		jpanel3.add(label6);
		jpanel3.add(textSL);
		
		JPanel jpanel4 = new JPanel();
		jpanel4.setLayout(new FlowLayout(FlowLayout.RIGHT,30 ,20));
		
		btnYes = new JButton("确定");
		btnNo = new JButton("取消");
		jpanel4.add(btnYes);
		jpanel4.add(btnNo);
		
		{
			btnYes.addActionListener(new PanDianXinxiXiugaiOKAction(this));
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					PanDianShangPinXiuGaiWindow.this.dispose();
				}
			});
		}
		
		{
			jpanel.add(jpanel1);
			jpanel.add(jpanel2);
			jpanel.add(jpanel3);
			jpanel.add(jpanel4);
		}
		return jpanel;
	}
	
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		new PanDianShangPinXiuGaiWindow(null).setVisible(true);
	}
*/
}
