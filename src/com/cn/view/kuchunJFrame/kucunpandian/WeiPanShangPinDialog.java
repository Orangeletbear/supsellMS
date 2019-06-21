package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucunpandian.ShowCardAction;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCPDModel;

public class WeiPanShangPinDialog extends JDialog {
	private PanYingPanKuiJDialog dialog;
	private JLabel labelSPSL;//未盘的商品数量
	private AllTableModel tablemodel2;
	private JTable table2;
	private Vector vo2 = new Vector();
	private Vector ve2 = new Vector();
	private JButton btnExit;//
	
	public WeiPanShangPinDialog (PanYingPanKuiJDialog dialog,String title ,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	///////////////////////////
	public PanYingPanKuiJDialog getDialog() {
		return dialog;
	}

	public JLabel getLabelSPSL() {
		return labelSPSL;
	}
	public AllTableModel getTablemodel2() {
		return tablemodel2;
	}

	public JTable getTable2() {
		return table2;
	}

	public Vector getVo2() {
		return vo2;
	}

	public void setVo2(Vector vo2) {
		this.vo2 = vo2;
	}
	public Vector getVe2() {
		return ve2;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	private void init(){
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
	}
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		
		{
			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
		return jpanel;
	}
	private JPanel addNor(){
		JPanel norJpanel = new JPanel();
		norJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel label = new JLabel("注意：未盘点的商品不能直接在此窗口中增加，必须从盘点仓库中的仓库中选择！");
		label.setForeground(Color.RED);
		norJpanel.add(label);
		
		return norJpanel;
	}
	private JPanel addCen(){
		JPanel tJpanel = new JPanel();
		tJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//////////////////////
		JPanel jpanel2 = new JPanel();
		////加表格
		vo2 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK4);
		ve2 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK4);
		tablemodel2 = new AllTableModel(vo2,ve2);
		table2 = new JTable(tablemodel2);
		table2.setAutoCreateRowSorter(true); //此语句让表格自动排序
		table2.setPreferredScrollableViewportSize(new Dimension(770,360));
		JScrollPane scroPane = new JScrollPane(table2);
		jpanel2.add(scroPane);
		jpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
//		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"选择盘点单"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
//		System.out.println(vo2.size());//无法统计数据
		JLabel label31 = new JLabel("记录数：");
		labelSPSL = new JLabel();
		labelSPSL.setForeground(Color.RED);
		
		jpanel3.add(label31);
		jpanel3.add(labelSPSL);
		
		
		
		{
//			tJpanel.add(jpanel1,BorderLayout.NORTH);
			tJpanel.add(jpanel2,BorderLayout.CENTER);
			tJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		tJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"所有未盘商品"));
		return tJpanel;
	}
	/*
	 * 南部按钮面板
	 */
	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		btnExit = new JButton("退出");
		
		{
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					WeiPanShangPinDialog.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnExit);
		}
		souJpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,30,20));
		return souJpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WeiPanShangPinDialog(null,"未盘商品",true).setVisible(true);
	}
}
