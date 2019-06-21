package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import com.cn.control.systemframe.sanpingtiaojia.ClientTableMouseAcion;
import com.cn.control.systemframe.sanpingtiaojia.SPTJDocumentAcion;
import com.cn.control.systemframe.sanpingtiaojia.SPTJSelectTreeAction;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.util.InitTreePane;
import com.cn.util.JDatePicker;
import com.cn.view.systemJFrame.shangpingxinxidialog.SPTiaoJiManage;
/*
 * ϵͳ�����µ���Ʒ�����Ӵ���
 */
public class SanpinTiaoJiaJFrame extends JDialog {
	
	
	//��һ��ѡ��еĵ�һ����
	private JTable sptable;
	AllTableModel tableModel;
	//��һ��ѡ��еĵڶ�������Ʒ��ϸ��
	private JTable spmxtable;
	AllTableModel tableModel2 ;
	//�ڶ���ѡ��еĵ�һ����
	private JTable sptjtable;
	AllTableModel tableMode2;
	//��Ʒ����
	private JTextField spmcfield11 ;
	//�����ϱ��
	private JTextField spbhfield12 ;
	//�����������ƻ���
	private JTextField mcbhfield2 ;
	//��Ʒ�������ṹ
	private JTree tree;
	//��������
	private JDatePicker datePickerTo1;
	private JDatePicker datePickerTo2;
	
	public JTable getSptable() {
		return sptable;
	}

	public AllTableModel getTableModel() {
		return tableModel;
	}

	public JTable getSpmxtable() {
		return spmxtable;
	}

	public AllTableModel getTableModel2() {
		return tableModel2;
	}

	public JTable getSptjtable() {
		return sptjtable;
	}

	public AllTableModel getTableMode2() {
		return tableMode2;
	}

	public JTextField getSpmcfield11() {
		return spmcfield11;
	}

	public JTextField getSpbhfield12() {
		return spbhfield12;
	}

	public JTextField getMcbhfield2() {
		return mcbhfield2;
	}

	public JTree getTree() {
		return tree;
	}

	public JDatePicker getDatePickerTo1() {
		return datePickerTo1;
	}

	public JDatePicker getDatePickerTo2() {
		return datePickerTo2;
	}

	public SanpinTiaoJiaJFrame(JFrame frame,String title) {
		super(frame,title,true);
		init();
		initDataFromDB();
		this.setVisible(true);
		
	}
	/*
	 * ���ݵĳ�ʼ��
	 */
	public void initDataFromDB(){
		Vector data = SanPingTiaoJiJDBC.getSPBaseMassege("�������", "");
        //���½�������
        this.getTableModel().setDataVector(data,
    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.ColumnName11));
	}
	//���ڳ�ʹ��
	public void init(){
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
		JTabbedPane  tabblePane = new JTabbedPane(
				JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//����ѡ�
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		
		tabblePane.add("���۹���",pane1);
		tabblePane.add("���۲�ѯ",pane2);
		
		mainPane.add(tabblePane);
		return mainPane;
	}
	
	/*
	 * ���������ĳ�ʹ��
	 */
	private JPanel createPane1(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//�ֱ����
		JSplitPane splitPane = new JSplitPane();
		
		//����������
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.setBorder(new TitledBorder("��Ʒ���"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("�������"));
		
		spmcfield11 = new JTextField(10);
		northPane.add(spmcfield11);
		
		leftPane.add(northPane,BorderLayout.NORTH);
		InitTreePane tmp = new InitTreePane(tree);
		tree = tmp.getTree();
        tree.addMouseListener(new SPTJSelectTreeAction(this));
		leftPane.add(new JScrollPane(tmp.getPane()),
				BorderLayout.CENTER);
		splitPane.setLeftComponent(leftPane);
		
		
		//�ұ��������
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("��Ʒ�б�"));
		
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("��Ʒ��� : ");
		spbhfield12 = new JTextField(14);
		JButton sptnBtn = new JButton("��Ʒ����");
	   
		sptnBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(SanpinTiaoJiaJFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(SanpinTiaoJiaJFrame.this,"���۹���");
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							SanpinTiaoJiaJFrame.this, "��ѡ��һ����Ա����");
				}
			}
		});
		JButton exitBtn = new JButton("��       ��");
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0){
				SanpinTiaoJiaJFrame.this.dispose();
			}
			
		});
		
		northPane1.add(lab1);
		northPane1.add(spbhfield12);
		northPane1.add(sptnBtn);
		northPane1.add(exitBtn);
		Document doc = spbhfield12.getDocument();
		doc.addDocumentListener(new SPTJDocumentAcion(this));
		rightPane.add(northPane1,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		tableModel = new AllTableModel(SPTJTableCulomns.data,
				SPTJTableCulomns.ColumnName11);
		//�½�һ�����
		sptable = new JTable(tableModel);
		//���̶���С
		sptable.setPreferredScrollableViewportSize(new Dimension(1400, 370));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//����Զ�����
		sptable.setAutoCreateRowSorter(true);
		//��һ��������
		sptable.addMouseListener(new ClientTableMouseAcion(this));
		
		tablePane.add(new JScrollPane(sptable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
				BorderLayout.CENTER);
		
		rightPane.add(new JScrollPane(tablePane));
		
		splitPane.setRightComponent(rightPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(250);
		splitPane.setDividerSize(0);
		pane.add(splitPane);
		pane.add(new JScrollPane(initSouth()),BorderLayout.SOUTH);
		return pane;
	}
	
	/*
	 * ��Ʒ��ϸ����
	 */
	private JPanel initSouth(){
		JPanel pane = new JPanel();
		
		tableModel2 = new AllTableModel(SPTJTableCulomns.data,
				SPTJTableCulomns.ColumnName12);
		//�½�һ�����
		spmxtable = new JTable(tableModel2);
		//���̶���С
		spmxtable.setPreferredScrollableViewportSize(new Dimension(870, 80));
		//���Ϊ true��������������߽��ڵ���������
		pane.setOpaque(true);
		//����Զ�����
		spmxtable.setAutoCreateRowSorter(true);
		//��һ��������
		
		pane.add(new JScrollPane(spmxtable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
				BorderLayout.CENTER);
		
		return pane;
	}
	/*
	 * �ڶ���ѡ� ,���۲�ѯ
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//�������ļ���
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        
		//����
		JButton exportBtn = new JButton(new ImageIcon(
								"res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		//��ӡ
		JButton printBtn = new JButton(new ImageIcon(
								"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		//�˳�
		JButton exitBtn = new JButton(new ImageIcon(
								"res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SanpinTiaoJiaJFrame.this.dispose();
			}
			
		});
		northPane.add(exportBtn);
		northPane.add(printBtn);
		northPane.add(exitBtn);
		
		pane.add(northPane,BorderLayout.NORTH);
		
		
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane1 = new JPanel();
		northPane1.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		
		JLabel fromLab = new JLabel("����ʱ��:  ");
		//����ѡ��
		datePickerTo1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("��: ");
		datePickerTo2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("��Ʒ���ƻ��� : ");
		mcbhfield2 = new JTextField(14);
		JButton findbtn = new JButton("��    ѯ");
		
		northPane1.add(fromLab);
		northPane1.add(datePickerTo1);
		northPane1.add(toLab);
		northPane1.add(datePickerTo2);
		northPane1.add(allfindlab);
		northPane1.add(mcbhfield2);
		northPane1.add(findbtn);
		
		downPane1.add(northPane1,BorderLayout.NORTH);
		
		
		JPanel tablePane = new JPanel();
		
		tableMode2 = new AllTableModel(SPTJTableCulomns.data,
				SPTJTableCulomns.ColumnName2);
		//�½�һ�����
		sptjtable = new JTable(tableMode2);
		//���̶���С
		sptjtable.setPreferredScrollableViewportSize(
								new Dimension(870, 400));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//����Զ�����
		sptjtable.setAutoCreateRowSorter(true);
		//��һ��������
		
		tablePane.add(new JScrollPane(sptjtable),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		
		pane.add(downPane1);
		return pane;
	}
	
	
    public static void main(String[] args){
    	
    	new SanpinTiaoJiaJFrame((JFrame)null,"��Ʒ����");
    }

}
