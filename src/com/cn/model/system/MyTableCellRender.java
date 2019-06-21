package com.cn.model.system;


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
	  
    if(table.getValueAt(row, 9).equals("0")) {
        setForeground(Color.red);
    } else {
        setForeground(Color.black);
    }
    
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
  }
}
