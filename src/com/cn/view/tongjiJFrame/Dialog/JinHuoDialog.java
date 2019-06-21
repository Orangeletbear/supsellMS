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
	
     JButton  addChaXun,changeCount,moveGoods,daoChu,daYin,tuiChu;//���尴ť
     DefaultTableModel dtm; //����Tablemodel
     JTable mainTable;//����JTable
     JLabel jiLu;
     String tableNames[]={"��Ʒ���","��Ʒ����","��λ","����ͺ�","��ɫ","��Ӧ��","�ο���������","��ǰ�������"};
     String column[][];
     
     JPopupMenu jpm;   
     JMenuItem dangQianGoods,allGoods; //JPopupMenu��ѡ��
     /**
      *�÷���������һ��JDialog���ڣ������а���6����ť��һ��JTable
      */
      public JinHuoDialog(JDialog frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  init();
      }
      private void init(){
    	  this.setSize(700,500);
    	  this.setLocationRelativeTo(null);//���ڵ�����
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new BorderLayout());
    	  /*
    	   * ��ť�������ʵ����
    	   */
    	  JPanel buttonP=new JPanel();
 		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
 		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
 		 /*
 		  * ��ťͼƬ�����
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
 		  * ���������ʾ����ʵ���������
 		  */
 		 jiLu=new JLabel("��¼����");
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
       * ��Ӽ�����
       */
      private void addAction(){
    	  addChaXun.addActionListener(this);
    	  changeCount.addActionListener(this);
    	  moveGoods.addActionListener(this);
    	  daoChu.addActionListener(this);
    	  tuiChu.addActionListener(this);
    	 
      }
      /**
       * ����һ��JPopupMenu ������
       */
      private JPopupMenu addJPopupMenu(){
    	  jpm=new JPopupMenu();
    	  dangQianGoods=new JMenuItem("ɾ����ǰ��Ʒ");
    	  allGoods=new JMenuItem("ɾ��������Ʒ");
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
			new JinHuoZhongDialog(this,"��Ӳο�������Ʒ",true);
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
			new XiuGaiDialog(this,"�޸�����",true);
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

