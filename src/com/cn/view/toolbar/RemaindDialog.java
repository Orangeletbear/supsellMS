package com.cn.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.control.toolbar.TadayKuCunBaoJinBtnAction;
import com.cn.control.toolbar.TodayPassDateAction;
import com.cn.control.toolbar.TodayYingShouKuanAction;
import com.cn.dao.MFrameJDBC;
import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.util.PrintTableData;
import com.cn.util.SwingCommonPrinitTools;

/*
 * 今日提醒对话框，用已智能的提醒用户做事
 */
public class RemaindDialog extends JDialog{
	
	//库存报警中的输入区,用以输入商品名和编号
	JTextField spNamefield;
	//新建一个表格,库存报警
	AllTableModel kuCunBJtableMO; 
	JTable kuCunBJTable;
	
	
	//应收款提醒
	JTextField keHuNamefield;
	JComboBox box;
	JSpinner dayNum;
	//应收款表
	AllTableModel yiShouTMO;
	JTable yiShouKuanTable;
	
	//商品过期提醒
	JTextField spNafield;
	JComboBox comBox;
	JSpinner spDayNum;
	//商品过期表
	 AllTableModel guoQiMO;
	JTable spGuoQitable;
	
	public JTextField getSpNamefield() {
		return spNamefield;
	}
	public AllTableModel getKuCunBJtableMO() {
		return kuCunBJtableMO;
	}
	public JTable getKuCunBJTable() {
		return kuCunBJTable;
	}
	public JTextField getKeHuNamefield() {
		return keHuNamefield;
	}
	public JComboBox getBox() {
		return box;
	}
	public JSpinner getDayNum() {
		return dayNum;
	}
	public AllTableModel getYiShouTMO() {
		return yiShouTMO;
	}
	public JTable getYiShouKuanTable() {
		return yiShouKuanTable;
	}
	public JTextField getSpNafield() {
		return spNafield;
	}
	public JComboBox getComBox() {
		return comBox;
	}
	public JSpinner getSpDayNum() {
		return spDayNum;
	}
	public AllTableModel getGuoQiMO() {
		return guoQiMO;
	}
	public JTable getSpGuoQitable() {
		return spGuoQitable;
	}

	private static final long serialVersionUID = 1L;

	public RemaindDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		initData();
	}
	/*
	 * 数据的更新
	 */
	private void initData(){
		//商品报警
		Vector data = TadayRemindJDBC.getCuCunBJData(
			    this.getSpNamefield().getText().toString());
	   this.getKuCunBJtableMO().setDataVector(data,
	   AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName1));
	   
	   data = TadayRemindJDBC.getYingShouKTXData(
			    getKeHuNamefield().getText().toString(),
			    getBox().getSelectedItem().toString(),
			    getDayNum().getValue().toString());
	   getYiShouTMO().setDataVector(data,
	   AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName2));
	   
	   
	   
	}
	/*
	 * 三个共用标签的初始化
	 */
	private JPanel initLabel(){
		JPanel toolPane = new JPanel();
		toolPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				RemaindDialog.this.dispose();
			}
		});
		JButton print = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		print.setMargin(new Insets(0,0,0,0));
		
		JButton export = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		export.setMargin(new Insets(0,0,0,0));
		export.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", 
						kuCunBJTable, TableCulomnModel.TodayColumnName1);
			}
			
		});
		print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(kuCunBJTable.getModel(),"ccc");
			}
			
		});
		
		
		toolPane.add(export);
		toolPane.add(print);
		toolPane.add(exit);
		return toolPane;
	}
	private void init(){
		this.setSize(new Dimension(770,500));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel pane1 = createPane1();
		
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		
		tabblePane.add("库存报警",pane1);
		tabblePane.add("应收款提示",pane2);
		tabblePane.add("商品过期提醒",pane3);
		
		mainPane.add(tabblePane);
		JCheckBox noRemind = new JCheckBox("不再提醒");
		String isRemind = MFrameJDBC.getIsTodayRemind();
 	   	if(isRemind.equals("1")){
 		  noRemind.setSelected(false);
 	    }else{
 	      noRemind.setSelected(true);
 	    }
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPane.add(noRemind);
		mainPane.add(southPane,BorderLayout.SOUTH);
		
		noRemind.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JCheckBox noRemind = (JCheckBox)arg0.getSource();
				if(noRemind.isSelected()){
					MFrameJDBC.changeTodayRemind("0");
				}else{
					MFrameJDBC.changeTodayRemind("1");
				}
			}
			
		});
		return mainPane;
	}
	/*
	 * 第一个选项卡
	 */
	private JPanel createPane1(){
        final Object[][] data = {};
		
        JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(initLabel());
		
		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		JLabel lab = new JLabel("输入商品编号/名称简称: ");
		spNamefield = new JTextField(20);
		JButton findbtn = new JButton("查    询");
		
		findbtn.addActionListener(new TadayKuCunBaoJinBtnAction(this));
		northPane.add(lab);
		northPane.add(spNamefield);
		northPane.add(findbtn);
		downPane.add(northPane,BorderLayout.NORTH);
		//表格面板
		JPanel tablePane = new JPanel();
		
		kuCunBJtableMO = new AllTableModel(data,TableCulomnModel.TodayColumnName1);
		//新建一个表格
		kuCunBJTable = new JTable(kuCunBJtableMO);
		//表格固定大小
		kuCunBJTable.setPreferredScrollableViewportSize(new Dimension(900, 300));
		//如果为 true，则该组件绘制其边界内的所有像素
	
		kuCunBJTable.setAutoCreateRowSorter(true);
		
		tablePane.setOpaque(true);
		
		//加一个滚动条
		tablePane.add(new JScrollPane(kuCunBJTable),BorderLayout.CENTER);
		
		downPane.add(new JScrollPane(tablePane));
		splitPane.setRightComponent(downPane);
		splitPane.setDividerLocation(70);
		splitPane.setDividerSize(0);
		pane.add(splitPane,BorderLayout.CENTER);

		return pane;
	}
	
	/*
	 * 第二个选项卡
	 */
	private JPanel createPane2(){
		

	    final Object[][] data = {};
              
       
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(initLabel());
		
		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		JLabel lab = new JLabel("客户名称: ");
		keHuNamefield = new JTextField(20);
		JLabel lab1 = new JLabel("欠款天数");
		box = new JComboBox(new String[]{"<=",">=","="});
		dayNum = new JSpinner();
		dayNum.setValue(10);
		JLabel lab2 = new JLabel("天   ");
		JButton findbtn = new JButton("查    询");
		findbtn.addActionListener(new TodayYingShouKuanAction(this));
		northPane.add(lab);
		northPane.add(keHuNamefield);
		northPane.add(lab1);
		northPane.add(box);
		northPane.add(dayNum);
		northPane.add(lab2);
		northPane.add(findbtn);
		
		downPane.add(northPane,BorderLayout.NORTH);

        JPanel tablePane = new JPanel();
        
        yiShouTMO =new AllTableModel(data,TableCulomnModel.TodayColumnName2);
		yiShouKuanTable = new JTable(yiShouTMO);
		
		yiShouKuanTable.setAutoCreateRowSorter(true);
		yiShouKuanTable.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		tablePane.setOpaque(true);
		tablePane.add(new JScrollPane(yiShouKuanTable),BorderLayout.CENTER);
		
		downPane.add(new JScrollPane(tablePane));
		
		splitPane.setRightComponent(downPane);
		splitPane.setDividerLocation(70);
		splitPane.setDividerSize(0);
		pane.add(splitPane,BorderLayout.CENTER);
		
		return pane;
		
	}
	private JPanel createPane3(){
		

	    Object[][] data = {};
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(initLabel());
		
		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		JLabel lab = new JLabel("输入商品编号或简称: ");
		spNafield = new JTextField(15);
		JLabel lab1 = new JLabel("剩余天数");
		comBox = new JComboBox(new String[]{"<=",">=","="});
		spDayNum = new JSpinner();
		spDayNum.setValue(10);
		JLabel lab2 = new JLabel("天   ");
		JButton btn = new JButton("查    询");
		JLabel lab3 = new JLabel("默认提前十天提醒");
		btn.addActionListener(new TodayPassDateAction(this));
		northPane.add(lab);
		northPane.add(spNafield);
		northPane.add(lab1);
		northPane.add(comBox);
		northPane.add(spDayNum);
		northPane.add(lab2);
		northPane.add(btn);
		northPane.add(lab3);
		
		downPane.add(northPane,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		guoQiMO = new AllTableModel(data,TableCulomnModel.TodayColumnName3);
		spGuoQitable = new JTable(guoQiMO);
		spGuoQitable.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		tablePane.setOpaque(true);
		tablePane.add(new JScrollPane(spGuoQitable),BorderLayout.CENTER);
		
		spGuoQitable.setAutoCreateRowSorter(true);
		
		downPane.add(new JScrollPane(tablePane));
		
		splitPane.setRightComponent(downPane);
		splitPane.setDividerLocation(70);
		splitPane.setDividerSize(0);
		pane.add(splitPane,BorderLayout.CENTER);
		
		return pane;
		
	}
	
	public static void main(String [] args){
		new RemaindDialog((JFrame)null,"库存报警",true).setVisible(true);
	}
	
}
