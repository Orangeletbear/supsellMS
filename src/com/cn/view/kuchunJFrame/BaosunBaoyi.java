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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.control.kuchunframe.baosunbaoyi.BSBY_AddShangPinAction;
import com.cn.control.kuchunframe.baosunbaoyi.BSBY_TimeChaXunAction;
import com.cn.control.kuchunframe.baosunbaoyi.BaoSunBaoYiShuJuLuRuAction;
import com.cn.control.kuchunframe.baosunbaoyi.ChaXunBaoSunBaoYiMouseListener;
import com.cn.control.kuchunframe.baosunbaoyi.TitleChangeAction;
import com.cn.control.kuchunframe.baosunbaoyi.XiuGaiBSBYShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.DeleteShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.JingBanRenAction;
import com.cn.dao.kuchun.baosunbaoyi.baosunbaoyichaxun.BaosunBaoyiChaXunGetDatas;
import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.BSBYModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.baosunbaoyi.BSBY_GaoJiChaXunDialog;
import com.cn.view.mainJFrame.MainFrame;

public class BaosunBaoyi extends JDialog {
	private MainFrame frame;//主窗口界面
	//报损
	private Vector vector1 = new Vector();
	//报溢
	private Vector vector2 = new Vector();
	//备注报损报溢
	private JLabel labelTitle ;
	private JComboBox comboDJLX1;//单据类型
	private JComboBox comboCKMC;//仓库名称
	private JLabel labelBSRQ; 

	private JDatePicker date1;//报损日期
	private JLabel labelDH ;//报损单号

	private JButton btnTJSP;//添加商品
	private JButton btnXGSP;//修改商品
	private JButton btnSCSP;//删除商品
	
	private DefaultTableModel tableModel1;
	private JTable tableBSBY1 ;
	private Vector ve1 = new Vector();//存放列名
	private Vector vo1 = new Vector();
	
	private JComboBox comboJBR;//经办人
	private JButton btnJBR;//经办人
	private JTextField textBZ = new JTextField(20);
	
	private JButton btnYes;
	private JButton btnNo;
	
	//报损报溢查询
	private JButton btnGJCX;
	private JButton btnCKDJ;
	private JButton btnDC;
	private JButton btnExit;
	private JButton btnCheck;
	private JComboBox comboDJLX2;//单据类型
	private JDatePicker dateFrom;//查询时间选择区
	private JDatePicker dateTo;//查询时间选择区
	
	private DefaultTableModel tableModel2;
	private JTable tableBSBY2 ;
	private Vector ve2 = new Vector();//存放列名
	private Vector vo2 = new Vector();

	private DefaultTableModel tableModel3;
	private JTable tableBSBY3 ;
	private Vector ve3 = new Vector();//存放列名
	private Vector vo3 = new Vector();
	
	private JLabel labelDJHJ;
	private JLabel labelNum1;
	private JLabel labelDJXX;
	private JLabel labelSPHJ;
	private JLabel labelNum2;
	
////////////////////////////////////////////
	
	public JComboBox getComboCKMC() {
		return comboCKMC;
	}
	public Vector getVector1() {
		return vector1;
	}
	public Vector getVector2() {
		return vector2;
	}
	public MainFrame getFrame() {
		return frame;
	}

	public JDatePicker getDate1() {
		return date1;
	}

	public JLabel getLabelDH() {
		return labelDH;
	}

	public JComboBox getComboJBR() {
		return comboJBR;
	}

	public JTextField getTextBZ() {
		return textBZ;
	}

	public JComboBox getComboDJLX2() {
		return comboDJLX2;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public void setComboDJLX1(JComboBox comboDJLX1) {
		this.comboDJLX1 = comboDJLX1;
	}
	
	public JLabel getLabelTitle() {
		return labelTitle;
	}
	
	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}

	public JTable getTableBSBY1() {
		return tableBSBY1;
	}

	public DefaultTableModel getTableModel2() {
		return tableModel2;
	}

	public JTable getTableBSBY2() {
		return tableBSBY2;
	}

	public DefaultTableModel getTableModel3() {
		return tableModel3;
	}

	public JTable getTableBSBY3() {
		return tableBSBY3;
	}

	public JComboBox getComboDJLX1() {
		return comboDJLX1;
	}
	
	public JLabel getLabelBSRQ() {
		return labelBSRQ;
	}
	
	public Vector getVe1() {
		return ve1;
	}
	public Vector getVo1() {
		return vo1;
	}
	public Vector getVe2() {
		return ve2;
	}
	public Vector getVo2() {
		return vo2;
	}
	public Vector getVe3() {
		return ve3;
	}
	public Vector getVo3() {
		return vo3;
	}
////////////////
	public BaosunBaoyi(MainFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame = frame;
		init();
		//设置报损编号
		{
			String num = DanJuHaoShuLiangGetDatas.baoSunNum();
			try {
				labelDH.setText("BS" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		createData1();
//		createData2(); //当数据库中无符合条件的数据时，会产生异常
		this.setVisible(true);
		
	}
	//数据初始化
	private void createData1(){
		vo2 = BaosunBaoyiChaXunGetDatas.danJuChaXun(labelDJXX.getText(),comboDJLX2.getSelectedItem().toString());
		tableModel2.setDataVector(vo2, ve2);
//		tableBSBY2.setRowSelectionInterval(0,0);
	}
	//调拨商品初始化
	private void createData2(){
		int row = tableBSBY2.getSelectedRow();
		vo3 = BaosunBaoyiChaXunGetDatas.shangPinChaXun(tableBSBY2.getValueAt(row, 0).toString(),
				comboDJLX2.getSelectedItem().toString());
		tableModel3.setDataVector(vo3, ve3);
		tableBSBY3.setRowSelectionInterval(0,0);
	}
	private void init(){
		this.setSize(900, 600);
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
		tabpanel.addTab("报损/报溢", addComBSBY());
		tabpanel.addTab("报损/报溢查询", addComBSBYCX());
		
		return tabpanel;
	}
	/*
	 * 库存调货单界面主面板
	 * 
	 */
	private JPanel addComBSBY(){
		JPanel jpanelBSBY = new JPanel();
		jpanelBSBY.setLayout(new BorderLayout());
		
		jpanelBSBY.add(addComBSBYNor(),BorderLayout.NORTH);
		jpanelBSBY.add(addComBSBYCen(),BorderLayout.CENTER);
		jpanelBSBY.add(addComBSBYSou(),BorderLayout.SOUTH);
		
		return jpanelBSBY;
	}
	/*
	 * 库存调拨单北部
	 * 
	 */
	private JPanel addComBSBYNor(){
		JPanel jpanelNor = new JPanel();
		labelTitle = new JLabel("商品报损");
		labelTitle.setFont(new Font("黑体",Font.BOLD,20));
		jpanelNor.add(labelTitle);
		return jpanelNor;
	}
	
	/*
	 * 报损报溢中部
	 */
	private JPanel addComBSBYCen(){
		JPanel jpanelCen = new JPanel();
		jpanelCen.setLayout(new BorderLayout());
		
		//添加信息栏面板
		JPanel jpanelCenNor = new JPanel();
		jpanelCenNor.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		comboDJLX1 = new JComboBox(BSBYModel.itemsDJLX);
		comboDJLX1.addActionListener(new TitleChangeAction(this)); 
		comboCKMC = new JComboBox(JDBCCuCunFind.getCanKuData());
		
		JLabel labelDJLX = new JLabel("单 据 类 型");
		JLabel labelCKMC = new JLabel("仓 库 名 称");
		labelBSRQ = new JLabel("报 损 日 期");
		date1 = new JDatePicker();
		date1.setEditable(false);
		JLabel label = new JLabel("单号:");
		labelDH = new JLabel("BS0510100022");
		labelDH.setForeground(Color.RED); 
		{
		jpanelCenNor.add(labelDJLX);
		jpanelCenNor.add(comboDJLX1);
		jpanelCenNor.add(labelCKMC);
		jpanelCenNor.add(comboCKMC);
		jpanelCenNor.add(labelBSRQ);
		jpanelCenNor.add(date1);
		jpanelCenNor.add(label);
		jpanelCenNor.add(labelDH);
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
		
		//给按钮添加监听器
		{
			XiuGaiBSBYShangPinAction xg = new XiuGaiBSBYShangPinAction(this);
			btnXGSP.addActionListener(xg);
			btnSCSP.addActionListener(new DeleteShangPinAction(this));
			btnTJSP.addActionListener(new BSBY_AddShangPinAction(this));
		}
		{
			jpanelCenCenNor.add(btnTJSP);
			jpanelCenCenNor.add(btnXGSP);
			jpanelCenCenNor.add(btnSCSP);
		}
		
		JPanel jpanelCenCenCen = new JPanel();
		
		vo1 = AllTableModel.getVectorDataFromObj(BSBYModel.dataBSBY1);
		ve1 = AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY1);
		tableModel1 = new AllTableModel(vo1,ve1);
		tableBSBY1 = new JTable(tableModel1);
		{
			tableBSBY1.addMouseListener(new XiuGaiBSBYShangPinAction(this));
		}
		tableBSBY1.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableBSBY1.setPreferredScrollableViewportSize(new Dimension(860,310));
		JScrollPane scroPane = new JScrollPane(tableBSBY1);
		jpanelCenCenCen.add(scroPane);
		
//		createTable(jpanelCenCenCen,tableBSBY1,tableModel1,BSBYModel.dataBSBY1,BSBYModel.colunmsBSBY1);
		
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
	 * 报损报溢南部
	 */
	private JPanel addComBSBYSou(){
		JPanel jpanelSou= new JPanel();
		jpanelSou.setLayout(new GridLayout(2,1));
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel labelJBR = new JLabel("经   办   人");
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
//		btnJBR = new JButton("…");
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
			btnYes.addActionListener(new BaoSunBaoYiShuJuLuRuAction(this));
		}
		btnNo = new JButton("取    消");
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BaosunBaoyi.this.dispose();
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
	 * 报损报溢查询界面主面板
	 * 
	 */
	
	private JPanel addComBSBYCX(){
		JPanel jpanelBSBYCX = new JPanel();
		jpanelBSBYCX.setLayout(new GridLayout(2,1));
		{
			jpanelBSBYCX.add(addUp());
			jpanelBSBYCX.add(addDown());
		}
		return jpanelBSBYCX;
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
		{
			btnGJCX.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new BSBY_GaoJiChaXunDialog(BaosunBaoyi.this,"报损报溢高级查询",true).setVisible(true);
				}
			});
		}
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
		JLabel labelDJLX = new JLabel("单 据 类 型");
		btnCheck = new JButton("查  询");
		{
			btnCheck.addActionListener(new BSBY_TimeChaXunAction(this));
		}
		comboDJLX2 = new JComboBox(BSBYModel.itemsDJLX);
		{
		    btnExit.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e) {
				    BaosunBaoyi.this.dispose();
			    }
		});
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
			upNorJpanel.add(labelDJLX);
			upNorJpanel.add(comboDJLX2);
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
		
		vo2 = AllTableModel.getVectorDataFromObj(BSBYModel.dataBSBY2);
		ve2 = AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY2);
		tableModel2 = new AllTableModel(vo2,ve2);
		tableBSBY2 = new JTable(tableModel2);
		tableBSBY2.requestFocus();
		{
			tableBSBY2.addMouseListener(new ChaXunBaoSunBaoYiMouseListener(this));
		}
		tableBSBY2.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableBSBY2.setPreferredScrollableViewportSize(new Dimension(870,130));
		JScrollPane scroPane = new JScrollPane(tableBSBY2);
		upCenJpanel.add(scroPane);
		
//		createTable(upCenJpanel,tableBSBY2,tableModel2,BSBYModel.dataBSBY2,BSBYModel.colunmsBSBY2);
		return upCenJpanel;
	}
	/*
	 * 上南部
	 * 
	 */
	private JPanel addUpSou(){
		JPanel upSouJpanel = new JPanel();
		upSouJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel label = new JLabel("单  据 合  计");
		labelDJHJ = new JLabel("",JLabel.LEFT);
		labelDJHJ.setForeground(Color.RED);
//		labelNum1 = new JLabel("      ",JLabel.RIGHT);
		{
			upSouJpanel.add(label);
			upSouJpanel.add(labelDJHJ);
//			upSouJpanel.add(labelNum1);
		}
		upSouJpanel.setBorder(new LineBorder(Color.lightGray,1));
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
		JLabel label = new JLabel("单 据 的 详 细 信 息 ：");
		labelDJXX = new JLabel("",JLabel.LEFT);
		labelDJXX.setForeground(Color.RED);
		downNorJpanel.add(label);
		downNorJpanel.add(labelDJXX);
		
		downNorJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return downNorJpanel;
	}
	/*
	 * 下中部
	 */
	private JPanel addDownCen(){
		JPanel downCenJpanel = new JPanel();
		vo3 = AllTableModel.getVectorDataFromObj(BSBYModel.dataBSBY3);
		ve3 = AllTableModel.getVectorFromObj(BSBYModel.colunmsBSBY3);
		tableModel3 = new AllTableModel(vo3,ve3);
		tableBSBY3 = new JTable(tableModel3);
		tableBSBY3.requestFocus();
		tableBSBY3.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableBSBY3.setPreferredScrollableViewportSize(new Dimension(870,180));
		JScrollPane scroPane = new JScrollPane(tableBSBY3);
		downCenJpanel.add(scroPane);
		
//		createTable(downCenJpanel,tableBSBY3,tableModel3,BSBYModel.dataBSBY3,BSBYModel.colunmsBSBY3);
		return downCenJpanel;
	}
	/*
	 * 下南部
	 */
	
	private JPanel addDownSou(){
		JPanel downSouJpanel = new JPanel();
		downSouJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel label = new JLabel("商品合计：");
		labelSPHJ = new JLabel("",JLabel.LEFT);
		labelSPHJ.setForeground(Color.RED);
//		labelNum2 = new JLabel("    ",JLabel.LEFT);
		{
			downSouJpanel.add(label);
			downSouJpanel.add(labelSPHJ);
//			downSouJpanel.add(labelNum2);
		}
		downSouJpanel.setBorder(new LineBorder(Color.BLACK,1));
		return downSouJpanel;
	}

	
//	测试===============================
	
	public static void main(String [] args){
		new BaosunBaoyi(null,"报损报溢",true);
	}
	public JButton getBtnCheck() {
		return btnCheck;
	}
	public JButton getBtnCKDJ() {
		return btnCKDJ;
	}
	public JButton getBtnDC() {
		return btnDC;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public JButton getBtnGJCX() {
		return btnGJCX;
	}
	public JButton getBtnJBR() {
		return btnJBR;
	}
	public JButton getBtnNo() {
		return btnNo;
	}
	public JButton getBtnSCSP() {
		return btnSCSP;
	}
	public JButton getBtnTJSP() {
		return btnTJSP;
	}
	public JButton getBtnXGSP() {
		return btnXGSP;
	}
	public JButton getBtnYes() {
		return btnYes;
	}
	public JLabel getLabelDJHJ() {
		return labelDJHJ;
	}
	public JLabel getLabelDJXX() {
		return labelDJXX;
	}
	public JLabel getLabelNum1() {
		return labelNum1;
	}
	public JLabel getLabelNum2() {
		return labelNum2;
	}
	public JLabel getLabelSPHJ() {
		return labelSPHJ;
	}
}