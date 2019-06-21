package com.cn.view.systemJFrame.XiTongWeiHu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cn.dao.MFrameJDBC;
import com.cn.util.GBC;
import com.cn.util.Log;
import com.cn.util.XiTongDataBeiFen;
import com.cn.view.systemJFrame.SystemWeiHuFrame;

public class BeiFenDialog extends JDialog implements ActionListener {
	SystemWeiHuFrame frame;
	JButton beiFenQueDing,huiFuQueDing,beiFenTuiChu,huiFuTuiChu;
	JButton beiFenLuJing,huiFuLuJing;
	JProgressBar beiFenJP,huiFuJP;
	JTextField beiFenText,huiFuText;
	JRadioButton jr;
	JSpinner time;                     //各组件的定义
	public BeiFenDialog(SystemWeiHuFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame=frame;
		init();
	}
	/*
	 * 数据初始化
	 */
	private void initData(){
		String isAuto = MFrameJDBC.getIsAutoBakeData();
		String time1 = MFrameJDBC.getIsAutoBakeDataTime();
		if(isAuto.equals("1")){
			jr.setSelected(true);
		
			time.setValue(new Integer(time1));
		}else{
			jr.setSelected(false);
			time.setEnabled(false);
		}
	}
	private void init(){
		this.setSize(380, 250);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);         //主界面的设置
		JTabbedPane jtp=new JTabbedPane();
		//备份选项卡
		JPanel beiFen=new JPanel();
		beiFen.setLayout(new BorderLayout());
		JPanel mainP=new JPanel();
		mainP.setLayout(new GridBagLayout());
		mainP.add(new JLabel("备份路径: "),new GBC(0,0).setInsets(8, 1, 8, 1));
		beiFenText=new JTextField();
		beiFenText.setPreferredSize(new Dimension(150,20));
		mainP.add(beiFenText,new GBC(1,0,3,1).setInsets(8, 1, 8, 1));
		beiFenLuJing =new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		beiFenLuJing.setMargin(new Insets(0,0,0,0));
		mainP.add(beiFenLuJing,new GBC(4,0).setInsets(8, 1, 8, 1));
		mainP.add(new JLabel("备份进度："),new GBC(0,1).setInsets(1, 1, 1, 1));
		beiFenJP=new JProgressBar(0,150);
		beiFenJP.setValue(0);
		beiFenJP.setStringPainted(true);
		mainP.add(beiFenJP,new GBC(1,1,3,1).setInsets(8, 1, 8, 1));
		jr=new JRadioButton("自动备份");
		mainP.add(jr,new GBC(0,2).setInsets(8, 1, 8, 10));
		mainP.add(new JLabel("每隔 "),new GBC(1,2).setInsets(8, 1, 8, 1));
		time=new JSpinner(new SpinnerNumberModel(8,1,99,1));
		mainP.add(time,new GBC(2,2).setInsets(8, 1, 8, 1));
		mainP.add(new JLabel("小时备份一次 "),new GBC(3,2).setInsets(8, 1, 8, 1));
		jr.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(jr.isSelected()){
					time.setEnabled(true);
					MFrameJDBC.updateAutoBakeData("1");
				}else{
					time.setEnabled(false);
					MFrameJDBC.updateAutoBakeData("0");
				}
			}
			
		});
		
		time.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent arg0) {
				String timeString =  time.getValue().toString();
				MFrameJDBC.updateAutoBakeDataTime(timeString);
			}
			
		});
		JPanel southP=new JPanel();
		southP.setLayout(new FlowLayout(FlowLayout.CENTER));
		beiFenQueDing=new JButton("确定");
		beiFenTuiChu=new JButton("退出");
		southP.add(beiFenQueDing);
		southP.add(new JLabel("      "));
		southP.add(beiFenTuiChu);
		beiFen.add(southP,BorderLayout.SOUTH);
		beiFen.add(mainP);             //备份选项卡完成
		//恢复选项卡
		JPanel huiFu=new JPanel();
		huiFu.setLayout(new BorderLayout());
		JPanel mainP1=new JPanel();
		mainP1.setLayout(new GridBagLayout());
		mainP1.add(new JLabel("恢复文件: "),new GBC(0,0).setInsets(8, 1, 8, 1));
		huiFuText=new JTextField();
		huiFuText.setPreferredSize(new Dimension(150,20));
		mainP1.add(huiFuText,new GBC(1,0,3,1).setInsets(8, 1, 8, 1));
		huiFuLuJing =new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
		huiFuLuJing.setMargin(new Insets(0,0,0,0));
		mainP1.add(huiFuLuJing,new GBC(4,0).setInsets(8, 1, 8, 1));
		mainP1.add(new JLabel("恢复进度："),new GBC(0,1).setInsets(1, 1, 1, 1));
		huiFuJP=new JProgressBar(0,150);
		huiFuJP.setValue(0);
		huiFuJP.setStringPainted(true);
		mainP1.add(huiFuJP,new GBC(1,1,3,1).setInsets(8, 1, 8, 1));
		JPanel southP1=new JPanel();
		southP1.setLayout(new FlowLayout(FlowLayout.CENTER));
		huiFuQueDing=new JButton("确定");
		huiFuTuiChu=new JButton("退出");
		southP1.add(huiFuQueDing);
		southP1.add(new JLabel("      "));
		southP1.add(huiFuTuiChu);
		huiFu.add(southP1,BorderLayout.SOUTH);
		huiFu.add(mainP1);
		jtp.add("备份数据", beiFen);
		jtp.add("恢复数据",huiFu);
		beiFenLuJing.addActionListener(this);
		beiFenTuiChu.addActionListener(this);
		beiFenQueDing.addActionListener(this);
		huiFuLuJing.addActionListener(this);
		huiFuQueDing.addActionListener(this);
		huiFuTuiChu.addActionListener(this);
		jr.addActionListener(this);
		this.getContentPane().add(jtp);
		initData();
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
             if(e.getSource()==beiFenLuJing){
            	 JFileChooser chooser = new JFileChooser();
            	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            	    int returnVal = chooser.showDialog(this,"确定");
            	    if(returnVal ==0) {
            	    	beiFenText.setText(chooser.getSelectedFile().getAbsolutePath());
            	    }
             }	
             if(e.getSource()==beiFenTuiChu){
            	 this.dispose();
             }
             if(e.getSource()==beiFenQueDing){
            	 if(beiFenText.getText().equals("")){
            		 JOptionPane joptionP= new JOptionPane();
		          		JOptionPane.showMessageDialog(this, "备份路径不能为空！！");
		          		joptionP.setVisible(true);    
            	 }
            	 else{
            	 Date date = new Date();
            	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	   String time = formatter.format(date);
            	try {
					XiTongDataBeiFen.dataBackup("peng", "123456", "mydbp", beiFenText.getText(), "peng"+time);
			           new TaskThread(this,beiFenJP,"数据备份成功！！").start();
			           Log.traceLog("操作员 ",frame.getFrame().getUser()," 备份了数据库数据");
			           
			           } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
             }
             if(e.getSource()==huiFuTuiChu){
            	 this.dispose();
             }
             if(e.getSource()==huiFuQueDing){
            	 if(huiFuText.getText().equals("")){
            		 JOptionPane joptionP= new JOptionPane();
		          		JOptionPane.showMessageDialog(this, "恢复路径不能为空！！");
		          		joptionP.setVisible(true); 
            	 }
            	 else{
            	 try {
					XiTongDataBeiFen.dataResume("peng", "123456", "ORACLE", "mydbp", huiFuText.getText());
					new TaskThread(this,huiFuJP,"数据恢复成功！！").start();
					 Log.traceLog("操作员 "+frame.getFrame().getUser()+"恢复了数据库数据");
					 
					 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
             }
             if(e.getSource()==huiFuLuJing){
            	 JFileChooser chooser = new JFileChooser();
            	 chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            	    int returnVal = chooser.showDialog(this,"确定");
            	    if(returnVal ==JFileChooser.APPROVE_OPTION) {
            	    	huiFuText.setText(chooser.getSelectedFile().getAbsolutePath());
            	    }
             }
       }
}
/**
*备份进度条的多线程
*/
class TaskThread extends Thread {
	BeiFenDialog frame;
	JProgressBar jp;
	String str;
	int max=100;
 public	TaskThread(BeiFenDialog frame,JProgressBar jp,String str){
	 this.jp=jp;
	 this.str=str;
	 this.frame=frame;
 }
	  public void run() {
	   int min = 0;
	   jp.setValue(min);
	   jp.setMinimum(min);
	   jp.setMaximum(max);

	   Runnable runner = new Runnable() {

	    public void run() {
	    	int value = jp.getValue();
	    	value++;
	    try {
	    	Thread.sleep(5);
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    jp.setValue(value);
	    if(jp.getValue()==100){
	    	 JOptionPane joptionP= new JOptionPane();
	    	 JOptionPane.showMessageDialog(null, str);
       		 joptionP.setVisible(true);
       		frame.dispose();
	    }
	    }
	    
	   };

	   for (int i = min; i < max; i++) {
	    try {
	     SwingUtilities.invokeAndWait(runner);// 组件和线程同步进行
	    } catch (InvocationTargetException e) {
	     break;
	    } catch (InterruptedException e) {
	    }

	   }
	  }
	}

