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
 * POS�������жԻ��� ,��������ѡ�����Ʒ�������У�
 * ����Ա�������У���Ʒ�����������
 * 
 * @author Administrator
 *
 */
public class SalesRankingDialog extends JDialog {
	
	/*
	 * ��Ʒ��������ѡ��ϵ����
	 */
	
	private JPanel tab1_panel = new JPanel();
	
	//��������ϵ����
	
	//��һ��ѡ����˻��ο���ť
	private JButton restockButton = new JButton(new ImageIcon("res/AcionIcon/jinhuochangkao.jpg"));
	//��һ��ѡ��Ľ����ο���ť
	private JButton returnButton = new JButton(new ImageIcon("res/AcionIcon/tuihuochangkao.jpg"));
	//��һ��ѡ��ĵ�����ť
	private JButton exportButton1 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��һ��ѡ��Ĵ�ӡ��ť
	private JButton printButton1 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//��һ��ѡ����˳���ť
	private JButton exitButton1 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //�м�����ϵ����
	
	//��һ��ѡ����˻��ο���ť�Ĳ�ѯʱ�����
	private TimeSpinnerPanel timeSpinner1 = new TimeSpinnerPanel();
	//��һ��ѡ���ʱ�䰴ť
	private JButton shiJianButton1 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//��һ��ѡ�����Ʒ�����ı���
	private JTextField goodText = new JTextField(10);
	//��һ��ѡ��Ĳ�ѯ��ť
	private JButton queryButton1 = new JButton("��ѯ(F2)");
	////��һ��ѡ��ı�
	private AllTableModel goodSalesRankingModel;
	private JTable goodSalesRankingTable;
	
	/*
	 * ����Ա��������ѡ��ϵ����
	 */
	JPanel tab2_panel = new JPanel();
	
	//��������ϵ����
	
	//�ڶ���ѡ��ĵ�����ť
	private JButton exportButton2 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//�ڶ���ѡ��Ĵ�ӡ��ť
	private JButton printButton2 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//�ڶ���ѡ����˳���ť
	private JButton exitButton2 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	
    //�м�����ϵ����
	
	//�ڶ���ѡ��Ĳ�ѯʱ�����
	private TimeSpinnerPanel timeSpinner2 = new TimeSpinnerPanel();
	//�ڶ���ѡ��Ĳ�ѯʱ�䰴ť
	private JButton shiJianButton2 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//�ڶ���ѡ�������ԱBox
	private JComboBox cashierNamesBox = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	//�ڶ���ѡ��Ĳ�ѯ��ť
	private JButton queryButton2 = new JButton("��ѯ(F2)");
	//�ڶ���ѡ��ı�
	private AllTableModel salesRankingModel;
	private JTable salesRankingTable;
	
	/*
	 * ��Ʒ�����������ѡ��ϵ����
	 */
	JPanel tab3_panel = new JPanel();

    //	��������ϵ����
	
	//������ѡ��ĵ�����ť
	private JButton exportButton3 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//������ѡ��Ĵ�ӡ��ť
	private JButton printButton3 = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//������ѡ����˳���ť
	private JButton exitButton3 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //�м�����ϵ����
	
	//������ѡ��Ĳ�ѯʱ�����
	private TimeSpinnerPanel timeSpinner3 = new TimeSpinnerPanel();
	//������ѡ��Ĳ�ѯʱ�䰴ť
	private JButton shiJianButton3 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//������ѡ�����Ʒ��������ı���
	private JComboBox categoryText = new JComboBox(JDBCCuCunFind.getSpLbData());
	//������ѡ��Ĳ�ѯ��ť
	private JButton queryButton3 = new JButton("��ѯ(F2)");
	//������ѡ��ı�
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
	 * �������ݳ�ʼ��
	 */
	private void initData(){
		//���µ�һ������
		String spID = this.getGoodText().getText();
		Vector data = XPOSJDBCControl.
		      getPOSSPXiaoShouPaiHangForNum("2000-1-1","2222-2-2",spID);
		getGoodSalesRankingModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.goodSalesRankingColumNames));
		//���µڶ�������
		data = XPOSJDBCControl.getPOSYeWuYuanXiaoShouPaiHang("2000-1-1","2222-2-2","");
		this.getSalesRankingModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.salesRankingColumNames));
		//���µ� ��������
		data = XPOSJDBCControl.getPOSSPLeiBieXiaoShouPaiHang("2000-1-1","2222-2-2","");
		this.getCategoryModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(
				   POSXiaoShouCulomnModel.categoryColumNames));
		
	}
	
	public void init() {
		this.setSize(920,600);
		this.setResizable(false);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("��Ʒ��������", initTab1_panel());
		tabbedPane.addTab("����Ա��������", initTab2_panel());
		tabbedPane.addTab("��Ʒ�����������", initTab3_panel());
		
		this.add(tabbedPane);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	/**
	 * ��Ʒ��������ѡ��ϵ�����Ĳ���
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
			
	        	  new JinHuoDialog(SalesRankingDialog.this,"�����ο�",true);
			}
			
		});
		returnButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
	        	  new TuiHuoDialog(SalesRankingDialog.this,"�˻��ο�",true);
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
		north.add(new JLabel("��ѯʱ��:"));
		north.add(timeSpinner1);
		shiJianButton1.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton1);
		north.add(new JLabel("��Ʒ����:"));
		north.add(goodText);
		goodText.setToolTipText("��Ϊ�������");
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
		goodSalesRankingTable.setPreferredScrollableViewportSize(new Dimension(900,356));//���̶���С
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	
	
	/**
	 * ����Ա��������ѡ��ϵ�����Ĳ���
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
		north.add(new JLabel("��ѯʱ��:"));
		north.add(timeSpinner2);
		shiJianButton2.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton2);
		north.add(new JLabel("����Ա����:"));
		north.add(cashierNamesBox);
		cashierNamesBox.addItem("��������Ա");
		cashierNamesBox.setSelectedItem("��������Ա");
		north.add(queryButton2);
		queryButton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String hyID = getCashierNamesBox().getSelectedItem().toString();
				if("��������Ա".equals(hyID)){
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
		salesRankingTable.setPreferredScrollableViewportSize(new Dimension(900,356));//���̶���С
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	
	/**
	 * ��Ʒ�����������ѡ��ϵ�����Ĳ���
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
		north.add(new JLabel("��ѯʱ��:"));
		north.add(timeSpinner3);
		shiJianButton3.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton3);
		north.add(new JLabel("�������:"));
		north.add(categoryText);
		north.add(queryButton3);
		categoryText.addItem("�������");
		categoryText.setSelectedItem("�������");
		queryButton3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String lbID = getCategoryText().getSelectedItem().toString();
				if("�������".equals(lbID)){
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
		categoryTable.setPreferredScrollableViewportSize(new Dimension(900,356));//���̶���С
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	//������
	public static void main(String[] args){
		new SalesRankingDialog(null,"POS��������",true);
	}
}
