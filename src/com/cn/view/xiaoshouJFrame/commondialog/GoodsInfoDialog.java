package com.cn.view.xiaoshouJFrame.commondialog;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * ��Ʒ��Ϣ�Ի���
 * @author Administrator
 *
 */
public class GoodsInfoDialog extends JDialog {

	//��Ʒ���
	private JLabel spID = new JLabel();
	//����ͺ�
	private JLabel guiGeXingHao = new JLabel();
	//��������
	private JLabel changShang = new JLabel();
	//��ǰ���
	private JLabel kuCun = new JLabel();
	//��Ʒ����
	private JLabel goodsName = new JLabel();
	//��λ
	private JComboBox danWei = new JComboBox(new String[] {"ƿ","��","��"});
	//��ɫ
	private JLabel color = new JLabel();
	//��ǰ���
	private JLabel kucun = new JLabel();
	//��ע
	private JLabel beiZhu = new JLabel();
	//�ο��ۼ�
	private JTextField shouJieText = new JTextField(8);
	//������
	private JTextField daZheText = new JTextField(6);
	//����
	private JTextField shuLiangText = new JTextField(6);
	//�ۺ󵥼�
	private JLabel zhdjLabel = new JLabel();
	//�ܼ�
	private JLabel zjLable = new JLabel();
	
	private JButton sureButton = new JButton("ȷ��(F5)");
	private JButton exitButton = new JButton("�˳�(F4)");
	
	public GoodsInfoDialog(JDialog dialog,String title,boolean model) {
		super(dialog,title,model);
		init();
	}
	
	public void init() {
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(createPanel(),BorderLayout.CENTER);
		this.add(createSouthPanel(),BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public JPanel createSouthPanel(){
		JPanel southPanel = new JPanel();
		southPanel.add(sureButton);
		southPanel.add(exitButton);
		return southPanel;
	}
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("��Ʒ���:"));
		box1.add(spID);
		box1.add(Box.createHorizontalStrut(80));
		box1.add(new JLabel("��Ʒ����:"));
		box1.add(goodsName);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("����ͺ�:"));
		box2.add(guiGeXingHao);
		box2.add(Box.createHorizontalStrut(40));
		box2.add(new JLabel("��λ:"));
		box2.add(danWei);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("��������:"));
		box3.add(changShang);
		box3.add(Box.createHorizontalStrut(40));
		box3.add(new JLabel("��ɫ:"));
		box3.add(color);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("��ǰ���:"));
		box4.add(kucun);
		box4.add(Box.createHorizontalStrut(40));
		box4.add(new JLabel("��ע:"));
		box4.add(beiZhu);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("�ο��ۼ�:"));
		box5.add(shouJieText);
		box5.add(new JLabel("Ԫ"));
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("������:"));	
		box5.add(daZheText);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("����:"));
		box5.add(shuLiangText);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("�ۺ󵥼�:"));
		box6.add(zhdjLabel);
		box6.add(new JLabel("Ԫ"));
		box6.add(Box.createHorizontalStrut(20));

		JLabel label = new JLabel("1Ϊ������,0.8Ϊ��8��");
		label.setForeground(Color.RED);
		box6.add(label);
		box6.add(new JLabel("�ܼ�:"));
		box6.add(zjLable);
		box6.add(new JLabel("Ԫ"));
		
		Box box = Box.createVerticalBox();
		box.add(box1);
		box.add(Box.createVerticalStrut(30));
		box.add(box2);
		box.add(Box.createVerticalStrut(30));
		box.add(box3);
		box.add(Box.createVerticalStrut(30));
		box.add(box4);
		box.add(Box.createVerticalStrut(30));
		box.add(box5);
		box.add(Box.createVerticalStrut(30));
		box.add(box6);
		box.add(Box.createVerticalStrut(30));
		
		panel.add(box);
		panel.setBorder(new TitledBorder("��Ʒ��Ϣ"));
		return panel;
	}
	
	public static void main(String[] args){
		new GoodsInfoDialog(null,"��Ʒ��Ϣ",true);
	}
}
