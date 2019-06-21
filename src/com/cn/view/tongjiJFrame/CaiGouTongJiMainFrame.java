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
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.danJuListener;
import com.cn.control.tongjiframe.danJuMouseListener;
import com.cn.dao.pos.POSJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.CaiGouTongJiCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.DanJuDialogTwo;

public class CaiGouTongJiMainFrame extends JDialog implements ActionListener {
	/*
	 * 5个按钮和查找栏中的组件
	 */
	JButton check,checkDanJu,daoChu,daYin,tuiChu,tongJi;
	JLabel caiGouDate,zhi,yeWuYuanName;
	JDatePicker datePickerTo,datePickerTo2; 
	JComboBox yeWuYuanBox;
	/*
	 * 业务员采购单据表选项卡中的JTable何JLael
	 */
	JLabel jiLu;
	JTable danJuBiao;
	/*
	 * 单据详细信息表中的JTable何JLael
	 */
	JLabel pinZhong, xinXiLabel;
	JTable xinXiBiao;
	/*
	 * 商品明细表选项卡中的JTable何JLael
	 */
	JLabel jiLu1;
	JTable mingXiBiao;
	/*
	 * 商品汇总表选项卡中的JTable何JLael
	 */
	JLabel pinZhong1;
	JTable huiZongBiao;
	
	
	JTabbedPane mainJPane;   //选项卡界面
	DefaultTableModel dft1,dft2,dft3,dft4;

	/**
	 * 改方法创建了一个JDialog窗口，窗口中有5个按钮，和一个查找栏，以及三个选项卡。5个按钮分别是
	 * 查找，查看单据，导出，打印，退出。查找栏中有查找的时间段，查找的业务员名称。
	 * 选项卡分别是业务员采购单据表，商品明细表，商品汇总表。其中业务员采购单据表中包括一个单据的
	 * 单据详细信息表。
	 */
	public CaiGouTongJiMainFrame(JDialog owner,String title,boolean model){
   	 super(owner,title,model);
   	 init();
    }
	 public CaiGouTongJiMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
     }
     private void init(){
    	 this.setSize(800, 500);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 //this.pack();
		 this.setLocationRelativeTo(null);//对主界面的设置
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * 将各个按钮实例化并添加到一个面板中
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 check=new JButton(new ImageIcon("res\\AcionIcon\\find.jpg"));
		 check.setMargin(new Insets(0,0,0,0));
		 buttonP.add(check);
		 checkDanJu=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(checkDanJu);
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
		  * 将查找栏中的组件实例化并添加到一个面板中
		  */
		 caiGouDate=new JLabel("采购日期");
		 zhi=new JLabel("至");
		 yeWuYuanName=new JLabel("业务员名称：");
		 yeWuYuanBox=new JComboBox(POSJDBC.getAllWorker());
		 yeWuYuanBox.addItem("所有业务员");
		 yeWuYuanBox.setSelectedItem("所有业务员");
		 
		 tongJi=new JButton("统计");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo);
		 northP.add(zhi);
		 northP.add(datePickerTo2);
		 northP.add(new JLabel("              "));
		 northP.add(yeWuYuanName);
		 northP.add(yeWuYuanBox);
		 northP.add(tongJi);
		 
		 /*
		  * 将整个界面的组件添加到主界面
		  */
		 JPanel centreP=new JPanel();
		 centreP.setLayout(new BorderLayout());
		 centreP.add(northP,BorderLayout.NORTH);
		 centreP.add(addPane());
		 
		 jp.add(buttonP,BorderLayout.NORTH);
		 jp.add(centreP);
		 addAction();
		 tongJi.addActionListener(l);//添加监听器
		 danJuBiao.addMouseListener(m);
		 this.add(jp);
		 this.setVisible(true);
     }
     public ActionListener l=new danJuListener(this);
     public MouseListener m=new danJuMouseListener(this);
     /*
      * 添加并返回选项卡
      */
		 public  JTabbedPane addPane(){
			 mainJPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
			 dft1=new AllTableModel(tongJiModel.danJuColumn,tongJiModel.danJuNames);
			 dft2=new AllTableModel(tongJiModel.mingXiColumn,tongJiModel.mingXiNames);
			 dft3=new AllTableModel(tongJiModel.huiZongColumn,tongJiModel.huiZongNames);
			 dft4=new AllTableModel(tongJiModel.xinXiColumn,tongJiModel.xinXiNames);
			 dft1.isCellEditable(0, 0);
			 dft2.isCellEditable(0, 0);
			 dft3.isCellEditable(0, 0);
			 dft4.isCellEditable(0, 0);
			 danJuBiao=new JTable(dft1);
			 danJuBiao.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane danJuJS=new JScrollPane(danJuBiao);
			 mingXiBiao=new JTable(dft2);
			 huiZongBiao=new JTable(dft3);
			 xinXiBiao=new JTable(dft4);
			 xinXiBiao.setPreferredScrollableViewportSize(new Dimension(200,50));
			 JScrollPane xinXiJS=new JScrollPane(xinXiBiao);
			 xinXiLabel=new JLabel("信息的详细列表：");
			 xinXiLabel.setForeground(Color.red);
			 pinZhong=new JLabel("品种合计：");
			 pinZhong.setForeground(Color.red);
			 JPanel xinXiP=new JPanel();
			 xinXiP.setLayout(new FlowLayout(FlowLayout.LEFT));
			 xinXiP.add(pinZhong);
             JPanel p1=new JPanel();
             p1.setLayout(new BorderLayout());
             p1.add(xinXiLabel,BorderLayout.NORTH);
             p1.add(xinXiJS,BorderLayout.CENTER);
             p1.add(xinXiP,BorderLayout.SOUTH);
             
             jiLu=new JLabel("记录数：");
             jiLu.setForeground(Color.red);
			 JPanel p2=new JPanel();
			 p2.setLayout(new FlowLayout(FlowLayout.LEFT));
			 p2.add(jiLu);
			 p2.setBorder(new LineBorder(Color.LIGHT_GRAY));
			 JPanel danJuP=new JPanel();
			 danJuP.setLayout(new BorderLayout());
			 
			 danJuP.add(p2,BorderLayout.SOUTH);
			
			 danJuP.add(danJuJS);
			 JPanel danJuZongP=new JPanel();
			 danJuZongP.setLayout(new BorderLayout());
			 danJuZongP.add(p1,BorderLayout.SOUTH);
			 danJuZongP.add(danJuP);
			 
			 jiLu1=new JLabel("记录数：");
			 jiLu1.setForeground(Color.red);
			 JPanel p3=new JPanel();
			 p3.setLayout(new FlowLayout(FlowLayout.LEFT));
			 p3.add(jiLu1);
			 mingXiBiao=new JTable(dft2);
			 JScrollPane mingXiJS=new JScrollPane(mingXiBiao);
			 JPanel mingXiZongBiao=new JPanel();
			 mingXiZongBiao.setLayout(new BorderLayout());
			 mingXiZongBiao.add(p3,BorderLayout.SOUTH);
			 mingXiZongBiao.add(mingXiJS);
			 
			 pinZhong1=new JLabel("品种合计：");
			 pinZhong1.setForeground(Color.red);
			 JPanel huiZongP=new JPanel();
			 huiZongP.setLayout(new FlowLayout(FlowLayout.LEFT));
			 huiZongP.add(pinZhong1);
			 huiZongBiao=new JTable(dft3);
			 JScrollPane huiZongJS=new JScrollPane(huiZongBiao);
             JPanel huiZongZongBiao=new JPanel();
             huiZongZongBiao.setLayout(new BorderLayout());
             huiZongZongBiao.add(huiZongP,BorderLayout.SOUTH);
             huiZongZongBiao.add(huiZongJS);
            
			 mainJPane.add("业务员采购单据表",danJuZongP);
			 mainJPane.add("商品明细表",mingXiZongBiao);
			 mainJPane.add("商品汇总表",huiZongZongBiao);
			 return mainJPane;
		 }
		 /*
		  * 添加监听器
		  */
		  private void addAction(){
		    	 check.addActionListener(this);
		    	 checkDanJu.addActionListener(this);
		    	 daoChu.addActionListener(this);
		    	 tuiChu.addActionListener(this);
		     }
		
		 /*
		  * 实现监听器
		  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		  */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==check){
				new CaiGouTongJiCheckDialog(CaiGouTongJiMainFrame.this,"查找",true);
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
		    if(e.getSource()==checkDanJu){
		    	new DanJuDialogTwo(this,"单据表",true);
		    }
		}
		/*
		 * 获取get方法
		 */
		public JDatePicker getDatePickerTo() {
			return datePickerTo;
		}
		public JDatePicker getDatePickerTo2() {
			return datePickerTo2;
		}
		public DefaultTableModel getDft1() {
			return dft1;
		}
		public DefaultTableModel getDft2() {
			return dft2;
		}
		public JComboBox getYeWuYuanBox() {
			return yeWuYuanBox;
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
		public JButton getTongJi() {
			return tongJi;
		}
		public JLabel getCaiGouDate() {
			return caiGouDate;
		}
		public JLabel getYeWuYuanName() {
			return yeWuYuanName;
		}
		
		public JLabel getJiLu() {
			return jiLu;
		}
		public JTable getDanJuBiao() {
			return danJuBiao;
		}
		public JLabel getPinZhong() {
			return pinZhong;
		}
		public JTable getXinXiBiao() {
			return xinXiBiao;
		}
		public JLabel getJiLu1() {
			return jiLu1;
		}
		public JTable getMingXiBiao() {
			return mingXiBiao;
		}
		public JLabel getPinZhong1() {
			return pinZhong1;
		}
		public JTable getHuiZongBiao() {
			return huiZongBiao;
		}
		public JTabbedPane getMainJPane() {
			return mainJPane;
		}
		public DefaultTableModel getDft3() {
			return dft3;
		}
		public DefaultTableModel getDft4() {
			return dft4;
		}
		
        public JLabel getXinXiLabel() {
			return xinXiLabel;
		}
        public static void main(String args[]){
	
        }		
	
}
