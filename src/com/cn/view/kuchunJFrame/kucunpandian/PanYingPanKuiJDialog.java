package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucunpandian.ShowCardAction;
import com.cn.control.kuchunframe.kucunpandian.panyingpankui.PanYingPanKuiActionListener;
import com.cn.dao.MFrameJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.view.kuchunJFrame.KucunPandian;
/**
 * 盘盈盘亏界面
 * 总体布局按cardlayout
 * @author Administrator
 *
 */
public class PanYingPanKuiJDialog extends JDialog {
	private KucunPandian dialog;
	private JPanel cenJpanel;
	
	private AllTableModel tablemodel1;
	private JTable table1;
	private Vector vo1 = new Vector();
	private Vector ve1 = new Vector();
	
	private AllTableModel tablemodel2;
	private JTable table2;
	private Vector vo2 = new Vector();
	private Vector ve2 = new Vector();
	
	private AllTableModel tablemodel3;
	private JTable table3;
	private Vector vo3 = new Vector();
	private Vector ve3 = new Vector();
	
	private CardLayout cardlayout;
	private JComboBox comboCK;//仓库名称
	private JComboBox comboCZY;//操作员
	private JButton btnCX;//查询
	private JLabel labelPDDS;//盘点单数
	private JLabel labelJLS1;//第二步表格的商品总数
	private JLabel labelJLS2;//第三步表格的商品总数
	
	private JButton btnNext;//
	private JButton btnLast;//
	private JButton btnWP;//未盘商品
	private JButton btnXZ;//修正库存
	private JButton btnExit;//
	
	public PanYingPanKuiJDialog (KucunPandian dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	///////////////////////////
	
	public KucunPandian getDialog() {
		return dialog;
	}

	public JPanel getCenJpanel() {
		return cenJpanel;
	}

	public AllTableModel getTablemodel1() {
		return tablemodel1;
	}

	public JTable getTable1() {
		return table1;
	}
	
	public JLabel getLabelPDDS() {
		return labelPDDS;
	}
	public Vector getVo1() {
		return vo1;
	}

	public Vector getVe1() {
		return ve1;
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

	public Vector getVe2() {
		return ve2;
	}

	public AllTableModel getTablemodel3() {
		return tablemodel3;
	}

	public JTable getTable3() {
		return table3;
	}

	public Vector getVo3() {
		return vo3;
	}

	public Vector getVe3() {
		return ve3;
	}

	public CardLayout getCardlayout() {
		return cardlayout;
	}

	public JComboBox getComboCK() {
		return comboCK;
	}

	public JComboBox getComboCZY() {
		return comboCZY;
	}

	public JButton getBtnCX() {
		return btnCX;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public JButton getBtnWP() {
		return btnWP;
	}

	public JButton getBtnXZ() {
		return btnXZ;
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
//			jpanel.add(addNor(),BorderLayout.NORTH);
			jpanel.add(addCen(),BorderLayout.CENTER);
			jpanel.add(addSou(),BorderLayout.SOUTH);
		}
		return jpanel;
	}

	private JPanel addCen(){
		cenJpanel = new JPanel();
		cardlayout = new CardLayout();
		cenJpanel.setLayout(cardlayout);
		
		{
			cenJpanel.add("first",first());
			cenJpanel.add("second",second());
			cenJpanel.add("third",third());
		}
		
		return cenJpanel;
	}
	

	
	//中间面板的第一个面板
	private JPanel first(){
		JPanel fiJpanel = new JPanel();
		fiJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel label1 = new JLabel("第一步：根据查询条件查处对应的盘点单，然后再列表中选择要盘点的盘点单，可以多选。");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();
		jpanel2.setLayout(new BorderLayout());
		JPanel jpanel21 = new JPanel();
		jpanel21.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel label21 = new JLabel("仓库名称：");
		JLabel label22 = new JLabel("操作员：");
		comboCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboCZY = new JComboBox(MFrameJDBC.getUser());
		btnCX = new JButton("查询");
		{
			PanYingPanKuiActionListener lis = new PanYingPanKuiActionListener(this);
			btnCX.addActionListener(lis);
		}
		{
			jpanel21.add(label21);
			jpanel21.add(comboCK);
			jpanel21.add(label22);
			jpanel21.add(comboCZY);
			jpanel21.add(btnCX);
		}
		
		JPanel jpanel22 = new JPanel();
		jpanel22.setLayout(new FlowLayout(FlowLayout.LEFT));
		////加表格
		vo1 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK1);
		ve1 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK1);
		tablemodel1 = new AllTableModel(vo1,ve1);
		table1 = new JTable(tablemodel1);
		table1.setAutoCreateRowSorter(true); //此语句让表格自动排序
		table1.setPreferredScrollableViewportSize(new Dimension(780,360));
		JScrollPane scroPane = new JScrollPane(table1);
		jpanel22.add(scroPane);
		jpanel22.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		{
			jpanel2.add(jpanel21,BorderLayout.NORTH);
			jpanel2.add(jpanel22,BorderLayout.CENTER);
		}
//		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"选择盘点单"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		JLabel label31 = new JLabel();
		
		labelPDDS = new JLabel();
		labelPDDS.setForeground(Color.RED);
		
		jpanel3.add(label31);
		jpanel3.add(labelPDDS);
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		{
			fiJpanel.add(jpanel1,BorderLayout.NORTH);
			fiJpanel.add(jpanel2,BorderLayout.CENTER);
			fiJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		fiJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"选择盘点单"));
		return fiJpanel;
	}
	
	private JPanel second(){
		JPanel sJpanel = new JPanel();
		sJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label1 = new JLabel("第二步：根据第一步选择的盘点单，汇总得到列表中的所有盘点商品，单击未盘商品可以查看未盘到的商品信息。");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();
		
		////加表格
		vo2 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK2);
		ve2 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK2);
		tablemodel2 = new AllTableModel(vo2,ve2);
		table2 = new JTable(tablemodel2);
		table2.setAutoCreateRowSorter(true); //此语句让表格自动排序
		table2.setPreferredScrollableViewportSize(new Dimension(780,330));
		JScrollPane scroPane = new JScrollPane(table2);
		jpanel2.add(scroPane);
		jpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"选择盘点单"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		JLabel label31 = new JLabel("记录数：" );
		labelJLS1 = new JLabel();
		labelJLS1.setForeground(Color.RED);
		jpanel3.add(label31);
		jpanel3.add(labelJLS1);
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		
		{
			sJpanel.add(jpanel1,BorderLayout.NORTH);
			sJpanel.add(jpanel2,BorderLayout.CENTER);
			sJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		sJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"所有盘点商品"));
		return sJpanel;
	}
	
	private JPanel third(){
		JPanel tJpanel = new JPanel();
		tJpanel.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label1 = new JLabel("第三步：盘点数量-库存数量 = 差异数量。库存修复之后，原数据库的数据无法回复，请提前备份。");
		label1.setForeground(Color.RED);
		jpanel1.add(label1);
		
		//////////////////////
		JPanel jpanel2 = new JPanel();

		vo3 = AllTableModel.getVectorDataFromObj(KCPDModel.dataPYPK3);
		ve3 = AllTableModel.getVectorFromObj(KCPDModel.colunmsPYPK3);
		tablemodel3 = new AllTableModel(vo3,ve3);
		table3 = new JTable(tablemodel3);
		table3.setAutoCreateRowSorter(true); //此语句让表格自动排序
		table3.setPreferredScrollableViewportSize(new Dimension(780,320));
		JScrollPane scroPane = new JScrollPane(table3);
		jpanel2.add(scroPane);
		jpanel2.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
		
//		jpanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"选择盘点单"));
		
		////////////////
		JPanel jpanel3 = new JPanel();
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		JLabel label31 = new JLabel("记录数：");
		labelJLS2 = new JLabel();
		labelJLS2.setForeground(Color.RED);
		
		jpanel3.add(label31);
		jpanel3.add(labelJLS2);
		
		{
			tJpanel.add(jpanel1,BorderLayout.NORTH);
			tJpanel.add(jpanel2,BorderLayout.CENTER);
			tJpanel.add(jpanel3,BorderLayout.SOUTH);
		}
		
		tJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"盘点差异表"));
		return tJpanel;
	}
	/*
	 * 南部按钮面板
	 */
	private JPanel addSou(){
		JPanel souJpanel = new JPanel();
		btnWP = new JButton("未盘商品");
		btnLast = new JButton("上一步");
		btnNext = new JButton("下一步");
		btnXZ = new JButton("修正库存");
		btnExit = new JButton("退出");
		{
			ShowCardAction l = new ShowCardAction(this);
			btnLast.addActionListener(l);
			btnNext.addActionListener(l);
			btnXZ.addActionListener(l);
		}
		{
			btnWP.addActionListener(new PanYingPanKuiActionListener(this));
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					PanYingPanKuiJDialog.this.dispose();
				}
			});
		}
		{
			souJpanel.add(btnWP);
			souJpanel.add(btnLast);
			souJpanel.add(btnNext);
			souJpanel.add(btnXZ);
			souJpanel.add(btnExit);
		}
		souJpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,30,20));
		return souJpanel;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PanYingPanKuiJDialog(null,"盘盈盘亏",true).setVisible(true);
	}


	public JLabel getLabelJLS1() {
		return labelJLS1;
	}


	public JLabel getLabelJLS2() {
		return labelJLS2;
	}
}
