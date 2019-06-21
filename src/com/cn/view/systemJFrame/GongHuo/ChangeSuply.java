package com.cn.view.systemJFrame.GongHuo;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cn.control.systemframe.suplly.ChangeSupllyAction;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.GongHuoShang;
/*
 * 修改供应商对话框
 */
public class ChangeSuply extends JDialog {
	JTextField t1;//供货商名称
	JTextField t2;//负责人
	JTextField t3;//联系电话
	JTextField t4;//联系地址
	JTextArea t5;//备注
	JCheckBox c1 ;//默认供货商
	JButton jb1;
	  JCheckBox c2;
	 public JTextField getLa() {
		return la;
	}

	JTextField la;
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

	public JCheckBox getC1() {
		return c1;
	}

	public JButton getJb1() {
		return jb1;
	}

	
	public ChangeSuply(GongHuoShang set,String str,boolean bo){
		super(set,str,true);
		init();
		initData();
		this.setVisible(true);
	}
   private void initData() {
		
	   GongHuoShang frame = (GongHuoShang)this.getOwner();
	    int row = frame.getTable().getSelectedRow();
	
	    Vector data = new Vector();
	for(int i = 0 ; i<frame.getSupplyModel().getColumnCount() ; i++){
		data.add(frame.getSupplyModel().getValueAt(row, i));
	}
	   //  System.out.println(data.size());
	     t1.setText(data.get(0).toString());
	  
	  if(data.get(1)!=null){
	     t2.setText(data.get(1).toString());
	     }else{t2.setText("");}
	  if(data.get(2)!=null){
	     t3.setText(data.get(2).toString());}
	     else{t3.setText("");}
	  
	  if(data.get(3)!=null){
		     la.setText(data.get(3).toString());}
		    else{la.setText("");}
	  
	  if(data.get(4)!=null){
	     t4.setText((String) data.get(4));}
	    else{t4.setText("");}
	  
	
	
	  
	if(data.get(5)!=null){  
	  if(data.get(5).toString().equals("是")){
		    this.c1.setSelected(true);
    	}else{
	    	this.c1.setSelected(false);
	    }
	  }
	else{this.c1.setSelected(false);}
	
	
	if(data.get(6)!=null){
		if(data.get(6).toString().equals("是")){
		    this.c2.setSelected(true);
    	}else{
	    	this.c2.setSelected(false);
	    }
	  } else{this.c2.setSelected(false);}
	
	
	if(data.get(7)!=null){
		t5.setText(data.get(7).toString());
	}
	   else{t5.setText("");}
	
	data.removeAllElements();
	}
	 


//	JDialog dia = new JDialog((JFrame)null, title,false);
	//dia.setName("  ");
	
	private void init(){
	this.setSize(250,280);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	JPanel pa = new JPanel();
	//JPanel pa1 = new JPanel();
	//JPanel pa2 = new JPanel();
	//JPanel pa3 = new JPanel();
	pa.setLayout(new FlowLayout(FlowLayout.RIGHT,2,48));
	JLabel b1 = new JLabel("供货商 名称");
	JLabel b2 = new JLabel("负  责  人 ");
	JLabel b3 = new JLabel("联 系 电 话");
	JLabel b4 = new JLabel("联 系 地 址");
	JLabel b5 = new JLabel("  备  注   ");
	  t1 = new JTextField(21);
	  t2 = new JTextField(21);
	  t3 = new JTextField(21);
	  t4 = new JTextField(21);
	  t5 = new JTextArea("普通供货商为 不固定的商品供货商",4,21);
	JScrollPane js = new JScrollPane(t5);
	 js.add(t5,JScrollPane.RIGHT_ALIGNMENT);
	 t5.setPreferredSize(new Dimension(14,17));
	pa.add(b1);pa.add(t1);
	pa.add(b2);pa.add(t2);
	pa.add(b3);pa.add(t3);
	pa.add(b4);pa.add(t4);
	pa.add(b5);pa.add(t5);
    JLabel l = new JLabel("我方应付:");
	  la = new JTextField(4);
	  c1 = new JCheckBox("默认: ");
	 c2 = new JCheckBox("禁用:");
	//JCheckBox c2 = new JCheckBox("   POS仓库  ");
	 jb1 = new JButton("确认(F5)");
	 jb1.addActionListener(new ChangeSupllyAction(this));
	 
	 
	JButton jb2 = new JButton("退出(F4)");
	jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
		    ChangeSuply.this.dispose();
			
		}
		
	});
	pa.add(l);
	pa.add(la);
	pa.add(c1);
	pa.add(c2);
	//pa.add(c2);
	
	 
	pa.add(jb1);
	pa.add(jb2);
	pa.setLayout(new FlowLayout(FlowLayout.CENTER));
	 
	this.add(pa);
	//this.setVisible(true);
	}

	public JCheckBox getC2() {
		return c2;
	}

}
