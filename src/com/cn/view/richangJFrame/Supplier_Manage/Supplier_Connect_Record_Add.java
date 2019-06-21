package com.cn.view.richangJFrame.Supplier_Manage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Supplier_Manage.Action_Connect_Record_Add;
import com.cn.dao.richang.Supplier_Manage.JDBC_Connect_Record;
import com.cn.util.JDatePicker;

public class Supplier_Connect_Record_Add extends JDialog {
	private Vector jbr = new Vector();

	private JButton save = new JButton("保存");
	private JButton concel = new JButton("取消");
	private JTextArea textarea = new JTextArea();
	private JComboBox date_S;
	private DefaultComboBoxModel comboxMoel;
	private JComboBox comboBox;
	private Supplier_Manage sm ;

	public Supplier_Connect_Record_Add(Supplier_Manage sm ,String title, boolean b) {
		super(sm,title,b);
		this.sm = sm;
		getContentPane().setLayout(new BorderLayout());
		
		init();
		this.setSize(270,315);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void init() {
		JLabel time = new JLabel("联系时间：");
		date_S = new JDatePicker();
		JLabel people = new JLabel("经办人：");
		comboBox = new JComboBox();
		//JComboBox 选项来自数据库中员工表
		jbr = JDBC_Connect_Record.get_jbr();
		comboxMoel = new DefaultComboBoxModel(jbr);
		comboxMoel.setSelectedItem(null);
		comboBox.setModel(comboxMoel);
		
		JPanel north = new JPanel();
		JPanel north_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) north_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel north_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) north_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		north_1.add(Box.createHorizontalStrut(30));
		north_1.add(time);
		north_1.add(date_S);
		
		Component horizontalStrut = Box.createHorizontalStrut(43);
		north_2.add(horizontalStrut);
		north_2.add(people);
		north_2.add(Box.createHorizontalStrut(10));
		north_2.add(comboBox);
		
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(north_1);
		north.add(north_2);
		getContentPane().add(north,BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.setBorder(new TitledBorder(null, "联系内容", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		center.setLayout(new BorderLayout(0, 0));
		center.add(textarea);
		getContentPane().add(center,BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		south.add(save);
		south.add(concel);
		getContentPane().add(south,BorderLayout.SOUTH);
		
		
		save.addActionListener(new Action_Connect_Record_Add(Supplier_Connect_Record_Add.this));
		
		concel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	//获取联系时间
	public JComboBox getComboBox_date() {
		return date_S;
	}
	//获取联系经办人
	public JComboBox getComboBox_jbr() {
		return comboBox;
	}
	//获取联系内容
	public JTextArea getTextarea() {
		return textarea;
	}
	//获取父窗口对象
	public Supplier_Manage getSm() {
		return sm;
	}
}
