package com.cn.view.posmainJFrame;
/*
 * 字体对话框
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.cn.util.GBC;



public class FontDialog extends JDialog{
	
	private JButton okButton, cancelButton;

	private Font oldFont=null;
	private String name = "Serif";

	private int type = 0;

	private int size = 12;


	private Font customFont = new Font("宋体", Font.ITALIC, 12);

	private JLabel lbl1 = new JLabel("字体：");

	private JLabel lbl2 = new JLabel("字形：");

	private JLabel lbl3 = new JLabel("字号：");

	private JTextArea area;

	String[] zx = { "平体", "加粗", "斜体", "基线" };

	JLabel lbl = new JLabel("字体样式Style");

	private JComboBox cb1, cb3, cb2 = new JComboBox(zx);

	private String[] zt;

	public FontDialog(POSFrame owner, String title, boolean modal) {
		
		super(owner,title,modal);
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);
		init();
		addActionListener();
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setBackground(new Color(145, 167, 220));
		this.setVisible(true);

	}	
	
	
	private void init(){
		GridBagLayout layout = new GridBagLayout();
        okButton = new JButton("确定");
		
		cancelButton = new JButton("取消");
		
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		zt = ge.getAvailableFontFamilyNames();
		
		cb1 = new JComboBox(zt);
		cb1.setMaximumRowCount(6);
		area = new JTextArea(6, 30);
		cb3 = new JComboBox();
		
		for (int i = 1; i <= 72; i++) {
			if (i % 2 == 0) {
				cb3.addItem(i);
			}
		}
		area.setEditable(false);
		area.setText("无敌七人开发组开发");
		area.setBorder(new TitledBorder("字体样式"));
		area.setBackground(new Color(255, 122, 0));
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(5,1,20,20));
		this.setLayout(layout);
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane.add(lbl1);
		pane.add(cb1);
		layout.setConstraints(pane, new GBC(0, 0,2,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		this.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane.add(lbl2);
		pane.add(cb2);
		layout.setConstraints(pane, new GBC(0, 1,1,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		this.add(pane);
		
		
		pane = new JPanel();
		pane.add(lbl3);
		pane.add(cb3);
		layout.setConstraints(pane, new GBC(0, 2,1,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		this.add(pane);
		
		
		pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		pane.add(area);
		layout.setConstraints(pane, new GBC(1, 1,1,2).
									setInsets(10,10,10,10).
									setFill(GBC.BOTH).
									setWeight(1,1));
		this.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT,5,2));
		pane.add(okButton);
		pane.add(cancelButton);
		layout.setConstraints(pane, new GBC(1, 3,1,1).
									setInsets(10,10,10,10));
		this.add(pane);
		
		//空区填补
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT,2,2));
		pane.add(new JLabel());
		pane.add(new JLabel());
		layout.setConstraints(pane, new GBC(0, 3,1,1).
									setInsets(10,10,10,10));
		this.add(pane);
		
		
	}
	
	
	private void addActionListener(){
		
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				FontDialog.this.dispose();
			}
		});
		
		okButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				((POSFrame)(FontDialog.this.getOwner())).getTable().setFont(customFont);
				((POSFrame)(FontDialog.this.getOwner())).validate();
				FontDialog.this.dispose();
			}
		});
		
		
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				name = (String) event.getItem();
				setCustomFont(new Font(name, type, size));
			}
		});
		
		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				String s = (String) event.getItem();
				if (s.equals("平体")) {
					type = Font.PLAIN;
					setCustomFont(new Font(name, type, size));
				} else if (s.equals("加粗")) {
					type = Font.BOLD;
					setCustomFont(new Font(name, type, size));
				} else if (s.equals("斜体")) {
					type = Font.ITALIC;
					setCustomFont(new Font(name, type, size));
				} else {
					type = Font.CENTER_BASELINE;
					setCustomFont(new Font(name, type, size));
				}
			}
		});
		
		cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				String state = event.getItem().toString();
				size = Integer.parseInt(state);
				setCustomFont(new Font(name, type, size));
			}
		});
        
		
		
	}
	
	private void setCustomFont(Font customFont) {
		this.customFont = customFont;
		area.setFont(customFont);
		area.revalidate();

	}

}