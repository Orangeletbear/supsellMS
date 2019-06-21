package com.cn.view.jinhuoJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.dao.jinhuo.caigoudanju.JDBCCaiGouDanJu;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCWangLaiZhangWu;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.columnName.CaiGouDanJuColumnNames;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoudanjuchaxun.XiangXiChaZhao;



public class CaiGouDanJuChaXun extends JDialog{
	/*
	 * 父窗口
	 */
	private JFrame frame;
//	north 组件
	
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton zhengDanTuiHuo = new JButton(new ImageIcon("res/AcionIcon/zhengDantuihuo.jpg"));
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
//	center 组件
	//	时间1
	private JDatePicker chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//	时间2
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField gongHuoShangORdanJuHao = new JTextField(12);
	//表
	private AllTableModel ATM;
	private JTable table1;
	private Vector table1_data = new Vector();//table 数据
//	south
	private AllTableModel ATM2;
	private JTable table2;
	private Vector table2_data = new Vector();//table 数据
	
	public CaiGouDanJuChaXun(JFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		init();
	}
	private void init(){
		this.setSize(1000, 630);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);////////////////////////////////////////////////
	
		this.setLayout(new BorderLayout());
		this.add(north(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.add(south(),BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
//	north
	private JPanel north(){
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		//设置button内边距
		//退出Button
		JButton tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		tuiChu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CaiGouDanJuChaXun.this.dispose();
			}
		});
//		//详细查找
//		JButton xiangXiChaZhao = new JButton(new ImageIcon("res/AcionIcon/xiangXiChaZhao.jpg"));
//		xiangXiChaZhao.setMargin(new Insets(0,0,0,0));
//		final CaiGouDanJuChaXun argDialog = this;
//		xiangXiChaZhao.addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				new XiangXiChaZhao(argDialog,"详细查找",true);
//			}
//			
//		});
		//整单退货
		zhengDanTuiHuo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i = table1.getSelectedRow();
				if(i == -1){
					JOptionPane.showMessageDialog(null,"请选择采购单据!");
					return;
				}
				String danhao = ((Vector)table1_data.get(i)).get(0).toString();
				if(!danhao.matches("CJ.*")){
					JOptionPane.showMessageDialog(CaiGouDanJuChaXun.this,"请选择采购进货单据，以CJ开头!");
					return;
				}
				Vector argdata = JDBCWangLaiZhangWu.getDanJuXiangXi(danhao);
				//顺序被打乱了，重新排
				Vector newdata = new Vector();
				for(Object tmp : argdata){
					Vector inner = new Vector();
					inner.add(((Vector)tmp).get(0));
					inner.add(((Vector)tmp).get(1));
					inner.add(((Vector)tmp).get(2));
					inner.add(((Vector)tmp).get(6));
					inner.add(((Vector)tmp).get(7));
					inner.add(((Vector)tmp).get(3));
					inner.add(((Vector)tmp).get(4));
					inner.add(((Vector)tmp).get(5));
					
					newdata.add(inner);
				}
//				供货商
				String gonghuoshang = ((Vector)table1_data.get(i)).get(2).toString();
				
				//new 一个采购退货窗口
			 new CaiGouTuiHuo(frame,"采购退货",true,newdata,gonghuoshang);
				
			}
		
			
		});
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		zhengDanTuiHuo.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		daYin.setMargin(new Insets(0,0,0,0));
		tuiChu.setMargin(new Insets(0,0,0,0));
		
//		north.add(xiangXiChaZhao);
		north.add(chaKanDanJu);
		north.add(zhengDanTuiHuo);
		north.add(daoChu);
		north.add(daYin);
		north.add(tuiChu);
		north.setBorder(new LineBorder(Color.GRAY,1));//创建具有指定颜色和厚度的线边框。
		
		return north;
	}
// center再分成两个子pane1和pane2
	private JPanel center(){
		JPanel center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
	  //pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("查询时间:"));
		pane1.add(chaXunShiJian);
		pane1.add(new JLabel("至"));
		pane1.add(zhi);
		pane1.add(new JLabel("按供货商/单据号查询："));
		pane1.add(gongHuoShangORdanJuHao);
		//查询按钮
		JButton chaXun = new JButton("查询");
		chaXun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = chaXunShiJian.getSelectedItem().toString();
				String time2 = zhi.getSelectedItem().toString();
				String gonghuoshang = gongHuoShangORdanJuHao.getText().toString();
				
				table1_data= JDBCCaiGouDanJu.getCaiGou(time1,time2,gonghuoshang);
				
				ATM.setDataVector(table1_data,CaiGouDanJuColumnNames.table1_columnNames);
			}
		});
		pane1.add(chaXun);
		//pane1.setBorder(new LineBorder(Color.GRAY));//创建具有指定颜色和厚度的线边框。
	  //pane2
		//表
		ATM = new AllTableModel(table1_data,CaiGouDanJuColumnNames.table1_columnNames);
		table1 = new JTable(ATM);
		table1.addMouseListener(new MouseAdapter(){//表上操作的监听器
			 public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1){
						int i = table1.getSelectedRow();
						String danhao = (String)((Vector)table1_data.get(i)).get(0);
						//table2的跟随刷新
						table2_data = JDBCCaiGouDanJu.getDanJuXiangXi(danhao);
						ATM2.setDataVector(table2_data,CaiGouDanJuColumnNames.table2_columnNames);
					}
			 }
		});
		
		//表格固定大小
		table1.setPreferredScrollableViewportSize(new Dimension(990,280));
		
		pane2.add(new JScrollPane(table1));
	  //center
		center.setLayout(new BorderLayout());
		center.add(pane1,BorderLayout.NORTH);
		center.add(pane2,BorderLayout.CENTER);
		//center.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		
		return center;
	}
	
//	south
	private JPanel south(){
		JPanel south = new JPanel();
		
		ATM2 = new AllTableModel(table2_data,CaiGouDanJuColumnNames.table2_columnNames);
		table2= new JTable(ATM2);
		table2.setPreferredScrollableViewportSize(new Dimension(990,130));//表格固定大小
		
		south.setLayout(new FlowLayout(FlowLayout.LEFT));
		south.add(new JLabel("单据的详细信息:"));
		south.add(new JScrollPane(table2),BorderLayout.CENTER);//加一个滚动条
		//south.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		
		
		return south;
	}
	
	public static void main(String[] args){
		new CaiGouDanJuChaXun((JFrame)null,"采购单据查询",true);
	}
}
