package com.cn.view.xiaoshouJFrame.guketuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.JDatePicker;


/**
 * 
 * 初始化退货对话框上的顾客退货选项卡上的面板
 * @author Administrator
 *
 */

public class GuKeTuiHuoPanel extends JPanel{

    private JPanel mainPanel = new JPanel();
	
	//顾客退货选项卡的顾客退货标签
	private JLabel topicLabel  = new JLabel("顾客退货");
	//顾客退货选项卡的单号标签
	private JLabel danHaoLabel = new JLabel("单号:XT101013010001");
	//客户名称标签
	private JLabel nameLabel = new JLabel("客户名称:");
	//客户文本框
	private JTextField  keHuText = new JTextField(10);
	//查询客户按钮
	private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//收货仓库标签
	private JLabel shouHuoCangKuLabel = new JLabel("收货仓库:");
	//仓库Box
	private JComboBox cangKuBox = new JComboBox(new String[]{"主仓库"});
	//销售日期标签
	private JLabel riQiLabel = new JLabel("销售日期:");
	//时间
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//添加退货商品按钮
	private JButton addButton = new JButton("添加退货商品(F2)");
	//添加退货商品按钮
	private JButton alterButton = new JButton("修改商品(F3)");
	//添加退货商品按钮
	private JButton deleteButton = new JButton("删除商品(F4)");
	//整单退货按钮
	private JButton tuiHuoButton = new JButton("整单退货(F7)");
	
	//定义面板下部的组件

    private JTable table;
	
	//应退金额标签
	private JLabel yingTuiMoneyLabel = new JLabel("应退金额:");
	//应退金额文本框
	private JTextField yingTuiText = new JTextField(10);
	//实收金额标签
	private JLabel shiTuiMoneyLabel = new JLabel("实退金额:");
	//实收金额文本框
	private JTextField shiTuiText = new JTextField(10);
	//经办人标签
	private JLabel jingBanRenLabel = new JLabel("经办人:");
	//经办人Box
	private JComboBox jingBanBox = new JComboBox(new String[]{"小白","小李","增加经办人"});
	//查询经办人按钮
	private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
	//备注标签
	private JLabel beiZhuLabel = new JLabel("备注:");
	//备注文本框
	private JTextField beiZhuText = new JTextField(20);
	//查看备注按钮
	private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
	//确定按钮
	private JButton sureButton = new JButton("确定");
	//退出按钮
	private JButton tuiChuButton = new JButton("退出");
	
	public GuKeTuiHuoPanel() {
		init();
		
	}
	
	public void init() {
	
		initMainPanel();
		this.add(mainPanel);
		this.setVisible(true);
		
	}
	
	/**
	 * 初始化顾客退货选项卡上的主面板
	 */
	public void initMainPanel(){
		JPanel northPane = new JPanel();
		northPane.add(new JLabel("                                     "));
		northPane.add(topicLabel);
		northPane.add(new JLabel("                                  "));
        danHaoLabel.setForeground(Color.RED);
		northPane.add(danHaoLabel);
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPane,BorderLayout.NORTH);
		mainPanel.add(createNorthPane(),BorderLayout.CENTER);
		
		
	}
	/**
	 * 北部面板上组件的布局
	 * @return  北部面板
	 */
	public JPanel createNorthPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel northPane = new JPanel();
		
		northPane.setBorder(new LineBorder(Color.GRAY));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT,20,3);
		
		northPane.setLayout(layout);
		northPane.add(nameLabel);
		northPane.add(keHuText);
		keHuButton.setMargin(new Insets(0,0,0,0));
		northPane.add(keHuButton);
		northPane.add(shouHuoCangKuLabel);
		northPane.add(cangKuBox);
		northPane.add(riQiLabel);
		northPane.add(dataPicker1);
		
		JPanel southPane = new JPanel();
		southPane.setBorder(new LineBorder(Color.GRAY));
		southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPane.add(beiZhuLabel);
		southPane.add(beiZhuText);
		beiZhuButton.setMargin(new Insets(0,0,0,0));
		southPane.add(beiZhuButton);
	    southPane.add(new JLabel("                               " +
	    		"                                              "));
		southPane.add(sureButton);
		southPane.add(tuiChuButton);
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 System.exit(2);
			}
			
		});
		
		pane.add(northPane,BorderLayout.NORTH);
		pane.add(createCenterPane (),BorderLayout.CENTER);
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	/**
	 * 顾客退货选项卡上的中间面板的组件的布局
	 * @return 中间面板
	 */
	public JPanel createCenterPane () {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.add(addButton);
		northPanel.add(alterButton);
		northPanel.add(deleteButton);
		northPanel.add(tuiHuoButton);
		
		
		JPanel southPanel = new JPanel();
		
		southPanel.setBorder(new LineBorder(Color.GRAY));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(15);
		southPanel.setLayout(layout);
		southPanel.add(yingTuiMoneyLabel);
		southPanel.add(yingTuiText);
		southPanel.add(shiTuiMoneyLabel);
		southPanel.add(shiTuiText);
		southPanel.add(jingBanRenLabel);
		southPanel.add(jingBanBox);
		jingBanButton.setMargin(new Insets(0,0,0,0));
		southPanel.add(jingBanButton);
		southPanel.add(new JLabel("                    "));
		
		
		JPanel centerPanel = new JPanel();
		table = new JTable(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.BackColumNames);
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
		centerPanel.add(scroll);
		
		pane.add(northPanel,BorderLayout.NORTH);
		pane.add(centerPanel,BorderLayout.CENTER);
		pane.add(southPanel,BorderLayout.SOUTH);
		
		return pane;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750,660);
		
		f.add(new GuKeTuiHuoPanel());
		f.setVisible(true);
	}

}

