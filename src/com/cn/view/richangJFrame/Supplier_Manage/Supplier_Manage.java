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
	//��ȡ�ӱ��еõ��Ĺ��������ƣ���ϵ�ˣ���ϵ�绰�������̵�ַ
	private JLabel [] label_box_1 = new JLabel[4];
	//��ȡ�ӱ��еõ����ҷ�Ӧ�����ҷ�ʵ���������
	private JLabel [] label_box_2 = new JLabel[4];
	//��ȡ�ӱ��еõ��ļ�¼�����ҷ�Ӧ�����ҷ�ʵ����
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
	//�϶˵�JTabbedPane
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
		C_Center.addTab("��ע/��ϵ��¼", null, tab_2, null);
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
		north_right_tab_2.setBorder(new TitledBorder(null, "��ϵ��¼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		right_tab_2.add(north_right_tab_2, BorderLayout.NORTH);
		north_right_tab_2.setLayout(new BorderLayout(0, 0));
		
		addPanel_15();
	}
	/**
	 * tab_2���ұߵı�
	 * ���ڹ�������ҵ��Ա����ϵ
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
	 * tab_2�е�����������ť
	 * ��ӣ��޸ģ�ɾ����Ӧ����ϵ
	 */
	private void addPanel_13() {
		south_right_tab_2 = new JPanel();
		right_tab_2.add(south_right_tab_2, BorderLayout.SOUTH);
		
		add = new JButton("���");
		add.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_right_tab_2.add(add);
		
		change = new JButton("�޸�");
		change.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_right_tab_2.add(change);
		
		delete = new JButton("ɾ��");
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
		center_left_tab_2.setBorder(new TitledBorder(null, "��ע", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		left_tab_2.add(center_left_tab_2, BorderLayout.CENTER);
		center_left_tab_2.setLayout(new BorderLayout(0, 0));
		//TEXTAREA��Document������
		textArea = new JTextArea();
//		textArea.getDocument().addDocumentListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
			
		
		textArea.setLineWrap(true);
		center_left_tab_2.add(textArea, BorderLayout.CENTER);
	}

	private void addPanel_10() {
		south_left_tab_2 = new JPanel();
		left_tab_2.add(south_left_tab_2, BorderLayout.SOUTH);
		
		save = new JButton("����");
		save.addActionListener(new Action_Supplier_Manager_Button_tab_2(Supplier_Manage.this));
		south_left_tab_2.add(save);
	}

	private void addsplitPane() {
		tab_1 = new JSplitPane();
		tab_1.setDividerSize(0);
		tab_1.setResizeWeight(0.1);
		C_Center.addTab("��Ӧ�̹������", null, tab_1, null);
		addPanel_5();
		addPanel_6();
		
	}

	private void addPanel_6() {
		right_tab_1 = new JPanel();
		right_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "��ϸ����", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tab_1.setRightComponent(right_tab_1);
		right_tab_1.setLayout(new BorderLayout(0, 0));
		addTable_1();
		addPanel_8();
		
	}
	/**
	 * ���·�Labelһ��
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
	 * ��һ��tab���ұ߱�table_right_tab_1����ϸ��Ϣ��
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
		left_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "�ɹ�/�˻�/�����¼", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tab_1.setLeftComponent(left_tab_1);
		left_tab_1.setLayout(new BorderLayout(0, 0));
		addTable();
		addPanel_7();
		
	}
	/**
	 * ���·���JLabel
	 */
	private void addPanel_7() {
		

		
		South_left_tab_1 = new JPanel();
		FlowLayout fl_South_left_tab_1 = (FlowLayout) South_left_tab_1.getLayout();
		fl_South_left_tab_1.setAlignment(FlowLayout.LEFT);
		left_tab_1.add(South_left_tab_1, BorderLayout.SOUTH);
		
		
		label_record_num = new JLabel("��¼����");
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
	 * ��һ��tab����߱��ɹ�/�˻�/�����¼��
	 * ����ڱ���˫��ĳ�У�������ϸ���ݱ�����ʾ��Ʒ����ϸ��Ϣ
	 */
	private void addTable() {
		tabelModel_left_tab_1  = new AllTableModel(data, 
				AllTableModel.getVectorFromObj(Supplier_Manage_Model.table_left_tab_1));
	}

	private void addPanel_2() {
		N_Center = new JPanel();//label����panel
		N_Center.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "��������Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addPanel_3();
		addPanel_4();
		Center.add(N_Center, BorderLayout.NORTH);
		N_Center.setLayout(new BoxLayout(N_Center, BoxLayout.Y_AXIS));
		
		
	}
	/**
	 * �ҷ�ʵ��һ��
	 */
	private void addPanel_4() {
		Box_2 = new JPanel();
		FlowLayout fl_Box_2 = (FlowLayout) Box_2.getLayout();
		fl_Box_2.setAlignment(FlowLayout.LEFT);
		N_Center.add(Box_2);
		
		//label�����ҷ�ʵ��һ��
		Component horizontalStrut_1 = Box.createHorizontalStrut(62);
		Box_2.add(horizontalStrut_1);
		
		label_pay = new JLabel("�ҷ�Ӧ����");
		Box_2.add(label_pay);
		
		label_box_2[0] = new JLabel("                      ");
		Box_2.add(label_box_2[0]);
		
		label_fact_pay = new JLabel("�ҷ�ʵ����");
		Box_2.add(label_fact_pay);
		
		label_box_2[1] = new JLabel("            ");
		Box_2.add(label_box_2[1]);
		
		label_bettween = new JLabel("����");
		Box_2.add(label_bettween);
		
		label_box_2[2] = new JLabel("                ");
		Box_2.add(label_box_2[2]);
		//�鿴�������
		chakanzhuangwu = new JButton("�鿴�������");
		chakanzhuangwu.setForeground(Color.BLUE);
		chakanzhuangwu.setVisible(false);
		chakanzhuangwu.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
//				int i = JOptionPane.showConfirmDialog(Supplier_Manage.this, 
//						"û�з��������ļ�¼����ѯ����Ϊ���ɹ����ڣ�2009-10-01" +
//						"��2009-10-23��ҵ��Ա���ƣ�����ҵ��Ա", 
//						"ϵͳ��ʾ",
//						 JOptionPane.YES_OPTION,
//						 JOptionPane.WARNING_MESSAGE, 
//						new ImageIcon("res\\AcionIcon\\wenhao.jpg")
//                        );
				new WangLaiZhangWu(Supplier_Manage.this,"��������(��Ӧ��)",true);
			}
		});
		Box_2.add(chakanzhuangwu);
	}
	


	/**
	 * ��Ӧ��Labelһ��
	 */
	private void addPanel_3() {
		Box_1 = new JPanel();
		FlowLayout fl_Box_1 = (FlowLayout) Box_1.getLayout();
		fl_Box_1.setAlignment(FlowLayout.LEFT);
		Box_1.setBorder(null);
		N_Center.add(Box_1);	
		
		//label���ݹ�����һ��
		Box_1.add(Box.createHorizontalStrut(50));
		label_Supplier_name = new JLabel("��Ӧ�����ƣ�");
		Box_1.add(label_Supplier_name);
		label_box_1[0] = new JLabel("                      ");
		Box_1.add(label_box_1[0]);
		label_lianxiren = new JLabel("�� ϵ �ˣ�");
		Box_1.add(label_lianxiren);
		label_box_1[1] = new JLabel("            ");
		Box_1.add(label_box_1[1]);
		label_Tel = new JLabel("��ϵ�绰��");
		Box_1.add(label_Tel);
		label_box_1[2] = new JLabel("                ");
		Box_1.add(label_box_1[2]);
		label_Address = new JLabel("��Ӧ�̵�ַ��");
		Box_1.add(label_Address);
		label_box_1[3] = new JLabel("               ");
		Box_1.add(label_box_1[3]);
	}
	//��ߵ�panel
	private void addPanel() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		North = new JPanel();//�������Ǹ�panel
		getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(new BoxLayout(North, BoxLayout.X_AXIS));
		
		North.add(Box.createHorizontalStrut(80));
		
		label_query = new JLabel("���빩�������ƻ��ţ�");
		North.add(label_query);
		
		//���޸�����ɾ��JTextField����ֵʱ����ѯ����ͬ�Ĺ�������Ϣ
		text_North = new JTextField(20);
		text_North.setToolTipText("�������빩�������ƣ���ţ�" +
				"��ϵ�ˣ���ϵ�绰����ϵ��ַ��ѯ");
		text_North.getDocument().addDocumentListener(new JWindow_Supplier_Action(Supplier_Manage.this) );
		North.add(text_North);
		
		North.add(Box.createHorizontalStrut(20));
		//��ѯ���й����̵���Ϣ
		query = new JButton("��ѯ");//��ѯ��ť
		query.addActionListener(new JWindow_Supplier_Action(Supplier_Manage.this) );
		North.add(query);
		
		North.add(Box.createHorizontalStrut(20));
		
		button_1 = new JButton("�����̹���");//�����̹���ť
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				new GongHuoShang(Supplier_Manage.this,"��������Ϣ");
			}
		});
		North.add(button_1);
		
		North.add(Box.createHorizontalStrut(20));
		//����������ť
		supplier_debt = new JButton("����������");
		supplier_debt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		new WangLaiZhangWu(Supplier_Manage.this,"��������(��Ӧ��)",true);
			}
		});
		North.add(supplier_debt);
		
		North.add(Box.createHorizontalStrut(20));
		
		exit = new JButton("�˳�");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		North.add(exit);
		
		North.add(Box.createHorizontalStrut(40));
	}

	//��ȡSupplier_Manage�������ڣ������빩�������ƻ��š���JTextField��������ַ�
	public String getText_North() {
		return text_North.getText();
	}
	//��ȡSupplier_Manage�������ڣ������빩�������ƻ��š���JTextField
	public JTextField getJTextField(){
		return text_North;
	}
	//��ȡSupplier_Manage�������ڣ������빩�������ƻ��š�JLabel�ĺ�����
	public int get_X(){
		return label_query.getLocationOnScreen().x;
	}
	//��ȡSupplier_Manage�������ڣ������빩�������ƻ��š�JLabel�����½ǵ�������
	public int get_Y(){
		return label_query.getLocationOnScreen().y + label_query.getSize().height;
	}
	//��ȡSupplier_Manage�������ڣ���Ϊ��һ�ſ�JLable����Ӧ�����ƣ�
	public JLabel[] getLabel_box_1() {
		return label_box_1;
	}
	//��ȡSupplier_Manage�������ڣ���Ϊ�ڶ��ſ�JLable���ҷ�Ӧ����
	public JLabel[] getLabel_box_2() {
		return label_box_2;
	}
	//��ȡSupplier_Manage�������ڣ�box_2��ѯ����ť
	public JButton getChakanzhuangwu() {
		return chakanzhuangwu;
	}
	//��ȡSupplier_Manage�������ڣ���Ϊ���·�JLable����¼����
	public JLabel[] getLabel_box_3() {
		return label_box_3;
	}
	/**
	 * ��ȡSupplier_Manage�������ڣ���һ��tab����߱��ɹ�/�˻�/�����¼��
	 * @return
	 */
	public JTable getTable_left_tab_1() {
		return table_left_tab_1;
	}
	//��ȡSupplier_Manage�������ڣ���һ��tab����߱��ɹ�/�˻�/�����¼����tabelModel
	public AllTableModel getTabelModel_left_tab_1() {
		return tabelModel_left_tab_1;
	}
	//����Supplier_Manage�������ڣ���һ��tab����߱��ɹ�/�˻�/�����¼����data
	public void setData(Vector data) {
		this.data = data;
	}
	//��ȡSupplier_Manage�������ڣ���һ��tab����߱��ɹ�/�˻�/�����¼����data
	public Vector getTable_left_tab_1_Data() {
		return data;
	}
	/**
	 * ��ȡSupplier_Manage�������ڣ���һ��tab���ұ߱���ϸ��Ϣ��
	 * @return
	 */
	public JTable getTable_right_tab_1() {
		return table_right_tab_1;
	}
	//��ȡSupplier_Manage�������ڣ���һ��tab���ұ߱���ϸ��Ϣ����tabelModel
	public AllTableModel getTabelModel_right_tab_1() {
		return tabelModel_right_tab_1;
	}
	//��ȡ����һ����JLabe���н��
	public JLabel getAll_money() {
		return all_money;
	}
	//��ȡ����һ����JLabe��������
	public JLabel getAll_num() {
		return all_num;
	}
	/**
	 * ��ȡtab_2���ұߵı�ṹ
	 * ���ڹ�������ҵ��Ա����ϵ
	 */
	public AllTableModel getTabelModel_right_tab_2() {
		return tabelModel_right_tab_2;
	}
	//��ȡTable_right_tab_2����Ӧ����ϵ��
	public JTable getTable_right_tab_2() {
		return table_right_tab_2;
	}
	/**
	 * tab_2�е��ĸ���ť�����棬��ӣ��޸ģ�ɾ��
	 * @return
	 */
	public JButton getSave() {//����
		return save;
	}

	public JButton getAdd() {//���
		return add;
	}


	public JButton getChange() {//�޸�
		return change;
	}


	public JButton getDelete() {//ɾ��
		return delete;
	}
	//tab_2��textArea
	public JTextArea getTextArea() {
		return textArea;
	}
	//��ȡTable_right_tab_2��vector
	public Vector getData_2() {
		return data_2;
	}
}
