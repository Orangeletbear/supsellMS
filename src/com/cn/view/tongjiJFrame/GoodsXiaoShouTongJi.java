package com.cn.view.tongjiJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.ShangPinXiaoShouTongJi.GongHuoListener;
import com.cn.control.tongjiframe.ShangPinXiaoShouTongJi.GongHuoMouseListener;
import com.cn.control.tongjiframe.ShangPinXiaoShouTongJi.KeHuListener;
import com.cn.control.tongjiframe.ShangPinXiaoShouTongJi.KeHuMouseListener;
import com.cn.control.tongjiframe.ShangPinXiaoShouTongJi.XiaoShouMingXiListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.FenXiDialog;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.GoodsGuoLvDialog;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.KeHuTongJiDialog;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.TongJiDialog;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.XiaoShouCheckDilog;

public class GoodsXiaoShouTongJi extends JDialog implements ActionListener {
	JLabel caiGouDate,zhi,shangPinKind,shangPingMing;
	/*
	 * 商品销售统计表选项卡中的组件
	 */
	JButton guoLu,checkDanJu,fenXi,daoChu,daYin,tuiChu,chaXun;
	JTabbedPane xiaoShouPane;
	JTable mingXiBiao,huiZongBiao,tongJiBiao;
	JDatePicker datePickerTo,datePickerTo1;
	JComboBox shangPinText;
	JTextField shangPinNameText;
	JLabel jiLu;
	
	/*
	 * 按供货商统计表选项卡中的组件
	 */
	JButton checkDanJu1,daoChu1,daYin1,tuiChu1,chaXun1;
	JTextField gongHuoText;
	JComboBox shangPinText1;
	JDatePicker datePickerTo2,datePickerTo3;
	JLabel jiLu1,gongHuoShangXinXi;
	/*
	 * 按客户统计表选项卡中的组件
	 */
	JButton checkDanJu2,daoChu2,daYin2,tuiChu2,chaXun2;
	JTextField keHuText;
	JComboBox shangPinText2;
	JDatePicker datePickerTo4,datePickerTo5; 
	JLabel jiLu2;
	
	JLabel keHuShu,keHuXinXi;
	
	JTabbedPane mainJTabbedPane;
	JTable gongHuoBiao,gongHuoXiBiao,keHuBiao,keHuXiBiao;
	DefaultTableModel dtm1,dtm2,dtm3,dtm4,dtm5,dtm6,dtm7;
	
	/**
	 * 改方法创建了一个JDialog窗口，窗口中有三个选项卡，分别是商品销售统计表，按供货商统计，
	 * 按客户统计。其中商品销售统计表选项卡中包括6个按钮，一个查找栏，和三个选项卡，分别是
	 * 商品销售明细表，商品销售汇总表，销售商品分类统计表。按供货商统计选项卡中包括4个按钮
	 * 一个查找栏和两个JTable，按客户统计选项卡中包括4个按钮，一个查找栏和两个JTable。
	 * @param title
	 */
	 public GoodsXiaoShouTongJi(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
    private void init(){
   	 this.setSize(850, 500);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null); //主界面的设置
		 //JPanel jp=new JPanel();
		 //jp.setLayout(new BorderLayout());
		 /*
		  * 商品销售统计表选项卡中JButton的实例与添加
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 guoLu=new JButton(new ImageIcon("res\\AcionIcon\\guoLv.jpg"));
		 guoLu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(guoLu);
		 checkDanJu=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(checkDanJu);
		 fenXi=new JButton(new ImageIcon("res\\AcionIcon\\dangpinfenxi.jpg"));
		 fenXi.setMargin(new Insets(0,0,0,0));
		 buttonP.add(fenXi);
		 daoChu=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daoChu);
		 daYin=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daYin);	
		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(tuiChu);
		 /*
		  * 商品销售统计表选项卡中查找栏的实例与添加
		  */
		 caiGouDate=new JLabel("采购时间");
		 zhi=new JLabel("至");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo1= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 shangPinKind=new JLabel("商品类别");
		 shangPingMing=new JLabel("商品名称或编号");
		 shangPinText=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinText.addItem("所有类别");
		 shangPinText.setSelectedItem("所有类别");
		 shangPinNameText=new JTextField(10);
		 chaXun=new JButton("查询");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo);
		 northP.add(zhi);
		 northP.add(datePickerTo1);
		 northP.add(shangPinKind);
		 northP.add(shangPinText);
		 northP.add(shangPingMing);
		 northP.add(shangPinNameText);
		 northP.add(chaXun);
		 /*
		  * 商品销售统计表选项卡中三个选项卡的实例与添加
		  */
		 dtm1=new AllTableModel(tongJiModel.dtm1Column,tongJiModel.dtm1Names);
		 dtm2=new AllTableModel(tongJiModel.dtm2Column,tongJiModel.dtm2Names);
		 dtm3=new AllTableModel(tongJiModel.dtm3Column,tongJiModel.dtm3Names);
		 dtm1.isCellEditable(0, 0);
		 dtm2.isCellEditable(0, 0);
		 dtm3.isCellEditable(0, 0);
		 
		 JPanel scrollPane = new JPanel();
		 scrollPane.setLayout(new BorderLayout());
		 mingXiBiao=new JTable(dtm1);
		 huiZongBiao=new JTable(dtm2);
		 tongJiBiao=new JTable(dtm3);
		 mingXiBiao.setPreferredScrollableViewportSize(new Dimension(1500,600));
		 mingXiBiao.setAutoCreateRowSorter(true); //此语句让表格自动排序
		 scrollPane.add(new JScrollPane(mingXiBiao));
		 JScrollPane mingXiP=new JScrollPane(scrollPane,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 JScrollPane huiZongP=new JScrollPane(huiZongBiao);
		 JScrollPane tongJiP=new JScrollPane(tongJiBiao);
		 xiaoShouPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		 xiaoShouPane.add("销售商品明细表",mingXiP);
		 xiaoShouPane.add("销售商品汇总表",huiZongP);
		 xiaoShouPane.add("销售商品分类统计表",tongJiP);
		 
		 jiLu=new JLabel("记录数 ：");
		 jiLu.setForeground(Color.red);
    	 JPanel JLabelP=new JPanel();
    	 JLabelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 JLabelP.add(jiLu);
    	 
    	 JPanel mainP=new JPanel();
    	 mainP.setLayout(new BorderLayout());
    	 mainP.add(northP,BorderLayout.NORTH);
    	 mainP.add(xiaoShouPane,BorderLayout.CENTER);
    	 mainP.add(JLabelP,BorderLayout.SOUTH);
    	 
    	 
    	 JPanel cardP=new JPanel();
    	 cardP.setLayout(new BorderLayout());
    	 cardP.add(buttonP,BorderLayout.NORTH);
    	 cardP.add(mainP);
    	
    	 /*
    	  * 按供货商统计表选项卡的实例与添加
    	  */
    	 checkDanJu1=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu1.setMargin(new Insets(0,0,0,0));
		 daoChu1=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu1.setMargin(new Insets(0,0,0,0));
		 daYin1=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin1.setMargin(new Insets(0,0,0,0));
		 tuiChu1=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu1.setMargin(new Insets(0,0,0,0));
    	 JPanel buttonP1=new JPanel();
    	 buttonP1.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP1.setLayout(new FlowLayout(FlowLayout.LEFT));
		 buttonP1.add(checkDanJu1);
		 buttonP1.add(daoChu1);
		 buttonP1.add(daYin);
		 buttonP1.add(tuiChu1);
		 dtm4=new AllTableModel(tongJiModel.dtm4Column,tongJiModel.dtm4Names);
		 dtm4.isCellEditable(0, 0);
		 gongHuoBiao=new JTable(dtm4);
		 gongHuoBiao.setPreferredScrollableViewportSize(new Dimension(200,200));
		 JScrollPane js=new JScrollPane(gongHuoBiao);
		 JPanel j=new JPanel();
		 j.setLayout(new FlowLayout(FlowLayout.LEFT));
		 gongHuoShangXinXi=new JLabel("供货商商品销售明细");
		 gongHuoShangXinXi.setForeground(Color.red);
		 j.add(gongHuoShangXinXi);
		 JPanel p1=new JPanel();
		 p1.setLayout(new BorderLayout());
		 p1.add(j,BorderLayout.NORTH);
		 p1.add(addJPanel());
		 
		 JPanel p2=new JPanel();
		 p2.setLayout(new BorderLayout());
		 p2.add(xuanZeDan(),BorderLayout.NORTH);
		 p2.add(js);
		 
		 JPanel p3=new JPanel();
		 p3.setLayout(new BorderLayout());
		 
		 p3.add(buttonP1,BorderLayout.NORTH);
		 p3.add(p2,BorderLayout.CENTER);
		 p3.add(p1,BorderLayout.SOUTH);
		 
		 checkDanJu2=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu2.setMargin(new Insets(0,0,0,0));
		 daoChu2=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu2.setMargin(new Insets(0,0,0,0));
		 daYin2=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin2.setMargin(new Insets(0,0,0,0));
		 tuiChu2=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu2.setMargin(new Insets(0,0,0,0));
    	 JPanel buttonP2=new JPanel();
    	 buttonP2.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP2.setLayout(new FlowLayout(FlowLayout.LEFT));
		 buttonP2.add(checkDanJu2);
		 buttonP2.add(daoChu2);
		 buttonP2.add(daYin2);
		 buttonP2.add(tuiChu2);
		 /*
		  * 按客户统计表选项卡的实例与添加
		  */
		 dtm6=new AllTableModel(tongJiModel.dtm6Column,tongJiModel.dtm6Names);
		 dtm6.isCellEditable(0, 0);
		 keHuBiao=new JTable(dtm6);
		 keHuBiao.setPreferredScrollableViewportSize(new Dimension(200,200));
		 JScrollPane js1=new JScrollPane(keHuBiao);
		 JPanel j1=new JPanel();
		 j1.setLayout(new FlowLayout(FlowLayout.LEFT));
		 keHuXinXi=new JLabel("客户销售商品明细");
		 keHuXinXi.setForeground(Color.red);
		 j1.add(keHuXinXi);
		 JPanel p6=new JPanel();
		 p6.setLayout(new BorderLayout());
		 p6.add(j1,BorderLayout.NORTH);
		 p6.add(addJPanel1());
		 
		 JPanel p4=new JPanel();
		 p4.setLayout(new BorderLayout());
		 p4.add(xuanZeDannext(),BorderLayout.NORTH);
		 p4.add(js1);
		 
		 JPanel p5=new JPanel();
		 p5.setLayout(new BorderLayout());
		 
		 p5.add(buttonP2,BorderLayout.NORTH);
		 p5.add(p4,BorderLayout.CENTER);
		 p5.add(p6,BorderLayout.SOUTH);
		 
		 mainJTabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    	 mainJTabbedPane.add("商品销售统计表",cardP);
    	 mainJTabbedPane.add("按供货商统计",p3);
    	 mainJTabbedPane.add("按客户查询",p5);
         //jp.add(mainJTabbedPane);    
    	 /*
    	  * 添加监听器
    	  */
    	 chaXun.addActionListener(l);
    	 chaXun1.addActionListener(m);
    	 chaXun2.addActionListener(n);
    	 gongHuoBiao.addMouseListener(p);
    	 keHuBiao.addMouseListener(q);
    	 guoLu.addActionListener(this);
    	 checkDanJu.addActionListener(this);
    	 fenXi.addActionListener(this);
    	 checkDanJu1.addActionListener(this);
    	 checkDanJu2.addActionListener(this);
    	 daoChu.addActionListener(this);
    	 tuiChu.addActionListener(this);
    	 daoChu1.addActionListener(this);
    	 tuiChu1.addActionListener(this);
    	 daoChu2.addActionListener(this);
    	 tuiChu2.addActionListener(this);
    	 this.getContentPane().add(mainJTabbedPane);
    	 this.setVisible(true);
    }
    
    public ActionListener l=new XiaoShouMingXiListener(this);
    public ActionListener m=new GongHuoListener(this);
    public ActionListener n=new KeHuListener(this);
    public MouseListener p=new GongHuoMouseListener(this);
    public MouseListener q=new KeHuMouseListener(this);
    
    public JPanel addJPanel(){
    	dtm5=new AllTableModel(tongJiModel.dtm5Column,tongJiModel.dtm5Names);
    	dtm5.isCellEditable(0, 0);
    	gongHuoXiBiao=new JTable(dtm5);
    	gongHuoXiBiao.setPreferredScrollableViewportSize(new Dimension(200,100));
    	JScrollPane js=new JScrollPane(gongHuoXiBiao);
    	JPanel  jpl=new JPanel();
    	jpl.setLayout(new FlowLayout(FlowLayout.LEFT));
    	jiLu1=new JLabel("记录数：");
    	jiLu1.setForeground(Color.red);
    	jpl.add(jiLu1);
    	JPanel returnJPanel=new JPanel();
    	returnJPanel.setLayout(new BorderLayout());
    	returnJPanel.add(jpl,BorderLayout.SOUTH);
    	returnJPanel.add(js);
    	return returnJPanel;
    }
    public JPanel addJPanel1(){
    	dtm7=new AllTableModel(tongJiModel.dtm7Column,tongJiModel.dtm7Names);
    	dtm7.isCellEditable(0, 0);
    	keHuXiBiao=new JTable(dtm7);
    	keHuXiBiao.setPreferredScrollableViewportSize(new Dimension(200,100));
    	JScrollPane js=new JScrollPane(keHuXiBiao);
    	JPanel  jpl=new JPanel();
    	jpl.setLayout(new FlowLayout(FlowLayout.LEFT));
    	jiLu2=new JLabel("记录数：");
    	jiLu2.setForeground(Color.red);
    	jpl.add(jiLu2);
    	JPanel returnJPanel=new JPanel();
    	returnJPanel.setLayout(new BorderLayout());
    	returnJPanel.add(jpl,BorderLayout.SOUTH);
    	returnJPanel.add(js);
    	return returnJPanel;
    }
    /*
     * 按供货商统计表选项卡中查找栏的实例与添加
     */
    public JPanel xuanZeDan(){
    	 caiGouDate=new JLabel("查看日期");
		 zhi=new JLabel("至");
		 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo3= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 shangPinKind=new JLabel("商品类别");
		 shangPingMing=new JLabel("供货商名称");
		 shangPinText1=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinText1.addItem("所有类别");
		 shangPinText1.setSelectedItem("所有类别");
		 gongHuoText=new JTextField(10);
		 chaXun1=new JButton("查询");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo2);
		 northP.add(zhi);
		 northP.add(datePickerTo3);
		 northP.add(shangPinKind);
		 northP.add(shangPinText1);
		 northP.add(shangPingMing);
		 northP.add(gongHuoText);
		 northP.add(chaXun1);
		 return northP;
    }
    /*
     * 按客户统计表选项卡中查找栏的实例与添加
     */
    public JPanel xuanZeDannext(){
   	 caiGouDate=new JLabel("查看日期");
		 zhi=new JLabel("至");
		 datePickerTo4= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo5= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 shangPinKind=new JLabel("商品类别");
		 shangPingMing=new JLabel("客户名称");
		 shangPinText2=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinText2.addItem("所有类别");
		 shangPinText2.setSelectedItem("所有类别");
		 keHuText=new JTextField(10);
		 chaXun2=new JButton("查询");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo4);
		 northP.add(zhi);
		 northP.add(datePickerTo5);
		 northP.add(shangPinKind);
		 northP.add(shangPinText2);
		 northP.add(shangPingMing);
		 northP.add(keHuText);
		 northP.add(chaXun2);
		 return northP;
   }
    /*
     * 返回界面中的各组件
     */

	public JLabel getCaiGouDate() {
		return caiGouDate;
	}
	public JButton getChaXun() {
		return chaXun;
	}
	public JButton getChaXun1() {
		return chaXun1;
	}
	public JButton getChaXun2() {
		return chaXun2;
	}
	public JButton getCheckDanJu() {
		return checkDanJu;
	}
	public JButton getCheckDanJu1() {
		return checkDanJu1;
	}
	public JButton getCheckDanJu2() {
		return checkDanJu2;
	}
	public JButton getDaoChu() {
		return daoChu;
	}
	public JButton getDaoChu1() {
		return daoChu1;
	}
	public JButton getDaoChu2() {
		return daoChu2;
	}
	public JDatePicker getDatePickerTo() {
		return datePickerTo;
	}
	public JDatePicker getDatePickerTo1() {
		return datePickerTo1;
	}
	public JDatePicker getDatePickerTo2() {
		return datePickerTo2;
	}
	public JDatePicker getDatePickerTo3() {
		return datePickerTo3;
	}
	public JDatePicker getDatePickerTo4() {
		return datePickerTo4;
	}
	public JDatePicker getDatePickerTo5() {
		return datePickerTo5;
	}
	public JButton getDaYin() {
		return daYin;
	}
	public JButton getDaYin1() {
		return daYin1;
	}
	public JButton getDaYin2() {
		return daYin2;
	}
	public DefaultTableModel getDtm1() {
		return dtm1;
	}
	public DefaultTableModel getDtm2() {
		return dtm2;
	}
	public DefaultTableModel getDtm3() {
		return dtm3;
	}
	public DefaultTableModel getDtm4() {
		return dtm4;
	}
	public DefaultTableModel getDtm5() {
		return dtm5;
	}
	public DefaultTableModel getDtm6() {
		return dtm6;
	}
	public DefaultTableModel getDtm7() {
		return dtm7;
	}
	public JButton getFenXi() {
		return fenXi;
	}
	public JTable getGongHuoBiao() {
		return gongHuoBiao;
	}
	public JTextField getGongHuoText() {
		return gongHuoText;
	}
	public JTable getGongHuoXiBiao() {
		return gongHuoXiBiao;
	}
	public JButton getGuoLu() {
		return guoLu;
	}
	public JTable getHuiZongBiao() {
		return huiZongBiao;
	}
	public JLabel getJiLu() {
		return jiLu;
	}
	public JTable getKeHuBiao() {
		return keHuBiao;
	}
	public JLabel getKeHuShu() {
		return keHuShu;
	}
	public JTextField getKeHuText() {
		return keHuText;
	}
	public ActionListener getL() {
		return l;
	}
	public JTabbedPane getMainJTabbedPane() {
		return mainJTabbedPane;
	}
	public JTable getMingXiBiao() {
		return mingXiBiao;
	}
	public JLabel getShangPingMing() {
		return shangPingMing;
	}
	public JLabel getShangPinKind() {
		return shangPinKind;
	}
	public JTextField getShangPinNameText() {
		return shangPinNameText;
	}
	public JComboBox getShangPinText() {
		return shangPinText;
	}
	public JComboBox getShangPinText1() {
		return shangPinText1;
	}
	public JComboBox getShangPinText2() {
		return shangPinText2;
	}
	public JTable getTongJiBiao() {
		return tongJiBiao;
	}
	public JButton getTuiChu() {
		return tuiChu;
	}
	public JButton getTuiChu1() {
		return tuiChu1;
	}
	public JButton getTuiChu2() {
		return tuiChu2;
	}
	public JTabbedPane getXiaoShouPane() {
		return xiaoShouPane;
	}
	public JLabel getZhi() {
		return zhi;
	}
	public JLabel getJiLu1() {
		return jiLu1;
	}
	public JLabel getJiLu2() {
		return jiLu2;
	}
	public JLabel getGongHuoShangXinXi() {
		return gongHuoShangXinXi;
	}
	public JLabel getKeHuXinXi() {
		return keHuXinXi;
	}
	/**
	 * 实现监听器
	 * @param args
	 */
	public static void main(String[] args) {
		new GoodsXiaoShouTongJi(null,"",true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guoLu){
			new GoodsGuoLvDialog(this,"过滤",true);
		}
		if(e.getSource()==checkDanJu){
			new XiaoShouCheckDilog(this,"单据查询",true);
		}
		if(e.getSource()==fenXi){
			new FenXiDialog(this,"单品分析",true);
		}
		if(e.getSource()==checkDanJu1){
			new TongJiDialog(this,"单据查询",true);
		}
		if(e.getSource()==checkDanJu2){
			new KeHuTongJiDialog(this,"单据查询",true);
		}
		if(e.getSource()==daoChu){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    System.out.println("value : " + value);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		    }
		}
		if(e.getSource()==tuiChu){
			this.dispose();
		}
		if(e.getSource()==daoChu1){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    System.out.println("value : " + value);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		    }
		}
		if(e.getSource()==tuiChu1){
			this.dispose();
		}
		if(e.getSource()==daoChu2){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    System.out.println("value : " + value);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		    }
		}
		if(e.getSource()==tuiChu2){
			this.dispose();
		}
	}

}
