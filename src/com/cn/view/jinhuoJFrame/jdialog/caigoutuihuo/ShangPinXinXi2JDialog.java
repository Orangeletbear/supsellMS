package com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.jinhuoframe.caigoutuihuo.XiuGaiBtnActionListener;
import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.model.AllTableModel;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;

public class ShangPinXinXi2JDialog extends JDialog{
	/*
	 * 父窗口
	 */
	private TuiHuoShangPin dialog;
	private String argspid;

	//panel1
	private JLabel shangpinbianhao= new JLabel();
	private JLabel shangpinmingcheng= new JLabel();
	

	public AllTableModel getATM() {
		return ATM;
	}

	private JLabel guigexinghao= new JLabel();
	private JLabel jibendanwei= new JLabel();
	private JLabel shengchanchangshang= new JLabel();
	private JLabel yanse= new JLabel();
	private JLabel dangqiankucun= new JLabel();
	private JLabel beizhu= new JLabel();
	//
	private JComboBox xuanzedanwei = new JComboBox();
	private JTextField cankaojinjia = new JTextField(10);
	private JTextField shuliang = new JTextField(10);
	
	private JButton queren = new JButton("确认");
	
	//
	private AllTableModel ATM;//表model
	private Vector gonghuojilu_columnNames = ColumnNames.gonghuojilu_columnNames;//列名
	//
	
	/**
	 * spid来自双击表格中某行数据的spID
	 */
	public ShangPinXinXi2JDialog(JDialog dialog,String title,boolean model){
		super(dialog,title,model);//必须位于第一行

		this.dialog = (TuiHuoShangPin)dialog;
		
		int tmp = (this.dialog).getSplbtable().getSelectedRow();
		argspid = (String)((this.dialog).getATM().getValueAt(tmp, 0));
		this.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
				//初始化数据
				Vector v = JDBCShangPinXinXi.getData(argspid);
				//由于toString出现null不好办，所以用山寨版
				shangpinbianhao.setText(""+v.remove(0));
				
				shangpinmingcheng.setText(""+v.remove(0));
				shangpinmingcheng.setForeground(Color.RED);//商品名称设为红色字体
				
				guigexinghao.setText(""+v.remove(0));
				
				//一个数据同时赋给  基本单位  和  选择单位
				jibendanwei.setText(""+v.get(0));
				xuanzedanwei.addItem(""+v.remove(0));
				
				shengchanchangshang.setText(""+v.remove(0));
				yanse.setText(""+v.remove(0));
				
				dangqiankucun.setText(""+v.remove(0));
				dangqiankucun.setForeground(Color.RED);//当前库存设为红色字体
				
				beizhu.setText(""+v.remove(0));
				cankaojinjia.setText(""+v.remove(0));
			}
		});
		init();
	}
	
	private void init(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);//固定大小
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		this.add(panel1(),BorderLayout.NORTH);
	
		this.setVisible(true);
	}
//panel1
	private JPanel panel1(){
		JPanel panel1 = new JPanel();
		//
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new LineBorder(Color.GRAY,1) );//边框
		panel_center.setLayout(new GridLayout(4,0,1,10));
		panel_center.add(new JLabel("商品编号:"));
		panel_center.add(shangpinbianhao);
		panel_center.add(new JLabel("商品名称:"));
		panel_center.add(shangpinmingcheng);
		panel_center.add(new JLabel("规格型号:"));
		panel_center.add(guigexinghao);
		panel_center.add(new JLabel("基本单位:"));
		panel_center.add(jibendanwei);
		panel_center.add(new JLabel("生产厂商:"));
		panel_center.add(shengchanchangshang);
		panel_center.add(new JLabel("颜色:"));
		panel_center.add(yanse);
		panel_center.add(new JLabel("当前库存:"));
		panel_center.add(dangqiankucun);
		panel_center.add(new JLabel("备注:"));
		panel_center.add(beizhu);
		//
	JPanel panel_south = new JPanel();
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("选择单位"));
		xuanzedanwei.setPreferredSize(new Dimension(80,20));//设置comboBox大小，纯美观需求
		xuanzedanwei.setEditable(false);//设置comboBox不可编辑
		pane.add(xuanzedanwei);
		pane.add(new JLabel("参考进价"));
		pane.add(cankaojinjia);
		pane.add(new JLabel("数量"));
		shuliang.setText("1");//数量预设为1
		shuliang.setForeground(Color.RED);
		pane.add(shuliang);
		//
		JPanel pane2= new JPanel();
		JButton tuichu = new JButton("退出");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShangPinXinXi2JDialog.this.dispose();
			}
		});
		pane2.setLayout(new FlowLayout(FlowLayout.CENTER,60,1));
		//确认按钮上的大文章监听器
		queren.addActionListener(new XiuGaiBtnActionListener(this));
		pane2.add(queren);
		pane2.add(tuichu);
		
		panel_south.setLayout(new GridLayout(2,0));
		panel_south.setBorder(new LineBorder(Color.GRAY,1) );//边框
		panel_south.add(pane);
		panel_south.add(pane2);
		
	/////////////////////////////////	
		panel1.setLayout(new BorderLayout());
		panel1.add(panel_center,BorderLayout.CENTER);
		panel1.add(panel_south,BorderLayout.SOUTH);
		return panel1;
	}

	public String getArgspid() {
		return argspid;
	}

	public JLabel getBeizhu() {
		return beizhu;
	}

	public JTextField getCankaojinjia() {
		return cankaojinjia;
	}

	public JLabel getDangqiankucun() {
		return dangqiankucun;
	}

	public TuiHuoShangPin getDialog() {
		return dialog;
	}

	public Vector getGonghuojilu_columnNames() {
		return gonghuojilu_columnNames;
	}

	public JLabel getGuigexinghao() {
		return guigexinghao;
	}

	public JLabel getJibendanwei() {
		return jibendanwei;
	}

	public JButton getQueren() {
		return queren;
	}

	public JLabel getShangpinbianhao() {
		return shangpinbianhao;
	}

	public JLabel getShangpinmingcheng() {
		return shangpinmingcheng;
	}

	public JLabel getShengchanchangshang() {
		return shengchanchangshang;
	}

	public JTextField getShuliang() {
		return shuliang;
	}

	public JComboBox getXuanzedanwei() {
		return xuanzedanwei;
	}

	public JLabel getYanse() {
		return yanse;
	}
	
}