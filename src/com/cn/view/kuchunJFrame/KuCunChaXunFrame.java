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
 * 当前库存查询对话框
 * @author finey
 *
 */
public class KuCunChaXunFrame extends JDialog {
	
	//第一个选项卡中的第一个表
	private AllTableModel tableModel;
	private JTable hysxtable1;
	//第二个选项卡中的第一个表
	private AllTableModel tableMode2;
	private JTable hysxtable2;
	//第三个选项卡中的第一个表
	private AllTableModel tableMode3 ;
	private JTable hysxtable3;
	// 选择仓库的BOX
	private JComboBox chankuBox;
	//四个日期
	private JDatePicker datePickerTo1;
	private JDatePicker datePickerTo2;
	
	//用于输入商品类别名
	private JComboBox splbB ;
	//商品名称
	private JTextField spmcfield12 ;
	//名称或编号
	private JTextField mchbhfield21 ;
	//类别
	private JTextField lbfield31 ;
	//编号或名称
	private JTextField spbhmcfield32 ;
	//多选框，有是否过滤为0的商品
	private JCheckBox isgetO;
	//商品类别的树结构
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
		//表中数据的初始化
		CunChunPublicFindData.setSPDataFromDatabase(this,"所有类别","");
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
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		//三个选项卡
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		
		tabblePane.add("库存变动情况",pane1);
		tabblePane.add("商品变动情况",pane2);
		tabblePane.add("商品信息查询",pane3);
		
		mainPane.add(tabblePane);
		return mainPane;
	}
	/*
	 * 第一个选项卡
	 */
	private JPanel createPane1(){
        
		
        JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//工具栏的加入
		pane.add(initTool(),BorderLayout.NORTH);
	
		//表格面板
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		JLabel lab = new JLabel("仓库 : ");
		chankuBox = new JComboBox(JDBCCuCunFind.getCanKuData());
		chankuBox.addItem("所有仓库");
		chankuBox.setSelectedIndex(chankuBox.getItemCount()-1);
		JLabel lab1 = new JLabel("商品类别 : ");
		splbB = new JComboBox(JDBCCuCunFind.getSpLbData());
		splbB.addItem("所有类别");
		splbB.setSelectedIndex(splbB.getItemCount()-1);
		JLabel lab2 = new JLabel("商品编号或名称: ");
		spmcfield12 = new JTextField(14);
		
		JButton findbtn = new JButton("查    询");
		isgetO = new JCheckBox("不再显示库存为零的商品");
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
		//新建一个表格
		hysxtable1 = new JTable(tableModel);
		hysxtable1.addMouseListener(new TableMouseAction(this,1));
		//表格固定大小
		hysxtable1.setPreferredScrollableViewportSize(new Dimension(1200,400));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//设列宽
		//hysxtable1.getColumnModel().getColumn(3).setPreferredWidth(150);
		//加一个滚动条
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
	 * 第一个面板的工具栏的建立
	 */
	private JPanel initTool(){
		JPanel pane =new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//高级查询
		JButton gjcsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/advanceFind.jpg"));
		gjcsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new AdvanceFind(KuCunChaXunFrame.this,"高级查询");
			}
			
		});
		gjcsBtn.setMargin(new Insets(0,0,0,0));
		//全部
		JButton qbBtn = new JButton(new ImageIcon(
				"res/AcionIcon/all.jpg"));
		qbBtn.setMargin(new Insets(0,0,0,0));
		qbBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				boolean isGetO = getIsgetO().isSelected();
				
				Vector data = DanQianKuCunJDBC.getSPBDQKData("所有仓库","所有类别","",isGetO);
				//数据加入表模式中
				getTableModel().setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName1));
				
		        MyTableCellRender render = new MyTableCellRender();
				
				//设置每列的渲染器
			    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
			    	getHysxtable1().getColumnModel().getColumn(i).setCellRenderer(render);
			    }
			}
			
		});
		
		
		//查看明细
		JButton ckmsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chakanmingxi.jpg"));
		ckmsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(KuCunChaXunFrame.this.getHysxtable1().getSelectedColumn()<0){
					JOptionPane.showMessageDialog(
							KuCunChaXunFrame.this, "请选择一条商品数据");
				}else{
					new ChaKanMingXiDialog(KuCunChaXunFrame.this,"查看商品明细",1);
				}
				
			}
			
		});
		ckmsBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton printBtn = new JButton(new ImageIcon(
				"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		printBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(hysxtable1.getModel(),"ccc");
			}
			
		});
		
		
		//进货参考
		JButton jhckBtn = new JButton(new ImageIcon(
				"res/AcionIcon/jinhuochangkao.jpg"));
		jhckBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new JinHuoDialog(KuCunChaXunFrame.this,"进货参考",true);
			}
			
		});
		
		
		jhckBtn.setMargin(new Insets(0,0,0,0));
		//退货参考
		JButton thckBtn = new JButton(new ImageIcon(
				"res/AcionIcon/tuihuochangkao.jpg"));
		thckBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TuiHuoDialog(KuCunChaXunFrame.this,"退货参考",true);
			}
			
		});
		
		thckBtn.setMargin(new Insets(0,0,0,0));
		//拆分捆绑
		JButton cfkbBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chaifenkuangbang.jpg"));
		cfkbBtn.setMargin(new Insets(0,0,0,0));
		cfkbBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ChaifenKunbang(KuCunChaXunFrame.this,"折分捆绑",true);
			}
			
		});
		
		
		//修改均价
		JButton xgjjBtn = new JButton(new ImageIcon(
				"res/AcionIcon/changeAva.jpg"));
		xgjjBtn.setMargin(new Insets(0,0,0,0));
		//导出
		JButton exportBtn = new JButton(new ImageIcon(
				"res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", hysxtable1, 
						KuCunKunCBDCulomns.KuCunColumnName1);
			}
			
		});
		
		//退出
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
	 * 第二个选项卡
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//工具栏的加入
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        
		//查看明细
		JButton ckmsBtn = new JButton(new ImageIcon(
				"res/AcionIcon/chakanmingxi.jpg"));
		ckmsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(KuCunChaXunFrame.this.getHysxtable2().getSelectedColumn()<0){
					JOptionPane.showMessageDialog(
							KuCunChaXunFrame.this, "请选择一条商品数据");
				}else{
					new ChaKanMingXiDialog(KuCunChaXunFrame.this,"查看商品明细",2);
				}
			}
			
		});
		ckmsBtn.setMargin(new Insets(0,0,0,0));
		//导出
		JButton exportBtn = new JButton(new ImageIcon(
				"res/AcionIcon/export.jpg"));
		
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", hysxtable2, 
						KuCunKunCBDCulomns.KuCunColumnName2);
			}
			
		});
		
		exportBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton printBtn = new JButton(new ImageIcon(
				"res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		printBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(hysxtable2.getModel(),"ccc");
			}
			
		});
		
		//退出
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
		
		JLabel fromLab = new JLabel("统计时间:  ");
		//日期选项
		datePickerTo1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("到: ");
		datePickerTo2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("商品名称或编号 : ");
		mchbhfield21 = new JTextField(14);
		JButton findbtn = new JButton("查    询");
		
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
		//新建一个表格
		hysxtable2 = new JTable(tableMode2);
		hysxtable2.addMouseListener(new TableMouseAction(this,2));
		//表格固定大小
		hysxtable2.setPreferredScrollableViewportSize(
				new Dimension(870, 400));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//表格自动排序
		hysxtable2.setAutoCreateRowSorter(true);
		//加一个滚动条
		
		tablePane.add(new JScrollPane(hysxtable2),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		
		pane.add(downPane1);
		return pane;
	}
	
	/*
	 * 第三个面板的初使化
	 */
	private JPanel createPane3(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//分边面板
		JSplitPane splitPane = new JSplitPane();
		
		//左边树型面板
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.setBorder(new TitledBorder("类别信息"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("类别名称"));
		
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
		rightPane.setBorder(new TitledBorder("商品列表"));
		
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("商品信息查询(F6) : ");
		spbhmcfield32 = new JTextField(14);
		Document doc = spbhmcfield32.getDocument();
		
		doc.addDocumentListener(new SanPinXinDocumentAction(this));
		
		JLabel lab3 = new JLabel("  (输入商品编号，名称，自动查询) ");
		northPane1.add(lab1);
		northPane1.add(spbhmcfield32);
		northPane1.add(lab3);
		
		rightPane.add(northPane1,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		
		tableMode3 = new AllTableModel(HYSZTableCulomns.data,
				KuCunKunCBDCulomns.KuCunColumnName3);
		//新建一个表格
		hysxtable3 = new JTable(tableMode3);
		//表格固定大小
		hysxtable3.setPreferredScrollableViewportSize(
				new Dimension(870, 450));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//表格自动排序
		hysxtable3.setAutoCreateRowSorter(true);
		//加一个滚动条
		
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
		new KuCunChaXunFrame((JFrame)null,"当前库存查询");
	}

}
