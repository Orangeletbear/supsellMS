package com.cn.view.richangJFrame.Salesman_Manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Salesman_Info extends JDialog {

	

	private JPanel panel_1;
	private JPanel panel_0;
	private JScrollPane scrollPane;
	private JButton modify;
	private AbstractButton delete;
	private JButton find;
	private JButton tianjia;
	private JButton quanbu;
	private JButton print;
	private JButton exit;
	private JTable table;
	private JButton daochu;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JSeparator separator;


	/**
	 * Create the dialog.
	 */
	public Salesman_Info() {
		
		this.setTitle("员工信息");
		init();
		setBounds(400, 350, 600, 400);
	}
	
	
	private void init() {
		
		
		panel_0 = new JPanel();
		getContentPane().add(panel_0, BorderLayout.CENTER);
		panel_0.setLayout(new BorderLayout(0, 0));
		
		addPanel_1();
		panel_0.add(panel_1,BorderLayout.NORTH);
		
		
		addScrollPane();
		panel_0.add(scrollPane, BorderLayout.CENTER);
		
		
		addSouth();
		
		
		getContentPane().add(panel_0);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_0.add(panel, BorderLayout.SOUTH);
		
		label = new JLabel("供应商数");
		panel.add(label);
		
		label_1 = new JLabel("0                                                            ");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(label_1);
		
		
	}


	private void addSouth() {
		
	}


	private void addScrollPane() {
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"员工姓名", "职务", "联系电话", "联系地址", "联系地址","备注"
			}
		));
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		panel_0.add(scrollPane, BorderLayout.CENTER);
	}


	private void addPanel_1() {
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
//		panel_1.add(panel_1, BorderLayout.NORTH);
		
		tianjia = new JButton(new ImageIcon("res\\AcionIcon\\add.jpg"));
		tianjia.setMargin(new Insets(0,0,0,0));
		panel_1.add(tianjia);
		
		modify = new JButton(new ImageIcon("res\\AcionIcon\\atler.jpg"));
		modify.setMargin(new Insets(0,0,0,0));
		panel_1.add(modify);
		
		delete = new JButton(new ImageIcon("res\\AcionIcon\\delete.jpg"));
		delete.setMargin(new Insets(0,0,0,0));
		panel_1.add(delete);
		
		find = new JButton(new ImageIcon("res\\AcionIcon\\find.jpg"));
		find.setMargin(new Insets(0,0,0,0));
		panel_1.add(find);
		
		quanbu = new JButton(new ImageIcon("res\\AcionIcon\\all.jpg"));
		quanbu.setMargin(new Insets(0,0,0,0));
		panel_1.add(quanbu);
		
		daochu = new JButton(new ImageIcon("res\\AcionIcon\\daochu.jpg"));
		daochu.setMargin(new Insets(0,0,0,0));
		panel_1.add(daochu);
		
		print = new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		print.setMargin(new Insets(0,0,0,0));
		panel_1.add(print);
		
		exit = new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		panel_1.add(exit);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salesman_Info dialog = new Salesman_Info();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
