package com.cn.view.systemJFrame.Operator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cn.view.systemJFrame.OperatorSet;
/*
 * ���Ӳ���Ա�Ի���
 */
public class AddOperator extends JDialog {
	
	JButton bo1  ;
	OperatorSet set;
	public AddOperator(OperatorSet set,String title){
		super(set,title,true);
		this.set = set;
	    init();
	}

	private void init() {
		 JPanel pa = new JPanel();
		 this.setSize(360,120);
		 this.setLocationRelativeTo(null);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 final JCheckBox box1 = new JCheckBox("������ͨ����Ա    ");
		 JCheckBox box2 = new JCheckBox("���� P O S ����Ա ",true);
		 bo1=new JButton("ȷ��(F5)");
	 
		 JButton bo2 = new JButton("ȡ��(F4)");
		 bo2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				 AddOperator.this.dispose();
			}
		 });
		 bo1.addActionListener(new ActionListener(){
 
			public void actionPerformed(ActionEvent e) {
				
				if(box1.isSelected()){
					 new AddOperator2(set,"���Ӳ���Ա","0",false);
				}else{
					 new AddOperator2( set,"���Ӳ���Ա","1",false);
				}
				AddOperator.this.dispose();
			
			   
			    
				
			}});
		 ButtonGroup group = new ButtonGroup();
		 group.add(box1);
		 group.add(box2);
		 
		 pa.add(box1);
		 pa.add(box2);
		 
		 pa.add(bo1);
		 pa.add(bo2);
		 
		 
		 this.add(pa);
		 this.setVisible(true);
	}
	 
	public static void main(String [] args){
		new AddOperator(null,"");
	}
}
