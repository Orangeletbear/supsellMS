package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 会员级别基本设置
 * @author finey
 *
 */
public class HuiYuanJiBieSet extends JDialog {
     public static String [] tbCulomns = {
    	           "级别编号","级别名称","级别折扣","积分下限","积分上限"};
	//增加
	JButton add = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/add.jpg"));
	//修改
	JButton alter = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/atler.jpg"));
	//删除
	JButton dele = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/delete.jpg"));
	//退出
	JButton exit = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/exit.jpg"));
	
	AllTableModel tbMo = new AllTableModel(
			new Object[][]{},tbCulomns);
	
	JTable table = new JTable(tbMo);
	
	private JTextField jiBieF = new JTextField(10);
	
	
	JLabel countNum = new JLabel("0");
	
	
	
	public JLabel getCountNum() {
		return countNum;
	}

	public  HuiYuanJiBieSet(HuiYanGuangLiFrame frame,String title){
		super(frame,title,true);
   	     
		
		init();
	}
	
	  private void init(){
		  //设置大小
		  //this.setSize(590,420);
		  this.setLayout(new BorderLayout());
		
		  //定义关闭方式
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  this.add(initNorth(),BorderLayout.NORTH);
		  this.add(initCenter());
		  this.add(initSouth(),BorderLayout.SOUTH);
		  this.pack();
		  //大小不可改变
		  this.setResizable(false);
		  this.setLocationRelativeTo(null);
		  addListener();
		  //对话框可见
		  initData();
		  this.setVisible(true);
	  }
	  /**
	   * 级别信息初始化
	   */
	  public void initData(){
		    Vector data = HuiYuanXinGLJDBC.getHuiJiBieBaseM("");
			//数据加入表模式中
			this.getTbMo().setDataVector(data,
			AllTableModel.getVectorFromObj(tbCulomns));
			countNum.setText(" "+data.size());
	  }
	  
	  private void addListener(){
		  exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HuiYuanJiBieSet.this.dispose();
			}
			  
		  });
		  
		  add.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					new AddHuiYuanJiBie(HuiYuanJiBieSet.this,
							"增加级别",false);
				}
				  
		   });
		  alter.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(HuiYuanJiBieSet.this.getTabel().getSelectedColumn()<0){
						JOptionPane.showMessageDialog(null,"请先选择一条数据");
						return;
					}else{
						new AddHuiYuanJiBie(HuiYuanJiBieSet.this,
								"修改级别",true);
					}
					
				}
				  
		   });
		  dele.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(HuiYuanJiBieSet.this.getTabel().getSelectedColumn()<0){
						JOptionPane.showMessageDialog(null,"请先选择一条数据");
						return;
					}
			        int choice =  JOptionPane.showConfirmDialog(
			        		HuiYuanJiBieSet.this, "数据删除后将不能恢复，是否删除！","删除警告",
			        		 JOptionPane.YES_NO_OPTION, 1);
			        
			        
			          //点确定删除数据
				     if(choice == JOptionPane.YES_OPTION){
				    	 int row = HuiYuanJiBieSet.this.getTabel().
				    	             getSelectedRow();
				    	 
				    	 String obj = HuiYuanJiBieSet.this.getTbMo()
				    	           .getValueAt(row, 0).toString();
				    	 boolean isDele = HuiYuanXinGLJDBC.deleJiBie(obj);
				    	 
				    	 if(isDele){
				    	        HuiYanGuangLiFrame hyframe = (HuiYanGuangLiFrame)HuiYuanJiBieSet.this.getOwner();
				    	      	MainFrame mframe = (MainFrame)hyframe.getOwner();
				    	      	String user = mframe.getUser();
				    	      	//写日志
				    	      	Log.traceLog("  操作员  ",user," 删除了会员级别 :  "+
				    	      	   HuiYuanJiBieSet.this.getTbMo().getValueAt(row, 1).toString()+"  的信息");
				    		 
				    		 JOptionPane.showMessageDialog(null,"数据成功删除");
				    	     initData();
				    	 }
				     }
				}
		   });
	  }
	  
	private JPanel initNorth(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add.setMargin(new Insets(0,0,0,0));
		alter.setMargin(new Insets(0,0,0,0));
		dele.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		pane.add(add);
		pane.add(alter);
		pane.add(dele);
		pane.add(exit);
		
		
		return pane;
	}
	
	
	private JPanel initCenter(){
		JPanel pane = new JPanel();
	
		pane.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		north.add(new JLabel("级别信息"));
		north.add(jiBieF);
		jiBieF.setToolTipText("输入级别编号或名称模糊查询");
        JButton findBtn = new JButton("查  询");
        north.add(findBtn);
        pane.add(north,BorderLayout.NORTH);
        findBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String jbIN = jiBieF.getText();
				Vector data = HuiYuanXinGLJDBC.getHuiJiBieBaseM(jbIN);
				//数据加入表模式中
				getTbMo().setDataVector(data,
				AllTableModel.getVectorFromObj(tbCulomns));
				countNum.setText(" "+data.size());
			}
        	
        });
        
        JPanel tbPane = new JPanel();
        table.setPreferredScrollableViewportSize(
        		new Dimension(500,200));
        table.setAutoCreateRowSorter(true);
        tbPane.add(new JScrollPane(table));
        table.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() ==2){
				 new AddHuiYuanJiBie(HuiYuanJiBieSet.this,"修改级别",true);
				}
			}

			
        	
        });
        
        pane.add(tbPane);
		return pane;
	}
	
	private JPanel initSouth(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("记录数：  "));
		pane.add(countNum);
		return pane;
	}
	

	public JTextField getJiBieF() {
		return jiBieF;
	}

	public JTable getTabel() {
		return table;
	}

	public AllTableModel getTbMo() {
		return tbMo;
	}
	public static void main(String[] args) {
		new HuiYuanJiBieSet(null,"会员级别");
	}
}
