package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import com.cn.control.posmainframe.RuKuanDialog_SureAction;
import com.cn.dao.pos.POScrk_JDBC;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.util.DateConventer;
/*
 * POS�˵��еĿ�������
 */
public class POSLuKuangDialog extends JDialog {

	//����Ա
	JTextField userName = new JTextField(10);
	//��   
	JLabel ruKuanDanHao = new JLabel("");
	//�����
	JTextField ruKuanJinE = new JTextField(10);
	
	public POSLuKuangDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(300,200));
		this.setLayout(new GridLayout(4,1));
		
		JPanel pane  =new JPanel();
		pane.setLayout(new FlowLayout());
		JLabel lab =new JLabel("�� �� Ա :");
		pane.add(lab);
		userName.setText(((POSFrame)this.getOwner()).getUser());
		userName.setEditable(false);
		userName.setForeground(Color.RED);
		pane.add(userName);
		this.add(pane);
		
		pane  = new JPanel();
		pane.setLayout(new FlowLayout());
		lab =new JLabel("���� :");
		pane.add(lab);
		pane.add(ruKuanDanHao);
		ruKuanDanHao.setForeground(Color.RED);
		this.add(pane);
		
		String date = DateConventer.dateToStr(new Date());

	    String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		
		ArrayList dan = POScrk_JDBC.getRuKuanInfo(date);
		
		 ArrayList sd = new ArrayList();
		 for(int i = 0;i < dan.size();i++){
			 String dan1 = dan.get(i).toString();
		
			 if(dan1.substring(2, 10).equals(s)){	 
				 sd.add(dan1);
			 }
		 }
		
		//��ϵͳ���ڵ������պ����ڵ��쵥�ݺŵ�˳����Ϊ���ݺ�
		 if(sd.size()==0){
			 ruKuanDanHao.setText("RK"+s+"0001") ;
			
		 }else{
			 int max = 0;
			 String h = null;
			 for(int i = 0;i< sd.size();i++){
				    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
				 
		        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
		        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
		        		
		        	}

		    }
			 if(max+1>0 && max+1<10){
	        		h = "000"+(max+1);
	        	}else if(max+1>9 && max+1<100){
	        		h = "00"+(max+1);
	        	}else if(max+1 >99&& max+1< 1000){
	        		h = "0"+(max+1);
	        	}else {
	        		h = ""+(max+1);
	        	}
			 //����
			 ruKuanDanHao.setText("RK"+s+h) ;
	      }	 
		
		
		
		pane  =new JPanel();
		pane.setLayout(new FlowLayout());
		lab =new JLabel("����� :");
		pane.add(lab);
		pane.add(ruKuanJinE);
		this.add(pane);

		
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		JButton okBtn = new JButton("ȷ��");
		okBtn.addActionListener(new RuKuanDialog_SureAction(this));
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				POSLuKuangDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		this.add(southPane,BorderLayout.SOUTH);
		
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}

	public JLabel getruKuanDanHao() {
		return ruKuanDanHao;
	}

	public JTextField getruKuanJinE() {
		return ruKuanJinE;
	}

	public JTextField getUserName() {
		return userName;
	}

}
