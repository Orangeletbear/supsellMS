package com.cn.control.jinhuoframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;

import com.cn.model.jinhuo.AddSanPingCulomns;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * 加入商品对话框
 * @author finey
 *
 */
public class AddSanPingDialog extends JDialog {
	
	//商品列表
	private JTable splbtable;
	//商品清单
	private JTable spqdtable;
	//所选商品
	private JTable sxsptable;
	//名称上编号
	private JTextField spbhfield ;
	
	//商品类别的树结构
	private JTree tree;
	
	
	public AddSanPingDialog(JDialog dialog, String title){
		super(dialog,title,true);
		init();
	}
	
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocation(300, 200);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
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
		JButton addBtn = new JButton("加入所选商品（F8）");
		northPane.add(lab);
		northPane.add(spbhfield);
		northPane.add(addBtn);
		leftPane.add(northPane,BorderLayout.NORTH);
		//----------------------------------
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
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
         splbtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName1);
         
         //表格固定大小
         splbtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //如果为 true，则该组件绘制其边界内的所有像素
         splbtable.setOpaque(true);
 		//表格自动排序
         splbtable.setAutoCreateRowSorter(true);
 		//加一个滚动条
         pane.add(new JScrollPane(splbtable));
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
			
			leftPane.add(initTree(),BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			//新建一个表格
			spqdtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName2);
			//表格固定大小
			spqdtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//如果为 true，则该组件绘制其边界内的所有像素
			tablePane.setOpaque(true);
			//表格自动排序
			spqdtable.setAutoCreateRowSorter(true);
			//加一个滚动条
			tablePane.add(new JScrollPane(spqdtable,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
						BorderLayout.CENTER);
			
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
		splbtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName2);
        //表格固定大小
        splbtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //如果为 true，则该组件绘制其边界内的所有像素
        splbtable.setOpaque(true);
		//表格自动排序
        splbtable.setAutoCreateRowSorter(true);
		//加一个滚动条
        rightPane.add(new JScrollPane(splbtable));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        JButton aterBtn = new JButton("修改(F3)");
        JButton deleteBtn = new JButton("删除(Del)");
        JButton okBtn = new JButton("确定(F5)");
        JButton canncerBtn = new JButton("取消(F4)");
        
        btnPane.add(aterBtn);
        btnPane.add(deleteBtn);
        btnPane.add(okBtn);
        btnPane.add(canncerBtn);
        
        rightPane.add(btnPane,BorderLayout.SOUTH);
		return rightPane;
	}
	
	//------------------------------------------------
	/*
	 * 商品类别树的初始化
	 */
	private JPanel initTree(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有类别");
		
		DefaultMutableTreeNode drink = new DefaultMutableTreeNode("酒类");
		DefaultMutableTreeNode shuiGuo = new DefaultMutableTreeNode("水果类");
		DefaultMutableTreeNode yiLiao = new DefaultMutableTreeNode("饮料类");
		DefaultMutableTreeNode shiPing = new DefaultMutableTreeNode("食品类");
		DefaultMutableTreeNode shengHuo = new DefaultMutableTreeNode("生活类");
		
		DefaultMutableTreeNode writeDrink = new DefaultMutableTreeNode("白酒");
		DefaultMutableTreeNode redDrink = new DefaultMutableTreeNode("红酒");
		
	    root.add(drink); 
	    root.add(shuiGuo); 
	    root.add(yiLiao); 
	    root.add(shiPing); 
	    root.add(shengHuo);
	    
	    drink.add(writeDrink);
	    drink.add(redDrink);
	    //指定根的树模型
	    DefaultTreeModel treeModel = new DefaultTreeModel(root);
	    
	    tree = new JTree(treeModel);
	    
	    KunCunDefaultTreeCellRenderer render = new KunCunDefaultTreeCellRenderer();
	    
	    tree.setCellRenderer(render);
	    
	    tree.setCellEditor(new DefaultTreeCellEditor(tree, render) {
	        
	    });
	    pane.add(tree);
	    
	    pane.setBorder(new LineBorder(Color.gray));
	    pane.setBackground(Color.white);
		return pane;
	}
	public static void main(String[] args) {
		new AddSanPingDialog((JDialog)null,"增加商品");
	}

}
