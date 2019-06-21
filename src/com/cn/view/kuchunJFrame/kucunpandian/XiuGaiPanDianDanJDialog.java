package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin.AddShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.util.JDatePicker;

/**
 * 
 * 修改盘点单窗口
 * @author Administrator
 *
 */
public class XiuGaiPanDianDanJDialog extends JDialog {
		
		private JLabel labelPDDH;//盘点单号
		private JComboBox comboPDCK;//盘点仓库
		private JDatePicker datePDRQ;//盘点日期
		private JLabel labelCZY;//操作员
		private JLabel labelBZ;//备注
		
		private JTextField textSPBH;//商品编号
		private JButton btnYes;//确定按钮
		private JTable tableSPQD;//商品清单
		private AllTableModel tableModelSPQD;//商品清单
		private Vector voKCSP;//盘点库存商品数据行列
		private Vector veKCSP;//盘点库存商品列名
		
		private JButton btnXG;//修改
		private JButton btnSC;//删除
		private JButton btnOK;//确定
		private JButton btnExit;//退出
		private JTable tableYPSP;//商品清单
		private AllTableModel tableModelYPSP;//商品清单
		private Vector voYPSP;//盘点库存商品数据行列
		private Vector veYPSP;//盘点库存商品列名
		
		
		public XiuGaiPanDianDanJDialog(JDialog dialog,String title,boolean b){
			super(dialog,title,b);
			init();
//			addGetDatas(this.comboPDCK.getSelectedItem().toString());
		}
////////////////////
		public JComboBox getComboPDCK() {
			return comboPDCK;
		}

		//初始化添加商品同时将选择仓库中商品信息查询出来
		
		
		////////////空指针异常
		///////////可能是由于Vector改变过程中出现了一点点问题
		private void addGetDatas(String name){
     		Vector datas = null ;//= AddShangPinDataToView.dataToView(name);
			Vector columns = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1);
			
//			for(int i = 1; i < datas.size(); i ++){
//				System.out.println(datas.get(i));
//			}
//			for(int i = 00; i < columns.size(); i ++){
//				System.out.println(columns.get(i));
//			}
			tableModelSPQD.setDataVector(datas, columns);
//			tableSPQD.setRowSelectionInterval(0, 0);
		}
		private void init(){
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.add(addCom());
//			this.setVisible(true);
		}
		
		private JPanel addCom(){
			JPanel jpanel = new JPanel();
			jpanel.setLayout(new BorderLayout());
			{
				jpanel.add(addNor(),BorderLayout.NORTH);
				jpanel.add(addCen(),BorderLayout.CENTER);
			}
			return jpanel;
		}

		/*
		 * 中部
		 */
		private JPanel addNor(){
			JPanel norJpanel = new JPanel();
			norJpanel.setLayout(new GridLayout(3,1));
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			JPanel jpanel3 = new JPanel();

			JLabel label1 = new JLabel("盘点单号 ：");
			JLabel label2 = new JLabel("盘点仓库 ：");
			JLabel label3 = new JLabel("盘点日期 ：");
			JLabel label4 = new JLabel("操 作 员：");
			JLabel label5 = new JLabel("备    注：");
			JLabel label6 = new JLabel("提示：盘点中不能更换仓库和日期。" +
					"在没有修正库存之前请无忧采购进货、销售等能改变库存数量的操作，不然会造成库存数量的不准。");
			
			{
				labelPDDH = new JLabel("PD101028100001");
				labelPDDH.setForeground(Color.RED);
				comboPDCK = new JComboBox(KCDBModel.itemsCK);
				comboPDCK.setEnabled(false);
				datePDRQ = new JDatePicker();
				datePDRQ.setEnabled(false);
				labelCZY = new JLabel("admin");
				labelBZ = new JLabel("_____________________________________");
			}
			{
				jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
				jpanel1.add(label1);
				jpanel1.add(labelPDDH);
				jpanel1.add(label2);
				jpanel1.add(comboPDCK);
				jpanel1.add(label3);
				jpanel1.add(datePDRQ);
				jpanel1.add(label4);
				jpanel1.add(labelCZY);
			}
			
			{
				jpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
				jpanel2.add(label5);
				jpanel2.add(labelBZ);
			}
			
			{
				label6.setForeground(Color.RED);
				jpanel3.add(label6);
			}
			
			{
				norJpanel.add(jpanel1);
				norJpanel.add(jpanel2);
				norJpanel.add(jpanel3);
			}
			
			norJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"盘点信息"));
			return norJpanel;
		}
		
		/*
		 * 中部
		 * 中间部分分为左右两个部分
		 */
		private JPanel addCen(){
			JPanel cenJpanel = new JPanel();
			cenJpanel.setLayout(new GridLayout(1,2));
			{
				cenJpanel.add(addLeft());
				cenJpanel.add(addRight());
			}
			return cenJpanel;
		}
		
		/*
		 * 左边
		 */
		private JPanel addLeft(){
			JPanel leftJpanel = new JPanel();
			leftJpanel.setLayout(new BorderLayout());
				
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			
			tableModelSPQD = new AllTableModel();
			tableSPQD = new JTable(tableModelSPQD);
			
			JLabel label = new JLabel("商品编号");
			textSPBH = new JTextField(10);
			btnYes =new JButton("确   定");
			
			{
				jpanel1.add(label);
				jpanel1.add(textSPBH);
				jpanel1.add(btnYes);
			}
			
			{
				voKCSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCSP);
				veKCSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCSP);
				createTable(jpanel2,tableSPQD,tableModelSPQD,voKCSP,veKCSP);
			}
			
			{
				leftJpanel.add(jpanel1,BorderLayout.NORTH);
				leftJpanel.add(jpanel2,BorderLayout.CENTER);
			}
			leftJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"库存商品"));
			return leftJpanel;
		}
		
		/*
		 * 右边
		 */
		private JPanel addRight(){
			JPanel rightJpanel = new JPanel();
			rightJpanel.setLayout(new BorderLayout());
			
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			
			jpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
			btnXG = new JButton("修改");
			btnSC = new JButton("删除");
			btnOK = new JButton("确定");
			btnExit = new JButton("退出");
			{
				btnExit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						XiuGaiPanDianDanJDialog.this.dispose();
					}
				});
			}
			{
				jpanel1.add(btnXG);
				jpanel1.add(btnSC);
				jpanel1.add(btnOK);
				jpanel1.add(btnExit);
			}
			
			{
				voYPSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataYPSP);
				veYPSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsYPSP);
				createTable(jpanel2,tableYPSP,tableModelYPSP,voYPSP,veYPSP);
			}
			
			{
				rightJpanel.add(jpanel1,BorderLayout.NORTH);
				rightJpanel.add(jpanel2,BorderLayout.CENTER);
			}
			rightJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"已盘商品"));
			return rightJpanel;
		}
		
		/*
		 * 此方法是创建table面板
		 * 
		 */
		private void createTable(JPanel jpanel,JTable table,
			AllTableModel tableModel,Vector data,Vector colunms){
			
			tableModel = new AllTableModel(data,colunms);
			table = new JTable(tableModel);
			table.setAutoCreateRowSorter(true); //此语句让表格自动排序
			table.setPreferredScrollableViewportSize(new Dimension(380,400));
			JScrollPane scroPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
			jpanel.add(scroPane);
		}
		
		/**
		 * @param args
		 */
/*		public static void main(String[] args) {
			new XinZengPanDianDanJDialog(null,"录入盘点商品",true);
		}*/
}
