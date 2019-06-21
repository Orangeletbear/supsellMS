package com.cn.view.xiaoshouJFrame.POS;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * POS销售排行对话框 ,包含三个选项卡：商品销售排行，
 * 收银员销售排行，商品类别销售排行
 * 
 * @author Administrator
 *
 */
public class XiaoShouPaiHangDialog extends JDialog {
	
	/*
	 * 商品销售排行选项卡上的组件
	 */
	
	private JPanel tab1_panel = new JPanel();
	
	
	/*
	 * 收银员销售排行选项卡上的组件
	 */
	JPanel tab2_panel = new JPanel();
	
	
	/*
	 * 商品类别销售排行选项卡上的组件
	 */
	JPanel tab3_panel = new JPanel();

    //	北部面板上的组件
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //中间面板上的组件
	
	private TimeSpinnerPanel timeSpinner = new TimeSpinnerPanel();
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	private JTextField lieBeiText = new JTextField(10);
	private JButton chaXunButton = new JButton("查询(F2)");
	
	
	
	public XiaoShouPaiHangDialog(JFrame frame, String title,boolean model) {
		super(frame,title,model);
		init();
	}
	
	
	public void init() {
		
	}
	
	
	/**
	 * 商品销售排行选项卡上的组件的布局
	 */
	
	
	
	/**
	 * 收银员销售排行选项卡上的组件的布局
	 */
	
	
	
	
	
	/**
	 * 商品类别销售排行选项卡上的组件的布局
	 */
	
	
}
