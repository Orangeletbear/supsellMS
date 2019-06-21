package com.cn.view.kuchunJFrame.chaifenkunbang;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ChaifenKunbang extends JDialog {
	
	public ChaifenKunbang(JDialog dialog,String title,boolean b){
		super(dialog,title,b);
		init();
	}
	
	private void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(addCom());
		this.setVisible(true);
	}
	
	private JTabbedPane addCom(){
		JTabbedPane tabjpanel = new JTabbedPane();
		
		ChaifenShangpin jpanelCFSP = new ChaifenShangpin();
		KunbangShangpin jpanelKBSP = new KunbangShangpin();
		BaozhuangShezhi jpanelBZSZ = new BaozhuangShezhi();
		CFKBCheck jpanelCFKB = new CFKBCheck();
		
		{
			tabjpanel.add("拆分商品", jpanelCFSP);
			tabjpanel.add("捆绑商品", jpanelKBSP);
			tabjpanel.add("包装设置", jpanelBZSZ);
			tabjpanel.add("拆分/捆绑查询", jpanelCFKB);
		}
		
		return tabjpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChaifenKunbang(null,"拆分/捆绑",true);
	}

}
