package com.cn.view.richangJFrame.Salesman_Manage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Salesman_Manage.Action_Log_Change;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;

public class Salesman_Log_Change extends JDialog{
	private JButton save;
	private JButton cancel;
	private JTextArea textArea = new JTextArea();
	private JComboBox date;
	private Salesman_Manage sm;
	private AllTableModel TableModel;
	private JTable table;
	public Salesman_Log_Change(Salesman_Manage sm, String title,boolean b) {
		super(sm,title,b);
		this.sm = sm;
		init();
	}



	private void init() {
		
		TableModel  = sm.getTabelModel_tab_2();
		table = sm.getTable_tab_2();
		int row = table.getSelectedRow();
		if(row != -1){
			
			Vector data = (Vector)TableModel.getDataVector().get(row);
			textArea.setText(data.get(1).toString());
			JPanel main = new JPanel(new BorderLayout());

			save = new JButton("保存");
			save.addActionListener(new Action_Log_Change(Salesman_Log_Change.this));
			cancel = new JButton("取消");
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			
			
			JLabel label = new JLabel("日志日期：");
			date = new JDatePicker();
			
			
			JPanel North = new JPanel();
			FlowLayout flowLayout = (FlowLayout) North.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			
			JPanel South = new JPanel();
			
			JPanel Center = new JPanel(new BorderLayout());
			Center.setBorder(new TitledBorder(null, "日志内容", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			
			South.add(save);
			South.add(cancel);
			North.add(label);
			North.add(date);
			Center.add(textArea);
			main.add(North, BorderLayout.NORTH);
			main.add(Center);
			main.add(South, BorderLayout.SOUTH);
			getContentPane().add(main);
			this.setSize(289, 305);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
		
		
	}
	
	public JButton getSave() {
		return save;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JComboBox getDate() {
		return date;
	}
	public Salesman_Manage getSm() {
		return sm;
	}

}
