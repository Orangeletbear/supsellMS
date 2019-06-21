package com.cn.view.richangJFrame.Customer_Manage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Customer_Manage.Action_Connect_Record_Change;
import com.cn.dao.richang.Customer_Manage.JDBC_Connect_Record;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;

public class Customer_Connect_Record_Change extends JDialog {
	private Vector jbr = new Vector();

	private JButton save = new JButton("保存");
	private JButton concel = new JButton("取消");
	private JTextArea textarea = new JTextArea();
	private JComboBox date_S;
	private DefaultComboBoxModel comboxMoel;
	private JComboBox comboBox;
	private Customer_Manage cm ;

	private AllTableModel TableModel;

	private JTable table_cm;
	
	public Customer_Connect_Record_Change(Customer_Manage cm, String title,
			boolean b) {
		super(cm,title,b);
		this.cm = cm;
		getContentPane().setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setSize(270,315);
		init();
		
		
		
	}

	private void init() {
		//获取选中行的数据
		TableModel = cm.getTabelModel_split_2_tab_2();
		table_cm = cm.getTable_split_2_tab_2();
		int row = table_cm.getSelectedRow();
		System.out.println(row);
		if(row != -1){
			Vector data_2 = (Vector)TableModel.getDataVector().get(row);
			textarea.setText(data_2.get(1).toString());
			JLabel time = new JLabel("联系时间：");
			date_S = new JDatePicker();
			JLabel people = new JLabel("经办人：");
			comboBox = new JComboBox();
			//JComboBox 选项来自数据库中员工表
			jbr = JDBC_Connect_Record.get_jbr();
			comboxMoel = new DefaultComboBoxModel(jbr);
			comboxMoel.setSelectedItem(data_2.get(2).toString());
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
			
			/**
			 * 修改信息
			 */
			save.addActionListener(new Action_Connect_Record_Change(Customer_Connect_Record_Change.this));
			
			concel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			this.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(cm, "请选择指定列！", "系统信息", 
					JOptionPane.OK_OPTION, new ImageIcon("res\\AcionIcon\\wenhao.jpg"));
		}
		
		
		
		
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
	public Customer_Manage getcm() {
		return cm;
	}
}
