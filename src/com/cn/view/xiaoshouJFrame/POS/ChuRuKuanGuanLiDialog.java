package com.cn.view.xiaoshouJFrame.POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.wanglaizhangwu.WangLaiZhangWuDialog;

/**
 * POS����Ա��������Ի���
 * @author Administrator
 *
 */
public class ChuRuKuanGuanLiDialog extends JDialog {
    
	//panel_north
	private JButton ruKuanButton = new JButton(new ImageIcon("res/AcionIcon/rukuan.jpg"));
	private JButton chuKuanButton = new JButton(new ImageIcon("res/AcionIcon/chukuan.jpg"));
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	//panel_center
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	
	private JButton riQiButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	private JComboBox namesBox = new JComboBox(new String[] {"��������Ա����","pos","04"});
	private JButton chaXunButton = new JButton("��ѯ");
	private Vector data = new Vector();//table ����
	private Vector<String> cloumnNames = new Vector<String>();//table ����
	
	
	
	public ChuRuKuanGuanLiDialog(JFrame parent,String title,boolean model) {
		
		super(parent,title,model);
		init();
	}
	public void init() {
		this.setSize(700,550);
		this.setResizable(false);
		this.add( keHuFuKuanMingXi());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private JPanel keHuFuKuanMingXi(){
		JPanel keHuFuKuanMingXi = new JPanel();
		
		keHuFuKuanMingXi.setLayout(new BorderLayout());
		keHuFuKuanMingXi.add(panel_north(),BorderLayout.NORTH);
		keHuFuKuanMingXi.add(panel_center(),BorderLayout.CENTER);
		return keHuFuKuanMingXi;
	}
	//
	//panel_north
	private JPanel panel_north(){
		JPanel panel_north = new JPanel();
		
		ruKuanButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		chuKuanButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		
		panel_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel_north.add(ruKuanButton);
		panel_north.add(chuKuanButton);
		panel_north.add(daoChuButton);
		panel_north.add(daYinButton);
		panel_north.add(tuiChuButton);
		ruKuanButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new POSLuKuangDialog(ChuRuKuanGuanLiDialog.this,"���",true);
			}
			
		});
		chuKuanButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new POSChuKuangDialog(ChuRuKuanGuanLiDialog.this,"����",true);
			}
			
		});
		
		tuiChuButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ChuRuKuanGuanLiDialog.this.dispose();
			}
			
		});
		panel_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel_north;
	}
	//panel_center ��Ϊ������
	private JPanel panel_center(){
		JPanel panel_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		//pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯ���� :"));
		pane1.add(dataPicker1);
		pane1.add(new JLabel("�� "));
		pane1.add(dataPicker2);
		riQiButton.setMargin(new Insets(0,0,0,0));
		pane1.add(riQiButton);
		pane1.add(new JLabel("�ͻ����� :"));
		pane1.add(namesBox);
		pane1.add(chaXunButton);
		pane1.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		//pane2
		cloumnNames.add("����");
		cloumnNames.add( "��������");
		cloumnNames.add("�����");
		cloumnNames.add("������");
		cloumnNames.add("��������");
		cloumnNames.add("����Ա");
		cloumnNames.add("����Ա");
	
		
		
		JTable table = new JTable(data,cloumnNames);
		table.setPreferredScrollableViewportSize(new Dimension(700,356));//���̶���С
		pane2.add(new JScrollPane(table));
		
		panel_center.setLayout(new BorderLayout());
		panel_center.add(pane1,BorderLayout.NORTH);
		panel_center.add(pane2,BorderLayout.CENTER);
		
		
		return panel_center;
	}
	public static void main(String[] args){
		new ChuRuKuanGuanLiDialog(null,"POS��������",true);
	}
	
}
