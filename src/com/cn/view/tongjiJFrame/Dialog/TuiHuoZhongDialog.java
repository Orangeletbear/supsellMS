package com.cn.view.tongjiJFrame.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;


public class TuiHuoZhongDialog extends JDialog implements ActionListener {
	TuiHuoDialog dialog;
     JTabbedPane mainPane;//���ѡ�������
     /*
      * ��������ѯѡ������
      */
     JTextField shangPinKind,xiaoShouLiang1,xiaoShouLiang2;
     JComboBox date;
     JButton chaXun,tianJia;
     JDatePicker datePickerTo,datePickerTo2; 
     
     String dateBoxNames[]={"����","����","ǰ��","�������","���һ����","����","����","����ʱ��"};
     String tableNames[]={"��Ʒ���","��Ʒ����","�������","��λ","����ͺ�","��ɫ","��������","�������"};
     String column[][];
     /*
      * ��Ķ��������������ʾ���Ķ���
      */
     DefaultTableModel dtm;
     JTable mainTable;
     JLabel jiLu;
    /*
     * ����Ʒ��ѯѡ������
     */
     JButton chaXun1,tianJia1;
     JTextField shangPinNames;
     JRadioButton xuanZe;
     /*
      * �������̲�ѯѡ������
      */
     JButton chaXun2,tianJia2;
	 JTextField gongHuoShangNames;
	/**
	 *  
     *�÷���������һ��JDialog���ڣ������а���3��ѡ���һ��JTable��
     *����ѡ��ֱ�Ϊ��������ѯ������Ʒ��ѯ���������̲�ѯ��
	 * @param jinHuoDialog
	 * @param title
	 * @param modal
	 */
      public TuiHuoZhongDialog(TuiHuoDialog dialog,String title,boolean modal){
    	  super(dialog,title,modal);
    	  this.dialog=dialog;
    	  init();
      }
      private void init(){
    	  this.setSize(800,400);
    	  this.setLocationRelativeTo(null);//���ڵ�����
    	  
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new BorderLayout());
    	  jp.setBorder(new TitledBorder("��ѯ�����Ʒ"));
    	  
    	  dtm=new DefaultTableModel(column,tableNames);
    	  mainTable=new JTable(dtm);
    	  JScrollPane mainP=new JScrollPane(mainTable);//JTable��ʵ����
    	  /*
    	   * ���������ӵ�������
    	   */
    	  jiLu=new JLabel("��¼���� ");
    	  JPanel jiLuP=new JPanel();
    	  jiLuP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	  jiLuP.add(jiLu);
    	  JPanel centrePane=new JPanel();
    	  centrePane.setLayout(new BorderLayout());
    	  centrePane.add(jiLuP,BorderLayout.SOUTH);
    	  centrePane.add(mainP);
    	  
    	  jp.add(addPane(),BorderLayout.NORTH);
    	  jp.add(centrePane);
    	  chaXun.addActionListener(this);
    	  chaXun1.addActionListener(this);
    	  chaXun2.addActionListener(this);
    	  xuanZe.addActionListener(this);
    	  tianJia.addActionListener(this);
    	  tianJia1.addActionListener(this);
    	  tianJia2.addActionListener(this);
    	  this.add(jp);
    	  this.setVisible(true);
    	  
      }
      /**
       * 3��ѡ���ʵ���������䷵��
       * @return
       */
    private JTabbedPane addPane(){
    	/*
    	 * ��������ѯѡ���ʵ��
    	 */
    	mainPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    	JLabel j1=new JLabel("��ѯ������");
    	JLabel j2=new JLabel("��ʼ���ڴӣ�");
    	JLabel zhi=new JLabel("��");
    	datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
    	datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
    	JLabel j3=new JLabel("��Ʒ���Ϊ");
    	JLabel j4=new JLabel("����������");
    	JLabel j5=new JLabel("����С��");
    	chaXun=new JButton("��ѯ");
    	tianJia=new JButton("��ӵ��ο��˻�");
    	date=new JComboBox(dateBoxNames);
  	    shangPinKind=new JTextField("�������");
  	    xiaoShouLiang1=new JTextField();
  	    xiaoShouLiang1.setPreferredSize(new Dimension(40,20));
  	    xiaoShouLiang2=new JTextField();
  	    xiaoShouLiang2.setPreferredSize(new Dimension(40,20));
  	    JPanel mainP1=new JPanel();
  	    mainP1.setLayout(new GridBagLayout());
  	    mainP1.add(j1,new GBC(0,0));
  	    mainP1.add(j2,new GBC(1,0));
  	    mainP1.add(datePickerTo,new GBC(2,0));
  	    mainP1.add(zhi,new GBC(3,0));
  	    mainP1.add(datePickerTo2,new GBC(4,0));
  	    mainP1.add(date,new GBC(5,0).setInsets(5, 5, 5, 5));
  	    mainP1.add(j3,new GBC(6,0));
  	    mainP1.add(shangPinKind,new GBC(7,0));
  	    mainP1.add(j4,new GBC(1,1));
  	    mainP1.add(xiaoShouLiang1,new GBC(2,1));
  	    mainP1.add(j5,new GBC(3,1));
  	    mainP1.add(xiaoShouLiang2,new GBC(4,1));
  	    mainP1.add(chaXun,new GBC(5,1));
  	    mainP1.add(tianJia,new GBC(6,1));
  	    /*
  	     * ����Ʒ��ѯѡ���ʵ��
  	     */
  	    JLabel j6=new JLabel("������Ʒ��Ż�����");
  	    shangPinNames=new JTextField();
  	    shangPinNames.setPreferredSize(new Dimension(80,20));
  	    chaXun1=new JButton("��ѯ");
  	    tianJia1=new JButton("��ӵ��ο��˻�");
  	    JPanel j=new JPanel();
  	    j.add(j6);
  	    j.add(shangPinNames);
  	    j.add(chaXun1);
  	    j.add(tianJia1);
  	    xuanZe=new JRadioButton("ֻ��ʾ��汨����Ʒ");
  	    xuanZe.setForeground(Color.red);
  	    JPanel mainP2=new JPanel();
  	    mainP2.setLayout(new BorderLayout());
  	    mainP2.add(j,BorderLayout.NORTH);
  	    JPanel jn=new JPanel();
  	    jn.setLayout(new FlowLayout(FlowLayout.CENTER));
  	    jn.add(xuanZe);
  	    mainP2.add(jn);
  	    /*
  	     * �������̲�ѯѡ���ʵ��
  	     */
  	    JLabel j7=new JLabel("���빩�������ƻ���룺");
  	    gongHuoShangNames=new JTextField(20);
  	    chaXun2=new JButton("��ѯ");
  	    tianJia2=new JButton("��ӵ��ο��˻�");
  	    JPanel mainP3=new JPanel();
  	    mainP3.add(j7);
  	    mainP3.add(gongHuoShangNames);
  	    mainP3.add(chaXun2);
  	    mainP3.add(tianJia2);
  	    /*
  	     *���
  	     */
  	    mainPane.add("��������ѯ",mainP1);
  	    
  	    mainPane.add("����Ʒ��ѯ",mainP2);
  	    
  	    mainPane.add("�������̲�ѯ",mainP3);
  	  return mainPane;
    }
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==chaXun){
      	  try {
				Vector vector=JinHuoJDBC.getTiaoJianJDBC(DateConventer.dateToStr(datePickerTo.getSelectedDate()), 
						  DateConventer.dateToStr(datePickerTo2.getSelectedDate()), 
								  shangPinKind.getText(),xiaoShouLiang1.getText(),xiaoShouLiang2.getText());
				dtm.setDataVector(vector, AllTableModel.getVectorFromObj(tableNames));
				mainTable.requestFocus();
				mainTable.setRowSelectionInterval(0, 0);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }		
        if(e.getSource()==chaXun1){
      	  Vector vector=JinHuoJDBC.getShangPinJDBC(shangPinNames.getText());
			dtm.setDataVector(vector, AllTableModel.getVectorFromObj(tableNames));
			mainTable.requestFocus();
			mainTable.setRowSelectionInterval(0, 0);
        }
        if(e.getSource()==chaXun2){
      	  Vector vector=JinHuoJDBC.getGongHuoShangJDBC(gongHuoShangNames.getText());
			dtm.setDataVector(vector, AllTableModel.getVectorFromObj(tableNames));
			mainTable.requestFocus();
			mainTable.setRowSelectionInterval(0, 0);
        }
        if(e.getSource()==xuanZe){
      	  if(xuanZe.isSelected()){
      		  Vector vector=JinHuoJDBC.getXuanZeJDBC();
      			dtm.setDataVector(vector, AllTableModel.getVectorFromObj(tableNames));
      			mainTable.requestFocus();
      			mainTable.setRowSelectionInterval(0, 0);
      	  }
      	  else{
      		  Vector vector=JinHuoJDBC.getShangPinJDBC(shangPinNames.getText());
    			dtm.setDataVector(vector, AllTableModel.getVectorFromObj(tableNames));
    			mainTable.requestFocus();
    			mainTable.setRowSelectionInterval(0, 0);
      	  }
        }
        if(e.getSource()==tianJia){
      	  new TuiHuoCanShuDialog(this,"����ο��˻�����",true);
        }
        if(e.getSource()==tianJia1){
      	  new TuiHuoCanShuDialog(this,"����ο��˻�����",true);
        }
        if(e.getSource()==tianJia2){
      	  new TuiHuoCanShuDialog(this,"����ο��˻�����",true);
        }
	}
	public String[] getTableNames() {
		return tableNames;
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public JTable getMainTable() {
		return mainTable;
	}
	public TuiHuoDialog getDialog() {
		return dialog;
	}
	
}

