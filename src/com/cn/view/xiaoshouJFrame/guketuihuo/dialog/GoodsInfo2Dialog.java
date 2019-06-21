package com.cn.view.xiaoshouJFrame.guketuihuo.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.guketuihuo.GoodsInfo2Listener;
import com.cn.control.xiaoshouframe.guketuihuo.GoodsInfo2SureAction;

/**
 * 双击增加商品（销售退货）对话框
 * 右边表格时出现的商品信息对话框
 * @author Administrator
 *
 */
public class GoodsInfo2Dialog extends JDialog {

	//父窗口
	private  AddTuiHuoGoodsDialog dialog;
	
	//初始化时有数据，数据来源于父窗口上右边表格的数据
	public GoodsInfo2Dialog(AddTuiHuoGoodsDialog dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		this.addWindowListener(new GoodsInfo2Listener(this));
		init();
	}
	
	
	//商品编号
	private JLabel spId= new JLabel();
	//商品名称
	private JLabel spName= new JLabel();
	//规格型号
	private JLabel xingHao= new JLabel();
	//单位
	private JLabel danWei= new JLabel();
	//生产厂商
	private JLabel changShang= new JLabel();
	//颜色
	private JLabel color= new JLabel();
	//当前库存
	private JLabel kuCun= new JLabel();
	//备注
	private JLabel beiZhu= new JLabel();
	
	private JTextField danJia = new JTextField(10);
	private JTextField shuLiang = new JTextField(10);
	
	private JButton sure = new JButton("确认");
	
	
	private void init(){
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);//固定大小
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		
		
		this.setLayout(new BorderLayout());
		this.add(initCenterPanel(),BorderLayout.CENTER);
		this.add(createSouthPanel(),BorderLayout.SOUTH);
	
		this.setVisible(true);
		
	}
//panel1
	private JPanel initCenterPanel(){
		JPanel panel1 = new JPanel();
		//
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new TitledBorder("商品信息"));

		centerPanel.setLayout(new GridLayout(5,0,1,8));
		centerPanel.add(new JLabel("商品编号:"));
		centerPanel.add(spId);
		centerPanel.add(new JLabel("商品名称:"));
		centerPanel.add(spName);
		centerPanel.add(new JLabel("规格型号:"));
		centerPanel.add(xingHao);
		centerPanel.add(new JLabel("基本单位:"));
		centerPanel.add(danWei);
		centerPanel.add(new JLabel("生产厂商:"));
		centerPanel.add(changShang);
		centerPanel.add(new JLabel("颜       色:"));
		centerPanel.add(color);
		centerPanel.add(new JLabel("当前库存:"));
		centerPanel.add(kuCun);
		centerPanel.add(new JLabel("备       注:"));
		centerPanel.add(beiZhu);
		
		centerPanel.add(new JLabel("退货单价:"));
		centerPanel.add(danJia);
		centerPanel.add(new JLabel("数       量:"));
		centerPanel.add(shuLiang);
		
		return centerPanel;
	}

	
	public JPanel createSouthPanel(){
		JPanel southPanel = new JPanel();
		JButton exit = new JButton("退出");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GoodsInfo2Dialog.this.dispose();
			}
		});
		
		southPanel.add(sure);
		sure.addActionListener(new GoodsInfo2SureAction(dialog,this));
		southPanel.add(new JLabel("                        "));
		southPanel.add(exit);
		
		return southPanel;
	}
	
	public JLabel getSpName() {
		return spName;
	}
	public void setSpName(JLabel spName) {
		this.spName = spName;
	}
	public  AddTuiHuoGoodsDialog getDialog() {
		return dialog;
	}
	public JLabel getSpId() {
		return spId;
	}
	public JLabel getXingHao() {
		return xingHao;
	}
	public JLabel getDanWei() {
		return danWei;
	}
	public JLabel getChangShang() {
		return changShang;
	}
	public JLabel getColor() {
		return color;
	}
	public JLabel getKuCun() {
		return kuCun;
	}
	public JLabel getBeiZhu() {
		return beiZhu;
	}
	public JTextField getDanJia() {
		return danJia;
	}
	public JTextField getShuLiang() {
		return shuLiang;
	}
	public static void main(String[] args) {
		new GoodsInfo2Dialog(null,"");
	}


}
