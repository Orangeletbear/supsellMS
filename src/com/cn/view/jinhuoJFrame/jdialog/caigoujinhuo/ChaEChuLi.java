package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.cn.view.jinhuoJFrame.CaiGouJinHuo;

/**
 * ����
 * ��ʵ�����С��Ӧ������ǣ�ѡ�����Żݻ���Ƿ��
 */
public class ChaEChuLi extends JDialog{
	/*
	 * ������
	 */
	CaiGouJinHuo dialog;
	/*
	 * ��֧
	 */
	JRadioButton youhui ;
	JRadioButton qiankuan;
	//���
	private float chaE = 0;
	

	public ChaEChuLi(CaiGouJinHuo dialog,String title,boolean model){
		super(dialog,title,model);
		this.dialog = dialog;
		float arg1 = Float.parseFloat(dialog.getYingFuJinE().getText());
		float arg2 = Float.parseFloat(dialog.getShiFuJinE().getText());
		chaE =arg1 -arg2;
		youhui = new JRadioButton("�õ��ݶ��ҷ��Żݣ�"+chaE+" Ԫ");
		qiankuan =new JRadioButton("�õ����ҷ�Ƿ�"+chaE+" Ԫ");
		init();
	}
	
	private void init(){
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		this.add(pane());
		this.setVisible(true);
	}
	
	private JPanel pane(){
		JPanel pane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("�ɹ�������ʵ���������Ӧ����"));
		panel1.add(new JLabel("��������������ѡ��Բ��Ĵ���"));

		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup bg = new ButtonGroup();
		bg.add(youhui);
		bg.add(qiankuan);
		panel2.add(youhui);
		panel2.add(qiankuan);

		JButton quxiao = new JButton("ȡ��");
		quxiao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ChaEChuLi.this.dispose();
			}
		});
		JButton queding = new JButton("ȷ��");
		queding.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!youhui.isSelected() && !qiankuan.isSelected()){//��û��ѡ
					return;
				}

				if(youhui.isSelected()){
					dialog.setYouHuiJine(chaE);
				}else{
					dialog.setQianKuanJine(chaE);
				}
				ChaEChuLi.this.dispose();
			}
		});
		panel3.add(queding);
		panel3.add(quxiao);
		
		pane.setLayout(new GridLayout(3,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		
		
		return pane;
	}

}
