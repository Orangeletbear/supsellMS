package com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.AllKeHuSureAction;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCFindKeHuInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;

public class AllKeHuDialog extends JDialog {

	private JTable keHuTable ;
	
	private AllTableModel tableModel;
	boolean isaddData;
	
	public AllKeHuDialog(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		init();
		this.setVisible(true);
	}
	
	
	public AllKeHuDialog(JDialog dialog,String title,boolean model,boolean isaddData){
		super(dialog,title,model);
		init();
		if(isaddData ){
		 setTableData();
		}
		this.setVisible(true);
	}
	public void init(){
		this.add(createPanel());
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	public JPanel createPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		tableModel = new AllTableModel(DanJuColumnames.obj,DanJuColumnames.keHuInfo);
		keHuTable = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(keHuTable);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,35,5));
		JButton alterButton = new JButton("�޸�(F9)");
		JButton sureButton = new JButton("ȷ��(F5)");
		JButton exitButton = new JButton("�˳�(F4)");
		exitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		southPanel.add(alterButton);
		
	    sureButton.addActionListener(new AllKeHuSureAction(this));
		southPanel.add(sureButton);
		southPanel.add(exitButton);
		
		
		panel.add(scroll,BorderLayout.CENTER);
		panel.add(southPanel,BorderLayout.SOUTH);
		
		return panel;
	}
	
	
	public void setTableData(){
		Vector data = JDBCFindKeHuInfo.getData();
		tableModel.setDataVector(data,AllTableModel.getVectorFromObj(DanJuColumnames.keHuInfo));
		keHuTable.requestFocus();
		keHuTable.setRowSelectionInterval(0, 0);
	}
	
	public JTable getKeHuTable() {
		return keHuTable;
	}

	//������
	public static void main(String[] args) {
		new AllKeHuDialog(null,"Fcxkh",true);
	}
}
