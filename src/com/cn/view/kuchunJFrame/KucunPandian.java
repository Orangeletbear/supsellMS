package com.cn.view.kuchunJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucunpandian.KCPD_ChaXunShangPinMouseListener;
import com.cn.control.kuchunframe.kucunpandian.KunCunPanDianChaXunAction;
import com.cn.control.kuchunframe.kucunpandian.PanDianZhuJieMianAction;
import com.cn.control.kuchunframe.kucunpandian.XZorXGPanDianDanAction;
import com.cn.dao.MFrameJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.kucunpandian.KCPD_GaoJiChaXunDialog;
import com.cn.view.mainJFrame.MainFrame;

public class KucunPandian extends JDialog {
	private MainFrame frame;
	//////////////�̵��б�
	private JButton btnKSPD;//��ʼ�̵�
	private JButton btnCKDJ;//�鿴����
	private JButton btnExit;//�˳�
	
	private JButton btnXZPDD;//�����̵㵥
	private JButton btnXGPDD;//�޸��̵㵥
	private JButton btnSCPDD;//ɾ���̵㵥
	private JButton btnPDDDR;//�̵㵥����
	private JButton btnGJCX;//�߼���ѯ
	
	private JTable tablePD1;//���
	private AllTableModel tablemodelPD1;//��ģʽ
	private Vector ve1 = new Vector();//������
	private Vector vo1 = new Vector();
	
	private JLabel labelHJ1;//�ϼ�
	private JLabel labelPDDH;//�̵㵥��
	
	private JButton btnXZSP;//������Ʒ
	private JButton btnXGSP;//�޸���Ʒ
	private JButton btnSCSP;//ɾ����Ʒ
	
	private JTable tablePD2;//���
	private AllTableModel tablemodelPD2;//��ģʽ
	private Vector ve2 = new Vector();//������
	private Vector vo2 = new Vector();
	
	///////////////////////��ʷ�̵��ѯ
	private JButton btnDY;//��ӡ
	private JButton btnCX;//��ѯ
	
	private JTable tablePD3;//���
	private AllTableModel tablemodelPD3;//��ģʽ
	private Vector ve3 = new Vector();//������
	private Vector vo3 = new Vector();
	private JLabel labelHJ2;
	private JLabel labelHJ3;
	private JDatePicker dateFrom;
	private JDatePicker dateTo;
	private JComboBox comboCKMC;//�ֿ�����
	private JComboBox comboCZR;//������
	
	//////////////////
	
	public JTable getTablePD1() {
		return tablePD1;
	}

	public AllTableModel getTablemodelPD1() {
		return tablemodelPD1;
	}

	public Vector getVe1() {
		return ve1;
	}

	public Vector getVo1() {
		return vo1;
	}

	public JLabel getLabelPDDH() {
		return labelPDDH;
	}

	public JTable getTablePD2() {
		return tablePD2;
	}

	public AllTableModel getTablemodelPD2() {
		return tablemodelPD2;
	}

	public Vector getVe2() {
		return ve2;
	}

	public Vector getVo2() {
		return vo2;
	}

	public JTable getTablePD3() {
		return tablePD3;
	}

	public AllTableModel getTablemodelPD3() {
		return tablemodelPD3;
	}

	public Vector getVe3() {
		return ve3;
	}

	public Vector getVo3() {
		return vo3;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public JComboBox getComboCKMC() {
		return comboCKMC;
	}

	public JComboBox getComboCZR() {
		return comboCZR;
	}

	public JButton getBtnXZPDD() {
		return btnXZPDD;
	}

	public JButton getBtnXGPDD() {
		return btnXGPDD;
	}
	
	public JButton getBtnKSPD() {
		return btnKSPD;
	}
	public JButton getBtnCKDJ() {
		return btnCKDJ;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public JButton getBtnSCPDD() {
		return btnSCPDD;
	}
	public JButton getBtnPDDDR() {
		return btnPDDDR;
	}
	public JButton getBtnGJCX() {
		return btnGJCX;
	}
	public JButton getBtnXZSP() {
		return btnXZSP;
	}
	public JButton getBtnXGSP() {
		return btnXGSP;
	}
	public JButton getBtnSCSP() {
		return btnSCSP;
	}
	public JButton getBtnDY() {
		return btnDY;
	}
	public JButton getBtnCX() {
		return btnCX;
	}
	public MainFrame getFrame() {
		return frame;
	}
///////////////
	public KucunPandian(MainFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame = frame;
		init();
		this.setVisible(true);
	}
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JTabbedPane addCom(){
		JTabbedPane tabpanel = new JTabbedPane();
		tabpanel.addTab("�̵��б�", addComPDLB());
		tabpanel.addTab("��ʷ�̵��ѯ", addComPDCX());
		return tabpanel;
	}
	
	private JPanel addComPDLB(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		{
			jpanel1.add(addNorPDLB(),BorderLayout.NORTH);
			jpanel1.add(addCenPDLB(),BorderLayout.CENTER);
		}
		return jpanel1;
	}
	
	/*
	 * �������
	 * 
	 */
	private JPanel addNorPDLB(){
		JPanel norJpanel1 = new JPanel();
		norJpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		btnKSPD = new JButton(new ImageIcon("res/AcionIcon/kaishipandian.jpg"));
		btnKSPD.setMargin(new Insets(0,0,0,0));
		btnCKDJ = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		btnCKDJ.setMargin(new Insets(0,0,0,0));
		btnExit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit.setMargin(new Insets(0,0,0,0));
		{
			btnKSPD.addActionListener(new PanDianZhuJieMianAction(this));
			
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					KucunPandian.this.dispose();
				}
			});
		}
		{
			norJpanel1.add(btnKSPD);
			norJpanel1.add(btnCKDJ);
			norJpanel1.add(btnExit);
		}
		
		norJpanel1.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		return norJpanel1;
	}

	/*
	 * �в�����Ϊ��������
	 * 
	 */
	private JPanel addCenPDLB(){
		JPanel cenJpanel1 = new JPanel();
		cenJpanel1.setLayout(new GridLayout(2,1));
		
		{
			cenJpanel1.add(addCenPDLB1());
			cenJpanel1.add(addCenPDLB2());
		}
		
		return cenJpanel1;
	}
	
	/*
	 *�м�����һ��
	 * 
	 */
	private JPanel addCenPDLB1(){
		JPanel cenJpanel11 = new JPanel();
		cenJpanel11.setLayout(new BorderLayout());
		
		{
			cenJpanel11.add(addCenNorPDLB1(),BorderLayout.NORTH);
			cenJpanel11.add(addCenCenPDLB1(),BorderLayout.CENTER);
			cenJpanel11.add(addCenSouPDLB1(),BorderLayout.SOUTH);
		}
		
		cenJpanel11.setBorder(new TitledBorder(
				new LineBorder(Color.LIGHT_GRAY,1),"�̵㵥�б�(�б�����ʾ��������δ�����Ŀ��ǰ���̵㵥)"));
		return cenJpanel11;
	}

	private JPanel addCenNorPDLB1(){
		JPanel cenNorJpanel1 = new JPanel();
		cenNorJpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		btnXZPDD = new JButton("�����̵㵥",new ImageIcon("res/AcionIcon/green.jpg"));
		btnXZPDD.setMargin(new Insets(-4,-2,-4,-2));
		btnXGPDD = new JButton("�޸��̵㵥",new ImageIcon("res/AcionIcon/green.jpg"));
		btnXGPDD.setMargin(new Insets(-4,-2,-4,-2));
		btnSCPDD = new JButton("ɾ���̵㵥",new ImageIcon("res/AcionIcon/red.jpg"));
		btnSCPDD.setMargin(new Insets(-4,-2,-4,-2));
		btnPDDDR = new JButton("�̵㵥����",new ImageIcon("res/AcionIcon/green.jpg"));
		btnPDDDR.setMargin(new Insets(-4,-2,-4,-2));
		btnGJCX = new JButton("�߼���ѯ",new ImageIcon("res/AcionIcon/check.jpg"));
		btnGJCX.setMargin(new Insets(0,0,0,0));
		{
			btnGJCX.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new KCPD_GaoJiChaXunDialog(KucunPandian.this,"�߼���ѯ(����̵�)",true).setVisible(true);
				}
			});
			XZorXGPanDianDanAction lis = new XZorXGPanDianDanAction(this);
			btnXZPDD.addActionListener(lis);
			btnXGPDD.addActionListener(lis);
			btnSCPDD.addActionListener(new PanDianZhuJieMianAction(this));
		}
		{
			cenNorJpanel1.add(btnXZPDD);
			cenNorJpanel1.add(btnXGPDD);
			cenNorJpanel1.add(btnSCPDD);
			cenNorJpanel1.add(btnPDDDR);
			cenNorJpanel1.add(btnGJCX);
			
		}
		return cenNorJpanel1;
	}
	private JPanel addCenCenPDLB1(){
		JPanel cenCenJpanel1 = new JPanel();
		
		vo1 = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCPD1);
		ve1 = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCPD1);
		tablemodelPD1 = new AllTableModel(vo1,ve1);
		tablePD1 = new JTable(tablemodelPD1);
		tablePD1.setAutoCreateRowSorter(true); //������ñ���Զ�����
		tablePD1.addMouseListener(new KCPD_ChaXunShangPinMouseListener(this));
		tablePD1.setPreferredScrollableViewportSize(new Dimension(760,100));
		JScrollPane scroPane = new JScrollPane(tablePD1);
		cenCenJpanel1.add(scroPane);
		
//		createTable(cenCenJpanel1,tablePD1,tablemodelPD1,KCPDModel.dataKCPD1,KCPDModel.colunmsKCPD1);

		return cenCenJpanel1;
	}
	private JPanel addCenSouPDLB1(){
		JPanel cenSouJpanel1 = new JPanel();
		cenSouJpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel label = new JLabel("�ϼƣ�");
		labelHJ1 = new JLabel("");
		labelHJ1.setForeground(Color.RED);
		
		cenSouJpanel1.add(label);
		cenSouJpanel1.add(labelHJ1);
		cenSouJpanel1.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return cenSouJpanel1;
	}
	
	/*
	 * �м����ڶ���
	 * 
	 */
	
	private JPanel addCenPDLB2(){
		JPanel cenJpanel12 = new JPanel();
		cenJpanel12.setLayout(new BorderLayout());
		
		{
			cenJpanel12.add(addCenNorPDLB2(),BorderLayout.NORTH);
			cenJpanel12.add(addCenCenPDLB2(),BorderLayout.CENTER);
			cenJpanel12.add(addCenSouPDLB2(),BorderLayout.SOUTH);
		}
		cenJpanel12.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return cenJpanel12;
	}
	
	private JPanel addCenNorPDLB2(){
		JPanel cenNorJpanel2 = new JPanel();
		cenNorJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JLabel label1 = new JLabel("�̵���Ʒ��ϸ");
		label1.setForeground(Color.RED);
		JLabel label2 = new JLabel("�̵㵥��:");
		
		labelPDDH = new JLabel();
		labelPDDH.setPreferredSize(new Dimension(140,20));
		int row = tablePD1.getSelectedRow();
		labelPDDH.setForeground(Color.RED);
		
		if(row != -1){
			labelPDDH.setText(tablePD1.getValueAt(row, 0).toString());
		}
		
		btnXZSP = new JButton("������Ʒ",new ImageIcon("res/AcionIcon/green.jpg"));
		btnXZSP.setMargin(new Insets(-4,-2,-4,-2));
		btnXGSP = new JButton("�޸���Ʒ",new ImageIcon("res/AcionIcon/green.jpg"));
		btnXGSP.setMargin(new Insets(-4,-2,-4,-2));
		btnSCSP = new JButton("ɾ����Ʒ",new ImageIcon("res/AcionIcon/red.jpg"));
		btnSCSP.setMargin(new Insets(-4,-2,-4,-2));
		{
			PanDianZhuJieMianAction lis =  new PanDianZhuJieMianAction(this);
			btnXZSP.addActionListener(lis);
			btnXGSP.addActionListener(lis);
			btnSCSP.addActionListener(lis);
		}
		{
			cenNorJpanel2.add(label1);
			cenNorJpanel2.add(label2);
			cenNorJpanel2.add(labelPDDH);
//			cenNorJpanel2.add(btnXZSP);
			cenNorJpanel2.add(btnXGSP); 
			cenNorJpanel2.add(btnSCSP);
		}
		
		cenNorJpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return cenNorJpanel2;
	}
	
	private JPanel addCenCenPDLB2(){
		JPanel cenCenJpanel2 = new JPanel();
		
		vo2 = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCPD2);
		ve2 = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCPD2);
		tablemodelPD2 = new AllTableModel(vo2,ve2);
		tablePD2 = new JTable(tablemodelPD2);
		tablePD2.setAutoCreateRowSorter(true); //������ñ���Զ�����
		{
			tablePD2.addMouseListener(new PanDianZhuJieMianAction(this));
		}
		tablePD2.setPreferredScrollableViewportSize(new Dimension(760,130));
		JScrollPane scroPane = new JScrollPane(tablePD2);
		cenCenJpanel2.add(scroPane);
//		createTable(cenCenJpanel2,tablePD2,tablemodelPD2,KCPDModel.dataKCPD2,KCPDModel.colunmsKCPD2);
		return cenCenJpanel2;
	}
	
	private JPanel addCenSouPDLB2(){
		JPanel cenSouJpanel2 = new JPanel();
		cenSouJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel label = new JLabel("�ϼƣ�");
		labelHJ2 = new JLabel();
		labelHJ2 = new JLabel("");
		labelHJ2.setForeground(Color.RED);
		
		cenSouJpanel2.add(label);
		cenSouJpanel2.add(labelHJ2);
		cenSouJpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		return cenSouJpanel2;
	}
	
	///////////////////�̵��굥��ѯ
	/*	
	 * �ϲ����
	 * 
	 */
	private JPanel addComPDCX(){
		JPanel jpanel2 = new JPanel();
		jpanel2.setLayout(new BorderLayout());
		
		{
			jpanel2.add(addNorPDCX(),BorderLayout.NORTH);
			jpanel2.add(addCenPDCX(),BorderLayout.CENTER);
			jpanel2.add(addSouPDCX(),BorderLayout.SOUTH);
		}
		
		return jpanel2;
	}
	
	/*
	 * �������
	 * 
	 */
	private JPanel addNorPDCX(){
		JPanel norJpanel2 = new JPanel();
		norJpanel2.setLayout(new GridLayout(2,1));
		
		{
			norJpanel2.add(addNorPDCX1());
			norJpanel2.add(addNorPDCX2());
		}
		
		return norJpanel2;
	}
	
	private JPanel addNorPDCX1(){
		JPanel norJpanel21 = new JPanel();
		norJpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		btnDY = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		btnDY.setMargin(new Insets(0,0,0,0));
		btnCKDJ = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		btnCKDJ.setMargin(new Insets(0,0,0,0));
		btnExit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit.setMargin(new Insets(0,0,0,0));
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				KucunPandian.this.dispose();
			}
		});
		
		{
			norJpanel21.add(btnDY);
			norJpanel21.add(btnCKDJ);
			norJpanel21.add(btnExit);
		}
		
		return norJpanel21;
	}
	
	private JPanel addNorPDCX2(){
		JPanel norJpanel22 = new JPanel();
		norJpanel22.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		JLabel label1 = new JLabel("��ѯ����");
		JLabel label2 = new JLabel("  ��  ");
		JLabel label3 = new JLabel("�ֿ�����");
		JLabel label4 = new JLabel("������");
		
		dateFrom = new JDatePicker();
		dateFrom.setEditable(false);
		dateTo = new JDatePicker();
		dateTo.setEditable(false);
		
		comboCKMC = new JComboBox(JDBCCuCunFind.getCanKuData());
	
		comboCZR = new JComboBox(MFrameJDBC.getUser());
		comboCZR.addItem("���в���Ա");
		comboCZR.setSelectedItem("���в���Ա");
		
		btnCX = new JButton("��ѯ");
		{
			btnCX.addActionListener(new KunCunPanDianChaXunAction(this));
		}
		{
			norJpanel22.add(label1);
			norJpanel22.add(dateFrom);
			norJpanel22.add(label2);
			norJpanel22.add(dateTo);
			norJpanel22.add(label3);
			norJpanel22.add(comboCKMC);
			norJpanel22.add(label4);
			norJpanel22.add(comboCZR);
			norJpanel22.add(btnCX);
		}
		
		norJpanel22.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return norJpanel22;
	}
	/*
	 * �в����
	 * 
	 */
	private JPanel addCenPDCX(){
		JPanel cenJpanel2 = new JPanel();
		vo3 = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCPD3);
		ve3 = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCPD3);
		tablemodelPD3 = new AllTableModel(vo3,ve3);
		tablePD3 = new JTable(tablemodelPD3);
		tablePD3.setAutoCreateRowSorter(true); //������ñ���Զ�����
		tablePD3.setPreferredScrollableViewportSize(new Dimension(780,400));
		JScrollPane scroPane = new JScrollPane(tablePD3);
		cenJpanel2.add(scroPane);
		
//		createTable(cenJpanel2,tablePD2,tablemodelPD2,KCPDModel.dataKCPD2,KCPDModel.colunmsKCPD2);
		return cenJpanel2;
	}
	
	/*
	 * �ϲ����
	 * 
	 */
	private JPanel addSouPDCX(){
		JPanel cenJpanel2 = new JPanel();
		cenJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel label = new JLabel("�ϼƣ�");
		labelHJ3 = new JLabel("");
		labelHJ3.setForeground(Color.RED);
		
		cenJpanel2.add(label);
		cenJpanel2.add(labelHJ3);
		cenJpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		return cenJpanel2;
	}
	
	public static void main(String []args){
		new KucunPandian(null,"����̵�",true);
	}

	public JLabel getLabelHJ1() {
		return labelHJ1;
	}

	public JLabel getLabelHJ2() {
		return labelHJ2;
	}

	public JLabel getLabelHJ3() {
		return labelHJ3;
	}
}

