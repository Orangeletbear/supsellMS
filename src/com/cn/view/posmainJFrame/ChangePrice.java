package com.cn.view.posmainJFrame;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 修改单价的小窗口
 */
public class ChangePrice extends JDialog {
	private static ChangePrice dia;
	
	public static ChangePrice getInstance(POSFrame dialog,String title){
		if(dia == null){
			return new ChangePrice(dialog,title);
		}else{
			return dia;
		}
	}
	private JLabel name = new JLabel();
	
	private JTextField price = new JTextField(10);
	
	POSFrame dialog;
	public ChangePrice(POSFrame dialog,String title) {
		super(dialog,title,true);
		this.dialog = dialog;
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(250,200));
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("商品名称: "));
		pane.add(name);
		
		name.setText(dialog.getMode().getValueAt(dialog.getTable().getSelectedRow(), 2).toString());
		this.add(pane);
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("商品定价: "));
		pane.add(price);
		price.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode() == KeyEvent.VK_F5){
				 int row = dialog.getTable().getSelectedRow();
					
					float danJia = Float.parseFloat(price.getText());
					float zhj = danJia*Float.parseFloat(dialog.getMode().getValueAt(row, 5).toString());
				    float zje = zhj*Float.parseFloat(dialog.getMode().getValueAt(row, 7).toString());
				    String zj = null;
				    if(zje < 10){
				          zj = String.valueOf(zje).substring(0,3);
				    }else if(zje < 100){
				    	 zj = String.valueOf(zje).substring(0,4);
				    }else if(zje < 1000){
				    	 zj = String.valueOf(zje).substring(0,5);
				    }else if(zje < 10000){
				    	 zj = String.valueOf(zje).substring(0,6);
				    }
				    //修改单价
					dialog.getMode().setValueAt(danJia, row, 4);
					//修改折后价
					dialog.getMode().setValueAt(zhj, row, 6);
					//获取旧的总金额
					float oldMoney = Float.parseFloat(
							          dialog.getMode().getValueAt(row, 8).toString());
					//修改总金额
					dialog.getMode().setValueAt(zj, row, 8);
					float allMoney = Float.parseFloat(dialog.getAll().getText()) +zje-oldMoney;
	                if(allMoney < 10){
						
	                	dialog.getAll().setText(String.valueOf(allMoney).substring(0, 3));
					}else if(allMoney <100){
				
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 4));
					}else if(allMoney <1000){
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 5));
					}else if(allMoney < 1000){
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 6));
					}
					
					ChangePrice.this.dispose();
			 }else if(e.getKeyCode() == KeyEvent.VK_F4){
				 ChangePrice.this.dispose();
			 }
			}

			public void keyReleased(KeyEvent e) {
			
			}

			public void keyTyped(KeyEvent e) {
			
			}
			
		});
		price.setText(dialog.getMode().getValueAt(dialog.getTable().getSelectedRow(), 4).toString());
		this.add(pane);
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		JButton okBtn = new JButton("确定(F5)");
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 int row = dialog.getTable().getSelectedRow();
					
					float danJia = Float.parseFloat(price.getText());
					float zhj = danJia*Float.parseFloat(dialog.getMode().getValueAt(row, 5).toString());
				    float zje = zhj*Float.parseFloat(dialog.getMode().getValueAt(row, 7).toString());
				    String zj = null;
				    if(zje < 10){
				          zj = String.valueOf(zje).substring(0,3);
				    }else if(zje < 100){
				    	 zj = String.valueOf(zje).substring(0,4);
				    }else if(zje < 1000){
				    	 zj = String.valueOf(zje).substring(0,5);
				    }else if(zje < 10000){
				    	 zj = String.valueOf(zje).substring(0,6);
				    }
				    //修改单价
					dialog.getMode().setValueAt(danJia, row, 4);
					//修改折后价
					dialog.getMode().setValueAt(zhj, row, 6);
					//获取旧的总金额
					float oldMoney = Float.parseFloat(
							          dialog.getMode().getValueAt(row, 8).toString());
					//修改总金额
					dialog.getMode().setValueAt(zj, row, 8);
					float allMoney = Float.parseFloat(dialog.getAll().getText()) +zje-oldMoney;
	                if(allMoney < 10){
						
	                	dialog.getAll().setText(String.valueOf(allMoney).substring(0, 3));
					}else if(allMoney <100){
				
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 4));
					}else if(allMoney <1000){
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 5));
					}else if(allMoney < 1000){
						dialog.getAll().setText(String.valueOf(allMoney).substring(0, 6));
					}
					
					ChangePrice.this.dispose();
			}
			
		});
        JButton cancelBtn = new JButton("退出(F4)");
        cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ChangePrice.this.dispose();
			}
			
		});
        pane.add(okBtn);
        pane.add(cancelBtn);
        
		this.add(pane);
		
		
	}
	public static void main(String[] args) {
		new ChangePrice((POSFrame)null,"");
	}
	
}
