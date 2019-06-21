package com.cn.view.jinhuoJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.dao.jinhuo.wanglaizhangwu.JDBCPanel2;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCPanel3;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCPanel5;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCWangLaiZhangWu;
import com.cn.dao.jinhuo.wanglaizhangwu.ZhangWuJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.columnName.WangLaiZhangWuColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu.DanJuKeHuJDialog;
import com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu.FuKuanKeHuJDailog;
import com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu.QingKuangKeHuJDialog;
import com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu.XiaoShouKeHuJDialog;
import com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu.ZhangWuKeHuJDialog;

public class WangLaiZhangWu extends JDialog implements ActionListener {
	/*
	 * ������
	 */
	JFrame frame;
/**
 * panel1	���������е���
 */
	//north ���
	private JButton woFangFuKuan = new JButton(new ImageIcon("res/AcionIcon/wofangFuKuang.jpg"));
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton ShanChuDanJu = new JButton(new ImageIcon("res/AcionIcon/deleteDanJu.jpg"));
	private JButton zhengDanTuiHuo = new JButton(new ImageIcon("res/AcionIcon/zhengDantuihuo.jpg"));
	private JButton danJuGuoLv = new JButton(new ImageIcon("res/AcionIcon/zhengdanguolv.jpg"));
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//center ���
	private JDatePicker chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField gongHuoShangMingCheng = new JTextField(12);
	private JButton fangDa = new JButton(new ImageIcon("res/AcionIcon/fangDa.jpg"));
	//���۵ı�table1...
	private Vector table1_data = new Vector();//table ����
	private JTable table1;
	private AllTableModel ATM;
	//south 
	//table2...
	private JTable table2;
	private AllTableModel ATM2;
	private Vector table2_data = new Vector();//table ����
	//table3...
	private JTable table3;
	private AllTableModel ATM3;
	private Vector table3_data = new Vector();//table ����
/**
 *   panel2 �����̹��������
 */
	//panel2_north
	private JButton panel2_north_gaoJiChaXun = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	private JButton panel2_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton panel2_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//panel2_center
	private JDatePicker panel2_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker panel2_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField panel2_center_gongHuoShangMingCheng = new JTextField(12);
	private JButton panel2_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/fangDa.jpg"));
	//���ܱ����ˮ��tabel_huizong    table_liushui
	private AllTableModel ATM_huizong;
	private JTable table_huizong;
	private Vector huiZongBiao_data = new Vector();//table ����
	private AllTableModel ATM_liushui;
	private JTable table_liushui;
	private Vector liuShuiBiao_data = new Vector();//table ����
/**
 *  panel3 ��������Ʒ���������
 */
	//panel2_north
	private JButton panel3_north_gaoJiChaXun = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	private JButton panel3_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton panel3_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//panel2_center
	private JDatePicker panel3_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker panel3_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField panel3_center_gongHuoShangMingCheng = new JTextField(12);
	private JButton panel3_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/fangDa.jpg"));
	//���ܱ����ˮ��
	private AllTableModel ATM_panel3;
	private JTable table_panel3;
	private Vector panel3_huiZongBiao_data = new Vector();//table ����
/**
 *  ����������
 */
	//panel4_north
	private JButton panel4_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton panel4_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//panel4_center
	private JTextField panel4_center_gongHuoShangMingCheng = new JTextField(12);
	private JButton panel4_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/fangDa.jpg"));
	private JButton panel4_center_chaXun = new JButton("��ѯ");
	//��
	private AllTableModel ATM_panel4;
	private JTable table_panel4;
	private Vector panel4_data = new Vector();//table ����
 /**
  *  �ҷ�������ϸ
  */
	//panel5_north
	private JButton panel5_north_chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton panel5_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton panel5_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//panel5_center
	private JDatePicker panel5_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker panel5_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField panel5_center_gongHuoShangMingCheng = new JTextField(12);
	private JButton panel5_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/fangDa.jpg"));
	//table5...
	private AllTableModel ATM_panel5;
	private JTable table_panel5;
	private Vector panel5_data = new Vector();//table ����
	
	public JTextField getPanel5_center_gongHuoShangMingCheng() {
		return panel5_center_gongHuoShangMingCheng;
	}
	/**
	 * ������
	 * @param frame �����ĸ�����
	 * @param title ����
	 * @param model 
	 */
	public WangLaiZhangWu(JDialog frame,String title,boolean model){
		super(frame,title,model);
		init();
	}
	public WangLaiZhangWu(JFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		init();
	}
	private void init(){
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("���������е���", panel1());
		tab.addTab("�����̹��������",panel2());
		tab.addTab("��������Ʒ���������", panel3());
		tab.addTab("����������", gongHuoShangZhangWu());
		tab.addTab("�ҷ�������ϸ", woFangFuKuanMingXi());
		
		panel5_center_fangDa.addActionListener(this);
		panel4_center_chaXun.addActionListener(this);
		panel4_center_fangDa.addActionListener(this);
		panel3_center_fangDa.addActionListener(this);
		panel2_center_fangDa.addActionListener(this);
		fangDa.addActionListener(this);
		
		this.add(tab);
		this.setVisible(true);
		
	}
/**
 * tab1���������е���
 */
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
		//����˳�button
		JButton exit = exitButton();
		//����button�ڱ߾�
		woFangFuKuan.setMargin(new Insets(0,0,0,0));
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		ShanChuDanJu.setMargin(new Insets(0,0,0,0));
		zhengDanTuiHuo.setMargin(new Insets(0,0,0,0));
		danJuGuoLv.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		daYin.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		panel1_north.add(woFangFuKuan);
		panel1_north.add(chaKanDanJu);
		panel1_north.add(ShanChuDanJu);
		panel1_north.add(zhengDanTuiHuo);
		//�����˻�
		zhengDanTuiHuo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i = table1.getSelectedRow();
				if(i == -1){
					JOptionPane.showMessageDialog(null,"��ѡ��ɹ�����!");
					return;
				}
				String danhao = ((Vector)table1_data.get(i)).get(2).toString();
				if(!danhao.matches("CJ.*")){
					JOptionPane.showMessageDialog(WangLaiZhangWu.this,
							"��ѡ��ɹ��������ݣ���CJ��ͷ!");
					return;
				}
				Vector argdata = JDBCWangLaiZhangWu.getDanJuXiangXi(danhao);
				//˳�򱻴����ˣ�������
				Vector newdata = new Vector();
				for(Object tmp : argdata){
					Vector inner = new Vector();
					inner.add(((Vector)tmp).get(0));
					inner.add(((Vector)tmp).get(1));
					inner.add(((Vector)tmp).get(2));
					inner.add(((Vector)tmp).get(6));
					inner.add(((Vector)tmp).get(7));
					inner.add(((Vector)tmp).get(3));
					inner.add(((Vector)tmp).get(4));
					inner.add(((Vector)tmp).get(5));
						
					newdata.add(inner);
				}
//				������
				String gonghuoshang = ((Vector)table1_data.get(i)).get(0).toString();
				//new һ���ɹ��˻�����
				new CaiGouTuiHuo(frame,"�ɹ��˻�",true,newdata,gonghuoshang);
			}
		});
		panel1_north.add(danJuGuoLv);
		panel1_north.add(daoChu);
		panel1_north.add(daYin);
		panel1_north.add(exit);
		//panel1_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		
		return panel1_north;
	}
	//panel1_center�ٷֳ�������pane1��pane2
	private JPanel panel1_center(){
		JPanel panel1_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
	  //pane1
		pane1.add(new JLabel("��ѯʱ��:"));
		pane1.add(chaXunShiJian);
		pane1.add(new JLabel("��"));
		pane1.add(zhi);
		pane1.add(new JLabel("����������"));
		pane1.add(gongHuoShangMingCheng);
		fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(fangDa);
		//ʱ�������
		chaXunShiJian.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					panel2_center_chaXunShiJian.setSelectedDate(
							chaXunShiJian.getSelectedDate()) ;
					panel3_center_chaXunShiJian.setSelectedDate(
							chaXunShiJian.getSelectedDate()) ;
					panel5_center_chaXunShiJian.setSelectedDate(
							chaXunShiJian.getSelectedDate()) ;
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(
							WangLaiZhangWu.this,"���ݴ���!");
					e1.printStackTrace();
				}
				
			}
		});
		zhi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					panel2_center_zhi.setSelectedDate(
							zhi.getSelectedDate()) ;
					panel3_center_zhi.setSelectedDate(
							zhi.getSelectedDate()) ;
					panel5_center_zhi.setSelectedDate(
							zhi.getSelectedDate()) ;
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(
							WangLaiZhangWu.this,"Ū��ʱ���㻹��������쳣!");
					e1.printStackTrace();
				}
				
			}
		});
		
		//��ѯ��ť��һ����ز���
		JButton chaXun = new JButton("��ѯ");
		chaXun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String time1 = chaXunShiJian.getSelectedItem().toString();
				String time2 = zhi.getSelectedItem().toString();
				String gonghuoshang = gongHuoShangMingCheng.getText().toString();
				
				table1_data = JDBCWangLaiZhangWu.getCaiGou(time1,time2,gonghuoshang);
				
				ATM.setDataVector(table1_data,
						WangLaiZhangWuColumnNames.wanglaizhangwu_danJu );
			}
			
		});
		pane1.add(chaXun);
		
		//pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
	  //pane2
		//���۵ı�
		ATM = new AllTableModel(table1_data,
				WangLaiZhangWuColumnNames.wanglaizhangwu_danJu);
		table1 = new JTable(ATM);
		table1.addMouseListener(new MouseAdapter(){//���ϲ����ļ�����
			 public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1){
						int i = table1.getSelectedRow();
						String danhao = (String)((Vector)table1_data.get(i)).get(2);
						//table2�ĸ���ˢ��
						table2_data = JDBCWangLaiZhangWu.getDanJuXiangXi(danhao);
						ATM2.setDataVector(table2_data,WangLaiZhangWuColumnNames.wanglaizhangwu_xiangDan);
						//table3�ĸ���ˢ��
						Vector argv = new Vector();
						Vector argv1 = new Vector();
						argv.add(((Vector)table1_data.get(i)).get(0));
						argv.add(((Vector)table1_data.get(i)).get(1));
						argv.add(((Vector)table1_data.get(i)).get(2));
						argv.add(((Vector)table1_data.get(i)).get(3));
						argv.add(((Vector)table1_data.get(i)).get(5));
						argv.add(((Vector)table1_data.get(i)).get(8));
						argv.add(((Vector)table1_data.get(i)).get(9));
						argv.add("�ɹ�����ʱ��ʵ����");
						argv1.add(argv);
						table3_data = argv1;
						
						ATM3.setDataVector(table3_data, WangLaiZhangWuColumnNames.wanglaizhangwu_fuKuan);
					}
				} 
		});
		//���̶���С
		table1.setPreferredScrollableViewportSize(new Dimension(880,220));
		
		pane2.add(new JScrollPane(table1));
	  //panel1_center
		panel1_center.setLayout(new BorderLayout());
		panel1_center.add(pane1,BorderLayout.NORTH);
		panel1_center.add(pane2,BorderLayout.CENTER);
		
		return panel1_center;
	}
	//panel1_south
	private JPanel panel1_south(){
		JPanel panel1_south = new JPanel();
		JLabel label1 = new JLabel("���ݵ���ϸ��Ϣ : ");
		JLabel label2 = new JLabel("����������Ϣ�������ɹ������˻����������Ϣ");
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		
		ATM2 = new AllTableModel(table2_data,WangLaiZhangWuColumnNames.wanglaizhangwu_xiangDan);
		table2 = new JTable(ATM2);
		table2.setPreferredScrollableViewportSize(new Dimension(880,90));//���̶���С
		
		ATM3 = new AllTableModel(table3_data,WangLaiZhangWuColumnNames.wanglaizhangwu_fuKuan);
		table3 = new JTable(ATM3);
		table3.setPreferredScrollableViewportSize(new Dimension(880,90));//���̶���С
		
		pane1.add(new JScrollPane(table2));
		pane2.add(new JScrollPane(table3));
		
		//south ������tabbedPane���
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("���ݵ���Ʒ��Ϣ", pane1);
		tab.addTab("���ݵĸ�����Ϣ",pane2);
		tab.setPreferredSize(new Dimension(880,125));//����tab�Ĵ�С
		
		panel1_south.setLayout(new BorderLayout());
		panel1_south.add(label1,BorderLayout.NORTH);
		panel1_south.add(tab,BorderLayout.CENTER);
		panel1_south.add(label2,BorderLayout.SOUTH);
		return panel1_south;
	}
/**
 * 	tab2�����̹��������
 */
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new BorderLayout());
		panel2.add(panel2_north(),BorderLayout.NORTH);
		panel2.add(panel2_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("��ѯ��������ɹ������˻�������ϸ��Ϣ���ܽ������Żݽ��");
		panel2.add(label,BorderLayout.SOUTH);
		
		return panel2;
	}
	//panel2_north
	private JPanel panel2_north(){
		JPanel panel2_north = new JPanel();
		//����˳�button
		JButton exit = exitButton();
		
		panel2_north_gaoJiChaXun.setMargin(new Insets(0,0,0,0));
		panel2_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel2_north_daYin.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		panel2_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel2_north.add(panel2_north_gaoJiChaXun);
		panel2_north.add(panel2_north_daoChu);
		panel2_north.add(panel2_north_daYin);
		panel2_north.add(exit);
		//panel2_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel2_north;
	}
	//panel2_center ��Ϊ������
	private JPanel panel2_center(){
		JPanel panel2_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel2_center_chaXunShiJian);
		pane1.add(new JLabel("�� :"));
		pane1.add(panel2_center_zhi);
		pane1.add( new JLabel("���������� :"));
		pane1.add(panel2_center_gongHuoShangMingCheng);
		panel2_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel2_center_fangDa);
		//��ѯ��ť
		JButton panel2_center_chaXun = new JButton("��ѯ");
		panel2_center_chaXun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String time1 = panel2_center_chaXunShiJian.getSelectedItem().toString();
				String time2 = panel2_center_zhi.getSelectedItem().toString();
				String gonghuoshang = panel2_center_gongHuoShangMingCheng.getText().toString();
				
				huiZongBiao_data = JDBCPanel2.getData(time1,time2,gonghuoshang);
				
				ATM_huizong.setDataVector(huiZongBiao_data,
						WangLaiZhangWuColumnNames.wanglaizhangwu_huizong );
			}
		});
		pane1.add(panel2_center_chaXun);
		//checkBox
		ButtonGroup bg = new ButtonGroup();
		//pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		
		ATM_huizong = new AllTableModel(huiZongBiao_data,WangLaiZhangWuColumnNames.wanglaizhangwu_huizong);
		table_huizong = new JTable(ATM_huizong);
		table_huizong.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table_huizong));
		
		panel2_center.setLayout(new BorderLayout());
		panel2_center.add(pane1,BorderLayout.NORTH);
		panel2_center.add(pane2,BorderLayout.CENTER);
		
		return panel2_center;
	}
/**
 * ���������������
 */
	private JPanel panel3(){
		JPanel panel3 = new JPanel();
		
		panel3.setLayout(new BorderLayout());
		panel3.add(panel3_north(),BorderLayout.NORTH);
		panel3.add(panel3_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("��ѯ��������ɹ������˻�������ϸ��Ϣ���ܽ������Żݽ��");
		panel3.add(label,BorderLayout.SOUTH);
		return panel3;
	}
	//panel3_north
	private JPanel panel3_north(){
		JPanel panel3_north = new JPanel();
		//����˳�button
		JButton exit = exitButton();
		
		panel3_north_gaoJiChaXun.setMargin(new Insets(0,0,0,0));
		panel3_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel3_north_daYin.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		panel3_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel3_north.add(panel3_north_gaoJiChaXun);
		panel3_north.add(panel3_north_daoChu);
		panel3_north.add(panel3_north_daYin);
		panel3_north.add(exit);
		//panel3_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel3_north;
	}
	//panel3_center ��Ϊ������pane1��pane2
	private JPanel panel3_center(){
		JPanel panel3_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel3_center_chaXunShiJian);
		pane1.add(new JLabel("�� :"));
		pane1.add(panel3_center_zhi);
		pane1.add(new JLabel("���������� :"));
		pane1.add(panel3_center_gongHuoShangMingCheng);
		panel3_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel3_center_fangDa);
		//��ѯ��ť
		JButton panel3_center_chaXun = new JButton("��ѯ");
		pane1.add(panel3_center_chaXun);
		panel3_center_chaXun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String time1 = panel3_center_chaXunShiJian.getSelectedItem().toString();
				String time2 = panel3_center_zhi.getSelectedItem().toString();
				String gonghuoshang = panel3_center_gongHuoShangMingCheng.getText().toString();
				
				panel3_huiZongBiao_data= JDBCPanel3.getData(time1,time2,gonghuoshang);
				
				ATM_panel3.setDataVector(panel3_huiZongBiao_data,
						WangLaiZhangWuColumnNames.wanglaizhangwu_panel3 );
			}
			
		});
		//checkBox
		ButtonGroup bg = new ButtonGroup();
		//pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		
		ATM_panel3 = new AllTableModel(panel3_huiZongBiao_data,WangLaiZhangWuColumnNames.wanglaizhangwu_panel3);
		table_panel3 = new JTable(ATM_panel3);
		table_panel3.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table_panel3));
		
		panel3_center.setLayout(new BorderLayout());
		panel3_center.add(pane1,BorderLayout.NORTH);
		panel3_center.add(pane2,BorderLayout.CENTER);
		
		return panel3_center;
	}
/**
 * 	����������
 */
	private JPanel gongHuoShangZhangWu(){
		JPanel gongHuoShangZhangWu = new JPanel();
		
		gongHuoShangZhangWu.setLayout(new BorderLayout());
		gongHuoShangZhangWu.add(panel4_north(),BorderLayout.NORTH);
		gongHuoShangZhangWu.add(panel4_center(),BorderLayout.CENTER);
		return gongHuoShangZhangWu;
	}
	//panel4_north
	private JPanel panel4_north(){
		JPanel panel4_north = new JPanel();
		//����˳�button
		JButton exit = exitButton();
		
		panel4_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel4_north_daYin.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		panel4_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel4_north.add(panel4_north_daoChu);
		panel4_north.add(panel4_north_daYin);
		panel4_north.add(exit);
		//panel4_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel4_north;
	}
	//panel4_center ��Ϊ������
	private JPanel panel4_center(){
		JPanel panel4_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.add(new JLabel("���������ƣ�"));
		pane1.add(panel4_center_gongHuoShangMingCheng);
		panel4_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel4_center_fangDa);
		pane1.add(panel4_center_chaXun);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		ATM_panel4 = new AllTableModel(panel4_data,WangLaiZhangWuColumnNames.wanglaizhangwu_panel4);
		table_panel4 = new JTable(ATM_panel4);
		table_panel4.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table_panel4));
		
		panel4_center.setLayout(new BorderLayout());
		panel4_center.add(pane1,BorderLayout.NORTH);
		panel4_center.add(pane2,BorderLayout.CENTER);
		
		return panel4_center;
	}
/**
 * �ҷ�������ϸ
 */
	private JPanel woFangFuKuanMingXi(){
		JPanel woFangFuKuanMingXi = new JPanel();
		
		woFangFuKuanMingXi.setLayout(new BorderLayout());
		woFangFuKuanMingXi.add(panel5_north(),BorderLayout.NORTH);
		woFangFuKuanMingXi.add(panel5_center(),BorderLayout.CENTER);
		return woFangFuKuanMingXi;
	}
	//panel5_north
	private JPanel panel5_north(){
		JPanel panel5_north = new JPanel();
		//����˳�button
		JButton exit = exitButton();
		
		panel5_north_chaKanDanJu.setMargin(new Insets(0,0,0,0));
		panel5_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel5_north_daYin.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		panel5_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel5_north.add(panel5_north_chaKanDanJu);
		panel5_north.add(panel5_north_daoChu);
		panel5_north.add(panel5_north_daYin);
		panel5_north.add(exit);
		//panel5_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel5_north;
	}
	//panel5_center ��Ϊ������
	private JPanel panel5_center(){
		JPanel panel5_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel5_center_chaXunShiJian);
		pane1.add(new JLabel("�� :"));
		pane1.add(panel5_center_zhi);
		pane1.add(new JLabel("���������� :"));
		pane1.add(panel5_center_gongHuoShangMingCheng);
		panel5_center_fangDa.setMargin(new Insets(0,0,0,0));//�����ڱ߾�
		pane1.add(panel5_center_fangDa);
		//��ѯ��ť
		JButton panel5_center_chaXun = new JButton("��ѯ");
		pane1.add(panel5_center_chaXun);
		panel5_center_chaXun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String time1 = panel5_center_chaXunShiJian.getSelectedItem().toString();
				String time2 = panel5_center_zhi.getSelectedItem().toString();
				String gonghuoshang = panel5_center_gongHuoShangMingCheng.getText().toString();
				
				panel5_data= JDBCPanel5.getCaiGou(time1,time2,gonghuoshang);
				
				ATM_panel5.setDataVector(panel5_data,
						WangLaiZhangWuColumnNames.wanglaizhangwu_panel5 );
			}
			
		});
		
		//pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		//��
		ATM_panel5 = new AllTableModel(panel5_data,WangLaiZhangWuColumnNames.wanglaizhangwu_panel5);
		table_panel5 = new JTable(ATM_panel5);
		table_panel5.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		pane2.add(new JScrollPane(table_panel5));
		
		panel5_center.setLayout(new BorderLayout());
		panel5_center.add(pane1,BorderLayout.NORTH);
		panel5_center.add(pane2,BorderLayout.CENTER);
		
		return panel5_center;
	}
/**
 * �˳�Button���ദ�õ������ϵ�����
 */
	private JButton exitButton(){
		 
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				WangLaiZhangWu.this.dispose();
			}
		});
		return exit;
	}

/**
 * ����
 * @param args
 */
	public static void main(String[] args){
		new WangLaiZhangWu((JFrame)null,"��������(������)",true);
	}
	
public JTextField getGongHuoShangMingCheng() {
	return gongHuoShangMingCheng;
}
public JTextField getPanel2_center_gongHuoShangMingCheng() {
	return panel2_center_gongHuoShangMingCheng;
}
public JTextField getPanel3_center_gongHuoShangMingCheng() {
	return panel3_center_gongHuoShangMingCheng;
}
public JTextField getPanel4_center_gongHuoShangMingCheng() {
	return panel4_center_gongHuoShangMingCheng;
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==panel5_center_fangDa){
		new FuKuanKeHuJDailog(this,"�ͻ���Ϣ",true);
	}
	if(e.getSource()==panel4_center_chaXun){
		Vector v=ZhangWuJDBC.getZhangWu(panel4_center_gongHuoShangMingCheng.getText());
		ATM_panel4.setDataVector(v,WangLaiZhangWuColumnNames.wanglaizhangwu_panel4);
	}
	if(e.getSource()==panel4_center_fangDa){
		new ZhangWuKeHuJDialog(this,"�ͻ���Ϣ",true);
	}
	if(e.getSource()==panel3_center_fangDa){
		new XiaoShouKeHuJDialog(this,"�ͻ���Ϣ",true);
	}
	if(e.getSource()==panel2_center_fangDa){
		new QingKuangKeHuJDialog(this,"�ͻ���Ϣ",true);
	}
	if(e.getSource()==fangDa){
		new DanJuKeHuJDialog(this,"�ͻ���Ϣ",true);
	}
}
	
}
