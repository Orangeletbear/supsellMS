package com.cn.view.systemJFrame.CangKuXheZhi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.control.systemframe.storage.ChangeStorageActive;
import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.StorageCulomns;
import com.cn.view.systemJFrame.CangKuSheZhi;
import com.cn.view.systemJFrame.GongHuoShang;
/*
 * �޸Ĳֿ�Ի���
 */
public class ChangeStorage extends JDialog {
	
	JTextField t1;//�ֿ�����
	JTextField t2;//������
	JTextField t3;//��ϵ��
	JTextField t4;//��ϵ�绰
	JTextField t5;//��ע
	public JCheckBox c1;//Ĭ�ϲֿ�
	public JCheckBox c2;//POS�ֿ�
	JButton jb1;//ȷ��
 
   public JTextField getT1() {
		return t1;
	}

	public JTextField getT2() {
		return t2;
	}

	public JTextField getT3() {
		return t3;
	}

	public JTextField getT4() {
		return t4;
	}

	public JTextField getT5() {
		return t5;
	}

	public JCheckBox getC1() {
		return c1;
	}

	public JCheckBox getC2() {
		return c2;
	}

	public JButton getJb1() {
		return jb1;
	}

public ChangeStorage(CangKuSheZhi ck,String title, boolean b){
	   super(ck,title,true);
	   init();
	   initData();
	   this.setVisible(true);
   }
	
   public void initData(){
	   int row = CangKuSheZhi.getTable().getSelectedRow();
	   Vector data = new Vector();
	   int count = CangKuSheZhi.getTablemodel().getColumnCount();
	    
	   for(int i = 0;i<count;i++){
		   data.add(CangKuSheZhi.getTablemodel().getValueAt(row, i));
	    
	   }
	   if(data.get(0)!=null){
	   t1.setText(  data.get(0).toString().trim());
	   }else{t1.setText("");}
	   
	   if(data.get(1)!=null){
	   t2.setText(  data.get(1).toString().trim());}
	   else{t1.setText("");}
	   
	   if(data.get(2)!=null){
	   t3.setText(  data.get(2).toString().trim());}
	   else{t1.setText("");}
	   
	   if(data.get(3)!=null){
	   t4.setText(  data.get(3).toString().trim());}
	   else{t1.setText("");}
	   
	   if(data.get(6)!=null){
	   t5.setText(  data.get(6).toString().trim());}
	   else{t5.setText("");}
	   
	   //System.out.println(data.get(4));
	    if(data.get(4)!=null){
	      if(data.get(4).toString().equals("��")){
		     this.c1.setSelected(true);}
	          else{this.c1.setSelected(false);}
	        }else{this.c1.setSelected(false);}
	     
	   
	   if(data.get(5)!=null){
	      if(data.get(5).toString().equals("��")){
		     c2.setSelected(true);}
		    else{c2.setSelected(false);}
	      }else{c2.setSelected(false);}
	  
	    
	   data.removeAllElements();
	   
   }
   
   public void init(){
	   
     this.setSize(230,250);
	 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 this.setLocationRelativeTo(null);
	 this.setResizable(false);
	 JPanel pa = new JPanel();
	//JPanel pa1 = new JPanel();
	//JPanel pa2 = new JPanel();
	//JPanel pa3 = new JPanel();
	 pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
	 JLabel b1 = new JLabel("�ֿ�����");
	 JLabel b2 = new JLabel("�� �� ��");
	 JLabel b3 = new JLabel("��ϵ�绰");
	 JLabel b4 = new JLabel("��ϵ��ַ");
	 JLabel b5 = new JLabel("��   ע ");
	 t1 = new JTextField(21);
	 t2 = new JTextField(21);
	  t3 = new JTextField(21);
	  t4 = new JTextField(21);
	  t5 = new JTextField(21);
	 pa.add(b1);pa.add(t1);
	 pa.add(b2);pa.add(t2);
	 pa.add(b3);pa.add(t3);
	 pa.add(b4);pa.add(t4);
	 pa.add(b5);pa.add(t5);
    
	 
	   c1 = new JCheckBox("Ĭ�ϲֿ�");
	   c2 = new JCheckBox("POS�ֿ�");
	 jb1 = new JButton("ȷ��(F5)");
	
	 /*
	  * �޸Ĳֿ� ȷ���� �ļ���
	  */
	 
	     jb1.addActionListener(new ChangeStorageActive(this));
	  
	
	 
		JButton jb2 = new JButton("�˳�(F4)");
		 jb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			ChangeStorage.this.dispose();
				
			}});
		 pa.add(c1);
		 pa.add(c2);
		
		 
		 pa.add(jb1);
		 pa.add(jb2);
		 pa.setLayout(new FlowLayout(FlowLayout.CENTER));
		  
		this.add(pa);
		//this.setVisible(true);
		}
		
}
