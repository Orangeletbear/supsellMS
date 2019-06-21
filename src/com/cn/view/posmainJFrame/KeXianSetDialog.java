package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * POS�˵Ŀ�������
 * @author finey
 *
 */
public class KeXianSetDialog extends JDialog {

	//����
	JTextField spDanJia = new JTextField(10);
	//�ܼ�
	JTextField countAll = new JTextField(10);
	//�տ�
	JTextField getPrice = new JTextField(10);
	//����
	JTextField returnPrice = new JTextField(10);
    //�˿�
	JComboBox duanBox = new JComboBox(new String[]{"COM1","COM2","COM3","COM4"});
	
	public KeXianSetDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(350,330));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//�������������
	    JPanel centerPane = initPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				KeXianSetDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	private JPanel initPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel upPane = initUpPane();
		JPanel centerPane = initCenterPane();
		
		pane.add(upPane,BorderLayout.NORTH);
		pane.add(centerPane,BorderLayout.CENTER);
		
		return pane;
	}
	//�������
	private JPanel initUpPane(){
		JPanel pane = new JPanel();
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("ѡ�����ʹ�õĶ˿� : ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(duanBox);
	    pane.add(tmpPane);

	    pane.setBorder(new TitledBorder("ѡ��˿�"));
		return pane;
	}
	//�м����
	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    JLabel tmpLab = new JLabel("����: ");
	    JButton text = new JButton("����");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDanJia);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("�ܼ�: ");
	    text = new JButton("����");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(countAll);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("�տ�: ");
	    text = new JButton("����");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(getPrice);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout());
	    tmpLab = new JLabel("����: ");
	    text = new JButton("����");
	    
	    tmpPane.add(tmpLab);
	    tmpPane.add(returnPrice);
	    tmpPane.add(text);
	    pane.add(tmpPane);
	    
	    
		pane.setBorder(new TitledBorder("���Բ���"));
		return pane;
	}
	

}
