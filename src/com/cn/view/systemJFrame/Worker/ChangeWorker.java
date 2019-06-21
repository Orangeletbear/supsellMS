package com.cn.view.systemJFrame.Worker;

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
import javax.swing.JTextField;

import com.cn.control.systemframe.worker.ChangeWorkerAction;
import com.cn.dao.system.WorkerDB;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.WorkSet;
/*
 * 修改员工对话框
 */
public class ChangeWorker extends JDialog {
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	
	JCheckBox c1;//采购管理
	JCheckBox c2;//销售管理
	JCheckBox c3;//库存管理
	
	
	public ChangeWorker(WorkSet set,String title,boolean bo){
		super(set,title,true);
		
		init();
		initData();
		this.setVisible(true);
	}

    private void initData() {
    	//WorkSet frame = (WorkSet)this.getOwner();
	    int row = WorkSet.getTable().getSelectedRow();
	
	    Vector data = new Vector();
	
	    for(int i = 0 ; i<WorkSet.getWorkerModel().getColumnCount() ; i++){
	
	    	data.add(WorkSet.getWorkerModel().getValueAt(row, i));
	
	    }
	    Object obj = WorkSet.getWorkerModel().getValueAt(row, 0);
	    Vector data2 = WorkerDB.getData2(obj);
	    
	    System.out.println(data2.get(0));
	    System.out.println(data.get(0).toString().trim().equals("是"));
	   if(data2.get(0)!=null){
		   if(data2.get(0).toString().trim().equals("是")){
			   c1.setSelected(true);}
			   else{
				   c1.setSelected(false);
				   }
		   }else{c1.setSelected(false);}
	  
	   if(data2.get(1)!=null){
		   if(data2.get(1).toString().trim().equals("是")){
			   c2.setSelected(true);}
			   else{
				   c2.setSelected(false);
				   }
		   }else{c2.setSelected(false);}
	   
	   
	   if(data2.get(2)!=null){
		   if(data2.get(2).toString().trim().equals("是")){
			   c3.setSelected(true);}
			   else{
				   c3.setSelected(false);
				   }
		   }else{c3.setSelected(false);}
	    
       
           
	    
	    // System.out.println(data.size());
	     t1.setText(data.get(0).toString());
	  
	     if(data.get(1)!=null){
	     t2.setText(data.get(1).toString());
	     }else{t2.setText("");}
	
	     if(data.get(2)!=null){
	 
		  t3.setText(data.get(2).toString());}
	     else{t3.setText("");}
	

	     if(data.get(3)!=null){
	 
		  t4.setText(data.get(3).toString());}
	     else{t4.setText("");}
	
	     
	     if(data.get(4)!=null){
	       t5.setText(data.get(4).toString());}
	      else{t5.setText("");}
	     
	     
    	
	}

	private void init(){ 
	
	//dia.setName("  仓库设置");
	this.setSize(240,260);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	JPanel pa = new JPanel();
	 JPanel pa2 = new JPanel();
	 JPanel pa3 = new JPanel();
	pa.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel b1 = new JLabel("员工姓名: ");
	JLabel b2 = new JLabel("所任职务: ");
	JLabel b3 = new JLabel("联系电话: ");
	 
	JLabel b4 = new JLabel("联系地址: ");
	JLabel b5 = new JLabel("备    注: ");
	 
	  t1 = new JTextField("小熊",17);
	  t2 = new JTextField("采购员",17);
	  t3 = new JTextField(17);
	  t4 = new JTextField(21);
	  t5 = new JTextField("负责商品的采购",21);
	pa2.add(b1);pa2.add(t1);
	pa2.add(b2);pa2.add(t2);
	pa2.add(b3);pa2.add(t3);
	
	pa2.setPreferredSize(new Dimension(240,250));
	pa2.setLayout(new FlowLayout(FlowLayout.LEFT));
	pa2.add(b4);pa2.add(t4);
	pa2.add(b5);pa2.add(t5);
    
	JLabel be = new JLabel("业务权限：                                                                ");
	
	  c1 = new JCheckBox("采购管理",true);

	  c2 = new JCheckBox("销售管理",true);
	  c3 = new JCheckBox("库存管理",true);
	JLabel lb = new JLabel("                               ") ; 
	JLabel lb2 = new JLabel("          ");
	JButton jb1 = new JButton("确认(F5)");
	jb1.addActionListener(new ChangeWorkerAction(this));
	JButton jb2 = new JButton("退出(F4)");
	jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			ChangeWorker.this.dispose();
			
		}});
	pa2.setLayout(new FlowLayout(FlowLayout.LEFT)); 
	pa2.add(c1);
	pa2.add(c2);
	pa2.add(c3);
	 pa2.add(lb);pa2.add(lb2);
	pa2.add(jb1);
	pa2.add(jb2);	
	pa2.setPreferredSize(new Dimension(280,150));
	 //pa2.setLayout(new FlowLayout(FlowLayout.CENTER));
	//pa.add(pa2);
	//pa.add(pa3);
	this.add(pa2); 
	//this.add(pa1,FlowLayout.CENTER);
	
    	
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

	public JTextField getT5() {
		return t5;
	}

	public JCheckBox getC1() {
		return c1;
	}

	public JCheckBox getC2() {
		return c2;
	}

	public JCheckBox getC3() {
		return c3;
	}
    
}