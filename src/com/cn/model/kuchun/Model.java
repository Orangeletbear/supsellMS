package com.cn.model.kuchun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

//=====================table.setAutoCreateRowSorter(true); 此语句让表格自动排序
public class Model extends JDialog {

	public Model(JDialog dialog,String title,boolean b){
		super(dialog,title,b);
		init();
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(addCom());
		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	/*
	 * 北部面板
	 * 
	 */
	private JPanel addNor(){
		JPanel norJpanel = new JPanel();
		
		return norJpanel;
	}

	/*
	 * 中部面板
	 * 
	 */
	private JPanel addCen(){
		JPanel cenJpanel = new JPanel();
		
		
		
		
		return cenJpanel;
	}
	
	/*
	 * 南部面板
	 * 
	 */
	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		
		
		
		
		return souJpanel;
	}
	
	public static void main(String []args){
		new Model(null,"",true);
	}
	
	/*
	 * 此方法是创建table面板
	 * 
	 */
	private void createTable(JPanel jpanel,JTable table,
		DefaultTableModel tableModel,Object[][] data,Object[] colunms){
		tableModel = new MyTableModel(data,colunms);
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true); //此语句让表格自动排序
		table.setPreferredScrollableViewportSize(new Dimension(770,300));
		JScrollPane scroPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		jpanel.add(scroPane);
	}
	
	
}
