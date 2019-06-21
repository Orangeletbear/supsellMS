package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucunpandian.KCPD_MoHuChaXunDocumentLisrener;
import com.cn.control.kuchunframe.kucunpandian.ShangPinPanDianShuJuLuRuAction;
import com.cn.control.kuchunframe.kucunpandian.xinzengshangpin.PanDianXinxiXiugaiMouseAction;
import com.cn.control.kuchunframe.kucunpandian.xinzengshangpin.YiPanShangPinMouseActionListener;
import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.KucunPandian;

/**
 * 
 * �����̵㵥����
 * @author Administrator
 *
 */
public class XinZengPanDianDanJDialog extends JDialog {
	private KucunPandian dialog;
	private JLabel labelPDDH;//�̵㵥��
	private JComboBox comboPDCK;//�̵�ֿ�
	private JDatePicker datePDRQ;//�̵�����
	private JLabel labelCZY;//����Ա
	private JLabel labelBZ;//��ע
	
	private JTextField textSPBH;//��Ʒ���
	private JButton btnYes;//ȷ����ť
	private JTable tableSPQD;//��Ʒ�嵥
	private AllTableModel tableModelSPQD;//��Ʒ�嵥
	private Vector voKCSP = new Vector();//�̵�����Ʒ��������
	private Vector veKCSP = new Vector();//�̵�����Ʒ����
	
	private JButton btnXG;//�޸�
	private JButton btnSC;//ɾ��
	private JButton btnOK;//ȷ��
	private JButton btnExit;//�˳�
	private JTable tableYPSP;//��Ʒ�嵥
	private AllTableModel tableModelYPSP;//��Ʒ�嵥
	private Vector voYPSP = new Vector();//�̵�����Ʒ��������
	private Vector veYPSP = new Vector();//�̵�����Ʒ����
	
	/////////////////////////////
	
	public JDatePicker getDatePDRQ() {
		return datePDRQ;
	}

	public KucunPandian getDialog() {
		return dialog;
	}

	public JTextField getTextSPBH() {
		return textSPBH;
	}

	public JTable getTableSPQD() {
		return tableSPQD;
	}

	public AllTableModel getTableModelSPQD() {
		return tableModelSPQD;
	}

	public Vector getVoKCSP() {
		return voKCSP;
	}

	public Vector getVeKCSP() {
		return veKCSP;
	}

	public JTable getTableYPSP() {
		return tableYPSP;
	}

	public AllTableModel getTableModelYPSP() {
		return tableModelYPSP;
	}

	public Vector getVoYPSP() {
		return voYPSP;
	}

	public Vector getVeYPSP() {
		return veYPSP;
	}
	
	public JButton getBtnXG() {
		return btnXG;
	}
	public JButton getBtnSC() {
		return btnSC;
	}
	public JButton getBtnOK() {
		return btnOK;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	
	public JLabel getLabelPDDH() {
		return labelPDDH;
	}
	public JComboBox getComboPDCK() {
		return comboPDCK;
	}
	public JLabel getLabelCZY() {
		return labelCZY;
	}
	public JLabel getLabelBZ() {
		return labelBZ;
	}

	public XinZengPanDianDanJDialog(KucunPandian dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
		/*
		 * ���õ������ݺ�
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.panDianNum();
			
			try {
				labelPDDH.setText("PD" + DateConventer.dateToStr(datePDRQ.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//���ò���Ա--------------------------
//			labelCZY.setText(this.getDialog().getFrame().getUser());
		}
		initData();
		this.setVisible(true);
	}
	private void initData(){
		Vector vo = KunCunPanDianChaXunGetDatas.initDatas(comboPDCK.getSelectedItem().toString());
		tableModelSPQD.setDataVector(vo, veKCSP);
	}
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
		}
		return jpanel;
	}

	/*
	 * �в�
	 */
	private JPanel addNor(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new GridLayout(3,1));
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		JPanel jpanel3 = new JPanel();

		JLabel label1 = new JLabel("�̵㵥�� ��");
		JLabel label2 = new JLabel("�̵�ֿ� ��");
		JLabel label3 = new JLabel("�̵����� ��");
		JLabel label4 = new JLabel("�� �� Ա��");
		JLabel label5 = new JLabel("��    ע��");
		JLabel label6 = new JLabel("��ʾ���̵��в��ܸ����ֿ�����ڡ�" +
				"��û���������֮ǰ�����ǲɹ����������۵��ܸı��������Ĳ�������Ȼ����ɿ�������Ĳ�׼��");
		{
			labelPDDH = new JLabel();
			labelPDDH.setForeground(Color.RED);
			comboPDCK = new JComboBox(JDBCCuCunFind.getCanKuData());
			datePDRQ = new JDatePicker();
			datePDRQ.setEditable(false);
			labelCZY = new JLabel("admin");
			labelBZ = new JLabel("");
		}
		{	
			comboPDCK.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Vector vo = KunCunPanDianChaXunGetDatas.initDatas(comboPDCK.getSelectedItem().toString());
					tableModelSPQD.setDataVector(vo, veKCSP);
				}
			});
			
			datePDRQ.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					/*
					 * �����̵㵥�ݺ�
					 */
						String num = DanJuHaoShuLiangGetDatas.panDianNum();
						System.out.println(num);
						try {
							labelPDDH.setText("PD" + DateConventer.dateToStr(datePDRQ.getSelectedDate(),"yyyyMMdd") 
									+ num);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
			});
		}
		
		{
			jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
			jpanel1.add(label1);
			jpanel1.add(labelPDDH);
			jpanel1.add(label2);
			jpanel1.add(comboPDCK);
			jpanel1.add(label3);
			jpanel1.add(datePDRQ);
			jpanel1.add(label4);
			jpanel1.add(labelCZY);
		}
		
		{
			jpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
			jpanel2.add(label5);
			jpanel2.add(labelBZ);
		}
		
		{
			label6.setForeground(Color.RED);
			jpanel3.add(label6);
		}
		
		{
			norJpanel.add(jpanel1);
			norJpanel.add(jpanel2);
			norJpanel.add(jpanel3);
		}
		
		norJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�̵���Ϣ"));
		return norJpanel;
	}
	
	/*
	 * �в�
	 * �м䲿�ַ�Ϊ������������
	 */
	private JPanel addCen(){
		JPanel cenJpanel = new JPanel();
		cenJpanel.setLayout(new GridLayout(1,2));
		{
			cenJpanel.add(addLeft());
			cenJpanel.add(addRight());
		}
		return cenJpanel;
	}
	
	/*
	 * ���
	 */
	private JPanel addLeft(){
		JPanel leftJpanel = new JPanel();
		leftJpanel.setLayout(new BorderLayout());
			
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		
		JLabel label = new JLabel("��Ʒ���");
		textSPBH = new JTextField(10);
		{
			textSPBH.getDocument().addDocumentListener(new KCPD_MoHuChaXunDocumentLisrener(this));
		}
		btnYes =new JButton("ȷ   ��");
		{
			btnYes.addActionListener(new PanDianXinxiXiugaiMouseAction(this));
		}
		
		{
			jpanel1.add(label);
			jpanel1.add(textSPBH);
			jpanel1.add(btnYes);
		}
		
		{
			voKCSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCSP);
			veKCSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCSP);
			tableModelSPQD = new AllTableModel(voKCSP,veKCSP);
			tableSPQD = new JTable(tableModelSPQD);
			{
				tableSPQD.addMouseListener(new PanDianXinxiXiugaiMouseAction(this));
			}
			tableSPQD.setAutoCreateRowSorter(true); //������ñ���Զ�����
			tableSPQD.setPreferredScrollableViewportSize(new Dimension(380,310));
			JScrollPane scroPane = new JScrollPane(tableSPQD);
			jpanel2.add(scroPane);
			
//			createTable(jpanel2,tableSPQD,tableModelSPQD,voKCSP,veKCSP);
		}
		
		{
			leftJpanel.add(jpanel1,BorderLayout.NORTH);
			leftJpanel.add(jpanel2,BorderLayout.CENTER);
		}
		leftJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�����Ʒ"));
		return leftJpanel;
	}
	
	/*
	 * �ұ�
	 */
	private JPanel addRight(){
		JPanel rightJpanel = new JPanel();
		rightJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		
		jpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		btnXG = new JButton("�޸�");
		btnSC = new JButton("ɾ��");
		btnOK = new JButton("ȷ��");
		btnExit = new JButton("�˳�");
		
		YiPanShangPinMouseActionListener lis = new YiPanShangPinMouseActionListener(this);
		{
			btnOK.addActionListener(new ShangPinPanDianShuJuLuRuAction(this));
			btnXG.addActionListener(lis);
			btnSC.addActionListener(lis);
		}
		{
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					XinZengPanDianDanJDialog.this.dispose();
				}
			});
		}
		{
			jpanel1.add(btnXG);
			jpanel1.add(btnSC);
			jpanel1.add(btnOK);
			jpanel1.add(btnExit);
		}
		
		{
			voYPSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataYPSP);
			veYPSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsYPSP);
			tableModelYPSP = new AllTableModel(voYPSP,veYPSP);
			tableYPSP = new JTable(tableModelYPSP);
			{
				tableYPSP.addMouseListener(new YiPanShangPinMouseActionListener(this));
			}
			tableYPSP.setAutoCreateRowSorter(true); //������ñ���Զ�����
			tableYPSP.setPreferredScrollableViewportSize(new Dimension(380,310));
			JScrollPane scroPane = new JScrollPane(tableYPSP);
			jpanel2.add(scroPane);
			
//			createTable(jpanel2,tableYPSP,tableModelYPSP,voYPSP,veYPSP);
		}
		
		{
			rightJpanel.add(jpanel1,BorderLayout.NORTH);
			rightJpanel.add(jpanel2,BorderLayout.CENTER);
		}
		rightJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"������Ʒ"));
		return rightJpanel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new XinZengPanDianDanJDialog(null,"¼���̵���Ʒ",true);
	}
}
