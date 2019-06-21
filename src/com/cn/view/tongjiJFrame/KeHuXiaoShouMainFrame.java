package com.cn.view.tongjiJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.JMenuListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.JMenuTwoListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuDanJuListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuDanJuMouseListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuFuKuanListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuXiaoFeiListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuXiaoFeiMouseListener;
import com.cn.control.tongjiframe.KeHuXiaoShouTongJi.KeHuZhangWuListener;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.CheckDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.GaoJiDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuDanJuDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuJialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuMingXiDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuXiaoFeiDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuXinXiDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.KeHuZhangWuDialog;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.ReMoveDialog;

public class KeHuXiaoShouMainFrame extends JDialog implements ActionListener {
	/*
	 * 客户所有单据选项卡中的所有组件
	 */
	JButton shouKuan,checkDanJu,removeDanJu,tuiHuo,guoLv,daoChu,daYin,tuiChu;
	JButton souSuo,chaXun;
	JTextField keHuNames;
	JDatePicker datePickerTo,datePickerTo1;
	JLabel danJuShu;
	JLabel juLuShu;
	JLabel danJuHeJi;
	JLabel danJuXiangXi;
	JTable zhangWuBiao,shangPinBiao,fuKuanBiao;
	JPopupMenu jpm;
	 JButton xiaoShou;
	 JButton tuiHuoL;
	
	/*
	 * 客户消费情况选项卡中的所有组件
	 */
	JButton chaXun1,gaoJiCheck,daoChu1,daYin1,tuiChu1,souSuo1;
	JTextField keHuNames1;
	JDatePicker datePickerTo2,datePickerTo3;
	JLabel jiLuShu1;
	JLabel danJuShu1;
	JLabel danJuXiangXi1;
	JTable huiZongBiao,mingXiBiao;
	/*
	 * 客户账务信息选项卡中的所有组件
	 */
	JButton chaXun2;
	JButton daoChu2,daYin2,tuiChu2,souSuo2;
	JTextField quanBuKeHu1;
	JLabel keHuShu;
	JTable keHuBiao;
	/*
	 * 客户付款明细选项卡中的所有组件
	 */
	JButton souSuo3,chaXun3,checkDanJu3,daoChu3,daYin3,tuiChu3;
	JTextField quanBuKeHu;
	JDatePicker datePickerTo4, datePickerTo5;
	JLabel jiLuShuLiang;
	JTable danJuBiao;
	DefaultTableModel zhangWuDtm,shangPinDtm,fuKuanDtm,huiZongDtm,mingXiDtm,keHuDtm,danJuDtm;
	
	JTabbedPane mainJTabbedPane;
	/**
	 * 改方法创建了一个JDialog窗口，窗口中有四个选项卡，分别是客户所有单据，客户消费情况，
	 * 客户账务信息，客户付款明细。其中客户所有单据选项卡中包括8个按钮，一个查找栏，和两个
	 * JTable，客户消费情况选项卡中包括4个按钮一个查找栏，和两个JTable，客户账务信息选项卡
	 * 中包括3个按钮 ，一个查找栏和一个JTable，客户付款明细选项卡中包括四个按钮一个查找栏和
	 * 一个JTable。
	 * @param title
	 */
	 public KeHuXiaoShouMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(900,600);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 //this.pack();
		 this.setLocationRelativeTo(null);
		 /*
		  *实例并添加 客户所有单据表选项卡中的JButton
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 shouKuan=new JButton(new ImageIcon("res\\AcionIcon\\myShouKuang.jpg"));
		 shouKuan.setMargin(new Insets(0,0,0,0));
		 buttonP.add(shouKuan);
		 checkDanJu=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(checkDanJu);
		 removeDanJu=new JButton(new ImageIcon("res\\AcionIcon\\deleteDanJu.jpg"));
		 removeDanJu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(removeDanJu);
		 tuiHuo=new JButton(new ImageIcon("res\\AcionIcon\\zhengdantuihuo.jpg"));
		 tuiHuo.setMargin(new Insets(0,0,0,0));
		 buttonP.add(tuiHuo);
		 guoLv=new JButton(new ImageIcon("res\\AcionIcon\\guoLv.jpg"));
		 guoLv.setMargin(new Insets(0,0,0,0));
		 buttonP.add(guoLv);
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
		  * 实例并添加客户消费情况选项卡中的JButton
		  */
		 JPanel buttonP1=new JPanel();
		 buttonP1.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP1.setLayout(new FlowLayout(FlowLayout.LEFT));
		 gaoJiCheck=new JButton(new ImageIcon("res\\AcionIcon\\advanceFind.jpg"));
		 gaoJiCheck.setMargin(new Insets(0,0,0,0));
		 buttonP1.add(gaoJiCheck);
		 daoChu1=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu1.setMargin(new Insets(0,0,0,0));
		 buttonP1.add(daoChu1);
		 daYin1=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin1.setMargin(new Insets(0,0,0,0));
		 buttonP1.add(daYin1);
		 tuiChu1=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu1.setMargin(new Insets(0,0,0,0));
		 buttonP1.add(tuiChu1);
		/*
		 * 组合客户所有单据选项卡
		 */
		 JPanel danJuP=new JPanel();
		 danJuP.setLayout(new BorderLayout());
		 danJuP.add(chaXunPane(),BorderLayout.NORTH);
		 danJuP.add(wangLaiPane());
		 JPanel mainP=new JPanel();
		 mainP.setLayout(new BorderLayout());
		 mainP.add(buttonP,BorderLayout.NORTH);
		 mainP.add(danJuP);
		 /*
		 * 组合客户消费情况选项卡
		 */
		 JPanel huiZongP=new JPanel();
		 huiZongP.setLayout(new BorderLayout());
		 huiZongP.add(chaXunPane1(),BorderLayout.NORTH);
		 huiZongP.add(shangPinHuiZong());
		 JPanel mainP1=new JPanel();
		 mainP1.setLayout(new BorderLayout());
		 mainP1.add(buttonP1,BorderLayout.NORTH);
		 mainP1.add(huiZongP);
		 /*
		  * 将各个选项卡添加到主界面
		  */
		 mainJTabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		 mainJTabbedPane.add("客户所有单据",mainP);
		 mainJTabbedPane.add("客户消费情况",mainP1);
		 mainJTabbedPane.add("客户账务信息",mainP2());
		 mainJTabbedPane.add("客户付款明细",mainP3());
		 chaXun.addActionListener(l);
		 chaXun1.addActionListener(m);
		 chaXun2.addActionListener(n);
		 chaXun3.addActionListener(p);
		 huiZongBiao.addMouseListener(o);
		 zhangWuBiao.addMouseListener(q);
		 shouKuan.addActionListener(this);
		 checkDanJu.addActionListener(this);
		 removeDanJu.addActionListener(this);
		 tuiHuo.addActionListener(this);
		 guoLv.addActionListener(this);
		 daoChu.addActionListener(this);
		 tuiChu.addActionListener(this);
		 gaoJiCheck.addActionListener(this);
		 daoChu1.addActionListener(this);
		 tuiChu1.addActionListener(this);
		 daoChu2.addActionListener(this);
		 tuiChu2.addActionListener(this);
		 daoChu3.addActionListener(this);
		 tuiChu3.addActionListener(this);
		 checkDanJu3.addActionListener(this);
		 souSuo.addActionListener(this);
		 souSuo1.addActionListener(this);
		 souSuo2.addActionListener(this);
		 souSuo3.addActionListener(this);
		 danJuBiao.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1&&e.getClickCount()==2){
					new KeHuDanJuDialog(KeHuXiaoShouMainFrame.this,"单据统计",true);
				}
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		 });
		 this.getContentPane().add(mainJTabbedPane);
		 this.setVisible(true);
     }
     public ActionListener l=new KeHuDanJuListener(this);
     public ActionListener m=new KeHuXiaoFeiListener(this);
     public ActionListener n=new KeHuZhangWuListener(this);
     public ActionListener p=new KeHuFuKuanListener(this);
     public MouseListener o=new KeHuXiaoFeiMouseListener(this);
     public MouseListener q=new KeHuDanJuMouseListener(this);
     public ActionListener mo=new JMenuListener(this);
     public ActionListener mos=new JMenuTwoListener(this);
   
     /*
      * 各个查找栏的实例化
      */
     public JPanel chaXunPane(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo1= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo1);
		 jp.add(new JLabel("客户名称："));
		 keHuNames=new JTextField(8);
		 jp.add(keHuNames);
		 souSuo=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		 souSuo.setMargin(new Insets(0,0,0,0));
		 jp.add(souSuo);
		 chaXun=new JButton("查询");
		 jp.add(chaXun);
    	 return jp;
     }
     public JPanel chaXunPane1(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo3= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo2);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo3);
		 jp.add(new JLabel("客户名称："));
		 keHuNames1=new JTextField(8);
		 jp.add(keHuNames1);
	     souSuo1=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		 souSuo1.setMargin(new Insets(0,0,0,0));
		 jp.add(souSuo1);
		 chaXun1=new JButton("查询");
		 jp.add(chaXun1);
    	 return jp;
     }
     public JPanel chaXunPane2(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo4= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo5= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo4);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo5);
		
		 jp.add(new JLabel("客户名称："));
		 quanBuKeHu=new JTextField(8);
		 jp.add(quanBuKeHu);
		 souSuo3=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		 souSuo3.setMargin(new Insets(0,0,0,0));
		 jp.add(souSuo3);
		 chaXun3=new JButton("查询");
		 jp.add(chaXun3);
    	 return jp;
     }
     /*
      * 各个选项卡中表的实例化
      */
     public JPanel keHuLabel(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 keHuShu=new JLabel("客户数：0");
    	 keHuShu.setForeground(Color.red);
    	 jp.add(keHuShu);
    	 return jp;
     }
     public JPanel wangLaiPane(){
    	 JPanel jp=new JPanel();
    	 jp.setBorder(new TitledBorder("往来账务列表"));
    	 jp.setLayout(new BorderLayout());
    	 shangPinDtm=new AllTableModel(tongJiModel.shangPinColumn,tongJiModel.shangPinNames);
    	 shangPinDtm.isCellEditable(0, 0);
    	 shangPinBiao=new JTable(shangPinDtm);
    	 shangPinBiao.setPreferredScrollableViewportSize(new Dimension(860,80));
    	 JScrollPane shangPinJS=new JScrollPane(shangPinBiao);
    	 fuKuanDtm=new DefaultTableModel(tongJiModel.fuKuanColumn,tongJiModel.fuKuanNames);
    	 fuKuanBiao=new JTable(fuKuanDtm);
    	 fuKuanBiao.setPreferredScrollableViewportSize(new Dimension(860,80));
    	 JScrollPane fuKuanJS=new JScrollPane(fuKuanBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 juLuShu=new JLabel("记录数：");
         juLuShu.setForeground(Color.red);
    	 labelP.add(juLuShu);
    	 JPanel ka1=new JPanel();
    	 ka1.setLayout(new BorderLayout());
    	 ka1.add(labelP,BorderLayout.SOUTH);
    	 ka1.add(shangPinJS);
    	 
    	 JPanel labelP1=new JPanel();
    	 labelP1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuHeJi=new JLabel("单据合计：");
    	 danJuHeJi.setForeground(Color.red);
    	 labelP1.add(danJuHeJi);
    	 JPanel ka2=new JPanel();
    	 ka2.setLayout(new BorderLayout());
    	 ka2.add(labelP1,BorderLayout.SOUTH);
    	 ka2.add(fuKuanJS);
    	 JTabbedPane jt=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    	 jt.add("单据商品信息",ka1);
    	 jt.add("单据付款信息",ka2);
    	 JPanel southP=new JPanel();
    	 southP.add(jt);
    	 JPanel danJuXiangXiP=new JPanel();
    	 danJuXiangXiP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuXiangXi=new JLabel("单据的详细信息：");
    	 danJuXiangXi.setForeground(Color.red);
    	 danJuXiangXiP.add(danJuXiangXi);
    	 JPanel heSouthP=new JPanel();
    	 heSouthP.setLayout(new BorderLayout());
    	 heSouthP.add(danJuXiangXiP,BorderLayout.NORTH);
    	 heSouthP.add(southP);
    	 
    	
    	 zhangWuDtm=new AllTableModel(tongJiModel.zhangWuColumn,tongJiModel.zhangWuNames);
    	 zhangWuDtm.isCellEditable(0, 0);
    	 zhangWuBiao=new JTable(zhangWuDtm);
    	 zhangWuBiao.setPreferredScrollableViewportSize(new Dimension(860,200));
    	 JScrollPane zhangWuJS=new JScrollPane(zhangWuBiao);
    	 JPanel labelP2=new JPanel();
    	 labelP2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuShu=new JLabel("单据总数：");
    	 danJuShu.setForeground(Color.red);
    	 labelP2.add(danJuShu);
    	 JPanel ka3=new JPanel();
    	 ka3.setLayout(new BorderLayout());
    	 ka3.add(labelP2,BorderLayout.SOUTH);
    	 ka3.add(zhangWuJS);
    	 
    	 jp.add(heSouthP,BorderLayout.SOUTH);
    	 jp.add(ka3);
    	 return jp;
     }
     public JPanel shangPinHuiZong(){
    	 JPanel jp=new JPanel();
    	 jp.setBorder(new TitledBorder("往来账务列表"));
    	 jp.setLayout(new BorderLayout());
    	 huiZongDtm=new AllTableModel(tongJiModel.huiZongColumn1,tongJiModel.huiZongNames1);
    	 huiZongDtm.isCellEditable(0, 0);
    	 huiZongBiao=new JTable(huiZongDtm);
    	 huiZongBiao.setPreferredScrollableViewportSize(new Dimension(200,100));
    	 JScrollPane huiZongJS=new JScrollPane(huiZongBiao);
    	 mingXiDtm=new AllTableModel(tongJiModel.mingXiColumn1,tongJiModel.mingXiNames1);
    	 mingXiDtm.isCellEditable(0, 0);
    	 mingXiBiao=new JTable(mingXiDtm);
    	 mingXiBiao.setPreferredScrollableViewportSize(new Dimension(200,100));
    	 JScrollPane mingXiJS=new JScrollPane(mingXiBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShu1=new JLabel("记录数：");
         jiLuShu1.setForeground(Color.red);
    	 labelP.add(jiLuShu1);
    	 JPanel ka1=new JPanel();
    	 ka1.setLayout(new BorderLayout());
    	 ka1.add(labelP,BorderLayout.SOUTH);
    	 ka1.add(huiZongJS);
    	 
    	 JPanel labelP1=new JPanel();
    	 labelP1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuShu1=new JLabel("单据合计：");
    	 danJuShu1.setForeground(Color.red);
    	 labelP1.add(danJuShu1);
    	 JPanel ka2=new JPanel();
    	 ka2.setLayout(new BorderLayout());
    	 ka2.add(labelP1,BorderLayout.SOUTH);
    	 ka2.add(mingXiJS);
    	
    	 JPanel danJuXiangXiP=new JPanel();
    	 danJuXiangXiP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuXiangXi1=new JLabel("商品销售明细：");
    	 danJuXiangXi1.setForeground(Color.red);
    	 danJuXiangXiP.add(danJuXiangXi1);
    	 JPanel heSouthP=new JPanel();
    	 heSouthP.setLayout(new BorderLayout());
    	 heSouthP.add(danJuXiangXiP,BorderLayout.NORTH);
    	 heSouthP.add(ka2);
    	 
    	
    	 jp.add(heSouthP,BorderLayout.SOUTH);
    	 jp.add(ka1);
    	 return jp;
     }
     /**
      * 实例化客户账务信息选项卡，并将其返回
      */
     public JPanel mainP2(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 keHuDtm=new AllTableModel(tongJiModel.keHuColumn,tongJiModel.keHuName);
    	 keHuDtm.isCellEditable(0, 0);
    	 keHuBiao=new JTable(keHuDtm);
    	 JScrollPane keHuP=new JScrollPane(keHuBiao);
    	 JPanel labelP=new JPanel();
    	 quanBuKeHu1=new JTextField(10);
    	 chaXun2=new JButton("查询");
    	 labelP.add(new JLabel("客户名称："));
    	 labelP.add(quanBuKeHu1);
    	 souSuo2=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		 souSuo2.setMargin(new Insets(0,0,0,0));
    	 labelP.add(souSuo2);
    	 labelP.add(chaXun2);
    	 JPanel jp1=new JPanel();
    	 jp1.setLayout(new BorderLayout());
    	 jp1.add(labelP,BorderLayout.NORTH);
    	 jp1.add(keHuP,BorderLayout.CENTER);
    	 jp1.add(keHuLabel(),BorderLayout.SOUTH);
    	 
    	 JPanel buttonP=new JPanel();
    	 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 daoChu2=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu2.setMargin(new Insets(0,0,0,0));
		
		 daYin2=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin2.setMargin(new Insets(0,0,0,0));
	
		 tuiChu2=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu2.setMargin(new Insets(0,0,0,0));
		
    	 buttonP.add(daoChu2);
    	 buttonP.add(daYin2);
    	 buttonP.add(tuiChu2);
    	 jp.add(buttonP,BorderLayout.NORTH);
    	 jp.add(jp1);
    	 return jp;
     }
     /**
      * 实例化客户付款明细选项卡，并将其返回
      */
     public JPanel mainP3(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 danJuDtm=new AllTableModel(tongJiModel.danJuColumn1,tongJiModel.danJuNames1);
    	 danJuDtm.isCellEditable(0, 0);
    	 danJuBiao=new JTable(danJuDtm);
    	 JScrollPane danJuP=new JScrollPane(danJuBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShuLiang=new JLabel("记录数量：");
    	  jiLuShuLiang.setForeground(Color.red);
    	 labelP.add(jiLuShuLiang);
    	 JPanel jp1=new JPanel();
    	 jp1.setLayout(new BorderLayout());
    	 jp1.add(labelP,BorderLayout.SOUTH);
    	 jp1.add(danJuP);
    	 JPanel jp2=new JPanel();
    	 jp2.setLayout(new BorderLayout());
    	 jp2.add(chaXunPane2(),BorderLayout.NORTH);
    	 jp2.add(jp1);
    	 
    	 JPanel buttonP=new JPanel();
    	 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	
    	 checkDanJu3=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
    	 checkDanJu3.setMargin(new Insets(0,0,0,0));
		
    	 daoChu3=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu3.setMargin(new Insets(0,0,0,0));
		
		 daYin3=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin3.setMargin(new Insets(0,0,0,0));
	
		 tuiChu3=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu3.setMargin(new Insets(0,0,0,0));
		 buttonP.add(checkDanJu3);
    	 buttonP.add(daoChu3);
    	 buttonP.add(daYin3);
    	 buttonP.add(tuiChu3);
    	 jp.add(buttonP,BorderLayout.NORTH);
    	 jp.add(jp2);
    	 return jp;
     }
     /*
      * 添加JPopupMenu
      */
   public JPopupMenu addJPopupMenu(){
    	 JPopupMenu jpm=new JPopupMenu();
    	  xiaoShou=new JButton("销售单");
          tuiHuoL=new JButton("退货单");
    	 jpm.add(xiaoShou);
    	 jpm.add(tuiHuoL);
    	 xiaoShou.addActionListener(mo);
    	 tuiHuoL.addActionListener(mos);
    	 return jpm;
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
	public JButton getChaXun3() {
		return chaXun3;
	}
	public JButton getCheckDanJu() {
		return checkDanJu;
	}
	public JButton getCheckDanJu3() {
		return checkDanJu3;
	}
	public JTable getDanJuBiao() {
		return danJuBiao;
	}
	public DefaultTableModel getDanJuDtm() {
		return danJuDtm;
	}
	public JLabel getDanJuHeJi() {
		return danJuHeJi;
	}
	public JLabel getDanJuShu() {
		return danJuShu;
	}
	public JLabel getDanJuShu1() {
		return danJuShu1;
	}
	public JLabel getDanJuXiangXi() {
		return danJuXiangXi;
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
	public JButton getDaoChu3() {
		return daoChu3;
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
	public JButton getDaYin3() {
		return daYin3;
	}
	public JTable getFuKuanBiao() {
		return fuKuanBiao;
	}
	public DefaultTableModel getFuKuanDtm() {
		return fuKuanDtm;
	}
	public JButton getGaoJiCheck() {
		return gaoJiCheck;
	}
	public JButton getGuoLv() {
		return guoLv;
	}
	public JTable getHuiZongBiao() {
		return huiZongBiao;
	}
	public DefaultTableModel getHuiZongDtm() {
		return huiZongDtm;
	}
	public JLabel getJiLuShu1() {
		return jiLuShu1;
	}
	public JLabel getJiLuShuLiang() {
		return jiLuShuLiang;
	}
	public JLabel getJuLuShu() {
		return juLuShu;
	}
	public JTable getKeHuBiao() {
		return keHuBiao;
	}
	public DefaultTableModel getKeHuDtm() {
		return keHuDtm;
	}
	public JTextField getKeHuNames() {
		return keHuNames;
	}
	public JTextField getKeHuNames1() {
		return keHuNames1;
	}
	public JLabel getKeHuShu() {
		return keHuShu;
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
	public DefaultTableModel getMingXiDtm() {
		return mingXiDtm;
	}
	public JTextField getQuanBuKeHu() {
		return quanBuKeHu;
	}
	public JTextField getQuanBuKeHu1() {
		return quanBuKeHu1;
	}
	public JButton getRemoveDanJu() {
		return removeDanJu;
	}
	public JTable getShangPinBiao() {
		return shangPinBiao;
	}
	public DefaultTableModel getShangPinDtm() {
		return shangPinDtm;
	}
	public JButton getShouKuan() {
		return shouKuan;
	}
	public JButton getSouSuo() {
		return souSuo;
	}
	public JButton getSouSuo1() {
		return souSuo1;
	}
	public JButton getSouSuo2() {
		return souSuo2;
	}
	public JButton getSouSuo3() {
		return souSuo3;
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
	public JButton getTuiChu3() {
		return tuiChu3;
	}
	public JButton getTuiHuo() {
		return tuiHuo;
	}
	public JTable getZhangWuBiao() {
		return zhangWuBiao;
	}
	public DefaultTableModel getZhangWuDtm() {
		return zhangWuDtm;
	}
	public JButton getXiaoShou() {
		return xiaoShou;
	}
	
	public JLabel getDanJuXiangXi1() {
		return danJuXiangXi1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new KeHuXiaoShouMainFrame(null,"",true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==shouKuan){
			new KeHuJialog(this,"收款单",true);
		}
		if(e.getSource()==checkDanJu){
			new CheckDialog(this,"",true);
		}
		if(e.getSource()==removeDanJu){
			new ReMoveDialog(this,"",true);
		}
		if(e.getSource()==tuiHuo){
			if(zhangWuDtm.getValueAt(zhangWuBiao.getSelectedRow(), 2).
					toString().toLowerCase().startsWith("xs")){
			JOptionPane joptionP= new JOptionPane();
    		//chaZhaoB.add(joptionP);
    		JOptionPane.showMessageDialog(tuiHuo, ("您的退货单号为："+zhangWuDtm.getValueAt(zhangWuBiao.getSelectedRow(), 2).toString())
    				+"请到前台进行退货！谢谢合作");
    		joptionP.setVisible(true);}
			else{
				JOptionPane joptionP= new JOptionPane();
	    		//chaZhaoB.add(joptionP);
	    		JOptionPane.showMessageDialog(tuiHuo, ("您选择的不是销售单，请重新选择"));
	    		joptionP.setVisible(true);
			}
		}
		if(e.getSource()==guoLv){
			jpm=addJPopupMenu();
			jpm.show(guoLv, 40, 40);				 
		}
		if(e.getSource()==tuiChu){
			this.dispose();
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
		if(e.getSource()==gaoJiCheck){
			new GaoJiDialog(this,"客户消费情况高级查询",true);
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
		if(e.getSource()==daoChu3){
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
		if(e.getSource()==tuiChu3){
			this.dispose();
		}
		if(e.getSource()==checkDanJu3){
			new KeHuDanJuDialog(this,"单据统计",true);
		}
		if(e.getSource()==souSuo){
			new KeHuXinXiDialog(this,"客户查找",true);
		}
		if(e.getSource()==souSuo1){
			new KeHuXiaoFeiDialog(this,"客户查询",true);
		}
		if(e.getSource()==souSuo2){
			new KeHuZhangWuDialog(this,"客户查询",true);
		}
		if(e.getSource()==souSuo3){
			new KeHuMingXiDialog(this,"客户查询",true);
		}
	}

}
