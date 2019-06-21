package com.cn.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.toolbar.DanJuFindBtnAction;
import com.cn.control.toolbar.DanJuTableSelectAction;
import com.cn.model.AllTableModel;
/*
 * 主界面上的单据查询按钮对话框
 */
public class DanJuFindDialog extends JDialog {
	
	JCheckBox box = new JCheckBox("查询销售单备注");
	
	JLabel lblab = new JLabel("输入单据号: ");
	//单据号输入框
	JTextField lbField = new JTextField(15);
	//主表列名
	JTable table;
	
	AllTableModel tabelModel  = new AllTableModel(TableCulomnModel.obj,
			TableCulomnModel.TodayColumnName1);
	
	//副表列名
	JTable table2;
	AllTableModel tabelModel1  = new AllTableModel(TableCulomnModel.obj,
			TableCulomnModel.DangJuFindColumnName1);
	
	
	public JTable getTable() {
		return table;
	}

	public JTable getTable2() {
		return table2;
	}

	public JCheckBox getBox() {
		return box;
	}

	public JTextField getLbField() {
		return lbField;
	}

	public DanJuFindDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
	}

	/*
	 * 对话框布局初使化
	 */
	private void init(){
		this.setSize(new Dimension(850,550));
        this.add(createPane());
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
        /*table.requestFocus();
        table.setRowSelectionInterval(0,0);*/
        this.setVisible(true);
	}
	/*
	 * 中间面板的加入
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		mainPane.add(initNorthPane(),BorderLayout.NORTH);
		//表格面板建立
		JPanel centerPane = createCenterPane();
	    
		mainPane.add(centerPane);

		return mainPane;
	}
	/*
	 * 北面工具栏按钮
	 */
	private JPanel initNorthPane(){
		JPanel pane = new JPanel();

		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DanJuFindDialog.this.dispose();
			}
			
		});
		
		JButton findDangju = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		findDangju.setMargin(new Insets(0,0,0,0));
		
		JLabel lab = new JLabel("可查出采购进货单，采购退货单，销售单，销售退货单的详细信息,支持模糊查询");
		lab.setFont(new Font("",Font.PLAIN,17));
		lab.setPreferredSize(new Dimension(600,70));
		lab.setForeground(Color.red);
        
		pane.add(findDangju);
		pane.add(exit);
		pane.add(lab);

		return pane;
	}
	/*
	 * 中心面板的建立
	 */
	private JPanel createCenterPane(){
		
		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		JButton findbtn = new JButton("查    询");
		findbtn.addActionListener(new DanJuFindBtnAction(this));
        findbtn.setToolTipText("空查询则查出所有");
		northPane.add(box);
		northPane.add(lblab);
		northPane.add(lbField);
		northPane.add(findbtn);
		
		downPane.add(northPane,BorderLayout.NORTH);
		//表格面板
		JPanel tablePane = new JPanel();
		tablePane.setLayout(new GridLayout(2,1));
        
		//JPanel tmp = new JPanel();
		//tmp.setLayout(new BorderLayout());
		//新建一个表格
		table = new JTable(tabelModel);
		//表格固定大小
		table.setPreferredScrollableViewportSize(new Dimension(1000, 150));		
		table.setAutoCreateRowSorter(true);
		//tmp.add(new JScrollPane(table));
		JPanel pane2 = new JPanel();
		pane2.setLayout(new BorderLayout());
		pane2.setBorder(new TitledBorder("详细内容"));
	    table.addMouseListener(new DanJuTableSelectAction(this));
        //表2
		table2 = new JTable(tabelModel1);
		//加边框
		
		//表格固定大小
		table2.setPreferredScrollableViewportSize(new Dimension(750,150));
		pane2.add(new JScrollPane(table2));
		table2.setFont(new Font("宋体",Font.PLAIN,17));
		table2.setRowHeight(25);
		table2.setAutoCreateRowSorter(true);
		//加一个滚动条
		tablePane.add(new JScrollPane(table));
		tablePane.add(new JScrollPane(pane2));
		
		downPane.add(new JScrollPane(tablePane));

		return downPane;
	}

	public AllTableModel getTabelModel() {
		return tabelModel;
	}

	public AllTableModel getTabelModel1() {
		return tabelModel1;
	}

	public static void main(String[] args) {
		new DanJuFindDialog((JFrame)null,"ff",true);
	}

}
