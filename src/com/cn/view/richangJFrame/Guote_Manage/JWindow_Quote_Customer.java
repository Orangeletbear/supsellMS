package com.cn.view.richangJFrame.Guote_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

import com.cn.dao.richang.Customer_Manage.JDBC_RiChang_GetCustomer;
import com.cn.model.AllTableModel;

public class JWindow_Quote_Customer extends JWindow{
	private JTable table;
	private JScrollPane js;
	private JCheckBox query;
	private JButton confirm;
	private JButton exit;
	private JPanel North;
	private JCheckBox checkBox;
	public JWindow_Quote_Customer(JDialog dialog){
		super(dialog);
		init();
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout());
		
		JPanel Center = new JPanel();
		JPanel South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		Center.setLayout(new BorderLayout(0, 0));
		
		Vector data = JDBC_RiChang_GetCustomer.getCustomer("");

		table = new JTable(data, AllTableModel.getVectorFromObj(new String[] {
		  		"编号", "供货商名称", "联系人", "联系电话", "联系地址"
	  	}));
		
		js = new JScrollPane();
		js.setViewportView(table);
		Center.add(js);
		getContentPane().add(Center,BorderLayout.CENTER);
		
		confirm = new JButton("确定");
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		South.add(confirm);
		South.add(exit);
		getContentPane().add(South,BorderLayout.SOUTH);
		
		North = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) North.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		getContentPane().add(North, BorderLayout.NORTH);
		
		checkBox = new JCheckBox("查询全部用户");
		North.add(checkBox);
	}

}
