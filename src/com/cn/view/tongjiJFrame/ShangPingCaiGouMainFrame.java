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
	 * 5����ť��ѡ��е�����
	 */
	JButton check,checkDanJu,daoChu,daYin,tuiChu,tongJi;
	JLabel caiGouDate,zhi,shangPinKind,shangPingMing;
	JDatePicker datePickerTo,datePickerTo2; 
	JComboBox shangPinText;
	JTextField shangPinNameText;
	/*
	 * �ɹ���Ʒ��ϸѡ��е�JTable��JLabel
	 */
	JLabel jiLu;
	JTable shangPinTable;
	/*
	 * �ɹ���Ʒ����ѡ��е�JTable��JLabel
	 */
	JLabel jiLu1;
	JTable huiZongTable;
	/*
	 * �ɹ���Ʒͳ�Ʊ�ѡ��е�JTable��JLabel
	 */
	JLabel shangPinShu;
	JTable tongJiTable;
	
	JTabbedPane xuanXiangKa;//װ����ѡ��������
	DefaultTableModel dtm,dtm2,dtm3; //����JTable��model
	
	/**
	 * �ķ���������һ��JDialog���ڣ���������5����ť����һ�����������Լ�����ѡ���5����ť�ֱ���
	 * ���ң��鿴���ݣ���������ӡ���˳������������в��ҵ�ʱ��Σ����ҵ���Ʒ������Ʒ���ƣ���š�
	 * ѡ��ֱ��ǲɹ���Ʒ��ϸ���ɹ���Ʒ���ܣ��ɹ���Ʒͳ�Ʊ�
	 */
	 public ShangPingCaiGouMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(900, 600);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);   //�������ڵ�����
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * ʵ����5����ť������������ӵ�һ�������
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
		  * ʵ���������������ݣ�����ӵ�һ�����
		  */
		 caiGouDate=new JLabel("�ɹ�ʱ��");
		 zhi=new JLabel("��");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 shangPinKind=new JLabel("��Ʒ���");
		 shangPingMing=new JLabel("��Ʒ���ƻ���");
		 shangPinText=new JComboBox(JDBCCuCunFind.getSpLbData());
		 shangPinText.addItem("������");
		 shangPinText.setSelectedItem("������");
		 shangPinNameText=new JTextField(10);
		 tongJi=new JButton("ͳ��");
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
		  * ��������ֱ���ӵ�������
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
            	  new DanJuDialog(ShangPingCaiGouMainFrame.this,"���ݱ�",true);
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
      * �ķ�����3��ѡ�ʵ����������3��JTable���·���JLabel�ֱ���ӵ�ѡ���
      * �ٽ�ѡ���ӵ�һ��JTabbedPane�в�����
      * @return
      */
     private  JTabbedPane addTabbed(){
    	 dtm=new AllTableModel(tongJiModel.column,tongJiModel.tableNames);
    	 dtm.isCellEditable(0, 0);
    	 shangPinTable=new JTable(dtm);
    	 JScrollPane mingXiP=new JScrollPane(shangPinTable);
    	 jiLu=new JLabel("��¼�� ��");
    	 jiLu.setForeground(Color.red);
    	 JPanel JLabelP=new JPanel();
    	 JLabelP.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 JLabelP.add(jiLu);
    	 JPanel mingXiZongP=new JPanel();
    	 mingXiZongP.setLayout(new BorderLayout());
    	 mingXiZongP.add(JLabelP,BorderLayout.SOUTH);
    	 mingXiZongP.add(mingXiP);
    	 
    	 shangPinShu=new JLabel("��Ʒ�� ��");
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
    	 
    	 
    	 jiLu1=new JLabel("��¼�� ��");
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
    	 xuanXiangKa.add("�ɹ���Ʒ��ϸ",mingXiZongP);
    	 xuanXiangKa.add("�ɹ���Ʒ����",huiZongZongP);
    	 xuanXiangKa.add("�ɹ���Ʒ����ͳ�Ʊ�",tongJiZongP);
    	 return xuanXiangKa;
     }
     /**
      * ��Ӽ�����
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
	 * ʵ�ּ�����
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==check){
			new ShangPinCaiGouCheckDialog(this,"����",true);
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
	    	new DanJuDialog(this,"���ݱ�",true);
	    }
	}

}
