package com.cn.view.kuchunJFrame.chaifenkunbang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.BeiChaiShangPinChaXunAction;
import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.BeiChaiShangPinTableMouseListener;
import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.BeiChaiShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.chaifenkunbang.ChaiFenKunBang;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

/**
 * ����������ʾ������Ʒ����ϸ��Ϣ������ѡ�񱻲���Ʒ
 * @author Administrator
 *
 */
public class BeiChaiShangPinFindJWindow extends JWindow {
	//�����Ʒ
	private ChaifenKunbang dialog;
	
	//��װ����
	private BaozhuangShezhiJDialog  bDialog;
	
	//��ǲ�֡����󵯳����ڵİ�ť
	private String flag;
	//��Ǵ�С��Ʒ�������ڵİ�ť
	private String flag1;
	
	private AllTableModel tableModelBCF;//�������Ʒ
	private JTable tableBCF;//�������Ʒ
	private JTextField textSPCX;//��Ʒ��ѯ
	private JButton btnYes;
	private JButton btnExit;//�˳���ť
	
/////////////////////////////////	
	public JTextField getTextSPCX() {
		return textSPCX;
	}
	
	public String getFlag() {
		return flag;
	}
	
	public String getFlag1() {
		return flag1;
	}
	public AllTableModel getTableModelBCF() {
		return tableModelBCF;
	}
	
	public ChaifenKunbang getDialog() {
		return dialog;
	}
	
	public BaozhuangShezhiJDialog getBDialog() {
		return bDialog;
	}

	public JTable getTableBCF() {
		return tableBCF;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public BeiChaiShangPinFindJWindow(ChaifenKunbang dialog){
		super(dialog);
		this.dialog = dialog;
		init();
		setLabelData();
		this.setVisible(true);
	}
	
	public BeiChaiShangPinFindJWindow(ChaifenKunbang dialog,String flag,String str){
		super(dialog);
		this.dialog = dialog;
		this.flag = flag;
		init();
		setLabelData(str);
		this.setVisible(true);
	}
	public BeiChaiShangPinFindJWindow(BaozhuangShezhiJDialog bDialog,String flag1,String str){
		super(bDialog);
		this.bDialog = bDialog;
		this.flag1 = flag1;
		init();
		setLabelData(str);
		this.setVisible(true);
	}
	private void init(){
		this.setBounds(570,250,400,280);//Ӧ���ڲ�ͬ�Ĵ���������λ�ò�һ��
		this.add(addCom());
//		this.setVisible(true);
	}
	
////////////////////////////���ݳ�ʼ����
	
	private void setLabelData(){
		String num = ((ChaifenKunbang)this.getOwner()).getTextBCSPBH().getText().trim();
		Object[][]datas = BeiChaiShangPinDataToView.dataToView(num);
		tableModelBCF.setDataVector(datas, ChaiFenKunBang.colunmsCFKB1);
	}
	
	private void setLabelData(String str){
//		String num = ((ChaifenKunbang)this.getOwner()).getTextBCSPBH().getText().trim();
		Object[][]datas = BeiChaiShangPinDataToView.dataToView(str);
		tableModelBCF.setDataVector(datas, ChaiFenKunBang.colunmsCFKB1);
	}
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		
		//scrollPane ���
		JPanel cenJpanel = new JPanel();
		tableModelBCF = new AllTableModel(ChaiFenKunBang.dataCFKB1,ChaiFenKunBang.colunmsCFKB1);
		tableBCF = new JTable(tableModelBCF);
		
		tableBCF.setAutoCreateRowSorter(true); //������ñ���Զ�����
		tableBCF.setPreferredScrollableViewportSize(new Dimension(380,200));
		{
			tableBCF.addMouseListener(new BeiChaiShangPinTableMouseListener(this));
		}
			JScrollPane scroPane = new JScrollPane(tableBCF,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
			
			cenJpanel.add(scroPane);
		
		//�ײ���ť������
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		JLabel label = new JLabel("��Ʒ��ѯ(F2)");

		textSPCX = new JTextField(10);
		
		{
			textSPCX.getDocument().addDocumentListener(new BeiChaiShangPinChaXunAction(this));
		}
		
		btnYes = new JButton("ȷ��");
		{
			btnYes.addActionListener(new BeiChaiShangPinTableMouseListener(this));
		}
		btnExit = new JButton("�˳�");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BeiChaiShangPinFindJWindow.this.dispose();
			}
		});
		
		{
			souJpanel.add(label);
			souJpanel.add(textSPCX);
			souJpanel.add(btnYes);
			souJpanel.add(btnExit);
		}
		
		{
			jpanel.add(cenJpanel,BorderLayout.CENTER);
			jpanel.add(souJpanel,BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		new BeiChaiShangPinFindJWindow(null);
//	}
}
