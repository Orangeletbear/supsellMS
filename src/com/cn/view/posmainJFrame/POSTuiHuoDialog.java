package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.control.posmainframe.POSTuiHuoKeyListener;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.util.DateConventer;
/*
 * 退货记录对话框
 */
public class POSTuiHuoDialog extends JDialog {
	
	private POSFrame frame;
	//退货单号
	JLabel tuiHuoID = new JLabel(" ");
	//销售单号
	JTextField xsIS = new JTextField(14);
	//销售日期
	JLabel xsDate = new JLabel(DateConventer.dateToStr(new Date()));
	//会员编号
	JLabel hyID = new JLabel("02");
	
	JCheckBox printXP = new JCheckBox("打印小票");
	
	//商品条码
	JTextField sptm = new JTextField(14);
	//商品表的序号
	int count = 1;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	//商品表
	JTable spTable;
   AllTableModel defaultModel;
	//用来存放商品表中的数据
	Vector data = new Vector();
	//退货总数量
	JLabel number = new JLabel("0");
	//退货总金额
	JLabel sum = new JLabel("0.0");
	
	public POSTuiHuoDialog(POSFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(800,500));
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
	    
	    JPanel nothPane = initNorthPane();
	    
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    mainPane.add(nothPane,BorderLayout.NORTH);
	    
		return mainPane;
	}
	
	 public JPanel initNorthPane(){
		 JPanel pane = new JPanel();
		 pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,8));
		 
		 pane.add(new JLabel("退货单号:"));
		 tuiHuoID.setForeground(Color.red);
		 pane.add(tuiHuoID);
		 tuiHuoID.setText(getDanJuNumner());
		 pane.add(new JLabel("销售单号(F6):"));
		 
		 pane.add(xsIS);
		 xsIS.addKeyListener(new POSTuiHuoKeyListener(this));
		 JLabel tmpLab = new JLabel("输入后回车:");
		 tmpLab.setForeground(Color.red);
		 pane.add(tmpLab);
		 pane.add(new JLabel("销售日期:"));
		 
		 pane.add(xsDate);
		 pane.add(new JLabel("会员编号:"));
		 pane.add(hyID);
			
		 return pane;
	 }
	 
	public JLabel getHyID() {
		return hyID;
	}

	public JLabel getNumber() {
		return number;
	}

	public JCheckBox getPrintXP() {
		return printXP;
	}

	public JTable getSpTable() {
		return spTable;
	}

	public AllTableModel getDefaultModel() {
		return defaultModel;
	}

	public JTextField getSptm() {
		return sptm;
	}

	public JLabel getSum() {
		return sum;
	}

	public JLabel getTuiHuoID() {
		return tuiHuoID;
	}

	public JLabel getXsDate() {
		return xsDate;
	}

	public JTextField getXsIS() {
		return xsIS;
	}

	public POSFrame getFrame() {
		return frame;
	}

	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		 pane.setLayout(new BorderLayout());
		 
		 JPanel northPane = new JPanel();
		 northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,8));
		 northPane.add(printXP);
		 northPane.add(new JLabel("  商品条码(F2):"));
		 northPane.add(sptm);
		 sptm.addKeyListener(new POSTuiHuoKeyListener(this));
		 
		 JButton deleBtn = new JButton("删除(F3)");
		 JButton numBtn = new JButton("数量(F4)");
		 JButton okBtn = new JButton("确定(F5)");
		 JButton cancerBtn = new JButton("退出(F7)");
		 cancerBtn.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					POSTuiHuoDialog.this.dispose();
				}
				
			});
		 northPane.add(deleBtn);
		 northPane.add(numBtn);
		 northPane.add(okBtn);
		 northPane.add(cancerBtn);
		 
		 pane.add(northPane,BorderLayout.NORTH);
		 
		 defaultModel = new AllTableModel(data,
				  AllTableModel.getVectorFromObj(POSTableModel.SPCulomns));
		 spTable = new JTable(defaultModel); 
		
		 spTable.setPreferredScrollableViewportSize(new Dimension(690,300));
		 spTable.setAutoCreateRowSorter(true);
	     spTable.addKeyListener(new POSTuiHuoKeyListener(this));
		 pane.add(new JScrollPane(spTable));
		 
		 JPanel southPane = new JPanel();
		 southPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,4));
		 southPane.add(new JLabel("退货数量: "));
		 southPane.add(number);
		 southPane.add(new JLabel("退货总金额: "));
		 southPane.add(sum);
		 pane.add(southPane,BorderLayout.SOUTH);
		 

		 return pane;
	}
	private String getDanJuNumner(){
		String date = DateConventer.dateToStr(new Date());

	    String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		
		ArrayList dan = JDBC_POS_GetInfo.get_pos_xsth_id(date);
		
		 ArrayList sd = new ArrayList();
		 for(int i = 0;i < dan.size();i++){
			 String dan1 = dan.get(i).toString();
		
			 if(dan1.substring(2, 10).equals(s)){	 
				 sd.add(dan1);
			 }
		 }
		
		//以系统日期的年月日和它在当天单据号的顺序作为单据号
		 if(sd.size()==0){
			
			 return "XT"+s+"0001";
			
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
			 return "XT"+s+h;
	      }
	}
	public Vector getData() {
		return data;
	}

	public static void main(String[] args) {
		new POSTuiHuoDialog(null,"退货",true);
	}
}
