package com.cn.view.systemJFrame ;

 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;


import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.model.system.StorageCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.*;
import com.cn.view.systemJFrame.CangKuXheZhi.AddStorage;
import com.cn.view.systemJFrame.CangKuXheZhi.ChangeStorage;
import com.cn.view.systemJFrame.CangKuXheZhi.FindStorage;

/*
 * 仓库设置对话框
 */

public class CangKuSheZhi extends JDialog {
	
	JButton btn1 = new JButton(
			new ImageIcon("res/AcionIcon/add.jpg"));
	JButton btn2 = new JButton(
			new ImageIcon("res/AcionIcon/atler.jpg"));
	JButton btn3 = new JButton(
			new ImageIcon("res/AcionIcon/delete.jpg"));
	JButton btn4 = new JButton(
			new ImageIcon("res/AcionIcon/find.jpg"));
	JButton btn5 = new JButton(
			new ImageIcon("res/AcionIcon/all.jpg"));
	JButton btn6 = new JButton(
			new ImageIcon("res/AcionIcon/import.jpg"));
	JButton btn7 = new JButton(
			new ImageIcon("res/AcionIcon/print.jpg"));
	JButton btn8 = new JButton(
			new ImageIcon("res/AcionIcon/exit.jpg"));
	
	JPanel bigPanel = new JPanel();
	
	static JTable table;
	
	static AllTableModel tablemodel =null;
	
	public  CangKuSheZhi(MainFrame frame,String str){
		super(frame,str,true);
   	     
		init();
		initData();
		this.setVisible(true);
	}
	
	  private void initData() {
		 Vector data = StorageDB.getData();
		// System.out.println(data.size());
	    this.getTablemodel().setDataVector(data,
	    		AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));
		
	}

	private void init(){
		  //设置大小
		  this.setSize(590,420);
		  //设置布局方式
		  bigPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		  //窗体居中
		  this.setLocationRelativeTo(null);
		  //定义关闭方式
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  addNorth();
		  addTable();
		  addSouth();
		  addListener();
		  this.toFront();
		  //大小不可改变
		  this.setResizable(false);
		  //对话框可见
		  
	  }
 
	private void addListener() {
		//退出键添加监听器
		btn8.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CangKuSheZhi.this.dispose();
			}});
		//增加键添加监听器
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			new AddStorage( CangKuSheZhi.this,"增加仓库", true);
		}});
       //修改键监听器
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 if(CangKuSheZhi.getTable().getSelectedRow()<0){
					 JOptionPane.showMessageDialog(null,"请先选择一条数据！！");
					 return;
				 }
				 else{new ChangeStorage(CangKuSheZhi.this,"修改仓库",true);}
			}
		});
		//删除监听器
		btn3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(CangKuSheZhi.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(null,"请先选择一条数据");
					return;
				}
				
		      
				int choice =  JOptionPane.showConfirmDialog(CangKuSheZhi.this, 
		        		"是否确定删除！删除后不可恢复~","系统提示",
		        		 JOptionPane.YES_NO_OPTION, 1);
		        
		        
		          //点确定删除数据
			     if(choice == JOptionPane.YES_OPTION){
			    	 int row = CangKuSheZhi.this.getTable().getSelectedRow();
			    	 Object obj = CangKuSheZhi.this.getTablemodel().getValueAt(row, 0);
			    	 boolean isdele=StorageDB.DeleteStorageData(obj);
			    	 if(isdele){
			    		  Vector data = StorageDB.getData();
						    // System.out.println(data.size());
						     CangKuSheZhi.this.getTablemodel().setDataVector(data, 
						    		 AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));
						     JOptionPane.showMessageDialog(null,
						    		 "数据成功删除") ;
			    	 	MainFrame mUser = (MainFrame)(CangKuSheZhi.this.getOwner());
			    	 	String user=mUser.getUser();
			    	 	Log.traceLog("操作员：",user," 删除了仓库："+
                   	      obj.toString()+" 的信息");
			    	 }
			    	 else{ 
			    		 JOptionPane.showMessageDialog(null,"已发生业务，不可删除！");
			    	 }
			    	 
			    	  
                           
			    	  
                           
			    	 }
			     }
			
		});
		
       //查找键添加监听器
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		    new FindStorage(CangKuSheZhi.this,"仓库查找",true);
				}
			});
		
		//全部键监听器
		btn5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Vector data = StorageDB.getData();
				CangKuSheZhi.this.getTablemodel().setDataVector(data,
						AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));
			}
			
		});
		
	}

    private void addTable() {
			 
			 String[][] data = new String[][]{};
			 tablemodel = new AllTableModel(data,StorageCulomns.cangKuNames);
			 
			  table = new JTable(tablemodel);
			  
			  table.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent arg0) {
					if( arg0.getClickCount()==2){
						new ChangeStorage(CangKuSheZhi.this,"修改仓库",true);
					}
					
				}

				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}});
			 
			 table.setPreferredScrollableViewportSize(
					 new Dimension(560,300));
			 
			 JPanel panel = new JPanel();
			 
			 panel.add(new JScrollPane(table),
					 JScrollPane.HORIZONTAL_SCROLLBAR);
			 
			 bigPanel.add(panel,BorderLayout.CENTER);
			 this.add(bigPanel);
		 
	}

	private void addNorth() {
		 JPanel north = new JPanel();
		 north.add(btn1);
		 btn1.setMargin(new Insets(0,0,0,0));
		 north.add(btn2); 
		 btn2.setMargin(new Insets(0,0,0,0));
		 north.add(btn3); 
		 btn3.setMargin(new Insets(0,0,0,0));
		 north.add(btn4); 
		 btn4.setMargin(new Insets(0,0,0,0));
		 north.add(btn5); 
		 btn5.setMargin(new Insets(0,0,0,0));
		 north.add(btn6); 
		 btn6.setMargin(new Insets(0,0,0,0));
		 north.add(btn7);
		 btn7.setMargin(new Insets(0,0,0,0));
		 north.add(btn8);
		 btn8.setMargin(new Insets(0,0,0,0));
		 
		 bigPanel.add(north);
		 
		 this.add(bigPanel);
		
	}
	private void addSouth(){
		JPanel pa = new JPanel();
		JLabel be = new JLabel("");
		be.setFont(new Font("DIALOG",Font.PLAIN,12));
		pa.add(be);
		bigPanel.add(pa);
		this.add(bigPanel);
	}
	
	public static JTable getTable() {
		return table;
	}

	public JPanel getBigPanel() {
		return bigPanel;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public static  AllTableModel getTablemodel() {
		return tablemodel;
	}

}

 