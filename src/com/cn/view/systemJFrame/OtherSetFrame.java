package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * 系统的一些设置对话框
 * @author finey
 *
 */
public class OtherSetFrame extends JDialog {

	/*
	 * 项目组全名
	 */
	private JTextField allName = new JTextField(44);
	/*
	 * 项目组简称
	 */
	private JTextField simpleName = new JTextField(15);
	/*
	 * 项目组联系电话
	 */
	private JTextField tell = new JTextField(15);
	/*
	 * 项目联系地址
	 */
	private JTextField address = new JTextField(44);
	/*
	 * 第二个面板上的单价取
	 */
	JComboBox card2Box = new JComboBox(new String[]{"平均进价","最近进价"});
	JCheckBox box1 = new JCheckBox("启用现金银行功能");
	JCheckBox box2 = new JCheckBox("销售时允许修改销售单价");
	JCheckBox box3 = new JCheckBox("库存为零时允许销售");
	JCheckBox box4 = new JCheckBox("采购进货或销售时有原始单号");
	JCheckBox box5 = new JCheckBox("采购退货时只能退该供货商供应的商品");
	JCheckBox box6 = new JCheckBox("特价商品参与积分");
	JCheckBox box7 = new JCheckBox("销售完后退出商品销售窗口");
	JCheckBox box8 = new JCheckBox("使用标准条码商品库增加商品");
	JCheckBox box9 = new JCheckBox("商品成本价为零时允许销售");
	JCheckBox box10 = new JCheckBox("商品条码允许重复");
	JCheckBox box11 = new JCheckBox("增加商品基本信息时商品自动编号");
	JCheckBox box12 = new JCheckBox("销售退货时只能退该客户销售的商品");
	/*
	 * 小数位数
	 */
	private JTextField number = new JTextField(5);
	/*
	 * 第三个面板
	 */
	JCheckBox box31 = new JCheckBox("pos前端销售时允许模糊查询");
	JCheckBox box32 = new JCheckBox("pos前端公保存当天挂单信息");
	JCheckBox box33 = new JCheckBox("pos前端销售时会员只能刷卡消费");
	JCheckBox box34 = new JCheckBox("pos前端显示商品库存数量");
	private JTextField number31 = new JTextField(3);
	private JTextField number32 = new JTextField(3);
	/*
	 * 第四个选项卡
	 */
	JCheckBox box41 = new JCheckBox("启用远程Web访问功能");
	
	/*
	 * 第五个选项卡
	 */
	private JTextField number51 = new JTextField(2);
	private JTextField number52 = new JTextField(2);
	private JTextField number53 = new JTextField(2);
	private JTextField number54 = new JTextField(2);
	
	public OtherSetFrame(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(500,400));
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
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		JPanel pane4 = createPane4();
		JPanel pane5 = createPane5();
		
		tabblePane.add("项目组信息",pane1);
		tabblePane.add("系统参数",pane2);
		tabblePane.add("POS参数设置",pane3);
		tabblePane.add("远程访问设置",pane4);
		tabblePane.add("电子称条码设置",pane5);
		
		mainPane.add(tabblePane);
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("确定");
		JButton cancerBtn = new JButton("取消");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				OtherSetFrame.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		
		
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	/*
	 * 第一个选项卡
	 */
	private JPanel createPane1(){
        JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(8,1,10,4));
        
        
        inpane.add(new JLabel());
       
        
        JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamAllName = new JLabel("项目组全名:");
        allName.setText("无敌七人项目开发组");
        tempPane.add(teamAllName);
        tempPane.add(allName);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamSimpleName = new JLabel("项目组简称:");
        simpleName.setText("无敌七人");
        JLabel teamTell = new JLabel("项目组电话:");
        tempPane.add(teamSimpleName);
        tempPane.add(simpleName);
        tempPane.add(teamTell);
        tell.setText("0731-88888888");
        tempPane.add(tell);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamAddress = new JLabel("项目组地址:");
        tempPane.add(teamAddress);
        address.setText("中南大学中信软件教育基地");
        tempPane.add(address);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        //inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
	}
	
	/*
	 * 第二个选项卡
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(8,2));

        JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lab = new JLabel("采购/退货的单价取");
        tempPane.add(lab);
        tempPane.add(card2Box);
        inpane.add(tempPane);
        
        box2.setSelected(true);
        box3.setSelected(true);
        box4.setSelected(true);
        box5.setSelected(true);
        box9.setSelected(true);
        box10.setSelected(true);
        box11.setSelected(true);
        box12.setSelected(true);
        
        inpane.add(box7);
        inpane.add(box1);
        inpane.add(box8);
        inpane.add(box2);
        inpane.add(box9);
        inpane.add(box3);
        inpane.add(box10);
        inpane.add(box4);
        inpane.add(box11);
        inpane.add(box5);
        inpane.add(box12);
        inpane.add(box6);
       
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("系统小数位数: "));
        number.setText("2");
        tempPane.add(number);
        tempPane.add( new JLabel("位"));
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
		
	}
	private JPanel createPane3(){
		

		JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(6,2));
        inpane.add(new JLabel());
        inpane.add(new JLabel());
        inpane.add(new JLabel());
        inpane.add(new JLabel());
       
        box31.setSelected(true);
        inpane.add(box31);
        inpane.add(box32);
        inpane.add(box33);
        inpane.add(box34);
        

        JPanel tempPane = new JPanel();
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("POS端结账小数位数: "));
        number31.setText("1");
        tempPane.add(number31);
        tempPane.add( new JLabel("位"));
        inpane.add(tempPane);
    
       
        tempPane = new JPanel();
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("POS端商品数量小数位数: "));
        number32.setText("2");
        tempPane.add(number32);
        tempPane.add( new JLabel("位"));
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
		
		
	}
	/*
	 * 第四个选项卡
	 */
	private JPanel createPane4(){    
       
		JPanel pane = new JPanel();
		
		pane.add(box41);
		pane.add(new JLabel("远程访问端口:"));
		
		JTextField field = new JTextField(4);
		field.setText("888");
		field.setEditable(false);
		
		JButton btn = new JButton("测试连接");
		btn.setEnabled(false);
		pane.add(field);
		pane.add(btn);
		
		return pane;
		
	}
	/*
	 * 第五个选项卡的设置
	 */
	private JPanel createPane5(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(new JLabel(new ImageIcon("res/AcionIcon/sptm.jpg")),BorderLayout.NORTH);
		
		JPanel tmpPane = new JPanel();
		tmpPane.add(new JLabel("商品条码位数: "));
		number51.setText("0");
		tmpPane.add(number51);
		
		tmpPane.add(new JLabel("商品重量码位数: "));
		number52.setText("0");
		tmpPane.add(number52);
		
		tmpPane.add(new JLabel("整数位数: "));
		number53.setText("0");
		tmpPane.add(number53);
		
		tmpPane.add(new JLabel("小数位数: "));
		number54.setText("2");
		tmpPane.add(number54);
		
		pane.add(tmpPane);
		pane.add(new JLabel(new ImageIcon("res/AcionIcon/remind.jpg")),BorderLayout.SOUTH);
		return pane;
		
	}
	public static void main(String[] args) {
		new OtherSetFrame((JFrame)null,"系统设置",true);
	}

}
