package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.control.kuchunframe.kucundiaobo.chaxun.GaoJiChaXunOKAction;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.KCDBModel;
import com.cn.view.kuchunJFrame.KucunDiaobo;


public class GaojiChaxunDialog extends JDialog {
	private KucunDiaobo dialog;
	private JComboBox comboDCCK;
	private JComboBox comboDRCK;
	private JComboBox comboJBR;
	private JButton btnYes;
	private JButton btnNo;
	
	//获取信息
	public KucunDiaobo getDialog() {
		return dialog;
	}

	public JComboBox getComboDCCK() {
		return comboDCCK;
	}

	public JComboBox getComboDRCK() {
		return comboDRCK;
	}

	public JComboBox getComboJBR() {
		return comboJBR;
	}

	public GaojiChaxunDialog(KucunDiaobo dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	
	private void init(){
		this.setSize(240, 240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
		this.setResizable(false);
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		
		JPanel jpanel = new JPanel();
		/*
		 * 设置名称标签
		 */
		JLabel labelDCCK = new JLabel("调出仓库：");
		JLabel labelDRCK = new JLabel("调入仓库：");
		JLabel labelJBR = new JLabel("经 办 人:");
		
		/*
		 * 初始化下拉菜单
		 */
		comboDCCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboDCCK.addItem("所有仓库");
		comboDCCK.setSelectedItem("所有仓库");
		comboDRCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboDRCK.addItem("所有仓库");
		comboDRCK.setSelectedItem("所有仓库");
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
		comboJBR.addItem("所有经办人");
		comboJBR.setSelectedItem("所有经办人");
		
		/*
		 * 定义按钮
		 */
		btnYes = new JButton("确定(F4)");
		{
			btnYes.addActionListener(new GaoJiChaXunOKAction(this));
		}
		btnNo = new JButton("取消(F5)");
		//给取消按钮注册监听器
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GaojiChaxunDialog.this.dispose();
			}
		});
		/*
		 * 设置面板组建的布局，利用设置坐标的方法确定组建的位置
		 */
		labelDCCK.setBounds(20, 20, 100, 30);
		labelDCCK.setFont(new Font("黑体",Font.BOLD,14));
		this.add(labelDCCK);
		comboDCCK.setBounds(110, 20, 100, 30);
		this.add(comboDCCK);
		
		labelDRCK.setBounds(20, 70, 100, 30);
		labelDRCK.setFont(new Font("黑体",Font.BOLD,14));
		this.add(labelDRCK);
		comboDRCK.setBounds(110, 70, 100,30);
		this.add(comboDRCK);
		
		labelJBR.setBounds(20, 120, 100,30);
		labelJBR.setFont(new Font("黑体",Font.BOLD,14));
		this.add(labelJBR);
		comboJBR.setBounds(110, 120,  100,30);
		this.add(comboJBR);
		
		btnYes.setBounds(20, 170, 90, 25);
		this.add(btnYes);
		btnNo.setBounds(130, 170, 90, 25);
		this.add(btnNo);
		
		return jpanel;
	}
	
/*	public static void main(String []args){
		new GaojiChaxunDialog(null,"高级查询",true);
	}*/
	
}
