package com.cn.view.xiaoshouJFrame.table;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePane extends JPanel {

	private JTable table;
	
	/** 用来保存JTable中的数据*/
	private MyTableModel tableModel;
	
	/** 在JTable中显示的数据行 */
	private String[][] data;
	
	/**存放JTable中的表头*/
	private String[] columnNames;
	
	public TablePane(String[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
		
		init();
	}
	
	public void init(){
		
		this.setLayout(new BorderLayout());
        
		tableModel = new MyTableModel(data, columnNames);
		
		table = new JTable(tableModel);
		
		//界面启动后，table的第一行被选中
		 table.requestFocus();
		//table.setRowSelectionInterval(0, 0);
		
		 //table不能根据窗体的尺寸自动改变尺寸
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  
	    //table.getColumnModel().getColumn(1).setPreferredWidth(150);
	    
	    //把JTable添加到JScrollPane中
	    JScrollPane spane = new JScrollPane(table);
	    add(spane, BorderLayout.CENTER);
	    
	}

	public JTable getTable() {
		return table;
	}
}
