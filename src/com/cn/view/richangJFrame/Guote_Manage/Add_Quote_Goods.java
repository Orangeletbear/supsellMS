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
	private Vector data_left_tab_1;//tab_1左边商品清单的商品表data_left_tab_1
	private Vector data_right_tab;//tab右边商品清单的商品表data_right_tab

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
		split_2.setBorder(new TitledBorder(null, "所选商品", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(split_2);
		split_2.setLayout(new BorderLayout());
		{
			N_split_2 = new JPanel();
			split_2.add(N_split_2, BorderLayout.NORTH);
			N_split_2.setLayout(new GridLayout(1, 0, 0, 0));
			{
			
				{
						//JComboBox 选项来自数据库中员工表
						jbr = JDBC_Connect_Record.get_jbr();
						comboxMoel = new DefaultComboBoxModel(jbr);
					
				}
				{
					grid_3_N_split_2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) grid_3_N_split_2.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					N_split_2.add(grid_3_N_split_2);
					{
						label_beizhu = new JLabel("备    注：");
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
					//改变表格
					change = new JButton("修改");
					change.addActionListener(new Action_Select_change_del(Add_Quote_Goods.this));
					S_split_2.add(change);
					delete = new JButton("删除");
					delete.addActionListener(new Action_Select_change_del(Add_Quote_Goods.this));
					S_split_2.add(delete);
					//是否确认添加该数据
					confirm = new JButton("确定");
					confirm.addActionListener(new Action_Add_Guote_Commit(Add_Quote_Goods.this));
					S_split_2.add(confirm);
					cancel = new JButton("取消");
					cancel.addActionListener(new Action_Add_Guote_Commit(Add_Quote_Goods.this));
					S_split_2.add(cancel);
				
					split_2.add(S_split_2, BorderLayout.SOUTH);
			}
		}
	}

	private void addpanel_1() {
		split_1 = new JPanel();
		split_1.setBorder(new TitledBorder(null, "查询商品列表", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(split_1);
		split_1.setLayout(new BorderLayout(0, 0));
		{
			N_split_1 = new JPanel();
			split_1.add(N_split_1, BorderLayout.NORTH);
			N_split_1.setLayout(new GridLayout(2, 0, 0, 0));
			{
				notice = new JLabel("  请输入商品编号或名称查询商品，查询到商品后添加到右边所选商品");
				N_split_1.add(notice);
			}
			{
				grid2_N_split_1 = new JPanel();
				FlowLayout fl_grid2_N_split_1 = (FlowLayout) grid2_N_split_1.getLayout();
				fl_grid2_N_split_1.setAlignment(FlowLayout.LEFT);
				N_split_1.add(grid2_N_split_1);
				{
					goods_name_id = new JLabel("输入商品编号或名称查询商品：");
					grid2_N_split_1.add(goods_name_id);
				}
				{	
					//tab_1中的JTextField
					text_name_id = new JTextField(30);
					text_name_id.getDocument().addDocumentListener(new Action_sp_tab_1(Add_Quote_Goods.this));
					grid2_N_split_1.add(text_name_id);
					text_name_id.setColumns(10);
				}
				{	
					//tab_1中的加入所选商品
					add_selected_goods = new JButton("加入所选商品");
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
				C_split_1.addTab("商品清单", null, tab_1, null);
				{	
					
					
					//table_left_tab_1
					data_left_tab_1 = JDBC_Guote_Manage.get_sp_select("");
					tabelModel_table_tab_1 = new AllTableModel(data_left_tab_1,
							AllTableModel.getVectorFromObj(Guote_Manage_Model.left_table_tab_1));
					table_tab_1 = new JTable(tabelModel_table_tab_1);
					
					//Add_Quote_Goods_self左边tab_1中的table_tab_1加入鼠标监听器
					table_tab_1.addMouseListener(
							new Action_Select_sp(Add_Quote_Goods.this));
					tab_1.setViewportView(table_tab_1);
				}
			}
			{
				tab_2 = new JSplitPane();
				tab_2.setDividerSize(0);
				tab_2.setResizeWeight(0.3);
				C_split_1.addTab("商品列表", null, tab_2, null);
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
//								"商品编号", "商品名称", "预设进价", "预设售价"
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

	//加入所选商品的按钮
	public JButton getAdd_selected_goods() {
		return add_selected_goods;
	}

	public AllTableModel getTabelModel_table_tab_2() {
		return tabelModel_table_tab_2;
	}

	public JTree getTree_tab_1() {
		return tree_tab_1;
	}

	//获取父窗口Quote_Manage对象
	public Quote_Manage getDialog() {
		return dialog;
	}


	//获取tab_1左边商品清单的商品表table_tab_1
	public JTable getTable_tab_1() {
		return table_tab_1;
	}
	//获取tab_1左边商品清单的商品表data_left_tab_1
	public Vector getData_left_tab_1() {
		return data_left_tab_1;
	}

	//获取tab_2左边商品清单的商品表table_tab_2
	public JTable getTable_tab_2() {
		return table_tab_2;
	}

	//获取tab右边商品清单的商品表table_right_tab
	public JTable getTable_right_tab() {
		return table_right_tab;
	}
//	public Vector getData_right_tab() {
//		return data_right_tab;
//	}

	//tab_1商品清单的JTextField
	public JTextField getText_name_id() {
		return text_name_id;
	}


	//获取tab_1左边商品清单的商品表TabelModel
	public AllTableModel getTabelModel_table_tab_1() {
		return tabelModel_table_tab_1;
	}

	
	//获取tab右边的商品清单的商品报价表TabelModel
	public AllTableModel getTabelModel_table_right() {
		return tabelModel_table_right;
	}
	//获取tab右边商品清单的商品表data_right_tab
	public Vector getData_right_tab() {
		return data_right_tab;
	}

	
	//设置tab右边商品清单的商品表data_right_tab
	public void setData_right_tab(Vector data_right_tab) {
		this.data_right_tab = data_right_tab;
	}
//	//获取tab右边商品清单的客户名称
//	public JLabel getCustomer_name() {
//		return customer_name;
//	}
//	
//	
	//获取tab右边商品清单的客户名称横坐标
	public int get_X() {
		return text_name_id.getLocationOnScreen().x;
	}
	//获取tab右边商品清单的客户名称左下角纵坐标
	public int get_Y() {
		return text_name_id.getLocationOnScreen().y + text_name_id.getSize().height;
	}
//	
//	
//	
//	//获取tab右边商品清单的客户名称的JTextField
//	public JTextField getText_name() {
//		return text_name;
//	}
	//获取tab右边商品清单的报价人的报价
	public JTextField getBeizhu() {
		return beizhu;
	}
	
	
	
	//获取tab右边商品清单的商品表change按钮
	public JButton getChange() {
		return change;
	}
	//获取tab右边商品清单的商品表delete按钮
	public JButton getDelete() {
		return delete;
	}
	//获取tab右边商品清单的商品表confirm按钮
	public JButton getConfirm() {
		return confirm;
	}
	//获取tab右边商品清单的商品表cancel按钮
	public JButton getCancel() {
		return cancel;
	}

}
