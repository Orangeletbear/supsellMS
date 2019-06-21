package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.posmainframe.CheckOut_Sure;
import com.cn.control.posmainframe.CheckOut_SureKeyList;
import com.cn.control.posmainframe.CheckOut_documentListener;
/**
 *  结账对话框
 * 
 */
public class CheckOut extends JDialog {

	private POSFrame frame;
	//应付金额
	private JLabel shouldPay = new JLabel("0.0");
	//付款金额
	private JTextField givePay = new JTextField(20);
	//找零金额
	private JTextField returnPay = new JTextField(20);
	//销售备注
	private JLabel hyID = new JLabel("");
	//付款方式
	private JLabel zfWay = new JLabel("现金");
	
	//付款方式
	private JRadioButton cash = new JRadioButton("现金 （1）");
	private JRadioButton czCard = new JRadioButton("储值卡 （2）");
	private JRadioButton bankCard = new JRadioButton("银行卡 （3）");
	private JRadioButton daiJinQuan = new JRadioButton("代金券 （4）");
	private JRadioButton connectPay = new JRadioButton("联合结账 （5）");
	
	//打印小票
	private JCheckBox printXP = new JCheckBox("打印小票");
	
	
	public JLabel getZfWay() {
		return zfWay;
	}

	public CheckOut(POSFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		init();
		
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(550,450));
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
		mainPane.setLayout(new BorderLayout(10,10));
		//中心数据输入块
	    JPanel centerPane = initCenterPane();
	    
	    
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    JPanel southPane = new JPanel();
	    southPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
	    
	   
	    
        JButton mlBtn = new JButton("抹零(F6)");
        JButton okBtn = new JButton("确定(F5)");
        okBtn.addActionListener(new CheckOut_Sure(this));
        JButton cancelBtn = new JButton("退出(F4)");
        cancelBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				CheckOut.this.dispose();
			}
			
		});
        
        southPane.add(printXP);
	    southPane.add(mlBtn);
	    southPane.add(okBtn);
	    southPane.add(cancelBtn);
		mainPane.add(southPane,BorderLayout.SOUTH); 
	    
	    
	    
		return mainPane;
	}
	
	private JPanel initCenterPane(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(5,1,2,10));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              应付金额:"));
		shouldPay.setForeground(Color.red);
		shouldPay.setFont(new Font("黑体",Font.BOLD,25));
		/*//应付金额
		float money = 0;
		//System.out.println(frame == null);
		for(int i = 0;i < frame.getTable().getRowCount();i++){
			money = money + Float.parseFloat(frame.getMode().getValueAt(i, 8).toString());
		}
		
		shouldPay.setText(String.valueOf(money));*/
		shouldPay.setText(frame.getAll().getText());
		tmpPane.add(shouldPay);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              付款金额:"));
		givePay.setForeground(Color.red);
		givePay.getDocument().addDocumentListener(new CheckOut_documentListener(this));
		
		givePay.addKeyListener(new CheckOut_SureKeyList(this));
		//givePay.setText(String.valueOf(money));
		givePay.setText(frame.getAll().getText());
		givePay.setFont(new Font("黑体",Font.BOLD,25));
		tmpPane.add(givePay);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              找零金额:"));
		returnPay.setText("0.0");
		returnPay.setFont(new Font("黑体",Font.BOLD,25));
		returnPay.setForeground(Color.red);
		tmpPane.add(returnPay);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              销售备注:"));
		hyID.setFont(new Font("黑体",Font.BOLD,25));
		hyID.setForeground(Color.red);
		tmpPane.add(hyID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              支付方式:"));
		zfWay.setFont(new Font("黑体",Font.BOLD,25));
		zfWay.setForeground(Color.red);
		tmpPane.add(zfWay);
		centerPane.add(tmpPane);
		
		
		centerPane.setBorder(new TitledBorder("付款结账 "));
		pane.add(centerPane);
		
		JPanel southPane = new JPanel();
		ButtonGroup grop = new ButtonGroup();
		
		grop.add(cash);
		grop.add(czCard);
		grop.add(bankCard);
		grop.add(daiJinQuan);
		grop.add(connectPay);
		//支付方式监听器
		PayMethodAction l = new PayMethodAction(this);
		
        southPane.add(cash);
        southPane.add(czCard);
        southPane.add(bankCard);
        southPane.add(daiJinQuan);
        southPane.add(connectPay);
        
        cash.addActionListener(l);
        czCard.addActionListener(l);
        bankCard.addActionListener(l);
        daiJinQuan.addActionListener(l);
        connectPay.addActionListener(l);
        
		southPane.setBorder(new TitledBorder("请选择支付方式 "));
		pane.add(southPane,BorderLayout.SOUTH);
		return pane;
	}
	/*
	 * 改变付款方式的内部类
	 */
	class PayMethodAction implements ActionListener{
		private CheckOut dialog;
		PayMethodAction(CheckOut dialog){
			this.dialog = dialog;
		}
		public void actionPerformed(ActionEvent e) {
			JRadioButton tmpBtn = (JRadioButton)e.getSource();
			
			if(tmpBtn.isSelected()){
				int x = tmpBtn.getText().toString().indexOf(' ');
				String tmpString = tmpBtn.getText().substring(0, x);
				dialog.getZfWay().setText(tmpString);
			}
		}
		
	}
	
	public POSFrame getFrame() {
		return frame;
	}

	public JLabel getShouldPay() {
		return shouldPay;
	}

	public JTextField getGivePay() {
		return givePay;
	}

	public JTextField getReturnPay() {
		return returnPay;
	}

	public JLabel getHyID() {
		return hyID;
	}

	public JRadioButton getCash() {
		return cash;
	}

	public JRadioButton getCzCard() {
		return czCard;
	}

	public JRadioButton getBankCard() {
		return bankCard;
	}

	public JRadioButton getDaiJinQuan() {
		return daiJinQuan;
	}

	public JRadioButton getConnectPay() {
		return connectPay;
	}

	public JCheckBox getPrintXP() {
		return printXP;
	}

	public static void main(String[] args) {
		new CheckOut(null,"",true);
	}

}
