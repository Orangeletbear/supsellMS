package com.cn.view.systemJFrame.CangKuXheZhi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.systemframe.storage.AddStorageAction;
import com.cn.view.systemJFrame.CangKuSheZhi;
/*
 * ���Ӳֿ�Ի���
 */
public class AddStorage extends JDialog {
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
	public JButton getJb1() {
		return jb1;
	}
	public String getTitle() {
		return title;
	}
	//
	JTextField t1  ;//�ֿ�����
	JTextField t2  ;//������
	JTextField t3  ;//��ϵ�绰
	JTextField t4  ;//��ϵ��ַ
	JTextField t5  ;//��ע
	JButton jb1;//ȷ��
	JCheckBox c1;//Ĭ�ϲֿ�
	JCheckBox c2;//	POS�ֿ�
	protected String title;
	CangKuSheZhi owner;
	
	public AddStorage(CangKuSheZhi frame,String title,boolean be){
	super(frame,title,true);
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
	JLabel b5 = new JLabel(" ��  ע ");
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
	
	  /**
	   * ��ȷ�������Ӽ�����
	   */
	  jb1.addActionListener(new AddStorageAction(AddStorage.this));
	  
	
	  JButton jb2 = new JButton("�˳�(F4)");
	
	  jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			 AddStorage.this.dispose();
			
		}});
	 
	
	  pa.add(c1);
	
	  pa.add(c2);
	
	  pa.add(jb1);
	
	  pa.add(jb2);
	
	
	  pa.setLayout(new FlowLayout(FlowLayout.CENTER));
    //�˳���������
	  jb2.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			AddStorage.this.dispose();
		}});
	
	  this.add(pa);
	
	  this.setVisible(true);
	
	}
 
	  public JCheckBox getC1() {
		 return c1;
	}
	  public JCheckBox getC2() {
		 return c2;
	}
}


