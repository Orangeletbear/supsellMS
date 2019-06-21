package com.cn.view.kuchunJFrame.kucunDiaobo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.model.kuchun.chaifenkunbang.ChaiFenKunBang;

/**
 * 
 * 经办人详细信息窗口
 * 用于查询，修改，增加新的经办人
 * @author Administrator
 *
 */
public class JingbanrenJWindow extends JDialog {
	private DefaultTableModel tableModelJBR;//经办人
	private JTable tableJBR;//经办人
	private JTextField textJBRCX;//经办人查询
	private JButton btnYes;//确定
	private JButton btnZJ;//增加
	private JButton btnXG;//修改
	private JButton btnExit;//关闭按钮
	
	
	public JingbanrenJWindow(JDialog dialog,String title,boolean b){
		super(dialog,title,b);
		init();
	}
	
	private void init(){
		this.setBounds(240, 280, 480, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(addCom());
//		this.setVisible(true);
	}
	
	private JPanel addCom(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		
		//scrollPane 面板
		JPanel cenJpanel = new JPanel();
		tableModelJBR = new AllTableModel(ChaiFenKunBang.dataCFKB1,KCDBModel.colunmsJBR);
		tableJBR = new JTable(tableModelJBR);
		tableJBR.setAutoCreateRowSorter(true); //此语句让表格自动排序
		tableJBR.setPreferredScrollableViewportSize(new Dimension(460,220));
			JScrollPane scroPane = new JScrollPane(tableJBR,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
			cenJpanel.add(scroPane);
		
		//底部按钮面板添加
		JPanel souJpanel = new JPanel();
		souJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
		
		JLabel label = new JLabel("商品查询(F2)");
		label.setPreferredSize(new Dimension(65,20));
		label.setFont(new Font("楷体",Font.BOLD,10));
		
		textJBRCX = new JTextField(10);
		
		btnYes = new JButton("确定");
		btnYes.setPreferredSize(new Dimension(65,20));
		btnYes.setFont(new Font("楷体",Font.BOLD,10));
		
		btnZJ = new JButton("增加");
		btnZJ.setPreferredSize(new Dimension(65,20));
		btnZJ.setFont(new Font("楷体",Font.BOLD,10));
		
		btnXG = new JButton("修改");
		btnXG.setPreferredSize(new Dimension(65,20));
		btnXG.setFont(new Font("楷体",Font.BOLD,10));
		
		btnExit = new JButton("退出");
		btnExit.setPreferredSize(new Dimension(65,20));
		btnExit.setFont(new Font("楷体",Font.BOLD,10));
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JingbanrenJWindow.this.dispose();
			}
		});
		
		{
			souJpanel.add(label);
			souJpanel.add(textJBRCX);
			souJpanel.add(btnYes);
			souJpanel.add(btnZJ);
			souJpanel.add(btnXG);
			souJpanel.add(btnExit);
		}
		
		{
			jpanel.add(cenJpanel,BorderLayout.CENTER);
			jpanel.add(souJpanel,BorderLayout.SOUTH);
		}
		
		return jpanel;
	}
	
	
/*	public static void main(String[] args) {
		new JingbanrenJWindow(null).setVisible(true);
	}*/
}
