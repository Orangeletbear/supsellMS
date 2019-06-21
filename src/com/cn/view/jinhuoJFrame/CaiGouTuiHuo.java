package com.cn.view.jinhuoJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.jinhuoframe.caigoujinhuo.main.OKBtnActionListener;
import com.cn.control.jinhuoframe.caigoutuihuo.TuiHuoMainOKBtnListener;
import com.cn.dao.jinhuo.JinBanRenJDBC;
import com.cn.dao.jinhuo.caigoudanju.JDBCCaiGouDanJu;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCWangLaiZhangWu;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.columnName.CaiGouTuiHuoColumn;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo.GongHuoShangJDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo.TuiHuoShangPin;

public class CaiGouTuiHuo extends JDialog{
	/*
	 * 父窗口
	 */
	private JFrame frame;
	/*
	 * 根据构造器的不同要设置这个panel是否可见
	 */
	private JPanel center1 = new JPanel();
	private JLabel danhao ;
	//caiGouJinHuo 组件
		//放大镜
	JButton cha = new JButton(new ImageIcon("res/AcionIcon/cha.jpg"));
	private JTextField gongHuoShang = new JTextField(20);
	private JComboBox chuHuoCangKu = new JComboBox(JDBCCuCunFind.getCanKuData());
	//	时间
	private JDatePicker tuiHuoRiQi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	private JButton tianJiaTuiHuoShangpin = new JButton("添加退货商品(F2)");
	
//	表是一个蛋疼的问题
	private JTable table;
	private AllTableModel ATM;
	private Vector caiGouTuiHuo_data = new Vector();//用来存表中data
	
	/*
	 * 应收金额
	 */
	private JTextField yingShouJinE = new JTextField(15);
	/*
	 * 实收金额
	 */
	private JTextField shiShouJinE = new JTextField(15);
	
	private JComboBox jingbanren = new JComboBox(); 
	private JTextField beiZhu = new JTextField(30); 
	private JButton queDing = new JButton("确定");
	
//TuiHuoChaXun,
	//north1
	private JButton gaoJiChaXun = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//north2
	//	时间
	private JDatePicker kaiDanRiQi = new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField gongHuoShangOrDanJuHao = new JTextField(10);
	private JButton chaXun = new JButton("查询(F2)");
	//center
	//	表是一个蛋疼的问题
	private JTable table_center;
	private AllTableModel ATM_center;
	private Vector data_center = new Vector();//用来存表中data
	//south
	private JTable table_south;
	private AllTableModel ATM_south;
	private Vector data_south = new Vector();//用来存表中data
	
	
	/*
	 * 构造方法1-----主流
	 */
	public CaiGouTuiHuo(JFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		//供货商添加监听器，方便设置下面的构造方法中供货商无监听器
		gongHuoShang.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				new GongHuoShangJDialog(CaiGouTuiHuo.this,"选择供货商",true);
			}
		});
		//放大镜
		cha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new GongHuoShangJDialog(CaiGouTuiHuo.this,"选择供货商",true);/////////////////////
			}
		});
		init();
	}
	/*
	 * 构造方法2---只在整单退货中用到
	 */
	public CaiGouTuiHuo(JFrame frame,String title,
			boolean model,Vector argData,String gonghuoshang){
		super(frame,title,model);
		for(Object tmp : argData){
		  caiGouTuiHuo_data.add(tmp);
		}
		this.frame = frame;
		//设置panel1不可见
		center1.setVisible(false);
	
		//设置供货商。。并移除允许修改的监听器
		gongHuoShang.setText(gonghuoshang);
		System.out.print(gonghuoshang);
		gongHuoShang.setEditable(false);
		gongHuoShang.addMouseListener(new MouseAdapter(){

		  public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(CaiGouTuiHuo.this,
					"整单退货期间不允许更改供货商!");
		  }
		});
		cha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(CaiGouTuiHuo.this,
						"整单退货期间不允许更改供货商!");/////////////////////
			}
		});
		//设置应收金额和实收金额
		float i = 0;
		for(Object tmp : argData){
			i = i + Float.valueOf(((Vector)tmp).get(7).toString());
		}
		this.getYingShouJinE().setText(""+i);
		this.getShiShouJinE().setText(""+i);
		
		//////////////////////////////////////////////
		init();
	}
	
	private void init(){
		//初始化单据号
		try {
			danhao = new JLabel("CT"+DateConventer.dateToStr(
					tuiHuoRiQi.getSelectedDate(),"yyMMdd")+
					DateConventer.dateToStr(new Date(),"hhmmss"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//经办人
		Vector argyuangong = JinBanRenJDBC.find();
		for(Object tmp : argyuangong){
			jingbanren.addItem(tmp);
		}
		
		this.setSize(720, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.addTab("采购退货", caiGouTuiHuo());
		tab.addTab("退货查询",tuiHuoChaXun());
		
		this.add(tab);
		this.setVisible(true);
		
	}
//caiGouTuiHuo pane
	private JPanel caiGouTuiHuo(){
		JPanel caiGouTuiHuo = new JPanel();
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
	//north
		north.setLayout(new BorderLayout());
		
		JPanel north1 = new JPanel();
		north1.setLayout(new FlowLayout(FlowLayout.RIGHT,20,2));
		JLabel biaoti = new JLabel("采购退货");
		JLabel danHao = new JLabel("单号 :");
		danhao.setForeground(Color.RED);
		biaoti.setFont(new Font("黑体",Font.BOLD,25));//字体设置
		north1.add(biaoti);
		JLabel label = new JLabel("               ");
		north1.add(label);
		north1.add(danHao);
		north1.add(danhao);
		
		
		JPanel north2 = new JPanel();
		north2.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		//供货商
		north2.add(new JLabel("供货商 ："));
		north2.add(gongHuoShang);
		
		//放大镜
		cha.setMargin(new Insets(0,0,0,0));//设置内边距
		north2.add(cha);
		
		north2.add(new JLabel("出货仓库 ："));
		north2.add(chuHuoCangKu);
		north2.add(new JLabel("退货日期"));
		north2.add(tuiHuoRiQi);
		//north2.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		north.add(north1,BorderLayout.NORTH);
		north.add(north2,BorderLayout.CENTER);
	//center
		center.setLayout(new BorderLayout());
		//添加组件
		JPanel center2 = new JPanel();
		
		
		JButton zhengDanTuiHuo = new JButton("整单退货(F7)");
		zhengDanTuiHuo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!caiGouTuiHuo_data.isEmpty()){
					JOptionPane.showMessageDialog(CaiGouTuiHuo.this,
					"请先保存本次的退货单据!");
				}
				new CaiGouDanJuChaXun(frame,"采购单据查询",true);
			}
		});
		//添加退货商品  按钮的监听器
		tianJiaTuiHuoShangpin.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new TuiHuoShangPin(CaiGouTuiHuo.this,"增加商品（采购退货）");
			}
			
		});
		
		//删除商品
		JButton shanchushangpin = new JButton("删除商品(F4)");
		shanchushangpin.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i = CaiGouTuiHuo.this.getTable().getSelectedRow();
				if(i != -1){
					CaiGouTuiHuo.this.getCaiGouTuiHuo_data().remove(i);
					//记得刷新表
					CaiGouTuiHuo.this.getATM().setDataVector(
							CaiGouTuiHuo.this.caiGouTuiHuo_data,ColumnNames.caiGouJinHuo_columns );
				}
			}
		});
		
		center1.setLayout(new FlowLayout(FlowLayout.LEFT));
		center1.add(tianJiaTuiHuoShangpin);
		center1.add(zhengDanTuiHuo);
		center1.add(shanchushangpin);
		center.add(center1,BorderLayout.NORTH);
		///////////////////////////////////////////////////
		ATM = new AllTableModel(caiGouTuiHuo_data,ColumnNames.caiGouJinHuo_columns);
		table = new JTable(ATM);
		
		table = new JTable(ATM);
		//表格固定大小
		table.setPreferredScrollableViewportSize(new Dimension(670,200));
		table.setBackground(Color.WHITE);//这个没达到效果
		center2.add(new JScrollPane(table),BorderLayout.CENTER);//加一个滚动条
		//center2.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		center.add(center2,BorderLayout.CENTER);
		
		//center.setBorder(new LineBorder(Color.GRAY,1)); 
	//south 
		JPanel pane_south1 = new JPanel();
		JPanel pane_south2 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		pane_south1.setLayout(new GridLayout(2,0));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane_south1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		//添加组件
		
		JButton tuiChu = new JButton("退出");
		tuiChu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CaiGouTuiHuo.this.dispose();
			}
		});
		
		panel1.add(new JLabel("应收金额 ："));
		yingShouJinE.setEditable(false);
		panel1.add(yingShouJinE);
		panel1.add( new JLabel("实收金额 ："));
		panel1.add(shiShouJinE);
		panel1.add(new JLabel("经办人 ："));
		panel1.add(jingbanren);
		panel2.add(new JLabel("备注 : "));
		panel2.add(beiZhu);
		pane_south2.add(queDing);
		//确定button
		queDing.addActionListener(new TuiHuoMainOKBtnListener(this));
		pane_south2.add(tuiChu);
		
		pane_south1.add(panel1);
		pane_south1.add(panel2);
		south.add(pane_south1);
		south.add(pane_south2);
		
	//
		caiGouTuiHuo.setLayout(new BorderLayout());
		caiGouTuiHuo.add(north,BorderLayout.NORTH);
		caiGouTuiHuo.add(center,BorderLayout.CENTER);
		caiGouTuiHuo.add(south,BorderLayout.SOUTH);
		return caiGouTuiHuo;
	}
	
	
//tuiHuoChaXun pane..
	private JPanel tuiHuoChaXun(){
		JPanel tuiHuoChaXun = new JPanel();
		tuiHuoChaXun.setLayout(new BorderLayout());
		tuiHuoChaXun.add(tuiHuoNorth(),BorderLayout.NORTH);
		tuiHuoChaXun.add(tuiHuoCenter(),BorderLayout.CENTER);
		tuiHuoChaXun.add(tuiHuoSouth(),BorderLayout.SOUTH);
		
		return tuiHuoChaXun;
	}
	//north
	private JPanel tuiHuoNorth(){
		JPanel tuiHuoNorth = new JPanel();
		
		JPanel north1 = new JPanel();
		JPanel north2 = new JPanel();
		JPanel north3 = new JPanel();
		//north1
		//退出button
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CaiGouTuiHuo.this.dispose();
			}
		});
		//设置button内边距
		gaoJiChaXun.setMargin(new Insets(0,0,0,0));
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		north1.add(gaoJiChaXun);
		north1.add(chaKanDanJu);
		north1.add(daoChu);
		north1.add(exit);
		//north2
		JPanel one = new JPanel();
		//JLabel改为靠左对齐
		//label1.setHorizontalAlignment(JLabel.RIGHT);
		//设置大小
		//label1.setPreferredSize(new Dimension(20,2));
		
		one.add(new JLabel("开单日期:"));
		one.add(kaiDanRiQi);
		one.add(new JLabel("至"));
		one.add(zhi);
		
		JPanel two = new JPanel();
		
		two.add(new JLabel("供货商/单据号:"));
		two.add(gongHuoShangOrDanJuHao);
		two.add(chaXun);
		//查询按钮
		chaXun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = kaiDanRiQi.getSelectedItem().toString();
				String time2 = zhi.getSelectedItem().toString();
				String gonghuoshang = gongHuoShangOrDanJuHao.getText().toString();
				
				data_center= JDBCCaiGouDanJu.getCaiGou(time1,time2,gonghuoshang);
				
				ATM_center.setDataVector(data_center,
						CaiGouTuiHuoColumn.center_ColumnNames);
			}
		});
		
		north2.setLayout(new GridLayout(2,0));
		north2.add(one);
		north2.add(two);
		
		//添加
		tuiHuoNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		tuiHuoNorth.add(north1);
		tuiHuoNorth.add(north2);
		
		return tuiHuoNorth;
	}
//center
	private JPanel tuiHuoCenter(){
		JPanel tablePane = new JPanel();
		
		
		ATM_center = new AllTableModel(data_center,
				CaiGouTuiHuoColumn.center_ColumnNames);
		table_center = new JTable(ATM_center);
		//表上监听事件
		table_center.addMouseListener(new MouseAdapter(){//表上操作的监听器
		  public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1 || e.getClickCount() ==2){
					int i = table_center.getSelectedRow();
					String danhao = (String)((Vector)data_center.get(i)).get(0);
					//south table的跟随刷新
					data_south = JDBCWangLaiZhangWu.getDanJuXiangXi(danhao);
					ATM_south.setDataVector(data_south,
							CaiGouTuiHuoColumn.south_ColumnNames);
			}
		  }
		});
		//表格固定大小
		table_center.setPreferredScrollableViewportSize(new Dimension(670,200));
		tablePane.add(new JScrollPane(table_center),BorderLayout.CENTER);//加一个滚动条
		//tablePane.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		
		return tablePane;
	}
//south
	private JPanel tuiHuoSouth(){
		JPanel tuiHuoSouth = new JPanel();
		
		ATM_south = new AllTableModel(data_south,
				CaiGouTuiHuoColumn.south_ColumnNames);
		
		table_south = new JTable(ATM_south);
		table_south.setPreferredScrollableViewportSize(new Dimension(670,80));//表格固定大小
		
		tuiHuoSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		tuiHuoSouth.add(new JLabel("单据的详细信息:"));
		tuiHuoSouth.add(new JScrollPane(table_south),BorderLayout.CENTER);//加一个滚动条
		//tuiHuoSouth.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		
		
		return tuiHuoSouth;
	}
	
	public static void main(String[] args){
		new CaiGouTuiHuo((JFrame)null,"采购退货",true);
	}

	public JTextField getBeiZhu() {
		return beiZhu;
	}


	public AllTableModel getATM() {
		return ATM;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getChaKanDanJu() {
		return chaKanDanJu;
	}

	public JButton getChaXun() {
		return chaXun;
	}

	public JButton getDaoChu() {
		return daoChu;
	}

	public JButton getGaoJiChaXun() {
		return gaoJiChaXun;
	}

	public JTextField getGongHuoShang() {
		return gongHuoShang;
	}

	public JTextField getGongHuoShangOrDanJuHao() {
		return gongHuoShangOrDanJuHao;
	}

	public JDatePicker getKaiDanRiQi() {
		return kaiDanRiQi;
	}

	public JButton getQueDing() {
		return queDing;
	}

	public JTextField getShiShouJinE() {
		return shiShouJinE;
	}


	public JButton getTianJiaTuiHuoShangpin() {
		return tianJiaTuiHuoShangpin;
	}

	public JDatePicker getTuiHuoRiQi() {
		return tuiHuoRiQi;
	}

	public JTextField getYingShouJinE() {
		return yingShouJinE;
	}

	public JDatePicker getZhi() {
		return zhi;
	}

	public Vector getCaiGouTuiHuo_data() {
		return caiGouTuiHuo_data;
	}

	public AllTableModel getATM_center() {
		return ATM_center;
	}

	public AllTableModel getATM_south() {
		return ATM_south;
	}

	public Vector getData_center() {
		return data_center;
	}

	public Vector getData_south() {
		return data_south;
	}

	public JTable getTable_center() {
		return table_center;
	}

	public JTable getTable_south() {
		return table_south;
	}

	public JComboBox getChuHuoCangKu() {
		return chuHuoCangKu;
	}

	public JLabel getDanhao() {
		return danhao;
	}

	public JComboBox getJingbanren() {
		return jingbanren;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setCaiGouTuiHuo_data(Vector caiGouTuiHuo_data) {
		this.caiGouTuiHuo_data = caiGouTuiHuo_data;
	}
	
	
	
}
