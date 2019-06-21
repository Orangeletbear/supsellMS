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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.poscontrol.HuiYuanXiaoFeiXiangXiMouseActon;
import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;

/**
 * ��Ա����ͳ��---��Ա���Ѳ�ѯ�Ի���
 * @author Administrator
 *
 */

public class VIPConsumeDialog extends JDialog {

	/*
	 * ��������ϵ����
	 */
	
	//�鿴���ݰ�ť
	private JButton seeDocumentsButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//��ӡ��ť
	private JButton printButton = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	//�˳���ť
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//��ѯʱ�䰴ť
	private JButton timeButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//���۵���\��Ա��Ϣ�ı���
	private  JTextField infoText = new JTextField(10);
	//��ѯ��ť
	private JButton queryButton = new JButton("��ѯ(F2)");
	//������ϸ��Ϣ��ǩ
	private JLabel detailedInfoLabel = new JLabel("20000000000");
	
    //ʱ���������
	private TimeSpinnerPanel spPane;
	/*
	 * ������
	 */
	private JTable consumeTable;
	private AllTableModel consumeModel;
	private Vector data = new Vector();
	
	private JTable detailedTable;
	private AllTableModel detailedModel;
	public Vector getData() {
		return data;
	}

	public void setData(Vector data) {
		this.data = data;
	}

	public Vector getMingXiData() {
		return mingXiData;
	}

	public void setMingXiData(Vector mingXiData) {
		this.mingXiData = mingXiData;
	}
	private Vector mingXiData = new Vector();
	
	
	
	
	public VIPConsumeDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
	}
	
	public void init(){
		//this.setSize(920,550);
		this.setResizable(false);
		this.add(creareNorthPanel(),BorderLayout.NORTH);
		this.add(createCenterPanel(),BorderLayout.CENTER);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.pack();
		ininData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * ���ݵĳ�ʼ��
	 */
	private void ininData(){
		String dateFrom = "2000-1-1";
		String dateTo = "2222-2-2";
		String hyId = infoText.getText();
		Vector data = XPOSJDBCControl.getHuiYuanXiaoFei(dateFrom, dateTo, hyId);
		this.setData(data);
		this.getConsumeModel().setDataVector(data,
				AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.VIPConsumeColumNames));
		//this.repaint();
	}
	/**
	 * ��山������Ĳ���
	 * @return �������
	 */
	public JPanel creareNorthPanel(){
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,3));
		northPanel.setBorder(new LineBorder(Color.GRAY));
		
		seeDocumentsButton.setMargin(new Insets(0,0,0,0));
		printButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(seeDocumentsButton);
		northPanel.add(printButton);
		northPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		
		JPanel panel2 = new JPanel();
		timeButton.setMargin(new Insets(0,0,0,0));
		panel2.add(new JLabel("��ѯʱ��:"));
		spPane = new TimeSpinnerPanel();
		
		panel2.add(spPane);
		panel2.add(timeButton);
		
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("���۵���/��Ա��Ϣ:"));
		panel3.add(infoText);
		infoText.setToolTipText("��Ϊ�������");
		panel3.add(queryButton);
		queryButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
						VIPConsumeDialog.this.getSpPane().getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							VIPConsumeDialog.this.getSpPane().getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				String hyId = infoText.getText();
				Vector data = XPOSJDBCControl.getHuiYuanXiaoFei(dateFrom, dateTo, hyId);
				VIPConsumeDialog.this.setData(data);
				VIPConsumeDialog.this.getConsumeModel().setDataVector(data,
						AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.VIPConsumeColumNames));
			}
			
		});
		
		panel1.add(panel2);
		panel1.add(panel3);
		
		northPanel.add(panel1);
		return northPanel;
		
	}
	
	
	/**
	 * �����м�����Ĳ��֡������Ϊ������
	 * @return �м����
	 */
	public JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		consumeModel = new AllTableModel(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.VIPConsumeColumNames));
		consumeTable = new JTable(consumeModel);
		JScrollPane scroll = new JScrollPane(consumeTable);
		consumeTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		consumeTable.setPreferredScrollableViewportSize(new Dimension(920,150));//���̶���С
		//panel1.setBorder(new LineBorder(Color.GRAY));
		panel1.add(scroll);
		consumeTable.addMouseListener(new HuiYuanXiaoFeiXiangXiMouseActon(this));
		JPanel panel2 = new JPanel();
		detailedModel = new AllTableModel(mingXiData,
				AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.detailedInfoColumNames));
		detailedTable = new JTable(detailedModel);
		JScrollPane scroll2 = new JScrollPane(detailedTable);
		detailedTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		detailedTable.setPreferredScrollableViewportSize(new Dimension(920,150));//���̶���С
		//panel2.setBorder(new LineBorder(Color.GRAY));
		panel2.add(scroll2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("���ݵ���ϸ��Ϣ:"));
		detailedInfoLabel.setForeground(Color.red);
		panel3.add(detailedInfoLabel);
		
		JPanel panel4 = new JPanel();
		
		panel4.setLayout(new BorderLayout());
		panel4.add(panel3,BorderLayout.NORTH);
		panel4.add(panel2,BorderLayout.CENTER);
		
		centerPanel.add(panel1);
		centerPanel.add(panel4);
		
		return centerPanel;
	}
	public JTextField getInfoText() {
		return infoText;
	}

	public JLabel getDetailedInfoLabel() {
		return detailedInfoLabel;
	}

	public JTable getConsumeTable() {
		return consumeTable;
	}

	public AllTableModel getConsumeModel() {
		return consumeModel;
	}

	public JTable getDetailedTable() {
		return detailedTable;
	}

	public AllTableModel getDetailedModel() {
		return detailedModel;
	}

	public TimeSpinnerPanel getSpPane() {
		return spPane;
	}

	
	
	//������
	public static void main(String[] args) {
		new VIPConsumeDialog(null,"��Ա���Ѳ�ѯ",true);
		

	}
}
