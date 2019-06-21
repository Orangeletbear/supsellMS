package com.cn.view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.cn.control.mianframe.LoginCompareAction;
import com.cn.dao.MFrameJDBC;
import com.cn.view.mainJFrame.MainFrame;
/**
 * ��½����
 * @author finey
 *
 */
public class LoginDialog extends JDialog {
	
	private MainFrame frame;
	
	
	public MainFrame getFrame() {
		return frame;
	}

	JButton btnLoad;
	JButton btnExit;
	/*
	 * �û���
	 */
	JComboBox textfieldName = new JComboBox(MFrameJDBC.getUser());
	/*
	 * ������
	 */
	JPasswordField password = new JPasswordField(20); 
	
	public JComboBox getTextfieldName() {
		return textfieldName;
	}

	public JPasswordField getPassword() {
		return password;
	}

	private boolean howDo;
	
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
	 * �������ֱ�ӶԻ�������
	 * �Ի�������Ϊ����
	 * 
	 */
	public LoginDialog ( String title){
		super((JFrame)null,title,false);
		
		 //  ���ô���ͼ��
		Toolkit tool = Toolkit.getDefaultToolkit();
		this.setIconImage(tool.getImage("res/AcionIcon/denglutubiao.jpg"));
		
		try {
   			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceModerateLookAndFeel");
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		} catch (InstantiationException e) {
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			e.printStackTrace();
   		} catch (UnsupportedLookAndFeelException e) {
   			e.printStackTrace();
   		}
		init(true);
		btnLoad.requestFocus();
		this.setVisible(true);
	}

	/*
	 * �����ߵ�½������ĶԻ�������
	 * 
	 * �Ի����ʼ��Ϊ���ɼ�
	 */
	public LoginDialog (MainFrame owner,String title,boolean b){
		super(owner,title,b);
		this.frame = owner;
		init(false);
		textfieldName.setSelectedItem(owner.getUser());
		this.setVisible(true);
	}
	
	private void init(boolean b){
		this.howDo = b;
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.add(add());
		//this.btnLoad.requestFocus();
		//this.btnLoad.setFocusCycleRoot(true);
		
	}
	
	private JPanel add(){
		jpanel.setLayout(new BorderLayout(0,0));
		jpanel.add(addWest(),BorderLayout.WEST);
		jpanel.add(addCen(),BorderLayout.CENTER);
		jpanel.setOpaque(true);
		return jpanel;
	}
	/*
	 * ��½����������ͼƬ
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
	 * ��½���������
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
		textfieldName.addItem("��������Ա��ע��");
		textfieldName.setSelectedItem("admin");
		jpaName.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelName.setText("    �� ½ �� �� : ");
		labelName.setBounds(2, 2, 2, 2);
		jpaName.add(labelName);
		//textfieldName.setText("admin");
		
		//textfieldName.setEditable(false);
		jpaName.add(textfieldName);
		
		//JLabel selectBtn = new JLabel("..");
		//jpaName.add(selectBtn);
		cenjpanel.add(jpaName);
		
		}
		{
		JPanel jpaMima = new JPanel();
		JLabel labelMima = new JLabel();
		jpaMima.setLayout(new FlowLayout(FlowLayout.LEFT));
		password = new JPasswordField(20);
		labelMima.setText("    �� ½ �� �� : ");
		labelMima.setSize(20, 300);
		jpaMima.add(labelMima);
		jpaMima.add(password);
		
		password.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				LoginConfirmation.loginConfirm(LoginDialog.this);
			}
			
		});
		cenjpanel.add(jpaMima);
		}
		{
		JPanel jpaLoad = new JPanel();
		JPanel jpaButton = new JPanel();
		jpaLoad.setLayout(new BorderLayout());
		JLabel labelKong = new JLabel();
		labelKong.setSize(300, 100);
		btnLoad = new JButton("��½");
		btnExit = new JButton("ȡ��");
		//btnLoad.setMnemonic('g');
		/*btnLoad.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent arg0) {
				//System.out.println(arg0.getKeyChar());
				if(arg0.getKeyChar() == '\n'){
					System.out.println("fffffffff");
				}
			}
			
		});*/
		btnLoad.addActionListener(new LoginCompareAction(this));
		//ȡ��
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					LoginDialog.this.dispose();
			
			}
		});
		
		jpaButton.setLayout(new FlowLayout(FlowLayout.CENTER,50,5));
		jpaButton.add(btnLoad);
		jpaButton.add(btnExit);
		
		jpaLoad.add(labelKong,BorderLayout.NORTH);
		jpaLoad.add(jpaButton,BorderLayout.CENTER);
		
		JLabel lab = new JLabel("     ϵͳ����Ա admin �ĳ�ʹ����Ϊ   admin");
		lab.setForeground(Color.red);
		
		cenjpanel.add(lab);
		
		cenjpanel.add(jpaLoad);
		
		}
		return cenjpanel;
	}
	
	public static void main(String []args){
		
		new LoginDialog("���й���ϵͳ��½");
		
	}

	public boolean isHowDo() {
		return howDo;
	}
}
