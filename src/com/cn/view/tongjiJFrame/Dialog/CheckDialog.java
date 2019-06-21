package com.cn.view.tongjiJFrame.Dialog;

import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;



public class CheckDialog extends JDialog {
    JLabel gongHuoShang,cangKu,jingBanRen,danJu;//标示输入信息的JLabel
	JButton queDing,tuiChu,chaXun; //确定，退出和查询按钮
	JTextField showT;    //供货商名的输入框
	JComboBox cangKuBox,jingBanRenBox,danJuBox;//3个JComboBox
	String cangKuNames[]={"所有仓库","主仓库","酒库","饮料库"};
	String jingBanRenNames[]={"所有经办人","小张","小熊","小周","小朱"};
	String danJuNames[]={"所有单据","进货单","退货单"};
	/**
	 * 该方法向用户提供添加单据数据的窗口，其中有4个JLabel和3个JComboBox,
	 * 和1个JTextField以及3个按钮，分别为取消和确定,查询。
	 * @param frame
	 * @param title
	 * @param modal
	 */
      public CheckDialog(JDialog frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  //this.mf=mf;
    	  init();
      }
      private void init(){
    	  this.setSize(300, 300);
    	  this.setLocationRelativeTo(null);  //主界面的设置
    	  /*
    	   * 各个组件的实例化与添加
    	   */
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new GridBagLayout());
    	  gongHuoShang=new JLabel("供货商:");
    	  cangKu=new JLabel("仓库");
    	  jingBanRen=new JLabel("经办人");
    	  danJu=new JLabel("单据");
    	  showT=new JTextField(8);
    	  cangKuBox=new JComboBox(cangKuNames);
    	  jingBanRenBox=new JComboBox(jingBanRenNames);
    	  danJuBox=new JComboBox(danJuNames);
    	  queDing=new JButton("确定");
    	  tuiChu=new JButton("退出");
    	  chaXun=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
    	  chaXun.setMargin(new Insets(0,0,0,0));
    	  jp.add(gongHuoShang,new GBC(0,0).setInsets(5, 5, 5, 5));
    	  jp.add(showT,new GBC(1,0).setInsets(5, 5, 5, 5));
    	  jp.add(chaXun,new GBC(2,0).setInsets(5, 5, 5, 5));
    	  jp.add(cangKu,new GBC(0,1).setInsets(5, 5, 5, 5));
    	  jp.add(cangKuBox,new GBC(1,1).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRen,new GBC(0,2).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRenBox,new GBC(1,2).setInsets(5, 5, 5, 5));
    	  jp.add(danJu,new GBC(0,3).setInsets(5, 5, 5, 5));
    	  jp.add(danJuBox,new GBC(1,3).setInsets(5, 5, 5, 5));
    	  jp.add(queDing,new GBC(0,4).setInsets(5, 5, 5, 5));
    	  jp.add(tuiChu,new GBC(2,4).setInsets(5, 5, 5, 5));
    	 
    	  this.add(jp);
    	  this.setVisible(true);
      }
}
