package com.cn.model.kuchun;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRender extends DefaultTableCellRenderer {

  
  public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column) {
	  
	 int num = new Integer(table.getValueAt(row, 3).toString()).intValue();
    if(num <= 0) {
        setForeground(Color.red);
    } else {
      setForeground(Color.black);
    }
    
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
  }
}
