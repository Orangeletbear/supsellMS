package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 会员管理下的会员续费
 * @author Administrator
 *
 */
public class HuiYuanXuFei extends JDialog {
	 //会员号
	private JLabel hyID = new JLabel("05");
    //会员名称
	private JLabel hyName = new JLabel();
	//账号余额
	private JLabel hyYuE = new JLabel(); 
	
	JTextField chongZhi = new JTextField(8);
	JTextField daoZhang = new JTextField(8);
	HuiYanGuangLiFrame frame;
	public HuiYuanXuFei( HuiYanGuangLiFrame frame,String title){
		super(frame,title);
		this.frame = frame;
		init();
		initData();
		this.setVisible(true);
	}
	
	/*
	 * 数据初始化
	 */
	private void initData(){
		int row = ((HuiYanGuangLiFrame)(this.getOwner())).
        getHyXinXiT().getSelectedRow();

		String hyIDN = ((HuiYanGuangLiFrame)(this.getOwner())).
		    getHyXinXiTM().getValueAt(row, 0).toString();
		String hyName1 = ((HuiYanGuangLiFrame)(this.getOwner())).
	    	getHyXinXiTM().getValueAt(row, 1).toString();
		Object hyYuE1 = ((HuiYanGuangLiFrame)(this.getOwner())).
	    	getHyXinXiTM().getValueAt(row, 4);
		hyID.setText(hyIDN);
		hyName.setText(hyName1);
		if(hyYuE1 == null){
			hyYuE.setText("0.0");
		}else{
			hyYuE.setText(hyYuE1.toString());
		}
		
	}
	
	
	private void init(){
		this.setSize(new Dimension(350,350));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	
   private JPanel createPane(){
	    JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab = new JLabel("会员编号:");
		tmpPane.add(lab);
		hyID.setForeground(Color.red);
		tmpPane.add(hyID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("会员名称:");
		tmpPane.add(lab);
		hyName.setForeground(Color.red);
		tmpPane.add(hyName);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("账号余额:");
		tmpPane.add(lab);
		hyYuE.setForeground(Color.red);
		tmpPane.add(hyYuE);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    lab = new JLabel("充值金额:");
		tmpPane.add(lab);
		tmpPane.add(chongZhi);
		lab = new JLabel("到账金额:");
		tmpPane.add(lab);
		tmpPane.add(daoZhang);
		centerPane.add(tmpPane);
		
		centerPane.setBorder(new TitledBorder("会员信息"));
		
		mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYuanXuFei.this.dispose();
			}
			
		});
		
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String hyID1 = hyID.getText();
				String hyMoney =daoZhang.getText();
				if(chongZhi.getText().equals("")||daoZhang.getText().equals("")){
					JOptionPane.showMessageDialog(null,"请输入正确数值!");
					return;
				}
				
				//float spjMoney = new Float(hyMoney).floatValue();
				String user = ((MainFrame)frame.getOwner()).getUser();
				boolean isSuccess = HuiYuanXinGLJDBC.huiYuanAddMoney(chongZhi.getText(),
						daoZhang.getText(),hyID1,user);
				if(isSuccess){
					JOptionPane.showMessageDialog(null,"成功充值!");
					
					Log.traceLog("  操作员  ",user,"  给会员: "+
							hyName.getText()+" 充了 "+hyMoney+" 元金额");
					frame.initData();
					HuiYuanXuFei.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null,"请输入正确数值!");
				}
			}
			
		});
		
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
   } 
}
