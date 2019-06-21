package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.util.GBC;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;

/**
 * @author Administrator
 *
 */
public class XinShangPinTianJia extends JDialog{

	/*
	 * ������
	 */
	CaiGouJinHuo dialog;

	//panel1
	private JTextField suoshuleibie = new JTextField(10);
	private JTextField shangpinbianhao = new JTextField(10);
	private JTextField shangpinmingcheng = new JTextField(10);
	private JTextField shangpintiaoma = new JTextField(10);
	private JTextField guigexinghao = new JTextField(10);
	private JTextField danwei = new JTextField(10);
	private JTextField kucunxiaxian = new JTextField(10);
	private JTextField yanse = new JTextField(10);
	private JTextField yushejinjia = new JTextField(10);
	private JTextField yusheshoujia = new JTextField(10);
	private JTextField shengchanchangshang = new JTextField(10);
	private JTextField beizhu = new JTextField(28);
	private JCheckBox shiyongbaozhiqi;
	private JTextField tian = new JTextField(6);
	private JButton fangdajing;
	//panel2
	//��һ����
	
	//�ڶ�����
	private JCheckBox lianxuzengjia;
	private JButton queren;
	private JButton tuichu;
	public XinShangPinTianJia(JDialog jDialog,String title,boolean model){
		super(jDialog,title,model);
		this.dialog = (CaiGouJinHuo)jDialog;
		init();
	}
	
	private void init(){
		this.setSize(500, 450);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setLayout(new GridLayout(2,0));
		this.add(panel1());
		this.add(panel2());
		
		this.setVisible(true);
	}
	//panel1
	private JTabbedPane panel1(){
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.RED,1));//�߿�
		
		//
		GridBagLayout layout = new GridBagLayout();
		panel1.setLayout(new GridBagLayout());
		panel1.setLayout(layout);
		//layout.setConstraints(btn1, new GBC(0, 0).setInsets(2, 2, 2, 2));
	 
		JLabel label1 = new JLabel("�������:");
		JLabel label2 = new JLabel("��Ʒ���:");
		JLabel label3 = new JLabel("��Ʒ����:");
		JLabel label4 = new JLabel("��Ʒ����:");
		JLabel label5 = new JLabel("����ͺ�:");
		JLabel label6 = new JLabel("��λ:");
		JLabel label7 = new JLabel("�������:");
		JLabel label8 = new JLabel("��ɫ:");
		JLabel label9 = new JLabel("Ԥ�����:");
		JLabel label10 = new JLabel("Ԥ���ۼ�:");
		JLabel label11 = new JLabel("��");
		JLabel label12 = new JLabel("��������:");
		JLabel label13 = new JLabel("��ע:");
		
		layout.setConstraints(label1,new GBC(0,0,1,1));//�������
		panel1.add(label1);
		layout.setConstraints(suoshuleibie,new GBC(1,0,2,1));
		panel1.add(suoshuleibie);
		
		fangdajing = new JButton(new ImageIcon("res/AcionIcon/cha.jpg"));//�Ŵ�
		fangdajing.setMargin(new Insets(0,0,0,0));
		layout.setConstraints(fangdajing,new GBC(3,0,1,1));
		panel1.add(fangdajing);
		
		layout.setConstraints(label2,new GBC(4,0,1,1));//��Ʒ���
		panel1.add(label2);
		layout.setConstraints(shangpinbianhao,new GBC(5,0,2,1));
		panel1.add(shangpinbianhao);
		
		layout.setConstraints(label3,new GBC(0,1,1,1));//��Ʒ����
		panel1.add(label3);
		layout.setConstraints(shangpinmingcheng,new GBC(1,1,2,1));
		panel1.add(shangpinmingcheng);
		
		layout.setConstraints(label4,new GBC(4,1,1,1));//��Ʒ����
		panel1.add(label4);
		layout.setConstraints(shangpintiaoma,new GBC(5,1,2,1));
		panel1.add(shangpintiaoma);
		
		layout.setConstraints(label5,new GBC(0,2,1,1));//����ͺ�
		panel1.add(label5);
		layout.setConstraints(guigexinghao,new GBC(1,2,2,1));
		panel1.add(guigexinghao);
		
		layout.setConstraints(label6,new GBC(4,2,1,1));//��λ
		panel1.add(label6);
		layout.setConstraints(danwei,new GBC(5,2,1,1));
		panel1.add(danwei);
		
		layout.setConstraints(label7,new GBC(0,3,1,1));//�������
		panel1.add(label7);
		layout.setConstraints(kucunxiaxian,new GBC(1,3,2,1));
		panel1.add(kucunxiaxian);
		
		layout.setConstraints(label8,new GBC(4,3,1,1));//��ɫ
		panel1.add(label8);
		layout.setConstraints(yanse,new GBC(5,3,2,1));
		panel1.add(yanse);
		
		layout.setConstraints(label9,new GBC(0,4,1,1));//Ԥ�����
		panel1.add(label9);
		layout.setConstraints(yushejinjia,new GBC(1,4,2,1));
		panel1.add(yushejinjia);
		
		layout.setConstraints(label10,new GBC(4,4,1,1));//Ԥ���ۼ�
		panel1.add(label10);
		layout.setConstraints(yusheshoujia,new GBC(5,4,2,1));
		panel1.add(yusheshoujia);
		
		shiyongbaozhiqi = new JCheckBox("ʹ�ñ�����");
		layout.setConstraints(shiyongbaozhiqi,new GBC(0,5,2,1));//ʹ�ñ�����
		panel1.add(shiyongbaozhiqi);
		
		layout.setConstraints(tian,new GBC(2,5,1,1));//��
		panel1.add(tian);
		layout.setConstraints(label11,new GBC(3,5,1,1));
		panel1.add(label11);
		
		layout.setConstraints(label12,new GBC(4,5,1,1));//��������
		panel1.add(label12);
		layout.setConstraints(shengchanchangshang,new GBC(5,5,2,1));
		panel1.add(shengchanchangshang);
		
		layout.setConstraints(label13,new GBC(0,6,1,1));//��ע
		panel1.add(label13);
		layout.setConstraints(beizhu,new GBC(1,6,4,1));
		panel1.add(beizhu);
		
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.add("��Ʒ��Ϣ", panel1);
		return tabPane;
	}
	//panel2
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		//��һ���֣�JTabbedPane����������ѡ�
		JTabbedPane tabPane = new JTabbedPane();
		
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		
		tabPane.add("�൥λ",pane1);
		tabPane.add("������Ϣ",pane2);
		tabPane.add("�ؼ���Ϣ",pane3);
		
		
		
		//�ڶ����֣�����   ����������Ʒ��ȷ�����˳� ��ť
		JPanel pane_south = new JPanel();
		
		lianxuzengjia = new JCheckBox("��������");
		queren = new JButton("ȷ��");
		queren.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(shangpinmingcheng.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"��Ʒ���Ʋ���Ϊ��");
					return;
				}
				if(shangpinbianhao.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"��Ʒ��Ų���Ϊ��");
					return;
				}
				if(danwei.getText().equals("")){
					JOptionPane.showMessageDialog(dialog,"��ѡ����Ʒ��λ");
					return;
				}
				//һ�кϷ�����xinshangpinData ������
				/*
				 * ��Ʒ��ţ���Ʒ���ƣ����ۣ�������룬��λ����λ��ϵ
				 * Ԥ����ۣ�Ԥ���ۼۣ�����ͺţ���ɫ�����
				 * �Ƿ��ؼ���Ʒ����Ʒ�ۿۣ���Ա�ۣ��ؼۣ�
				 * ��ʼ���ڣ��������ڣ�״̬�������ʣ��������̣��ֿ�
				 */
				
			}
			
		});
		tuichu = new JButton("�˳�");
		tuichu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				XinShangPinTianJia.this.dispose();
			}
			
		});
		
		pane_south.setLayout(new FlowLayout(FlowLayout.LEFT,50,2));
		pane_south.add(lianxuzengjia);
		pane_south.add(queren);
		pane_south.add(tuichu);
		

		
		//
		panel2.setLayout(new BorderLayout());
		panel2.add(tabPane,BorderLayout.CENTER);
		panel2.add(pane_south,BorderLayout.SOUTH);
		
		return panel2;
	}
	
	public static void main(String[] args){
		new XinShangPinTianJia((JDialog)null,"������Ʒ",true);
	}

	public JTextField getSuoshuleibie() {
		return suoshuleibie;
	}

	public JTextField getShangpinbianhao() {
		return shangpinbianhao;
	}

	public JTextField getShangpinmingcheng() {
		return shangpinmingcheng;
	}

	public JTextField getShangpintiaoma() {
		return shangpintiaoma;
	}

	public JTextField getGuigexinghao() {
		return guigexinghao;
	}

	public JTextField getDanwei() {
		return danwei;
	}

	public JTextField getKucunxiaxian() {
		return kucunxiaxian;
	}

	public JTextField getYanse() {
		return yanse;
	}

	public JTextField getYushejinjia() {
		return yushejinjia;
	}

	public JTextField getYusheshoujia() {
		return yusheshoujia;
	}

	public JTextField getShengchanchangshang() {
		return shengchanchangshang;
	}

	public JTextField getBeizhu() {
		return beizhu;
	}

	public JCheckBox getShiyongbaozhiqi() {
		return shiyongbaozhiqi;
	}

	public JTextField getTian() {
		return tian;
	}

	public JButton getFangdajing() {
		return fangdajing;
	}

	public JCheckBox getLianxuzengjia() {
		return lianxuzengjia;
	}

	public JButton getQueren() {
		return queren;
	}

	public JButton getTuichu() {
		return tuichu;
	}
	
}
