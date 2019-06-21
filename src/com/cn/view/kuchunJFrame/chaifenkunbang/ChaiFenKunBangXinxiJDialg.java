package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.ChaiFenKunBangXinXiOKBtnAction;
import com.cn.util.GBC;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class ChaiFenKunBangXinxiJDialg extends JDialog {
	
	private ChaifenKunbang dialog;
	private String flag;//���ֲ������ı�־
	
//	private static String []items = {"ƿ","��","��"}; 
	private JLabel labelSPBH;//��Ʒ���
	private JLabel labelGGXH;//����ͺ�
	private JLabel labelSCCS;//��������
	private JLabel labelDQKC;//��ǰ���
	private JLabel labelSPMC;//��Ʒ����
	private JLabel labelYS;//��ɫ
	private JLabel labelBZ;//��ע
	private JTextField textCFSL;//�������
	private JTextField textCFDJ;//��ֵ���
//	private JComboBox comboDW;//��λ
	private JLabel labelDW;
	
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	
	//��ȡlabel�ϵ���Ϣ��������
	
	public ChaiFenKunBangXinxiJDialg(ChaifenKunbang dialog,String title,boolean b,String flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
	}
	
	public String getFlag() {
		return flag;
	}
	public JLabel getLabelSPBH() {
		return labelSPBH;
	}

	public JLabel getLabelGGXH() {
		return labelGGXH;
	}

	public JLabel getLabelSCCS() {
		return labelSCCS;
	}

	public JLabel getLabelDQKC() {
		return labelDQKC;
	}

	public JLabel getLabelSPMC() {
		return labelSPMC;
	}

	public JLabel getLabelYS() {
		return labelYS;
	}

	public JLabel getLabelBZ() {
		return labelBZ;
	}

	public JTextField getTextCFSL() {
		return textCFSL;
	}

	public JTextField getTextCFDJ() {
		return textCFDJ;
	}

//	public JComboBox getComboDW() {
//		return comboDW;
//	}
	
	public JButton getBtnYes() {
		return btnYes;
	}

	public JLabel getLabelDW() {
		return labelDW;
	}

	public JButton getBtnNo() {
		return btnNo;
	}
	
	public ChaifenKunbang getDialog() {
		return dialog;
	}

	private void init(){
		this.setSize(350, 260);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
//		jpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),""));
		return jpanel;
	}
	
	/**
	 * �м䲿�ֵ������
	 */
	private JPanel addCen(){
		JPanel cenJpanel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		cenJpanel.setLayout(layout);
		
		JLabel label1 = new JLabel("��Ʒ���:  ");//��Ʒ���
		label1.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label1, new GBC(0,0));
		cenJpanel.add(label1);
		
		JLabel label2= new JLabel("����ͺ�:  ");//����ͺ�
		label2.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label2, new GBC(0,1));
		cenJpanel.add(label2);
		
		JLabel label3= new JLabel("��������:  ");//��������
		label3.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label3, new GBC(0,2));
		cenJpanel.add(label3);
		
		JLabel label4= new JLabel("��ǰ���:  ");//��ǰ���
		label4.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label4, new GBC(0,3));
		cenJpanel.add(label4);
		
		JLabel label5= new JLabel("��ֵ���:  ");//��ֵ���
		label5.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label5, new GBC(0,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label5);
		
		JLabel label6= new JLabel("��Ʒ����:  ");//��Ʒ����
		label6.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label6, new GBC(2,0));
		cenJpanel.add(label6);
		
		JLabel label7= new JLabel("��        λ:  ");//��λ
		label7.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label7, new GBC(2,1));
		cenJpanel.add(label7);
		
		JLabel label8= new JLabel("��       ɫ:  ");//��ɫ
		label8.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label8, new GBC(2,2));
		cenJpanel.add(label8);
		
		JLabel label9= new JLabel("��        ע:  ");//��ע
		label9.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label9, new GBC(2,3));
		cenJpanel.add(label9);
		
		JLabel label10= new JLabel("�������:  ");//�ɱ�����
		label10.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label10, new GBC(2,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label10);
		
		
		labelSPBH = new JLabel();
		labelSPBH.setPreferredSize(new Dimension(60,20));
		labelSPBH.setEnabled(false);
		layout.setConstraints(labelSPBH, new GBC(1,0));
		cenJpanel.add(labelSPBH);
		
		labelGGXH = new JLabel();
		labelGGXH.setPreferredSize(new Dimension(60,20));
		labelGGXH.setEnabled(false);
		layout.setConstraints(labelGGXH, new GBC(1,1));
		cenJpanel.add(labelGGXH);
		
		labelSCCS = new JLabel();
		labelSCCS.setPreferredSize(new Dimension(60,20));
		labelSCCS.setEnabled(false);
		layout.setConstraints(labelSCCS, new GBC(1,2));
		cenJpanel.add(labelSCCS);
		
		labelDQKC = new JLabel();
		labelDQKC.setPreferredSize(new Dimension(60,20));
		labelDQKC.setEnabled(false);
		labelDQKC.setForeground(Color.RED);
		layout.setConstraints(labelDQKC, new GBC(1,3));
		cenJpanel.add(labelDQKC);
		
		textCFDJ = new JTextField(5);
		textCFDJ.setPreferredSize(new Dimension(60,20));
		textCFDJ.setText("1.0");
		layout.setConstraints(textCFDJ, new GBC(1,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textCFDJ);
		
		labelSPMC = new JLabel();
		labelSPMC.setPreferredSize(new Dimension(60,20));
		labelSPMC.setEnabled(false);
		layout.setConstraints(labelSPMC, new GBC(3,0));
		cenJpanel.add(labelSPMC);
		
//		comboDW = new JComboBox(items);
		labelDW = new JLabel();
		labelDW.setPreferredSize(new Dimension(60,20));
		layout.setConstraints(labelDW, new GBC(3,1));
		cenJpanel.add(labelDW);
		
		labelYS = new JLabel();
		labelYS.setPreferredSize(new Dimension(60,20));
		labelYS.setEnabled(false);
		layout.setConstraints(labelYS, new GBC(3,2));
		cenJpanel.add(labelYS);
		
		labelBZ = new JLabel();
		labelBZ.setPreferredSize(new Dimension(60,20));
		labelBZ.setEnabled(false);
		layout.setConstraints(labelBZ, new GBC(3,3));
		cenJpanel.add(labelBZ);
		
		textCFSL = new JTextField(5);
		textCFSL.setText("5");
		textCFSL.setPreferredSize(new Dimension(60,20));
		textCFSL.setForeground(Color.RED);
		layout.setConstraints(textCFSL, new GBC(3,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textCFSL);
		
		cenJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return cenJpanel;
	}

	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		
		btnYes = new JButton("ȷ  ��(F5)");
		btnNo = new JButton("ȡ  ��(F4)");
		{	
			//ȷ������Ʒ��Ϣ���ڵ���Ϣȫ���ӵ���ѡ�б���ȥ
			btnYes.addActionListener(new ChaiFenKunBangXinXiOKBtnAction(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					ChaiFenKunBangXinxiJDialg.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnYes);
			souJpanel.add(btnNo);
		}
		return souJpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChaiFenKunBangXinxiJDialg(null,"�����Ʒ��Ϣ",true,"").setVisible(true);
	}
}
