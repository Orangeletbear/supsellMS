package com.cn.view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import com.cn.control.posmainframe.LoginPOSCompareAction;
import com.cn.dao.loginandmainframe.JDBCPOSGetUserName;
import com.cn.view.mainJFrame.MainFrame;
/**
 * 登陆窗口
 * @author finey
 *
 */
public class LoginPosFrame extends JDialog {
	
	JButton btnLoad;
	JButton btnExit;
	/*
	 * 用户名
	 */
	JComboBox userdName ;
	/*
	 * 密码哉
	 */
	JPasswordField password = new JPasswordField(5); 
	
	

	public JComboBox getUserdName() {
		return userdName;
	}

	public JPasswordField getPassword() {
		return password;
	}

	
	private JPanel eastjpanel = new JPanel();
	private JPanel cenjpanel = new JPanel(){
		public void paintComponent(Graphics g){ 
	           g.drawImage(new ImageIcon("res/BackImage/denglubeijing.jpg").getImage(), 0, 0, null); 
	           super.paintComponent(g); 
	       } 
	};
	{
		cenjpanel.setOpaque(false);
	}
	private JPanel jpanel = new JPanel();
	/*
	 * 打开软件的直接对话框的软件
	 * 对话框设置为可视
	 * 
	 */
	public LoginPosFrame ( String title){
		super((JFrame)null,title,true);
		
		 //  设置窗体图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		this.setIconImage(tool.getImage("res/AcionIcon/denglutubiao.jpg"));
		try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		init();
	}
	
	private void init(){
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.add(add());
		//this.btnLoad.requestFocus();
		//this.btnLoad.setFocusCycleRoot(true);
		this.setVisible(true);
	}
	
	private JPanel add(){
		jpanel.setLayout(new BorderLayout(0,0));
		jpanel.add(addWest(),BorderLayout.WEST);
		jpanel.add(addCen(),BorderLayout.CENTER);
		jpanel.setOpaque(true);
		return jpanel;
	}
	/*
	 * 登陆界面的左边是图片
	 * 
	 */
	private JPanel addWest(){
		
		JLabel label = new JLabel();
		label.setSize(100, 300);
		label.setIcon(new ImageIcon("res/AcionIcon/loakback.jpg"));
		eastjpanel.add(label);
		return eastjpanel;
	}
	
	/*
	 * 登陆界面主面板
	 * 
	 */
	private JPanel addCen(){
		cenjpanel.setOpaque(true);
		cenjpanel.setLayout(new GridLayout(5,1));
		//cenjpanel.setBorder(new LineBorder(Color.white));
		{
		JPanel jpaLabe = new JPanel();
		jpaLabe.setLayout(new BorderLayout());
		JLabel labelup = new JLabel();
		labelup.setSize(100, 250);
		labelup.setIcon(new ImageIcon("res/AcionIcon/denglulabel.gif"));
		jpaLabe.add(labelup);
		cenjpanel.add(jpaLabe);
		}
		{
		JPanel jpaName = new JPanel();
		JLabel labelName = new JLabel();
		labelName.setSize(20, 300);
		//从数据库中读取用户
		userdName = new JComboBox(JDBCPOSGetUserName.getUserName());
		userdName.setSelectedIndex(0);
		userdName.addItem("管理员可注册用户");
		jpaName.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelName.setText("    登 陆 账 户 : ");
		labelName.setBounds(2, 2, 2, 2);
		jpaName.add(labelName);
		jpaName.add(userdName);
		cenjpanel.add(jpaName);
		}
		{
		JPanel jpaMima = new JPanel();
		JLabel labelMima = new JLabel();
		jpaMima.setLayout(new FlowLayout(FlowLayout.LEFT));
		password = new JPasswordField(20); 
		labelMima.setText("    登 陆 密 码 : ");
		labelMima.setSize(20, 300);
		jpaMima.add(labelMima);
		jpaMima.add(password);
		cenjpanel.add(jpaMima);
		}
		{
		JPanel jpaLoad = new JPanel();
		JPanel jpaButton = new JPanel();
		jpaLoad.setLayout(new BorderLayout());
		JLabel labelKong = new JLabel();
		labelKong.setSize(300, 100);
		btnLoad = new JButton("登陆");
		btnExit = new JButton("取消");
		btnLoad.addActionListener(new LoginPOSCompareAction(this));
		btnExit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				LoginPosFrame.this.dispose();
				//System.exit(4);
			}
			
		});
		jpaButton.setLayout(new FlowLayout(FlowLayout.CENTER,50,5));
		jpaButton.add(btnLoad);
		jpaButton.add(btnExit);
		
		jpaLoad.add(labelKong,BorderLayout.NORTH);
		jpaLoad.add(jpaButton,BorderLayout.CENTER);
		
		JLabel lab = new JLabel("     只可以POS用户登陆   ");
		lab.setForeground(Color.red);
		cenjpanel.add(lab);
		
		cenjpanel.add(jpaLoad);
		
		}
		password.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				LoginConfirmation.posLoginConfirm(LoginPosFrame.this);
			}
			
		});
		
		return cenjpanel;
	}
	
	public static void main(String []args){
		
		new LoginPosFrame("超市管理系统POS消费端登陆窗口");
		
	}

}