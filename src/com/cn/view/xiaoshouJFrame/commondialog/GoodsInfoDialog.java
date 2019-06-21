package com.cn.view.xiaoshouJFrame.commondialog;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * 商品信息对话框
 * @author Administrator
 *
 */
public class GoodsInfoDialog extends JDialog {

	//商品编号
	private JLabel spID = new JLabel();
	//规格型号
	private JLabel guiGeXingHao = new JLabel();
	//生产厂商
	private JLabel changShang = new JLabel();
	//当前库存
	private JLabel kuCun = new JLabel();
	//商品名称
	private JLabel goodsName = new JLabel();
	//单位
	private JComboBox danWei = new JComboBox(new String[] {"瓶","件","箱"});
	//颜色
	private JLabel color = new JLabel();
	//当前库存
	private JLabel kucun = new JLabel();
	//备注
	private JLabel beiZhu = new JLabel();
	//参考售价
	private JTextField shouJieText = new JTextField(8);
	//打折率
	private JTextField daZheText = new JTextField(6);
	//数量
	private JTextField shuLiangText = new JTextField(6);
	//折后单价
	private JLabel zhdjLabel = new JLabel();
	//总价
	private JLabel zjLable = new JLabel();
	
	private JButton sureButton = new JButton("确定(F5)");
	private JButton exitButton = new JButton("退出(F4)");
	
	public GoodsInfoDialog(JDialog dialog,String title,boolean model) {
		super(dialog,title,model);
		init();
	}
	
	public void init() {
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(createPanel(),BorderLayout.CENTER);
		this.add(createSouthPanel(),BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public JPanel createSouthPanel(){
		JPanel southPanel = new JPanel();
		southPanel.add(sureButton);
		southPanel.add(exitButton);
		return southPanel;
	}
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("商品编号:"));
		box1.add(spID);
		box1.add(Box.createHorizontalStrut(80));
		box1.add(new JLabel("商品名称:"));
		box1.add(goodsName);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("规格型号:"));
		box2.add(guiGeXingHao);
		box2.add(Box.createHorizontalStrut(40));
		box2.add(new JLabel("单位:"));
		box2.add(danWei);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("生产厂商:"));
		box3.add(changShang);
		box3.add(Box.createHorizontalStrut(40));
		box3.add(new JLabel("颜色:"));
		box3.add(color);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("当前库存:"));
		box4.add(kucun);
		box4.add(Box.createHorizontalStrut(40));
		box4.add(new JLabel("备注:"));
		box4.add(beiZhu);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("参考售价:"));
		box5.add(shouJieText);
		box5.add(new JLabel("元"));
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("打折率:"));	
		box5.add(daZheText);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("数量:"));
		box5.add(shuLiangText);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("折后单价:"));
		box6.add(zhdjLabel);
		box6.add(new JLabel("元"));
		box6.add(Box.createHorizontalStrut(20));

		JLabel label = new JLabel("1为不打折,0.8为打8折");
		label.setForeground(Color.RED);
		box6.add(label);
		box6.add(new JLabel("总计:"));
		box6.add(zjLable);
		box6.add(new JLabel("元"));
		
		Box box = Box.createVerticalBox();
		box.add(box1);
		box.add(Box.createVerticalStrut(30));
		box.add(box2);
		box.add(Box.createVerticalStrut(30));
		box.add(box3);
		box.add(Box.createVerticalStrut(30));
		box.add(box4);
		box.add(Box.createVerticalStrut(30));
		box.add(box5);
		box.add(Box.createVerticalStrut(30));
		box.add(box6);
		box.add(Box.createVerticalStrut(30));
		
		panel.add(box);
		panel.setBorder(new TitledBorder("商品信息"));
		return panel;
	}
	
	public static void main(String[] args){
		new GoodsInfoDialog(null,"商品信息",true);
	}
}
