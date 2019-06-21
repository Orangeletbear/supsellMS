package com.cn.view.posmainJFrame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * POS端上的密码修改对话框
 * @author Administrator
 *
 */
public class ChangePasswordDialog extends JDialog {

    private JPasswordField first ;
    //标题二
    private JPasswordField newPassword ;
    //标题三
    private JPasswordField newPassword1 ;

	public ChangePasswordDialog(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		init();
	}
	
	private void init(){
		this.setSize(new Dimension(300,300));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocation(300, 200);
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(5,1,2,10));
		
		JPanel tmpPane = new JPanel();
		tmpPane.add(new JLabel("收银员:  "));  
		JLabel posUser = new JLabel("POS_Finey");
		//posUser.setText(((POSFrame)(this.getOwner())).getUser());
		posUser.setForeground(Color.blue);
		tmpPane.add(posUser);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
        tmpPane.add(new JLabel("初始密码 : "));  
        first = new JPasswordField(15);
        tmpPane.add(first);
        pane.add(tmpPane);
		
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("新  密  码:"));  
        newPassword = new JPasswordField(15);
        tmpPane.add(newPassword);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("验 证 密 码:"));
        newPassword1 = new JPasswordField(15);
        tmpPane.add(newPassword1);
        pane.add(tmpPane);
        

        tmpPane = new JPanel();
        tmpPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
        JButton okBtn = new JButton("确定(F5)");
        JButton exitBtn = new JButton("退出(F4)");
        tmpPane.add(okBtn);
        tmpPane.add(exitBtn);
        pane.add(tmpPane);
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ChangePasswordDialog.this.dispose();
			}
			
		});
		
		return pane;
	}
	
}
