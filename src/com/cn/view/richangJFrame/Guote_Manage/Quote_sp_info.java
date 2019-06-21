package com.cn.view.richangJFrame.Guote_Manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.richangframe.Guote_Manage.Action_sp_info_Confirm;

public class Quote_sp_info extends JDialog{
	private Add_Quote_Goods aqgs;
	private JLabel id;
	private JLabel name;
	private JLabel ysjj;
	private JLabel yssj;
	private JTextField wfbj;
	private JTextField ghsbj;
	
	public Quote_sp_info(Add_Quote_Goods aqgs,String title,boolean b){
		super(aqgs,title,b);
		this.aqgs = aqgs;
		init();
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void init() {
		JPanel panel_main = new JPanel();
		panel_main.setLayout(new BorderLayout(0, 0));
		
		JPanel Center = new JPanel();
		Center.setBorder(new TitledBorder(null, "报价商品信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Center.setLayout(new BoxLayout(Center, BoxLayout.Y_AXIS));
		
		JPanel box_1 = new JPanel();
		
		
		JPanel box_2 = new JPanel();
		
		
		JPanel box_3 = new JPanel();
		Vector v = (Vector)aqgs.getData_left_tab_1().get(aqgs.getTable_tab_1().getSelectedRow());
		box_1.setLayout(new BoxLayout(box_1, BoxLayout.X_AXIS));
		box_2.setLayout(new BoxLayout(box_2, BoxLayout.X_AXIS));
		box_3.setLayout(new BoxLayout(box_3, BoxLayout.X_AXIS));
		
		Center.add(box_1);
		
		JPanel box1_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) box1_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		box_1.add(box1_1);
		
		JLabel label_id = new JLabel("商品编号：");
		box1_1.add(label_id);
		
		id = new JLabel();
		box1_1.add(id);
		id.setText(v.get(0).toString());
		
		
		id.setForeground(Color.BLUE);
		
		JPanel box_1_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) box_1_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		box_1.add(box_1_2);
		JLabel label_name = new JLabel("商品名称：");
		box_1_2.add(label_name);
		name = new JLabel();
		box_1_2.add(name);
		name.setText(v.get(1).toString());
		name.setForeground(Color.RED);
		Center.add(box_2);
		
		JPanel box_2_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) box_2_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		box_2.add(box_2_1);
		JLabel label_ysjj = new JLabel("预设进价：");
		box_2_1.add(label_ysjj);
		ysjj = new JLabel("            ");
		box_2_1.add(ysjj);
		ysjj.setText(v.get(2).toString());
		ysjj.setForeground(Color.BLUE);
		
		JPanel box_2_2 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) box_2_2.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		box_2.add(box_2_2);
		JLabel label_yssj = new JLabel("预售售价：");
		box_2_2.add(label_yssj);
		yssj = new JLabel("        ");
		box_2_2.add(yssj);
		yssj.setText(v.get(3).toString());
		yssj.setForeground(Color.BLUE);
		Center.add(box_3);
		
		JPanel box_3_2 = new JPanel();
		box_3.add(box_3_2);
		
		JLabel label_ghsbj = new JLabel("供货商报价");
		box_3_2.add(label_ghsbj);
		
		ghsbj = new JTextField(10);
		ghsbj.setText(v.get(2).toString());
		ghsbj.setForeground(Color.RED);
		box_3_2.add(ghsbj);
		
		JLabel yuan = new JLabel("元");
		box_3_2.add(yuan);
		
		JPanel box_3_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) box_3_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		box_3.add(box_3_1);
		JLabel label_wfbj = new JLabel("我方报价：");
		box_3_1.add(label_wfbj);
		wfbj = new JTextField(10);
		box_3_1.add(wfbj);
		wfbj.setText(v.get(3).toString());
		wfbj.setForeground(Color.RED);
		JLabel danwei = new JLabel("元");
		box_3_1.add(danwei);
		panel_main.add(Center);
		//南边两个button
		JPanel South = new JPanel();
		JButton comfirm = new JButton("确定");
		comfirm.addActionListener(new Action_sp_info_Confirm(Quote_sp_info.this));
		JButton exit = new JButton("退出");
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		South.add(comfirm);
		South.add(exit);
		panel_main.add(South, BorderLayout.SOUTH);
		getContentPane().add(panel_main, BorderLayout.NORTH);
	}
	//获取Add_Quote_Goods_self对象
	public Add_Quote_Goods getAqgs() {
		return aqgs;
	}
	//获取商品id
	public JLabel getId() {
		return id;
	}
	//获取商品名称name
	public JLabel getname() {
		return name;
	}
	//获取商品报价wfbj
	public JTextField getWfbj() {
		return wfbj;
	}
	//获取商品供货商报价ghsbj
	public JTextField getGhsbj() {
		return ghsbj;
	}
}
