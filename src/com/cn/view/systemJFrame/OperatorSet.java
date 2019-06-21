package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.cn.dao.system.CustomerDB;
import com.cn.dao.system.OperatorDB;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.model.system.OperatorCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.Operator.AddOperator;
import com.cn.view.systemJFrame.Operator.AddOperator2;
/*
 * 操作员设置对话框
 */
public class OperatorSet extends JDialog {
	
	private JButton btn1 = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/add.jpg"));
	private JButton btn2 = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/atler.jpg"));
	private JButton btn3 = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/delete.jpg"));
	private JButton btn4 = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/exit.jpg"));
	AllTableModel operatorModel ;
	JTable table;
	
	
	public JTable getTable() {
		return table;
	}
	public AllTableModel getOperatorModel() {
		return operatorModel;
	}
	public OperatorSet(JFrame frame,String str){
		super(frame,str,true);
		addListener();
		init();
		initData();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	/**
	 * 数据初始化
	 */
	public void  initData(){
		Vector data = OperatorDB.getData();
		//System.out.println(data.size());
		getOperatorModel().setDataVector(data,
				AllTableModel.getVectorFromObj(OperatorCulomns.operatorNames));
		
	}
	
	private void addListener() {
	    btn4.addActionListener(new ActionListener(){
			 
			public void actionPerformed(ActionEvent e) {
				 OperatorSet.this.dispose();
			}});
	    
	    btn1.addActionListener(new ActionListener(){
			 
			public void actionPerformed(ActionEvent e) {
				new AddOperator(OperatorSet.this,"选择操作员类型");
			}});
	    btn2.addActionListener(new ActionListener(){
			 
			public void actionPerformed(ActionEvent e) {
				int row = OperatorSet.this.getTable().getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null,"请先选择一条数据");
					return ;
				}else{
					String id = getOperatorModel().getValueAt(row, 0).toString();
					if(id.equals("01")){
						JOptionPane.showMessageDialog(null,"超级管理员不可修改");
						return;
					}
					
					new AddOperator2(OperatorSet.this,"修改操作员","1",true);
				}
			}});
	    btn3.addActionListener(new ActionListener(){
			 
			public void actionPerformed(ActionEvent e) {
				int row = OperatorSet.this.getTable().getSelectedRow();
				if(row == -1){
					JOptionPane.showInternalMessageDialog(null,"请先选择一条数据");
					return ;
				}else{
					String obj = OperatorSet.this.getOperatorModel()
	    	           .getValueAt(row, 0).toString();
					if(obj.equals("01")){
						JOptionPane.showMessageDialog(null,"超级管理员不可删除");
						return;
					}
					int choice =  JOptionPane.showConfirmDialog(
							OperatorSet.this, "数据删除后将不能恢复，是否删除！","删除警告",
			        		 JOptionPane.YES_NO_OPTION, 1);
			          //点确定删除数据
				     if(choice == JOptionPane.YES_OPTION){

				    	if(OperatorDB.deleteOperator(obj)){
				    		
				    		String user = ((MainFrame)getOwner()).getUser();
				    		
					        Log.traceLog(" 操作员 ",user,
					    		"  删除了操作员 "+OperatorSet.this.
					    	getOperatorModel().getValueAt(row, 1).toString()+"的信息");
					    		 
				    		JOptionPane.showMessageDialog(null,"数据成功删除");
				    		initData();
				    	 }else{
				    		 System.out.println("fff");
				    		 JOptionPane.showMessageDialog(null,"数据已发生业务不能删除");
				    	 }
				     }
				}
			}});
	}


	private void init() {
		//this.setSize(500,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel norPane = new JPanel();
		norPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		 btn1.setMargin(new Insets(0,0,0,0));
		 btn2.setMargin(new Insets(0,0,0,0));
		 btn3.setMargin(new Insets(0,0,0,0));
		 btn4.setMargin(new Insets(0,0,0,0));
		 norPane.add(btn1);
		 norPane.add(btn2);
		 norPane.add(btn3);
		 norPane.add(btn4);
	 
		 JPanel cenPane = new JPanel();
		
		 
		 String[][] data = new String[][]{};
		 
		 operatorModel = new AllTableModel(data,OperatorCulomns.operatorNames);
		 
		 table = new JTable(operatorModel);
		 
		 table.setPreferredScrollableViewportSize(new Dimension(400,250));
		 
		 cenPane.add(new JScrollPane(table));
		 table.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent me) {
				 if(me.getClickCount() ==2){
					 int row = OperatorSet.this.getTable().getSelectedRow();
						
						String id = getOperatorModel().getValueAt(row, 0).toString();
						if(id.equals("01")){
							JOptionPane.showMessageDialog(null,"超级管理员不可修改");
							return;
						}
						new AddOperator2(OperatorSet.this,"修改操作员","1",true);
				 }
			 }
		 });
		 this.add(norPane,BorderLayout.NORTH);
		 this.add(cenPane);
	}
   
    

	public static void main(String[] args) {
		 new OperatorSet((JFrame)null,"操作员设置");
	}

}
 