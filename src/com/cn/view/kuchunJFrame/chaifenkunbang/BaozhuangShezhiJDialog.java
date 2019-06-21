package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.chaifenkunbang.CFKB_TanChuChaXunActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi.BaoZhuangSheZhiOKActionListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.CFKBModel;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

	/**
	 * ��Ʒ��װ���ô���
	 * �������ô�С��װ��Ʒ֮���ѡ�������
	 * @author Administrator
	 *
	 */

public class BaozhuangShezhiJDialog extends JDialog{
	private ChaifenKunbang dialog;
	private String flag;//��־��ͬ�����¼�
	
	// ��һ�����
	private JComboBox comboSZCK1;//���ڲֿ�
	private JTextField textSPBH1;//��Ʒ���
	private JButton btnCX1;
	private JLabel labelSPName1;//��Ʒ����
	private JLabel labelGGXH1;//����ͺ�
	private JLabel labelDW1;//DW
	private JLabel labelYS1;//��ɫ

	// �ڶ������
	private JComboBox comboSZCK2;//���ڲֿ�
	private JTextField textSPBH2;//��Ʒ���
	private JButton btnCX2;
	private JLabel labelSPName2;//��Ʒ����
	private JLabel labelGGXH2;//����ͺ�
	private JLabel labelDW2;//DW
	private JLabel labelYS2;//��ɫ
	
	//���������
	private JTextField textZFBL;//�۷ֱ���
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	
	//////////////////////////////-------------------------
	public ChaifenKunbang getDialog() {
		return dialog;
	}

	public String getFlag() {
		return flag;
	}

	public JComboBox getComboSZCK1() {
		return comboSZCK1;
	}

	public JTextField getTextSPBH1() {
		return textSPBH1;
	}

	public JButton getBtnCX1() {
		return btnCX1;
	}

	public JLabel getLabelSPName1() {
		return labelSPName1;
	}

	public JLabel getLabelGGXH1() {
		return labelGGXH1;
	}

	public JLabel getLabelDW1() {
		return labelDW1;
	}

	public JLabel getLabelYS1() {
		return labelYS1;
	}

	public JComboBox getComboSZCK2() {
		return comboSZCK2;
	}

	public JTextField getTextSPBH2() {
		return textSPBH2;
	}

	public JButton getBtnCX2() {
		return btnCX2;
	}

	public JLabel getLabelSPName2() {
		return labelSPName2;
	}

	public JLabel getLabelGGXH2() {
		return labelGGXH2;
	}

	public JLabel getLabelDW2() {
		return labelDW2;
	}

	public JLabel getLabelYS2() {
		return labelYS2;
	}

	public JTextField getTextZFBL() {
		return textZFBL;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public BaozhuangShezhiJDialog(ChaifenKunbang dialog,String title,boolean b,String flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
	}
	
	private void init(){
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	//������廮Ϊ3��
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(3,1));

		{
			jpanel.add(addFrist());
			jpanel.add(addSecond());
			jpanel.add(addThree());
//			jpanel.add(addFour());
		}
		
		return jpanel;
	}
	
	//��һ�����
	private JPanel addFrist(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new GridLayout(2,1));
		
		JPanel jpanel11 = new JPanel();
		JPanel jpanel12 = new JPanel();
		jpanel11.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		jpanel12.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		
		JLabel label1 = new JLabel("���ڲֿ⣺");
		JLabel label2 = new JLabel("��Ʒ��ţ�");
		JLabel label3 = new JLabel("��Ʒ���ƣ�");
		JLabel label4 = new JLabel("����ͺţ�");
		JLabel label5 = new JLabel("��λ��");
		JLabel label6 = new JLabel("��ɫ��");
		
		comboSZCK1 = new JComboBox(JDBCCuCunFind.getCanKuData());
		textSPBH1 = new JTextField(10);;
		labelSPName1 = new JLabel("          ");
		labelSPName1.setPreferredSize(new Dimension(80,20));
		labelGGXH1 = new JLabel("          ");
		labelDW1 = new JLabel("          ");
		labelYS1 = new JLabel("          ");
		btnCX1 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX1.setSize(new Dimension(30,30));
		btnCX1.setMargin(new Insets(0,0,0,0));
		//��Ӽ�����
		{
			btnCX1.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		{
			jpanel11.add(label1);
			jpanel11.add(comboSZCK1);
			jpanel11.add(label2);
			jpanel11.add(textSPBH1);
			jpanel11.add(btnCX1);
		}
		
		{
			jpanel12.add(label3);
			jpanel12.add(labelSPName1);
			jpanel12.add(label4);
			jpanel12.add(labelGGXH1);
			jpanel12.add(label5);
			jpanel12.add(labelDW1);
			jpanel12.add(label6);
			jpanel12.add(labelYS1);
		}
		
		{
			jpanel1.add(jpanel11);
			jpanel1.add(jpanel12);
		}
		
		jpanel1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"����Ʒ��װ"));
		return jpanel1; 
	}
	
	//�ڶ������
	private JPanel addSecond(){
		JPanel jpanel2 = new JPanel();
		
		jpanel2.setLayout(new GridLayout(2,1));
		
		JPanel jpanel21 = new JPanel();
		JPanel jpanel22 = new JPanel();
		jpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		jpanel22.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		
		JLabel label1 = new JLabel("���ڲֿ⣺");
		JLabel label2 = new JLabel("��Ʒ��ţ�");
		JLabel label3 = new JLabel("��Ʒ���ƣ�");
		JLabel label4 = new JLabel("����ͺţ�");
		JLabel label5 = new JLabel("��λ��");
		JLabel label6 = new JLabel("��ɫ��");
		
		comboSZCK2 = new JComboBox(JDBCCuCunFind.getCanKuData());
		textSPBH2 = new JTextField(10);
		labelSPName2 = new JLabel("          ");
		labelSPName2.setPreferredSize(new Dimension(80,20));
		labelGGXH2 = new JLabel("          ");
		labelDW2 = new JLabel("          ");
		labelYS2 = new JLabel("          ");
		btnCX2 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX2.setSize(new Dimension(30,30));
		btnCX2.setMargin(new Insets(0,0,0,0));
		//��Ӽ�����
		{
			btnCX2.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		
		{
			jpanel21.add(label1);
			jpanel21.add(comboSZCK2);
			jpanel21.add(label2);
			jpanel21.add(textSPBH2);
			jpanel21.add(btnCX2);
		}
		
		{
			jpanel22.add(label3);
			jpanel22.add(labelSPName2);
			jpanel22.add(label4);
			jpanel22.add(labelGGXH2);
			jpanel22.add(label5);
			jpanel22.add(labelDW2);
			jpanel22.add(label6);
			jpanel22.add(labelYS2);
		}
		
		{
			jpanel2.add(jpanel21);
			jpanel2.add(jpanel22);
		}
		
		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"С��Ʒ��װ"));
		return jpanel2; 
	}
	
	//���������
	private JPanel addThree(){
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new GridLayout(3,1));
		
		JPanel jpanel31 = new JPanel();
		JPanel jpanel32 = new JPanel();
		JPanel jpanel33 = new JPanel();
		jpanel31.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
		jpanel33.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		
		JLabel label1 = new JLabel("�� �� �� �ʣ�");
		JLabel label2 = new JLabel("˵������ֱ�����ָһ�����װ��Ʒ��һ��С��װ��Ʒ���۷ֱ�����" );
		JLabel label3 = new JLabel("���۷ֱ���Ϊ10����1�����װ��Ʒ���Բ�ֳ�10��С��װ��Ʒ��");
		label2.setForeground(Color.RED);
		label3.setForeground(Color.RED);
		
		textZFBL = new JTextField(20);
		btnYes = new JButton("ȷ��",new ImageIcon("res/AcionIcon/green.jpg"));
		btnYes.setMargin(new Insets(0,0,0,0));
		btnNo = new JButton("�˳�",new ImageIcon("res/AcionIcon/red.jpg"));
		btnNo.setMargin(new Insets(0,0,0,0));
		{
			btnYes.addActionListener(new BaoZhuangSheZhiOKActionListener(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BaozhuangShezhiJDialog.this.dispose();
				}
			});
		}
		
		{
		jpanel31.add(label1);	
		jpanel31.add(textZFBL);
		
		jpanel32.add(label2);
		jpanel32.add(label3);
		
		jpanel33.add(btnYes);
		jpanel33.add(btnNo);
		}
		{
			jpanel3.add(jpanel31);
			jpanel3.add(jpanel32);
			jpanel3.add(jpanel33);
		}
		
		return jpanel3; 
	}
	
	public static void main(String []args){
		new BaozhuangShezhiJDialog(null,"��Ʒ��װ����",true,"").setVisible(true);
	}
	
}
