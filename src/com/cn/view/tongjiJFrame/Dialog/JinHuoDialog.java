package com.cn.view.tongjiJFrame.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;


public class JinHuoDialog extends JDialog implements ActionListener {
	
     JButton  addChaXun,changeCount,moveGoods,daoChu,daYin,tuiChu;//定义按钮
     DefaultTableModel dtm; //定义Tablemodel
     JTable mainTable;//定义JTable
     JLabel jiLu;
     String tableNames[]={"商品编号","商品名称","单位","规格型号","颜色","供应商","参考进货数量","当前库存数量"};
     String column[][];
     
     JPopupMenu jpm;   
     JMenuItem dangQianGoods,allGoods; //JPopupMenu的选项
     /**
      *该方法创建了一个JDialog窗口，窗口中包括6个按钮和一个JTable
      */
      public JinHuoDialog(JDialog frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  init();
      }
      private void init(){
    	  this.setSize(700,500);
    	  this.setLocationRelativeTo(null);//窗口的设置
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new BorderLayout());
    	  /*
    	   * 按钮的添加与实例化
    	   */
    	  JPanel buttonP=new JPanel();
 		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
 		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
 		 /*
 		  * 按钮图片的添加
 		  */
 		 addChaXun=new JButton(new ImageIcon("res\\AcionIcon\\tianjiachaxun.jpg"));
 		 addChaXun.setMargin(new Insets(0,0,0,0));
		 buttonP.add(addChaXun);
		 changeCount=new JButton(new ImageIcon("res\\AcionIcon\\xiugaishuliang.jpg"));
		 changeCount.setMargin(new Insets(0,0,0,0));
		 buttonP.add(changeCount);
		 moveGoods=new JButton(new ImageIcon("res\\AcionIcon\\movegoods.jpg"));
		 moveGoods.setMargin(new Insets(0,0,0,0));
		 buttonP.add(moveGoods); 
    	 daoChu=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
 		 daoChu.setMargin(new Insets(0,0,0,0));
 		 buttonP.add(daoChu);
 		 daYin=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
 		 daYin.setMargin(new Insets(0,0,0,0));
 		 buttonP.add(daYin);
 		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
 		 tuiChu.setMargin(new Insets(0,0,0,0));
 		 buttonP.add(tuiChu);
    	  
 		 dtm=new AllTableModel(column,tableNames);
 		 dtm.isCellEditable(0, 0);
 		 mainTable=new JTable(dtm);
 		 JScrollPane mainP=new JScrollPane(mainTable);
 		 /*
 		  * 表下面的显示条的实例化与添加
 		  */
 		 jiLu=new JLabel("记录数：");
		 jiLu.setForeground(Color.red);
		 JPanel jiLuP=new JPanel();
		 jiLuP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 jiLuP.add(jiLu);
		 JPanel jinHuoP=new JPanel();
		 jinHuoP.setLayout(new BorderLayout());
		 jinHuoP.add(jiLuP,BorderLayout.SOUTH);
		 jinHuoP.add(mainP);
 		 jp.add(buttonP,BorderLayout.NORTH);
 		 jp.add(jinHuoP);
 		 addAction();
    	  this.add(jp);
    	  this.setVisible(true);
    	  
      }
      /**
       * 添加监听器
       */
      private void addAction(){
    	  addChaXun.addActionListener(this);
    	  changeCount.addActionListener(this);
    	  moveGoods.addActionListener(this);
    	  daoChu.addActionListener(this);
    	  tuiChu.addActionListener(this);
    	 
      }
      /**
       * 创建一个JPopupMenu 并返回
       */
      private JPopupMenu addJPopupMenu(){
    	  jpm=new JPopupMenu();
    	  dangQianGoods=new JMenuItem("删除当前商品");
    	  allGoods=new JMenuItem("删除所有商品");
    	  dangQianGoods.addActionListener(this);
    	  allGoods.addActionListener(this);
    	  jpm.add(dangQianGoods);
    	  jpm.add(allGoods);
    	  return jpm;
      }
      
      public DefaultTableModel getDtm() {
		return dtm;
	}
	public JTable getMainTable() {
		return mainTable;
	}
	
	public String[] getTableNames() {
		return tableNames;
	}
	
	public JLabel getJiLu() {
		return jiLu;
	}
	/**
       * 
       */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addChaXun){
			new JinHuoZhongDialog(this,"添加参考进货商品",true);
		}
		if(e.getSource()==moveGoods){
			addJPopupMenu().show(moveGoods,50,50);
		}
		if(e.getSource()==daoChu){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		    }
		}
		if(e.getSource()==tuiChu){
			this.dispose();
		}
		if(e.getSource()==changeCount){
			new XiuGaiDialog(this,"修改数量",true);
		}
	   if(e.getSource()==dangQianGoods){
		  Vector mainV=dtm.getDataVector();
		  mainV.remove(mainTable.getSelectedRow());
		  dtm.setDataVector(mainV, AllTableModel.getVectorFromObj(tableNames));
	   }
	   if(e.getSource()==allGoods){
		   Vector mainV=dtm.getDataVector();
			  mainV.removeAll(mainV);
			  dtm.setDataVector(mainV, AllTableModel.getVectorFromObj(tableNames));
	   }
	}
}

