package com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ShanChuYuanYin extends JDialog{
	//��һ����
	JLabel caigoujinhuodan = new JLabel();
	JLabel gonghuoshangmingcheng = new JLabel();
	JLabel yingfujine = new JLabel();
	JLabel shifujine = new JLabel();
	//�ڶ�����
	private JTextArea shanchuyuanyin = new JTextArea(20,8);
	//��������
	private JButton queding = new JButton("ȷ��");
	
	public ShanChuYuanYin(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		init();
	}
	
	private void init(){
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	
		this.setLayout(new BorderLayout());
		this.add(pane(),BorderLayout.NORTH);
		this.add(shanchuyuanyin,BorderLayout.CENTER);
		this.add(panel3(),BorderLayout.SOUTH);
		
		this.setVisible(true);
	
	}
	
//	��һ����
	private JPanel pane(){
		JPanel pane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		//
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel1.add(new JLabel("�ɹ�������:"));
		panel1.add(caigoujinhuodan);
		//
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel2.add(new JLabel("����������:"));
		panel2.add(gonghuoshangmingcheng);
		//
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel3.add(new JLabel("Ӧ�����:"));
		panel3.add(yingfujine);
		//
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel4.add(new JLabel("ʵ�����:"));
		panel4.add(shifujine);
		//
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,4));
		panel5.add(new JLabel("������������ɾ��ԭ��ԭ�򽫴���ϵͳ��־����"));
		panel5.add(shanchuyuanyin);
		//
		
		pane.setLayout(new GridLayout(5,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		
		
		
		return pane;
	}

//	��������
	private JPanel panel3(){
		JPanel panel3 = new JPanel();
		JButton tuichu = new JButton("�˳�");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShanChuYuanYin.this.dispose();
			}
		});
		
		
		panel3.add(queding);
		panel3.add(tuichu);
		return panel3;
	}
	
	public static void main(String[] args){
		new ShanChuYuanYin((JDialog)null,"ɾ��ԭ��",true);
	}
}
