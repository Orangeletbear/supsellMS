package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.cn.view.jinhuoJFrame.CaiGouJinHuo;

/**
 * 差额处理
 * 当实付金额小于应付金额是，选择是优惠还是欠款
 */
public class ChaEChuLi extends JDialog{
	/*
	 * 父窗口
	 */
	CaiGouJinHuo dialog;
	/*
	 * 分支
	 */
	JRadioButton youhui ;
	JRadioButton qiankuan;
	//差额
	private float chaE = 0;
	

	public ChaEChuLi(CaiGouJinHuo dialog,String title,boolean model){
		super(dialog,title,model);
		this.dialog = dialog;
		float arg1 = Float.parseFloat(dialog.getYingFuJinE().getText());
		float arg2 = Float.parseFloat(dialog.getShiFuJinE().getText());
		chaE =arg1 -arg2;
		youhui = new JRadioButton("该单据对我方优惠："+chaE+" 元");
		qiankuan =new JRadioButton("该单据我方欠款："+chaE+" 元");
		init();
	}
	
	private void init(){
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		this.add(pane());
		this.setVisible(true);
	}
	
	private JPanel pane(){
		JPanel pane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("采购进货是实付金额少于应付金额，"));
		panel1.add(new JLabel("请在下面两下中选择对差额的处理："));

		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup bg = new ButtonGroup();
		bg.add(youhui);
		bg.add(qiankuan);
		panel2.add(youhui);
		panel2.add(qiankuan);

		JButton quxiao = new JButton("取消");
		quxiao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ChaEChuLi.this.dispose();
			}
		});
		JButton queding = new JButton("确定");
		queding.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!youhui.isSelected() && !qiankuan.isSelected()){//若没有选
					return;
				}

				if(youhui.isSelected()){
					dialog.setYouHuiJine(chaE);
				}else{
					dialog.setQianKuanJine(chaE);
				}
				ChaEChuLi.this.dispose();
			}
		});
		panel3.add(queding);
		panel3.add(quxiao);
		
		pane.setLayout(new GridLayout(3,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		
		
		return pane;
	}

}
