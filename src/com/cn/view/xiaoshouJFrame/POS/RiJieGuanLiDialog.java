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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.poscontrol.RiJeiAction;
import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;

/**
 * POS�ս����Ի���
 * @author Administrator
 *
 */
public class RiJieGuanLiDialog extends JDialog {

	/*
     * ��ʼ���öԻ��򱱲�����ϵ����
     */
	//�սᰴť
	private JButton riJieButton = new JButton(new ImageIcon("res/AcionIcon/rijieguanli.jpg"));
	//�鿴��ϸ��ť
	private JButton chaKanMingXiButton = new JButton(new ImageIcon("res/AcionIcon/chakanmingxi.jpg"));
	//������ť
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��ӡ��ť
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//�˳���ť
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	/*
	 * ��ʼ���öԻ����м�����ϵ����
	 */
	//����ʱ��
	private  JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//��ѯʱ�䰴ť
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//�����ı���
	private JTextField mingChengText = new JTextField(10);
	//��ѯ��ť
	private JButton chaXunButton = new JButton("��ѯ(F2)");
	
	//��
	private JTable table;
	private AllTableModel tableModel;
	
	public JDatePicker getDataPicker1() {
		return dataPicker1;
	}

	public JDatePicker getDataPicker2() {
		return dataPicker2;
	}

	public JTextField getMingChengText() {
		return mingChengText;
	}

	public JTable getTable() {
		return table;
	}

	public AllTableModel getTableModel() {
		return tableModel;
	}

	public RiJieGuanLiDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		
	    init();
	  
	}
	
	public void init() {
		this.setSize(900,550);
		this.setResizable(false);
		this.add(createNorthPanel(),BorderLayout.NORTH);
		this.add(createCenterPanel(),BorderLayout.CENTER);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initData();
		this.setVisible(true);
	}
	/**
	 * ���ݳ�ʼ��
	 */
	private void initData(){
		//�������
		Vector data = XPOSJDBCControl.getPOSRiJieGuangLi("2000-1-1","2222-2-2","");
		
		
		this.getTableModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.riJieColumNames));
	}
	/**
	 * �ս����Ի��򱱲����������Ĳ���
	 * @return �������
	 */
	public JPanel createNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new LineBorder(Color.GRAY));
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,12));
		
		riJieButton.setMargin(new Insets(0,0,0,0));
		chaKanMingXiButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			    	 dispose();
			}
		});
		riJieButton.addActionListener(new RiJeiAction(this));
		northPanel.add(riJieButton);
		northPanel.add(chaKanMingXiButton);
		northPanel.add(daoChuButton);
		northPanel.add(daYinButton);
		northPanel.add(tuiChuButton);
		northPanel.add(new JLabel(new ImageIcon("res/AcionIcon/chakanLabel.jpg")));
		return northPanel;
	}
	/**
	 * �ս����Ի����м����������Ĳ���
	 * @return �м����
	 */
	public JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		north.setBorder(new LineBorder(Color.GRAY));
		north.add(new JLabel("�ս�����:"));
		north.add(dataPicker1);
		north.add(new JLabel("��"));
		north.add(dataPicker2);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton);
		north.add(new JLabel("�սᵥ�Ż����Ա����:"));
		north.add(mingChengText);
		north.add(chaXunButton);
		chaXunButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String spID = RiJieGuanLiDialog.this.getMingChengText().getText();
				
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							RiJieGuanLiDialog.this.getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							RiJieGuanLiDialog.this.getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSRiJieGuangLi(dateFrom,dateTo,spID);
				getTableModel().setDataVector(data,
				   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.riJieColumNames));
			}
			
		});
		JPanel center = new JPanel();
		tableModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				POSXiaoShouCulomnModel.riJieColumNames);
		table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(880,350));//���̶���С
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		
		return centerPanel;
	}
	
	//������
	public static void main(String[] args) {
		new RiJieGuanLiDialog(null,"�ս����",true);
	}
}
