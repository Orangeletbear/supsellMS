package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

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
import javax.swing.border.LineBorder;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.tongjiJFrame.Dialog.JinHuoDialog;
import com.cn.view.tongjiJFrame.Dialog.TuiHuoDialog;

/**
 * POS销售排行对话框 ,包含三个选项卡：商品销售排行，
 * 收银员销售排行，商品类别销售排行
 * 
 * @author Administrator
 *
 */
public class SalesRankingDialog extends JDialog {
	
	/*
	 * 商品销售排行选项卡上的组件
	 */
	
	private JPanel tab1_panel = new JPanel();
	
	//北部面板上的组件
	
	//第一个选项卡的退货参考按钮
	private JButton restockButton = new JButton(new ImageIcon("res/AcionIcon/jinhuochangkao.jpg"));
	//第一个选项卡的进货参考按钮
	private JButton returnButton = new JButton(new ImageIcon("res/AcionIcon/tuihuochangkao.jpg"));
	//第一个选项卡的导出按钮
	private JButton exportButton1 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第一个选项卡的打印按钮
	private JButton printButton1 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第一个选项卡的退出按钮
	private JButton exitButton1 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //中间面板上的组件
	
	//第一个选项卡的退货参考按钮的查询时间面板
	private TimeSpinnerPanel timeSpinner1 = new TimeSpinnerPanel();
	//第一个选项卡的时间按钮
	private JButton shiJianButton1 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//第一个选项卡的商品名称文本框
	private JTextField goodText = new JTextField(10);
	//第一个选项卡的查询按钮
	private JButton queryButton1 = new JButton("查询(F2)");
	////第一个选项卡的表
	private AllTableModel goodSalesRankingModel;
	private JTable goodSalesRankingTable;
	
	/*
	 * 收银员销售排行选项卡上的组件
	 */
	JPanel tab2_panel = new JPanel();
	
	//北部面板上的组件
	
	//第二个选项卡的导出按钮
	private JButton exportButton2 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第二个选项卡的打印按钮
	private JButton printButton2 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第二个选项卡的退出按钮
	private JButton exitButton2 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	
    //中间面板上的组件
	
	//第二个选项卡的查询时间面板
	private TimeSpinnerPanel timeSpinner2 = new TimeSpinnerPanel();
	//第二个选项卡的查询时间按钮
	private JButton shiJianButton2 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//第二个选项卡的收银员Box
	private JComboBox cashierNamesBox = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	//第二个选项卡的查询按钮
	private JButton queryButton2 = new JButton("查询(F2)");
	//第二个选项卡的表
	private AllTableModel salesRankingModel;
	private JTable salesRankingTable;
	
	/*
	 * 商品类别销售排行选项卡上的组件
	 */
	JPanel tab3_panel = new JPanel();

    //	北部面板上的组件
	
	//第三个选项卡的导出按钮
	private JButton exportButton3 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第三个选项卡的打印按钮
	private JButton printButton3 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第三个选项卡的退出按钮
	private JButton exitButton3 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //中间面板上的组件
	
	//第三个选项卡的查询时间面板
	private TimeSpinnerPanel timeSpinner3 = new TimeSpinnerPanel();
	//第三个选项卡的查询时间按钮
	private JButton shiJianButton3 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//第三个选项卡的商品类别名称文本框
	private JComboBox categoryText = new JComboBox(JDBCCuCunFind.getSpLbData());
	//第三个选项卡的查询按钮
	private JButton queryButton3 = new JButton("查询(F2)");
	//第三个选项卡的表
	private AllTableModel categoryModel;
	private JTable categoryTable;
	
	
	public JComboBox getCashierNamesBox() {
		return cashierNamesBox;
	}


	public AllTableModel getCategoryModel() {
		return categoryModel;
	}


	public JTable getCategoryTable() {
		return categoryTable;
	}


	public JComboBox getCategoryText() {
		return categoryText;
	}


	public AllTableModel getGoodSalesRankingModel() {
		return goodSalesRankingModel;
	}


	public JTable getGoodSalesRankingTable() {
		return goodSalesRankingTable;
	}


	public JTextField getGoodText() {
		return goodText;
	}


	public AllTableModel getSalesRankingModel() {
		return salesRankingModel;
	}


	public JTable getSalesRankingTable() {
		return salesRankingTable;
	}


	public JPanel getTab1_panel() {
		return tab1_panel;
	}


	public JPanel getTab2_panel() {
		return tab2_panel;
	}


	public TimeSpinnerPanel getTimeSpinner1() {
		return timeSpinner1;
	}


	public TimeSpinnerPanel getTimeSpinner2() {
		return timeSpinner2;
	}


	public TimeSpinnerPanel getTimeSpinner3() {
		return timeSpinner3;
	}


	public SalesRankingDialog(JFrame frame, String title,boolean model) {
		super(frame,title,model);
		init();
		
		
		
	}
	/*
	 * 界面数据初始化
	 */
	private void initData(){
		//更新第一个卡区
		String spID = this.getGoodText().getText();
		Vector data = XPOSJDBCControl.
		      getPOSSPXiaoShouPaiHangForNum("2000-1-1","2222-2-2",spID);
		getGoodSalesRankingModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.goodSalesRankingColumNames));
		//更新第二个卡区
		data = XPOSJDBCControl.getPOSYeWuYuanXiaoShouPaiHang("2000-1-1","2222-2-2","");
		this.getSalesRankingModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.salesRankingColumNames));
		//更新第 三个卡区
		data = XPOSJDBCControl.getPOSSPLeiBieXiaoShouPaiHang("2000-1-1","2222-2-2","");
		this.getCategoryModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.categoryColumNames));
		
	}
	
	public void init() {
		this.setSize(920,600);
		this.setResizable(false);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("商品销售排行", initTab1_panel());
		tabbedPane.addTab("收银员销售排行", initTab2_panel());
		tabbedPane.addTab("商品类别销售排行", initTab3_panel());
		
		this.add(tabbedPane);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	/**
	 * 商品销售排行选项卡上的组件的布局
	 */
	public JPanel initTab1_panel() {
		tab1_panel = new JPanel();
		tab1_panel.setLayout(new BorderLayout());
		tab1_panel.add(createNorthPanel1(),BorderLayout.NORTH);
		tab1_panel.add(createCenterPanel1(),BorderLayout.CENTER);
		
		return tab1_panel;
	}
	
	public JPanel createNorthPanel1(){
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new LineBorder(Color.GRAY));
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,1));
		
		restockButton.setMargin(new Insets(0,0,0,0));
		returnButton.setMargin(new Insets(0,0,0,0));
		exportButton1.setMargin(new Insets(0,0,0,0));
		printButton1.setMargin(new Insets(0,0,0,0));
		exitButton1.setMargin(new Insets(0,0,0,0));
		
		restockButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
	        	  new JinHuoDialog(SalesRankingDialog.this,"进货参考",true);
			}
			
		});
		returnButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
	        	  new TuiHuoDialog(SalesRankingDialog.this,"退货参考",true);
			}
		});
		exitButton1.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		northPanel.add(restockButton);
		northPanel.add(returnButton);
		northPanel.add(exportButton1);
		northPanel.add(printButton1);
		northPanel.add(exitButton1);
		
		return northPanel;
	}
	
	
	public JPanel createCenterPanel1(){
		JPanel centerPanel = new JPanel();
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		north.add(new JLabel("查询时间:"));
		north.add(timeSpinner1);
		shiJianButton1.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton1);
		north.add(new JLabel("商品名称:"));
		north.add(goodText);
		goodText.setToolTipText("空为查出所有");
		north.add(queryButton1);
		queryButton1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String spID = getGoodText().getText();
				
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
						getTimeSpinner1().getDataPicker1().
						getSelectedDate(),"yyyy-MM-dd");
					
					dateTo = DateConventer.dateToStr(
							getTimeSpinner1().getDataPicker2().
							getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				Vector data = XPOSJDBCControl.getPOSSPXiaoShouPaiHangForNum(
						dateFrom,dateTo,spID);
				System.out.println(data.size());
				getGoodSalesRankingModel().setDataVector(data,
				  AllTableModel.getVectorFromObj(
						  POSXiaoShouCulomnModel.goodSalesRankingColumNames));
			}
			
		});
		
		JPanel center = new JPanel();
		goodSalesRankingModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				                  POSXiaoShouCulomnModel.goodSalesRankingColumNames);
		goodSalesRankingTable = new JTable(goodSalesRankingModel);
		JScrollPane scroll = new JScrollPane(goodSalesRankingTable);
		goodSalesRankingTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		goodSalesRankingTable.setPreferredScrollableViewportSize(new Dimension(900,356));//表格固定大小
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	
	
	/**
	 * 收银员销售排行选项卡上的组件的布局
	 */
	public JPanel initTab2_panel() {
		tab2_panel = new JPanel();
		tab2_panel.setLayout(new BorderLayout());
		tab2_panel.add(createNorthPanel2(),BorderLayout.NORTH);
		tab2_panel.add(createCenterPanel2(),BorderLayout.CENTER);
		
		return tab2_panel;
	}
	
	public JPanel createNorthPanel2(){
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new LineBorder(Color.GRAY));
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,1));
		
		exportButton2.setMargin(new Insets(0,0,0,0));
		printButton2.setMargin(new Insets(0,0,0,0));
		exitButton2.setMargin(new Insets(0,0,0,0));
		
		northPanel.add(exportButton2);
		northPanel.add(printButton2);
		northPanel.add(exitButton2);
		exitButton2.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		return northPanel;
	}
	
	
	public JPanel createCenterPanel2(){
		JPanel centerPanel = new JPanel();
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		north.add(new JLabel("查询时间:"));
		north.add(timeSpinner2);
		shiJianButton2.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton2);
		north.add(new JLabel("收银员名称:"));
		north.add(cashierNamesBox);
		cashierNamesBox.addItem("所有收银员");
		cashierNamesBox.setSelectedItem("所有收银员");
		north.add(queryButton2);
		queryButton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String hyID = getCashierNamesBox().getSelectedItem().toString();
				if("所有收银员".equals(hyID)){
					hyID = "";
				}
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
						getTimeSpinner2().getDataPicker1().
						getSelectedDate(),"yyyy-MM-dd");
					
					dateTo = DateConventer.dateToStr(
							getTimeSpinner2().getDataPicker2().
							getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				Vector data = XPOSJDBCControl.getPOSYeWuYuanXiaoShouPaiHang(dateFrom,dateTo,hyID);
				getSalesRankingModel().setDataVector(data,
						   AllTableModel.getVectorFromObj(
								   POSXiaoShouCulomnModel.salesRankingColumNames));
				
				
			}
			
		});
		JPanel center = new JPanel();
		salesRankingModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				                 POSXiaoShouCulomnModel.salesRankingColumNames);
		salesRankingTable = new JTable(salesRankingModel);
		JScrollPane scroll = new JScrollPane(salesRankingTable);
		salesRankingTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		salesRankingTable.setPreferredScrollableViewportSize(new Dimension(900,356));//表格固定大小
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	
	/**
	 * 商品类别销售排行选项卡上的组件的布局
	 */
	
	public JPanel initTab3_panel(){
		tab3_panel = new JPanel();
		tab3_panel.setLayout(new BorderLayout());
		tab3_panel.add(createNorthPanel3(),BorderLayout.NORTH);
		tab3_panel.add(createCenterPanel3(),BorderLayout.CENTER);
		
		return tab3_panel;
	}
	
	public JPanel createNorthPanel3(){
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,1));
		northPanel.setBorder(new LineBorder(Color.GRAY));
		
		exportButton3.setMargin(new Insets(0,0,0,0));
		printButton3.setMargin(new Insets(0,0,0,0));
		exitButton3.setMargin(new Insets(0,0,0,0));
		
		northPanel.add(exportButton3);
		northPanel.add(printButton3);
		northPanel.add(exitButton3);
		
		exitButton3.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		return northPanel;
	}
	
	public JPanel createCenterPanel3(){
		JPanel centerPanel = new JPanel();
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		north.add(new JLabel("查询时间:"));
		north.add(timeSpinner3);
		shiJianButton3.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton3);
		north.add(new JLabel("类别名称:"));
		north.add(categoryText);
		north.add(queryButton3);
		categoryText.addItem("所有类别");
		categoryText.setSelectedItem("所有类别");
		queryButton3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String lbID = getCategoryText().getSelectedItem().toString();
				if("所有类别".equals(lbID)){
					lbID = "";
				}
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
						getTimeSpinner3().getDataPicker1().
						getSelectedDate(),"yyyy-MM-dd");
					
					dateTo = DateConventer.dateToStr(
							getTimeSpinner3().getDataPicker2().
							getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				Vector data = XPOSJDBCControl.getPOSSPLeiBieXiaoShouPaiHang(dateFrom,dateTo,lbID);
				getCategoryModel().setDataVector(data,
						   AllTableModel.getVectorFromObj(
								   POSXiaoShouCulomnModel.categoryColumNames));
				
				
			}
			
		});
		JPanel center = new JPanel();
		categoryModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				           POSXiaoShouCulomnModel.categoryColumNames);
		categoryTable = new JTable(categoryModel);
		JScrollPane scroll = new JScrollPane(categoryTable);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		categoryTable.setAutoCreateRowSorter(true);
		categoryTable.setPreferredScrollableViewportSize(new Dimension(900,356));//表格固定大小
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	//测试类
	public static void main(String[] args){
		new SalesRankingDialog(null,"POS销售排行",true);
	}
}
