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

import com.cn.view.posmainJFrame.POSFrame;
/**
 * 修改折扣对话框
 * @author Administrator
 *
 */
public class ChangeZheKouDialog extends JDialog {

	private POSFrame frame;
	//商品名称
	private JLabel spName = new JLabel();
	//折扣率
	private JTextField zkl = new JTextField(8);
	
	
	public ChangeZheKouDialog(POSFrame frame,String title){
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
		pane.add(new JLabel("折扣率: "));
		pane.add(zkl);
		zkl.setText(frame.getMode().getValueAt(frame.getTable().getSelectedRow(), 5).toString());
		zkl.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F5){
					float zheKou = Float.parseFloat(zkl.getText());
					
					int row = frame.getTable().getSelectedRow();
					float danJia = Float.parseFloat(frame.getMode().getValueAt(row, 4).toString());
					//折后价
					String zhj = String.valueOf(danJia*zheKou).substring(0, 3);
					float zje = Float.parseFloat(frame.getMode().getValueAt(row, 7).toString())
					                              *Float.parseFloat(zhj);
					
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
					frame.getMode().setValueAt(zheKou, row, 5);
					frame.getMode().setValueAt(zhj, row, 6);
					//获取旧的总金额
					float oldMoney = Float.parseFloat(
							          frame.getMode().getValueAt(row, 8).toString());
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

		
					ChangeZheKouDialog.this.dispose();
				
			 }else if(e.getKeyCode() == KeyEvent.VK_F4){
				 ChangeZheKouDialog.this.dispose();
			    }
			}

			public void keyReleased(KeyEvent e) {
			
			}

			public void keyTyped(KeyEvent e) {
			
			}
			
		});
		mainPane.add(pane);
		
		
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,2));
		JButton okBtn = new JButton("确定(F5)");
		okBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				float zheKou = Float.parseFloat(zkl.getText());
				
				int row = frame.getTable().getSelectedRow();
				float danJia = Float.parseFloat(frame.getMode().getValueAt(row, 4).toString());
				//折后价
				String zhj = String.valueOf(danJia*zheKou).substring(0, 3);
				float zje = Float.parseFloat(frame.getMode().getValueAt(row, 7).toString())
				                              *Float.parseFloat(zhj);
				
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
				frame.getMode().setValueAt(zheKou, row, 5);
				frame.getMode().setValueAt(zhj, row, 6);
				//获取旧的总金额
				float oldMoney = Float.parseFloat(
						          frame.getMode().getValueAt(row, 8).toString());
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

	
				ChangeZheKouDialog.this.dispose();
			
			
			}
			
		});
        JButton cancelBtn = new JButton("退出(F4)");
        cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ChangeZheKouDialog.this.dispose();
			}
			
		});
        pane.add(okBtn);
        pane.add(cancelBtn);
        mainPane.add(pane);
        
		return mainPane;
	}
	public static void main(String[] args) {
		new ChangeZheKouDialog((POSFrame)null,"");
	}
}
