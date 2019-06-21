package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/*
 * 会员管理的行宣染器
 */
public class HuiYuanTableCellRender extends DefaultTableCellRenderer{
	  
		  public Component getTableCellRendererComponent(JTable table,
		      Object value,
		      boolean isSelected,
		      boolean hasFocus,
		      int row,
		      int column) {
			String values = table.getValueAt(row, 7).toString();
		    if(values.equals("停用")) {
		        setForeground(Color.red);
		    } else {
		      setForeground(Color.black);
		    }
		    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		  }
		}
