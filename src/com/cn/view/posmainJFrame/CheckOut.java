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
 *  ���˶Ի���
 * 
 */
public class CheckOut extends JDialog {

	private POSFrame frame;
	//Ӧ�����
	private JLabel shouldPay = new JLabel("0.0");
	//������
	private JTextField givePay = new JTextField(20);
	//������
	private JTextField returnPay = new JTextField(20);
	//���۱�ע
	private JLabel hyID = new JLabel("");
	//���ʽ
	private JLabel zfWay = new JLabel("�ֽ�");
	
	//���ʽ
	private JRadioButton cash = new JRadioButton("�ֽ� ��1��");
	private JRadioButton czCard = new JRadioButton("��ֵ�� ��2��");
	private JRadioButton bankCard = new JRadioButton("���п� ��3��");
	private JRadioButton daiJinQuan = new JRadioButton("����ȯ ��4��");
	private JRadioButton connectPay = new JRadioButton("���Ͻ��� ��5��");
	
	//��ӡСƱ
	private JCheckBox printXP = new JCheckBox("��ӡСƱ");
	
	
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
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout(10,10));
		//�������������
	    JPanel centerPane = initCenterPane();
	    
	    
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    JPanel southPane = new JPanel();
	    southPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
	    
	   
	    
        JButton mlBtn = new JButton("Ĩ��(F6)");
        JButton okBtn = new JButton("ȷ��(F5)");
        okBtn.addActionListener(new CheckOut_Sure(this));
        JButton cancelBtn = new JButton("�˳�(F4)");
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
		tmpPane.add(new JLabel("              Ӧ�����:"));
		shouldPay.setForeground(Color.red);
		shouldPay.setFont(new Font("����",Font.BOLD,25));
		/*//Ӧ�����
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
		tmpPane.add(new JLabel("              ������:"));
		givePay.setForeground(Color.red);
		givePay.getDocument().addDocumentListener(new CheckOut_documentListener(this));
		
		givePay.addKeyListener(new CheckOut_SureKeyList(this));
		//givePay.setText(String.valueOf(money));
		givePay.setText(frame.getAll().getText());
		givePay.setFont(new Font("����",Font.BOLD,25));
		tmpPane.add(givePay);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              ������:"));
		returnPay.setText("0.0");
		returnPay.setFont(new Font("����",Font.BOLD,25));
		returnPay.setForeground(Color.red);
		tmpPane.add(returnPay);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              ���۱�ע:"));
		hyID.setFont(new Font("����",Font.BOLD,25));
		hyID.setForeground(Color.red);
		tmpPane.add(hyID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		tmpPane.add(new JLabel("              ֧����ʽ:"));
		zfWay.setFont(new Font("����",Font.BOLD,25));
		zfWay.setForeground(Color.red);
		tmpPane.add(zfWay);
		centerPane.add(tmpPane);
		
		
		centerPane.setBorder(new TitledBorder("������� "));
		pane.add(centerPane);
		
		JPanel southPane = new JPanel();
		ButtonGroup grop = new ButtonGroup();
		
		grop.add(cash);
		grop.add(czCard);
		grop.add(bankCard);
		grop.add(daiJinQuan);
		grop.add(connectPay);
		//֧����ʽ������
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
        
		southPane.setBorder(new TitledBorder("��ѡ��֧����ʽ "));
		pane.add(southPane,BorderLayout.SOUTH);
		return pane;
	}
	/*
	 * �ı丶�ʽ���ڲ���
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
