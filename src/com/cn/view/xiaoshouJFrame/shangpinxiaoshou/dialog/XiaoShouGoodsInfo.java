package com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfoAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfo_DocumentListener;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfo_SureAction;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.util.JNumberField;
/**
 * 双击增加商品（商品销售）
 * 对话框左边的表时出现的对话框
 * 即商品信息（商品销售）对话框
 * @author Administrator
 *
 */
public class XiaoShouGoodsInfo extends JDialog {

	//父窗口
	  private  AddXiaoShouGoodsDialog dialog;
	 
	  //商品编号
	  private JLabel goodId= new JLabel();
	  //商品名称
	  private JLabel goodName= new JLabel();
	  //规格型号
	  private JLabel xingHao= new JLabel();
	  //生产厂商
	  private JLabel changShang= new JLabel();
	  //颜色
	  private JLabel color= new JLabel();
	  //当前库存
	  private JLabel kuCun= new JLabel();
	  //备注
	  private JLabel beiZhu= new JLabel();
	  //单位
	  private JLabel danWei = new JLabel();
	  //参考售价
	  private JTextField canKaoShouJia = new JTextField();
	  //数量
	  private JNumberField shuLiang = new JNumberField();
      //打折率
	  private JTextField daZhe = new JTextField();
	  //折后单价
	  private JLabel danJia = new JLabel(); 
	  //总计金额
	  private JLabel zje = new JLabel();
	  
	  private JButton sure = new JButton("确认");
	  private JButton exit = new JButton("退出");
		
		//
	  private JTable table;
	  private AllTableModel tableModel;
	  
	  
	  private JPanel biaoGePanel;

	public XiaoShouGoodsInfo(AddXiaoShouGoodsDialog dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		int row = dialog.getSpqdtable().getSelectedRow();
		String kehu = dialog.getMaindialog().getKeHuText().getText();
		this.addWindowListener(new XiaoShouGoodsInfoAction(this,kehu,row));
		init();
	}
	
	public void init(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(createTopPanel());
		mainPanel.add(createBottomPanel());
		this.add(mainPanel);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * 上部面板组件的布局
	 * @return
	 */
	public JPanel createTopPanel(){
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder("商品信息"));
		topPanel.setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,1,1,10));
		center.setLayout(new GridLayout(5,0,1,10));
		center.add(new JLabel("商品编号:"));
		center.add(goodId);
		center.add(new JLabel("商品名称:"));
		center.add(goodName);
		center.add(new JLabel("规格型号:"));
		center.add(xingHao);
		center.add(new JLabel("单     位:"));
		center.add(danWei);
		center.add(new JLabel("生产厂商:"));
		center.add(changShang);
		center.add(new JLabel("颜      色:"));
		center.add(color);
		center.add(new JLabel("当前库存:"));
		center.add(kuCun);
		center.add(new JLabel("备      注:"));
		center.add(beiZhu);
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,1));
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("参考售价:"));
		box1.add(canKaoShouJia);
		canKaoShouJia.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		
		box1.add(new JLabel("元"));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(new JLabel("打折率:"));
		box1.add(daZhe);
		daZhe.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(new JLabel("数量:"));
		box1.add(shuLiang);
		shuLiang.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("折后单价:"));
		box2.add(danJia);
		box2.add(new JLabel("元"));
		box2.add(Box.createHorizontalStrut(100));
		JLabel label = new JLabel("1为不打折,0.8为打八折!");
		label.setForeground(Color.RED);
		box2.add(label);
		box2.add(new JLabel("总计:"));
		box2.add(zje);
	    box2.add(new JLabel("元"));
	    
		south.add(box1);
		south.add(box2);
		
		topPanel.add(center,BorderLayout.CENTER);
		topPanel.add(south,BorderLayout.SOUTH);
		
		
		return topPanel;
	}
	/**
	 * 下部面板组件的布局
	 * @return
	 */
	
	public JPanel createBottomPanel(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
	//	north.setLayout(new FlowLayout(100));
		north.add(sure);
		sure.addActionListener(new XiaoShouGoodsInfo_SureAction(this));
		north.add(new JLabel("                           "));
		north.add(exit);
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		biaoGePanel = new JPanel();
		tableModel = new AllTableModel(
			    DialogCulomnModel.obj,DialogCulomnModel.columNames);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,356));
        biaoGePanel.add(new JScrollPane(table));
        
        
        bottomPanel.add(north,BorderLayout.NORTH);
        bottomPanel.add(biaoGePanel,BorderLayout.CENTER);
		return bottomPanel;
	}
	
	
	public AddXiaoShouGoodsDialog getDialog() {
		return dialog;
	}

	public JLabel getGoodId() {
		return goodId;
	}

	public JLabel getGoodName() {
		return goodName;
	}

	public JLabel getXingHao() {
		return xingHao;
	}

	public JLabel getChangShang() {
		return changShang;
	}

	public JLabel getColor() {
		return color;
	}

	public JLabel getKuCun() {
		return kuCun;
	}

	public JLabel getBeiZhu() {
		return beiZhu;
	}

	public JLabel getDanWei() {
		return danWei;
	}

	public JTextField getCanKaoShouJia() {
		return canKaoShouJia;
	}

	public JTextField getShuLiang() {
		return shuLiang;
	}

	public JTextField getDaZhe() {
		return daZhe;
	}

	public JLabel getDanJia() {
		return danJia;
	}

	public JLabel getZje() {
		return zje;
	}

	public AllTableModel getTableModel() {
		return tableModel;
	}

	public JTable getTable() {
		return table;
	}

	public JPanel getBiaoGePanel() {
		return biaoGePanel;
	}

	public static void main(String[] args){
		new XiaoShouGoodsInfo(null,"");
	}
}
