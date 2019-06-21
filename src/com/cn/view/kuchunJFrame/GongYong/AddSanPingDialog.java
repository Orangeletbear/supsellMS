package com.cn.view.kuchunJFrame.GongYong;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucundiaobo.AddShangPinMouseListener;
import com.cn.control.kuchunframe.kucundiaobo.Send_ShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.ShangPinMohuChaXunDocumentListener;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.DeleteShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.JRSX_XiuGaiShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.XiuGaiShangPinMouseListener;
import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin.AddShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.util.InitTreePane;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
/**
 * 加入商品对话框
 * @author finey
 *
 */


public class AddSanPingDialog extends JDialog {
	private KucunDiaobo kDialog;
	private BaosunBaoyi bDialog;
	private ChaifenKunbang cDialog;
	//拆分与捆绑的区分标志,0 为拆分，1为捆绑
	private String flag;
	//报损报溢标志区分：0为报损，1为报溢
	private String bFlag;
	//定义Vector
	private Vector vo1 = new Vector();
	private Vector vo2 = new Vector();
	private Vector vo3 = new Vector();

	private Vector ve1 = new Vector();
	private Vector ve2 = new Vector();
	private Vector ve3 = new Vector();

	//加入所选商品
	private JButton addBtn;
//	修改
	private JButton aterBtn;
	//商品清单
	private JTable spqdtable;
	//商品列表
	private  JTable splbtable;
	//所选商品
	private JTable sxsptable;
	//左边第一个选项卡面板表model
	private  AllTableModel tableModel1;
	//左边第二个选项卡面板表model
	private AllTableModel tableModel2;
	//右边面板表model
	private AllTableModel tableModel3;
	
	
	//名称上编号
	private JTextField spbhfield ;
	
	//商品类别的树结构
	private JTree tree;
	
	
	//获得父类窗口
	public KucunDiaobo getKDialog() {
		return kDialog;
	}
	
	public String getBFlag() {
		return bFlag;
	}


	public JButton getAterBtn() {
		return aterBtn;
	}

	public BaosunBaoyi getBDialog() {
		return bDialog;
	}

	public ChaifenKunbang getCDialog() {
		return cDialog;
	}
	//获取标志
	public String getFlag() {
		return flag;
	}

	//获取vector 
	public Vector getVo3() {
		return vo3;
	}

	public Vector getVo1() {
		return vo1;
	}

	public Vector getVo2() {
		return vo2;
	}

	public Vector getVe1() {
		return ve1;
	}

	public Vector getVe2() {
		return ve2;
	}

	public Vector getVe3() {
		return ve3;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	//获得商品信息输入文本框
	public JTextField getSpbhfield() {
		return spbhfield;
	}
	
	//jtable信息的获取
	//商品列表
	public JTable getSplbtable() {
		return splbtable;
	}
//商品清单
	public JTable getSpqdtable() {
		return spqdtable;
	}
//所选商品
	public JTable getSxsptable() {
		return sxsptable;
	}

	//获取表模式
	public AllTableModel getTableModel1() {
		return tableModel1;
	}

	public AllTableModel getTableModel2() {
		return tableModel2;
	}

	public AllTableModel getTableModel3() {
		return tableModel3;
	}
	
/*	public AddSanPingDialog(JDialog dialog, String title,String name){
		super(dialog,title,true);
		init();
		addGetDatas(name);
	}*/
	//库存调拨窗口
	public AddSanPingDialog(KucunDiaobo dialog, String title,String name){
		super(dialog,title,true);
		init();
		kDialog = dialog;
		addGetDatas(name);
		this.setVisible(true);
	}
	//报损报溢窗口
	public AddSanPingDialog(BaosunBaoyi dialog, String title,String name,String bflag){
		super(dialog,title,true);
		init();
		this.bFlag = bflag;
		bDialog = dialog;
		addGetDatas(name);
	}
	
	//拆分捆绑窗口
	public AddSanPingDialog(ChaifenKunbang dialog, String title,String name,boolean b,String flag){
		super(dialog,title,true);
		init();
		cDialog = dialog;
		this.flag = flag;
		addGetDatas(name);
	}
	
	//初始化添加商品同时将选择仓库中商品信息查询出来
	private void addGetDatas(String name){
//		Vector datas = AddShangPinDataToView.dataToView(name);
		Object[][]datas = AddShangPinDataToView.dataToView(name);
//		tableModel1.setDataVector(datas,AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1));
		tableModel1.setDataVector(datas,AddSanPingCulomns.ColumnName1);
//		spqdtable.setRowSelectionInterval(0, 0);
	}
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		this.setResizable(false);
	}
	//------------------------------------------------
	//单个面板
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		//分边面板
		JSplitPane splitPane = new JSplitPane();
		
		//左边树型面板
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout(2,2));
		leftPane.setBorder(new TitledBorder("询查商品列表"));
		leftPane.add(initLeftPane());
		splitPane.setLeftComponent(leftPane);

		//右边面板的建立
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("所选商品"));
		rightPane.add(initRightPane());
		
		splitPane.setRightComponent(rightPane);
		//splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(0);
		mainPane.add(splitPane);
		return mainPane;
	}
	//------------------------------------------------
	//初使化左边面板
	private JPanel initLeftPane(){
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		//------------------------------
		JPanel northPane = new JPanel();
		JLabel lab = new JLabel("输入商品编号或名称： ");
		spbhfield = new JTextField(10);
		{
			spbhfield.getDocument().addDocumentListener(new ShangPinMohuChaXunDocumentListener(this));
		}
		addBtn = new JButton("加入所选商品（F8）");
		{
			addBtn.addActionListener(new AddShangPinMouseListener(this));
		}
		northPane.add(lab);
		northPane.add(spbhfield);
		northPane.add(addBtn);
		leftPane.add(northPane,BorderLayout.NORTH);
		//----------------------------------
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//二个选项卡
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		
		tabblePane.add("商品清单",pane1);
		tabblePane.add("商品列表",pane2);
		
		leftPane.add(tabblePane);
		return leftPane;
	}
	//------------------------------------------------
	//第一个选项卡面板
	 private JPanel createPane1(){
         JPanel pane = new JPanel();
         pane.setLayout(new BorderLayout());
         
       vo1 =  AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
       ve1 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1);
         
       tableModel1 = new AllTableModel(vo1,ve1);
       spqdtable = new JTable(tableModel1);
       spqdtable.addMouseListener(new AddShangPinMouseListener(this));
         
         //表格固定大小
       spqdtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //如果为 true，则该组件绘制其边界内的所有像素
       spqdtable.setOpaque(true);
       //获取焦点(0,0)
       spqdtable.requestFocus();
       
/*       ListSelectionModel listSelectionModel = new DefaultListSelectionModel();   
		listSelectionModel .setSelectionInterval(0, 0);   
		spqdtable.setSelectionModel(listSelectionModel);*/ 
//       spqdtable.setRowSelectionInterval(0, 0);
 		//表格自动排序
       spqdtable.setAutoCreateRowSorter(true);
 		//加一个滚动条
         pane.add(new JScrollPane(spqdtable));
		 return pane;
		 
	 }
	//------------------------------------------------
	 //第二个选项卡面板
	 private JPanel createPane2(){
		    JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			//分边面板
			JSplitPane splitPane = new JSplitPane();
			
			//左边树型面板
			JPanel leftPane = new JPanel();
			leftPane.setLayout(new BorderLayout());
			
			leftPane.add(new JScrollPane(new InitTreePane(tree).getPane()),
					BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			vo2 =  AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
		    ve2 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName2);
			 tableModel2 = new AllTableModel(vo2,ve2);
			//新建一个表格
			 splbtable = new JTable(tableModel2);
			//表格固定大小
			 splbtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//如果为 true，则该组件绘制其边界内的所有像素
			tablePane.setOpaque(true);
			//表格自动排序
			splbtable.setAutoCreateRowSorter(true);
			//加一个滚动条
			tablePane.add(new JScrollPane(splbtable,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),BorderLayout.CENTER);
			
			rightPane.add(new JScrollPane(tablePane));
			splitPane.setRightComponent(rightPane);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(120);
			splitPane.setDividerSize(2);
			pane.add(splitPane);
			return pane;
	 }
	//------------------------------------------------
		
	//初使化右边面板
	private JPanel initRightPane(){
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		//////不同的功能部分表格有所区别
		/*if(this.getOwner() instanceof BaosunBaoyi){
			vo3 = AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
			ve3 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3);
		}*/
		
		vo3 = AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
		ve3 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3);
		
		tableModel3 = new AllTableModel(vo3,ve3);
		sxsptable = new JTable(tableModel3);
        //表格固定大小
		sxsptable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //如果为 true，则该组件绘制其边界内的所有像素
		
/*		ListSelectionModel listSelectionModel = new DefaultListSelectionModel(); 
		listSelectionModel .setSelectionInterval(0, 0); 
		sxsptable.setSelectionModel(listSelectionModel);*/
		
		sxsptable.setOpaque(true);
		//表格自动排序
		sxsptable.setAutoCreateRowSorter(true);
		//加一个滚动条
        rightPane.add(new JScrollPane(sxsptable));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        aterBtn = new JButton("修改(F3)");
        JButton deleteBtn = new JButton("删除(Del)");
        JButton okBtn = new JButton("确定(F5)");
        {
        	JRSX_XiuGaiShangPinAction lis = new JRSX_XiuGaiShangPinAction(this);
        	sxsptable.addMouseListener(lis);
        	aterBtn.addActionListener(lis);
        	
        	deleteBtn.addActionListener(new DeleteShangPinAction(this));
        	okBtn.addActionListener(new Send_ShangPinAction(this));
        }
        JButton canncerBtn = new JButton("取消(F4)");
        canncerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddSanPingDialog.this.dispose();
			}
        });
        btnPane.add(aterBtn);
        btnPane.add(deleteBtn);
        btnPane.add(okBtn);
        btnPane.add(canncerBtn);
        
        rightPane.add(btnPane,BorderLayout.SOUTH);
		return rightPane;
	}
	
	//------------------------------------------------
	
/*	public static void main(String[] args) {
		new AddSanPingDialog(null,"增加商品");
	}*/

}
