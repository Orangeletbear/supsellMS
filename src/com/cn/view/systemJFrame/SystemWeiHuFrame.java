package com.cn.view.systemJFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.XiTongWeiHu.BeiFenDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.MiMaDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.NianZhongJieSuanDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.RiZhiDialog;
/**
 * 系统设置里面的系统维护
 * @author Administrator
 *
 */
public class SystemWeiHuFrame extends JDialog implements ActionListener {
	MainFrame frame;
	//系统备份/恢复数据按钮
	private JButton beiFenBtn;
	//系统初始化
	private JButton systemInitBtn;
	//修改密码
	private JButton changeSecretBtn;
	//年终结算
	private JButton yearConclusionBtn;
	//查看日志
	private JButton lookLogBtn;
	//版权法码打印
	private JButton tiaoMaPrintBtn;
	//报表设计
	private JButton baiBiaoSheJiBtn;
	//初期建账
	private JButton chuQiJiangZBtn;
	//退出
	private JButton exitBtn;
	
	public SystemWeiHuFrame(MainFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.frame=frame;
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(400,380));
        this.add(createPane());
        changeSecretBtn.addActionListener(this);
        lookLogBtn.addActionListener(this);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	/*
	 * 选项卡的加入
	 */
	private JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(3,3,40,40));
		//系统备份/恢复数据按钮
		beiFenBtn  = new JButton(new ImageIcon("res/AcionIcon/shujubeifenyuhuifu.jpg"));
		beiFenBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new BeiFenDialog(SystemWeiHuFrame.this,"系统备份与恢复",true);
			}
			
		});
		beiFenBtn.setMargin(new Insets(0,0,0,0));
		//系统初始化
		systemInitBtn = new JButton(new ImageIcon("res/AcionIcon/xitongchushihua.jpg"));
		systemInitBtn.setMargin(new Insets(0,0,0,0));
		//修改密码
		changeSecretBtn = new JButton(new ImageIcon("res/AcionIcon/xiugaimima.jpg"));
		changeSecretBtn.setMargin(new Insets(0,0,0,0));
		//年终结算
		yearConclusionBtn = new JButton(new ImageIcon("res/AcionIcon/nianzhongjiesuan.jpg"));
		yearConclusionBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new NianZhongJieSuanDialog(SystemWeiHuFrame.this,"年终结算");
			}
			
		});
		
		yearConclusionBtn.setMargin(new Insets(0,0,0,0));
		//查看日志
		lookLogBtn = new JButton(new ImageIcon("res/AcionIcon/chakanrizhi.jpg"));
		lookLogBtn.setMargin(new Insets(0,0,0,0));
		//打印条码
		tiaoMaPrintBtn = new JButton(new ImageIcon("res/AcionIcon/tiaomadaying.jpg"));
		tiaoMaPrintBtn.setMargin(new Insets(0,0,0,0));
		//报表设计
		baiBiaoSheJiBtn = new JButton(new ImageIcon("res/AcionIcon/baobiaosheji.jpg"));
		baiBiaoSheJiBtn.setMargin(new Insets(0,0,0,0));
		//初期建账
		chuQiJiangZBtn = new JButton(new ImageIcon("res/AcionIcon/chuqijiangzhang.jpg"));
		chuQiJiangZBtn.setMargin(new Insets(0,0,0,0));
		//退出
		exitBtn = new JButton(new ImageIcon("res/AcionIcon/tuichu.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				SystemWeiHuFrame.this.dispose();
			}
			
		});
		
		mainPane.add(beiFenBtn);
		mainPane.add(systemInitBtn);
		mainPane.add(changeSecretBtn);
		mainPane.add(yearConclusionBtn);
		mainPane.add(lookLogBtn);
		mainPane.add(tiaoMaPrintBtn);
		mainPane.add(baiBiaoSheJiBtn);
		mainPane.add(chuQiJiangZBtn);
		mainPane.add(exitBtn);
		
		pane.add(mainPane);
		return pane;
	}
	

	public MainFrame getFrame() {
		return frame;
	}

	public void actionPerformed(ActionEvent e) {
         if(e.getSource()==changeSecretBtn){
        	 new MiMaDialog(this,"修改密码",true);
         }		
         if(e.getSource()==lookLogBtn){
        	 new RiZhiDialog(this,"查看日志",true);
         }
	}

}
