package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;

/**
 * 会员信息对话框
 * @author Administrator
 *
 */
public class HuiYuanInfo extends JDialog {

	private SelectHuiYuanDialog dialog;
	
	public HuiYuanInfo(SelectHuiYuanDialog dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		init();
		addData();
		this.setVisible(true);
	}
	

	private JTable table;
	private AllTableModel tableModel;
    private String hyName;
	
	//NorthPanel 上的组件
	private JTextField keHuText = new JTextField(8);

	private JButton sureButton = new JButton("确定(F5)");

	private JButton exitButton = new JButton("退出(F4)");
	



	/**
	 * 对象的初始化
	 */
	public void init(){
		this.add(createPanel());
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	
	public JPanel createPanel(){
		JPanel panel = new JPanel();
		
		tableModel = new AllTableModel(new Vector(),
				AllTableModel.getVectorFromObj(POSTableModel.hyculomn));
		
		table = new JTable(tableModel);
		JScrollPane  scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
	
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,1));
	
		southPanel.add(sureButton);
		sureButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String hyId  = tableModel.getValueAt(
						table.getSelectedRow(), 0).toString();
			        hyName = tableModel.getValueAt(
						table.getSelectedRow(), 1).toString();
			   dialog.getHyId().setText(hyId);
			   HuiYuanInfo.this.dispose();
			}
			
		});
		table.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F5){
					String hyId  = tableModel.getValueAt(
							table.getSelectedRow(), 0).toString();
				        hyName = tableModel.getValueAt(
							table.getSelectedRow(), 1).toString();
				   dialog.getHyId().setText(hyId);
				   HuiYuanInfo.this.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_F4){
					 HuiYuanInfo.this.dispose();
				}
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		exitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		southPanel.add(exitButton);
		
		panel.setLayout(new BorderLayout());
		panel.add(scroll,BorderLayout.CENTER);
		panel.add(southPanel,BorderLayout.SOUTH);
		
		return panel;
	}
	
	public JTable getTable() {
		return table;
	}


	public void addData(){
		Vector data = JDBC_POS_GetInfo.gethyInfo();
		tableModel.setDataVector(data,
				AllTableModel.getVectorFromObj(POSTableModel.hyculomn));
		table.requestFocus();
		table.setRowSelectionInterval(0, 0);
	}
	public static void main(String[] args) {
		new HuiYuanInfo(null,"");
	}

}
