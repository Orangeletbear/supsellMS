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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.control.kuchunframe.KuCunBaoJingTableSelectAction;
import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCBJModel;
import com.cn.model.kuchun.MyTableModel;
import com.cn.util.JDatePicker;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
import com.cn.view.tongjiJFrame.Dialog.JinHuoDialog;
import com.cn.view.tongjiJFrame.Dialog.TuiHuoDialog;
import com.cn.view.toolbar.TableCulomnModel;

public class KucunBaojin extends JDialog {
	////////////////�ϰ벿��Ա����
	private JButton btnXGSP;//�޸���Ʒ
	private JButton btnJHCK;//�����ο�
	private JButton btnTHCK;//�˻��ο�
	private JButton btnExport;//����
	private JButton btnPrint;//��ӡ
	private JButton btnExit;//�˳�
	
	private MyTableModel tablemodel1;
	

	private JTable table1;
	
	JDatePicker datePickerTo;
	JDatePicker datePickerFrom;
	private JLabel labelSPS;//��Ʒ��
	
	////////////////�°벿��Ա����
	private JTextField textJHXSMX;//����������ϸ
	private JButton btnCheck;//����
	private JLabel labelDJS;//������
	private JLabel labelRKS;//�����
	private JLabel labelCKS;//������
	
	private MyTableModel tablemodel2;
	private JTable table2;
	
	
	public MyTableModel getTablemodel1() {
		return tablemodel1;
	}

	public JTable getTable1() {
		return table1;
	}

	public JDatePicker getDatePickerTo() {
		return datePickerTo;
	}

	public JDatePicker getDatePickerFrom() {
		return datePickerFrom;
	}

	public JLabel getLabelSPS() {
		return labelSPS;
	}

	public JTextField getTextJHXSMX() {
		return textJHXSMX;
	}

	public JLabel getLabelDJS() {
		return labelDJS;
	}

	public JLabel getLabelRKS() {
		return labelRKS;
	}

	public JLabel getLabelCKS() {
		return labelCKS;
	}

	public MyTableModel getTablemodel2() {
		return tablemodel2;
	}

	public JTable getTable2() {
		return table2;
	}
	
	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnExport() {
		return btnExport;
	}

	public JButton getBtnJHCK() {
		return btnJHCK;
	}

	public JButton getBtnPrint() {
		return btnPrint;
	}

	public JButton getBtnTHCK() {
		return btnTHCK;
	}

	public JButton getBtnXGSP() {
		return btnXGSP;
	}

	public KucunBaojin(JFrame frame,String title,boolean b){
		super(frame,title,b);
		init();
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setResizable(false);;
		
		this.add(addCom());
		initData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/*
	 * ���ݵĸ���
	 */
	private void initData(){
		//��Ʒ����
		Vector data = TadayRemindJDBC.getCuCunBJData("");
	   this.getTablemodel1().setDataVector(data,
	   AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName1));
	}
	/*
	 * ����������Ϊ����������
	 * 
	 */
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(2,1));
		{
			jpanel.add(addUp());
			jpanel.add(addDown());
		}
		return jpanel;
	}
	
	/*
	 * �ϰ벿�������
	 * �ϰ벿�ְ�BorderLayout����
	 */
	private JPanel addUp(){
		JPanel Upjpanel = new JPanel();
		Upjpanel.setLayout(new BorderLayout());
		
		{
			Upjpanel.add(addUpNor(),BorderLayout.NORTH);
			Upjpanel.add(addUpCen(),BorderLayout.CENTER);
			Upjpanel.add(addUpSou(),BorderLayout.SOUTH);
		}
		
		return Upjpanel;
	}
	/*
	 * �ϱ���
	 * 
	 */
	private JPanel addUpNor(){
		JPanel UpNorjpanel = new JPanel();
		UpNorjpanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
		
		btnXGSP = new JButton(new ImageIcon("res/AcionIcon/xiugangshangping.jpg"));
		btnXGSP.setMargin(new Insets(0,0,0,0));
		btnJHCK = new JButton(new ImageIcon("res/AcionIcon/jinhuochangkao.jpg"));
		btnJHCK.setMargin(new Insets(0,0,0,0));
		btnTHCK = new JButton(new ImageIcon("res/AcionIcon/tuihuochangkao.jpg"));
		btnTHCK.setMargin(new Insets(0,0,0,0));
		btnExport = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		btnExport.setMargin(new Insets(0,0,0,0));
		btnPrint = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		btnPrint.setMargin(new Insets(0,0,0,0));
		btnExit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit.setMargin(new Insets(0,0,0,0));
		
		{
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					KucunBaojin.this.dispose();
				}
			});
		}
		
		btnXGSP.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int row = table1.getSelectedRow();
				if(row == -1 ){
					JOptionPane.showMessageDialog(null, "����ѡ��һ����Ʒ��Ϣ");
					return;
				}
				String obj = tablemodel1.getValueAt(row, 0).toString();
				
				new AtlerShangPingDialog(KucunBaojin.this,"�޸���Ʒ",true,obj);
			}
		});
		
		
		{
			UpNorjpanel.add(btnXGSP);
			UpNorjpanel.add(btnJHCK);
			UpNorjpanel.add(btnTHCK);
			UpNorjpanel.add(btnExport);
			UpNorjpanel.add(btnExport);
			UpNorjpanel.add(btnPrint);
			UpNorjpanel.add(btnExit);
		}
		btnJHCK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new JinHuoDialog(KucunBaojin.this,"�����ο�",true);
			}
		});
		btnTHCK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				new TuiHuoDialog(KucunBaojin.this,"�˻��ο�",true);
			}
		});
		
		
		UpNorjpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		return UpNorjpanel;
	}
	
	/*
	 * ���в�
	 * 
	 */
	private JPanel addUpCen(){
		JPanel UpCenjpanel = new JPanel();
		
		tablemodel1 = new MyTableModel(
			TableCulomnModel.obj,TableCulomnModel.TodayColumnName1);
		
		table1 = new JTable(tablemodel1);
		table1.setShowGrid(true);
		table1.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table1.setPreferredScrollableViewportSize(new Dimension(780,300));
		JScrollPane scroPane = new JScrollPane(table1,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		UpCenjpanel.add(scroPane);
		table1.addMouseListener(new KuCunBaoJingTableSelectAction(this));
		return UpCenjpanel;
	}
	/*
	 * ���ϲ�
	 * 
	 */
	private JPanel addUpSou(){
		JPanel UpSoujpanel = new JPanel();
		
		UpSoujpanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		labelSPS = new JLabel();
		labelSPS.setText("��Ʒ�� ��" + 3);
		{
			UpSoujpanel.add(labelSPS);
		}
		return UpSoujpanel;
	}
	
	/*
	 * �°벿�������
	 * �°벿�ְ�BorderLayout����
	 */
	private JPanel addDown(){
		JPanel Downjpanel = new JPanel();
		Downjpanel.setLayout(new BorderLayout());
		
		{
			Downjpanel.add(addDownNor(),BorderLayout.NORTH);
			Downjpanel.add(addDownCen(),BorderLayout.CENTER);
			Downjpanel.add(addDownSou(),BorderLayout.SOUTH);
		}
		return Downjpanel;
	}
	/*
	 * �±���
	 * 
	 */
	private JPanel addDownNor(){
		JPanel DownNorjpanel = new JPanel();
		//��ʼʱ���
		DownNorjpanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
		datePickerFrom= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		datePickerFrom.setEditable(false);//����Ϊ���ɱ༭

		//��ʼʱ���
		DownNorjpanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		datePickerTo = new JDatePicker(JDatePicker.STYLE_CN_DATE);
		datePickerTo.setEditable(false);//����Ϊ���ɱ༭

		textJHXSMX = new JTextField(20);
		textJHXSMX.setEditable(false);
		
	    JLabel label1 = new JLabel("����������ϸ:");
		JLabel label2 = new JLabel("��ѯ����");
		JLabel label3 = new JLabel("��");
		
		btnCheck = new JButton("��  ѯ");
		
		{
			DownNorjpanel.add(label1);
			DownNorjpanel.add(textJHXSMX);
			DownNorjpanel.add(label2);
			DownNorjpanel.add(datePickerFrom);
			DownNorjpanel.add(label3);
			DownNorjpanel.add(datePickerTo);
			DownNorjpanel.add(btnCheck);
			
		}
		DownNorjpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		return DownNorjpanel;
	}
	
	/*
	 * ���в�
	 * 
	 */
	private JPanel addDownCen(){
		JPanel DownNorjpanel = new JPanel();
		
		tablemodel2 = new MyTableModel(TableCulomnModel.obj,TableCulomnModel.KuCunBaoJingXiaoXi);
		table2 = new JTable(tablemodel2);
		table2.setShowGrid(true);
		table2.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table2.setPreferredScrollableViewportSize(new Dimension(780,300));
		JScrollPane scroPane = new JScrollPane(table2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		DownNorjpanel.add(scroPane);
		return DownNorjpanel;
	}
	/*
	 * ���ϲ�
	 * 
	 */
	private JPanel addDownSou(){
		JPanel DownNorjpanel = new JPanel();
		DownNorjpanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		labelDJS = new JLabel();
		labelDJS.setText("������ ��" + 3);
		labelCKS = new JLabel("��������"+"0.0",JLabel.RIGHT);
		labelCKS.setForeground(Color.RED);
		labelRKS = new JLabel("�������"+"211.0",JLabel.RIGHT);
		labelRKS.setForeground(Color.RED);
		
		{
			DownNorjpanel.add(labelSPS);
			DownNorjpanel.add(labelCKS);
			DownNorjpanel.add(labelRKS);
		}
		DownNorjpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return DownNorjpanel;
	}
	
	/*
	 * �˷����Ǵ���table���
	 * 
	 */
	private static void createTable(JPanel jpanel,JTable table,
		DefaultTableModel tableModel,Object[][] data,Object[] colunms){
		
		tableModel = new MyTableModel(data,colunms);
		table = new JTable(tableModel);
		table.setShowGrid(true);
		table.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table.setPreferredScrollableViewportSize(new Dimension(780,300));
		JScrollPane scroPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		jpanel.add(scroPane);
	}
	
	public static void main(String[] args) {
		new KucunBaojin(null,"��汨��",true);
	}

}
