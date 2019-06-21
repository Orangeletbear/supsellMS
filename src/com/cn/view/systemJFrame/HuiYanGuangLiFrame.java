package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Vector;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.control.systemframe.huiyuanxinxi.FindHYBaseMAction;
import com.cn.control.systemframe.huiyuanxinxi.FindHYXiaoFeiAction;
import com.cn.control.systemframe.huiyuanxinxi.FindXuFeiXinXiBtnAction;
import com.cn.control.systemframe.huiyuanxinxi.HYJiFenQingLingAction;
import com.cn.control.systemframe.huiyuanxinxi.SelectHYBaseMouseAction;
import com.cn.control.systemframe.huiyuanxinxi.SelectXiaoFeiMouseAction;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.MyTableCellRender;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.util.Log;
import com.cn.util.PrintTableData;
import com.cn.util.SwingCommonPrinitTools;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.huiyuanguanli.AddHuiYuan;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanCanShuSheZhi;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanJiBieSet;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanTableCellRender;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanXuFei;
import com.cn.view.toolbar.HelpDialog;
/**
 * 会员管理界面
 * @author finey
 *
 */
public class HuiYanGuangLiFrame extends JDialog {
	
	//四个日期
	JDatePicker xinXiDate1;
	JDatePicker xinXiDate2;
	JDatePicker xuFeiDate1;
	JDatePicker xuFeiDate2;
	JDatePicker xiaoFeiDate1;
	JDatePicker xiaoFeiDate2;
	


	JTextField hyIDfield1 ;
	JTextField hyIDfield2 ;
	JTextField hyIDfield3 ;
	
	


	//第一个卡片上的
	private  JLabel xfdLab; 
	//表模式
	AllTableModel hyXinXiTM;
	AllTableModel hyXianXiXinXiTM;
	AllTableModel hyXuFeiTM;
	AllTableModel hyXiaoFenTM;
	AllTableModel hyXiaoFenMinXiTM;
    //积分清零
	JButton jfqlBtn;
    

	//第一个选项卡中的第一个表
	JTable hyXinXiT;
	//第一个选项卡中的第二个表
	JTable hyXianXiXinXiT;
	//第二个选项卡中的第一个表
	JTable hyXuFeiT;
	//第三个选项卡中的第一个表
	JTable hyXiaoFenT;
	//第三个选项卡中的第二个表
	JTable hyXiaoFenMinXiT;

	JLabel djId ;
	

	public JDatePicker getXiaoFeiDate1() {
		return xiaoFeiDate1;
	}

	public JDatePicker getXiaoFeiDate2() {
		return xiaoFeiDate2;
	}
	
	public JButton getJfqlBtn() {
		return jfqlBtn;
	}

	
	public JTextField getHyIDfield1() {
		return hyIDfield1;
	}

	public JTextField getHyIDfield2() {
		return hyIDfield2;
	}

	public JTextField getHyIDfield3() {
		return hyIDfield3;
	}
	
	public JLabel getDjId() {
		return djId;
	}

	public JDatePicker getXinXiDate1() {
		return xinXiDate1;
	}

	public JDatePicker getXinXiDate2() {
		return xinXiDate2;
	}

	public JDatePicker getXuFeiDate1() {
		return xuFeiDate1;
	}

	public JDatePicker getXuFeiDate2() {
		return xuFeiDate2;
	}

	public JTextField getDjfield1() {
		return hyIDfield1;
	}

	public JTextField getDjfield2() {
		return hyIDfield2;
	}

	public JTextField getDjfield3() {
		return hyIDfield3;
	}

	public JTable getHyXianXiXinXiT() {
		return hyXianXiXinXiT;
	}

	public AllTableModel getHyXianXiXinXiTM() {
		return hyXianXiXinXiTM;
	}

	public JTable getHyXiaoFenMinXiT() {
		return hyXiaoFenMinXiT;
	}

	public AllTableModel getHyXiaoFenMinXiTM() {
		return hyXiaoFenMinXiTM;
	}

	public JTable getHyXiaoFenT() {
		return hyXiaoFenT;
	}

	public AllTableModel getHyXiaoFenTM() {
		return hyXiaoFenTM;
	}

	public JTable getHyXinXiT() {
		return hyXinXiT;
	}

	public AllTableModel getHyXinXiTM() {
		return hyXinXiTM;
	}

	public JTable getHyXuFeiT() {
		return hyXuFeiT;
	}

	public AllTableModel getHyXuFeiTM() {
		return hyXuFeiTM;
	}

	public JLabel getXfdLab() {
		return xfdLab;
	}

	public HuiYanGuangLiFrame(MainFrame frame,String name){
		
		super(frame,name,true);
		init();
		initData();
		this.setVisible(true);
	}
	/**
	 * 表中数据的初始化
	 */
	public void initData(){
		 Vector data = HuiYuanXinGLJDBC.getHuiYuanBaseM("");
         //更新界面数据
         this.getHyXinXiTM().setDataVector(data,
     		   AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName11));
         
         data = HuiYuanXinGLJDBC.getHuiYuanXuFei("2000-1-1", "2020-1-1", "");
 		//数据加入表模式中
 		this.getHyXuFeiTM().setDataVector(data,
 		AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName2));
 		
 		data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiXinXi("2000-1-1", "2020-1-1", "");
 		//数据加入表模式中
 		this.getHyXiaoFenTM().setDataVector(data,
 		AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName31));
 		
 		HuiYuanTableCellRender render = new HuiYuanTableCellRender();
		
		//设置每列的渲染器
	    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
	    	hyXinXiT.getColumnModel().getColumn(i).setCellRenderer(render);
	    }
 		
	}
	
	private void init(){
		this.setSize(new Dimension(820,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		JTabbedPane  tabblePane = new JTabbedPane(
				JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//三个选项卡
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		
		tabblePane.add("会员信息管理",pane1);
		tabblePane.add("会员续费查询",pane2);
		tabblePane.add("会员销费统计",pane3);
		
		mainPane.add(tabblePane);
		return mainPane;
	}
	/*
	 * 第一个选项卡
	 */
	private JPanel createPane1(){
        
		
        JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//工具栏的加入
		pane.add(initTool(),BorderLayout.NORTH);
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(2,1));
		//表格面板
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		
		JLabel lab = new JLabel("会员信息 : ");
		hyIDfield1 = new JTextField(14);
		hyIDfield1.setToolTipText("输入会员编号或名称模糊查询");
		JButton findbtn = new JButton("查    询");
		findbtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				  String dateFrom = null;
		          String dateTo = null;
		          
		          int row = HuiYanGuangLiFrame.this.getHyXinXiT().getSelectedRow();
		          if(row ==-1){
		        	  return;
		          }
		          String hyid = HuiYanGuangLiFrame.this.getHyXinXiTM().getValueAt(row, 0).toString();
		          
		          try {
					dateFrom = DateConventer.dateToStr(
							HuiYanGuangLiFrame.this.getXinXiDate1().getSelectedDate(), "yyyy-MM-dd");
					dateTo = DateConventer.dateToStr(
							HuiYanGuangLiFrame.this.getXinXiDate2().getSelectedDate(), "yyyy-MM-dd");
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				Vector data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiMassege(
						dateFrom,dateTo,hyid);
	        	  
				HuiYanGuangLiFrame.this.getHyXianXiXinXiTM().setDataVector(data,
	        	AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName12));
				
				HuiYuanTableCellRender render = new HuiYuanTableCellRender();
				
				//设置每列的渲染器
			    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
			    	hyXinXiT.getColumnModel().getColumn(i).setCellRenderer(render);
			    }
			}
		});
		jfqlBtn = new JButton("积分清零");
		jfqlBtn.setEnabled(false);
		jfqlBtn.addActionListener(new HYJiFenQingLingAction(this));
		findbtn.addActionListener(new FindHYBaseMAction(this));
		northPane.add(lab);
		northPane.add(hyIDfield1);
		northPane.add(findbtn);
		northPane.add(jfqlBtn);
		
		downPane1.add(northPane,BorderLayout.NORTH);
		JPanel tablePane = new JPanel();
		tablePane.setLayout(new BorderLayout());
		
		hyXinXiTM = new AllTableModel(HYSZTableCulomns.data,
				  HYSZTableCulomns.ColumnName11);
		//新建一个表格
		hyXinXiT = new JTable(hyXinXiTM);
		//表格固定大小
		hyXinXiT.setPreferredScrollableViewportSize(new Dimension(1200, 150));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//加表格自动排序
		hyXinXiT.setAutoCreateRowSorter(true);
		hyXinXiT.addMouseListener(new SelectHYBaseMouseAction(this));
		
		//加一个滚动条
		tablePane.add(new JScrollPane(hyXinXiT),BorderLayout.CENTER);
		
		downPane1.add(new JScrollPane(tablePane),BorderLayout.CENTER);
		centerPane.add(downPane1);
		
		//=========================================
		//第二个表格区
		downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JLabel tmpLabel = new JLabel("会员消费明细：   ");
		xfdLab = new JLabel("张三");
		xfdLab.setForeground(Color.red);
		
		lab = new JLabel("会员信息 : ");
		
		xinXiDate1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("到: ");
		xinXiDate2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		findbtn = new JButton("查    询");
		
		northPane.add(tmpLabel);
		northPane.add(xfdLab);
		northPane.add(lab);
		northPane.add(xinXiDate1);
		northPane.add(toLab);
		northPane.add(xinXiDate2);
		
		northPane.add(findbtn);
		
		downPane1.add(northPane,BorderLayout.NORTH);
		tablePane = new JPanel();
		hyXianXiXinXiTM = new AllTableModel(HYSZTableCulomns.data,
				    HYSZTableCulomns.ColumnName12);
		//新建一个表格
		hyXianXiXinXiT = new JTable(hyXianXiXinXiTM);
		//表格固定大小
		hyXianXiXinXiT.setPreferredScrollableViewportSize(new Dimension(800, 150));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//加表格自动排序
		hyXianXiXinXiT.setAutoCreateRowSorter(true);
		//加一个滚动条
		tablePane.add(new JScrollPane(hyXianXiXinXiT),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		centerPane.add(downPane1);
		
		pane.add(centerPane);
		return pane;
	}
	/*
	 * 第一个面板的工具栏的建立
	 */
	private JPanel initTool(){
		JPanel pane =new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//加入会员
		JButton zjhyBtn = new JButton(new ImageIcon("res/AcionIcon/tjhy.jpg"));
		zjhyBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new AddHuiYuan(HuiYanGuangLiFrame.this,"增加会员",false);
			}
		});
		zjhyBtn.setMargin(new Insets(0,0,0,0));
		//修改会员
		JButton xghyBtn = new JButton(new ImageIcon("res/AcionIcon/xiugaihuiyuan.jpg"));
		xghyBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(HuiYanGuangLiFrame.this.getHyXinXiT().getSelectedColumnCount()==1){
					new AddHuiYuan(HuiYanGuangLiFrame.this,"修改会员",true);
				}else{
					JOptionPane.showMessageDialog(
							HuiYanGuangLiFrame.this, "请选择一条会员数据");
				}
			}
		});
		xghyBtn.setMargin(new Insets(0,0,0,0));
		//删除会员
		JButton schyBtn = new JButton(new ImageIcon("res/AcionIcon/sanchuhuiyan.jpg"));
		schyBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(HuiYanGuangLiFrame.this.getHyXinXiT().getSelectedColumnCount()!=1){
					JOptionPane.showMessageDialog(null,"请先选择一条数据");
					return;
				}
		        int choice =  JOptionPane.showConfirmDialog(
		        		HuiYanGuangLiFrame.this, "数据删除后将不能恢复，是否删除！","删除警告",
		        		 JOptionPane.YES_NO_OPTION, 1);
		          //点确定删除数据
			     if(choice == JOptionPane.YES_OPTION){
			    	 int row = HuiYanGuangLiFrame.this.getHyXinXiT().
			    	             getSelectedRow();
			    	 
			    	 String obj = HuiYanGuangLiFrame.this.getHyXinXiTM()
			    	           .getValueAt(row, 0).toString();
			    	 
			    	 String hyName = HuiYanGuangLiFrame.this.getHyXinXiTM()
	    	           .getValueAt(row, 1).toString();
			    	 
			    	 if(HuiYuanXinGLJDBC.deleHuiYuan(obj)){
			    		 JOptionPane.showMessageDialog(null,"数据成功删除");
			    		 
			    	     MainFrame mframe = (MainFrame)HuiYanGuangLiFrame.this .getOwner();
			    	     String user = mframe.getUser();
			    	   	 Log.traceLog("  操作员  ",user," 删除了会员 :  "+hyName);
			    		 initData();
			    	 }
			     }
			}
			  
	   });
		
		
		schyBtn.setMargin(new Insets(0,0,0,0));
		//会员级别
		JButton hyjbBtn = new JButton(new ImageIcon("res/AcionIcon/huiyuanjibie.jpg"));
		hyjbBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new HuiYuanJiBieSet(HuiYanGuangLiFrame.this,"会员级别");
				
			}
			
		});
		
		hyjbBtn.setMargin(new Insets(0,0,0,0));
		//参数设置
		JButton csszBtn = new JButton(new ImageIcon("res/AcionIcon/changshushezhi.jpg"));
		csszBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new HuiYuanCanShuSheZhi(HuiYanGuangLiFrame.this,"参数设置");
			}
			
		});
		
		csszBtn.setMargin(new Insets(0,0,0,0));
		//会员续费
		JButton hyxfBtn = new JButton(new ImageIcon("res/AcionIcon/huiyanxufei.jpg"));
		hyxfBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new HuiYuanXuFei(HuiYanGuangLiFrame.this,"会员续费");
			}
			
		});
		hyxfBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton printBtn = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		//查看单据
		JButton ckdjBtn = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		ckdjBtn.setMargin(new Insets(0,0,0,0));
		//其它操作
		JButton qtczBtn = new JButton(new ImageIcon("res/AcionIcon/qitachaozhuo.jpg"));
		qtczBtn.setMargin(new Insets(0,0,0,0));
		//退出
		JButton exitBtn = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYanGuangLiFrame.this.dispose();
			}
			
		});
		
		pane.add(zjhyBtn);
		pane.add(xghyBtn);
		pane.add(schyBtn);
		pane.add(hyjbBtn);
		pane.add(csszBtn);
		pane.add(hyxfBtn);
		pane.add(printBtn);
		pane.add(ckdjBtn);
		pane.add(qtczBtn);
		pane.add(exitBtn);
		
		
		return pane;
	}
	/*
	 * 第二个选项卡
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//工具栏的加入
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
         //导出
		JButton exportBtn = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", hyXuFeiT, HYSZTableCulomns.ColumnName2);
			}
			
		});
		
		exportBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton printBtn = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		printBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(hyXuFeiT.getModel(),"ccc");
			}
			
		});
		
		
		printBtn.setMargin(new Insets(0,0,0,0));
		//退出
		JButton exitBtn = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYanGuangLiFrame.this.dispose();
			}
			
		});
		
		northPane.add(exportBtn);
		northPane.add(printBtn);
		northPane.add(exitBtn);
		
		pane.add(northPane,BorderLayout.NORTH);
		
		
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		JPanel northPane1 = new JPanel();
		northPane1.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		
		JLabel fromLab = new JLabel("查询日期 从:  ");
		//日期选项
		xuFeiDate1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("到: ");
		xuFeiDate2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("会员卡号或姓名 : ");
		hyIDfield2 = new JTextField(14);
		JButton findbtn = new JButton("查    询");
		findbtn.addActionListener(new FindXuFeiXinXiBtnAction(this));
		
		
		
		northPane1.add(fromLab);
		northPane1.add(xuFeiDate1);
		northPane1.add(toLab);
		northPane1.add(xuFeiDate2);
		northPane1.add(allfindlab);
		northPane1.add(hyIDfield2);
		northPane1.add(findbtn);
		
		
		downPane1.add(northPane1,BorderLayout.NORTH);
		
		
		JPanel tablePane = new JPanel();
		hyXuFeiTM = new AllTableModel(HYSZTableCulomns.data,
				HYSZTableCulomns.ColumnName2);
		//新建一个表格
		hyXuFeiT = new JTable(hyXuFeiTM);
		//表格固定大小
		hyXuFeiT.setPreferredScrollableViewportSize(new Dimension(800, 400));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//加表格自动排序
		hyXuFeiT.setAutoCreateRowSorter(true);
		//加一个滚动条
		tablePane.add(new JScrollPane(hyXuFeiT),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		
		pane.add(downPane1);
		return pane;
	}
	
	
	private JPanel createPane3(){
		

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//工具栏的加入
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
         //导出
		JButton exportBtn = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		//查看单据
		JButton printBtn = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		printBtn.setMargin(new Insets(0,0,0,0));
		//打印
		JButton ckdjBtn = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		ckdjBtn.setMargin(new Insets(0,0,0,0));
		//退出
		JButton exitBtn = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				HuiYanGuangLiFrame.this.dispose();
			}
			
		});
		
		northPane.add(exportBtn);
		northPane.add(printBtn);
		northPane.add(ckdjBtn);
		northPane.add(exitBtn);
		
		pane.add(northPane,BorderLayout.NORTH);
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(2,1));
		
		
		JPanel downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		JPanel northPane1 = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JLabel fromLab = new JLabel("查询日期 从:  ");
		//日期选项
		xiaoFeiDate1 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		JLabel toLab = new JLabel("到: ");
		xiaoFeiDate2 =new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		JLabel allfindlab = new JLabel("会员卡号或姓名/单据号查询 : ");
		hyIDfield3 = new JTextField(14);
		JButton findbtn = new JButton("查    询");
		findbtn.addActionListener(new FindHYXiaoFeiAction(this));
		northPane1.add(fromLab);
		northPane1.add(xiaoFeiDate1);
		northPane1.add(toLab);
		northPane1.add(xiaoFeiDate2);
		
		northPane1.add(allfindlab);
		northPane1.add(hyIDfield3);
		northPane1.add(findbtn);
		
		downPane1.add(northPane1,BorderLayout.NORTH);
		JPanel tablePane = new JPanel();
		
		hyXiaoFenTM = new AllTableModel(HYSZTableCulomns.data,
				HYSZTableCulomns.ColumnName31);
		//新建一个表格
		hyXiaoFenT = new JTable(hyXiaoFenTM);
		//表格固定大小
		hyXiaoFenT.setPreferredScrollableViewportSize(new Dimension(800, 150));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//加表格自动排序
		hyXiaoFenT.setAutoCreateRowSorter(true);
		//加一个滚动条
		tablePane.add(new JScrollPane(hyXiaoFenT),BorderLayout.CENTER);
		hyXiaoFenT.addMouseListener(new SelectXiaoFeiMouseAction(this));
		downPane1.add(tablePane);
		centerPane.add(downPane1);
		
		//=========================================
		//第二个表格区
		downPane1 = new JPanel();
		downPane1.setLayout(new BorderLayout());
		
		northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		JLabel xfmslab = new JLabel("消费明细         ");
		djId = new JLabel("  单据号:  ");
		djId.setForeground(Color.red);
		
		northPane.add(xfmslab);
		northPane.add(djId);
		
		downPane1.add(northPane,BorderLayout.NORTH);
		tablePane = new JPanel();
		
		hyXiaoFenMinXiTM = new AllTableModel(HYSZTableCulomns.data,
				HYSZTableCulomns.ColumnName32);
		//新建一个表格
		hyXiaoFenMinXiT = new JTable(hyXiaoFenMinXiTM);
		//表格固定大小
		hyXiaoFenMinXiT.setPreferredScrollableViewportSize(
				new Dimension(800, 170));
		//如果为 true，则该组件绘制其边界内的所有像素
		tablePane.setOpaque(true);
		//加表格自动排序
		hyXiaoFenMinXiT.setAutoCreateRowSorter(true);
		//加一个滚动条
		tablePane.add(new JScrollPane(hyXiaoFenMinXiT),BorderLayout.CENTER);
		
		downPane1.add(tablePane);
		centerPane.add(downPane1);
		
		pane.add(centerPane);
		return pane;
	}
	
	
	
}
