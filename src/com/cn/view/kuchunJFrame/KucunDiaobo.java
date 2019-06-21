package com.cn.view.kuchunJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.cn.control.kuchunframe.kucundiaobo.DeleteShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.DiaoBoShuJuLuRuAction;
import com.cn.control.kuchunframe.kucundiaobo.GJCXActionListener;
import com.cn.control.kuchunframe.kucundiaobo.KCDB_AddShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.XiuGaiShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.chaxun.ChaXunDiaoBoMouseListener;
import com.cn.control.kuchunframe.kucundiaobo.chaxun.TimeChaXunAction;
import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.dao.kuchun.kucundiaobo.diaobodanchaxun.DiaoBoDanChaXunGetDatas;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.mainJFrame.MainFrame;

public class KucunDiaobo extends JDialog {
	private MainFrame frame;
	//调拨
	private Vector vector1 = new Vector();
	
	//库存调拨表
	private JComboBox comboDCCK ;
	private JComboBox comboDRCK ;
	private JDatePicker date1;
	private JLabel labelDBDH ;
	private JButton btnTJSP ;//添加商品
	private JButton btnXGSP ;//修改商品
	private JButton btnSCSP ;//删除商品
	
	private AllTableModel tableModel1;
	private JTable tableKCDB1 ;
	private Vector ve1 = new Vector();//存列名
	private Vector vo1 = new Vector();
	
	private JComboBox comboJBR = new JComboBox();
	private JTextField textBZ = new JTextField(20);
//	private JButton btnJBR;
	private JButton btnYes;
	private JButton btnNo;
	
	//调拨详单查询
	private JButton btnGJCX;
	private JButton btnCKDJ;
	private JButton btnDC;
	private JButton btnExit;
	private JButton btnCheck;
	
	private JDatePicker dateFrom;
	private JDatePicker dateTo;
	
	private AllTableModel tableModel2;
	private JTable tableKCDB2 ;
	private Vector ve2 = new Vector();//存列名
	private Vector vo2 = new Vector();
	
	private AllTableModel tableModel3;
	private JTable tableKCDB3 ;
	private Vector ve3 = new Vector();//存列名
	private Vector vo3 = new Vector();
	
	private JLabel labelDJS;
	private JLabel labelNum1;
	private JLabel labelDJXQ;
	private JLabel labelJLS;
	private JLabel labelNum2;
	
///////////////////////	
	public MainFrame getFrame() {
		return frame;
	}
	
	public Vector getVector1() {
		return vector1;
	}

	public JLabel getLabelDJXQ() {
		return labelDJXQ;
	}

	public Vector getVo2() {
		return vo2;
	}
	public Vector getVo3() {
		return vo3;
	}
	
	public Vector getVe2() {
		return ve2;
	}
	public Vector getVe3() {
		return ve3;
	}
	public JDatePicker getDateFrom() {
		return dateFrom;
	}
	public JDatePicker getDateTo() {
		return dateTo;
	}
	//获取添加商品按钮
	public JButton getBtnTJSP() {
		return btnTJSP;
	}
	//获取调出仓库的combo
	public JComboBox getComboDCCK() {
		return comboDCCK;
	}
//	获取调入仓库的combo
	public JComboBox getComboDRCK() {
		return comboDRCK;
	}
	//获取调拨日期
	public JDatePicker getDate1() {
		return date1;
	}
	//获取高级查询按钮
	public JButton getBtnGJCX() {
		return btnGJCX;
	}
	/////获取表格
	public JTable getTableKCDB1() {
		return tableKCDB1;
	}
	public JTable getTableKCDB2() {
		return tableKCDB2;
	}
	public JTable getTableKCDB3() {
		return tableKCDB3;
	}
	public AllTableModel getTableModel1() {
		return tableModel1;
	}
	public AllTableModel getTableModel2() {
		return tableModel2;
	}
	public AllTableModel getTableModel3() {
		return tableModel3;
	}
	
	public Vector getVe1() {
		return ve1;
	}
	public Vector getVo1() {
		return vo1;
	}
	////调拨单所需的部分信息获取
	public JComboBox getComboJBR() {
		return comboJBR;
	}
	public JLabel getLabelDBDH() {
		return labelDBDH;
	}
	public JTextField getTextBZ() {
		return textBZ;
	}
	public JLabel getLabelNum1() {
		return labelNum1;
	}

	public void setLabelNum1(JLabel labelNum1) {
		this.labelNum1 = labelNum1;
	}

	public JLabel getLabelDJS() {
		return labelDJS;
	}

	public JLabel getLabelJLS() {
		return labelJLS;
	}

	public JLabel getLabelNum2() {
		return labelNum2;
	}

	//////////////////////////
	public KucunDiaobo(MainFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame = frame;
		init();
		/*
		 * 设置调拨单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.diaoBoNum();
//			System.out.println(num);
			try {
				labelDBDH.setText("TB" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
//		createData1();
//		createData2();  有时数据不存在，初始化会报异常
		this.setVisible(true);
	}
	/////////////////数据初始化
	private void createData1(){
		//调拨单初始化
		vo2 = DiaoBoDanChaXunGetDatas.danJuChaXun();
		tableModel2.setDataVector(vo2, ve2);
		labelDJS.setText("" + vo2.size());
//		tableKCDB2.setRowSelectionInterval(0,0);
	}
	
	private void createData2(){
		//调拨商品初始化
		int row = tableKCDB2.getSelectedRow();
		vo3 = DiaoBoDanChaXunGetDatas.shangPinChaXun(tableKCDB2.getValueAt(row, 0).toString());
		tableModel3.setDataVector(vo3, ve3);
		tableKCDB3.setRowSelectionInterval(0,0);
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addComJtab());
//		this.setVisible(true);
	}
	/*
	 * 为选项卡添加面板
	 * 
	 */
	private JTabbedPane addComJtab(){
		JTabbedPane tabpanel = new JTabbedPane();
		tabpanel.addTab("库存调拨单", addComKCDBD());
		tabpanel.addTab("库存调拨查询", addComKCDBCX());
		return tabpanel;
	}
	/*
	 * 库存调货单界面主面板
	 * 
	 */
	private JPanel addComKCDBD(){
		JPanel jpanelKCTBD = new JPanel();
		jpanelKCTBD.setLayout(new BorderLayout());
		
		jpanelKCTBD.add(addComKCTDDNor(),BorderLayout.NORTH);
		jpanelKCTBD.add(addComKCDBDCen(),BorderLayout.CENTER);
		jpanelKCTBD.add(addComKCDBDSou(),BorderLayout.SOUTH);
		
		return jpanelKCTBD;
	}
	/*
	 * 库存调拨单北部
	 * 
	 */
	private JPanel addComKCTDDNor(){
		JPanel jpanelNor = new JPanel();
		JLabel labelKCTB = new JLabel("库  存  调  拨");
		labelKCTB.setFont(new Font("黑体",Font.BOLD,20));
		jpanelNor.add(labelKCTB);
		return jpanelNor;
	}
	
	/*
	 * 库存调拨单中部
	 */
	private JPanel addComKCDBDCen(){
		JPanel jpanelCen = new JPanel();
		jpanelCen.setLayout(new BorderLayout());
		
		//添加label栏面板
		JPanel jpanelCenNor = new JPanel();
		jpanelCenNor.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
		comboDCCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboDRCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		JLabel labelDCCK = new JLabel("调 出 仓 库");
		JLabel labelDRCK = new JLabel("调入 仓 库");
		JLabel labelDBRQ = new JLabel("调 拨 日 期");
		date1 = new JDatePicker();
		date1.setEditable(false);
		JLabel label = new JLabel("调拨单号:");
		labelDBDH = new JLabel();
		labelDBDH.setForeground(Color.RED);
        
		date1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				/*
				 * 设置拆分单据号
				 */
					String num = DanJuHaoShuLiangGetDatas.diaoBoNum();
//					System.out.println(num);
					try {
						labelDBDH.setText("CF" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
								+ num);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
		});
		{
			jpanelCenNor.add(labelDCCK);
			jpanelCenNor.add(comboDCCK);
			jpanelCenNor.add(labelDRCK);
			jpanelCenNor.add(comboDRCK);
			jpanelCenNor.add(labelDBRQ);
			jpanelCenNor.add(date1);
			jpanelCenNor.add(label);
			jpanelCenNor.add(labelDBDH);
			jpanelCenNor.setBorder(new LineBorder(Color.lightGray,1));
		}
		
		//添加tabbedpane主面板
		JPanel jpanelCenCen = new JPanel();
		jpanelCenCen.setLayout(new BorderLayout());
		
		JPanel jpanelCenCenNor = new JPanel();
		jpanelCenCenNor.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		btnTJSP = new JButton("添加商品(F2)");
		btnXGSP = new JButton("修改商品(F3)");
		btnSCSP = new JButton("删除商品(F4)");
		
		XiuGaiShangPinAction xg = new XiuGaiShangPinAction(this);
		{
			btnTJSP.addActionListener(new KCDB_AddShangPinAction(this));
			btnXGSP.addActionListener(xg);
			btnSCSP.addActionListener(new DeleteShangPinAction(this));
		}
		
		{
			jpanelCenCenNor.add(btnTJSP);
			jpanelCenCenNor.add(btnXGSP);
			jpanelCenCenNor.add(btnSCSP);
		}
		
		JPanel jpanelCenCenCen = new JPanel();
		
		vo1 = AllTableModel.getVectorDataFromObj(KCDBModel.dataKCDB1);
		ve1 = AllTableModel.getVectorFromObj(KCDBModel.colunmsKCDB1);
	
		tableModel1 = new AllTableModel(vo1,ve1);
		tableKCDB1 = new JTable(tableModel1);
		tableKCDB1.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableKCDB1.setPreferredScrollableViewportSize(new Dimension(780,297));
		JScrollPane scroPane = new JScrollPane(tableKCDB1);
		jpanelCenCenCen.add(scroPane);
		{
			tableKCDB1.addMouseListener(new XiuGaiShangPinAction(this));
		}
		
		{
			jpanelCenCen.add(jpanelCenCenNor,BorderLayout.NORTH);
			jpanelCenCen.add(jpanelCenCenCen,BorderLayout.CENTER);
		}
		
		{
			jpanelCen.add(jpanelCenNor,BorderLayout.NORTH);
			jpanelCen.add(jpanelCenCen,BorderLayout.CENTER);
		}
		jpanelCen.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return jpanelCen;
	}
	/*
	 * 库存调拨单南部
	 */
	private JPanel addComKCDBDSou(){
		JPanel jpanelSou= new JPanel();
		jpanelSou.setLayout(new GridLayout(2,1));
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel labelJBR = new JLabel("经   办   人");
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
		comboJBR.addItem("所有经办人");
		comboJBR.setSelectedItem("所有经办人");
//		btnJBR = new JButton("...");
//		{
//			btnJBR.addActionListener(new JingBanRenAction(this));
//		}
		JLabel labelBZ = new JLabel("备      注");
		{
			jpanel1.add(labelJBR);
			jpanel1.add(comboJBR);
//			jpanel1.add(btnJBR);
			jpanel1.add(labelBZ);
			jpanel1.add(textBZ);
		}
		
		JPanel jpanel2 = new JPanel(); 
		jpanel2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
		btnYes = new JButton("确     定");
		{
			btnYes.addActionListener(new DiaoBoShuJuLuRuAction(this));
		}
		btnNo = new JButton("取    消");
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				KucunDiaobo.this.dispose();
			}
		});
		{
			jpanel2.add(btnYes);
			jpanel2.add(btnNo);
		}
		{
			jpanelSou.add(jpanel1);
			jpanelSou.add(jpanel2);
		}
		jpanelSou.setBorder(new LineBorder(Color.lightGray,1));
		return jpanelSou;
	}
	
	
	
	/**
	 * 库存调拨查询界面主面板
	 * 
	 */
	
	private JPanel addComKCDBCX(){
		JPanel jpanelKCDBCX = new JPanel();
		jpanelKCDBCX.setLayout(new GridLayout(2,1));
		{
			jpanelKCDBCX.add(addUp());
			jpanelKCDBCX.add(addDown());
		}
		return jpanelKCDBCX;
	}
	/*
	 * 上半部主面板
	 * 
	 * 上半部分为北中南三部分
	 */
	private JPanel addUp(){
		JPanel upJpanel = new JPanel();
		upJpanel.setLayout(new BorderLayout());
		{
			upJpanel.add(addUpNor(),BorderLayout.NORTH);
			upJpanel.add(addUpCen(),BorderLayout.CENTER);
			upJpanel.add(addUpSou(),BorderLayout.SOUTH);
		}
				
		return upJpanel;
	}
	/*
	 * 上北部
	 *
	 */
	private JPanel addUpNor(){
		JPanel upNorJpanel = new JPanel();
		upNorJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		btnGJCX = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
		btnGJCX.setMargin(new Insets(0,0,0,0));
		btnCKDJ = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		btnCKDJ.setMargin(new Insets(0,0,0,0));
		btnDC = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		btnDC.setMargin(new Insets(0,0,0,0));
		btnExit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit.setMargin(new Insets(0,0,0,0));
		
		JLabel label1 = new JLabel("调拨时间");
		dateFrom = new JDatePicker();
		dateFrom.setEditable(false);
		JLabel label2 = new JLabel("   至    ");
		dateTo = new JDatePicker();
		dateTo.setEditable(false);
		btnCheck = new JButton("查  询");
		//按钮监听器
		{
			btnCheck.addActionListener(new TimeChaXunAction(this));
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					KucunDiaobo.this.dispose();
				}
		});
		
		btnDC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser("D:/workspace");
				file.setFileFilter(new FileNameExtensionFilter("excel表格","excel"));
				file.showSaveDialog(KucunDiaobo.this);
			}
		});
		}
		//注册监听器:高级查询按钮
		{
			btnGJCX.addActionListener(new GJCXActionListener(this));
			
		}
		{
			upNorJpanel.add(btnGJCX);
			upNorJpanel.add(btnCKDJ);
			upNorJpanel.add(btnDC);
			upNorJpanel.add(btnExit);
			upNorJpanel.add(label1);
			upNorJpanel.add(dateFrom);
			upNorJpanel.add(label2);
			upNorJpanel.add(dateTo);
			upNorJpanel.add(btnCheck);
			
		}
		upNorJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return upNorJpanel;
	}
	/*
	 * 上中部
	 */
	private JPanel addUpCen(){
		JPanel upCenJpanel = new JPanel();
		vo2 = AllTableModel.getVectorDataFromObj(KCDBModel.dataKCDB2);
		ve2 = AllTableModel.getVectorFromObj(KCDBModel.colunmsKCDB2);
	
		tableModel2 = new AllTableModel(vo2,ve2);
		tableKCDB2 = new JTable(tableModel2);
		tableKCDB2.setAutoCreateRowSorter(true); //此语句让表格自动排序
		{
			tableKCDB2.addMouseListener(new ChaXunDiaoBoMouseListener(this));
		}
		tableKCDB2.setPreferredScrollableViewportSize(new Dimension(780,140));
		JScrollPane scroPane = new JScrollPane(tableKCDB2);
		upCenJpanel.add(scroPane);
		
		return upCenJpanel;
	}
	/*
	 * 上南部
	 * 
	 */
	private JPanel addUpSou(){
		JPanel upSouJpanel = new JPanel();
		upSouJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel label = new JLabel("单  据  数：");
		labelDJS = new JLabel("",JLabel.LEFT);
		labelDJS.setForeground(Color.RED);
		labelDJS.setPreferredSize(new Dimension(60,20));
//		labelNum1 = new JLabel("  0.0  ",JLabel.RIGHT);
		{
			upSouJpanel.add(label);
			upSouJpanel.add(labelDJS);
//			upSouJpanel.add(labelNum1);
		}
		
		upSouJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return upSouJpanel;
	}
	
	/*
	 * 下半部主面板
	 * 
	 * 下半部分为北中南三部分
	 */
	private JPanel addDown(){
		JPanel downJpanel = new JPanel();
		downJpanel.setLayout(new BorderLayout());
		{
			downJpanel.add(addDownNor(),BorderLayout.NORTH);
			downJpanel.add(addDownCen(),BorderLayout.CENTER);
			downJpanel.add(addDownSou(),BorderLayout.SOUTH);
		}
		
		return downJpanel;
	}
	/*
	 * 下北部
	 */
	private JPanel addDownNor(){
		JPanel downNorJpanel = new JPanel();
		downNorJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label1 = new JLabel("    单 据 详 情：");
		labelDJXQ = new JLabel("DB",JLabel.LEFT);
		labelDJXQ.setForeground(Color.RED);
		
		downNorJpanel.add(label1);
		downNorJpanel.add(labelDJXQ);
		return downNorJpanel;
	}
	/*
	 * 下中部
	 */
	private JPanel addDownCen(){
		JPanel downCenJpanel = new JPanel();
		
		vo3 = AllTableModel.getVectorDataFromObj(KCDBModel.dataKCDB3);
		ve3 = AllTableModel.getVectorFromObj(KCDBModel.colunmsKCDB3);
		tableModel3 = new AllTableModel(vo3,ve3);
		tableKCDB3 = new JTable(tableModel3);
		tableKCDB3.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableKCDB3.setPreferredScrollableViewportSize(new Dimension(780,180));
		JScrollPane scroPane = new JScrollPane(tableKCDB3);
		downCenJpanel.add(scroPane);
		return downCenJpanel;
	}
	/*
	 * 下南部
	 
	 */
	
	private JPanel addDownSou(){
		JPanel downSouJpanel = new JPanel();
		downSouJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel label = new JLabel("记录数：");
		labelJLS = new JLabel("0",JLabel.LEFT);
		labelJLS.setForeground(Color.RED);
		labelNum2 = new JLabel("   0.0   ",JLabel.LEFT);
		labelNum2.setForeground(Color.RED);
		{
			downSouJpanel.add(label);
			downSouJpanel.add(labelJLS);
//			downSouJpanel.add(labelNum2);
		}
		
		downSouJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return downSouJpanel;
	}
	
//	测试===============================
	public static void main(String [] args){
		new KucunDiaobo(null,"库存调拨",true);
	}
}
