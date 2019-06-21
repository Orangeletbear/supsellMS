package com.cn.view.xiaoshouJFrame.table;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePane extends JPanel {

	private JTable table;
	
	/** ��������JTable�е�����*/
	private MyTableModel tableModel;
	
	/** ��JTable����ʾ�������� */
	private String[][] data;
	
	/**���JTable�еı�ͷ*/
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
		
		//����������table�ĵ�һ�б�ѡ��
		 table.requestFocus();
		//table.setRowSelectionInterval(0, 0);
		
		 //table���ܸ��ݴ���ĳߴ��Զ��ı�ߴ�
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  
	    //table.getColumnModel().getColumn(1).setPreferredWidth(150);
	    
	    //��JTable��ӵ�JScrollPane��
	    JScrollPane spane = new JScrollPane(table);
	    add(spane, BorderLayout.CENTER);
	    
	}

	public JTable getTable() {
		return table;
	}
}
