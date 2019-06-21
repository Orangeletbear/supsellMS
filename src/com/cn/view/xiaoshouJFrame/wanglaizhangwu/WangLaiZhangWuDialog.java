package com.cn.view.xiaoshouJFrame.wanglaizhangwu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.util.JDatePicker;


/**
 * 往来账务（客户）对话框
 * @author Administrator
 *
 */
public class WangLaiZhangWuDialog extends JDialog {
  //panel1	客户商所有单据
	//north 组件
	
	//第一个选项卡上的我方付款按钮
	private JButton woFangFuKuan = new JButton(new ImageIcon("res/AcionIcon/wofangFuKuang.jpg"));
	//第一个选项卡上的查看单据按钮
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//第一个选项卡上的删除单据按钮
	private JButton ShanChuDanJu = new JButton(new ImageIcon("res/AcionIcon/deleteDanJu.jpg"));
	//第一个选项卡上的整单退货按钮
	private JButton zhengDanTuiHuo = new JButton(new ImageIcon("res/AcionIcon/zhengDantuihuo.jpg"));
	//第一个选项卡上的单据过滤按钮
	private JButton danJuGuoLv = new JButton(new ImageIcon("res/AcionIcon/zhengdanguolv.jpg"));
	//第一个选项卡上的导出按钮
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第一个选项卡上的打印按钮
	private JButton daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第一个选项卡上的退出按钮
	private JButton tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	
	//center 组件
	//日期
	private JDatePicker chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	//第一个选项卡上的客户名称文本框
	private JTextField keHuMingCheng = new JTextField(12);
	//查看日期的按钮
	private JButton riQi = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//查询客户的按钮
	private JButton fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//查询按钮
	private JButton chaXun = new JButton("查询");
	//日期
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	private JRadioButton anRiQiPaiXu = new JRadioButton("按日期排序");
	//第一个选项卡上的表
	private Vector table1_data = new Vector();//table 数据
	private Vector<String> table1_columnNames = new Vector<String>();//table 列名
	//south 组件
	private Vector table2_data = new Vector();//table 数据
	private Vector<String> table2_columnNames = new Vector<String>();//table 列名
	private Vector table3_data = new Vector();//table 数据
	private Vector<String> table3_columnNames = new Vector<String>();//table 列名
	
	
  //panel2 客户消费情况表
	//panel2_north
	//第二个选项卡上的高级查询按钮
	private JButton panel2_north_gaoJiChaXun = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	//第二个选项卡上的导出按钮
	private JButton panel2_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第二个选项卡上的打印按钮
	private JButton panel2_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第二个选项卡上的退出按钮
	private JButton panel2_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel2_center

	//两个日期
	private JDatePicker panel2_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker panel2_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	//查询时间的按钮
	private JButton panel2_center_RIQI = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//查询客户的文本框
	private JTextField panel2_center_keHuMingCheng = new JTextField(12);
	//查询客户的按钮
	private JButton panel2_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//查询按钮
	private JButton panel2_center_chaXun = new JButton("查询");
	
	private JRadioButton panel2_center_huiZongBiao = new JRadioButton("汇总表");
	
	//汇总表
	private Vector huiZongBiao_data = new Vector();//table 数据
	private Vector<String> huiZongBiao_columnNames = new Vector<String>();//table 列名
	private JLabel shangPinMingXiLabel = new JLabel(" ");
	//明细表
	private Vector mingXiBiao_data = new Vector();//table 数据
	private Vector<String> mingXiBiao_columnNames = new Vector<String>();//table 列名

 //客户账务
	//panel3_north
	//第三个选项卡上的导出按钮
	private JButton panel3_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第三个选项卡上的打印按钮
	private JButton panel3_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第三个选项卡上的退出按钮
	private JButton panel3_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel3_center
	
	//第三个选项卡上的客户名称文本框
	private JTextField panel3_center_keHuMingCheng = new JTextField(12);
	//第三个选项卡上查找客户的按钮
	private JButton panel3_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//查询按钮
	private JButton panel3_center_chaXun = new JButton("查询");
	
	private Vector panel3_data = new Vector();//table 数据
	private Vector<String> panel3_columnNames = new Vector<String>();//table 列名
	
	
  //我方付款明细
	//panel4_north
	//第四个选项卡的查看单据按钮
	private JButton panel4_north_chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//第四个选项卡的导出按钮
	private JButton panel4_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//第四个选项卡的打印按钮
	private JButton panel4_north_daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//第四个选项卡的退出按钮
	private JButton panel4_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	//panel4_center
	
	//两个时间
	private JDatePicker panel4_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker panel4_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	
	//第四个选项卡的查询日期按钮
	private JButton panel4_center_RIQI = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//第四个选项卡的客户名称文本框
	private JTextField panel4_center_keHuMingCheng = new JTextField(12);
	//第四个选项卡的查询客户按钮
	private JButton panel4_center_fangDa = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
	//查询按钮
	private JButton panel4_center_chaXun = new JButton("查询");
	private Vector panel4_data = new Vector();//table 数据
	private Vector<String> panel4_columnNames = new Vector<String>();//table 列名
	
	public WangLaiZhangWuDialog(JDialog parent,String title,boolean model){
		super(parent,title,model);
		init();
	}
	public WangLaiZhangWuDialog(JFrame parent,String title,boolean model){
		super(parent,title,model);
		init();
	}
	private void init(){
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);////////////////////////////////////////////////////////
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("客户所有单据", panel1());
		tab.addTab("客户消费情况",panel2());
		tab.addTab("客户账务信息", gongHuoShangZhangWu());
		tab.addTab("客户付款明细", woFangFuKuanMingXi());
		
		
		this.add(tab);
		this.setVisible(true);
		
	}
// tab1客户所有单据
	private JPanel panel1(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		panel1.add(panel1_north(),BorderLayout.NORTH);
		panel1.add(panel1_center(),BorderLayout.CENTER);
		panel1.add(panel1_south(),BorderLayout.SOUTH);
		
		return panel1;
	}
	//panel1_north
	private JPanel panel1_north(){
		JPanel panel1_north = new JPanel();
		panel1_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		//设置button内边距
		woFangFuKuan.setMargin(new Insets(0,0,0,0));
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		ShanChuDanJu.setMargin(new Insets(0,0,0,0));
		zhengDanTuiHuo.setMargin(new Insets(0,0,0,0));
		danJuGuoLv.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		daYin.setMargin(new Insets(0,0,0,0));
		tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel1_north.add(woFangFuKuan);
		panel1_north.add(chaKanDanJu);
		panel1_north.add(ShanChuDanJu);
		panel1_north.add(zhengDanTuiHuo);
		panel1_north.add(danJuGuoLv);
		panel1_north.add(daoChu);
		panel1_north.add(daYin);
		panel1_north.add(tuiChu);
		tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel1_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		return panel1_north;
	}
	//panel1_center再分成两个子pane1和pane2
	private JPanel panel1_center(){
		JPanel panel1_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
	  //pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane1.add(new JLabel("查询时间:"));
		pane1.add(chaXunShiJian);
		pane1.add(new JLabel("至"));
		pane1.add(zhi);
		
		riQi.setMargin(new Insets(0,0,0,0));
		pane1.add(riQi);
		pane1.add(new JLabel("客户名称:"));
		pane1.add(keHuMingCheng);
		fangDa.setMargin(new Insets(0,0,0,0));//设置内边距
		pane1.add(fangDa);
		pane1.add(chaXun);
		//checkBox 变单选
		
		pane1.add(anRiQiPaiXu);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
	  //pane2
		table1_columnNames.add("客户名称");
		table1_columnNames.add( "日期");
		table1_columnNames.add("单号");
		table1_columnNames.add("类型");
		table1_columnNames.add("应付金额");
		table1_columnNames.add("实付金额");
		table1_columnNames.add("欠款金额");
		table1_columnNames.add("优惠金额");
		table1_columnNames.add("经办人");
		table1_columnNames.add("操作员");
		JTable table1 = new JTable(table1_data,table1_columnNames);
		table1.setAutoCreateRowSorter(true);
		//表格固定大小
		table1.setPreferredScrollableViewportSize(new Dimension(880,220));
		
		pane2.add(new JScrollPane(table1));
		pane2.setBorder(new TitledBorder("往来账务列表:"));
	  //panel1_center
		panel1_center.setLayout(new BorderLayout());
		panel1_center.add(pane1,BorderLayout.NORTH);
		panel1_center.add(pane2,BorderLayout.CENTER);
		
		return panel1_center;
	}
	//panel1_south
	private JPanel panel1_south(){
		JPanel panel1_south = new JPanel();
		JLabel label1 = new JLabel("单据详细信息 : ");
		JLabel label2 = new JLabel("往来账务信息包括：销售单，退货单及付款单信息");
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		
		
		table2_columnNames.add("商品编号");
		table2_columnNames.add( "商品名称");
		table2_columnNames.add("单位");
		table2_columnNames.add("单价");
		table2_columnNames.add("数量");
		table2_columnNames.add("总金额");
		table2_columnNames.add("规格型号");
		table2_columnNames.add("颜色");
		JTable table2 = new JTable(table2_data,table2_columnNames);
		table2.setAutoCreateRowSorter(true);
		table2.setPreferredScrollableViewportSize(new Dimension(880,90));//表格固定大小
		
		
		table3_columnNames.add("客户名称");
		table3_columnNames.add( "日期");
		table3_columnNames.add("单号");
		table3_columnNames.add("类型");
		table3_columnNames.add("收款金额");
		table3_columnNames.add("经办人");
		table3_columnNames.add("操作员");
		table3_columnNames.add("备注");
		JTable table3 = new JTable(table3_data,table3_columnNames);
		table3.setAutoCreateRowSorter(true);
		table3.setPreferredScrollableViewportSize(new Dimension(880,90));//表格固定大小
		
		pane1.add(new JScrollPane(table2));
		pane2.add(new JScrollPane(table3));
		
		//south 由两个tabbedPane组成
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("单据商品信息", pane1);
		tab.addTab("单据付款信息",pane2);
		tab.setPreferredSize(new Dimension(880,125));//设置tab的大小
		
		panel1_south.setLayout(new BorderLayout());
		panel1_south.add(label1,BorderLayout.NORTH);
		panel1_south.add(tab,BorderLayout.CENTER);
		panel1_south.add(label2,BorderLayout.SOUTH);
		return panel1_south;
	}
	
	
// tab2	客户消费情况
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new BorderLayout());
		panel2.add(panel2_north(),BorderLayout.NORTH);
		panel2.add(panel2_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("");
		panel2.add(label,BorderLayout.SOUTH);
		
		return panel2;
	}
	//panel2_north
	private JPanel panel2_north(){
		JPanel panel2_north = new JPanel();
		
		panel2_north_gaoJiChaXun.setMargin(new Insets(0,0,0,0));
		panel2_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel2_north_daYin.setMargin(new Insets(0,0,0,0));
		panel2_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel2_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel2_north.add(panel2_north_gaoJiChaXun);
		panel2_north.add(panel2_north_daoChu);
		panel2_north.add(panel2_north_daYin);
		panel2_north.add(panel2_north_tuiChu);
		panel2_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel2_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		return panel2_north;
	}
	//panel2_center 分为两部分
	private JPanel panel2_center(){
		JPanel panel2_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		pane2.setBorder(new TitledBorder("商品销售汇总"));
		//pane1
	
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,15,2));
		pane1.add(new JLabel("查询时间 :"));
		pane1.add(panel2_center_chaXunShiJian);
		pane1.add(new JLabel("至 "));
		pane1.add(panel2_center_zhi);
		panel2_center_RIQI.setMargin(new Insets(0,0,0,0));
		pane1.add(panel2_center_RIQI);
		pane1.add( new JLabel("客户名称 :"));
		pane1.add(panel2_center_keHuMingCheng);
		panel2_center_fangDa.setMargin(new Insets(0,0,0,0));//设置内边距
		pane1.add(panel2_center_fangDa);
		pane1.add(panel2_center_chaXun);
		//checkBox
		
		pane1.add(panel2_center_huiZongBiao);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		//pane2
		huiZongBiao_columnNames.add("商品编号");
		huiZongBiao_columnNames.add( "商品名称");
		huiZongBiao_columnNames.add("单位");
		huiZongBiao_columnNames.add("销售数量");
		huiZongBiao_columnNames.add("销售总金额");
		huiZongBiao_columnNames.add("规格型号");
		huiZongBiao_columnNames.add("颜色");
		huiZongBiao_columnNames.add("生产厂商");
		huiZongBiao_columnNames.add("备注");
		
		//明细表的列名
		mingXiBiao_columnNames.add("客户名称");
		mingXiBiao_columnNames.add( "单据号");
		mingXiBiao_columnNames.add("开单日期");
		mingXiBiao_columnNames.add( "单位");
		mingXiBiao_columnNames.add("单价");
		mingXiBiao_columnNames.add("数量");
		mingXiBiao_columnNames.add("总金额");
		mingXiBiao_columnNames.add("规格型号");
		mingXiBiao_columnNames.add("颜色");
		
		JTable table1 = new JTable(huiZongBiao_data,huiZongBiao_columnNames);
		table1.setPreferredScrollableViewportSize(new Dimension(880,356));//表格固定大小
		JTable table2 = new JTable(mingXiBiao_data,mingXiBiao_columnNames);
		table2.setPreferredScrollableViewportSize(new Dimension(880,356));//表格固定大小
		
		pane3.setLayout(new BorderLayout());
		JPanel pane4 = new JPanel();
		pane4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane4.add(new JLabel("商品销售明细:"));
		pane4.add(shangPinMingXiLabel);
		pane3.add(pane4,BorderLayout.NORTH);
		pane3.add(new JScrollPane(table2));
		
		
		pane2.add(new JScrollPane(table1));
		pane2.add(pane3);
		
		
		panel2_center.setLayout(new BorderLayout());
		panel2_center.add(pane1,BorderLayout.NORTH);
		panel2_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel2_center;
	}
	


// tab3		
	private JPanel gongHuoShangZhangWu(){
		JPanel gongHuoShangZhangWu = new JPanel();
		
		gongHuoShangZhangWu.setLayout(new BorderLayout());
		gongHuoShangZhangWu.add(panel3_north(),BorderLayout.NORTH);
		gongHuoShangZhangWu.add(panel3_center(),BorderLayout.CENTER);
		return gongHuoShangZhangWu;
	}
	//
	//panel3_north
	private JPanel panel3_north(){
		JPanel panel3_north = new JPanel();
		
		panel3_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel3_north_daYin.setMargin(new Insets(0,0,0,0));
		panel3_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel3_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel3_north.add(panel3_north_daoChu);
		panel3_north.add(panel3_north_daYin);
		panel3_north.add(panel3_north_tuiChu);
		panel3_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	dispose();
			}
			
		});
		panel3_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		return panel3_north;
	}
	//panel3_center 分为两部分
	private JPanel panel3_center(){
		JPanel panel3_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.add(new JLabel("客户名称："));
		pane1.add(panel3_center_keHuMingCheng);
		panel3_center_fangDa.setMargin(new Insets(0,0,0,0));//设置内边距
		pane1.add(panel3_center_fangDa);
		pane1.add(panel3_center_chaXun);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		//pane2
		panel3_columnNames.add("客户消费商品情况");
		panel3_columnNames.add( "客户账务情况");
		panel3_columnNames.add("客户名称");
		panel3_columnNames.add("商品销售额");
		panel3_columnNames.add("商品退货额");
		panel3_columnNames.add("合计金额");
		panel3_columnNames.add("我方应收金额");
		panel3_columnNames.add("我方实收金额");
		panel3_columnNames.add("未收金额");
		
		JTable table = new JTable(panel3_data,panel3_columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(880,356));//表格固定大小
		pane2.add(new JScrollPane(table));
		
		panel3_center.setLayout(new BorderLayout());
		panel3_center.add(pane1,BorderLayout.NORTH);
		panel3_center.add(pane2,BorderLayout.CENTER);
		
		return panel3_center;
	}
	
// tab4
	private JPanel woFangFuKuanMingXi(){
		JPanel woFangFuKuanMingXi = new JPanel();
		
		woFangFuKuanMingXi.setLayout(new BorderLayout());
		woFangFuKuanMingXi.add(panel4_north(),BorderLayout.NORTH);
		woFangFuKuanMingXi.add(panel4_center(),BorderLayout.CENTER);
		return woFangFuKuanMingXi;
	}
	//
	//panel4_north
	private JPanel panel4_north(){
		JPanel panel4_north = new JPanel();
		
		panel4_north_chaKanDanJu.setMargin(new Insets(0,0,0,0));
		panel4_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel4_north_daYin.setMargin(new Insets(0,0,0,0));
		panel4_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel4_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel4_north.add(panel4_north_chaKanDanJu);
		panel4_north.add(panel4_north_daoChu);
		panel4_north.add(panel4_north_daYin);
		panel4_north.add(panel4_north_tuiChu);
		panel4_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	dispose();
			}
			
		});
		panel4_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		return panel4_north;
	}
	//panel4_center 分为两部分
	private JPanel panel4_center(){
		JPanel panel4_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("查询时间 :"));
		pane1.add(panel4_center_chaXunShiJian);
		pane1.add(new JLabel("至 "));
		pane1.add(panel4_center_zhi);
		panel4_center_RIQI.setMargin(new Insets(0,0,0,0));
		pane1.add(panel4_center_RIQI);
		pane1.add(new JLabel("客户名称 :"));
		pane1.add(panel4_center_keHuMingCheng);
		panel4_center_fangDa.setMargin(new Insets(0,0,0,0));//设置内边距
		pane1.add(panel4_center_fangDa);
		pane1.add(panel4_center_chaXun);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		//pane2
		panel4_columnNames.add("单据编号");
		panel4_columnNames.add( "单据日期");
		panel4_columnNames.add("收款方式/类型");
		panel4_columnNames.add("收款金额");
		panel4_columnNames.add("客户名称");
		panel4_columnNames.add("经办人");
		panel4_columnNames.add("操作员");
		panel4_columnNames.add("备注 ");
		
		
		JTable table = new JTable(panel4_data,panel4_columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(880,356));//表格固定大小
		pane2.add(new JScrollPane(table));
		
		panel4_center.setLayout(new BorderLayout());
		panel4_center.add(pane1,BorderLayout.NORTH);
		panel4_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel4_center;
	}
	

	public static void main(String[] args){
		
	}
	
	
}
