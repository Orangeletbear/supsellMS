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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.jinhuoframe.caigoujinhuo.main.OKBtnActionListener;
import com.cn.dao.jinhuo.JinBanRenJDBC;
import com.cn.dao.jinhuo.NomalJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.util.PrintTableData;
import com.cn.util.SwingCommonPrinitTools;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.GongHuoShangDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.XinShangPin;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.XinShangPinTianJia;
import com.cn.view.toolbar.TableCulomnModel;

public class CaiGouJinHuo extends JDialog{
	//父窗口
	JFrame frame;
	/*
	 * 界面无显示的 优惠金额，和欠款 金额
	 */
	private float youHuiJine = 0;
	private float QianKuanJine = 0;
	/*
	 * 新商品数据保存
	 */
	private Vector xinShangPinData = new Vector();
	
	//north 组件
	private JLabel danhao;
	private JTextField gongHuoShang = new JTextField(20);
	private JComboBox shouHuoCangKu = new JComboBox(JDBCCuCunFind.getCanKuData());
	//	时间
	private JDatePicker jinHuoRiQi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//center 组件
	private JButton xinShangpin = new JButton("新商品添加(F9)");
	private JButton daoRuDaoChu = new JButton("导入导出(F7)");
	private JButton dayindanju = new JButton("打印单据(F8)");
	//表是一个蛋疼的问题
	private JTable table;
	private AllTableModel ATM;
	private Vector<Vector> caiGouJinHuo_data = new Vector<Vector>();//用来存表中data
	//south 组件
	private JTextField yingFuJinE = new JTextField(15);
	private JTextField shiFuJinE = new JTextField(15);
	private JComboBox jingbanren = new JComboBox(); 
	private JTextField yuanShiDanHao = new JTextField(15);
	private JTextField beiZhu = new JTextField(30); 
	private JButton queDing = new JButton("确定");
	
	public CaiGouJinHuo(JFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		//初始化单据号
		try {
			danhao = new JLabel("CJ"+DateConventer.dateToStr(
					jinHuoRiQi.getSelectedDate(),"yyMMdd")+
					DateConventer.dateToStr(new Date(),"hhmmss"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//经办人
		Vector argyuangong = JinBanRenJDBC.find();
		for(Object tmp : argyuangong){
			jingbanren.addItem(tmp);
		}
		init();
	}
	
	private void init(){
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		this.add(north(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.add(south(),BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
//north pane
	private JPanel north(){
		JPanel north = new JPanel();
		
		north.setLayout(new BorderLayout());
		//添加组件
		JPanel north1 = new JPanel();
		north1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel biaoti = new JLabel("采购进货");
		biaoti.setFont(new Font("黑体",Font.BOLD,25));//字体设置
		north1.add(biaoti);
		north1.add(new JLabel("                 "));//用来美化格式
		danhao.setForeground(Color.RED);
		north1.add(new JLabel("单号："));
		north1.add(danhao);
		north1.add(new JLabel("                 "));//用来美化格式
		
		/////////////////////////////////////////
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		center.add(new JLabel("供货商 ："));
		//供货商
		gongHuoShang.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				new GongHuoShangDialog(CaiGouJinHuo.this,"选择供货商",true);
			}
		});
		center.add(gongHuoShang);
		
		//添加那个放大镜式的东西
		JButton cha = new JButton(new ImageIcon("res/AcionIcon/cha.jpg"));
		
		cha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new GongHuoShangDialog(CaiGouJinHuo.this,"选择供货商",true);/////////////////////
			}
		});
		cha.setMargin(new Insets(0,0,0,0));//设置内边距
		center.add(cha);
		
		center.add(new JLabel("收获仓库 ："));
		center.add(shouHuoCangKu);
		center.add(new JLabel("进货日期"));
		//进货日期关联单号命名
		jinHuoRiQi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					danhao.setText(("CJ"+
							DateConventer.dateToStr(jinHuoRiQi.getSelectedDate(),"yyMMdd")
							+DateConventer.dateToStr(new Date(),"hhmmss")));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		center.add(jinHuoRiQi);
		center.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		north.add(north1,BorderLayout.NORTH);
		north.add(center,BorderLayout.CENTER);
		
		return north;
	}
//center pane
	private JPanel center(){
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		//添加组件
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//老商品添加按钮
		JButton laoShangpin = new JButton("老商品添加(F2)");
		laoShangpin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new AddShangPingDialog(CaiGouJinHuo.this,"增加商品(采购进货)");
			}
		});
		//新商品添加按钮
		xinShangpin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new com.cn.view.systemJFrame.shangpingxinxidialog.
				AddShangPingDialog(CaiGouJinHuo.this,"增加商品",true);
			}
		});
		north.add(laoShangpin);
		north.add(xinShangpin);
		north.add(daoRuDaoChu);
		daoRuDaoChu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", table, 
						ColumnNames.caiGouJinHuo);
			}
			
		});
		
		//删除商品
		JButton shanchushangpin = new JButton("删除商品(F4)");
		shanchushangpin.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i = CaiGouJinHuo.this.getTable().getSelectedRow();
				if(i != -1){
					CaiGouJinHuo.this.getCaiGouJinHuo_data().remove(i);
					//记得刷新表
					CaiGouJinHuo.this.getATM().setDataVector(
							CaiGouJinHuo.this.caiGouJinHuo_data,ColumnNames.caiGouJinHuo_columns );
				}
			}
			
		});
		north.add(shanchushangpin);
		north.add(dayindanju);
		center.add(north,BorderLayout.NORTH);
		
		dayindanju.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(table.getModel(),"ccc");
			}
			
		});
		JPanel center1 = new JPanel();
		
		ATM = new AllTableModel(caiGouJinHuo_data,ColumnNames.caiGouJinHuo_columns);
		table = new JTable(ATM);
		//表格固定大小
		table.setPreferredScrollableViewportSize(new Dimension(650,260));
		table.setBackground(Color.WHITE);//
		//加一个滚动条
		center1.add(new JScrollPane(table),BorderLayout.CENTER);
		//center1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		center.add(center1,BorderLayout.CENTER);
		
		//center.setBorder(new LineBorder(Color.GRAY,1)); 	
		return center;
	}
//south pane
	private JPanel south(){
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,0));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,10,2));
		//添加组件
		JButton tuiChu = new JButton("退出");
		tuiChu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CaiGouJinHuo.this.dispose();
			}
		});
		
		panel1.add(new JLabel("应付金额 ："));
		yingFuJinE.setEditable(false);
		panel1.add(yingFuJinE);
		panel1.add(new JLabel("实付金额 ："));
		panel1.add(shiFuJinE);
		panel1.add(new JLabel("经办人 ："));
		
		panel1.add(jingbanren);
		panel1.add(new JLabel("原始单号 : "));
		panel1.add(yuanShiDanHao);
		panel2.add(new JLabel("备注 : "));
		panel2.add(beiZhu);
		//确定button
		queDing.addActionListener(new OKBtnActionListener(this));
		panel2.add(queDing);
		
		panel2.add(tuiChu);
		
		south.add(panel1);
		south.add(panel2);
		return south;
	}
	public static void main(String[] args){
		new CaiGouJinHuo((JFrame)null,"采购进货",true);
	}

	public AllTableModel getATM() {
		return ATM;
	}


	public Vector<Vector> getCaiGouJinHuo_data() {
		return caiGouJinHuo_data;
	}


	public JTextField getBeiZhu() {
		return beiZhu;
	}

	public JButton getDaoRuDaoChu() {
		return daoRuDaoChu;
	}

	public JButton getDayindanju() {
		return dayindanju;
	}

	public JTextField getGongHuoShang() {
		return gongHuoShang;
	}

	
	public JComboBox getJingbanren() {
		return jingbanren;
	}

	public JDatePicker getJinHuoRiQi() {
		return jinHuoRiQi;
	}

	public JButton getQueDing() {
		return queDing;
	}

	public JTextField getShiFuJinE() {
		return shiFuJinE;
	}

	public JComboBox getShouHuoCangKu() {
		return shouHuoCangKu;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getXinShangpin() {
		return xinShangpin;
	}


	public JTextField getYingFuJinE() {
		return yingFuJinE;
	}

	public JTextField getYuanShiDanHao() {
		return yuanShiDanHao;
	}

	public JLabel getDanhao() {
		return danhao;
	}

	public JFrame getFrame() {
		return frame;
	}

	public float getYouHuiJine() {
		return youHuiJine;
	}

	public void setYouHuiJine(float youHuiJine) {
		this.youHuiJine = youHuiJine;
	}

	public float getQianKuanJine() {
		return QianKuanJine;
	}

	public void setQianKuanJine(float qianKuanJine) {
		QianKuanJine = qianKuanJine;
	}

	public Vector getXinShangPinData() {
		return xinShangPinData;
	}

	
}
