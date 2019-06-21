package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;

/**
 * POS销售流水账对话框
 * 
 * @author Administrator
 *
 */
public class XiaoShouLiuShuiZhangDialog extends JDialog {

	/*
	 * 初始化销售流水账上单据流水表选项卡的组件
	 */
	
	private JPanel danJuPanel;//单据流水表选项卡上的面板
	
	
	private JButton chaKanDanJuButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	/*private  JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private TimeSpinnerPanel timeSpinner1 = new TimeSpinnerPanel();
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private TimeSpinnerPanel timeSpinner2 = new TimeSpinnerPanel();
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));*/
	private JComboBox shouYinYuanBox = new JComboBox(new String[] {"所有收银员","pos","04"});
	private JComboBox jingBanRenBox = new JComboBox(new String[] {"所有经办人","p小张","小李"});
	private JButton chaXunButton = new JButton("查询");
	
	private JTable table;
	
	/*
	 * 初始化销售流水账上商品明细表选项卡面板上的组件
	 */
	
	private JPanel mingXiPanel ;
	
	private JButton daoChuButton1 = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	private JButton daYinButton1 = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	private JButton exitButton1 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
    private TimeSpinnerPanel timeChaXun = new TimeSpinnerPanel();
	private JTextField chaXunText = new JTextField(10);
	private JButton chaXunButton2 = new JButton("查询");
	
	private JTable table2;
	
	/*
	 * 
	 */
	
	public XiaoShouLiuShuiZhangDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
	}
	public void init(){
		this.setSize(950, 550);
		//this.setResizable(false);
		tabbedPane();
		this.setVisible(true);
	}
	
	public void tabbedPane(){
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("单据流水表",danJuPanel());
		tabbedPane.addTab("商品明细表",mingXiPanel());
		this.add(tabbedPane);
	}
	/**
	 * 单据流水表选项卡面板
	 * @return
	 */
	public JPanel danJuPanel() {
		danJuPanel = new JPanel();
		
		danJuPanel.setLayout(new BorderLayout());
		danJuPanel.add(createNorthPanel(),BorderLayout.NORTH);
		danJuPanel.add(createCenterPanel(),BorderLayout.CENTER);
		JLabel label = new JLabel("说明:优惠金额包括抹零金额及商品折扣优惠金额");
		label.setForeground(Color.BLUE);
		danJuPanel.add(label,BorderLayout.SOUTH);
		
		return danJuPanel;
	}
	
	/**
	 * 销售流水账上单据流水表选项卡北面面板上组件的布局
	 * @return northPanel
	 */
	public JPanel createNorthPanel(){
		JPanel northPanel = new JPanel();
		//northPanel.setLayout(new GridLayout(1,2));
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
/*		
		JPanel panel1  = new JPanel();
	     panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("查询时间:"));
		panel1.add(dataPicker1);
		panel1.add(timeSpinner1);
		panel1.add(new JLabel(" 至 "));
		panel1.add(dataPicker2);
		panel1.add(timeSpinner2);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		panel1.add(shiJianButton);*/
		
		JPanel panel2 = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		panel2.setLayout(layout);
		layout.setHgap(30);
		panel2.add(new JLabel("收银员:"));
		panel2.add(shouYinYuanBox);
		panel2.add(new JLabel("经办人:"));
		panel2.add(jingBanRenBox);
		panel2.add(chaXunButton);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(new TimeSpinnerPanel());
		panel3.add(panel2);
		
		chaKanDanJuButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(chaKanDanJuButton);
		northPanel.add(daoChuButton);
		northPanel.add(daYinButton);
		northPanel.add(exitButton);
		northPanel.add(panel3);
		
		return northPanel;
	}
	
	/**
	 * 销售流水账上单据流水表选项卡中间面板上组件的布局
	 * @return
	 */
	private JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel();
		
		table = new JTable(POSXiaoShouCulomnModel.obj,POSXiaoShouCulomnModel.danJuColumNames);
		JScrollPane scroll = new JScrollPane(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(950,356));//表格固定大小
		centerPanel.add(scroll);
		return centerPanel;
	}
	
	
	
	
	/**
	 * 商品明细表选项卡面板
	 * @return
	 */
	public JPanel mingXiPanel() {
		mingXiPanel = new JPanel();
		
		mingXiPanel.setLayout(new BorderLayout());
		mingXiPanel.add(createNorthPane(),BorderLayout.NORTH);
		mingXiPanel.add(createCenterPane(),BorderLayout.CENTER);
		
		return mingXiPanel;
	}
	
	
	/**
	 * 销售流水账上商品明细表表选项卡北面面板上组件的布局
	 * @param args
	 */
	
	public JPanel createNorthPane() {
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,2));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("按单据号/会员查询:"));
		panel1.add(chaXunText);
		panel1.add(chaXunButton2);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(timeChaXun);
		panel2.add(panel1);
		
	
		daoChuButton1.setMargin(new Insets(0,0,0,0));
		daYinButton1.setMargin(new Insets(0,0,0,0));
		exitButton1.setMargin(new Insets(0,0,0,0));
		northPane.add(daoChuButton1);
		northPane.add(daYinButton1);
		northPane.add(exitButton1);
		northPane.add(panel2);
		return northPane;
	}
	
	/**
	 * 销售流水账上商品明细表选项卡中间面板上组件的布局
	 * @return
	 */
	private JPanel createCenterPane(){
		JPanel centerPanel = new JPanel();
		
		table = new JTable(POSXiaoShouCulomnModel.obj,POSXiaoShouCulomnModel.mingXiColumNames);
		JScrollPane scroll = new JScrollPane(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(950,356));//表格固定大小
		centerPanel.add(scroll);
		return centerPanel;
	}
	//测试类
	public static void main(String[] args) {
	
		new XiaoShouLiuShuiZhangDialog(null,"销售流水账",true);
		

	}
}
