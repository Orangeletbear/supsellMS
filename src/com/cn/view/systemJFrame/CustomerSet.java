package com.cn.view.systemJFrame ;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import com.cn.dao.system.CustomerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.Customer.AddCustomer;
import com.cn.view.systemJFrame.Customer.ChangeCustomer;
import com.cn.view.systemJFrame.Customer.FindCustomer;

/*
 * 顾客设置对话框
 */
public class CustomerSet extends JDialog {
	 
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

	public JPanel getBigPanel() {
		return bigPanel;
	}

	public static AllTableModel getCustomerModel() {
		return customerModel;
	}

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
	
	static AllTableModel customerModel;
	
	JTable table ;
	
	
	public JTable getTable() {
		return table;
	}
    
	public CustomerSet(JDialog frame,String str){
		super(frame,str,true);
		init();
		initAddData();
		this.setVisible(true);
	}
	public CustomerSet(MainFrame frame,String str){
		super(frame,str,true);
		init();
		initAddData();
		this.setVisible(true);
	}
	
	/*
	 *   把数据库的数据显示到界面上
	 *   setDataVector();
	 */
	private void initAddData(){
		Vector data = CustomerDB.getData();
		//System.out.println(data.size());
		this.getCustomerModel().setDataVector(data,
				AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
		
	}
	
	  private void init(){
		  //设置大小
		  this.setSize(607,420);
		  //设置布局方式 
		  bigPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		  //设置窗体居中
		  this.setLocationRelativeTo(null);
		  //设置关闭方式
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  addNorth();
		  addTable();
		  addSouth();
		  addListener();
		  this.toFront();
		  //大小不可改变
		  this.setResizable(false);
		  //窗口可见
		 
	  }
 
	private void addListener() {
		
		//退出
		btn8.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CustomerSet.this.dispose();
			}});
		 //增加客户
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new  AddCustomer(CustomerSet.this,"增加客户");
		}});
		//修改客户
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(CustomerSet.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(CustomerSet.this, "请先选择一条数据");
					return;
					
				}else{
					 new ChangeCustomer(CustomerSet.this, "修改客户",true);
				}
		       
		    }
	    });
		//删除客户
		btn3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(CustomerSet.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(CustomerSet.this, "请先选择一条数据");
				    return;
				}
				
				int cus = JOptionPane.showConfirmDialog(CustomerSet.this, "是否确定删除！删除后不可恢复~", "系统信息",
						JOptionPane.OK_CANCEL_OPTION,1);
				
				if(cus == JOptionPane.OK_OPTION){
					int row = CustomerSet.this.getTable().getSelectedRow();
					Object obj = CustomerSet.this.getCustomerModel().getValueAt(row, 0);
					boolean isdele = CustomerDB.deleteCustomer(obj);
					if(isdele){
						Vector data = CustomerDB.getData();
						
						CustomerSet.this.getCustomerModel().setDataVector(data,
								AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
						JOptionPane.showMessageDialog(CustomerSet.this,"数据成功删除!");
						MainFrame mf = (MainFrame)(CustomerSet.this.getOwner());
						String user = mf.getUser();
						Log.traceLog("操作员：",user," 删除了客户："
								+obj.toString()+"的信息!");
					}else{
						JOptionPane.showMessageDialog(CustomerSet.this,"该客户已发生业务，不可删除");
					}	
				}
			}
		});
		
		//查找客户
	    btn4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		 new FindCustomer(CustomerSet.this,"查找客户",true) ;
	    	}
	    });
	    btn5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Vector data = CustomerDB.getData();
				CustomerSet.this.getCustomerModel().setDataVector(data,
						AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
			}
			
		});
	}
	    
	
	private void addTable() {
		 JPanel downpanel = new JPanel();
		 Object[][] data = new Object[][]{};       //StorageDB.getData();
		 
		 customerModel = new AllTableModel(data,
				 CustomerCulomns.customerNames);
		 
		  table = new JTable(customerModel);
		 table.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2){
					new ChangeCustomer(CustomerSet.this,"修改客户", true);
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
		  
		 table.setPreferredScrollableViewportSize(new Dimension(580,260));
		 
		 JPanel panel = new JPanel();
		 panel.setLayout(new BorderLayout());
		 table.setOpaque(true);
		 panel.add(new JScrollPane(table) );
		 
		 downpanel.add(new JScrollPane(panel) );
		 bigPanel.add(downpanel);
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
		 
		 bigPanel.add(north,BorderLayout.NORTH);
		 this.add(bigPanel);
	}
	private void addSouth(){
		JPanel pa = new JPanel();
		JLabel be = new JLabel("我方应收金额，正数表示欠款金额，" +
				"负数表示客户预支金额.");
		be.setFont(new Font("DIALOG",Font.PLAIN,12));
		pa.add(be);
		bigPanel.add(pa);
		 this.add(bigPanel);
	}

	public static void main(String[] args) {

	}

}
 