package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.kuchun.CFKBModel;
import com.cn.model.kuchun.MyTableModel;

public class ChaifenKunbang00 extends JDialog {
	///////////////////////�����Ʒ
	private JLabel labelDH = new JLabel("���ţ�"+"CF1010040001",JLabel.RIGHT);
	private JComboBox comboCFCK;
	private JLabel labelCFRQ;//������ڣ�������������������
	private JTextField textBCSPBH;//������Ʒ���
	private JButton btnCX;//��ѯ
	private JTextField textCFSL;//�������
	
	private JLabel labelBCSPMC;//������Ʒ����
	private JLabel labelGGXH;//����ͺ�
	private JLabel labelDW;//��λ
	private JLabel labelYS;//��ɫ
	private JLabel labelDQKC;//��ǰ���
	private JLabel labelCBJ;//�ɱ���
	private JLabel labelCFZE;//����ܶ�
	
	private DefaultTableModel tableModelCF;//�����Ʒ
	private JTable tableCF;//�����Ʒ
	
	private JComboBox comboJBR;//������
	private JTextField textBZ ;//��ע
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	
	/////////////////////////////������Ʒ
	
	public ChaifenKunbang00(JDialog dialog,String title,boolean b){
		super(dialog,title,b);
		init();
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(addCom());
		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	/*
	 * �������
	 * 
	 */
	private JPanel addNor(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new GridLayout(3,1));
		
		{
			norJpanel.add(addNor1());
			norJpanel.add(addNor2());
			norJpanel.add(addNor3());
		}
		
		return norJpanel;
	}
	
	private JPanel addNor1(){
		JPanel norJpanel1 = new JPanel();
		norJpanel1.setLayout(new GridLayout(2,1));
		JPanel norJpanel11 = new JPanel();
		JPanel norJpanel12 = new JPanel();
		
		//norJpanel1���
		JLabel labelSPCF = new JLabel("��  Ʒ  ��  ��");
		labelSPCF.setFont(new Font("����",Font.BOLD,20)); 
		norJpanel11.add(labelSPCF);
		
		//norJpanel2���
		norJpanel12.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
		JLabel label1 = new JLabel("��Ʒ��ְѿ�������е�ĳ����Ʒ��ֳɼ�����Ʒ",JLabel.LEFT);
		
		JLabel label2 = new JLabel("                                                 ");
		labelDH.setForeground(Color.RED);
		
		{
			norJpanel12.add(label1);
			norJpanel12.add(label2);
			norJpanel12.add(labelDH);
		}
		
		{
			norJpanel1.add(norJpanel11);
			norJpanel1.add(norJpanel12);
		}
		
		norJpanel1.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel1;
	}
	/*
	 * 
	 */
	private JPanel addNor2(){
		JPanel norJpanel2 = new JPanel();
		norJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		JLabel label1 = new JLabel("��ֲֿ⣺");
		JLabel label2 = new JLabel("�������:");
		JLabel label3 = new JLabel("������Ʒ���");
		JLabel label4 = new JLabel("�������");
		
		comboCFCK = new JComboBox(CFKBModel.CFKBChaifenShangpin);
		labelCFRQ = new JLabel("2010-10-14");
		textBCSPBH = new JTextField(10);
		textBCSPBH.setText("CF1010005");
		btnCX = new JButton(new ImageIcon("res/AcionIcon/find.jpg"));
		btnCX.setMargin(new Insets(0,0,0,0));
		textCFSL = new JTextField(10);
		textCFSL.setText("1.00");
		
		{
			norJpanel2.add(label1);
			norJpanel2.add(comboCFCK);
			norJpanel2.add(label2);
			norJpanel2.add(labelCFRQ);
			norJpanel2.add(label3);
			norJpanel2.add(textBCSPBH);
			norJpanel2.add(btnCX);
			norJpanel2.add(label4);
			norJpanel2.add(textCFSL);
			
		}
		norJpanel2.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel2;
	}
	
	/*
	 * 
	 */
	private JPanel addNor3(){
		JPanel norJpanel3 = new JPanel();
		norJpanel3.setLayout(new GridLayout(2,1));
		
		JLabel label1 = new JLabel("������Ʒ���ƣ�");
		JLabel label2 = new JLabel("����ͺţ�");
		JLabel label3 = new JLabel("��λ��");
		JLabel label4 = new JLabel("��ɫ��");
		JLabel label5 = new JLabel("��ǰ��棺");
		JLabel label6 = new JLabel("�ɱ��ۣ�");
		JLabel label7 = new JLabel("����ܶ");
		
		labelBCSPMC = new JLabel("���б���");
		labelBCSPMC.setForeground(Color.RED);
		labelGGXH = new JLabel("100g");
		labelDW = new JLabel("��");
		labelYS = new JLabel("��������");
		labelDQKC = new JLabel("    35");
		labelDQKC.setForeground(Color.RED);
		labelCBJ = new JLabel("6.07");
		labelCFZE = new JLabel("6.07");
		
		{
			norJpanel3.add(label1);
			norJpanel3.add(labelBCSPMC);
			norJpanel3.add(label2);
			norJpanel3.add(labelGGXH);
			norJpanel3.add(label3);
			norJpanel3.add(labelDW);
			norJpanel3.add(label4);
			norJpanel3.add(labelYS);
			norJpanel3.add(label5);
			norJpanel3.add(labelDQKC);
			norJpanel3.add(label6);
			norJpanel3.add(labelCBJ);
			norJpanel3.add(label7);
			norJpanel3.add(labelCFZE);
		}
		
		norJpanel3.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel3;
	}
	
	
	/*
	 * �в����
	 * 
	 */
	private JPanel addCen(){
		JPanel cenJpanel = new JPanel();
		
		tableModelCF = new MyTableModel(CFKBModel.dataCFKB1,CFKBModel.colunmsCFKB1);
		tableCF = new JTable(tableModelCF);
		tableCF.setPreferredScrollableViewportSize(new Dimension(780, 220));
		tableCF.setAutoCreateRowSorter(true);
		JScrollPane scroPane = new JScrollPane(tableCF);
		scroPane.setBorder(new LineBorder(Color.GRAY,2));
		cenJpanel.add(scroPane);
		
		cenJpanel.setBorder(new LineBorder(Color.gray,1));
		return cenJpanel;
	}
	
	/*
	 * �ϲ����
	 * 
	 */
	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		
//		JPanel jpanelSou= new JPanel();
		souJpanel.setLayout(new GridLayout(2,1));
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel labelJBR = new JLabel("��   ��   ��");
		
		comboJBR = new JComboBox(CFKBModel.itemsJBR);
		JLabel labelBZ = new JLabel("��      ע");
		textBZ = new JTextField(20);
		{
			jpanel1.add(labelJBR);
			jpanel1.add(comboJBR);
			jpanel1.add(labelBZ);
			jpanel1.add(textBZ);
		}
		
		JPanel jpanel2 = new JPanel(); 
		jpanel2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
		btnYes = new JButton("ȷ     ��");
		btnNo = new JButton("ȡ    ��");
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ChaifenKunbang00.this.dispose();
			}
		});
		{
			jpanel2.add(btnYes);
			jpanel2.add(btnNo);
		}
		{
			souJpanel.add(jpanel1);
			souJpanel.add(jpanel2);
		}
		souJpanel.setBorder(new LineBorder(Color.lightGray,1));
		
		return souJpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChaifenKunbang00(null,"��Ʒ���",true);
	}
}
