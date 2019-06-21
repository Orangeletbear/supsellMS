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
 * ���ӻ�Ա ���޸Ļ�Աһ�廯
 * @author finey
 *
 */
public class AddHuiYuan extends JDialog {
	//��Ա���
	private JTextField hyID = new JTextField(15);
	//��Ա����
	private JComboBox hyJiBie = new JComboBox(HuiYuanXinGLJDBC.getHuiYuanJiBie());
	//��Ա����
	private JTextField hyName = new JTextField(15);
	//��Ա����
	private JPasswordField hySecret = new JPasswordField(15);
	//��Ա����
	private JDatePicker hyBirthday = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//ȷ������
	private JPasswordField hyCirSecret = new JPasswordField(15);
	//��Ա����
	private JTextField hyJiFen = new JTextField(15);
	//��ϵ�绰
	private JTextField hyTell = new JTextField(15);
	//��������
	private JDatePicker hyJiaLuDate = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//��ֹ����
	private JDatePicker hyJieDate = new JDatePicker(
			JDatePicker.STYLE_CN_DATE);
	//�û�Ա���н�ֹ����
	private JCheckBox hyYouJiZhiDate = new JCheckBox("�û�Ա���н�ֹ����");
	//���øû�Ա��
	private JComboBox hyStart = new JComboBox(new String[]{"����","ͣ��"});
	//�Ƿ�����Զ�����
	private JComboBox hyShenJi = new JComboBox(new String[]{"��","��"});
	
	//��ע
	private JTextArea hyBeiZhu = new JTextArea(3,60);
	
	
	//һ�������������޸Ļ������صı�־(true Ϊ�޸�   false ����)
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
	 * ���Ӻ��޸ĶԻ���һ��
	 * @param frame  ���� 
	 * @param title ����
	 * @param isGetDate  �Ƿ����޸ĶԻ��� true Ϊ�޸ģ����Ϊ����
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
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//�������������
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		okBtn.addActionListener(new HuiAddOKBtnAction(this));
		JButton cancerBtn = new JButton("ȡ��");
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
	 * ��
	 */
	public JPanel initCenterPane(){
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		JPanel cenNorthPane = initCeneterNorthPane();
		JPanel cenSouthPane = initCeneterSouthPane();

		centerPane.add(cenNorthPane);
		centerPane.add(cenSouthPane,BorderLayout.SOUTH);
		
		
		centerPane.setBorder(new TitledBorder("��Ա��Ϣ"));
		
		return centerPane;
	}
	/*
	 * �б�
	 */
	public JPanel initCeneterNorthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(7,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա��� ��"));
		tmpPane.add(hyID);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա���� ��"));
		tmpPane.add(hyJiBie);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա���� ��"));
		tmpPane.add(hyName);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա���� ��"));
		tmpPane.add(hySecret);
		pane.add(tmpPane);
		
	
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա���� ��"));
		tmpPane.add(hyBirthday);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("ȷ������ ��"));
		tmpPane.add(hyCirSecret);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��Ա���� ��"));
		tmpPane.add(hyJiFen);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��ϵ�绰 ��"));
		tmpPane.add(hyTell);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("�������� ��"));
		hyJiaLuDate.setEnabled(false);
		tmpPane.add(hyJiaLuDate);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("��ֹ���� ��"));
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
		tmpPane.add(new JLabel("����״̬ ��"));
		tmpPane.add(hyStart);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("����������"));
		tmpPane.add(hyShenJi);
		pane.add(tmpPane);
		
		return pane;
		
	}
	/*
	 * ������
	 */
	private JPanel initCeneterSouthPane(){
		JPanel pane = new JPanel();
		pane.add(new JLabel("�� ע :"));
		pane.add(hyBeiZhu);
		return pane;
		
	}
	/*
	 * �޸�ʱ�����ݳ�ʼ��
	 */
	private void addDataToDialog(){
		
		int row = ((HuiYanGuangLiFrame)(this.getOwner())).
		         getHyXinXiT().getSelectedRow();

		String obj = ((HuiYanGuangLiFrame)(this.getOwner())).
				getHyXinXiTM().getValueAt(row, 0).toString();
		//ȡ�ñ�������
		Vector data = HuiYuanXinGLJDBC.getAHYMassege(obj);
		//��ǰ��Ʒ�����ݷ��������
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
