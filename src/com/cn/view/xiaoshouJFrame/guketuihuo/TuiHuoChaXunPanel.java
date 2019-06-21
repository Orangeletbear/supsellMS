package com.cn.view.xiaoshouJFrame.guketuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.JDatePicker;

/**
 * 
 * ��ʼ���˿��˻��Ի����ϵ��˻���ѯ���
 * @author Administrator
 *
 */
public class TuiHuoChaXunPanel extends JPanel {
	
	//�˻���ѯ���ĸ߼���ѯ��ť
	private JButton chaXunButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//�˻���ѯ���Ĳ鿴���ݰ�ť
	private JButton chaKanButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//�˻���ѯ���ĵ�����ť
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//�˻���ѯ�����˳���ť
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
    //����ʱ��
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	//�鿴ʱ�䰴ť
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//�ͻ��ı���
	private JTextField keHuText = new JTextField(10);
	//��ѯ��ť
	private JButton chaXun = new JButton("��ѯ(F2)");
	
	private JRadioButton danJuBiao = new JRadioButton("���ݱ�");
	
	//��һ�����
	private JTable danJuTable;
	
	//�ڶ������
	
	private JTable xiangXiTable ;
	
	
	private JLabel information = new JLabel("");
	
	public TuiHuoChaXunPanel() {
		init();
	}
	
	/**
	 * ��ʼ���˻���ѯ���
	 */
	public void init(){
		
		this.setLayout(new BorderLayout());
		this.add(createNorthPanel(),BorderLayout.NORTH);
		this.add(createCenterPanel1(),BorderLayout.CENTER);
	
	}
	
	/**
	 * �˻���ѯ���ı������������Ĳ���
	 * @return �������
	 */
	public JPanel createNorthPanel(){
		JPanel northPanel = new JPanel();
		FlowLayout layout =new FlowLayout(FlowLayout.LEFT,25,3);
		northPanel.setLayout(layout);
		
		chaXunButton.setMargin(new Insets(0,0,0,0));
		chaKanButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(chaXunButton);
		northPanel.add(chaKanButton);
		northPanel.add(daoChuButton);
		northPanel.add(tuiChuButton);
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 System.exit(2);
			}
			
		});
		
		JPanel panel1 = new JPanel();
		Box box1 = new Box(BoxLayout.X_AXIS);
		box1.add(new JLabel("��������: "));
		box1.add(dataPicker1);
		box1.add(new JLabel(" ��   "));
		box1.add(dataPicker2);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		box1.add(shiJianButton);
	
		Box box2 = new Box(BoxLayout.X_AXIS);
		box2.add(new JLabel("�ͻ�/���ݺ�:"));
		box2.add(keHuText);
		box2.add(chaXun);
		
		panel1.setLayout(new GridLayout(2,1,10,10));
		panel1.add(box1);
		panel1.add(box2);
		
		JPanel panel2 = new JPanel();
        panel2.setBorder(new LineBorder(Color.GRAY));
        panel2.setLayout(new GridLayout(3,1));
		ButtonGroup group = new ButtonGroup();
		group.add(danJuBiao);
		danJuBiao.setSelected(true);
		
		northPanel.add(panel1);
		northPanel.add(panel2);
		return northPanel;
	}
	
	/**
	 * �˻���ѯ�����м����������Ĳ���
	 * @return �м����
	 */
	public JPanel createCenterPanel1(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("���ݵ���ϸ��Ϣ:"));
		panel2.add(information);
		
		panel.add(panel2,BorderLayout.NORTH);
		
		JPanel center = new JPanel();
	    xiangXiTable = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.DanJuColumnNames);
		JScrollPane scroll = new JScrollPane(xiangXiTable);
		xiangXiTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		xiangXiTable.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
		center.add(scroll);
		panel.add(center,BorderLayout.CENTER);
		
	
		JPanel center2 = new JPanel();
	    danJuTable = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.QueryColumnNames);
		JScrollPane scroll2 = new JScrollPane(danJuTable);
		danJuTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		danJuTable.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
		center2.add(scroll2);
		
		
		centerPanel.add(center2);
		centerPanel.add(panel);
		return centerPanel;
	}
	
	
	//������
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750,500);
		f.add(new TuiHuoChaXunPanel());
		f.setVisible(true);
	}
}
