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
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.chaifenkunbang.CFKB_TanChuChaXunActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi.BaoZhuangSheZhiActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi.SPSZAddAction;
import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.ChaiFenShangPinActionLisenter;
import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.ChaiFenShuJuLuRuActions;
import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.ChaiFenShuLiangSheZhiDocumentListener;
import com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin.SPCF_AddShangPinAction;
import com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun.BiaoLieMingChangeActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.danjuchaxun.CFKB_DanJuChaXunActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin.KunBangShangPinActionListener;
import com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin.KunBangShuJuLuRuActions;
import com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin.KunBangShuLiangSheZhiDocumentListener;
import com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin.SPKB_AddShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.JingBanRenAction;
import com.cn.dao.kuchun.danjuhao.DanJuHaoShuLiangGetDatas;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.CFKBModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.chaifenkunbang.CFGaojiChaxunJDialog;
import com.cn.view.mainJFrame.MainFrame;

public class ChaifenKunbang extends JDialog {
	private MainFrame frame;
	
	//用于存储增加的商品
	//拆分
	private Vector vector1 = new Vector();
	//捆绑
	private Vector vector2 = new Vector();
	
	///////////////////////拆分商品
	private JTabbedPane tabpanel;//选项卡面板
	
	private JLabel labelSPCF ;//捆绑标题
	private JLabel labelCFDH;//拆分单号
	private JComboBox comboCFCK;//拆分仓库
	private JDatePicker date1;//日期
	private JTextField textBCSPBH;//被拆商品编号
	private JButton btnCX1;//查询
	private JTextField textCFSL;//拆分数量
	
	private JLabel labelBCSPMC1;//被拆商品名称
	private JLabel labelGGXH1;//规格型号
	private JLabel labelDW1;//单位
	private JLabel labelYS1;//颜色
	private JLabel labelDQKC1;//当前库存
	private JLabel labelCBJ1;//成本价
	private JLabel labelCFZE;//拆分总额
	
	private JButton btnAddSP1;//增加
	private JButton btnXGSP1;//修改
	private JButton btnSCSP1;//删除
	
	private AllTableModel tableModelCF;//拆分商品
	private JTable tableCF;//拆分商品
	private Vector ve1 = new Vector();//存列名
	private Vector vo1 = new Vector();
	
	private JComboBox comboJBR1;//经办人
	private JTextField textBZ1 ;//备注
	private JButton btnYes;//确定
	private JButton btnNo;//取消
	private JButton btnJBR1;
	
	/////////////////////////////捆绑商品
	
	private JLabel labelSPKB ;//捆绑标题
	private JLabel labelKBDH;//捆绑单号
	private JLabel labelGGXH2;//规格型号
	private JLabel labelDW2;//单位
	private JLabel labelYS2;//颜色
	private JLabel labelDQKC2;//当前库存
	private JLabel labelCBJ2;//成本价
	private JDatePicker date2;//日期
	private JButton btnCX2;//查询
	
	private JComboBox comboKBCK;//捆绑仓库
	private JTextField textKBSP;//捆绑成的商品
	private JTextField textKBSL;//捆绑数量
	private JLabel labelKBSP;//捆绑成的商品
	private JLabel labelKBZE;//捆绑总额
	private AllTableModel tableModelKB;//捆绑商品
	private JTable tableKB;//捆绑商品
	private Vector ve2 = new Vector();//存列名
	private Vector vo2 = new Vector();
	
	private JComboBox comboJBR2;//经办人
	private JTextField textBZ2 ;//备注
	private JButton btnAddSP2;//增加
	private JButton btnXGSP2;//修改
	private JButton btnSCSP2;//删除
	private JButton btnJBR2;//捆绑界面中的经办人
	private JButton btnSave;//保存
	private JButton btnExit;//退出
	
	/////////////////////包装设置
	private JButton btnZJ;//增加
	private JButton btnXG;//修改
	private JButton btnSC;//删除
	private JButton btnDC3;//导出
//	private JFileChooser fileChooser3;
	private JButton btnDY;//打印
	private JTextField textSPXX;//商品信息
	private JButton btnCX3;//查询
	private JButton btnExit3;//退出
	private JLabel labelHJ3;//合计
	private AllTableModel tableModelBZ;//捆绑商品
	private JTable tableBZ;//捆绑商品
	private Vector ve3 = new Vector();//存列名
	private Vector vo3 = new Vector();
	
	//////////////////////拆分/捆绑查询
	private JButton btnGJCX;
	private JButton btnCKDJ;
	private JButton btnDC4;
	private JButton btnExit4;
	private JTextField textSPBH;//查询选项卡的商品编号查询
	private JButton btnCheck;
	
	private JDatePicker dateFrom;//查询时间选择区
	private JDatePicker dateTo;//查询时间选择区
	private AllTableModel tableModel4;
	private JTable tableCFKB4 ;
	private Vector ve4 = new Vector();//存列名
	private Vector vo4 = new Vector();
	
	private JComboBox comboDJLX;
	
	private AllTableModel tableModel5;
	private JTable tableCFKB5 ;
	private Vector ve5 = new Vector();//存列名
	private Vector vo5 = new Vector();
	
	private JLabel labelDJHJ;
	private JLabel labelNum1;
	private JLabel labelDJXX;
	private JLabel labelSPHJ;
	private JLabel labelNum2;
	
//////////////////////

	public MainFrame getFrame() {
		return frame;
	}

	public Vector getVector1() {
		return vector1;
	}

	public Vector getVector2() {
		return vector2;
	}
	
	public JTable getTableBZ() {
		return tableBZ;
	}

	public JTabbedPane getTabpanel() {
		return tabpanel;
	}
	public JTable getTableCF() {
		return tableCF;
	}

	public JTable getTableCFKB4() {
		return tableCFKB4;
	}

	public JTable getTableCFKB5() {
		return tableCFKB5;
	}

	public JTable getTableKB() {
		return tableKB;
	}

	public AllTableModel getTableModel4() {
		return tableModel4;
	}

	public AllTableModel getTableModel5() {
		return tableModel5;
	}

	public AllTableModel getTableModelBZ() {
		return tableModelBZ;
	}

	public AllTableModel getTableModelCF() {
		return tableModelCF;
	}

	public AllTableModel getTableModelKB() {
		return tableModelKB;
	}

	public Vector getVe1() {
		return ve1;
	}

	public Vector getVe2() {
		return ve2;
	}

	public Vector getVe3() {
		return ve3;
	}

	public Vector getVe4() {
		return ve4;
	}
	public Vector setVe4() {
		return ve4;
	}
	public Vector getVe5() {
		return ve5;
	}

	public Vector getVo1() {
		return vo1;
	}

	public Vector getVo2() {
		return vo2;
	}

	public Vector getVo3() {
		return vo3;
	}

	public Vector getVo4() {
		return vo4;
	}

	public Vector getVo5() {
		return vo5;
	}
	
	public void setVo1(Vector vo1) {
		this.vo1 = vo1;
	}

	public void setVo2(Vector vo2) {
		this.vo2 = vo2;
	}

	public void setVo3(Vector vo3) {
		this.vo3 = vo3;
	}

	public void setVo4(Vector vo4) {
		this.vo4 = vo4;
	}

	public void setVo5(Vector vo5) {
		this.vo5 = vo5;
	}

	public JLabel getLabelCFDH() {
		return labelCFDH;
	}

	public JComboBox getComboCFCK() {
		return comboCFCK;
	}

	public JDatePicker getDate1() {
		return date1;
	}

	public JDatePicker getDate2() {
		return date2;
	}
	public JButton getBtnCX1() {
		return btnCX1;
	}
	public JButton getBtnCX2() {
		return btnCX2;
	}
	public JButton getBtnAddSP1() {
		return btnAddSP1;
	}

	public JButton getBtnXGSP1() {
		return btnXGSP1;
	}

	public JButton getBtnSCSP1() {
		return btnSCSP1;
	}

	public JComboBox getComboJBR1() {
		return comboJBR1;
	}

	public JTextField getTextBZ1() {
		return textBZ1;
	}

	public JComboBox getComboJBR2() {
		return comboJBR2;
	}

	public JTextField getTextBZ2() {
		return textBZ2;
	}
	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	public JButton getBtnJBR1() {
		return btnJBR1;
	}

	public JLabel getLabelKBDH() {
		return labelKBDH;
	}

	public JLabel getLabelGGXH2() {
		return labelGGXH2;
	}

	public JLabel getLabelDW2() {
		return labelDW2;
	}

	public JLabel getLabelYS2() {
		return labelYS2;
	}

	public JLabel getLabelDQKC2() {
		return labelDQKC2;
	}

	public JLabel getLabelCBJ2() {
		return labelCBJ2;
	}

	public JComboBox getComboKBCK() {
		return comboKBCK;
	}

	public JLabel getLabelKBSP() {
		return labelKBSP;
	}

	public JLabel getLabelKBZE() {
		return labelKBZE;
	}

	public JButton getBtnAddSP2() {
		return btnAddSP2;
	}

	public JButton getBtnXGSP2() {
		return btnXGSP2;
	}

	public JButton getBtnSCSP2() {
		return btnSCSP2;
	}

	public JButton getBtnJBR2() {
		return btnJBR2;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnZJ() {
		return btnZJ;
	}

	public JButton getBtnXG() {
		return btnXG;
	}

	public JButton getBtnSC() {
		return btnSC;
	}

	public JButton getBtnDC3() {
		return btnDC3;
	}

	public JButton getBtnDY() {
		return btnDY;
	}

	public JButton getBtnCX3() {
		return btnCX3;
	}

	public JButton getBtnExit3() {
		return btnExit3;
	}

	public JLabel getLabelHJ3() {
		return labelHJ3;
	}

	public JButton getBtnGJCX() {
		return btnGJCX;
	}

	public JButton getBtnCKDJ() {
		return btnCKDJ;
	}

	public JButton getBtnDC4() {
		return btnDC4;
	}

	public JButton getBtnExit4() {
		return btnExit4;
	}

	public JButton getBtnCheck() {
		return btnCheck;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public JComboBox getComboDJLX() {
		return comboDJLX;
	}

	public JLabel getLabelDJHJ() {
		return labelDJHJ;
	}

	public JLabel getLabelNum1() {
		return labelNum1;
	}

	public JLabel getLabelDJXX() {
		return labelDJXX;
	}

	public JLabel getLabelSPHJ() {
		return labelSPHJ;
	}

	public JLabel getLabelNum2() {
		return labelNum2;
	}

	/////////////////////////////////
	public JTextField getTextBCSPBH() {
		return textBCSPBH;
	}
//////////商品属性栏的label	
	public JLabel getLabelBCSPMC1() {
		return labelBCSPMC1;
	}

	public JLabel getLabelGGXH1() {
		return labelGGXH1;
	}

	public JLabel getLabelDW1() {
		return labelDW1;
	}

	public JLabel getLabelYS1() {
		return labelYS1;
	}

	public JLabel getLabelDQKC1() {
		return labelDQKC1;
	}

	public JLabel getLabelCBJ1() {
		return labelCBJ1;
	}

	public JLabel getLabelCFZE() {
		return labelCFZE;
	}

	public JTextField getTextCFSL() {
		return textCFSL;
	}

	public JTextField getTextKBSL() {
		return textKBSL;
	}

	public JTextField getTextKBSP() {
		return textKBSP;
	}

	public JTextField getTextSPXX() {
		return textSPXX;
	}
	
	public JLabel getLabelSPCF() {
		return labelSPCF;
	}

	public JLabel getLabelSPKB() {
		return labelSPKB;
	}
	
	public JTextField getTextSPBH() {
		return textSPBH;
	}

	public ChaifenKunbang(JDialog frame,String title,boolean b){
		super(frame,title,b);
		this.frame = (MainFrame)frame.getOwner();
		init();
		/*
		 * 设置拆分单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.chaiFenNum();
//			System.out.println(num);
			try {
				labelCFDH.setText("CF" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 设置捆绑单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.kunBangNum();
//			System.out.println(num);
			try {
				labelKBDH.setText("KB" + DateConventer.dateToStr(date2.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		this.setVisible(true);
	}
	
	public ChaifenKunbang(MainFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame = frame;
		init();
		/*
		 * 设置拆分单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.chaiFenNum();
//			System.out.println(num);
			try {
				labelCFDH.setText("CF" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 设置捆绑单据号
		 */
		{
			String num = DanJuHaoShuLiangGetDatas.kunBangNum();
//			System.out.println(num);
			try {
				labelKBDH.setText("KB" + DateConventer.dateToStr(date2.getSelectedDate(),"yyyyMMdd") 
						+ num);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JTabbedPane addCom(){
		tabpanel = new JTabbedPane();
		{
		tabpanel.addTab("拆分商品", addCom1());
		tabpanel.addTab("捆绑商品", addCom2());
		tabpanel.addTab("包装设置", addCom3());
		tabpanel.addTab("拆分/捆绑查询",addCom4());
		}
		return tabpanel;
	}
	
	
	private JPanel addCom1(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addNor1(),BorderLayout.NORTH);
			jpanel.add(addCen1(),BorderLayout.CENTER);
			jpanel.add(addSou1(),BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	/*
	 * 北部面板
	 * 
	 */
	private JPanel addNor1(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new GridLayout(3,1));
		
		{
			norJpanel.add(addNor11());
			norJpanel.add(addNor12());
			norJpanel.add(addNor13());
		}
		
		return norJpanel;
	}
	
	private JPanel addNor11(){
		JPanel norJpanel1 = new JPanel();
		norJpanel1.setLayout(new GridLayout(2,1));
		JPanel norJpanel11 = new JPanel();
		JPanel norJpanel12 = new JPanel();
		
		//norJpanel1面板
		labelSPCF = new JLabel("商  品  拆  分");
		labelSPCF.setFont(new Font("黑体",Font.BOLD,20)); 
		norJpanel11.add(labelSPCF);
		
		//norJpanel2面板
		norJpanel12.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
		JLabel label1 = new JLabel("商品拆分把库存中已有的某种商品拆分成几种商品",JLabel.LEFT);
		labelCFDH = new JLabel("CF40001",JLabel.RIGHT);
		JLabel label2 = new JLabel("单  号：");
		labelCFDH.setForeground(Color.RED);
		
		{
			norJpanel12.add(label1);
			norJpanel12.add(label2);
			norJpanel12.add(labelCFDH);
		}
		
		{
			norJpanel1.add(norJpanel11);
			norJpanel1.add(norJpanel12);
		}
		
		norJpanel1.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel1;
	}
	
	private JPanel addNor12(){
		JPanel norJpanel2 = new JPanel();
		norJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,3,5));
		JLabel label1 = new JLabel("拆分仓库：");
		JLabel label2 = new JLabel("拆分日期:");
		JLabel label3 = new JLabel("被拆商品编号");
		JLabel label4 = new JLabel("拆分数量");
		
		comboCFCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		date1 = new JDatePicker();
		date1.setEditable(false);
		date1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				/*
				 * 设置拆分单据号
				 */
					String num = DanJuHaoShuLiangGetDatas.chaiFenNum();
//					System.out.println(num);
					try {
						labelCFDH.setText("CF" + DateConventer.dateToStr(date1.getSelectedDate(),"yyyyMMdd") 
								+ num);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
		});
		textBCSPBH = new JTextField(10);//需要增加监听器
		/*
		 * 自动弹出监听器还有待改进
		 */
//		{
//			textBCSPBH.getDocument().addDocumentListener(new CFTextDocumentListener(this));
//		}
//		textBCSPBH.setText("CF1010005");
		btnCX1 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX1.setMargin(new Insets(-8,-6,-8,-6));
		{
			btnCX1.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		
		textCFSL = new JTextField(10);
		textCFSL.setText("5");
		{
			textCFSL.getDocument().addDocumentListener(new ChaiFenShuLiangSheZhiDocumentListener(this));
		}
		
		{
			norJpanel2.add(label1);
			norJpanel2.add(comboCFCK);
			norJpanel2.add(label2);
			norJpanel2.add(date1);
			norJpanel2.add(label3);
			norJpanel2.add(textBCSPBH);
			norJpanel2.add(btnCX1);
			norJpanel2.add(label4);
			norJpanel2.add(textCFSL);
			
		}
		norJpanel2.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel2;
	}
	
	/*
	 * 商品属性栏
	 */
	private JPanel addNor13(){
		JPanel norJpanel3 = new JPanel();
		norJpanel3.setLayout(new GridLayout(2,1));
		
		JPanel norJpanel31 = new JPanel();
		JPanel norJpanel32 = new JPanel();
		norJpanel31.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		norJpanel32.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JLabel label1 = new JLabel("被拆商品名称：");
		JLabel label2 = new JLabel("规格型号：");
		JLabel label3 = new JLabel("单  位：");
		JLabel label4 = new JLabel("颜  色：");
		JLabel label0 = new JLabel();
		label0.setPreferredSize(new Dimension(205,20));
		JLabel label5 = new JLabel("当前库存：");
		JLabel label6 = new JLabel("成本价：");
		JLabel label7 = new JLabel("拆分总额：");
		
		labelBCSPMC1 = new JLabel();
		labelBCSPMC1.setPreferredSize(new Dimension(100,20));
		labelBCSPMC1.setForeground(Color.RED);
		labelGGXH1 = new JLabel();
		labelGGXH1.setPreferredSize(new Dimension(60,20));
		labelDW1 = new JLabel();
		labelDW1.setPreferredSize(new Dimension(60,20));
		labelYS1 = new JLabel();
		labelYS1.setPreferredSize(new Dimension(60,20));
		labelDQKC1 = new JLabel();
		labelDQKC1.setForeground(Color.RED);
		labelDQKC1.setPreferredSize(new Dimension(60,20));
		labelCBJ1 = new JLabel("  0");
		labelCBJ1.setPreferredSize(new Dimension(55,20));
		labelCFZE = new JLabel("  0");
		labelCFZE.setPreferredSize(new Dimension(60,20));
		{
			norJpanel31.add(label1);
			norJpanel31.add(labelBCSPMC1);
			norJpanel31.add(label2);
			norJpanel31.add(labelGGXH1);
			norJpanel31.add(label3);
			norJpanel31.add(labelDW1);
			norJpanel31.add(label4);
			norJpanel31.add(labelYS1);
			
			norJpanel32.add(label0);
			norJpanel32.add(label5);
			norJpanel32.add(labelDQKC1);
			norJpanel32.add(label6);
			norJpanel32.add(labelCBJ1);
			norJpanel32.add(label7);
			norJpanel32.add(labelCFZE);
		}
		
		norJpanel3.add(norJpanel31);
		norJpanel3.add(norJpanel32);
		norJpanel3.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel3;
	}
	
	/*
	 * 中部面板
	 * 
	 */
	private JPanel addCen1(){
		JPanel cenJpanel = new JPanel();
		cenJpanel.setLayout(new BorderLayout());
		
		JPanel cenJpanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,30,5));
		JPanel cenJpanel2 = new JPanel();
		
		btnAddSP1 = new JButton("添加商品");
		btnXGSP1 = new JButton("修改商品");
		btnSCSP1 = new JButton("删除商品");
		{
			btnAddSP1.addActionListener(new SPCF_AddShangPinAction(this));
			ChaiFenShangPinActionLisenter lis = new ChaiFenShangPinActionLisenter(this);
			btnSCSP1.addActionListener(lis);
			btnXGSP1.addActionListener(lis);
		}
		{
			cenJpanel1.add(btnAddSP1);
			cenJpanel1.add(btnXGSP1);
			cenJpanel1.add(btnSCSP1);
		}
		
		vo1 = AllTableModel.getVectorDataFromObj(CFKBModel.dataCFKB1);
		ve1 = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB1);
		tableModelCF = new AllTableModel(vo1,ve1);
		tableCF = new JTable(tableModelCF);
		tableCF.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableCF.addMouseListener(new ChaiFenShangPinActionLisenter(this));
		tableCF.setPreferredScrollableViewportSize(new Dimension(780,310));
		JScrollPane scroPane = new JScrollPane(tableCF);
		cenJpanel2.add(scroPane);
		
//		createTable(cenJpanel2,tableCF,tableModelCF,CFKBModel.dataCFKB1,CFKBModel.colunmsCFKB1);
		
		{
		cenJpanel.add(cenJpanel1,BorderLayout.NORTH);
		cenJpanel.add(cenJpanel2,BorderLayout.CENTER);
		}
		cenJpanel.setBorder(new TitledBorder(new LineBorder(Color.gray,1),"拆分成的商品列表"));
		return cenJpanel;
	}
	
	/*
	 * 南部面板
	 * 
	 */
	private JPanel addSou1(){
		JPanel souJpanel = new JPanel();
		
//		JPanel jpanelSou= new JPanel();
		souJpanel.setLayout(new GridLayout(2,1));
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel labelJBR = new JLabel("经   办   人");
		comboJBR1 = new JComboBox(POSJDBC.getAllWorker());
		comboJBR1.setPreferredSize(new Dimension(80,30));
		
//		btnJBR1 = new JButton("...");
//		btnJBR1.addActionListener(new JingBanRenAction(this));
		
		JLabel labelBZ = new JLabel("备      注");
		textBZ1 = new JTextField(20);
		
		{
			jpanel1.add(labelJBR);
			jpanel1.add(comboJBR1);
//			jpanel1.add(btnJBR1);
			jpanel1.add(labelBZ);
			jpanel1.add(textBZ1);
		}
		
		JPanel jpanel2 = new JPanel(); 
		jpanel2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
		btnYes = new JButton("确     定(F4)");
		{
			btnYes.addActionListener(new ChaiFenShuJuLuRuActions(this));
		}
		
		btnNo = new JButton("取    消(F5)");
		
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ChaifenKunbang.this.dispose();
			}
		});
		{
			jpanel2.add(btnYes);
			jpanel2.add(btnNo);
		}
		{
			souJpanel.add(jpanel1);
			souJpanel.add(jpanel2);
		}
		souJpanel.setBorder(new LineBorder(Color.lightGray,1));
		
		return souJpanel;
	}
	
	///////////////////////////////////第二个选项卡：捆绑商品
	
	private JPanel addCom2(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		{
			jpanel.add(addNor2(),BorderLayout.NORTH);
			jpanel.add(addCen2(),BorderLayout.CENTER);
			jpanel.add(addSou2(),BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	/*
	 * 北部面板
	 * 
	 */
	private JPanel addNor2(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new GridLayout(3,1));
		
		{
			norJpanel.add(addNor21());
			norJpanel.add(addNor22());
			norJpanel.add(addNor23());
		}
		
		return norJpanel;
	}
	
	private JPanel addNor21(){
		JPanel norJpanel1 = new JPanel();
		norJpanel1.setLayout(new GridLayout(2,1));
		JPanel norJpanel11 = new JPanel();
		JPanel norJpanel12 = new JPanel();
		
		//norJpanel1面板
		labelSPKB = new JLabel("商  品  捆  绑");
		labelSPKB.setFont(new Font("黑体",Font.BOLD,20)); 
		norJpanel11.add(labelSPKB);
		
		//norJpanel2面板
		norJpanel12.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
		JLabel label1 = new JLabel("商品捆绑把库存中已有的几种商品捆绑成其他某种商品！",JLabel.LEFT);
		
		JLabel label2 = new JLabel("单  号：");
		labelKBDH = new JLabel("",JLabel.RIGHT);
		labelKBDH.setForeground(Color.RED);
		
		{
			norJpanel12.add(label1);
			norJpanel12.add(label2);
			norJpanel12.add(labelKBDH);
		}
		
		{
			norJpanel1.add(norJpanel11);
			norJpanel1.add(norJpanel12);
		}
		
		norJpanel1.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel1;
	}
	/*
	 * 
	 */
	private JPanel addNor22(){
		JPanel norJpanel2 = new JPanel();
		norJpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,3,5));
		JLabel label1 = new JLabel("捆绑仓库：");
		JLabel label2 = new JLabel("捆绑日期:");
		JLabel label3 = new JLabel("捆绑成的商品");
		JLabel label4 = new JLabel("捆绑数量");
		
		comboKBCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		date2 = new JDatePicker();
		date2.setEditable(false);
		date2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				/*
				 * 设置拆分单据号
				 */
					String num = DanJuHaoShuLiangGetDatas.kunBangNum();
//					System.out.println(num);
					try {
						labelKBDH.setText("KB" + DateConventer.dateToStr(date2.getSelectedDate(),"yyyyMMdd") 
								+ num);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
		});
		textKBSP = new JTextField(10);
//		textKBSP.setText("KB1010005");
	
		btnCX2 = new JButton(new ImageIcon("res/AcionIcon/check.jpg"));
		btnCX2.setMargin(new Insets(-8,-6,-8,-6));
		{
			btnCX2.addActionListener(new CFKB_TanChuChaXunActionListener(this));
		}
		
		textKBSL = new JTextField(10);
		textKBSL.setText("5");
		{
			textKBSL.getDocument().addDocumentListener(new KunBangShuLiangSheZhiDocumentListener(this));
		}
		{
			norJpanel2.add(label1);
			norJpanel2.add(comboKBCK);
			norJpanel2.add(label2);
			norJpanel2.add(date2);
			norJpanel2.add(label3);
			norJpanel2.add(textKBSP);
			norJpanel2.add(btnCX2);
			norJpanel2.add(label4);
			norJpanel2.add(textKBSL);
			
		}
		norJpanel2.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel2;
	}
	
	/*
	 * 商品属性栏
	 */
	private JPanel addNor23(){
		JPanel norJpanel3 = new JPanel();
		norJpanel3.setLayout(new GridLayout(2,1));
		
		JPanel norJpanel31 = new JPanel();
		JPanel norJpanel32 = new JPanel();
		norJpanel31.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		norJpanel32.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JLabel label1 = new JLabel("捆绑成的商品：");
		JLabel label2 = new JLabel("规格型号：");
		JLabel label3 = new JLabel("单  位：");
		JLabel label4 = new JLabel("颜  色：");
		JLabel label0 = new JLabel();
		label0.setPreferredSize(new Dimension(200,20));
		JLabel label5 = new JLabel(" 当前库存：");
		JLabel label6 = new JLabel(" 成本价：");
		JLabel label7 = new JLabel("捆绑总额：");
		
		labelKBSP = new JLabel();
		labelKBSP.setForeground(Color.RED);
		labelKBSP.setPreferredSize(new Dimension(100,20));
		labelGGXH2 = new JLabel();
		labelGGXH2.setPreferredSize(new Dimension(60,20));
		labelDW2 = new JLabel();
		labelDW2.setPreferredSize(new Dimension(60,20));
		labelYS2 = new JLabel();
		labelYS2.setPreferredSize(new Dimension(60,20));
		labelDQKC2 = new JLabel();
		labelDQKC2.setForeground(Color.RED);
		labelDQKC2.setPreferredSize(new Dimension(50,20));
		labelCBJ2 = new JLabel("0.0");
		labelCBJ2.setPreferredSize(new Dimension(50,20));
		labelKBZE = new JLabel("0");
		labelKBZE.setPreferredSize(new Dimension(60,20));
		
		{
			norJpanel31.add(label1);
			norJpanel31.add(labelKBSP);
			norJpanel31.add(label2);
			norJpanel31.add(labelGGXH2);
			norJpanel31.add(label3);
			norJpanel31.add(labelDW2);
			norJpanel31.add(label4);
			norJpanel31.add(labelYS2);
			
			norJpanel32.add(label0);
			norJpanel32.add(label5);
			norJpanel32.add(labelDQKC2);
			norJpanel32.add(label6);
			norJpanel32.add(labelCBJ2);
			norJpanel32.add(label7);
			norJpanel32.add(labelKBZE);
		}
		
		norJpanel3.add(norJpanel31);
		norJpanel3.add(norJpanel32);
		norJpanel3.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel3;
	}
	
	/*
	 * 中部面板
	 * 
	 */
	private JPanel addCen2(){
		JPanel cenJpanel = new JPanel();
		cenJpanel.setLayout(new BorderLayout());
		
		JPanel cenJpanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,30,5));
		JPanel cenJpanel2 = new JPanel();
		
		btnAddSP2 = new JButton("添加商品");
		btnXGSP2 = new JButton("修改商品");
		btnSCSP2 = new JButton("删除商品");
		{
			btnAddSP2.addActionListener(new SPKB_AddShangPinAction(this));
			KunBangShangPinActionListener lis = new KunBangShangPinActionListener(this);
			btnXGSP2.addActionListener(lis);
			btnSCSP2.addActionListener(lis);
		}
		{
			cenJpanel1.add(btnAddSP2);
			cenJpanel1.add(btnXGSP2);
			cenJpanel1.add(btnSCSP2);
		}
		
		vo2 = AllTableModel.getVectorDataFromObj(CFKBModel.dataCFKB2);
		ve2 = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB2);
		tableModelKB = new AllTableModel(vo2,ve2);
		tableKB = new JTable(tableModelKB);
		{
			tableKB.addMouseListener(new KunBangShangPinActionListener(this));
		}
		tableKB.setAutoCreateRowSorter(true); //此语句让表格自动排序
//		tableKB.addMouseListener(new KCPD_ChaXunShangPinMouseListener(this));
		tableKB.setPreferredScrollableViewportSize(new Dimension(780,310));
		JScrollPane scroPane = new JScrollPane(tableKB);
		cenJpanel2.add(scroPane);
		
//		createTable(cenJpanel2,tableKB,tableModelKB,CFKBModel.dataCFKB2,CFKBModel.colunmsCFKB2);

		{
		cenJpanel.add(cenJpanel1,BorderLayout.NORTH);
		cenJpanel.add(cenJpanel2,BorderLayout.CENTER);
		}
		cenJpanel.setBorder(new TitledBorder(new LineBorder(Color.gray,1),"捆绑成的商品列表"));
		return cenJpanel;
	}
	
	/*
	 * 南部面板
	 * 
	 */
	private JPanel addSou2(){
		JPanel souJpanel = new JPanel();
		
		souJpanel.setLayout(new GridLayout(2,1));
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		JLabel labelJBR = new JLabel("经   办   人");
//		btnJBR2 = new JButton("...");
//		btnJBR2.addActionListener(new JingBanRenAction(this));
		
		comboJBR2 = new JComboBox(POSJDBC.getAllWorker());
		comboJBR2.setPreferredSize(new Dimension(80,30));
		JLabel labelBZ = new JLabel("备      注");
		textBZ2 = new JTextField(20);
		{
			jpanel1.add(labelJBR);
			jpanel1.add(comboJBR2);
//			jpanel1.add(btnJBR2);
			jpanel1.add(labelBZ);
			jpanel1.add(textBZ2);
		}
		
		JPanel jpanel2 = new JPanel(); 
		jpanel2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
		btnSave = new JButton("保 存(F4)");
		{
			btnSave.addActionListener(new KunBangShuJuLuRuActions(this));
		}
		btnExit = new JButton("退 出(F5)");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ChaifenKunbang.this.dispose();
			}
		});
		{
			jpanel2.add(btnSave);
			jpanel2.add(btnExit);
		}
		{
			souJpanel.add(jpanel1);
			souJpanel.add(jpanel2);
		}
		souJpanel.setBorder(new LineBorder(Color.lightGray,1));
		
		return souJpanel;
	}
	
	////////////////////////面板三：包装设置
	
	private JPanel addCom3(){
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new BorderLayout());
		{
			jpanel3.add(addNor3(),BorderLayout.NORTH);
			jpanel3.add(addCen3(),BorderLayout.CENTER);
			jpanel3.add(addSou3(),BorderLayout.SOUTH);
		}
		return jpanel3;
	}
	
	/*
	 * 北部面板
	 * 
	 */
	private JPanel addNor3(){
		JPanel norJpanel3 = new JPanel();
		norJpanel3.setLayout(new GridLayout(2,1));
		
		JPanel norJpanel31 = new JPanel();
		norJpanel31.setLayout(new GridLayout(1,2));
		JPanel norJpanel32 = new JPanel();
		
		JPanel norJpanel311 = new JPanel();
		norJpanel311.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		btnZJ = new JButton(new ImageIcon("res/AcionIcon/add.jpg"));
		btnZJ.setMargin(new Insets(-2,-2,-2,-2));
		btnXG = new JButton(new ImageIcon("res/AcionIcon/atler.jpg"));
		btnXG.setMargin(new Insets(-2,-2,-2,-2));
		btnSC = new JButton(new ImageIcon("res/AcionIcon/delete.jpg"));
		btnSC.setMargin(new Insets(-2,-2,-2,-2));
		btnDC3 = new JButton(new ImageIcon("res/AcionIcon/import.jpg"));
		btnDC3.setMargin(new Insets(-2,-2,-2,-2));
		btnDY = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		btnDY.setMargin(new Insets(-2,-2,-2,-2));
		btnCX3 = new JButton(new ImageIcon("查  询(F2)"));
		btnExit3 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit3.setMargin(new Insets(-2,-2,-2,-2));
		{
			SPSZAddAction lis = new SPSZAddAction(this);
			btnZJ.addActionListener(lis);
			btnXG.addActionListener(lis);
			btnSC.addActionListener(new BaoZhuangSheZhiActionListener(this));
			btnExit3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					ChaifenKunbang.this.dispose();
				}
			});
			
			btnDC3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser file3 = new JFileChooser("D:/workspace");
					file3.showSaveDialog(ChaifenKunbang.this);
				}
			});
			
		}
		
		textSPXX = new JTextField(20);
		
		{
			norJpanel311.add(btnZJ);
			norJpanel311.add(btnXG);
			norJpanel311.add(btnSC);
			norJpanel311.add(btnDC3);
			norJpanel311.add(btnDY);
			norJpanel311.add(btnExit3);
		}
		
		JPanel norJpanel312 = new JPanel();
		norJpanel312.setLayout(new GridLayout(3,1));
		norJpanel312.setForeground(Color.RED);
		JLabel label1 = new JLabel("说明：此功能用来商品的自动拆分。例如：一条香烟(1)");
		label1.setForeground(Color.RED);
		JLabel label2 = new JLabel("=10包香烟(2),则设置后，在商品销售时，如果(2)不足，");
		label2.setForeground(Color.RED);
		JLabel label3 = new JLabel("则会自动拆分成(1)。如果(1)不足，(2)则不会自动捆绑成(1)。");
		label3.setForeground(Color.RED);
		
		norJpanel32.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label4 = new JLabel("商 品 编 号：");
		textSPXX = new JTextField(20);
		btnCX3 = new JButton("查  询");
		
		{
			norJpanel312.add(label1);
			norJpanel312.add(label2);
			norJpanel312.add(label3);
		}
		{
			norJpanel31.add(norJpanel311);
			norJpanel31.add(norJpanel312);
		}
		{
			norJpanel32.add(label4);
			norJpanel32.add(textSPXX);
			norJpanel32.add(btnCX3);
		}
		{
			norJpanel3.add(norJpanel31);
			norJpanel3.add(norJpanel32);
		}
		norJpanel3.setBorder(new LineBorder(Color.lightGray,1));
		return norJpanel3;
	}
	
	/*
	 * 中部面板
	 * 
	 */
	private JPanel addCen3(){
		JPanel cenJpanel3 = new JPanel();
		
		vo3 = AllTableModel.getVectorDataFromObj(CFKBModel.dataCFKB3);
		ve3 = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB3);
		tableModelBZ = new AllTableModel(vo3,ve3);
		tableBZ = new JTable(tableModelBZ);
		tableBZ.setAutoCreateRowSorter(true); //此语句让表格自动排序
//		tableBZ.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tableBZ.addMouseListener(new KCPD_ChaXunShangPinMouseListener(this));
		tableBZ.setPreferredScrollableViewportSize(new Dimension(780,310));
		JScrollPane scroPane = new JScrollPane(tableBZ);
		cenJpanel3.add(scroPane);
		
//		createTable(cenJpanel3,tableBZ,tableModelBZ,CFKBModel.dataCFKB3,CFKBModel.colunmsCFKB3);
		return cenJpanel3;
	}
	
	/*
	 * 南部面板
	 * 
	 */
	private JPanel addSou3(){
		JPanel souJpanel3 = new JPanel();
		souJpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel label = new JLabel("合计：");
		labelHJ3 = new JLabel("");
		souJpanel3.add(label);
		souJpanel3.add(labelHJ3);
		return souJpanel3;
	}
	
	////////////////////////第四个选项卡:拆分/捆绑查询
	/**
	 * 包装捆绑查询查询界面主面板
	 * 
	 */
	
	private JPanel addCom4(){
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
		upNorJpanel.setLayout(new GridLayout(1,2));
		
		JPanel upNorJpanel1 = new JPanel();
		JPanel upNorJpanel2 = new JPanel();
		
		upNorJpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		btnGJCX = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
		btnGJCX.setMargin(new Insets(-2,-2,-2,-2));
		btnCKDJ = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		btnCKDJ.setMargin(new Insets(-2,-2,-2,-2));
		btnDC4 = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		btnDC4.setMargin(new Insets(-2,-2,-2,-2));
		btnExit4 = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		btnExit4.setMargin(new Insets(-2,-2,-2,-2));
		{
			btnGJCX.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new CFGaojiChaxunJDialog(ChaifenKunbang.this,"高级查询",true);
				}
			});
			
			btnDC4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser file4 = new JFileChooser("D:/workspace");
					file4.showOpenDialog(ChaifenKunbang.this);
				}
			});	
				
			btnExit4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					ChaifenKunbang.this.dispose();
				}
			});
		}
		JLabel label1 = new JLabel("调拨时间");
		dateFrom = new JDatePicker();
		dateFrom.setEditable(false);
		JLabel label2 = new JLabel("   至    ");
		dateTo = new JDatePicker();
		dateTo.setEditable(false);
		JLabel labelDJLX = new JLabel("单据类型");
		JLabel label3 = new JLabel("商品编号：");
		textSPBH = new JTextField(6);
		textSPBH.setPreferredSize(new Dimension(60,20));
		btnCheck = new JButton("查  询");
		btnCheck.setPreferredSize(new Dimension(70,20));
		{
			btnCheck.addActionListener(new CFKB_DanJuChaXunActionListener(this));
		}
		comboDJLX = new JComboBox(CFKBModel.itemsDJLX);
		comboDJLX.addActionListener(new BiaoLieMingChangeActionListener(this));
		{
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					ChaifenKunbang.this.dispose();
				}
			});
		}
		{
			upNorJpanel1.add(btnGJCX);
			upNorJpanel1.add(btnCKDJ);
			upNorJpanel1.add(btnDC4);
			upNorJpanel1.add(btnExit4);
			
		}
		{
			upNorJpanel2.setLayout(new GridLayout(2,1));
			JPanel upNorJpanel21 = new JPanel();
			upNorJpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
			JPanel upNorJpanel22 = new JPanel();
			upNorJpanel22.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
			
			upNorJpanel21.add(label1);
			upNorJpanel21.add(dateFrom);
			upNorJpanel21.add(label2);
			upNorJpanel21.add(dateTo);
			
			upNorJpanel22.add(labelDJLX);
			upNorJpanel22.add(comboDJLX);
			upNorJpanel22.add(label3);
			upNorJpanel22.add(textSPBH);
			upNorJpanel22.add(btnCheck);
			
			upNorJpanel2.add(upNorJpanel21);
			upNorJpanel2.add(upNorJpanel22);
		}
		
		{
			upNorJpanel.add(upNorJpanel1);
			upNorJpanel.add(upNorJpanel2);
		}
		upNorJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return upNorJpanel;
	}
	/*
	 * 上中部
	 */
	private JPanel addUpCen(){
		JPanel upCenJpanel = new JPanel();
 
		ve4 = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB4);
		vo4 = AllTableModel.getVectorDataFromObj(CFKBModel.dataCFKB4);
		
		tableModel4 = new AllTableModel(vo4,ve4);
		tableCFKB4 = new JTable(tableModel4);
		tableCFKB4.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableCFKB4.getColumnModel().getColumn(0).setPreferredWidth(150);
//		tableCFKB4.getColumnModel().getColumn(0).setPreferredWidth(120);设置列宽
		tableCFKB4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		{
			tableCFKB4.addMouseListener(new CFKB_DanJuChaXunActionListener(this));
		}
		tableCFKB4.setPreferredScrollableViewportSize(new Dimension(780,120));
		JScrollPane scroPane = new JScrollPane(tableCFKB4);
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
		JLabel label = new JLabel("单据合计：");
		labelDJHJ = new JLabel("",JLabel.LEFT);
		labelDJHJ.setForeground(Color.RED);
		labelDJHJ.setSize(80, 15);
		labelNum1 = new JLabel("      ",JLabel.RIGHT);
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
		JLabel label = new JLabel("单据的详细信息：");
		labelDJXX = new JLabel("" ,JLabel.LEFT);
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
		
		vo5 = AllTableModel.getVectorDataFromObj(CFKBModel.dataCFKB5);
		ve5 = AllTableModel.getVectorFromObj(CFKBModel.colunmsCFKB5);
		tableModel5 = new AllTableModel(vo5,ve5);
		tableCFKB5 = new JTable(tableModel5);
		tableCFKB5.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableCFKB5.getColumnModel().getColumn(0).setPreferredWidth(150);
//		tableCFKB5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tableBZ.addMouseListener(new KCPD_ChaXunShangPinMouseListener(this));
		tableCFKB5.setPreferredScrollableViewportSize(new Dimension(780,180));
		JScrollPane scroPane = new JScrollPane(tableCFKB5);
		downCenJpanel.add(scroPane);
		
//		createTable(downCenJpanel,tableCFKB5,tableModel5,CFKBModel.dataCFKB5,CFKBModel.colunmsCFKB5);
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
//		labelNum2 = new JLabel("",JLabel.LEFT);
		{
			downSouJpanel.add(label);
			downSouJpanel.add(labelSPHJ);
//			downSouJpanel.add(labelNum2);
		}
		downSouJpanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		return downSouJpanel;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new ChaifenKunbang(null,"拆分捆绑",true).setVisible(true);
	}
}
