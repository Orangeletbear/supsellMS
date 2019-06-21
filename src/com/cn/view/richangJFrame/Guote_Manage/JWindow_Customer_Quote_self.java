package com.cn.view.richangJFrame.Guote_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.control.richangframe.Guote_Manage.Action_Customer_Quote_Confirm;
import com.cn.dao.richang.Customer_Manage.JDBC_RiChang_GetCustomer;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Customer_Manage_Model;

public class JWindow_Customer_Quote_self extends JWindow{
	private static JWindow_Customer_Quote_self khWindow = null;
	private JTable table;
	private JScrollPane js;
	private JCheckBox query;
	private JButton confirm;
	private JButton exit;
	private JPanel North;
	private AllTableModel tabelModel;
	private Add_Quote_Goods dialog;
	private static Vector data = new Vector();
	private JLabel label;
	private JTextField chaxun_kh;
	/**
	 * 通过单子模式实现本窗口
	 * @param dialog
	 * @return
	 */
    public static JWindow_Customer_Quote_self getjcmWindow(Add_Quote_Goods dialog){
    	if(khWindow==null){
//    		data = JDBC_RiChang_GetCustomer.getCustomer(dialog.getText_name().getText());
    		
    		khWindow = new JWindow_Customer_Quote_self(dialog);
    		
    		khWindow.setSize(480, 220);
    		khWindow.setLocation(dialog.get_X(), dialog.get_Y());
    		khWindow.setVisible(true);
    		return khWindow;
    	}else{
//    		data = JDBC_RiChang_GetCustomer.getCustomer(dialog.getText_name().getText());
    		khWindow.getTabelModel().setDataVector(data,
    				AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
    		
    		khWindow.setVisible(true);
    		return khWindow;
    	}
    }
	private JWindow_Customer_Quote_self(Add_Quote_Goods dialog){
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
//		table//添加鼠标监听器
		table.addMouseListener(new Action_Customer_Quote_Confirm(JWindow_Customer_Quote_self.this));

		js = new JScrollPane();
		js.setViewportView(table);
		Center.add(js);
		getContentPane().add(Center,BorderLayout.CENTER);
		
		confirm = new JButton("确定");
		confirm.addActionListener(new Action_Customer_Quote_Confirm(JWindow_Customer_Quote_self.this));
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chaxun_kh.setText(null);
				dispose();
			}
		});
		
		label = new JLabel("查询客户");
		South.add(label);
		
		chaxun_kh = new JTextField(15);
		chaxun_kh.getDocument().addDocumentListener(new DocumentListener(){

			public void changedUpdate(DocumentEvent arg0) {
				
				data = JDBC_RiChang_GetCustomer.getCustomer(chaxun_kh.getText().trim());
				tabelModel.setDataVector(data,
	    				AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
			}

			public void insertUpdate(DocumentEvent arg0) {
				data = JDBC_RiChang_GetCustomer.getCustomer(chaxun_kh.getText().trim());
				tabelModel.setDataVector(data,
	    				AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				data = JDBC_RiChang_GetCustomer.getCustomer(chaxun_kh.getText().trim());
				tabelModel.setDataVector(data,
	    				AllTableModel.getVectorFromObj(Customer_Manage_Model.JWindow_Customer_Col));
				
			}
			
		});
		South.add(chaxun_kh);
		chaxun_kh.setColumns(10);
		South.add(confirm);
		South.add(exit);
		getContentPane().add(South,BorderLayout.SOUTH);
		
	}
	//获取查询简码内容
	public JTextField getChaxun_kh() {
		return chaxun_kh;
	}
	public static Vector getData() {
		return data;
	}
	//获取JWindow_Quote_Manage本窗口的JTable
	public JTable getTable() {
		return table;
	}
	
	//获取JWindow_Quote_Manage本窗口的TabelModel
	public AllTableModel getTabelModel() {
		return tabelModel;
	}
	//获取传入进来的父窗口
	public Add_Quote_Goods getDialog() {
		return dialog;
	}
}
