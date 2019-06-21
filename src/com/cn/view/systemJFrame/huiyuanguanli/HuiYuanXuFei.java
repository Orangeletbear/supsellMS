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
 * ��Ա�����µĻ�Ա����
 * @author Administrator
 *
 */
public class HuiYuanXuFei extends JDialog {
	 //��Ա��
	private JLabel hyID = new JLabel("05");
    //��Ա����
	private JLabel hyName = new JLabel();
	//�˺����
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
	 * ���ݳ�ʼ��
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
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	
   private JPanel createPane(){
	    JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab = new JLabel("��Ա���:");
		tmpPane.add(lab);
		hyID.setForeground(Color.red);
		tmpPane.add(hyID);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("��Ա����:");
		tmpPane.add(lab);
		hyName.setForeground(Color.red);
		tmpPane.add(hyName);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab = new JLabel("�˺����:");
		tmpPane.add(lab);
		hyYuE.setForeground(Color.red);
		tmpPane.add(hyYuE);
		centerPane.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    lab = new JLabel("��ֵ���:");
		tmpPane.add(lab);
		tmpPane.add(chongZhi);
		lab = new JLabel("���˽��:");
		tmpPane.add(lab);
		tmpPane.add(daoZhang);
		centerPane.add(tmpPane);
		
		centerPane.setBorder(new TitledBorder("��Ա��Ϣ"));
		
		mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		JButton cancerBtn = new JButton("ȡ��");
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
					JOptionPane.showMessageDialog(null,"��������ȷ��ֵ!");
					return;
				}
				
				//float spjMoney = new Float(hyMoney).floatValue();
				String user = ((MainFrame)frame.getOwner()).getUser();
				boolean isSuccess = HuiYuanXinGLJDBC.huiYuanAddMoney(chongZhi.getText(),
						daoZhang.getText(),hyID1,user);
				if(isSuccess){
					JOptionPane.showMessageDialog(null,"�ɹ���ֵ!");
					
					Log.traceLog("  ����Ա  ",user,"  ����Ա: "+
							hyName.getText()+" ���� "+hyMoney+" Ԫ���");
					frame.initData();
					HuiYuanXuFei.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null,"��������ȷ��ֵ!");
				}
			}
			
		});
		
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
   } 
}
