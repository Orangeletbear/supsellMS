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
 * 系统设置下的商品调价子窗口
 */
public class SanpinTiaoJiaJFrame extends JDialog {
	
	
	//第一个选项卡中的第一个表
	private JTable sptable;
	AllTableModel tableModel;
	//第一个选项卡中的第二个表，商品明细表
	private JTable spmxtable;
	AllTableModel tableModel2 ;
	//第二个选项卡中的第一个表
	private JTable sptjtable;
	AllTableModel tableMode2;
	//商品名称
	private JTextField spmcfield11 ;
	//名称上编号
	private JTextField spbhfield12 ;
	//用于输入名称或编号
	private JTextField mcbhfield2 ;
	//商品类别的树结构
	private JTree tree;
	//两个日期
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
	 * 数据的初始化
	 */
	public void initDataFromDB(){
		Vector data = SanPingTiaoJiJDBC.getSPBaseMassege("所有类别", "");
        //更新界面数据
        this.getTableModel().setDataVector(data,
    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.ColumnName11));
	}
	//窗口初使化
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
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		JTabbedPane  tabblePane = new JTabbedPane(
				JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//三个选项卡
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		
		tabblePane.add("调价管理",pane1);
		tabblePane.add("调价查询",pane2);
		
		mainPane.add(tabblePane);
		return mainPane;
	}
	
	/*
	 * 第三个面板的初使化
	 */
	private JPanel createPane1(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//分边面板
		JSplitPane splitPane = new JSplitPane();
		
		//左边树型面板
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.setBorder(new TitledBorder("商品类别"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("类别名称"));
		
		spmcfield11 = new JTextField(10);
		northPane.add(spmcfield11);
		
		leftPane.add(northPane,BorderLayout.NORTH);
		InitTreePane tmp = new InitTreePane(tree);
		tree = tmp.getTree();
        tree.addMouseListener(new SPTJSelectTreeAction(this));
		leftPane.add(new JScrollPane(tmp.getPane()),
				BorderLayout.CENTER);
		splitPane.setLeftComponent(leftPane);
		
		
		//右边树型面板
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("商品列表"));
		
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("商品编号 : ");
		spbhfield12 = new JTextField(14);
		JButton sptnBtn = new JButton("商品调价");
	   
		sptnBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(SanpinTiaoJiaJFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(SanpinTiaoJiaJFrame.this,"调价管理");
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							SanpinTiaoJiaJFrame.this, "请选择一条会员数据");
				}
			}
		});
		JButton exitBtn = new JButton("退       出");
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
		//新建一个表格
		sptable = new JTable(tableModel);
		//表格固定大小
		sptable.setPreferredScrollableViewportSize(new Dimension(1400, 370));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//表格自动排序
		sptable.setAutoCreateRowSorter(true);
		//加一个滚动条
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
	 * 商品明细表区
	 */
	private JPanel initSouth(){
		JPanel pane = new JPanel();
		
		tableModel2 = new AllTableModel(SPTJTableCulomns.data,
				SPTJTableCulomns.ColumnName12);
		//新建一个表格
		spmxtable = new JTable(tableModel2);
		//表格固定大小
		spmxtable.setPreferredScrollableViewportSize(new Dimension(870, 80));
		//如果为 true，则该组件绘制其边界内的所有像素
		pane.setOpaque(true);
		//表格自动排序
		spmxtable.setAutoCreateRowSorter(true);
		//加一个滚动条
		
		pane.add(new JScrollPane(spmxtable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
				BorderLayout.CENTER);
		
		return pane;
	}
	/*
	 * 第二个选项卡 ,调价查询
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//工具栏的加入
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        
		//导出
		JButton exportBtn = new JButton(new ImageIcon(
								"res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton printBtn = new JButton(new ImageIcon(
								"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		//退出
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
		
		JLabel fromLab = new JLabel("调价时间:  ");
		//日期选项
		datePickerTo1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("到: ");
		datePickerTo2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("商品名称或编号 : ");
		mcbhfield2 = new JTextField(14);
		JButton findbtn = new JButton("查    询");
		
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
		//新建一个表格
		sptjtable = new JTable(tableMode2);
		//表格固定大小
		sptjtable.setPreferredScrollableViewportSize(
								new Dimension(870, 400));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//表格自动排序
		sptjtable.setAutoCreateRowSorter(true);
		//加一个滚动条
		
		tablePane.add(new JScrollPane(sptjtable),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		
		pane.add(downPane1);
		return pane;
	}
	
	
    public static void main(String[] args){
    	
    	new SanpinTiaoJiaJFrame((JFrame)null,"商品调价");
    }

}
