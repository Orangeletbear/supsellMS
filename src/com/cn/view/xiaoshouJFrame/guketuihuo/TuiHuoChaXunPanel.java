package com.cn.view.xiaoshouJFrame.guketuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.JDatePicker;

/**
 * 
 * 初始化顾客退货对话框上的退货查询面板
 * @author Administrator
 *
 */
public class TuiHuoChaXunPanel extends JPanel {
	
	//退货查询面板的高级查询按钮
	private JButton chaXunButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//退货查询面板的查看单据按钮
	private JButton chaKanButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//退货查询面板的导出按钮
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//退货查询面板的退出按钮
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
    //两个时间
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	//查看时间按钮
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//客户文本框
	private JTextField keHuText = new JTextField(10);
	//查询按钮
	private JButton chaXun = new JButton("查询(F2)");
	
	private JRadioButton danJuBiao = new JRadioButton("单据表");
	
	//第一个表格
	private JTable danJuTable;
	
	//第二个表格
	
	private JTable xiangXiTable ;
	
	
	private JLabel information = new JLabel("");
	
	public TuiHuoChaXunPanel() {
		init();
	}
	
	/**
	 * 初始化退货查询面板
	 */
	public void init(){
		
		this.setLayout(new BorderLayout());
		this.add(createNorthPanel(),BorderLayout.NORTH);
		this.add(createCenterPanel1(),BorderLayout.CENTER);
	
	}
	
	/**
	 * 退货查询面板的北部面板上组件的布局
	 * @return 北部面板
	 */
	public JPanel createNorthPanel(){
		JPanel northPanel = new JPanel();
		FlowLayout layout =new FlowLayout(FlowLayout.LEFT,25,3);
		northPanel.setLayout(layout);
		
		chaXunButton.setMargin(new Insets(0,0,0,0));
		chaKanButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		northPanel.add(chaXunButton);
		northPanel.add(chaKanButton);
		northPanel.add(daoChuButton);
		northPanel.add(tuiChuButton);
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 System.exit(2);
			}
			
		});
		
		JPanel panel1 = new JPanel();
		Box box1 = new Box(BoxLayout.X_AXIS);
		box1.add(new JLabel("开单日期: "));
		box1.add(dataPicker1);
		box1.add(new JLabel(" 至   "));
		box1.add(dataPicker2);
		shiJianButton.setMargin(new Insets(0,0,0,0));
		box1.add(shiJianButton);
	
		Box box2 = new Box(BoxLayout.X_AXIS);
		box2.add(new JLabel("客户/单据号:"));
		box2.add(keHuText);
		box2.add(chaXun);
		
		panel1.setLayout(new GridLayout(2,1,10,10));
		panel1.add(box1);
		panel1.add(box2);
		
		JPanel panel2 = new JPanel();
        panel2.setBorder(new LineBorder(Color.GRAY));
        panel2.setLayout(new GridLayout(3,1));
		ButtonGroup group = new ButtonGroup();
		group.add(danJuBiao);
		danJuBiao.setSelected(true);
		
		northPanel.add(panel1);
		northPanel.add(panel2);
		return northPanel;
	}
	
	/**
	 * 退货查询面板的中间面板上组件的布局
	 * @return 中间面板
	 */
	public JPanel createCenterPanel1(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("单据的详细信息:"));
		panel2.add(information);
		
		panel.add(panel2,BorderLayout.NORTH);
		
		JPanel center = new JPanel();
	    xiangXiTable = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.DanJuColumnNames);
		JScrollPane scroll = new JScrollPane(xiangXiTable);
		xiangXiTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		xiangXiTable.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
		center.add(scroll);
		panel.add(center,BorderLayout.CENTER);
		
	
		JPanel center2 = new JPanel();
	    danJuTable = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.QueryColumnNames);
		JScrollPane scroll2 = new JScrollPane(danJuTable);
		danJuTable.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		danJuTable.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
		center2.add(scroll2);
		
		
		centerPanel.add(center2);
		centerPanel.add(panel);
		return centerPanel;
	}
	
	
	//测试类
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750,500);
		f.add(new TuiHuoChaXunPanel());
		f.setVisible(true);
	}
}
