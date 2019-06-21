package com.cn.view.richangJFrame.Guote_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Guote_Manage.Action_Add_Guote_Commit;
import com.cn.control.richangframe.Guote_Manage.Action_Guote_Tree;
import com.cn.control.richangframe.Guote_Manage.Action_Select_change_del;
import com.cn.control.richangframe.Guote_Manage.Action_Select_sp;
import com.cn.control.richangframe.Guote_Manage.Action_sp_tab_1;
import com.cn.dao.richang.Customer_Manage.JDBC_Connect_Record;
import com.cn.dao.richang.Guote_Manage.JDBC_Guote_Manage;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.util.InitTreePane;

public class Add_Quote_Goods extends JDialog {
	
	private JPanel split_1;
	private JPanel split_2;
	private JPanel N_split_1;
	private JLabel notice;
	private JPanel grid2_N_split_1;
	private JLabel goods_name_id;
	private JPanel S_split_2;
	private JPanel N_split_2;
	
	private JTabbedPane C_split_1;
	
	private JSplitPane splitPane;
	private JSplitPane tab_2;
	
	private JTree tree_tab_1;
	
	private JScrollPane tab_1;
	private JScrollPane C_split_2;
	private JScrollPane scroll_tab_2;
	
	private JTable table_tab_1;
	private JTable table_tab_2;
	private JTable table_right_tab;
	
	private JButton add_selected_goods;
	private JButton change;
	private JButton delete;
	private JButton confirm;
	private JButton cancel;
	
	private JTextField text_name_id;
	private AllTableModel tabelModel_table_tab_1;
	private Vector data_left_tab_1;//tab_1�����Ʒ�嵥����Ʒ��data_left_tab_1
	private Vector data_right_tab;//tab�ұ���Ʒ�嵥����Ʒ��data_right_tab

	private AllTableModel tabelModel_table_right;
	private JPanel grid_3_N_split_2;
	private JLabel label_beizhu;
	private JTextField beizhu;
	private Vector jbr;
	private DefaultComboBoxModel comboxMoel;
	private Quote_Manage dialog;
	private JPanel leftPane = new JPanel();
	private AllTableModel tabelModel_table_tab_2;
	private Vector data_left_tab_2 = new Vector();
	public void setData_left_tab_2(Vector data_left_tab_2) {
		this.data_left_tab_2 = data_left_tab_2;
	}

	public Add_Quote_Goods(Quote_Manage dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		
		splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setResizeWeight(0.6);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		init();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(900, 525);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void init() {
		addpanel_1();
		addpanel_2();
	}


	private void addpanel_2() {
		split_2 = new JPanel();
		split_2.setBorder(new TitledBorder(null, "��ѡ��Ʒ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(split_2);
		split_2.setLayout(new BorderLayout());
		{
			N_split_2 = new JPanel();
			split_2.add(N_split_2, BorderLayout.NORTH);
			N_split_2.setLayout(new GridLayout(1, 0, 0, 0));
			{
			
				{
						//JComboBox ѡ���������ݿ���Ա����
						jbr = JDBC_Connect_Record.get_jbr();
						comboxMoel = new DefaultComboBoxModel(jbr);
					
				}
				{
					grid_3_N_split_2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) grid_3_N_split_2.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					N_split_2.add(grid_3_N_split_2);
					{
						label_beizhu = new JLabel("��    ע��");
						grid_3_N_split_2.add(label_beizhu);
					}
					{
						beizhu = new JTextField(20);
						grid_3_N_split_2.add(beizhu);
						beizhu.setColumns(10);
					}
				}
				{
						
				}
			}
		{
				C_split_2 = new JScrollPane();
				
				
				//table_right_tab
				tabelModel_table_right = new AllTableModel(data_right_tab,
						AllTableModel.getVectorFromObj(Guote_Manage_Model.right_table_tab));
				table_right_tab = new JTable(tabelModel_table_right);
				table_right_tab.addMouseListener(new Action_Select_change_del(Add_Quote_Goods.this));
				table_right_tab.setAutoCreateRowSorter(true);
				C_split_2.setViewportView(table_right_tab);
				
				split_2.add(C_split_2, BorderLayout.CENTER);
		}
			{
					S_split_2 = new JPanel();
					//�ı���
					change = new JButton("�޸�");
					change.addActionListener(new Action_Select_change_del(Add_Quote_Goods.this));
					S_split_2.add(change);
					delete = new JButton("ɾ��");
					delete.addActionListener(new Action_Select_change_del(Add_Quote_Goods.this));
					S_split_2.add(delete);
					//�Ƿ�ȷ����Ӹ�����
					confirm = new JButton("ȷ��");
					confirm.addActionListener(new Action_Add_Guote_Commit(Add_Quote_Goods.this));
					S_split_2.add(confirm);
					cancel = new JButton("ȡ��");
					cancel.addActionListener(new Action_Add_Guote_Commit(Add_Quote_Goods.this));
					S_split_2.add(cancel);
				
					split_2.add(S_split_2, BorderLayout.SOUTH);
			}
		}
	}

	private void addpanel_1() {
		split_1 = new JPanel();
		split_1.setBorder(new TitledBorder(null, "��ѯ��Ʒ�б�", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(split_1);
		split_1.setLayout(new BorderLayout(0, 0));
		{
			N_split_1 = new JPanel();
			split_1.add(N_split_1, BorderLayout.NORTH);
			N_split_1.setLayout(new GridLayout(2, 0, 0, 0));
			{
				notice = new JLabel("  ��������Ʒ��Ż����Ʋ�ѯ��Ʒ����ѯ����Ʒ����ӵ��ұ���ѡ��Ʒ");
				N_split_1.add(notice);
			}
			{
				grid2_N_split_1 = new JPanel();
				FlowLayout fl_grid2_N_split_1 = (FlowLayout) grid2_N_split_1.getLayout();
				fl_grid2_N_split_1.setAlignment(FlowLayout.LEFT);
				N_split_1.add(grid2_N_split_1);
				{
					goods_name_id = new JLabel("������Ʒ��Ż����Ʋ�ѯ��Ʒ��");
					grid2_N_split_1.add(goods_name_id);
				}
				{	
					//tab_1�е�JTextField
					text_name_id = new JTextField(30);
					text_name_id.getDocument().addDocumentListener(new Action_sp_tab_1(Add_Quote_Goods.this));
					grid2_N_split_1.add(text_name_id);
					text_name_id.setColumns(10);
				}
				{	
					//tab_1�еļ�����ѡ��Ʒ
					add_selected_goods = new JButton("������ѡ��Ʒ");
					add_selected_goods.addActionListener(new Action_Select_sp(Add_Quote_Goods.this));
					grid2_N_split_1.add(add_selected_goods);
				}
			}
		}
		{
			C_split_1 = new JTabbedPane(JTabbedPane.TOP);
			split_1.add(C_split_1, BorderLayout.CENTER);
			{
				tab_1 = new JScrollPane();
				C_split_1.addTab("��Ʒ�嵥", null, tab_1, null);
				{	
					
					
					//table_left_tab_1
					data_left_tab_1 = JDBC_Guote_Manage.get_sp_select("");
					tabelModel_table_tab_1 = new AllTableModel(data_left_tab_1,
							AllTableModel.getVectorFromObj(Guote_Manage_Model.left_table_tab_1));
					table_tab_1 = new JTable(tabelModel_table_tab_1);
					
					//Add_Quote_Goods_self���tab_1�е�table_tab_1������������
					table_tab_1.addMouseListener(
							new Action_Select_sp(Add_Quote_Goods.this));
					tab_1.setViewportView(table_tab_1);
				}
			}
			{
				tab_2 = new JSplitPane();
				tab_2.setDividerSize(0);
				tab_2.setResizeWeight(0.3);
				C_split_1.addTab("��Ʒ�б�", null, tab_2, null);
				{	
					InitTreePane tmptree = new InitTreePane(tree_tab_1);
					tree_tab_1 = tmptree.getTree();
					tab_2.setLeftComponent(new JScrollPane(tmptree.getPane()));
					
					tree_tab_1.addMouseListener(new Action_Guote_Tree(this));
				}
				{
					scroll_tab_2 = new JScrollPane();
					tab_2.setRightComponent(scroll_tab_2);
					{	
						tabelModel_table_tab_2 = new AllTableModel(data_left_tab_2,
								AllTableModel.getVectorFromObj(Guote_Manage_Model.left_table_tab_2));
						table_tab_2 = new JTable(tabelModel_table_tab_2);
//						table_tab_2 = new JTable();
//						table_tab_2.setModel(new DefaultTableModel(
//							new Object[][] {
//							},
//							new String[] {
//								"��Ʒ���", "��Ʒ����", "Ԥ�����", "Ԥ���ۼ�"
//							}
//						));
						scroll_tab_2.setViewportView(table_tab_2);
					}
				}
			}
		}
	}
	
	public Vector getData_left_tab_2() {
		return data_left_tab_2;
	}

	//������ѡ��Ʒ�İ�ť
	public JButton getAdd_selected_goods() {
		return add_selected_goods;
	}

	public AllTableModel getTabelModel_table_tab_2() {
		return tabelModel_table_tab_2;
	}

	public JTree getTree_tab_1() {
		return tree_tab_1;
	}

	//��ȡ������Quote_Manage����
	public Quote_Manage getDialog() {
		return dialog;
	}


	//��ȡtab_1�����Ʒ�嵥����Ʒ��table_tab_1
	public JTable getTable_tab_1() {
		return table_tab_1;
	}
	//��ȡtab_1�����Ʒ�嵥����Ʒ��data_left_tab_1
	public Vector getData_left_tab_1() {
		return data_left_tab_1;
	}

	//��ȡtab_2�����Ʒ�嵥����Ʒ��table_tab_2
	public JTable getTable_tab_2() {
		return table_tab_2;
	}

	//��ȡtab�ұ���Ʒ�嵥����Ʒ��table_right_tab
	public JTable getTable_right_tab() {
		return table_right_tab;
	}
//	public Vector getData_right_tab() {
//		return data_right_tab;
//	}

	//tab_1��Ʒ�嵥��JTextField
	public JTextField getText_name_id() {
		return text_name_id;
	}


	//��ȡtab_1�����Ʒ�嵥����Ʒ��TabelModel
	public AllTableModel getTabelModel_table_tab_1() {
		return tabelModel_table_tab_1;
	}

	
	//��ȡtab�ұߵ���Ʒ�嵥����Ʒ���۱�TabelModel
	public AllTableModel getTabelModel_table_right() {
		return tabelModel_table_right;
	}
	//��ȡtab�ұ���Ʒ�嵥����Ʒ��data_right_tab
	public Vector getData_right_tab() {
		return data_right_tab;
	}

	
	//����tab�ұ���Ʒ�嵥����Ʒ��data_right_tab
	public void setData_right_tab(Vector data_right_tab) {
		this.data_right_tab = data_right_tab;
	}
//	//��ȡtab�ұ���Ʒ�嵥�Ŀͻ�����
//	public JLabel getCustomer_name() {
//		return customer_name;
//	}
//	
//	
	//��ȡtab�ұ���Ʒ�嵥�Ŀͻ����ƺ�����
	public int get_X() {
		return text_name_id.getLocationOnScreen().x;
	}
	//��ȡtab�ұ���Ʒ�嵥�Ŀͻ��������½�������
	public int get_Y() {
		return text_name_id.getLocationOnScreen().y + text_name_id.getSize().height;
	}
//	
//	
//	
//	//��ȡtab�ұ���Ʒ�嵥�Ŀͻ����Ƶ�JTextField
//	public JTextField getText_name() {
//		return text_name;
//	}
	//��ȡtab�ұ���Ʒ�嵥�ı����˵ı���
	public JTextField getBeizhu() {
		return beizhu;
	}
	
	
	
	//��ȡtab�ұ���Ʒ�嵥����Ʒ��change��ť
	public JButton getChange() {
		return change;
	}
	//��ȡtab�ұ���Ʒ�嵥����Ʒ��delete��ť
	public JButton getDelete() {
		return delete;
	}
	//��ȡtab�ұ���Ʒ�嵥����Ʒ��confirm��ť
	public JButton getConfirm() {
		return confirm;
	}
	//��ȡtab�ұ���Ʒ�嵥����Ʒ��cancel��ť
	public JButton getCancel() {
		return cancel;
	}

}
