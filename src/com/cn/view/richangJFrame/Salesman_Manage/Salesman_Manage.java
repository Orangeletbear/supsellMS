package com.cn.view.richangJFrame.Salesman_Manage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.control.richangframe.Salesman_Manage.Action_Salesman_Manage_Button_tab_2;
import com.cn.control.richangframe.Salesman_Manage.JWindow_Salesman_Action;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;
import com.cn.view.systemJFrame.WorkSet;
import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;

public class Salesman_Manage extends JDialog {
	
	
	
	private JTextField select_name;
	private JTextArea textArea_split_2;
	private JTable table_split_1;//tab_1��߱�
	private JTable table_split_2;//tab_1�ұ߱�
	private JTable table_tab_2;//tab_2�ұ߱�
	private JLabel salesman_name_;
	private JLabel salesman_position;
	private JLabel Tel;
	private JLabel Add;
	private JLabel Buy_money;
	private JLabel Pay_Money;
	private JLabel Sell_Money;
	private JLabel record_num;
	private JLabel num_1_split_2;
	private JLabel num_2_split_2;
	private JLabel select_salesman_name;
	//��ȡ�ӱ��еõ���Ա��������Ա��ְ����ϵ�绰����ϵ��ַ
	private JLabel [] label_box_1 = new JLabel[4];
	//��ȡ�ӱ��еõ��Ĳɹ������ҷ��Ѹ������۽��ͻ��Ѹ�
	private JLabel [] label_box_2 = new JLabel[4];
	//��ȡ�ӱ��еõ��ļ�¼����Ӧ����ʵ����
	private JLabel [] label_box_3 = new JLabel[3];
	private JButton query;
	private JButton sales_manage;
	private JButton salesman_account;
	private JButton save;
	private JButton exit;
	private JButton add;
	private JButton change;
	private JButton delete;
	private JPanel Center;
	private JPanel N_Center;
	private JPanel box1_N_Center;
	private JPanel box2_N_Center;
	private JPanel left_tab_1;
	private JPanel S_left_tab_1;
	private JPanel right_tab_1;
	private JPanel S_right_tab_1;
	private JPanel left_tab_2;
	private JPanel S_left_tab_2;
	private JPanel C_left_tab_2;
	private JPanel right_tab_2;
	private JPanel S_right_tab_2;
	private JPanel C_right_tab_2;
	private JPanel C_C_right_tab_2;
	private JSplitPane tab_1;
	private JSplitPane tab_2;
	private JTabbedPane C_Center;
	private JPopupMenu popupMenu;
	private JMenuItem menuItem;
	private JSeparator separator;
	private JMenuItem menuItem_1;
	private AllTableModel tabelModel_split_1;
	private AllTableModel tabelModel_split_2;
	private Vector data_left;
	private Vector data_right_tab_1;
	private Vector data_tab_2;
	private AllTableModel tabelModel_tab_2;
	public Salesman_Manage(JFrame frame,String title,boolean b) {
		super(frame,title,b);
		init();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
			JPanel North = new JPanel();//�������Ǹ�panel
			getContentPane().add(North, BorderLayout.NORTH);
			North.setLayout(new BoxLayout(North, BoxLayout.X_AXIS));
			
			North.add(Box.createHorizontalStrut(80));
			
			select_salesman_name = new JLabel("����ҵ��Ա������");
			North.add(select_salesman_name);
			
			
			select_name = new JTextField(20);
			select_name.getDocument().addDocumentListener(new JWindow_Salesman_Action(Salesman_Manage.this));
			North.add(select_name);
			
			North.add(Box.createHorizontalStrut(20));
			
			query = new JButton("��ѯ");//��ѯ��ť
			query.addActionListener(new JWindow_Salesman_Action(Salesman_Manage.this));
			North.add(query);
			
			North.add(Box.createHorizontalStrut(20));
			
			sales_manage = new JButton("ҵ��Ա����");//�����̹���ť
			sales_manage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new WorkSet(Salesman_Manage.this,"Ա����Ϣ");
				}
			});
			North.add(sales_manage);
			
			North.add(Box.createHorizontalStrut(20));
			
			salesman_account = new JButton("ҵ��Ա����");//����������ť
			North.add(salesman_account);
			
			popupMenu = new JPopupMenu();
			
			
			menuItem = new JMenuItem("�ɹ�ҵ��");
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = JOptionPane.showConfirmDialog(Salesman_Manage.this, 
							"û�з��������ļ�¼����ѯ����Ϊ���ɹ����ڣ�2009-10-01" +
							"��2009-10-23��ҵ��Ա���ƣ�����ҵ��Ա", 
							"ϵͳ��ʾ",
							 JOptionPane.YES_OPTION,
							 JOptionPane.WARNING_MESSAGE, 
							new ImageIcon("res\\AcionIcon\\wenhao.jpg")
                            );
					if(i == JOptionPane.YES_OPTION){
						new CaiGouTongJiMainFrame(Salesman_Manage.this,"ҵ��Ա�ɹ�ͳ��",true);
					}
					
				}
			});
			popupMenu.add(menuItem);
			
			separator = new JSeparator();
			popupMenu.add(separator);
			
			menuItem_1 = new JMenuItem("����ҵ��");
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new YeWuYuanMainFrame(Salesman_Manage.this,"ҵ��Ա����ͳ��",true);
				}
			});
			menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0));
			popupMenu.add(menuItem_1);
			addPopup(salesman_account,popupMenu);
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
			box1_N_Center = new JPanel();
			FlowLayout fl_box1_N_Center = (FlowLayout) box1_N_Center.getLayout();
			fl_box1_N_Center.setAlignment(FlowLayout.LEFT);
			box1_N_Center.setBorder(null);
			N_Center.add(box1_N_Center);	
			
			//label����Ա������һ��
			box1_N_Center.add(Box.createHorizontalStrut(62));
			salesman_name_ = new JLabel("Ա�����ƣ�");
			box1_N_Center.add(salesman_name_);
			label_box_1[0] = new JLabel("               ");
			box1_N_Center.add(label_box_1[0]);
			
			salesman_position = new JLabel("Ա��ְ��");
			box1_N_Center.add(salesman_position);
			label_box_1[1] = new JLabel("            ");
			box1_N_Center.add(label_box_1[1]);
			
			Tel = new JLabel("��ϵ�绰��");
			box1_N_Center.add(Tel);
			label_box_1[2] = new JLabel("             ");
			box1_N_Center.add(label_box_1[2]);
			
			Add = new JLabel("��ϵ��ַ��");
			box1_N_Center.add(Add);
			label_box_1[3] = new JLabel("                 ");
			box1_N_Center.add(label_box_1[3]);
		}
				private void addPanel_4() {
					box2_N_Center = new JPanel();
					FlowLayout fl_box2_N_Center = (FlowLayout) box2_N_Center.getLayout();
					fl_box2_N_Center.setAlignment(FlowLayout.LEFT);
					N_Center.add(box2_N_Center);
					
					//label���ݲɹ����һ��
					Component horizontalStrut_1 = Box.createHorizontalStrut(62);
					box2_N_Center.add(horizontalStrut_1);
					Buy_money = new JLabel("�ɹ���");
					box2_N_Center.add(Buy_money);
					label_box_2[0] = new JLabel("               ");
					box2_N_Center.add(label_box_2[0]);
					
					Pay_Money = new JLabel("�ҷ��Ѹ���");
					box2_N_Center.add(Pay_Money);
					label_box_2[1] = new JLabel("            ");
					box2_N_Center.add(label_box_2[1]);
					
					Sell_Money = new JLabel("���۽�");
					box2_N_Center.add(Sell_Money);
					label_box_2[2] = new JLabel("             ");
					box2_N_Center.add(label_box_2[2]);
					label_box_2[3] = new JLabel("                 ");
					box2_N_Center.add(label_box_2[3]);
				}
			private void addtabbedPane() {
				C_Center = new JTabbedPane(JTabbedPane.TOP);//�϶˵�JTabbedPane
				Center.add(C_Center, BorderLayout.CENTER);
				addsplitPane();
				addsplitPane_1();
			}
				private void addsplitPane() {
					tab_1 = new JSplitPane();
					tab_1.setDividerSize(0);
					tab_1.setResizeWeight(0.4);
					C_Center.addTab("���ݼ�¼", null, tab_1, null);
					addPanel_5();
					addPanel_6();
					
				}
					private void addPanel_5() {
						left_tab_1 = new JPanel();
						left_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "�ɹ�/�������", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1.setLeftComponent(left_tab_1);
						left_tab_1.setLayout(new BorderLayout(0, 0));
						addTable();
						addPanel_7();
						
					}
						private void addTable() {
							/**
							 * ��һ��tab����߱��ɹ�/���������
							 * ����ڱ���˫��ĳ�У�������ϸ���ݱ�����ʾ��Ʒ����ϸ��Ϣ
							 */
							tabelModel_split_1 = new AllTableModel(data_left,
									AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_1));
							
							table_split_1 = new JTable(tabelModel_split_1);
							
							table_split_1.setAutoCreateRowSorter(true);
							JScrollPane C_left_tab_1 = new JScrollPane(table_split_1);
							left_tab_1.add(C_left_tab_1, BorderLayout.CENTER);
						}
						private void addPanel_7() {
					S_left_tab_1 = new JPanel();
					FlowLayout fl_S_left_tab_1 = (FlowLayout) S_left_tab_1.getLayout();
					fl_S_left_tab_1.setAlignment(FlowLayout.LEADING);
					left_tab_1.add(S_left_tab_1, BorderLayout.SOUTH);
					
					
					record_num = new JLabel("��¼����");
					S_left_tab_1.add(record_num);
					label_box_3[0] = new JLabel("0         ");
					S_left_tab_1.add(label_box_3[0]);
					
					label_box_3[1] = new JLabel("0.0      ");
					label_box_3[1].setForeground(Color.RED);
					S_left_tab_1.add(label_box_3[1]);
					
					label_box_3[2] = new JLabel("0.0                       ");
					label_box_3[2].setForeground(Color.RED);
					S_left_tab_1.add(label_box_3[2]);
				}
					private void addPanel_6() {
						right_tab_1 = new JPanel();
						right_tab_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "��ϸ����", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						tab_1.setRightComponent(right_tab_1);
						right_tab_1.setLayout(new BorderLayout(0, 0));
						addTable_1();
						addPanel_8();
						
					}
						private void addTable_1() {
							
							/**
							 * ��һ��tab_1���ұ߱�table_split_2����ϸ���ݣ�
							 */
							tabelModel_split_2 = new AllTableModel(data_right_tab_1, 
									AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_2));
							table_split_2 = new JTable(tabelModel_split_2);
//							table_right_tab_1 = new JTable();
//							table_right_tab_1.setEnabled(false);
//							table_right_tab_1.setModel(new DefaultTableModel(
//								new Object[][] {
//								},
//								new String[] {
//									"��Ʒ���", "��Ʒ����", "��λ", "����", "����", "�ܽ��"
//								}
//							));
							table_split_2.setAutoCreateRowSorter(true);
							JScrollPane C_right_tab_1 = new JScrollPane(table_split_2);
							right_tab_1.add(C_right_tab_1, BorderLayout.CENTER);
						}
						private void addPanel_8() {
							S_right_tab_1 = new JPanel();
							FlowLayout fl_S_right_tab_1 = (FlowLayout) S_right_tab_1.getLayout();
							fl_S_right_tab_1.setAlignment(FlowLayout.RIGHT);
							right_tab_1.add(S_right_tab_1, BorderLayout.SOUTH);
							
							
							num_1_split_2 = new JLabel("         0.0");
							num_1_split_2.setForeground(Color.RED);
							S_right_tab_1.add(num_1_split_2);
							
							num_2_split_2 = new JLabel("         0.0");
							num_2_split_2.setForeground(Color.RED);
							S_right_tab_1.add(num_2_split_2);
						}
				private void addsplitPane_1() {
					tab_2 = new JSplitPane();
					tab_2.setDividerSize(0);
					tab_2.setResizeWeight(1);
					C_Center.addTab("��ע/��־", null, tab_2, null);
					addPanel_9();
					addPanel_12();
				}
					private void addPanel_9() {
						left_tab_2 = new JPanel();
						tab_2.setLeftComponent(left_tab_2);
						left_tab_2.setLayout(new BorderLayout(0, 0));
						addPanel_10();
						addPanel_11();
					}	
						private void addPanel_10() {
						S_left_tab_2 = new JPanel();
						left_tab_2.add(S_left_tab_2, BorderLayout.SOUTH);
						
						save = new JButton("����");
						save.addActionListener(new Action_Salesman_Manage_Button_tab_2(Salesman_Manage.this));
						S_left_tab_2.add(save);
					}
						private void addPanel_11() {
							C_left_tab_2 = new JPanel();
							C_left_tab_2.setBorder(new TitledBorder(null, "��ע", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							left_tab_2.add(C_left_tab_2, BorderLayout.CENTER);
							C_left_tab_2.setLayout(new BorderLayout(0, 0));
							
							textArea_split_2 = new JTextArea();
							textArea_split_2.setLineWrap(true);
							C_left_tab_2.add(textArea_split_2, BorderLayout.CENTER);
						}
					private void addPanel_12() {
						right_tab_2 = new JPanel();
						tab_2.setRightComponent(right_tab_2);
						right_tab_2.setLayout(new BorderLayout(0, 0));
						
						addPanel_13();
						addPanel_14();
					}
						private void addPanel_13() {
						S_right_tab_2 = new JPanel();
						right_tab_2.add(S_right_tab_2, BorderLayout.SOUTH);
						
						add = new JButton("���");
						add.addActionListener(new Action_Salesman_Manage_Button_tab_2(Salesman_Manage.this));
						S_right_tab_2.add(add);
						
						change = new JButton("�޸�");
						change.addActionListener(new Action_Salesman_Manage_Button_tab_2(Salesman_Manage.this));
						S_right_tab_2.add(change);
						
						delete = new JButton("ɾ��");
						delete.addActionListener(new Action_Salesman_Manage_Button_tab_2(Salesman_Manage.this));
						S_right_tab_2.add(delete);
					}
						private void addPanel_14() {
							C_right_tab_2 = new JPanel();
							C_right_tab_2.setBorder(new TitledBorder(null, "��ϵ��¼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							right_tab_2.add(C_right_tab_2, BorderLayout.CENTER);
							C_right_tab_2.setLayout(new BorderLayout(0, 0));
							
							addPanel_15();
						}
							private void addPanel_15() {
								C_C_right_tab_2 = new JPanel();
								C_right_tab_2.add(C_C_right_tab_2);
								C_C_right_tab_2.setLayout(new BorderLayout(0, 0));
								
								
								
								
								/**
								 * �ڶ���tab_2���ұ߱�table_split_2����־��
								 */
								tabelModel_tab_2 = new AllTableModel(data_tab_2, 
										AllTableModel.getVectorFromObj(Salesman_Manage_Model.table_split_3));
								table_tab_2 = new JTable(tabelModel_tab_2);
//								table_tab_2 = new JTable();
//								table_tab_2.setEnabled(false);
//								table_tab_2.setModel(new DefaultTableModel(
//									new Object[][] {
//									},
//									new String[] {
//										"����", "����"
//									}
//								));
								table_tab_2.setAutoCreateRowSorter(true);
								JScrollPane js_tab_2 = new JScrollPane(table_tab_2);
								C_C_right_tab_2.add(js_tab_2, BorderLayout.CENTER);
							}
							
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	//��ȡSalesman_Manage�������ڣ�������ҵ��Ա������JLabel�ĺ�����
	public int get_X(){
		return select_salesman_name.getLocationOnScreen().x;
	}
	//��ȡSalesman_Manage�������ڣ�������ҵ��Ա������JLabel�����½ǵ�������
	public int get_Y(){
		return select_salesman_name.getLocationOnScreen().y + select_salesman_name.getSize().height;
	}
	//��ȡSalesman_Manage�������ڣ���ߵ�JTextField
	public JTextField getSelect_name() {
		return select_name;
	}
	//��ȡSalesman_Manage�������ڣ���Ϊ��һ�ſ�JLable��Ա��������
	public JLabel[] getLabel_box_1() {
		return label_box_1;
	}
	//��ȡSalesman_Manage�������ڣ���Ϊ�ڶ��ſ�JLable���ɹ���
	public JLabel[] getLabel_box_2() {
		return label_box_2;
	}
	//��ȡSalesman_Manage�������ڣ���Ϊ���·�JLable����¼����
	public JLabel[] getLabel_box_3() {
		return label_box_3;
	}
	
	//��ȡ����һ����JLabe��������
	public JLabel getNumber_split_2() {
		return num_1_split_2;
	}
	//��ȡ����һ����JLabe���н��
	public JLabel getMoney_split_2() {
		return num_2_split_2;
	}
	
	
	//��ȡtab_1��߱�
	public JTable getTable_split_1() {
		return table_split_1;
	}
	//��ȡtab_1�ұ�TableModel
	public JTable getTable_split_2() {
		return table_split_2;
	}
	//��ȡtab_2�ұ߱�
	public JTable getTable_tab_2() {
		return table_tab_2;
	}
	//��ȡtab_1���TableModel
	public AllTableModel getTabelModel_split_1() {
		return tabelModel_split_1;
	}
	//��ȡtab_1�ұ߱�
	public AllTableModel getTabelModel_split_2() {
		return tabelModel_split_2;
	}
	//��ȡtab_2�ұ�TableModel
	public AllTableModel getTabelModel_tab_2() {
		return tabelModel_tab_2;
	}
	//��ȡtab_1��߱�DATA
	public Vector getData_left() {
		return data_left;
	}
	
	//����tab_1��߱�DATA
	public void setData_left(Vector data_left) {
		this.data_left = data_left;
	}
	
	//��ȡtab_1�ұ߱�DATA
	public Vector getData_right_tab_1() {
		return data_right_tab_1;
	}
	//��ȡtab_2�ұ߱�DATA
	public Vector getData_tab_2() {
		return data_tab_2;
	}
	
	
	//tab_2��textArea
	public JTextArea getTextArea() {
		return textArea_split_2;
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
}
