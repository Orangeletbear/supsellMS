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
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;


/**
 * POS����Ա��������Ի���
 * @author Administrator
 *
 */
public class StockControlDialog extends JDialog {
    
	//panel_north
	//��ť
	private JButton stockButton = new JButton(new ImageIcon("res/AcionIcon/rukuan.jpg"));
	//���ť
	private JButton chuKuanButton = new JButton(new ImageIcon("res/AcionIcon/chukuan.jpg"));
	//������ť
	private JButton exportButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��ӡ��ť
	private JButton printButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//�˳���ť
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	//panel_center
	//������ѯʱ�����
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	
	//��ѯʱ�䰴ť
	private JButton timeButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//����ԱBox
	private JComboBox namesBox = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	//��ѯ��ť
	private JButton queryButton = new JButton("��ѯ(F2)");
	
	private JTable table ;
	private AllTableModel tableModel;
	
	
	
	
	public JDatePicker getDataPicker1() {
		return dataPicker1;
	}
	public JDatePicker getDataPicker2() {
		return dataPicker2;
	}
	public JButton getTimeButton() {
		return timeButton;
	}
	public JComboBox getNamesBox() {
		return namesBox;
	}
	public JTable getTable() {
		return table;
	}
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public StockControlDialog(JFrame parent,String title,boolean model) {
		
		super(parent,title,model);
		init();
	}
	public void init() {
		//this.setSize(700,550);
		this.setResizable(false);
		this.add( keHuFuKuanMingXi());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
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
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.chuRuKuanColumNames));
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
		
		stockButton.setMargin(new Insets(0,0,0,0));
		exportButton.setMargin(new Insets(0,0,0,0));
		chuKuanButton.setMargin(new Insets(0,0,0,0));
		printButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		exitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				StockControlDialog.this.dispose();
			}
			
		});
		stockButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new POSLuKuangDialog(StockControlDialog.this,"���",true);
			}
			
		});
		chuKuanButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new POSChuKuangDialog(StockControlDialog.this,"����",true);
			}
			
		});
		panel_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel_north.add(stockButton);
		panel_north.add(chuKuanButton);
		panel_north.add(exportButton);
		panel_north.add(printButton);
		panel_north.add(exitButton);
		exitButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel_north;
	}
	//panel_center ��Ϊ������
	private JPanel panel_center(){
		JPanel panel_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯ���� :"));
		pane1.add(dataPicker1);
		pane1.add(new JLabel("�� "));
		pane1.add(dataPicker2);
		timeButton.setMargin(new Insets(0,0,0,0));
		pane1.add(timeButton);
		pane1.add(new JLabel("�ͻ����� :"));
		pane1.add(namesBox);
		pane1.add(queryButton);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		namesBox.addItem("��������Ա");
		namesBox.setSelectedItem("��������Ա");
		queryButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String syName = StockControlDialog.this.
						getNamesBox().getSelectedItem().toString();
				
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							StockControlDialog.this.getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							StockControlDialog.this.getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSRiJieGuangLi(dateFrom,dateTo,syName);
				getTableModel().setDataVector(data,
						   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.chuRuKuanColumNames));
			}
			
		});
		
		
		
		tableModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				POSXiaoShouCulomnModel.chuRuKuanColumNames);
        table = new JTable(tableModel);
        
		table.setPreferredScrollableViewportSize(new Dimension(700,356));//���̶���С
		pane2.add(new JScrollPane(table));
		
		panel_center.setLayout(new BorderLayout());
		panel_center.add(pane1,BorderLayout.NORTH);
		panel_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel_center;
	}
	public static void main(String[] args){
		new StockControlDialog(null,"POS��������",true);
	}
	
}
