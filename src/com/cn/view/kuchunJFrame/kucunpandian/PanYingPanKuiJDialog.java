package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucunpandian.ShowCardAction;
import com.cn.control.kuchunframe.kucunpandian.panyingpankui.PanYingPanKuiActionListener;
import com.cn.dao.MFrameJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.view.kuchunJFrame.KucunPandian;
/**
 * ��ӯ�̿�����
 * ���岼�ְ�cardlayout
 * @author Administrator
 *
 */
public class PanYingPanKuiJDialog extends JDialog {
	private KucunPandian dialog;
	private JPanel cenJpanel;
	
	private AllTableModel tablemodel1;
	private JTable table1;
	private Vector vo1 = new Vector();
	private Vector ve1 = new Vector();
	
	private AllTableModel tablemodel2;
	private JTable table2;
	private Vector vo2 = new Vector();
	private Vector ve2 = new Vector();
	
	private AllTableModel tablemodel3;
	private JTable table3;
	private Vector vo3 = new Vector();
	private Vector ve3 = new Vector();
	
	private CardLayout cardlayout;
	private JComboBox comboCK;//�ֿ�����
	private JComboBox comboCZY;//����Ա
	private JButton btnCX;//��ѯ
	private JLabel labelPDDS;//�̵㵥��
	private JLabel labelJLS1;//�ڶ���������Ʒ����
	private JLabel labelJLS2;//������������Ʒ����
	
	private JButton btnNext;//
	private JButton btnLast;//
	private JButton btnWP;//δ����Ʒ
	private JButton btnXZ;//�������
	private JButton btnExit;//
	
	public PanYingPanKuiJDialog (KucunPandian dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	///////////////////////////
	
	public KucunPandian getDialog() {
		return dialog;
	}

	public JPanel getCenJpanel() {
		return cenJpanel;
	}

	public AllTableModel getTablemodel1() {
		return tablemodel1;
	}

	public JTable getTable1() {
		return table1;
	}
	
	public JLabel getLabelPDDS() {
		return labelPDDS;
	}
	public Vector getVo1() {
		return vo1;
	}

	public Vector getVe1() {
		return ve1;
	}

	public AllTableModel getTablemodel2() {
		return tablemodel2;
	}

	public JTable getTable2() {
		return table2;
	}

	public Vector getVo2() {
		return vo2;
	}

	public Vector getVe2() {
		return ve2;
	}

	public AllTableModel getTablemodel3() {
		return tablemodel3;
	}

	public JTable getTable3() {
		return table3;
	}

	public Vector getVo3() {
		return vo3;
	}

	public Vector getVe3() {
		return ve3;
	}

	public CardLayout getCardlayout() {
		return cardlayout;
	}

	public JComboBox getComboCK() {
		return comboCK;
	}

	public JComboBox getComboCZY() {
		return comboCZY;
	}

	public JButton getBtnCX() {
		return btnCX;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public JButton getBtnWP() {
		return btnWP;
	}

	public JButton getBtnXZ() {
		return btnXZ;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	private void init(){
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		
		{
//			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
		return jpanel;
	}

	private JPanel addCen(){
		cenJpanel = new JPanel();
		cardlayout = new CardLayout();
		cenJpanel.setLayout(cardlayout);
		
		{
			cenJpanel.add("first",first());
			cenJpanel.add("second",second());
			cenJpanel.add("third",third());
		}
		
		return cenJpanel;
	}
	

	
	//�м����ĵ�һ�����
	private JPanel first(){
		JPanel fiJpanel = new JPanel();
		fiJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel label1 = new JLabel("��һ�������ݲ�ѯ�����鴦��Ӧ���̵㵥��Ȼ�����б���ѡ��Ҫ�̵���̵㵥�����Զ�ѡ��");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();
		jpanel2.setLayout(new BorderLayout());
		JPanel jpanel21 = new JPanel();
		jpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel label21 = new JLabel("�ֿ����ƣ�");
		JLabel label22 = new JLabel("����Ա��");
		comboCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboCZY = new JComboBox(MFrameJDBC.getUser());
		btnCX = new JButton("��ѯ");
		{
			PanYingPanKuiActionListener lis = new PanYingPanKuiActionListener(this);
			btnCX.addActionListener(lis);
		}
		{
			jpanel21.add(label21);
			jpanel21.add(comboCK);
			jpanel21.add(label22);
			jpanel21.add(comboCZY);
			jpanel21.add(btnCX);
		}
		
		JPanel jpanel22 = new JPanel();
		jpanel22.setLayout(new FlowLayout(FlowLayout.LEFT));
		////�ӱ��
		vo1 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK1);
		ve1 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK1);
		tablemodel1 = new AllTableModel(vo1,ve1);
		table1 = new JTable(tablemodel1);
		table1.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table1.setPreferredScrollableViewportSize(new Dimension(780,360));
		JScrollPane scroPane = new JScrollPane(table1);
		jpanel22.add(scroPane);
		jpanel22.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		{
			jpanel2.add(jpanel21,BorderLayout.NORTH);
			jpanel2.add(jpanel22,BorderLayout.CENTER);
		}
//		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"ѡ���̵㵥"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		JLabel label31 = new JLabel();
		
		labelPDDS = new JLabel();
		labelPDDS.setForeground(Color.RED);
		
		jpanel3.add(label31);
		jpanel3.add(labelPDDS);
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		{
			fiJpanel.add(jpanel1,BorderLayout.NORTH);
			fiJpanel.add(jpanel2,BorderLayout.CENTER);
			fiJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		fiJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"ѡ���̵㵥"));
		return fiJpanel;
	}
	
	private JPanel second(){
		JPanel sJpanel = new JPanel();
		sJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label1 = new JLabel("�ڶ��������ݵ�һ��ѡ����̵㵥�����ܵõ��б��е������̵���Ʒ������δ����Ʒ���Բ鿴δ�̵�����Ʒ��Ϣ��");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();
		
		////�ӱ��
		vo2 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK2);
		ve2 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK2);
		tablemodel2 = new AllTableModel(vo2,ve2);
		table2 = new JTable(tablemodel2);
		table2.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table2.setPreferredScrollableViewportSize(new Dimension(780,330));
		JScrollPane scroPane = new JScrollPane(table2);
		jpanel2.add(scroPane);
		jpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"ѡ���̵㵥"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		JLabel label31 = new JLabel("��¼����" );
		labelJLS1 = new JLabel();
		labelJLS1.setForeground(Color.RED);
		jpanel3.add(label31);
		jpanel3.add(labelJLS1);
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		
		{
			sJpanel.add(jpanel1,BorderLayout.NORTH);
			sJpanel.add(jpanel2,BorderLayout.CENTER);
			sJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		sJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�����̵���Ʒ"));
		return sJpanel;
	}
	
	private JPanel third(){
		JPanel tJpanel = new JPanel();
		tJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label1 = new JLabel("���������̵�����-������� = ��������������޸�֮��ԭ���ݿ�������޷��ظ�������ǰ���ݡ�");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();

		vo3 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK3);
		ve3 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK3);
		tablemodel3 = new AllTableModel(vo3,ve3);
		table3 = new JTable(tablemodel3);
		table3.setAutoCreateRowSorter(true); //������ñ���Զ�����
		table3.setPreferredScrollableViewportSize(new Dimension(780,320));
		JScrollPane scroPane = new JScrollPane(table3);
		jpanel2.add(scroPane);
		jpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
//		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"ѡ���̵㵥"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label31 = new JLabel("��¼����");
		labelJLS2 = new JLabel();
		labelJLS2.setForeground(Color.RED);
		
		jpanel3.add(label31);
		jpanel3.add(labelJLS2);
		
		{
			tJpanel.add(jpanel1,BorderLayout.NORTH);
			tJpanel.add(jpanel2,BorderLayout.CENTER);
			tJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		tJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�̵�����"));
		return tJpanel;
	}
	/*
	 * �ϲ���ť���
	 */
	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		btnWP = new JButton("δ����Ʒ");
		btnLast = new JButton("��һ��");
		btnNext = new JButton("��һ��");
		btnXZ = new JButton("�������");
		btnExit = new JButton("�˳�");
		{
			ShowCardAction l = new ShowCardAction(this);
			btnLast.addActionListener(l);
			btnNext.addActionListener(l);
			btnXZ.addActionListener(l);
		}
		{
			btnWP.addActionListener(new PanYingPanKuiActionListener(this));
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					PanYingPanKuiJDialog.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnWP);
			souJpanel.add(btnLast);
			souJpanel.add(btnNext);
			souJpanel.add(btnXZ);
			souJpanel.add(btnExit);
		}
		souJpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,30,20));
		return souJpanel;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PanYingPanKuiJDialog(null,"��ӯ�̿�",true).setVisible(true);
	}


	public JLabel getLabelJLS1() {
		return labelJLS1;
	}


	public JLabel getLabelJLS2() {
		return labelJLS2;
	}
}
