package com.cn.view.xiaoshouJFrame.POS;

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.util.DateConventer;

/**
 * POS收银员收银统计对话框
 * 
 * @author Administrator
 *
 */
public class ShouYinTongJiDialog extends JDialog {
	
	//查看明细按钮
	private JButton chaKanMingXiButton = new JButton(new ImageIcon("res/AcionIcon/chakanmingxi.jpg"));
	//查看单据按钮
	private JButton chaKanDanJuButton = new JButton(new ImageIcon("res/AcionIcon/chakandanju.jpg"));
	//导出按钮
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//打印按钮
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	//退出按钮
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	//panel2_center
    //查询时间面板
	private TimeSpinnerPanel timeChaXun = new TimeSpinnerPanel();
	//查询时间按钮
	private JButton timeButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//收银员Box
	private JComboBox shouYinYuanBox = new JComboBox(
			XPOSJDBCControl.getAllPOSChaoZhuoYuanData());
	//查询按钮
	private JButton chaXunButton = new JButton("查询(F2)");
	//收银明细标签
	private JLabel  shouYinMingXiLabel = new JLabel();
	
	//收银员统计表
	private JTable sytjTable;
	private AllTableModel sytjModel;
  
	//收银员收银明细表
	private JTable symxTable;
	private AllTableModel symxModel;
	

	
	public TimeSpinnerPanel getTimeChaXun() {
		return timeChaXun;
	}

	public JComboBox getShouYinYuanBox() {
		return shouYinYuanBox;
	}

	public JLabel getShouYinMingXiLabel() {
		return shouYinMingXiLabel;
	}

	public JTable getSytjTable() {
		return sytjTable;
	}

	public AllTableModel getSytjModel() {
		return sytjModel;
	}

	public JTable getSymxTable() {
		return symxTable;
	}

	public AllTableModel getSymxModel() {
		return symxModel;
	}

	public ShouYinTongJiDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		//this.setSize(900, 550);
		this.setResizable(false);
		this.add(panel2());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		initData();
		this.setVisible(true);
	}
	private void initData(){
		Vector data = XPOSJDBCControl.getPOSShouYingYuanShouFei("2000-1-1","2222-2-2","");
		this.getSytjModel().setDataVector(data,
		   AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.shouYinColumNames));
		
	}
	
	private JPanel panel2(){
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new BorderLayout());
		panel2.add(panel2_north(),BorderLayout.NORTH);
		panel2.add(panel2_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("");
		panel2.add(label,BorderLayout.SOUTH);
		
		return panel2;
	}
	
	//panel2_north
	private JPanel panel2_north(){
		JPanel panel2_north = new JPanel();
		
		chaKanMingXiButton.setMargin(new Insets(0,0,0,0));
		chaKanDanJuButton.setMargin(new Insets(0,0,0,0));
		daoChuButton.setMargin(new Insets(0,0,0,0));
		daYinButton.setMargin(new Insets(0,0,0,0));
		tuiChuButton.setMargin(new Insets(0,0,0,0));
		
		panel2_north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		panel2_north.add(chaKanMingXiButton);
		panel2_north.add(chaKanDanJuButton);
		panel2_north.add(daoChuButton);
		panel2_north.add(daYinButton);
		panel2_north.add(tuiChuButton);
		
		tuiChuButton.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			    	dispose();
			}
		});
		
		panel2_north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		return panel2_north;
	}
	
	//panel2_center 分为两部分
	private JPanel panel2_center(){
		JPanel panel2_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		pane2.setLayout(new GridLayout(2,1));
		
	
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,15,2));
		pane1.add(new JLabel("查看日期:"));
		pane1.add(timeChaXun);
		timeButton.setMargin(new Insets(0,0,0,0));
		pane1.add(timeButton);
		pane1.add( new JLabel("收银员 :"));
		pane1.add( shouYinYuanBox);
		pane1.add(chaXunButton);
		shouYinYuanBox.addItem("所有收银员");
		shouYinYuanBox.setSelectedItem("所有收银员");
		pane1.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		chaXunButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String syID = ShouYinTongJiDialog.this
				         .getShouYinYuanBox().getSelectedItem().toString();

				if("所有收银员".equals(syID)){
					syID = "";
				}
				
	
				String dateFrom = null;
				String dateTo = null;
				try {
					dateFrom = DateConventer.dateToStr(
							ShouYinTongJiDialog.this.getTimeChaXun().
							getDataPicker1().getSelectedDate(),"yyyy-MM-dd");
					
					dateTo = DateConventer.dateToStr(
							ShouYinTongJiDialog.this.getTimeChaXun().
							getDataPicker2().getSelectedDate(),"yyyy-MM-dd");
					
				
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				
				Vector data = XPOSJDBCControl.getPOSShouYingYuanShouFei(
						dateFrom,dateTo,syID);
				
				getSytjModel().setDataVector(data,
				   AllTableModel.getVectorFromObj(
						   POSXiaoShouCulomnModel.shouYinColumNames));
			}
			
		});
		sytjModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				                    POSXiaoShouCulomnModel.shouYinColumNames);
		sytjTable = new JTable(sytjModel);
		sytjTable.setPreferredScrollableViewportSize(new Dimension(880,150));//表格固定大小
		sytjTable.setAutoCreateRowSorter(true);
		
		symxModel = new AllTableModel(POSXiaoShouCulomnModel.obj,
				POSXiaoShouCulomnModel.shouYinMingXiColumNames);
		symxTable = new JTable(symxModel);
		symxTable.setPreferredScrollableViewportSize(new Dimension(880,150));//表格固定大小
		symxTable.setAutoCreateRowSorter(true);
		
		pane3.setLayout(new BorderLayout());
		JPanel pane4 = new JPanel();
		pane4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane4.add(new JLabel("收银员收银明细:"));
		pane4.add(shouYinMingXiLabel);
		pane3.add(pane4,BorderLayout.NORTH);
		pane3.add(new JScrollPane(symxTable));
		
		
		pane2.add(new JScrollPane(sytjTable));
		pane2.add(pane3);
		
		
		panel2_center.setLayout(new BorderLayout());
		panel2_center.add(pane1,BorderLayout.NORTH);
		panel2_center.add(pane2,BorderLayout.CENTER);
		
		sytjTable.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() ==1){
					
					//取得表中选择行的收银员编号
					String syId = ShouYinTongJiDialog.this.getSytjModel().
			         getValueAt(ShouYinTongJiDialog.this.getSytjTable().
			        		 getSelectedRow(), 0).toString();
					Vector data = XPOSJDBCControl.getPOSShouYingYuanShouFeiMingXi(syId);
					
					getSymxModel().setDataVector(data,
					   AllTableModel.getVectorFromObj(
							   POSXiaoShouCulomnModel.shouYinMingXiColumNames));
				}
			}

		});
		
		
		return panel2_center;
	}
	
	//测试类
	public static void main(String[] args) {
		new ShouYinTongJiDialog(null,"收银员收银统计",true);
		

	}
}
