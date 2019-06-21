package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;

import com.cn.control.systemframe.sanpingxinxi.AddSPOKAcion;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.ChoiceSPLBAction;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;


/**
 * 增加商品信息对话框
 * @author finey
 *
 */
public class AddShangPingDialog extends JDialog {
	//商品类别
	JTextField spLeiBie = new JTextField(12);
	//商品编号
	JTextField spId = new JTextField(18);
	//商品名
	JTextField spName = new JTextField(18);
	//商品条码
	JTextField spTiaoMa = new JTextField(18);
	//商品规格
	JTextField spGuiGe = new JTextField(18);
	//商品单位
	JComboBox spDangWei = new JComboBox(SanPingGuanLiJDBC.getSPDanWei());
	//商品最低库存
	JTextField spKuChun = new JTextField(18);
	//商品颜色
	JComboBox  spColor = new JComboBox(SanPingGuanLiJDBC.getSPColor());
	//商品预设进价
	JTextField spJingPrice = new JTextField(18);
	//商品预设售价
	JTextField spShouPrice = new JTextField(18);
	
	//商品使用期限
	JCheckBox spUseDate = new JCheckBox("使用保质期");
	//商品保质期
	JTextField spBaoZhiQi = new JTextField(12);
	//商品生产厂商
	JTextField spProductor = new JTextField(18);
	//商品备注
	JTextField sp_bz = new JTextField(22);
	
	AllTableModel model ;
	//表格区
	JTable table2;
	//商品折扣
	JTextField spZheKou = new JTextField(12);
	JTextField spDuiHuanJiFen = new JTextField(12);
	
	JCheckBox spIsZhenPing = new JCheckBox("该商品可作为赠品");
	JCheckBox spIsTeJia = new JCheckBox("商品是特价商品");
	JCheckBox spFirstJiangZhang = new JCheckBox("商品初期建账");
	
	JRadioButton useNo = new JRadioButton("停用");
	JRadioButton useYes = new JRadioButton("可用",true);
	
	//商品特价
	JTextField spTejia = new JTextField(18);
	//会员特价
	JTextField spHuiYuanTejia = new JTextField(18);
	//商品有特价期限
	JCheckBox haveTeJia = new JCheckBox("该商品有特价期限");
	
	JDatePicker  dateFrom = new JDatePicker(
			JDatePicker.STYLE_CN_DATETIME);
	
	JDatePicker dateTo =  new JDatePicker(
			JDatePicker.STYLE_CN_DATETIME);
	
	
	public JTextField getSpTejia() {
		return spTejia;
	}

	public JTextField getSpHuiYuanTejia() {
		return spHuiYuanTejia;
	}

	public JCheckBox getHaveTeJia() {
		return haveTeJia;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public JTextField getSpLeiBie() {
		return spLeiBie;
	}

	public JTextField getSpId() {
		return spId;
	}

	public JTextField getSpName() {
		return spName;
	}

	public JTextField getSpTiaoMa() {
		return spTiaoMa;
	}

	public JTextField getSpGuiGe() {
		return spGuiGe;
	}

	public JComboBox getSpDangWei() {
		return spDangWei;
	}

	public JTextField getSpKuChun() {
		return spKuChun;
	}

	public JComboBox getSpColor() {
		return spColor;
	}

	public JTextField getSpJingPrice() {
		return spJingPrice;
	}

	public JTextField getSpShouPrice() {
		return spShouPrice;
	}

	public JCheckBox getSpUseDate() {
		return spUseDate;
	}

	public AllTableModel getModel() {
		return model;
	}

	public JTextField getSpBaoZhiQi() {
		return spBaoZhiQi;
	}

	public JTextField getSpProductor() {
		return spProductor;
	}

	public JTextField getSp_bz() {
		return sp_bz;
	}

	

	public JTable getTable2() {
		return table2;
	}

	public JTextField getSpZheKou() {
		return spZheKou;
	}

	public JTextField getSpDuiHuanJiFen() {
		return spDuiHuanJiFen;
	}

	public JCheckBox getSpIsZhenPing() {
		return spIsZhenPing;
	}

	public JCheckBox getSpIsTeJia() {
		return spIsTeJia;
	}

	public JCheckBox getSpFirstJiangZhang() {
		return spFirstJiangZhang;
	}

	public JRadioButton getUseNo() {
		return useNo;
	}

	public JRadioButton getUseYes() {
		return useYes;
	}

	
	public AddShangPingDialog(CaiGouJinHuo frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	
	public AddShangPingDialog(ShangPingGuangLiFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(700,500));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		//中心数据输入块
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //南方控制块
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		okBtn.addActionListener(new AddSPOKAcion(this));
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AddShangPingDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		JPanel leftPane = initLeftPane();
	
		JPanel rightPane = initRightPane();
		
		
		splitPane.setLeftComponent(leftPane);
		splitPane.setRightComponent(rightPane);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(0);
		
		pane.add(splitPane,BorderLayout.CENTER);
		return pane;
	}
	//左边面板
	private JPanel initLeftPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel leftUpPane = initLeftUpPane();
		JPanel leftDownPane = initLeftDownPane();
		
		pane.add(leftUpPane);
		pane.add(leftDownPane,BorderLayout.SOUTH);
		

		return pane;
	}
	//右边面板
	private JPanel initRightPane(){
		JPanel pane = new JPanel();
		pane.setBorder(new TitledBorder("已存商品"));
		pane.setLayout(new BorderLayout());
		
		model = new AllTableModel(GetFinallyMassage.obj,
				GetFinallyMassage.table2culomns);
		table2 = new JTable(model);
        table2.setPreferredScrollableViewportSize(new Dimension(230,400));
		table2.setAutoCreateRowSorter(true);
        
		pane.add(new JScrollPane(table2));
        return pane;
	}
	//左边的上面面板
	private JPanel initLeftUpPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(7,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("所属类别: ");
	    JButton choiceBtn = new JButton("选择类别");
	    choiceBtn.setMargin(new Insets(0,0,0,0));
	    spLeiBie.setText("选择类别");
	    spLeiBie.setEditable(false);
	    tmpPane.add(tmpLab);
	    tmpPane.add(spLeiBie);
	    tmpPane.add(choiceBtn);
	    
	    choiceBtn.addMouseListener(
	      new ChoiceSPLBAction(this,spLeiBie,true,spId));
	    
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品编号: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spId);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品名称: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spName);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品条码: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spTiaoMa);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("规格型号: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spGuiGe);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品单位: ");
	    spDangWei.setMaximumRowCount(4);
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDangWei);
	    JButton tmp = new JButton("单位");
	    tmpPane.add(tmp);
	    pane.add(tmpPane);
	    
	    tmp.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new DanWeiManager(AddShangPingDialog.this,"单位管理",true);
			}
	    	
	    });
	    
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("库存下限: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spKuChun);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品颜色: ");
	    tmpPane.add(tmpLab);
	    spColor.setMaximumRowCount(4);
	    tmpPane.add(spColor);
	    JButton color = new JButton("颜色");
	    tmpPane.add(color);
	    pane.add(tmpPane);
	    
	    color.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new ColorMessager(AddShangPingDialog.this,"颜色管理",true);
			}
	    	
	    });
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("预设进价: ");
	    spJingPrice.setText("0.0");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spJingPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("预设售价: ");
	    tmpPane.add(tmpLab);
	    spShouPrice.setText("0.0");
	    tmpPane.add(spShouPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("天 ");
	    tmpPane.add(spUseDate);
	    tmpPane.add(spBaoZhiQi);
	    tmpPane.add(tmpLab);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("生产厂商: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spProductor);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("备注: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(sp_bz);
	    
	    pane.add(tmpPane);
	    pane.setBorder(new TitledBorder("商品基本信息"));
		return pane;
	}
	//左边的下面面板
	private JPanel initLeftDownPane(){
		
		JPanel tabPane = new JPanel();
		tabPane.setLayout(new BorderLayout());
		JTabbedPane tbp = new JTabbedPane();
		
		JPanel pane1 = new JPanel();
		pane1.setLayout(new GridLayout(4,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("商品折扣: ");
	    tmpPane.add(tmpLab);
	    spZheKou.setText("1.0");
	    tmpPane.add(spZheKou);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("0.9为九折，1.0  为不打折 ");
	    tmpLab.setForeground(Color.red);
	    tmpPane.add(tmpLab);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spIsZhenPing);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("兑换积分: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDuiHuanJiFen);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spIsTeJia);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpLab = new JLabel("商品状态: ");
		ButtonGroup grop = new ButtonGroup();
		
		grop.add(useNo);
		grop.add(useYes);
		
	    tmpPane.add(tmpLab);
	    tmpPane.add(useNo);
	    tmpPane.add(useYes);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spFirstJiangZhang);
	    pane1.add(tmpPane);
	    

		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(3,2));
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("商品特价: ");
	    tmpPane.add(tmpLab);
	    spZheKou.setText("0.0");
	    tmpPane.add(spTejia);
	    pane2.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("会员特价: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spHuiYuanTejia);
	    pane2.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(haveTeJia);
	    pane2.add(tmpPane);
	 
	    pane2.add(new JLabel());
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("期限从: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(dateFrom);
	    pane2.add(tmpPane);
	    
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("至: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(dateTo);
	    pane2.add(tmpPane);
		
	    
	    
	    
	    tbp.add("其它信息",pane1);
	    tbp.add("特价信息",pane2);
	    
	    tabPane.add(tbp);
		return tabPane;
	}
	
	
	public static void main(String[] args) {
	}

}
