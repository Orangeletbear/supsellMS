package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.systemframe.huiyuanxinxi.HuiYuanJiBieOkAction;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;

/**
 * 增加会员级别
 * @author finey
 *
 */
public class AddHuiYuanJiBie extends JDialog {

	//级别编号
	private JTextField jbID = new JTextField(15);
	//级别名称
	private JTextField jbName = new JTextField(15);
	//级别折扣
	private JTextField jbZheKou = new JTextField(15);
	//积分上限
	private JTextField jiFenUp= new JTextField(15);
	//积分下限
	private JTextField jiFenDown = new JTextField(15);
	
	
	//修改还是加入一条记录
	private boolean addOrAlter  = false;
	public JTextField getJbID() {
		return jbID;
	}

	public JTextField getJbName() {
		return jbName;
	}

	public JTextField getJbZheKou() {
		return jbZheKou;
	}

	public JTextField getJiFenUp() {
		return jiFenUp;
	}

	public JTextField getJiFenDown() {
		return jiFenDown;
	}

	public boolean isAddOrAlter() {
		return addOrAlter;
	}

	/**
	 * 增加和修改对话框一体
	 * @param frame  名称 
	 * @param title 标题
	 * @param isGetDate  是否是修改对话框 true 为修改，否刚为增加
	 */
	public AddHuiYuanJiBie(HuiYuanJiBieSet frame,
			String title,boolean isGetDate){
		super(frame,title,true);
		this.addOrAlter = isGetDate;
		init();
		if(isGetDate){
			addDataToDialog();
		}
		this.setVisible(true);
	}
	 
	private void init(){
		this.setSize(new Dimension(250,240));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}

	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//中心数据输入块
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		JButton okBtn = new JButton("确定");
		okBtn.addActionListener(new HuiYuanJiBieOkAction(this));
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AddHuiYuanJiBie.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	/*
	 * 中
	 */
	public JPanel initCenterPane(){
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(6,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("级别编号 ：  "));
		tmpPane.add(jbID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("级别名称 ：  "));
		tmpPane.add(jbName);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("级别折扣 ：  "));
		tmpPane.add(jbZheKou);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("积分上限 ：  "));
		tmpPane.add(jiFenUp);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("积分下限 ：  "));
		tmpPane.add(jiFenDown);
		centerPane.add(tmpPane);
		
		JLabel lba = new JLabel("注：0.9为九折，1为不打折");
		lba.setForeground(Color.red);
		centerPane.add(lba);
		
		return centerPane;
	}
	/*
	 * 数据初始化
	 */
	private void addDataToDialog(){
		
		Vector data = new Vector();
		int row = ((HuiYuanJiBieSet)(this.getOwner())).
							getTabel().getSelectedRow();

		String jiBieID = ((HuiYuanJiBieSet)(this.getOwner())).
						getTbMo().getValueAt(row, 0).toString();
		
	    data = HuiYuanXinGLJDBC.getAJiBieXinXi( jiBieID);
	    
	    jbID.setText(data.get(0).toString());
	    jbID.setEnabled(false);
	    jbName.setText(data.get(1).toString());
		
	    jbZheKou.setText(data.get(2).toString());

	    jiFenUp.setText(data.get(3).toString());
		
	    jiFenDown.setText(data.get(4).toString());
		
		
		
	}
	
	
	public static void main(String[] args) {
		new AddHuiYuanJiBie(null,"",false);
	}

}
