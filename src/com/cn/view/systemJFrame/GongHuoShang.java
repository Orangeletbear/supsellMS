package com.cn.view.systemJFrame ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.cn.dao.system.CustomerDB;
import com.cn.dao.system.SupllyDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.model.system.SuplyCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.GongHuo.AddSuply;
import com.cn.view.systemJFrame.GongHuo.ChangeSuply;
import com.cn.view.systemJFrame.GongHuo.FindSuply;
 
/*
 * 供货商设置对话框
 */
public class GongHuoShang extends JDialog {
	
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
	
	static AllTableModel supplyModel =null;
	
	JTable table;
 
	public  GongHuoShang(JDialog frame,String str){
		super(frame,str,true);
	     init();
   	     initData();
		this.setVisible(true);
	}
	public  GongHuoShang(MainFrame frame,String str){
		super(frame,str,true);
	     init();
   	     initData();
		this.setVisible(true);
	}
	
	  private void initData() {
		Vector data = SupllyDB.getData();
		this.getSupplyModel().setDataVector(data,
				AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
	}

	private void init(){
		  //设置大小
		  this.setSize(700,434);
          this.setLayout(new BorderLayout());
		  //窗体居中
		  this.setLocationRelativeTo(null);
		  //设置关闭方式
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  addNorth();
		  addTable();
		  addSouth();
		  addListener();
		 // this.toFront();
		  //大小不可改变
		  this.setResizable(false);
		  //设为可见
		 // this.setVisible(true);
	  }
 
	private void addListener() {
		btn8.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				GongHuoShang.this.dispose();
			}});
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			new AddSuply(GongHuoShang.this,"增加供货商" );
		}});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(GongHuoShang.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(null, "请选择一条数据！！");
				}
				else{new ChangeSuply( GongHuoShang.this, "修改供货商",true);}
			}
		});
		
		btn3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(GongHuoShang.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(GongHuoShang.this, "请选择一条数据");
					return;
				}
				int sup = JOptionPane.showConfirmDialog(GongHuoShang.this,"是否确定删除！删除后不恢复~","系统提示", JOptionPane.OK_CANCEL_OPTION,1);
				
				if(sup==JOptionPane.OK_OPTION){
					int row = GongHuoShang.this.getTable().getSelectedRow();
					Object obj = GongHuoShang.this.getSupplyModel().getValueAt(row, 0);
					boolean isdele = SupllyDB.deleteSupply(obj.toString());
					if(isdele){
						
						Vector data = SupllyDB.getData();
						
						GongHuoShang.this.getSupplyModel().setDataVector(data,
								
								AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
						
						JOptionPane.showMessageDialog(GongHuoShang.this,"删除成功");
					
					}else{
						
						JOptionPane.showMessageDialog(GongHuoShang.this,"对象发生业务,不可删除");
					}
					
					
					MainFrame mf = (MainFrame)(GongHuoShang.this.getOwner());
					String user = mf.getUser();
					
					if(isdele){
						Log.traceLog(" 操作员  ",user," 删除了供货商："
								+obj.toString()+"的信息!");
						
					}
					
				}
				
				
				
				
			}
			
		});
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		    new FindSuply(GongHuoShang.this,"供货商查找",true);
				}
			});
		btn5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Vector data = SupllyDB.getData();
				GongHuoShang.this.getSupplyModel().setDataVector(data,
						AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
			}
			
		});
	}

		
    private void addTable() {
    	    String[][] data = new String[][]{};
			
    	    supplyModel = new AllTableModel(data,SuplyCulomns.suplyNames);
			
	
			 JPanel tpane = new JPanel();
			 tpane.setLayout(new BorderLayout());
			 
			 table = new JTable(supplyModel);
			 table.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent arg0) {
					if(arg0.getClickCount()==2){
						new ChangeSuply(GongHuoShang.this,"修改供货商",true);
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
			// table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		    table.setPreferredScrollableViewportSize( 
		    		  new Dimension(800,255));
			 
			 tpane.add(new JScrollPane(table));
			 
			 bigPanel.add(new JScrollPane(tpane));
			
		 
	}

	

	private void addNorth() {
		 JPanel north = new JPanel();
		 north.setLayout(new FlowLayout(FlowLayout.LEFT));
		 
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
		 btn8.setMargin(new Insets(0,0,0,0));
		 north.add(btn8);
		
		 bigPanel.setLayout(new BorderLayout());
		 bigPanel.add(north,BorderLayout.NORTH);
		 
		
	}
	private void addSouth(){
		JPanel pa = new JPanel();
		JLabel be = new JLabel("我方应付金额:正数表示我方欠款金额,负数表示我方预支金额.");
		be.setFont(new Font("DIALOG",Font.PLAIN,12));
		be.setForeground(Color.red);
		pa.add(be);
		bigPanel.add(pa,BorderLayout.SOUTH);
		this.add(bigPanel);
	}
	
	public static void main(String[] args) {

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

	public static AllTableModel getSupplyModel() {
		return supplyModel;
	}
	public JTable getTable() {
		return table;
	}
}


 