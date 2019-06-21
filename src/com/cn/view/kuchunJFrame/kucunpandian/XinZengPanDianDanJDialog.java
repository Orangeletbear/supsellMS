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
 * 新增盘点单窗口
 * @author Administrator
 *
 */
public class XinZengPanDianDanJDialog extends JDialog {
	private KucunPandian dialog;
	private JLabel labelPDDH;//盘点单号
	private JComboBox comboPDCK;//盘点仓库
	private JDatePicker datePDRQ;//盘点日期
	private JLabel labelCZY;//操作员
	private JLabel labelBZ;//备注
	
	private JTextField textSPBH;//商品编号
	private JButton btnYes;//确定按钮
	private JTable tableSPQD;//商品清单
	private AllTableModel tableModelSPQD;//商品清单
	private Vector voKCSP = new Vector();//盘点库存商品数据行列
	private Vector veKCSP = new Vector();//盘点库存商品列名
	
	private JButton btnXG;//修改
	private JButton btnSC;//删除
	private JButton btnOK;//确定
	private JButton btnExit;//退出
	private JTable tableYPSP;//商品清单
	private AllTableModel tableModelYPSP;//商品清单
	private Vector voYPSP = new Vector();//盘点库存商品数据行列
	private Vector veYPSP = new Vector();//盘点库存商品列名
	
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
		 * 设置调拨单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.panDianNum();
			
			try {
				labelPDDH.setText("PD" + DateConventer.dateToStr(datePDRQ.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//设置操作员--------------------------
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
	 * 中部
	 */
	private JPanel addNor(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new GridLayout(3,1));
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		JPanel jpanel3 = new JPanel();

		JLabel label1 = new JLabel("盘点单号 ：");
		JLabel label2 = new JLabel("盘点仓库 ：");
		JLabel label3 = new JLabel("盘点日期 ：");
		JLabel label4 = new JLabel("操 作 员：");
		JLabel label5 = new JLabel("备    注：");
		JLabel label6 = new JLabel("提示：盘点中不能更换仓库和日期。" +
				"在没有修正库存之前请无忧采购进货、销售等能改变库存数量的操作，不然会造成库存数量的不准。");
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
					 * 设置盘点单据号
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
		
		norJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"盘点信息"));
		return norJpanel;
	}
	
	/*
	 * 中部
	 * 中间部分分为左右两个部分
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
	 * 左边
	 */
	private JPanel addLeft(){
		JPanel leftJpanel = new JPanel();
		leftJpanel.setLayout(new BorderLayout());
			
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		
		JLabel label = new JLabel("商品编号");
		textSPBH = new JTextField(10);
		{
			textSPBH.getDocument().addDocumentListener(new KCPD_MoHuChaXunDocumentLisrener(this));
		}
		btnYes =new JButton("确   定");
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
			tableSPQD.setAutoCreateRowSorter(true); //此语句让表格自动排序
			tableSPQD.setPreferredScrollableViewportSize(new Dimension(380,310));
			JScrollPane scroPane = new JScrollPane(tableSPQD);
			jpanel2.add(scroPane);
			
//			createTable(jpanel2,tableSPQD,tableModelSPQD,voKCSP,veKCSP);
		}
		
		{
			leftJpanel.add(jpanel1,BorderLayout.NORTH);
			leftJpanel.add(jpanel2,BorderLayout.CENTER);
		}
		leftJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"库存商品"));
		return leftJpanel;
	}
	
	/*
	 * 右边
	 */
	private JPanel addRight(){
		JPanel rightJpanel = new JPanel();
		rightJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		
		jpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		btnXG = new JButton("修改");
		btnSC = new JButton("删除");
		btnOK = new JButton("确定");
		btnExit = new JButton("退出");
		
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
			tableYPSP.setAutoCreateRowSorter(true); //此语句让表格自动排序
			tableYPSP.setPreferredScrollableViewportSize(new Dimension(380,310));
			JScrollPane scroPane = new JScrollPane(tableYPSP);
			jpanel2.add(scroPane);
			
//			createTable(jpanel2,tableYPSP,tableModelYPSP,voYPSP,veYPSP);
		}
		
		{
			rightJpanel.add(jpanel1,BorderLayout.NORTH);
			rightJpanel.add(jpanel2,BorderLayout.CENTER);
		}
		rightJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"已盘商品"));
		return rightJpanel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new XinZengPanDianDanJDialog(null,"录入盘点商品",true);
	}
}
