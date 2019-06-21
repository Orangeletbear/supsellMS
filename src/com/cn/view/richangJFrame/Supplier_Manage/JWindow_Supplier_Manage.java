package com.cn.view.richangJFrame.Supplier_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

import com.cn.control.richangframe.Supplier_Manage.Action_Supplier_Confirm_Row;
import com.cn.dao.richang.Supplier_Manage.JDBC_RiChang_GetSupplier;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Supplier_Manage_Model;

public class JWindow_Supplier_Manage extends JWindow{
	private static JWindow_Supplier_Manage ghWindow = null;
	public static  JWindow_Supplier_Manage getGhWindow() {
		return ghWindow;
	}
	private JTable table;
	private JScrollPane js;
	private JButton confirm;
	private JButton exit;
	private Supplier_Manage dialog;
	private AllTableModel tabelModel;
	private static Vector data = new Vector();
	/**
	 * 通过单子模式实现本窗口
	 * @param dialog
	 * @return
	 */
    public static JWindow_Supplier_Manage getjsmWindow( Supplier_Manage dialog){
    	if(ghWindow==null){
    		data = JDBC_RiChang_GetSupplier.getSupplier(dialog.getText_North());
    		
    		ghWindow = new JWindow_Supplier_Manage(dialog);
    		
    		ghWindow.setSize(480, 220);
    		ghWindow.setLocation(dialog.get_X(), dialog.get_Y());
    		ghWindow.setVisible(true);
    		dialog.getJTextField().requestFocus();
    		return ghWindow;
    	}else{
    		data = JDBC_RiChang_GetSupplier.getSupplier(dialog.getText_North());
    		ghWindow.getTabelModel().setDataVector(data,
    				AllTableModel.getVectorFromObj(Supplier_Manage_Model.JWindow_Supplier_Col));
    		
    		ghWindow.setVisible(true);
    		dialog.getJTextField().requestFocus();
    		return ghWindow;
    	}
    }
	private  JWindow_Supplier_Manage(Supplier_Manage dialog){
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
		
		tabelModel  = new AllTableModel(data, AllTableModel.getVectorFromObj(Supplier_Manage_Model.JWindow_Supplier_Col));
		table = new JTable(tabelModel);
		table.addMouseListener(new Action_Supplier_Confirm_Row(JWindow_Supplier_Manage.this));
		js = new JScrollPane();
		js.setViewportView(table);
		Center.add(js);
		getContentPane().add(Center,BorderLayout.CENTER);
		confirm = new JButton("确定");
		confirm.addActionListener(new Action_Supplier_Confirm_Row(JWindow_Supplier_Manage.this));
		
		
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		South.add(confirm);
		South.add(exit);
		getContentPane().add(South,BorderLayout.SOUTH);
		dialog.getJTextField().requestFocus();
		
	}
	
	public static Vector getData() {
		return data;
	}
	public static void setData(Vector data) {
		JWindow_Supplier_Manage.data = data;
	}
	
	//获取JWindow_Supplier_Manage本窗口的JTable
	public JTable getTable() {
		return table;
	}
	
	//获取JWindow_Supplier_Manage本窗口的TabelModel
	public AllTableModel getTabelModel() {
		return tabelModel;
	}
	//获取传入进来的父窗口
	public Supplier_Manage getDialog() {
		return dialog;
	}
}
