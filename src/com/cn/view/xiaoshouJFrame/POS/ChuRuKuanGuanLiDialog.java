package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.wanglaizhangwu.WangLaiZhangWuDialog;

/**
 * POS收银员出入款管理对话框
 * @author Administrator
 *
 */
public class ChuRuKuanGuanLiDialog extends JDialog {
    
	//panel_north
	private JButton ruKuanButton = new JButton(new ImageIcon("res/AcionIcon/rukuan.jpg"));
	private JButton chuKuanButton = new JButton(new ImageIcon("res/AcionIcon/chukuan.jpg"));
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	//panel_center
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	
	private JButton riQiButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	private JComboBox namesBox = new JComboBox(new String[] {"所有收银员名称","pos","04"});
	private JButton chaXunButton = new JButton("查询");
	private Vector data = new Vector();//table 数据
	private Vector<String> cloumnNames = new Vector<String>();//table 列名
	
	
	
	public ChuRuKuanGuanLiDialog(JFrame parent,String title,boolean model) {
		
		super(parent,title,model);
		init();
	}
	public void init() {
		this.setSize(700,550);
		this.setResizable(false);
		this.add( keHuFuKuanMingXi());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private JPanel keHuFuKuanMingXi(){
		JPanel keHuFuKuanMingXi = new JPanel();
		
		keHuFuKuanMingXi.setLayout(new BorderLayout());
		keHuFuKuanMingXi.add(panel_north(),BorderLayout.NORTH);
		keHuFuKuanMingXi.add(panel_center(),BorderLayout.CENTER);
		return keHuFuKuanMingXi;
	}
	//
	//panel_north
	private JPanel panel_north(){
		JPanel panel_north = new JPanel();
		
		ruKuanButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		chuKuanButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		
		panel_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel_north.add(ruKuanButton);
		panel_north.add(chuKuanButton);
		panel_north.add(daoChuButton);
		panel_north.add(daYinButton);
		panel_north.add(tuiChuButton);
		ruKuanButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new POSLuKuangDialog(ChuRuKuanGuanLiDialog.this,"入款",true);
			}
			
		});
		chuKuanButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new POSChuKuangDialog(ChuRuKuanGuanLiDialog.this,"出款",true);
			}
			
		});
		
		tuiChuButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ChuRuKuanGuanLiDialog.this.dispose();
			}
			
		});
		panel_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		return panel_north;
	}
	//panel_center 分为两部分
	private JPanel panel_center(){
		JPanel panel_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("查询日期 :"));
		pane1.add(dataPicker1);
		pane1.add(new JLabel("至 "));
		pane1.add(dataPicker2);
		riQiButton.setMargin(new Insets(0,0,0,0));
		pane1.add(riQiButton);
		pane1.add(new JLabel("客户名称 :"));
		pane1.add(namesBox);
		pane1.add(chaXunButton);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		//pane2
		cloumnNames.add("单号");
		cloumnNames.add( "开单日期");
		cloumnNames.add("入款金额");
		cloumnNames.add("出款金额");
		cloumnNames.add("单据类型");
		cloumnNames.add("收银员");
		cloumnNames.add("操作员");
	
		
		
		JTable table = new JTable(data,cloumnNames);
		table.setPreferredScrollableViewportSize(new Dimension(700,356));//表格固定大小
		pane2.add(new JScrollPane(table));
		
		panel_center.setLayout(new BorderLayout());
		panel_center.add(pane1,BorderLayout.NORTH);
		panel_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel_center;
	}
	public static void main(String[] args){
		new ChuRuKuanGuanLiDialog(null,"POS出入款管理",true);
	}
	
}
