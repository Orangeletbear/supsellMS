package com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.control.xiaoshouframe.guketuihuo.KeHuWindowSureButtonAction;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCFindKeHuInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
/**
 * 商品销售对话框中的按下
 * 查找客户按钮所出现的对话框
 * @author Administrator
 *
 */
public class KeHuWind extends JWindow {

	private ShangPinXiaoShouDialog dialog;
	private JTable table;
	private AllTableModel tableModel;
	
	//NorthPanel 上的组件
	private JTextField keHuText = new JTextField(8);
	
	private JButton sureButton = new JButton("确定(F5)");
	private JButton exitButton = new JButton("退出(F4)");
	
	public KeHuWind(ShangPinXiaoShouDialog dialog){
		super(dialog);
		init();
		addData();
		this.dialog =dialog;
		this.setVisible(true);
	}
	/**
	 * 对象的初始化
	 */
	public void init(){
		this.add(createPanel());
		this.setSize(550, 300);
		
		
	}
	
	public JPanel createPanel(){
		JPanel panel = new JPanel();
		
		tableModel = new AllTableModel(XiaoShouCulomnModel.obj,
				             XiaoShouCulomnModel.khcolumnNames);
		
		table = new JTable(tableModel);
		JScrollPane  scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
	
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,1));
		southPanel.add(new JLabel("查找客户(F2)"));
		southPanel.add(keHuText);
		keHuText.getDocument().addDocumentListener(new DocumentListener(){

			public void changedUpdate(DocumentEvent e) {
				
			}

			
			public void insertUpdate(DocumentEvent e) {
				
				Vector data = new Vector();
				String khId = keHuText.getText();
				data = JDBCFindKeHuInfo.getkeHuData(khId);
				if(data.size() > 0){
					tableModel.setDataVector(data,AllTableModel.getVectorFromObj(XiaoShouCulomnModel.khcolumnNames));
					table.requestFocus();
					table.setRowSelectionInterval(0, 0);
				}else{
					tableModel.setDataVector(data,AllTableModel.getVectorFromObj(XiaoShouCulomnModel.khcolumnNames));
				}
				
			}

			
			public void removeUpdate(DocumentEvent e) {
				
			}
			
		});
		southPanel.add(sureButton);
		sureButton.addActionListener(new ActionListener(){

			/**
			 * 将被选择行所对应的客户名称
			 * 显示到父窗口的客户框上
			 */
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String keHuName = tableModel.getValueAt(row,1).toString();
				dialog.getKeHuText().setText(keHuName);
				KeHuWind.this.dispose();
				
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
		Vector data = JDBCFindKeHuInfo.getData();
		tableModel.setDataVector(data,AllTableModel.getVectorFromObj(XiaoShouCulomnModel.khcolumnNames));
		table.requestFocus();
		table.setRowSelectionInterval(0, 0);
	}
	public static void main(String[] args){
		new KeHuWind(null);
	}

}
