package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;

import com.cn.control.systemframe.sanpingxinxi.AtlerShangPingAction;
import com.cn.control.systemframe.sanpingxinxi.SPFindAction;
import com.cn.control.systemframe.sanpingxinxi.SelectTreeAction;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.model.system.MyTableCellRender;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.util.InitTreePane;
import com.cn.util.Log;
import com.cn.util.PrintTableData;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AddShangPingDialog;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerSPZheKou;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
import com.cn.view.systemJFrame.shangpingxinxidialog.SPTiaoJiManage;
/*
 * 系统设置下面的商品信息管理
 */
public class ShangPingGuangLiFrame extends JDialog {
	//表
	AllTableModel tableModel;
	private JTable sptable;
	//商品名称
	private JTextField spmcfield ;
	//名称上编号
	private JTextField spbhfield ;
	
	//商品类别的树结构
	private JTree tree;
	//
	JPopupMenu  popMenu = new JPopupMenu();
	
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public JTable getSptable() {
		return sptable;
	}
	public JTextField getSpmcfield() {
		return spmcfield;
	}
	public JTextField getSpbhfield() {
		return spbhfield;
	}
	public JTree getTree() {
		return tree;
	}
	public ShangPingGuangLiFrame(JFrame frame,String title) {
		super(frame,title,true);
		init();
		initDataFromDB();
		this.setVisible(true);
		
	}
	/**
	 * 数据初始化
	 */
	public void initDataFromDB(){
		//从数据库取出数据
	       Vector data = SanPingGuanLiJDBC.getSPBaseMassege("所有类别", "");
	       //更新界面数据
	       this.getTableModel().setDataVector(data,
	    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.SPTLColumnName));
	      //创建渲染器对象
		    TableCellRenderer cellRenderer = new MyTableCellRender();
			//设置每列的渲染器
		    for(int i = 0; i < SPTJTableCulomns.SPTLColumnName.length; i++) {
		    	sptable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		    }
	
	
	}
	//窗口初使化
	public void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		initPopupMenu();
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
	}
	
	private void initPopupMenu(){
		
		JMenuItem item1 = new JMenuItem("禁用商品");
		JMenuItem item2 = new JMenuItem("调整价格");
		JMenuItem item3 = new JMenuItem("修改折扣");
		JMenuItem item4 = new JMenuItem("改修类别");
		popMenu.add(item1);
		popMenu.add(item2);
		popMenu.addSeparator();
		popMenu.add(item3);
		popMenu.add(item4);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = getSptable().getSelectedRow(); 
				String spId = getTableModel().getValueAt(row, 0).toString();
			    boolean isChange = SanPingGuanLiJDBC.jinYongSP(spId);
			    if(isChange == true){
			       	 JOptionPane.showMessageDialog(null,"禁用成功");
			       	 MainFrame mframe = (MainFrame)ShangPingGuangLiFrame.this.getOwner();
			       	 
			       	 String user = mframe.getUser();
			       	 Log.traceLog(" 操作员  ",user,"  禁用了商品 "+getTableModel().getValueAt(row, 1));
			        }else{
			       	 JOptionPane.showMessageDialog(null,"注: 该商品不可禁用");
			        } 
			}
		});
		
		item2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(ShangPingGuangLiFrame.this,"调价管理");
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "请选择一条商品数据");
				}
			}
		});
		item3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new AtlerSPZheKou(ShangPingGuangLiFrame.this,"折扣修改",true);
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "请选择一条商品数据");
				}
			}
		});
	}
	
	//单个面板
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		//分边面板
		JSplitPane splitPane = new JSplitPane();
		//左边树型面板
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout(2,2));
		leftPane.setBorder(new TitledBorder("商品类别"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("类别名称"));
		
		spmcfield = new JTextField(10);
		northPane.add(spmcfield);
		
		leftPane.add(northPane,BorderLayout.NORTH);
		InitTreePane tmp = new InitTreePane(tree);
		tree = tmp.getTree();
		
		leftPane.add(tmp.getPane(),BorderLayout.CENTER);
		splitPane.setLeftComponent(leftPane);
		
        tree.addMouseListener(new SelectTreeAction(this));
        
		//右边面板的建立
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("商品列表"));
		
		rightPane.add(initPaneToolPane(),BorderLayout.NORTH);
		
		JPanel rightCenterPane = new JPanel();
		rightCenterPane.setLayout(new BorderLayout());
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("商品编号 : ");
		spbhfield = new JTextField(14);
		JButton sptnBtn = new JButton("查询");
		sptnBtn.addActionListener(new SPFindAction(this));
		JCheckBox selectAll = new JCheckBox("全选商品(Ctrl+A)");
		selectAll.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(((JCheckBox)arg0.getSource()).isSelected()){
					ShangPingGuangLiFrame.this.getSptable().selectAll();
				}else{
					ShangPingGuangLiFrame.this.getSptable().clearSelection();
				}
			}
			
		});
		
		northPane1.add(lab1);
		northPane1.add(spbhfield);
		northPane1.add(sptnBtn);
		northPane1.add(selectAll);
		lab1 = new JLabel("              提示:  红色字体为禁用商品");
		lab1.setForeground(Color.red);
		northPane1.add(lab1);
		
		
		rightCenterPane.add(northPane1,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		
		tableModel = new AllTableModel(SPTJTableCulomns.data,SPTJTableCulomns.SPTLColumnName);
		//新建一个表格
		sptable = new JTable(tableModel);
		
		//表格固定大小
		sptable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);

		final MouseInputListener mouseInputListener = getMouseInputListener(sptable);//添加鼠标右键选择行
        //右击可以选择该行
		sptable.addMouseListener(mouseInputListener);

		//sptable.addMouseMotionListener(mouseInputListener);
		//表格自动排序
		sptable.setAutoCreateRowSorter(true);
		sptable.setComponentPopupMenu(popMenu);
		sptable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2){
					int row = getSptable().getSelectedRow();
					String obj = getTableModel().getValueAt(row, 0).toString();
					
					new AtlerShangPingDialog(ShangPingGuangLiFrame.this,"修改商品",true,obj);
				}
			}
		});
		//加一个滚动条
		
		tablePane.add(new JScrollPane(sptable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),BorderLayout.CENTER);
		
		rightCenterPane.add(new JScrollPane(tablePane));
		
		rightPane.add(rightCenterPane);
		
		splitPane.setRightComponent(rightPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(200);
		//splitPane.setDividerSize(0);
		mainPane.add(splitPane);
		return mainPane;
	}
	
	
	 /*

     * 添加鼠标右键单击选择监听，并显示右键菜单

     */

    private static MouseInputListener getMouseInputListener(final JTable jTable){

       return new MouseInputListener() {

           public void mouseClicked(MouseEvent e) {
              processEvent(e);

           }
           public void mousePressed(MouseEvent e) {

              processEvent(e);

           }
           public void mouseReleased(MouseEvent e) {

              processEvent(e);

              /*if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0

                     && !e.isControlDown() && !e.isShiftDown()) {

//                popupMenu.show(tableLyz, e.getX(), e.getY());//右键菜单显示

              }*/
           }
           public void mouseEntered(MouseEvent e) {

              processEvent(e);

           }
           public void mouseExited(MouseEvent e) {
              processEvent(e);
           }
           public void mouseDragged(MouseEvent e) {
              processEvent(e);

           }
           public void mouseMoved(MouseEvent e) {
              processEvent(e);
           }
           private void processEvent(MouseEvent e) {

              if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                  int modifiers = e.getModifiers();

                  modifiers -= MouseEvent.BUTTON3_MASK;

                  modifiers |= MouseEvent.BUTTON1_MASK;

                  MouseEvent ne = new MouseEvent(e.getComponent(), e.getID(),

                         e.getWhen(), modifiers, e.getX(), e.getY(), 
                         e.getClickCount(), false);

                  jTable.dispatchEvent(ne);
              }
           }

       };

    }
	
	
	//工具栏面板
	private JPanel initPaneToolPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//增加商品
		JButton zjspBtn = new JButton(new ImageIcon("res/AcionIcon/add.jpg"));
		zjspBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new AddShangPingDialog(ShangPingGuangLiFrame.this,"增加商品",true);
			}
			
		});
		zjspBtn.setMargin(new Insets(0,0,0,0));
		//修改商品
		JButton xgBtn = new JButton(new ImageIcon("res/AcionIcon/atler.jpg"));
		xgBtn.addActionListener(new AtlerShangPingAction(this));
		xgBtn.setMargin(new Insets(0,0,0,0));
		//删除商品
		JButton scBtn = new JButton(new ImageIcon("res/AcionIcon/delete.jpg"));
		scBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedColumnCount()!=1){
					JOptionPane.showMessageDialog(null,"请先选择一条数据");
					return;
				}
		        int choice =  JOptionPane.showConfirmDialog(
		        		ShangPingGuangLiFrame.this, "数据删除后将不能恢复，是否删除！","删除警告",
		        		 JOptionPane.YES_NO_OPTION, 1);
		          //点确定删除数据
			     if(choice == JOptionPane.YES_OPTION){
			    	 int row = ShangPingGuangLiFrame.this.getSptable().
			    	             getSelectedRow();
			    	 
			    	 String obj = ShangPingGuangLiFrame.this.getTableModel()
			    	           .getValueAt(row, 0).toString();
			    	 
			    	 if(SanPingGuanLiJDBC.deleteData(obj)){
			    		 JOptionPane.showMessageDialog(null,"数据成功删除");
			    		 initDataFromDB();
			    	 }else{
			    		 JOptionPane.showMessageDialog(null,"该商品发生业务不能删除");
			    	 }
			     }
			}
			
		});
		scBtn.setMargin(new Insets(0,0,0,0));
		//调价
		JButton tjBtn = new JButton(new ImageIcon("res/AcionIcon/changeprice.jpg"));
		tjBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(ShangPingGuangLiFrame.this,"调价管理");
					initDataFromDB();
					
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "请选择一条会员数据");
				}
			}
		});
		tjBtn.setMargin(new Insets(0,0,0,0));
		//折扣
		JButton zkBtn = new JButton(new ImageIcon("res/AcionIcon/discont.jpg"));
		zkBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new AtlerSPZheKou(ShangPingGuangLiFrame.this,"折扣修改",true);
					initDataFromDB();
					
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "请选择一条会员数据");
				}
			}
		});
		
		zkBtn.setMargin(new Insets(0,0,0,0));
		//查询过滤
		JButton cxglBtn = new JButton(new ImageIcon("res/AcionIcon/chakanguolv.jpg"));
		cxglBtn.setMargin(new Insets(0,0,0,0));
		//导入
		JButton importSp = new JButton(new ImageIcon("res/AcionIcon/import.jpg"));
		importSp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", sptable, 
						SPTJTableCulomns.SPTLColumnName);
			}
			
		});
		importSp.setMargin(new Insets(0,0,0,0));
		//导出
		JButton export = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		export.setMargin(new Insets(0,0,0,0));
		
		//退出
		JButton exitBtn = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ShangPingGuangLiFrame.this.dispose();
			}
			
		});
		
		pane.add(zjspBtn);
		pane.add(xgBtn);
		pane.add(scBtn);
		pane.add(tjBtn);
		pane.add(zkBtn);
		pane.add(cxglBtn);
		pane.add(importSp);
		pane.add(export);
		pane.add(exitBtn);
		
		
		
		return pane;
	}

	
	public static void main(String[] args) {
	     new ShangPingGuangLiFrame((JFrame)null,"商品信息");
	}

}
