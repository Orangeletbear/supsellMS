package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.systemframe.huiyuanxinxi.HuiAddOKBtnAction;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AddShangPingDialog;
/**
 * 增加会员 和修改会员一体化
 * @author finey
 *
 */
public class AddHuiYuan extends JDialog {
	//会员编号
	private JTextField hyID = new JTextField(15);
	//会员级别
	private JComboBox hyJiBie = new JComboBox(HuiYuanXinGLJDBC.getHuiYuanJiBie());
	//会员名称
	private JTextField hyName = new JTextField(15);
	//会员密码
	private JPasswordField hySecret = new JPasswordField(15);
	//会员生日
	private JDatePicker hyBirthday = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//确认密码
	private JPasswordField hyCirSecret = new JPasswordField(15);
	//会员积分
	private JTextField hyJiFen = new JTextField(15);
	//联系电话
	private JTextField hyTell = new JTextField(15);
	//加入日期
	private JDatePicker hyJiaLuDate = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//截止日期
	private JDatePicker hyJieDate = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//该会员卡有截止日期
	private JCheckBox hyYouJiZhiDate = new JCheckBox("该会员卡有截止日期");
	//启用该会员卡
	private JComboBox hyStart = new JComboBox(new String[]{"可用","停用"});
	//是否积分自动升级
	private JComboBox hyShenJi = new JComboBox(new String[]{"是","否"});
	
	//备注
	private JTextArea hyBeiZhu = new JTextArea(3,60);
	
	
	//一个用于区分是修改还是增回的标志(true 为修改   false 增加)
	private boolean addOrAtler = false;
	
	public JTextField getHyID() {
		return hyID;
	}

	public JComboBox getHyJiBie() {
		return hyJiBie;
	}

	public JTextField getHyName() {
		return hyName;
	}

	public JPasswordField getHySecret() {
		return hySecret;
	}

	public JDatePicker getHyBirthday() {
		return hyBirthday;
	}

	public JPasswordField getHyCirSecret() {
		return hyCirSecret;
	}

	public JTextField getHyJiFen() {
		return hyJiFen;
	}

	public JTextField getHyTell() {
		return hyTell;
	}

	public JDatePicker getHyJiaLuDate() {
		return hyJiaLuDate;
	}

	public JDatePicker getHyJieDate() {
		return hyJieDate;
	}

	public JCheckBox getHyYouJiZhiDate() {
		return hyYouJiZhiDate;
	}

	public JComboBox getHyStart() {
		return hyStart;
	}

	public JComboBox getHyShenJi() {
		return hyShenJi;
	}

	public JTextArea getHyBeiZhu() {
		return hyBeiZhu;
	}

	public boolean isAddOrAtler() {
		return addOrAtler;
	}

	/**
	 * 增加和修改对话框一体
	 * @param frame  名称 
	 * @param title 标题
	 * @param isGetDate  是否是修改对话框 true 为修改，否刚为增加
	 */
	public AddHuiYuan(HuiYanGuangLiFrame frame,String title,boolean isGetDate){
		super(frame,title,true);
		init();
		this.addOrAtler = isGetDate;
		if(isGetDate){
			addDataToDialog();
			
		}
		this.setVisible(true);
	}
	 
	private void init(){
		this.setSize(new Dimension(450,450));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//中心数据输入块
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		okBtn.addActionListener(new HuiAddOKBtnAction(this));
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AddHuiYuan.this.dispose();
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
		centerPane.setLayout(new BorderLayout());
		JPanel cenNorthPane = initCeneterNorthPane();
		JPanel cenSouthPane = initCeneterSouthPane();

		centerPane.add(cenNorthPane);
		centerPane.add(cenSouthPane,BorderLayout.SOUTH);
		
		
		centerPane.setBorder(new TitledBorder("会员信息"));
		
		return centerPane;
	}
	/*
	 * 中北
	 */
	public JPanel initCeneterNorthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(7,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员编号 ："));
		tmpPane.add(hyID);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员级别 ："));
		tmpPane.add(hyJiBie);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员名称 ："));
		tmpPane.add(hyName);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员密码 ："));
		tmpPane.add(hySecret);
		pane.add(tmpPane);
		
	
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员生日 ："));
		tmpPane.add(hyBirthday);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("确认密码 ："));
		tmpPane.add(hyCirSecret);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("会员积分 ："));
		tmpPane.add(hyJiFen);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("联系电话 ："));
		tmpPane.add(hyTell);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("加入日期 ："));
		hyJiaLuDate.setEnabled(false);
		tmpPane.add(hyJiaLuDate);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("截止日期 ："));
		tmpPane.add(hyJieDate);
		hyJieDate.setEnabled(false);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(hyYouJiZhiDate);
		hyYouJiZhiDate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(hyYouJiZhiDate.isSelected()){
					hyJiaLuDate.setEnabled(true);
					hyJieDate.setEnabled(true);
				}else{
					hyJiaLuDate.setEnabled(false);
					hyJieDate.setEnabled(false);
				}
			}
		});
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("卡号状态 ："));
		tmpPane.add(hyStart);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("积分升级："));
		tmpPane.add(hyShenJi);
		pane.add(tmpPane);
		
		return pane;
		
	}
	/*
	 * 中南区
	 */
	private JPanel initCeneterSouthPane(){
		JPanel pane = new JPanel();
		pane.add(new JLabel("备 注 :"));
		pane.add(hyBeiZhu);
		return pane;
		
	}
	/*
	 * 修改时的数据初始化
	 */
	private void addDataToDialog(){
		
		int row = ((HuiYanGuangLiFrame)(this.getOwner())).
		         getHyXinXiT().getSelectedRow();

		String obj = ((HuiYanGuangLiFrame)(this.getOwner())).
				getHyXinXiTM().getValueAt(row, 0).toString();
		//取得表中数据
		Vector data = HuiYuanXinGLJDBC.getAHYMassege(obj);
		//当前商品的数据放入界面上
		hyID.setText(data.get(0).toString());
		
		hyJiBie.setSelectedItem(data.get(14).toString());
		
		hyName.setText(data.get(1).toString());

		hySecret.setText(data.get(12).toString());

		try {
			hyBirthday.setSelectedDate(DateConventer.strToDate(
					data.get(6).toString(), "yyyy-MM-dd"));
			
			hyJiaLuDate.setSelectedDate(DateConventer.strToDate(
					data.get(8).toString(), "yyyy-MM-dd"));
			
			hyJieDate.setSelectedDate(DateConventer.strToDate(
					data.get(9).toString(), "yyyy-MM-dd"));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		hyCirSecret.setText(data.get(12).toString());
		hyJiFen.setText(data.get(3).toString());

		hyTell.setText(data.get(7).toString());
			
		hyYouJiZhiDate.setSelected(false);
		
		hyStart.setSelectedItem(data.get(4));

		hyShenJi.setSelectedItem(data.get(10));
		if(data.get(11) ==null){
			hyBeiZhu.setText("");
		}else{
			hyBeiZhu.setText(data.get(11).toString());
		}
		

	}
	
}
