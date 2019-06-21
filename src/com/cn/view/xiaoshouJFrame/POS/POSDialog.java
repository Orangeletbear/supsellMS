package com.cn.view.xiaoshouJFrame.POS;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.cn.util.GBC;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.xiaoshouJFrame.POS.SellLedgerDialog;

public class POSDialog extends JDialog {

	
	private MainFrame frame;
	public POSDialog() {
		
	}
	public POSDialog(MainFrame frame,String title,boolean model) {
	//	this.frame =frame;
		super(frame,title,model);
		this.frame = frame;
		this.setSize(420,350);
		
		init();
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	public void init() {
		JPanel pane = new JPanel();
		
		GridBagLayout layout = new GridBagLayout();
		
		pane.setLayout(layout);
		
		
		
		JButton liuShuiZhang = createButton("res/posBtn/posxiaoliushuizhan.png");
		layout.setConstraints(liuShuiZhang, new GBC(0, 0,1,1).setInsets(0,10,20,10));
		liuShuiZhang.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
			
				new SellLedgerDialog(frame,"POS销售流水账",true);
			}
		});
		
		JButton riJieGuanLi = createButton("res/posBtn/posrijieguangli.png");
		layout.setConstraints(riJieGuanLi, new GBC(0, 1,1,1).setInsets(0,10,20,10));
		riJieGuanLi.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new RiJieGuanLiDialog(frame,"日结管理",true);
			}
		});
		
		JButton xiaoShouPaiHang = createButton("res/posBtn/posxiaoshouPaiHang.png");
		layout.setConstraints(xiaoShouPaiHang, new GBC(0, 2,1,1).setInsets(0,10,20,10));
		xiaoShouPaiHang.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new SalesRankingDialog(frame,"POS销售排行",true);
			}
		});
		
		JButton huiYuanTongJi = createButton("res/posBtn/huiyuanxiaoshoutongji.png");
		layout.setConstraints(huiYuanTongJi, new GBC(0, 3,1,1).setInsets(0,10,20,10));
		huiYuanTongJi.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new VIPConsumeDialog(frame,"会员消费查询",true);
			}
		});

		JButton shouYinTongJi = createButton("res/posBtn/shouyingyuanshouyantongji.png");
		layout.setConstraints(shouYinTongJi, new GBC(1, 0,1,1).setInsets(0,10,20,10));
		shouYinTongJi.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new ShouYinTongJiDialog(frame,"收银员收银统计",true);
			}
		});
		
		JButton chuRuKuan = createButton("res/posBtn/shouyingyuanchulykuanguanli.png");
		layout.setConstraints(chuRuKuan, new GBC(1, 1,1,1).setInsets(0,10,20,10));
		chuRuKuan.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new StockControlDialog(frame,"POS出入款管理",true);
			}
		});
		
		JButton xiaoShouTongJi = createButton("res/posBtn/posshangpingxiaoshoutongji.png");
		layout.setConstraints(xiaoShouTongJi, new GBC(1, 2,1,1).setInsets(0,10,20,10));
		xiaoShouTongJi.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
				new OfftakeCountDialog(frame,"POS商品销售统计",true);
			}
		});
		JButton tuiChu = createButton("res/posBtn/posExit.png");
		layout.setConstraints(tuiChu, new GBC(1, 3,1,1).setInsets(0,10,20,10));
		tuiChu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		pane.add(liuShuiZhang);
		pane.add(riJieGuanLi);
		pane.add(xiaoShouPaiHang);
		pane.add(huiYuanTongJi);
		pane.add(shouYinTongJi);
		pane.add(chuRuKuan);
		pane.add(xiaoShouTongJi);
		pane.add(tuiChu);
		
		
		
		this.add(pane);
		
	}
	
	public JButton createButton(String title){
		JButton bt =  new JButton(new ImageIcon(title));
		bt.setMargin(new Insets(0,0,0,0));
		return bt;
	}
	
	public static void main(String[] args) {
		new POSDialog(null,"POS销售统计",true);
	}
}
