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

import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;

/**
 * POS��Ʒ����ͳ�ƶԻ���
 * @author Administrator
 *
 */
public class OfftakeCountDialog extends JDialog {
	
	/*
	 * �Ի��򱱲�����ϵ����
	 */
	//�鿴��ϸ��ť
	private JButton seeDetailedButton = new JButton(new ImageIcon("res/AcionIcon/chakanmingxi.jpg"));
	//������ť
	private JButton exportButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��ӡ��ť
	private JButton printButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//�˳���ť
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	/*
	 * �Ի����м�����ϵ����
	 */
	
	//��ѯʱ�����
	private TimeSpinnerPanel timeSpinner = new TimeSpinnerPanel();
	//��ѯʱ�䰴ť
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//��Ʒ��Ϣ�ı���
	private JTextField infoText = new JTextField(10);
	//��ѯ��ť
	private JButton queryButton = new JButton("��ѯ(F2)");
	//��
	private JTable goodsInfoTable;
	private AllTableModel goodsInfoModel;
	
	
	
	
	
	public TimeSpinnerPanel getTimeSpinner() {
		return timeSpinner;
	}
	public JTextField getInfoText() {
		return infoText;
	}
	public JTable getGoodsInfoTable() {
		return goodsInfoTable;
	}
	public OfftakeCountDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
	}
	public void init(){
		//this.setSize(880,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.add(createNorthPanel(),BorderLayout.NORTH);
		this.add(createCenterPanel(),BorderLayout.CENTER);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		initData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	/**
	 * ���ݳ�ʼ��
	 *
	 */
	private void initData(){
		
		String spID = this.getInfoText().getText();
		Vector data = XPOSJDBCControl.getPOSSPXiaoShouPaiHang("2000-1-1","2222-2-2",spID);
		this.getGoodsInfoModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.goodsInfoColumNames));
		
	}
	/**
	 * �Ի��򱱲����������Ĳ���
	 * 
	 * @return
	 */
	public JPanel createNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,3));
		northPanel.setBorder(new LineBorder(Color.GRAY));
		
		seeDetailedButton.setMargin(new Insets(0,0,0,0));
		exportButton.setMargin(new Insets(0,0,0,0));
		printButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		
		exitButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	dispose();
			}
			
		});
		
		northPanel.add(seeDetailedButton);
		northPanel.add(exportButton);
		northPanel.add(printButton);
		northPanel.add(exitButton);
		
		
		return northPanel ;
	}
	
	/**
	 * �Ի����м����������Ĳ���
	 * 
	 * @return
	 */
	public JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		
		JPanel north = new JPanel();
		north.setBorder(new LineBorder(Color.GRAY));
		north.setLayout(new FlowLayout(FlowLayout.LEFT,0,1));
		north.add(new JLabel("��������:"));
		north.add(timeSpinner);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		north.add(shiJianButton);
		north.add(new JLabel("��Ʒ��Ϣ:"));
		north.add(infoText);
		infoText.setToolTipText("��Ϊ�������");
		north.add(queryButton);
		queryButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String spID = OfftakeCountDialog.this.getInfoText().getText();
				
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							OfftakeCountDialog.this.getTimeSpinner().getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							OfftakeCountDialog.this.getTimeSpinner().getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSSPXiaoShouPaiHang(dateFrom,dateTo,spID);
				
				OfftakeCountDialog.this.getGoodsInfoModel().setDataVector(data,
				   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.goodsInfoColumNames));
			}
			
		});
		JPanel center = new JPanel();
		goodsInfoModel = new AllTableModel(POSXiaoShouCulomnModel.obj,POSXiaoShouCulomnModel.goodsInfoColumNames);
		goodsInfoTable = new JTable(goodsInfoModel);
		JScrollPane scroll = new JScrollPane(goodsInfoTable);
		goodsInfoTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		goodsInfoTable.setPreferredScrollableViewportSize(new Dimension(870,356));//���̶���С
		center.add(scroll);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north,BorderLayout.NORTH);
		centerPanel.add(center,BorderLayout.CENTER);
		centerPanel.add(new JLabel("˵��:��ѯ��ʾ���ܽ������Żݽ��"),BorderLayout.SOUTH);
		
		
		return centerPanel ;
	}
	
	//������
	public static void main(String[] args){
		new OfftakeCountDialog(null,"POS��Ʒ����ͳ��",true);
	}
	public AllTableModel getGoodsInfoModel() {
		return goodsInfoModel;
	}
}
