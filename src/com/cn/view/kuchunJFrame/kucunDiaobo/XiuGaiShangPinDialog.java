package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.kuchunframe.baosunbaoyi.XiuGaiOKAction;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.KucunDiaobo;

/**
 * ��Ʒ���������޸ĶԻ���
 * @author Administrator
 *
 */
public class XiuGaiShangPinDialog extends JDialog {
	private KucunDiaobo kDialog;
	private BaosunBaoyi bDialog;
	
	private JLabel labelMC;//��Ʒ����
	private JLabel labelDW;//��λ
	private JLabel labelGGXH;//����ͺ�
	private JLabel labelYS;//��ɫ
	private JLabel labelDJ;//����
	private JTextField textSL;//����
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
//	private JLabel labelZJE;//�ܽ��
//	private JLabel labelBZ;//��ע
	
	/////////////////////////////
	public JLabel getLabelMC() {
		return labelMC;
	}
	public JLabel getLabelDW() {
		return labelDW;
	}
	public JLabel getLabelGGXH() {
		return labelGGXH;
	}
	public JLabel getLabelYS() {
		return labelYS;
	}
	public JLabel getLabelDJ() {
		return labelDJ;
	}
	public JTextField getTextSL() {
		return textSL;
	}
	public JButton getBtnYes() {
		return btnYes;
	}
	public JButton getBtnNo() {
		return btnNo;
	}
	////////�����ڻ�ȡ
	public KucunDiaobo getkDialog() {
		return kDialog;
	}
	public BaosunBaoyi getbDialog() {
		return bDialog;
	}
	///////////������
	public XiuGaiShangPinDialog(KucunDiaobo dialog,String title,boolean b){
		super(dialog,title,b);
		kDialog = dialog;
		init();
	}
	/////////������
	public XiuGaiShangPinDialog(BaosunBaoyi dialog,String title,boolean b){
		super(dialog,title,b);
		bDialog = dialog;
		init();
	}
	private void  init(){
		this.setSize(360,240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	public JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5,4,10,30));
		
			labelMC = new JLabel("����");
			labelDW = new JLabel("��λ");
			labelGGXH = new JLabel("���");
			labelYS = new JLabel("��ɫ");
			labelDJ = new JLabel("����");
			textSL = new JTextField(8);
			textSL.setPreferredSize(new Dimension(30,18));
//			labelZJE = new JLabel("�ܽ��");
//			labelBZ = new JLabel("��ע");
			
			btnYes = new JButton("ȷ  ��");//ȷ����ť�ļ�����Ӧ�������ݵĸ���
			{
				btnYes.addActionListener(new XiuGaiOKAction(this));
			}
			btnNo = new JButton("ȡ  ��");
			{
				btnNo.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						XiuGaiShangPinDialog.this.dispose();
					}
				});
			}
			
			JLabel label1 = new JLabel("��Ʒ���ƣ�");
			JLabel label2 = new JLabel("��Ʒ��λ��");
			JLabel label3 = new JLabel("��Ʒ���");
			JLabel label4 = new JLabel("��Ʒ��ɫ��");
			JLabel label5 = new JLabel("��Ʒ���ۣ�");
			JLabel label6 = new JLabel("��Ʒ������");
			JLabel label7 = new JLabel("��Ʒ��");
			JLabel label8 = new JLabel("��    ע��");
		
		{
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			jpanel.add(new JLabel());
			
			jpanel.add(label1);
			jpanel.add(labelMC);
			jpanel.add(label2);
			jpanel.add(labelDW);
			
			jpanel.add(label3);
			jpanel.add(labelGGXH);
			jpanel.add(label4);
			jpanel.add(labelYS);
			
			jpanel.add(label5);
			jpanel.add(labelDJ);
			jpanel.add(label6);
			jpanel.add(textSL);
			
		/*	jpanel.add(label7);
			jpanel.add(labelZJE);
			jpanel.add(label8);
			jpanel.add(labelBZ);*/
			
			jpanel.add(new JLabel());
			jpanel.add(btnYes);
			jpanel.add(btnNo);
			jpanel.add(new JLabel());
		}
		
		return jpanel;
	}
	
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		new XiuGaiShangPinDialog(null,"�޸���Ʒ",true).setVisible(true);
	}*/
}
