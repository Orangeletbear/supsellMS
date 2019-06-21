package com.cn.util.font;


import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FontText extends JDialog {
	
	private TextArea title = new TextArea(8,20);

	private JButton fontd = new JButton("设置");

	private static FontText test;

	public FontText() {
		this.setSize(240,220);
		this.setLayout(new FlowLayout());
		this.add(fontd);
		this.add(title);
		this.setVisible(true);
		this.setLocation(200,300);
		this.setResizable(false);
		fontd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == fontd) {
					FontDialog dialog = new FontDialog(test, "字体对话框", true);
					dialog.showFontDialog();
					title.setFont(dialog.getCustomFont());
				}
			}
		});
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public static void main(String args[]) {
		test = new FontText();
	}
}
