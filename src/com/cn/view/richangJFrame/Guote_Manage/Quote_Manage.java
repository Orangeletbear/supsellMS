package com.cn.view.richangJFrame.Guote_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.control.richangframe.Guote_Manage.Action_query_kind;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Guote_Manage_Model;
import com.cn.util.JDatePicker;
import com.cn.util.PrintTableData;

public class Quote_Manage extends JDialog {
	private JPanel main_panel;
	private JPanel N;
	private JPanel C;
	private JPanel N_C_;
	private JScrollPane C_C;
	private JPanel S_C;
	private JButton addBaoJia;
	private JButton daochu;
	private JButton print;
	private JButton exit;
	private JLabel query_date;
	private JDatePicker datepicker_1;
	private JLabel zhi;
	private JDatePicker datepicker_2;
	private JLabel goods_info;
	private JTextField text_goods;
	private JButton query_F2;
	private JTable table;
	private JLabel record_num;
	private Vector data;
	private AllTableModel tabelModel;
	private JLabel record_num_;

	public Quote_Manage(JFrame frame,String title,boolean b) {
		super(frame,title, b);
		
		init();
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize (800, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void init() {
		addTab_1();
		addTab_2();
	}

	private void addTab_2() {
		addpanel_2_2();
	}

	private void addTab_1() {
		
		main_panel = new JPanel();
		getContentPane().add(main_panel, BorderLayout.NORTH);
		main_panel.setLayout(new BorderLayout(0, 0));
		
		N = new JPanel();
		FlowLayout fl_N_tab_1 = (FlowLayout) N.getLayout();
		fl_N_tab_1.setAlignment(FlowLayout.LEFT);
		
		
		addBaoJia = new JButton(new ImageIcon("res\\AcionIcon\\addBaoJia.jpg"));
		addBaoJia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Quote_Goods(Quote_Manage.this,"添加报价商品",true);
			}
		});
		addBaoJia.setMargin(new Insets(0,0,0,0));
		N.add(addBaoJia);
		
		
		
		daochu = new JButton(new ImageIcon("res\\AcionIcon\\daochu.jpg"));
		daochu.setMargin(new Insets(0,0,0,0));
		
		daochu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", table, 
						Guote_Manage_Model.table);
			}
			
		});
		N.add(daochu);
		
		print = new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		print.setMargin(new Insets(0,0,0,0));
		N.add(print);
		
		exit = new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		N.add(exit);
		
		main_panel.add(N, BorderLayout.NORTH);
		
		C = new JPanel();
		main_panel.add(C, BorderLayout.CENTER);
		C.setLayout(new BorderLayout(0, 0));
		N = new JPanel();
		FlowLayout fl_N_C = (FlowLayout) N.getLayout();
		fl_N_C.setAlignment(FlowLayout.LEFT);
		C.add(N, BorderLayout.NORTH);
		
		query_date = new JLabel("查询日期：");
		N.add(query_date);
		
		datepicker_1 = new JDatePicker();
		N.add(datepicker_1);
		
		zhi = new JLabel("至");
		N.add(zhi);
		
		datepicker_2 = new JDatePicker();
		N.add(datepicker_2);
		
		goods_info = new JLabel("按商品信息");
		N.add(goods_info);
		
		text_goods = new JTextField("全部商品");
		text_goods.addActionListener(new Action_query_kind(Quote_Manage.this));
		
		N.add(text_goods);
		text_goods.setColumns(10);
		
		query_F2 = new JButton("查询(F2)");
		query_F2.addActionListener(new Action_query_kind(Quote_Manage.this));
		N.add(query_F2);
		
		data = new Vector();
		tabelModel  = new AllTableModel(data, 
				AllTableModel.getVectorFromObj(Guote_Manage_Model.table));
		table = new JTable(tabelModel);
		table.setAutoCreateRowSorter(true);
		C_C = new JScrollPane();
		C_C.setViewportView(table);
		C.add(C_C, BorderLayout.CENTER);
		S_C = new JPanel();
		FlowLayout fl_S_C = (FlowLayout) S_C.getLayout();
		fl_S_C.setAlignment(FlowLayout.LEFT);
		C.add(S_C, BorderLayout.SOUTH);
		
		record_num = new JLabel("记录数：");
		S_C.add(record_num);
		
		record_num_ = new JLabel("0");
		S_C.add(record_num_);
	}
	
	public JTextField getText_goods() {
		return text_goods;
	}

	public AllTableModel getTabelModel() {
		return tabelModel;
	}

	private void addpanel_2_2() {
		
		addpanel_2_3();
	}



	private void addpanel_2_3() {
		text_goods.setColumns(10);
	}



	public JDatePicker getDatepicker_1() {
		return datepicker_1;
	}

	public JDatePicker getDatepicker_2() {
		return datepicker_2;
	}
	
	


}
