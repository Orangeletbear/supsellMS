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
 * ���ӻ�Ա����
 * @author finey
 *
 */
public class AddHuiYuanJiBie extends JDialog {

	//������
	private JTextField jbID = new JTextField(15);
	//��������
	private JTextField jbName = new JTextField(15);
	//�����ۿ�
	private JTextField jbZheKou = new JTextField(15);
	//��������
	private JTextField jiFenUp= new JTextField(15);
	//��������
	private JTextField jiFenDown = new JTextField(15);
	
	
	//�޸Ļ��Ǽ���һ����¼
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
	 * ���Ӻ��޸ĶԻ���һ��
	 * @param frame  ���� 
	 * @param title ����
	 * @param isGetDate  �Ƿ����޸ĶԻ��� true Ϊ�޸ģ����Ϊ����
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
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}

	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//�������������
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		JButton okBtn = new JButton("ȷ��");
		okBtn.addActionListener(new HuiYuanJiBieOkAction(this));
		JButton cancerBtn = new JButton("ȡ��");
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
	 * ��
	 */
	public JPanel initCenterPane(){
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(6,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("������ ��  "));
		tmpPane.add(jbID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("�������� ��  "));
		tmpPane.add(jbName);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("�����ۿ� ��  "));
		tmpPane.add(jbZheKou);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("�������� ��  "));
		tmpPane.add(jiFenUp);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpPane.add(new JLabel("�������� ��  "));
		tmpPane.add(jiFenDown);
		centerPane.add(tmpPane);
		
		JLabel lba = new JLabel("ע��0.9Ϊ���ۣ�1Ϊ������");
		lba.setForeground(Color.red);
		centerPane.add(lba);
		
		return centerPane;
	}
	/*
	 * ���ݳ�ʼ��
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
