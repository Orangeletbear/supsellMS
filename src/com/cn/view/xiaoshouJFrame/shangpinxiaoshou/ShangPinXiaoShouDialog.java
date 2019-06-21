package com.cn.view.xiaoshouJFrame.shangpinxiaoshou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.DataPickerAlterAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.ShangPinXiaoShou_SureAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.util.PrintTableData;
import com.cn.view.toolbar.TableCulomnModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AlterXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.KeHuWind;

/**
 * 商品销售对话框
 * @author Administrator
 *
 */
public class ShangPinXiaoShouDialog extends JDialog {
	
	private JPanel mainPanel = new JPanel();
	
	//定义面板上部的组件
	//private JPanel topPanel ;
	//单号标签
	private JLabel danHaoLabel = new JLabel("");
	//客户名称文本框
	private JTextField  keHuText = new JTextField(10);
	//查询客户按钮
    private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
    //仓库Box
    private ComboBoxModel cangKuModel ;
	private JComboBox cangKuBox ;
	//
	
	//时间
	private JDatePicker dataPicker =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
   //添加商品按钮
	private JButton addButton = new JButton("添加商品(F2)");
	//修改商品按钮
	private JButton alterButton = new JButton("修改商品(F3)");
	//删除商品按钮
	private JButton deleteButton = new JButton("删除商品(F4)");
	
	//导出导入按钮
	private JButton daoRuButton = new JButton("导入导出(F7)");
	
	//定义表格
    private JTable table;

	//存放表格中的数据
	Vector<Vector> data  = new Vector<Vector>();
	
	private AllTableModel tableModel ;
	//应收金额文本框
	private JTextField yingShouText = new JTextField(6);
	//实收金额文本框
	private JTextField shiShouText = new JTextField(6);
	//经办人Box
	private JComboBox jingBanBox ;
	private ComboBoxModel jinBanModel;
	//查询经办人按钮
	private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//原始单号文本框
	private JTextField danHaoText = new JTextField(10);
	//备注文本框
	private JTextField beiZhuText = new JTextField(20);
	//查看备注信息按钮
	private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//确定按钮
	private JButton sureButton = new JButton("确定");
	//退出按钮
	private JButton tuiChuButton = new JButton("退出");
	
	//无参构造方法
	public ShangPinXiaoShouDialog(){
		
	}
	//带参构造方法
	public ShangPinXiaoShouDialog(JFrame frame,String title,boolean modal){
		super(frame,title,modal);
		
		init();
		
	}
	public void init() {
		
		this.setSize(680, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initMainPanel();
		this.add(mainPanel);
		
		this.setVisible(true);
		
	}
	
	public void initMainPanel(){
		JPanel northPane = new JPanel();
		northPane.add(new JLabel("                                     "));
		northPane.add(new JLabel("商品销售"));
		northPane.add(new JLabel("                                  "));
		JLabel label = new JLabel("单号:");
		northPane.add(label);
		northPane.add(danHaoLabel);
		 try {
				
			 String date = DateConventer.dateToStr(dataPicker.getSelectedDate(),"yyyy-MM-dd");
			 String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
			 ArrayList dan = JDBCFindGoodsInfo.danJu(date);
			 ArrayList sd = new ArrayList();
			 for(int i = 0;i < dan.size();i++){
				 String dan1 = dan.get(i).toString();
				 if(dan1.substring(2, 10).equals(s)){	 
					 sd.add(dan1);
				 }
			 }
			//以销售日期的年月日和它在当天单据号的顺序作为单据号
			 if(sd.size()==0){
				danHaoLabel.setText("XS"+s+"0001") ;
				
			 }else{
				 int max = 0;
				 String h = null;
				 for(int i = 0;i< sd.size();i++){
					    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
					 
			        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
			        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
			        	}
			        	
			    }
				 if(max>0 && max+1<10){
		        		h = "000"+(max+1);
		        	}else if(max+1>9 && max+1<100){
		        		h = "00"+(max+1);
		        	}else if(max+1 >99&& max+1< 1000){
		        		h = "0"+(max+1);
		        	}else {
		        		h = ""+(max+1);
		        	}
				 //单号
				danHaoLabel.setText("XS"+s+h) ;
		      }	} catch (ParseException e2) {
					
					e2.printStackTrace();
				}
		
		danHaoLabel.setForeground(Color.RED);
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPane,BorderLayout.NORTH);
		mainPanel.add(createNorthPane(),BorderLayout.CENTER);
		 	
		
	}
	/**
	 * 
	 * @return
	 */
	public JPanel createNorthPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		
		
		JPanel panel1 = new JPanel();
		FlowLayout layout =new FlowLayout(FlowLayout.LEFT);
		panel1.setBorder(new LineBorder(Color.GRAY));
		layout.setHgap(15);
		panel1.setLayout(layout);
		panel1.add(new JLabel("客户名称:"));
		panel1.add(keHuText);
		keHuButton.setMargin(new Insets(0,0,0,0));
	
		keHuButton.addMouseListener(new MouseAdapter(){
			
		
			public void mouseClicked(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
			    int y = arg0.getYOnScreen();
			    
				new KeHuWind(ShangPinXiaoShouDialog.this).setLocation(x-190,y-20);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});


	
		panel1.add(keHuButton);	
		panel1.add(new JLabel("出货仓库:"));
		cangKuModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
		cangKuBox= new JComboBox(cangKuModel);
		panel1.add(cangKuBox);
		panel1.add(new JLabel("销售日期:"));
		panel1.add(dataPicker);
		dataPicker.addActionListener(new DataPickerAlterAction(this));
		dataPicker.setEditable(false);//设置为不可编辑;
		
		JPanel southPane = new JPanel();
		southPane.setBorder(new LineBorder(Color.GRAY));
		southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPane.add(new JLabel("备注:"));
		southPane.add(beiZhuText);
		beiZhuButton.setMargin(new Insets(0,0,0,0));
		southPane.add(beiZhuButton);
	    southPane.add(new JLabel("                               "));
		southPane.add(sureButton);
		sureButton.addActionListener(new ShangPinXiaoShou_SureAction(this));
		southPane.add(tuiChuButton);
		
		tuiChuButton.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
		        	  if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(ShangPinXiaoShouDialog.this,
		        			 "当前单据还没保存，是否退出？", "系统提示", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			  dispose();
		        		  }else {
		        			  
		        		  }
		        	  }
				    
				}
 				
 			});
		
		pane.add(panel1,BorderLayout.NORTH);
		pane.add(createCenterPane (),BorderLayout.CENTER);
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	
	/**
	 * 初始化中间面板
	 * @return
	 */
	public JPanel createCenterPane () {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.add(addButton);
		addButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			new AddXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"增加商品(商品销售)");
			}
			
		});
		alterButton.setVisible(false);
		alterButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new AlterXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"商品信息");
				
			}
			
		});
		deleteButton.setVisible(false);
		northPanel.add(alterButton);
		northPanel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showOptionDialog(ShangPinXiaoShouDialog.this, "是否要删除该商品信息!", "系统提示", 
						  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			    if(n == JOptionPane.YES_OPTION){
			    	int row = table.getSelectedRow();
			    	tableModel.removeRow(row);
			    }
			}
			
		});
		northPanel.add(daoRuButton);
		
		daoRuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", table, 
						XiaoShouCulomnModel.columnNames);
			}
			
		});
		JPanel southPanel = new JPanel();
		
		southPanel.setBorder(new LineBorder(Color.GRAY));
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPanel.add(new JLabel("应收金额:"));
		southPanel.add(yingShouText);
		southPanel.add(new JLabel("实收金额:"));
		southPanel.add(shiShouText);
		southPanel.add(new JLabel("经办人:"));
		jinBanModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
		jingBanBox = new JComboBox(jinBanModel);
		southPanel.add(jingBanBox);
		jingBanButton.setMargin(new Insets(0,0,0,0));
		southPanel.add(jingBanButton);
		southPanel.add(new JLabel("原始单号:"));
		southPanel.add(danHaoText);
		
		JPanel center = new JPanel();
		tableModel = new AllTableModel(data,
				            AllTableModel.getVectorFromObj(XiaoShouCulomnModel.columnNames));
	    table = new JTable(tableModel);
	
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
					new AlterXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"商品信息");
				}
			}
		});
		
		
		table.setPreferredScrollableViewportSize(new Dimension(670,356));//表格固定大小
		center.add(scroll);
		center.setOpaque(true);
		
		pane.add(northPanel,BorderLayout.NORTH);
		pane.add(center,BorderLayout.CENTER);
		pane.add(southPanel,BorderLayout.SOUTH);
		
		return pane;
	}
	
	public JLabel getDanHaoLabel() {
		return danHaoLabel;
	}
	public JTextField getKeHuText() {
		return keHuText;
	}
	public ComboBoxModel getCangKuModel() {
		return cangKuModel;
	}
	public JComboBox getCangKuBox() {
		return cangKuBox;
	}

	public Vector<Vector> getData() {
		return data;
	}
	public JDatePicker getDataPicker() {
		return dataPicker;
	}
	public JTable getTable() {
		return table;
	}
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public JTextField getYingShouText() {
		return yingShouText;
	}
	public JTextField getShiShouText() {
		return shiShouText;
	}
	public JComboBox getJingBanBox() {
		return jingBanBox;
	}
	public JButton getAlterButton() {
		return alterButton;
	}
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public ComboBoxModel getJinBanModel() {
		return jinBanModel;
	}
	public JTextField getDanHaoText() {
		return danHaoText;
	}
	public JTextField getBeiZhuText() {
		return beiZhuText;
	}
	//测试类
	public static void main(String[] args) {
		new ShangPinXiaoShouDialog(null,"商品销售",true);
		

	}

}

