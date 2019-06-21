package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.kuchunframe.kucundiaobo.TanChuXinXiOKAction;
import com.cn.util.GBC;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * ������Ʒ��Ϣ������������Ʒ��Ϣ����
 * 
 * @author Administrator
 *
 */
public class AddShangPinXinXiDialog extends JDialog {
	private AddSanPingDialog dialog;//������
	private int flag;//��־������
	
	
	private JLabel labelSPBH;//��Ʒ���
	private JLabel labelGGXH;//����ͺ�
	private JLabel labelSCCS;//��������
	private JLabel labelDQKC;//��ǰ���
	private JLabel labelSPMC;//��Ʒ����
	private JLabel labelYS;//��ɫ
	private JLabel labelBZ;//��ע
	private JLabel labelCBDJ;//�ɱ�����
	private JTextField textDBSL;//��������
	private JLabel labelDW;
//	private JComboBox comboDW;//��λ
	
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	public AddSanPingDialog getDialog() {
		return dialog;
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

	public JLabel getLabelCBDJ() {
		return labelCBDJ;
	}

	public JTextField getTextDBSL() {
		return textDBSL;
	}

	public JLabel getLabelDW() {
		return labelDW;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}
	
	//��ȡlabel�ϵ���Ϣ��������
	
	public int getFlag() {
		return flag;
	}

//	public AddShangPinXinXiDialog(AddSanPingDialog dialog,String title,boolean b){
//		super(dialog,title,b);
//		this.dialog = dialog;
//		init();
//	}
	
	/*
	 * �������޸�
	 * 1Ϊ�޸ģ�0Ϊ����
	 */
	public AddShangPinXinXiDialog(AddSanPingDialog dialog,String title,boolean b,int flag){
		super(dialog,title,b);
		this.dialog = dialog;
		this.flag = flag;
		init();
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
		label4.setForeground(Color.RED);
		layout.setConstraints(label4, new GBC(0,3));
		cenJpanel.add(label4);
		
		JLabel label5= new JLabel("��Ʒ����:  ");//��������
		label5.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label5, new GBC(0,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(label5);
		
		JLabel label6= new JLabel("��Ʒ����:  ");//��Ʒ����
		label6.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label6, new GBC(2,0));
		cenJpanel.add(label6);
		
		JLabel label7= new JLabel("��λ:  ");//��λ
		label7.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label7, new GBC(2,1));
		cenJpanel.add(label7);
		
		JLabel label8= new JLabel("��ɫ:  ");//��ɫ
		label8.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label8, new GBC(2,2));
		cenJpanel.add(label8);
		
		JLabel label9= new JLabel("��ע:  ");//��ע
		label9.setPreferredSize(new Dimension(80,30));
		layout.setConstraints(label9, new GBC(2,3));
		cenJpanel.add(label9);
		
		JLabel label10= new JLabel("�ɱ�����:  ");//�ɱ�����
		label10.setPreferredSize(new Dimension(80,30));
		label10.setForeground(Color.RED);
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
		labelDQKC.setForeground(Color.RED);
		layout.setConstraints(labelDQKC, new GBC(1,3));
		cenJpanel.add(labelDQKC);
		
		textDBSL = new JTextField(5);
		textDBSL.setPreferredSize(new Dimension(60,20));
		textDBSL.setText("10");
		layout.setConstraints(textDBSL, new GBC(1,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(textDBSL);
		
		labelSPMC = new JLabel();
		labelSPMC.setPreferredSize(new Dimension(60,20));
		labelSPMC.setEnabled(false);
		layout.setConstraints(labelSPMC, new GBC(3,0));
		cenJpanel.add(labelSPMC);
		
//		comboDW = new JComboBox(items);//��ʱ����label��ʾ
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
		
		labelCBDJ = new JLabel();
		labelCBDJ.setPreferredSize(new Dimension(60,20));
		labelCBDJ.setForeground(Color.RED);
		layout.setConstraints(labelCBDJ, new GBC(3,4).setInsets(2, 2, 2, 2));
		cenJpanel.add(labelCBDJ);
		
		return cenJpanel;
	}

	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		
		btnYes = new JButton("ȷ  ��(F5)");
		btnNo = new JButton("ȡ  ��(F4)");
		{	
			//ȷ������Ʒ��Ϣ���ڵ���Ϣȫ���ӵ���ѡ�б���ȥ
			btnYes.addActionListener(new TanChuXinXiOKAction(this));
			
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AddShangPinXinXiDialog.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnYes);
			souJpanel.add(btnNo);
		}
		return souJpanel;
	}
	
	//===========================����
		public static void main(String [] args){
			new AddShangPinXinXiDialog(null,"����",true,1).setVisible(true);
		}
}
