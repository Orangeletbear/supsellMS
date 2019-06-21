package com.cn.view.posmainJFrame;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 选择会员对话框
 * @author Administrator
 *
 */
public class SelectHuiYuanDialog extends JDialog {

	private POSFrame frame;
	private JTextField hyId = new JTextField(15);
	
	public SelectHuiYuanDialog(POSFrame frame,String title){
		super(frame,title,true);
		this.frame = frame;
		init();
	}
	
	public void init(){
		this.add(createPane());
		this.setSize(200,120);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,10,8));
		JLabel hy = new JLabel("请输入会员编号:");
		hy.setForeground(Color.RED);
		pane.add(hy);
		pane.add(hyId);
		hyId.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F3){
					new HuiYuanInfo(SelectHuiYuanDialog.this,"会员信息");
				}else if(e.getKeyCode() == KeyEvent.VK_F4){
					String hyId2 = 	hyId.getText();
					frame.getHyName().setText(hyId2);
					SelectHuiYuanDialog.this.dispose();
				}
				
			}

			public void keyReleased(KeyEvent e) {
				
				
			}

			public void keyTyped(KeyEvent e) {
				
			}
			
		});
		
		pane.add(new JLabel("          "));
		JButton chaXun = new JButton("查询(F3)");
		chaXun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new HuiYuanInfo(SelectHuiYuanDialog.this,"会员信息");
				
			}
			
		});
		chaXun.setMargin(new Insets(0,0,0,0));
		

		JButton sure= new JButton("确定(F4)");
		sure.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			String hyId2 = 	hyId.getText();
			frame.getHyName().setText(hyId2);
			SelectHuiYuanDialog.this.dispose();
			}
			
		});
		sure.setMargin(new Insets(0,0,0,0));
     
		pane.add(chaXun);
		pane.add(sure);
		return pane;
	}
	public POSFrame getFrame() {
		return frame;
	}

	public JTextField getHyId() {
		return hyId;
	}

	public  static void main(String[] args){
		new SelectHuiYuanDialog(null,"");
	}
}
