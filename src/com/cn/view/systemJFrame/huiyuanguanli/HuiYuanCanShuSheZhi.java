package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * ��Ա�����µĲ������öԻ���
 * @author finey
 *
 */
public class HuiYuanCanShuSheZhi extends JDialog {
    //ÿ��һ�ֵ����ѽ��
	private JTextField jiFenXiaoFeiE = new JTextField(10);
    
	//���ֺ����������ۼƵ��´�����
	private JCheckBox yuEBox = new JCheckBox("���ֺ����������ۼƵ��´�����");
	
	 //��ֵ�۶ұ���
	private JTextField biLi = new JTextField(10);
	
	public HuiYuanCanShuSheZhi( HuiYanGuangLiFrame frame,String title){
		super(frame,title);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(350,350));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	
   private JPanel createPane(){
	    JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab = new JLabel("ÿ��һ�ֵ����ѽ��:");
		tmpPane.add(lab);
		tmpPane.add(jiFenXiaoFeiE);
		jiFenXiaoFeiE.setText("20");
		JLabel lab1 = new JLabel("����Ϊ��(Ĭ��20)");
		lab1.setForeground(Color.red);
		tmpPane.add(lab1);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(yuEBox);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("��ֵ�ұ���:");
		tmpPane.add(lab);
		tmpPane.add(biLi);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    lab = new JLabel("�۶ұ���=���˽��/֧�����");
	    lab.setForeground(Color.red);
		tmpPane.add(lab);
		centerPane.add(tmpPane);
		
		centerPane.setBorder(new TitledBorder("��������"));
		
		mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYuanCanShuSheZhi.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
   }
	
	
}
