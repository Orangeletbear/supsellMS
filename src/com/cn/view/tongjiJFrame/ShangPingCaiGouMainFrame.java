package com.cn.view.tongjiJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.CaiGouListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.ShangPinCaiGouCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.DanJuDialog;

public class ShangPingCaiGouMainFrame extends JDialog implements ActionListener {
	/*
	 * 5个按钮和选项卡中的内容
	 */
	JButton check,checkDanJu,daoChu,daYin,tuiChu,tongJi;
	JLabel caiGouDate,zhi,shangPinKind,shangPingMing;
	JDatePicker datePickerTo,datePickerTo2; 
	JComboBox shangPinText;
	JTextField shangPinNameText;
	/*
	 * 采购商品明细选项卡中的JTable和JLabel
	 */
	JLabel jiLu;
	JTable shangPinTable;
	/*
	 * 采购商品汇总选项卡中的JTable和JLabel
	 */
	JLabel jiLu1;
	JTable huiZongTable;
	/*
	 * 采购商品统计表选项卡中的JTable和JLabel
	 */
	JLabel shangPinShu;
	JTable tongJiTable;
	
	JTabbedPane xuanXiangKa;//装三个选项卡的主面板
	DefaultTableModel dtm,dtm2,dtm3; //三个JTable的model
	
	/**
	 * 改方法创建了一个JDialog窗口，窗口中有5个按钮，和一个查找栏，以及三个选项卡。5个按钮分别是
	 * 查找，查看单据，导出，打印，退出。查找栏中有查找的时间段，查找的商品或者商品名称，编号。
	 * 选项卡分别是采购商品明细，采购商品汇总，采购商品统计表。
	 */
	 public ShangPingCaiGouMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(900, 600);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);   //对主窗口的设置
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * 实例化5个按钮，并将他们添加到一个面板中
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
		  * 实例化查找栏的内容，并添加到一个面板
		  */
		 caiGouDate=new JLabel("采购时间");
		 zhi=new JLabel("至");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 shangPinKind=new JLabel("商品类别");
		 shangPingMing=new JLabel("商品名称或编号");
		 shangPinText=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinText.addItem("所有类");
		 shangPinText.setSelectedItem("所有类");
		 shangPinNameText=new JTextField(10);
		 tongJi=new JButton("统计");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo);
		 northP.add(zhi);
		 northP.add(datePickerTo2);

		 northP.add(shangPinKind);
		 northP.add(shangPinText);
		 northP.add(shangPingMing);
		 northP.add(shangPinNameText);
		 northP.add(tongJi);
		 /*
		  * 将各组件分别添加到主界面
		  */
		 JPanel centreP=new JPanel();
		 centreP.setLayout(new BorderLayout());
		 centreP.add(northP,BorderLayout.NORTH);
		 centreP.add(addTabbed());
		 jp.add(buttonP,BorderLayout.NORTH);
		 jp.add(centreP);
		 addAction();
		 shangPinTable.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
              if(e.getClickCount()==2){
            	  new DanJuDialog(ShangPingCaiGouMainFrame.this,"单据表",true);
              }				
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
			}
		 });
		 tongJi.addActionListener(l);
		 this.add(jp);
		 this.setVisible(true);
     }
     /**
      * 改方法将3个选项卡实例化，并将3个JTable和下方的JLabel分别添加到选项卡中
      * 再将选项卡添加到一个JTabbedPane中并返回
      * @return
      */
     private  JTabbedPane addTabbed(){
    	 dtm=new AllTableModel(tongJiModel.column,tongJiModel.tableNames);
    	 dtm.isCellEditable(0, 0);
    	 shangPinTable=new JTable(dtm);
    	 JScrollPane mingXiP=new JScrollPane(shangPinTable);
    	 jiLu=new JLabel("记录数 ：");
    	 jiLu.setForeground(Color.red);
    	 JPanel JLabelP=new JPanel();
    	 JLabelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 JLabelP.add(jiLu);
    	 JPanel mingXiZongP=new JPanel();
    	 mingXiZongP.setLayout(new BorderLayout());
    	 mingXiZongP.add(JLabelP,BorderLayout.SOUTH);
    	 mingXiZongP.add(mingXiP);
    	 
    	 shangPinShu=new JLabel("商品数 ：");
    	 shangPinShu.setForeground(Color.red);
    	 JPanel JLabelP1=new JPanel();
    	 JLabelP1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 JLabelP1.add(shangPinShu);
    	 dtm2=new AllTableModel(tongJiModel.column2,tongJiModel.huiZongName);
    	 dtm2.isCellEditable(0, 0);
    	 huiZongTable=new JTable(dtm2);
    	 JScrollPane huiZongP=new JScrollPane(huiZongTable);
    	 JPanel huiZongZongP=new JPanel();
    	 huiZongZongP.setLayout(new BorderLayout());
    	 huiZongZongP.add(JLabelP1,BorderLayout.SOUTH);
    	 huiZongZongP.add(huiZongP);
    	 
    	 
    	 jiLu1=new JLabel("记录数 ：");
    	 jiLu1.setForeground(Color.red);
    	 JPanel JLabelP2=new JPanel();
    	 JLabelP2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 JLabelP2.add(jiLu1);
    	 JLabelP2.add(new JLabel("                                "));
    	 JLabelP2.add(new JLabel("         "));
    	 dtm3=new AllTableModel(tongJiModel.column3,tongJiModel.tongJiName);
    	 dtm3.isCellEditable(0, 0);
    	 tongJiTable=new JTable(dtm3);
    	 JScrollPane tongJiP=new JScrollPane(tongJiTable);
    	 JPanel tongJiZongP=new JPanel();
    	 tongJiZongP.setLayout(new BorderLayout());
    	 tongJiZongP.add(JLabelP2,BorderLayout.SOUTH);
    	 tongJiZongP.add(tongJiP);
    	 
    	 xuanXiangKa=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
    	 xuanXiangKa.add("采购商品明细",mingXiZongP);
    	 xuanXiangKa.add("采购商品汇总",huiZongZongP);
    	 xuanXiangKa.add("采购商品分类统计表",tongJiZongP);
    	 return xuanXiangKa;
     }
     /**
      * 添加监听器
      */
     private void addAction(){
    	 check.addActionListener(this);
    	 checkDanJu.addActionListener(this);
    	 daoChu.addActionListener(this);
    	 tuiChu.addActionListener(this);
    	 
     }
     ActionListener l= new CaiGouListener(this);
     
	public JComboBox getShangPinText() {
		return shangPinText;
	}
	
	public JDatePicker getDatePickerTo() {
		return datePickerTo;
	}
	public JDatePicker getDatePickerTo2() {
		return datePickerTo2;
	}
	public JLabel getJiLu() {
		return jiLu;
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
	public JLabel getShangPinShu() {
		return shangPinShu;
	}
	public JTable getShangPinTable() {
		return shangPinTable;
	}

	public JLabel getCaiGouDate() {
		return caiGouDate;
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
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public DefaultTableModel getDtm2() {
		return dtm2;
	}
	public DefaultTableModel getDtm3() {
		return dtm3;
	}
	public JTable getHuiZongTable() {
		return huiZongTable;
	}
	public JLabel getJiLu1() {
		return jiLu1;
	}
	public ActionListener getL() {
		return l;
	}
	public JButton getTongJi() {
		return tongJi;
	}
	public JTable getTongJiTable() {
		return tongJiTable;
	}
	public JButton getTuiChu() {
		return tuiChu;
	}
	public JTabbedPane getXuanXiangKa() {
		return xuanXiangKa;
	}
	public JLabel getZhi() {
		return zhi;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ShangPingCaiGouMainFrame(null,"",true);
	}
	/*
	 * 实现监听器
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==check){
			new ShangPinCaiGouCheckDialog(this,"查找",true);
		}
		if(e.getSource()==daoChu){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    //int value = chooser.showOpenDialog(frame);
		    System.out.println("value : " + value);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		      //this.mingBianT.setText(f.getAbsolutePath());
		      //System.out.println(f.getAbsolutePath());
		    }
		    
		}
		if(e.getSource()==tuiChu){
	    	this.dispose();
	    }
	    if(e.getSource()==checkDanJu){
	    	new DanJuDialog(this,"单据表",true);
	    }
	}

}
