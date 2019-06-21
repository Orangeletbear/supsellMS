package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.control.kuchunframe.kucundiaobo.chaxun.GaoJiChaXunOKAction;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.KCDBModel;
import com.cn.view.kuchunJFrame.KucunDiaobo;


public class GaojiChaxunDialog extends JDialog {
	private KucunDiaobo dialog;
	private JComboBox comboDCCK;
	private JComboBox comboDRCK;
	private JComboBox comboJBR;
	private JButton btnYes;
	private JButton btnNo;
	
	//��ȡ��Ϣ
	public KucunDiaobo getDialog() {
		return dialog;
	}

	public JComboBox getComboDCCK() {
		return comboDCCK;
	}

	public JComboBox getComboDRCK() {
		return comboDRCK;
	}

	public JComboBox getComboJBR() {
		return comboJBR;
	}

	public GaojiChaxunDialog(KucunDiaobo dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	
	private void init(){
		this.setSize(240, 240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
		this.setResizable(false);
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		
		JPanel jpanel = new JPanel();
		/*
		 * �������Ʊ�ǩ
		 */
		JLabel labelDCCK = new JLabel("�����ֿ⣺");
		JLabel labelDRCK = new JLabel("����ֿ⣺");
		JLabel labelJBR = new JLabel("�� �� ��:");
		
		/*
		 * ��ʼ�������˵�
		 */
		comboDCCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboDCCK.addItem("���вֿ�");
		comboDCCK.setSelectedItem("���вֿ�");
		comboDRCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboDRCK.addItem("���вֿ�");
		comboDRCK.setSelectedItem("���вֿ�");
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
		comboJBR.addItem("���о�����");
		comboJBR.setSelectedItem("���о�����");
		
		/*
		 * ���尴ť
		 */
		btnYes = new JButton("ȷ��(F4)");
		{
			btnYes.addActionListener(new GaoJiChaXunOKAction(this));
		}
		btnNo = new JButton("ȡ��(F5)");
		//��ȡ����ťע�������
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GaojiChaxunDialog.this.dispose();
			}
		});
		/*
		 * ��������齨�Ĳ��֣�������������ķ���ȷ���齨��λ��
		 */
		labelDCCK.setBounds(20, 20, 100, 30);
		labelDCCK.setFont(new Font("����",Font.BOLD,14));
		this.add(labelDCCK);
		comboDCCK.setBounds(110, 20, 100, 30);
		this.add(comboDCCK);
		
		labelDRCK.setBounds(20, 70, 100, 30);
		labelDRCK.setFont(new Font("����",Font.BOLD,14));
		this.add(labelDRCK);
		comboDRCK.setBounds(110, 70, 100,30);
		this.add(comboDRCK);
		
		labelJBR.setBounds(20, 120, 100,30);
		labelJBR.setFont(new Font("����",Font.BOLD,14));
		this.add(labelJBR);
		comboJBR.setBounds(110, 120,  100,30);
		this.add(comboJBR);
		
		btnYes.setBounds(20, 170, 90, 25);
		this.add(btnYes);
		btnNo.setBounds(130, 170, 90, 25);
		this.add(btnNo);
		
		return jpanel;
	}
	
/*	public static void main(String []args){
		new GaojiChaxunDialog(null,"�߼���ѯ",true);
	}*/
	
}
