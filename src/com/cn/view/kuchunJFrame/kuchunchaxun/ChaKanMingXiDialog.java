package com.cn.view.kuchunJFrame.kuchunchaxun;

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
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cn.control.kuchunframe.kucunchaxun.ChaKanSPMingXiBtnAction;
import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * 库存查询里面的查看明细
 * @author finey
 *
 */
public class ChaKanMingXiDialog extends JDialog {
	//商品名称
	private JLabel spName = new JLabel("统一冰红茶");
	//商品总额
	private JLabel spSumE = new JLabel("0.00元");
	//商品利润
	private JLabel spAllInterest= new JLabel("0.00元");
   //两个日期段
	private JDatePicker dateFrom;
	public JDatePicker getDateFrom() {
		return dateFrom;
	}
	public JDatePicker getDateTo() {
		return dateTo;
	}

	private JDatePicker dateTo;
	
	
	//仓库
	private JComboBox canKuBox = new JComboBox(
			JDBCCuCunFind.getCanKuData());
	
	public JComboBox getCanKuBox() {
		return canKuBox;
	}

	//表格
	private AllTableModel tableMO;
	private JTable detailTable;
	
	
	public AllTableModel getTableMO() {
		return tableMO;
	}

	//统计栏
	private JLabel danJuNum = new JLabel("单据数："+0);
	
	public JLabel getDanJuNum() {
		return danJuNum;
	}

	//所查商品编号
	private String spIdFromP =null;
	
	public String getSpIdFromP() {
		return spIdFromP;
	}
	public ChaKanMingXiDialog(KuCunChaXunFrame frame,String title,int num){
		super(frame,title,true);
		init();
		if(num ==1){
			addDataForOne();
		}
		if(num ==2){
			addDataForTwo();
		}
		this.setVisible(true);
			
		
		
	}
	/*
	 * 第一个表的明细初始化
	 */
	private void addDataForOne(){
		
		int row = ((KuCunChaXunFrame)this.getOwner()).
					getHysxtable1().getSelectedRow();
		String spId =  ((KuCunChaXunFrame)this.getOwner()).
					getTableModel().getValueAt(row, 0).toString();
		//商品编号或名称
		String spName1 = ((KuCunChaXunFrame)this.getOwner()).
		getTableModel().getValueAt(row,1).toString();
		//商品编号或名称
        spName.setText(spName1);
        spIdFromP = spId;
		Vector data = DanQianKuCunJDBC.getSPMingXiData(
				"1-1-1","2222-1-1",spId,"所有仓库");
		tableMO.setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunDeTailFind));
		this.getDanJuNum().setText("单据数: "+data.size()); 
	}
	/*
	 * 第二个表的明细初始化
	 */
	private void addDataForTwo(){
		int row = ((KuCunChaXunFrame)this.getOwner()).
				getHysxtable2().getSelectedRow();
		String spId =  ((KuCunChaXunFrame)this.getOwner()).
				getTableMode2().getValueAt(row, 0).toString();
		 spIdFromP = spId;
		String spName1 = ((KuCunChaXunFrame)this.getOwner()).
		getTableMode2().getValueAt(row,1).toString();
		//商品编号或名称
        spName.setText(spName1);
		Vector data = DanQianKuCunJDBC.getSPMingXiData(
				"1-1-1","2222-1-1",spId,"所有仓库");
         
		tableMO.setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunDeTailFind));
		this.getDanJuNum().setText("单据数: "+data.size()); 
	}
	
	private void init(){
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(addPane());
		canKuBox.addItem("所有仓库");
		canKuBox.setSelectedIndex(canKuBox.getItemCount()-1);
		
	}

	
	private JPanel addPane(){
		JPanel pane =new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPane = addNorthPane();
		
		JPanel centerTablePane = addCenterPane();
		
		JPanel southPane = addSouthPane();
		pane.add(northPane,BorderLayout.NORTH);
		pane.add(new JScrollPane(centerTablePane));
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	/*
	 * 北面工具栏建立
	 */
	private JPanel addNorthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		//单据过滤
		JButton djglBtn = new JButton(
				new ImageIcon("res/AcionIcon/zhengdanguolv.jpg"));
		djglBtn.setMargin(new Insets(0,0,0,0));
		//查看单据
		JButton ckdjBtn = new JButton(
				new ImageIcon("res/AcionIcon/chakandanju.jpg"));
		ckdjBtn.setMargin(new Insets(0,0,0,0));
		//导出
		JButton exportBtn = new JButton(
				new ImageIcon("res/AcionIcon/export.jpg"));
		exportBtn.setMargin(new Insets(0,0,0,0));
		//退出
		JButton exitBtn = new JButton(
				new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ChaKanMingXiDialog.this.dispose();
			}
			
		});
		
		pane.add(djglBtn);
		pane.add(ckdjBtn);
		pane.add(exportBtn);
		pane.add(exitBtn);
		
		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(2,1,2,5));
		
		JPanel tmp = new JPanel();
		tmp.setLayout(new FlowLayout(FlowLayout.LEFT,50,2));
		
		JPanel intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("商品名称: "));
		spName.setForeground(Color.red);
		intmPane.add(spName);
		tmp.add(intmPane);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("出货总额: "));
		spSumE.setForeground(Color.red);
		intmPane.add(spSumE);
		tmp.add(intmPane);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("出货利润: "));
		spAllInterest.setForeground(Color.red);
		intmPane.add(spAllInterest);
		tmp.add(intmPane);
		
		gridPane.add(tmp);
		
		intmPane = new JPanel();
		intmPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		intmPane.add(new JLabel("查询日期: "));
		dateFrom = new JDatePicker(JDatePicker.STYLE_CN_DATE);
		intmPane.add(dateFrom);
		intmPane.add(new JLabel("至 "));
		dateTo = new JDatePicker(JDatePicker.STYLE_CN_DATE);
		intmPane.add(dateTo);
		intmPane.add(new JLabel("所在仓库: "));
		intmPane.add(canKuBox);
		JButton findBtn = new JButton("查 询");
		findBtn.addActionListener(new ChaKanSPMingXiBtnAction(this));
		intmPane.add(findBtn);
		
		gridPane.add(intmPane);
		pane.add(gridPane);
		
		return pane;
	}
	/*
	 *中间表格建立
	 */
	private JPanel addCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		tableMO = new AllTableModel(KuCunKunCBDCulomns.data,
				KuCunKunCBDCulomns.KuCunDeTailFind);
		detailTable = new JTable(tableMO);
		detailTable.setPreferredScrollableViewportSize(
				new Dimension(1200, 400));
		detailTable.setAutoCreateRowSorter(true);
		
		pane.add(new JScrollPane(detailTable));
		return pane;
	}
	
	/*
	 * 南面统计栏栏建立
	 */
	private JPanel addSouthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
		pane.add(danJuNum);
		return pane;
	}
	
	public static void main(String[] args) {
		new ChaKanMingXiDialog(null,"商品明细",0);
	}

}
