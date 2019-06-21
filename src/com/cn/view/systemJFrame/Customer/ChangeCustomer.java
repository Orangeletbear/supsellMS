package com.cn.view.systemJFrame.Customer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cn.control.systemframe.customer.ChangeCustomerActive;
import com.cn.view.systemJFrame.CustomerSet;
/*
 * 修改顾客信息对话框
 */
public class ChangeCustomer extends  JDialog {
	
	
	JTextField t1;//客房名称
	JTextField t2;//负责人
	JTextField t3;//联系电话
	JTextField t4;//联系地址
	JTextArea t5;//备注
	JTextField jf;//初期应收
	public JCheckBox c1;//默认客房
	public JCheckBox c2;//禁用
	JButton jb1;//确定	
	
	
	
	public JCheckBox getC1() {
		return c1;
	}

	public JButton getJb1() {
		return jb1;
	}

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

	public JTextArea getT5() {
		return t5;
	}

	public ChangeCustomer(CustomerSet set,String str,boolean bo){
		super(set,str,bo);
		init();
		initData();
		this.setVisible(true);
		
	}
	/*
	 * 从选中行获取数据
	 * 显示在相应界面上
	 */
	private void initData(){
		CustomerSet frame = (CustomerSet)this.getOwner();
		    int row = frame.getTable().getSelectedRow();
		
		    Vector data = new Vector();
		for(int i = 0 ; i<frame.getCustomerModel().getColumnCount() ; i++){
			data.add(frame.getCustomerModel().getValueAt(row, i));
		}
		     System.out.println(data.size());
		     System.out.println(data.get(6).toString());
		     if(data.get(7)!=null){
		     System.out.println(data.get(7).toString());}
		     t1.setText(data.get(0).toString());
		     
		  if(data.get(1)!=null){
		     t2.setText(data.get(1).toString());
		     }else{t2.setText("");}
		  
		  if(data.get(2)!=null){
		     t3.setText(data.get(2).toString());}
		     else{t3.setText("");}
		
		  if(data.get(4)!=null){
		     t4.setText(data.get(4).toString());}
		    else{t4.setText("");}
		  
		  if(data.get(3)!=null){
		     jf.setText(data.get(3).toString());}
		    else{jf.setText("");}
		
		  
		if(data.get(5)!=null  ){  
		  if(data.get(5).toString().equals("是")){
			    this.c1.setSelected(true);
	     	}else{
		    	this.c1.setSelected(false);
		    }
		  }
		    else{this.c1.setSelected(false);}
		
		
		if(data.get(6)!=null  ){
			if(data.get(6).toString().equals("是")){
			    this.c2.setSelected(true);
	     	}else{
		    	this.c2.setSelected(false);
		    }
		  }
		   else{this.c2.setSelected(false);}
		
		if(data.get(7) !=null){
			t5.setText(data.get(7).toString());
		}else{t5.setText("");}
		
		
		data.removeAllElements();
		}
		 

	
	
	
	private void init(){
	this.setSize(244,270);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	JPanel pa = new JPanel();
	 
	pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
	JLabel b1 = new JLabel("客户名称");
	JLabel b2 = new JLabel("负 责 人");
	JLabel b3 = new JLabel("联系电话");
	JLabel b4 = new JLabel("联系地址");
	JLabel b5 = new JLabel(" 备  注 ");
	  t1 = new JTextField(21);
	  t2 = new JTextField(21);
	  t3 = new JTextField(21);
	  t4 = new JTextField(21);
	  t5 = new JTextArea(3,21);
	 JScrollPane js = new JScrollPane(t5);
	 js.add(t5,JScrollPane.RIGHT_ALIGNMENT);

	pa.add(b1);pa.add(t1);
	pa.add(b2);pa.add(t2);
	pa.add(b3);pa.add(t3);
	pa.add(b4);pa.add(t4);
	pa.add(b5);pa.add(t5);
    
	 JLabel b = new JLabel("初期应收：");
	  jf = new JTextField("0.00",4);
	  c1 = new JCheckBox("默认客户",true);
	  c2 = new JCheckBox("禁用");
	//JCheckBox c2 = new JCheckBox("   POS仓库  ");
      jb1 = new JButton("确认(F5)");
      
      jb1.addActionListener(new ChangeCustomerActive(this));
	
      JButton jb2 = new JButton("退出(F4)");
	
      jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			ChangeCustomer.this.dispose();
			
		}});
	 pa.add(b);pa.add(jf);
	 pa.add(c1);
	 pa.add(c2);
	
	 
	pa.add(jb1);
	pa.add(jb2);
	pa.setLayout(new FlowLayout(FlowLayout.CENTER));
	 
	this.add(pa);
	
	}

	public JCheckBox getC2() {
		return c2;
	}

	public JTextField getJf() {
		return jf;
	}
   public static void main(String[] args){
	new ChangeCustomer(null,null,true);
}
}
