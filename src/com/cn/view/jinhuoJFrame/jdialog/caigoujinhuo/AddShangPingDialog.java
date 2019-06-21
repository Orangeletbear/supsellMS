package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.cn.control.jinhuoframe.caigoujinhuo.AddMouseAdapterRIGHT;
import com.cn.control.jinhuoframe.caigoujinhuo.AddShangPinMouseAdapt;
import com.cn.control.jinhuoframe.caigoujinhuo.LaoShangPinTianJiaListener;
import com.cn.control.jinhuoframe.caigoujinhuo.TreeMouseListener;
import com.cn.dao.jinhuo.Tb_spinfonameJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.util.InitTreePane;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
/**
 * 点击老商品添加按钮出现的对话框
 *
 */
public class AddShangPingDialog extends JDialog {
	private CaiGouJinHuo caiGouJinHuo;//用于向父窗口返回数据
	
//	存放向父窗口返回的一批数据,一批一批的加
	private Vector<Vector> YiPi_data = new Vector<Vector>();
	
//商品列表1,左边表格
	private AllTableModel ATM;
	private Vector LeftData = new Vector();//左边表数据
	JTable splbtable;//左边第一个面板的表
	
//右边面板表格
	private AllTableModel ATM1;
	private JTable splbtable1;
	
	//用于将商品信息采购数据显示到右边面板表中的存放data的Vector，能实现不断添加。
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	

	//商品清单,树形面板
	private JTable spqdtable;
	private Vector spqdtable_data = new Vector();
	private Vector spqdtable_columnName = ColumnNames.spqdtable_columnName;
	private AllTableModel splb_tableModel;
	//查询名称或编号
	private JTextField spbhfield ;
	
	public JTable getSplbtable() {
		return splbtable;
	}

	//商品类别的树结构
	private JTree tree;
	
	
	public AddShangPingDialog(CaiGouJinHuo dialog, String title){
		super(dialog,title,true);
		
		//一打开addSanPingDialog就应该初始化了左边表内数据
		this.addWindowListener(new LaoShangPinTianJiaListener(this));
		//关联父窗口
		this.caiGouJinHuo = dialog;
		init();
	}
	
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
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
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(spbhfield.getText().equals("")){
					JOptionPane.showMessageDialog(AddShangPingDialog.this,
					"请输入商品编号或名称!");
					return;
				}
				Vector shangpin = Tb_spinfonameJDBC.find(spbhfield.getText());
				if(shangpin.isEmpty()){
					JOptionPane.showMessageDialog(AddShangPingDialog.this,
					"仓库中无该商品信息!");
					return;
				}
				String spid = ((Vector)shangpin.get(0)).get(0).toString();
				int i = 0;
				for(Object tmp : LeftData){
					if( ((Vector)tmp).get(0).equals(spid)){//设置选择行为这一行
						splbtable.setRowSelectionInterval(i,i); 
						new  ShangPinXinXi(AddShangPingDialog.this,
								"商品信息（采购进货）",true);
					}else{
						i++;
					}
				}
					
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
         
         ATM = new AllTableModel(LeftData,ColumnNames.splbtable1_colunm);
         splbtable = new JTable(ATM);
         
         //这个鼠标事件根据表中行信息new出一个商品信息dilog，并初始化该dialog
         splbtable.addMouseListener(new AddShangPinMouseAdapt(this));
         
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
			
			InitTreePane tmptree = new InitTreePane(tree);
			tree = tmptree.getTree();
			tree.addMouseListener(new TreeMouseListener(this));
			leftPane.add(new JScrollPane(tmptree.getPane()),
					BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			
			splb_tableModel = new AllTableModel(spqdtable_data,
					spqdtable_columnName);
			//新建一个表格
			spqdtable = new JTable(splb_tableModel);
			spqdtable.addMouseListener(new MouseAdapter(){
			  public void mouseClicked(MouseEvent e) {
			    if(e.getClickCount()==2 ){
				  int i = spqdtable.getSelectedRow();
				  if(i == -1){ return;}
				  String spid = ((Vector)spqdtable_data.get(i)).get(0).toString(); 
				  
				  int jishu = 0;//选中行
				  for(Object tmp : LeftData){
					String argspid = ((Vector)tmp).get(0).toString();
					if(spid.equals(argspid)){
						splbtable.setRowSelectionInterval(jishu,jishu); 
						break;
					}else{
						jishu ++;
					}
				  }	 
				  
				  new ShangPinXinXi(AddShangPingDialog.this,
									"商品信息（采购进货）",true);
						}
					} 
				
				
			});
			//表格固定大小
			spqdtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//如果为 true，则该组件绘制其边界内的所有像素
			tablePane.setOpaque(true);
			//表格自动排序
			spqdtable.setAutoCreateRowSorter(true);
			//加一个滚动条
			tablePane.add(new JScrollPane(spqdtable,
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
		
		
		ATM1 = new AllTableModel(data,ColumnNames.splbtable1_colunm);
		splbtable1 = new JTable(ATM1);
		splbtable1.addMouseListener(new AddMouseAdapterRIGHT(this));//添加表格双击监听器
	
		
        //表格固定大小
        splbtable1.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //如果为 true，则该组件绘制其边界内的所有像素
        splbtable1.setOpaque(true);
		//表格自动排序
        splbtable1.setAutoCreateRowSorter(true);
		//加一个滚动条
        rightPane.add(new JScrollPane(splbtable1));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        //
        JButton aterBtn = new JButton("修改(F3)");
        aterBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(splbtable1.getSelectedRow() == -1){
					return;
				}
				new ShangPinXinXi2(AddShangPingDialog.this,"（修改）商品信息",true);
			}
        	
        });
        
        //
        JButton deleteBtn = new JButton("删除(Del)");
        deleteBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(splbtable1.getSelectedRow() != -1){
					data.remove(splbtable1.getSelectedRow());//去掉选中行的数据
				
					//去掉向采购进货主界面传的这行数据
					YiPi_data.remove(splbtable1.getSelectedRow());
				
					//刷新表
					AddShangPingDialog.this.getATM1().setDataVector(
							data, ColumnNames.splbtable1_colunm);
				}
			}
        	
        });
        //
        JButton okBtn = new JButton("确定(F5)");
        okBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//将数据一行一行的加过去
				for(Vector tmp : YiPi_data){
					caiGouJinHuo.getCaiGouJinHuo_data().add(tmp);
				}
				//刷新表中数据
				caiGouJinHuo.getATM().setDataVector(
						caiGouJinHuo.getCaiGouJinHuo_data(),ColumnNames.caiGouJinHuo_columns);
				//更改应付金额与实付金额
				Vector<Vector> huoqujine = caiGouJinHuo.getCaiGouJinHuo_data();
				float argJinE = 0;
				for(Vector tmp : huoqujine){
					argJinE = argJinE + Float.parseFloat(tmp.get(7).toString());
				}
				caiGouJinHuo.getYingFuJinE().setText(""+argJinE);
				caiGouJinHuo.getShiFuJinE().setText(""+argJinE);
				AddShangPingDialog.this.dispose();
			}
        	
        });
        //
        JButton canncerBtn = new JButton("取消(F4)");
        canncerBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
				AddShangPingDialog.this.dispose();
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
	
	public static void main(String[] args) {
		new AddShangPingDialog((CaiGouJinHuo)null,"增加商品");
	}

	public AllTableModel getATM() {
		return ATM;
	}

	public AllTableModel getATM1() {
		return ATM1;
	}


	public JTable getSplbtable1() {
		return splbtable1;
	}

	public Vector<Vector<Object>> getData() {
		return data;
	}


	public Vector<Vector> getYiPi_data() {
		return YiPi_data;
	}


	public CaiGouJinHuo getCaiGouJinHuo() {
		return caiGouJinHuo;
	}

	public JTextField getSpbhfield() {
		return spbhfield;
	}


	public JTable getSpqdtable() {
		return spqdtable;
	}


	public JTree getTree() {
		return tree;
	}


	public Vector getLeftData() {
		return LeftData;
	}


	public void setLeftData(Vector leftData) {
		LeftData = leftData;
	}


	public AllTableModel getSplb_tableModel() {
		return splb_tableModel;
	}

	
	public Vector getSpqdtable_columnName() {
		return spqdtable_columnName;
	}
	
	
	public Vector getSpqdtable_data() {
		return spqdtable_data;
	}
	
	
	public void setSpqdtable_data(Vector spqdtable_data) {
		this.spqdtable_data = spqdtable_data;
	}








	
}
