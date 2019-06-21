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
	//��ȡ�ӱ��еõ��Ŀͻ����ƣ���ϵ�ˣ���ϵ�绰���ͻ���ַ
	private JLabel [] label_box_1 = new JLabel[4];
	//��ȡ�ӱ��еõ���Ӧ�ս�ʵ�ս������
	private JLabel [] label_box_2 = new JLabel[4];
	//��ȡ�ӱ��еõ��ļ�¼�����ҷ�Ӧ�����ҷ�ʵ����
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
			North = new JPanel();//�������Ǹ�panel
			getContentPane().add(North, BorderLayout.NORTH);
			North.setLayout(new BoxLayout(North, BoxLayout.X_AXIS));
			
			North.add(Box.createHorizontalStrut(80));
			
			customer_name_id = new JLabel("����ͻ����ƻ��ţ�");
			North.add(customer_name_id);
			
			//����ı�������
			text_North = new JTextField(20);
			text_North.getDocument().addDocumentListener(new JWindow_Customer_Action(Customer_Manage.this));
			North.add(text_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			query_North = new JButton("��ѯ");//��ѯ��ť
			query_North.addActionListener(new JWindow_Customer_Action(Customer_Manage.this));
			North.add(query_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			customer_manage_North = new JButton("�ͻ�����");//�����̹���ť
			customer_manage_North.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CustomerSet(Customer_Manage.this,"�ͻ���Ϣ");
				}
			});
			North.add(customer_manage_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			costomer_debt_North = new JButton("�ͻ�����");//����������ť
			costomer_debt_North.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new WangLaiZhangWuDialog(Customer_Manage.this,"��������(�ͻ�)",true);
				}
			});
			North.add(costomer_debt_North);
			
			North.add(Box.createHorizontalStrut(20));
			
			exit_North = new JButton("�˳�");
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
			N_Center = new JPanel();//label����panel
			N_Center.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ա����Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			
			
			//label���ݿͻ�һ��
			Box_1_N_Center.add(Box.createHorizontalStrut(62));
			customer_name_N_Center = new JLabel("�ͻ����ƣ�");
			Box_1_N_Center.add(customer_name_N_Center);
			label_box_1[0] = new JLabel("               ");
			Box_1_N_Center.add(label_box_1[0]);
			
			linkman_N_Center = new JLabel("�� ϵ �ˣ�");
			Box_1_N_Center.add(linkman_N_Center);
			label_box_1[1] = new JLabel("            ");
			Box_1_N_Center.add(label_box_1[1]);
			
			tel_num_N_Center = new JLabel("��ϵ�绰��");
			Box_1_N_Center.add(tel_num_N_Center);
			label_box_1[2] = new JLabel("             ");
			Box_1_N_Center.add(label_box_1[2]);
			
			addr_N_Center = new JLabel("�ͻ���ַ��");
			Box_1_N_Center.add(addr_N_Center);
			label_box_1[3] = new JLabel("                 ");
			Box_1_N_Center.add(label_box_1[3]);
		}
				private void addPanel_4() {
					box_2_N_Center = new JPanel();
					FlowLayout fl_box_2_N_Center = (FlowLayout) box_2_N_Center.getLayout();
					fl_box_2_N_Center.setAlignment(FlowLayout.LEFT);
					N_Center.add(box_2_N_Center);
					
					//label����Ӧ�ս��һ��
					Component horizontalStrut_1 = Box.createHorizontalStrut(62);
					box_2_N_Center.add(horizontalStrut_1);
					
					account_receivable = new JLabel("Ӧ�ս�");
					box_2_N_Center.add(account_receivable);
					label_box_2[0] = new JLabel("               ");
					box_2_N_Center.add(label_box_2[0]);
					
					fact_receivable = new JLabel("ʵ�ս�");
					box_2_N_Center.add(fact_receivable);
					label_box_2[1] = new JLabel("            ");
					box_2_N_Center.add(label_box_2[1]);
					
					bettween_num = new JLabel("����");
					box_2_N_Center.add(bettween_num);
					label_box_2[2] = new JLabel("             ");
					box_2_N_Center.add(label_box_2[2]);
					
					//�鿴�������
					chakanzhuangwu = new JButton("�鿴�������");
					chakanzhuangwu.setForeground(Color.BLUE);
					chakanzhuangwu.setVisible(false);
					chakanzhuangwu.addMouseListener(new MouseAdapter(){
						public void mousePressed(MouseEvent e) {
//							int i = JOptionPane.showConfirmDialog(Supplier_Manage.this, 
//									"û�з��������ļ�¼����ѯ����Ϊ���ɹ����ڣ�2009-10-01" +
//									"��2009-10-23��ҵ��Ա���ƣ�����ҵ��Ա", 
//									"ϵͳ��ʾ",
//									 JOptionPane.YES_OPTION,
//									 JOptionPane.WARNING_MESSAGE, 
//									new ImageIcon("res\\AcionIcon\\wenhao.jpg")
//			                        );
							new WangLaiZhangWuDialog(Customer_Manage.this,"��������(��Ӧ��)",true);
						}
					});
					box_2_N_Center.add(chakanzhuangwu);
					
				}

			private void addtabbedPane() {
				C_Center = new JTabbedPane(JTabbedPane.TOP);//�϶˵�JTabbedPane
				Center.add(C_Center, BorderLayout.CENTER);
				addsplitPane();
				addsplitPane_1();
			}
				private void addsplitPane() {
					tab_1_C_Center = new JSplitPane();
					tab_1_C_Center.setEnabled(false);
					tab_1_C_Center.setDividerSize(0);
					tab_1_C_Center.setResizeWeight(0.3);
					C_Center.addTab("�ͻ��������", null, tab_1_C_Center, null);
					addPanel_5();
					addPanel_6();
					
				}
					private void addPanel_5() {
						split_1_tab_1 = new JPanel();
						split_1_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "����/�˻�/�����¼", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1_C_Center.setLeftComponent(split_1_tab_1);
						split_1_tab_1.setLayout(new BorderLayout(0, 0));
						addTable();
						addPanel_7();
						
					}
						private void addTable() {
							/**
							 * ��һ��tab����߱�����/�˻�/�����¼��
							 * ����ڱ���˫��ĳ�У�������ϸ���ݱ�����ʾ��Ʒ����ϸ��Ϣ
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
					
					
					record_num_tab_1 = new JLabel("��¼����");
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
						split_2_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "��ϸ����", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1_C_Center.setRightComponent(split_2_tab_1);
						split_2_tab_1.setLayout(new BorderLayout(0, 0));
						addTable_1();
						addPanel_8();
						
					}
						private void addTable_1() {
							/**
							 * ��һ��tab_1���ұ߱�table_split_2����ϸ��Ϣ��
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
					C_Center.addTab("��ע/��ϵ��¼", null, tab_2_C_Center, null);
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
						
						save = new JButton("����");
						save.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_1.add(save);
					}
						private void addPanel_11() {
							C_split_1 = new JPanel();
							C_split_1.setBorder(new TitledBorder(null, "��ע", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
						
						add = new JButton("���");
						add.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(add);
						
						change = new JButton("�޸�");
						change.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(change);
						
						delete = new JButton("ɾ��");
						delete.addActionListener(new Action_Customer_Manage_Button_tab_2(Customer_Manage.this));
						S_split_2.add(delete);
					}
						private void addPanel_14() {
							C_split_2 = new JPanel();
							C_split_2.setBorder(new TitledBorder(null, "��ϵ��¼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							split_2_tab_2.add(C_split_2, BorderLayout.CENTER);
							C_split_2.setLayout(new BorderLayout(0, 0));
							
							addPanel_15();
						}
							private void addPanel_15() {
								C_C_split_2 = new JPanel();
								C_split_2.add(C_C_split_2);
								C_C_split_2.setLayout(new BorderLayout(0, 0));
								
								
								/**
								 * �ڶ���tab_2���ұ߱�table_split_2����ϵ��¼��
								 */
								tabelModel_split_2_tab_2 = new AllTableModel(data_2, 
										AllTableModel.getVectorFromObj(Customer_Manage_Model.table_split_3));
								table_split_2_tab_2 = new JTable(tabelModel_split_2_tab_2);
								
//								table_split_2_tab_2 = new JTable();
//								table_split_2_tab_2.setModel(new DefaultTableModel(
//									new Object[][] {
//									},
//									new String[] {
//										"��ϵʱ��", "��ϵ����", "������"
//									}
//								));
								table_split_2_tab_2.setAutoCreateRowSorter(true);
								JScrollPane C_C_C_split_2 = new JScrollPane(table_split_2_tab_2);
								C_C_split_2.add(C_C_C_split_2, BorderLayout.CENTER);
							}
							
							

	//��ȡCustomer_Manage�������ڣ�������ͻ����ƻ��š�JLabel�ĺ�����
	public int get_X(){
		return customer_name_id.getLocationOnScreen().x;
	}
	//��ȡCustomer_Manage�������ڣ�������ͻ����ƻ��š�JLabel�����½ǵ�������
	public int get_Y(){
		return customer_name_id.getLocationOnScreen().y + customer_name_id.getSize().height;
	}
	//��ȡCustomer_Manage�������ڣ���ߵ�JTextField
	public JTextField getText_North() {
		return text_North;
	}
	//��ȡCustomer_Manage�������ڣ���Ϊ��һ�ſ�JLable���ͻ����ƣ�
	public JLabel[] getLabel_box_1() {
		return label_box_1;
	}
	//��ȡCustomer_Manage�������ڣ���Ϊ�ڶ��ſ�JLable��Ӧ����
	public JLabel[] getLabel_box_2() {
		return label_box_2;
	}
	//��ȡCustomer_Manage�������ڣ���Ϊ���·�JLable����¼����
	public JLabel[] getLabel_box_3() {
		return label_box_3;
	}

	//tab_2��textArea
	public JTextArea getTextArea() {
		return textArea_split_2;
	}
	//��ȡCustomer_Manage�������ڣ�tab_1��ѯ����ť
	public JButton getChakanzhuangwu() {
		return chakanzhuangwu;
	}
	//��ȡ����һ����JLabe��������
	public JLabel getNumber_split_2() {
		return num_1_split_2;
	}
	//��ȡ����һ����JLabe���н��
	public JLabel getMoney_split_2() {
		return num_2_split_2;
	}
	/**
	 * tab_2���İ�ť
	 * @return
	 */
	public JButton getSave() {//���水ť
		return save;
	}

	public JButton getAdd() {//��Ӱ�ť
		return add;
	}

	public JButton getChange() {//�޸İ�ť
		return change;
	}

	public JButton getDelete() {//ɾ����ť
		return delete;
	}
	/**
	 * ��ȡSupplier_Manage�������ڣ���һ��tab����߱�����/�˻�/�����¼��
	 * @return
	 */
	public JTable getTable_split_1() {
		return table_split_1;
	}
	//��ȡCustomer_Manage�������ڣ���һ��tab����߱�����/�˻�/�����¼����tabelModel_split_1
	public AllTableModel getTabelModel_split_1() {
		return tabelModel_split_1;
	}
	//����Customer_Manage�������ڣ���һ��tab����߱�����/�˻�/�����¼����data
	public void setData_split_1(Vector data) {
		this.data = data;
	}
	//��ȡCustomer_Manage�������ڣ���һ��tab����߱�����/�˻�/�����¼����data
	public Vector getData_split_1() {
		return data;
	}
	/**
	 *��ȡCustomer_Manage�������ڣ� ��һ��tab���ұ߱�table_split_2����ϸ��Ϣ��
	 */
	public JTable getTable_split_2() {
		return table_split_2;
	}
	//��ȡCustomer_Manage�������ڣ���һ��tab����߱�����/�˻�/�����¼����tabelModel_split_2
	public AllTableModel getTabelModel_split_2() {
		return tabelModel_split_2;
	}
	/**
	 *��ȡCustomer_Manage�������ڣ� �ڶ���tab_2���ұ߱�table_split_2_tab_2����ϵ��¼��
	 */
	public JTable getTable_split_2_tab_2() {
		return table_split_2_tab_2;
	}
	//��ȡCustomer_Manage�������ڣ��ڶ���tab_2���ұ߱���ϵ��¼����tabelModel_split_2_tab_2
	public AllTableModel getTabelModel_split_2_tab_2() {
		return tabelModel_split_2_tab_2;
	}
}
