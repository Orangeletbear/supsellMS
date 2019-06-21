package com.cn.view.xiaoshouJFrame.guketuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.JDatePicker;


/**
 * 
 * ��ʼ���˻��Ի����ϵĹ˿��˻�ѡ��ϵ����
 * @author Administrator
 *
 */

public class GuKeTuiHuoPanel extends JPanel{

    private JPanel mainPanel = new JPanel();
	
	//�˿��˻�ѡ��Ĺ˿��˻���ǩ
	private JLabel topicLabel  = new JLabel("�˿��˻�");
	//�˿��˻�ѡ��ĵ��ű�ǩ
	private JLabel danHaoLabel = new JLabel("����:XT101013010001");
	//�ͻ����Ʊ�ǩ
	private JLabel nameLabel = new JLabel("�ͻ�����:");
	//�ͻ��ı���
	private JTextField  keHuText = new JTextField(10);
	//��ѯ�ͻ���ť
	private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//�ջ��ֿ��ǩ
	private JLabel shouHuoCangKuLabel = new JLabel("�ջ��ֿ�:");
	//�ֿ�Box
	private JComboBox cangKuBox = new JComboBox(new String[]{"���ֿ�"});
	//�������ڱ�ǩ
	private JLabel riQiLabel = new JLabel("��������:");
	//ʱ��
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//����˻���Ʒ��ť
	private JButton addButton = new JButton("����˻���Ʒ(F2)");
	//����˻���Ʒ��ť
	private JButton alterButton = new JButton("�޸���Ʒ(F3)");
	//����˻���Ʒ��ť
	private JButton deleteButton = new JButton("ɾ����Ʒ(F4)");
	//�����˻���ť
	private JButton tuiHuoButton = new JButton("�����˻�(F7)");
	
	//��������²������

    private JTable table;
	
	//Ӧ�˽���ǩ
	private JLabel yingTuiMoneyLabel = new JLabel("Ӧ�˽��:");
	//Ӧ�˽���ı���
	private JTextField yingTuiText = new JTextField(10);
	//ʵ�ս���ǩ
	private JLabel shiTuiMoneyLabel = new JLabel("ʵ�˽��:");
	//ʵ�ս���ı���
	private JTextField shiTuiText = new JTextField(10);
	//�����˱�ǩ
	private JLabel jingBanRenLabel = new JLabel("������:");
	//������Box
	private JComboBox jingBanBox = new JComboBox(new String[]{"С��","С��","���Ӿ�����"});
	//��ѯ�����˰�ť
	private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
	//��ע��ǩ
	private JLabel beiZhuLabel = new JLabel("��ע:");
	//��ע�ı���
	private JTextField beiZhuText = new JTextField(20);
	//�鿴��ע��ť
	private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
	//ȷ����ť
	private JButton sureButton = new JButton("ȷ��");
	//�˳���ť
	private JButton tuiChuButton = new JButton("�˳�");
	
	public GuKeTuiHuoPanel() {
		init();
		
	}
	
	public void init() {
	
		initMainPanel();
		this.add(mainPanel);
		this.setVisible(true);
		
	}
	
	/**
	 * ��ʼ���˿��˻�ѡ��ϵ������
	 */
	public void initMainPanel(){
		JPanel northPane = new JPanel();
		northPane.add(new JLabel("                                     "));
		northPane.add(topicLabel);
		northPane.add(new JLabel("                                  "));
        danHaoLabel.setForeground(Color.RED);
		northPane.add(danHaoLabel);
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPane,BorderLayout.NORTH);
		mainPanel.add(createNorthPane(),BorderLayout.CENTER);
		
		
	}
	/**
	 * �������������Ĳ���
	 * @return  �������
	 */
	public JPanel createNorthPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel northPane = new JPanel();
		
		northPane.setBorder(new LineBorder(Color.GRAY));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT,20,3);
		
		northPane.setLayout(layout);
		northPane.add(nameLabel);
		northPane.add(keHuText);
		keHuButton.setMargin(new Insets(0,0,0,0));
		northPane.add(keHuButton);
		northPane.add(shouHuoCangKuLabel);
		northPane.add(cangKuBox);
		northPane.add(riQiLabel);
		northPane.add(dataPicker1);
		
		JPanel southPane = new JPanel();
		southPane.setBorder(new LineBorder(Color.GRAY));
		southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPane.add(beiZhuLabel);
		southPane.add(beiZhuText);
		beiZhuButton.setMargin(new Insets(0,0,0,0));
		southPane.add(beiZhuButton);
	    southPane.add(new JLabel("                               " +
	    		"                                              "));
		southPane.add(sureButton);
		southPane.add(tuiChuButton);
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 System.exit(2);
			}
			
		});
		
		pane.add(northPane,BorderLayout.NORTH);
		pane.add(createCenterPane (),BorderLayout.CENTER);
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	/**
	 * �˿��˻�ѡ��ϵ��м���������Ĳ���
	 * @return �м����
	 */
	public JPanel createCenterPane () {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.add(addButton);
		northPanel.add(alterButton);
		northPanel.add(deleteButton);
		northPanel.add(tuiHuoButton);
		
		
		JPanel southPanel = new JPanel();
		
		southPanel.setBorder(new LineBorder(Color.GRAY));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(15);
		southPanel.setLayout(layout);
		southPanel.add(yingTuiMoneyLabel);
		southPanel.add(yingTuiText);
		southPanel.add(shiTuiMoneyLabel);
		southPanel.add(shiTuiText);
		southPanel.add(jingBanRenLabel);
		southPanel.add(jingBanBox);
		jingBanButton.setMargin(new Insets(0,0,0,0));
		southPanel.add(jingBanButton);
		southPanel.add(new JLabel("                    "));
		
		
		JPanel centerPanel = new JPanel();
		table = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.BackColumNames);
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
		centerPanel.add(scroll);
		
		pane.add(northPanel,BorderLayout.NORTH);
		pane.add(centerPanel,BorderLayout.CENTER);
		pane.add(southPanel,BorderLayout.SOUTH);
		
		return pane;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750,660);
		
		f.add(new GuKeTuiHuoPanel());
		f.setVisible(true);
	}

}

