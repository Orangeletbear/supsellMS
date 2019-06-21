package com.cn.view.posmainJFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 修改数量对话框
 * @author Administrator
 *
 */
public class ChangeNumberDialog extends JDialog {

	private POSFrame frame;
	//商品名称
	private JLabel spName = new JLabel();
	//商品数量
	private JTextField spNum = new JTextField(8);
	
	
	public ChangeNumberDialog(POSFrame frame,String title){
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
	    spName.setText(frame.getMode().getValueAt(frame.getTable().getSelectedRow(), 2).toString());
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("修改数量: "));
		pane.add(spNum);
		spNum.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode() == KeyEvent.VK_F5){
				    int num = Integer.parseInt(spNum.getText());
					int row = frame.getTable().getSelectedRow();
					float zje = Float.parseFloat(frame.getMode().getValueAt(row, 6).toString())*num;
					String zj = null;
					if(zje < 10){
						zj = String.valueOf(zje).substring(0, 3);
					}else if(zje <100){
						zj = String.valueOf(zje).substring(0, 4);
					}else if(zje <1000){
						zj = String.valueOf(zje).substring(0, 5);
					}else if(zje < 1000){
						zj = String.valueOf(zje).substring(0, 6);
					}
				
					//修改数量
					frame.getMode().setValueAt(num, row, 7);
					//获取旧的总金额
					float oldMoney = Float.parseFloat(frame.getMode().getValueAt(row, 8).toString());
					//修改总金额
					frame.getMode().setValueAt(zj, row, 8);
					float allMoney = Float.parseFloat(frame.getAll().getText()) +zje-oldMoney;
					if(allMoney < 10){
						
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 3));
					}else if(allMoney <100){
				
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 4));
					}else if(allMoney <1000){
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 5));
					}else if(allMoney < 1000){
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 6));
					}

				
					ChangeNumberDialog.this.dispose();
			 }else if(e.getKeyCode() == KeyEvent.VK_F4){
				 ChangeNumberDialog.this.dispose();
			 }
			}

			public void keyReleased(KeyEvent e) {
			
			}

			public void keyTyped(KeyEvent e) {
			
			}
			
		});
		spNum.setText("1");
		mainPane.add(pane);
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		JButton okBtn = new JButton("确定(F5)");
		
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 int num = Integer.parseInt(spNum.getText());
					int row = frame.getTable().getSelectedRow();
					float zje = Float.parseFloat(frame.getMode().getValueAt(row, 6).toString())*num;
					String zj = null;
					if(zje < 10){
						zj = String.valueOf(zje).substring(0, 3);
					}else if(zje <100){
						zj = String.valueOf(zje).substring(0, 4);
					}else if(zje <1000){
						zj = String.valueOf(zje).substring(0, 5);
					}else if(zje < 1000){
						zj = String.valueOf(zje).substring(0, 6);
					}
				
					//修改数量
					frame.getMode().setValueAt(num, row, 7);
					//获取旧的总金额
					float oldMoney = Float.parseFloat(frame.getMode().getValueAt(row, 8).toString());
					//修改总金额
					frame.getMode().setValueAt(zj, row, 8);
					float allMoney = Float.parseFloat(frame.getAll().getText()) +zje-oldMoney;
					if(allMoney < 10){
						
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 3));
					}else if(allMoney <100){
				
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 4));
					}else if(allMoney <1000){
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 5));
					}else if(allMoney < 1000){
						frame.getAll().setText(String.valueOf(allMoney).substring(0, 6));
					}

				
					ChangeNumberDialog.this.dispose();
			}
			
		});
        JButton cancelBtn = new JButton("退出(F4)");
        cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ChangeNumberDialog.this.dispose();
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
