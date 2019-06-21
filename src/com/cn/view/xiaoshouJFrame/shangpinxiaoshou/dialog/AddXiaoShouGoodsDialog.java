package com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
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

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AddXiaoShouGoodsAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AddXiaoShouGoods_TreeMouseListener;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AddXiaoShuoGoodsMouseAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.ClickedAddGoodsAction;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.DialogColumnNamesModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.util.InitTreePane;

import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;

public class AddXiaoShouGoodsDialog extends JDialog {

	//父窗口
	private ShangPinXiaoShouDialog mainDialog;
	//存放向父窗口返回的数据
	private Vector<Vector> mainData = new Vector<Vector>();

	//左边面板上的表
	private JTable spqdtable;
    private AllTableModel spqd_tableModel ;
	//树形面板上的表
	private JTable splbtable;
	private AllTableModel splb_tableModel ;
	
	//右边面板上的表
	private JTable sxspTable;
	private AllTableModel sxsp_tableModel;
	
	
	//名称上编号
	private JTextField spbhfield ;
	
	//商品类别的树结构
	private JTree tree;
	
	//用于将商品信息数据显示到右边面板表中的存放data的Vector，能实现不断添加。
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	
	public AddXiaoShouGoodsDialog(ShangPinXiaoShouDialog dialog,String title){
		super(dialog,title,true);
		//一打开addXiaoShouGoodsDialog就应该初始化了左边表内数据
		this.addWindowListener(new AddXiaoShouGoodsAction(this));
		this.mainDialog = dialog;
		init();
		this.setVisible(true);
	}
	private void init(){
		this.setSize(new Dimension(950,600));
		//this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		//关闭窗口事件
		AddXiaoShouGoodsDialog.this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			
				 if(sxsp_tableModel.getRowCount() == 0){
	        			dispose();
	        	  }else{
	        		  int n = JOptionPane.showOptionDialog(AddXiaoShouGoodsDialog.this,
	        			 "当前单据还没保存，是否关闭窗口？", "系统提示", 
	        			 JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, null,null);
	        		  if(n == JOptionPane.YES_OPTION){
	        			  dispose();
	        		  }else {
	        			
	        		  }
	        	  }
			}
		});
		this.setLocation(300, 200);
		this.setLayout(new BorderLayout());
		this.add(createPane());
	
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
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
		addBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new  XiaoShouGoodsInfo(AddXiaoShouGoodsDialog.this,"商品信息(商品销售)");
			}
			
		});
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
         
         spqd_tableModel = new AllTableModel(DialogCulomnModel.obj,
        		 DialogCulomnModel.leftColumnName);
         spqdtable = new JTable(spqd_tableModel);
     
         spqdtable.addMouseListener(new ClickedAddGoodsAction(this));
       
         //表格固定大小
         spqdtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //如果为 true，则该组件绘制其边界内的所有像素
         spqdtable.setOpaque(true);
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
			
			InitTreePane tmptree = new InitTreePane(tree);
			tree = tmptree.getTree();
			tree.addMouseListener(new AddXiaoShouGoods_TreeMouseListener(this));
			leftPane.add(new JScrollPane(tmptree.getPane()),
					BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			
			splb_tableModel = new AllTableModel(DialogCulomnModel.obj,
					 DialogCulomnModel.leftColumnName);
			//新建一个表格
			splbtable = new JTable(splb_tableModel);
			//表格固定大小
	splbtable.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount() == 2){
						new XiaoShouGoodsInfo(AddXiaoShouGoodsDialog.this,"商品信息（销售退货）");
					}
				}
			});
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
		
		
        sxsp_tableModel = new AllTableModel(data,
        		AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
		sxspTable = new JTable(sxsp_tableModel);
		sxspTable.addMouseListener(new AddXiaoShuoGoodsMouseAction(this));
        //表格固定大小
		sxspTable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //如果为 true，则该组件绘制其边界内的所有像素
		sxspTable.setOpaque(true);
		//表格自动排序
		sxspTable.setAutoCreateRowSorter(true);
		//加一个滚动条
        rightPane.add(new JScrollPane(sxspTable));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        JButton alterBtn = new JButton("修改(F3)");
        alterBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(sxsp_tableModel.getColumnCount()>0){
					
					new XiaoShouGoodsInfo2(AddXiaoShouGoodsDialog.this,"商品信息");
					
				}
				
			}
        	
        });
        JButton deleteBtn = new JButton("删除(Del)");
        final AddXiaoShouGoodsDialog addDialog = AddXiaoShouGoodsDialog.this;
        deleteBtn.addActionListener(new ActionListener(){
        	
			public void actionPerformed(ActionEvent e) {
				if(sxsp_tableModel.getColumnCount()>0){
					if(sxspTable.getSelectedRow() != -1){
						data.remove(sxspTable.getSelectedRow());//去掉选中行的数据
					   mainData.remove(sxspTable.getSelectedRow());
						//刷新表
					   addDialog.getSxsp_tableModel().setDataVector(data,
							           AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
				}
				}
				
			}
        });
        JButton sureBtn = new JButton("确定(F5)");
   
        sureBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(sxsp_tableModel.getColumnCount()>0){
					for(Vector temp: AddXiaoShouGoodsDialog.this.getMainData()){
						mainDialog.getData().add(temp);
					}
				
					mainDialog.getTableModel().setDataVector(mainDialog.getData(),
	                 
						AllTableModel.getVectorFromObj(XiaoShouCulomnModel.columnNames));
					
					
					if(mainDialog.getTableModel().getRowCount() > 0){
						mainDialog.getTable().requestFocus();
						mainDialog.getTable().setRowSelectionInterval(0, 0);
					}
					int row = mainDialog.getTableModel().getRowCount();
					float money = 0;
					for(int i = 0; i< row;i++){
					    String s =	mainDialog.getTableModel().getValueAt(i, 9).toString();
						money = Float.parseFloat(s) + money;
					   }
						
						mainDialog.getYingShouText().setText(""+money);
						mainDialog.getShiShouText().setText(""+money);
						mainDialog.getDeleteButton().setVisible(true);
						mainDialog.getAlterButton().setVisible(true);
						
						addDialog.dispose();
				}
					
			}
			
        });
        JButton canncerBtn = new JButton("取消(F4)");
        
        btnPane.add(alterBtn);
        btnPane.add(deleteBtn);
        btnPane.add(sureBtn);
        btnPane.add(canncerBtn);
        canncerBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(sxspTable.getModel().getRowCount() == 0){
					dispose();
				}else{
					  int n = JOptionPane.showOptionDialog(AddXiaoShouGoodsDialog.this, 
							  "所选商品还没保存，是否保存？", "系统提示", 
							  JOptionPane.YES_NO_CANCEL_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
				       if(n == JOptionPane.YES_OPTION){
				    	   for(Vector temp: AddXiaoShouGoodsDialog.this.getMainData()){
								mainDialog.getData().add(temp);
							}
						
							mainDialog.getTableModel().setDataVector(mainDialog.getData(),
			                 
								AllTableModel.getVectorFromObj(XiaoShouCulomnModel.columnNames));
							
							int row = mainDialog.getTableModel().getRowCount();
							float money = 0;
							for(int i = 0; i< row;i++){
							    String s =	mainDialog.getTableModel().getValueAt(i, 5).toString();
								money = Float.parseFloat(s) + money;
							   }
								
								mainDialog.getYingShouText().setText(""+money);
								mainDialog.getShiShouText().setText(""+money);
								mainDialog.getDeleteButton().setVisible(true);
								mainDialog.getAlterButton().setVisible(true);
								dispose();
		    				
				       }else if(n == JOptionPane.NO_OPTION){
				    	   dispose();
				       }else {
				    	   
				       }
				}
			}
        	
     });
        
        rightPane.add(btnPane,BorderLayout.SOUTH);
		return rightPane;
	}
	public Vector<Vector<Object>> getData() {
		return data;
	}


	public JTable getSplbtable() {
		return splbtable;
	}


	public JTable getSpqdtable() {
		return spqdtable;
	}


	public JTable getSxsptable() {
		return sxspTable;
	}


	public JTextField getSpbhfield() {
		return spbhfield;
	}


	public JTree getTree() {
		return tree;
	}
	public AllTableModel getSpqd_tableModel() {
		return spqd_tableModel;
	}


	public AllTableModel getSplb_tableModel() {
		return splb_tableModel;
	}


	public AllTableModel getSxsp_tableModel() {
		return sxsp_tableModel;
	}

	//------------------------------------------------
	
	public static void main(String[] args) {
		new AddXiaoShouGoodsDialog((ShangPinXiaoShouDialog)null,"增加商品(商品销售)");
	}



	public  ShangPinXiaoShouDialog getMaindialog() {
		return mainDialog;
	}

	public Vector<Vector> getMainData() {
		return mainData;
	}
}
