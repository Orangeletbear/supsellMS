package com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.jinhuoframe.caigoutuihuo.XiuGaiBtnActionListener;
import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.model.AllTableModel;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;

public class ShangPinXinXi2JDialog extends JDialog{
	/*
	 * ������
	 */
	private TuiHuoShangPin dialog;
	private String argspid;

	//panel1
	private JLabel shangpinbianhao= new JLabel();
	private JLabel shangpinmingcheng= new JLabel();
	

	public AllTableModel getATM() {
		return ATM;
	}

	private JLabel guigexinghao= new JLabel();
	private JLabel jibendanwei= new JLabel();
	private JLabel shengchanchangshang= new JLabel();
	private JLabel yanse= new JLabel();
	private JLabel dangqiankucun= new JLabel();
	private JLabel beizhu= new JLabel();
	//
	private JComboBox xuanzedanwei = new JComboBox();
	private JTextField cankaojinjia = new JTextField(10);
	private JTextField shuliang = new JTextField(10);
	
	private JButton queren = new JButton("ȷ��");
	
	//
	private AllTableModel ATM;//��model
	private Vector gonghuojilu_columnNames = ColumnNames.gonghuojilu_columnNames;//����
	//
	
	/**
	 * spid����˫�������ĳ�����ݵ�spID
	 */
	public ShangPinXinXi2JDialog(JDialog dialog,String title,boolean model){
		super(dialog,title,model);//����λ�ڵ�һ��

		this.dialog = (TuiHuoShangPin)dialog;
		
		int tmp = (this.dialog).getSplbtable().getSelectedRow();
		argspid = (String)((this.dialog).getATM().getValueAt(tmp, 0));
		this.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
				//��ʼ������
				Vector v = JDBCShangPinXinXi.getData(argspid);
				//����toString����null���ð죬������ɽկ��
				shangpinbianhao.setText(""+v.remove(0));
				
				shangpinmingcheng.setText(""+v.remove(0));
				shangpinmingcheng.setForeground(Color.RED);//��Ʒ������Ϊ��ɫ����
				
				guigexinghao.setText(""+v.remove(0));
				
				//һ������ͬʱ����  ������λ  ��  ѡ��λ
				jibendanwei.setText(""+v.get(0));
				xuanzedanwei.addItem(""+v.remove(0));
				
				shengchanchangshang.setText(""+v.remove(0));
				yanse.setText(""+v.remove(0));
				
				dangqiankucun.setText(""+v.remove(0));
				dangqiankucun.setForeground(Color.RED);//��ǰ�����Ϊ��ɫ����
				
				beizhu.setText(""+v.remove(0));
				cankaojinjia.setText(""+v.remove(0));
			}
		});
		init();
	}
	
	private void init(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);//�̶���С
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		this.add(panel1(),BorderLayout.NORTH);
	
		this.setVisible(true);
	}
//panel1
	private JPanel panel1(){
		JPanel panel1 = new JPanel();
		//
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new LineBorder(Color.GRAY,1) );//�߿�
		panel_center.setLayout(new GridLayout(4,0,1,10));
		panel_center.add(new JLabel("��Ʒ���:"));
		panel_center.add(shangpinbianhao);
		panel_center.add(new JLabel("��Ʒ����:"));
		panel_center.add(shangpinmingcheng);
		panel_center.add(new JLabel("����ͺ�:"));
		panel_center.add(guigexinghao);
		panel_center.add(new JLabel("������λ:"));
		panel_center.add(jibendanwei);
		panel_center.add(new JLabel("��������:"));
		panel_center.add(shengchanchangshang);
		panel_center.add(new JLabel("��ɫ:"));
		panel_center.add(yanse);
		panel_center.add(new JLabel("��ǰ���:"));
		panel_center.add(dangqiankucun);
		panel_center.add(new JLabel("��ע:"));
		panel_center.add(beizhu);
		//
	JPanel panel_south = new JPanel();
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("ѡ��λ"));
		xuanzedanwei.setPreferredSize(new Dimension(80,20));//����comboBox��С������������
		xuanzedanwei.setEditable(false);//����comboBox���ɱ༭
		pane.add(xuanzedanwei);
		pane.add(new JLabel("�ο�����"));
		pane.add(cankaojinjia);
		pane.add(new JLabel("����"));
		shuliang.setText("1");//����Ԥ��Ϊ1
		shuliang.setForeground(Color.RED);
		pane.add(shuliang);
		//
		JPanel pane2= new JPanel();
		JButton tuichu = new JButton("�˳�");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShangPinXinXi2JDialog.this.dispose();
			}
		});
		pane2.setLayout(new FlowLayout(FlowLayout.CENTER,60,1));
		//ȷ�ϰ�ť�ϵĴ����¼�����
		queren.addActionListener(new XiuGaiBtnActionListener(this));
		pane2.add(queren);
		pane2.add(tuichu);
		
		panel_south.setLayout(new GridLayout(2,0));
		panel_south.setBorder(new LineBorder(Color.GRAY,1) );//�߿�
		panel_south.add(pane);
		panel_south.add(pane2);
		
	/////////////////////////////////	
		panel1.setLayout(new BorderLayout());
		panel1.add(panel_center,BorderLayout.CENTER);
		panel1.add(panel_south,BorderLayout.SOUTH);
		return panel1;
	}

	public String getArgspid() {
		return argspid;
	}

	public JLabel getBeizhu() {
		return beizhu;
	}

	public JTextField getCankaojinjia() {
		return cankaojinjia;
	}

	public JLabel getDangqiankucun() {
		return dangqiankucun;
	}

	public TuiHuoShangPin getDialog() {
		return dialog;
	}

	public Vector getGonghuojilu_columnNames() {
		return gonghuojilu_columnNames;
	}

	public JLabel getGuigexinghao() {
		return guigexinghao;
	}

	public JLabel getJibendanwei() {
		return jibendanwei;
	}

	public JButton getQueren() {
		return queren;
	}

	public JLabel getShangpinbianhao() {
		return shangpinbianhao;
	}

	public JLabel getShangpinmingcheng() {
		return shangpinmingcheng;
	}

	public JLabel getShengchanchangshang() {
		return shengchanchangshang;
	}

	public JTextField getShuliang() {
		return shuliang;
	}

	public JComboBox getXuanzedanwei() {
		return xuanzedanwei;
	}

	public JLabel getYanse() {
		return yanse;
	}
	
}