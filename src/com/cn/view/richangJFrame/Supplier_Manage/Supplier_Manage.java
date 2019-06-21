package com.cn.view.richangJFrame.Supplier_Manage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Supplier_Manage.Action_Supplier_Manager_Button_tab_2;
import com.cn.control.richangframe.Supplier_Manage.JWindow_Supplier_Action;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;
import com.cn.view.jinhuoJFrame.WangLaiZhangWu;
import com.cn.view.systemJFrame.GongHuoShang;

public class Supplier_Manage extends JDialog {
	
	
	
	private JTextField text_North;
	private JTextArea textArea;
	private JTable table_north_right_tab_2;
	private JLabel label_Supplier_name;
	private JLabel label_lianxiren;
	private JLabel label_Tel;
	private JLabel label_Address;
	private JLabel label_pay;
	private JLabel label_fact_pay;
	private JLabel label_bettween;
	private JLabel label_record_num;
	private JLabel all_num;
	private JLabel all_money;
	private JLabel label_query;
	//获取从表中得到的供货商名称，联系人，联系电话，供货商地址
	private JLabel [] label_box_1 = new JLabel[4];
	//获取从表中得到的我方应付，我方实付，相差金额
	private JLabel [] label_box_2 = new JLabel[4];
	//获取从表中得到的记录数，我方应付，我方实付，
	private JLabel [] label_box_3 = new JLabel[3];
	private JButton query;
	private JButton button_1;
	private JButton supplier_debt;
	private JButton save;
	private JButton exit;
	private JButton add;
	private JButton change;
	private JButton delete;
	private JPanel North;
	private JPanel Center;
	private JPanel N_Center;
	private JPanel Box_1;
	private JPanel Box_2;
	private JPanel left_tab_1;
	private JPanel South_left_tab_1;
	private JPanel right_tab_1;
	private JPanel south_right_tab_1;
	private JPanel left_tab_2;
	private JPanel south_left_tab_2;
	private JPanel center_left_tab_2;
	private JPanel right_tab_2;
	private JPanel south_right_tab_2;
	private JPanel north_right_tab_2;
	private JPanel C_north_right_tab_2;
	private JSplitPane tab_1;
	private JSplitPane tab_2;
	private JTabbedPane C_Center;
	private JTable table_left_tab_1;//tabel_left_tab_1
	private  Vector data;//tabel_left_tab_1
	private AllTableModel tabelModel_left_tab_1;//tabel_left_tab_1
	
	private JTable table_right_tab_1;//tabel_right_tab_1
	private Vector data_1;//tabel_right_tab_1
	private AllTableModel tabelModel_right_tab_1;//tabel_right_tab_1
	
	private JTable table_right_tab_2;//able_right_tab_2
	private Vector data_2;//able_right_tab_2
	private AllTableModel tabelModel_right_tab_2;//able_right_tab_2
	
	private JButton chakanzhuangwu;
	private JPanel panel;
	
	
	
	
	public Supplier_Manage(JFrame frame,String title,boolean b) {
		super(frame,title,b);
		init();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(790, 535);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


	private void init() {
		addPanel();
		addPanel_1();
	}

	private void addPanel_1() {
		Center = new JPanel();
		getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout());
		addPanel_2();
		addtabbedPane();
	}
	//南端的JTabbedPane
	private void addtabbedPane() {
		C_Center = new JTabbedPane(JTabbedPane.TOP);
		Center.add(C_Center, BorderLayout.CENTER);
		addsplitPane();
		addsplitPane_1();
	}

	private void addsplitPane_1() {
		tab_2 = new JSplitPane();
		tab_2.setDividerSize(0);
		tab_2.setResizeWeight(1);
		C_Center.addTab("备注/联系记录", null, tab_2, null);
		addPanel_9();
		addPanel_12();
	}

	private void addPanel_12() {
		right_tab_2 = new JPanel();
		tab_2.setRightComponent(right_tab_2);
		right_tab_2.setLayout(new BorderLayout(0, 0));
		
		addPanel_13();
		addPanel_14();
	}

	private void addPanel_14() {
		north_right_tab_2 = new JPanel();
		north_right_tab_2.setBorder(new TitledBorder(null, "联系记录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		right_tab_2.add(north_right_tab_2, BorderLayout.NORTH);
		north_right_tab_2.setLayout(new BorderLayout(0, 0));
		
		addPanel_15();
	}
	/**
	 * tab_2中右边的表
	 * 用于供货商与业务员的联系
	 */
	private void addPanel_15() {
		C_north_right_tab_2 = new JPanel();
		north_right_tab_2.add(C_north_right_tab_2);
		C_north_right_tab_2.setLayout(new BorderLayout(0, 0));
		
		data_2 = new Vector();
		tabelModel_right_tab_2  = new AllTableModel(data_2, 
				AllTableModel.getVectorFromObj(Supplier_Manage_Model.connect_ghs));
		
		table_right_tab_2 = new JTable(tabelModel_right_tab_2);
		table_right_tab_2.setAutoCreateRowSorter(true);
		JScrollPane js_north_right_tab_2 = new JScrollPane(table_right_tab_2);
		C_north_right_tab_2.add(js_north_right_tab_2, BorderLayout.CENTER);
	}

	/**
	 * tab_2中的右下三个按钮
	 * 添加，修改，删除供应商联系
	 */
	private void addPanel_13() {
		south_right_tab_2 = new JPanel();
		right_tab_2.add(south_right_tab_2, BorderLayout.SOUTH);
		
		add = new JButton("添加");
		add.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_right_tab_2.add(add);
		
		change = new JButton("修改");
		change.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_right_tab_2.add(change);
		
		delete = new JButton("删除");
		delete.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_right_tab_2.add(delete);
	}

	private void addPanel_9() {
		left_tab_2 = new JPanel();
		tab_2.setLeftComponent(left_tab_2);
		left_tab_2.setLayout(new BorderLayout(0, 0));
		addPanel_10();
		addPanel_11();
	}

	private void addPanel_11() {
		center_left_tab_2 = new JPanel();
		center_left_tab_2.setBorder(new TitledBorder(null, "备注", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		left_tab_2.add(center_left_tab_2, BorderLayout.CENTER);
		center_left_tab_2.setLayout(new BorderLayout(0, 0));
		//TEXTAREA的Document监听器
		textArea = new JTextArea();
//		textArea.getDocument().addDocumentListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
			
		
		textArea.setLineWrap(true);
		center_left_tab_2.add(textArea, BorderLayout.CENTER);
	}

	private void addPanel_10() {
		south_left_tab_2 = new JPanel();
		left_tab_2.add(south_left_tab_2, BorderLayout.SOUTH);
		
		save = new JButton("保存");
		save.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_left_tab_2.add(save);
	}

	private void addsplitPane() {
		tab_1 = new JSplitPane();
		tab_1.setDividerSize(0);
		tab_1.setResizeWeight(0.1);
		C_Center.addTab("供应商供货情况", null, tab_1, null);
		addPanel_5();
		addPanel_6();
		
	}

	private void addPanel_6() {
		right_tab_1 = new JPanel();
		right_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "详细内容", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tab_1.setRightComponent(right_tab_1);
		right_tab_1.setLayout(new BorderLayout(0, 0));
		addTable_1();
		addPanel_8();
		
	}
	/**
	 * 右下方Label一栏
	 */
	private void addPanel_8() {
		south_right_tab_1 = new JPanel();
		FlowLayout fl_south_right_tab_1 = (FlowLayout) south_right_tab_1.getLayout();
		fl_south_right_tab_1.setAlignment(FlowLayout.RIGHT);
		right_tab_1.add(south_right_tab_1, BorderLayout.SOUTH);
		
		
		all_num = new JLabel("0.0      ");
		all_num.setForeground(Color.RED);
		south_right_tab_1.add(all_num);
		
		all_money = new JLabel("0.0        ");
		all_money.setForeground(Color.RED);
		south_right_tab_1.add(all_money);
	}
	


	/**
	 * 第一个tab的右边表table_right_tab_1（详细信息）
	 */
	private void addTable_1() {
		tabelModel_right_tab_1  = new AllTableModel(data_1, 
				AllTableModel.getVectorFromObj(Supplier_Manage_Model.detail_info));
		
		table_right_tab_1 = new JTable(tabelModel_right_tab_1);
		table_right_tab_1.setAutoCreateRowSorter(true);
		
		JScrollPane js_right_tab_1 = new JScrollPane(table_right_tab_1);
		right_tab_1.add(js_right_tab_1, BorderLayout.CENTER);
	}

	


	private void addPanel_5() {
		left_tab_1 = new JPanel();
		left_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "采购/退货/付款记录", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tab_1.setLeftComponent(left_tab_1);
		left_tab_1.setLayout(new BorderLayout(0, 0));
		addTable();
		addPanel_7();
		
	}
	/**
	 * 左下方的JLabel
	 */
	private void addPanel_7() {
		

		
		South_left_tab_1 = new JPanel();
		FlowLayout fl_South_left_tab_1 = (FlowLayout) South_left_tab_1.getLayout();
		fl_South_left_tab_1.setAlignment(FlowLayout.LEFT);
		left_tab_1.add(South_left_tab_1, BorderLayout.SOUTH);
		
		
		label_record_num = new JLabel("记录数：");
		South_left_tab_1.add(label_record_num);
		label_box_3[0] = new JLabel("0         ");
		South_left_tab_1.add(label_box_3[0]);
		
		label_box_3[1] = new JLabel("0.0      ");
		label_box_3[1].setForeground(Color.RED);
		South_left_tab_1.add(label_box_3[1]);
				
		label_box_3[2] = new JLabel("0.0                       ");
		label_box_3[2].setForeground(Color.RED);
		South_left_tab_1.add(label_box_3[2]);
		
		panel = new JPanel();
		left_tab_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		table_left_tab_1 = new JTable(tabelModel_left_tab_1);
		table_left_tab_1.setAutoCreateRowSorter(true);
		
		JScrollPane js_left_tab_1 = new JScrollPane(table_left_tab_1);
		panel.add(js_left_tab_1, BorderLayout.CENTER);
	}
	


	/**
	 * 第一个tab的左边表（采购/退货/付款记录）
	 * 如果在表中双击某行，则将再详细内容表中显示商品的详细信息
	 */
	private void addTable() {
		tabelModel_left_tab_1  = new AllTableModel(data, 
				AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
	}

	private void addPanel_2() {
		N_Center = new JPanel();//label栏的panel
		N_Center.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "供货商信息", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addPanel_3();
		addPanel_4();
		Center.add(N_Center, BorderLayout.NORTH);
		N_Center.setLayout(new BoxLayout(N_Center, BoxLayout.Y_AXIS));
		
		
	}
	/**
	 * 我方实付一栏
	 */
	private void addPanel_4() {
		Box_2 = new JPanel();
		FlowLayout fl_Box_2 = (FlowLayout) Box_2.getLayout();
		fl_Box_2.setAlignment(FlowLayout.LEFT);
		N_Center.add(Box_2);
		
		//label内容我方实付一栏
		Component horizontalStrut_1 = Box.createHorizontalStrut(62);
		Box_2.add(horizontalStrut_1);
		
		label_pay = new JLabel("我方应付：");
		Box_2.add(label_pay);
		
		label_box_2[0] = new JLabel("                      ");
		Box_2.add(label_box_2[0]);
		
		label_fact_pay = new JLabel("我方实付：");
		Box_2.add(label_fact_pay);
		
		label_box_2[1] = new JLabel("            ");
		Box_2.add(label_box_2[1]);
		
		label_bettween = new JLabel("相差金额：");
		Box_2.add(label_bettween);
		
		label_box_2[2] = new JLabel("                ");
		Box_2.add(label_box_2[2]);
		//查看账务情况
		chakanzhuangwu = new JButton("查看账务情况");
		chakanzhuangwu.setForeground(Color.BLUE);
		chakanzhuangwu.setVisible(false);
		chakanzhuangwu.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
//				int i = JOptionPane.showConfirmDialog(Supplier_Manage.this, 
//						"没有符合条件的记录，查询条件为：采购日期：2009-10-01" +
//						"至2009-10-23，业务员名称：所有业务员", 
//						"系统提示",
//						 JOptionPane.YES_OPTION,
//						 JOptionPane.WARNING_MESSAGE, 
//						new ImageIcon("res\\AcionIcon\\wenhao.jpg")
//                        );
				new WangLaiZhangWu(Supplier_Manage.this,"往来账务(供应商)",true);
			}
		});
		Box_2.add(chakanzhuangwu);
	}
	


	/**
	 * 供应商Label一栏
	 */
	private void addPanel_3() {
		Box_1 = new JPanel();
		FlowLayout fl_Box_1 = (FlowLayout) Box_1.getLayout();
		fl_Box_1.setAlignment(FlowLayout.LEFT);
		Box_1.setBorder(null);
		N_Center.add(Box_1);	
		
		//label内容供货商一栏
		Box_1.add(Box.createHorizontalStrut(50));
		label_Supplier_name = new JLabel("供应商名称：");
		Box_1.add(label_Supplier_name);
		label_box_1[0] = new JLabel("                      ");
		Box_1.add(label_box_1[0]);
		label_lianxiren = new JLabel("联 系 人：");
		Box_1.add(label_lianxiren);
		label_box_1[1] = new JLabel("            ");
		Box_1.add(label_box_1[1]);
		label_Tel = new JLabel("联系电话：");
		Box_1.add(label_Tel);
		label_box_1[2] = new JLabel("                ");
		Box_1.add(label_box_1[2]);
		label_Address = new JLabel("供应商地址：");
		Box_1.add(label_Address);
		label_box_1[3] = new JLabel("               ");
		Box_1.add(label_box_1[3]);
	}
	//最北边的panel
	private void addPanel() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		North = new JPanel();//最上面那个panel
		getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(new BoxLayout(North, BoxLayout.X_AXIS));
		
		North.add(Box.createHorizontalStrut(80));
		
		label_query = new JLabel("输入供货商名称或编号：");
		North.add(label_query);
		
		//当修改输入删除JTextField的数值时将查询出不同的供货商信息
		text_North = new JTextField(20);
		text_North.setToolTipText("可以输入供货商名称，编号，" +
				"联系人，联系电话，联系地址查询");
		text_North.getDocument().addDocumentListener(new JWindow_Supplier_Action(Supplier_Manage.this) );
		North.add(text_North);
		
		North.add(Box.createHorizontalStrut(20));
		//查询所有供货商的信息
		query = new JButton("查询");//查询按钮
		query.addActionListener(new JWindow_Supplier_Action(Supplier_Manage.this) );
		North.add(query);
		
		North.add(Box.createHorizontalStrut(20));
		
		button_1 = new JButton("供货商管理");//供货商管理按钮
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				new GongHuoShang(Supplier_Manage.this,"供货商信息");
			}
		});
		North.add(button_1);
		
		North.add(Box.createHorizontalStrut(20));
		//供货商账务按钮
		supplier_debt = new JButton("供货商账务");
		supplier_debt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		new WangLaiZhangWu(Supplier_Manage.this,"往来账务(供应商)",true);
			}
		});
		North.add(supplier_debt);
		
		North.add(Box.createHorizontalStrut(20));
		
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		North.add(exit);
		
		North.add(Box.createHorizontalStrut(40));
	}

	//获取Supplier_Manage（本窗口）”输入供货商名称或编号“的JTextField中输入的字符
	public String getText_North() {
		return text_North.getText();
	}
	//获取Supplier_Manage（本窗口）”输入供货商名称或编号“的JTextField
	public JTextField getJTextField(){
		return text_North;
	}
	//获取Supplier_Manage（本窗口）”输入供货商名称或编号“JLabel的横坐标
	public int get_X(){
		return label_query.getLocationOnScreen().x;
	}
	//获取Supplier_Manage（本窗口）”输入供货商名称或编号“JLabel的左下角的纵坐标
	public int get_Y(){
		return label_query.getLocationOnScreen().y + label_query.getSize().height;
	}
	//获取Supplier_Manage（本窗口）此为第一排空JLable（供应商名称）
	public JLabel[] getLabel_box_1() {
		return label_box_1;
	}
	//获取Supplier_Manage（本窗口）此为第二排空JLable（我方应付）
	public JLabel[] getLabel_box_2() {
		return label_box_2;
	}
	//获取Supplier_Manage（本窗口）box_2查询账务按钮
	public JButton getChakanzhuangwu() {
		return chakanzhuangwu;
	}
	//获取Supplier_Manage（本窗口）此为左下方JLable（记录数）
	public JLabel[] getLabel_box_3() {
		return label_box_3;
	}
	/**
	 * 获取Supplier_Manage（本窗口）第一个tab的左边表（采购/退货/付款记录）
	 * @return
	 */
	public JTable getTable_left_tab_1() {
		return table_left_tab_1;
	}
	//获取Supplier_Manage（本窗口）第一个tab的左边表（采购/退货/付款记录）的tabelModel
	public AllTableModel getTabelModel_left_tab_1() {
		return tabelModel_left_tab_1;
	}
	//设置Supplier_Manage（本窗口）第一个tab的左边表（采购/退货/付款记录）的data
	public void setData(Vector data) {
		this.data = data;
	}
	//获取Supplier_Manage（本窗口）第一个tab的左边表（采购/退货/付款记录）的data
	public Vector getTable_left_tab_1_Data() {
		return data;
	}
	/**
	 * 获取Supplier_Manage（本窗口）第一个tab的右边表（详细信息）
	 * @return
	 */
	public JTable getTable_right_tab_1() {
		return table_right_tab_1;
	}
	//获取Supplier_Manage（本窗口）第一个tab的右边表（详细信息）的tabelModel
	public AllTableModel getTabelModel_right_tab_1() {
		return tabelModel_right_tab_1;
	}
	//获取右下一栏的JLabe所有金额
	public JLabel getAll_money() {
		return all_money;
	}
	//获取右下一栏的JLabe所有数量
	public JLabel getAll_num() {
		return all_num;
	}
	/**
	 * 获取tab_2中右边的表结构
	 * 用于供货商与业务员的联系
	 */
	public AllTableModel getTabelModel_right_tab_2() {
		return tabelModel_right_tab_2;
	}
	//获取Table_right_tab_2，供应商联系表
	public JTable getTable_right_tab_2() {
		return table_right_tab_2;
	}
	/**
	 * tab_2中的四个按钮，保存，添加，修改，删除
	 * @return
	 */
	public JButton getSave() {//保存
		return save;
	}

	public JButton getAdd() {//添加
		return add;
	}


	public JButton getChange() {//修改
		return change;
	}


	public JButton getDelete() {//删除
		return delete;
	}
	//tab_2中textArea
	public JTextArea getTextArea() {
		return textArea;
	}
	//获取Table_right_tab_2的vector
	public Vector getData_2() {
		return data_2;
	}
}
