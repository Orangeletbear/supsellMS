package com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;

public class FuKuanDan extends JDialog{
	
	//panel1
	private JLabel gonghuoshang = new JLabel();
	//panel2
	private JLabel qiankuanjine = new JLabel();
	private JLabel danhao = new JLabel();
	private JTextField fukuanjine = new JTextField();
	private JDatePicker fukuanriqi = new JDatePicker();
	private JComboBox fukuanfangshi = new JComboBox();
	private JComboBox jinbanren = new JComboBox();
	//panel3
	private JTextField fujiashuoming = new JTextField(20);
	//panel4
	private JButton dayin = new JButton("打印");
	private JButton queding = new JButton("确定");
	
	
	
	public FuKuanDan(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		init();
		
	}
	
	private void init(){
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		this.add(pane());
		
		
		this.setVisible(true);
	}
	
	/*
	 * 
	 */
	private JPanel pane(){
		JPanel pane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		//panel1
		panel1.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		
		panel1.add(new JLabel("供货商："));
		panel1.add(gonghuoshang);
		//panel2
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(new JLabel("欠款金额:"));
		panel2.add(qiankuanjine);
		panel2.add(new JLabel("单号:"));
		panel2.add(danhao);
		panel2.add(new JLabel("付款金额:"));
		panel2.add(fukuanjine);
		panel2.add(new JLabel("付款日期:"));
		panel2.add(fukuanriqi);
		panel2.add(new JLabel("付款方式:"));
		panel2.add(fukuanfangshi);
		panel2.add(new JLabel("经办人:"));
		panel2.add(jinbanren);
		
		//panel3
		panel3.add(new JLabel("附加说明:"));
		panel3.add(fujiashuoming);
		//panel4
		panel4.setBorder(new LineBorder(Color.BLACK,1));//创建具有指定颜色和厚度的线边框。
		panel4.add(dayin);
		panel4.add(queding);
		JButton tuichu = new JButton("退出");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FuKuanDan.this.dispose();
			}
		});
		panel4.add(tuichu);
		
		pane.setLayout(new GridLayout(4,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		return pane;
		
	}

	public static void main(String[] args){
		new FuKuanDan((JDialog)null,"付款单（供货商）",true);
	}
}
