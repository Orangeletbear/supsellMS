package com.cn.view.kuchunJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;


import com.cn.control.kuchunframe.kucunchaxun.ChaXunFirstBtnAction;
import com.cn.control.kuchunframe.kucunchaxun.CunChunPublicFindData;
import com.cn.control.kuchunframe.kucunchaxun.SPBianDongBtnAction;
import com.cn.control.kuchunframe.kucunchaxun.SanPinXinDocumentAction;
import com.cn.control.kuchunframe.kucunchaxun.TableMouseAction;
import com.cn.control.kuchunframe.kucunchaxun.TreeMouseAction;
import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.model.kuchun.MyTableCellRender;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.util.InitTreePane;
import com.cn.util.JDatePicker;
import com.cn.util.PrintTableData;
import com.cn.util.SwingCommonPrinitTools;
import com.cn.view.kuchunJFrame.kuchunchaxun.AdvanceFind;
import com.cn.view.kuchunJFrame.kuchunchaxun.ChaKanMingXiDialog;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.huiyuanguanli.AddHuiYuan;
import com.cn.view.tongjiJFrame.Dialog.JinHuoDialog;
import com.cn.view.tongjiJFrame.Dialog.TuiHuoDialog;
/**
 * ��ǰ����ѯ�Ի���
 * @author finey
 *
 */
public class KuCunChaXunFrame extends JDialog {
	
	//��һ��ѡ��еĵ�һ����
	private AllTableModel tableModel;
	private JTable hysxtable1;
	//�ڶ���ѡ��еĵ�һ����
	private AllTableModel tableMode2;
	private JTable hysxtable2;
	//������ѡ��еĵ�һ����
	private AllTableModel tableMode3 ;
	private JTable hysxtable3;
	// ѡ��ֿ��BOX
	private JComboBox chankuBox;
	//�ĸ�����
	private JDatePicker datePickerTo1;
	private JDatePicker datePickerTo2;
	
	//����������Ʒ�����
	private JComboBox splbB ;
	//��Ʒ����
	private JTextField spmcfield12 ;
	//���ƻ���
	private JTextField mchbhfield21 ;
	//���
	private JTextField lbfield31 ;
	//��Ż�����
	private JTextField spbhmcfield32 ;
	//��ѡ�����Ƿ����Ϊ0����Ʒ
	private JCheckBox isgetO;
	//��Ʒ�������ṹ
	private JTree tree;
	
	
	public AllTableModel getTableModel() {
		return tableModel;
	}

	public JTable getHysxtable1() {
		return hysxtable1;
	}

	public AllTableModel getTableMode2() {
		return tableMode2;
	}

	public JTable getHysxtable2() {
		return hysxtable2;
	}

	public AllTableModel getTableMode3() {
		return tableMode3;
	}

	public JTable getHysxtable3() {
		return hysxtable3;
	}

	public JComboBox getChankuBox() {
		return chankuBox;
	}

	public JDatePicker getDatePickerTo1() {
		return datePickerTo1;
	}

	public JDatePicker getDatePickerTo2() {
		return datePickerTo2;
	}

	public JComboBox getSplb() {
		return splbB;
	}

	public JTextField getSpmcfield12() {
		return spmcfield12;
	}

	public JTextField getMchbhfield21() {
		return mchbhfield21;
	}

	public JTextField getLbfield31() {
		return lbfield31;
	}

	public JTextField getSpbhmcfield32() {
		return spbhmcfield32;
	}

	public JCheckBox getIsgetO() {
		return isgetO;
	}

	public JTree getTree() {
		return tree;
	}

	public KuCunChaXunFrame(JFrame frame,String name){
		
		super(frame,name,true);
		init();
		//�������ݵĳ�ʼ��
		CunChunPublicFindData.setSPDataFromDatabase(this,"�������","");
		this.setVisible(true);
		
	}
	
	private void init(){
		this.setSize(new Dimension(900,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		//this.pack();
		this.setResizable(false);

	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		//����ѡ�
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		
		tabblePane.add("���䶯���",pane1);
		tabblePane.add("��Ʒ�䶯���",pane2);
		tabblePane.add("��Ʒ��Ϣ��ѯ",pane3);
		
		mainPane.add(tabblePane);
		return mainPane;
	}
	/*
	 * ��һ��ѡ�
	 */
	private JPanel createPane1(){
        
		
        JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//�������ļ���
		pane.add(initTool(),BorderLayout.NORTH);
	
		//������
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		JLabel lab = new JLabel("�ֿ� : ");
		chankuBox = new JComboBox(JDBCCuCunFind.getCanKuData());
		chankuBox.addItem("���вֿ�");
		chankuBox.setSelectedIndex(chankuBox.getItemCount()-1);
		JLabel lab1 = new JLabel("��Ʒ��� : ");
		splbB = new JComboBox(JDBCCuCunFind.getSpLbData());
		splbB.addItem("�������");
		splbB.setSelectedIndex(splbB.getItemCount()-1);
		JLabel lab2 = new JLabel("��Ʒ��Ż�����: ");
		spmcfield12 = new JTextField(14);
		
		JButton findbtn = new JButton("��    ѯ");
		isgetO = new JCheckBox("������ʾ���Ϊ�����Ʒ");
		findbtn.addActionListener(new ChaXunFirstBtnAction(this));
		
		northPane.add(lab);
		northPane.add(chankuBox);
		northPane.add(lab1);
		northPane.add(splbB);
		northPane.add(lab2);
		northPane.add(spmcfield12);
		northPane.add(findbtn);
		northPane.add(isgetO);
		
		
		downPane1.add(northPane,BorderLayout.NORTH);
		JPanel tablePane = new JPanel();
		
		tableModel = new AllTableModel(HYSZTableCulomns.data,
				KuCunKunCBDCulomns.KuCunColumnName1);
		//�½�һ�����
		hysxtable1 = new JTable(tableModel);
		hysxtable1.addMouseListener(new TableMouseAction(this,1));
		//���̶���С
		hysxtable1.setPreferredScrollableViewportSize(new Dimension(1200,400));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//���п�
		//hysxtable1.getColumnModel().getColumn(3).setPreferredWidth(150);
		//��һ��������
		tablePane.add(new JScrollPane(hysxtable1,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
				BorderLayout.CENTER);
		
		hysxtable1.setAutoCreateRowSorter(true);
		
		downPane1.add(new JScrollPane(tablePane));
		
		pane.add(downPane1);
		return pane;
	}
	/*
	 * ��һ�����Ĺ������Ľ���
	 */
	private JPanel initTool(){
		JPanel pane =new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//�߼���ѯ
		JButton gjcsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/advanceFind.jpg"));
		gjcsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new AdvanceFind(KuCunChaXunFrame.this,"�߼���ѯ");
			}
			
		});
		gjcsBtn.setMargin(new Insets(0,0,0,0));
		//ȫ��
		JButton qbBtn = new JButton(new ImageIcon(
				"res/AcionIcon/all.jpg"));
		qbBtn.setMargin(new Insets(0,0,0,0));
		qbBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				boolean isGetO = getIsgetO().isSelected();
				
				Vector data = DanQianKuCunJDBC.getSPBDQKData("���вֿ�","�������","",isGetO);
				//���ݼ����ģʽ��
				getTableModel().setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName1));
				
		        MyTableCellRender render = new MyTableCellRender();
				
				//����ÿ�е���Ⱦ��
			    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
			    	getHysxtable1().getColumnModel().getColumn(i).setCellRenderer(render);
			    }
			}
			
		});
		
		
		//�鿴��ϸ
		JButton ckmsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chakanmingxi.jpg"));
		ckmsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(KuCunChaXunFrame.this.getHysxtable1().getSelectedColumn()<0){
					JOptionPane.showMessageDialog(
							KuCunChaXunFrame.this, "��ѡ��һ����Ʒ����");
				}else{
					new ChaKanMingXiDialog(KuCunChaXunFrame.this,"�鿴��Ʒ��ϸ",1);
				}
				
			}
			
		});
		ckmsBtn.setMargin(new Insets(0,0,0,0));
		//��ӡ
		JButton printBtn = new JButton(new ImageIcon(
				"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		printBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(hysxtable1.getModel(),"ccc");
			}
			
		});
		
		
		//�����ο�
		JButton jhckBtn = new JButton(new ImageIcon(
				"res/AcionIcon/jinhuochangkao.jpg"));
		jhckBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new JinHuoDialog(KuCunChaXunFrame.this,"�����ο�",true);
			}
			
		});
		
		
		jhckBtn.setMargin(new Insets(0,0,0,0));
		//�˻��ο�
		JButton thckBtn = new JButton(new ImageIcon(
				"res/AcionIcon/tuihuochangkao.jpg"));
		thckBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TuiHuoDialog(KuCunChaXunFrame.this,"�˻��ο�",true);
			}
			
		});
		
		thckBtn.setMargin(new Insets(0,0,0,0));
		//�������
		JButton cfkbBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chaifenkuangbang.jpg"));
		cfkbBtn.setMargin(new Insets(0,0,0,0));
		cfkbBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ChaifenKunbang(KuCunChaXunFrame.this,"�۷�����",true);
			}
			
		});
		
		
		//�޸ľ���
		JButton xgjjBtn = new JButton(new ImageIcon(
				"res/AcionIcon/changeAva.jpg"));
		xgjjBtn.setMargin(new Insets(0,0,0,0));
		//����
		JButton exportBtn = new JButton(new ImageIcon(
				"res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", hysxtable1, 
						KuCunKunCBDCulomns.KuCunColumnName1);
			}
			
		});
		
		//�˳�
		JButton exitBtn = new JButton(new ImageIcon(
				"res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				KuCunChaXunFrame.this.dispose();
			}
			
		});
		
		pane.add(gjcsBtn);
		pane.add(qbBtn);
		pane.add(ckmsBtn);
		pane.add(jhckBtn);
		pane.add(thckBtn);
		pane.add(cfkbBtn);
		pane.add(printBtn);
		pane.add(xgjjBtn);
		pane.add(exportBtn);
		pane.add(exitBtn);
		
		
		return pane;
	}
	/*
	 * �ڶ���ѡ�
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//�������ļ���
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        
		//�鿴��ϸ
		JButton ckmsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chakanmingxi.jpg"));
		ckmsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(KuCunChaXunFrame.this.getHysxtable2().getSelectedColumn()<0){
					JOptionPane.showMessageDialog(
							KuCunChaXunFrame.this, "��ѡ��һ����Ʒ����");
				}else{
					new ChaKanMingXiDialog(KuCunChaXunFrame.this,"�鿴��Ʒ��ϸ",2);
				}
			}
			
		});
		ckmsBtn.setMargin(new Insets(0,0,0,0));
		//����
		JButton exportBtn = new JButton(new ImageIcon(
				"res/AcionIcon/export.jpg"));
		
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", hysxtable2, 
						KuCunKunCBDCulomns.KuCunColumnName2);
			}
			
		});
		
		exportBtn.setMargin(new Insets(0,0,0,0));
		//��ӡ
		JButton printBtn = new JButton(new ImageIcon(
				"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		printBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(hysxtable2.getModel(),"ccc");
			}
			
		});
		
		//�˳�
		JButton exitBtn = new JButton(new ImageIcon(
				"res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				KuCunChaXunFrame.this.dispose();
			}
			
		});
		northPane.add(ckmsBtn);
		northPane.add(exportBtn);
		northPane.add(printBtn);
		northPane.add(exitBtn);
		
		pane.add(northPane,BorderLayout.NORTH);
		
		
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane1 = new JPanel();
		northPane1.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		
		JLabel fromLab = new JLabel("ͳ��ʱ��:  ");
		//����ѡ��
		datePickerTo1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("��: ");
		datePickerTo2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("��Ʒ���ƻ��� : ");
		mchbhfield21 = new JTextField(14);
		JButton findbtn = new JButton("��    ѯ");
		
		findbtn.addActionListener(new SPBianDongBtnAction(this));
		
		northPane1.add(fromLab);
		northPane1.add(datePickerTo1);
		northPane1.add(toLab);
		northPane1.add(datePickerTo2);
		northPane1.add(allfindlab);
		northPane1.add(mchbhfield21);
		northPane1.add(findbtn);
		
		downPane1.add(northPane1,BorderLayout.NORTH);
		
		
		JPanel tablePane = new JPanel();
		
		tableMode2 = new AllTableModel(HYSZTableCulomns.data,
				KuCunKunCBDCulomns.KuCunColumnName2);
		//�½�һ�����
		hysxtable2 = new JTable(tableMode2);
		hysxtable2.addMouseListener(new TableMouseAction(this,2));
		//���̶���С
		hysxtable2.setPreferredScrollableViewportSize(
				new Dimension(870, 400));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//����Զ�����
		hysxtable2.setAutoCreateRowSorter(true);
		//��һ��������
		
		tablePane.add(new JScrollPane(hysxtable2),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		
		pane.add(downPane1);
		return pane;
	}
	
	/*
	 * ���������ĳ�ʹ��
	 */
	private JPanel createPane3(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//�ֱ����
		JSplitPane splitPane = new JSplitPane();
		
		//����������
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.setBorder(new TitledBorder("�����Ϣ"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("�������"));
		
		lbfield31 = new JTextField(10);
		northPane.add(lbfield31);
		
		leftPane.add(northPane,BorderLayout.NORTH);
		
		InitTreePane tmptree = new InitTreePane(tree);
		
		tree = tmptree.getTree();
		leftPane.add(new JScrollPane(tmptree.getPane()),
				BorderLayout.CENTER);
		
		splitPane.setLeftComponent(leftPane);
		tree.addMouseListener(new TreeMouseAction(this));
		
		
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("��Ʒ�б�"));
		
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("��Ʒ��Ϣ��ѯ(F6) : ");
		spbhmcfield32 = new JTextField(14);
		Document doc = spbhmcfield32.getDocument();
		
		doc.addDocumentListener(new SanPinXinDocumentAction(this));
		
		JLabel lab3 = new JLabel("  (������Ʒ��ţ����ƣ��Զ���ѯ) ");
		northPane1.add(lab1);
		northPane1.add(spbhmcfield32);
		northPane1.add(lab3);
		
		rightPane.add(northPane1,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		
		tableMode3 = new AllTableModel(HYSZTableCulomns.data,
				KuCunKunCBDCulomns.KuCunColumnName3);
		//�½�һ�����
		hysxtable3 = new JTable(tableMode3);
		//���̶���С
		hysxtable3.setPreferredScrollableViewportSize(
				new Dimension(870, 450));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//����Զ�����
		hysxtable3.setAutoCreateRowSorter(true);
		//��һ��������
		
		tablePane.add(new JScrollPane(hysxtable3,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
				BorderLayout.CENTER);
		
		rightPane.add(new JScrollPane(tablePane));
		
		splitPane.setRightComponent(rightPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(250);
		pane.add(splitPane);
	
		return pane;
	}
	public static void main(String[] args) {
		new KuCunChaXunFrame((JFrame)null,"��ǰ����ѯ");
	}

}
