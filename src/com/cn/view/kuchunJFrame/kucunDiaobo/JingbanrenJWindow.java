package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.model.kuchun.chaifenkunbang.ChaiFenKunBang;

/**
 * 
 * ��������ϸ��Ϣ����
 * ���ڲ�ѯ���޸ģ������µľ�����
 * @author Administrator
 *
 */
public class JingbanrenJWindow extends JDialog {
	private DefaultTableModel tableModelJBR;//������
	private JTable tableJBR;//������
	private JTextField textJBRCX;//�����˲�ѯ
	private JButton btnYes;//ȷ��
	private JButton btnZJ;//����
	private JButton btnXG;//�޸�
	private JButton btnExit;//�رհ�ť
	
	
	public JingbanrenJWindow(JDialog dialog,String title,boolean b){
		super(dialog,title,b);
		init();
	}
	
	private void init(){
		this.setBounds(240, 280, 480, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		
		//scrollPane ���
		JPanel cenJpanel = new JPanel();
		tableModelJBR = new AllTableModel(ChaiFenKunBang.dataCFKB1,KCDBModel.colunmsJBR);
		tableJBR = new JTable(tableModelJBR);
		tableJBR.setAutoCreateRowSorter(true); //������ñ���Զ�����
		tableJBR.setPreferredScrollableViewportSize(new Dimension(460,220));
			JScrollPane scroPane = new JScrollPane(tableJBR,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
			cenJpanel.add(scroPane);
		
		//�ײ���ť������
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
		
		JLabel label = new JLabel("��Ʒ��ѯ(F2)");
		label.setPreferredSize(new Dimension(65,20));
		label.setFont(new Font("����",Font.BOLD,10));
		
		textJBRCX = new JTextField(10);
		
		btnYes = new JButton("ȷ��");
		btnYes.setPreferredSize(new Dimension(65,20));
		btnYes.setFont(new Font("����",Font.BOLD,10));
		
		btnZJ = new JButton("����");
		btnZJ.setPreferredSize(new Dimension(65,20));
		btnZJ.setFont(new Font("����",Font.BOLD,10));
		
		btnXG = new JButton("�޸�");
		btnXG.setPreferredSize(new Dimension(65,20));
		btnXG.setFont(new Font("����",Font.BOLD,10));
		
		btnExit = new JButton("�˳�");
		btnExit.setPreferredSize(new Dimension(65,20));
		btnExit.setFont(new Font("����",Font.BOLD,10));
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JingbanrenJWindow.this.dispose();
			}
		});
		
		{
			souJpanel.add(label);
			souJpanel.add(textJBRCX);
			souJpanel.add(btnYes);
			souJpanel.add(btnZJ);
			souJpanel.add(btnXG);
			souJpanel.add(btnExit);
		}
		
		{
			jpanel.add(cenJpanel,BorderLayout.CENTER);
			jpanel.add(souJpanel,BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	
/*	public static void main(String[] args) {
		new JingbanrenJWindow(null).setVisible(true);
	}*/
}
