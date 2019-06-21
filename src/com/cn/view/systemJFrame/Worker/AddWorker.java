package com.cn.view.systemJFrame.Worker;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.systemframe.customer.AddCustomerActive;
import com.cn.control.systemframe.worker.AddWorkerAction;
import com.cn.view.systemJFrame.WorkSet;

/*
 * ����Ա���Ի���
 */
public class AddWorker extends JDialog {
	
	JCheckBox c1;//�ɹ�����
	JCheckBox c2;//���۹���
	JCheckBox c3;//������
	
	JTextField t1;//Ա������
	JTextField t2;//����ְ��
	JTextField t3;//��ϵ�绰
	JTextField t4;//��ϵ��ַ
	JTextField t5;//��ע
	
	
	public JCheckBox getC1() {
		return c1;
	}
	public JCheckBox getC2() {
		return c2;
	}
	public JCheckBox getC3() {
		return c3;
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
	public AddWorker(WorkSet set,String title,boolean bo){
		super(set,title,true);
		init();
		this.setVisible(true);
	}
	 
	private void init(){
		 
		//dia.setName("  �ֿ�����");
		this.setSize(240,288);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//JPanel pa = new JPanel();
		 JPanel pa2 = new JPanel();
		 JPanel pa3 = new JPanel();
		pa2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel b1 = new JLabel("Ա������ :");
		JLabel b2 = new JLabel("����ְ�� :");
		JLabel b3 = new JLabel("��ϵ�绰 :");
		 
		JLabel b4 = new JLabel("��ϵ��ַ :");
		JLabel b5 = new JLabel("��    ע :");
		 
		t1 = new JTextField(17);
		JLabel ll = new JLabel("   ");
		JLabel kk = new JLabel("   ");JLabel oo = new JLabel("   ");
		 t2 = new JTextField(17);
		 t3 = new JTextField(17);
		 t4 = new JTextField(24);
		 t5 = new JTextField(24);
		pa2.add(b1);pa2.add(t1); 
		pa2.add(b2);pa2.add(t2); 
		pa2.add(b3);pa2.add(t3); 
		
		 pa2.setPreferredSize(new Dimension(240,282));
		pa2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pa2.add(b4);pa2.add(t4);
		pa2.add(b5);pa2.add(t5);
	    
		JLabel be = new JLabel("ҵ��Ȩ�ޣ�                                                   ");
		
		  c1 = new JCheckBox("�ɹ�����",true);
		  c2 = new JCheckBox("���۹���");
		  c3 = new JCheckBox("������",true);
		JButton jb1 = new JButton("ȷ��(F5)");
		jb1.addActionListener(new AddWorkerAction(AddWorker.this));
		
		JButton jb2 = new JButton("�˳�(F4)");
		jb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AddWorker.this.dispose();
				
			}});
		pa2.add(be ); 
		pa2.add(c1);
		pa2.add(c2);
		pa2.add(c3);
		 JLabel bb= new JLabel("                " +
		 		"                         ");
		 JLabel bb1= new JLabel("           ");
		 pa2.add(bb); pa2.add(bb1);
		pa2.add(jb1);
		pa2.add(jb2);	
		//pa3.setPreferredSize(new Dimension(280,150));
		 //pa3.setLayout(new FlowLayout(FlowLayout.CENTER));
		//pa.add(pa2);
		//pa.add(pa2);
		//this.pack();
		this.add(pa2); 
		//this.add(pa1,FlowLayout.CENTER);
	}
}
