package com.cn.view.tongjiJFrame.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.model.AllTableModel;

public class XiuGaiDialog extends JDialog implements ActionListener{
	JinHuoDialog dialog;
	JButton queDing,tuiChu;
	JTextField shuLiang;
	JLabel bianHao,mingCheng,xingHao,danWei,yanSe,kuCun,changShang,beiZhu;//������Ķ���
	Vector mainV;
   public XiuGaiDialog(JinHuoDialog dialog,String tilte,boolean b){
	   super(dialog,tilte,b);
	   this.dialog=dialog;
	   init();
   }
   private void init(){
	   this.setSize(400,300);
	   this.setLocationRelativeTo(null);//�����ڵ�����
	   JPanel jp=new JPanel();
	   jp.setLayout(new BorderLayout());
	   JPanel southP=new JPanel();
	   southP.setLayout(new GridBagLayout());
	   southP.add(new JLabel("�ο���������:"),new GBC(0,0).setInsets(4, 4, 4, 4));
	   shuLiang=new JTextField("0");
	   shuLiang.setPreferredSize(new Dimension(80,20));
	   southP.add(shuLiang,new GBC(1,0).setInsets(4, 4, 4, 4));
	   JLabel show=new JLabel("(����ֻ��Ϊһ���������˻��Ĳο������޸�ʵ�ʿ�档)");
	   show.setForeground(Color.red);
	   southP.add(show,new GBC(0,1,3,1).setInsets(4, 4, 4, 4));
	   queDing=new JButton("ȷ��");
	   tuiChu=new JButton("�˳�");
	   southP.add(queDing,new GBC(0,2).setInsets(4, 4, 4, 4));
	   southP.add(tuiChu,new GBC(2,2).setInsets(4, 4, 4, 4)); //���ڱ��ߵ���������
	   
	   JPanel xinXiP=new JPanel();
	   xinXiP.setBorder(new TitledBorder("��Ʒ��Ϣ"));
	   xinXiP.setLayout(new GridBagLayout());
	   bianHao=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,0).toString());
	   bianHao.setForeground(Color.blue);
	   mingCheng=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,1).toString());
	   mingCheng.setForeground(Color.red);
	   xingHao=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,3).toString());
	   xingHao.setForeground(Color.blue);
	   danWei=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,2).toString());
	   danWei.setForeground(Color.blue);
	   yanSe=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,4).toString());
	   yanSe.setForeground(Color.blue);
	   kuCun=new JLabel(dialog.getDtm().getValueAt(dialog.getMainTable().getSelectedRow() ,7).toString());
	   kuCun.setForeground(Color.red);
	   changShang=new JLabel();
	   beiZhu=new JLabel();
	   xinXiP.add(new JLabel("��Ʒ���:"),new GBC(0,0).setInsets(10, 2, 10, 2));
	   xinXiP.add(bianHao,new GBC(1,0));
	   xinXiP.add(new JLabel("��Ʒ����:"),new GBC(3,0).setInsets(10, 2, 10, 2));
	   xinXiP.add(mingCheng,new GBC(4,0));
	   
	   xinXiP.add(new JLabel("����ͺ�:"),new GBC(0,1).setInsets(10, 2, 10, 2));
	   xinXiP.add(xingHao,new GBC(1,1));
	   xinXiP.add(new JLabel("��    λ      :"),new GBC(3,1).setInsets(10, 2, 10, 2));
	   xinXiP.add(danWei,new GBC(4,1));
	   
	   xinXiP.add(new JLabel("��ǰ���:"),new GBC(0,2).setInsets(10, 2, 10, 2));
	   xinXiP.add(kuCun,new GBC(1,2));
	   xinXiP.add(new JLabel("��      ɫ    :"),new GBC(3,2).setInsets(10, 2, 10, 2));
	   xinXiP.add(yanSe,new GBC(4,2));
	   
	   xinXiP.add(new JLabel("��������:"),new GBC(0,3).setInsets(10, 2, 10, 2));
	   xinXiP.add(changShang,new GBC(1,3));
	   xinXiP.add(new JLabel("��      ע     :"),new GBC(3,3).setInsets(10, 2, 10, 2));
	   xinXiP.add(beiZhu,new GBC(4,3));
	   
	   jp.add(southP,BorderLayout.SOUTH);
	   jp.add(xinXiP);
	   queDing.addActionListener(this);
	   tuiChu.addActionListener(this);
	   this.add(jp);
	   this.setVisible(true);
   }
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==tuiChu){
		this.dispose();
	}
	if(e.getSource()==queDing){
	    Vector mainV=dialog.getDtm().getDataVector();
	    ((Vector) mainV.get(dialog.getMainTable().getSelectedRow())).setElementAt(shuLiang.getText(), 6);
	    dialog.getDtm().setDataVector(mainV, AllTableModel.getVectorFromObj(dialog.getTableNames()));
	    this.dispose();
	}
}
}
