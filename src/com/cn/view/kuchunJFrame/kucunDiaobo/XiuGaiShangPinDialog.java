package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.kuchunframe.baosunbaoyi.XiuGaiOKAction;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * 商品在主窗口修改对话框
 * @author Administrator
 *
 */
public class XiuGaiShangPinDialog extends JDialog {
	private KucunDiaobo kDialog;
	private BaosunBaoyi bDialog;
	
	private JLabel labelMC;//商品名称
	private JLabel labelDW;//单位
	private JLabel labelGGXH;//规格型号
	private JLabel labelYS;//颜色
	private JLabel labelDJ;//单价
	private JTextField textSL;//数量
	private JButton btnYes;//确定
	private JButton btnNo;//取消
//	private JLabel labelZJE;//总金额
//	private JLabel labelBZ;//备注
	
	/////////////////////////////
	public JLabel getLabelMC() {
		return labelMC;
	}
	public JLabel getLabelDW() {
		return labelDW;
	}
	public JLabel getLabelGGXH() {
		return labelGGXH;
	}
	public JLabel getLabelYS() {
		return labelYS;
	}
	public JLabel getLabelDJ() {
		return labelDJ;
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
	////////父窗口获取
	public KucunDiaobo getkDialog() {
		return kDialog;
	}
	public BaosunBaoyi getbDialog() {
		return bDialog;
	}
	///////////库存调拨
	public XiuGaiShangPinDialog(KucunDiaobo dialog,String title,boolean b){
		super(dialog,title,b);
		kDialog = dialog;
		init();
	}
	/////////报损报溢
	public XiuGaiShangPinDialog(BaosunBaoyi dialog,String title,boolean b){
		super(dialog,title,b);
		bDialog = dialog;
		init();
	}
	private void  init(){
		this.setSize(360,240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	public JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5,4,10,30));
		
			labelMC = new JLabel("名称");
			labelDW = new JLabel("单位");
			labelGGXH = new JLabel("规格");
			labelYS = new JLabel("颜色");
			labelDJ = new JLabel("单价");
			textSL = new JTextField(8);
			textSL.setPreferredSize(new Dimension(30,18));
//			labelZJE = new JLabel("总金额");
//			labelBZ = new JLabel("备注");
			
			btnYes = new JButton("确  定");//确定按钮的监听器应该是数据的更新
			{
				btnYes.addActionListener(new XiuGaiOKAction(this));
			}
			btnNo = new JButton("取  消");
			{
				btnNo.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						XiuGaiShangPinDialog.this.dispose();
					}
				});
			}
			
			JLabel label1 = new JLabel("商品名称：");
			JLabel label2 = new JLabel("商品单位：");
			JLabel label3 = new JLabel("商品规格：");
			JLabel label4 = new JLabel("商品颜色：");
			JLabel label5 = new JLabel("商品单价：");
			JLabel label6 = new JLabel("商品数量：");
			JLabel label7 = new JLabel("商品金额：");
			JLabel label8 = new JLabel("备    注：");
		
		{
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			
			jpanel.add(label1);
			jpanel.add(labelMC);
			jpanel.add(label2);
			jpanel.add(labelDW);
			
			jpanel.add(label3);
			jpanel.add(labelGGXH);
			jpanel.add(label4);
			jpanel.add(labelYS);
			
			jpanel.add(label5);
			jpanel.add(labelDJ);
			jpanel.add(label6);
			jpanel.add(textSL);
			
		/*	jpanel.add(label7);
			jpanel.add(labelZJE);
			jpanel.add(label8);
			jpanel.add(labelBZ);*/
			
			jpanel.add(new JLabel());
			jpanel.add(btnYes);
			jpanel.add(btnNo);
			jpanel.add(new JLabel());
		}
		
		return jpanel;
	}
	
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		new XiuGaiShangPinDialog(null,"修改商品",true).setVisible(true);
	}*/
}
