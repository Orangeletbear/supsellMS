package com.cn.util.font;
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



public class FontDialog {
	
	private JDialog fontdialog;

	private JButton okButton, cancelButton;

	private int width = 450;

	private int height = 250;
	private Font oldFont=null;
	private String name = "Serif";

	private int type = 0;

	private int size = 12;

	private static final int OK_OPTION = 0x00001;

	private static final int CANCEL_OPTION = 0x00010;

	private Font customFont = new Font("宋体", Font.ITALIC, 12);

	private boolean okpressed = false;

	private boolean cancelpressed = false;

	private JLabel lbl1 = new JLabel("字体：");

	private JLabel lbl2 = new JLabel("字形：");

	private JLabel lbl3 = new JLabel("字号：");

	private JTextArea area;

	String[] zx = { "平体", "加粗", "斜体", "基线" };

	JLabel lbl = new JLabel("字体样式Style");

	private JComboBox cb1, cb3, cb2 = new JComboBox(zx);

	private Container c;

	private String[] zt;

	public FontDialog(JDialog owner, String title, boolean modal) {
		
		GridBagLayout layout = new GridBagLayout();
		init();
		fontdialog = new JDialog(owner, title, modal);
		oldFont=owner.getFont();
		fontdialog.setLocation(400, 300);
		fontdialog.setLayout(new GridLayout(5,1,20,20));
		fontdialog.setSize(new Dimension(400,350));
		fontdialog.setLayout(layout);
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane.add(lbl1);
		pane.add(cb1);
		layout.setConstraints(pane, new GBC(0, 0,2,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		fontdialog.add(pane);
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		pane.add(lbl2);
		pane.add(cb2);
		layout.setConstraints(pane, new GBC(0, 1,1,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		fontdialog.add(pane);
		
		pane = new JPanel();
		pane.add(lbl3);
		pane.add(cb3);
		layout.setConstraints(pane, new GBC(0, 2,1,1).
									setInsets(10,10,10,10).
									setFill(GBC.HORIZONTAL));
		fontdialog.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		pane.add(area);
		layout.setConstraints(pane, new GBC(1, 1,1,2).
									setInsets(10,10,10,10).
									setFill(GBC.BOTH).
									setWeight(1,1));
		fontdialog.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,2));
		pane.add(okButton);
		pane.add(cancelButton);
		layout.setConstraints(pane, new GBC(1, 3,1,1).
									setInsets(10,10,10,10));
		fontdialog.add(pane);
		
		
		//空区填补
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT,2,2));
		pane.add(new JLabel());
		pane.add(new JLabel());
		layout.setConstraints(pane, new GBC(0, 3,1,1).
									setInsets(10,10,10,10));
		fontdialog.add(pane);
		
		
		fontdialog.setResizable(false);
		//fontdialog.setAlwaysOnTop(true);
		fontdialog.setBackground(new Color(145, 167, 220));
		cancelButton.addActionListener(new fontListener());
		okButton.addActionListener(new fontListener());
		fontdialog.addWindowListener(new fontListener());
		
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

	public Font showFontDialog() {
		fontdialog.setVisible(true);
		if (!okpressed) {
			return getCustomFont();
		} else {
			return customFont;
		}
	}

	private void init() {
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
		//okButton.setFocusable(true);
		area.setEditable(false);
		area.setText("无敌七人开发组开发");
		area.setBorder(new TitledBorder("字体样式"));
		area.setBackground(new Color(255, 122, 0));
		//okButton.setBackground(new Color(122, 122, 122));
		//cancelButton.setBackground(new Color(122, 122, 122));

	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private int getWidth() {
		return (this.width);
	}

	private int getHeight() {
		return (this.height);
	}

	private void setCustomFont(Font customFont) {
		this.customFont = customFont;
		area.setFont(customFont);
		area.revalidate();

	}

	public String toString() {
		return FontDialog.class.toString();
	}

	public Font getCustomFont() {
		
		return (this.customFont);
	}

	private class fontListener extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent e) {
			fontdialog.dispose();

		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cancelButton) {
				
				fontdialog.dispose();
				cancelpressed = true;
			} else if (e.getSource() == okButton) {
				okpressed = true;
				setCustomFont(new Font(name, type, size));
				fontdialog.dispose();
			}
		}
	}
}