package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import com.cn.dao.pos.POSJDBC;
import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;

/**
 * POS������ˮ�˶Ի���,�öԻ����������ѡ���
 *  ������ˮ�����Ʒ��ϸ��
 * 
 * @author Administrator
 *
 */
public class SellLedgerDialog extends JDialog {

	/*
	 * ��ʼ��������ˮ���ϵ�����ˮ��ѡ������
	 */
	
	private JPanel danJuPanel;//������ˮ��ѡ��ϵ����
	
	//��һ��ѡ��ϵĲ鿴���ݰ�ť
	private JButton seeDocumentsButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//��һ��ѡ��ϵĲ鿴������ť
	private JButton exportButton = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	//��һ��ѡ��ϵĴ�ӡ��ť
	private JButton printButton = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	//��һ��ѡ��ϵ��˳���ť
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//��һ��ѡ��ϵĲ�ѯʱ�䰴ť
	private JButton timeButton1 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//��һ��ѡ��ϵ�����ԱBox
	private JComboBox cashierBox = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	private JComboBox jingBanRenBox = new JComboBox(POSJDBC.getAllWorker());
	private JButton queryButton = new JButton("��ѯ");
	
	private TimeSpinnerPanel timePane;
	
	public TimeSpinnerPanel getTimePane() {
		return timePane;
	}
	private AllTableModel tableModel;
	private JTable table;
	
	/*
	 * ��ʼ��������ˮ������Ʒ��ϸ��ѡ�����ϵ����
	 */
	
	private JPanel mingXiPanel ;
	
	//�ڶ���ѡ��ĵ�����ť
	private JButton exportButton1 = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	//�ڶ���ѡ��Ĵ�ӡ��ť
	private JButton printButton1 = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	//�ڶ���ѡ����˳���ť
	private JButton exitButton1 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//�ڶ���ѡ���ʱ���ѯ���
    private TimeSpinnerPanel timeChaXun = new TimeSpinnerPanel();
  //�ڶ���ѡ��Ĳ�ѯʱ�䰴ť
    private JButton timeButton2 = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
  //�ڶ���ѡ��İ�����\��Ա��ѯ�ı���
	private JTextField queryText = new JTextField(10);
	//�ڶ���ѡ��Ĳ�ѯ��ť
	private JButton queryButton2 = new JButton("��ѯ");
	//�ڶ���ѡ��ı�
	private AllTableModel tableModel2;
	private JTable table2;
	

	
	public JPanel getDanJuPanel() {
		return danJuPanel;
	}
	public JComboBox getCashierBox() {
		return cashierBox;
	}
	public JComboBox getJingBanRenBox() {
		return jingBanRenBox;
	}
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public JTable getTable() {
		return table;
	}
	public JPanel getMingXiPanel() {
		return mingXiPanel;
	}
	public TimeSpinnerPanel getTimeChaXun() {
		return timeChaXun;
	}
	public JTextField getQueryText() {
		return queryText;
	}
	public AllTableModel getTableModel2() {
		return tableModel2;
	}
	public JTable getTable2() {
		return table2;
	}
	public SellLedgerDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
	}
	public void init(){
		//this.setSize(950, 600);
		this.setResizable(false);
		tabbedPane();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		initData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/*
	 * ��ʼ������
	 */
	private void initData(){
		//�������
		Vector data = XPOSJDBCControl.getPOSSPDanJuLiuShui("2000-1-1","2222-2-2","","");
		this.getTableModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.danJuColumNames));
		
		
		data = XPOSJDBCControl.getPOSSPMingXiLiuShui("2000-1-1","2222-2-2","");
		this.getTableModel2().setDataVector(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.mingXiColumNames));
	}
	
	public void tabbedPane(){
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("������ˮ��",danJuPanel());
		tabbedPane.addTab("��Ʒ��ϸ��",mingXiPanel());
		this.add(tabbedPane);
	}
	
	
	/**
	 * ������ˮ��ѡ����
	 * @return
	 */
	public JPanel danJuPanel() {
		danJuPanel = new JPanel();
		
		danJuPanel.setLayout(new BorderLayout());
		danJuPanel.add(createNorthPanel(),BorderLayout.NORTH);
		danJuPanel.add(createCenterPanel(),BorderLayout.CENTER);
		JLabel label = new JLabel("˵��:�Żݽ�����Ĩ�����Ʒ�ۿ��Żݽ��");
		label.setForeground(Color.BLUE);
		danJuPanel.add(label,BorderLayout.SOUTH);
		
		return danJuPanel;
	}
	
	/**
	 * ������ˮ���ϵ�����ˮ��ѡ��������������Ĳ���
	 * @return northPanel
	 */
	public JPanel createNorthPanel(){
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		northPanel.setBorder(new LineBorder(Color.GRAY));
		
		JPanel panel2 = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		panel2.setLayout(layout);
		layout.setHgap(30);
		panel2.add(new JLabel("����Ա:"));
		panel2.add(cashierBox);
		cashierBox.addItem("��������Ա");
		cashierBox.setSelectedItem("��������Ա");
		panel2.add(new JLabel("������:"));
		panel2.add(jingBanRenBox);
		jingBanRenBox.addItem("���о�����");
		jingBanRenBox.setSelectedItem("���о�����");
		jingBanRenBox.setMaximumRowCount(4);
		
		panel2.add(queryButton);
		queryButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String syID = SellLedgerDialog.this.
				         getCashierBox().getSelectedItem().toString();
				
				String jbID = SellLedgerDialog.this.
				         getJingBanRenBox().getSelectedItem().toString();
				
				if("��������Ա".equals(syID)){
					syID = "";
				}
				
				if("���о�����".equals(jbID)){
					jbID = "";
				}
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							SellLedgerDialog.this.getTimePane().
							getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					
					dateTo = DateConventer.dateToStr(
							SellLedgerDialog.this.getTimePane().
							getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
					
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSSPDanJuLiuShui(
						dateFrom,dateTo,syID,jbID);
				getTableModel().setDataVector(data,
				   AllTableModel.getVectorFromObj(
						  POSXiaoShouCulomnModel.danJuColumNames));
			}
			
		});
		JPanel panel3 = new JPanel();
		timeButton1.setMargin(new Insets(0,0,0,0));
		panel3.add(new JLabel("��ѯʱ��:"));
		timePane = new TimeSpinnerPanel();
		panel3.add(timePane);
		panel3.add(timeButton1);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2,1));
		
		panel4.add(panel3);
		panel4.add(panel2);
		
		seeDocumentsButton.setMargin(new Insets(0,0,0,0));
		exportButton.setMargin(new Insets(0,0,0,0));
		printButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(seeDocumentsButton);
		northPanel.add(exportButton);
		northPanel.add(printButton);
		northPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		northPanel.add(panel4);
		
		return northPanel;
	}
	
	/**
	 * ������ˮ���ϵ�����ˮ��ѡ��м����������Ĳ���
	 * @return
	 */
	private JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel();
		
		tableModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				               POSXiaoShouCulomnModel.danJuColumNames);
		table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(950,356));//���̶���С
		centerPanel.add(scroll);
		return centerPanel;
	}
	
	
	
	
	/**
	 * ��Ʒ��ϸ��ѡ����
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
	 * ������ˮ������Ʒ��ϸ���ѡ��������������Ĳ���
	 * @param args
	 */
	
	public JPanel createNorthPane() {
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		northPane.setBorder(new LineBorder(Color.GRAY));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("�����ݺ�/��Ա��ѯ:"));
		panel1.add(queryText);
		panel1.add(queryButton2);
		queryText.setToolTipText("��Ϊ�������");
		queryButton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String djHyID = SellLedgerDialog.this.getQueryText().getText();
				
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							SellLedgerDialog.this.getTimeChaXun().getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							SellLedgerDialog.this.getTimeChaXun().getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSSPMingXiLiuShui(dateFrom,dateTo,djHyID);
				getTableModel2().setDataVector(data,
						   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.mingXiColumNames));
			}
			
		});
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("��ѯʱ��:"));
		panel2.add(timeChaXun);
		timeButton2.setMargin(new Insets(0,0,0,0));
		panel2.add(timeButton2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(panel2);
		panel3.add(panel1);
		
	
		exportButton1.setMargin(new Insets(0,0,0,0));
		printButton1.setMargin(new Insets(0,0,0,0));
		exitButton1.setMargin(new Insets(0,0,0,0));
		northPane.add(exportButton1);
		northPane.add(printButton1);
		northPane.add(exitButton1);
		exitButton1.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		northPane.add(panel3);
		return northPane;
	}
	
	/**
	 * ������ˮ������Ʒ��ϸ��ѡ��м����������Ĳ���
	 * @return
	 */
	private JPanel createCenterPane(){
		JPanel centerPanel = new JPanel();
		
		tableModel2 = new AllTableModel(POSXiaoShouCulomnModel.obj,
				POSXiaoShouCulomnModel.mingXiColumNames);
		table2 = new JTable(tableModel2);
		JScrollPane scroll = new JScrollPane(table2);
		table2.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setPreferredScrollableViewportSize(new Dimension(950,356));//���̶���С
		centerPanel.add(scroll);
		return centerPanel;
	}
	//������
	public static void main(String[] args) {
	
		new SellLedgerDialog(null,"POS������ˮ��",true);
		

	}
}
