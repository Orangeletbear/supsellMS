package com.cn.view.richangJFrame.Salesman_Manage;

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

import com.cn.control.richangframe.Salesman_Manage.Action_Salesman_Confirm_Row;
import com.cn.dao.richang.Salesman_Manage.JDBC_RiChang_getSalesman;
import com.cn.model.AllTableModel;
import com.cn.model.richang.Salesman_Manage_Model;

public class JWindow_Salesman_Manage extends JWindow{
	private static JWindow_Salesman_Manage ywyWindow = null;
	private JTable table;
	private JScrollPane js;
	private JCheckBox query;
	private JButton confirm;
	private JButton exit;
	private JCheckBox checkBox;
	private Salesman_Manage dialog;
	private AllTableModel tabelModel;
	private static Vector data = new Vector();
	/**
	 * 通过单子模式实现本窗口
	 * @param dialog
	 * @return
	 */
    public static JWindow_Salesman_Manage getjsmWindow(Salesman_Manage dialog){
    	if(ywyWindow==null){
    		data = JDBC_RiChang_getSalesman.getSalesman(dialog.getSelect_name().getText());
    		
    		ywyWindow = new JWindow_Salesman_Manage(dialog);
    		
    		ywyWindow.setSize(480, 220);
    		ywyWindow.setLocation(dialog.get_X(), dialog.get_Y());
    		ywyWindow.setVisible(true);
    		dialog.getSelect_name().requestFocus();
    		return ywyWindow;
    	}else{
    		data = JDBC_RiChang_getSalesman.getSalesman(dialog.getSelect_name().getText());
    		ywyWindow.getTabelModel().setDataVector(data,
    				AllTableModel.getVectorFromObj(Salesman_Manage_Model.JWindow_Salesman_Col));
    		
    		ywyWindow.setVisible(true);
    		dialog.getSelect_name().requestFocus();
    		return ywyWindow;
    	}
    }
	
	
	private JWindow_Salesman_Manage(Salesman_Manage dialog){
		super(dialog);
		this.dialog = dialog;
		init();
		this.setSize(460, 215);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout());
		
		
		
		JPanel Center = new JPanel();
		JPanel South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South.getLayout();
		Center.setLayout(new BorderLayout(0, 0));
		
		tabelModel  = new AllTableModel(data, AllTableModel.getVectorFromObj(Salesman_Manage_Model.JWindow_Salesman_Col));
		table = new JTable(tabelModel);
		
		js = new JScrollPane();
		js.setViewportView(table);
		Center.add(js);
		getContentPane().add(Center,BorderLayout.CENTER);
		
		confirm = new JButton("确定");
		confirm.addActionListener(new Action_Salesman_Confirm_Row(JWindow_Salesman_Manage.this));
		
		exit = new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		South.add(confirm);
		South.add(exit);
		getContentPane().add(South,BorderLayout.SOUTH);
		dialog.getSelect_name().requestFocus();
	}
	
	public static Vector getData() {
		return data;
	}
	//获取JWindow_Salesman_Manage本窗口的JTable
	public JTable getTable() {
		return table;
	}
	
	//获取JWindow_Salesman_Manage本窗口的TabelModel
	public AllTableModel getTabelModel() {
		return tabelModel;
	}
	//获取传入进来的父窗口
	public Salesman_Manage getDialog() {
		return dialog;
	}
}
