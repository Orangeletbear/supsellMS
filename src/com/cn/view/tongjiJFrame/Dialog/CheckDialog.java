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
    JLabel gongHuoShang,cangKu,jingBanRen,danJu;//��ʾ������Ϣ��JLabel
	JButton queDing,tuiChu,chaXun; //ȷ�����˳��Ͳ�ѯ��ť
	JTextField showT;    //���������������
	JComboBox cangKuBox,jingBanRenBox,danJuBox;//3��JComboBox
	String cangKuNames[]={"���вֿ�","���ֿ�","�ƿ�","���Ͽ�"};
	String jingBanRenNames[]={"���о�����","С��","С��","С��","С��"};
	String danJuNames[]={"���е���","������","�˻���"};
	/**
	 * �÷������û��ṩ��ӵ������ݵĴ��ڣ�������4��JLabel��3��JComboBox,
	 * ��1��JTextField�Լ�3����ť���ֱ�Ϊȡ����ȷ��,��ѯ��
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
    	  this.setLocationRelativeTo(null);  //�����������
    	  /*
    	   * ���������ʵ���������
    	   */
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new GridBagLayout());
    	  gongHuoShang=new JLabel("������:");
    	  cangKu=new JLabel("�ֿ�");
    	  jingBanRen=new JLabel("������");
    	  danJu=new JLabel("����");
    	  showT=new JTextField(8);
    	  cangKuBox=new JComboBox(cangKuNames);
    	  jingBanRenBox=new JComboBox(jingBanRenNames);
    	  danJuBox=new JComboBox(danJuNames);
    	  queDing=new JButton("ȷ��");
    	  tuiChu=new JButton("�˳�");
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
