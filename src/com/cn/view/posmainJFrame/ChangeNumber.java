package com.cn.view.posmainJFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeNumber extends JDialog {
	
	private POSTuiHuoDialog frame;
	//商品名称
	private JLabel spName = new JLabel();
	//商品原数量
	private JLabel sp_oldNum = new JLabel();
	//商品新数量
	private JTextField sp_newNum = new JTextField(8);
	
	public ChangeNumber(POSTuiHuoDialog frame,String title){
		super(frame,title,true);
		this.frame = frame;
		init();
	}
	
	public void init(){
		this.add(createPane());
		this.setSize(200,150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	   }
	
	public JPanel createPane(){
		JPanel mainPane = new JPanel();
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("商品名称: "));
		pane.add(spName);
		mainPane.add(pane);
	    spName.setText(frame.getDefaultModel().getValueAt(frame.getSpTable().getSelectedRow(), 2).toString());
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("原数量: "));
		pane.add(sp_oldNum);
		sp_oldNum.setText(frame.getDefaultModel().getValueAt(
				           frame.getSpTable().getSelectedRow(), 7).toString());
		mainPane.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("新数量: "));
		pane.add(sp_newNum);
		sp_newNum.setText(frame.getDefaultModel().getValueAt(
				           frame.getSpTable().getSelectedRow(), 7).toString());
		mainPane.add(pane);
		
		sp_newNum.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode() == KeyEvent.VK_F5){
				    int new_num = Integer.parseInt(sp_newNum.getText());
				    int old_num = Integer.parseInt(sp_oldNum.getText());
				    
				    if(new_num > old_num){
				    	JOptionPane.showMessageDialog(ChangeNumber.this, "退货数量不可大于可退货数量",
				    			"系统提示", JOptionPane.PLAIN_MESSAGE, null);
				    }else{
				    	int row = frame.getSpTable().getSelectedRow();
                        //修改数量
				    	frame.getDefaultModel().setValueAt(new_num, row, 7);
				    	//获取单价
				    	float danJia = Float.parseFloat(frame.getDefaultModel().getValueAt(row, 4).toString());
				    	float total = danJia * new_num;
				    	
				    	String je = String.valueOf(total).substring(0, 3);
				    	//修改金额
				    	frame.getDefaultModel().setValueAt(je, row, 8);
				    	
				    	ChangeNumber.this.dispose();
				    }
				    
				
				
				
			 }else if(e.getKeyCode() == KeyEvent.VK_F4){
				 ChangeNumber.this.dispose();
			 }
			}

			public void keyReleased(KeyEvent e) {
			
			}

			public void keyTyped(KeyEvent e) {
			
			}
			
		});
		
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		JButton okBtn = new JButton("确定(F5)");
		
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
					    int new_num = Integer.parseInt(sp_newNum.getText());
					    int old_num = Integer.parseInt(sp_oldNum.getText());
					    
					    if(new_num > old_num){
					    	JOptionPane.showMessageDialog(ChangeNumber.this, "退货数量不可大于可退货数量",
					    			"系统提示", JOptionPane.PLAIN_MESSAGE, null);
					    }else{
					    	int row = frame.getSpTable().getSelectedRow();
	                        //修改数量
					    	frame.getDefaultModel().setValueAt(new_num, row, 7);
					    	//获取单价
					    	float danJia = Float.parseFloat(frame.getDefaultModel().getValueAt(row, 4).toString());
					    	float total = danJia * new_num;
					    	
					    	String je = String.valueOf(total).substring(0, 3);
					    	//修改金额
					    	frame.getDefaultModel().setValueAt(je, row, 8);
					    	
					    	ChangeNumber.this.dispose();
					    }
				 }
				 });
        JButton cancelBtn = new JButton("退出(F4)");
        cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ChangeNumber.this.dispose();
			}
			
		});
        pane.add(okBtn);
        pane.add(cancelBtn);
        mainPane.add(pane);
        
		return mainPane;
	}
  	
	public static void main(String[] args) {
		new ChangeNumberDialog((POSFrame)null,"");
	}
}
