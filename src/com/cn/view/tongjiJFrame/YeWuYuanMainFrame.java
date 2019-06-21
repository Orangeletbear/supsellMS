package com.cn.view.tongjiJFrame;

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
import java.io.File;
import java.text.ParseException;
import java.util.Vector;

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
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi.YeWuLeiBieListener;
import com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi.YeWuMingXiListener;
import com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi.YeWuMingXiMouseListener;
import com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi.YeWuYeJiListener;
import com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi.YeWuYeJiMouseListener;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou.LeiBieDialog;
import com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou.MingXiDialog;
import com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou.YeWuCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou.YeWuJDBC;

public class YeWuYuanMainFrame extends JDialog implements ActionListener{
	/*
	 * 业务员销售明细选项卡中的所有组件
	 */
	JButton check,checkDanJu,daoChu,daYin,tuiChu;
	JDatePicker datePickerTo,datePickerTo1;
	JComboBox names;
	JButton chaXun;
	JTable xiaoShouBiao,mingXiBiao;
	DefaultTableModel xiaoShouDtm,mingXiDtm;
	JLabel danJuShu;
	JLabel XiangQing;
	JLabel jiLuShu;
	/*
	 * 业务员业绩统计选项卡中的所有组件
	 */
	JButton checkDanJu1,daoChu1,daYin1,tuiChu1;
	JDatePicker datePickerTo2,datePickerTo3;
	JComboBox names1;
	JButton chaXun1;
	JTable yeJiBiao,yeJiXiBiao;
	DefaultTableModel yeJiDtm,yeJiXiDtm;
	JLabel jiLuShu3;
	JLabel keHuJinEmingXi;
	 JLabel jiLuShu4;
	/*
	 * 业务员商品类别统计选项卡中的所有组件
	 */
	JButton checkDanJu2,daoChu2,daYin2,tuiChu2;
	JDatePicker datePickerTo4,datePickerTo5;
	JComboBox names2;
	JButton chaXun2;
	JTable leiBieBiao;
	JComboBox shangPinLeiBie;
	DefaultTableModel leiBieDtm;
	 JLabel jiLuShu5;
	JTabbedPane mainJT=new JTabbedPane();
	/**
	 * 改方法创建了一个JDialog窗口，窗口中有三个选项卡，分别是业务员销售明细，业务员业绩统计，
	 * 业务员商品类别统计。其中业务员销售明细选项卡中包括5个按钮，一个查找栏，和两个 JTable，
	 * 业务员业绩统计选项卡中包括4个按钮一个查找栏，和两个JTable，业务员商品类别统计选项卡
	 * 中包括4个按钮 ，一个查找栏和一个JTabl。
	 * @param title
	 */
	public YeWuYuanMainFrame(JDialog owner,String title,boolean model){
   	 super(owner,title,model);
   	 init();
   	 }
	 public YeWuYuanMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(900, 600);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 //this.pack();
		 this.setLocationRelativeTo(null);//主界面的设置
		 /*
		  * 三个选项卡的添加
		  */
		 JPanel xiaoShouZuHe=new JPanel();
		 xiaoShouZuHe.setLayout(new BorderLayout());
		 xiaoShouZuHe.add(xiaoShouLabel(),BorderLayout.NORTH);
		 xiaoShouZuHe.add(xiaoShouTablePane());
		 JPanel mainP1=new JPanel();
		 mainP1.setLayout(new BorderLayout());
		 mainP1.add(xiaoShouButtonP(),BorderLayout.NORTH);
		 mainP1.add(xiaoShouZuHe);
		 
		 JPanel yeJiZuHe=new JPanel();
		 yeJiZuHe.setLayout(new BorderLayout());
		 yeJiZuHe.add(yeJiLabel(),BorderLayout.NORTH);
		 yeJiZuHe.add(yeJiTablePane());
		 JPanel mainP2=new JPanel();
		 mainP2.setLayout(new BorderLayout());
		 mainP2.add(yeJiButtonP(),BorderLayout.NORTH);
		 mainP2.add(yeJiZuHe);
		 
		 JPanel leiBieZuHe=new JPanel();
		 leiBieZuHe.setLayout(new BorderLayout());
		 leiBieZuHe.add(leiBieLabel(),BorderLayout.NORTH);
		 leiBieZuHe.add(leiBieTablePane());
		 JPanel mainP3=new JPanel();
		 mainP3.setLayout(new BorderLayout());
		 mainP3.add(leiBieButtonP(),BorderLayout.NORTH);
		 mainP3.add(leiBieZuHe);
		 /*
		  * 将选项卡添加到主界面
		  */
		 mainJT=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
         mainJT.add("业务员销售明细",mainP1);
         mainJT.add("业务员业绩统计",mainP2);
         mainJT.add("业务员商品类别统计",mainP3);
         chaXun.addActionListener(l);
         chaXun1.addActionListener(m);
         chaXun2.addActionListener(n);
         xiaoShouBiao.addMouseListener(p);
         yeJiBiao.addMouseListener(q);
         check.addActionListener(this);
         checkDanJu.addActionListener(this);
         checkDanJu1.addActionListener(this);
         checkDanJu2.addActionListener(this);
         daoChu.addActionListener(this);
         tuiChu.addActionListener(this);
         daoChu1.addActionListener(this);
         tuiChu1.addActionListener(this);
         daoChu2.addActionListener(this);
         tuiChu2.addActionListener(this);
         leiBieBiao.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {
        		 if(e.getButton()==1&&e.getClickCount()==2){
        			 new LeiBieDialog(YeWuYuanMainFrame.this,"",true);
        		 }
        	 }
         });
		 this.getContentPane().add(mainJT);
		 this.setVisible(true);
     }
     public ActionListener l=new YeWuMingXiListener(this);
     public ActionListener m=new YeWuYeJiListener(this);
     public ActionListener n=new YeWuLeiBieListener(this);
     public MouseListener p=new YeWuMingXiMouseListener(this);
     public MouseListener q=new YeWuYeJiMouseListener(this);
     /**
      * 业务员销售明细选项卡中JButton的实例以及添加
      */
     public JPanel xiaoShouButtonP(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
         jp.setBorder(new LineBorder(Color.lightGray,2,true));
         check=new JButton(new ImageIcon("res\\AcionIcon\\find.jpg"));
    	 check.setMargin(new Insets(0,0,0,0));
    	 jp.add(check);
    	 checkDanJu=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
    	 checkDanJu.setMargin(new Insets(0,0,0,0));
    	 jp.add(checkDanJu);
		 daoChu=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu.setMargin(new Insets(0,0,0,0));
		 jp.add(daoChu);
		 daYin=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin.setMargin(new Insets(0,0,0,0));
		 jp.add(daYin);
		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 jp.add(tuiChu);
		 return jp;	 
     }
     /**
      * 业务员业绩统计选项卡中JButton的实例以及添加
      */
     public JPanel yeJiButtonP(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
         jp.setBorder(new LineBorder(Color.lightGray,2,true));
    	 checkDanJu1=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
    	 checkDanJu1.setMargin(new Insets(0,0,0,0));
    	 jp.add(checkDanJu1);
		 daoChu1=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu1.setMargin(new Insets(0,0,0,0));
		 jp.add(daoChu1);
		 daYin1=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin1.setMargin(new Insets(0,0,0,0));
		 jp.add(daYin1);
		 tuiChu1=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu1.setMargin(new Insets(0,0,0,0));
		 jp.add(tuiChu1);
		 return jp;	 
     }
     /**
      * 业务员商品类别选项卡中JButton的实例以及添加
      */
     public JPanel leiBieButtonP(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
         jp.setBorder(new LineBorder(Color.lightGray,2,true));
    	 checkDanJu2=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
    	 checkDanJu2.setMargin(new Insets(0,0,0,0));
    	 jp.add(checkDanJu2);
		 daoChu2=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu2.setMargin(new Insets(0,0,0,0));
		 jp.add(daoChu2);
		 daYin2=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin2.setMargin(new Insets(0,0,0,0));
		 jp.add(daYin2);
		 tuiChu2=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu2.setMargin(new Insets(0,0,0,0));
		 jp.add(tuiChu2);
		 return jp;	 
     }
     /**
      * 业务员销售明细选项卡中查找栏的实例以及添加
      * @return
      */
     public JPanel xiaoShouLabel(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo1= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo1);

	
		 jp.add(new JLabel("业务员名称："));
		 names=new JComboBox(POSJDBC.getAllWorker());
		 names.addItem("所有业务员");
		 names.setSelectedItem("所有业务员");
		 jp.add(names);
		 chaXun=new JButton("查询");
		 jp.add(chaXun);
    	 return jp;
     }
     /**
      * 业务员业绩统计选项卡中查找栏的实例以及添加
      * @return
      */
     public JPanel yeJiLabel(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo3= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo2);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo3);
		
		 jp.add(new JLabel("业务员名称："));
		 names1=new JComboBox(POSJDBC.getAllWorker());
		 names1.addItem("所有业务员");
		 names1.setSelectedItem("所有业务员");
		 jp.add(names1);
		 chaXun1=new JButton("查询");
		 jp.add(chaXun1);
    	 return jp;
     }
     /**
      * 业务员销售商品类别中查找栏的实例以及添加
      * @return
      */
     public JPanel leiBieLabel(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jp.add(new JLabel("查询时间："));
    	 datePickerTo4= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo5= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo4);
		 jp.add(new JLabel("至"));
		 jp.add(datePickerTo5);

		 jp.add(new JLabel("商品类别："));
		 shangPinLeiBie=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinLeiBie.addItem("所有类别");
		 shangPinLeiBie.setSelectedItem("所有类别");
		 jp.add(shangPinLeiBie);
		 jp.add(new JLabel("业务员名称："));
		 names2=new JComboBox(POSJDBC.getAllWorker());
		 names2.addItem("所有业务员");
		 names2.setSelectedItem("所有业务员");
		 jp.add(names2);
		 chaXun2=new JButton("查询");
		 jp.add(chaXun2);
    	 return jp;
     }
     /**
      * 业务员销售明细选项卡的组合
      * @return
      */
     public JPanel xiaoShouTablePane(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 xiaoShouDtm=new AllTableModel(tongJiModel.xiaoShouColumn,tongJiModel.xiaoShouNames);
    	 xiaoShouDtm.isCellEditable(0, 0);
    	 xiaoShouBiao=new JTable(xiaoShouDtm);
    	 xiaoShouBiao.setPreferredScrollableViewportSize(new Dimension(780,50));
    	 JScrollPane xiaoShouJS=new JScrollPane(xiaoShouBiao);
    	 mingXiDtm=new AllTableModel(tongJiModel.mingXiColumn2,tongJiModel.mingXiNames2);
    	 mingXiDtm.isCellEditable(0, 0);
    	 mingXiBiao=new JTable(mingXiDtm);
    	 mingXiBiao.setPreferredScrollableViewportSize(new Dimension(780,50));
    	 JScrollPane mingXiJS=new JScrollPane(mingXiBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 danJuShu=new JLabel("单据数：");
         danJuShu.setForeground(Color.red);
    	 labelP.add(danJuShu);
    	 JPanel ka1=new JPanel();
    	 ka1.setLayout(new BorderLayout());
    	 ka1.add(labelP,BorderLayout.SOUTH);
    	 ka1.add(xiaoShouJS);
    	 
    	 JPanel labelP1=new JPanel();
    	 labelP1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShu=new JLabel("记录数：");
    	jiLuShu.setForeground(Color.red);
    	 labelP1.add(jiLuShu);
    	 JPanel ka2=new JPanel();
    	 ka2.setLayout(new BorderLayout());
    	 ka2.add(labelP1,BorderLayout.SOUTH);
    	 ka2.add(mingXiJS);
    	
    	 JPanel XiangQingP=new JPanel();
    	 XiangQingP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 XiangQingP.setBorder(new LineBorder(Color.LIGHT_GRAY,2,true));
    	 XiangQing=new JLabel("单据的详细信息：");
    	 
    	 XiangQingP.add(XiangQing);
    	 JPanel heSouthP=new JPanel();
    	 heSouthP.setLayout(new BorderLayout());
    	 heSouthP.add(XiangQingP,BorderLayout.NORTH);
    	 heSouthP.add(ka2);
    	
    	 jp.setLayout(new BorderLayout());
    	 jp.add(heSouthP,BorderLayout.SOUTH);
    	 jp.add(ka1);
    	 return jp;
     }
     /**
      * 业务员业绩统计选项卡的组合
      * @return
      */
     public JPanel yeJiTablePane(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 yeJiDtm=new AllTableModel(tongJiModel.yeJiColumn,tongJiModel.yeJiNames);
    	 yeJiDtm.isCellEditable(0, 0);
    	 yeJiBiao=new JTable(yeJiDtm);
    	 yeJiBiao.setPreferredScrollableViewportSize(new Dimension(780,50));
    	 JScrollPane yeJiJS=new JScrollPane(yeJiBiao);
    	 yeJiXiDtm=new AllTableModel(tongJiModel.yeJiXiColumn,tongJiModel.yeJiXiNames);
    	 yeJiXiDtm.isCellEditable(0, 0);
    	 yeJiXiBiao=new JTable(yeJiXiDtm);
    	 yeJiXiBiao.setPreferredScrollableViewportSize(new Dimension(780,50));
    	 JScrollPane yeJiXiJS=new JScrollPane(yeJiXiBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShu3=new JLabel("记录数:");
    	 jiLuShu3.setForeground(Color.red);
    	 labelP.add(jiLuShu3);
    	 JPanel ka1=new JPanel();
    	 ka1.setLayout(new BorderLayout());
    	 ka1.add(labelP,BorderLayout.SOUTH);
    	 ka1.add(yeJiJS);
    	 
    	
    	 JPanel labelP1=new JPanel();
    	 labelP1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShu5=new JLabel("记录数：");
         jiLuShu5.setForeground(Color.red);
    	 labelP1.add(jiLuShu5);
    	 JPanel ka2=new JPanel();
    	 ka2.setLayout(new BorderLayout());
    	 ka2.add(labelP1,BorderLayout.SOUTH);
    	 ka2.add(yeJiXiJS);
    	
    	 JPanel XiangQingP=new JPanel();
    	 XiangQingP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 XiangQingP.setBorder(new LineBorder(Color.LIGHT_GRAY,2,true));
    	 keHuJinEmingXi=new JLabel("各客户业绩金额明细：");
    	 
    	 XiangQingP.add(keHuJinEmingXi);
    	 JPanel heSouthP=new JPanel();
    	 heSouthP.setLayout(new BorderLayout());
    	 heSouthP.add(XiangQingP,BorderLayout.NORTH);
    	 heSouthP.add(ka2);
    	
    	 jp.setLayout(new BorderLayout());
    	 jp.add(heSouthP,BorderLayout.SOUTH);
    	 jp.add(ka1);
    	 return jp;
     }
     /**
      * 业务员商品类别选项卡的组合
      * @return
      */
     public JPanel leiBieTablePane(){
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 leiBieDtm=new AllTableModel(tongJiModel.leiBieColumn,tongJiModel.leiBieNames);
    	 leiBieDtm.isCellEditable(0, 0);
    	 leiBieBiao=new JTable(leiBieDtm);
    	 leiBieBiao.setPreferredScrollableViewportSize(new Dimension(780,50));
    	 JScrollPane leiBieJS=new JScrollPane(leiBieBiao);
    	 JPanel labelP=new JPanel();
    	 labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 jiLuShu4=new JLabel("记录数：");
    	 jiLuShu4.setForeground(Color.red);
    	 labelP.add(jiLuShu4);
    	 jp.add(labelP,BorderLayout.SOUTH);
    	 jp.add(leiBieJS);
    	 return jp;
     }
     
     public JButton getCheck() {
		return check;
	}
	public JButton getCheckDanJu() {
		return checkDanJu;
	}
	public JButton getDaoChu() {
		return daoChu;
	}
	public JButton getDaYin() {
		return daYin;
	}
	public JButton getTuiChu() {
		return tuiChu;
	}
	public JDatePicker getDatePickerTo() {
		return datePickerTo;
	}
	public JDatePicker getDatePickerTo1() {
		return datePickerTo1;
	}
	
	public JComboBox getNames() {
		return names;
	}
	public JButton getChaXun() {
		return chaXun;
	}
	public JTable getXiaoShouBiao() {
		return xiaoShouBiao;
	}
	public JTable getMingXiBiao() {
		return mingXiBiao;
	}
	public DefaultTableModel getXiaoShouDtm() {
		return xiaoShouDtm;
	}
	public DefaultTableModel getMingXiDtm() {
		return mingXiDtm;
	}
	public JLabel getDanJuShu() {
		return danJuShu;
	}
	public JLabel getXiangQing() {
		return XiangQing;
	}
	public JLabel getJiLuShu() {
		return jiLuShu;
	}
	public JButton getCheckDanJu1() {
		return checkDanJu1;
	}
	public JButton getDaoChu1() {
		return daoChu1;
	}
	public JButton getDaYin1() {
		return daYin1;
	}
	public JButton getTuiChu1() {
		return tuiChu1;
	}
	public JDatePicker getDatePickerTo2() {
		return datePickerTo2;
	}
	public JDatePicker getDatePickerTo3() {
		return datePickerTo3;
	}

	
	public JComboBox getNames1() {
		return names1;
	}
	public JButton getChaXun1() {
		return chaXun1;
	}
	public JTable getYeJiBiao() {
		return yeJiBiao;
	}
	public JTable getYeJiXiBiao() {
		return yeJiXiBiao;
	}
	public DefaultTableModel getYeJiDtm() {
		return yeJiDtm;
	}
	public DefaultTableModel getYeJiXiDtm() {
		return yeJiXiDtm;
	}
	public JLabel getKeHuJinEmingXi() {
		return keHuJinEmingXi;
	}
	public JLabel getJiLuShu4() {
		return jiLuShu4;
	}
	public JLabel getJiLuShu5() {
		return jiLuShu5;
	}
	public JButton getCheckDanJu2() {
		return checkDanJu2;
	}
	public JButton getDaoChu2() {
		return daoChu2;
	}
	public JButton getDaYin2() {
		return daYin2;
	}
	public JButton getTuiChu2() {
		return tuiChu2;
	}
	public JDatePicker getDatePickerTo4() {
		return datePickerTo4;
	}
	public JDatePicker getDatePickerTo5() {
		return datePickerTo5;
	}
	
	public JComboBox getNames2() {
		return names2;
	}
	public JButton getChaXun2() {
		return chaXun2;
	}
	public JTable getLeiBieBiao() {
		return leiBieBiao;
	}
	public JComboBox getShangPinLeiBie() {
		return shangPinLeiBie;
	}
	public DefaultTableModel getLeiBieDtm() {
		return leiBieDtm;
	}
	public JLabel getJiLuShu3() {
		return jiLuShu3;
	}
	public JTabbedPane getMainJT() {
		return mainJT;
	}
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
        	new YeWuCheckDialog(this,"",true);
        }	
        if(e.getSource()==checkDanJu){
        	new MingXiDialog(this,"单据查询",true);
        }
        if(e.getSource()==checkDanJu1){
        	String name=yeJiDtm.getValueAt(yeJiBiao.getSelectedRow(), 0).toString();
        	try {
				Vector xiaoshou=YeWuJDBC.getMingXiData(DateConventer.dateToStr(datePickerTo2.getSelectedDate()), DateConventer.dateToStr(datePickerTo3.getSelectedDate()), name);
				xiaoShouDtm.setDataVector(xiaoshou, AllTableModel.getVectorFromObj(tongJiModel.xiaoShouNames));
				mainJT.setSelectedIndex(0);
        	} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        if(e.getSource()==checkDanJu2){
    		new LeiBieDialog(this,"",true);
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
