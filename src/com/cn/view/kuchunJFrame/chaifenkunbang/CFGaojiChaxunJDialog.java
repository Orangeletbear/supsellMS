package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.Dimension;
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

import com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun.GaoJiChaXunOKActionListener;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.CFKBModel;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class CFGaojiChaxunJDialog extends JDialog {
	private ChaifenKunbang dialog;
	private JComboBox comboCFCK;//��ֲֿ�
	private JComboBox comboJBR;//������
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	/////------------------------
	public CFGaojiChaxunJDialog(ChaifenKunbang dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	
	public JComboBox getComboCFCK() {
		return comboCFCK;
	}

	public JComboBox getComboJBR() {
		return comboJBR;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}
	
	public ChaifenKunbang getDialog() {
		return dialog;
	}

	private void init(){
		this.setSize(250, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(3,1));
		
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		JPanel jpanel3 = new JPanel();
		
		/*new BoxLayout(jpanel1,BoxLayout.Y_AXIS);
		new BoxLayout(jpanel2,BoxLayout.Y_AXIS);*/
		
		JLabel label1 = new JLabel("���ڲֿ�:");
		label1.setPreferredSize(new Dimension(80,30));
		JLabel label2 = new JLabel("������:");
		label2.setPreferredSize(new Dimension(80,30));
		
		comboCFCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboCFCK.addItem("���вֿ�");
		comboCFCK.setSelectedItem("���вֿ�");
		comboCFCK.setPreferredSize(new Dimension(90,30));
		
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
		comboJBR.addItem("���о�����");
		comboJBR.setSelectedItem("���о�����");
		comboJBR.setPreferredSize(new Dimension(90,30));
		
		btnYes = new JButton("ȷ��",new ImageIcon("res/AcionIcon/green.jpg"));
		btnYes.setMargin(new Insets(0,0,0,0));
		btnYes.setPreferredSize(new Dimension(80,30));
		btnNo = new JButton("�˳�",new ImageIcon("res/AcionIcon/red.jpg"));
		btnNo.setMargin(new Insets(0,0,0,0));
		btnNo.setPreferredSize(new Dimension(80,30));
		{
			btnYes.addActionListener(new GaoJiChaXunOKActionListener(this));
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					CFGaojiChaxunJDialog.this.dispose();
				}
			});
		}
		
		{
			jpanel1.add(label1);
			jpanel1.add(comboCFCK);
			
			jpanel2.add(label2);
			jpanel2.add(comboJBR);
			
			jpanel3.add(btnYes);
			jpanel3.add(btnNo);
		}
		
		{
			jpanel.add(jpanel1);
			jpanel.add(jpanel2);
			jpanel.add(jpanel3);
			
		}
		return jpanel;
	}
	
	
	public static void main(String [] args){
		new CFGaojiChaxunJDialog(null,"�������",true);
	}
}
