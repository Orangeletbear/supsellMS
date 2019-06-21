package com.cn.view.kuchunJFrame.kuchunchaxun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cn.control.kuchunframe.kucunchaxun.ChaKanSPMingXiBtnAction;
import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * ����ѯ����Ĳ鿴��ϸ
 * @author finey
 *
 */
public class ChaKanMingXiDialog extends JDialog {
	//��Ʒ����
	private JLabel spName = new JLabel("ͳһ�����");
	//��Ʒ�ܶ�
	private JLabel spSumE = new JLabel("0.00Ԫ");
	//��Ʒ����
	private JLabel spAllInterest= new JLabel("0.00Ԫ");
   //�������ڶ�
	private JDatePicker dateFrom;
	public JDatePicker getDateFrom() {
		return dateFrom;
	}
	public JDatePicker getDateTo() {
		return dateTo;
	}

	private JDatePicker dateTo;
	
	
	//�ֿ�
	private JComboBox canKuBox = new JComboBox(
			JDBCCuCunFind.getCanKuData());
	
	public JComboBox getCanKuBox() {
		return canKuBox;
	}

	//���
	private AllTableModel tableMO;
	private JTable detailTable;
	
	
	public AllTableModel getTableMO() {
		return tableMO;
	}

	//ͳ����
	private JLabel danJuNum = new JLabel("��������"+0);
	
	public JLabel getDanJuNum() {
		return danJuNum;
	}

	//������Ʒ���
	private String spIdFromP =null;
	
	public String getSpIdFromP() {
		return spIdFromP;
	}
	public ChaKanMingXiDialog(KuCunChaXunFrame frame,String title,int num){
		super(frame,title,true);
		init();
		if(num ==1){
			addDataForOne();
		}
		if(num ==2){
			addDataForTwo();
		}
		this.setVisible(true);
			
		
		
	}
	/*
	 * ��һ�������ϸ��ʼ��
	 */
	private void addDataForOne(){
		
		int row = ((KuCunChaXunFrame)this.getOwner()).
					getHysxtable1().getSelectedRow();
		String spId =  ((KuCunChaXunFrame)this.getOwner()).
					getTableModel().getValueAt(row, 0).toString();
		//��Ʒ��Ż�����
		String spName1 = ((KuCunChaXunFrame)this.getOwner()).
		getTableModel().getValueAt(row,1).toString();
		//��Ʒ��Ż�����
        spName.setText(spName1);
        spIdFromP = spId;
		Vector data = DanQianKuCunJDBC.getSPMingXiData(
				"1-1-1","2222-1-1",spId,"���вֿ�");
		tableMO.setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunDeTailFind));
		this.getDanJuNum().setText("������: "+data.size()); 
	}
	/*
	 * �ڶ��������ϸ��ʼ��
	 */
	private void addDataForTwo(){
		int row = ((KuCunChaXunFrame)this.getOwner()).
				getHysxtable2().getSelectedRow();
		String spId =  ((KuCunChaXunFrame)this.getOwner()).
				getTableMode2().getValueAt(row, 0).toString();
		 spIdFromP = spId;
		String spName1 = ((KuCunChaXunFrame)this.getOwner()).
		getTableMode2().getValueAt(row,1).toString();
		//��Ʒ��Ż�����
        spName.setText(spName1);
		Vector data = DanQianKuCunJDBC.getSPMingXiData(
				"1-1-1","2222-1-1",spId,"���вֿ�");
         
		tableMO.setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunDeTailFind));
		this.getDanJuNum().setText("������: "+data.size()); 
	}
	
	private void init(){
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(addPane());
		canKuBox.addItem("���вֿ�");
		canKuBox.setSelectedIndex(canKuBox.getItemCount()-1);
		
	}

	
	private JPanel addPane(){
		JPanel pane =new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPane = addNorthPane();
		
		JPanel centerTablePane = addCenterPane();
		
		JPanel southPane = addSouthPane();
		pane.add(northPane,BorderLayout.NORTH);
		pane.add(new JScrollPane(centerTablePane));
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	/*
	 * ���湤��������
	 */
	private JPanel addNorthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		//���ݹ���
		JButton djglBtn = new JButton(
				new ImageIcon("res/AcionIcon/zhengdanguolv.jpg"));
		djglBtn.setMargin(new Insets(0,0,0,0));
		//�鿴����
		JButton ckdjBtn = new JButton(
				new ImageIcon("res/AcionIcon/chakandanju.jpg"));
		ckdjBtn.setMargin(new Insets(0,0,0,0));
		//����
		JButton exportBtn = new JButton(
				new ImageIcon("res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		//�˳�
		JButton exitBtn = new JButton(
				new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ChaKanMingXiDialog.this.dispose();
			}
			
		});
		
		pane.add(djglBtn);
		pane.add(ckdjBtn);
		pane.add(exportBtn);
		pane.add(exitBtn);
		
		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(2,1,2,5));
		
		JPanel tmp = new JPanel();
		tmp.setLayout(new FlowLayout(FlowLayout.LEFT,50,2));
		
		JPanel intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("��Ʒ����: "));
		spName.setForeground(Color.red);
		intmPane.add(spName);
		tmp.add(intmPane);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("�����ܶ�: "));
		spSumE.setForeground(Color.red);
		intmPane.add(spSumE);
		tmp.add(intmPane);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("��������: "));
		spAllInterest.setForeground(Color.red);
		intmPane.add(spAllInterest);
		tmp.add(intmPane);
		
		gridPane.add(tmp);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("��ѯ����: "));
		dateFrom = new JDatePicker(JDatePicker.STYLE_CN_DATE);
		intmPane.add(dateFrom);
		intmPane.add(new JLabel("�� "));
		dateTo = new JDatePicker(JDatePicker.STYLE_CN_DATE);
		intmPane.add(dateTo);
		intmPane.add(new JLabel("���ڲֿ�: "));
		intmPane.add(canKuBox);
		JButton findBtn = new JButton("�� ѯ");
		findBtn.addActionListener(new ChaKanSPMingXiBtnAction(this));
		intmPane.add(findBtn);
		
		gridPane.add(intmPane);
		pane.add(gridPane);
		
		return pane;
	}
	/*
	 *�м�����
	 */
	private JPanel addCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		tableMO = new AllTableModel(KuCunKunCBDCulomns.data,
				KuCunKunCBDCulomns.KuCunDeTailFind);
		detailTable = new JTable(tableMO);
		detailTable.setPreferredScrollableViewportSize(
				new Dimension(1200, 400));
		detailTable.setAutoCreateRowSorter(true);
		
		pane.add(new JScrollPane(detailTable));
		return pane;
	}
	
	/*
	 * ����ͳ����������
	 */
	private JPanel addSouthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
		pane.add(danJuNum);
		return pane;
	}
	
	public static void main(String[] args) {
		new ChaKanMingXiDialog(null,"��Ʒ��ϸ",0);
	}

}
