package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

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

import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;

/**
 * POS������ˮ�˶Ի���
 * 
 * @author Administrator
 *
 */
public class XiaoShouLiuShuiZhangDialog extends JDialog {

	/*
	 * ��ʼ��������ˮ���ϵ�����ˮ��ѡ������
	 */
	
	private JPanel danJuPanel;//������ˮ��ѡ��ϵ����
	
	
	private JButton chaKanDanJuButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	private JButton exitButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	/*private  JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private TimeSpinnerPanel timeSpinner1 = new TimeSpinnerPanel();
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private TimeSpinnerPanel timeSpinner2 = new TimeSpinnerPanel();
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));*/
	private JComboBox shouYinYuanBox = new JComboBox(new String[] {"��������Ա","pos","04"});
	private JComboBox jingBanRenBox = new JComboBox(new String[] {"���о�����","pС��","С��"});
	private JButton chaXunButton = new JButton("��ѯ");
	
	private JTable table;
	
	/*
	 * ��ʼ��������ˮ������Ʒ��ϸ��ѡ�����ϵ����
	 */
	
	private JPanel mingXiPanel ;
	
	private JButton daoChuButton1 = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
	private JButton daYinButton1 = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	private JButton exitButton1 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
    private TimeSpinnerPanel timeChaXun = new TimeSpinnerPanel();
	private JTextField chaXunText = new JTextField(10);
	private JButton chaXunButton2 = new JButton("��ѯ");
	
	private JTable table2;
	
	/*
	 * 
	 */
	
	public XiaoShouLiuShuiZhangDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
	}
	public void init(){
		this.setSize(950, 550);
		//this.setResizable(false);
		tabbedPane();
		this.setVisible(true);
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
		//northPanel.setLayout(new GridLayout(1,2));
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
/*		
		JPanel panel1  = new JPanel();
	     panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("��ѯʱ��:"));
		panel1.add(dataPicker1);
		panel1.add(timeSpinner1);
		panel1.add(new JLabel(" �� "));
		panel1.add(dataPicker2);
		panel1.add(timeSpinner2);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		panel1.add(shiJianButton);*/
		
		JPanel panel2 = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		panel2.setLayout(layout);
		layout.setHgap(30);
		panel2.add(new JLabel("����Ա:"));
		panel2.add(shouYinYuanBox);
		panel2.add(new JLabel("������:"));
		panel2.add(jingBanRenBox);
		panel2.add(chaXunButton);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(new TimeSpinnerPanel());
		panel3.add(panel2);
		
		chaKanDanJuButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		exitButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(chaKanDanJuButton);
		northPanel.add(daoChuButton);
		northPanel.add(daYinButton);
		northPanel.add(exitButton);
		northPanel.add(panel3);
		
		return northPanel;
	}
	
	/**
	 * ������ˮ���ϵ�����ˮ��ѡ��м����������Ĳ���
	 * @return
	 */
	private JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel();
		
		table = new JTable(POSXiaoShouCulomnModel.obj,POSXiaoShouCulomnModel.danJuColumNames);
		JScrollPane scroll = new JScrollPane(table);
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
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,2));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("�����ݺ�/��Ա��ѯ:"));
		panel1.add(chaXunText);
		panel1.add(chaXunButton2);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(timeChaXun);
		panel2.add(panel1);
		
	
		daoChuButton1.setMargin(new Insets(0,0,0,0));
		daYinButton1.setMargin(new Insets(0,0,0,0));
		exitButton1.setMargin(new Insets(0,0,0,0));
		northPane.add(daoChuButton1);
		northPane.add(daYinButton1);
		northPane.add(exitButton1);
		northPane.add(panel2);
		return northPane;
	}
	
	/**
	 * ������ˮ������Ʒ��ϸ��ѡ��м����������Ĳ���
	 * @return
	 */
	private JPanel createCenterPane(){
		JPanel centerPanel = new JPanel();
		
		table = new JTable(POSXiaoShouCulomnModel.obj,POSXiaoShouCulomnModel.mingXiColumNames);
		JScrollPane scroll = new JScrollPane(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(950,356));//���̶���С
		centerPanel.add(scroll);
		return centerPanel;
	}
	//������
	public static void main(String[] args) {
	
		new XiaoShouLiuShuiZhangDialog(null,"������ˮ��",true);
		

	}
}
