package com.cn.view.xiaoshouJFrame.wanglaizhangwu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.util.JDatePicker;


/**
 * �������񣨿ͻ����Ի���
 * @author Administrator
 *
 */
public class WangLaiZhangWuDialog extends JDialog {
  //panel1	�ͻ������е���
	//north ���
	
	//��һ��ѡ��ϵ��ҷ����ť
	private JButton woFangFuKuan = new JButton(new ImageIcon("res/AcionIcon/wofangFuKuang.jpg"));
	//��һ��ѡ��ϵĲ鿴���ݰ�ť
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//��һ��ѡ��ϵ�ɾ�����ݰ�ť
	private JButton ShanChuDanJu = new JButton(new ImageIcon("res/AcionIcon/deleteDanJu.jpg"));
	//��һ��ѡ��ϵ������˻���ť
	private JButton zhengDanTuiHuo = new JButton(new ImageIcon("res/AcionIcon/zhengDantuihuo.jpg"));
	//��һ��ѡ��ϵĵ��ݹ��˰�ť
	private JButton danJuGuoLv = new JButton(new ImageIcon("res/AcionIcon/zhengdanguolv.jpg"));
	//��һ��ѡ��ϵĵ�����ť
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��һ��ѡ��ϵĴ�ӡ��ť
	private JButton daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//��һ��ѡ��ϵ��˳���ť
	private JButton tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	
	//center ���
	//����
	private JDatePicker chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	//��һ��ѡ��ϵĿͻ������ı���
	private JTextField keHuMingCheng = new JTextField(12);
	//�鿴���ڵİ�ť
	private JButton riQi = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//��ѯ�ͻ��İ�ť
	private JButton fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//��ѯ��ť
	private JButton chaXun = new JButton("��ѯ");
	//����
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	private JRadioButton anRiQiPaiXu = new JRadioButton("����������");
	//��һ��ѡ��ϵı�
	private Vector table1_data = new Vector();//table ����
	private Vector<String> table1_columnNames = new Vector<String>();//table ����
	//south ���
	private Vector table2_data = new Vector();//table ����
	private Vector<String> table2_columnNames = new Vector<String>();//table ����
	private Vector table3_data = new Vector();//table ����
	private Vector<String> table3_columnNames = new Vector<String>();//table ����
	
	
  //panel2 �ͻ����������
	//panel2_north
	//�ڶ���ѡ��ϵĸ߼���ѯ��ť
	private JButton panel2_north_gaoJiChaXun = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//�ڶ���ѡ��ϵĵ�����ť
	private JButton panel2_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//�ڶ���ѡ��ϵĴ�ӡ��ť
	private JButton panel2_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//�ڶ���ѡ��ϵ��˳���ť
	private JButton panel2_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel2_center

	//��������
	private JDatePicker panel2_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker panel2_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	//��ѯʱ��İ�ť
	private JButton panel2_center_RIQI = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//��ѯ�ͻ����ı���
	private JTextField panel2_center_keHuMingCheng = new JTextField(12);
	//��ѯ�ͻ��İ�ť
	private JButton panel2_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//��ѯ��ť
	private JButton panel2_center_chaXun = new JButton("��ѯ");
	
	private JRadioButton panel2_center_huiZongBiao = new JRadioButton("���ܱ�");
	
	//���ܱ�
	private Vector huiZongBiao_data = new Vector();//table ����
	private Vector<String> huiZongBiao_columnNames = new Vector<String>();//table ����
	private JLabel shangPinMingXiLabel = new JLabel(" ");
	//��ϸ��
	private Vector mingXiBiao_data = new Vector();//table ����
	private Vector<String> mingXiBiao_columnNames = new Vector<String>();//table ����

 //�ͻ�����
	//panel3_north
	//������ѡ��ϵĵ�����ť
	private JButton panel3_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//������ѡ��ϵĴ�ӡ��ť
	private JButton panel3_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//������ѡ��ϵ��˳���ť
	private JButton panel3_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel3_center
	
	//������ѡ��ϵĿͻ������ı���
	private JTextField panel3_center_keHuMingCheng = new JTextField(12);
	//������ѡ��ϲ��ҿͻ��İ�ť
	private JButton panel3_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//��ѯ��ť
	private JButton panel3_center_chaXun = new JButton("��ѯ");
	
	private Vector panel3_data = new Vector();//table ����
	private Vector<String> panel3_columnNames = new Vector<String>();//table ����
	
	
  //�ҷ�������ϸ
	//panel4_north
	//���ĸ�ѡ��Ĳ鿴���ݰ�ť
	private JButton panel4_north_chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//���ĸ�ѡ��ĵ�����ť
	private JButton panel4_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//���ĸ�ѡ��Ĵ�ӡ��ť
	private JButton panel4_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//���ĸ�ѡ����˳���ť
	private JButton panel4_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel4_center
	
	//����ʱ��
	private JDatePicker panel4_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker panel4_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	
	//���ĸ�ѡ��Ĳ�ѯ���ڰ�ť
	private JButton panel4_center_RIQI = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//���ĸ�ѡ��Ŀͻ������ı���
	private JTextField panel4_center_keHuMingCheng = new JTextField(12);
	//���ĸ�ѡ��Ĳ�ѯ�ͻ���ť
	private JButton panel4_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//��ѯ��ť
	private JButton panel4_center_chaXun = new JButton("��ѯ");
	private Vector panel4_data = new Vector();//table ����
	private Vector<String> panel4_columnNames = new Vector<String>();//table ����
	
	public WangLaiZhangWuDialog(JDialog parent,String title,boolean model){
		super(parent,title,model);
		init();
	}
	public WangLaiZhangWuDialog(JFrame parent,String title,boolean model){
		super(parent,title,model);
		init();
	}
	private void init(){
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);////////////////////////////////////////////////////////
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("�ͻ����е���", panel1());
		tab.addTab("�ͻ��������",panel2());
		tab.addTab("�ͻ�������Ϣ", gongHuoShangZhangWu());
		tab.addTab("�ͻ�������ϸ", woFangFuKuanMingXi());
		
		
		this.add(tab);
		this.setVisible(true);
		
	}
// tab1�ͻ����е���
	private JPanel panel1(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		panel1.add(panel1_north(),BorderLayout.NORTH);
		panel1.add(panel1_center(),BorderLayout.CENTER);
		panel1.add(panel1_south(),BorderLayout.SOUTH);
		
		return panel1;
	}
	//panel1_north
	private JPanel panel1_north(){
		JPanel panel1_north = new JPanel();
		panel1_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		//����button�ڱ߾�
		woFangFuKuan.setMargin(new Insets(0,0,0,0));
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		ShanChuDanJu.setMargin(new Insets(0,0,0,0));
		zhengDanTuiHuo.setMargin(new Insets(0,0,0,0));
		danJuGuoLv.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		daYin.setMargin(new Insets(0,0,0,0));
		tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel1_north.add(woFangFuKuan);
		panel1_north.add(chaKanDanJu);
		panel1_north.add(ShanChuDanJu);
		panel1_north.add(zhengDanTuiHuo);
		panel1_north.add(danJuGuoLv);
		panel1_north.add(daoChu);
		panel1_north.add(daYin);
		panel1_north.add(tuiChu);
		tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel1_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		
		return panel1_north;
	}
	//panel1_center�ٷֳ�������pane1��pane2
	private JPanel panel1_center(){
		JPanel panel1_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
	  //pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane1.add(new JLabel("��ѯʱ��:"));
		pane1.add(chaXunShiJian);
		pane1.add(new JLabel("��"));
		pane1.add(zhi);
		
		riQi.setMargin(new Insets(0,0,0,0));
		pane1.add(riQi);
		pane1.add(new JLabel("�ͻ�����:"));
		pane1.add(keHuMingCheng);
		fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(fangDa);
		pane1.add(chaXun);
		//checkBox �䵥ѡ
		
		pane1.add(anRiQiPaiXu);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
	  //pane2
		table1_columnNames.add("�ͻ�����");
		table1_columnNames.add( "����");
		table1_columnNames.add("����");
		table1_columnNames.add("����");
		table1_columnNames.add("Ӧ�����");
		table1_columnNames.add("ʵ�����");
		table1_columnNames.add("Ƿ����");
		table1_columnNames.add("�Żݽ��");
		table1_columnNames.add("������");
		table1_columnNames.add("����Ա");
		JTable table1 = new JTable(table1_data,table1_columnNames);
		table1.setAutoCreateRowSorter(true);
		//���̶���С
		table1.setPreferredScrollableViewportSize(new Dimension(880,220));
		
		pane2.add(new JScrollPane(table1));
		pane2.setBorder(new TitledBorder("���������б�:"));
	  //panel1_center
		panel1_center.setLayout(new BorderLayout());
		panel1_center.add(pane1,BorderLayout.NORTH);
		panel1_center.add(pane2,BorderLayout.CENTER);
		
		return panel1_center;
	}
	//panel1_south
	private JPanel panel1_south(){
		JPanel panel1_south = new JPanel();
		JLabel label1 = new JLabel("������ϸ��Ϣ : ");
		JLabel label2 = new JLabel("����������Ϣ���������۵����˻����������Ϣ");
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		
		
		table2_columnNames.add("��Ʒ���");
		table2_columnNames.add( "��Ʒ����");
		table2_columnNames.add("��λ");
		table2_columnNames.add("����");
		table2_columnNames.add("����");
		table2_columnNames.add("�ܽ��");
		table2_columnNames.add("����ͺ�");
		table2_columnNames.add("��ɫ");
		JTable table2 = new JTable(table2_data,table2_columnNames);
		table2.setAutoCreateRowSorter(true);
		table2.setPreferredScrollableViewportSize(new Dimension(880,90));//���̶���С
		
		
		table3_columnNames.add("�ͻ�����");
		table3_columnNames.add( "����");
		table3_columnNames.add("����");
		table3_columnNames.add("����");
		table3_columnNames.add("�տ���");
		table3_columnNames.add("������");
		table3_columnNames.add("����Ա");
		table3_columnNames.add("��ע");
		JTable table3 = new JTable(table3_data,table3_columnNames);
		table3.setAutoCreateRowSorter(true);
		table3.setPreferredScrollableViewportSize(new Dimension(880,90));//���̶���С
		
		pane1.add(new JScrollPane(table2));
		pane2.add(new JScrollPane(table3));
		
		//south ������tabbedPane���
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("������Ʒ��Ϣ", pane1);
		tab.addTab("���ݸ�����Ϣ",pane2);
		tab.setPreferredSize(new Dimension(880,125));//����tab�Ĵ�С
		
		panel1_south.setLayout(new BorderLayout());
		panel1_south.add(label1,BorderLayout.NORTH);
		panel1_south.add(tab,BorderLayout.CENTER);
		panel1_south.add(label2,BorderLayout.SOUTH);
		return panel1_south;
	}
	
	
// tab2	�ͻ��������
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new BorderLayout());
		panel2.add(panel2_north(),BorderLayout.NORTH);
		panel2.add(panel2_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("");
		panel2.add(label,BorderLayout.SOUTH);
		
		return panel2;
	}
	//panel2_north
	private JPanel panel2_north(){
		JPanel panel2_north = new JPanel();
		
		panel2_north_gaoJiChaXun.setMargin(new Insets(0,0,0,0));
		panel2_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel2_north_daYin.setMargin(new Insets(0,0,0,0));
		panel2_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel2_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel2_north.add(panel2_north_gaoJiChaXun);
		panel2_north.add(panel2_north_daoChu);
		panel2_north.add(panel2_north_daYin);
		panel2_north.add(panel2_north_tuiChu);
		panel2_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel2_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel2_north;
	}
	//panel2_center ��Ϊ������
	private JPanel panel2_center(){
		JPanel panel2_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		pane2.setBorder(new TitledBorder("��Ʒ���ۻ���"));
		//pane1
	
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,15,2));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel2_center_chaXunShiJian);
		pane1.add(new JLabel("�� "));
		pane1.add(panel2_center_zhi);
		panel2_center_RIQI.setMargin(new Insets(0,0,0,0));
		pane1.add(panel2_center_RIQI);
		pane1.add( new JLabel("�ͻ����� :"));
		pane1.add(panel2_center_keHuMingCheng);
		panel2_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel2_center_fangDa);
		pane1.add(panel2_center_chaXun);
		//checkBox
		
		pane1.add(panel2_center_huiZongBiao);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		huiZongBiao_columnNames.add("��Ʒ���");
		huiZongBiao_columnNames.add( "��Ʒ����");
		huiZongBiao_columnNames.add("��λ");
		huiZongBiao_columnNames.add("��������");
		huiZongBiao_columnNames.add("�����ܽ��");
		huiZongBiao_columnNames.add("����ͺ�");
		huiZongBiao_columnNames.add("��ɫ");
		huiZongBiao_columnNames.add("��������");
		huiZongBiao_columnNames.add("��ע");
		
		//��ϸ�������
		mingXiBiao_columnNames.add("�ͻ�����");
		mingXiBiao_columnNames.add( "���ݺ�");
		mingXiBiao_columnNames.add("��������");
		mingXiBiao_columnNames.add( "��λ");
		mingXiBiao_columnNames.add("����");
		mingXiBiao_columnNames.add("����");
		mingXiBiao_columnNames.add("�ܽ��");
		mingXiBiao_columnNames.add("����ͺ�");
		mingXiBiao_columnNames.add("��ɫ");
		
		JTable table1 = new JTable(huiZongBiao_data,huiZongBiao_columnNames);
		table1.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		JTable table2 = new JTable(mingXiBiao_data,mingXiBiao_columnNames);
		table2.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		
		pane3.setLayout(new BorderLayout());
		JPanel pane4 = new JPanel();
		pane4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane4.add(new JLabel("��Ʒ������ϸ:"));
		pane4.add(shangPinMingXiLabel);
		pane3.add(pane4,BorderLayout.NORTH);
		pane3.add(new JScrollPane(table2));
		
		
		pane2.add(new JScrollPane(table1));
		pane2.add(pane3);
		
		
		panel2_center.setLayout(new BorderLayout());
		panel2_center.add(pane1,BorderLayout.NORTH);
		panel2_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel2_center;
	}
	


// tab3		
	private JPanel gongHuoShangZhangWu(){
		JPanel gongHuoShangZhangWu = new JPanel();
		
		gongHuoShangZhangWu.setLayout(new BorderLayout());
		gongHuoShangZhangWu.add(panel3_north(),BorderLayout.NORTH);
		gongHuoShangZhangWu.add(panel3_center(),BorderLayout.CENTER);
		return gongHuoShangZhangWu;
	}
	//
	//panel3_north
	private JPanel panel3_north(){
		JPanel panel3_north = new JPanel();
		
		panel3_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel3_north_daYin.setMargin(new Insets(0,0,0,0));
		panel3_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel3_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel3_north.add(panel3_north_daoChu);
		panel3_north.add(panel3_north_daYin);
		panel3_north.add(panel3_north_tuiChu);
		panel3_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	dispose();
			}
			
		});
		panel3_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel3_north;
	}
	//panel3_center ��Ϊ������
	private JPanel panel3_center(){
		JPanel panel3_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.add(new JLabel("�ͻ����ƣ�"));
		pane1.add(panel3_center_keHuMingCheng);
		panel3_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel3_center_fangDa);
		pane1.add(panel3_center_chaXun);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		panel3_columnNames.add("�ͻ�������Ʒ���");
		panel3_columnNames.add( "�ͻ��������");
		panel3_columnNames.add("�ͻ�����");
		panel3_columnNames.add("��Ʒ���۶�");
		panel3_columnNames.add("��Ʒ�˻���");
		panel3_columnNames.add("�ϼƽ��");
		panel3_columnNames.add("�ҷ�Ӧ�ս��");
		panel3_columnNames.add("�ҷ�ʵ�ս��");
		panel3_columnNames.add("δ�ս��");
		
		JTable table = new JTable(panel3_data,panel3_columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table));
		
		panel3_center.setLayout(new BorderLayout());
		panel3_center.add(pane1,BorderLayout.NORTH);
		panel3_center.add(pane2,BorderLayout.CENTER);
		
		return panel3_center;
	}
	
// tab4
	private JPanel woFangFuKuanMingXi(){
		JPanel woFangFuKuanMingXi = new JPanel();
		
		woFangFuKuanMingXi.setLayout(new BorderLayout());
		woFangFuKuanMingXi.add(panel4_north(),BorderLayout.NORTH);
		woFangFuKuanMingXi.add(panel4_center(),BorderLayout.CENTER);
		return woFangFuKuanMingXi;
	}
	//
	//panel4_north
	private JPanel panel4_north(){
		JPanel panel4_north = new JPanel();
		
		panel4_north_chaKanDanJu.setMargin(new Insets(0,0,0,0));
		panel4_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel4_north_daYin.setMargin(new Insets(0,0,0,0));
		panel4_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel4_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel4_north.add(panel4_north_chaKanDanJu);
		panel4_north.add(panel4_north_daoChu);
		panel4_north.add(panel4_north_daYin);
		panel4_north.add(panel4_north_tuiChu);
		panel4_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	dispose();
			}
			
		});
		panel4_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel4_north;
	}
	//panel4_center ��Ϊ������
	private JPanel panel4_center(){
		JPanel panel4_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel4_center_chaXunShiJian);
		pane1.add(new JLabel("�� "));
		pane1.add(panel4_center_zhi);
		panel4_center_RIQI.setMargin(new Insets(0,0,0,0));
		pane1.add(panel4_center_RIQI);
		pane1.add(new JLabel("�ͻ����� :"));
		pane1.add(panel4_center_keHuMingCheng);
		panel4_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel4_center_fangDa);
		pane1.add(panel4_center_chaXun);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		panel4_columnNames.add("���ݱ��");
		panel4_columnNames.add( "��������");
		panel4_columnNames.add("�տʽ/����");
		panel4_columnNames.add("�տ���");
		panel4_columnNames.add("�ͻ�����");
		panel4_columnNames.add("������");
		panel4_columnNames.add("����Ա");
		panel4_columnNames.add("��ע ");
		
		
		JTable table = new JTable(panel4_data,panel4_columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table));
		
		panel4_center.setLayout(new BorderLayout());
		panel4_center.add(pane1,BorderLayout.NORTH);
		panel4_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel4_center;
	}
	

	public static void main(String[] args){
		
	}
	
	
}
