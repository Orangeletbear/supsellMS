package com.cn.view.richangJFrame.Customer_Manage;


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
import javax.swing.table.DefaultTableModel;

import com.cn.control.richangframe.Customer_Manage.Action_Customer_Manage_Button_tab_2;
import com.cn.control.richangframe.Customer_Manage.JWindow_Customer_Action;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.xiaoshouJFrame.wanglaizhangwu.WangLaiZhangWuDialog;

public class Customer_Manage extends JDialog {
	
	
	
	private JTextField text_North;
	private JTextArea textArea_split_2;
	private JTable table_split_1;
	private JTable table_split_2;
	private JTable table_split_2_tab_2;
	private JLabel customer_name_N_Center;
	private JLabel name;
	private JLabel linkman_N_Center;
	private JLabel tel_num_N_Center;
	private JLabel addr_N_Center;
	private JLabel account_receivable;
	private JLabel fact_receivable;
	private JLabel bettween_num;
	private JLabel record_num_tab_1;
	private JLabel num_1_split_2;
	private JLabel num_2_split_2;
	private JLabel customer_name_id;
	//获取从表中得到的客户名称，联系人，联系电话，客户地址
	private JLabel [] label_box_1 = new JLabel[4];
	//获取从表中得到的应收金额，实收金额，相差金额
	private JLabel [] label_box_2 = new JLabel[4];
	//获取从表中得到的记录数，我方应付，我方实付，
	private JLabel [] label_box_3 = new JLabel[3];
	private JButton query_North;
	private JButton customer_manage_North;
	private JButton costomer_debt_North;
	private JButton save;
	private JButton exit_North;
	private JButton add;
	private JButton change;
	private JButton delete;
	private JPanel North;
	private JPanel Center;
	private JPanel N_Center;
	private JPanel Box_1_N_Center;
	private JPanel box_2_N_Center;
	private JPanel split_1_tab_1;
	private JPanel N_split_1_tab_1;
	private JPanel split_2_tab_1;
	private JPanel N_split_2_tab_1;
	private JPanel split_1_tab_2;
	private JPanel S_split_1;
	private JPanel C_split_1;
	private JPanel split_2_tab_2;
	private JPanel S_split_2;
	private JPanel C_split_2;
	private JPanel C_C_split_2;
	private JSplitPane tab_1_C_Center;
	private JSplitPane tab_2_C_Center;
	private JTabbedPane C_Center;
	private Vector data;//tabel_split_1
	private JButton chakanzhuangwu;
	private AllTableModel tabelModel_split_1;
	private AllTableModel tabelModel_split_2;
	private Vector data_1;//tabel_split_2
	private AllTableModel tabelModel_split_2_tab_2;
	private Vector data_2;//split_2_tab_2
	public Customer_Manage(JFrame frame,String title,boolean b) {
		super(frame,title, b);
		init();
		this.setSize(794, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void init() {
		addPanel();
		addPanel_1();
	}
		private void addPanel() {
			getContentPane().setLayout(new BorderLayout(0, 0));
			North = new JPanel();//最上面那个panel
			getContentPane().add(North, BorderLayout.NORTH);
			North.setLayout(new BoxLayout(North, BoxLayout.X_AXIS));
			
			North.add(Box.createHorizontalStrut(80));
			
			customer_name_id = new JLabel("输入客户名称或编号：");
			North.add(customer_name_id);
			
			//添加文本监听器
			text_North = new JTextField(20);
			text_North.getDocument().addDocumentListener(new JWindow_Customer_Action(Customer_Manage.this));
			North.add(text_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			query_North = new JButton("查询");//查询按钮
			query_North.addActionListener(new JWindow_Customer_Action(Customer_Manage.this));
			North.add(query_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			customer_manage_North = new JButton("客户管理");//供货商管理按钮
			customer_manage_North.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CustomerSet(Customer_Manage.this,"客户信息");
				}
			});
			North.add(customer_manage_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			costomer_debt_North = new JButton("客户账务");//供货商账务按钮
			costomer_debt_North.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new WangLaiZhangWuDialog(Customer_Manage.this,"往来账务(客户)",true);
				}
			});
			North.add(costomer_debt_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			exit_North = new JButton("退出");
			exit_North.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			North.add(exit_North);
			
			North.add(Box.createHorizontalStrut(40));
		}
		private void addPanel_1() {
			Center = new JPanel();
			getContentPane().add(Center, BorderLayout.CENTER);
			Center.setLayout(new BorderLayout(0, 0));
			addPanel_2();
			addtabbedPane();
		}
			private void addPanel_2() {
			N_Center = new JPanel();//label栏的panel
			N_Center.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "员工信息", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			addPanel_3();
			addPanel_4();
			Center.add(N_Center, BorderLayout.NORTH);
			N_Center.setLayout(new BoxLayout(N_Center, BoxLayout.Y_AXIS));
		
		}
				private void addPanel_3() {
			Box_1_N_Center = new JPanel();
			FlowLayout fl_Box_1_N_Center = (FlowLayout) Box_1_N_Center.getLayout();
			fl_Box_1_N_Center.setAlignment(FlowLayout.LEFT);
			Box_1_N_Center.setBorder(null);
			N_Center.add(Box_1_N_Center);	
			
			
			//label内容客户一栏
			Box_1_N_Center.add(Box.createHorizontalStrut(62));
			customer_name_N_Center = new JLabel("客户名称：");
			Box_1_N_Center.add(customer_name_N_Center);
			label_box_1[0] = new JLabel("               ");
			Box_1_N_Center.add(label_box_1[0]);
			
			linkman_N_Center = new JLabel("联 系 人：");
			Box_1_N_Center.add(linkman_N_Center);
			label_box_1[1] = new JLabel("            ");
			Box_1_N_Center.add(label_box_1[1]);
			
			tel_num_N_Center = new JLabel("联系电话：");
			Box_1_N_Center.add(tel_num_N_Center);
			label_box_1[2] = new JLabel("             ");
			Box_1_N_Center.add(label_box_1[2]);
			
			addr_N_Center = new JLabel("客户地址：");
			Box_1_N_Center.add(addr_N_Center);
			label_box_1[3] = new JLabel("                 ");
			Box_1_N_Center.add(label_box_1[3]);
		}
				private void addPanel_4() {
					box_2_N_Center = new JPanel();
					FlowLayout fl_box_2_N_Center = (FlowLayout) box_2_N_Center.getLayout();
					fl_box_2_N_Center.setAlignment(FlowLayout.LEFT);
					N_Center.add(box_2_N_Center);
					
					//label内容应收金额一栏
					Component horizontalStrut_1 = Box.createHorizontalStrut(62);
					box_2_N_Center.add(horizontalStrut_1);
					
					account_receivable = new JLabel("应收金额：");
					box_2_N_Center.add(account_receivable);
					label_box_2[0] = new JLabel("               ");
					box_2_N_Center.add(label_box_2[0]);
					
					fact_receivable = new JLabel("实收金额：");
					box_2_N_Center.add(fact_receivable);
					label_box_2[1] = new JLabel("            ");
					box_2_N_Center.add(label_box_2[1]);
					
					bettween_num = new JLabel("相差金额：");
					box_2_N_Center.add(bettween_num);
					label_box_2[2] = new JLabel("             ");
					box_2_N_Center.add(label_box_2[2]);
					
					//查看账务情况
					chakanzhuangwu = new JButton("查看账务情况");
					chakanzhuangwu.setForeground(Color.BLUE);
					chakanzhuangwu.setVisible(false);
					chakanzhuangwu.addMouseListener(new MouseAdapter(){
						public void mousePressed(MouseEvent e) {
//							int i = JOptionPane.showConfirmDialog(Supplier_Manage.this, 
//									"没有符合条件的记录，查询条件为：采购日期：2009-10-01" +
//									"至2009-10-23，业务员名称：所有业务员", 
//									"系统提示",
//									 JOptionPane.YES_OPTION,
//									 JOptionPane.WARNING_MESSAGE, 
//									new ImageIcon("res\\AcionIcon\\wenhao.jpg")
//			                        );
							new WangLaiZhangWuDialog(Customer_Manage.this,"往来账务(供应商)",true);
						}
					});
					box_2_N_Center.add(chakanzhuangwu);
					
				}

			private void addtabbedPane() {
				C_Center = new JTabbedPane(JTabbedPane.TOP);//南端的JTabbedPane
				Center.add(C_Center, BorderLayout.CENTER);
				addsplitPane();
				addsplitPane_1();
			}
				private void addsplitPane() {
					tab_1_C_Center = new JSplitPane();
					tab_1_C_Center.setEnabled(false);
					tab_1_C_Center.setDividerSize(0);
					tab_1_C_Center.setResizeWeight(0.3);
					C_Center.addTab("客户销售情况", null, tab_1_C_Center, null);
					addPanel_5();
					addPanel_6();
					
				}
					private void addPanel_5() {
						split_1_tab_1 = new JPanel();
						split_1_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "销售/退货/付款记录", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1_C_Center.setLeftComponent(split_1_tab_1);
						split_1_tab_1.setLayout(new BorderLayout(0, 0));
						addTable();
						addPanel_7();
						
					}
						private void addTable() {
							/**
							 * 第一个tab的左边表（销售/退货/付款记录）
							 * 如果在表中双击某行，则将再详细内容表中显示商品的详细信息
							 */
							tabelModel_split_1 = new AllTableModel(data,
									AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_1));
							
							table_split_1 = new JTable(tabelModel_split_1);
							table_split_1.setAutoCreateRowSorter(true);
							JScrollPane C_split_1_tab_1 = new JScrollPane(table_split_1);
							split_1_tab_1.add(C_split_1_tab_1, BorderLayout.CENTER);
						}
						private void addPanel_7() {
					N_split_1_tab_1 = new JPanel();
					FlowLayout fl_N_split_1_tab_1 = (FlowLayout) N_split_1_tab_1.getLayout();
					fl_N_split_1_tab_1.setAlignment(FlowLayout.LEADING);
					split_1_tab_1.add(N_split_1_tab_1, BorderLayout.SOUTH);
					
					
					record_num_tab_1 = new JLabel("记录数：");
					N_split_1_tab_1.add(record_num_tab_1);
					label_box_3[0] = new JLabel("0         ");
					N_split_1_tab_1.add(label_box_3[0]);
					
					label_box_3[1] = new JLabel("0.0      ");
					label_box_3[1].setForeground(Color.RED);
					N_split_1_tab_1.add(label_box_3[1]);
					
					label_box_3[2] = new JLabel("0.0                       ");
					label_box_3[2].setForeground(Color.RED);
					N_split_1_tab_1.add(label_box_3[2]);
				}
					private void addPanel_6() {
						split_2_tab_1 = new JPanel();
						split_2_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "详细内容", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1_C_Center.setRightComponent(split_2_tab_1);
						split_2_tab_1.setLayout(new BorderLayout(0, 0));
						addTable_1();
						addPanel_8();
						
					}
						private void addTable_1() {
							/**
							 * 第一个tab_1的右边表table_split_2（详细信息）
							 */
							tabelModel_split_2 = new AllTableModel(data_1, 
									AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_2));
							table_split_2 = new JTable(tabelModel_split_2);
							
							table_split_2.setAutoCreateRowSorter(true);
							JScrollPane C_split_2_tab_1 = new JScrollPane(table_split_2);
							split_2_tab_1.add(C_split_2_tab_1, BorderLayout.CENTER);
						}

						private void addPanel_8() {
							N_split_2_tab_1 = new JPanel();
							FlowLayout fl_N_split_2_tab_1 = (FlowLayout) N_split_2_tab_1.getLayout();
							fl_N_split_2_tab_1.setAlignment(FlowLayout.RIGHT);
							split_2_tab_1.add(N_split_2_tab_1, BorderLayout.SOUTH);
							
							
							num_1_split_2 = new JLabel("         0.0");
							num_1_split_2.setForeground(Color.RED);
							N_split_2_tab_1.add(num_1_split_2);
							
							num_2_split_2 = new JLabel("         0.0");
							num_2_split_2.setForeground(Color.RED);
							N_split_2_tab_1.add(num_2_split_2);
						}
				private void addsplitPane_1() {
					tab_2_C_Center = new JSplitPane();
					tab_2_C_Center.setEnabled(false);
					tab_2_C_Center.setDividerSize(0);
					tab_2_C_Center.setResizeWeight(1);
					C_Center.addTab("备注/联系记录", null, tab_2_C_Center, null);
					addPanel_9();
					addPanel_12();
				}
					private void addPanel_9() {
						split_1_tab_2 = new JPanel();
						tab_2_C_Center.setLeftComponent(split_1_tab_2);
						split_1_tab_2.setLayout(new BorderLayout(0, 0));
						addPanel_10();
						addPanel_11();
					}	
						private void addPanel_10() {
						S_split_1 = new JPanel();
						split_1_tab_2.add(S_split_1, BorderLayout.SOUTH);
						
						save = new JButton("保存");
						save.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_1.add(save);
					}
						private void addPanel_11() {
							C_split_1 = new JPanel();
							C_split_1.setBorder(new TitledBorder(null, "备注", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							split_1_tab_2.add(C_split_1, BorderLayout.CENTER);
							C_split_1.setLayout(new BorderLayout(0, 0));
							
							textArea_split_2 = new JTextArea();
							textArea_split_2.setLineWrap(true);
							C_split_1.add(textArea_split_2, BorderLayout.CENTER);
						}

					private void addPanel_12() {
						split_2_tab_2 = new JPanel();
						tab_2_C_Center.setRightComponent(split_2_tab_2);
						split_2_tab_2.setLayout(new BorderLayout(0, 0));
						
						addPanel_13();
						addPanel_14();
					}
						private void addPanel_13() {
						S_split_2 = new JPanel();
						split_2_tab_2.add(S_split_2, BorderLayout.SOUTH);
						
						add = new JButton("添加");
						add.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(add);
						
						change = new JButton("修改");
						change.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(change);
						
						delete = new JButton("删除");
						delete.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(delete);
					}
						private void addPanel_14() {
							C_split_2 = new JPanel();
							C_split_2.setBorder(new TitledBorder(null, "联系记录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							split_2_tab_2.add(C_split_2, BorderLayout.CENTER);
							C_split_2.setLayout(new BorderLayout(0, 0));
							
							addPanel_15();
						}
							private void addPanel_15() {
								C_C_split_2 = new JPanel();
								C_split_2.add(C_C_split_2);
								C_C_split_2.setLayout(new BorderLayout(0, 0));
								
								
								/**
								 * 第二个tab_2的右边表table_split_2（联系记录）
								 */
								tabelModel_split_2_tab_2 = new AllTableModel(data_2, 
										AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
								table_split_2_tab_2 = new JTable(tabelModel_split_2_tab_2);
								
//								table_split_2_tab_2 = new JTable();
//								table_split_2_tab_2.setModel(new DefaultTableModel(
//									new Object[][] {
//									},
//									new String[] {
//										"联系时间", "联系内容", "经办人"
//									}
//								));
								table_split_2_tab_2.setAutoCreateRowSorter(true);
								JScrollPane C_C_C_split_2 = new JScrollPane(table_split_2_tab_2);
								C_C_split_2.add(C_C_C_split_2, BorderLayout.CENTER);
							}
							
							

	//获取Customer_Manage（本窗口）”输入客户名称或编号“JLabel的横坐标
	public int get_X(){
		return customer_name_id.getLocationOnScreen().x;
	}
	//获取Customer_Manage（本窗口）”输入客户名称或编号“JLabel的左下角的纵坐标
	public int get_Y(){
		return customer_name_id.getLocationOnScreen().y + customer_name_id.getSize().height;
	}
	//获取Customer_Manage（本窗口）最北边的JTextField
	public JTextField getText_North() {
		return text_North;
	}
	//获取Customer_Manage（本窗口）此为第一排空JLable（客户名称）
	public JLabel[] getLabel_box_1() {
		return label_box_1;
	}
	//获取Customer_Manage（本窗口）此为第二排空JLable（应付金额）
	public JLabel[] getLabel_box_2() {
		return label_box_2;
	}
	//获取Customer_Manage（本窗口）此为左下方JLable（记录数）
	public JLabel[] getLabel_box_3() {
		return label_box_3;
	}

	//tab_2中textArea
	public JTextArea getTextArea() {
		return textArea_split_2;
	}
	//获取Customer_Manage（本窗口）tab_1查询账务按钮
	public JButton getChakanzhuangwu() {
		return chakanzhuangwu;
	}
	//获取右下一栏的JLabe所有数量
	public JLabel getNumber_split_2() {
		return num_1_split_2;
	}
	//获取右下一栏的JLabe所有金额
	public JLabel getMoney_split_2() {
		return num_2_split_2;
	}
	/**
	 * tab_2中四按钮
	 * @return
	 */
	public JButton getSave() {//保存按钮
		return save;
	}

	public JButton getAdd() {//添加按钮
		return add;
	}

	public JButton getChange() {//修改按钮
		return change;
	}

	public JButton getDelete() {//删除按钮
		return delete;
	}
	/**
	 * 获取Supplier_Manage（本窗口）第一个tab的左边表（销售/退货/付款记录）
	 * @return
	 */
	public JTable getTable_split_1() {
		return table_split_1;
	}
	//获取Customer_Manage（本窗口）第一个tab的左边表（销售/退货/付款记录）的tabelModel_split_1
	public AllTableModel getTabelModel_split_1() {
		return tabelModel_split_1;
	}
	//设置Customer_Manage（本窗口）第一个tab的左边表（销售/退货/付款记录）的data
	public void setData_split_1(Vector data) {
		this.data = data;
	}
	//获取Customer_Manage（本窗口）第一个tab的左边表（销售/退货/付款记录）的data
	public Vector getData_split_1() {
		return data;
	}
	/**
	 *获取Customer_Manage（本窗口） 第一个tab的右边表table_split_2（详细信息）
	 */
	public JTable getTable_split_2() {
		return table_split_2;
	}
	//获取Customer_Manage（本窗口）第一个tab的左边表（销售/退货/付款记录）的tabelModel_split_2
	public AllTableModel getTabelModel_split_2() {
		return tabelModel_split_2;
	}
	/**
	 *获取Customer_Manage（本窗口） 第二个tab_2的右边表table_split_2_tab_2（联系记录）
	 */
	public JTable getTable_split_2_tab_2() {
		return table_split_2_tab_2;
	}
	//获取Customer_Manage（本窗口）第二个tab_2的右边表（联系记录）的tabelModel_split_2_tab_2
	public AllTableModel getTabelModel_split_2_tab_2() {
		return tabelModel_split_2_tab_2;
	}
}
