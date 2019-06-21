package com.cn.view.systemJFrame.XiTongWeiHu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import com.cn.dao.system.miMaJDBC;
import com.cn.util.GBC;
import com.cn.util.JDBCTool;
import com.cn.view.systemJFrame.SystemWeiHuFrame;
/*
 * 修改操作员密码
 */
public class MiMaDialog extends JDialog implements ActionListener{
	SystemWeiHuFrame frame;
	JButton queDing,tuiChu;
	JLabel czy;
	JPasswordField chuShi,xinMa,yanZheng;
	
	
   public MiMaDialog(SystemWeiHuFrame frame,String title,boolean b){  //构造器
	   super(frame,title,b);
	   this.frame=frame;
	   init();
   }
   private void init(){
	   this.setSize(280, 210);
	   this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	   this.setLocationRelativeTo(null); //主界面的设置
	   JPanel jp=new JPanel();
	   jp.setLayout(new GridBagLayout());
	   jp.add(new JLabel("操 作 员："),new GBC(0,0).setInsets(4, 4, 4, 4));
	   czy=new JLabel(frame.getFrame().getUser());
	   czy.setPreferredSize(new Dimension(120,20));
	   czy.setForeground(Color.blue);
	   jp.add(czy,new GBC(1,0).setInsets(4, 4, 4, 4));
	   chuShi=new JPasswordField();
	   chuShi.setPreferredSize(new Dimension(120,20));
	   xinMa=new JPasswordField();
	   xinMa.setPreferredSize(new Dimension(120,20));
	   yanZheng=new JPasswordField();
	   yanZheng.setPreferredSize(new Dimension(120,20));
	   jp.add(new JLabel("初始密码："),new GBC(0,1).setInsets(4, 4, 4, 4));
	   jp.add(chuShi,new GBC(1,1).setInsets(4, 4, 4, 4));
	   jp.add(new JLabel("新 密码："),new GBC(0,2).setInsets(4, 4, 4, 4));
	   jp.add(xinMa,new GBC(1,2).setInsets(4, 4, 4, 4));
	   jp.add(new JLabel("验证密码："),new GBC(0,3).setInsets(4, 4, 4, 4));
	   jp.add(yanZheng,new GBC(1,3).setInsets(4, 4, 4, 4));
	   queDing=new JButton("确定");
	   tuiChu=new JButton("退出");
	   jp.add(queDing,new GBC(0,4).setInsets(4, 4, 4, 4));
	   jp.add(tuiChu,new GBC(1,4).setInsets(4, 4, 4, 4));
	   queDing.addActionListener(this);
	   tuiChu.addActionListener(this);
	   yanZheng.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			SecretOK.secretOK(MiMaDialog.this);
		}
		   
	   });
	   
	   
	   this.add(jp);
	   this.setVisible(true);
   }
   		public void actionPerformed(ActionEvent e) {
       if(e.getSource()==tuiChu){
    	   this.dispose();
       }	
       else{
    	   SecretOK.secretOK(this);
    		   
       }
}
		public JPasswordField getChuShi() {
			return chuShi;
		}
		public JLabel getCzy() {
			return czy;
		}
		public SystemWeiHuFrame getFrame() {
			return frame;
		}
		public JButton getQueDing() {
			return queDing;
		}
		public JButton getTuiChu() {
			return tuiChu;
		}
		public JPasswordField getXinMa() {
			return xinMa;
		}
		public JPasswordField getYanZheng() {
			return yanZheng;
		}
}
