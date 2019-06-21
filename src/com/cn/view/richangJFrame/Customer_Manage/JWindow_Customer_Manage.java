package com.cn.view.richangJFrame.Customer_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

import com.cn.control.richangframe.Customer_Manage.Action_Customer_Confirm_Row;
import com.cn.dao.richang.Customer_Manage.JDBC_RiChang_GetCustomer;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;

public class JWindow_Customer_Manage extends JWindow{
	private static JWindow_Customer_Manage khWindow = null;
	private JTable table;
	private JScrollPane js;
	private JCheckBox query;
	private JButton confirm;
	private JButton exit;
	private JPanel North;
	private AllTableModel tabelModel;
	private Customer_Manage dialog;
	private static Vector data = new Vector();
	/**
	 * 通过单子模式实现本窗口
	 * @param dialog
	 * @return
	 */
    public static JWindow_Customer_Manage getjcmWindow(Customer_Manage dialog){
    	if(khWindow==null){
    		data = JDBC_RiChang_GetCustomer.getCustomer(dialog.getText_North().getText());
    		
    		khWindow = new JWindow_Customer_Manage(dialog);
    		
    		khWindow.setSize(480, 220);
    		khWindow.setLocation(dialog.get_X(), dialog.get_Y());
    		khWindow.setVisible(true);
    		dialog.getText_North().requestFocus();
    		return khWindow;
    	}else{
    		data = JDBC_RiChang_GetCustomer.getCustomer(dialog.getText_North().getText());
    		khWindow.getTabelModel().setDataVector(data,
    				AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
    		
    		khWindow.setVisible(true);
    		dialog.getText_North().requestFocus();
    		return khWindow;
    	}
    }
	private JWindow_Customer_Manage(Customer_Manage dialog){
		super(dialog);
		this.dialog = dialog;
		init();
		this.setSize(480, 220);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout());
		
		JPanel Center = new JPanel();
		JPanel South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South.getLayout();
		Center.setLayout(new BorderLayout(0, 0));
		
//		Vector data = JDBC_RiChang_GetCustomer.getCustomer();
		tabelModel  = new AllTableModel(data, AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
		table = new JTable(tabelModel);
		
		js = new JScrollPane();
		js.setViewportView(table);
		Center.add(js);
		getContentPane().add(Center,BorderLayout.CENTER);
		
		confirm = new JButton("确定");
		confirm.addActionListener(new Action_Customer_Confirm_Row(JWindow_Customer_Manage.this));
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		South.add(confirm);
		South.add(exit);
		getContentPane().add(South,BorderLayout.SOUTH);
		dialog.getText_North().requestFocus();
		
	}
	
	public static Vector getData() {
		return data;
	}
	//获取JWindow_Customer_Manage本窗口的JTable
	public JTable getTable() {
		return table;
	}
	
	//获取JWindow_Customer_Manage本窗口的TabelModel
	public AllTableModel getTabelModel() {
		return tabelModel;
	}
	//获取传入进来的父窗口
	public Customer_Manage getDialog() {
		return dialog;
	}
}
