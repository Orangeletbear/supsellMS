package com.cn.view.kuchunJFrame.kuchunchaxun;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
/**
 * ��ǰ����еĸ߼���ѯ��ť
 * @author finey
 *
 */
public class AdvanceFind extends JDialog {
	//��Ӧ��
	private JTextField gongHuoSan = new JTextField(16) ; 
	
	private JComboBox comBox = new JComboBox(new String[]{"=",">=","<=","<>"});
	//���
	private JTextField kuCunNum = new JTextField(8);
	//�ֿ⼯��
	private JComboBox canKu = new JComboBox(JDBCCuCunFind.getCanKuData());
	
	public AdvanceFind(KuCunChaXunFrame frame,String title){
		super(frame,title,true);
		init();
	}
	
	private void init(){
		this.setSize(270,270);
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
        this.setVisible(true);
        
	}
	/*
	 * �������
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(5,1));
		
		JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lab = new JLabel("��ѯ�˹�����������Ʒ�Ŀ�����:");
        tempPane.add(lab);
        mainPane.add(tempPane);
		
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("�� �� ��:");
        tempPane.add(lab);
        tempPane.add(gongHuoSan);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("�� �� ��:");
        tempPane.add(lab);
        tempPane.add(comBox);
        tempPane.add(kuCunNum);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab = new JLabel("���ڲֿ�:");
        tempPane.add(lab);
        tempPane.add(canKu);
        mainPane.add(tempPane);
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,5));
        JButton okBtn = new JButton("ȷ  ��");
        JButton exitBtn = new JButton("��  ��");
        exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AdvanceFind.this.dispose();
			}
        	
        });
        tempPane.add(okBtn);
        tempPane.add(exitBtn);
        mainPane.add(tempPane);
        
        
        
        
		return mainPane;
	}
	public static void main(String[] args) {
		new AdvanceFind(null,"ff");
	}

}
