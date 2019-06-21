package com.cn.view.xiaoshouJFrame.guketuihuo;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.guketuihuo.ChaZhaoKeHuButtonAction;
import com.cn.control.xiaoshouframe.guketuihuo.DatePickerAlterAction;
import com.cn.control.xiaoshouframe.guketuihuo.GaoJiChaXunAction;
import com.cn.control.xiaoshouframe.guketuihuo.GuKeTuiHuoSureAction;
import com.cn.control.xiaoshouframe.guketuihuo.TuiHuoDanJuFindAction;
import com.cn.control.xiaoshouframe.guketuihuo.TuiHuoMouseListener;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ZhengDanTuiHuoAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AlterGoodsDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * 顾客退货对话框
 * @author Administrator
 *
 */
public class GuKeTuiHuoDialog extends JDialog{
	
	    /**
	     * 第一个选项卡上的组件
	     */
	
	   private MainFrame  mainFrame;
	   private JPanel guKeTuiHuoPane = new JPanel();
		
		//顾客退货选项卡的顾客退货标签
		private JLabel topicLabel  = new JLabel("顾客退货");
		//顾客退货选项卡的单号标签
		
		private JLabel danHaoLabel = new JLabel("");
		//客户名称标签
		private JLabel nameLabel = new JLabel("客户名称:");
		//客户文本框
		private JTextField  keHuText1 = new JTextField(15);
	
		//查询客户按钮
		private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
		//收货仓库标签
		private JLabel shouHuoCangKuLabel = new JLabel("收货仓库:");
		//仓库Box
		
		private DefaultComboBoxModel cangKuModel ;
		private JComboBox cangKuBox ;
		//销售日期标签
		private JLabel riQiLabel = new JLabel("销售日期:");
		//时间
		private JDatePicker dataPicker =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		//
		private JLabel infoLabel = new JLabel("");
		//添加退货商品按钮
		private JButton addButton = new JButton("添加退货商品(F2)");
		//修改商品商品按钮
		private JButton alterButton = new JButton("修改商品(F3)");
		//删除商品商品按钮
		private JButton deleteButton = new JButton("删除商品(F4)");
		//整单退货按钮
		private JButton tuiHuoButton = new JButton("整单退货(F7)");
		
		//定义面板下部的组件

	    private JTable table;
	    
	    
	    private DanJuChaXunDialog dialog = ZhengDanTuiHuoAction.getDialog() ;
	   

		private AllTableModel tableModel;
		
		//应退金额标签
		private JLabel yingTuiMoneyLabel = new JLabel("应退金额:");
		//应退金额文本框
		private JTextField yingTuiText = new JTextField(15);
		//实收金额标签
		private JLabel shiTuiMoneyLabel = new JLabel("实退金额:");
		//实收金额文本框
		private JTextField shiTuiText = new JTextField(15);
		//经办人标签
		private JLabel jingBanRenLabel = new JLabel("经办人:");
		//经办人Box
		private JComboBox jingBanBox ;
		private DefaultComboBoxModel jinBanModel;
		
		//存放表格中的数据
		Vector<Vector> data  = new Vector<Vector>();
		//查询经办人按钮
		private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
		//备注标签
		private JLabel beiZhuLabel = new JLabel("备注:");
		//备注文本框
		private JTextField beiZhuText = new JTextField(40);
		//查看备注按钮
		private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
		//确定按钮
		private JButton sureButton = new JButton("确定");
		//退出按钮
		private JButton tuiChuButton1 = new JButton("退出");
		
		/**
		 * 第二个选项卡上的组件
		 */
		
		private JPanel tuiHuoChaXunPane = new JPanel();
//		退货查询面板的高级查询按钮
		private JButton chaXunButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
		//退货查询面板的查看单据按钮
		private JButton chaKanButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		//退货查询面板的导出按钮
		private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
		//退货查询面板的退出按钮
		private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	    //两个时间
		private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		//查看时间按钮
		private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
		//客户文本框
		private JTextField keHuText = new JTextField(15);
		//查询按钮
		private JButton chaXun = new JButton("查询(F2)");
		
		private JRadioButton danJuBiao = new JRadioButton("单据表");
		
		//第一个表格
		private JTable danJuTable;
		private AllTableModel danJuModel;
		
		//第二个表格
		
		private JTable xiangXiTable ;	
		private AllTableModel xiangXiModel;
		
		private JLabel information = new JLabel("");
		

		public GuKeTuiHuoDialog(MainFrame  mainFrame,String title,boolean model) {
			super(mainFrame,title,model);
			this.mainFrame  = mainFrame;
			init();
			this.setVisible(true);
			
		}
	    

	/*  //初始化时无数据 
	    public GuKeTuiHuoDialog(JDialog dialog,String title,boolean model) {
			super(dialog,title,model);
			init();
		
			this.setVisible(true);
			
		}*/
	   
	    //初始化时有数据 
	    public GuKeTuiHuoDialog(JDialog dialog,String title,boolean model,boolean isaddData) {
			super(dialog,title,model);
			init();
			addData();
		//	this.setVisible(true);
			
		}
		/**
		 * 初始化顾客退货对话框
		 */
		public void init(){
			
			this.setSize(800, 550);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
		
			this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			//关闭窗口事件
			GuKeTuiHuoDialog.this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
				
					 if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(GuKeTuiHuoDialog.this,
		        			 "当前单据还没保存，是否关闭窗口？", "系统提示", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			  dispose();
		        		  }else {
		        			
		        		  }
		        	  }
				}
			});
			JTabbedPane pane = new JTabbedPane();
			pane.addTab("顾客退货",initguKeTuiHuoPane());
			pane.addTab("退货查询",initTuiHuoChaXunPane());
			this.add(pane);
			
		}

		/**
		 * 初始化顾客退货选项卡上的主面板
		 */
		public JPanel initguKeTuiHuoPane(){
			JPanel northPane = new JPanel();
			northPane.add(new JLabel("                                     "));
			northPane.add(topicLabel);
			northPane.add(new JLabel("                                  "));
			northPane.add(new JLabel("单号:"));
	        danHaoLabel.setForeground(Color.RED);
			northPane.add(danHaoLabel);
			 try {
					
				 String date = DateConventer.dateToStr(dataPicker.getSelectedDate(),"yyyy-MM-dd");
				 String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
				
				 ArrayList dan = JDBCTuiHuoDanJuFind.danJuId(date);
				
				 ArrayList sd = new ArrayList();
				 for(int i = 0;i < dan.size();i++){
					 String dan1 = dan.get(i).toString();
				
					 if(dan1.substring(2, 10).equals(s)){	 
						 sd.add(dan1);
					 }
				 }
				
				//以销售日期的年月日和它在当天单据号的顺序作为单据号
				 if(sd.size()==0){
					danHaoLabel.setText("XT"+s+"0001") ;
					
				 }else{
					 int max = 0;
					 String h = null;
					 for(int i = 0;i< sd.size();i++){
						    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
						 
				        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
				        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
				        		
				        	}
	
				    }
					 if(max+1>0 && max+1<10){
			        		h = "000"+(max+1);
			        	}else if(max+1>9 && max+1<100){
			        		h = "00"+(max+1);
			        	}else if(max+1 >99&& max+1< 1000){
			        		h = "0"+(max+1);
			        	}else {
			        		h = ""+(max+1);
			        	}
					 //单号
					danHaoLabel.setText("XT"+s+h) ;
			      }	} catch (ParseException e2) {
						
						e2.printStackTrace();
					}
			
			guKeTuiHuoPane.setLayout(new BorderLayout());
			guKeTuiHuoPane.add(northPane,BorderLayout.NORTH);
			guKeTuiHuoPane.add(createNorthPane(),BorderLayout.CENTER);
			
			return guKeTuiHuoPane;
			
		}
		/**
		 * 北部面板上组件的布局
		 * @return  北部面板
		 */
		public JPanel createNorthPane() {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			JPanel northPane = new JPanel();
			
			JPanel north = new JPanel();
			north.setLayout(new GridLayout(2,1));
			north.setBorder(new LineBorder(Color.GRAY));
			
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT,20,3);
			
			northPane.setLayout(layout);
			northPane.add(nameLabel);
			northPane.add(keHuText1);
			keHuButton.setMargin(new Insets(0,0,0,0));
			keHuButton.addMouseListener(new ChaZhaoKeHuButtonAction(this));
			northPane.add(keHuButton);
			northPane.add(shouHuoCangKuLabel);
			
			cangKuModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
			cangKuBox= new JComboBox(cangKuModel);
			northPane.add(cangKuBox);
			
		
			cangKuBox.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {
                  if(tableModel.getRowCount()== 0){
						
					}else{
						
						JOptionPane.showMessageDialog(dialog,
								"退货状态时不能更改仓库名称", "系统提示",  JOptionPane.QUESTION_MESSAGE, null);
						cangKuBox.setEditable(false);
						
					}
					
				}
				
			});
			
			northPane.add(riQiLabel);
			northPane.add(dataPicker);
			dataPicker.addActionListener(new DatePickerAlterAction(this));
			infoLabel.setBorder(new LineBorder(Color.GRAY));
			north.add(northPane);
			north.add(infoLabel);
			
			JPanel southPane = new JPanel();
			southPane.setBorder(new LineBorder(Color.GRAY));
			southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			southPane.add(beiZhuLabel);
			southPane.add(beiZhuText);
			beiZhuButton.setMargin(new Insets(0,0,0,0));
			southPane.add(beiZhuButton);
		    southPane.add(new JLabel("                               " ));
			southPane.add(sureButton);
			sureButton.addActionListener(new GuKeTuiHuoSureAction(this));
			southPane.add(tuiChuButton1);
			tuiChuButton1.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
		        	  if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(GuKeTuiHuoDialog.this,
		        			 "当前单据还没保存，是否退出？", "系统提示", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			
		        			  dispose();
		        		  }else {
		        			  
		        		  }
		        	  }
				    
				}
				
			});
			
			pane.add(north,BorderLayout.NORTH);
			pane.add(createCenterPane (),BorderLayout.CENTER);
			pane.add(southPane,BorderLayout.SOUTH);
			
			return pane;
		}
	

		public JButton getKeHuButton() {
			return keHuButton;
		}


		/**
		 * 顾客退货选项卡上的中间面板的组件的布局
		 * @return 中间面板
		 */
		public JPanel createCenterPane () {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			
			JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			northPanel.add(addButton);
			addButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					new AddTuiHuoGoodsDialog(GuKeTuiHuoDialog.this,"增加商品(销售退货)");
					
				}
				
			});
			
			alterButton.setVisible(false);
			northPanel.add(alterButton);
			alterButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
				
					new AlterGoodsDialog(GuKeTuiHuoDialog.this,"商品信息");
				}
				
			});
			deleteButton.setVisible(false);
			northPanel.add(deleteButton);
			deleteButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					int n = JOptionPane.showOptionDialog(dialog, "是否要删除该商品信息!", "系统提示", 
							  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
				    if(n == JOptionPane.YES_OPTION){
				    	int row = table.getSelectedRow();
				    	tableModel.removeRow(row);
				    }
				}
				
			});
			northPanel.add(tuiHuoButton);
			tuiHuoButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(tableModel.getRowCount()== 0){
						new DanJuChaXunDialog(GuKeTuiHuoDialog.this,"销售单据查询",true).setVisible(true);
					}else{
					
						JOptionPane.showMessageDialog(GuKeTuiHuoDialog.this,
								"请先保存本次的退货单价!", "系统提示", JOptionPane.DEFAULT_OPTION, null);
					}
				}
				
			});
            
			JPanel southPanel = new JPanel();
			
			southPanel.setBorder(new LineBorder(Color.GRAY));
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
			layout.setHgap(15);
			southPanel.setLayout(layout);
			southPanel.add(yingTuiMoneyLabel);
			southPanel.add(yingTuiText);
			
			yingTuiText.setText("0.0");
			southPanel.add(shiTuiMoneyLabel);
			southPanel.add(shiTuiText);
			shiTuiText.setText("0.0");
			southPanel.add(jingBanRenLabel);
			jinBanModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
			jingBanBox = new JComboBox(jinBanModel);
			southPanel.add(jingBanBox);
			jingBanButton.setMargin(new Insets(0,0,0,0));
			southPanel.add(jingBanButton);
			southPanel.add(new JLabel("                    "));
			
			
			JPanel centerPanel = new JPanel();
			tableModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,
					    TuiHuoTabelCulomnModel.BackColumNames);
			table = new JTable(tableModel);
			JScrollPane scroll = new JScrollPane(table);
			
			table.setAutoCreateRowSorter(true);
		
			table.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
	
			centerPanel.add(scroll);
			
			pane.add(northPanel,BorderLayout.NORTH);
			pane.add(centerPanel,BorderLayout.CENTER);
			pane.add(southPanel,BorderLayout.SOUTH);
			
			return pane;
		}
		
	
		
		public JButton getAlterButton() {
			return alterButton;
		}


		public JButton getDeleteButton() {
			return deleteButton;
		}


		/**
		 * 初始化退货查询面板
		 */
		public JPanel initTuiHuoChaXunPane(){
			
			tuiHuoChaXunPane.setLayout(new BorderLayout());
			tuiHuoChaXunPane.add(createNorthPanel(),BorderLayout.NORTH);
			tuiHuoChaXunPane.add(createCenterPanel1(),BorderLayout.CENTER);
		 
			return tuiHuoChaXunPane;
		}
		
		/**
		 * 退货查询面板的北部面板上组件的布局
		 * @return 北部面板
		 */
		public JPanel createNorthPanel(){
			JPanel northPanel = new JPanel();
			FlowLayout layout =new FlowLayout(FlowLayout.LEFT,25,3);
			northPanel.setLayout(layout);
			
			chaXunButton.setMargin(new Insets(0,0,0,0));
			chaXunButton.addActionListener(new GaoJiChaXunAction(this));
			
			chaKanButton.setMargin(new Insets(0,0,0,0));
			daoChuButton.setMargin(new Insets(0,0,0,0));
			tuiChuButton.setMargin(new Insets(0,0,0,0));
			northPanel.add(chaXunButton);
			northPanel.add(chaKanButton);
			northPanel.add(daoChuButton);
			northPanel.add(tuiChuButton);
			tuiChuButton.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
				    	 dispose();
				}
				
			});
			
		
			
			
			JPanel panel1 = new JPanel();
			JPanel pane1 = new JPanel();
			pane1.add(new JLabel("开单日期: "));
			pane1.add(dataPicker1);
			pane1.add(new JLabel(" 至   "));
			pane1.add(dataPicker2);
			shiJianButton.setMargin(new Insets(0,0,0,0));
			pane1.add(shiJianButton);
			
		  
			JPanel pane2 = new JPanel();
			pane2.add(new JLabel("客户/单据号:"));
			pane2.add(keHuText);
			pane2.add(chaXun);
			chaXun.addActionListener(new TuiHuoDanJuFindAction(this));
			panel1.setLayout(new GridLayout(2,1,2,4));
			panel1.add(pane1);
			panel1.add(pane2);
			
			
			northPanel.add(panel1);
			
			return northPanel;
		}
		
		/**
		 * 退货查询面板的中间面板上组件的布局
		 * @return 中间面板
		 */
		public JPanel createCenterPanel1(){
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new GridLayout(2,1));
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel2.add(new JLabel("单据的详细信息:"));
			panel2.add(information);
			
			panel.add(panel2,BorderLayout.NORTH);
			
			JPanel center = new JPanel();
			xiangXiModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.DanJuColumnNames);
		    xiangXiTable = new JTable(xiangXiModel);
			JScrollPane scroll = new JScrollPane(xiangXiTable);
			xiangXiTable.setAutoCreateRowSorter(true);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			xiangXiTable.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
			center.add(scroll);
			panel.add(center,BorderLayout.CENTER);
			
		
			JPanel center2 = new JPanel();
			danJuModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.QueryColumnNames);
		    danJuTable = new JTable(danJuModel);
			JScrollPane scroll2 = new JScrollPane(danJuTable);
			danJuTable.setAutoCreateRowSorter(true);
			danJuTable.addMouseListener(new TuiHuoMouseListener(this,danJuTable.getSelectedRow()));
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			danJuTable.setPreferredScrollableViewportSize(new Dimension(780,356));//表格固定大小
			center2.add(scroll2);
			
			
			centerPanel.add(center2);
			centerPanel.add(panel);
			return centerPanel;
		}
		/**
		 * 给顾客退货选项卡上的表初始化时
		 * 增添数据.数据来源于销售单据查询对话框上
		 * 的销售单据详表
		 */
		public void addData(){
			AllTableModel tableModel = dialog.getTabelModel2();
			table.setModel(tableModel);
		
		}
		
		public JTable getTable() {
			return table;
		}


		public AllTableModel getTableModel() {
			return tableModel;
		}
		public JTextField getKeHuText1() {
			return keHuText1;
		}


		public JTextField getKeHuText() {
			return keHuText;
		}


		public JTable getDanJuTable() {
			return danJuTable;
		}


		public JTable getXiangXiTable() {
			return xiangXiTable;
		}


	    public JLabel getInformation() {
			return information;
		}


		public AllTableModel getDanJuModel() {
			return danJuModel;
		}


		public AllTableModel getXiangXiModel() {
			return xiangXiModel;
		}


		public JDatePicker getDataPicker1() {
			return dataPicker1;
		}


		public JDatePicker getDataPicker2() {
			return dataPicker2;
		}
		public JLabel getInfoLabel() {
			return infoLabel;
		}


		public JComboBox getJingBanBox() {
			return jingBanBox;
		}


		public JTextField getShiTuiText() {
			return shiTuiText;
		}


		public JTextField getYingTuiText() {
			return yingTuiText;
		}
	/*//测试类
	public static void main(String[] args) {
		new GuKeTuiHuoDialog((JFrame)null,"顾客退货",true);
		

	}*/


	public Vector<Vector> getData() {
		return data;
	}


	public JTextField getBeiZhuText() {
		return beiZhuText;
	}


	public JComboBox getCangKuBox() {
		return cangKuBox;
	}


	public JLabel getDanHaoLabel() {
		return danHaoLabel;
	}


	public JDatePicker getDataPicker() {
		return dataPicker;
	}


	public MainFrame getMainFrame() {
		return mainFrame;
	}


}
